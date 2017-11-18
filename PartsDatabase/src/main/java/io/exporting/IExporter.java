package io.exporting;

import model.CarPart;

import java.util.Collection;

//Exports all CarPart objects in the application to a text file. Returns false if there are no records to write, otherwise true.
public interface IExporter
{
    public boolean exportParts();
}
