<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">

<jsp:include page="inc/common/head.jsp">
			<jsp:param value="네이버 예약" name="title"/>
</jsp:include>

<body>
    <div id="container">
        <jsp:include page="inc/common/header.jsp">
        		<jsp:param value="transparent" name="visual"/>
        </jsp:include>
        <div class="ct main">
            <div>
                <div class="section_visual">
                    <div class="pagination">
                        <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                            <span class="num _ProductImageCurrentCount">1</span>
							<!--디폴트 이미지 보여줄 것을 생각해서 -->
                            <span class="num off">/ <span class="_productImageMaxCount">${fn:length(product.fileList) > 0 ? fn:length(product.fileList) : 1 }</span></span>
                        </div>
                    </div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                        		<c:choose>
                        			<c:when test="${ empty product.fileList }">
									<ul class="visual_img">
	                            	    		<li class="item _item" style="width: 414px;"> <img alt="" class="img_thumb" src="/imgresources/no_img.png"> <span class="img_bg"></span>
                            	    			   <c:if test="${status.first}">
		                                        <div class="visual_txt">
		                                            <div class="visual_txt_inn">
		                                                <h2 class="visual_txt_tit"> <span>${product.name }</span> </h2>
		                                                <p class="visual_txt_dsc">${product.description }</p>
		                                            </div>
		                                        </div>
	                                        </c:if>
                                    		</li>
			     				    </ul>
		     				    	</c:when>
								<c:when test="${ !empty product.fileList }">
									<ul class="visual_img">
	                            	    <c:forEach var="item" items= "${product.fileList}" varStatus="status">
                            	    		<li class="item _item" style="width: 414px;">
                                                <img alt="" class="img_thumb" src="/imgresources${item.saveFileName }">
                                                <span class="img_bg"></span>
                        	    			    <c:if test="${status.first}">
		                                        <div class="visual_txt">
		                                            <div class="visual_txt_inn">
		                                                <h2 class="visual_txt_tit"> <span>${product.name }</span> </h2>
		                                                <p class="visual_txt_dsc">${product.description }</p>
		                                            </div>
		                                        </div>
                                               </c:if>
                                		    </li>
			     				    </c:forEach>
			     				    </ul>
		     				    	</c:when>
	     				    	</c:choose>
                            </div>
                            <c:if test="${fn:length(product.fileList) gt 1}">
	                            <div class="prev">
	                                <div class="prev_inn">
	                                    <a href="#" class="btn_prev _prev" title="이전">
	                                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
	                                        <i class="spr_book2 ico_arr6_lt off"></i>
	                                    </a>
	                                </div>
	                            </div>
	                            <div class="nxt">
	                                <div class="nxt_inn">
	                                    <a href="#" class="btn_nxt _next" title="다음">
	                                        <i class="spr_book2 ico_arr6_rt"></i>
	                                    </a>
	                                </div>
	                            </div>
						    </c:if>
                        </div>
                    </div>
                    <div class="group_btn_goto">
						<c:if test="${product.homepage ne null }">
                        		<a class="btn_goto_home" title="홈페이지" href="${product.homepage }" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        </c:if>
                        <c:if test="${product.tel ne null }">
                        		<a class="btn_goto_tel" title="전화" href="tel:${product.tel }"> <i class="fn fn-call1"></i> </a>
                        </c:if>
                        <c:if test="${product.email ne null }">
							<a class="btn_goto_mail" title="이메일" href="mailto:${product.email }"> <i class="fn fn-mail1"></i> </a>
						</c:if>
						<c:if test="${product.placeLot ne null || product.placeStreet ne null }">
							<a href="#" class="btn_goto_path _store_location" title="길찾기" target="_blank"> <i class="fn fn-path-find1 _store_location"></i> </a>
                        </c:if>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>
                <div class="section_store_details _detailContentWrapper">
                    <!-- [D] 펼쳐보기 클릭 시 store_details에 close3 제거 -->
                    <div class="store_details close3 _content">
                        <p class="dsc">
                            웰메이드 창작 뮤지컬의 대표 브랜드 '김수로 프로젝트' 최신작! 연극, 뮤지컬, 무용 등 매년 작품성 있는 창작 공연을 선보이며, 대한민국 대표 웰메이드 창작 브랜드로 자리매김한 '김수로 프로젝트'의 최신작 입니다.
                        </p>
                    </div>
                    <!-- [D] 토글 상황에 따라 bk_more에 display:none 추가 -->
                    <a href="#" class="bk_more _open _hinge"> <span class="bk_more_txt">펼쳐보기</span> <i class="fn fn-down2"></i> </a>
                    <a href="#" class="bk_more _close _hinge hide"> <span class="bk_more_txt">접기</span> <i class="fn fn-up2"></i> </a>
                </div>
                <c:if test="${product.event ne null }">
	                <div class="section_event">
	                    <div class="event_info_box">
	                        <div class="event_info_tit">
	                            <h4 class="in_tit"> <i class="spr_book ico_evt"></i> <span>이벤트 정보</span> </h4>
	                        </div>
	                        <div class="event_info">
	                            <div class="in_dsc">${product.event }</div>
	                        </div>
	                    </div>
	                </div>
                </c:if>
                <div class="section_btn"> <a href="/booking?productId=${product.id }" class="bk_btn _btn_reservation"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </a> </div>

                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
	                        <div class="short_review_area">
	                            <div class="grade_area">
	                                <!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
	                                <span class="graph_mask"> <em class="graph_value _scorePercentage" style="width: 0%;"></em> </span>
	                                <strong class="text_value"> <span class="_score">0.0</span> <em class="total">5.0</em> </strong>
	                                <span class="join_count"><em class="green"><span class="_count">0</span>건</em> 등록</span>
	                            </div>
	                            <ul class="list_short_review _reviewList">
	                            	   <!-- review template HandleBar  -->
	                            </ul>
	                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>

                   <a class="btn_review_more" href="/reviews?productId=${product.id}"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>

                <div class="section_info_tab _infoTabArea">
                    <!-- [D] tab 선택 시 anchor에 active 추가 -->
                    <ul class="info_tab_lst">
                    	    <c:if test="${product.content ne null }">
	                        <li class="item">
	                            <a href="#" class="active anchor _tab" data-content="._detail"> <span>상세정보</span> </a>
	                        </li>
                        </c:if>
                        <li class="item">
                            <a href="#" class="anchor _tab ${product.content == null ? 'active' :  ''}" data-content="._way"> <span>오시는길</span> </a>
                        </li>
                    </ul>
                    <!-- [D] 상세정보 외 다른 탭 선택 시 detail_area_wrap에 hide 추가 -->
                    <c:if test="${product.content ne null }">
	                    <div class="detail_area_wrap _content _detail">
	                        <div class="detail_area">
	                            <div class="detail_info">
	                                <h3 class="blind">상세정보</h3>
	                                <ul class="detail_info_group">
	                                    <li class="detail_info_lst">
	                                        <strong class="in_tit">[소개]</strong>
	                                        <p class="in_dsc">
	                                        		${product.content }
	                                        </p>
	                                    </li>
	                                    <li class="detail_info_lst"> <strong class="in_tit">[공지사항]</strong>
	                                        <ul class="in_img_group">
	                                            <li class="in_img_lst"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170131_238/14858250829398Pnx6_JPEG/%B0%F8%C1%F6%BB%E7%C7%D7.jpg?type=a1000"> </li>
	                                        </ul>
	                                    </li>
	                                    <li class="detail_info_lst"> <strong class="in_tit">[공연정보]</strong>
	                                        <ul class="in_img_group">
	                                            <li class="in_img_lst"> <img alt="" class="img_thumb" data-lazy-image="https://ssl.phinf.net/naverbooking/20170131_255/1485825099482NmYMe_JPEG/%B0%F8%BF%AC%C1%A4%BA%B8.jpg?type=a1000"> </li>
	                                        </ul>
	                                    </li>
                                      <li class="detail_info_lst">
                                          <img class="img_thumb lazyImg" data-src="/imgresources/2017/07/18/52b2239e-9871-4edf-a91f-3169d6757770" alt="업로드 이미지">
                                      </li>
                                      <li class="detail_info_lst">
                                          <img class="img_thumb lazyImg" data-src="/imgresources/2017/07/18/52b2239e-9871-4edf-a91f-3169d6757770" alt="업로드 이미지">
                                      </li>
	                                </ul>
	                            </div>
	                        </div>
	                    </div>
                    </c:if>
                    <!-- [D] 오시는길 외 다른 탭 선택 시 detail_location에 hide 추가 -->
                    <div class="detail_location _content _way ${product.content == null ? '' : 'hide'}">
                        <div class="box_store_info">
                            <a href="#" class="store_location _store_location" title="지도웹으로 연결" target="_blnak">
                                <img class="store_map img_thumb" alt="map" src="">
                                <!-- <div id="map" style="width:100%;height:165px;"></div> -->
                                <span class="img_border"></span>
                                <span class="btn_map"><i class="spr_book2 ico_mapview"></i></span>
                            </a>
                            <h3 class="store_name">${product.name }</h3>
                            <div class="store_info">
                                <div class="store_addr_wrap">
                                    <span class="fn fn-pin2"></span>
                                    <p class="store_addr store_addr_bold">${product.placeStreet } </p>
                                    <p class="store_addr">
                                        <span class="addr_old">지번</span>
                                        <span class="addr_old_detail">${product.placeLot } </span>
                                    </p>
                                    <p class="store_addr addr_detail">${product.placeName }</p>
                                </div>
                                <div class="lst_store_info_wrap">
                                    <ul class="lst_store_info">
                                        <li class="item"> <span class="item_lt"> <i class="fn fn-call2"></i> <span class="sr_only">전화번호</span> </span> <span class="item_rt"> <a href="tel:${product.tel }" class="store_tel">${product.tel }</a></span> </li>
                                    </ul>
                                </div>
                            </div>
							<!-- [D] 모바일 브라우저에서 접근 시 column2 추가와 btn_navigation 요소 추가 -->
                            <div class="bottom_common_path column2">
                                <a href="#" class="btn_path"> <i class="fn fn-path-find2"></i> <span>길찾기</span> </a>
								<a hewf="#" class="btn_navigation before"> <i class="fn fn-navigation2"></i> <span>내비게이션</span> </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>
    <div id="photoviwer" class="hide">
    		<div id="photoviwerInner"></div>
    		<button class="close _close" type="button">
    			<span class="blind">닫기</span>
    			<span aria-role="presentation">X</span>
   		</button>
    </div>
