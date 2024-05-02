/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0581HTMLAction.java
*@FileTitle : OOP Code Match with Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.19 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgVslOopVO;
import com.hanjin.syscommon.common.table.BkgVslOpCrrCdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.transshipmentmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TransshipmentMgtSC로 실행요청<br>
 * - TransshipmentMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0581HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0581HTMLAction 객체를 생성
	 */
	public ESM_BKG_0581HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TransshipmentMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0581Event event = new EsmBkg0581Event();
		
		if(command.isCommand(FormCommand.MULTI01)) { 
			
			String[] ibflag= request.getParameterValues("sheet1_ibflag");
			String[] vsl_cd= request.getParameterValues("sheet1_vsl_cd");
			String[] oop1= request.getParameterValues("sheet1_oop1");
			String[] oop2= request.getParameterValues("sheet1_oop2");
			String[] oop3= request.getParameterValues("sheet1_oop3");
			
			BkgVslOopVO bkgVslOopVO1 = new BkgVslOopVO();
			BkgVslOopVO bkgVslOopVO2 = new BkgVslOopVO();
			BkgVslOopVO bkgVslOopVO3 = new BkgVslOopVO();
			
			BkgVslOopVO[] bkgVslOopVOS = null;
			int iArr=1; 
			int idx=0;
			for(int i=0;i<ibflag.length;i++){
				if (oop1[i] !=null && oop1[i].trim().length()>0){
					bkgVslOopVO1.setIbflag(ibflag[i]);
				}else{
					bkgVslOopVO1.setIbflag("D");
				}
					bkgVslOopVO1.setVslCd(vsl_cd[i]);
					bkgVslOopVO1.setOpCd(JSPUtil.getNull(oop1[i]));
					bkgVslOopVO1.setOpSeq("1");
					iArr++;

				if (oop2[i] !=null && oop2[i].trim().length()>0){
					bkgVslOopVO2.setIbflag(ibflag[i]);
				}else{
					bkgVslOopVO2.setIbflag("D");
				}
					bkgVslOopVO2.setVslCd(vsl_cd[i]);
					bkgVslOopVO2.setOpCd(JSPUtil.getNull(oop2[i]));
					bkgVslOopVO2.setOpSeq("2");
					iArr++;
				
				if (oop3[i] !=null && oop3[i].trim().length()>0){
					bkgVslOopVO3.setIbflag(ibflag[i]);
				}else{
					bkgVslOopVO3.setIbflag("D");
				}
					bkgVslOopVO3.setVslCd(vsl_cd[i]);
					bkgVslOopVO3.setOpCd(JSPUtil.getNull(oop3[i]));
					bkgVslOopVO3.setOpSeq("3");
				
				
				bkgVslOopVOS=new BkgVslOopVO[iArr];
				
//				if (oop1[i] !=null && oop1[i].trim().length()>0){
					bkgVslOopVOS[idx]= bkgVslOopVO1;
					idx++;
//				}
				
//				if (oop2[i] !=null && oop2[i].trim().length()>0){
					bkgVslOopVOS[idx]= bkgVslOopVO2;
					idx++;
//				}
//				if (oop3[i] !=null && oop3[i].trim().length()>0){
					bkgVslOopVOS[idx]= bkgVslOopVO3;
//				}
			}
			
			event.setBkgVslOopVOS(bkgVslOopVOS);
//			event.setBkgVslOopVOS((BkgVslOopVO[])getVOs(request, BkgVslOopVO .class,"sheet1_"));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setBkgVslOpCrrCdVOS((BkgVslOpCrrCdVO[])getVOs(request, BkgVslOpCrrCdVO .class,"sheet2_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setVslOopInputVO((VslOopInputVO)getVO(request, VslOopInputVO .class));
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