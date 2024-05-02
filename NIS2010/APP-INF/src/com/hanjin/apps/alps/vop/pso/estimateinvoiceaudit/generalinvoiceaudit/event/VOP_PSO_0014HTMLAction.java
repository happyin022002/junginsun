/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0014HTMLAction.java
*@FileTitle : Invoice Creation N' Audit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.19
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2009.08.28 김진일
* 1.0 Creation
* History
* 2012.11.19 이혜민 CHM-201221185-01 	[PSO] 항비 입력시 skip port 에 대한 pop up 메시지 추가 요청
* 2013.01.24 SKY    CHM-201322525    	Invoice creation 중복 account code 체크 로직 추가
* 2014.05.30 박다은 [CHM-201430328] 	[PSO] Port Charge invoice Creation 기능 개선
* 2014.08.05 이성훈 CHM-201430972 		[PSO] Invoice내 Exchanage Rate 칼럼 추가
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.InvAuditDataValidVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EstimateInvoiceAuditSC로 실행요청<br>
 * - EstimateInvoiceAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jin Ihl
 * @see EstimateInvoiceAuditEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0014HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0014HTMLAction 객체를 생성
	 */
	public VOP_PSO_0014HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EstimateInvoiceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0014Event event = new VopPso0014Event();
		
		if(command.isCommand(FormCommand.COMMAND04)) {//Grid input VVD체크 
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));
			event.setYdCd(request.getParameter("yd_cd"));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {//Confirm Button Click 
			event.setInvAuditDataValidVO((InvAuditDataValidVO)getVO(request, InvAuditDataValidVO .class));
//			InvAuditDataValidVO vo = event.getInvAuditDataValidVO(); 
//			vo.setIssDt(request.getParameter("iss_dt"));
//			vo.setYdCd(request.getParameter("yd_cd"));
			//sAVE처리와 같은 처리 
			event.setAuditDataValidVOs((InvAuditDataValidVO[])getVOs(request, InvAuditDataValidVO.class,"sheet1_"));
			InvAuditDataValidVO[] vos = event.getAuditDataValidVOs();
			if(vos!=null){
				if(vos.length>0){//Master 정보 설정 
					vos[0].setYdCd(request.getParameter("yd_cd"));
					vos[0].setVndrSeq(request.getParameter("spcode"));
					vos[0].setCostOfcCd(request.getParameter("cost_ofc"));
					vos[0].setInvOfcCd(request.getParameter("inv_ofc_cd"));
					vos[0].setInvNo(request.getParameter("inv_no"));
					vos[0].setCurrCd(request.getParameter("curr_cd"));
					vos[0].setTtlLoclAmt(request.getParameter("ttl_loc_amt"));
					vos[0].setInvLoclAmt(request.getParameter("inv_amt"));
					vos[0].setLoclTaxAmt(request.getParameter("vat"));
					vos[0].setLoclWhldTaxAmt(request.getParameter("whld_tax"));	//[2010.04.09] add
					vos[0].setLoclNetAmt(request.getParameter("net_amt"));		//[2010.04.09] add
					vos[0].setLoclDdctAmt(request.getParameter("ddt_amt"));		//[2010.04.09] add
					vos[0].setAcptDt(request.getParameter("rcv_dt"));
					vos[0].setIssDt(request.getParameter("iss_dt"));
					vos[0].setEffDt(request.getParameter("eff_dt"));
					vos[0].setUpdateflag(request.getParameter("updateflag"));
					vos[0].setPsoTrnsSlpCtnt(request.getParameter("trnsf_slp")== null ? "N":"Y");//2009.11.23 추가 컬럼
				}
				String usrId = request.getParameter("usr_id");
				for(int i=0;i<vos.length;i++){
					vos[i].setUsrId(usrId);
				}
			}
		}
		else if(command.isCommand(FormCommand.COMMAND03)) {//VVD Leve Check 
			event.setInvAuditDataValidVO((InvAuditDataValidVO)getVO(request, InvAuditDataValidVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND05)) {//Grid Row 단위 Calculation
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));
			event.setVndrSeq(request.getParameter("spcode"));
			event.setLgsCostCd(request.getParameter("cost_cd"));
			event.setIssDt(request.getParameter("iss_dt"));
			event.setYdCd(request.getParameter("yd_cd"));
			event.setCurrCd(request.getParameter("curr_cd"));
			event.setIoFlag(request.getParameter("io_flag"));
			event.setRowIdx(request.getParameter("rowIdx"));
			//event.setPsoTrnsSlpCtnt(request.getParameter("trnsf_slp") == null ? "N":"Y");//2009.11.23 추가 컬럼
