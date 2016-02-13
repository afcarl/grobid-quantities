package org.grobid.core.data;

import org.grobid.core.utilities.OffsetPosition;
import org.grobid.core.utilities.UnitUtilities;

import java.util.List;
import java.util.ArrayList;

/**
 * Class for managing normalized Unit representation.
 *
 * @author Patrice Lopez
 */
public class Unit {

    private List<String> names = null; // usual full names for the unit, e.g. metre, meter

    private List<String> notations = null;
    // standard notation, e.g. g for gram - there might be several notations for an unit

    private UnitUtilities.Unit_Type type; // type of measurement

    // boolean indicating  if the unit is a standard SI unit
    private UnitUtilities.System_Type system;

    // to be used only when building a unit during parsing
    private String rawName = null;
    private OffsetPosition offsets = null;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> name) {
        this.names = names;
    }

    public void addName(String name) {
        if (names == null)
            names = new ArrayList<String>();
        names.add(name);
    }

    public List<String> getNotations() {
        return notations;
    }

    public void setNotations(List<String> not) {
        this.notations = not;
    }

    public void addNotation(String not) {
        if (notations == null)
            notations = new ArrayList<String>();
        notations.add(not);
    }

    public String getRawName() {
        return rawName;
    }

    public void setRawName(String name) {
        rawName = name;
    }

    public UnitUtilities.System_Type getSystem() {
        return system;
    }

    public void setSystem(UnitUtilities.System_Type si) {
        system = si;
    }

    public UnitUtilities.Unit_Type getType() {
        return type;
    }

    public void setType(UnitUtilities.Unit_Type ty) {
        type = ty;
    }

    public void setOffsetStart(int start) {
    	if (offsets == null)
            offsets = new OffsetPosition();
        offsets.start = start;
    }

    public int getOffsetStart() {
    	if (offsets != null)
	        return offsets.start;
	    else return -1;
    }

    public void setOffsetEnd(int end) {
    	if (offsets == null)
            offsets = new OffsetPosition();
        offsets.end = end;
    }

    public int getOffsetEnd() {
    	if (offsets != null)
	        return offsets.end;
	    else return -1;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        if (notations != null)
            builder.append(notations.toString()).append("\t");
        if (type != null)
            builder.append(type.getName()).append("\t");
        if (system != null)
            builder.append(system.getName()).append("\t");
        if (names != null)
            builder.append(names.toString()).append("\t");
        if (rawName != null)
            builder.append(rawName.toString()).append("\t");
        if (offsets != null)
            builder.append(offsets.toString());
        builder.append(" ]");
        return builder.toString();
    }

}