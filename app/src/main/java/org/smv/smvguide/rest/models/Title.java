package org.smv.smvguide.rest.models;

/**
 * Created by root on 12/5/16.
 */


public class Title
{
    private String rendered;

    public String getRendered ()
    {
        return rendered;
    }

    public void setRendered (String rendered)
    {
        this.rendered = rendered;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rendered = "+rendered+"]";
    }
}
