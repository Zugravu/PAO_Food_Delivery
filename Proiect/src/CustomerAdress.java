
public class CustomerAdress
{
    private String road_name;
    private String bl_nr;
    private String ap_nr;

    public CustomerAdress()
    {
        this.road_name = "";
        this.bl_nr = "";
        this.ap_nr = "";
    }
    public CustomerAdress(String road_name, String bl_nr, String ap_nr)
    {
        this.road_name = road_name;
        this.bl_nr = bl_nr;
        this.ap_nr = ap_nr;
    }

    public String getRoad_name()
    {
        return road_name;
    }

    public void setRoad_name(String road_name)
    {
        this.road_name = road_name;
    }

    public String getBl_nr()
    {
        return bl_nr;
    }

    public void setBl_nr(String bl_nr)
    {
        this.bl_nr = bl_nr;
    }

    public String getAp_nr()
    {
        return ap_nr;
    }

    public void setAp_nr(String ap_nr)
    {
        this.ap_nr = ap_nr;
    }
}