</body>
<script id="review-template" type="text/x-handlebars-template">
    <li class="list_item">
        <div>
            <div class="review_area {{#unless commnetImageList}}no_img{{/unless}}">
                <div class="thumb_area">
                    {{#if commentImageList}}
                        <a href="#" class="thumb _commentThumb" title="이미지 크게 보기">
                            {{#each commentImageList}}
                                {{#if @first}}
                                    <img width="90" height="90" class="_img img_vertical_top" src="/imgresources/{{saveFileName}}" alt="리뷰이미지">
                                {{else}}
                                    <img width="90" height="90" class="_img img_vertical_top hide" src="/imgresources/{{saveFileName}}" alt="리뷰이미지">
                                {{/if}}
                            {{/each}}
                        </a>
                        <span class="img_count">{{commentImageList.length}}</span>
                    {{/if}}
                </div>
                <h4 class="resoc_name">{{productName}}</h4>
                <p class="review">{{comment}}</p>
            </div>
            <div class="info_area">
                <div class="review_info">
                    <span class="grade">{{roundUpToFirstPoint score}}</span>
                    <span class="name">{{username}}</span>
                    <span class="date">{{reservationDate}} 방문</span>
                </div>
            </div>
        </div>
    </li>
</script>
<script src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=9xywjQhEim1nZVIa1xZc&submodules=geocoder" ></script>

<script>
    $(document).on("ready", function(){
        (function(){
            "use strict";

            var SALESEND = "sales_end";
            var SOLDOUT = "sold_out";
            var arrAlert = {};
            arrAlert[SALESEND] = "판매기간이 종료되었습니다. 다음에 이용 부탁드립니다.";
            arrAlert[SOLDOUT] = "매진됐습니다. 다음에 이용 부탁드립니다.";
            var ONSALE = 1;
            var saleStatus = ONSALE;
            <jsp:useBean id="now" class="java.util.Date"/>
            ${product.salesEnd <= now ? "saleStatus = SALESEND" : ""}
            ${product.salesFlag != 1 ? "saleStatus = SOLDOUT" : ""}
            if(saleStatus === SALESEND || saleStatus === SOLDOUT )
                $("._btn_reservation").click(function(e) {
                    alert(arrAlert[saleStatus]);
                })
            // 네이버 지도 API
            <c:if test="${product.placeLot ne null || product.placeStreet ne null }">
            /* var map = new naver.maps.Map('map'); */
            var myaddress = "${product.placeStreet != null ? product.placeStreet : product.placeLot }";// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
            naver.maps.Service.geocode({address: myaddress}, function(status, response) {
                if (status !== naver.maps.Service.Status.OK) {
                    return alert(myaddress + '의 검색 결과가 없거나 기타 네트워크 에러');
                }

                var mapImgPath = "https://openapi.naver.com/v1/map/staticmap.bin?clientId=9xywjQhEim1nZVIa1xZc&w=640&h=300&baselayer=default&url=http://220.230.116.163/&level=11";
                var center = "&center=" + (response.result.items[0].point.x) + "," + (response.result.items[0].point.y);
                var markers = "&markers=" + (response.result.items[0].point.x) + "," + (response.result.items[0].point.y);
                mapImgPath = mapImgPath + center + markers;
                $(".store_location").attr("href", "http://map.naver.com/?query=" + myaddress);
                $(".store_location > img").attr("src", mapImgPath);
            });
            //네이버 지도 API
           </c:if>
        })();
    });
</script>
<script>
    require(['detailPresenter', 'rolling', 'reviewPresenter', 'reviewModel'], function(DetailPresenter, Rolling, ReviewPresenter, ReviewModel) {
        "use strict";
        var reviewModel = new ReviewModel({
            productId : ${product.id},
            offset: 0,
            size : 3 });
        var detailPresenter = new DetailPresenter(reviewModel);
        var reviewPresenter = new ReviewPresenter(reviewModel);

        var rolling = new Rolling(".visual_img", {
            "prevBtn" : ".btn_prev",
            "nextBtn" : ".btn_nxt",
            "autoSlide" : false,
            "isTouch" : true
        });
        rolling.on("sliding", function(res) {
            $("._ProductImageCurrentCount").text(res.currentNum);
        });
    });
</script>

</html>
