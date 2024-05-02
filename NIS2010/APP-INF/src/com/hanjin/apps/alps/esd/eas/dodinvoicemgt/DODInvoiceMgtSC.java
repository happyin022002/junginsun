/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DODInvoiceMgtSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013-09-09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013-09-09 KIM HYUN HWA
* 1.0 최초 생성
* [CHM-201326710]Drop-off charge invoice 신규 기능 개발
* 2016-03-28 [CHM-201640540]한국지역 Drop-Off Charge 시스템 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt;
  

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic.DODInvoiceMgtBC;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.basic.DODInvoiceMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0100Event;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0101Event;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0102Event;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0103Event;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0104Event;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event.EsdEas0106Event;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionSumVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODCollectionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODTariffVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DodArIfMnVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasAttentionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrCntcPntVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasPayrInfoVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.PayerInformationVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchBKGCntrListVO;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * DODInvoiceMgtSC<br>
 * @author 
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class DODInvoiceMgtSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS 업무 시나리오 선행작업<br>
     * DODInvoiceMgtSC 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
        	log.info(account.getUsr_id());
            log.error("DODInvoiceMgtSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * EAS 업무 시나리오 마감작업<br>
     * DodInvoiceMgtSC 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("DODInvoiceMgtSC 종료");
    }

	/**
	 * perform<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */    
	public EventResponse perform(Event e) throws EventException {

        EventResponse eventResponse = null;
       
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdEas0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBKGCntrList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAttention(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPayerInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = createDODInvoice(e);
//				eventResponse = transmitEASEDI(e, "ESD_EAS_0100");
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0101Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	            eventResponse = sendKORDodInvoiceByFaxEmail(e);
	        }
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0102Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchDODInvoiceList(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	            eventResponse = createARInvoiceData(e);
//	            eventResponse = transmitEASEDI(e, "ESD_EAS_0102");
	        }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
	        	log.debug("\n cancelDODInvoice======================================");
	        	eventResponse = cancelDODInvoice(e);
	            
	        }
	    }else if ( e.getEventName().equalsIgnoreCase("EsdEas0103Event")) {
	        	// Payer Code별로 Payer정보를 조회한다.
	        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
	                eventResponse = searchPayerInformation(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
	                eventResponse = searchPayerName(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ) {
	                eventResponse = searchPayerAddress(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03) ) {
	                eventResponse = searchPayerContactPointName(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04) ) {
	                eventResponse = searchPayerPhoneNo(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05) ) {
	                eventResponse = searchPayerFaxNo(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06) ) {
	                eventResponse = searchPayerEmail(e);
	        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI) ) {
	                eventResponse = managePayerInformation(e);
	            }
	    }else if ( e.getEventName().equalsIgnoreCase("EsdEas0104Event")) {
	        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
	                eventResponse = searchDODInvoiceCollectionList(e);
	        	}
	    } else if ( e.getEventName().equalsIgnoreCase("EsdEas0106Event")) {
          	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
                eventResponse = searchDODTariffList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01) ) {
                eventResponse = searchDODTariffEffDtList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02) ) {
                eventResponse = verifyDODTariffTpSz(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI) ) {
                eventResponse = manageDODTariff(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03) ) {
                eventResponse = searchDODTariffDupCheck(e);
        	}   
        } 
		return eventResponse;
	}

	/**
	 * [ESD_EAS_0104]DOD Invoice CollectionList - 조회 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchDODInvoiceCollectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0104Event event = (EsdEas0104Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();

		try{
			List<DODCollectionVO> list = command.searchDODInvoiceCollectionList(event.getDODCollectionParmVO());
			eventResponse.setRsVoList(list);
			List<DODCollectionSumVO> sumList = command.searchDODInvoiceCollectionSummary(event.getDODCollectionParmVO());
			
			DODCollectionSumVO dodCollectionSumVo = new DODCollectionSumVO();
			if(sumList.size() > 0 ){
				dodCollectionSumVo =(DODCollectionSumVO) sumList.get(0);
				eventResponse.setETCData("a2",dodCollectionSumVo.getA2());
				eventResponse.setETCData("a4",dodCollectionSumVo.getA4());
				eventResponse.setETCData("d2",dodCollectionSumVo.getD2());
				eventResponse.setETCData("d4",dodCollectionSumVo.getD4());
				eventResponse.setETCData("d5",dodCollectionSumVo.getD5());
				eventResponse.setETCData("d7",dodCollectionSumVo.getD7());
				eventResponse.setETCData("d8",dodCollectionSumVo.getD8());
				eventResponse.setETCData("d9",dodCollectionSumVo.getD9());
				eventResponse.setETCData("dw",dodCollectionSumVo.getDw());
				eventResponse.setETCData("dx",dodCollectionSumVo.getDx());
				eventResponse.setETCData("f2",dodCollectionSumVo.getF2());
				eventResponse.setETCData("f4",dodCollectionSumVo.getF4());
				eventResponse.setETCData("f5",dodCollectionSumVo.getF5());
				eventResponse.setETCData("o2",dodCollectionSumVo.getO2());
				eventResponse.setETCData("o4",dodCollectionSumVo.getO4());
				eventResponse.setETCData("o5",dodCollectionSumVo.getO5());
				eventResponse.setETCData("p2",dodCollectionSumVo.getP2());
				eventResponse.setETCData("p4",dodCollectionSumVo.getP4());
				eventResponse.setETCData("r2",dodCollectionSumVo.getR2());
				eventResponse.setETCData("r4",dodCollectionSumVo.getR4());
				eventResponse.setETCData("r5",dodCollectionSumVo.getR5());
				eventResponse.setETCData("s2",dodCollectionSumVo.getS2());
				eventResponse.setETCData("s4",dodCollectionSumVo.getS4());
				eventResponse.setETCData("t2",dodCollectionSumVo.getT2());
				eventResponse.setETCData("t4",dodCollectionSumVo.getT4());
				eventResponse.setETCData("total20",dodCollectionSumVo.getTotal20());
				eventResponse.setETCData("total40",dodCollectionSumVo.getTotal40());
				eventResponse.setETCData("sum_inv_amt",dodCollectionSumVo.getSumInvAmt());
				eventResponse.setETCData("sum_bil_amt",dodCollectionSumVo.getSumBilAmt());
				eventResponse.setETCData("sum_tax_amt",dodCollectionSumVo.getSumTaxAmt());
				eventResponse.setETCData("tot_amt",dodCollectionSumVo.getTotAmt());
			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * [ESD_EAS_0100] DOD Invoice Issue - Retrieve <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBKGCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0100Event event = (EsdEas0100Event)e;
		SearchBKGCntrListVO searchBKGCntrListVO = new SearchBKGCntrListVO();
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();

		try{
			//List<SearchBKGCntrListVO> list = command.searchBKGCntrList(event.getInBlNo(), event.getSessionOfcCd() );
			List<SearchBKGCntrListVO> list = command.searchBKGCntrList(event.getInBlNo(),  event.getTrfOfc());
			  if(list.size() > 0 ){
				String pol_conti = list.get(0).getPolContiCd();
				//List<DODTariffVO> tarifflist = command.searchDODTariffList(event.getSessionOfcCd(), pol_conti, "" );
				List<DODTariffVO> tarifflist = command.searchDODTariffList(event.getTrfOfc(), pol_conti, "" );
				searchBKGCntrListVO.setListDODTariffVO(tarifflist);
				eventResponse.setRsVoList(list);
				eventResponse.setRsVoList(searchBKGCntrListVO.getListDODTariffVO());
				
				//List<String> efflist = command.searchDODTariffEffDtList(event.getSessionOfcCd(), pol_conti);
				List<String> efflist = command.searchDODTariffEffDtList(event.getTrfOfc(), pol_conti);
				StringBuffer codes = new StringBuffer();
				
				if (efflist != null && efflist.size() > 0) {
					for (int i = 0 ; i < efflist.size(); i++) {
						codes.append(efflist.get(i));
						if (i < efflist.size() - 1) codes.append("|");
					}
				}
				eventResponse.setETCData("TRF_EFFDT", codes.toString());
			  }	
			}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
    /**
     * [ESD_EAS_0100]Payer정보를 조회한다. <br>
     * 
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0100Event event = (EsdEas0100Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl(); 
		try{
			DODPayrInfoVO dODPayrInfoVO = command.searchPayerInfo(event.getInPayerCd(), event.getInCustRgstNo()); 
            eventResponse.setETCData(dODPayrInfoVO.getColumnValues());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }	
    
	/**
	 * [ESD_EAS_0100]DOD Invoice Issue - ISSUE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createDODInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0100Event event = (EsdEas0100Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
		DODInvoiceMainVO  dodInvoiceMainVO = null;
		DODInvoiceDetailVO[] dodInvoiceDetailVOs = null;		
		
		try{
			String dodInvNo = command.searchEasDodInvSeq(account.getOfc_cd());

			begin();
			command.createDODInvoice(event.getDodInvoiceMainVO(), event.getDodInvoiceDetailVOs(), dodInvNo, account);
			
			commit();
			
			begin();
			
			dodInvoiceMainVO = command.searchDodInvoiceMain(dodInvNo);
			dodInvoiceDetailVOs	 = command.searchDodInvoiceDetail(dodInvNo);			
			
			String key = command.startBackEndJob(account, dodInvoiceMainVO, dodInvoiceDetailVOs, "ESD_EAS_0100");
			
			log.info("\n easEDI SENT DODInv:"+ dodInvNo);
	        
			commit();
			eventResponse.setETCData("dodInvNo", dodInvNo);
			eventResponse.setETCData("KEY", key);
			eventResponse.setUserMessage(new ErrorHandler("EAS00079").getUserMessage());
			


        } catch (EventException ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("error:"+ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Date"}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	
//	/**ESD_EAS_0100: transmit EDI
//	 * @param Event e, String pgmNo
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	private EventResponse transmitEASEDI(Event e, String pgmNo) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		DODInvoiceMgtBC command = null;
//		log.debug("\n transmitEASEDI start=============================================");
//		try
//		{
//			String dodInvNo = command.searchEasDodInvSeq(account.getOfc_cd());	
//			begin();
//		
//		// EAS Flat File 생성)
//		EsdEas0100Event event =(EsdEas0100Event) e;
//
//		// transmit
//		command = new DODInvoiceMgtBCImpl();
//
//		//String key = command.startBackEndJob(account, event.getSearchInvoiceStatusVO(), "ESD_EAS_0100");
//		String key = command.startBackEndJob(account, event.getDodInvoiceMainVO(), event.getDodInvoiceDetailVOs(), pgmNo);
//        
//		eventResponse.setETCData("KEY", key);
//		eventResponse.setUserMessage(new ErrorHandler("EAS00079").getUserMessage());
//		
//		commit();
//		eventResponse.setETCData("dodInvNo", dodInvNo);
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		}catch(Exception ex){
//			rollback();
//			throw new EventException(new ErrorHandler("TPB00080").getMessage(), ex);
//		}
//		log.debug("\n transmitEASEDI end=============================================");
//
//		return eventResponse;	
//		
//	}

	
	/**
	 * [ESD_EAS_0102] : 조회<br>
	 * DOD Invoice List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDODInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0102Event event = (EsdEas0102Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
		
		try{
			List<DODInvoiceListVO> list = command.searchDODInvoiceList(event.getSearchDODInvoiceListInputVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * [ESD_EAS_0102] : Cancel<br>
	 * DOD Invoice 를 Cancel 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelDODInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0102Event event = (EsdEas0102Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
    	GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl();
		DODInvoiceListVO[] cancelInvVOs = event.getDODInvoiceListVOs();
		
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();

		int total_cnt = cancelInvVOs.length;
		int success_cnt = 0;
		int fail_cnt = 0;
		String msg = "";
		StringBuffer sb_ar_err_msg = new StringBuffer();
		
		String key = "";
		
		DODInvoiceMainVO  dodInvoiceMainVO = null;
		DODInvoiceDetailVO[] dodInvoiceDetailVOs = null;
log.debug("\n cancelDODInvoice [1]======================================");		
		
		try{
			
			StringBuffer sb_err_cr = new StringBuffer(); 
			StringBuffer sb_err_inv = new StringBuffer(); 
			
			for (int i = 0; i < cancelInvVOs.length; i++) {
				String arIfFlg = cancelInvVOs[i].getArIfFlg();
log.debug("\n cancelDODInvoice [2]======================================");		
				
				// A/R interface 된 데이터는  Credit note 를 생성 함.
				if ("Y".equals(arIfFlg)){
				   String newDodInvNo = command.searchEasDodInvSeq(account.getOfc_cd());
				   String dodInvNo = cancelInvVOs[i].getDodInvNo();
				   String bkgNo  = cancelInvVOs[i].getBkgNo();
				   String ar_if_no	= "";
			    // credit note 생성.
				     begin();
				   command.createCreditNoteDODInvoice(dodInvNo, newDodInvNo, account);
log.debug("\n cancelDODInvoice [3]======================================");				
			    // credit note A/R Interface	
    			   genIfVOs	= new ArrayList<ARInterfaceCreationVO>();
    		       arInterfaceCreationVO = command.searchARInterfaceInvoice(account, newDodInvNo, bkgNo);
log.debug("\n cancelDODInvoice [4]======================================");    			
    			   if(arInterfaceCreationVO.getInvArIfChgVOs() == null) {
	            	  log.debug(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());
	            	  fail_cnt++;
	            	  sb_err_cr.append(dodInvNo).append(",");
	            	  rollback();
	            	  cancelInvVOs[i].setIbflag("R");
	               }else{
    			
    	              genIfVOs.add(arInterfaceCreationVO); 
    	              log.debug("\n AR_IF =======getInvSrcNo===="+arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo());
    	            
    	            // AR INTERFACE CALL
    	           
    	            	rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
    	            	ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
    	            // AR INTERFACE END
log.debug("\n cancelDODInvoice [5]======================================");    	            
    	            if(ar_if_no == null || ar_if_no.equals("")) {
    	            	log.debug("\n AR_IF_NO NULL===============");
log.debug("\n cancelDODInvoice [6]======================================");    	            	
    	            	fail_cnt++;
    	            	sb_err_cr.append(dodInvNo).append(",");
		            	rollback();
		            	cancelInvVOs[i].setIbflag("R");
    	            }else{
log.debug("\n cancelDODInvoice [7]======================================");    	            	
    	            	String ar_if_no_arr[] =	ar_if_no.split("::");
    	            	if(ar_if_no_arr[0].equals("S")){
    	            		
	            			// EAS AR I/F Cancel EDI Transmit : KLNET 에서  입금표 발행 취소는  없다고 했음!! 20140514
//	            			dodInvoiceMainVO = command.searchDodInvoiceMain(dodInvNo);
//	            			dodInvoiceDetailVOs	 = command.searchDodInvoiceDetail(dodInvNo);
//						log.debug("\n cancelDODInvoice [8] ESD_EAS_0102_1 ======================================");       	            			
////	            			key = command.startBackEndJob(account, dodInvoiceMainVO, dodInvoiceDetailVOs, "ESD_EAS_0102_1");
//						log.debug("\n cancelDODInvoice [9]======================================");   
    	            		
	    	            	success_cnt++;
	        	            // EAS TABLE UPDATE
        	        		command.modifyARInterfaceInfo(account, ar_if_no_arr[1], newDodInvNo);
        	        	 commit();  
        	        	 cancelInvVOs[i].setCnRefInvNo(newDodInvNo);
        	        	
			        		// ERP로직 분리
			        		begin();
			        			commandAR.interfaceARInvoiceToERPAR(ar_if_no_arr[1]);

			        		commit();
			        		
    	            	}else{
log.debug("\n cancelDODInvoice [10]======================================");    	            		
		    	            commit();
		    	            
        	            	fail_cnt++;
        	            	sb_ar_err_msg.append(ar_if_no_arr[1]).append("|");
    		            	log.debug("\n AR_IF_ERROR MSG===============>["+newDodInvNo+"]"+ar_if_no_arr[1]);
    		            	sb_err_inv.append(newDodInvNo).append(",");
    		            	cancelInvVOs[i].setIbflag("R");
    	            	}
    	            }
        		}	

				}
			}
   //   Cancel 건 처리			
					
				begin();

				
				for (int i = 0; i < cancelInvVOs.length; i++) {
log.debug("\n cancelDODInvoice [11] i:"+i+"======================================"); 	
					String dodInvNo = cancelInvVOs[i].getDodInvNo();				
				
	    			// EAS AR I/F Cancel EDI Transmit
	    			dodInvoiceMainVO = command.searchDodInvoiceMain(dodInvNo);
	    			dodInvoiceDetailVOs	 = command.searchDodInvoiceDetail(dodInvNo);
log.debug("\n cancelDODInvoice [12] ESD_EAS_0100_1 ======================================");		    			
	    			key = command.startBackEndJob(account, dodInvoiceMainVO, dodInvoiceDetailVOs, "ESD_EAS_0100_1");
	    			
				}				
				
log.debug("\n cancelDODInvoice [13]======================================");  				
				command.cancelDODInvoice(cancelInvVOs, account);

					
				commit();
		
        msg = "Total Cancel Invoice Q'ty :"+ total_cnt+" Credit note Success :"+success_cnt +  " Credit note Failed :"+fail_cnt ;
        if(fail_cnt > 0) {
       	msg = msg+"(Credit note Fail ==> Invoice No:["+sb_err_cr.toString()+"]"+" AR_IF_ERROR :["+sb_err_inv.toString()+" : "+sb_ar_err_msg.toString()+"]";
       }

  	   eventResponse.setUserMessage(msg);
  	   
		eventResponse.setETCData("KEY", key);
		eventResponse.setUserMessage(new ErrorHandler("EAS00079").getUserMessage());
		
				
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
    /**
     * ESD_EAS_0103 Payer정보를 조회한다.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerInformation(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			PayerInformationVO payrInfomationVO = command.searchPayerInformation(((EsdEas0103Event)e).getPayerInfoParamVO());
			List<EasPayrCntcPntVO> list = payrInfomationVO.getEasPayrCntcPntVOs();
			EasPayrInfoVO dmtPayrInfoVO = payrInfomationVO.getEasPayrInfoVO();
			
            eventResponse.setRsVoList(list);
            eventResponse.setETCData(dmtPayrInfoVO.getColumnValues());
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }

    /**
     * Payer Name 정보를 조회한다.<br>
     * 
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerName(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			List<EasPayrInfoVO> list = command.searchPayerName(((EsdEas0103Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = NAME 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getPayrNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			log.debug("\n payer_name list--->"+codes.toString());
			eventResponse.setETCData("PAYER_NAME", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Address 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerAddress(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			List<EasPayrInfoVO> list = command.searchPayerAddress(((EsdEas0103Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|").append(" ");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = ADDR 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getCustAddr()).append("=").append(" ");
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			log.debug("\n payer_addr list--->"+codes.toString());
			eventResponse.setETCData("PAYER_ADDR", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerContactPointName(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			List<EasPayrInfoVO> list = command.searchPayerContactPointName(((EsdEas0103Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = ContractPointName 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getCntcPntNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_CNTC_PNT_NM", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Phone No 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerPhoneNo(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			List<EasPayrInfoVO> list = command.searchPayerPhoneNo(((EsdEas0103Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = PhoneNo 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getCntcPntPhnNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_PHN_NO", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Fax No 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerFaxNo(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			List<EasPayrInfoVO> list = command.searchPayerFaxNo(((EsdEas0103Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = FAX NO 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getCntcPntFaxNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_FAX_NO", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Email 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerEmail(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
		try{
			List<EasPayrInfoVO> list = command.searchPayerEmail(((EsdEas0103Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = Email 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getN1stEml());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_EMAIL", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
    
    /**
     * Payer Info 정보를 저장한다.<BR>
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse managePayerInformation(Event e) throws EventException {
    	DODInvoiceMgtBC command 	= new DODInvoiceMgtBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        PayerInformationVO payerInformationVO 	= new PayerInformationVO();
        Map<String,String> etcData 				= new HashMap<String,String>();
        
        try{
        	payerInformationVO.setEasPayrInfoVO(((EsdEas0103Event)e).getEasPayrInfoVO());
        	payerInformationVO.setEasPayrCntcPntVOs(((EsdEas0103Event)e).getEasPayrCntcPntVOs());
        	
            begin();
            command.managePayerInformation(payerInformationVO, account);
            etcData.put("SUCCESS_YN", "Y");
            eventResponse.setETCData(etcData);
            commit();

        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
        	rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    	
    }
    
	/**
	 * ESD_EAS_0100 : Payer Attention <br>
	 * Attention 정보를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAttention(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0100Event event = (EsdEas0100Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
		
		try {
			List<EasAttentionVO> list = command.searchAttention(event.getEasAttentionVO());
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				for (int i = 0 ; i < list.size(); i++) {
					codes.append(list.get(i).getCntcPntNm())
						.append("=").append(StringUtils.defaultString(list.get(i).getCntcPntPhnNo()))
						.append("=").append(StringUtils.defaultString(list.get(i).getCntcPntFaxNo()))
						.append("=").append(StringUtils.defaultString(list.get(i).getCntcPntEml()))
						.append("=").append(list.get(i).getSheetFlg())
						.append("=").append(list.get(i).getCustCntCd()).append("^").append(list.get(i).getCustCntcPntSeq()).append("^").append(list.get(i).getCustSeq());
					
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			eventResponse.setETCData("ATTENTION", codes.toString());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	  /**
	 * [ESD_EAS_0102] : [ARIF] <br>
	 * [ARInterface]을 [create]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
     */

	private EventResponse createARInvoiceData(Event e) throws EventException {
    	DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
    	GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        EsdEas0102Event event = (EsdEas0102Event)e;
        
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
		
		
		Map<String,String> etcData = new HashMap<String,String>();
		String ar_if_no 	= "";
		String invoice_no  	= "";
		String bkg_no  	= "";
		String key = "";
		
		DODInvoiceMainVO  dodInvoiceMainVO = null;
		DODInvoiceDetailVO[] dodInvoiceDetailVOs = null;

		DODInvoiceListVO[] dodInvoiceListVOs = null;
		

		int total_cnt = 0;
		int success_cnt = 0;
		int fail_cnt = 0;
		String msg = "";
		StringBuffer sb_ar_err_msg = new StringBuffer();
		
		int already_cnt = 0;
		StringBuffer already_msg = new StringBuffer();
		log.debug("\n =======DOD A/R Interface start===>");
        try{

            dodInvoiceListVOs =  (event.getDODInvoiceListVOs());

    		total_cnt = dodInvoiceListVOs.length;

    		StringBuffer sb_err_inv = new StringBuffer(); 
    		
        		for(int i = 0 ; i < dodInvoiceListVOs.length ; i++) {
        			invoice_no = dodInvoiceListVOs[i].getDodInvNo();
        			bkg_no = dodInvoiceListVOs[i].getBkgNo();
        			genIfVOs	= new ArrayList<ARInterfaceCreationVO>();
        			
        			arInterfaceCreationVO = command.searchARInterfaceInvoice(account, invoice_no, bkg_no);
        			
        			
        			if(arInterfaceCreationVO.getInvArIfChgVOs() == null) {
    	            	log.debug(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());
    	            	fail_cnt++;
		            	sb_err_inv.append(invoice_no).append(",");
    	            }else{
        			
	    	            genIfVOs.add(arInterfaceCreationVO);
	    	            log.debug("\n AR_IF =======getInvSrcNo===="+arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo());
	    	            
	    	            // A/R I/F 여부 확인 로직
	    	            //where (AR_IF_FLG = 'N' -- A/R I/F 여부
	    	            //       or DOD_INV_STS_CD = 'X') -- Invoice Status code
	    	            DodArIfMnVO dodArIfMnVO = command.checkAlreadyArIf(account, invoice_no, bkg_no);
	    	            if(dodArIfMnVO != null && 
	    	            		( "N".equals(dodArIfMnVO.getArIfFlg()) ||"X".equals(dodArIfMnVO.getDodInvStsCd()))	) {
	    	            //------------------------------------------------------------------------------------------	
	    	            	// AR INTERFACE CALL
	    	            	begin();
	    	            	rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
	    	            	ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
	    	            	// AR INTERFACE END
	    	            	
	    	            	if(ar_if_no == null || ar_if_no.equals("")) {
	    	            		log.debug("\n AR_IF_NO NULL===============");
	    	            		fail_cnt++;
	    	            		sb_err_inv.append(invoice_no).append(",");
	    	            		rollback();
	    	            	}else{
	    	            		String ar_if_no_arr[] =	ar_if_no.split("::");
	    	            		if(ar_if_no_arr[0].equals("S")){
	    	            			success_cnt++;
	    	            			// EAS TABLE UPDATE
	    	            			command.modifyARInterfaceInfo(account, ar_if_no_arr[1], invoice_no);
	    	            			commit();    
	    	            			
	    	            			// ERP로직 분리
	    	            			begin();
	    	            			commandAR.interfaceARInvoiceToERPAR(ar_if_no_arr[1]);

	    	            			// EAS AR I/F Cancel EDI Transmit
	    	            			dodInvoiceMainVO = command.searchDodInvoiceMain(invoice_no);
	    	            			dodInvoiceDetailVOs	 = command.searchDodInvoiceDetail(invoice_no);
	    	            			
	    	            			key = command.startBackEndJob(account, dodInvoiceMainVO, dodInvoiceDetailVOs, "ESD_EAS_0102");
	    	            			
	    	            			commit();			    	            
	    	            		}else{
	    	            			commit();
	    	            			
	    	            			fail_cnt++;
	    	            			sb_ar_err_msg.append(ar_if_no_arr[1]).append("|");
	    	            			log.debug("\n AR_IF_ERROR MSG===============>["+invoice_no+"]"+ar_if_no_arr[1]);
	    	            			sb_err_inv.append(invoice_no).append(",");
	    	            		}
	    	            	}
	    	            } //A/R I/F 여부 확인 로직 e------------------------------------------------------------------------------------------
	    	            else {
	    	            	//이미 A/R I/F 된 건이므로 Message("Already Interfaced!") 뿌려주고 재 조회 함.
	    	            	already_cnt++;
	    	            	already_msg.append(invoice_no).append(",");
	    	            }
	        		}
        		}
        		
	            etcData.put("SUCCESS_YN", "Y");
	            
	            msg = "Total Invoice Q'ty :"+ total_cnt+" A/R IF Success :"+success_cnt +  " A/R IF Failed :"+fail_cnt ;
	             if(fail_cnt > 0) {
	            	msg = msg+"(Fail ==> Invoice No:["+sb_err_inv.toString()+"]"+"["+sb_ar_err_msg.toString()+"]";
	            }
	             if(already_cnt > 0) {
		            	msg = msg+"(Already Interfaced ==> Invoice No:["+already_msg.toString()+"]";
		            }

           	eventResponse.setUserMessage(msg);
         	eventResponse.setETCData(etcData);
         	
			eventResponse.setETCData("KEY", key);
			eventResponse.setUserMessage(new ErrorHandler("EAS00079").getUserMessage());	         	
            
        } catch(EventException ex) {
            etcData.put("SUCCESS_YN", "N");
            log.error("EventException " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex){
            etcData.put("SUCCESS_YN", "N");
            log.error("Exception " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;
    } 
	
	/**
	 * [ESD_EAS_0101] : FAX Send, E-mail Send<br>
	 * DOD Invoice  Email/Fax 전송기능.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendKORDodInvoiceByFaxEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0101Event event = (EsdEas0101Event) e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();

		String sendNo = "";
		try {
			begin();

			sendNo = command.sendKORDodInvoiceByFaxEmail(event.getDODInvEmailFaxVO(), account);

			log.error("sendKORDodInvoiceByFaxEmail sendNo================"+sendNo);
			
			commit();

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse; 
	}	

	/**
	 * (KOR) DOD Tariff Creation list를 조회한다
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDODTariffList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0106Event event = (EsdEas0106Event)e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
		
		try{
			List<DODTariffVO> list = command.searchDODTariffList(event.getSessionOfcCd(), event.getSelPolContiCd(),event.getSelEffDt());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
    }
    
    /**
     * (KOR) DOD Tariff Creation Effective Date list를 조회한다
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDODTariffEffDtList(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0106Event event = (EsdEas0106Event)e;
    	DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
    	
        try {

        	List<String> efflist = command.searchDODTariffEffDtList(event.getSessionOfcCd(), event.getSelPolContiCd());
			
			StringBuffer codes = new StringBuffer();
			if (efflist != null && efflist.size() > 0) {
				for (int i = 0 ; i < efflist.size(); i++) {
					codes.append(efflist.get(i));
					if (i < efflist.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("TRF_EFFDT", codes.toString());
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	
	/**
	 * (KOR) DOD Tariff Creation 정보를  등록, 수정, 삭제한다.<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDODTariff(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdEas0106Event event = (EsdEas0106Event) e;
		DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
		
		try {
			
			begin();
			
			command.manageDODTariff(event.getDODTariffVOs());

			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	

    /**
     * (KOR) DOD Tariff Creation 입력된 tpsz_cd의 MDM내 존재여부 확인
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse verifyDODTariffTpSz(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0106Event event = (EsdEas0106Event)e;
    	DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
    	
        try {

        	String tpszCnt = command.verifyDODTariffTpSz(event.getSelCntrTpszCd());
			
			eventResponse.setETCData("TPSZ_CNT", tpszCnt);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * (Korea) DOD Tariff Dup Chek 정보를 조회한다.<br>
	 * @param e 
	 * @return
	 * @throws EventException
	 */
    private EventResponse searchDODTariffDupCheck(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0106Event event = (EsdEas0106Event)e;
    	DODInvoiceMgtBC command = new DODInvoiceMgtBCImpl();
    	
        try {

        	String dupCnt = command.searchDODTariffDupCheck(event.getDODTariffVO());
			
			eventResponse.setETCData("DUP_CNT", dupCnt);
            
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
 }
	