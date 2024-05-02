/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RenewalConsultationSC.java
*@FileTitle : Settlement Item & Account Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.basic.RenewalConsultationBC;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.basic.RenewalConsultationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0101Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0102Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0103Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0104Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0105Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0106Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0107Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.event.FnsJoo0108Event;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ActualDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.ConsultationConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceDetailVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.InvoiceVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.vo.SettlementTargetVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBC;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComActualCarrierVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.StringUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-JointOperationMasterDataMgtSC Business Logic ServiceCommand - handling business transaction
 * 
 * @author
 * @see RenewalMasterDataMgtBCDBDAO
 * @since J2EE 1.4
 */

public class RenewalConsultationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * JointOperationMasterDataMgtSC system : preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * JointOperationMasterDataMgtSC system : biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("RenewalConsultationSC 종료");
	}

	/**
	 * 
	 * OPUS-RenewalMasterDataMgtSC system <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("FnsJoo0101Event")) { //select target VVD for Settlement Creation

            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	// Retrieve BackEndJob Call.
                eventResponse = searchSettlementTargetBackEndJobList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //BackEndJob Status
                eventResponse = searchComBackEndJobStatus(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //BackEndJob Result
                try {
					eventResponse = searchComBackEndJobResult(e);
				} catch (BackEndJobException ex) {
					throw new EventException(ex.getMessage());
				}
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { // Create BackEndJob Call.
                eventResponse = calculateSettlementTargetBackEndJobList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save BackEndJob Call.
                eventResponse = manageSettlementTargetBackEndJobList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0101(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0102Event")) {

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchInvoiceTargetList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchInvoiceTargetDetailList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
                eventResponse = manageInvoiceList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0102(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0103Event")) { // Authority Carrier 

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCsrCreationList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //Effective Date 체크.
                eventResponse = searchEffectiveDateCloseYn(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //CSR 생성.
                eventResponse = manageConsultationList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0103(e);			
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0104Event")) { // Select actual payer/receiver for slip

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchActualPayerReceiverList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
                eventResponse = manageActualPayerReceiverList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0104(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0105Event")) { // Actual Detail 

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchActualDetailList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchInvoiceNoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0105(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0106Event")) {

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchInvoiceDeleteList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
                eventResponse = manageInvoiceDeleteList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0106(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0107Event")) {

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //Summary
                eventResponse = searchInvoiceReportSummaryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Detail
                eventResponse = searchInvoiceReportDetailList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0107(e);				
			}
        } else if (e.getEventName().equalsIgnoreCase("FnsJoo0108Event")) { // Settlement Target Summary

        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSettlementTargetSummaryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsJoo0108(e);				
			}
        } 
		
		return eventResponse;
	}
	

    /**
     *  FNS_JOO_0101 : Open <br>
     *  retrieving Select Target VVD and Settlement<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	@SuppressWarnings("unchecked")
	private EventResponse openFnsJoo0101(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		String joCrrCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String authOfcCds 		= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
            
    		String itemCombo 		= getOpenEtcDataList(mItmCdFlag); //IBCombo, Code만
    		String mnlItemCombo 	= getOpenEtcDataList(mItmCdByMnlFlag); //IBCombo, Code만
    		
    		
    		// Revenue Direction
    		CodeUtil codeUtil = CodeUtil.getInstance();
			Collection<CodeInfo> codeList2 = codeUtil.getCodeSelect("CD01866", 0); // BSA Type
    		String stljbSheetList[] = StringUtil.split(BizComUtil.getCodeSelectString(codeList2), BizComUtil.CODE_DELIMITTER);
    		String bsaTypeCd[] = (stljbSheetList[0]).split("[|]");
    		String bsaTypeNm[] = (stljbSheetList[1]).split("[|]");

    		String code = "";
    		int iCode = 0;
    		StringBuilder bsaTypeCdTmp = new StringBuilder();
    		StringBuilder bsaTypeNmTmp = new StringBuilder();
    		for (int i=0; i<bsaTypeCd.length; i++){
    			code = bsaTypeCd[i].substring(0,1);
    			iCode = Integer.parseInt(bsaTypeCd[i]);
    			if ("1".equals(code) && iCode < 104){
    				bsaTypeCdTmp.append(bsaTypeCd[i]+"|");
    				bsaTypeNmTmp.append(bsaTypeNm[i]+"|");
    			}
    		}

    		String bsaTpCd = bsaTypeCdTmp.toString().substring(0, bsaTypeCdTmp.toString().length()-1);
    		String bsaTpNm = bsaTypeNmTmp.toString().substring(0, bsaTypeNmTmp.toString().length()-1);
    		
    		eventResponse.setETCData("jo_crr_cds"   	, joCrrCdCombo);
    		eventResponse.setETCData("item_cds"   		, itemCombo);
    		eventResponse.setETCData("mnl_item_cds" 	, mnlItemCombo);
    		eventResponse.setETCData("jo_stl_jb_cds" 	, bsaTpCd);
    		eventResponse.setETCData("jo_stl_jb_nms" 	, bsaTpNm);
    		eventResponse.setETCData("auth_ofc_cds"  	, authOfcCds);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }	

    /**
     *  FNS_JOO_0101 : Retrieve <br>
     *  retrieving Select Target VVD and Settlement<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse searchSettlementTargetBackEndJobList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0101Event event = (FnsJoo0101Event)e;
        	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        	
			String key = command.searchSettlementTargetBackEndJobList(event.getSettlementTargetVO(), "RETRIEVE", account);
			eventResponse.setETCData("job_key", key);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }	

    /**
     *  FNS_JOO_0101 : Create <br>
     *  create Select Target VVD and Settlement<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse calculateSettlementTargetBackEndJobList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0101Event event = (FnsJoo0101Event)e;
        	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        	
			String key = command.searchSettlementTargetBackEndJobList(event.getSettlementTargetVO(), "CREATE", account);
			eventResponse.setETCData("job_key", key);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }	

    /**
     *  FNS_JOO_0101 : Save <br>
     *  save Select Target VVD and Settlement<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse manageSettlementTargetBackEndJobList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	FnsJoo0101Event event = (FnsJoo0101Event)e;
        	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        	
			String key = command.manageSettlementTargetBackEndJobList(event.getSettlementTargetVOS(), "SAVE", account);
			eventResponse.setETCData("job_key", key);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	

    /**
     *  FNS_JOO_0102 : Open <br>
     *  retrieving Invoice/Slip Creation and Inquiry<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0102(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		//String joCrrCdCombo 	= getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String joCrrCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String authOfcCds 		= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
            
    		
    		String acctgCrrCdCombo= getOpenEtcDataList(mAcctgCrrCdFlag); //jo_crr_cd^^vndr_cd^^cust_cd|jo_crr_cd^^vndr_cd^^cust_cd...
    		String acctgCrrNmCombo= getOpenEtcDataList(mAcctgCrrNmFlag); //jo_crr_cd\tvndr_nm\tcust_nm|jo_crr_cd\tvndr_nm\tcust_nm...
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("acctg_crr_cds", acctgCrrCdCombo);
    		eventResponse.setETCData("acctg_crr_nms", acctgCrrNmCombo);
    		eventResponse.setETCData("auth_ofc_cds"	, authOfcCds);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : Invoice Creation 대상 조회.
	 * 
	 * @category FNS_JOO_0102
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchInvoiceTargetList(Event e) throws EventException {
        FnsJoo0102Event event = (FnsJoo0102Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
	        List<InvoiceVO> list = command.searchInvoiceTargetList(   event.getConsultationConditionVO() );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
	
    /**
     * Retrieve : Invoice Creation Detail 대상 조회.
	 * 
	 * @category FNS_JOO_0102
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchInvoiceTargetDetailList(Event e) throws EventException {
        FnsJoo0102Event event = (FnsJoo0102Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
	        List<InvoiceDetailVO> list = command.searchInvoiceTargetDetailList(   event.getConsultationConditionVO() );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }

    /**
     * Save : Invoice/Slip Creation. 
	 * 
	 * @category FNS_JOO_0102
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse manageInvoiceList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
    	FnsJoo0102Event event = (FnsJoo0102Event)e;
    	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        try{
        	begin();
			command.manageInvoiceList(event.getInvoiceVOS(), event.getInvoiceDetailVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage()); 
			commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	

    /**
     *  FNS_JOO_0103 : Open <br>
     *  retrieving CSR Creation<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0103(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		//String joCrrCdCombo   	= getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String joCrrCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String acctgCrrCdCombo	= getOpenEtcDataList(mAcctgCrrCdFlag); //jo_crr_cd^^vndr_cd^^cust_cd|jo_crr_cd^^vndr_cd^^cust_cd...
    		String acctgCrrNmCombo	= getOpenEtcDataList(mAcctgCrrNmFlag); //jo_crr_cd\tvndr_nm\tcust_nm|jo_crr_cd\tvndr_nm\tcust_nm...
    		String authOfcCds 		= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
                		
    		JOOFindCodeAndCheckBC command = new JOOFindCodeAndCheckBCImpl();
    		String localDateTime = command.searchLocalDateTime(account.getOfc_cd());
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("acctg_crr_cds", acctgCrrCdCombo);
    		eventResponse.setETCData("acctg_crr_nms", acctgCrrNmCombo);
    		eventResponse.setETCData("local_date"	, localDateTime);
    		eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : CSR Creation 조회.
	 * 
	 * @category FNS_JOO_0103
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchCsrCreationList(Event e) throws EventException {
        FnsJoo0103Event event = (FnsJoo0103Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
    		ConsultationConditionVO  consultationConditionVO = (ConsultationConditionVO) event.getConsultationConditionVO();
    		consultationConditionVO.setOfcCd(account.getOfc_cd());
    		consultationConditionVO.setUsrId(account.getUsr_id());
    		
	        List<SlipProcessVO> list = command.searchCsrCreationList(   consultationConditionVO );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
    

	
    /**
     * Retrieve : CSR Creation 조회.
	 * 
	 * @category FNS_JOO_0103
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchEffectiveDateCloseYn(Event e) throws EventException {
        FnsJoo0103Event event = (FnsJoo0103Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		JointOperationConsultationBC command = new JointOperationConsultationBCImpl();
    		SlipProcessVO slipProcessVO = command.searchCloseYn(event.getSlipProcessVO());
    		
    		eventResponse.setETCData("clos_yn",slipProcessVO.getVvdCxlFlg());
    		eventResponse.setETCData("eff_dt" ,slipProcessVO.getEffDt());
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }	

    /**
     *  FNS_JOO_0103 : Save <br>
     *  save CSR Creation List : AP/AR 생성.<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse manageConsultationList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
    	FnsJoo0103Event event = (FnsJoo0103Event)e;
    	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        try{

        	begin();
			command.manageConsultationList(event.getSlipProcessVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage()); 
			commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	

    /**
     *  FNS_JOO_0104 : Open <br>
     *  retrieving Select actual payer/receiver for slip<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0104(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	String joCrrCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String authOfcCds 		= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
            String itemCombo 		= getOpenEtcDataList(mItmCdFlag); //IBCombo, Code만
    		
    		String acctgCrrCdCombo= getOpenEtcDataList(mAcctgCrrCdFlag); //jo_crr_cd^^vndr_cd^^cust_cd|jo_crr_cd^^vndr_cd^^cust_cd...
    		String acctgCrrNmCombo= getOpenEtcDataList(mAcctgCrrNmFlag); //jo_crr_cd\tvndr_nm\tcust_nm|jo_crr_cd\tvndr_nm\tcust_nm...
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("acctg_crr_cds", acctgCrrCdCombo);
    		eventResponse.setETCData("acctg_crr_nms", acctgCrrNmCombo);
    		eventResponse.setETCData("item_cds"   	, itemCombo);
    		eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : Select actual payer/receiver for slip 조회.
	 * 
	 * @category FNS_JOO_0104
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchActualPayerReceiverList(Event e) throws EventException {
        FnsJoo0104Event event = (FnsJoo0104Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
	        List<InvoiceVO> list = command.searchActualPayerReceiverList(   event.getConsultationConditionVO() );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }

    /**
     * Save : Select actual payer/receiver for slip 저장.
	 * 
	 * @category FNS_JOO_0104
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse manageActualPayerReceiverList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
    	FnsJoo0104Event event = (FnsJoo0104Event)e;
    	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        try{
        	begin();
			command.manageActualPayerReceiverList(event.getConsultationConditionVO(), event.getInvoiceVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage()); 
			commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	

    /**
     *  FNS_JOO_0105 : Open <br>
     *  retrieving Select actual payer/receiver for slip<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0105(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		String joCrrCdCombo 	= getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String itemCombo 		= getOpenEtcDataList(mItmCdFlag); //IBCombo, Code만
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("item_cds"   	, itemCombo);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : Actual Detail Invoice No Combo Item 조회.
	 * 
	 * @category FNS_JOO_0105
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchInvoiceNoList(Event e) throws EventException {
        FnsJoo0105Event event = (FnsJoo0105Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
	        List<ActualDetailVO> list = command.searchInvoiceNoList(   event.getConsultationConditionVO() );
	        
	        StringBuilder sb = new StringBuilder();
	        for(ActualDetailVO invNoVo : list){
	        	sb.append(invNoVo.getInvNo());
				sb.append(JooConstants.SPLIT_ROW_STRING);
	        }
	        
			String rtnVal = sb.toString();
			
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
	        
			eventResponse.setETCData("inv_nos"   , rtnVal);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
	
    /**
     * Retrieve : Actual Detail 조회.
	 * 
	 * @category FNS_JOO_0105
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchActualDetailList(Event e) throws EventException {
        FnsJoo0105Event event = (FnsJoo0105Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
	        List<ActualDetailVO> list = command.searchActualDetailList(   event.getConsultationConditionVO() );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
	

    /**
     *  FNS_JOO_0106 : Open <br>
     *  retrieving Invoice Delete Target<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0106(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
        	String joCrrCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String authOfcCds 		= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
            //String joCrrCdCombo 	= getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		//String acctgCrrCdCombo= getOpenEtcDataList(mAcctgCrrCdFlag); //jo_crr_cd^^vndr_cd^^cust_cd|jo_crr_cd^^vndr_cd^^cust_cd...
    		//String acctgCrrNmCombo= getOpenEtcDataList(mAcctgCrrNmFlag); //jo_crr_cd\tvndr_nm\tcust_nm|jo_crr_cd\tvndr_nm\tcust_nm...
    		
    		//eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		//eventResponse.setETCData("acctg_crr_cds", acctgCrrCdCombo);
    		//eventResponse.setETCData("acctg_crr_nms", acctgCrrNmCombo);
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : Invoice Delete Target 대상 조회.
	 * 
	 * @category FNS_JOO_0106
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchInvoiceDeleteList(Event e) throws EventException {
        FnsJoo0106Event event = (FnsJoo0106Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
    		
    		ConsultationConditionVO  consultationConditionVO = (ConsultationConditionVO) event.getConsultationConditionVO();
    		consultationConditionVO.setOfcCd(account.getOfc_cd());
    		consultationConditionVO.setUsrId(account.getUsr_id());
    		
	        List<InvoiceVO> list = command.searchInvoiceDeleteList(   consultationConditionVO );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }

    /**
     * Save : Invoice Delete Target 대상 삭제 처리.
	 * 
	 * @category FNS_JOO_0106
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse manageInvoiceDeleteList(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
    	FnsJoo0106Event event = (FnsJoo0106Event)e;
    	RenewalConsultationBC command = new RenewalConsultationBCImpl();
        try{
        	begin();
			command.manageInvoiceDeleteList(event.getInvoiceVOS(), account);
			
			eventResponse.setUserMessage(new ErrorHandler("JOO10003").getUserMessage()); 
			commit();
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }

	

    /**
     *  FNS_JOO_0107 : Open <br>
     *  retrieving Invoice Inquiry<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0107(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		//String joCrrCdCombo 	= getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String joCrrCdCombo 	= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_CARRIER); //getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String authOfcCds 		= this.searchConditionComboItemByAuthOfficeCd(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC); //2016.07.26 권한 있는 Office 조회
            
    		//String acctgCrrCdCombo= getOpenEtcDataList(mAcctgCrrCdFlag); //jo_crr_cd^^vndr_cd^^cust_cd|jo_crr_cd^^vndr_cd^^cust_cd...
    		//String acctgCrrNmCombo= getOpenEtcDataList(mAcctgCrrNmFlag); //jo_crr_cd\tvndr_nm\tcust_nm|jo_crr_cd\tvndr_nm\tcust_nm...
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		eventResponse.setETCData("auth_ofc_cds" , authOfcCds);
    		//eventResponse.setETCData("acctg_crr_cds", acctgCrrCdCombo);
    		//eventResponse.setETCData("acctg_crr_nms", acctgCrrNmCombo);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : Invoice Inquiry : Summary 조회.
	 * 
	 * @category FNS_JOO_0107
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchInvoiceReportSummaryList(Event e) throws EventException {
    	FnsJoo0107Event event = (FnsJoo0107Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
    		
    		ConsultationConditionVO  consultationConditionVO = (ConsultationConditionVO) event.getConsultationConditionVO();
	        List<InvoiceVO> list = command.searchInvoiceReportSummaryList(   consultationConditionVO );

	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
	
    /**
     * Retrieve : Invoice Inquiry : Detail 조회.
	 * 
	 * @category FNS_JOO_0107
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchInvoiceReportDetailList(Event e) throws EventException {
    	FnsJoo0107Event event = (FnsJoo0107Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
    		
    		ConsultationConditionVO  consultationConditionVO = (ConsultationConditionVO) event.getConsultationConditionVO();
	        List<InvoiceDetailVO> list = command.searchInvoiceReportDetailList(   consultationConditionVO );

	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
	

    /**
     *  FNS_JOO_0108 : Open <br>
     *  retrieving Settlement Target Summary<br>
     *  2016.05.13 Renewal Add.
     *
     * @throws EventException
     * @return EventResponse
     * @author 
     */
	private EventResponse openFnsJoo0108(Event e) throws EventException {
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        try{
    		String joCrrCdCombo 	= getOpenEtcDataList(mCrrCdFlag); //IBCombo, Code만
    		String itemCombo 		= getOpenEtcDataList(mItmCdFlag); //IBCombo, Code만
    		
    		//String acctgCrrCdCombo= getOpenEtcDataList(mAcctgCrrCdFlag); //jo_crr_cd^^vndr_cd^^cust_cd|jo_crr_cd^^vndr_cd^^cust_cd...
    		//String acctgCrrNmCombo= getOpenEtcDataList(mAcctgCrrNmFlag); //jo_crr_cd\tvndr_nm\tcust_nm|jo_crr_cd\tvndr_nm\tcust_nm...
    		
    		eventResponse.setETCData("jo_crr_cds"   , joCrrCdCombo);
    		//eventResponse.setETCData("acctg_crr_cds", acctgCrrCdCombo);
    		//eventResponse.setETCData("acctg_crr_nms", acctgCrrNmCombo);
    		eventResponse.setETCData("item_cds"   	, itemCombo);
    		
        } catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }    
        return eventResponse;
    }
	
    /**
     * Retrieve : Settlement Target Summary 조회.
	 * 
	 * @category FNS_JOO_0108
     * @param Event e
     * @throws EventException
     * @return EventResponse
     * @author 
     */
    private EventResponse searchSettlementTargetSummaryList(Event e) throws EventException {
        FnsJoo0108Event event = (FnsJoo0108Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		RenewalConsultationBC command = new RenewalConsultationBCImpl();
	        
	        List<InvoiceVO> list = command.searchSettlementTargetSummaryList(   event.getConsultationConditionVO() );
	        eventResponse.setRsVoList(list);
	        
    	} catch (EventException ex) {
    		log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            log.error("error "+ex.toString(), ex);
            throw new EventException(ex.getMessage(), ex);
        }
    	return eventResponse;
    }
	
    /**
     * Common
     * Retrieve Common BackEndJob Status
     * 2016.05.19 Add
     * 
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchComBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RenewalConsultationBC command = new RenewalConsultationBCImpl();
		String key = (String)e.getAttribute("job_key");
		String status = null;
		try {
			status = command.searchComBackEndJobStatus(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("JOO10007", new String[]{""}).getMessage());
		}		
		return eventResponse;
	}	
	
	/**
     * Common
     * Retrieve Common BackEndJob Result
     * 
     * @param Event e
     * @return EventResponse
	 * @throws BackEndJobException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchComBackEndJobResult(Event e) throws EventException, BackEndJobException {
		String key = (String)e.getAttribute("job_key");		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(e.getEventName().equalsIgnoreCase("FnsJoo0101Event")) {
				List<SettlementTargetVO> list = null;
				list = (List<SettlementTargetVO>)BackEndJobResult.loadFromFile(key);
				
				if( list != null ) {
					eventResponse.setRsVoList(list);
				}
			}
			
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("JOO10007", new String[]{""}).getMessage());
		}
		return eventResponse;
	}
    
    /**
     * JOO_CRR_AUTH에 등록된 Office 권한의 ComboItem 조회.
     * @param comboItemFlg
     * @return
     * @throws EventException
     */
    private String searchConditionComboItemByAuthOfficeCd(String comboItemFlg) throws EventException {
    	try {    
		    JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
		    
		    String ofcCd = account.getOfc_cd();
		    boolean isContainOffice = OfficeCodeMgr.checkContainOfficeCode(JooConstants.KEY_OFFICE_GROUP_CD, JooConstants.KEY_OFFICE_SUBSYS_CD, ofcCd);
		    
		    String authOfcCd = isContainOffice ? "" : ofcCd; //등록된 Office일때는 ALL 권한, 그렇지 않으면 디폴트로 Login office
		    
		    //authDelcheckYn
		    JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		    jooCodeParamVO.setOfcCd(authOfcCd);
		    
		    String rtnCds = "";
		    
		    if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_CARRIER)){
		    	List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeList(jooCodeParamVO);
		    	rtnCds = makeComboString(carrlist, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_TRADE)){
		    	List<JooCodeInfoVO> list = command.searchTradeCodeList(jooCodeParamVO);
		    	rtnCds = makeComboString(list, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_RLANE)){
		    	List<JooCodeInfoVO> rlaneList = command.searchRlaneCodeList(jooCodeParamVO);
		    	rtnCds= makeComboString(rlaneList, 2); //IBCombo, Code만
		    }else if(comboItemFlg.equals(JooConstants.KEY_COMBOITEM_FLG_AUTH_OFC)){
		    	//2016.07.26 권한 있는 Office 조회
				if (isContainOffice){
					List<JooCodeInfoVO> authOfcList = command.searchAuthOfficeList(jooCodeParamVO);
					if (authOfcList.isEmpty()) {
						rtnCds = ofcCd + "," + ofcCd;
					}else{ 
						rtnCds = "ALL,|"+makeComboString(authOfcList, 1);
					}
				}else{
					rtnCds = ofcCd+","+ofcCd;
				}
		    }
		    
		    return rtnCds;
    	} catch (EventException ex) {
            log.error("error "+ex.toString(), ex);
            rollback();
            throw ex;
        }
    }
	

	
	int mCrrCdFlag = 1;
	int mItmCdFlag = 2;
	int mItmCdByMnlFlag = 3;
	int mSheetCrrCdFlag = 4;
	int mAcctgCrrCdFlag = 5;
	int mAcctgCrrNmFlag = 6;
	/**
	 * getOpenEtcDataList
	 * @param flag
	 * @return String
	 * @throws EventException
	 */
	private String getOpenEtcDataList(int flag) throws EventException{
		JOOFindCodeAndCheckBC    command    = new JOOFindCodeAndCheckBCImpl();
		JooCodeParamVO jooCodeParamVO = new JooCodeParamVO();
		if(flag == mCrrCdFlag){
			//Carrier All List
			List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
	        return makeComboString(carrlist, 1); //IBCombo, Code만	         
		}else if(flag == mItmCdByMnlFlag){
			//Item All List
			jooCodeParamVO.setSuperCd2("Y"); // Manual Check 된 ITEM
    		List<JooCodeInfoVO> mnlItemList = command.searchStlItemCodeList(jooCodeParamVO);
    		return makeComboString(mnlItemList, 2); //IBCombo, Code만
		}else if(flag == mItmCdFlag){
			//Item All List
    		List<JooCodeInfoVO> itemList = command.searchStlItemCodeList(jooCodeParamVO);
    		return makeComboString(itemList, 2); //IBCombo, Code만
		}else if(flag == mSheetCrrCdFlag){
			//Carrier All List : Sheet Combo
			List<JooCodeInfoVO> carrlist   = command.searchCarrierCodeWithoutAuthorityList(jooCodeParamVO);
	        return makeComboString(carrlist, 2); //IBSheet, Code만	 
		}else if(flag == mAcctgCrrCdFlag){
			StringBuilder sb = new StringBuilder();
			//Carrier All List : Sheet Combo
			List<JooComActualCarrierVO> carrlist   = command.searchActualCarrierList(jooCodeParamVO);
			
			for(JooComActualCarrierVO vo : carrlist){
				sb.append(vo.getJoCrrCd());
				sb.append(JooConstants.SPLIT_DATA_STRING);
				sb.append(vo.getCustCd());
				sb.append(JooConstants.SPLIT_DATA_STRING);
				sb.append(vo.getVndrSeq());
				sb.append(JooConstants.SPLIT_ROW_STRING);
			}
			
			String rtnVal = sb.toString();
			
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
			return rtnVal; 
		}else if(flag == mAcctgCrrNmFlag){
			StringBuilder sb = new StringBuilder();
			//Carrier All List : Sheet Combo
			List<JooComActualCarrierVO> carrlist   = command.searchActualCarrierList(jooCodeParamVO);
		
			for(JooComActualCarrierVO vo : carrlist){
				sb.append(vo.getJoCrrCd());
				sb.append(JooConstants.SPLIT_TAP_STRING);
				sb.append(vo.getCustLglEngNm());
				sb.append(JooConstants.SPLIT_TAP_STRING);
				sb.append(vo.getVndrLglEngNm());
				sb.append(JooConstants.SPLIT_ROW_STRING);
			}
			
			String rtnVal = sb.toString();
			
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
			return rtnVal; 
		}
		return "";
	}
	
	/**
	 * changing List to String
	 * @param List<JooCodeInfoVO> list
	 * @param int flg
	 * @return String rtnVal
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private String makeComboString(List<JooCodeInfoVO> list, int flg) throws EventException{
		String rtnVal = null;
		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			JooCodeInfoVO jooCodeInfoVO = (JooCodeInfoVO)iterator.next();
			
			if (flg==0){
				sb.append(jooCodeInfoVO.getName()+","+jooCodeInfoVO.getCode()+"|");				
			//IBCombo (code, code|)
			}else if (flg==1){
				sb.append(jooCodeInfoVO.getCode()+","+jooCodeInfoVO.getCode()+"|");				
			//IBSheet code(code|)
			}else if (flg==2){
				sb.append(jooCodeInfoVO.getCode()+"|");				
			//IBSheet name(name|)
			}else if (flg==3){
				sb.append(jooCodeInfoVO.getName()+"|");				
			//SuperCd
			}else if (flg==4){
				sb.append(jooCodeInfoVO.getSuperCd1()+","+jooCodeInfoVO.getSuperCd2()+","+jooCodeInfoVO.getCode()+"|");				
			}else if (flg==5){
				sb.append(jooCodeInfoVO.getCode()+"\t"+jooCodeInfoVO.getName()+"|");				
			}
		}
		
		rtnVal = sb.toString();
		
		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}
		
		return rtnVal;
	}
} 