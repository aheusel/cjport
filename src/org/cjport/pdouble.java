/*
 * CJPort - An utility library to aid the port of C-code to java
 * Copyright (C) 2014  Alexander Heusel
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.cjport;

/**
 *
 * @author Alexander Heusel
 */
public final class pdouble extends pdoubleBase<pdouble>
{
    public static final pdouble NULL = new pdouble(0, null);
    
    private pdouble(int offset, double[] array)
    {
        super(offset, array);
    }
        
    public static pdouble alloc(int size)
    {
        return new pdouble(0, new double[size]);
    }
    
    public static pdouble wrap(int offset, double[] array)
    {
        return new pdouble(offset, array);
    }
    
    public static pdouble wrap(double[] array)
    {
        return pdouble.wrap(0, array);
    }

    public static pdouble wrap(double v)
    {
        return pdouble.wrap(0, new double[]{v});
    }    
    
    @Override
    final public pdouble derefAddr(int idx)
    {
        return new pdouble(offset + idx, array);
    }

    @Override
    final public pdouble realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pdouble.wrap(reallocArray(nbytes));
    }

}
