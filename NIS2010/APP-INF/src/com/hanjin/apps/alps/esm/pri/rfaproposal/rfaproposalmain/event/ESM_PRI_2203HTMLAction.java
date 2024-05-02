/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ESM_PRI_2003HTMLAction.java
 *@FileTitle : Proposal & Amendment Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.05.08 변영주
 * 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;
import com.hanjin.syscommon.common.table.PriRpDurVO;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriRpScpDurVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpProgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaSummryAcceptAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RFAProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2203HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_0003HTMLAction 객체를 생성
	 */
	public ESM_PRI_2203HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCProposalEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri2203Event event = new EsmPri2203Event();
		event.setPropNo(request.getParameter("prop_no"));
		event.setAmdtSeq(request.getParameter("amdt_seq"));
		event.setSvcScpCd(request.getParameter("svc_scp_cd"));
		event.setFicRtTpCd(JSPUtil.getParameter(request, "fic_rt_tp_cd", ""));
		
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpHdrVO((PriRpHdrVO) getVO(request, PriRpHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			PriRpScpRtCmdtRoutVO vo = (PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class);
			event.setPriRpScpRtCmdtRoutVO(vo);
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setPriRpScpRtVO((PriRpScpRtVO) getVO(request, PriRpScpRtVO.class));
		} else if (command.isCommand(FormCommand.SEARCH04)) { 
			event.setPriRpScpAmdtSmryVO((PriRpScpAmdtSmryVO) getVO(request, PriRpScpAmdtSmryVO.class));
		} else if (command.isCommand(FormCommand.SEARCH05)) { //
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH06)) { // Approve Cancel시 Children Basic이 있는지 체크한다.
			event.setPriRpHdrVO((PriRpHdrVO) getVO(request, PriRpHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH07)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
			event.setPriRpScpMnVO((PriRpScpMnVO) getVO(request, PriRpScpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH08)) {
			event.setPriRpScpMnVO((PriRpScpMnVO) getVO(request, PriRpScpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH09)) {
			event.setPriRpScpMnVO((PriRpScpMnVO) getVO(request, PriRpScpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH11)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH12)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH13)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH14)) { // Approve Cancel시 BKG에 데이터가 있는지 조회한다.
			event.setCstApprovalVO((CstApprovalVO) getVO(request, CstApprovalVO.class));
		} else if (command.isCommand(FormCommand.SEARCH15)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH17)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH18)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH19)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH20)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH21)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {	// Main Save
			RfaPropMnVO vo = new RfaPropMnVO();

			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class, "sheet1_"));
			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));
			vo.setPriRpAmdtSmryVOs((PriRpAmdtSmryVO[]) getVOs(request, PriRpAmdtSmryVO.class, "sheet1_"));
			vo.setPriRpDmdtVOs((PriRpDmdtVO[]) getVOs(request, PriRpDmdtVO.class, "sheet1_"));

			vo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet6_"));
			vo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet6_"));
			vo.setPriRpScpProgVOs((PriRpScpProgVO[]) getVOs(request, PriRpScpProgVO.class, "sheet6_"));
			vo.setPriRpScpAmdtSmryVOs((PriRpScpAmdtSmryVO[]) getVOs(request, PriRpScpAmdtSmryVO.class, "sheet6_"));
//
//			String saleLeadOri = request.getParameter("sale_lead_ori");
			String cpPriMnFlag = request.getParameter("cpPriMnFlag");
			String arbiExecSvcScpCd = request.getParameter("arbiExecSvcScpCd");
			String arbiAddOnType = request.getParameter("arbiAddOnType");
//
			event.setRfaPropMnVO(vo);
//			event.setSaleLeadOri(saleLeadOri);
			event.setCpPriMnFlag(cpPriMnFlag);
