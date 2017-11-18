package io.importing;

import model.CarPart;

import java.util.Collection;

//Imports all CarPart objects from a text file to the application. Returns false if the file does not exist or is empty, otherwise true.
public interface IImporter
{
    public boolean importParts();
}
