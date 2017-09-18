package naverest.reservation.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import naverest.reservation.domain.ReservationInfo;
import naverest.reservation.dto.MyReservation;
import naverest.reservation.jdbc.CustomNamedParameterJdbcTemplate;
import naverest.reservation.sql.ReservationInfoSqls;

@Repository
public class ReservationInfoDao {
	private CustomNamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	
	private DateFormat df = new SimpleDateFormat("yyyy.M.d.(E)");
	private RowMapper<MyReservation> myReservationRowMapper = (rs, i) -> {
			MyReservation myReservation = new MyReservation();
			myReservation.setId(rs.getInt("id"));
			myReservation.setProductId(rs.getInt("productId"));
			myReservation.setUserId(rs.getInt("userId"));
			myReservation.setGeneralTicketCount(rs.getInt("generalTicketCount"));
			myReservation.setYouthTicketCount(rs.getInt("youthTicketCount"));
			myReservation.setChildTicketCount(rs.getInt("childTicketCount"));
			myReservation.setReservationType(rs.getString("reservationType"));
			myReservation.setReservationDate(df.format(rs.getDate("reservationDate")));
			myReservation.setName(rs.getString("name"));
			return myReservation;
	};
	
	private SimpleJdbcInsert insertAction;
	
	@Autowired
	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new CustomNamedParameterJdbcTemplate(dataSource, ReservationInfoDao.class);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(ReservationInfo reservationInfo) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
        return insertAction.executeAndReturnKey(params).intValue();
    }
	
	public List<MyReservation> selectByUserId(Integer userId) {
		Map<String, Object> params = Collections.singletonMap("userId", userId);
		return jdbc.query(ReservationInfoSqls.SELECT_BY_USER_ID, params, myReservationRowMapper);
	}
	
	public List<MyReservation> selectByUserIdAndType(Integer userId, Integer type) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("type", type);
		return jdbc.query(ReservationInfoSqls.SELECT_BY_USER_ID_AND_TYPE, params, myReservationRowMapper);
	}
	
	public Integer deleteByType(Integer userId, String type) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("type", type);
		return jdbc.update(ReservationInfoSqls.DELETE_BY_TYPE, params);
	}
	
	public Integer updateTypeById(Integer id, String type) {
		Map<String, Object> params = new HashMap<>();
		params.put("type", type);
		params.put("id", id);
		return jdbc.update(ReservationInfoSqls.UPDATE_TYPE_BY_ID, params);
	}
	public Integer selectCountByUserIdAndProductId(Integer productId, Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("userId", userId);
		return jdbc.queryForObject(ReservationInfoSqls.SELECT_COUNT_BY_USER_ID_AND_PRODUCT_ID, 
				params, Integer.class);
	}
	public ReservationInfo selectById(Integer id) {
		Map<String, Object> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ReservationInfoSqls.SELECT_BY_ID, params, rowMapper);
	}
	
}
