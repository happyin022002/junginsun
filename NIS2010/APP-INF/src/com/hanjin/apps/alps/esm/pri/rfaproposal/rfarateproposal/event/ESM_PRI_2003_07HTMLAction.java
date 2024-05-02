/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2003_07HTMLAction.java
 *@FileTitle : RFA Proposal Creation - Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.21 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scguideline 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCGuidelineSC로 실행요청<br>
 * - SCGuidelineSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Sungsoo, Park
 * @see SCGuidelineEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2003_07HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_PRI_0030HTMLAction 객체를 생성
	 */
	public ESM_PRI_2003_07HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SCGuidelineEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmPri200307Event event = new EsmPri200307Event();
		event.setFicRtTpCd(JSPUtil.getParameter(request, "fic_rt_tp_cd", ""));
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			PriRpScpRtCmdtRoutVO vo = (PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class);
			vo.setNoteDpSeq(request.getParameter("cmdt_row_seq"));
			event.setPriRpScpRtCmdtRoutVO(vo);
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setPriRpScpRtVO((PriRpScpRtVO) getVO(request, PriRpScpRtVO.class));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH11)) {
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH12)) {
			event.setRfaGlineCopyVO((RfaGlineCopyVO) getVO(request, RfaGlineCopyVO.class));
		} else if (command.isCommand(FormCommand.SEARCH15)) {
			PriRpScpRtCmdtHdrVO cmdtHdr = (PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class);

			String all = request.getParameter("reload_all");
			if (all != null && "Y".equals(all)) {
				cmdtHdr.setCmdtHdrSeq("");
			}
			event.setPriRpScpRtCmdtHdrVO(cmdtHdr);
			event.setPriRpScpRtCmdtRoutVO((PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class));
		} else if (command.isCommand(FormCommand.SEARCH20)) {
			event.setPriRpScpRtVO((PriRpScpRtVO) getVO(request, PriRpScpRtVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			RfaRtPropCmdtVO vo = new RfaRtPropCmdtVO();

			vo.setPriRpScpRtCmdtHdrVOS((PriRpScpRtCmdtHdrVO[]) getVOs(request, PriRpScpRtCmdtHdrVO.class, "sheet1_"));
			vo.setPriRpScpRtCmdtVOS((PriRpScpRtCmdtVO[]) getVOs(request, PriRpScpRtCmdtVO.class, "sheet4_"));
			vo.setPriRpScpRtActCustVOS((PriRpScpRtActCustVO[]) getVOs(request, PriRpScpRtActCustVO.class, "sheet5_"));
			vo.setPriRpScpRtCnoteVOS((PriRpScpRtCnoteVO[]) getVOs(request, PriRpScpRtCnoteVO.class, "sheet6_"));
			vo.setPriRfaNoteConvListVOS((PriRfaNoteConvListVO[]) getVOs(request, PriRfaNoteConvListVO.class, "sheet15_"));

			event.setRfaRtPropCmdtVO(vo);
			event.setPropNo(request.getParameter("prop_no"));
			event.setAmdtSeq(request.getParameter("amdt_seq"));
			event.setSvcScpCd(request.getParameter("svc_scp_cd"));			
		} else if (command.isCommand(FormCommand.MULTI02)) {
			RfaRtPropRtVO vo = new RfaRtPropRtVO();

			vo.setPriRpScpRtCmdtRoutVO((PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class));
			vo.setPriRpScpRtCmdtRoutVOS((PriRpScpRtCmdtRoutVO[]) getVOs(request, PriRpScpRtCmdtRoutVO.class, "sheet2_"));
			vo.setPriRpScpRtRoutOrgPntVOS((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet7_"));
			vo.setPriRpScpRtRoutOrgViaVOS((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet8_"));
			vo.setPriRpScpRtRoutDestViaVOS((PriRpScpRtRoutViaVO[]) getVOs(request, PriRpScpRtRoutViaVO.class, "sheet9_"));
			vo.setPriRpScpRtRoutDestPntVOS((PriRpScpRtRoutPntVO[]) getVOs(request, PriRpScpRtRoutPntVO.class, "sheet10_"));
			vo.setPriRpScpRtCmdtRnoteVOS((PriRpScpRtCmdtRnoteVO[]) getVOs(request, PriRpScpRtCmdtRnoteVO.class, "sheet12_"));
			vo.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, "sheet3_"));
			vo.setPriRfaNoteConvListVOS((PriRfaNoteConvListVO[]) getVOs(request, PriRfaNoteConvListVO.class, "sheet16_"));

			event.setRfaRtPropRtVO(vo);
			event.setPropNo(request.getParameter("prop_no"));
			event.setAmdtSeq(request.getParameter("amdt_seq"));
			event.setSvcScpCd(request.getParameter("svc_scp_cd"));
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriRpScpRtVOS((PriRpScpRtVO[]) getVOs(request, PriRpScpRtVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY11)) {
			event.setPriRpScpRtVO((PriRpScpRtVO) getVO(request, PriRpScpRtVO.class));
			event.setPriRpScpRtCmdtHdrVO((PriRpScpRtCmdtHdrVO) getVO(request, PriRpScpRtCmdtHdrVO.class));			
		} else if (command.isCommand(FormCommand.MODIFY12)) {
			event.setRfaGlineCopyVO((RfaGlineCopyVO) getVO(request, RfaGlineCopyVO.class));
		} else if(command.isCommand(FormCommand.SEARCH04)) { //Calculate
			PriRpScpRtCmdtRoutVO vo = (PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class);
			event.setPriRpScpRtCmdtRoutVO(vo);
		} else if(command.isCommand(FormCommand.SEARCH05)) { //Calculate
			PriRpScpRtCmdtRoutVO vo = (PriRpScpRtCmdtRoutVO) getVO(request, PriRpScpRtCmdtRoutVO.class);
			event.setPriRpScpRtCmdtRoutVO(vo);
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