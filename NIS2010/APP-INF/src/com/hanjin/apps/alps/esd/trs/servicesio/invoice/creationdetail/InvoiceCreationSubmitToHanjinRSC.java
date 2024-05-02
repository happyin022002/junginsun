/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationSubmitToHanjinRSC.java
*@FileTitle : SPP TRS Invoice Creation Submit
*Open Issues :
*Change history :
* 2007-03-28 sunghwan cho : 신규 작성
* 2007-04-03 sunghwan cho : PI eNIS와 파라미터 1차 수정
* 2007-04-04 sunghwan cho : PI eNIS와 파라미터 2차 수정
* 2007-04-05 sunghwan cho : Submit시 Cancel처리를 선행하여 Modify시에도 동일 모듈 처리
* 2007-04-10 sunghwan cho : Surcharge Data Set 변경
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
* 2007-04-11 sunghwan cho : trsp_inv_act_sts_cd 를 'O'로 세팅 (정원근 수석 요청사항)
* 2007-04-12 sunghwan cho : trs_trsp_inv_wrk 테이블의 invoice amount = invoice basic amount + invoice additional amount (정원근 수석 요청사항)
* 2007-04-23 sunghwan cho : Invoice Office 취득 SQL 변경
* 2007-07-20 jungjae kim : to send parameters to TRS, saveInvoiceCreation 수정
*@LastModifyDate : 2007-07-20
*@LastModifier : jungjae kim
*@LastVersion : 1.9
=========================================================
History
2012.02.15 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가(1건)
2012.02.20 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가건 추가수정(1건)
2012.04.12 윤권영 [] 오류원인 파악을 위한 로그 강화
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail;

