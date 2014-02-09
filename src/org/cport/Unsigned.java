 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

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
