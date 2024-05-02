/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0034HTMLAction.java
*@FileTitle : B/L INQUIRY_Customs Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.05.04 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaAiBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustomerSecondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0034HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0034HTMLAction 객체를 생성
	 */
	public ESM_BKG_0034HTMLAction() {}
 
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0034Event event = new EsmBkg0034Event();
		event.setBlNo(request.getParameter("bl_no"));
		event.setBlCstms(request.getParameter("bl_cstms"));

		if( command.isCommand(FormCommand.SEARCH) )	{	// 유저 정보 조회
			event.setBlCondVO((BlCondVO)getVO(request, UsaBlCondVO.class));
		}
		else if( command.isCommand(FormCommand.SEARCH01) )	{	// B/L Info 조회
			event.setBlCondVO((BlCondVO)getVO(request, UsaBlCondVO.class));
		} 
		else if( command.isCommand(FormCommand.SEARCH04) )	{	// Disposition Code List 조회
			event.setDispoCdListCondVO((DispoCdListCondVO)getVO(request, DispoCdListCondVO.class));
		} 
		else if(command.isCommand(FormCommand.MULTI)) {	 // Save
			event.setBlNo(request.getParameter("bl_no"));
			event.setBlCstms(request.getParameter("bl_cstms"));
			
			event.setUsaAiBlInfoVOs((UsaAiBlInfoVO[])getVOs(request, UsaAiBlInfoVO.class, "t0_new_"));
			event.setOldAiBlInfoVOs((UsaAiBlInfoVO[])getVOs(request, UsaAiBlInfoVO.class, "t0_old_"));

			UsaBlCustVO[] newBlCustVOs = new UsaBlCustVO[3];
			UsaBlCustVO[] temp = null;
			temp = (UsaBlCustVO[])getVOs(request, UsaBlCustVO.class, "t1_new_shpr_");
			if(temp != null) newBlCustVOs[0] = temp[0];
			temp = (UsaBlCustVO[])getVOs(request, UsaBlCustVO.class, "t1_new_cnee_");
			if(temp != null) newBlCustVOs[1] = temp[0];
			temp = (UsaBlCustVO[])getVOs(request, UsaBlCustVO.class, "t1_new_ntfy_");
			if(temp != null) newBlCustVOs[2] = temp[0];
			event.setUsaBlCustVOs(newBlCustVOs);
			event.setOldBlCustVOs((UsaBlCustVO[])getVOs(request, UsaBlCustVO.class, "t1_old_"));

			UsaBlCustomerSecondVO[] newBlCustomer2VOs = new UsaBlCustomerSecondVO[2];
			UsaBlCustomerSecondVO[] temp2 = null;
			temp2 = (UsaBlCustomerSecondVO[])getVOs(request, UsaBlCustomerSecondVO.class, "t2_new_fwdr_");
			if(temp2 != null) newBlCustomer2VOs[0] = temp2[0];
			temp2 = (UsaBlCustomerSecondVO[])getVOs(request, UsaBlCustomerSecondVO.class, "t2_new_antf_");
			if(temp2 != null) newBlCustomer2VOs[1] = temp2[0];
			event.setUsaBlCustomerSecondVOs(newBlCustomer2VOs);
			event.setOldBlCustomerSecondVOs((UsaBlCustomerSecondVO[])getVOs(request, UsaBlCustomerSecondVO.class, "t2_old_"));

			event.getUsaAiBlInfoVOs()[0].setDiffRmk(request.getParameter("t4_diff_rmk"));
			event.getOldAiBlInfoVOs()[0].setDiffRmk(request.getParameter("t4_bak_diff_rmk"));
		}
		else if(command.isCommand(FormCommand.MODIFY01)) { 
			UsaBlCustVO blCustVO = new UsaBlCustVO();
			String prefix = "";
			if("S".equals(request.getParameter("cust_tp"))){
				prefix = "shpr_";
			}else if("C".equals(request.getParameter("cust_tp"))){
				prefix = "cnee_";
			}else{
				prefix = "ntfy_";
			}
			blCustVO.setCustCntCd(request.getParameter(prefix+"cust_cnt_cd"));
			blCustVO.setCustSeq(request.getParameter(prefix+"cust_seq"));
			event.setUsaBlCustVO(blCustVO);
		} 
		else if(command.isCommand(FormCommand.MODIFY02)) { 
			UsaBlCustVO blCustVO = new UsaBlCustVO();
			String prefix = "";
			if("F".equals(request.getParameter("cust_tp"))){
				prefix = "fwdr_";
			}else{
				prefix = "antf_";
			}
			blCustVO.setCustCntCd(request.getParameter(prefix+"cust_cnt_cd"));
			blCustVO.setCustSeq(request.getParameter(prefix+"cust_seq"));
			event.setUsaBlCustVO(blCustVO);
		}
		else if(command.isCommand(FormCommand.MODIFY11) || command.isCommand(FormCommand.MODIFY12)) {
			// AI Manifest Transmit 정보 전송
			event.setUsaManifestSearchDetailVOS ((UsaManifestSearchDetailVO[]) getVOs(request, UsaManifestSearchDetailVO.class));
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