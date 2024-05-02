/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0119HTMLAction.java
*@FileTitle : MNR PFMC by AGMT TRIFF
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.13 민정호
* 1.0 Creation
* ---------------------------------------------------------
* history
* 2015.01.19 Chang Young Kim 품질결함으로 인한 소스명변경을 이유로 소스 수정(EesMnr0119_01Event.java -> EesMnr011901Event.java)
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.SearchFoodQualityDetailKeyINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrCtrlGlineHdrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.reportmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ReportManageSC로 실행요청<br>
 * - ReportManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jung Ho Min
 * @see ReportManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0119_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0119HTMLAction 객체를 생성
	 */
	public EES_MNR_0119_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ReportManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */

	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesMnr011901Event event = new EesMnr011901Event();
			
    	//건당 조회  
    	if(command.isCommand(FormCommand.SEARCH)) {
    		event.setSearchFoodQualityDetailKeyVO((SearchFoodQualityDetailKeyINVO)getVO(request, SearchFoodQualityDetailKeyINVO.class));
    	}
    	
    	//다건 조회
    	if(command.isCommand(FormCommand.MULTI)) {
    	/*	log.debug("============perform     ========");
    		log.debug("=============fm_dt      ============"+request.getParameterValues("fm_dt").length);
    		log.debug("=============to_dt      ============"+request.getParameterValues("to_dt").length);
    		log.debug("=============rhq        ============"+request.getParameterValues("rhq").length);
    		log.debug("=============ofc_cd     ============"+request.getParameterValues("ofc_cd").length);
    		log.debug("=============vndr_seq   ============"+request.getParameterValues("vndr_seq").length);
    		log.debug("=============location_cd============"+request.getParameterValues("location_cd").length);*/
    		
    		String vFm_dt[]       = request.getParameterValues("fm_dt");
    		String vTo_dt[]       = request.getParameterValues("to_dt");
    		String vRhq[] 	      = request.getParameterValues("rhq");
    		String vOfc_cd[]      = request.getParameterValues("ofc_cd");
    		String vVndr_seq[]    = request.getParameterValues("vndr_seq");
    		
    		String vLocation_cd[] = request.getParameterValues("location_cd");
    		String vComponent[] = request.getParameterValues("component");
    		String vRepair[] = request.getParameterValues("repair");
    		String vDivision[] = request.getParameterValues("division");
    		String vDamage[] = request.getParameterValues("damage");
    		
    		if(vFm_dt.length>0){
    			List<SearchFoodQualityDetailKeyINVO> 	searchFoodQualityDetailKeyINVOs 		= new ArrayList<SearchFoodQualityDetailKeyINVO>();
    			
	    		for(int i=0; i<vFm_dt.length;i++){
	    		/*	log.debug("=============vFm_dt============"+vFm_dt[i]);
	    			log.debug("=============to_dt      ============"+vTo_dt[i]      );
	        		log.debug("=============rhq        ============"+vRhq[i] 	    );  
	        		log.debug("=============ofc_cd     ============"+vOfc_cd[i]     );
	        		log.debug("=============vndr_seq   ============"+vVndr_seq[i]   );
	        		log.debug("=============location_cd============"+vLocation_cd[i]);*/
	        		SearchFoodQualityDetailKeyINVO searchFoodQualityDetailKeyINVO = new SearchFoodQualityDetailKeyINVO();
	        		searchFoodQualityDetailKeyINVO.setFmDt(vFm_dt[i]);
	        		searchFoodQualityDetailKeyINVO.setToDt(vTo_dt[i]);
	        		searchFoodQualityDetailKeyINVO.setRhq (vRhq[i]);
	        		searchFoodQualityDetailKeyINVO.setOfcCd(vOfc_cd[i]);
	        		searchFoodQualityDetailKeyINVO.setVndrSeq(vVndr_seq[i]);
	        		searchFoodQualityDetailKeyINVO.setLocationCd(vLocation_cd[i]);
	        		searchFoodQualityDetailKeyINVO.setComponent(vComponent[i]);
	        		searchFoodQualityDetailKeyINVO.setRepair(vRepair[i]);
	        		searchFoodQualityDetailKeyINVO.setDivision(vDivision[i]);
	        		searchFoodQualityDetailKeyINVO.setDamage(vDamage[i]);
	        		searchFoodQualityDetailKeyINVOs.add(searchFoodQualityDetailKeyINVO);
	    		}
	    		event.setSearchFoodQualityDetailMultiVOs(searchFoodQualityDetailKeyINVOs);
    		}
    	//	event.setSearchFoodQualityDetailMultiVO((SearchFoodQualityDetailKeyINVO[])getVOs(request, SearchFoodQualityDetailKeyINVO.class));
    	}
		return  event;
	}
	
	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}
	
	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}