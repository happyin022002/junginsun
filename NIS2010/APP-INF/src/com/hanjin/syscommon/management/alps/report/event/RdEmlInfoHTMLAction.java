/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RdEmlInfoHTMLAction.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-21
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-21 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.syscommon.management.alps.report.vo.ComEmlVO;
/**
 * HTTP Parser<br>
 * - NIS2010.src.com.hanjin.syscommon.management.nis2010.report 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RdEmlInfoSC 실행요청<br>
 * - RdEmlInfoSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author YongHoo-Kim
 * @see  RdEmlInfoHTMLAction 참조
 * @since J2SE 6.0
 */
public class RdEmlInfoHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 7046566339850038322L;
	
	/**
	 * RdEmlInfoHTMLAction 객체를 생성
	 */
	public RdEmlInfoHTMLAction() {
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RdEmlInfoEvent 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		ComEmlVO emlVO = (ComEmlVO) getVO(request, ComEmlVO.class);
		RdEmlInfoEvent emlInfoEvent = new RdEmlInfoEvent();
		emlInfoEvent.setComEmlVO(emlVO);
		return emlInfoEvent;
	}
}