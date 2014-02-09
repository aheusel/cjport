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
