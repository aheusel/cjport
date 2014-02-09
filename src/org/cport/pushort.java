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
public final class pushort extends pshortBase<pushort>
{
    public static final pushort NULL = new pushort(0, null);    
    
    private pushort(int offset, short[] array)
    {
        super(offset, array);
    }
    
    public static pushort alloc(int size)
    {
        return new pushort(0, new short[size]);
    }
    
    public static pushort wrap(int offset, short[] array)
    {
        return new pushort(offset, array);
    }
    
    public static pushort wrap(short[] array)
    {
        return pushort.wrap(0, array);
    }
    
    public static pushort wrap(short v)
    {
        return pushort.wrap(0, new short[]{v});
    }
    
    final public int derefPromote()
    {
        return uint16.promote(array[offset]);
    }
    
    final public int derefPromote(int i)
    {
        return uint16.promote(array[offset + i]);
    }

    @Override
    final public pushort derefAddr(int idx)
    {
        return new pushort(offset + idx, array);
    }

    @Override
    final public pushort realloc(int nbytes)
    {
        if(offset != 0)
        {
            throw new java.lang.IllegalStateException("Pointer has to point to mem-start.");
        }
        return pushort.wrap(reallocArray(nbytes));
    }
    
    
}
