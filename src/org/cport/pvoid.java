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
public class pvoid
{
    protected int offset;
    
    protected pvoid(int offset)
    {
        this.offset = offset;
    }
        
    public int offset()
    {
        return offset;
    }
    
    public void incr()
    {
        offset++;
    }
    
    public void incr(int incr)
    {
        offset += incr;
    }
    
    public void decr()
    {
        offset--;
    }
    
    public void decr(int decr)
    {
        offset -= decr;
    }
}
