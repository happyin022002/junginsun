/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccountManageSC.java
*@FileTitle : AccountManageSC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.21 신혜정 [CHM-201114467-01] Cancelled Disposal Invoice history 저장  
* 2012.04.05 신혜정 [CHM-201217201] Disposal Invoice Issue 화면내 [Confirm], [Cancel] 처리시, invoice no 체크 로직 추가
					  1. [Confirm] 처리시, invoice no 유,무에 따른 체크 로직 추가
					   - invoice no 가 있을 경우 confirm 된 데이타 확인 후 존재시 return 처리
					   - invoice no 가 없을 경우(invoice status=New) Verify List 의 disposal no, eq_no 리스트로 invoice no 존재 확인후 있으면 return 처리
					  2. [Cancel] 처리시, Cancel invoice no 체크 로직 추가
					   - 기 Cancel invoice no 존재시 return 처리
* 2012.07.31 신혜정	[CHM-201219139]	FA Interface 로그 보완 작업	
* 2013.02.15 조경완  [CHM-201322898-01] ALPS-MNR-Disposal-Invoice Issue 화면에서 중복 현상 발생 건에 대한 수정 요청
* 2014.11.12 10만불 비용지급 결재 3차 Invoice File Attatch 기능 추가
* 2015.11.03 박정민 [CHM-201538638] M&R - Invoice creation 화면에서 EAS 시스템 결과 확인 요청 기능 개발
*                                   M&R Repair Invoice Save이후 EAS 심사결과 출력 도입
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage;
  
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBC;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnr0041Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnr0042Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnr0143Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnr0229Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnrS041Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.event.EesMnrS042Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.CustomPayableInvoiceDetailINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.GLEstimateVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.basic.IncomeMgtBC;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.basic.IncomeMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.event.EesMnr0161Event;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic.MnrAdvanceAuditBC;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic.MnrAdvanceAuditBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.component.backend.core.WorkOnLongTxRemoteServerManager;
import com.hanjin.framework.component.backend.vo.WorkOnLongTxRemoteServerInfo;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
   
/**
 * alps-AccountManage Business Logic ServiceCommand - alps-AccountManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 함형석
 * @see ExpenseMgtBC
 * @since J2EE 1.6 
 */ 

