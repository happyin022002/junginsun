/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0090HTMLAction.java
*@FileTitle : EsdSce0090
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-14
*@LastModifier : sanghyun_kim
*@LastVersion : 1.0
* 2008-04-14 sanghyun_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author sanghyun_kim
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */

public class ESD_SCE_0090HTMLAction extends HTMLActionSupport{
	
	private static final long serialVersionUID = 1L;
	/** Constructor
     * 
     */
	public ESD_SCE_0090HTMLAction(){}
	
	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
    */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0090 생성!!");
		EsdSce0090Event event = new EsdSce0090Event();   
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCH01)) {
        	log.debug("Search01 를 위한 호출"); 
			event.setMyCust((SearchMyCustomerVO) getVO(request,SearchMyCustomerVO.class));
		} else if (f_cmd.isCommand(FormCommand.SEARCH02)) {
			log.debug("Search02 를 위한 호출"); 
			event.setMyPerf((SearchMyPerformanceVO) getVO(request,SearchMyPerformanceVO.class));
		} else if (f_cmd.isCommand(FormCommand.REMOVE01)) {
			log.debug("Delete01 를 위한 호출"); 
			SearchCustomerInfoVO condition = new SearchCustomerInfoVO();
			condition.setEdiGrpCd(JSPUtil.getParameter(request, "f_group_id", ""));
			condition.setCreUsrId(JSPUtil.getParameter(request, "f_user_id", ""));
			event.setMyCustInfo(condition);
			log.debug("f_group_id==" + request.getParameter("f_group_id"));
			log.debug("f_user_id==" + request.getParameter("f_user_id"));
			event.setMyCustInfos((SearchCustomerInfoVO[]) getVOs(request,
					SearchCustomerInfoVO.class));
		} else if (f_cmd.isCommand(FormCommand.REMOVE02)) {
			log.debug("Delete02 를 위한 호출"); 
			SearchCustomerInfoVO condition = new SearchCustomerInfoVO();
			condition.setEdiGrpCd(JSPUtil.getParameter(request, "f_group_id", ""));
			condition.setEdiGrpCd(JSPUtil.getParameter(request, "f_tp_id", ""));
			condition.setCreUsrId(JSPUtil.getParameter(request, "f_user_id", ""));
			event.setMyCustInfo(condition);
			log.debug("f_group_id==" + request.getParameter("f_group_id"));
			log.debug("f_tp_id==" + request.getParameter("f_tp_id"));
			log.debug("f_user_id==" + request.getParameter("f_user_id"));
			event.setMyCustInfos((SearchCustomerInfoVO[]) getVOs(request,
					SearchCustomerInfoVO.class));
		}
        
        request.setAttribute("Event", event);
        return event;
	}
	
	/** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     */
/*	public HashMap getParameterArray(HttpServletRequest request){
        String keyName = "";
        String keyValue = "";
        HashMap hMap = new HashMap();
        
        for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ){
            try{
	            keyName = (String)en.nextElement();
	            keyValue = JSPUtil.getParameter(request, keyName.trim(), "");
            }catch(Exception ex){
            	log.error("err " + ex.toString(), ex);
                keyValue = "";
            }
            hMap.put(keyName, keyValue);
        }
        return hMap;
    }
*/	
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

	/** HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
