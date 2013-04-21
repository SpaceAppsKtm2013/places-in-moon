/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom;

/**
 *
 * @author Smrita
 */
public class Test
{
    public static void main(String[] args)
    {
        String image="http://images.moonkam.ucsd.edu/main.php?g2_view=core.DownloadItem&g2_itemId=379618";
        String[] i=image.split("&");
        System.out.println(i[0]);
        System.out.println(i[1]);
        i[0]+="&amp;";
        System.out.println(i[0]);        
    }
    
}
