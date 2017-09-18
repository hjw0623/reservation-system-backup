package naverest.reservation.restcontroller.user;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import naverest.reservation.dto.Criteria;
import naverest.reservation.dto.UserCommentWrapper;
import naverest.reservation.service.UserCommentService;

@RestController
@RequestMapping("/api/reviews")
public class UserCommentRestController {

	private UserCommentService userCommentService;
	private final Logger log = LoggerFactory.getLogger(UserCommentRestController.class);

	@Autowired
	public UserCommentRestController(UserCommentService userCommentService) {
		this.userCommentService = userCommentService;
	}

	@GetMapping
	public UserCommentWrapper getList(@RequestParam Integer productId, @ModelAttribute @Valid Criteria criteria) {
		log.info("{}", criteria);
		return userCommentService.findCommentWrapperByProductId(productId, criteria.getOffset(), criteria.getSize());
	}
}
