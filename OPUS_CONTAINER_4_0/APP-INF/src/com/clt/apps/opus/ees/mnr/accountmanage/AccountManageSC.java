/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountManageSC.java
 *@FileTitle : AccountManageSC
 *Open Issues :
 *@Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.mnr.accountmanage;
  
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBC;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBCImpl;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0041Event;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0042Event;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0143Event;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0229Event;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnrS041Event;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnrS042Event;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.CustomPayableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.GLEstimateVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.basic.IncomeMgtBC;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.basic.IncomeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.event.EesMnr0161Event;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.CustomReceivableInvoiceDetailINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.framework.component.backend.core.WorkOnLongTxRemoteServerManager;
import com.clt.framework.component.backend.vo.WorkOnLongTxRemoteServerInfo;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
   
/**
 * COM-AccountManage Business Logic ServiceCommand - COM-AccountManage business transaction dispose
 * 
 * @author 
 * @see ExpenseMgtBC
 * @since J2EE 1.6 
 */

public class AccountManageSC extends ServiceCommandSupport {

	private SignOnUserAccount account = null;

	/**
	 * AccountManage system begin business preprocessing<br>
	 * AccoungManage create object<br>
	 */ 
	public void doStart() {
		log.debug("Begin AccountManageSC");
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}
	
	/**
	 * AccountManage system end business processing<br>
	 * AccountManage ending process after release object<br>
	 */
	public void doEnd() {
		log.debug("End AccountManageSC");
	}

