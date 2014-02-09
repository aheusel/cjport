/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cport;

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
    

  
}
