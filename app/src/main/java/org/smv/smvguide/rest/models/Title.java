package org.smv.smvguide.rest.models;

/**
 * Created by root on 12/5/16.
 */

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class Title
{
    public String rendered;

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

    @ParcelConstructor
    public Title(String rendered) {
        this.rendered = rendered;
    }
}
