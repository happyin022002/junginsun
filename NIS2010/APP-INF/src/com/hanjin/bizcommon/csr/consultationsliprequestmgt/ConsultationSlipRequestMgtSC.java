/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConsultationSlipRequestMgtSC.java
*@FileTitle : CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.01 함대성
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.08.31 김영철 [] R4J 에서 메소드 주석 수정부분 수정함.
* 2011.01.06 김영철 [] R4J 에서 Console의 메시지를 점검한다. 
*                   ( ex.printStackTrace(); -> log.error("err"+ex.toString(),ex); )
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
* 2015.03.13 심성윤 [COM_CSR_0015] Alps Data 처리 관련 로직 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBC;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBCImpl;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalRequestVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic.AGTAuditBC;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic.AGTAuditBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.bizcommon.approval.basic.ApprovalBC;
import com.hanjin.bizcommon.approval.basic.ApprovalBCImpl;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0001Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0002Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0004Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0008Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0011Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0014Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event.ComCsr0015Event;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration.ConsultationSlipRequestMgtDBDAO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.ApPayInvListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AutoRevVVDListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOhdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOlistVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CheckAsaVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.DtrbListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.HdrDtrGrpVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.HdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.SearchDTRBTtlVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.TAXInfoVO;
import com.hanjin.bizcommon.csr.csrapproval.basic.ComCsrApprovalBC;
import com.hanjin.bizcommon.csr.csrapproval.basic.ComCsrApprovalBCImpl;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBC;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;


