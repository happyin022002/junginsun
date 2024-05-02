/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EDS_EAS_0301HTMLAction.java
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 2014-12-05 Do-Hyun Kim
* 1.0 최초 생성
* 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청

=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditBatchVO;
import com.hanjin.apps.alps.esd.eas.psoadvanceaudit.vo.PreAuditListVO;

/**
 * EDS_EAS_0301HTMLAction ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author Do-Hyun Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ESD_EAS_0301HTMLAction extends HTMLActionSupport {

	 
	private static final long serialVersionUID = 1L;
	/**
     * EDS_EAS_0301HTMLAction 객체를 생성
     */
    public ESD_EAS_0301HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdEas0301Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdEas0301Event event = new EsdEas0301Event();
		
		if(command.isCommand(FormCommand.MODIFY01)){
//			PreAuditListVO PreAuditListVO   = new PreAuditListVO();
//			PreAuditListVO[] tcz = null; 
//			tcz = PreAuditListVO.fromRequestGrid(request);
//			event.setPreAuditListVOs(tcz);
			event.setPreAuditListVOs((PreAuditListVO[])getVOs(request, PreAuditListVO.class,""));	
					
		} else if(command.isCommand(FormCommand.MODIFY03)) {	
//			event.setPreAuditListVOs((PreAuditListVO[])getVOs(request, PreAuditListVO.class,""));	
//			event.setPreAuditListVO((PreAuditListVO)getVO(request, PreAuditListVO .class));
			event.setPreAuditBatchVOs((PreAuditBatchVO[])getVOs(request, PreAuditBatchVO.class,""));	
			
		} else if(command.isCommand(FormCommand.SEARCH02) ||command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.COMMAND01) 
				|| command.isCommand(FormCommand.COMMAND02) || command.isCommand(FormCommand.COMMAND03) 
				|| command.isCommand(FormCommand.COMMAND04) || command.isCommand(FormCommand.COMMAND05) 
				|| command.isCommand(FormCommand.COMMAND06)){ 
			
//			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO .class));
//			log.debug("\n rhq="  + event.getSearchConditionVO().getRhq());
//	    	event = new EsdEas0301Event();
			String rhq = JSPUtil.getParameter(request, "rhq", "");
			String office = JSPUtil.getParameter(request, "office", "");
			String period1 = JSPUtil.getParameter(request, "period1", "");
			String period2 = JSPUtil.getParameter(request, "period2", "");
			String chargeType = JSPUtil.getParameter(request, "charge_type", "");
			String accountCode = JSPUtil.getParameter(request, "acct_cd", "");
			String costCode = JSPUtil.getParameter(request, "cost_cd", "");
			String portCode = JSPUtil.getParameter(request, "port_cd", "");
			String spNo = JSPUtil.getParameter(request, "spcode", "");
			String auditStatus = JSPUtil.getParameter(request, "audit_status", "");
			String contractType = JSPUtil.getParameter(request, "contract_type", "");
			String yardCd = JSPUtil.getParameter(request, "yard_cd", "");
			String vesselClass = JSPUtil.getParameter(request, "vessel_class", "");
			String vessel = JSPUtil.getParameter(request, "vessel", "");
			String diff = JSPUtil.getParameter(request, "diff", "");
			String diffNum = JSPUtil.getParameter(request, "diff_num", "");
			String csrNo = JSPUtil.getParameter(request, "csr_no", "");
			String invNo = JSPUtil.getParameter(request, "inv_no", "");
			String ifStatus = JSPUtil.getParameter(request, "if_status", "");
			String remark = JSPUtil.getParameter(request, "remark", "");
			String divChargeType = JSPUtil.getParameter(request, "divChargeType", "");
			String sExpnAudStsCd = JSPUtil.getParameter(request, "s_expn_aud_sts_cd", "");
			String portlChargeType = JSPUtil.getParameter(request, "portlChargeType", "");
			String serviceChargeType = JSPUtil.getParameter(request, "serviceChargeType", "");
			String canalChargeType = JSPUtil.getParameter(request, "canalChargeType", "");
			String otherChargeType = JSPUtil.getParameter(request, "otherChargeType", "");
			
			event.setRhq(rhq);
			event.setOffice(office);
			event.setPeriod1(period1);
			event.setPeriod2(period2);
			event.setChargeType(chargeType);
			event.setAccountCode(accountCode);
			event.setCostCode(costCode);
			event.setPortCode(portCode);
			event.setSpNo(spNo);
			event.setAuditStatus(auditStatus);
			event.setContractType(contractType);
			event.setYardCd(yardCd);
			event.setVesselClass(vesselClass);
			event.setDiff(diff);
			event.setDiffNum(diffNum);
			event.setCsrNo(csrNo);
			event.setInvNo(invNo);
			event.setIfStatus(ifStatus);
			event.setVessel(vessel);
			event.setRemark(remark);
			event.setDivChargeType(divChargeType);
			event.setSExpnAudStsCd(sExpnAudStsCd);
			event.setPortlChargeType(portlChargeType);
			event.setServiceChargeType(serviceChargeType);
			event.setCanalChargeType(canalChargeType);
			event.setOtherChargeType(otherChargeType);
			
		}
		
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
