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

/**
 *
 * @author Alexander Heusel
 */
public final class plong extends plongBase<plong>
{
    public static final plong NULL = new plong(0, null);    
    
    private plong(int offset, long[] array)
    {
        super(offset, array);
    }
    
    public static plong alloc(int size)
    {
        return new plong(0, new long[size]);
    }
    
    public static plong wrap(int offset, long[] array)
    {
        return new plong(offset, array);
    }
    
    public static plong wrap(long[] array)
    {
        return plong.wrap(0, array);
    }
    
    public static plong wrap(long v)
    {
        return plong.wrap(0, new long[]{v});
    }
    
    @Override
    final public plong derefAddr(int idx)
    {
        return new plong(offset + idx, array);
    }

    @Override
    final public plong realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return plong.wrap(reallocArray(nbytes));
    }
    
    
}
