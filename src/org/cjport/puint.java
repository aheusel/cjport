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
public final class puint extends pintBase<puint>
{
    public static final puint NULL = new puint(0, null);

    private puint(int offset, int[] array)
    {
        super(offset, array);
    }
    
    public static puint alloc(int size)
    {
        return new puint(0, new int[size]);
    }
    
    public static puint wrap(int offset, int[] array)
    {
        return new puint(offset, array);
    }
    
    public static puint wrap(int[] array)
    {
        return puint.wrap(0, array);
    }
    
    public static puint wrap(int v)
    {
        return puint.wrap(0, new int[]{v});
    }
    
    final public long derefPromote()
    {
        return uint32.promote(array[offset]);
    }
    
    final public long derefPromote(int i)
    {
        return uint32.promote(array[offset + i]);
    }

    @Override
    final public puint derefAddr(int idx)
    {
        return new puint(offset + idx, array);
    }

    @Override
    final public puint realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return puint.wrap(reallocArray(nbytes));
    }
    
    
}
