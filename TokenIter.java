import java.util.Iterator;

public class TokenIter implements Iterator<String> {

    //input line to be tokenized
    private String line;

    // the next Token, null if no next Token
    private String nextToken;

    // counter for stepping through the input
    private int index;
    
    // implement
    public TokenIter(String line) {
    	this.line = line;
    	index = 0;
    }

    
    public boolean stringBuilder()
    {
    	String temp = new String();
    	String TRUE = new String("true");
    	String FALSE = new String("false");
    	
    	int indexT = index + 4;
    	int indexF = index + 5;
    	
    	
    	//new experimental strings
    	String T1 = line.substring(index, indexT);
    	String F1 = line.substring(index, indexF);
    	
    	
    	while(Character.isLetter(line.charAt(index)))
		{
			
    		//Check system for TRUE
    		if(line.charAt(index) == 't')
    		{
    			//System.out.println("DEBUG");
    			
    			while(index < indexT)
    			{
    				//System.out.println("DEBUG");
    				temp = temp + line.charAt(index);
    				index++;
    			}
    			
    			if(temp.equals(TRUE))
    			{
    				//System.out.println("DEBUG FALSE");
    				return true;
    			}
    			else
    			{
    				return true;
    			}
    			
    		}
    		
    		//Check system for FALSE
    		if(line.charAt(index) == 'f')
    		{
    	
    			while(index < indexF)
    			{
    				temp = temp + line.charAt(index);
    				index++;
    			}
    			if(temp.equals(FALSE))
    			{
    				
    				return false;
    			}
    		}
    
    	
		}//end while loop
    return false;
    
    }

    @Override
    // implement
    public boolean hasNext() {
	

        while(index < line.length())	
        {    
        	    char c = line.charAt(index);
        		  
        	if(line.charAt(index) == 't' || line.charAt(index) == 'f')
        		{
        		
        			int curIndex = index;//saves the current index before calling the stringBuilder helper method
        			//nextToken = stringBuilder();
        			
        			/*
        			if(stringBuilder() == true)
        			{
        				nextToken = stringBuilder();
        				return true;
        			}
        			*/
        			//index = curIndex;//restores the value of the index as it was prior to calling the stringBuilder helper method
        			
        			
        			if(stringBuilder() == true)
        			{
        				nextToken = "true";
        				index = curIndex;
        				return true;
        			}
        			
        			if(stringBuilder() == false)
        			{
        				nextToken = "false";
        				index = curIndex;
        				return true;
        			}
        			
        			//nextToken = "" + c;
        			//return true;
        			
        		}	
        	//System.out.println("nextToken = " + nextToken);
        	if(line.charAt(index) == '!' || line.charAt(index) == '&' || line.charAt(index) == '(' || line.charAt(index) == ')' || line.charAt(index) == '^')	
        		{
        			//System.out.println("Symbol detected at index: " + index);
        		    //s = Character.toString(c);
       			    nextToken ="" + c;
       			    //System.out.println("nextToken = " + nextToken);
        			return true;
        		} 

        	else
        		{
        			//System.out.println("WhiteSpace/ invalid detected at index: " + index);
        			index++;
        		}
        }	
    	
	return false;
    }

    @Override
    //implement
    public String next() {
    	
	if(hasNext() == true)
	{
		index++;
		return nextToken;
	}
	else
	{
		index++;
	}
    	
	return "";
    }

    @Override
    // provided, do not change
    public void remove() {
	// TODO Auto-generated method stub
	throw new UnsupportedOperationException();
    }

    // provided
    public static void main(String[] args) {
	String line;
	// you can play with other inputs on the command line
	if(args.length>0)
	    line = args[0];
	// or do the standard test
	else
	    line = " ! BAD (true ^ false) % truelybad";
	System.out.println("line: [" + line + "]");
	TokenIter tokIt = new TokenIter(line);
	while (tokIt.hasNext())
	    System.out.println("next token: [" + tokIt.next() + "]");
    }
}
