package DesignPatterns;
/*
Design Patterns and the Comparator interface:
 Locations:
    -Factory method:       CryptoCurrencyFactory class
    -Builder pattern:      CryptoCurrencyImplementer class / getAnonymousCoin()
    -Strategy pattern:     CryptoCurrencyFactory class / getProgrammableCoin()
    -Comparator interface: CryptoCurrency class / NAME_COMPARATOR
 */

import java.util.Arrays;

public class CryptoCurrencyImplementer
{
    // M3 USING BUILDER PATTERN
    private static AnonymousCoin getAnonymousCoin()
    {
        AnonymousCoin anonymousCoin = new AnonymousCoin.AnonymousCoinBuilder("HushCoin", 987654321L, 10000000000L)
                .symbol("shh")
                .description("Peer-to-peer anonymous transactions")
                .build();
        return anonymousCoin;
    }

    private static LotteryCoin getLotteryCoin()
    {
        LotteryCoin lotteryCoin = new LotteryCoin("LuckyCoin");
        lotteryCoin.setSymbol("LCK");
        lotteryCoin.setDescription("An international, decentralized, open-source lottery system");
        lotteryCoin.setCirculatingSupply(887777);
        lotteryCoin.setMarketCap(99988888);
        lotteryCoin.setLuckyNumber(1234567);
        return lotteryCoin;
    }
    private static String arrToStr(CryptoCurrency[] cryptoArray)
    {
        String results = "";
        for(int i = 0; i < cryptoArray.length; i++)
        {
            //Used to vertically align the prices
            if(cryptoArray[i].getName().length() >8)
            {
                results += "\t-"+cryptoArray[i].getName()+": "+cryptoArray[i].getPrice()+"\n";
            }
            else
            {
                results += "\t-"+cryptoArray[i].getName()+": \t"+cryptoArray[i].getPrice()+"\n";
            }

        }
        return results;
    }

    private static void beforeAfterSorting(CryptoCurrency[] cryptoArray)
    {
        //M3 COMPARATOR IMPLEMENTED
        System.out.println("Before any sort:");
        System.out.println(arrToStr(cryptoArray));
        System.out.println("Name sort:");
        Arrays.sort(cryptoArray, CryptoCurrency.NAME_COMPARATOR);
        System.out.println(arrToStr(cryptoArray));
    }

    public static void main(String[] args)
    {
        //M3 USING FACTORY METHOD
        CryptoCurrency usersCoin1 = CryptoCurrencyFactory.getInstance();
        CryptoCurrency usersCoin2 = CryptoCurrencyFactory.getInstance();
        AnonymousCoin anonymousCoin = getAnonymousCoin();
        LotteryCoin lotteryCoin = getLotteryCoin();

        CryptoCurrency[] cryptoArray = { usersCoin1, usersCoin2, anonymousCoin, lotteryCoin };

        System.out.println(CryptoCurrency.getDividingLine());
        for(CryptoCurrency coin : cryptoArray)
        {
            System.out.println(coin);
        }
        System.out.println("\nTotal market capitalization: "+CryptoCurrency.getTotalMarketCap()+"\n");
        beforeAfterSorting(cryptoArray);
        System.out.println(CryptoCurrency.getDividingLine());
    }
}