public class AccountManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AccountManage system 업무 시나리오 선행작업<br>
	 * AccountManage 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */ 
	public void doStart() {
		log.debug("AccountManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * AccountManage system 업무 시나리오 마감작업<br>
	 * AccountManage 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AccountManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-AgreementManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMnr0041Event")) {
			//조회 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchPayableINVInquiryListService(e);   
			} 
			//디테일 조회 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchPayableINVInquiryDetailService(e);   
			}   
			//Invoice 금액 환율변경 적용
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {      
				eventResponse = searchPayableINVInquiryCalCurrRateService(e);   
			}   			
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {      
				eventResponse = managePayableInvoiceService(e);   
			}   		 		
			//삭제 
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {      
				eventResponse = removePayableInvoiceService(e);   
			}   			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0143Event")) {
			//verify
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {      
				eventResponse = verifyPayableInvoiceFileListService(e);   
			}  		

		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0042Event")) {
			//조회 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchPayableINVInquiryListService(e);   
			} 
			//디테일 조회 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchPayableINVInquiryDetailService(e);   
			}   
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0161Event")) {
			//조회 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchReceivableInvoiceListService(e);   
			} 
			//디테일 조회 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchReceivableInvoiceDetailListService(e);   
			}   
			//저장 (SAVE 버튼)
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				log.debug("----------------- SAVE Disposal Invoice Issue -- ");
				eventResponse = modifyReceivableInvoiceService(e);   
			}  
		
			//삭제
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {      
				eventResponse = removeReceivableInvoiceService(e);   
			}
				
			// Confirm, Cancel 에서 invoice no 체크
			else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				log.debug("----------------- SAVE Disposal Invoice Issue Confirm 1 -- ");
				eventResponse = verifyInvoiceNoService(e);
			}
			// Confirm, Cancel 에서 invoice no 체크 완료후 진행
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {   
				log.debug("----------------- SAVE Disposal Invoice Issue Confirm 2 -- ");
				eventResponse = manageReceivableInvoiceService(e);   
			}  			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0229Event")) {
			//조회 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchGLEstimateIFListService(e);   
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {      
				eventResponse = manageBackEndGLEstimateIFListService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnrS041Event")) {
			//조회 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchPayableINVInquiryListService(e);   
			} 
			//디테일 조회 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchPayableINVInquiryDetailService(e);   
			}   
			//저장
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {      
				eventResponse = managePayableInvoiceService(e);   
			}  		
			//삭제
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {      
				eventResponse = removePayableInvoiceService(e);   
			}  			
		}		
		else if (e.getEventName().equalsIgnoreCase("EesMnrS042Event")) {
			//조회 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchPayableINVInquiryListService(e);   
			} 
			//디테일 조회 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchPayableINVInquiryDetailService(e);   
			}   
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0042 : Retrieve <br>
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableINVInquiryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExpenseMgtBC command = new ExpenseMgtBCImpl();       
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		
		try{  

			if(e.getEventName().equalsIgnoreCase("EesMnr0041Event")){
				EesMnr0041Event event = (EesMnr0041Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryListBasic(event.getPayableInvoiceGRPVO(),account);
			}else if(e.getEventName().equalsIgnoreCase("EesMnrS041Event")){
				EesMnrS041Event event = (EesMnrS041Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryListBasic(event.getPayableInvoiceGRPVO(),account);
			}else if(e.getEventName().equalsIgnoreCase("EesMnrS042Event")){
				EesMnrS042Event event = (EesMnrS042Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryListBasic(event.getPayableInvoiceGRPVO(),account);
			}else{
				EesMnr0042Event event = (EesMnr0042Event)e;   
				payableInvoiceGRPVO = command.searchPayableINVInquiryListBasic(event.getPayableInvoiceGRPVO(),account);
			}
			eventResponse.setRsVoList(payableInvoiceGRPVO.getCustomPayableINVInquiryListVOs());
			
		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EES_MNR_0042 : Retrieve <br>
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableINVInquiryDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpenseMgtBC command = new ExpenseMgtBCImpl();
		MnrAdvanceAuditBC easCommand = new MnrAdvanceAuditBCImpl();  
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		String auditDesc = "";
		
		try{  

			if(e.getEventName().equalsIgnoreCase("EesMnr0041Event")){
				EesMnr0041Event event = (EesMnr0041Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryDetailBasic(event.getPayableInvoiceGRPVO(),account);
			}else if(e.getEventName().equalsIgnoreCase("EesMnrS041Event")){
				EesMnrS041Event event = (EesMnrS041Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryDetailBasic(event.getPayableInvoiceGRPVO(),account);
			}else if(e.getEventName().equalsIgnoreCase("EesMnr0042Event")){
				EesMnr0042Event event = (EesMnr0042Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryDetailBasic(event.getPayableInvoiceGRPVO(),account);
			}else if(e.getEventName().equalsIgnoreCase("EesMnrS042Event")){
				EesMnrS042Event event = (EesMnrS042Event)e;  
				payableInvoiceGRPVO = command.searchPayableINVInquiryDetailBasic(event.getPayableInvoiceGRPVO(),account);
			}
			
			
			eventResponse.setRsVoList(payableInvoiceGRPVO.getCustomPayableInvoiceDetailINVOs());
			if(payableInvoiceGRPVO.getCustomPayableInvoiceDetailINVOs().isEmpty()){
				eventResponse.setETCData("dp_prcs_knt", ""); 
			}else{
				eventResponse.setETCData("dp_prcs_knt", payableInvoiceGRPVO.getCustomPayableInvoiceDetailINVOs().get(0).getDpPrcsKnt()); 
			}
			
			if(e.getEventName().equalsIgnoreCase("EesMnr0041Event")){
				EesMnr0041Event event = (EesMnr0041Event)e;
				// 혹시 모를 Null 체크
				if(event.getPayableInvoiceGRPVO() != null && event.getPayableInvoiceGRPVO().getPayableINVInquiryINVO() != null)
				auditDesc = easCommand.auditMnrInvoice(event.getPayableInvoiceGRPVO().getPayableINVInquiryINVO().getWoNo(), event.getPayableInvoiceGRPVO().getPayableINVInquiryINVO().getMnrPrnrSeq());
				eventResponse.setETCData("eas_audit_desc", auditDesc);
			}
			
		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	

	/**
	 * EES_MNR_0041 : Save <br>
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePayableInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

  		ExpenseMgtBC command = new ExpenseMgtBCImpl();       
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl(); 
		RepairMgtBC command4 = new RepairMgtBCImpl();
		
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO(); 
		
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0041Event")){
			EesMnr0041Event event = (EesMnr0041Event)e;  
			payableInvoiceGRPVO = event.getPayableInvoiceGRPVO();   
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS041Event")){ 
			EesMnrS041Event event = (EesMnrS041Event)e;    
			payableInvoiceGRPVO = event.getPayableInvoiceGRPVO();  
		} 		
		
		PayableInvoiceGRPVO payableInvoiceGRPVO2 = new PayableInvoiceGRPVO(); //event.getPayableInvoiceGRPVO();
		eQFlagListGRPVO.setEQFlagListINVO(payableInvoiceGRPVO.getEQFlagListINVO());
		
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		CustomMnrOrdDtlVO customMnrOrdDtlVO = new CustomMnrOrdDtlVO();
		
		String req_no = ""; 
		
		try{  
			begin(); 	
			
			//MNR_PAY_INV_WRK 등록,수정
			payableInvoiceGRPVO2 = command.manageRepairPayableInvoiceBasic(payableInvoiceGRPVO, account);

			if(account.getAccess_system().equals("ALP")){
				//MNR_ORD_DTL invoice정보 clear
				if(!payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq().equals("")){
					customMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq());
					generalWOGRPVO.setCustomMnrOrdDtlVO(customMnrOrdDtlVO);
					command4.modifyWEBInvoiceLinkClearBasic(generalWOGRPVO, account);
				}
			}
			
			//MNR_ORD_DTL invoice정보 수정
			CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO[payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs().length];

			CustomPayableInvoiceDetailINVO[] arrCustomPayableInvoiceDetailINVOs = payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs();
			
			for ( int i = 0; i< arrCustomPayableInvoiceDetailINVOs.length; i++ ) {  
				CustomMnrOrdDtlVO tempCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO();
					
				tempCustomMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq());
				tempCustomMnrOrdDtlVO.setInvNo(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getInvNo());
				tempCustomMnrOrdDtlVO.setSlsTaxAmt(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getSlsTaxAmt());
				tempCustomMnrOrdDtlVO.setEnvChgTax(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getEnvChgTax()); // 인도지역의 SBC Tax
				tempCustomMnrOrdDtlVO.setInvAmt(arrCustomPayableInvoiceDetailINVOs[i].getInvAmt());
				tempCustomMnrOrdDtlVO.setRprRsltDt(arrCustomPayableInvoiceDetailINVOs[i].getRprRsltDt());
				tempCustomMnrOrdDtlVO.setMnrOrdOfcCtyCd(arrCustomPayableInvoiceDetailINVOs[i].getMnrOrdOfcCtyCd());
				tempCustomMnrOrdDtlVO.setMnrOrdSeq(arrCustomPayableInvoiceDetailINVOs[i].getMnrOrdSeq());
				tempCustomMnrOrdDtlVO.setOrdDtlSeq(arrCustomPayableInvoiceDetailINVOs[i].getOrdDtlSeq());
				tempCustomMnrOrdDtlVO.setIdaSacCd(arrCustomPayableInvoiceDetailINVOs[i].getIdaSacCd());
				tempCustomMnrOrdDtlVO.setIdaCgstRto(arrCustomPayableInvoiceDetailINVOs[i].getIdaCgstRto());
				tempCustomMnrOrdDtlVO.setIdaSgstRto(arrCustomPayableInvoiceDetailINVOs[i].getIdaSgstRto());
				tempCustomMnrOrdDtlVO.setIdaIgstRto(arrCustomPayableInvoiceDetailINVOs[i].getIdaIgstRto());
				tempCustomMnrOrdDtlVO.setIdaUgstRto(arrCustomPayableInvoiceDetailINVOs[i].getIdaUgstRto());
				tempCustomMnrOrdDtlVO.setIdaCgstAmt(arrCustomPayableInvoiceDetailINVOs[i].getIdaCgstAmt());
				tempCustomMnrOrdDtlVO.setIdaSgstAmt(arrCustomPayableInvoiceDetailINVOs[i].getIdaSgstAmt());
				tempCustomMnrOrdDtlVO.setIdaIgstAmt(arrCustomPayableInvoiceDetailINVOs[i].getIdaIgstAmt());
				tempCustomMnrOrdDtlVO.setIdaUgstAmt(arrCustomPayableInvoiceDetailINVOs[i].getIdaUgstAmt());
				arrCustomMnrOrdDtlVO[i] = tempCustomMnrOrdDtlVO;     	
			} 		     
			generalWOGRPVO.setArrCustomMnrOrdDtlVOS(arrCustomMnrOrdDtlVO);
			
			//Invoice Status를 넘겨준다.
			generalWOGRPVO.setMnrInvStsCd(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd());
			
			command4.modifyWEBInvoiceLinkBasic(generalWOGRPVO,account);
			
			if(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd().equals("HC")){
				
				//CSR처리	
				req_no = command2.createCSRIFBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getMnrGrpTpCd(), payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(), account);
				
				//MNR_ORD_DTL req_no 수정
				command.modifyTotalLossPayableInvoiceBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(),req_no, account, payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getFileSeq());
				CustomPayableInvoiceDetailINVO[] arrCustomPayableInvoiceDetailINVO = payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs();
				
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				
				List<CustomMnrEqStsVO> listCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				List<CustomMnrFlgHisVO> listCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
					
				for ( int i = 0; i< arrCustomPayableInvoiceDetailINVO.length; i++ ) {  
					if(arrCustomPayableInvoiceDetailINVO[i].getMnrWoTpCd().equals("EST")){
						boolean isDupEqNo = false;	
						for (int j = 0; j < listCustomMnrEqStsVOS.size(); j++) {
							if(listCustomMnrEqStsVOS.get(j).getEqNo().equalsIgnoreCase(arrCustomPayableInvoiceDetailINVO[i].getEqNo())){
								isDupEqNo = true;
							}
						}
						
						if(!isDupEqNo){	
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(arrCustomPayableInvoiceDetailINVO[i].getEqNo());
							customMnrEqStsVO.setMnrDmgFlg("0");
							customMnrEqStsVO.setMnrStsRmk("By Repair Invoice");
							customMnrEqStsVO.setEqTpszCd(arrCustomPayableInvoiceDetailINVO[i].getEqTpszCd());
							customMnrEqStsVO.setEqKndCd(arrCustomPayableInvoiceDetailINVO[i].getEqKndCd());
							customMnrEqStsVO.setMnrDmgFlgYdCd(arrCustomPayableInvoiceDetailINVO[i].getYdCd());
							listCustomMnrEqStsVOS.add(customMnrEqStsVO);
							
							IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
							iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
							iFMnrFlagVO.setFlagUserId(account.getUsr_id());
							iFMnrFlagVO.setFlagType("DMG");
							iFMnrFlagVO.setRetireFlag("N");
							iFMnrFlagVO.setEqKindCd(arrCustomPayableInvoiceDetailINVO[i].getEqKndCd());
							iFMnrFlagVO.setEqNo(arrCustomPayableInvoiceDetailINVO[i].getEqNo());
							iFMnrFlagVO.setStsFlag("N");
							iFMnrFlagVO.setFlagDt(arrCustomPayableInvoiceDetailINVO[i].getRprRsltDt());
							iFMnrFlagVO.setFlagYdCd(arrCustomPayableInvoiceDetailINVO[i].getYdCd());
							iFMnrFlagVOS.add(iFMnrFlagVO);

							CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
							customMnrFlgHisVO.setMnrFlgTpCd("DMG"); 
							customMnrFlgHisVO.setMnrStsFlg("0");
							customMnrFlgHisVO.setMnrFlgInpTpCd("I");   
							customMnrFlgHisVO.setEqNo(arrCustomPayableInvoiceDetailINVO[i].getEqNo());
							customMnrFlgHisVO.setEqTpszCd(arrCustomPayableInvoiceDetailINVO[i].getEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(arrCustomPayableInvoiceDetailINVO[i].getYdCd());
							customMnrFlgHisVO.setEqKndCd(arrCustomPayableInvoiceDetailINVO[i].getEqKndCd());
							listCustomMnrFlgHisVOS.add(customMnrFlgHisVO);
						}
					}	
				}  
				
				if(iFMnrFlagVOS.size() > 0){	
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);	
					eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
					
					CustomMnrEqStsVO[] customMnrEqStsVOS = new CustomMnrEqStsVO[listCustomMnrEqStsVOS.size()];		
					CustomMnrFlgHisVO[] customMnrFlgHisVOS = new CustomMnrFlgHisVO[listCustomMnrFlgHisVOS.size()];	
					
					for (int j = 0; j < listCustomMnrEqStsVOS.size(); j++) {
						customMnrEqStsVOS[j] = listCustomMnrEqStsVOS.get(j);	
					}
					for (int j = 0; j < listCustomMnrFlgHisVOS.size(); j++) {
						customMnrFlgHisVOS[j] = listCustomMnrFlgHisVOS.get(j);	
					}
					
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
					
					command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command2.manageIFFlagBasic(interfaceGRPVO,account);
				} 	
			}   
			eventResponse.setETCData("pay_inv_seq", payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq()); 
				
			commit();
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0041 : Delete <br>
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePayableInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EesMnr0041Event event = (EesMnr0041Event)e;    
		ExpenseMgtBC command = new ExpenseMgtBCImpl();     
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		RepairMgtBC command3 = new RepairMgtBCImpl();

		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0041Event")){
			EesMnr0041Event event = (EesMnr0041Event)e;  
			payableInvoiceGRPVO = event.getPayableInvoiceGRPVO();   
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS041Event")){ 
			EesMnrS041Event event = (EesMnrS041Event)e;    
			payableInvoiceGRPVO = event.getPayableInvoiceGRPVO();  
		} 	
		
		//PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		CustomMnrOrdDtlVO customMnrOrdDtlVO = new CustomMnrOrdDtlVO();
		
		try{  
			begin(); 
			
			if(payableInvoiceGRPVO.getPayableINVInquiryINVO().getInvRgstNo().equals("")){
				command.removePayableInvoiceBasic(payableInvoiceGRPVO,account);								
				if(account.getAccess_system().equals("ALP")){
					customMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO.getPayableINVInquiryINVO().getPayInvSeq());
					generalWOGRPVO.setCustomMnrOrdDtlVO(customMnrOrdDtlVO);
					command3.modifyWEBInvoiceLinkClearBasic(generalWOGRPVO, account);
				}		
					
			}else{
				command2.removeCSRIFBasic(payableInvoiceGRPVO.getPayableINVInquiryINVO().getInvRgstNo(), account);
				command.modifyPayableInvoiceStatusBasic(payableInvoiceGRPVO,account);
			}
			//eventResponse.setRsVoList(payableInvoiceGRPVO.getCustomPayableInvoiceDetailINVOs());
			commit();
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0143 : Verify <br>
	 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 체크 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyPayableInvoiceFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0143Event event = (EesMnr0143Event)e;    

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOs());
		
		GeneralCodeINVO generalCodeINVO = new GeneralCodeINVO();
		generalCodeCheckMgtGRPVO.setGeneralCodeINVO(generalCodeINVO);
		
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		try{  
			begin(); 
			
			//공통함수를 이용 임시테이블에 입력하고, 시퀀스를 얻어온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account); 
			
			generalCodeCheckMgtGRPVO.getGeneralCodeINVO().setTmpSeq(seqValue);
			
			generalCodeCheckMgtGRPVO = command.verifyPayableInvoiceFileListBasic(generalCodeCheckMgtGRPVO,account);
			
			eventResponse.setRsVoList(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyListVO());
			commit();
			
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 *   EES_MNR_0161:   <br>
	 * [ EES_MNR_0161] 의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableInvoiceListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		IncomeMgtBC command = new IncomeMgtBCImpl();       
		ReceivableInvoiceGRPVO receivableInvoiceGRPVO = new ReceivableInvoiceGRPVO();
		EesMnr0161Event event = (EesMnr0161Event)e;  
		try{  
			
			receivableInvoiceGRPVO = command.searchReceivableInvoiceListBasic(event.getReceivableInvoiceGRPVO(),account);
			eventResponse.setRsVoList(receivableInvoiceGRPVO.getCustomReceivableINVInquiryListVOs());
			
		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EES_MNR_0161 : Retrieve <br>
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceivableInvoiceDetailListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0161Event event = (EesMnr0161Event)e;    
		IncomeMgtBC command = new IncomeMgtBCImpl();       
		ReceivableInvoiceGRPVO receivableInvoiceGRPVO = new ReceivableInvoiceGRPVO();
		try{  
			receivableInvoiceGRPVO = command.searchReceivableInvoiceDetailListBasic(event.getReceivableInvoiceGRPVO());
			eventResponse.setRsVoList(receivableInvoiceGRPVO.getCustomReceivableInvoiceDetailINVOs());
		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0161 : Save <br>
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReceivableInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0161Event event = (EesMnr0161Event)e;    
		IncomeMgtBC command = new IncomeMgtBCImpl();      
		DisposalMgtBC command2 = new DisposalMgtBCImpl();   
		GeneralARInvoiceCreationBC command3	= new  GeneralARInvoiceCreationBCImpl();
		InterfaceMgtBC command4 = new InterfaceMgtBCImpl(); 
		
		ReceivableInvoiceGRPVO receivableInvoiceGRPVO = event.getReceivableInvoiceGRPVO(); //new ReceivableInvoiceGRPVO();

		List<ARInterfaceCreationVO> aRInterfaceCreationVOs = new ArrayList<ARInterfaceCreationVO>();
		ARInterfaceCreationVO aRInterfaceCreationVO = new ARInterfaceCreationVO();

		try{  
			if(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getCancelYn().equals("")){

                begin();
				//MNR_DISP_DTL invoice정보 clear
				event.getDisposalGRPVO().getCustomMnrDispDtlVO().setInvNo(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo());
				if(!event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo().equals("")){
					command2.modifyDisposalInvoiceLinkClearBasic(event.getDisposalGRPVO(),account);
				}
				
				//MNR_RCV_INV_WRK 정보 등록,수정
				receivableInvoiceGRPVO = command.manageRepairReceivableInvoiceBasic(event.getReceivableInvoiceGRPVO(),account);
				
				//MNR_DISP_DTL invoice정보 update
				DisposalGRPVO disposalGRPVO = new DisposalGRPVO();
				
				CustomMnrDispDtlVO[] arrCustomMnrDispDtlVO = new CustomMnrDispDtlVO[event.getReceivableInvoiceGRPVO().getArrayCustomReceivableInvoiceDetailINVOs().length];

				if(receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs() != null){
					CustomReceivableInvoiceDetailINVO[] arrCustomReceivableInvoiceDetailINVO = receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs();
					for ( int i = 0; i< arrCustomReceivableInvoiceDetailINVO.length; i++ ) {  
						CustomMnrDispDtlVO customMnrDispDtlVO = new CustomMnrDispDtlVO();
						
						customMnrDispDtlVO.setRcvInvSeq(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq());
						customMnrDispDtlVO.setInvNo(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo());
						customMnrDispDtlVO.setInvAmt(arrCustomReceivableInvoiceDetailINVO[i].getInvAmt());
						customMnrDispDtlVO.setDispNo(arrCustomReceivableInvoiceDetailINVO[i].getDispNo());
						customMnrDispDtlVO.setDispDtlSeq(arrCustomReceivableInvoiceDetailINVO[i].getDispDtlSeq());
						arrCustomMnrDispDtlVO[i] = customMnrDispDtlVO;
					}      
					disposalGRPVO.setArrCustomMnrDispDtlVOS(arrCustomMnrDispDtlVO);
				}
				command2.modifyDisposalInvoiceLinkBasic(disposalGRPVO,account);
                commit();

			}	

			if(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getMnrInvStsCd().equals("HC")){

				receivableInvoiceGRPVO = command4.searchInvArIfListBasic(event.getReceivableInvoiceGRPVO(),account);
				
				aRInterfaceCreationVO.setInvArIfMnVO(receivableInvoiceGRPVO.getInvArIfMnVO());
				aRInterfaceCreationVO.setInvArIfChgVOs(receivableInvoiceGRPVO.getInvArIfChgVOs());
				aRInterfaceCreationVO.setInvArIfCntrVOs(receivableInvoiceGRPVO.getInvArIfCntrVOs());
				aRInterfaceCreationVOs.add(aRInterfaceCreationVO);

                begin();
				aRInterfaceCreationVOs = command3.interfaceGeneralARInvoiceToIF(aRInterfaceCreationVOs);
                commit();
                begin();
				String strResult = command3.interfaceGeneralARInvoiceToINV(aRInterfaceCreationVOs);
                commit();
                
                
                begin();
				String[] strResults =  strResult.split("::");
				
				//[2011-05-26 Kim Jong Ock] ERP로직 분리
				if(strResults[0].equals("S")){
	    			command3.interfaceARInvoiceToERPAR(strResults[1]);
				}
				
				if(strResults[0].equals("E")){
					
					if(!event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getCancelYn().equals("Y")){
						//MNR_RCV_INV_WRK 정보 수정
						command.manageRepairReceivableInvoiceStateHsBasic(event.getReceivableInvoiceGRPVO(),account);
					}	
					commit();	
					throw new EventException(new ErrorHandler("MNR00001",new String[]{strResults[1]}).getMessage());
				}else{

					if(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getCancelYn().equals("Y")){
						
						// start Cancelled Disposal Invoice history 추가 (이력 데이터 생성) 

						// 1. MNR_CXL_RCV_INV_WRK 저장 	
						command.addReceivableInvoiceCancelledBasic(receivableInvoiceGRPVO, account);
						// 2. MNR_DISP_CXL_HDR 저장
						command2.addDisposalHRDCancelledBasic(receivableInvoiceGRPVO);
						// 3. MNR_DISP_CXL_DTL 저장							
						command2.addDisposalDTLCancelledBasic(receivableInvoiceGRPVO);
						
						// end Cancelled Disposal Invoice history 추가 (이력 데이터 생성)						
						
						receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setMnrInvStsCd("HS");
						command.modifyReceivableInvoiceStatusBasic(receivableInvoiceGRPVO,account);
					}
					commit();
				}
				
				begin();
				//FA 전송
				InterfaceMgtBC command10	= new 	InterfaceMgtBCImpl();
				CustomReceivableInvoiceDetailINVO[] arrCustomReceivableInvoiceDetailINVO = receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs();
				FaErpListVO[] arrayfaErpListVOs = new FaErpListVO[arrCustomReceivableInvoiceDetailINVO.length];
				String ymdhms = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
				String ymdhm  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
				
				for ( int i = 0; i< arrCustomReceivableInvoiceDetailINVO.length; i++ ) {  
					FaErpListVO faErpListVO = new FaErpListVO();
					faErpListVO.setLifid("FNS027-0001");
					faErpListVO.setSeq(ymdhms + arrCustomReceivableInvoiceDetailINVO[i].getEqNo());
					faErpListVO.setTotalCount(String.valueOf(arrCustomReceivableInvoiceDetailINVO.length));
					faErpListVO.setRnum(String.valueOf(i+1));
					//Tag Number search start////////////////////////////////
					String faEqNo = "";
					String eqNo		= arrCustomReceivableInvoiceDetailINVO[i].getEqNo();
					faEqNo	= command10.searchFAEqNoBasic(eqNo);
					faErpListVO.setTagNumber(faEqNo);
					//Tag Number search end//////////////////////////////////
					faErpListVO.setBookTypeCode("SML GAAP BOOK");
					faErpListVO.setDateRetired(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInvDt().replace("-", ""));					
					faErpListVO.setProceedsOfSale(arrCustomReceivableInvoiceDetailINVO[i].getInvAmt().replace(",", ""));
					faErpListVO.setInvoiceNo(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo());
					faErpListVO.setUnitsRetired("1");
					faErpListVO.setRetirementTypeCode("SALE");
					faErpListVO.setInterfaceFlag("N");
					faErpListVO.setCreationDate(ymdhm);
					faErpListVO.setLastUpdateDate(ymdhm);
					faErpListVO.setSoldTo("136514");		
					//추가 2010-07-08	
					faErpListVO.setLclAmt(arrCustomReceivableInvoiceDetailINVO[i].getInvAmt().replace(",", ""));
					faErpListVO.setLclCurr(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getCurrCd());       
						
					arrayfaErpListVOs[i] = faErpListVO; 	
				}     
				//전송
				command10.faSendBasic(arrayfaErpListVOs, account, "DSP"); // Disposal Invoice Issue 구분(DSP)
				
				commit();
			}

			eventResponse.setETCData("rcv_inv_seq", receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq()); 
			eventResponse.setETCData("input_inv_no", receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo()); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_MNR_0161 : Delete <br>
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeReceivableInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0161Event event = (EesMnr0161Event)e;    
		IncomeMgtBC command = new IncomeMgtBCImpl();       
		DisposalMgtBC command2 = new DisposalMgtBCImpl();    

		try{  
			begin(); 
			command.removeReceivableInvoiceBasic(event.getReceivableInvoiceGRPVO(),account);
			
			event.getDisposalGRPVO().getCustomMnrDispDtlVO().setInvNo(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo());
			command2.modifyDisposalInvoiceLinkClearBasic(event.getDisposalGRPVO(),account);
			
			commit();
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_MNR_0229 : Retrieve<br>  
	 * M&R Estimate expense를 조회합니다.<br>
	 *  
	 * @param e Event   
	 * @return response EventResponse    
	 * @exception EventException   
	 */
	private EventResponse searchGLEstimateIFListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0229Event event = (EesMnr0229Event)e;    
		ExpenseMgtBC command = new ExpenseMgtBCImpl();       
		
		try{  			
			List<GLEstimateVO> list = command.searchGLEstimateIFListBasic(event.getGLEstimateINVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_MNR_0229 : Confirm-BackEndJob <br>	
	 * [EES_MNR_0229] manageGLEstimateIFListService를 호출하기 위한 <br>
	 *			
	 * @param Event e		
	 * @return EventResponse response			
	 * @exception EventException					
	 */		
	private EventResponse manageBackEndGLEstimateIFListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {		
			WorkOnLongTxRemoteServerManager mng = new WorkOnLongTxRemoteServerManager();		
			WorkOnLongTxRemoteServerInfo info = new WorkOnLongTxRemoteServerInfo();
			info.setCallScName("com.hanjin.apps.alps.ees.mnr.accountmanage.AccountManageSC");
			info.setCallMethodName("manageGLEstimateIFListService");  
			info.setEvent(e);	
			info.setUserId(account.getUsr_id());
			info.setJobMessage("AccountManageSC-manageGLEstimateIFListService");
			mng.execute(info);	
			
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}						
		return eventResponse;						 
	}		
		
	/**
	 * EES_MNR_0229 : Confirm<br>  
	 * M&R Estimate expense를 Confirm 합니다.<br>
	 * Time Out Error begin-tran 삭제   
	 *  
	 * @param e Event   
	 * @return response EventResponse    
	 * @exception EventException   
	 */		 		
	public EventResponse manageGLEstimateIFListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0229Event event = (EesMnr0229Event)e;      
		ExpenseMgtBC command = new ExpenseMgtBCImpl();        
		
		try{							 			      	
			command.manageGLEstimateIFListBasic(event.getGLEstimateINVO(),e.getSignOnUserAccount());
		}catch(EventException ex){	 	
			throw ex;		
		}catch(Exception ex){	
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	

	/**
	 * EES_MNR_0141 : Conv <br>
	 * [EES_MNR_0141]M&R Invoice 금액을 환율변경적용 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableINVInquiryCalCurrRateService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0041Event event = (EesMnr0041Event)e;    

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOs());
		
		GeneralCodeINVO generalCodeINVO = new GeneralCodeINVO();
		generalCodeCheckMgtGRPVO.setGeneralCodeINVO(generalCodeINVO);
		
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		try{  
			begin(); 
			
			//공통함수를 이용 임시테이블에 입력하고, 시퀀스를 얻어온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account); 
			
			generalCodeCheckMgtGRPVO.getGeneralCodeINVO().setTmpSeq(seqValue);
			
			generalCodeCheckMgtGRPVO = command.searchPayableINVInquiryCalCurrRateBasic(generalCodeCheckMgtGRPVO,account);
			
			eventResponse.setRsVoList(generalCodeCheckMgtGRPVO.getCustomMnrDatVrfyListVO());
			commit();
			
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0161 : Confirm, Cancel <br>
	 * [EES_MNR_0161] Disposal Invoice Issue의 Confirm, Cancel 시 invoice no 에 대한 검증을 실시합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyInvoiceNoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0161Event event = (EesMnr0161Event)e;    
		IncomeMgtBC command = new IncomeMgtBCImpl();      
		
		ReceivableInvoiceGRPVO receivableInvoiceGRPVO = event.getReceivableInvoiceGRPVO();

		String rtnVal = "";

		try{
			// invoice no 가 없는 상태.
			if("".equals(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo()) ||
				null == receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo()){
				// dispNo, eqNo 로 invNo 유무 체크
				if(receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs() != null){
					CustomReceivableInvoiceDetailINVO[] arrCustomReceivableInvoiceDetailINVO = receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs();
					for ( int i = 0; i< arrCustomReceivableInvoiceDetailINVO.length; i++ ) {  
						CustomMnrDispDtlVO customMnrDispDtlVO = new CustomMnrDispDtlVO();
						
						customMnrDispDtlVO.setDispNo(arrCustomReceivableInvoiceDetailINVO[i].getDispNo());
						customMnrDispDtlVO.setEqNo(arrCustomReceivableInvoiceDetailINVO[i].getEqNo());
						rtnVal = command.checkVerifiedInvNoBasic(customMnrDispDtlVO);
						if(!"".equals(rtnVal)){
							// invoice no 가 있으면, X로 셋팅. 작업 불가능
							rtnVal = "X";
							break;
						} 
					}      
				}				
				
			}else{
				// invoice no 로 Confirm, Cancel 가능 여부 체크(X 이면 존재함. 작업 불가능)
				rtnVal = command.checkReceivableInvNoBasic(receivableInvoiceGRPVO.getReceivableINVInquiryINVO());
			}
			
			eventResponse.setETCData("gubun", rtnVal);

		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	
	
	/**
	 * EES_MNR_0161 : Save <br>
	 * [EES_MNR_0161]Disposal Invoice Issue의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyReceivableInvoiceService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0161Event event = (EesMnr0161Event)e;    
		IncomeMgtBC command = new IncomeMgtBCImpl();      
		DisposalMgtBC command2 = new DisposalMgtBCImpl();   
		
		ReceivableInvoiceGRPVO receivableInvoiceGRPVO = event.getReceivableInvoiceGRPVO(); //new ReceivableInvoiceGRPVO();

		try{  
			begin();
				
			//MNR_DISP_DTL invoice정보 clear
			event.getDisposalGRPVO().getCustomMnrDispDtlVO().setInvNo(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo());
			if(!event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo().equals("")){
				command2.modifyDisposalInvoiceLinkClearBasic(event.getDisposalGRPVO(),account);
			}
				
			//MNR_RCV_INV_WRK 정보 등록,수정
			receivableInvoiceGRPVO = command.manageRepairReceivableInvoiceBasic(event.getReceivableInvoiceGRPVO(),account);
				
			//MNR_DISP_DTL invoice정보 update
			DisposalGRPVO disposalGRPVO = new DisposalGRPVO();
				
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVO = new CustomMnrDispDtlVO[event.getReceivableInvoiceGRPVO().getArrayCustomReceivableInvoiceDetailINVOs().length];

			if(receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs() != null){
				CustomReceivableInvoiceDetailINVO[] arrCustomReceivableInvoiceDetailINVO = receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs();
				for ( int i = 0; i< arrCustomReceivableInvoiceDetailINVO.length; i++ ) {  
					CustomMnrDispDtlVO customMnrDispDtlVO = new CustomMnrDispDtlVO();
						
					customMnrDispDtlVO.setRcvInvSeq(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq());
					customMnrDispDtlVO.setInvNo(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo());
					customMnrDispDtlVO.setInvAmt(arrCustomReceivableInvoiceDetailINVO[i].getInvAmt());
					customMnrDispDtlVO.setDispNo(arrCustomReceivableInvoiceDetailINVO[i].getDispNo());
					customMnrDispDtlVO.setDispDtlSeq(arrCustomReceivableInvoiceDetailINVO[i].getDispDtlSeq());
					arrCustomMnrDispDtlVO[i] = customMnrDispDtlVO;
				}      
				disposalGRPVO.setArrCustomMnrDispDtlVOS(arrCustomMnrDispDtlVO);
			}
			command2.modifyDisposalInvoiceLinkBasic(disposalGRPVO,account);
            commit();

			eventResponse.setETCData("rcv_inv_seq", receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq()); 
			eventResponse.setETCData("input_inv_no", receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo()); 
		}catch(EventException ex){ 
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}		
	
}