	/**
	 * do processing case of event<br>
	 * COM-AgreementManage - do processing case of business all event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Event handling part of SC
		if (e.getEventName().equalsIgnoreCase("EesMnr0041Event")) {
			//retrieve 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchPayableINVInquiryListService(e);   
			} 
			//retrieve detail list 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchPayableINVInquiryDetailService(e);   
			}   
			//apply changed exchange rate of invoice amount
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {      
				eventResponse = searchPayableINVInquiryCalCurrRateService(e);   
			}   			
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {      
				eventResponse = managePayableInvoiceService(e);   
			}   		 		
			//delete 
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
			//retrieve
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchPayableINVInquiryListService(e);   
			} 
			//retrieve detail list 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchPayableINVInquiryDetailService(e);   
			}   
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0161Event")) {
			//retrieve
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {      
				eventResponse = searchReceivableInvoiceListService(e);   
			} 
			//retrieve detail list 
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {      
				eventResponse = searchReceivableInvoiceDetailListService(e);   
			}   
			//save
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {      
				eventResponse = manageReceivableInvoiceService(e);   
			}  		
			//delete
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {      
				eventResponse = removeReceivableInvoiceService(e);   
			}  			
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0229Event")) {
			//retrieve
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
	 * [EES_MNR_0042]retrieve "M&R Invoice Inquiry"<br>
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
	 * [EES_MNR_0042]retrieve "M&R Invoice Inquiry" <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPayableINVInquiryDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpenseMgtBC command = new ExpenseMgtBCImpl();       
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		
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
			
		}catch(EventException ex){ 
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	

	/**
	 * EES_MNR_0041 : Save <br>
	 * [EES_MNR_0041]add, modify, delete "M&R Invoice Creation & Correction"<br>
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
		
		PayableInvoiceGRPVO payableInvoiceGRPVO = null;

		if(e.getEventName().equalsIgnoreCase("EesMnr0041Event")){
			EesMnr0041Event event = (EesMnr0041Event)e;  
			payableInvoiceGRPVO = event.getPayableInvoiceGRPVO();   
			eQFlagListGRPVO.setEQFlagListINVO(payableInvoiceGRPVO.getEQFlagListINVO());
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS041Event")){ 
			EesMnrS041Event event = (EesMnrS041Event)e;    
			payableInvoiceGRPVO = event.getPayableInvoiceGRPVO();  
			eQFlagListGRPVO.setEQFlagListINVO(payableInvoiceGRPVO.getEQFlagListINVO());
		} 		
		
		PayableInvoiceGRPVO payableInvoiceGRPVO2 = new PayableInvoiceGRPVO(); //event.getPayableInvoiceGRPVO();
		
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		CustomMnrOrdDtlVO customMnrOrdDtlVO = new CustomMnrOrdDtlVO();
		
		String req_no = ""; 
		
		try{  
			if(payableInvoiceGRPVO != null){
				begin(); 	
				
				//MNR_PAY_INV_WRK add, modify
				payableInvoiceGRPVO2 = command.manageRepairPayableInvoiceBasic(payableInvoiceGRPVO, account);
	
				if(account.getAccess_system().equals("ALP")){
					//MNR_ORD_DTL invoice정보 clear
					if(!payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq().equals("")){
						customMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq());
						generalWOGRPVO.setCustomMnrOrdDtlVO(customMnrOrdDtlVO);
						command4.modifyWEBInvoiceLinkClearBasic(generalWOGRPVO, account);
					}
				}
				
				if(!payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd().equals("HJ")){
					//MNR_ORD_DTL invoice data modify
					CustomMnrOrdDtlVO[] arrCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO[payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs().length];
		
					CustomPayableInvoiceDetailINVO[] arrCustomPayableInvoiceDetailINVOs = payableInvoiceGRPVO.getArrayCustomPayableInvoiceDetailINVOs();
					
					for ( int i = 0; i< arrCustomPayableInvoiceDetailINVOs.length; i++ ) {  
						CustomMnrOrdDtlVO tempCustomMnrOrdDtlVO = new CustomMnrOrdDtlVO();
							
						tempCustomMnrOrdDtlVO.setPayInvSeq(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq());
						tempCustomMnrOrdDtlVO.setInvNo(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getInvNo());
						tempCustomMnrOrdDtlVO.setInvAmt(arrCustomPayableInvoiceDetailINVOs[i].getInvAmt());
						tempCustomMnrOrdDtlVO.setRprRsltDt(arrCustomPayableInvoiceDetailINVOs[i].getRprRsltDt());
						tempCustomMnrOrdDtlVO.setMnrOrdOfcCtyCd(arrCustomPayableInvoiceDetailINVOs[i].getMnrOrdOfcCtyCd());
						tempCustomMnrOrdDtlVO.setMnrOrdSeq(arrCustomPayableInvoiceDetailINVOs[i].getMnrOrdSeq());
						tempCustomMnrOrdDtlVO.setOrdDtlSeq(arrCustomPayableInvoiceDetailINVOs[i].getOrdDtlSeq());
						tempCustomMnrOrdDtlVO.setSlsTaxAmt(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getSlsTaxAmt());  
						tempCustomMnrOrdDtlVO.setInvAdjBzcAmt(arrCustomPayableInvoiceDetailINVOs[i].getInvAdjBzcAmt());
						arrCustomMnrOrdDtlVO[i] = tempCustomMnrOrdDtlVO;     	
					} 		     
					generalWOGRPVO.setArrCustomMnrOrdDtlVOS(arrCustomMnrOrdDtlVO);
					
					//setting "Invoice Status" to deliver
					generalWOGRPVO.setMnrInvStsCd(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd());
					
					command4.modifyWEBInvoiceLinkBasic(generalWOGRPVO,account);
				}
				
				if(payableInvoiceGRPVO.getCustomMnrPayInvWrkVO().getMnrInvStsCd().equals("HC")){
					
					//handling CSR
					req_no = command2.createCSRIFBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getMnrGrpTpCd(), payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(), account);
					
					//modify MNR_ORD_DTL req_no
					command.modifyTotalLossPayableInvoiceBasic(payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq(),req_no, account);
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
								customMnrEqStsVO.setMnrDmgFlgDt(arrCustomPayableInvoiceDetailINVO[i].getRprRsltDt()+"2359");
								listCustomMnrEqStsVOS.add(customMnrEqStsVO);
								
								IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
								iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
								iFMnrFlagVO.setFlagUserId(account.getUsr_id());
								iFMnrFlagVO.setFlagType("DMG");
								iFMnrFlagVO.setRetireFlag("N");
								iFMnrFlagVO.setEqKindCd(arrCustomPayableInvoiceDetailINVO[i].getEqKndCd());
								iFMnrFlagVO.setEqNo(arrCustomPayableInvoiceDetailINVO[i].getEqNo());
								iFMnrFlagVO.setStsFlag("N");
								iFMnrFlagVO.setFlagDt(arrCustomPayableInvoiceDetailINVO[i].getRprRsltDt()+"2359");
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
						String [] rtn = command2.manageCtmIfFlagBasic(interfaceGRPVO, account);
						
						eventResponse.setETCData("error1", rtn[0]);
						eventResponse.setETCData("error2", rtn[1]);
					}
					 	
				}   
				eventResponse.setETCData("pay_inv_seq", payableInvoiceGRPVO2.getCustomMnrPayInvWrkVO().getPayInvSeq()); 
					
				commit();
			}
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
	 * [EES_MNR_0041]delete "M&R Invoice Creation & Correction"<br>
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

		PayableInvoiceGRPVO payableInvoiceGRPVO = null;

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
			if(payableInvoiceGRPVO != null){
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
			}
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
	 * EES_MNR_0143 : checking <br>
	 * [EES_MNR_0143]check "M&R Invoice Creation File"'s data<br>
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
			
			//getting sequence after save data on temporary table
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
	 *   EES_MNR_0161: retrieve  <br>
	 * [ EES_MNR_0161] retrieve data<br>
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
	 * [EES_MNR_0161]retrieve "Disposal Invoice Issue" data <br>
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
	 * EES_MNR_0161 : add, modify, delete <br>
	 * [EES_MNR_0161]add, modify, delete "Disposal Invoice Issue"<br>
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
			begin(); 

			if(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getCancelYn().equals("")){
				
				//MNR_DISP_DTL invoice clear data
				event.getDisposalGRPVO().getCustomMnrDispDtlVO().setInvNo(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo());
				if(!event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getInputInvNo().equals("")){
					command2.modifyDisposalInvoiceLinkClearBasic(event.getDisposalGRPVO(),account);
				}
				
				//add, modify MNR_RCV_INV_WRK
				receivableInvoiceGRPVO = command.manageRepairReceivableInvoiceBasic(event.getReceivableInvoiceGRPVO(),account);
				
				//modify MNR_DISP_DTL invoice
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
				//
			}	

			if(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getMnrInvStsCd().equals("HC")){
				receivableInvoiceGRPVO = command4.searchInvArIfListBasic(event.getReceivableInvoiceGRPVO(),account);
				List<InvArIfChgVO> list = receivableInvoiceGRPVO.getInvArIfChgVOs();
				for(int i = 0; i< list.size(); i++){
					if("ERR".equals(list.get(i).getChgCd())){
						throw new EventException(new ErrorHandler("MNR00001",new String[]{"Disposal Equipment has no Asset Code."}).getMessage());
					}
				}
				aRInterfaceCreationVO.setInvArIfMnVO(receivableInvoiceGRPVO.getInvArIfMnVO());
				aRInterfaceCreationVO.setInvArIfChgVOs(receivableInvoiceGRPVO.getInvArIfChgVOs());
				aRInterfaceCreationVO.setInvArIfCntrVOs(receivableInvoiceGRPVO.getInvArIfCntrVOs());
				aRInterfaceCreationVOs.add(aRInterfaceCreationVO);

				aRInterfaceCreationVOs = command3.interfaceGeneralARInvoiceToIF(aRInterfaceCreationVOs);
				String strResult = command3.interfaceGeneralARInvoiceToINV(aRInterfaceCreationVOs);
				
				String[] strResults =  strResult.split("::");
				if(strResults[0].equals("E")){
					throw new EventException(new ErrorHandler("MNR00001",new String[]{strResults[1]}).getMessage());
				}else{
					if(event.getReceivableInvoiceGRPVO().getReceivableINVInquiryINVO().getCancelYn().equals("Y")){
						receivableInvoiceGRPVO.getReceivableINVInquiryINVO().setMnrInvStsCd("HS");
						command.modifyReceivableInvoiceStatusBasic(receivableInvoiceGRPVO,account);
					}
				}
				
				//FA 전송
//				InterfaceMgtBC command10	= new 	InterfaceMgtBCImpl();
//				CustomReceivableInvoiceDetailINVO[] arrCustomReceivableInvoiceDetailINVO = receivableInvoiceGRPVO.getArrayCustomReceivableInvoiceDetailINVOs();
//				FaErpListVO[] arrayfaErpListVOs = new FaErpListVO[arrCustomReceivableInvoiceDetailINVO.length];
//				String ymdhms = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
//				String ymdhm  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
//				
//				for ( int i = 0; i< arrCustomReceivableInvoiceDetailINVO.length; i++ ) {  
//					FaErpListVO faErpListVO = new FaErpListVO();
//					faErpListVO.setLifid("FNS027-0001");
//					faErpListVO.setSeq(ymdhms + arrCustomReceivableInvoiceDetailINVO[i].getEqNo());
//					faErpListVO.setTotalCount(String.valueOf(arrCustomReceivableInvoiceDetailINVO.length));
//					faErpListVO.setRnum(String.valueOf(i+1));
//					//Tag Number search start////////////////////////////////
//					String faEqNo = "";
//					String eqNo		= arrCustomReceivableInvoiceDetailINVO[i].getEqNo();
//					faEqNo	= command10.searchFAEqNoBasic(eqNo);
//					faErpListVO.setTagNumber(faEqNo);
//					//Tag Number search end//////////////////////////////////
//					faErpListVO.setBookTypeCode("OPUS GAAP BOOK");
//					faErpListVO.setDateRetired(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInvDt().replace("-", ""));					
//					faErpListVO.setProceedsOfSale(arrCustomReceivableInvoiceDetailINVO[i].getInvAmt().replace(",", ""));
//					faErpListVO.setInvoiceNo(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo());
//					faErpListVO.setUnitsRetired("1");
//					faErpListVO.setRetirementTypeCode("SALE");
//					faErpListVO.setInterfaceFlag("N");
//					faErpListVO.setCreationDate(ymdhm);
//					faErpListVO.setLastUpdateDate(ymdhm);
//					faErpListVO.setSoldTo("136514");		
//					//추가 2010-07-08	
//					faErpListVO.setLclAmt(arrCustomReceivableInvoiceDetailINVO[i].getInvAmt().replace(",", ""));
//					faErpListVO.setLclCurr(receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getCurrCd());       
//						
//					arrayfaErpListVOs[i] = faErpListVO; 	
//				}     
				//전송
//				command10.faSendBasic(arrayfaErpListVOs, account, "DSP"); // Disposal Invoice Issue 구분(DSP)
			}
			
			eventResponse.setETCData("rcv_inv_seq", receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getRcvInvSeq()); 
			eventResponse.setETCData("input_inv_no", receivableInvoiceGRPVO.getReceivableINVInquiryINVO().getInputInvNo()); 
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
	 * EES_MNR_0161 : Delete <br>
	 * [EES_MNR_0161] delete "Disposal Invoice Issue"<br>
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
	 * retrieve "M&R Estimate expense"<br>
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
	 * [EES_MNR_0229] to call manageGLEstimateIFListService<br>
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
			info.setCallScName("com.clt.apps.opus.ees.mnr.accountmanage.AccountManageSC");
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
	 * Confirm "M&R Estimate expense"<br>
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
	 * EES_MNR_0141 : modify <br>
	 * [EES_MNR_0141] apply changed exchange rate of invoice amount<br>
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
			
			//getting sequence after save data on temporary table
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
}