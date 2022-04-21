package Classes;

public class CustomerAdress
{
    private String road_name;
    private String blNr;
    private String apNr;

    public CustomerAdress()
    {
        this.road_name = "";
        this.blNr = "";
        this.apNr = "";
    }
    public CustomerAdress(String road_name, String bl_nr, String ap_nr)
    {
        this.road_name = road_name;
        this.blNr = bl_nr;
        this.apNr = ap_nr;
    }

    public String getRoad_name()
    {
        return road_name;
    }

    public void setRoad_name(String road_name)
    {
        this.road_name = road_name;
    }

    public String getBlNr()
    {
        return blNr;
    }

    public void setBlNr(String blNr)
    {
        this.blNr = blNr;
    }

    public String getApNr()
    {
        return apNr;
    }

    public void setApNr(String apNr)
    {
        this.apNr = apNr;
    }
}
