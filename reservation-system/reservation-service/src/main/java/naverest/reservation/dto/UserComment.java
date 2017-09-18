package naverest.reservation.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserComment {
	private Integer id;
	private Integer userId;
	private String username;
	private String productName;
	private BigDecimal score;
	private String comment;
	private Date createDate;
	private Date modifyDate;
	
	private String reservationDate;
	private List<FileCommentImage> commentImageList;
	public UserComment() {
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public List<FileCommentImage> getCommentImageList() {
		return commentImageList;
	}
	public void setCommentImageList(List<FileCommentImage> commentImage) {
		this.commentImageList = commentImage;
	}
	@Override
	public String toString() {
	  return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
