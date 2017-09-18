package naverest.reservation.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MyReservation {
	private Integer id;
	private Integer productId;
	private Integer userId;
	private Integer generalTicketCount;
	private Integer youthTicketCount;
	private Integer childTicketCount;
	private String reservationType;
	private String reservationDate;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGeneralTicketCount() {
		return generalTicketCount;
	}

	public void setGeneralTicketCount(Integer generalTicketCount) {
		this.generalTicketCount = generalTicketCount;
	}

	public Integer getYouthTicketCount() {
		return youthTicketCount;
	}

	public void setYouthTicketCount(Integer youthTicketCount) {
		this.youthTicketCount = youthTicketCount;
	}

	public Integer getChildTicketCount() {
		return childTicketCount;
	}

	public void setChildTicketCount(Integer childTicketCount) {
		this.childTicketCount = childTicketCount;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
	  return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
}
