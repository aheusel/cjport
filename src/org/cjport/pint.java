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
public final class pint extends pintBase<pint>
{
    
    public static final pint NULL = new pint(0, null);    
    
    private pint(int offset, int[] array)
    {
        super(offset, array);
    }
    
    public static pint alloc(int size)
    {
        return new pint(0, new int[size]);
    }
    
    public static pint wrap(int offset, int[] array)
    {
        return new pint(offset, array);
    }
    
    public static pint wrap(int[] array)
    {
        return pint.wrap(0, array);
    }
    
    public static pint wrap(int v)
    {
        return pint.wrap(0, new int[]{v});
    }
    
    @Override
    final public pint derefAddr(int idx)
    {
        return new pint(offset + idx, array);
    }

    @Override
    final public pint realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pint.wrap(reallocArray(nbytes));
    }
    
}
