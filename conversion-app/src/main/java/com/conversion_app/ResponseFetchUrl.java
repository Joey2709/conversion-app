package com.conversion_app;

import com.google.gson.annotations.SerializedName;

public class ResponseFetchUrl {
	@SerializedName("result")
	private String result;
	@SerializedName("documentation")
    private String documentation;
	@SerializedName("terms_of_use")
    private String terms_of_use;
	@SerializedName("time_last_update_unix")
    private String time_last_update_unix;
	@SerializedName("time_last_update_utc")
    private String time_last_update_utc;
	@SerializedName("time_next_update_unix")
    private String time_next_update_unix;
	@SerializedName("time_next_update_utc")
    private String time_next_update_utc;
	@SerializedName("base_code")
    private String base_code;
	@SerializedName("target_code")
    private String target_code;
	@SerializedName("conversion_rate")
    private String conversion_rate;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public String getTerms_of_use() {
		return terms_of_use;
	}
	public void setTerms_of_use(String terms_of_use) {
		this.terms_of_use = terms_of_use;
	}
	public String getTime_last_update_unix() {
		return time_last_update_unix;
	}
	public void setTime_last_update_unix(String time_last_update_unix) {
		this.time_last_update_unix = time_last_update_unix;
	}
	public String getTime_last_update_utc() {
		return time_last_update_utc;
	}
	public void setTime_last_update_utc(String time_last_update_utc) {
		this.time_last_update_utc = time_last_update_utc;
	}
	public String getTime_next_update_unix() {
		return time_next_update_unix;
	}
	public void setTime_next_update_unix(String time_next_update_unix) {
		this.time_next_update_unix = time_next_update_unix;
	}
	public String getTime_next_update_utc() {
		return time_next_update_utc;
	}
	public void setTime_next_update_utc(String time_next_update_utc) {
		this.time_next_update_utc = time_next_update_utc;
	}
	public String getBase_code() {
		return base_code;
	}
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}
	public String getTarget_code() {
		return target_code;
	}
	public void setTarget_code(String target_code) {
		this.target_code = target_code;
	}
	public String getConversion_rate() {
		return conversion_rate;
	}
	public void setConversion_rate(String conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

   
}
