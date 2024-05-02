/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_SCE_0073HTMLAction.java
*@FileTitle : EsdSce0073
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-10
*@LastModifier : sanghyun-kim
*@LastVersion : 1.0
* 2008-05-10 sanghyun-kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerInqChoiceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEDIPerformanceOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiSummaryReportOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */

public class ESD_SCE_0073HTMLAction extends HTMLActionSupport{
	
	private static final long serialVersionUID = 1L;
	/** Constructor
     * 
     */
    public ESD_SCE_0073HTMLAction(){}
    
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform (HttpServletRequest request) throws HTMLActionException {
    	log.debug("Event 0073생성!!");
    	EsdSce0073Event event = new EsdSce0073Event();
        //HashMap map = null;
        FormCommand f_cmd = FormCommand.fromRequest(request);
        
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출-콤보 정보 조회");
        	event.setMySearchperPup((SearchPerRepPupModiVO) getVO(request,SearchPerRepPupModiVO.class));
        }else if (f_cmd.isCommand(FormCommand.SEARCH01)) {
        	log.debug("Search01 를 위한 호출"); 
        	SearchCustomerInfoVO condition = new SearchCustomerInfoVO();
			condition.setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_id", ""));
			condition.setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
			condition.setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
			event.setMyCustInfo(condition);
        	event.setMySearchperPup((SearchPerRepPupModiVO) getVO(request,SearchPerRepPupModiVO.class));
        } else if(f_cmd.isCommand(FormCommand.SEARCH02)) {
        	log.debug("Search02 를 위한 호출"); 
        	CustomerInqChoiceVO condition = new CustomerInqChoiceVO();
			condition.setEdiGrpId(JSPUtil.getParameter(request, "edi_grp_id", ""));
			condition.setUserId(JSPUtil.getParameter(request, "cre_usr_id", ""));
			condition.setTpId(JSPUtil.getParameter(request, "tp_cd", ""));
			condition.setEdiGrpDesc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
			condition.setEdiCgoRmk(JSPUtil.getParameter(request, "edi_cgo_rmk", ""));
			event.setMyUserInfo(condition);
			event.setMyUserInfos((CustomerInqChoiceVO[]) getVOs(request,
					CustomerInqChoiceVO.class));
        	event.setMySearchperPup((SearchPerRepPupModiVO) getVO(request,SearchPerRepPupModiVO.class));
        }  else if(f_cmd.isCommand(FormCommand.SEARCH03)) {
			event.setMyCustInfo((SearchCustomerInfoVO) getVO(request,SearchCustomerInfoVO.class));
        } else if(f_cmd.isCommand(FormCommand.SEARCHLIST03)) {
        	log.debug("SEARCHLIST03을 위한 호출"); 
        	SearchEdiSummaryReportOptionsVO condition = new SearchEdiSummaryReportOptionsVO();
        	condition.setCsGrpId(JSPUtil.getParameter(request, "edi_grp_id", ""));
        	log.debug("cs_grp_id==" + condition.getCsGrpId());
        	event.setSchSROptsVO((SearchEdiSummaryReportOptionsVO) getVO(request,SearchEdiSummaryReportOptionsVO.class));
        } else if(f_cmd.isCommand(FormCommand.SEARCHLIST02)) {
        	log.debug("SEARCHLIST02을 위한 호출"); 
        	SearchEDIPerformanceOptionsVO condition = new SearchEDIPerformanceOptionsVO();
        	condition.setTpId(JSPUtil.getParameter(request, "tp_id", ""));
			event.setSchEpOpts(condition);
			log.debug("tp_id==" + request.getParameter("tp_id"));
    		event.setSchEpOpts((SearchEDIPerformanceOptionsVO) getVO(request,SearchEDIPerformanceOptionsVO.class));
        }
        
        if(f_cmd.isCommand(FormCommand.MULTI01)){
        	log.debug("MULTI01을 위한 호출"); 
        	CustomerInqChoiceVO condition = new CustomerInqChoiceVO();
			condition.setEdiGrpId(JSPUtil.getParameter(request, "edi_grp_id", ""));
			condition.setEdiStndStsCd(JSPUtil.getParameter(request, "edi_stnd_sts_cd", ""));
			condition.setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
			condition.setUserId(JSPUtil.getParameter(request, "user_id", ""));
			event.setMyUserInfo(condition);
			log.debug("edi_grp_Id!==" + request.getParameter("edi_grp_id"));
			log.debug("edi_stnd_sts_cd==" + request.getParameter("edi_stnd_sts_cd"));
			log.debug("cust_edi_sts_cd==" + request.getParameter("cust_edi_sts_cd"));
			log.debug("f_user_id==" + request.getParameter("user_id"));
			event.setMyUserInfos((CustomerInqChoiceVO[]) getVOs(request,
					CustomerInqChoiceVO.class));
        } else if(f_cmd.isCommand(FormCommand.MULTI)) {
        	log.debug("MULTI을 위한 호출");
        	CustomerInqChoiceVO condition = new CustomerInqChoiceVO();
			condition.setEdiGrpId(JSPUtil.getParameter(request, "edi_grp_id", ""));
			condition.setUserId(JSPUtil.getParameter(request, "cre_usr_id", ""));
			condition.setTpId(JSPUtil.getParameter(request, "tp_cd", ""));
			condition.setEdiStndStsCd(JSPUtil.getParameter(request, "edi_stnd_sts_cd", ""));
			condition.setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
			condition.setEdiGrpDesc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
			condition.setEdiCgoRmk(JSPUtil.getParameter(request, "edi_cgo_rmk", ""));
			event.setMyUserInfo(condition);
        	event.setMyUserInfos((CustomerInqChoiceVO[]) getVOs(request,CustomerInqChoiceVO.class));
        }else if(f_cmd.isCommand(FormCommand.REMOVE01)) {
        	log.debug("REMOVE를 위한 호출");
        	SearchCustomerInfoVO condition = new SearchCustomerInfoVO();
			condition.setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_id", ""));
			condition.setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
			condition.setCsGrpId(JSPUtil.getParameter(request, "cs_grp_id", ""));
			event.setMyCustInfo(condition);
        	event.setMySearchperPup((SearchPerRepPupModiVO) getVO(request,SearchPerRepPupModiVO.class));
        }
        request.setAttribute("Event", event);
        return event;
    }
    
    /** HTMLAction 변수를 parsing하여 Collection에 담는다.
     * @param request
     * @return
     */
    /*public Collection getParametersArray(HttpServletRequest request){
        HashMap map = new HashMap();
        Collection models = new ArrayList();
        int length = request.getParameterValues("ibflg").length;

        try {
            String[] edi_sts       =  (JSPUtil.getParameter(request, "edi_sts".trim(),   length));
            String[] cust_sts      =  (JSPUtil.getParameter(request, "cust_sts".trim(),  length));
            String[] edi_desc      =  (JSPUtil.getParameter(request, "edi_desc".trim(),  length));
            String[] check          =  (JSPUtil.getParameter(request, "check".trim(),           length));
            
            for (int i = 0; i < length; i++) {
            	if(check[i].equals("1")){
	                map = new HashMap();
	                
	                map.put("edi_sts",          edi_sts[i]);
	                map.put("cust_sts",         cust_sts[i]);
	                map.put("edi_desc",         edi_desc[i]);
	                map.put("check",            check[i]);

	                models.add(map);
            	}
            }
        }catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
        }
        return models;
    }*/
    
    /** request 내의 parameter의 값을 HashMap으로 반환한다.
     * @param request
     * @return hMap
     */
    /*public HashMap getParameterArray(HttpServletRequest request){
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
    }*/
    
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
