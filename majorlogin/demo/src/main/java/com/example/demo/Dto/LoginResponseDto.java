package com.example.demo.Dto;

public class LoginResponseDto {
	
	 private String Message;
	    private Boolean status;
	    
	    
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		

}
