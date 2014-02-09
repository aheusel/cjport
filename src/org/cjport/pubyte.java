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
public final class pubyte extends pbyteBase<pubyte>
{
    public static final pubyte NULL = new pubyte(0, null);    
    
    private pubyte(int offset, byte[] array)
    {
        super(offset, array);
    }
    
    public static pubyte alloc(int size)
    {
        return new pubyte(0, new byte[size]);
    }
    
    public static pubyte wrap(int offset, byte[] array)
    {
        return new pubyte(offset, array);
    }
    
    public static pubyte wrap(byte[] array)
    {
        return pubyte.wrap(0, array);
    }
    
    public static pubyte wrap(byte v)
    {
        return pubyte.wrap(0, new byte[]{v});
    }
    
    final public short derefPromote()
    {
        return uint8.promote(array[offset]);
    }
    
    final public short derefPromote(int i)
    {
        return uint8.promote(array[offset + i]);
    }

    @Override
    final public pubyte derefAddr(int idx)
    {
        return new pubyte(offset + idx, array);
    }
    
    @Override
    final public pubyte realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pubyte.wrap(reallocArray(nbytes));
    }
    
    
}
