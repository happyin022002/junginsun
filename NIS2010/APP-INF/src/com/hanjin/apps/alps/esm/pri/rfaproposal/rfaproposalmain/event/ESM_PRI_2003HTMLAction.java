/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0003HTMLAction.java
 *@FileTitle : Proposal & Amendment Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.05.08 변영주
 * 1.0 Creation 
  =========================================================
 * History
 * 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리
 * 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
 * 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
 * 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청 
 * 2014.11.25 최성환 [CHM-201432700] Retroactive RFA Minimization관련 시스템 개발요청
 * 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
 * 2015.11.10 SELCMU/김현경 [CHM-201538112] Tariff 변경시 현 RFA 상 Arbitiary 탭 미반영 로직수정
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
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
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.scproposal 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SCProposalSC로 실행요청<br>
 * - SCProposalSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Byeon Young Joo
 * @see SCProposalEvent 참조
 * @since J2EE 1.4
 */

public class ESM_PRI_2003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_PRI_0003HTMLAction 객체를 생성
	 */
	public ESM_PRI_2003HTMLAction() {
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
		EsmPri2003Event event = new EsmPri2003Event();

		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setPriRpHdrVO((PriRpHdrVO) getVO(request, PriRpHdrVO.class));
		} //2103 - Retrieve - SEARCH39
		else if (command.isCommand(FormCommand.SEARCH39)) {
			event.setPriRpHdrVO((PriRpHdrVO) getVO(request, PriRpHdrVO.class));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setPriSpCtrtPtyVO((PriSpCtrtPtyVO) getVO(request, PriSpCtrtPtyVO.class));
		} else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setPriRpAmdtSmryVO((PriRpAmdtSmryVO) getVO(request, PriRpAmdtSmryVO.class));
		} else if (command.isCommand(FormCommand.SEARCH04)) {
			event.setPriRpScpAmdtSmryVO((PriRpScpAmdtSmryVO) getVO(request, PriRpScpAmdtSmryVO.class));
		} else if (command.isCommand(FormCommand.SEARCH05)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH06)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
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
		} else if (command.isCommand(FormCommand.SEARCH14)) {
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
		} else if (command.isCommand(FormCommand.MULTI01)) {
			RfaPropMnVO vo = new RfaPropMnVO();

			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class, "sheet1_"));
			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));
			vo.setPriRpAmdtSmryVOs((PriRpAmdtSmryVO[]) getVOs(request, PriRpAmdtSmryVO.class, "sheet1_"));
			vo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet2_"));
			vo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet2_"));
			vo.setPriRpScpProgVOs((PriRpScpProgVO[]) getVOs(request, PriRpScpProgVO.class, "sheet2_"));
			vo.setPriRpScpAmdtSmryVOs((PriRpScpAmdtSmryVO[]) getVOs(request, PriRpScpAmdtSmryVO.class, "sheet2_"));
			vo.setPriRpDmdtVOs((PriRpDmdtVO[]) getVOs(request, PriRpDmdtVO.class, "sheet1_"));

			String saleLeadOri = request.getParameter("sale_lead_ori");
			String cpPriMnFlag = request.getParameter("cpPriMnFlag");
			String arbiExecSvcScpCd = request.getParameter("arbiExecSvcScpCd");
			String arbiAddOnType = request.getParameter("arbiAddOnType");

			event.setRfaPropMnVO(vo);
			event.setSaleLeadOri(saleLeadOri);
			event.setCpPriMnFlag(cpPriMnFlag);
			
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			event.getPriRpComVO().setAddOnFlag(arbiAddOnType);
			event.getPriRpComVO().setExceSvcScpCd(arbiExecSvcScpCd);

		} //2103 - Save - MULTI11
		else if (command.isCommand(FormCommand.MULTI11)) {
			RfaPropMnVO vo = new RfaPropMnVO();

			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class, "sheet1_"));
			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));
			vo.setPriRpAmdtSmryVOs((PriRpAmdtSmryVO[]) getVOs(request, PriRpAmdtSmryVO.class, "sheet1_"));
			vo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet2_"));
			vo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet2_"));
			vo.setPriRpScpProgVOs((PriRpScpProgVO[]) getVOs(request, PriRpScpProgVO.class, "sheet2_"));
			vo.setPriRpScpAmdtSmryVOs((PriRpScpAmdtSmryVO[]) getVOs(request, PriRpScpAmdtSmryVO.class, "sheet2_"));
			vo.setPriRpDmdtVOs((PriRpDmdtVO[]) getVOs(request, PriRpDmdtVO.class, "sheet1_"));

			String saleLeadOri = request.getParameter("sale_lead_ori");
			String cpPriMnFlag = request.getParameter("cpPriMnFlag");
			String arbiExecSvcScpCd = request.getParameter("arbiExecSvcScpCd");
			String arbiAddOnType = request.getParameter("arbiAddOnType");

			event.setRfaPropMnVO(vo);
			event.setSaleLeadOri(saleLeadOri);
			event.setCpPriMnFlag(cpPriMnFlag);
			
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			event.getPriRpComVO().setAddOnFlag(arbiAddOnType);
			event.getPriRpComVO().setExceSvcScpCd(arbiExecSvcScpCd);
			
		} else if (command.isCommand(FormCommand.MULTI02)) {
			RfaPropProgVO vo = new RfaPropProgVO();
			RfaPropMnVO mnVo = new RfaPropMnVO();

			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));
			mnVo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			mnVo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));
			mnVo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet2_"));
			mnVo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet2_"));

			event.setRfaPropProgVO(vo);
			event.setRfaPropMnVO(mnVo);
			
			String arbiExecSvcScpCd = request.getParameter("arbiExecSvcScpCd");
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			event.getPriRpComVO().setExceSvcScpCd(arbiExecSvcScpCd);
		} else if (command.isCommand(FormCommand.MULTI03)) {
			RfaPropProgVO vo = new RfaPropProgVO();
			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class));
			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class));
			event.setRfaPropProgVO(vo);
		} //2103 - Approve - MULTI13
		else if (command.isCommand(FormCommand.MULTI13)) {
			RfaPropProgVO vo = new RfaPropProgVO();
			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class));
			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class));
			event.setRfaPropProgVO(vo);			
		} else if (command.isCommand(FormCommand.MULTI04)) {
			RfaPropProgVO vo = new RfaPropProgVO();
			RfaPropMnVO mnVo = new RfaPropMnVO();

			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));

			mnVo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			mnVo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));

			mnVo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet2_"));
			mnVo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet2_"));

			event.setRfaPropProgVO(vo);
			event.setRfaPropMnVO(mnVo);
		} else if (command.isCommand(FormCommand.MULTI05)) {
			event.setPriRpAmdtSmryVO((PriRpAmdtSmryVO) getVO(request, PriRpAmdtSmryVO.class));
		} else if (command.isCommand(FormCommand.MULTI06)) {
			event.setPriRpScpAmdtSmryVO((PriRpScpAmdtSmryVO) getVO(request, PriRpScpAmdtSmryVO.class));
		} else if (command.isCommand(FormCommand.MULTI07)) {
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
		} else if (command.isCommand(FormCommand.SEARCH22)) {
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
		} else if (command.isCommand(FormCommand.SEARCH25)) {					//------------------------check Duration for Basic Copy 
			
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
//			event.setPriRpDurVO((PriRpDurVO) getVO(request, PriRpDurVO.class));
			
		} else if (command.isCommand(FormCommand.SEARCH23)) {
			//CHM-201432700 Retroactive RFA Minimization관련 시스템 개발요청
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));			
		} else if (command.isCommand(FormCommand.SEARCH24)) {
			// CHM-201535165 RFA match back 팝업화면 추가
			event.setPriRpScpMnVO((PriRpScpMnVO) getVO(request, PriRpScpMnVO.class));
		} else if (command.isCommand(FormCommand.COMMAND09)) {
			//--------------------------------------------------------------------------------------------
			RfaPropProgVO vo = new RfaPropProgVO();
			RfaPropMnVO mnVo = new RfaPropMnVO();

			vo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			vo.setPriRpProgVOs((PriRpProgVO[]) getVOs(request, PriRpProgVO.class, "sheet1_"));
			vo.setPriRpHdrVOs((PriRpHdrVO[]) getVOs(request, PriRpHdrVO.class,  "sheet1_"));
			
			mnVo.setPriRpMnVOs((PriRpMnVO[]) getVOs(request, PriRpMnVO.class, "sheet1_"));
			mnVo.setPriRpDurVOs((PriRpDurVO[]) getVOs(request, PriRpDurVO.class, "sheet1_"));
			mnVo.setPriRpScpMnVOs((PriRpScpMnVO[]) getVOs(request, PriRpScpMnVO.class, "sheet2_"));
			mnVo.setPriRpScpDurVOs((PriRpScpDurVO[]) getVOs(request, PriRpScpDurVO.class, "sheet2_"));

			event.setRfaPropProgVO(vo);
			event.setRfaPropMnVO(mnVo);
			
			String arbiExecSvcScpCd = request.getParameter("arbiExecSvcScpCd");
			event.setPriRpComVO((PriRpComVO) getVO(request, PriRpComVO.class));
			event.getPriRpComVO().setExceSvcScpCd(arbiExecSvcScpCd);
				
		} else if (command.isCommand(FormCommand.SEARCH30)) {
			// CHM-201642287 Basic RFA용 Amend Check
			event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
	     } else if (command.isCommand(FormCommand.SEARCH26)) {
	            event.setPriRpMnVO((PriRpMnVO) getVO(request, PriRpMnVO.class));
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