/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableOutstandingSC.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PaymentLetterMDMInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.PaymentLetterTitVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar0012Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1001Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1002Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1003Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1004Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1005Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1006Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1007Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1008Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1009Event;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration.AccountReceivableOutstandingDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.AROustandingbySADateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.ApplyOutstandingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingBaseVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSAgingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OTSViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingDtlByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHdrByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingHisByDateVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.OutstandingSumByBlVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterByEmailFaxVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterSumVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo.PaymentRequestLetterVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountReceivableOutstanding Business Logic ServiceCommand 
 * - Handling AccountReceivableOutstanding Business transaction.
 * 
 * @author 
 * @see AccountReceivableOutstandingDBDAO
 * @since J2EE 1.6
 */ 

public class AccountReceivableOutstandingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableOutstanding system <br>
	 *  Create Object when STM_SAR job call<br>
	 */
	public void doStart() {
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow AccountReceivableOutstanding system<br>
	 * Release Object when STM_SAR job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableOutstandingSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableOutstanding system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("StmSar0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApplyOutstandingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOutstandingReceiptTemp(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOustandingByDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1001Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOustandingByBl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOustandingHisByDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOustandingAgingList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentRequestLetter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEmailSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEmailFax(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePaymentRequestLetter(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = managePaymentRequestLetterOFC(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = sendPaymentRequestLetterByFaxEmail(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("StmSar1007Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageItemCollection(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("StmSar1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOTSViewAccountingList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar1009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentRequestLetterHistory(e); 
			}
		} 

		return eventResponse;
	}

	/**
	 * Search OTS for Apply List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApplyOutstandingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar0012Event event = (StmSar0012Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			String otsRctTmpSeq = event.getApplyOutstandingCondVO().getOtsRctTmpSeq();
			
			if(event.getSarOtsRctTmpVOs() != null){			
				if(otsRctTmpSeq == null || ("").equals(otsRctTmpSeq)) {
					otsRctTmpSeq = command.searchOutstandingReceiptTempSeq();
					event.getApplyOutstandingCondVO().setOtsRctTmpSeq(otsRctTmpSeq);
				}
				event.getApplyOutstandingCondVO().setOtsDtlFlg("Y");
			} else {
				event.getApplyOutstandingCondVO().setOtsDtlFlg("N");
			}
			
			begin();
			List<ApplyOutstandingListVO> applyOutstandingListVO = command.searchApplyOutstandingList(event.getApplyOutstandingCondVO(), event.getSarOtsRctTmpVOs(), account.getUsr_id());
			commit();
			
			eventResponse.setRsVoList(applyOutstandingListVO);
			eventResponse.setETCData("ots_rct_tmp_seq", otsRctTmpSeq);
			
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * STM_SAR_1002 : Retrieve
	 * Retrieve Outstanding Inquiry event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOustandingByDate(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1002Event event = (StmSar1002Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		
	try {
			List<AROustandingbySADateVO> list = command.searchOustandingByDate(event.getAROustandingbySADateVO());
			eventResponse.setRsVoList(list);
			
			if(list != null && list.size() > 0){
				eventResponse.setETCData("total_cnt", list.get(0).getTotalCnt());
				eventResponse.setETCData("total_usd_amt", list.get(0).getTotalUsdAmt());
				eventResponse.setETCData("total_lcl_amt", list.get(0).getTotalLclAmt());
			}else{
				eventResponse.setETCData("total_cnt", "0");
				eventResponse.setETCData("total_usd_amt", "0");
				eventResponse.setETCData("total_lcl_amt", "0");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_1005 : Retrieve
	 * Retrieve Payment Request Letter event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentRequestLetter(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1005Event event = (StmSar1005Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		
	try {
			List<PaymentRequestLetterVO> list = command.searchPaymentRequestLetter(event.getPaymentRequestLetterVO());
			List<PaymentRequestLetterSumVO> list2 = command.searchPaymentRequestLetterSum(event.getPaymentRequestLetterVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_1005 : Retrieve
	 * Retrieve Payment Request Letter event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmailSeq(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1005Event event = (StmSar1005Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		
	try {
			String rtnVal = command.searchEmailSeq(event.getPaymentRequestLetterVO());
			eventResponse.setETCData("ar_eml_seq", rtnVal);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_1005 : Retrieve
	 * Retrieve Payment Request Letter Email fax event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmailFax(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1005Event event = (StmSar1005Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		
	try {
            List<PaymentRequestLetterVO> list = command.searchEmailFax(event.getPaymentRequestLetterVO());
			eventResponse.setETCData("email", list.get(0).getEmail());
			eventResponse.setETCData("fax", list.get(0).getFax());
				
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

/**
	 * STM_SAR_1005 : insert, update, delete
	 * Payment Request Letter event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePaymentRequestLetter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1005Event event = (StmSar1005Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		try {
			begin();
			List<PaymentRequestLetterVO> list = command.managePaymentRequestLetterBasic(event.getPaymentRequestLetterVOs(), account);
			eventResponse.setRsVoList(list);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * STM_SAR_1001 : Retrieve
	 * Outstanding Inquiry by B/L(Invoice)
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOustandingByBl(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSar1001Event event = (StmSar1001Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();

		try {
			// ------------------------------------------------------
			// > search outstanding header
			// ------------------------------------------------------
			OutstandingHdrByBlVO hdrParam = event.getOutstandingHdrByBlVO();
			List<OutstandingHdrByBlVO> hdrList = command.searchOutstandingHdrByBl(hdrParam);

			if (hdrList == null || hdrList.isEmpty()) {
				// msgs['COM130401'] = 'There is no data to search.';
				eventResponse.setETCData("errCode", "COM130401");
				return eventResponse;
			}

			eventResponse.setRsVoList(hdrList);
			// ------------------------------------------------------
			// > search outstanding detail
			// ------------------------------------------------------
			OutstandingHdrByBlVO hdrVO = hdrList.get(0);			
			OutstandingDtlByBlVO dtlParam = new OutstandingDtlByBlVO();
			dtlParam.setRhqCd(hdrVO.getRhqCd());
			dtlParam.setOtsOfcCd(hdrVO.getOtsOfcCd());
			dtlParam.setBlNo(hdrVO.getBlNo());
			dtlParam.setInvNo(hdrVO.getInvNo());
			
			List<OutstandingDtlByBlVO> dtlList = command.searchOutstandingDtlByBl(dtlParam);
			eventResponse.setRsVoList(dtlList);
			
			// ------------------------------------------------------
			// > search outstanding summary 
			// ------------------------------------------------------
			if (dtlList == null || dtlList.isEmpty()) {
				return eventResponse;
			}
		
			OutstandingSumByBlVO sumParam = new OutstandingSumByBlVO();
			sumParam.setRhqCd(hdrVO.getRhqCd());
			sumParam.setOtsOfcCd(hdrVO.getOtsOfcCd());
			sumParam.setBlNo(hdrVO.getBlNo());
			sumParam.setInvNo(hdrVO.getInvNo());
			
			List<OutstandingSumByBlVO> sumList = command.searchOutstandingSumByBl(sumParam);
			eventResponse.setRsVoList(sumList);
			

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * STM_SAR_1003 : Retrieve
	 * Outstanding History Inquiry By Date
	 * 
	 * @author jinyoonoh 2014. 4. 22.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOustandingHisByDate(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		StmSar1003Event event = (StmSar1003Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		try {
			OutstandingHisByDateVO hisParam = event.getOutstandingHisByDateVO();
			List<OutstandingHisByDateVO> hisList = command.searchOutstandingHisByDate(hisParam);
			eventResponse.setRsVoList(hisList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}		
	
	
	/**
	 * STM_SAR_1004 : Retrieve
	 * Search Outstanding Aging  List 
	 * @author jinyoonoh 2014. 5. 23.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOustandingAgingList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StmSar1004Event event = (StmSar1004Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();

		try {
			// ------------------------------------------------------
			// > search outstanding header
			// ------------------------------------------------------
			OTSAgingBaseVO paramVO = event.getOtsAgingBaseVO();
			List<OTSAgingListVO> list = command.searchOTSAgingList(paramVO);
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}	
		
	
	/**
	 * STM_SAR_1007 : update OTS_SAR_HDR
	 * <br>
	 * Outstanding Item Collection
	 * @author jinyoonoh 2014. 7. 4.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageItemCollection(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1007Event event = (StmSar1007Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		try {
			begin();			
			
			command.manageItemCollection(event.getOutstandingHdrByBlVO());
			
			//msgs['COM12191'] = '{?msg1} was saved successfully.';
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"})
					.getUserMessage());		
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * STM_SAR_1008 : Retrieve
	 * Search Outstanding view accounting
	 * @author jinyoonoh 2014. 7. 16.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOTSViewAccountingList(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		StmSar1008Event event = (StmSar1008Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		try {
			OTSViewAccountingListVO paramVO = event.getOtsViewAccountingListVO();
			List<OTSViewAccountingListVO> list = command.searchOTSViewAccountingList(paramVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * STM_SAR_1006 : Send
	 * Retrieve Payment Request Letter Email fax event<br>
	 * 
	 * @author JBLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendPaymentRequestLetterByFaxEmail(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1006Event event = (StmSar1006Event) e;
		AccountReceivableOutstandingBC command  = new AccountReceivableOutstandingBCImpl();
		AccountReceivableCommonBC      command2 = new AccountReceivableCommonBCImpl();
		try {
			begin();
			PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO = event.getPaymentRequestLetterByEmailFaxVO();
			
			PaymentRequestLetterByEmailFaxVO hisHdrVO = new PaymentRequestLetterByEmailFaxVO();
			hisHdrVO.setStmtRqstTpCd("CUST");
			hisHdrVO.setArOfcCd(paymentRequestLetterByEmailFaxVO.getArOfcCd());
			hisHdrVO.setSenderUserId(account.getUsr_id());
			hisHdrVO.setCsCustCntCd(paymentRequestLetterByEmailFaxVO.getRctCustCntCd());
			hisHdrVO.setCsCustSeq(paymentRequestLetterByEmailFaxVO.getRctCustSeq());
			String arEmlHisSeq = command.addPaymentRequestLetterHisHdr(hisHdrVO); 
				
		    //MDM Customer 관련 정보 조회 
		    PaymentLetterMDMInfoVO paymentLetterMDMInfoVO = command2.searchMDMinfo(paymentRequestLetterByEmailFaxVO);
		    paymentRequestLetterByEmailFaxVO.setSupYn(paymentLetterMDMInfoVO.getSupYn());
		    paymentRequestLetterByEmailFaxVO.setQeqFmt(paymentLetterMDMInfoVO.getQeqFmt());
		    paymentRequestLetterByEmailFaxVO.setCsCustCntCd(paymentRequestLetterByEmailFaxVO.getRctCustCntCd()); 
		    paymentRequestLetterByEmailFaxVO.setCsCustSeq(paymentRequestLetterByEmailFaxVO.getRctCustSeq()); 
		    paymentRequestLetterByEmailFaxVO.setCustNm(paymentLetterMDMInfoVO.getCustNm());
		    
		    //제목 내용 조회 
		    PaymentLetterTitVO paymentLetterTitVO = command2.searchPaymentLetterTit(paymentRequestLetterByEmailFaxVO);
		    if(paymentLetterTitVO != null){
		    	paymentRequestLetterByEmailFaxVO.setEmlTitle(paymentLetterTitVO.getArPrnTitNm());
			    if(paymentLetterMDMInfoVO.getCustFlg().equals("Y")){
			    	paymentRequestLetterByEmailFaxVO.setEmtCtnt(paymentLetterTitVO.getArCrCustPrnCtnt());
			    } else {
			    	paymentRequestLetterByEmailFaxVO.setEmtCtnt(paymentLetterTitVO.getArPrnCtnt());
			    }
			    paymentRequestLetterByEmailFaxVO.setRefEml(paymentLetterTitVO.getRefEml());
		    }  
		    //sender 정보 입력 
		    paymentRequestLetterByEmailFaxVO.setSenderUserId(account.getUsr_id());
		    paymentRequestLetterByEmailFaxVO.setSenderUserNm(account.getUsr_nm());
		    paymentRequestLetterByEmailFaxVO.setSenderOfcCd(account.getOfc_cd());
		    //paymentRequestLetterByEmailFaxVO.setSenderEml(account.getUsr_eml());
		    //sender email을 dftl_eml 로 변경
		    String usrEml = command2.searchLoginUserEml(account.getUsr_id());
		    paymentRequestLetterByEmailFaxVO.setSenderEml(usrEml);
		    
		    String sndNm = "";
		    if(paymentLetterMDMInfoVO.getSupYn().equals("N")){
		    	sndNm = command.sendPaymentRequestLetterByFaxEmail(paymentRequestLetterByEmailFaxVO);
		    } else {
		    	sndNm = "supy";
		    }
		    paymentRequestLetterByEmailFaxVO.setSendEmlNo(sndNm);
		    
		    List<PaymentRequestLetterByEmailFaxVO> list = new ArrayList<PaymentRequestLetterByEmailFaxVO>();
		    list.add(paymentRequestLetterByEmailFaxVO);
		    //history 테이블에 update  
			command.modifyPaymentRequestLetterHistoryDtl(arEmlHisSeq,list); 
			command.modifyPaymentRequestLetterHistoryHdr(arEmlHisSeq);
		    eventResponse.setETCData("SEND_NUMBER", sndNm); 
		    commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_1005 : BY OFFICE
	 * 
	 * @author myoungsin park 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePaymentRequestLetterOFC(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar1005Event event = (StmSar1005Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		AccountReceivableCommonBC      command2 = new AccountReceivableCommonBCImpl();
		
		try {
			begin();
			PaymentRequestLetterVO paymentRequestLetterVO = event.getPaymentRequestLetterVO();
		    //sender email을 dftl_eml 로 변경
		    String usrEml = command2.searchLoginUserEml(account.getUsr_id());
		    paymentRequestLetterVO.setAccountUsrEml(usrEml);
		    
			String batSeq = command.createPaymentRequestLetterBat(paymentRequestLetterVO,account);
			commit();
			//check batch status
			String pgmNo = "STM_SAR_B1005";
			String batStsCd = command.searchBatStsCdLetterOFC(pgmNo);
			
			if("S".equals(batStsCd)){
				//call batch
				String result = command.managePaymentRequestLetterOFC(batSeq);
				eventResponse.setETCData("result", result);				
			}else if("R".equals(batStsCd)){	// Running
				begin();
				// sco_bat_his 에 E로 업데이트
				command.manageCancelBatLetterOFC(batSeq, account);
				eventResponse.setETCData("batStsCd", batStsCd); 
				commit();		
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_1006 : Send by office
	 * Retrieve Payment Request Letter Email fax event<br>
	 * 
	 * @author myoungsin park
	 * @param PaymentRequestLetterVO paymentRequestLetterVO
	 * @exception EventException
	 */
	public void sendPaymentRequestLetterByOFC(PaymentRequestLetterVO paymentRequestLetterVO) throws EventException {
		try {
 			AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
			AccountReceivableCommonBC      command2 = new AccountReceivableCommonBCImpl();
			
			List<PaymentRequestLetterVO> customerList = command.searchPaymentRequestLetterCustomer(paymentRequestLetterVO);
			List<PaymentRequestLetterByEmailFaxVO> list = new ArrayList<PaymentRequestLetterByEmailFaxVO>();
			
			String rdFile = "";
			if (paymentRequestLetterVO.getOtsSmryCd().equals("INV")) {
		    	if(paymentRequestLetterVO.getArOfcCd().equals("SAOBB")){
		    		rdFile="STM_SAR_1009.mrd";
		      	} else {
		      		rdFile="STM_SAR_1007.mrd";     		
		      	}
		    } else {
		  	   if(paymentRequestLetterVO.getArOfcCd().equals("SAOBB")){
		  		   rdFile="STM_SAR_1008.mrd";
		  	   } else {
		  		   rdFile="STM_SAR_1006.mrd";
		  	   }
		    }
			
			//제목 내용 조회 
			PaymentRequestLetterByEmailFaxVO temp1 = new PaymentRequestLetterByEmailFaxVO();
			temp1.setArOfcCd(paymentRequestLetterVO.getArOfcCd());
		    PaymentLetterTitVO paymentLetterTitVO = command2.searchPaymentLetterTit(temp1);
			
			for (int i = 0; i < customerList.size(); i++) {
				PaymentRequestLetterVO customer = customerList.get(i);
				//ots dtl ar_eml_seq 업데이트 해야됨!
				String arEmlseq = command.searchEmailSeq(paymentRequestLetterVO);
				
				paymentRequestLetterVO.setCustCd(customer.getCnsdCustCd());
				paymentRequestLetterVO.setCustCntCd(customer.getCnsdCustCntCd());
				paymentRequestLetterVO.setCustSeq(customer.getCnsdCustSeq());
				paymentRequestLetterVO.setCnsdCustFlg(customer.getCnsdCustFlg());
				
				//update eml_seq
				List<PaymentRequestLetterVO> dtlList = command.searchPaymentRequestLetter(paymentRequestLetterVO);
				for (int j = 0; j < dtlList.size(); j++) {
					dtlList.get(j).setArOfcCd(paymentRequestLetterVO.getArOfcCd());
					dtlList.get(j).setArEmlSeq(arEmlseq);
					dtlList.get(j).setAccountUsrId(paymentRequestLetterVO.getAccountUsrId());
				}
				command.managePaymentRequestLetterEmlSeq(dtlList);
				
				PaymentRequestLetterByEmailFaxVO paymentRequestLetterByEmailFaxVO = new PaymentRequestLetterByEmailFaxVO();
				paymentRequestLetterByEmailFaxVO.setArOfcCd(paymentRequestLetterVO.getArOfcCd());
				paymentRequestLetterByEmailFaxVO.setCustCntCd(customer.getCnsdCustCntCd());
				paymentRequestLetterByEmailFaxVO.setCustSeq(customer.getCnsdCustSeq());
				paymentRequestLetterByEmailFaxVO.setCustCode(customer.getCnsdCustCd());
				paymentRequestLetterByEmailFaxVO.setCnsdCustFlg(customer.getCnsdCustFlg());
				paymentRequestLetterByEmailFaxVO.setSendType("EMAIL");
				paymentRequestLetterByEmailFaxVO.setEmlSeq(arEmlseq);
				paymentRequestLetterByEmailFaxVO.setRdName(rdFile);
				//sender 정보 입력 
			    paymentRequestLetterByEmailFaxVO.setSenderUserId(paymentRequestLetterVO.getAccountUsrId());
			    paymentRequestLetterByEmailFaxVO.setSenderUserNm(paymentRequestLetterVO.getAccountUsrNm());
			    paymentRequestLetterByEmailFaxVO.setSenderOfcCd(paymentRequestLetterVO.getAccountOfcCd());
			    paymentRequestLetterByEmailFaxVO.setSenderEml(paymentRequestLetterVO.getAccountUsrEml()); 
			    if(paymentLetterTitVO != null){
			    	paymentRequestLetterByEmailFaxVO.setRefEml(paymentLetterTitVO.getRefEml());
			    }
				
				PaymentLetterMDMInfoVO paymentLetterMDMInfoVO = command2.searchMDMinfo(paymentRequestLetterByEmailFaxVO);
				if(paymentLetterMDMInfoVO != null){
					paymentRequestLetterByEmailFaxVO.setSupYn(paymentLetterMDMInfoVO.getSupYn());
				    paymentRequestLetterByEmailFaxVO.setQeqFmt(paymentLetterMDMInfoVO.getQeqFmt());
				    paymentRequestLetterByEmailFaxVO.setEmail(paymentLetterMDMInfoVO.getCustEml());
				    paymentRequestLetterByEmailFaxVO.setFax(paymentLetterMDMInfoVO.getFaxNo());
				    paymentRequestLetterByEmailFaxVO.setCustNm(paymentLetterMDMInfoVO.getCustNm());
				   
				    if(paymentLetterTitVO != null){
				    	paymentRequestLetterByEmailFaxVO.setEmlTitle(paymentLetterTitVO.getArPrnTitNm());
					    if(paymentLetterMDMInfoVO.getCustFlg().equals("Y")){
					    	paymentRequestLetterByEmailFaxVO.setEmtCtnt(paymentLetterTitVO.getArCrCustPrnCtnt());
					    } else {
					    	paymentRequestLetterByEmailFaxVO.setEmtCtnt(paymentLetterTitVO.getArPrnCtnt());
					    }
				    }
				    
				    String sndNm = "";
				    if(paymentLetterMDMInfoVO.getSupYn().equals("N")){
				    	sndNm = command.sendPaymentRequestLetterByFaxEmail(paymentRequestLetterByEmailFaxVO);
				    } 
				    paymentRequestLetterByEmailFaxVO.setSendEmlNo(sndNm);
				}
			    
			    list.add(paymentRequestLetterByEmailFaxVO);
			}
			//history 테이블에 update
			command.modifyPaymentRequestLetterHistoryDtl(paymentRequestLetterVO.getStmtHisSeq(),list); 
		} catch (EventException ex) {
			//rollback();
			throw ex;
		} catch (Exception ex) {
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * searchPaymentRequestLetterHistory <br>
	 * 
	 * @author myoungsin Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentRequestLetterHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar1009Event event = (StmSar1009Event) e; 
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PaymentRequestLetterHisVO> paymentRequestLetterHisVOS = command.searchPaymentRequestLetterHistory(event.getPaymentRequestLetterHisVO());
			
			eventResponse.setRsVoList(paymentRequestLetterHisVOS);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
		
	/**
	 * Insert/Update SAR OUTSTANDING RECEIPT TEMP<br>
	 *  
     * @author sung yong park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOutstandingReceiptTemp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar0012Event event = (StmSar0012Event) e;
		AccountReceivableOutstandingBC command = new AccountReceivableOutstandingBCImpl();
		try {
			
			String otsRctTmpSeq = event.getApplyOutstandingCondVO().getOtsRctTmpSeq();
			
			if(event.getSarOtsRctTmpVOs() != null){			
				if(otsRctTmpSeq == null || ("").equals(otsRctTmpSeq)) {
					otsRctTmpSeq = command.searchOutstandingReceiptTempSeq();
				}
				
				begin();
				command.manageOutstandingReceiptTemp(event.getSarOtsRctTmpVOs(), otsRctTmpSeq, account.getUsr_id());
				commit();
			}
			
			eventResponse.setETCData("ots_rct_tmp_seq", otsRctTmpSeq);
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
}