package naverest.reservation.sql;

public class ReservationInfoSqls {
	public final static String ASKING = "1";
	public final static String CONFIRM = "2";
	public final static String COMPLETION = "3";
	public final static String CANCELLATION = "4";
	public final static String REFUND = "5";
	
	public final static String SELECT_BY_USER_ID = "SELECT "
			+ "									   r_i.id,"
			+ "									   r_i.product_id AS productId,"
			+ "									   r_i.user_id AS userId,"
			+ "									   r_i.general_ticket_count AS generalTicketCount,"
			+ "									   r_i.youth_ticket_count AS youthTicketCount,"
			+ "									   r_i.child_ticket_count AS childTicketCount,"
			+ "									   r_i.reservation_type AS reservationType,"
			+ "									   r_i.reservation_date AS reservationDate,"
			+ "									   p.name"
			+ "									   FROM reservation_info r_i"
			+ "									   INNER JOIN product p ON r_i.product_id = p.id"
			+ "									   WHERE r_i.user_id = :userId"
			+ "									   ORDER BY r_i.id desc";
	
	public final static String SELECT_BY_USER_ID_AND_TYPE = "SELECT "
			+ "												r_i.id,"
			+ "												r_i.product_id as productId,"
			+ "												r_i.user_id as userId,"
			+ "												r_i.general_ticket_count as generalTicketCount,"
			+ "												r_i.youth_ticket_count as youthTicketCount,"
			+ "												r_i.child_ticket_count as childTicketCount,"
			+ "												r_i.reservation_type as reservationType,"
			+ "												r_i.reservation_date as reservationDate,"
			+ "												p.name"
			+ "												FROM reservation_info r_i"
			+ "												INNER JOIN product p on r_i.product_id = p.id"
			+ "												WHERE r_i.user_id = :userId and r_i.reservation_type =:type"
			+ "												ORDER BY r_i.id desc";
	
	public final static String UPDATE_TYPE_BY_ID = "UPDATE"
			+ "									   reservation_info"
			+ "									   SET"
			+ "									   reservation_type = :type"
			+ "									   WHERE"
			+ "									   id = :id";
	
	public final static String DELETE_BY_TYPE= "DELETE"
		+ "									   FROM reservation_info"
		+ "									   WHERE user_id = :userId "
		+ "									   AND reservation_type = :type";
	
	public final static String SELECT_COUNT_BY_USER_ID_AND_PRODUCT_ID = "SELECT"
			+ "															COUNT(*)"
			+ "															FROM reservation_info"
			+ "															WHERE product_id = :productId"
			+ "															AND user_id = :userId";
	public final static String SELECT_BY_ID = "SELECT"
			+ "								  product_id,"
			+ "								  user_id"
			+ "								  FROM reservation_info"
			+ "								  WHERE id = :id";
}