//			event.setAuditDataValidVOs((InvAuditDataValidVO[])getVOs(request, InvAuditDataValidVO.class,"sheet1_"));
			event.setInvAuditDataValidVO((InvAuditDataValidVO)getVO(request, InvAuditDataValidVO .class));
			event.getInvAuditDataValidVO().setPsoTrnsSlpCtnt(request.getParameter("trnsf_slp") == null ? "N":"Y");//2009.12.11 error fix
		}
		else if(command.isCommand(FormCommand.COMMAND06)) {//IssueDate 선택 시 
			event.setIssDt(request.getParameter("iss_dt"));
			event.setRcvDt(request.getParameter("rcv_dt"));
		}
		else if(command.isCommand(FormCommand.COMMAND07)) {//CHCEK된 로우만 Calculation
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));
			event.setVndrSeq(request.getParameter("spcode"));
			event.setLgsCostCd(request.getParameter("cost_cd"));
			event.setIssDt(request.getParameter("iss_dt"));
			event.setYdCd(request.getParameter("yd_cd"));
			event.setCurrCd(request.getParameter("curr_cd"));
			event.setIoFlag(request.getParameter("io_flag"));
			event.setAuditDataValidVOs((InvAuditDataValidVO[])getVOs(request, InvAuditDataValidVO.class,"sheet1_"));
		}
		else if(command.isCommand(FormCommand.COMMAND08)) {//InvNo. Focus Out 시 
			event.setVndrSeq(request.getParameter("spcode"));
			event.setInvNo(request.getParameter("inv_no"));
		}
		else if(command.isCommand(FormCommand.COMMAND09)) {//Yard Skip Check
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));
			event.setYdCd(request.getParameter("yd_cd"));
		}
		else if(command.isCommand(FormCommand.COMMAND10)) {// Double pay Check
			event.setVslCd(request.getParameter("vsl_cd"));
			event.setSkdVoyNo(request.getParameter("skd_voy_no"));
			event.setSkdDirCd(request.getParameter("skd_dir_cd"));
			event.setLgsCostCd(request.getParameter("cost_cd"));
			event.setVndrSeq(request.getParameter("vndr_seq"));
			event.setCostOfcCd(request.getParameter("cost_ofc"));
			event.setYdCd(request.getParameter("yd_cd"));
		
		}
		else if(command.isCommand(FormCommand.COMMAND11)) {// S/P Code 변경시
			event.setVndrSeq(request.getParameter("vndr_seq"));
		}		
		else if(command.isCommand(FormCommand.COMMAND12)) {// tonnage 유무
			event.setVndrSeq(request.getParameter("spcode"));
			event.setInvNo(request.getParameter("inv_no"));
		}	
		else if(command.isCommand(FormCommand.COMMAND13)) {// tug boat 사용 유무  계정 확인 2015-06-18
			event.setVndrSeq(request.getParameter("vndr_seq"));
			event.setYdCd(request.getParameter("yd_cd"));
			event.setLgsCostCd(request.getParameter("cost_cd"));
			event.setIssDt(request.getParameter("iss_dt"));
		}	
		else if(command.isCommand(FormCommand.COMMAND14)) {// BAF 사용 유무  계정 확인 2015-12-18
			event.setVndrSeq(request.getParameter("vndr_seq"));
			event.setYdCd(request.getParameter("yd_cd"));
			event.setLgsCostCd(request.getParameter("cost_cd"));
			event.setIssDt(request.getParameter("iss_dt"));
		}
		else if(command.isCommand(FormCommand.SEARCH)||command.isCommand(FormCommand.SEARCH02)) {
			event.setInvAuditDataValidVO((InvAuditDataValidVO)getVO(request, InvAuditDataValidVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {//Save Button Click 시 
			event.setAuditDataValidVOs((InvAuditDataValidVO[])getVOs(request, InvAuditDataValidVO.class,"sheet1_"));
			InvAuditDataValidVO[] vos = event.getAuditDataValidVOs(); 
			if(vos.length>0){//Master 정보 설정 
				vos[0].setYdCd(request.getParameter("yd_cd"));
				vos[0].setVndrSeq(request.getParameter("spcode"));
				vos[0].setCostOfcCd(request.getParameter("cost_ofc"));
				vos[0].setInvOfcCd(request.getParameter("inv_ofc_cd"));
				vos[0].setInvNo(request.getParameter("inv_no"));
				vos[0].setCurrCd(request.getParameter("curr_cd"));
				vos[0].setTtlLoclAmt(request.getParameter("ttl_loc_amt"));
				vos[0].setInvLoclAmt(request.getParameter("inv_amt"));
				vos[0].setLoclTaxAmt(request.getParameter("vat"));
				vos[0].setLoclWhldTaxAmt(request.getParameter("whld_tax"));	//[2010.04.07] add
				vos[0].setLoclNetAmt(request.getParameter("net_amt"));		//[2010.04.07] add
				vos[0].setLoclDdctAmt(request.getParameter("ddt_amt"));		//[2010.04.07] add
				vos[0].setAcptDt(request.getParameter("rcv_dt"));
				vos[0].setIssDt(request.getParameter("iss_dt"));
				vos[0].setEffDt(request.getParameter("eff_dt"));
				vos[0].setUpdateflag(request.getParameter("updateflag"));
				vos[0].setPsoTrnsSlpCtnt(request.getParameter("trnsf_slp") == null ? "N":"Y");//2009.11.23 추가 컬럼
			}
			String usrId = request.getParameter("usr_id");
			for(int i=0;i<vos.length;i++){
				vos[i].setUsrId(usrId);
			}
		}
		else if(command.isCommand(FormCommand.REMOVE)) {//Delete Button Click 시 
			event.setInvAuditDataValidVO((InvAuditDataValidVO)getVO(request, InvAuditDataValidVO .class));
			event.setVndrSeq(request.getParameter("spcode"));
			event.setYdCd(request.getParameter("yd_cd"));
			event.setInvNo(request.getParameter("inv_no"));
			event.setPsoChgStsCd(request.getParameter("pso_chg_sts_cd"));
			//
			event.setAuditDataValidVOs((InvAuditDataValidVO[])getVOs(request, InvAuditDataValidVO.class,"sheet1_"));
			InvAuditDataValidVO[] vos = event.getAuditDataValidVOs();
			if(vos!=null){
				if(vos.length>0){//Master 정보 설정 
					vos[0].setYdCd(request.getParameter("yd_cd"));
					vos[0].setVndrSeq(request.getParameter("spcode"));
					vos[0].setCostOfcCd(request.getParameter("cost_ofc"));
					vos[0].setInvOfcCd(request.getParameter("inv_ofc_cd"));
					vos[0].setInvNo(request.getParameter("inv_no"));
					vos[0].setCurrCd(request.getParameter("curr_cd"));
					vos[0].setTtlLoclAmt(request.getParameter("ttl_loc_amt"));
					vos[0].setLoclAmt(request.getParameter("inv_amt"));
					vos[0].setLoclTaxAmt(request.getParameter("vat"));
					vos[0].setLoclNetAmt(request.getParameter("net_amt"));
					vos[0].setAcptDt(request.getParameter("rcv_dt"));
					vos[0].setIssDt(request.getParameter("iss_dt"));
					vos[0].setEffDt(request.getParameter("eff_dt"));
					vos[0].setUpdateflag(request.getParameter("updateflag"));
					vos[0].setPsoTrnsSlpCtnt(request.getParameter("trnsf_slp")== null ? "N":"Y");//2009.11.23 추가 컬럼
				}
				String usrId = request.getParameter("usr_id");
				for(int i=0;i<vos.length;i++){
					vos[i].setUsrId(usrId);
				}
			}
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