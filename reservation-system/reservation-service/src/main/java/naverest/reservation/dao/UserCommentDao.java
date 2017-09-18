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

import naverest.reservation.domain.ReservationUserComment;
import naverest.reservation.dto.CommentStats;
import naverest.reservation.dto.UserComment;
import naverest.reservation.jdbc.CustomNamedParameterJdbcTemplate;
import naverest.reservation.sql.UserCommentSqls;

@Repository
public class UserCommentDao {
	private CustomNamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	
	private DateFormat df = new SimpleDateFormat("yyyy.M.d.");
	private RowMapper<UserComment> userCommentrowMapper = (rs, i) -> {
		UserComment userComment = new UserComment();
		userComment.setId(rs.getInt("id"));
		userComment.setComment(rs.getString("comment"));
		userComment.setProductName(rs.getString("name"));
		userComment.setCreateDate(rs.getDate("create_date"));
		userComment.setModifyDate(rs.getDate("modify_date"));
		userComment.setScore(rs.getBigDecimal("score"));
		userComment.setUserId(rs.getInt("user_id"));
		userComment.setUsername(rs.getString("username").substring(0, rs.getString("username").length() - 3) + "****");
		userComment.setReservationDate(df.format(rs.getDate("reservation_date")));
		return userComment;
	};

	private RowMapper<CommentStats> userCommentStatsRowMapper = BeanPropertyRowMapper.newInstance(CommentStats.class);

	@Autowired
	public UserCommentDao(DataSource dataSource) {
		this.jdbc = new CustomNamedParameterJdbcTemplate(dataSource, UserCommentDao.class);
		 this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("RESERVATION_USER_COMMENT")
                 .usingGeneratedKeyColumns("id");
	}
	
	public Integer insert(ReservationUserComment comment) {
	    SqlParameterSource params = new BeanPropertySqlParameterSource(comment);
	    return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public List<UserComment> selectByProductId(Integer productId, Integer offset, Integer size) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("offset", offset);
		params.put("size", size);
		return jdbc.query(UserCommentSqls.SELECT_BY_PRODUCT_ID_LIMIT, params, userCommentrowMapper);
	}

	public CommentStats selectStatsByProductId(Integer productId) {
		Map<String, Object> params = Collections.singletonMap("productId", productId);
		return jdbc.queryForObject(UserCommentSqls.SELECT_STATS_BY_PRODUCT_ID, params, userCommentStatsRowMapper);
	}

}
