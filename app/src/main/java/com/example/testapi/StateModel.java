package com.example.testapi;

public class StateModel
{
    private String flages,states,active,death,recovered,cases;

    public StateModel( String states, String active, String death, String recovered, String cases)
    {
        this.states = states;
        this.active = active;
        this.death = death;
        this.recovered = recovered;
        this.cases = cases;
    }

    public String getStates()
    {
        return states;
    }

    public void setStates(String states)
    {
        this.states = states;
    }

    public String getActive()
    {
        return active;
    }

    public void setActive(String active)
    {
        this.active = active;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }
}
