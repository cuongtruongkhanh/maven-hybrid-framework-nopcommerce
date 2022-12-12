package com.nopcommerce.data;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("login")
	private Login login;

	public static class Login {
		@JsonProperty("username")
		private String username;

		@JsonProperty("password")
		private String password;
	}

	public String getLoginUsername() {
		return login.username;
	}

	public String getLoginPassword() {
		return login.password;
	}

	@JsonProperty("subjects")
	private List<Subjects> subjects;

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public static class Subjects {
		@JsonProperty("name")
		private String name;

		@JsonProperty("point")
		private Float point;

		public String getName() {
			return name;
		}

		public Float getPoint() {
			return point;
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAdress;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAdress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("date")
	private String date;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	@JsonProperty("companyName")
	private String companyName;
}
