package TestData;
import AllPages.*;
public class HomeObject {
	String homeTitle;
	String managetitle;
	Integer homeNumber;
	String manageUrl;

	public String getHomeTitle() {
		return homeTitle;
	}

	public String getManageTitle() {
		return managetitle;
	}
	public String getManageUrl() {
		return manageUrl;
	}

	public void setHomeTitle(String homeTitle) {
		this.homeTitle = homeTitle;
	}

	public void setManageTitle(String managetitle) {
		this.managetitle = managetitle;
	}
	public void setManageUrl(String manageUrl) {
		this.manageUrl = manageUrl;
	}

	public Integer getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(Integer homeNumber) {
		this.homeNumber = homeNumber;
	}

	@Override
	public String toString() {
		return "HomeObject [homeTitle=" + homeTitle + ", homeNumber="
				+ homeNumber + ", managetitle=" + managetitle + ", manageUrl=" + manageUrl + "]";

	}

}