/**
 * ALPS-ConsultationSlipRequestMgt Business Logic ServiceCommand - ALPS-ConsultationSlipRequestMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author HAM DAE SUNG
 * @see ConsultationSlipRequestMgtDBDAO
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount signOnUserAccount = null;

	/**
	 * ConsultationSlipRequestMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ConsultationSlipRequestMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			signOnUserAccount = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ConsultationSlipRequestMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ConsultationSlipRequestMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ConsultationSlipRequestMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("ComCsr0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCsrList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkAsaOffice(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("ComCsr0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCSRSummaryDetail(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchAsaNoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = approvalRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPreVeiw(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = verifyInvoiceDeltChk(e);	
			}
			/* BackEndJob 상태조회 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAccrualBackEndJobStatus(e);
			}
			/* BackEndJob 결과조회 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				try{
					eventResponse = searchAccrualBackEndJobResult(e);
				}catch(BackEndJobException ex){
					throw new EventException(ex.getMessage());
				}
			}/*결재유형 변경(ALPS->GW) Office인지 확인 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAl2GwOfc(e);	
			}
		}
		if (e.getEventName().equalsIgnoreCase("ComCsr0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTAXInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchApEviNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCompNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchEviCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTAXCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = getDefOfc(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("ComCsr0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCsrIfList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiConfirmCSR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = cancelCSR(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = tmpSearchPreVeiw(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI10)) {	//GW URL open
				eventResponse = manageApplication(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {  //GW Result
				eventResponse = manageGwStatus(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {	//3만불 이하 ALPS 결재
				eventResponse = approvalStep(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) { //3만불 이하 결재자 정보
				eventResponse = getApprovalRoute(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("ComCsr0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSOlist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSOhdr(e);
			}
		} 
		if (e.getEventName().equalsIgnoreCase("ComCsr0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSOlist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiRejectedCSRCancellation(e);
			}
		} 
		if (e.getEventName().equalsIgnoreCase("ComCsr0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchErpInterfaceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = erpInterface(e);
			}
		} 
		
		return eventResponse;
	}
 
	/**
	 * COM_CSR_0001 : 조회버튼 <br>
	 * CSR Creation의 리스트를 조회합니다
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrList (Event e) throws EventException {
        try{
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
			ComCsr0001Event event = (ComCsr0001Event)e;
			ApPayInvListVO apPayInvListVO = event.getApPayInvListVO();
			
			List<ApPayInvListVO> list = command.searchCsrList (apPayInvListVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse; 
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	
	/**
	 * CSR_0001 : 화면로드<br>
	 * CSR Creation의  A/P, ASA 체크<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkAsaOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();    
		// PDTO(Data Transfer Object including Parameters)
        try{
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
			
			ComCsr0001Event event = (ComCsr0001Event)e;
			CheckAsaVO     vo = event.getCheckAsaVO(); 
			CheckAsaVO     checkAsaVO2 = null; 
			
			checkAsaVO2 = command.checkAsaOffice(vo);
			
			if(checkAsaVO2 != null){
				Map<String, String> mapVO = checkAsaVO2.getColumnValues();
				eventResponse.setETCData(mapVO);
			}
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0002 : 조회버튼 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail (Event e) throws EventException {
        try{
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
			ComCsr0002Event event = (ComCsr0002Event)e;
			CsrListInputVO csrListInputVO = event.getCsrListInputVO();
			
			List<CsrListInputVO> list = command.searchCSRSummaryDetail (csrListInputVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse; 
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * COM_CSR_0002 : 인보이스 삭제여부 체크 <br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyInvoiceDeltChk(Event e) throws EventException {
        try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
        	ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
			ComCsr0002Event event = (ComCsr0002Event)e;
			CsrListInputVO[] csrListInputVOs = event.getCsrListInputVOs();
			String inv_no = "";
			boolean firt_data = true;
			
			eventResponse.setETCData("inv_no","");
			
			for(int i =0;i<csrListInputVOs.length;i++){
				if(firt_data){
					inv_no = command.verifyInvoiceDeltChk(csrListInputVOs[i].getInvRgstNo());
					if(!inv_no.equals("")){
						eventResponse.setETCData("inv_no",inv_no);
						firt_data = false;
					}
				}	
			}
			
			return eventResponse; 
			
        } catch (EventException ex) {
        	log.error("err"+ex.toString(),ex);
        	throw new EventException(ex.getMessage(), ex);
      } catch (Exception ex) {
      		log.error("err"+ex.toString(),ex);
      		throw new EventException(ex.getMessage(), ex);
      }
	}
	
	/**
	 * COM_CSR_0002 : 결재 유형 변경 Office인지 확인 (ALPS->GW) <br>
	 * Approval Type 설정용
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAl2GwOfc(Event e) throws EventException {
        try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
        	ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
        	ComCsr0002Event event = (ComCsr0002Event)e;
			
			String retVal = "";
			
			//csrParmVO.setOfcCd(signOnUserAccount.getOfc_cd());
			
			String ofcCd = signOnUserAccount.getOfc_cd();
			String csrNo = event != null?event.getCsrNo():""; 
			eventResponse.setETCData("CN_OFC_CHK","");
			
			retVal = command.searchAl2GwOfc(ofcCd, csrNo);
			if(!retVal.equals("")){
				eventResponse.setETCData("CN_OFC_CHK",retVal);
				log.error("\n\n CN_OFC_CHK:>>"+retVal+"<<------CSR_NO:"+csrNo+"--Office:"+ofcCd+"\n\n");
			}
			
			return eventResponse; 
			
        } catch (EventException ex) {
        	log.error("err"+ex.toString(),ex);
        	throw new EventException(ex.getMessage(), ex);
      } catch (Exception ex) {
      		log.error("err"+ex.toString(),ex);
      		throw new EventException(ex.getMessage(), ex);
      }
	}
	
	
	/**
	 * COM_CSR_0002 : 화면 로드
	 * CSR Creation(Detail)의 asa_no 콤보리스트 조회합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAsaNoList(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			AsaNoVO   asaNoVO = null;
			ComCsr0002Event event =null;
			if(e.getEventName().equalsIgnoreCase("ComCsr0002Event")){
				event = (ComCsr0002Event)e;
//				asaNoVO = event.getAsaNoVO();
			}
			
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
	
//			String costOfcCd 	 = asaNoVO.getCostOfcCd()==null?"":asaNoVO.getCostOfcCd(); 
			String invOfcCd  =  event != null?event.getInvOfcCd():""; 
			String apOfcCd 	 =  event != null?event.getApOfcCd():""; 
			String issDt 	 =  event != null?event.getIssDt():""; 
			
			List<AsaNoVO> list = command.searchAsaNoList(invOfcCd, apOfcCd, issDt);
			
			String comboList = makeComboString(list, 1);
			eventResponse.setETCData("asa_no" ,comboList);
			
			return eventResponse;
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }  
	}

	/**
	 * COM_CSR_0004 : 화면 로드
	 * EviCode 콤보리스트 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws Exception 
	 */
	private EventResponse searchEviCodeList(Event e) throws EventException { 
        try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			TAXInfoVO   vo = null;
			if(e.getEventName().equalsIgnoreCase("ComCsr0004Event")){
				ComCsr0004Event event = (ComCsr0004Event)e;
				vo = event.getTAXInfoVO();
			}
			
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
	
			List<TAXInfoVO> list = command.searchEviCodeList();
			
			String comboList = makeComboString2(list, 1);
			eventResponse.setETCData("tax_no2" ,comboList);
			return eventResponse;
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * COM_CSR_0004 : 화면로드 또는 사업자등록번호 기입 <br>
	 * 사업자등록번호, Vendor Code, 상호, 업태, 주소, 대표자명 조회
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTAXInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        try{
			ComCsr0004Event event = (ComCsr0004Event)e;
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
			
			TAXInfoVO vo = event.getTAXInfoVO();
			String compNo = vo.getCompNo();
			
			vo = command.searchTAXInfo(compNo);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();    
			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				eventResponse.setETCData(mapVO);
			}
			return eventResponse;

        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * COM_CSR_0004 : 화면로드 <br>
	 * 사업자등록번호 조회 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCompNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        try{
			ComCsr0004Event event = (ComCsr0004Event)e;
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
			
			TAXInfoVO vo = event.getTAXInfoVO();
			vo = command.searchCompNo(vo);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();    
			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				eventResponse.setETCData(mapVO);
			}
			return eventResponse;
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * COM_CSR_0004 : 화면로드 <br>
	 * 사업자등록번호 조회 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getDefOfc(Event e) throws EventException {
        try{
			ComCsr0004Event event = (ComCsr0004Event)e;
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
			GeneralEventResponse eventResponse = new GeneralEventResponse();    
			
			CsrParmVO csrParmVO = null;
			String inv_sub_sys_cd = null;
			String def_ofc = null;
			if (event!=null){
				if (event.getCsrParmVO()!=null){
					csrParmVO = event.getCsrParmVO();
					if (csrParmVO!=null){
						inv_sub_sys_cd = csrParmVO.getInvSubSysCd();	
					}
				}
			}
			if (inv_sub_sys_cd!=null && inv_sub_sys_cd.trim().equals("PSO")){
				if (signOnUserAccount!=null){
					if (signOnUserAccount.getOfc_cd()!=null && !signOnUserAccount.getOfc_cd().trim().equals("")){
						def_ofc = command.getDefOfc(JSPUtil.getNull(signOnUserAccount.getOfc_cd()));	
					}
				}
			}
			eventResponse.setETCData("def_ofc",JSPUtil.getNull(def_ofc));
			
			return eventResponse;
        } catch (EventException ex) {
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * COM_CSR_0004 : 완료버튼
	 * evid_no 채번 및 채번저장 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchApEviNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComCsr0004Event event = (ComCsr0004Event)e;
		TAXInfoVO vo = event.getTAXInfoVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
		
		try{
			begin();
			command.searchApEviNo(vo, signOnUserAccount);
			//eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
			commit();
			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				mapVO.put("gs_flg", "SEARCH02");
				eventResponse.setETCData(mapVO);
			}

        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	} 
	
	/**
	 * COM_CSR_0004 : 완료버튼 <br>
	 * 세금계산서 TAXCode 조회 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTAXCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComCsr0004Event event = (ComCsr0004Event)e;
		TAXInfoVO vo = event.getTAXInfoVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();    
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
		
        try{
			
        	TAXInfoVO tAXInfoVO = command.searchTAXCode(vo);
			
			if(tAXInfoVO != null){
				Map<String, String> mapVO = tAXInfoVO.getColumnValues();
				mapVO.put("tax_code", 	tAXInfoVO.getApTaxNm());
				mapVO.put("gs_flg", "SEARCH04");
				
				eventResponse.setETCData(mapVO);
			}
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * COM_CSR_0002 : Approval Request 버튼 <br>
	 * Approval Request 버튼 구현로직
	 * @param Event e
	 * @return EventResponse
	 * @throws Exception 
	 */
	private EventResponse approvalRequest(Event e) throws EventException {
		log.debug("\n\n SC.approvalRequest -------------------  \n\n");
		ComCsr0002Event 				event 				= (ComCsr0002Event)e;
		
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ConsultationSlipRequestMgtBC 	command 			= new ConsultationSlipRequestMgtBCImpl();
		DBRowSet[] 						autoRevVVDList 		= null;
		DBRowSet[] 						dtrbRowSet 			= null;
		
		String 							usr_id 				= event.getSignOnUserAccount().getUsr_id();
		
		//UPDATE 용 VO
		List<AutoRevVVDListVO> 			autoRevVVDListVO 	= new ArrayList<AutoRevVVDListVO>();
		AutoRevVVDListVO 				autoRevVVDVO 		= null;
		//IN, OUT 용 VO
		List<SearchDTRBTtlVO> 			searchDTRBTtlList 	= new ArrayList<SearchDTRBTtlVO>();
		SearchDTRBTtlVO 				searchDTRBTtlVO 	= null;
		//Param Setting
		CsrParmVO   					csrParmVO  			= event.getCsrParmVO();
		//Model Setting
		Collection						payInvVOs  			= event.getPayInvs();
		
		try {
			autoRevVVDList = command.getAutoRevVVDList(payInvVOs, csrParmVO);
			//event.setAutoRowSetArr01(autoRevVVDList);
			if(autoRevVVDList!=null){
				for(int j=0; j<autoRevVVDList.length; j++){
					while (autoRevVVDList[j].next()){
						autoRevVVDVO = new AutoRevVVDListVO();
						
						autoRevVVDVO.setVslCd		(autoRevVVDList[j].getString("vsl_cd"));
						autoRevVVDVO.setSkdVoyNo    (autoRevVVDList[j].getString("skd_voy_no"));
						autoRevVVDVO.setSkdDirCd    (autoRevVVDList[j].getString("skd_dir_cd"));
						autoRevVVDVO.setRevDirCd    (autoRevVVDList[j].getString("rev_dir_cd"));
						autoRevVVDVO.setInvRgstNo   (autoRevVVDList[j].getString("inv_rgst_no"));
						autoRevVVDVO.setInvRgstSeq  (autoRevVVDList[j].getString("inv_rgst_seq"));
						
						autoRevVVDListVO.add(autoRevVVDVO);
					}
				}
			}
			
			if ((csrParmVO.getCntCd()).equals("KR")){//국내
				dtrbRowSet =command.searchApInvDTRBIn	(event.getPayInvs(), csrParmVO);
				//searchDTRBTtlList = searchDTRBTtlComList(searchDTRBTtlList, searchDTRBTtlVO, dtrbRowSet);
			} else {//국외 
				dtrbRowSet =command.searchApInvDTRBOut	(event.getPayInvs(), csrParmVO);
				//searchDTRBTtlList = searchDTRBTtlComList(searchDTRBTtlList, searchDTRBTtlVO, dtrbRowSet);
			}
			//searchDTRBTtlList Setting
			if(dtrbRowSet!=null){
				for(int j=0; j<dtrbRowSet.length; j++){
					while (dtrbRowSet[j].next()){
						searchDTRBTtlVO = new SearchDTRBTtlVO();
						
						searchDTRBTtlVO.setLineSeq			(dtrbRowSet[j].getString("line_seq"));
						searchDTRBTtlVO.setLineNo           (dtrbRowSet[j].getString("line_no"));
						searchDTRBTtlVO.setLineTpLuCd       (dtrbRowSet[j].getString("line_tp_lu_cd"));
						searchDTRBTtlVO.setCsrAmt           (dtrbRowSet[j].getString("csr_amt"));
						searchDTRBTtlVO.setInvDesc          (dtrbRowSet[j].getString("inv_desc"));
						searchDTRBTtlVO.setInvTaxCd         (dtrbRowSet[j].getString("inv_tax_cd"));
						searchDTRBTtlVO.setDtrbCoaCoCd      (dtrbRowSet[j].getString("dtrb_coa_co_cd"));
						searchDTRBTtlVO.setDtrbCoaRgnCd     (dtrbRowSet[j].getString("dtrb_coa_rgn_cd"));
						searchDTRBTtlVO.setDtrbCoaCtrCd     (dtrbRowSet[j].getString("dtrb_coa_ctr_cd"));
						searchDTRBTtlVO.setDtrbCoaAcctCd    (dtrbRowSet[j].getString("dtrb_coa_acct_cd"));
						searchDTRBTtlVO.setDtrbCoaVvdCd     (dtrbRowSet[j].getString("dtrb_coa_vvd_cd"));
						searchDTRBTtlVO.setDtrbCoaInterCoCd (dtrbRowSet[j].getString("dtrb_coa_inter_co_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN1stCd (dtrbRowSet[j].getString("dtrb_coa_ftu_n1st_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN2ndCd (dtrbRowSet[j].getString("dtrb_coa_ftu_n2nd_cd"));
						searchDTRBTtlVO.setAttrCateNm       (dtrbRowSet[j].getString("attr_cate_nm"));
						searchDTRBTtlVO.setAttrCtnt1        (dtrbRowSet[j].getString("attr_ctnt1"));
						searchDTRBTtlVO.setAttrCtnt2        (dtrbRowSet[j].getString("attr_ctnt2"));
						searchDTRBTtlVO.setAttrCtnt3        (dtrbRowSet[j].getString("attr_ctnt3"));
						searchDTRBTtlVO.setAttrCtnt4        (dtrbRowSet[j].getString("attr_ctnt4"));
						searchDTRBTtlVO.setAttrCtnt5        (dtrbRowSet[j].getString("attr_ctnt5"));
						searchDTRBTtlVO.setAttrCtnt6        (dtrbRowSet[j].getString("attr_ctnt6"));
						searchDTRBTtlVO.setAttrCtnt7        (dtrbRowSet[j].getString("attr_ctnt7"));
						searchDTRBTtlVO.setAttrCtnt8        (dtrbRowSet[j].getString("attr_ctnt8"));
						searchDTRBTtlVO.setAttrCtnt9        (dtrbRowSet[j].getString("attr_ctnt9"));
						searchDTRBTtlVO.setAttrCtnt10       (dtrbRowSet[j].getString("attr_ctnt10"));
						searchDTRBTtlVO.setAttrCtnt11       (dtrbRowSet[j].getString("attr_ctnt11"));
						searchDTRBTtlVO.setAttrCtnt12       (dtrbRowSet[j].getString("attr_ctnt12"));
						searchDTRBTtlVO.setAttrCtnt13       (dtrbRowSet[j].getString("attr_ctnt13"));
						searchDTRBTtlVO.setAttrCtnt14       (dtrbRowSet[j].getString("attr_ctnt14"));
						searchDTRBTtlVO.setAttrCtnt15       (dtrbRowSet[j].getString("attr_ctnt15"));
						searchDTRBTtlVO.setBkgNo            (dtrbRowSet[j].getString("bkg_no"));
						searchDTRBTtlVO.setCntrTpszCd       (dtrbRowSet[j].getString("cntr_tpsz_cd"));
						searchDTRBTtlVO.setActVvdCd         (dtrbRowSet[j].getString("act_vvd_cd"));
						searchDTRBTtlVO.setPlnSctrDivCd     (dtrbRowSet[j].getString("pln_sctr_div_cd"));
						searchDTRBTtlVO.setSoCrrCd          (dtrbRowSet[j].getString("so_crr_cd"));
						searchDTRBTtlVO.setYdCd             (dtrbRowSet[j].getString("yd_cd"));
						searchDTRBTtlVO.setFtuUseCtnt1      (dtrbRowSet[j].getString("ftu_use_ctnt1"));
						searchDTRBTtlVO.setFtuUseCtnt2      (dtrbRowSet[j].getString("ftu_use_ctnt2"));
						searchDTRBTtlVO.setFtuUseCtnt3      (dtrbRowSet[j].getString("ftu_use_ctnt3"));
						searchDTRBTtlVO.setFtuUseCtnt4      (dtrbRowSet[j].getString("ftu_use_ctnt4"));
						searchDTRBTtlVO.setFtuUseCntr5      (dtrbRowSet[j].getString("ftu_use_cntr5"));
						searchDTRBTtlVO.setCreDt            (dtrbRowSet[j].getString("cre_dt"));
						searchDTRBTtlVO.setCreUsrId         (dtrbRowSet[j].getString("cre_usr_id"));
						searchDTRBTtlVO.setEaiEvntDt        (dtrbRowSet[j].getString("eai_evnt_dt"));
						
						searchDTRBTtlList.add(searchDTRBTtlVO);
					}
				}
			}
			
			/*******롱트랜잭션(BackEndJob) START*******/
			begin();
			//autoRevVVDListVO : autoRevVVDList 업데이트용 VO, searchDTRBTtlVOList : 국내/국외 용 VO, csrParmVO : 파라미터 VO
			String key = command.approvalRequest(event.getPayInvs(), autoRevVVDListVO, searchDTRBTtlList, csrParmVO, usr_id); 
			eventResponse.setETCData("key", key);
			commit();
			/*******롱트랜잭션(BackEndJob) END*******/

		} catch (EventException ex) {
//			ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
            rollback();
//			ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * COM_CSR_0002 : BackEndJob 상태, 에러 조회
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchAccrualBackEndJobStatus(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
			String key = (String)e.getAttribute("key");
			String statusNerr = command.searchBakEndJobStatus(key);
			eventResponse.setETCData("jb_sts_flg", statusNerr.substring(0,1));
			eventResponse.setETCData("jb_usr_err_msg", statusNerr.substring(1));
			return eventResponse;
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
    
	/**
	 * COM_CSR_0002 : BackEndJob 결과 조회 - CSR_NO 조회
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 * @throws EventException 
	 */
	private EventResponse searchAccrualBackEndJobResult(Event e) throws BackEndJobException {
		String key = (String)e.getAttribute("key");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("csr_no", (String)BackEndJobResult.loadFromFile(key));
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0002 : Preview 버튼 <br>
	 * Preview 버튼 구현로직
	 * @param Event e
	 * @return EventResponse
	 * @throws Exception 
	 */
	private EventResponse searchPreVeiw(Event e) throws EventException {
		log.debug("\n\n SC.searchPreVeiw -------------------  \n\n");
		ComCsr0002Event event = (ComCsr0002Event)e;
		
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		ConsultationSlipRequestMgtBC 	command 			= new ConsultationSlipRequestMgtBCImpl();
		DBRowSet[] 						autoRevVVDList 		= null;
		DBRowSet[] 						dtrbRowSet 			= null;
		
		String 							usr_id 				= event.getSignOnUserAccount().getUsr_id();
		
		//UPDATE 용 VO
		List<AutoRevVVDListVO> 			autoRevVVDListVO 	= new ArrayList<AutoRevVVDListVO>();
		AutoRevVVDListVO 				autoRevVVDVO 		= null;
		//IN, OUT 용 VO
		List<SearchDTRBTtlVO> 			searchDTRBTtlList 	= new ArrayList<SearchDTRBTtlVO>();
		SearchDTRBTtlVO 				searchDTRBTtlVO 	= null;
		//Param Setting
		CsrParmVO   					csrParmVO  			= event.getCsrParmVO();
		//Model Setting
		Collection						payInvVOs  			= event.getPayInvs();
		
		try {
			autoRevVVDList = command.getAutoRevVVDList(payInvVOs, csrParmVO);
			//event.setAutoRowSetArr01(autoRevVVDList);
			
			if(autoRevVVDList!=null){
				for(int j=0; j<autoRevVVDList.length; j++){
					while (autoRevVVDList[j].next()){
						autoRevVVDVO = new AutoRevVVDListVO();
						
						autoRevVVDVO.setVslCd		(autoRevVVDList[j].getString("vsl_cd")		);
						autoRevVVDVO.setSkdVoyNo    (autoRevVVDList[j].getString("skd_voy_no")	);
						autoRevVVDVO.setSkdDirCd    (autoRevVVDList[j].getString("skd_dir_cd")	);
						autoRevVVDVO.setRevDirCd    (autoRevVVDList[j].getString("rev_dir_cd")	);
						autoRevVVDVO.setInvRgstNo   (autoRevVVDList[j].getString("inv_rgst_no")	);
						autoRevVVDVO.setInvRgstSeq  (autoRevVVDList[j].getString("inv_rgst_seq"));
						
						autoRevVVDListVO.add(autoRevVVDVO);
					}
				}
			}
			
			if ((csrParmVO.getCntCd()).equals("KR")){//국내
				dtrbRowSet =command.searchApInvDTRBIn	(event.getPayInvs(), csrParmVO);
				//searchDTRBTtlList = searchDTRBTtlComList(searchDTRBTtlList, searchDTRBTtlVO, dtrbRowSet);
			} else {//국외 
				dtrbRowSet =command.searchApInvDTRBOut	(event.getPayInvs(), csrParmVO);
				//searchDTRBTtlList = searchDTRBTtlComList(searchDTRBTtlList, searchDTRBTtlVO, dtrbRowSet);
			}
			
			//searchDTRBTtlList Setting
			if(dtrbRowSet!=null){
				for(int j=0; j<dtrbRowSet.length; j++){
					while (dtrbRowSet[j].next()){
						searchDTRBTtlVO = new SearchDTRBTtlVO();
						
						searchDTRBTtlVO.setLineSeq			(dtrbRowSet[j].getString("line_seq"));
						searchDTRBTtlVO.setLineNo           (dtrbRowSet[j].getString("line_no"));
						searchDTRBTtlVO.setLineTpLuCd       (dtrbRowSet[j].getString("line_tp_lu_cd"));
						searchDTRBTtlVO.setCsrAmt           (dtrbRowSet[j].getString("csr_amt"));
						searchDTRBTtlVO.setInvDesc          (dtrbRowSet[j].getString("inv_desc"));
						searchDTRBTtlVO.setInvTaxCd         (dtrbRowSet[j].getString("inv_tax_cd"));
						searchDTRBTtlVO.setDtrbCoaCoCd      (dtrbRowSet[j].getString("dtrb_coa_co_cd"));
						searchDTRBTtlVO.setDtrbCoaRgnCd     (dtrbRowSet[j].getString("dtrb_coa_rgn_cd"));
						searchDTRBTtlVO.setDtrbCoaCtrCd     (dtrbRowSet[j].getString("dtrb_coa_ctr_cd"));
						searchDTRBTtlVO.setDtrbCoaAcctCd    (dtrbRowSet[j].getString("dtrb_coa_acct_cd"));
						searchDTRBTtlVO.setDtrbCoaVvdCd     (dtrbRowSet[j].getString("dtrb_coa_vvd_cd"));
						searchDTRBTtlVO.setDtrbCoaInterCoCd (dtrbRowSet[j].getString("dtrb_coa_inter_co_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN1stCd (dtrbRowSet[j].getString("dtrb_coa_ftu_n1st_cd"));
						searchDTRBTtlVO.setDtrbCoaFtuN2ndCd (dtrbRowSet[j].getString("dtrb_coa_ftu_n2nd_cd"));
						searchDTRBTtlVO.setAttrCateNm       (dtrbRowSet[j].getString("attr_cate_nm"));
						searchDTRBTtlVO.setAttrCtnt1        (dtrbRowSet[j].getString("attr_ctnt1"));
						searchDTRBTtlVO.setAttrCtnt2        (dtrbRowSet[j].getString("attr_ctnt2"));
						searchDTRBTtlVO.setAttrCtnt3        (dtrbRowSet[j].getString("attr_ctnt3"));
						searchDTRBTtlVO.setAttrCtnt4        (dtrbRowSet[j].getString("attr_ctnt4"));
						searchDTRBTtlVO.setAttrCtnt5        (dtrbRowSet[j].getString("attr_ctnt5"));
						searchDTRBTtlVO.setAttrCtnt6        (dtrbRowSet[j].getString("attr_ctnt6"));
						searchDTRBTtlVO.setAttrCtnt7        (dtrbRowSet[j].getString("attr_ctnt7"));
						searchDTRBTtlVO.setAttrCtnt8        (dtrbRowSet[j].getString("attr_ctnt8"));
						searchDTRBTtlVO.setAttrCtnt9        (dtrbRowSet[j].getString("attr_ctnt9"));
						searchDTRBTtlVO.setAttrCtnt10       (dtrbRowSet[j].getString("attr_ctnt10"));
						searchDTRBTtlVO.setAttrCtnt11       (dtrbRowSet[j].getString("attr_ctnt11"));
						searchDTRBTtlVO.setAttrCtnt12       (dtrbRowSet[j].getString("attr_ctnt12"));
						searchDTRBTtlVO.setAttrCtnt13       (dtrbRowSet[j].getString("attr_ctnt13"));
						searchDTRBTtlVO.setAttrCtnt14       (dtrbRowSet[j].getString("attr_ctnt14"));
						searchDTRBTtlVO.setAttrCtnt15       (dtrbRowSet[j].getString("attr_ctnt15"));
						searchDTRBTtlVO.setBkgNo            (dtrbRowSet[j].getString("bkg_no"));
						searchDTRBTtlVO.setCntrTpszCd       (dtrbRowSet[j].getString("cntr_tpsz_cd"));
						searchDTRBTtlVO.setActVvdCd         (dtrbRowSet[j].getString("act_vvd_cd"));
						searchDTRBTtlVO.setPlnSctrDivCd     (dtrbRowSet[j].getString("pln_sctr_div_cd"));
						searchDTRBTtlVO.setSoCrrCd          (dtrbRowSet[j].getString("so_crr_cd"));
						searchDTRBTtlVO.setYdCd             (dtrbRowSet[j].getString("yd_cd"));
						searchDTRBTtlVO.setFtuUseCtnt1      (dtrbRowSet[j].getString("ftu_use_ctnt1"));
						searchDTRBTtlVO.setFtuUseCtnt2      (dtrbRowSet[j].getString("ftu_use_ctnt2"));
						searchDTRBTtlVO.setFtuUseCtnt3      (dtrbRowSet[j].getString("ftu_use_ctnt3"));
						searchDTRBTtlVO.setFtuUseCtnt4      (dtrbRowSet[j].getString("ftu_use_ctnt4"));
						searchDTRBTtlVO.setFtuUseCntr5      (dtrbRowSet[j].getString("ftu_use_cntr5"));
						searchDTRBTtlVO.setCreDt            (dtrbRowSet[j].getString("cre_dt"));
						searchDTRBTtlVO.setCreUsrId         (dtrbRowSet[j].getString("cre_usr_id"));
						searchDTRBTtlVO.setEaiEvntDt        (dtrbRowSet[j].getString("eai_evnt_dt"));
						
						searchDTRBTtlList.add(searchDTRBTtlVO);
					}
				}
			} 

			begin();
			
			HdrDtrGrpVO 		grpVO 	= command.searchPreVeiw(event.getPayInvs(), autoRevVVDListVO, searchDTRBTtlList, csrParmVO, usr_id);
			HdrVO    			hdrSet 	= grpVO.getHdrVOs();
			List<DtrbListVO> 	dtrbSet = grpVO.getDtrbListVOs();
			
			eventResponse.setRsVo		(hdrSet);
			eventResponse.setRsVoList	(dtrbSet);
			
			//eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
			//commit(); 
			rollback();
			

		} catch (EventException ex) {
//			ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
            rollback();
//			ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0008 : CSR Format 버튼 <br>
	 * CSR Format 버튼 구현로직
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse tmpSearchPreVeiw(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComCsr0008Event event = (ComCsr0008Event)e;
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		CsrParmVO csrParmVO = event.getCsrParmVO();
		//String asa_no = param_map != null ? (String) param_map.get("asa_no") : "";
		String csrNo = csrParmVO.getCsrNo();
		
		try {
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
			
			begin();
			
			HdrDtrGrpVO grpVO = command.tmpSearchPreVeiw(csrNo);
			HdrVO    hdrSet = grpVO.getHdrVOs();
			List<DtrbListVO> dtrbSet = grpVO.getDtrbListVOs();
			
			eventResponse.setRsVo(hdrSet);
			eventResponse.setRsVoList(dtrbSet);

        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0008 : 조회버튼 <br>
	 * CSR I/F Inquiry 의 리스트를 조회합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrIfList (Event e) throws EventException {
        try{
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
			ComCsr0008Event event = (ComCsr0008Event)e;
			IfCsrListInputVO ifCsrListInputVO = event.getIfCsrListInputVO();
			
			List<IfCsrListInputVO> list = command.searchCsrIfList (ifCsrListInputVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse; 
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}

	/**
	 * COM_CSR_0011 : 화면로드 <br>
	 * Invoice List Inquiry 의 리스트폼조회 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOlist(Event e) throws EventException {
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		CSRSOlistVO vo = null;
		if (e.getEventName().equalsIgnoreCase("ComCsr0011Event")) {
			ComCsr0011Event event = (ComCsr0011Event) e;
			vo = event.getCSRSOlistVO();
		} else {
			ComCsr0014Event event = (ComCsr0014Event) e;
			vo = event.getCSRSOlistVO();
		}
		
		try {
			log.debug("\n\n SC - searchCSRSOlist() \n\n");
			List<CSRSOlistVO> list = command.searchCSRSOlist (vo);
			eventResponse.setRsVoList(list);

        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse; 
	} 
	
	/**
	 * COM_CSR_0011 : 화면로드 <br>
	 * Invoice List Inquiry 의 플릿폼조회 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOhdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
        try{
			ComCsr0011Event event = (ComCsr0011Event)e;
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl(); 
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			CSRSOhdrVO vo = event.getCSRSOhdrVO(); 
			vo = command.searchCSRSOhdr(vo); 
			eventResponse.setRsVo(vo);
			 
			return eventResponse;
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * COM_CSR_0008 : CSR Cancel버튼<br>
	 * I/F Error 의 Cancel 저장
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiConfirmCSR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComCsr0008Event event = (ComCsr0008Event)e;
		IfCsrListInputVO vo = event.getIfCsrListInputVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
		
		try{
			begin();
			command.multiConfirmCSR(vo, signOnUserAccount);
			eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
			commit();

        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0008 : CSR Cancel버튼<br>
	 * Approval Requested 의 Cancel 저장
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComCsr0008Event event = (ComCsr0008Event)e;
		
		IfCsrListInputVO vo = event.getIfCsrListInputVO();
		ComCsrInfoVO comCsrInfoVO = new ComCsrInfoVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
		ApprovalUtil aproUtil = new ApprovalUtil();
		
		try{
			begin();
			command.cancelCSR(vo,signOnUserAccount);
			
			//CSR Cancel 처리시 USR_APRO_STEP_FLG = ''으로 업데이트
			comCsrInfoVO.setCsrNo(vo.getCsrNo());
			comCsrInfoVO.setCsrAproTpCd(vo.getCsrAproTpCd());
			
			aproUtil.updateAproGwDt(comCsrInfoVO);
			
			eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
			commit();
        } catch (EventException ex) {
//            ex.printStackTrace();
        	rollback();
        	log.error("rollback err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	rollback();
        	log.error("rollback2 err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0014 : : CSR Cancel버튼시 화면로드<br>
	 * A/P Rejected & Disapproved 의 인보이스별 Cancel 저장
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse multiRejectedCSRCancellation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComCsr0014Event event = (ComCsr0014Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
		
		//Param Setting
		CsrParmVO   csrParmVO  = event.getCsrParmVO();
		//Model Setting
		Collection	payInvVOs  = event.getPayInvs();
		//chk Array
		String[] chks = event.getChks();
		//session
		String usrId = event.getSignOnUserAccount().getUsr_id();
		String ofcCd = event.getSignOnUserAccount().getOfc_cd();
		
		try{
			begin();
			command.multiRejectedCSRCancellation(payInvVOs, chks, csrParmVO, usrId, ofcCd);
			eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
			commit();

        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * 공통 : combo용 String
	 * List를 combo용 String으로 만들어준다. 
	 * @param List<AsaNoVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeComboString(List<AsaNoVO> list, int flg) throws Exception{
        try{
			String rtnVal = null;
			StringBuilder sb = new StringBuilder();
			
			Iterator iterator = (Iterator) list.iterator();
	
			while(iterator.hasNext()){
				AsaNoVO vo = (AsaNoVO)iterator.next();
				//일반적인 IBCombo용(name, code|)
				if (flg==0){
					sb.append(vo.getName()+","+vo.getCode()+"|");
				//IBCombo (code, code|)
				}else if (flg==1){
					sb.append(vo.getName()+","+vo.getName()+"|");
				//IBSheet의 코드부분(code|)
				}else if (flg==2){ 
					sb.append(vo.getCode()+"|");
				//IBSheet의 코드명부분(name|)
				}else if (flg==3){
					sb.append(vo.getName()+"|"); 
				}
			}
			rtnVal = sb.toString();
	
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
			
			return rtnVal;
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}	
	
	/**
	 * 공통 : combo용 String
	 * List를 combo용 String으로 만들어준다. 
	 * @param List<TAXInfoVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeComboString2(List<TAXInfoVO> list, int flg) throws Exception{
        try{
			String rtnVal = null;
			StringBuilder sb = new StringBuilder();
			
			Iterator iterator = (Iterator) list.iterator();
	
			while(iterator.hasNext()){
				TAXInfoVO vo = (TAXInfoVO)iterator.next();
				//일반적인 IBCombo용(name, code|)
				if (flg==0){
					sb.append(vo.getWkplcNmstring()+","+vo.getWkplcNmstring()+"|");
				//IBCombo (code, code|)
				}else if (flg==1){
					sb.append(vo.getWkplcNmstring()+","+vo.getWkplcNmstring()+"|");
				//IBSheet의 코드부분(code|)
				}else if (flg==2){
					sb.append(vo.getWkplcNmstring()+"|");
				//IBSheet의 코드명부분(name|)
				}else if (flg==3){
					sb.append(vo.getWkplcNmstring()+"|"); 
				}
			}
			rtnVal = sb.toString();
	
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
			
			return rtnVal;
        }catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	} 
	
	/**
	 * approval request gwUrl open<br>
	 * @author young shin kim
	 * @category 
	 * @category manageApplication 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApplication(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		ComCsr0008Event event = (ComCsr0008Event)e;
		// BC 객체 생성
		ComCsrApprovalBC command = new ComCsrApprovalBCImpl();	
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		IfCsrListInputVO vo = event.getIfCsrListInputVO();

		try {
			
			//그룹웨어 URL주소
			String gwUrl= "";
			
			//csr no 
			String csrNo = vo.getCsrNo();
			//inv_sub_sys_cd
			String invSubSysCd = vo.getInvSubSysCd();		
			
			gwUrl = command.sendGwApprovalRequestInfo(csrNo, invSubSysCd, signOnUserAccount);
			
			if (gwUrl == null) {
				gwUrl = "";
			}
			
			eventResponse.setETCData("GW_URL", gwUrl);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Gw Status 정보 수정 EAI에서 수신<br>
	 * @author young shin kim
	 * @category COM006R001
	 * @category manageGwStatus 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGwStatus(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		ComCsr0008Event event = (ComCsr0008Event)e;
		ComCsrInfoVO vo = event.getComCsrInfoVO();		
		ComApCsrHisVO hisVo = new ComApCsrHisVO();
		
		ApprovalUtil aproUtil = new ApprovalUtil();
		ApprovalCsrVO approvalCsrVO = new ApprovalCsrVO();
		ComAproRqstRoutVO rout = new ComAproRqstRoutVO();
		
		ComCsrApprovalBC command = new ComCsrApprovalBCImpl();	
		ApprovalBC aproCommand = new ApprovalBCImpl();
		AGTAuditBC agtCommand = new AGTAuditBCImpl();
    	AGNCommApprovalBC acmCommand = new AGNCommApprovalBCImpl();
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		TCharterIOConsultationBC     fmsCommand = new TCharterIOConsultationBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
		
		String beComplete = "";

		try {		
			begin();
			// ---------------------------------------------
			// GW 승인여부  : result
			// --------------------------------------------
			// C (CANCLE)    : 창닫기
			// N (REJECT)    : disapprove
			// Y (COMPLETE)  : 최종결재 완료.
			// P (PANDING)   : 기안완료
			// --------------------------------------------			
			String gwResult = JSPUtil.getNull(vo.getResult());
			String csrNo = JSPUtil.getNull(vo.getCsrNo());
			String aproUsrNm = JSPUtil.getNull(vo.getAproUsrNm());
			String aproUsrJbTitNm = JSPUtil.getNull(vo.getAproUsrJbTitNm());	
			String userId = JSPUtil.getNull(vo.getUserId());
			String requestId = JSPUtil.getNull(vo.getRequestId());
			String gwAgmtDocCfmCd = JSPUtil.getNull(vo.getGwAgmtDocCfmCd());
			String resultMsg = JSPUtil.getNull(vo.getResultMsg());
			
			String ofcCd = command.searchOfcCd(csrNo);
			//csrNo로 SubSysCd 값을 가져온다
			String subSysCd = command.searchSubSysCd(csrNo);
						
			log.error("============================");
			log.error("gwResult : " + gwResult);
			log.error("csrNo : " + csrNo);
			log.error("userId : " + userId);
			log.error("aproUsrNm : " + aproUsrNm);
			log.error("aproUsrJbTitNm : " + aproUsrJbTitNm);
			log.error("ofcCd : " + ofcCd);
			log.error("subSysCd : " + subSysCd);
			log.error("gwAgmtDocCfmCd : " + gwAgmtDocCfmCd);
			log.error("resultMsg : " + resultMsg);
			log.error("============================");
			
			approvalCsrVO.setCsrNo(csrNo);
			approvalCsrVO.setInvSubSysCd(subSysCd);
			approvalCsrVO.setSubSysCd(subSysCd);
			approvalCsrVO.setUsrNm(aproUsrNm);
			
			rout.setAproUsrNm(aproUsrNm);
			rout.setAproUsrJbTitNm(aproUsrJbTitNm);
			
			vo.setCsrNo(csrNo);
			vo.setOfcCd(ofcCd);
			vo.setCsrAproTpCd("GW");
			vo.setResult(gwResult);
			vo.setGwAgmtDocCfmCd(gwAgmtDocCfmCd);
					
			// -------------------------------------
			// GW 연동 정보를  history 테이블에 저장한다.
			// -------------------------------------
			log.error("\n 3.START - ConsultationSlipRequestMgtSC.manageGwStatus : saveGWInfo (csr_no:"+JSPUtil.getNull(csrNo)+") \n");
	    	hisVo.setCsrNo(csrNo);
	    	hisVo.setCsrAproTpCd("GW");
	    	hisVo.setAutoMnlFlg("Y");
	    	hisVo.setIoBndCd("I");
	    	hisVo.setGwCsrRqstId(requestId);
	    	hisVo.setGwAproRsltCd(gwResult);
	    	hisVo.setCreUsrId(userId);					//생성자 ID(승인자 ID)
	    	hisVo.setUpdUsrId(userId);					//업데이트 ID(승인자 ID)
	    	hisVo.setAproUsrId(userId);					//승인자 ID
	    	hisVo.setAproUsrJbTitNm(aproUsrJbTitNm);	//승인자 직책
	    	hisVo.setAproUsrNm(aproUsrNm);				//승인자 이름
	    	hisVo.setAproRmk(resultMsg);				//승인 코멘트
	    	
	    	command.saveGWInfo(hisVo);
	    	log.error("\n 3.DONE - ConsultationSlipRequestMgtSC.manageGwStatus : saveGWInfo (csr_no:"+JSPUtil.getNull(csrNo)+") \n");	    
		    
	    	commit();	//EAI연동에 의해 에러가 발생해도 History table 에 저장되는 값은 rollback 되지 않도록 한다.
		    begin();
		    // ---------------------------------------------
		 	// 현재 결재 상태를 조회한다.
		 	// --------------------------------------------
		 	// X (Requesting) : CSR_NO만 생성된 상태
		    // P (PANDING)    : 기안완료
		    // N (REJECT)     : disapproved 상태
		 	// Y (COMPLETE)   : 최종결재 완료 상태	 	
		 	// --------------------------------------------			
	    	String  aproStepFlg = command.searchRqstAproStepFlg(csrNo);
	    	log.error("\n aproStepFlg="+aproStepFlg);
	    	
		    if ("P".equals(gwResult)) {		    			
				if(aproStepFlg.equals("X")) {
					//RESULT 값에 따라 DATE 컬럼, RQST_APRO_STEP_FLG = '' 업데이트
					aproUtil.updateAproGwDt(vo);					
					beComplete = "Success";
					
					if("ACM".equals(subSysCd)) { //기안시 ACM의 상태가 AL->PS 로 업데이트
						AGNCommApprovalRequestVO rqstVO = new AGNCommApprovalRequestVO();
						rqstVO.setCsrNo(csrNo);
						rqstVO.setUpdUsrId(userId);
						acmCommand.manageAcmAgnOtrComm3(rqstVO);
					}
				} else if(aproStepFlg.equals("P")){ //기안이 완료된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
			} else if ("N".equals(gwResult)) {				
				if(aproStepFlg.equals("P")) { //기안이 완료된 건에 대해서만 disapproved
					if("FMS".equals(subSysCd)){
						fmsCommand.manageDisapproveFMS(userId, csrNo, ofcCd);
					} else {
	        			//1) 결재 정보 Update
	        			aproCommand.rejectApprovalGW(approvalCsrVO);
	        			
	        			//2) 각 모듈 Update (TES/TRS/AGT/ACM)
						if("AGT".equals(subSysCd)) {					
							agtCommand.transferAgentActualINFtoAP1("R", csrNo, rout);
						} else if("ACM".equals(subSysCd)) {
							acmCommand.transferAgentActualINFtoAP1("R", csrNo, rout);
						} else if("TES".equals(subSysCd)) {
							tesCommand.approvalRequestAccount1("R", csrNo, rout);
						} else if("TRS".equals(subSysCd)) {
							trsCommand.approvalRequestAccount1("R", csrNo, rout);
	    				}
					}
					
					//RESULT 값에 따라 DATE 컬럼 업데이트
					aproUtil.updateAproGwDt(vo);					
					beComplete = "Success";
					
				} else if(aproStepFlg.equals("X")){ //기안 완료가 되지 않은 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
					
			} else if ("Y".equals(gwResult)) {		
				if(aproStepFlg.equals("P")) { //기안이 완료된 건에 대해서만 approved	
					log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC gwResult = Y  IF (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>>>");	  
					//RESULT 값에 따라 DATE 컬럼, GW_AGMT_DOC_CFM_CD 업데이트
					aproUtil.updateAproGwDt(vo);
					
					log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC aproUtil.updateAproGwDt() DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>>>");	

					//ExeActTpCd 구하고 update 하기
					String exe_act_tp_cd = aproUtil.updateExeActTpCd(csrNo);
					log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC aproUtil.updateExeActTpCd() DONE (csr_no:"+JSPUtil.getNull(csrNo)+" - exe_act_tp_cd:"+JSPUtil.getNull(exe_act_tp_cd)+")  >>>>>>>>>>>>>>>>>");
					
					if (exe_act_tp_cd!=null && exe_act_tp_cd.trim().equals("B")){
						log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC BATCH (csr_no:"+JSPUtil.getNull(csrNo)+" - exe_act_tp_cd:"+JSPUtil.getNull(exe_act_tp_cd)+")  >>>>>>>>>>>>>>>>>");
					} else {
						log.error("\n <<<<<<<<<<<<<  ConsultationSlipRequestMgtSC ON-LINE (csr_no:"+JSPUtil.getNull(csrNo)+" - exe_act_tp_cd:"+JSPUtil.getNull(exe_act_tp_cd)+")  >>>>>>>>>>>>>>>>>");
						if ("FMS".equals(subSysCd)){
							fmsCommand.manageApproveFMS(userId, csrNo, ofcCd);
						} else {			
							//1) 결재 Update 수행 (Header & Route 정보)
							aproCommand.confirmApprovalGW(approvalCsrVO);
							log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC confirmApprovalGW DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>>");	  
							
				    		//2) CSR 결재완료시, 각 모듈별 Update 수행 (TES/TRS/AGT/ACM/CSR)
							if("TRS".equals(subSysCd)) {
								trsCommand.approvalRequestAccount2("C", csrNo, rout);
							} else if("TES".equals(subSysCd)) {
								tesCommand.approvalRequestAccount2("C", csrNo, rout);
							} else if("AGT".equals(subSysCd)){
								agtCommand.transferAgentActualINFtoAP2("C", csrNo, rout);
							} else if("ACM".equals(subSysCd)){
								acmCommand.transferAgentActualINFtoAP2("C", csrNo, rout );
							}
							log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC approvalRequestAccount2 DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>");	
			    			//3) CSR 결재완료시, ERP Interface 수행
			    			FNS0080003Document[] docReq = null;			
							
							if("AGT".equals(subSysCd)) {
								docReq = agtCommand.transferAgentActualINFtoAP1("C", csrNo, rout);
							} else if("ACM".equals(subSysCd)) {
								docReq = acmCommand.transferAgentActualINFtoAP1("C", csrNo, rout);
							} else if("TES".equals(subSysCd)) {
								docReq = tesCommand.approvalRequestAccount1("C", csrNo, rout);
							} else if("TRS".equals(subSysCd)) {
								docReq = trsCommand.approvalRequestAccount1("C", csrNo, rout);	
							} else if("MNR".equals(subSysCd) || "TLL".equals(subSysCd) || "LSE".equals(subSysCd) 
									|| "PSO".equals(subSysCd) || "CHS".equals(subSysCd) || "MGS".equals(subSysCd) || "CNI".equals(subSysCd)) {
								//AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema) 을 적용한 XML문서로 변환
								docReq = csrCommand.approvalRequestAccount1("C", csrNo, ofcCd, rout);
							}
							log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC approvalRequestAccount1 DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>");
							//invoice 정산내역을 ERP AP로 인터페이스한다.
							transferInvToERP(docReq, approvalCsrVO); 
							//BIZ스레드처리후 Exception 없다면 비동기(Biz) 커밋 :: Approval 결재 처리    	   	
							log.error("\n <<<<<<<<<<<<<<  ConsultationSlipRequestMgtSC transferInvToERP DONE (csr_no:"+JSPUtil.getNull(csrNo)+") >>>>>>>>>>>>>>>");
						}
					}
								
					beComplete = "Success";	
					
				} else if(aproStepFlg.equals("X")){ //기안 롼료가 되지 않은 건입니다.
					log.error("\n ConsultationSlipRequestMgtSC.manageGwStatus() : "+JSPUtil.getNull(csrNo)+" ["+aproStepFlg+"] "+new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage()+"\n");
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					log.error("\n ConsultationSlipRequestMgtSC.manageGwStatus() : "+JSPUtil.getNull(csrNo)+" ["+aproStepFlg+"] "+new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage()+"\n");
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					log.error("\n ConsultationSlipRequestMgtSC.manageGwStatus() : "+JSPUtil.getNull(csrNo)+" ["+aproStepFlg+"] "+new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage()+"\n");
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
			}

			commit(); 
			eventResponse.setUserMessage(beComplete);
			
		
		} catch(EventException ex) {
			rollback();
			log.error("\n manageGwStatus() - EventException err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("\n manageGwStatus() - Exception err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 설명 : AP I/F 수행 <br>
	 * CSR AP 관련 공통 메소드입니다 2009-11-18 HDS
	 * @throws EventException 
	*/
	private void transferInvToERP(FNS0080003Document[] docReq, ApprovalCsrVO approvalCsrVO) throws EventException {
		SendQueueBC apInvCommand = new SendQueueBCImpl();
		ApprovalBC command = new ApprovalBCImpl();
		try {
			apInvCommand.transferInvToERP(docReq, signOnUserAccount);
		} catch(EventException ex) {
			rollback();
			command.confirmApprovalRemark(approvalCsrVO);
			throw ex;
		} catch(Exception ex) {
			rollback();
			command.confirmApprovalRemark(approvalCsrVO);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
	}
	
	/**
	 * COM_CSR_0008 : Approval Request 버튼(3만불 이하 결재)<br>
	 * Requesting Approval 의 3만불 이하 Approval Step 저장
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse approvalStep(Event e) throws EventException {

		ComCsr0008Event event = (ComCsr0008Event)e;
		CsrParmVO vo = event.getCsrParmVO();
		ComCsrInfoVO comCsrInfoVO = event.getComCsrInfoVO();		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
		ComCsrApprovalBC csrCommand = new ComCsrApprovalBCImpl();	
		ApprovalUtil aproUtil = new ApprovalUtil();
		
		try{
			begin();
			command.approvalStep(vo);
			
			//RESULT 값에 따라 DATE 컬럼 업데이트
			String csrNo = JSPUtil.getNull(vo.getCsrNo());
			String ofcCd = csrCommand.searchOfcCd(csrNo);
			
			comCsrInfoVO.setCsrNo(csrNo);
			comCsrInfoVO.setCsrAproTpCd("AL");
			comCsrInfoVO.setOfcCd(ofcCd);
			comCsrInfoVO.setResult("");
			comCsrInfoVO.setGwAgmtDocCfmCd("");		
			
			aproUtil.updateAproGwDt(comCsrInfoVO);
			
			eventResponse.setUserMessage(new ErrorHandler("CSR10022").getUserMessage());
			commit();

        } catch (EventException ex) {
        	rollback();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	rollback();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * COM_CSR_0008 : Approval Step 정보<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse getApprovalRoute(Event e) throws EventException {
		
		ComCsr0008Event event = (ComCsr0008Event)e;
		IfCsrListInputVO vo = event.getIfCsrListInputVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {			
			String aproSeqKey = ApprovalUtil.getApprovalRoute1(vo.getCostOfcCd(), vo.getInvSubSysCd()); 
			String cost_aproSeqKey = ApprovalUtil.getApprovalRoute1(vo.getOfcCd(), vo.getInvSubSysCd());
			String login_aproSeqKey = ApprovalUtil.getApprovalRoute1(vo.getCostOfcCd(), vo.getInvSubSysCd());
			
			String costAproStep =  ApprovalUtil.getApprovalRoute(vo.getCostOfcCd(), vo.getInvSubSysCd()); 
			String loginAproStep = ApprovalUtil.getApprovalRoute(vo.getOfcCd(), vo.getInvSubSysCd()); 

            eventResponse.setETCData("apro_seq_key", aproSeqKey);
            eventResponse.setETCData("cost_apro_seq_key", cost_aproSeqKey);
            eventResponse.setETCData("login_apro_seq_key", login_aproSeqKey);
            
			eventResponse.setETCData("cost_apro_step", costAproStep);
			eventResponse.setETCData("login_apro_step", loginAproStep);
			
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * COM_CSR_0015 : 조회버튼 <br>
	 * ERP Interface 대상 CSR의 리스트를 조회합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErpInterfaceList(Event e) throws EventException {
        try{
			ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
			ComCsr0015Event event = (ComCsr0015Event)e;
			IfCsrListInputVO ifCsrListInputVO = event.getIfCsrListInputVO();
			
			List<IfCsrListInputVO> list = command.searchErpInterfaceList(ifCsrListInputVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse; 
        } catch (EventException ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}
	
	/**
	 * COM_CSR_0015 : ERP Interface버튼<br>
	 * CSR Data를 ERP로 전송한다.
	 * @param  Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse erpInterface(Event e) {
		// PDTO(Data Transfer Object including Parameters)
		ComCsr0015Event event = (ComCsr0015Event)e;
		
		IfCsrListInputVO[] ifCsrListInputVOs = null;
		ifCsrListInputVOs = event.getIfCsrListInputVOs();
		ApprovalCsrVO approvalCsrVO = new ApprovalCsrVO();
		ComAproRqstRoutVO rout = new ComAproRqstRoutVO();
		ComApCsrHisVO hisVO = new ComApCsrHisVO();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
		ComCsrApprovalBC command = new ComCsrApprovalBCImpl();	
		ApprovalBC aproCommand = new ApprovalBCImpl();
		AGTAuditBC agtCommand = new AGTAuditBCImpl();
    	AGNCommApprovalBC acmCommand = new AGNCommApprovalBCImpl();
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
		TCharterIOConsultationBC     fmsCommand = new TCharterIOConsultationBCImpl();
		String aproUsrNm = null;
		String aproUsrJbTitNm = null;
		//
		if (ifCsrListInputVOs != null) {
			for (int i = 0; i < ifCsrListInputVOs.length; i++) {
				try {

					begin();
					/*
					 * 2015.03.12 심성윤 수정 ALPS, GW 구분 기능 추가 COM_CSR_0015
					 */
					String csrNo = JSPUtil.getNull(ifCsrListInputVOs[i].getCsrNo());
					String csrAproTpCd = JSPUtil.getNull(ifCsrListInputVOs[i].getCsrAproTpCd());
					String subSysCd = command.searchSubSysCd(csrNo);
					String ofcCd = command.searchOfcCd(csrNo);
					String checkIfFlg = command.searchCheckIfFlg(csrNo);
					log.error("\n " + checkIfFlg + "<<<<<<<");
					// 최종승인자 성명과 직책정보를 history table의 result='Y'로 조회해 온다.
					if ("GW".equals(csrAproTpCd)) {
						ComApCsrHisVO hisInfo = command.searchCsrHisInfo(csrNo);
						aproUsrNm = JSPUtil.getNull(hisInfo.getAproUsrNm());
						aproUsrJbTitNm = JSPUtil.getNull(hisInfo.getAproUsrJbTitNm());
					}// if_GW
					else if ("AL".equals(csrAproTpCd)) {
						ComCsrInfoVO alpsInfo = command.searchCsrApAproInfo(csrNo);
						aproUsrNm = JSPUtil.getNull(alpsInfo.getAproUsrNm());
						aproUsrJbTitNm = JSPUtil.getNull(alpsInfo.getAproUsrJbTitNm());
					}// elseif_AL

					log.error("\n [" + i + "] >>> " + JSPUtil.getNull(csrNo) + "<<<" + JSPUtil.getNull(checkIfFlg)+ "--------------------");
					if (checkIfFlg == null || !checkIfFlg.trim().equals("Y")) {
						throw new EventException("\n" + JSPUtil.getNull(csrNo)	+ "<<<");
					} else {
						approvalCsrVO.setCsrNo(csrNo);
						approvalCsrVO.setInvSubSysCd(subSysCd);
						approvalCsrVO.setSubSysCd(subSysCd);
						approvalCsrVO.setUsrNm(aproUsrNm);
						rout.setAproUsrNm(aproUsrNm);
						rout.setAproUsrJbTitNm(aproUsrJbTitNm);
						if ("FMS".equals(subSysCd)) {
							fmsCommand.manageApproveFMS(signOnUserAccount.getUsr_id(), csrNo, ofcCd);
						} else {
							// 1) 결재 Update 수행 (Header & Route 정보)
							aproCommand.confirmApprovalGW(approvalCsrVO);

							// 2) CSR 결재완료시, 각 모듈별 Update 수행
							// (TES/TRS/AGT/ACM/CSR)
							if ("TRS".equals(subSysCd)) {
								trsCommand.approvalRequestAccount2("C", csrNo, rout);
							} else if ("TES".equals(subSysCd)) {
								tesCommand.approvalRequestAccount2("C", csrNo, rout);
							} else if ("AGT".equals(subSysCd)) {
								agtCommand.transferAgentActualINFtoAP2("C",	csrNo, rout);
							} else if ("ACM".equals(subSysCd)) {
								acmCommand.transferAgentActualINFtoAP2("C", csrNo, rout);
							}

							// 3) IF_DT = '' 값으로 업데이트 (안해주면 오류 발생)
							command.updateErpInterface(csrNo);

							// 4) CSR 결재완료시, ERP Interface 수행
							FNS0080003Document[] docReq = null;

							if ("AGT".equals(subSysCd)) {
								docReq = agtCommand.transferAgentActualINFtoAP1("C",csrNo, rout);
							} else if ("ACM".equals(subSysCd)) {
								docReq = acmCommand.transferAgentActualINFtoAP1("C",csrNo, rout);
							} else if ("TES".equals(subSysCd)) {
								docReq = tesCommand.approvalRequestAccount1("C", csrNo, rout);
							} else if ("TRS".equals(subSysCd)) {
								docReq = trsCommand.approvalRequestAccount1("C", csrNo, rout);
							} else if ("MNR".equals(subSysCd)
									|| "TLL".equals(subSysCd)
									|| "LSE".equals(subSysCd)
									|| "PSO".equals(subSysCd)
									|| "CHS".equals(subSysCd)
									|| "MGS".equals(subSysCd)
									|| "CNI".equals(subSysCd)) {
								// AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema)
								// 을 적용한 XML문서로 변환
								docReq = csrCommand.approvalRequestAccount1("C", csrNo, ofcCd, rout);
							}

							// invoice 정산내역을 ERP AP로 인터페이스한다.
							transferInvToERP(docReq, approvalCsrVO);
						}
					}

					/*
					 * ------------------------------------- 
					 * GW와 ALPS 연동 정보를
					 * history 테이블에 저장한다. COM_CSR_0015 심성윤
					 * -------------------------------------
					 */
					if ("GW".equals(csrAproTpCd)) {
						log.error("\n 3.START - ConsultationSlipRequestMgtSC.erpInterface : saveGWInfo (csr_no:" + JSPUtil.getNull(csrNo) + ") \n");
						hisVO.setCsrNo(csrNo);
						hisVO.setCsrAproTpCd("GW"); // GW
						hisVO.setAutoMnlFlg("N"); // 수동
						hisVO.setIoBndCd("O"); // ERP out
						hisVO.setCreUsrId(signOnUserAccount.getUsr_id());
						hisVO.setUpdUsrId(signOnUserAccount.getUsr_id());
						hisVO.setCorrHisRmk("SENDING");
						command.saveGWInfo(hisVO);
						log.error("\n 3.DONE - ConsultationSlipRequestMgtSC.erpInterface : saveGWInfo (csr_no:"	+ JSPUtil.getNull(csrNo) + ") \n");
					} else if ("AL".equals(csrAproTpCd)) {
						log.error("\n 3.START - ConsultationSlipRequestMgtSC.erpInterface : saveGWInfo (csr_no:" + JSPUtil.getNull(csrNo) + ") \n");
						hisVO.setCsrNo(csrNo);
						hisVO.setCsrAproTpCd("AL"); // ALPS
						hisVO.setAutoMnlFlg("N"); // 수동
						hisVO.setIoBndCd("O"); // ERP out
						hisVO.setCreUsrId(signOnUserAccount.getUsr_id());
						hisVO.setUpdUsrId(signOnUserAccount.getUsr_id());
						hisVO.setCorrHisRmk("SENDING");
						command.saveGWInfo(hisVO);
						log.error("\n 3.DONE - ConsultationSlipRequestMgtSC.erpInterface : saveGWInfo (csr_no:"	+ JSPUtil.getNull(csrNo) + ") \n");
					}
					// BIZ스레드처리후 Exception 없다면 비동기(Biz) 커밋 :: Approval 결재 처리
					eventResponse.setUserMessage(new ErrorHandler("CSR10003").getUserMessage());
					commit();

				} catch (EventException ex) {
					rollback();
					log.error("\n --> rollback err >> " + ex.toString(), ex);

					String csrNo = JSPUtil.getNull(ifCsrListInputVOs[i].getCsrNo());
					String csrAproTpCd = JSPUtil.getNull(ifCsrListInputVOs[i].getCsrAproTpCd());

					if ("GW".equals(csrAproTpCd)) {
						hisVO.setCsrNo(csrNo);
						hisVO.setCsrAproTpCd("GW");
						hisVO.setAutoMnlFlg("N"); // 수동
						hisVO.setIoBndCd("O"); // ERP out
						hisVO.setCreUsrId(signOnUserAccount.getUsr_id());
						hisVO.setUpdUsrId(signOnUserAccount.getUsr_id());
						hisVO.setCorrHisRmk("IE"); // Error
						try {
							begin();
							command.saveGWInfo(hisVO);
							commit();
						} catch (Exception exx) {
							log.error("\n EXCEPTION csrNo : " + JSPUtil.getNull(csrNo) + " <<<<");
							continue;
						}
					} else if ("AL".equals(csrAproTpCd)) {
						hisVO.setCsrNo(csrNo);
						hisVO.setCsrAproTpCd("AL");
						hisVO.setAutoMnlFlg("N"); // 수동
						hisVO.setIoBndCd("O"); // ERP out
						hisVO.setCreUsrId(signOnUserAccount.getUsr_id());
						hisVO.setUpdUsrId(signOnUserAccount.getUsr_id());
						hisVO.setCorrHisRmk("IE"); // Error
						try {
							begin();
							command.saveGWInfo(hisVO);
							commit();
						} catch (Exception exx) {
							log.error("\n EXCEPTION csrNo : "+ JSPUtil.getNull(csrNo) + " <<<<");
							continue;
						}
					}
					// throw new EventException(ex.getMessage(), ex);
					continue;

				} catch (Exception ex) {
					rollback();
					log.error("\n --> rollback2 err" + ex.toString(), ex);
					// throw new EventException(ex.getMessage(), ex);
					continue;
				}
			}
		}
		return eventResponse;
	}
	
}