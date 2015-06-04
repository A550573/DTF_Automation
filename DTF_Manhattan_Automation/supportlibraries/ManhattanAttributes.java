package supportlibraries;

public enum ManhattanAttributes {
	
		Com("com");
	
		
		private String value;
		
		ManhattanAttributes(String value)
		{
			this.value = value;
		}
		
		public String getValue()
		{
			return value;
		}
		
}
