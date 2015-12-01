/* @Author: John McCain
 * @Date: 11-30-15
 * @Version 0.1 
 * @Description:  Manages the files created by the Stream Ripper, deleting after 2 weeks.
 * 				  Note: lines that need to be modified are marked
 */

import java.io.File;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class StreamRipManager 
{
	public static void main(String[] args) throws InterruptedException
	{
		while(true)
		{
			try
			{
				/********* PUT TARGET DIRECTORY HERE *********/
				//Note: format like so: "C:/SomeDirectory/Stream Rip/"
				//This directory must already exist and be the same as specified in StreamRipper.java
				File folder = new File("YOUR_DIRECTORY_HERE");
				File[] listOfFiles = folder.listFiles();
				
				for(int i=0; i<listOfFiles.length; i++)
				{
					String filename = listOfFiles[i].getName();
					if(filename.substring(0, 4).equals("STRM"))
					{
						if(TooOld(filename))
						{
							listOfFiles[i].delete();
						}
					}	
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			Thread.sleep(900000);
		}
	}
	
	public static boolean TooOld(String filename)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HHmm");
		
		try 
		{
			Date fileDate = dateFormat.parse(filename.substring(5));
			final long DAY_IN_MS = 1000 * 60 * 60 * 24;
			Date compareDate = new Date(System.currentTimeMillis() - (14 * DAY_IN_MS));
			
			return(fileDate.compareTo(compareDate)<0);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
