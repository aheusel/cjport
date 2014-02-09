/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cport;

import java.math.BigInteger;

/**
 *
 * @author Alexander Heusel
 */
public final class pulong extends plongBase<pulong>
{    
    public static final pulong NULL = new pulong(0, null);
    
    private pulong(int offset, long[] array)
    {
        super(offset, array);
    }
    
    public static pulong alloc(int size)
    {
        return new pulong(0, new long[size]);
    }
    
    public static pulong wrap(int offset, long[] array)
    {
        return new pulong(offset, array);
    }
    
    public static pulong wrap(long[] array)
    {
        return pulong.wrap(0, array);
    }

    public static pulong wrap(long v)
    {
        return pulong.wrap(0, new long[]{v});
    }
        
    final public BigInteger derefPromote()
    {
        return uint64.promote(array[offset]);
    }
    
    final public BigInteger derefPromote(int i)
    {
        return uint64.promote(array[offset + i]);
    }

    @Override
    final public pulong derefAddr(int idx)
    {
        return new pulong(offset + idx, array);
    }

    @Override
    final public pulong realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pulong.wrap(reallocArray(nbytes));
    }
    
    
}
