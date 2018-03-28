package bean;

public class PhotoBean {
	 
	    private String name;
	    private byte[] imageData;
	
	    public PhotoBean() {
	 
	    }
	
	    public PhotoBean(String name, byte[] imageData) {
	    	this.name = name;
	        this.imageData = imageData;
	     }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public byte[] getImageData() {
	        return imageData;
	    }
	 
	    public void setImageData(byte[] imageData) {
	        this.imageData = imageData;
	    }
	 
	}

