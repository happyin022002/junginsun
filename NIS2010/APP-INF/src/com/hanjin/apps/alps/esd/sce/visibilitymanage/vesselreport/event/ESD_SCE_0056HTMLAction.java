/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0056HTMLAction.java
*@FileTitle : Vessel Report
*Open Issues :
*Change history :
*@LastModifyDate : 2007-07-23
*@LastModifier : Jeong-Seon An , Yoon-Jung Lee
*@LastVersion : 1.0
* 2007-07-23 Jeong-Seon An , Yoon-Jung Lee
* 1.0 최초 생성
* 2012.02.22 채창호 [CHM-201115166-01]:Split 01-US Inland Operation Report 내, 324 EDI 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ExceptionManageSC로 실행요청<br>
 * - ExceptionManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Jeong-Seon An , Yoon-Jung Lee
 * @see EsdSce0056Event , EsdSce0056EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0056HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
     * ESD_SCE_0056HTMLAction 객체를 생성
     */
    public ESD_SCE_0056HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0056Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand f_cmd = FormCommand.fromRequest(request);
        EsdSce0056Event event = new EsdSce0056Event();
        
        if (f_cmd.isCommand(FormCommand.SEARCHLIST) ||f_cmd.isCommand(FormCommand.SEARCH03) ) {
        	SearchUSIORInfoVO condition = new SearchUSIORInfoVO();
        	condition.setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
        	condition.setToDt(JSPUtil.getParameter(request, "to_dt", ""));
        	condition.setSNeweqOffice(JSPUtil.getParameter(request, "s_neweq_office", ""));
        	condition.setSEqOffice(JSPUtil.getParameter(request, "s_eq_office", ""));
        	condition.setTRailBillingSts(JSPUtil.getParameter(request, "t_rail_billing_sts", ""));
        	condition.setTTruckSts(JSPUtil.getParameter(request, "t_truck_sts", ""));
        	condition.setTCostMode(JSPUtil.getParameter(request, "t_cost_mode", ""));
        	condition.setSRailDest(JSPUtil.getParameter(request, "s_rail_dest", ""));
        	condition.setSDel(JSPUtil.getParameter(request, "s_del", ""));
        	condition.setSLane(JSPUtil.getParameter(request, "s_lane", ""));
        	condition.setTPNo(JSPUtil.getParameter(request, "t_p_no", ""));
        	condition.setSScNo(JSPUtil.getParameter(request, "s_sc_no", ""));
        	condition.setSPolPod(JSPUtil.getParameter(request, "s_pol_pod", ""));
        	condition.setSPupOffice(JSPUtil.getParameter(request, "s_pup_office", ""));
        	condition.setTPupSts(JSPUtil.getParameter(request, "t_pup_sts	", ""));
        	condition.setTEndSts(JSPUtil.getParameter(request, "t_end_sts	", ""));
        	condition.setSVvd(JSPUtil.getParameter(request, "s_vvd", ""));
        	condition.setEdiStatus(JSPUtil.getParameter(request, "t_edi_sts", ""));
        	condition.setSCLoc(JSPUtil.getParameter(request, "s_c_loc", ""));
        	condition.setCostDiv(JSPUtil.getParameter(request, "cost_div", ""));
        	condition.setEqmtOfc(JSPUtil.getParameter(request, "eqmt_ofc", ""));
        	condition.setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
        	
        	condition.setSBkgNo(JSPUtil.getParameter(request, "s_bkg_no", "")); // correction
        	condition.setSCntrNo(JSPUtil.getParameter(request, "s_cntr_no", "")); // correction
        	condition.setMstBkgSts(JSPUtil.getParameter(request, "mst_bkg_sts", "")); // correction
        	condition.setSMvmtCd(JSPUtil.getParameter(request, "s_mvmt_cd", ""));
        	
        	if (JSPUtil.getParameter(request, "rad_vendor", "").equals("V1")){
        		condition.setVndrSeq(JSPUtil.getParameter(request, "sel_railroad", ""));
        	}else {
        		condition.setVndrSeq(JSPUtil.getParameter(request, "combo_svc_provider", ""));
        	}
        	
        	condition.setDateselect(JSPUtil.getParameter(request, "dateselect", ""));
        	
        	event.setSearchUSIORInfo(condition);
        	event.setSearchUSIORList((SearchUSIORListVO) getVO(request, SearchUSIORListVO.class));
        }else if (f_cmd.isCommand(FormCommand.SEARCH02)) {
        	event.setCostDiv(JSPUtil.getParameter(request, "cost_div", ""));
        }else if (f_cmd.isCommand(FormCommand.MULTI)) { // 저장할 때

        	int leng2 = request.getParameterValues("chk2").length;
        	String[] chk2 = JSPUtil.getParameter(request, "chk2", leng2);       	
        	String[] coldesc2 = JSPUtil.getParameter(request, "coldesc2", leng2);
        	event.setChk2(chk2);
        	event.setColdesc2(coldesc2);
        	
        }else  if (f_cmd.isCommand(FormCommand.MODIFY)){
        	event.setSearchUSIORList((SearchUSIORListVO) getVO(request, SearchUSIORListVO.class));
        	List<SearchEdi324SendVO> sendvos = new ArrayList<SearchEdi324SendVO>();

        	int length = request.getParameterValues("chk").length;
        	
        	if(length >0 ){
        		String[] vvd = (JSPUtil.getParameter(request, "vvd".trim(),length));             
        		String[] bkg_no = (JSPUtil.getParameter(request, "bkg_no".trim(),length));         
        		String[] bl_no = (JSPUtil.getParameter(request, "bl_no".trim(),length));          
        		String[] cntr_no = (JSPUtil.getParameter(request, "cntr_no".trim(),length)); 
        		String[] cop_no = (JSPUtil.getParameter(request, "cop_no".trim(),length));               
        		String[] vendor_code = (JSPUtil.getParameter(request, "vndr_seq".trim(),length)); 
            	
        		for(int i=0; i <length;i++){
        			SearchEdi324SendVO sendvo = new SearchEdi324SendVO();

        			/*기 정의된값 세팅*/
        		    sendvo.setVslCd(vvd[i].substring(0, 4));
        		    sendvo.setSkdVoyNo(vvd[i].substring(4, 8));
        		    sendvo.setSkdDirCd(vvd[i].substring(8, 9));
        			sendvo.setBkgNo(bkg_no[i]);
        			sendvo.setBlNo(bl_no[i]);
        			sendvo.setCntrNo(cntr_no[i]);
        			sendvo.setVndrSeq(vendor_code[i]);
        			sendvo.setCreUsrId("324_MUN");
        			sendvo.setUpdUsrId("324_MUN");
        			/*화면에서 받아온 값을 VO 에 정의함*/
                     sendvos.add(sendvo);
        		}//for       		
        		
          }
        	 event.setSearchEdi324SendVOs(sendvos);
       }else if (f_cmd.isCommand(FormCommand.SEARCH05)) {
    	   SearchUSIORInfoVO condition = new SearchUSIORInfoVO();
    	   condition.setVndrSeq(JSPUtil.getParameter(request, "combo_svc_provider", ""));
    	   event.setSearchUSIORInfo(condition);
       }
       
		request.setAttribute("Event", event);

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