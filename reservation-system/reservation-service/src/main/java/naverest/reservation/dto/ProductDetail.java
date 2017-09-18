package naverest.reservation.dto;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
// 상세페이지에서 사용할 dto 
public class ProductDetail {
	//product
	private Integer id;
	private String name;
	private String description;
	private String event;
	private Integer salesFlag;
	private Date salesEnd;
	//display_info
	private String homepage;
	private String tel;
	private String email;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	//product_detail
	private String content;
	
	private List<FileProductImage> fileList;
	
	public List<FileProductImage> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileProductImage> fileList) {
		this.fileList = fileList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlaceLot() {
		return placeLot;
	}
	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}
	public String getPlaceStreet() {
		return placeStreet;
	}
	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}
	public Date getSalesEnd() {
		return salesEnd;
	}
	public void setSalesEnd(Date salesEnd) {
		this.salesEnd = salesEnd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	public Integer getSalesFlag() {
		return salesFlag;
	}
	public void setSalesFlag(Integer salesFlag) {
		this.salesFlag = salesFlag;
	}
	@Override
	public String toString() {
	  return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