//SPP Portal Interface
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.InvoiceAuditVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.vo.SearchInvoiceAuditVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.basic.InvoiceCreationDetailBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.basic.InvoiceCreationDetailBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.MultiInvoiceCreationDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.basic.InvoiceSurchargeBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.basic.InvoiceSurchargeBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.surcharge.event.InvoiceSurchargeInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.basic.InvoiceCancelManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.basic.InvoiceCancelManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.invoicecancelmanage.event.InvoiceCancelEvent;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * Remote Service Command<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationSubmitToHanjinRSC extends ServiceCommandSupport {
	private static final long serialVersionUID = 1L;

    /**
     * perform<BR>
     * 
     * @param e Event
     * @return eventResponse EventResponse
     * @throws EventException
     */
    public EventResponse perform(Event e) throws EventException {
        EventResponse eventResponse = null;
        
        if (e.getEventName().equalsIgnoreCase("SppTrsU02Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)
        			&& !((SppTrsU02Event)e).getMultiYN().equals("Y")) {
        		eventResponse = saveInvoiceCreation(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)
        			&& ((SppTrsU02Event)e).getMultiYN().equals("Y")) {
        		eventResponse = checkMultiInvoiceCreation(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)
        			&& ((SppTrsU02Event)e).getMultiYN().equals("Y")) {
        		eventResponse = saveMultiInvoiceCreation(e);
        	} 
        }
        
        return eventResponse;
    }
    
    /**
     * saveInvoiceCreation<BR>
     * 
     * @param e Event
     * @return eventResponse SPP_TRS_U02EventResponse
     * @throws EventException
     */
    private EventResponse saveInvoiceCreation(Event e) throws EventException {
    	SppTrsU02EventResponse eventResponse = null;
        
        try {
        	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC saveInvoiceCreation Start!");

        	begin();

        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsU02Event event = (SppTrsU02Event)e;
        	EsdTrs0033Event esd_trs_033Event = new EsdTrs0033Event();
        	
        	//입력된 값 검증
        	checkInputValue(event);
        	//Equipment Save 후 ALPS에서 W/O Amount 변경여부 체크
        	checkWOAmountChange(event);
        	//Container Movement 체크
        	checkContainerMovementStatus(event);
        	//Work Order Number 존재여부 체크
        	checkExistWorkOrderNo(event);
        	
        	/** 
        	 * Submit Process
        	 * 1) Invoice Cancel
        	 * 2) Invoice Insert
        	 * - Surcharge Set
        	 * - Invoice Master Set
        	 * - Currency Set
        	 * - Service Order Set
        	 */
        	
        	//기존 Invoice 정보 삭제 (신규 등록 및 Modify를 위해 기존 정보를 삭제후 신규등록)
        	cancelInvoice(event);
        	
        	//Surcharge 정보 생성
        	Collection surchargeVOCollection = makeSurcharge(event);
        	
        	//2007-07-20 : 추가,TRS 요청에 의한 변경.
        	InvoiceSurchargeBC command_surcharge = new InvoiceSurchargeBCImpl();
        	surchargeVOCollection = command_surcharge.searchWorkOrderSurchargeInquiryForTRS(event,surchargeVOCollection);

        	SurchargeVO[] surchargeVOs = null;
        	
        	surchargeVOs = (SurchargeVO[])surchargeVOCollection.toArray(new SurchargeVO[0]);
        	esd_trs_033Event.setSurchargeVOs(surchargeVOs);
    	
        	//Invoice Summary 정보 생성
        	esd_trs_033Event.setSearchInvoiceAuditVO(makeInvoiceSummary(event));
        	
        	//InvoiceAudit 정보 생성
        	InvoiceAuditVO[] invoiceAuditVOs = null;
        	invoiceAuditVOs = (InvoiceAuditVO[])makeInvoiceAudit(event, surchargeVOCollection).toArray(new InvoiceAuditVO[0]);
        	esd_trs_033Event.setInvoiceAuditVOs(invoiceAuditVOs);
        	
        	//TRS_TRSP_SVC_ORD 정보 생성
        	TrsTrspSvcOrdVO[] trsTrspWrkOrdVOs = null;
        	trsTrspWrkOrdVOs = (TrsTrspSvcOrdVO[])makeServiceOrder(event, surchargeVOCollection).toArray(new TrsTrspSvcOrdVO[0]);
        	esd_trs_033Event.setTrsTrspSvcOrdVOS(trsTrspWrkOrdVOs);
        	//Basic Command 생성
        	InvoiceAuditBC command = new InvoiceAuditBCImpl();
        	
        	/* EventResponse는 정상 수행시에도 NULL로 넘어온다. */
        	command.saveInvoiceAudit(esd_trs_033Event);

        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsU02EventResponse();
        	eventResponse.setCount(1);

            commit();
         
        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * saveMultiInvoiceCreation<BR>
     * 
     * @param e Event
     * @return eventResponse SppTrsU02EventResponse
     * @throws EventException
     */
    private EventResponse checkMultiInvoiceCreation(Event e) throws EventException {
    	SppTrsU02EventResponse eventResponse = null;
        
        try {

        	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC saveInvoiceCreation Start!");
        	begin();
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsU02Event event = (SppTrsU02Event)e;
        	
        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsU02EventResponse();
        	
        	// Basic Command 생성
        	InvoiceCreationDetailBCImpl command = new InvoiceCreationDetailBCImpl();

        	// 입력된 Invoic번호의 중복여부 체크
           	int iResult = 0;
           	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList = command.checkMultiInvoiceValue(event);
           	
           	eventResponse.setErrInvoiceNo(multiInvoiceCreationDetailList.getErrInvoiceNo());
           	eventResponse.setErrWorkOrderNo(multiInvoiceCreationDetailList.getErrWorkOrderNo());
           	eventResponse.setCount(iResult);
        	commit();

        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * checkWOAmountChange<BR>
     * 
     * @param e Event
     * @return void
     * @throws EventException
     */
    private void checkWOAmountChange(Event e) throws EventException {
    	
    	try{
    		// Basic Command 생성
        	InvoiceCreationDetailBCImpl command = new InvoiceCreationDetailBCImpl();
    		command.checkWOAmountChange(e);
    	}catch (EventException de){
    		log.error(de);
    		throw new EventException(de.getMessage());
    	}  	
    }

    
    /**
     * checkContainerMovement<BR>
     * 
     * @param e Event
     * @return void
     * @throws EventException
     */
    private void checkContainerMovementStatus(Event e) throws EventException {
    	
    	try{
    		// Basic Command 생성
        	InvoiceCreationDetailBCImpl command = new InvoiceCreationDetailBCImpl();
    		command.checkContainerMovementStatus(e);
    	}catch (EventException de){
    		log.error(de);
    		throw new EventException(de.getMessage());
    	}  	
    }
    
    
    /**
     * checkExistWorkOrderNo<BR>
     * 
     * @param e Event
     * @return void
     * @throws EventException
     */
    private void checkExistWorkOrderNo(Event e) throws EventException {
    	
    	try{
    		// Basic Command 생성
        	InvoiceCreationDetailBCImpl command = new InvoiceCreationDetailBCImpl();
    		command.checkExistWorkOrderNo(e);
    	}catch (EventException de){
    		log.error(de);
    		throw new EventException(de.getMessage());
    	}  	
    }
    
    
    /**
     * saveMultiInvoiceCreation<BR>
     * 
     * @param e Event
     * @return eventResponse SppTrsU02EventResponse
     * @throws EventException
     */
    private EventResponse saveMultiInvoiceCreation(Event e) throws EventException {
    	SppTrsU02EventResponse eventResponse = null;
        
        try {

        	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC saveInvoiceCreation Start!");
        	begin();
        	/**
        	 * BC에 전달하기 위한 Event
        	 */
        	SppTrsU02Event event = (SppTrsU02Event)e;
        	
        	/**
        	 * SC에 리턴하기 위한 EventResponse
        	 */
        	eventResponse = new SppTrsU02EventResponse();
        	
        	// Basic Command 생성
        	InvoiceCreationDetailBCImpl command = new InvoiceCreationDetailBCImpl();

        	// 입력된 Invoic번호의 중복여부 체크
           	int iResult = 0;
           	iResult = command.saveMultiInvoice(event);
           	
           	eventResponse.setCount(iResult);

           	commit();
            
        } catch (EventException de) {
        	rollback();
        	log.error(de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * checkInputValue<BR>
     * 
     * @param event SppTrsU02Event
     * @return 
     * @throws EventException
     */
    private void checkInputValue(SppTrsU02Event event) throws EventException {
    	//벤더코드(필수)
    	if ( event.getVendorCode() == null || event.getVendorCode().equals("") ) {
    		throw new EventException("System error : first input vendor code!");
    	} else {
   			for (int i=0; i < event.getVendorCode().length(); i++ ) {
   				if ( "1234567890".indexOf(event.getVendorCode().substring(i, i+1)) < 0 ){
   					throw new EventException("System error : invalid vendor code!");
   				}
   			}
    	}
    	//User ID(필수)
    	if ( event.getUserID() == null || event.getUserID().equals("") ) {
    		throw new EventException("System error : first input user id!");
    	}
    	//Invoice번호(필수)
    	if ( event.getInvoiceNo() == null || event.getInvoiceNo().equals("") ) {
    		throw new EventException("System error : first input Invoice number!");
    	} else {
    		if ( event.getInvoiceNo().length() < 4 ) {
    			throw new EventException("System error : invalid invoice number!");
    		}
    	}
    	//Invoice Issue Date(필수)
    	if ( event.getIssueDate() == null || event.getIssueDate().equals("") ) {
    		throw new EventException("System error : first input invoice issue date!");
    	} else {
    		if ( event.getIssueDate().length() != 8 ) {
    			throw new EventException("System error : invalid invoice issue date!");
    		}
    	}
    	//Invoice Currency(필수)
    	if ( event.getInvoiceCurrency() == null || event.getInvoiceCurrency().equals("") ) {
    		throw new EventException("System error : first input invoice currency!");
    	} else {
    		if ( event.getInvoiceCurrency().length() != 3 ) {
    			throw new EventException("System error : invalid invoice currency!");
    		}
    	}
    	//Invoice Creation Data(필수)
    	if ( event.getInvoiceCreationData() == null || event.getInvoiceCreationData().length == 0 ) {
    		throw new EventException("System error : first select equipment list!");
    	} else {
    		if ( event.getInvoiceCurrency().length() != 3 ) {
    			throw new EventException("System error : invalid invoice currency!");
    		}
    	}
    	
    	//Parent 벤더코드(필수)
    	if ( event.getParentVendorCode() == null || event.getParentVendorCode().equals("") ) {
    		throw new EventException("System error : first input parent vendor code!");
    	} else {
   			for (int i=0; i < event.getParentVendorCode().length(); i++ ) {
   				if ( "1234567890".indexOf(event.getParentVendorCode().substring(i, i+1)) < 0 ){
   					throw new EventException("System error : invalid parent vendor code!");
   				}
   			}
    	}
    	
    	//조회조건이 아무것도 없는 경우는 에러처리
    	if ( event.getInvoiceNo().equals("") && event.getIssueDate().equals("") && event.getInvoiceCurrency().equals("") ) {
    		throw new EventException("System error : invalid submit value for invoice submit!");
    	}    	
    	
    	return;
    }

    /**
     * cancelInvoice<BR>
     * 
     * @param event SppTrsU02Event
     * @return bResult boolean
     * @throws EventException
     */
    private boolean cancelInvoice(SppTrsU02Event event) throws EventException {
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC cancelInvoice START!");
    	boolean bResult = false;

		//한개의 Invoice만 사용한다.
		String[] invoiceNo = new String[1];		//Single 처리
		String[] vendorCode = new String[1];	//Single 처리		
		invoiceNo[0] = event.getInvoiceNo().trim();	//Invoice Number
		//2007-04-10 조성환 : vendorCode[0] = event.getVendorCode();	//Vendor Code
		vendorCode[0] = event.getParentVendorCode();	//Parent Vendor Code
		
		log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC cancelInvoice invoiceNo=" + invoiceNo[0] 
                   + " vendorCode=" + vendorCode[0]);
		
    	/**
		 * Request 에서 전송된 데이터를 InvoiceCancelEvent 에 맞게 변경하여 세트한다.
		 */
    	InvoiceCancelEvent cancelEvent = new InvoiceCancelEvent();
		FormCommand f = new FormCommand();
		f.setCommand(FormCommand.MULTI);
		cancelEvent.setFormCommand(f);
		
		((InvoiceCancelEvent)cancelEvent).setUserID(event.getUserID());
		((InvoiceCancelEvent)cancelEvent).setInv_no(invoiceNo);
		((InvoiceCancelEvent)cancelEvent).setInv_vndr_seq(vendorCode);
		
		InvoiceCancelManageBC cancelCommand = new InvoiceCancelManageBCImpl();
		GeneralEventResponse cancelEventResponse = (GeneralEventResponse)cancelCommand.cancelInvoiceList(cancelEvent);
		
		if ( cancelEventResponse.getFlowFlag().equals("true") ) {
			bResult = true;
		} else {
			bResult = false;
		}
		
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC cancelInvoice RESULT=" + bResult);
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC cancelInvoice END!");
    	return bResult;
    }
    
    /**
     * makeInvoiceSummary<BR>
     * 
     * @param event SppTrsU02Event
     * @return hashParam HashMap
     * @throws EventException
     */
    private SearchInvoiceAuditVO makeInvoiceSummary(SppTrsU02Event event) throws EventException {
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeInvoiceSummary START!");
    	InvoiceCreationDetailBC command = new InvoiceCreationDetailBCImpl();
    	SearchInvoiceAuditVO searchInvoiceAuditVO = new SearchInvoiceAuditVO();
    	//Parent Vendor Code 검색
    	int iParentVendorCode = Integer.parseInt(event.getParentVendorCode());
    	
    	//Parent Vendor Code's Create Office 검색
    	String sOfficeCode = event.getInvoiceCreationData()[0].getOfficeCode();
    	//Receive Date 검색 (Local Time)
    	String sReceiveDate = command.getReceiveDate(sOfficeCode);
    	if ( sReceiveDate.equals("") ) {
    		sReceiveDate = "";
    	}
    	searchInvoiceAuditVO.setComboSvcProvider(event.getVendorCode().trim());
    	searchInvoiceAuditVO.setPaymtSpCd(String.valueOf(iParentVendorCode));
    	searchInvoiceAuditVO.setInvoiceNo(event.getInvoiceNo().trim());
    	searchInvoiceAuditVO.setApplyCurrency(event.getInvoiceCurrency().trim());
    	searchInvoiceAuditVO.setTrspInvAudStsCdParam("RC");
    	searchInvoiceAuditVO.setIfSysKndCdParam("W");
    	searchInvoiceAuditVO.setInvAmt(event.getGrandTotal().replaceAll(",",""));
    	searchInvoiceAuditVO.setVatAmt(event.getVatAmt().replaceAll(",",""));
    	searchInvoiceAuditVO.setTotAmt(event.getGrandTotal().replaceAll(",",""));
    	searchInvoiceAuditVO.setRecieveDt(sReceiveDate.trim());
    	searchInvoiceAuditVO.setIssueDt(event.getIssueDate().trim());
    	searchInvoiceAuditVO.setFormCreUsrId("SPP_IF");
    	searchInvoiceAuditVO.setProvUsrId(event.getUserID().trim());
    	searchInvoiceAuditVO.setProvPhnId(event.getVendorPhoneNo().trim());
    	searchInvoiceAuditVO.setFormUsrOfcCd(sOfficeCode.trim());
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeInvoiceSummary END!");
    	return searchInvoiceAuditVO;
    }
    
    /**
     * makeInvoiceAudit<BR>
     * 
     * @param event SppTrsU02Event
     * @param surchargeVOCollection Collection
     * @return invoiceAuditVOCollection Collection
     * @throws EventException
     */
    private Collection makeInvoiceAudit(SppTrsU02Event event, Collection surchargeVOCollection) throws EventException {
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeInvoiceAudit START!");
    	
    	InvoiceCreationInquiry[] invoiceCreationData = event.getInvoiceCreationData();
    	Collection invoiceAuditVOCollection = new ArrayList();
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeInvoiceAudit INPUT CNT= " + invoiceCreationData.length);
    	
    	for ( int idxSO=0; idxSO < invoiceCreationData.length; idxSO++ ) {
    		log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeInvoiceAudit invoiceCreationData IDX=" + idxSO 
    				+ " SO=" + invoiceCreationData[idxSO].getServiceOrderNo() 
    				+ " WO=" + invoiceCreationData[idxSO].getWorkOrderNo()
    				+ " Tpsz_cd=" + invoiceCreationData[idxSO].getTpsz_cd()
    				+ " ProcessStatus=" + invoiceCreationData[idxSO].getProcessStatus() );
    		
    		if ( !invoiceCreationData[idxSO].getProcessStatus().equalsIgnoreCase("DELETE") ) {
        		//InvoiceAuditVO
        		InvoiceAuditVO invoiceAuditVO = new InvoiceAuditVO();
        		invoiceAuditVO.setIbflag("R");	//ibflag
        		invoiceAuditVO.setTrspSoOfcCtyCd(invoiceCreationData[idxSO].getServiceOrderNo().substring(0,3));	//trsp_so_ofc_cty_cd
        		invoiceAuditVO.setTrspSoSeq(invoiceCreationData[idxSO].getServiceOrderNo().substring(3));	//trsp_so_seq
        		invoiceAuditVO.setSurchargeKey(invoiceCreationData[idxSO].getServiceOrderNo().substring(3));	//Surcharge를 위한 Key정보
        		invoiceAuditVO.setEqNo(invoiceCreationData[idxSO].getEquipmentNo());	//eq_no
        		invoiceAuditVO.setTrspInvActStsCd("O");	//trsp_inv_act_sts_cd
        		invoiceAuditVO.setTrspWoOfcCtyCd(invoiceCreationData[idxSO].getWorkOrderNo().substring(0,3));	//trsp_wo_of_cty_cd
        		invoiceAuditVO.setTrspWoSeq(invoiceCreationData[idxSO].getWorkOrderNo().substring(3));	//trsp_wo_seq
        		invoiceAuditVO.setEqTpszCd(invoiceCreationData[idxSO].getTpsz_cd());	//eq_tpsz_cd
        		invoiceAuditVO.setEqKndCd(invoiceCreationData[idxSO].getEquipmentNoType());	//eq_tp_cd
        		invoiceAuditVO.setInvBzcAmt(invoiceCreationData[idxSO].getInvoiceBasicAmount().replaceAll(",",""));	//inv_bzc_amt
        		/* Service Order별 Surcharge 금액 계산 */
        		double surchargeByServieOrder = getSurchargeByServiceOrderNo(surchargeVOCollection, invoiceAuditVO.getTrspSoOfcCtyCd(), invoiceAuditVO.getTrspSoSeq());
        		invoiceAuditVO.setInvEtcAddAmt(String.valueOf(surchargeByServieOrder));	//surchage_amt
            	invoiceAuditVOCollection.add(invoiceAuditVO);
            }
    	}
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeInvoiceAudit END!");
    	return invoiceAuditVOCollection;
    }
    
    /**
     * makeServiceOrder<BR>
     * 
     * @param event SppTrsU02Event
     * @param surchargeVOCollection Collection
     * @return trs_trsp_svc_ordCollection Collection
     * @throws EventException
     */
    private Collection makeServiceOrder(SppTrsU02Event event, Collection surchargeVOCollection) throws EventException {
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeServiceOrder START!");
    	InvoiceCreationInquiry[] invoiceCreationData = event.getInvoiceCreationData();
    	Collection trs_trsp_svc_ordCollection = new ArrayList();
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeServiceOrder INPUT CNT= " + invoiceCreationData.length);
    	
    	for ( int idxSO=0; idxSO < invoiceCreationData.length; idxSO++ ) {
    		log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeServiceOrder invoiceCreationData IDX=" + idxSO 
    				+ " SO=" + invoiceCreationData[idxSO].getServiceOrderNo() 
    				+ " WO=" + invoiceCreationData[idxSO].getWorkOrderNo()
    				+ " ProcessStatus=" + invoiceCreationData[idxSO].getProcessStatus() );
    		if ( !invoiceCreationData[idxSO].getProcessStatus().equalsIgnoreCase("DELETE") ) {
    			//TRS_TRSP_SVC_ORD
            	TrsTrspSvcOrdVO trs_trsp_svc_ordVO = new TrsTrspSvcOrdVO();
            	trs_trsp_svc_ordVO.setTrspSoOfcCtyCd(invoiceCreationData[idxSO].getServiceOrderNo().substring(0,3));	//trsp_so_ofc_cty_cd
            	trs_trsp_svc_ordVO.setTrspSoSeq(invoiceCreationData[idxSO].getServiceOrderNo().substring(3));	//trsp_so_seq
            	trs_trsp_svc_ordVO.setInvVndrSeq(event.getParentVendorCode());	//Parent Vendor Code
            	trs_trsp_svc_ordVO.setInvNo(event.getInvoiceNo().trim());	//Invoice Number
            	trs_trsp_svc_ordVO.setTrspWoOfcCtyCd(invoiceCreationData[idxSO].getWorkOrderNo().substring(0,3));	//trsp_wo_of_cty_cd
            	trs_trsp_svc_ordVO.setTrspWoSeq(invoiceCreationData[idxSO].getWorkOrderNo().substring(3));	//trsp_wo_seq
            	trs_trsp_svc_ordVO.setInvCurrCd(event.getInvoiceCurrency());	//Invoice Currency
            	trs_trsp_svc_ordVO.setInvBzcAmt(invoiceCreationData[idxSO].getInvoiceBasicAmount().replaceAll(",",""));	//inv_bzc_amt
            	/* Service Order별 Surcharge 금액 계산 */
            	double surchargeByServieOrder = getSurchargeByServiceOrderNo(surchargeVOCollection, trs_trsp_svc_ordVO.getTrspSoOfcCtyCd(), trs_trsp_svc_ordVO.getTrspSoSeq());
            	trs_trsp_svc_ordVO.setInvEtcAddAmt(String.valueOf(surchargeByServieOrder) );	//inv_bzc_amt
            	trs_trsp_svc_ordVO.setSpInvRmk(invoiceCreationData[idxSO].getRemark());	//Inv_rmk
            	trs_trsp_svc_ordVO.setTrspInvCalcLgcTpCd(invoiceCreationData[idxSO].getExchangeCalculationLogicType());	//Trsp_inv_calc_lgc_tp_cd
            	trs_trsp_svc_ordVO.setInvXchRt(invoiceCreationData[idxSO].getExchangeRate());	//Inv_xch_rt
            	trs_trsp_svc_ordVO.setFuelScgAmt(invoiceCreationData[idxSO].getWorkOrderSurchargeFuel());	//Inv_fuel_scg_amt
            	trs_trsp_svc_ordVO.setVatScgAmt(invoiceCreationData[idxSO].getWorkOrderSurchargeVat());	//Inv_vat_scg_amt
            	trs_trsp_svc_ordVO.setNegoAmt(invoiceCreationData[idxSO].getWorkOrderSurchargeNegoAmt());	//INv_nego_amt
            	trs_trsp_svc_ordVO.setBzcAmt(invoiceCreationData[idxSO].getWorkOrderSurchargeBzcAmt());	//bzc_amt
            	trs_trsp_svc_ordVO.setEtcAddAmt(invoiceCreationData[idxSO].getWorkOrderSurchargeEtcAddAmt());	//Inv_ovr_wgt_scg_amt
            	trs_trsp_svc_ordVO.setTollFeeAmt(invoiceCreationData[idxSO].getWorkOrderSurchargeTollFeeAmt());
            	
            	trs_trsp_svc_ordCollection.add(trs_trsp_svc_ordVO);
            }
    	}
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeServiceOrder END!");
    	return trs_trsp_svc_ordCollection;
    }
    
    /**
     * makeSurcharge<BR>
     * 
     * @param event SppTrsU02Event
     * @param surchargeVOCollection
     * @return surchargeVOCollection Collection
     * @throws EventException
     */
    private Collection makeSurcharge(SppTrsU02Event event) throws EventException {
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeSurcharge START!");
    	InvoiceSurchargeInquiry[] invoiceSurchargeData = event.getInvoiceSurchargeData();
    	if(invoiceSurchargeData == null) {
    		invoiceSurchargeData = new InvoiceSurchargeInquiry[0];
    	}
    	Collection surchargeVOCollection = new ArrayList();

    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeSurcharge INPUT = " + invoiceSurchargeData.length);
    	int iResult = 0;
    	for ( int i=0; i < invoiceSurchargeData.length; i++ ) {
        	
    		log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeSurcharge "
    				+ " i=" + i
    				+ " getServiceNo=" + invoiceSurchargeData[i].getServiceNo()
    				);
        	
    		/**
    		 * 한건의 Surcharge Array(SO단위)에 여러종류의 Surcharge가 있으므로 다중처리한다.
    		 * - Surcharge Amount뿐 아니라, 옵션이 있는 경우는 옵션 Type의 입력여부를 검증한다.
    		 */
    		
    		String cgo_tp_cd = "";
    		if(invoiceSurchargeData[i].getCgo_tp_cd() != null && !"".equals(invoiceSurchargeData[i].getCgo_tp_cd()))
    			cgo_tp_cd = invoiceSurchargeData[i].getCgo_tp_cd().trim();
    		
        	if ( invoiceSurchargeData[i].getAdditionalLabor() != null && !invoiceSurchargeData[i].getAdditionalLabor().equals("") && !invoiceSurchargeData[i].getAdditionalLabor().equals("0") ) {
        		//Additional Labor
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCALAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMALAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMALAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getAdditionalLabor());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
        	} 
        	if ( invoiceSurchargeData[i].getBargeLowWater() != null && !invoiceSurchargeData[i].getBargeLowWater().equals("") && !invoiceSurchargeData[i].getBargeLowWater().equals("0") ) {
        		//Barge low water surcharge
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCLWAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMLWAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMLWAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getBargeLowWater());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
        	} 
        	if ( invoiceSurchargeData[i].getChassisUsage() != null && !invoiceSurchargeData[i].getChassisUsage().equals("") && !invoiceSurchargeData[i].getChassisUsage().equals("0") ) {
        		//CHZ Usage 
        		if ( invoiceSurchargeData[i].getChassisType() == null || invoiceSurchargeData[i].getChassisType().equals("") ) {
        			throw new EventException("must input surcharge CHZ Usage");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCCHAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMCHAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMCHAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getChassisUsage());
        		surchargeVO.setInvChssMgstTpszCd(invoiceSurchargeData[i].getChassisType());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
        	}
        	if ( invoiceSurchargeData[i].getDrop_Pull() != null && !invoiceSurchargeData[i].getDrop_Pull().equals("") && !invoiceSurchargeData[i].getDrop_Pull().equals("0") ) {
         		//Drop & Pull (Drop & Pickup)
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCDPAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMDPAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMDPAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getDrop_Pull());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getDryRun() != null && !invoiceSurchargeData[i].getDryRun().equals("") && !invoiceSurchargeData[i].getDryRun().equals("0") ) {
         		//Dry Run
        		if ( invoiceSurchargeData[i].getRealiableParty() == null || invoiceSurchargeData[i].getRealiableParty().equals("") ) {
        			throw new EventException("must input surcharge Dry Run");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCDRAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMDRAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMDRAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getDryRun());
        		surchargeVO.setInvDryRunRlblPtyTpCd(invoiceSurchargeData[i].getRealiableParty());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getFerryCost() != null && !invoiceSurchargeData[i].getFerryCost().equals("") && !invoiceSurchargeData[i].getFerryCost().equals("0") ) {
         		//Ferry Cost
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCFRAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMFRAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMFRAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getFerryCost());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getFine() != null && !invoiceSurchargeData[i].getFine().equals("") && !invoiceSurchargeData[i].getFine().equals("0") ) {
         		//Fine
        		if ( invoiceSurchargeData[i].getCause() == null || invoiceSurchargeData[i].getCause().equals("") ) {
        			throw new EventException("must input surcharge Fine");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCFIAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMFIAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMFIAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getFine());
        		surchargeVO.setInvFneCuzDesc(invoiceSurchargeData[i].getCause());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getFumigation() != null && !invoiceSurchargeData[i].getFumigation().equals("") && !invoiceSurchargeData[i].getFumigation().equals("0") ) {
         		//Fumigation
        		if ( invoiceSurchargeData[i].getCost() == null || invoiceSurchargeData[i].getCost().equals("") ) {
        			throw new EventException("must input surcharge Fumigation");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCFGAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMFGAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMFGAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getFumigation());
        		surchargeVO.setInvFumgCostTpCd(invoiceSurchargeData[i].getCost());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getGenSetUsage() != null && !invoiceSurchargeData[i].getGenSetUsage().equals("") && !invoiceSurchargeData[i].getGenSetUsage().equals("0") ) {
         		//Gen-set
        		if ( invoiceSurchargeData[i].getGenSetType() == null || invoiceSurchargeData[i].getGenSetType().equals("") ) {
        			throw new EventException("must input surcharge Gen-set");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCGNAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMGNAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMGNAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getGenSetUsage());
        		surchargeVO.setInvFumgCostTpCd(invoiceSurchargeData[i].getGenSetType());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getHazmat() != null && !invoiceSurchargeData[i].getHazmat().equals("") && !invoiceSurchargeData[i].getHazmat().equals("0") ) {
         		//HAZMAT
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCHZAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMHZAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMHZAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getHazmat());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getInspection() != null && !invoiceSurchargeData[i].getInspection().equals("") && !invoiceSurchargeData[i].getInspection().equals("0") ) {
         		//Inspection
        		if ( invoiceSurchargeData[i].getInspectionType() == null || invoiceSurchargeData[i].getInspectionType().equals("") ) {
        			throw new EventException("must input surcharge Inspection");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCINAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMINAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMINAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getInspection());
        		surchargeVO.setInvInspRfPtiCstmsTpCd(invoiceSurchargeData[i].getInspectionType());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getLiftingCharge() != null && !invoiceSurchargeData[i].getLiftingCharge().equals("") && !invoiceSurchargeData[i].getLiftingCharge().equals("0") ) {
         		//Lifting Charge
        		if ( invoiceSurchargeData[i].getNumberOfLifting() == null || invoiceSurchargeData[i].getNumberOfLifting().equals("") ) {
        			throw new EventException("must input surcharge Lifting Charge");
        		}
        		if ( invoiceSurchargeData[i].getLiftingCause() == null || invoiceSurchargeData[i].getLiftingCause().equals("") ) {
        			throw new EventException("must input surcharge Lifting Charge Desc");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCLFAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMLFAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMLFAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getLiftingCharge());
        		surchargeVO.setInvLftgKnt(invoiceSurchargeData[i].getNumberOfLifting());
        		surchargeVO.setInvLftgCuzDesc(invoiceSurchargeData[i].getLiftingCause());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getMultipleDelivery() != null && !invoiceSurchargeData[i].getMultipleDelivery().equals("") && !invoiceSurchargeData[i].getMultipleDelivery().equals("0") ) {
         		//Multistop Delivery
        		if ( invoiceSurchargeData[i].getStopLocation() == null || invoiceSurchargeData[i].getStopLocation().equals("") ) {
        			throw new EventException("must input surcharge Multistop Delivery");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCMDAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMMDAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMMDAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getMultipleDelivery());
        		surchargeVO.setInvStopLocNodCd(invoiceSurchargeData[i].getStopLocation());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getOverSize() != null && !invoiceSurchargeData[i].getOverSize().equals("") && !invoiceSurchargeData[i].getOverSize().equals("0") ) {
         		//Over Size
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCOSAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMOSAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMOSAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getOverSize());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	}
        	if ( invoiceSurchargeData[i].getOverWeight() != null && !invoiceSurchargeData[i].getOverWeight().equals("") && !invoiceSurchargeData[i].getOverWeight().equals("0") ) {
         		//Over Weight
        		if ( invoiceSurchargeData[i].getGrossWeight() == null || invoiceSurchargeData[i].getGrossWeight().equals("") ) {
        			throw new EventException("must input surcharge Over Weight");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCOWAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMOWAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMOWAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getOverWeight());
        		surchargeVO.setInvGrsWgt(invoiceSurchargeData[i].getGrossWeight());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getPrePull() != null && !invoiceSurchargeData[i].getPrePull().equals("") && !invoiceSurchargeData[i].getPrePull().equals("0") ) {
         		//Pre-Pull
        		if ( invoiceSurchargeData[i].getIncurredDate() == null || invoiceSurchargeData[i].getIncurredDate().equals("") ) {
        			throw new EventException("must input surcharge Pre-Pull");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCPPAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMPPAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMPPAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getPrePull());
        		surchargeVO.setInvIncrtDt(invoiceSurchargeData[i].getIncurredDate());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getRedirectionCharge() != null && !invoiceSurchargeData[i].getRedirectionCharge().equals("") && !invoiceSurchargeData[i].getRedirectionCharge().equals("0") ) {
         		//Redirection Charge
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCRCAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMRCAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMRCAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getRedirectionCharge());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getScaleStop() != null && !invoiceSurchargeData[i].getScaleStop().equals("") && !invoiceSurchargeData[i].getScaleStop().equals("0") ) {
         		//Scale Stop
        		if ( invoiceSurchargeData[i].getScaleStopPlace() == null || invoiceSurchargeData[i].getScaleStopPlace().equals("") ) {
        			throw new EventException("must input surcharge Scale Stop");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCSSAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMSSAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMSSAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getScaleStop());
        		surchargeVO.setInvSclStopPlcNodCd(invoiceSurchargeData[i].getScaleStopPlace());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getStorage() != null && !invoiceSurchargeData[i].getStorage().equals("") && !invoiceSurchargeData[i].getStorage().equals("0") ) {
         		//Storage
        		if ( invoiceSurchargeData[i].getStorageDays() == null || invoiceSurchargeData[i].getStorageDays().equals("") ) {
        			throw new EventException("must input surcharge Storage");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCSRAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMSRAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMSRAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getStorage());
        		surchargeVO.setInvStoDys(invoiceSurchargeData[i].getStorageDays());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getStreetTurn() != null && !invoiceSurchargeData[i].getStreetTurn().equals("") && !invoiceSurchargeData[i].getStreetTurn().equals("0") ) {
         		//Street Turn
        		if ( invoiceSurchargeData[i].getOutboundBookingNo() == null || invoiceSurchargeData[i].getOutboundBookingNo().equals("") ) {
        			throw new EventException("must input surcharge Street Turn");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCSTAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMSTAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMSTAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getStreetTurn());
        		surchargeVO.setInvObBkgNo(invoiceSurchargeData[i].getOutboundBookingNo().substring(0,11));
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getSundayRunning() != null && !invoiceSurchargeData[i].getSundayRunning().equals("") && !invoiceSurchargeData[i].getSundayRunning().equals("0") ) {
         		//Sunday Running
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCSNAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMSNAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMSNAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getSundayRunning());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getSwing_flip() != null && !invoiceSurchargeData[i].getSwing_flip().equals("") && !invoiceSurchargeData[i].getSwing_flip().equals("0") ) {
         		//Swing/Flip
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCSFAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMSFAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMSFAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getSwing_flip());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	} 
        	if ( invoiceSurchargeData[i].getTDOCFee() != null && !invoiceSurchargeData[i].getTDOCFee().equals("") && !invoiceSurchargeData[i].getTDOCFee().equals("0") ) {
         		//T-DOC Fee
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCTDAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMTDAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMTDAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getTDOCFee());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	}
        	if ( invoiceSurchargeData[i].getToil() != null && !invoiceSurchargeData[i].getToil().equals("") && !invoiceSurchargeData[i].getToil().equals("0") ) {
         		//Toll
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCTLAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMTLAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMTLAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getToil());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	}
        	if ( invoiceSurchargeData[i].getWaitingCharges() != null && !invoiceSurchargeData[i].getWaitingCharges().equals("") && !invoiceSurchargeData[i].getWaitingCharges().equals("0") ) {
         		//Waiting Charge
        		if ( invoiceSurchargeData[i].getWaitingHour() == null || invoiceSurchargeData[i].getWaitingHour().equals("") ) {
        			throw new EventException("must input surcharge Waiting Charge");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCWTAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMWTAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMWTAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getWaitingCharges());
        		surchargeVO.setInvWtHrs(invoiceSurchargeData[i].getWaitingHour());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	}
        	if ( invoiceSurchargeData[i].getOther() != null && !invoiceSurchargeData[i].getOther().equals("") && !invoiceSurchargeData[i].getOther().equals("0") ) {
         		//Other Surcharge
        		if ( invoiceSurchargeData[i].getRemark() == null || invoiceSurchargeData[i].getRemark().equals("") ) {
        			throw new EventException("must input surcharge Other Surcharge");
        		}
        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		if(cgo_tp_cd != null && !"".equals(cgo_tp_cd)){
        			if(cgo_tp_cd.equals("F")){
        				surchargeVO.setLgsCostCd("SCOTAL");
        			}else if(cgo_tp_cd.equals("M")){
        				surchargeVO.setLgsCostCd("SMOTAL");
        			}
        		}else{
        			surchargeVO.setLgsCostCd("SMOTAL");
        		}
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getOther());
        		surchargeVO.setInvOtrRmk(invoiceSurchargeData[i].getRemark());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
         	}
        	if ( invoiceSurchargeData[i].getChassisDrayage() != null && !invoiceSurchargeData[i].getChassisDrayage().equals("") && !invoiceSurchargeData[i].getChassisDrayage().equals("0") ) {

        		SurchargeVO surchargeVO = new SurchargeVO();
        		surchargeVO.setTrspSoOfcCtyCd(invoiceSurchargeData[i].getServiceNo().substring(0,3));
        		surchargeVO.setTrspSoSeq(invoiceSurchargeData[i].getServiceNo().substring(3));
        		surchargeVO.setUniqueCd(invoiceSurchargeData[i].getServiceNo().substring(3));	//Surcharge를 위한 Key정보
        		
        		surchargeVO.setLgsCostCd("SCCDAL");
        		
        		surchargeVO.setInvScgAmt(invoiceSurchargeData[i].getChassisDrayage());
        		surchargeVO.setInvChssNo(invoiceSurchargeData[i].getChssNo());
        		surchargeVO.setInvIncurDt(invoiceSurchargeData[i].getIncurDt());
        		log.debug("###############################\n\n\n");
        		log.debug("LgsCostCd	:	SCCDAL ");
        		log.debug("invoiceSurchargeData["+i+"].getChassisDrayage()	:	"+invoiceSurchargeData[i].getChassisDrayage());
        		log.debug("invoiceSurchargeData["+i+"].getChssNo()	:	"+invoiceSurchargeData[i].getChssNo());
        		log.debug("invoiceSurchargeData["+i+"].getIncurredDate()	:	"+invoiceSurchargeData[i].getIncurredDate());
        		log.debug("invoiceSurchargeData["+i+"].getIncurDt()	:	"+invoiceSurchargeData[i].getIncurDt());
        		
        		surchargeVO.setInvChssMgstTpszCd(invoiceSurchargeData[i].getChassisDrayageType());
        		surchargeVOCollection.add(surchargeVO);
        		iResult++;
        	}
        	
        } //end of for (SO 갯수 만큼)

    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC makeSurcharge END! iResult=" + iResult);
    	return surchargeVOCollection;
    }
    
    /**
     * getSurchargeByServiceOrderNo<BR>
     * 
     * @param surchargeVOCollection Collection
     * @param serviceOrderOFC String
     * @param serviceOrderSEQ String
     * @return fResult float
     * @throws EventException
     */
    private double getSurchargeByServiceOrderNo(Collection surchargeVOCollection, String serviceOrderOFC, String serviceOrderSEQ) throws EventException {
    	
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC getSurchargeByServiceOrderNo START! serviceOrderNo=" + serviceOrderOFC + serviceOrderSEQ);
    	Iterator surchargeArray = surchargeVOCollection.iterator();
    	double dResult = 0.0;
    	
    	while (surchargeArray.hasNext()) {
    		SurchargeVO surchargeVO = (SurchargeVO)surchargeArray.next();
        	if ( surchargeVO.getTrspSoOfcCtyCd().equals(serviceOrderOFC) && surchargeVO.getTrspSoSeq().equals(serviceOrderSEQ) ) {
        		log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC getSurchargeByServiceOrderNo "
        				+ " getServiceNo=" + surchargeVO.getTrspSoOfcCtyCd() + surchargeVO.getTrspSoSeq()
        				+ " getLgs_cost_cd=" + surchargeVO.getLgsCostCd() 
        				+ " getInv_scg_amt=" + surchargeVO.getInvScgAmt()
        				);
        		
        		dResult = dResult + Double.parseDouble((surchargeVO.getInvScgAmt() == null || surchargeVO.getInvScgAmt().equals("")) ? "0" : surchargeVO.getInvScgAmt());
        	}
    	}
    	DecimalFormat df = new DecimalFormat("##########.####");
    	dResult = Double.parseDouble(df.format(dResult));
    	log.debug("[debug]=== InvoiceCreationSubmitToHanjinRSC getSurchargeByServiceOrderNo END! dResult=" + dResult);
    	return dResult;
    }
    
}
