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
public class Util
{
    public static final int double_t = Double.SIZE / Byte.SIZE;
    public static final int float_t = Float.SIZE / Byte.SIZE;
    public static final int byte_t = Byte.SIZE / Byte.SIZE;
    public static final int short_t = Short.SIZE / Byte.SIZE;
    public static final int int_t = Integer.SIZE / Byte.SIZE;
    public static final int long_t = Long.SIZE / Byte.SIZE;
    public static final int ubyte_t = Byte.SIZE / Byte.SIZE;
    public static final int ushort_t = Short.SIZE / Byte.SIZE;
    public static final int uint_t = Integer.SIZE / Byte.SIZE;
    public static final int ulong_t = Long.SIZE / Byte.SIZE;
    
    
    public static boolean toBool(Object v)
    {
        return v == null;
    }
    
    public static boolean toBool(int v)
    {
        return v == 0 ? false : true;
    }
    
    public static int fromBool(boolean v)
    {
        return v ? 1 : 0;
    }
    
    public static int sizeof(int v)
    {
        return v;
    }
    

    public static byte[] realloc(byte[] array, int newSize)
    {
        byte[] newArray = new byte[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(newSize, array.length));
        return newArray;
    }
    
    public static short[] realloc(short[] array, int newSize)
    {
        short[] newArray = new short[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(newSize, array.length));
        return newArray;
    }
    
    public static int[] realloc(int[] array, int newSize)
    {
        int[] newArray = new int[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(newSize, array.length));
        return newArray;
    }
    
    public static long[] realloc(long[] array, int newSize)
    {
        long[] newArray = new long[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(newSize, array.length));
        return newArray;
    }
    
    public static float[] realloc(float[] array, int newSize)
    {
        float[] newArray = new float[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(newSize, array.length));
        return newArray;
    }
    
    public static double[] realloc(double[] array, int newSize)
    {
        double[] newArray = new double[newSize];
        System.arraycopy(array, 0, newArray, 0, Math.min(newSize, array.length));
        return newArray;
    }
    
  
}
