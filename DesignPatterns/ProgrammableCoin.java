package Inheritance;

public class ProgrammableCoin extends CryptoCurrency
{
    //private String script = "";
    private Programmable program;

    public ProgrammableCoin(String name, Programmable program)
    {
        super(name);
        this.program = program;
    }

    public ProgrammableCoin(String name, String symbol, String description, int circulatingSupply, int marketCap)
    {
        super(name, symbol, description, circulatingSupply, marketCap);
    }

//    public void setScript(String scriptArg)
//    {
//        script += scriptArg;
//    }
//
//    public String getScript()
//    {
//        return script;
//    }

    @Override
    public String toString()
    {
        String results = "";
        results += super.toString();
        // M3 USING STRATEGY
        results += "Script:\n"+program.getScript()+"\n\n";
        results += CryptoCurrency.getDividingLine();
        return results;
    }


    @Override
    public boolean equals(Object object)
    {
        if(object instanceof ProgrammableCoin)
        {
            return super.equals(object);
        }
        return false;
    }
}
