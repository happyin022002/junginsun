/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UI_PRI_0030HTMLAction.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;

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

public class ESM_PRI_0003_08HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_PRI_0030HTMLAction 객체를 생성
	 */
	public ESM_PRI_0003_08HTMLAction() {
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
		EsmPri000308Event event = new EsmPri000308Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriSpScpRtCmdtHdrVO((PriSpScpRtCmdtHdrVO) getVO(request, PriSpScpRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			PriSpScpRtCmdtRoutVO vo = (PriSpScpRtCmdtRoutVO) getVO(request, PriSpScpRtCmdtRoutVO.class);
			vo.setNoteDpSeq(request.getParameter("cmdt_row_seq"));
			event.setPriSpScpRtCmdtRoutVO(vo);
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setPriSpScpRtVO((PriSpScpRtVO) getVO(request, PriSpScpRtVO.class));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setPriSpScpRtCmdtHdrVO((PriSpScpRtCmdtHdrVO) getVO(request, PriSpScpRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH11)) {
			event.setPriSpScpRtCmdtHdrVO((PriSpScpRtCmdtHdrVO) getVO(request, PriSpScpRtCmdtHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH12)) {
			event.setScGlineCopyVO((ScGlineCopyVO) getVO(request, ScGlineCopyVO.class));
		} else if (command.isCommand(FormCommand.SEARCH15)) {
			PriSpScpRtCmdtHdrVO cmdtHdr = (PriSpScpRtCmdtHdrVO) getVO(request, PriSpScpRtCmdtHdrVO.class);

			String all = request.getParameter("reload_all");
			if (all != null && "Y".equals(all)) {
				cmdtHdr.setCmdtHdrSeq("");
			}
			event.setPriSpScpRtCmdtHdrVO(cmdtHdr);
			event.setPriSpScpRtCmdtRoutVO((PriSpScpRtCmdtRoutVO) getVO(request, PriSpScpRtCmdtRoutVO.class));
		} else if (command.isCommand(FormCommand.SEARCH20)) {
			event.setPriSpScpRtVO((PriSpScpRtVO) getVO(request, PriSpScpRtVO.class));
		} else if (command.isCommand(FormCommand.MULTI01)) {
			ScRtPropCmdtVO vo = new ScRtPropCmdtVO();

			vo.setPriSpScpRtCmdtHdrVOS((PriSpScpRtCmdtHdrVO[]) getVOs(request, PriSpScpRtCmdtHdrVO.class, "sheet1_"));
			vo.setPriSpScpRtCmdtVOS((PriSpScpRtCmdtVO[]) getVOs(request, PriSpScpRtCmdtVO.class, "sheet4_"));
			vo.setPriSpScpRtActCustVOS((PriSpScpRtActCustVO[]) getVOs(request, PriSpScpRtActCustVO.class, "sheet5_"));
			vo.setPriSpScpRtCnoteVOS((PriSpScpRtCnoteVO[]) getVOs(request, PriSpScpRtCnoteVO.class, "sheet6_"));

			event.setScRtPropCmdtVO(vo);
			event.setPropNo(request.getParameter("prop_no"));
			event.setAmdtSeq(request.getParameter("amdt_seq"));
			event.setSvcScpCd(request.getParameter("svc_scp_cd"));
			event.setGenSpclRtTpCd(request.getParameter("gen_spcl_rt_tp_cd"));
		} else if (command.isCommand(FormCommand.MULTI02)) {
			ScRtPropRtVO vo = new ScRtPropRtVO();

			vo.setPriSpScpRtCmdtRoutVO((PriSpScpRtCmdtRoutVO) getVO(request, PriSpScpRtCmdtRoutVO.class));
			vo.setPriSpScpRtCmdtRoutVOS((PriSpScpRtCmdtRoutVO[]) getVOs(request, PriSpScpRtCmdtRoutVO.class, "sheet2_"));
			vo.setPriSpScpRtRoutOrgPntVOS((PriSpScpRtRoutPntVO[]) getVOs(request, PriSpScpRtRoutPntVO.class, "sheet7_"));
			vo.setPriSpScpRtRoutOrgViaVOS((PriSpScpRtRoutViaVO[]) getVOs(request, PriSpScpRtRoutViaVO.class, "sheet8_"));
			vo.setPriSpScpRtRoutDestViaVOS((PriSpScpRtRoutViaVO[]) getVOs(request, PriSpScpRtRoutViaVO.class, "sheet9_"));
			vo.setPriSpScpRtRoutDestPntVOS((PriSpScpRtRoutPntVO[]) getVOs(request, PriSpScpRtRoutPntVO.class, "sheet10_"));
			vo.setPriSpScpRtRoutDirVOS((PriSpScpRtRoutDirVO[]) getVOs(request, PriSpScpRtRoutDirVO.class, "sheet11_"));
			vo.setPriSpScpRtCmdtRnoteVOS((PriSpScpRtCmdtRnoteVO[]) getVOs(request, PriSpScpRtCmdtRnoteVO.class, "sheet12_"));
			vo.setPriSpScpRtVOS((PriSpScpRtVO[]) getVOs(request, PriSpScpRtVO.class, "sheet3_"));
			
			event.setScRtPropRtVO(vo);
			event.setPropNo(request.getParameter("prop_no"));
			event.setAmdtSeq(request.getParameter("amdt_seq"));
			event.setSvcScpCd(request.getParameter("svc_scp_cd"));
			event.setGenSpclRtTpCd(request.getParameter("gen_spcl_rt_tp_cd"));
		} else if (command.isCommand(FormCommand.MODIFY01)) {
			event.setPriSpScpRtVOS((PriSpScpRtVO[]) getVOs(request, PriSpScpRtVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY02)) {
			event.setPriSpScpRtVOS((PriSpScpRtVO[]) getVOs(request, PriSpScpRtVO.class, ""));
		} else if (command.isCommand(FormCommand.MODIFY11)) {
			event.setPriSpScpRtVO((PriSpScpRtVO) getVO(request, PriSpScpRtVO.class));
		} else if (command.isCommand(FormCommand.MODIFY12)) {
			event.setScGlineCopyVO((ScGlineCopyVO) getVO(request, ScGlineCopyVO.class));
		} else if(command.isCommand(FormCommand.SEARCH04)) { //Calculate
			PriSpScpRtCmdtRoutVO vo = (PriSpScpRtCmdtRoutVO) getVO(request, PriSpScpRtCmdtRoutVO.class);
			event.setPriSpScpRtCmdtRoutVO(vo);
		} else if(command.isCommand(FormCommand.SEARCH05)) { //Calculate
			PriSpScpRtCmdtRoutVO vo = (PriSpScpRtCmdtRoutVO) getVO(request, PriSpScpRtCmdtRoutVO.class);
			event.setPriSpScpRtCmdtRoutVO(vo);
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