/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TRSInterfaceRSC.java
*@FileTitle : trs 공통
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 최 선 
*@LastVersion : 1.2
* 2006.12.20 Lee Sang-Woo
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2010.05.17 김종호 1.1 : searchCustRefPartyManage 추가
* 2012.02.07 최 선   1.2 [CHM-201215882] [TRS/SPP] 210 EDI 수신요건 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.basic.Invoice210EdiBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.basic.CanadaCustomsBC;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.basic.CanadaCustomsBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustoms.event.Esd076Hu01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.basic.CanadaCustomsVesselBC;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.basic.CanadaCustomsVesselBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.canadacustomsvessel.event.Esd075Hu01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.custpreference.basic.CustPreferenceBC;
import com.hanjin.apps.alps.esd.trs.servicesio.custpreference.basic.CustPreferenceBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.custpreference.event.CustPreferenceEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.eursoack.basic.EurSoAckManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.eursoack.basic.EurSoAckManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.eursoack.event.EdiEns002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.basic.Invoice210EdiManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.basic.Invoice210EdiManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.event.Esd999Hu01Event;
import com.hanjin.apps.alps.esd.trs.servicesio.korsoack.basic.KorSoAckManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.korsoack.basic.KorSoAckManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.korsoack.event.EdiEns003Event;
import com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.event.EdiEns001Event;
import com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.basic.USATruckEdiWoAckManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.basic.USATruckEdiWoAckManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.event.EdiEns004Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.basic.CustRefPartyManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.basic.CustRefPartyManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.event.Esd078Hu01Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TrsTrspEdiRailOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ENIS-BIZCOMMON Business Logic ServiceCommand<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see ESD006_HU01EventResponse,USACargoReleaseManageDBDAO 참조
 * @since J2EE 1.4
 */
public class TRSInterfaceRSC extends ServiceCommandSupport {
	
	// Login User Information
    private SignOnUserAccount account = null;

	private ArrayList emlresponseArray = null;