//			
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			event.getPriRpComVO().setAddOnFlag(arbiAddOnType);
			event.getPriRpComVO().setExceSvcScpCd(arbiExecSvcScpCd);
			
			//Commodity
			RfaRtPropCmdtVO cmdtVo = new RfaRtPropCmdtVO();
			
			cmdtVo.setPriRpScpRtCmdtHdrVOS((PriRpScpRtCmdtHdrVO[]) getVOs(request, PriRpScpRtCmdtHdrVO.class, "sheet2_"));
			cmdtVo.setPriRpScpRtCmdtVOS((PriRpScpRtCmdtVO[]) getVOs(request, PriRpScpRtCmdtVO.class, "sheet2_"));
			event.setRfaRtPropCmdtVO(cmdtVo);
			
		} else if (command.isCommand(FormCommand.MULTI02)) {	// Route & Summary Save
			RfaRtPropRtVO vo = new RfaRtPropRtVO();
			
			vo.setPriRpScpRtCmdtRoutVO((PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class));
			vo.setPriRpScpRtCmdtRoutVOS((PriRpScpRtCmdtRoutVO[]) getVOs(request, PriRpScpRtCmdtRoutVO.class, "sheet3_"));
			vo.setPriRpScpRtRoutOrgPntVOS((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet7_"));
			vo.setPriRpScpRtRoutOrgViaVOS((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet8_"));
			vo.setPriRpScpRtRoutDestViaVOS((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet9_"));
			vo.setPriRpScpRtRoutDestPntVOS((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet10_"));
			vo.setPriRpScpRtCmdtRnoteVOS((PriRpScpRtCmdtRnoteVO[]) getVOs(request, PriRpScpRtCmdtRnoteVO.class, "sheet12_"));
			vo.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, "sheet4_"));
			vo.setPriRfaNoteConvListVOS((PriRfaNoteConvListVO[]) getVOs(request, PriRfaNoteConvListVO.class, "sheet5_"));

			event.setRfaRtPropRtVO(vo);
			
			// Route & Summary의 APP Note Conversion
			event.setNoteConvMapgId(request.getParameter("note_conv_mapg_id"));
			event.setRsltRoutHdrSmryListVO((RsltRoutHdrSmryListVO) getVO(request, RsltRoutHdrSmryListVO.class, "sheet22_"));
			
		} else if (command.isCommand(FormCommand.MULTI03)) { // Request
			RfaPropProgVO vo = new RfaPropProgVO();
			RfaPropMnVO mnVo = new RfaPropMnVO();

			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));
			mnVo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			mnVo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));
			mnVo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet5_"));
			mnVo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet5_"));

			event.setRfaPropProgVO(vo);
			event.setRfaPropMnVO(mnVo);
			
			String arbiExecSvcScpCd = request.getParameter("arbiExecSvcScpCd");
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			event.getPriRpComVO().setExceSvcScpCd(arbiExecSvcScpCd);
		} else if (command.isCommand(FormCommand.MULTI04)) { // Approve
			RfaPropProgVO vo = new RfaPropProgVO();
			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class));
			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class));
			event.setRfaPropProgVO(vo);
			
		} else if (command.isCommand(FormCommand.MULTI05)) { // Cancel
			RfaPropProgVO vo = new RfaPropProgVO();
			RfaPropMnVO mnVo = new RfaPropMnVO();

			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));

			mnVo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			mnVo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));

			mnVo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet6_"));
			mnVo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet6_"));

			event.setRfaPropProgVO(vo);
			event.setRfaPropMnVO(mnVo);
		} else if (command.isCommand(FormCommand.MULTI06)) { // Accept All
			RfaSummryAcceptAllVO vo = new RfaSummryAcceptAllVO();
			
			vo.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, "sheet1_"));
			vo.setPriRpScpRtCmdtHdrVOS((PriRpScpRtCmdtHdrVO[])getVOs(request, PriRpScpRtCmdtHdrVO.class, "sheet1_"));
			
			event.setRfaSummryAcceptAllVO(vo);
		} else if (command.isCommand(FormCommand.MULTI07)) { //  Accept Cancel all
			event.setPriRpScpRtVO((PriRpScpRtVO) getVO(request, PriRpScpRtVO.class));
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
			event.setPriRpScpRtCmdtRoutVO((PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class));
//		} else if (command.isCommand(FormCommand.MULTI06)) { //  
//			event.setPriRpScpAmdtSmryVO((PriRpScpAmdtSmryVO) getVO(request, PriRpScpAmdtSmryVO.class));
//		} else if (command.isCommand(FormCommand.MULTI07)) {
//			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY03)) {
			event.setPriRpScpRtCmdtRnoteVOS((PriRpScpRtCmdtRnoteVO[]) getVOs(request, PriRpScpRtCmdtRnoteVO.class, ""));
			
			RfaRtPropRtVO vo = new RfaRtPropRtVO();
			vo.setPriRfaNoteConvListVOS((PriRfaNoteConvListVO[]) getVOs(request, PriRfaNoteConvListVO.class, ""));
			event.setRfaRtPropRtVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY04)) {
			event.setPriRpScpRtCmdtRnoteVOS((PriRpScpRtCmdtRnoteVO[]) getVOs(request, PriRpScpRtCmdtRnoteVO.class, ""));
			
			RfaRtPropRtVO vo = new RfaRtPropRtVO();
			vo.setPriRfaNoteConvListVOS((PriRfaNoteConvListVO[]) getVOs(request, PriRfaNoteConvListVO.class, ""));
			event.setRfaRtPropRtVO(vo);
		} else if (command.isCommand(FormCommand.MODIFY05)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
			
			event.setPriRpScpRtRoutOrgPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet7_"));
			event.setPriRpScpRtRoutOrgViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet8_"));
			event.setPriRpScpRtRoutDestViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet9_"));
			event.setPriRpScpRtRoutDestPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet10_"));
			
		} else if (command.isCommand(FormCommand.MODIFY06)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
			
			event.setPriRpScpRtRoutOrgPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet7_"));
			event.setPriRpScpRtRoutOrgViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet8_"));
			event.setPriRpScpRtRoutDestViaVO((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet9_"));
			event.setPriRpScpRtRoutDestPntVO((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet10_"));
			
		} else if (command.isCommand(FormCommand.SEARCH22)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH23)) {
			//CHM-201432700 Retroactive RFA Minimization관련 시스템 개발요청
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));			
		} else if (command.isCommand(FormCommand.SEARCH24)) {
			// CHM-201535165 RFA match back 팝업화면 추가
			event.setPriRpScpMnVO((PriRpScpMnVO) getVO(request, PriRpScpMnVO.class));
		}
		request.setAttribute("Event", event);
		return event;
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