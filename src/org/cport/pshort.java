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
public final class pshort extends pshortBase<pshort>
{
    public static final pshort NULL = new pshort(0, null);    
    
    private pshort(int offset, short[] array)
    {
        super(offset, array);
    }
        
    public static pshort alloc(int size)
    {
        return new pshort(0, new short[size]);
    }
    
    public static pshort wrap(int offset, short[] array)
    {
        return new pshort(offset, array);
    }
    
    public static pshort wrap(short[] array)
    {
        return pshort.wrap(0, array);
    }

    public static pshort wrap(short v)
    {
        return pshort.wrap(0, new short[]{v});
    }
    
    @Override
    final public pshort derefAddr(int idx)
    {
        return new pshort(offset + idx, array);
    }

    @Override
    final public pshort realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pshort.wrap(reallocArray(nbytes));
    }

    
}