    /**
     * BIZCOMMON 업무 시나리오 선행작업<br>
     * Vessel업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("BizCommonSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Vessel업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("BizCommonSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-BIZCOMMON 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

		emlresponseArray = new ArrayList();

		if(e.getEventName().equalsIgnoreCase("Esd075Hu01Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				 searchCanadaCustomsVesselManage(e);
			} 
		} else if(e.getEventName().equalsIgnoreCase("Esd076Hu01Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				 searchCanadaCustomsManage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EdiEns002Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		searchEurSoAckManage(e);
        	} 
        } else if (e.getEventName().equalsIgnoreCase("EdiEns003Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		searchKorSoAckManage(e);
        	} 
        } else if (e.getEventName().equalsIgnoreCase("EdiEns004Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		 searchUSATruckEdiWoAckManage(e);
        	} 
        } else if(e.getEventName().equalsIgnoreCase("Esd999Hu01Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				search210EDIInvoiceMange(e);
			}
		} /*else if (e.getEventName().equalsIgnoreCase("Esd007Hu01Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		searchDomesticRailSOManage(e);
        	} 	
        } else if(e.getEventName().equalsIgnoreCase("ESD012_HU01Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPickupNoticeBasicManage(e);
			}else {
				eventResponse = null;
			}	
		}*/ else if (e.getEventName().equalsIgnoreCase("EdiEns001Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		searchUSARailWoAckManage(e);
        	} 
	    }else if (e.getEventName().equalsIgnoreCase("CustPreferenceEvent")) {
	    	if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = manageCustPreference(e);
	    	} 
		} else if(e.getEventName().equalsIgnoreCase("Esd078Hu01Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustRefPartyManage(e);
			} else {
				eventResponse = null;
			}	
	    }
        return eventResponse;
    }
	

    /**
     * EDI 이벤트 처리<br>
     * EDI 에 대한 조회 이벤트 처리<br>
     * 
	 * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private void searchUSARailWoAckManage(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	ArrayList pre_eventResponse = null;

		int resultCount = 0;
    	try {
        	begin();
        	String str = ((EdiEns001Event)e).getString();
        	USARailWoAckManageBC command = new USARailWoAckManageBCImpl();
        	USA404EDIStatusInquiryBC pre_command = new USA404EDIStatusInquiryBCImpl();
        	resultCount = command.receiveUSARailWoAckManageList(str);
        	command.receiveUSARailReWoAckManageList(str);
        	commit();
        	
        	begin();
        	if (resultCount > 0) {
        		Collection model = command.searchUSARailWoAckManageList(str);
	        	if( (model != null) && (model.size()>0)) {
		        	Iterator itr = model.iterator();
		        	TrsTrspEdiRailOrdVO models = null;
		        	models = (TrsTrspEdiRailOrdVO)itr.next();
		        	String sOfc_cty_cd = models.getTrspSoOfcCtyCd();
		        	String sSo_seq = models.getTrspSoSeq();
	
	        		pre_eventResponse = pre_command.batchUSA404ComfirmedMessageSend(sOfc_cty_cd, sSo_seq);
	        		if((pre_eventResponse !=null) && (pre_eventResponse.size() > 0) ) {
	        			//Fax
	        			command.faxEdiSendConfirm(pre_eventResponse);
	        			//E-Mail
	        			command.emailEdiSendConfirm(pre_eventResponse);
	        		}
	        	}
        	}
            commit();

        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ee){
        	rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
    }
    
    
	/**
	 * Receving Data From TRS 처리 (Block Stowage Dest 정보) <br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void searchCanadaCustomsVesselManage(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		
		XmlObject xmlData = null;
		Collection models = null;	
		
		try {
			
			begin();			
			
        	xmlData = ((Esd075Hu01Event)e).getXmlObject();
        	CanadaCustomsVesselBC command = new CanadaCustomsVesselBCImpl();
        	
        	models = command.receiveCanadaCustomsVesselManage(xmlData);      	                
            command.ctrlCanadaCustomsVesselManage(models); 
			commit();			
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		
	}
	
	/**
	 * Receving Data From TRS 처리 (Block Stowage Dest 정보) <br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void searchCanadaCustomsManage(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		//EventResponse eventResponse = new Esd076Hu01EventResponse();
		XmlObject xmlData = null;
		Collection models = null;	
		
		try {
			
			begin();			
			
        	xmlData = ((Esd076Hu01Event)e).getXmlObject();
        	CanadaCustomsBC command = new CanadaCustomsBCImpl();
        	
        	models = command.receiveCanadaCustomsManage(xmlData);      	                
            command.ctrlCanadaCustomsManage(models);
            
			commit();			
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
	}
	
	
    /**
     * EDI 이벤트 처리( Eur S/O)  정보 <br>
     * EDI 에 대한 조회 이벤트 처리<br>
     * 
	 * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private void searchEurSoAckManage(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	int resultCount = 0;
    	try {
        	begin();

        	String str = ((EdiEns002Event)e).getString();
        	EurSoAckManageBC command = new EurSoAckManageBCImpl();
        	resultCount = command.receiveEurSoAckManage(str);  

            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ee){
        	rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
        
    }
	
    /**
     * EDI 이벤트 처리(Kor S/O)  정보 <br>
     * EDI 에 대한 조회 이벤트 처리<br>
     * 
	 * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private void searchKorSoAckManage(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	int resultCount = 0;
    	try {
        	begin();

        	String str = ((EdiEns003Event)e).getString();
        	KorSoAckManageBC command = new KorSoAckManageBCImpl();
        	resultCount = command.receiveKorSoAckManage(str);  
      
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ee){
        	rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
        
    }
    
    /**
     * EDI 이벤트 처리(USA TRUCK S/O)  정보 <br>
     * EDI 에 대한 조회 이벤트 처리<br>
     * 
	 * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private void searchUSATruckEdiWoAckManage(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	 
    	int resultCount = 0;
    	try {
        	begin();

        	String str = ((EdiEns004Event)e).getString();
        	USATruckEdiWoAckManageBC command = new USATruckEdiWoAckManageBCImpl();
        	resultCount = command.receiveUSATruckEdiWoAckManageList(str);  
        
            commit();
        } catch (EventException de) {
        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        } catch (Exception ee){
        	rollback();
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
        
    }
    
    /**
	 * Receving Data From TRS 처리 (INV EDI  정보관리)<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void search210EDIInvoiceMange(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체

		boolean isSuccessFlag = false;
		TrsTrspInvEdiVO model = null;
		
		try {
			
			begin();
			String str = ((Esd999Hu01Event)e).getString();
			log.debug("search210EDIInvoiceMange  :  " + str);
			Invoice210EdiManageBC command = new Invoice210EdiManageBCImpl();
			
        	model = command.receive210EDIData(str);
        	
        	isSuccessFlag = command.add210EDIManage(model);
            
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err after add210EDIManage Method >>>>>:" + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err after add210EDIManage Method >>>>>:" + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		

		try {
			if ( isSuccessFlag ){
				begin();
				this.verifyTruckInvoiceEdiImport(model);
				commit();
			}
		} catch (EventException de) {
			rollback();
			log.error("err after verifyTruckInvoiceEdiImport Method >>>>>:" + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err after verifyTruckInvoiceEdiImport Method >>>>>:" + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		
	}
 
	/**
	 * Invoice edi import verify<br>
	 * 
	 * @param model
	 * @throws EventException
	 */
	public void verifyTruckInvoiceEdiImport(TrsTrspInvEdiVO model) throws EventException {
		
		DBRowSet rowSO = null;
		DBRowSet rowWO = null;
	//	TrsTrspSvcOrdVO chd_model = null; //new TrsTrspSvcOrdVO();
		
//		boolean vndr_check   = false;
		boolean reject_check = false;     // TrsTrspSvcOrdVO SAVE 상태로 저장할 것인가. reject 상태로 저장할 것인가 CHECK.   reject_check: true --> reject ,  reject_check: false --> saved 
		boolean isSuccessful = false; 
		
		String eq_tpsz_cd = "";		
		String vndr_seq   = "";
		String inv_vndr   = "";
		String str_rmk    = "";
		
//		int dupCnt = 0;
		int cfmCnt = 0;
		
		Invoice210EdiBCImpl command  = null;
		InvoiceAuditBC	    command1 = null;
		
		try{
		//	begin();
			
			command 		= new Invoice210EdiBCImpl();
			command1 		= new InvoiceAuditBCImpl();
			
//			Invoice confirm  된 edi인지 체크 -->  이미 confirm 된 edi는 edi message set
//			CJO TRANSFORM IMPLEMENTATION
			cfmCnt = command.searchInvCfmSO(model);  
			if( cfmCnt > 0 ){
				model.setInvRmk("The same Invoice No exits");
				
			}else{
//				CJO TRANSFORM IMPLEMENTATION
				rowSO = command.searchNotInvSO(model);                       //*************메소드명 수정

				TrsTrspSvcOrdVO chd_model = new TrsTrspSvcOrdVO();
			//	chd_model.
			//	chd_model = (TrsTrspSvcOrdVO) rowSO.clone();
	
				//입력받은 EDI SO가 SO에 있는지 확인
				if((reject_check==false) && ( rowSO == null || rowSO.getRowCount() == 0)){
					str_rmk = JSPUtil.getNull(JSPUtil.getNull(model.getInvRmk()));
					if(str_rmk.length()>0){
						str_rmk = str_rmk+"/"+"SO No Not Exist Not Invoiced.";
					}else{
						str_rmk = "SO No Not Exist Not Invoiced.";
					}
					model.setInvRmk(str_rmk);
				} else {	
					if((reject_check==false) && rowSO.getRowCount() > 1){
						str_rmk = JSPUtil.getNull(model.getInvRmk());
						if(str_rmk.length()>0){
							str_rmk = str_rmk+"/"+"SO_NO DUP";
						}else{
							str_rmk = "SO_NO DUP";
						}
						model.setInvRmk(str_rmk);
					}else{
						while(rowSO.next()){
							//edi eq,eq_tpsz_cd 간의 check
//							9009610 TRANSFORM IMPLEMENTATION CONFIRM
							eq_tpsz_cd = command1.verifyEqNo(model.getEqNo());
							
							if( (reject_check==false) && ("".equals(eq_tpsz_cd) || eq_tpsz_cd == null) ){
								str_rmk = JSPUtil.getNull(model.getInvRmk());
								if(str_rmk.length()>0){
									str_rmk = str_rmk+"/"+"EQ No Not Exist";
								}else{
									str_rmk = "EQ No Not Exist";
								}
								model.setInvRmk(str_rmk);
								reject_check = true;
							}
							/*else{			
								if((reject_check==false) && !("".equals(model.getEqTpszCd()) || model.getEqTpszCd()==null)){
									if( !eq_tpsz_cd.equals(model.getEqTpszCd()) ){
										str_rmk = JSPUtil.getNull(model.getInvRmk());
										if(str_rmk.length()>0){
											str_rmk = str_rmk+"/"+"EQ TP/SZ Mismatch";
										}else{
											str_rmk = "EQ TP/SZ Mismatch";
										}
										model.setInvRmk(str_rmk);
										reject_check = true;
									}
								}
							}*/
							
//							SO BKG_NO와 EDI BKG_NO가 같은지 체
							if((reject_check==false) && !(model.getTrspWoOfcCtyCd().equals(rowSO.getString("TRSP_WO_OFC_CTY_CD")) && model.getTrspWoSeq().equals(rowSO.getString("TRSP_WO_SEQ")))){
								//if(!model.getBkgNo().equals(rowSO.getString("BKG_NO"))){
								str_rmk = JSPUtil.getNull(model.getInvRmk());
								if(str_rmk.length()>0){
									str_rmk = str_rmk+"/"+"SO WO_NO Diff ("+model.getTrspWoOfcCtyCd()+model.getTrspWoSeq()+").";
								}else{
									str_rmk = "SO WO_NO Diff ("+model.getTrspWoOfcCtyCd()+model.getTrspWoSeq()+").";
								}
								model.setInvRmk(str_rmk);
								reject_check = true;
								//}
							}
	
							
							//----------------------------------------------------->
							// SO EQ와 model.getEq_no()가 같은지 체크
							//------------------------------------------------------->
							//SO에 입력된 EQ가 없으면 EDI EQ를 SET  /  
							//EQ check
							
							if((reject_check==false) && ( "".equals(rowSO.getString("EQ_NO")) || rowSO.getString("EQ_NO")==null)){
								//SO BKG_NO와 EDI BKG_NO가 같은지 체
								/*
								if((reject_check==false) && (!"".equals(model.getBkgNo()) && !"".equals(rowSO.getString("BKG_NO")))){
									if(!model.getBkgNo().equals(rowSO.getString("BKG_NO"))){
										str_rmk = JSPUtil.getNull(model.getInvRmk());
										if(str_rmk.length()>0){
											str_rmk = str_rmk+"/"+"SO BKG_NO Diff ("+model.getBkgNo()+").";
										}else{
											str_rmk = "SO BKG_NO Diff ("+model.getBkgNo()+").";
										}
										model.setInvRmk(str_rmk);
										reject_check = true;
									}
								}
								*/
								//chd_model = (TrsTrspSvcOrdVO) rowSO.clone();
								chd_model.setInvNo(rowSO.getString("INV_NO"));
								chd_model.setVndrSeq(rowSO.getString("VNDR_SEQ"));
								//chd_model.setInv_vndr_seq(rowSO.getString("INV_VNDR_SEQ"));
								chd_model.setInvCurrCd(rowSO.getString("CURR_CD"));
								chd_model.setInvBzcAmt(rowSO.getString("INV_BZC_AMT"));
							//	chd_model.setInvRmk(rowSO.getString("INV_RMK"));
								chd_model.setTrspSoOfcCtyCd(rowSO.getString("TRSP_SO_OFC_CTY_CD"));
								chd_model.setTrspSoSeq(rowSO.getString("TRSP_SO_SEQ"));
								chd_model.setEqNo(rowSO.getString("EQ_NO"));
								chd_model.setCreOfcCd(rowSO.getString("CRE_OFC_CD"));
								chd_model.setCreUsrId(rowSO.getString("CRE_USR_ID"));
								
//								CJO TRANSFORM IMPLEMENTATION
								rowWO = command.searchInvoiceWO(model);
								if((reject_check==false) && rowWO.getRowCount() > 0){
								
									str_rmk = JSPUtil.getNull(model.getInvRmk());
									if(str_rmk.length()>0){
										str_rmk = str_rmk+"/"+"EQ_NO DUP.";
									}else{
										str_rmk = "EQ_NO DUP.";
									}
									model.setInvRmk(str_rmk);
									reject_check = true;
								}else{
									//SO BKG_NO와 EDI BKG_NO와 같은지 체크
									/*
									if((reject_check==false) && (!"".equals(model.getBkgNo()) && !"".equals(rowSO.getString("BKG_NO")))){
										if(!model.getBkgNo().equals(rowSO.getString("BKG_NO"))){
											str_rmk = JSPUtil.getNull(model.getInvRmk());
											if(str_rmk.length()>0){
												str_rmk = str_rmk+"/"+"SO BKG_NO Diff ("+model.getBkgNo()+").";
											}else{
												str_rmk = "SO BKG_NO Diff ("+model.getBkgNo()+").";
											}
											model.setInvRmk(str_rmk);
											reject_check = true;
										}
									}*/
									
	//								EQ 중복이 없을 경우 bkg 체크 후  chd_model에 입력    
									// CY/DOOR, Out bound, 운송형태 CNTR Door (Chasssis 제외)
									 //EQ_NO null check eq_no is null 만 해당
									if((reject_check==false) && ("Y".equals( rowSO.getString("TRSP_SO_TP_CD")) && "O".equals( rowSO.getString("TRSP_BND_CD")) && "DR".equals( rowSO.getString("TRSP_COST_DTL_MOD_CD"))) ){
										//bkg_no로 eq검색 
//										CJO TRANSFORM IMPLEMENTATION
										String bkgBkgCntr 	= command.searchInvoiceImportBkgBkgCntr(rowSO, model.getEqNo());
										if(bkgBkgCntr == null || !bkgBkgCntr.equals(model.getEqNo()) ){
											str_rmk = JSPUtil.getNull(model.getInvRmk());
											if(str_rmk.length()>0){
												str_rmk = str_rmk+"/"+"BKG CNTR Mismatch.";
											}else{
												str_rmk = "BKG CNTR Mismatch.";
											}
											model.setInvRmk(str_rmk);
											reject_check = true;
										}else{	
											if((reject_check==false) && rowSO.getString("EQ_TPSZ_CD") != null  &&! "".equals(rowSO.getString("EQ_TPSZ_CD")) ){
												//command.searchEqTpSz(bkgBkgCntr);
//												9009610 TRANSFORM IMPLEMENTATION CONFIRM
												eq_tpsz_cd = command1.verifyEqNo(bkgBkgCntr);
												if( rowSO.getString("EQ_TPSZ_CD").equals(eq_tpsz_cd) ){
													chd_model.setEqNo(model.getEqNo());
												}else{
													str_rmk = JSPUtil.getNull(model.getInvRmk());
													if(str_rmk.length()>0){
														str_rmk = str_rmk+"/"+"BKG EQ TP/SZ Mismatch.";
													}else{
														str_rmk = "BKG EQ TP/SZ Mismatch.";
													}
													model.setInvRmk(str_rmk);
													reject_check = true;
												}
											}
										}
									}else{
			//							empty 건에 대한 로직  inv_rmk에만 verify error 메세지    //EQ_NO null check eq_no is null 만 해당
										//if((reject_check==false) && ("M".equals( rowSO.getString("TRSP_SO_TP_CD")) && !"".equals( rowSO.getString("EQ_TPSZ_CD"))) ){
										if((reject_check==false) && (!"".equals( rowSO.getString("EQ_TPSZ_CD"))) ){
								//		if(!("Y".equals( rowSO.getString("TRSP_SO_TP_CD")) && "O".equals( rowSO.getString("TRSP_BND_CD")) && "DR".equals( rowSO.getString("TRSP_COST_DTL_MOD_CD"))) ){
											
											if(!"".equals(model.getEqNo())){
												if(!rowSO.getString("EQ_TPSZ_CD").equals(eq_tpsz_cd)){
													str_rmk = JSPUtil.getNull(model.getInvRmk());
													if(str_rmk.length()>0){
														str_rmk = str_rmk+"/"+"SO EQ TP/SZ Mismatch.";
													}else{
														str_rmk = "SO EQ TP/SZ Mismatch.";
													}
													model.setInvRmk(str_rmk);
													reject_check = true;
													
												}else{
												
													TrsTrspSvcOrdVO tmp_model = chd_model;
													tmp_model.setEqNo(model.getEqNo());
//													//9009610 TRANSFORM IMPLEMENTATION CONFIRM
													ArrayList dupList = command1.searchInvoiceImportDuplicateCheckByDate(tmp_model);
													String dupStr = getDuplicateCheckByDateString(dupList);
													if((reject_check==false) && dupStr.length()>0){
														if(chd_model.getInvRmk().length()>0){
															dupStr = chd_model.getInvRmk() + " / " + dupStr;
														}
														chd_model.setInvRmk(dupStr);
														reject_check = true;
													}
												}
											}
										}							
									}							
								}
							}else{
																
								chd_model.setInvNo(rowSO.getString("INV_NO"));
								chd_model.setVndrSeq(rowSO.getString("VNDR_SEQ"));
								//chd_model.setInv_vndr_seq(rowSO.getString("INV_VNDR_SEQ"));
								chd_model.setInvCurrCd(rowSO.getString("CURR_CD"));
								chd_model.setInvBzcAmt(rowSO.getString("INV_BZC_AMT"));
								chd_model.setTrspSoOfcCtyCd(rowSO.getString("TRSP_SO_OFC_CTY_CD"));
								chd_model.setTrspSoSeq(rowSO.getString("TRSP_SO_SEQ"));
								chd_model.setEqNo(rowSO.getString("EQ_NO"));
								chd_model.setCreOfcCd(rowSO.getString("CRE_OFC_CD"));
								chd_model.setCreUsrId(rowSO.getString("CRE_USR_ID"));
								
								if((reject_check==false) && (!rowSO.getString("EQ_NO").equals(model.getEqNo())) ){
									//so에 eq_no, eq_tpsz_cd가 있을경우 그대로 사용
									//chd_model = (TrsTrspSvcOrdVO) rowSO.clone();
									str_rmk = JSPUtil.getNull(model.getInvRmk());
									if(str_rmk.length()>0){
										str_rmk = str_rmk+"/"+"SO EQ_NO Diff("+model.getEqNo()+").";
									}else{
										str_rmk = "SO EQ_NO Diff("+model.getEqNo()+").";
									}
									model.setInvRmk(str_rmk);
			
									reject_check = true;
								}
							}  // --> if( "".equals(rowSO.getString("EQ_NO")) || rowSO.getString("EQ_NO")==null){   end
							
							/////////////////////////////////////////////////////////////////////////////////////////////////
							//*********************************************************************************
							//							CHECK 필요. W/O Status를 비교해야 하나 SO Status를 비교한다 
							//*********************************************************************************
							////////////////////////////////////////////////////////////////////////////////////////////////
							if((reject_check==false) && (!"I".equals(rowSO.getString("TRSP_SO_STS_CD"))) ){
								str_rmk = JSPUtil.getNull(model.getInvRmk());
								if(str_rmk.length()>0){
									str_rmk = str_rmk+"/"+"W/O Status ["+rowSO.getString("TRSP_SO_STS_CD")+"]";           //CHECK 필요. W/O Status를 비교해야 하나 SO Status를 비교한다 
								}else{
									str_rmk = "W/O Status ["+rowSO.getString("TRSP_SO_STS_CD")+"]";
								}
								model.setInvRmk(str_rmk);
								reject_check = true;
							}
							/*
							if( !model.getInv_curr_cd().equals(rowSO.getString("CURR_CD")) ){
								model.setInvRmk("Currency Mismatch");
								reject_check = true;
							}
							*/
							//invoice amt check
							if((reject_check==false) && (!"".equals(model.getInvAmt()) && model.getInvAmt() != null) ){
								if(validateNumberFormat(model.getInvAmt(),rowSO.getString("INV_BZC_AMT"))){
									BigDecimal modelInvBzcAmt = new BigDecimal(model.getInvAmt());
									BigDecimal rowSOInvBzcAmt = new BigDecimal(rowSO.getString("INV_BZC_AMT"));
									if(modelInvBzcAmt.compareTo(rowSOInvBzcAmt) != 0) {
										//model.setInvRmk("Amount Diff "+"("+modelInvBzcAmt.subtract(rowSOInvBzcAmt).toString()+")");
										str_rmk = JSPUtil.getNull(model.getInvRmk());
										if(str_rmk.length()>0){
											str_rmk = str_rmk+"/"+"Amount Diff "+"("+modelInvBzcAmt.subtract(rowSOInvBzcAmt).toString()+")";
										}else{
											str_rmk = "Amount Diff "+"("+modelInvBzcAmt.subtract(rowSOInvBzcAmt).toString()+")";
										}
										model.setInvRmk(str_rmk);
										model.setInvEdiRsltCd("D");
									}
								} else {
									BigDecimal modelInvBzcAmt = new BigDecimal("0");
									BigDecimal rowSOInvBzcAmt = new BigDecimal(rowSO.getString("INV_BZC_AMT"));
									if(modelInvBzcAmt.compareTo(rowSOInvBzcAmt) != 0 ){
										str_rmk = JSPUtil.getNull(model.getInvRmk());
										if(str_rmk.length()>0){
											str_rmk = str_rmk+"/"+"Amount Diff "+"("+modelInvBzcAmt.subtract(rowSOInvBzcAmt).toString()+")";
										}else{
											str_rmk = "Amount Diff "+"("+modelInvBzcAmt.subtract(rowSOInvBzcAmt).toString()+")";
										}
										model.setInvRmk(str_rmk);
										model.setInvEdiRsltCd("D");
									}
								}
							}else{
								if(!(reject_check==true) ){
									str_rmk = JSPUtil.getNull(model.getInvRmk());
									if(str_rmk.length()>0){
										str_rmk = str_rmk+"/"+"Invoice Amount Not Exist.";
									}else{
										str_rmk = "Invoice Amount Not Exist.";
									}
									model.setInvRmk(str_rmk);
									reject_check = true;
								}
							}
							
							if((reject_check==false) && (!"".equals(rowSO.getString("CURR_CD")) && ! "".equals(model.getInvCurrCd()) && !rowSO.getString("CURR_CD").equals(model.getInvCurrCd()))){
								str_rmk = JSPUtil.getNull(model.getInvRmk());
								if(str_rmk.length()>0){
									str_rmk = str_rmk+"/"+"Currency Diff ("+model.getInvCurrCd()+")";
								}else{
									str_rmk = "Currency Diff ("+model.getInvCurrCd()+")";
								}
								model.setInvRmk(str_rmk);
								//reject_check = true;
							}

							//SO VNDR_SEQ로 payment vendor를 찾아온다.
							//payment vendor가 없을때는 W/O VNDR_SEQ를 입력.
							vndr_seq = rowSO.getString("VNDR_SEQ");
							if( !"".equals(vndr_seq) && vndr_seq != null ){
//								CJO TRANSFORM IMPLEMENTATION
								inv_vndr = command.searchInvoiceVndr(vndr_seq);
								//edi payment vendor 정합성 체크   mdm_vndr에 있는 값인지 체크 
								if( inv_vndr == null || "".equals(inv_vndr) ){
									chd_model.setInvVndrSeq(rowSO.getString("VNDR_SEQ"));
								}else{
									chd_model.setInvVndrSeq(inv_vndr);
								}
							}
						}   //--> while end.
					
						chd_model.setInvNo(model.getInvNo());		
						chd_model.setInvRmk(JSPUtil.getNull(model.getInvRmk()));
						chd_model.setCreOfcCd("NYCRAG");
						chd_model.setCreUsrId("210_EDI_SYSTEM");
						log.error("inv_edi_rslt_cd >>>>>> " + model.getInvEdiRsltCd());
						if(!"".equals(chd_model.getTrspSoOfcCtyCd()) && !"".equals(chd_model.getTrspSoSeq()) && !"D".equals(model.getInvEdiRsltCd())){
							isSuccessful = command.saveInvoice210Edi(chd_model, reject_check, model.getInvAmt());
						}
					}
				}
			}
			//confirm 된 invoice 가 존재하는지 여부 체크   --> error.   No reject.
			
			if("".equals(model.getInvRmk()) || model.getInvRmk() == null ){
				model.setInvRmk("valid data.");
			}
			command.modifyTrsTrspInvEdi(model);
		
		//	commit();
			
		}catch (Exception de) {
		//	rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

	}

	/**
	 * R4J 예외처리를 위해 만든 고육지계 메소드
	 * 
	 * @param model
	 * @param svcModel
	 * @return
	 */
	private boolean validateNumberFormat(String str1, String str2){
		boolean returnFlag = true;
		try{
			 new BigDecimal(str1);
			 new BigDecimal(str2);
		}catch(NumberFormatException nfe){
			returnFlag = false;
		}
		return returnFlag;
	}	
	
	/**
	 * Duplicate 리스트를 String으로 변환한다.<br>
	 * @param ArrayList rsList 
	 * @return String
	 * @exception
	 */
	private String getDuplicateCheckByDateString(ArrayList rsList){
		
		StringBuffer returnStr = new StringBuffer();
		if(rsList != null && rsList.size()>0){
			for(int i=0; i<rsList.size(); i++){
				TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) rsList.get(i);
				
				if(i>0)	returnStr.append(" / ");
				returnStr.append(model.getTrspSoOfcCtyCd());
				returnStr.append(model.getTrspSoSeq());
				returnStr.append(" , ");
				returnStr.append(model.getCreDt());
				returnStr.append(" , ");
				returnStr.append(model.getFmNodCd());
				returnStr.append("-");
				returnStr.append(model.getToNodCd());
				returnStr.append(" , ");
				returnStr.append(model.getTrspCostDtlModCd());
				returnStr.append(" , ");
				returnStr.append(model.getTrspCrrModCd());
			}
		}
		return returnStr.toString();
	}
 
	/**
	 * Receving Data From TES 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse manageCustPreference(Event e) throws EventException {

		boolean isSuccessFlag = false;
		String isSuccess="false";
		GeneralEventResponse eventResponse = null;

		try {
			CustPreferenceBC command = new CustPreferenceBCImpl();
			
			
	    	log.debug("\n --------------------------------------------------------- " +
	  		          "\n           Start EAI - CustPreference                      " +
	  			      "\n --------------------------------------------------------- ");

			begin();

			XmlObject xmlObject = ((CustPreferenceEvent) e).getXmlObject();

			Collection models = command.receiveXML(xmlObject);

			isSuccessFlag = command.createPRDTB(models);
			
			if(isSuccessFlag) isSuccess="SUCCESS";
			else isSuccess="FAILE";
			eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(isSuccess);
			
			//eventResponse= new CustPreferenceEventResponse(isSuccessFlag);
			
			log.debug(" (createPRDCUSTPRF) isSucessFlag : " + isSuccess);

			commit();

	    	log.debug("\n --------------------------------------------------------- " +
				      "\n           End  EAI - CustPreference                       " +
				      "\n --------------------------------------------------------- ");
		}catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	


	/**
	 * Receving Data From TRS 처리 (crm referency party 정보) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCustRefPartyManage(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = null;
		XmlObject xmlData = null;
		Collection models = null;	
		
		try {			
			begin();			
			
        	xmlData = ((Esd078Hu01Event)e).getXmlObject();
        	CustRefPartyManageBC command = new CustRefPartyManageBCImpl();
        	
        	models = command.receiveCustRefPartyManage(xmlData);      	                
            command.ctrlCustRefPartyManage(models);
            //((ESD078_HU01EventResponse)eventResponse).setXmlObject(xmlData);
            
			commit();						
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ee){
			log.error("err " + ee.toString(), ee);
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * @param arraylist
	 */
//	private void setEmlresponse_array(ArrayList emlresponse_array) {
//		this.emlresponse_array = emlresponse_array;
//	}
	
	/**
	 * @return response ArrayList
	 */
	public ArrayList getEmlresponse_array() {
		return emlresponseArray;
	}
}
