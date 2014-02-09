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

import java.math.BigInteger;
import java.nio.ByteBuffer;

/**
 *
 * @author Alexander Heusel
 */
public class Unsigned
{   
    
    public static short ubyte(byte v)
    {
        return (short)((int)v & 0xff); 
    }
    
    public static int ushort(short v)
    {
        return v & 0xffff;
    }
    
    public static long uint(int v)
    {
        return 0x00000000ffffffffl & (long)v;
    }
    
    public static BigInteger ulong(long v)
    {
        final byte[] big = new byte[9];
        ByteBuffer.wrap(big).putLong(v);
        return new BigInteger(big);         
    }
    
   
}
