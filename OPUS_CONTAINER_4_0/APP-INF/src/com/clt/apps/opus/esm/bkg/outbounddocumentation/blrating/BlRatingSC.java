/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingSC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.common.WordWarp;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg007908Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0264Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0265Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0269Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0270Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0704Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0739Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0771Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0945Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0961Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1043Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1076Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1077Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1084Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.DocLocVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaBkgComIfVO;

/**
 * OPUS-BlRating Business Logic ServiceCommand 
 * Handling business transaction for OPUS-BlRating
 * 
 * @author
 * @see
 * @since J2EE 1.6
 */

public class BlRatingSC extends ServiceCommandSupport {

    // Login User Information
    private SignOnUserAccount account = null;
	
    /**
	 * BlRating system preceding process for biz scenario<br>
	 * BlRating system Creating related object by calling work scenario<br>
	 */
    public void doStart() {
    	log.debug("BlRatingSC 시작");
        try {
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
 
    /**
	 * BlRating system Handling for the end of working scenario<br>
	 * ESM_BKG_0945 system Clearing object by the end of work scenario<br>
	 */
    public void doEnd() {
    	log.debug("BlRatingSC 종료");
    }

	/**
	 * Handling working scenario of each event<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
//        log.debug("::CALL:: BlRatingSC : " + e.getEventName()+"::"+e.getFormCommand());

        if(e.getEventName().equalsIgnoreCase("EsmBkg0961Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPayerCode(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0270Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchScNote(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0265Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchChargeRemark(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageChargeRemark(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0264Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchQtyForRate(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0269Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchScInform(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchScInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageScInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
            	eventResponse = searchCmdt(e); 
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
            	eventResponse = searchScSurcharge(e); 
            }
/*            
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0700Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {

            }
*/
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0771Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCoveredBl(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCoveredBl(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0739Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRfaInform(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRfaInfomList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageRfaInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
            	eventResponse = searchRfaSurcharge(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0945Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchXchRt(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg007908Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchRateBkgDefault(e);
			}else
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRate(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg1043Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCntrRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCntrRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = distributeCntrRate(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg1076Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTaaInform(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTaaInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageTaaInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
            	eventResponse = searchCmdt(e); 
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
            	eventResponse = searchTaaSurcharge(e); 
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg1077Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchAppicationDate(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateTpbInfo(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0704Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDocAdjInfo(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageDocAdj(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
            	eventResponse = validateDocLoc(e);
			}
		}
        return eventResponse;
    }

    /**
     * EsmBkg0269Event 조회 이벤트 처리<br>
     * Freight & Charge_S/C Information 를 조회한다<br>
     *  
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchScInformList(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchScInformList SEARCH caflag]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command = new ScOftAutoRatingBCImpl();

        EsmBkg0269Event event = (EsmBkg0269Event) e;
        List<SearchScOftAutoratingListVO> list = null;

        /* PRC var
         *  v_bkg_no    IN BKG_BOOKING.BKG_NO%TYPE   ,
   		 *	v_ca_flg    IN VARCHAR2          ,
         *	v_ctrt_no    IN VARCHAR2          ,
         *	v_rt_aply_dt  IN VARCHAR2          ,
         *	v_svc_scp_cd  IN BKG_BOOKING.SVC_SCP_CD%TYPE ,
         *	v_cmdt_cd    IN BKG_BOOKING.CMDT_CD%TYPE  ,
         * */
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String rtaplydt = event.getrtAplyDt();
        String scNo = event.getscNo();
        
        try {
        	/* (1) TPE, TJE, MXE, ACE => TPE => TPS
			 * (2) TPW,      MXW, ACW => TPW => TPS
			 * (3) TAE, ASE, MME, SAS => TAE
			 * (4) TAW, ASW, SAN    => TAW
			 * (5) OTHER        => ETC
        	 */
//        	if("TPE".equals(scpcd)|"TPW".equals(scpcd)|"TJE".equals(scpcd)|"MXE".equals(scpcd)|"ACE".equals(scpcd)|"MXW".equals(scpcd)|"ACW".equals(scpcd)){
//        		 list = command.searchScTPSOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd);	
//        	
//        	}else if("TAE".equals(scpcd)|"ASE".equals(scpcd)|"MME".equals(scpcd)|"SAS".equals(scpcd)){
//
//        		list = command.searchScTAEOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd);	
//        	
//        	}else if("TAW".equals(scpcd)|"ASW".equals(scpcd)|"SAN".equals(scpcd)){
//        		
//       		 	list = command.searchScTAWOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd);	
//        	
//        	}else{
//        		
//       		 	list = command.searchScETCOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd);
//        	}
        	list = command.searchScOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd);
        	// result setting
            eventResponse.setRsVoList(list);
     	            
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInformList SEARCH ]==========");
        return eventResponse;
    }
    
    
	/**
	 * EsmBkg0269Event retrieve event process<br>
	 * Cmdt List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchCmdt(Event e )throws EventException{
        log.debug("[START:: searchCmdt == searchCmdt SEARCH cmdt]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0269Event event = (EsmBkg0269Event) e;
    	BookingUtil command = new BookingUtil();
    	
    	String cmdtnm = "";
    	String repcmdtcd = "";
    	String repcmdtnm = "";
    	String cmdt = event.getCmdtcd(); 	
    	cmdtnm =  command.searchMdmCmdtDesc(cmdt);
    	repcmdtcd = command.searchMdmCmdt(cmdt);
    	repcmdtnm = command.searchRepCmdtNm(repcmdtcd);
    	eventResponse.setETCData("cmdtnm", cmdtnm);
    	eventResponse.setETCData("repcmdtcd", repcmdtcd);
    	eventResponse.setETCData("repcmdtnm", repcmdtnm);
    	log.debug("repcmdtcd"+repcmdtcd);
    	return eventResponse;
    	
    }
    

	/**
	 * EsmBkg0269Event management event process<br>
	 * ScInform List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageScInformList(Event e) throws EventException {
    	log.debug("[START:: BlRatingSC == manageScInformList Surcharge Start]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0269Event  event = (EsmBkg0269Event) e; 
        ScOftAutoRatingBC command = new ScOftAutoRatingBCImpl();
        
        SearchScOftAutoratingListVO[] vos = null;
        
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO();
       
        
        List<SearchScOftAutoratingListVO> list2 = null;
//        List<SearchScOftAutoratingListVO> list2 = new ArrayList();
        //List<SearchSurchargePercentBaseChargeListVO> list3 = null;
        String bkg_no = event.getBkg_no(); 
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd(); 
        String ctrtNo = event.getscNo();
        String frtTermCd = event.getfrtTermCd();

               
        int fnl_frt_rt_amt = 0;
        
        
    	/* To improve performance, save and query data in a temporary table to retrieve. */
        try{
        	begin();
        	    	
        	command.manageScInformList(event.getSearchScOftAutoratingListVOS(), account.getUsr_id());
        	//Insert the actual logic and recognized as a Select query, so a user does not display a message.
        	//eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getMessage());
        	
        	log.debug("===VOS Length=="+event.getSearchScOftAutoratingListVOS().length);
        	vos = event.getSearchScOftAutoratingListVOS();
        	
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		vo.setFrtTermCd(frtTermCd);
    		for (int i = 0; i< vos.length; i ++){
    			fnl_frt_rt_amt += (int)Double.parseDouble(JSPUtil.getNullNoTrim(vos[i].getFnlFrtRtAmt(),"0"));
    			event.getSearchScOftAutoratingListVOS()[i].setInclTaxFlg("Y");		//2016.05.30. OFT include tax rate....
    		}

    		vo.setFnlFrtRtAmt(Integer.toString(fnl_frt_rt_amt));    		
        	
    		
    		//event.getSearchScOftAutoratingListVOS() -> vo
    		
    		
    		list2 = command.searchSurchargeAutoratingInclTaxList(vo, event.getSearchScOftAutoratingListVOS());
            eventResponse.setRsVoList(list2);
            
			commit();
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        return eventResponse;
   	
    }
   	
	/**
	 * EsmBkg0739Event retrieve event process<br>
	 * RfaInfom List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchRfaInfomList(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchRfaInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RfaOftAutoRatingBC command = new RfaOftAutoRatingBCImpl();

        EsmBkg0739Event event = (EsmBkg0739Event) e;

        List<SearchRfaOftAutoratingListVO> list = null;

        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String rtaplydt = event.getRtaplydt();
        String rfaNo = event.getrfaNo();

        try {
        	
        	list = command.searchRfaOftAutoratingList(bkg_no,caflag,rfaNo,rtaplydt,scpcd,cmdtcd);
        	
        	
//        		list = command.searchSurchargeAutoratingList(bkg_no,caflag,scpcd,cmdtcd );	
        	  eventResponse.setRsVoList(list);
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchRfaInform SEARCH ]==========");
        return eventResponse;
    }
    
	/**
	 * EsmBkg0739Event management event process<br>
	 * RfaInform List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageRfaInformList(Event e) throws EventException{
    	log.debug("[START:: BlRatingSC == searchSurchargeRfaInform SEARCH ]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        EsmBkg0739Event event = (EsmBkg0739Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO();
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getRtaplydt();
        String rtAudTpCd = event.getRtAudTpCd(); 
        String ctrtNo = event.getrfaNo();
        String frtTermCd = event.getfrtTermCd();
        
        
        
        /* To improve performance, save and query data in a temporary table to retrieve. */
        try{
        	
        	begin();
        	for(int i =0; i< event.getSearchScOftAutoratingListVOS().length; i++){
        		event.getSearchScOftAutoratingListVOS()[i].setPrcGenSpclRtTpCd("S");
        		event.getSearchScOftAutoratingListVOS()[i].setInclTaxFlg("Y");		//2016.05.30. OFT include tax rate....
        	}
        	command1.manageScInformList(event.getSearchScOftAutoratingListVOS(),account.getUsr_id());       	
          	
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		vo.setFrtTermCd(frtTermCd);
        	
//        	list2 = command1.searchSurchargeAutoratingList(vo);
    		list2 = command1.searchSurchargeAutoratingInclTaxList(vo, event.getSearchScOftAutoratingListVOS());
    		
    		
    		
        	eventResponse.setRsVoList(list2);
        	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
	/**
	 * EsmBkg0269Event retrieve event process<br>
	 * ScSurcharge List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchScSurcharge(Event e )throws EventException{
        log.debug("[START:: searchSurcharge == searchScSurcharge SEARCH03 ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        EsmBkg0269Event event = (EsmBkg0269Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO(); 
        
        String bkg_no = event.getBkg_no(); 
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd();
        String frtTermCd = event.getfrtTermCd();
        String ctrtNo = event.getscNo();
        try{
        	
        	begin();
    	  	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setFrtTermCd(frtTermCd);
    		vo.setCtrtNo(ctrtNo);
    		
    		
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);

        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }


	/**
	 * EsmBkg0739Event retrieve event process<br>
	 * RfaSurcharge List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchRfaSurcharge(Event e )throws EventException{
        log.debug("[START:: searchSurcharge == searchRfaSurcharge SEARCH03 ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        EsmBkg0739Event event = (EsmBkg0739Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO(); 
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getRtaplydt();
        String rtAudTpCd = event.getRtAudTpCd();  
        String ctrtNo = event.getrfaNo();

        try{
        	
        	begin();
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);

        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
	/**
	 * EsmBkg1076Event retrieve event process<br>
	 * TaaSurcharge List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchTaaSurcharge(Event e )throws EventException{
        log.debug("[START:: searchSurcharge == searchRfaSurcharge SEARCH03 ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        EsmBkg1076Event event = (EsmBkg1076Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO(); 
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd();  
        String ctrtNo = event.gettaaNo();

        try{
        	
        	begin();
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);

        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
    
	/**
	 * EsmBkg1076Event retrieve event process<br>
	 * TaaInform List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageTaaInformList(Event e) throws EventException{
    	log.debug("[START:: BlRatingSC == searchSurchargeTaaInform SEARCH ]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        EsmBkg1076Event event = (EsmBkg1076Event) e;

        List<SearchScOftAutoratingListVO> list2 = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO();
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd();
        String ctrtNo = event.gettaaNo();
        String frtTermCd = event.getfrtTermCd();
        
        /* To improve performance, save and query data in a temporary table to retrieve. */
        try{
        	begin();
        	for(int i =0; i< event.getSearchScOftAutoratingListVOS().length; i++){
        		event.getSearchScOftAutoratingListVOS()[i].setPrcGenSpclRtTpCd("S");
        		event.getSearchScOftAutoratingListVOS()[i].setPrcCmdtHdrSeq("0");
        		event.getSearchScOftAutoratingListVOS()[i].setPrcRoutSeq("0");
        		event.getSearchScOftAutoratingListVOS()[i].setPrcRtSeq("0");
        		event.getSearchScOftAutoratingListVOS()[i].setInclTaxFlg("Y");		//2016.05.30. OFT include tax rate....
        		
        	}
        	command1.manageScInformList(event.getSearchScOftAutoratingListVOS(), account.getUsr_id());        	
        	
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		vo.setFrtTermCd(frtTermCd);
    		
//    		list2 = command1.searchSurchargeAutoratingList(vo);
    		list2 = command1.searchSurchargeAutoratingInclTaxList(vo, event.getSearchScOftAutoratingListVOS());
            eventResponse.setRsVoList(list2);          
            commit();
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
	/**
	 * EsmBkg007908Event management event process<br>
	 * Rate List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == manageRate update ]==========");
        
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        BookingUtil bookingUtil 			= new BookingUtil();
        BlRatingBC blRatingBC 				= new BlRatingBCImpl();
        CostAssignBC coaCmd 				= new CostAssignBCImpl();
        GeneralBookingReceiptBC receiptBC	= new GeneralBookingReceiptBCImpl();
        BLDocumentationBLBC  bLDocumentationBLBC = new BLDocumentationBLBCImpl();
//        BLIssuanceBC bLIssuanceBC 			= new BLIssuanceBCImpl();
        EsmBkg007908Event event 			= (EsmBkg007908Event) e;
        BkgChgRateVO[] bkgChgRateVOs 		= event.getBkgChgRateVOs();
        BkgChgRateVO[] bkgChgRateHisVOs 	= event.getBkgChgRateHisVOs();
        RateMainInfoVO[] rateMainInfoVOs	= event.getRateMainInfoVOs();
        String application_date 			= event.getApplication_date();
        ScOftAutoRatingBC autoRateCommand	= new ScOftAutoRatingBCImpl();
        
        String bkg_no 		= event.getBkg_no();
        String bl_no 		= event.getBl_no();
        String caflag 		= event.getCaflag();
        String m_covered_bl	= event.getCovered_bl();
        String autoRate 	= event.getAutoRate();
        String removeAll 	= event.getRemoveAll();
        
        if(m_covered_bl != null && m_covered_bl.length()>0){
        	 if(m_covered_bl.length()>=12){
        		 m_covered_bl = m_covered_bl.substring(0,12);
        	 }else if(m_covered_bl.length()>=10){
        		 m_covered_bl = m_covered_bl.substring(0,10);
        	 }
        }
       
        RateInVO rateInVO = new RateInVO();
        rateInVO.setCaflag(caflag);
        rateInVO.setAccount(account);
        rateInVO.setBkgChgRateVOs(bkgChgRateVOs);
        rateInVO.setRateMainInfoVOs(rateMainInfoVOs);
        rateInVO.setBkg_no(bkg_no);
        rateInVO.setBl_no(bl_no);
        rateInVO.setCovered_bl(m_covered_bl);
        rateInVO.setApplication_date(application_date);
        rateInVO.setAutoRate(autoRate);
        rateInVO.setRemoveAll(removeAll);
        try {
        	//bdr check
        	BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
            bkgBlNoVo.setBkgNo(bkg_no);
    		bkgBlNoVo.setCaUsrId(account.getUsr_id());
    		bkgBlNoVo = bookingUtil.searchBkgBlNoVO(bkgBlNoVo);
    		
    		rateInVO.setCaflag(bkgBlNoVo.getCaFlg());

    		if(bkgChgRateHisVOs != null){
        		if(autoRate.equals("Y")&& bkgChgRateHisVOs.length >0){
    		        RateInVO rateHisInVO = new RateInVO();
    		        rateHisInVO.setBkg_no(bkg_no);
    		        rateHisInVO.setBl_no(bl_no);
    		        rateHisInVO.setCaflag(caflag);
    		        rateHisInVO.setAccount(account);
    		        rateHisInVO.setBkgChgRateVOs(bkgChgRateHisVOs);
    				blRatingBC.autoRatingHistory(rateHisInVO);
    			}
    		}

        	//check ppd_rcv_ofc_cd  office code
        	String existThird1  = bookingUtil.existThirdCode(rateMainInfoVOs[0].getPpdRcvOfcCd());
        	if(existThird1.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00905").getMessage());// Third Office is not available
        	}
        	//check clt_ofc_cd  office code
        	String existThird2  = bookingUtil.existThirdCode(rateMainInfoVOs[0].getCltOfcCd());
        	if(existThird2.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00905").getMessage());//Third Office is not available
        	}

        	//check getPpdPayrCustSeq  office code
    		String r_ppd_rcv_ofc_value = rateMainInfoVOs[0].getPpdPayrCntCd()+"|"+rateMainInfoVOs[0].getPpdPayrCustSeq();
        	String ppd_rcv_ofc  = bookingUtil.existPayerCode(r_ppd_rcv_ofc_value);
        	if(!ppd_rcv_ofc.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00458").getMessage());//  invalid customer code
        	}
        	
        	//check getCltPayrCustSeq  office cd
        	String r_clt_ofc_value = rateMainInfoVOs[0].getCltPayrCntCd()+"|"+rateMainInfoVOs[0].getCltPayrCustSeq();
        	String clt_ofc  = bookingUtil.existPayerCode(r_clt_ofc_value);
        	if(!clt_ofc.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00458").getMessage());//  invalid customer code
        	}
        	
        	//[10] BookingUtil::searchBkgNoByBlNo ( blNo ) 
        	if(m_covered_bl != null && m_covered_bl.length()>0){
        		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
                bkgBlNoIN.setBlNo(m_covered_bl);
                BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
                
                if(bkgBlNoVO == null || "X".equals(bkgBlNoVO.getBkgStsCd())) {
                	throw new EventException((String)new ErrorHandler("BKG08058",new String[]{m_covered_bl}).getMessage());	                	
                }
        	}
        	
            String rt_bl_tp_cd = rateMainInfoVOs[0].getRtBlTpCd();
            String rt_bl_tp_cd_old = rateMainInfoVOs[0].getRtBlTpCdOld();
            if("Y".equals(bkgBlNoVo.getCaFlg())) {
            	List<CoveredBlListVO> list = blRatingBC.searchCoveredBl(bkg_no, bl_no,caflag);
            	if( list.size() > 0){
            		throw new EventException((String)new ErrorHandler("BKG08170",new String[]{}).getMessage());
            	}
            }
            
            if(bkgChgRateVOs!=null && bkgChgRateVOs.length>0){
            	List<String> chgCdList = new ArrayList<String>();
            	for(BkgChgRateVO vo : bkgChgRateVOs){
            		chgCdList.add(vo.getChgCd());
            	}
            	List<String> nullChgList = bookingUtil.searchChgAcctNull(chgCdList);
            	
            	if(nullChgList.size() > 0){
            		String nullChg = nullChgList.toString();
            		String msg = "the Account(G/L) of "+nullChg+" on MDM"; 
            		throw new EventException((String)new ErrorHandler("BKG00445",new String[]{msg}).getMessage());
            	}
            }
            
            begin();
            
	        	//[11] IBookingHistoryMgtBC::searchOldBkgForHistory ( uiId , bkgBlNoVo )
				BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
				HistoryTableVO historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_0079_08", bkgBlNoVo);

				OfcChgProcVO ofcChgProcVO = new OfcChgProcVO();
				ofcChgProcVO.setType("R");  //rating
				ofcChgProcVO.setCaFlg(caflag);
				ofcChgProcVO.setBkgNo(bkg_no);
				ofcChgProcVO.setPpdRcvOfcCd(rateMainInfoVOs[0].getPpdRcvOfcCd());
				ofcChgProcVO.setCltOfcCd(rateMainInfoVOs[0].getCltOfcCd());
				ofcChgProcVO = bookingUtil.searchOfcChgProc(ofcChgProcVO);

				//[12] IBDRCorrectionBC::createTempHist ( bkgBlNoVo , tempHistCd , caRsnCD , caRmk )
				
				log.debug("=============================================");
				log.debug(" [MainInfo]  Modify if retriev option changed ");
				log.debug("=============================================");
	
				// Session user_id setting
				rateMainInfoVOs[0].setUserId(account.getUsr_id());
	
				// Save changed ChgRateBkgRate
				blRatingBC.modifyChgRateBkgRate(rateMainInfoVOs[0], caflag);
				
				
				////////////// [tax calculation..................] //////////////////////////////////////////////////////////////////////////
				if(bkgChgRateVOs !=null && bkgChgRateVOs.length>0){
				
					String svcScpCd = rateMainInfoVOs[0].getBkgSvcScpCd();
					String rtAplyDt = rateMainInfoVOs[0].getRtAplyDt();		//frm_t10sheet1_rt_aply_dt
					
					int inSize = 0;
					int delSize = 0;
					for(int i=0; i< bkgChgRateVOs.length; i++){
						if("D".equals(bkgChgRateVOs[i].getIbflag())){
							delSize++;
						}else{
							inSize++;
						}
					}
					
					BkgChgRateVO[] inBkgChgRateVOs		= null;
					BkgChgRateVO[] delBkgChgRateVOs		= null;
					
					if(inSize > 0){
						inBkgChgRateVOs		= new BkgChgRateVO[inSize];
					}
					
					if(delSize > 0){
						delBkgChgRateVOs	= new BkgChgRateVO[delSize];
					}

					inSize = 0;
					delSize = 0;
					for(int i=0; i< bkgChgRateVOs.length; i++){
						if("D".equals(bkgChgRateVOs[i].getIbflag())){
							delBkgChgRateVOs[delSize] = new BkgChgRateVO();
							delBkgChgRateVOs[delSize] = bkgChgRateVOs[i];
							delSize++;
						}else{
							inBkgChgRateVOs[inSize]	= new BkgChgRateVO();
							inBkgChgRateVOs[inSize]	= bkgChgRateVOs[i];
							inSize++;
						}
					}
					
					if(inSize==0){	//all rows deleted.
						rateInVO.setBkgChgRateVOs(bkgChgRateVOs);
					}else{
						List<SearchScOftAutoratingListVO> taxList = autoRateCommand.searchTaxSurchargeList(inBkgChgRateVOs, bkg_no, svcScpCd, rtAplyDt);
						
						BkgChgRateVO[] outBkgChgRateVOs 		= new BkgChgRateVO[taxList.size()];
						
						if(taxList!=null && taxList.size()>0){
							for(int i=0; i<taxList.size(); i++){
								SearchScOftAutoratingListVO oVO = (SearchScOftAutoratingListVO)taxList.get(i);
								
								outBkgChgRateVOs[i] = new BkgChgRateVO();
								outBkgChgRateVOs[i].setChgCd(oVO.getChgCd());
								outBkgChgRateVOs[i].setCurrCd(oVO.getCurrCd());
								outBkgChgRateVOs[i].setChgUtAmt(oVO.getChgUtAmt());
								outBkgChgRateVOs[i].setRatAsQty(oVO.getRatAsQty());
								outBkgChgRateVOs[i].setRatUtCd(oVO.getRatUtCd());
								outBkgChgRateVOs[i].setChgAmt(oVO.getChgAmt());
								outBkgChgRateVOs[i].setFrtTermCd(oVO.getFrtTermCd());
								outBkgChgRateVOs[i].setTaxFlg(oVO.getTaxFlg());
								outBkgChgRateVOs[i].setPctBseCd(oVO.getPctBseCd());
								outBkgChgRateVOs[i].setCgoCateCd(oVO.getCgoTpCd());
								
								if(oVO.getTaxFlg().equals("Y")){
									if(autoRate.equals("Y")){
										outBkgChgRateVOs[i].setIbflag("U");
									}else{
										outBkgChgRateVOs[i].setIbflag("I");
									}
									outBkgChgRateVOs[i].setSaveFlg("Y");
								}else{
									outBkgChgRateVOs[i].setSaveFlg("N");
									outBkgChgRateVOs[i].setIbflag("R");
								}
								
							}
						}
		//				log.debug("taxList size===>"+taxList.size());
		//				log.debug("inBkgChgRateVOs size===>"+inBkgChgRateVOs.length);
						
						List<BkgChgRateVO> listBkgChgRateVO		= new ArrayList<BkgChgRateVO>();
						
						
						String chgCd 	= "";
						String frtTermCd= "";
						String ratUtCd	= "";
						int idx = 0;
						int arrSize = inBkgChgRateVOs.length;
							
						for(int i=0; i<arrSize; i++){
							if("Y".equals(inBkgChgRateVOs[i].getTaxFlg())){
								inBkgChgRateVOs[i].setIbflag("D");
								listBkgChgRateVO.add(inBkgChgRateVOs[i]);
							}else{
								if(inBkgChgRateVOs[i].getIbflag() == null){
									inBkgChgRateVOs[i].setIbflag("R");
								}
								listBkgChgRateVO.add(inBkgChgRateVOs[i]);
							}
						}
						
						for(int i=0; i<outBkgChgRateVOs.length; i++){
							chgCd = outBkgChgRateVOs[i].getChgCd();
							frtTermCd = outBkgChgRateVOs[i].getFrtTermCd();
							ratUtCd = outBkgChgRateVOs[i].getRatUtCd();
							
							for(int j=0; j<listBkgChgRateVO.size(); j++){
								if(chgCd.equals(listBkgChgRateVO.get(j).getChgCd())
										&& frtTermCd.equals(listBkgChgRateVO.get(j).getFrtTermCd())
										&& ratUtCd.equals(listBkgChgRateVO.get(j).getRatUtCd()))
								{
									outBkgChgRateVOs[i].setInclOftFlg(listBkgChgRateVO.get(j).getInclOftFlg());
									outBkgChgRateVOs[i].setN3ptyRcvOfcCd(listBkgChgRateVO.get(j).getN3ptyRcvOfcCd());
									outBkgChgRateVOs[i].setN3ptyCustCntCd(listBkgChgRateVO.get(j).getN3ptyCustCntCd());
									outBkgChgRateVOs[i].setN3ptyCustSeq(listBkgChgRateVO.get(j).getN3ptyCustSeq());
									outBkgChgRateVOs[i].setCgoCateCd(listBkgChgRateVO.get(j).getCgoCateCd());
									outBkgChgRateVOs[i].setRcvTermCd(listBkgChgRateVO.get(j).getRcvTermCd());
									outBkgChgRateVOs[i].setDeTermCd(listBkgChgRateVO.get(j).getDeTermCd());
									outBkgChgRateVOs[i].setImdgClssCd(listBkgChgRateVO.get(j).getImdgClssCd());
									outBkgChgRateVOs[i].setAutoRatCd(listBkgChgRateVO.get(j).getAutoRatCd());
									outBkgChgRateVOs[i].setPrnHdnFlg(listBkgChgRateVO.get(j).getPrnHdnFlg());
									outBkgChgRateVOs[i].setNoteRtSeq(listBkgChgRateVO.get(j).getNoteRtSeq());
									outBkgChgRateVOs[i].setPropNo(listBkgChgRateVO.get(j).getPropNo());
									outBkgChgRateVOs[i].setAmdtSeq(listBkgChgRateVO.get(j).getAmdtSeq());
									outBkgChgRateVOs[i].setSvcScpCd(listBkgChgRateVO.get(j).getSvcScpCd());
									outBkgChgRateVOs[i].setRoutSeq(listBkgChgRateVO.get(j).getRoutSeq());
								}
							}
							
							listBkgChgRateVO.add(outBkgChgRateVOs[i]);						
						}
						BkgChgRateVO[] out2BkgChgRateVOs 		= new BkgChgRateVO[listBkgChgRateVO.size()];
						
						int outSize = out2BkgChgRateVOs.length;
						
						for(int i=0; i<listBkgChgRateVO.size(); i++){
							BkgChgRateVO tempVO	= (BkgChgRateVO)listBkgChgRateVO.get(i);
							out2BkgChgRateVOs[i] = tempVO;
						}
						
						int sizeMakeVO = delSize + outSize;
						log.debug("sizeMakeVO size===>"+sizeMakeVO);
						BkgChgRateVO[] makeBkgChgRateVOs 		= new BkgChgRateVO[sizeMakeVO];
						idx = 0;
						for(int i = 0; i < outSize; i++){
							makeBkgChgRateVOs[idx] = out2BkgChgRateVOs[i];
							idx++;
						}
						for(int i=0; i<delSize; i++){
							makeBkgChgRateVOs[idx] = delBkgChgRateVOs[i];
							idx++;
						}
						
						
						log.debug("recal input makeBkgChgRateVOs size===>"+makeBkgChgRateVOs.length);
		
						rateInVO.setBkgChgRateVOs(makeBkgChgRateVOs);
					}
				}

				//////////////// [tax calculation..................] //////////////////////////////////////////////////////////////////////////
				
				
				//[13] IBlRatingBC::manageRate ( rateOuts )
	            blRatingBC.manageRate(rateInVO);
	            
	            if("C".equals(rt_bl_tp_cd)){
	            	rateMainInfoVOs[0].setBlCvrdTpCd("C");
	            }
	            if(rateMainInfoVOs[0].getMstCvrdBl() != null && !"".equals(rateMainInfoVOs[0].getMstCvrdBl())){
	            	if(rateMainInfoVOs[0].getMstCvrdBl().length() >= 12)
	            	{
	            		rateMainInfoVOs[0].setMstCvrdBl(rateMainInfoVOs[0].getMstCvrdBl().substring(0,12));
	            	}else if (rateMainInfoVOs[0].getMstCvrdBl().length() >= 10){
	            		rateMainInfoVOs[0].setMstCvrdBl(rateMainInfoVOs[0].getMstCvrdBl().substring(0,10));
	            	}
	            }
	            bLDocumentationBLBC.modifyChgRateBkgBlDoc(rateMainInfoVOs[0], caflag);
	            rateMainInfoVOs[0].setBlCvrdTpCd(""); 
	            receiptBC.modifyChgRateBkgBooking(rateMainInfoVOs[0], caflag);
	            
                log.debug("=============================================");
                log.debug(" B/L Type 이 C 인 경우 Convered By 값을 Master B/L로 업데이트 한다 by 2010.1.21 김태경 ");
                log.debug("=============================================");
	        
	            if("M".equalsIgnoreCase(rt_bl_tp_cd)){
	            	//According to BKG_NO mst_cvrd_bl_no, cobiz_auth_no to handle changes to null.
					rateMainInfoVOs[0].setBkgNo(bkg_no);
					rateMainInfoVOs[0].setMstCvrdBl("");
					bLDocumentationBLBC.modifyChgRateBkgBlDoc(rateMainInfoVOs[0], caflag);
					
	            }else if("C".equalsIgnoreCase(rt_bl_tp_cd)){

	            	String m_bkg_no = bookingUtil.searchBkgNoByBlNo(m_covered_bl);
	            	
	            	//BKG_NO, MASTER BL BL_type on changes in the M.
	            	CoveredBlListVO  coveredBlListVO = new CoveredBlListVO();
	    			coveredBlListVO.setBkgNo(m_bkg_no);
	    			coveredBlListVO.setBlNo(m_covered_bl);		
	    			coveredBlListVO.setBlCvrdTpCd("M");
	    			coveredBlListVO.setUserId(account.getUsr_id());
					blRatingBC.modifyCoveredBl(coveredBlListVO,caflag);
					
					//on the master bl mst_cvrd_bl_no, cobiz_auth_no changes to null.
					rateMainInfoVOs[0].setBkgNo(m_bkg_no);
					rateMainInfoVOs[0].setMstCvrdBl("");
					rateMainInfoVOs[0].setCobizAuthNo("");
					bLDocumentationBLBC.modifyChgRateBkgBlDoc(rateMainInfoVOs[0], caflag);
	            }
	            
	            log.debug("=============================================");
                log.debug(" B/L Type 이 M,C가 아닌  경우  관련된 모든 테이블 관계를 끊는다. by 2010.3.9 김태경 ");
                log.debug("=============================================");
                // Change the value M, C while not
                if(!"M".equalsIgnoreCase(rt_bl_tp_cd)&& !"C".equalsIgnoreCase(rt_bl_tp_cd)){
                	//if Previous data M, C
            		if("M".equalsIgnoreCase(rt_bl_tp_cd_old)|| "C".equalsIgnoreCase(rt_bl_tp_cd_old)){
            			// If master "bl" nomal both to change the state.
            			if("M".equalsIgnoreCase(rt_bl_tp_cd_old)){
            				blRatingBC.modifyChgRateMaster(rateMainInfoVOs[0],caflag);
            			}
            			//relationship breaks all the tables involved
            			bLDocumentationBLBC.modifyChgRateBkgBlDocMasterCovered(rateMainInfoVOs[0], rt_bl_tp_cd_old,caflag);
            		}
                }
    			BookingUtil utilCmd = new BookingUtil();
    			
    			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
    			bkgBlNoVO.setBkgNo(bkg_no);
//    			bkgBlNoVO.setBlNo(bl_no);	
    			bkgBlNoVO.setCaUsrId(account.getUsr_id());
    			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
            
            	log.debug("\n======= Auto EDI Send ======\n");
//            	List<BkgNtcHisVO> bkgNtcHisVOs = bLIssuanceBC.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), account);

//    			if (bkgNtcHisVOs != null) {
//    				if (bkgNtcHisVOs.size() > 0) {
//    					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
//    				}
//    			}	                
                
                
	            //[14] BookingHistoryMgtBC::manageBookingHistory ( '','','' )
	            bookingHistoryMgtBC.manageBookingHistory("ESM_BKG_0079_08", historyTableVO, account);

            /* COA */
            if(!"Y".equals(caflag)){
                CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                coaBkgComIfVo.setBkgNo(bkg_no);
                coaBkgComIfVo.setCostSrcSysCd("BKG");
                coaBkgComIfVo.setIfRmk("Manage Rate");
                coaBkgComIfVo.setCreUsrId(account.getUsr_id());
                coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
                coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);	
                
                // Call Back End Job
                //[21] IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	                BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	                ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	                bkgIfVo.setBkgNo(bkg_no);
	                bkgIfVo.setManDivInd("B");
	                bkgIfVo.setUserId(account.getUsr_id());
	                bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
	                
	                bkgBlNoVO.setBkgNo(bkg_no);
	                bkgBlNoVO.setBlNo(bl_no);	
	                bkgBlNoVO.setCaUsrId(account.getUsr_id());
	                blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);      
            }
           
            /* 
            * Charge Save on the screen at a zero value if the Collect or 3rd Collect
            * CargoRelease calling side sends the EDI
            * C / A Save on Charge, regardless of whether the case should send EDI 
            */
            List<SearchFocByFreightListVO>  searchFocByFreightListVO = null;
                
            searchFocByFreightListVO = blRatingBC.searchFocByFreightList(bkg_no,caflag);
        	/* Displays an error message*/
			if(searchFocByFreightListVO == null){
				throw new EventException((String)new ErrorHandler("BKG08058").getMessage());
			}

			if(searchFocByFreightListVO.get(0).getcolAmt().equals("0") && searchFocByFreightListVO.get(0).getcctAmt().equals("0")){
 
			log.debug("===============================================================");
			log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByFreight ]");
			log.debug("===============================================================");
			
			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
			FrtCltLstVO frtCltLst = new FrtCltLstVO();
			/* BL No Flip only a 12-digit */
			if(bl_no == null){
				frtCltLst.setBlNo("");		//소스품질 check
			}else{
				if(bl_no.length() >= 12 ){
					frtCltLst.setBlNo(bl_no.substring(0, 12));
				}else if(bl_no.length() >= 10 ){
					frtCltLst.setBlNo(bl_no.substring(0, 10));
				}
			}
			
			frtCltLst.setFrtCltFlg("Y");
			frtCltLst.setEvntOfcCd(account.getOfc_cd());
			frtCltLst.setEvntUsrId(account.getUsr_id());
			frtCltLst.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			frtCltLst.setCgorTeamCd("F");
			frtCltLst.setCgoEvntNm("CHARGE");
			
			try{
				cargoBC.setupFocByFreight(frtCltLst);
			}catch(Exception e1){
				log.error("[end:: CargoReleaseOrderBC == manageRate update ]==========");
				}
			} 

			if ("Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgPpdProc()) || "Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgCctProc())) {
				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
				bkgModiOfcPrcVO.setInBkgNo(bkg_no);
				bkgModiOfcPrcVO.setInCaFlg(caflag);
				blRatingBC.callBkgModiIssOfcPrc(bkgModiOfcPrcVO);
			}

            commit();
            //[22] __COA::interfaceToCoa ( bkgBlNoVo )
            
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException((String)new ErrorHandler("BKG00391").getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageRate update ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0961Event retrieve event process<br>
	 * PayerCode List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchPayerCode(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchPayerCode SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0961Event event = (EsmBkg0961Event) e;
        PpdCctCustInVO ppdCctCustInVO = event.getPpdCctCustInVO();

        try {
            List<PpdCctCustOutVO> list = command.searchPayerCode(ppdCctCustInVO);

            eventResponse.setRsVoList(list);
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchPayerCode SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0270Event retrieve event process<br>
	 * ScNote List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchScNote(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchScNote SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0270Event event = (EsmBkg0270Event) e;
        ScNoteInVO scNoteInVO = event.getScNoteInVO();
        List<ScNoteOutVO> oftList = null;
        List<ScNoteOutVO> surchargeList = null;

        try {
            // 1. OFT Note to retrieve.
            scNoteInVO.setNoteChgTpCd("O");
            oftList = command.searchScNote(scNoteInVO);
            // 2. SurchargNote to retrieve.
            scNoteInVO.setNoteChgTpCd("S");
            surchargeList = command.searchScNote(scNoteInVO);
            // 3. Arbitrary Note to retrieve.

            eventResponse.setRsVoList(oftList);
            eventResponse.setRsVoList(surchargeList);
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScNote SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0265Event retrieve event process<br>
	 * ChargeRemark List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchChargeRemark(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchChargeRemark SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();
        BookingUtil bookingUtil = new BookingUtil();

        EsmBkg0265Event event = (EsmBkg0265Event) e;
        List<ChargeRemarkVO> list = null;
        String bkg_no = event.getBkg_no();

        try {
        	BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
			}
        	
        	String caFlg = bkgBlNoVO.getCaFlg();
        	
            list = command.searchChargeRemark(bkg_no,caFlg);
            if(list.size() > 0) {
                ChargeRemarkVO vo = list.get(0);
                eventResponse.setETCData("BKG_NO", JSPUtil.getNull(vo.getBkgNo()));
                eventResponse.setETCData("BL_CVRD_TP_CD", JSPUtil.getNull(vo.getBlCvrdTpCd()));
                eventResponse.setETCData("INTER_RMK", JSPUtil.getNull(vo.getInterRmk()));
                eventResponse.setETCData("DIFF_RMK", JSPUtil.getNull(vo.getDiffRmk()));
                eventResponse.setETCData("MST_CVRD_BL_NO", JSPUtil.getNull(vo.getMstCvrdBlNo()));
                eventResponse.setETCData("THIRD_PARTY_FREIGHT", JSPUtil.getNull(vo.getThirdPartyFreight()));
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchChargeRemark SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0265Event management event process<br>
	 * ChargeRemark List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageChargeRemark(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == manageChargeRemark update ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();
        BookingUtil bookingUtil = new BookingUtil();

        EsmBkg0265Event event = (EsmBkg0265Event) e;
        String bkg_no = event.getBkg_no();
        String diff_rmk = 	WordWarp.wrap(event.getDiff_rmk().trim(), 70);
        String inter_rmk =  WordWarp.wrap(event.getInter_rmk().trim(), 70);
        String user_id = account.getUsr_id();
        try {
            begin();
            
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
			}
			String ca_flg = bkgBlNoVO.getCaFlg();
            
            command.manageChargeRemark(bkg_no, diff_rmk,inter_rmk,user_id, ca_flg);
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageChargeRemark update ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0264Event retrieve event process<br>
	 * QtyForRate List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchQtyForRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchQtyForRate SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0264Event event = (EsmBkg0264Event) e;
        List<BkgQtyOutVO> list = null;
        String bkg_no = event.getBkg_no();

        try {
            list = command.searchQtyForRate(bkg_no);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchQtyForRate SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0269Event retrieve event process<br>
	 * ScInform List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchScInform(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchScInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0269Event event = (EsmBkg0269Event) e;
        ScInformOutVO scInformOutVO = null;
        ScInformInVO scInformInVO = event.getScInformInVO();
        
        String caFlg = event.getCaflag();
        

        try {
            // rateqtylist info
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(scInformInVO.getBkgNo());
            bkgBlNoVO.setCaFlg(caFlg);
            scInformInVO.setCaFlg(caFlg);
            eventResponse.setRsVoList(command.searchRateQtyList(bkgBlNoVO));

            // scinfo info.
            scInformOutVO = command.searchScInform(scInformInVO);
            eventResponse.setRsVo(scInformOutVO.getScBkgInformVOs());
            eventResponse.setRsVo(scInformOutVO.getScCustInformVOs());
            eventResponse.setRsVoList(null);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInform SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0771Event retrieve event process<br>
	 * CoveredBl List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchCoveredBl(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchCoveredBl SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0771Event event = (EsmBkg0771Event) e;
        List<CoveredBlListVO> list = null;
        String bkg_no = event.getBkg_no();
        String bl_no = event.getBl_no();

        try {
            list = command.searchCoveredBl(bkg_no, bl_no, "");

            eventResponse.setRsVoList(list);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchCoveredBl SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg0771Event management event process<br>
	 * CoveredBl List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageCoveredBl(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == manageCoveredBl MULTI ]==========");
        GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
        BlRatingBC 				blRatingBC 			= new BlRatingBCImpl();
        BLDocumentationBLBC 	bLDocumentationBLBC = new BLDocumentationBLBCImpl();
        
        EsmBkg0771Event event 				= (EsmBkg0771Event) e;
        CoveredBlListVO[] coveredBlListVOs 	= event.getCoveredBlListVOs();
        String bkg_no 						= event.getBkg_no();
        String bl_no 						= event.getBl_no();
        String val_code 					= "";
        
        try {
        	
            begin();
            //blRatingBC.manageCoveredBl
            if(bl_no!=null && !"".equals(bl_no)){
            	if(bl_no.length()>=12){
            		bl_no = bl_no.substring(0,12);
            	}else if(bl_no.length()>=10){
            		bl_no = bl_no.substring(0,10);
            	}
            }
            
            String r_message = blRatingBC.manageCoveredBl(bkg_no, bl_no, coveredBlListVOs, account);
            //bLDocumentationBLBC.manageCoveredBl
            r_message = bLDocumentationBLBC.manageCoveredBl(bkg_no, bl_no, coveredBlListVOs);
            commit();
            
            if(r_message.equals("")) {
        		val_code = "00";
        	}
            eventResponse.setETCData("val_code", val_code);
            eventResponse.setUserMessage(r_message); 

        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        log.debug("[END::]==========");
        return eventResponse;
    }

    
    
	/**
	 * EsmBkg0739Event management event process<br>
	 * RfaInform List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchRfaInform(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchRfaInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0739Event event = (EsmBkg0739Event) e;
        RfaInformOutVO rfaInformOutVO = null;
        RfaInformInVO rfaInformInVO = event.getRfaInformInVO();
        String caFlg = event.getCaflag();

        try {
            // rateqtylist info
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(rfaInformInVO.getBkgNo());
            bkgBlNoVO.setCaFlg(caFlg);
            rfaInformInVO.setCaFlg(caFlg);
            // + tp/sz
            eventResponse.setRsVoList(command.searchRateQtyList(bkgBlNoVO));

            // RFA Information
            rfaInformOutVO = command.searchRfaInform(rfaInformInVO);
            eventResponse.setRsVo(rfaInformOutVO.getRfaBkgInformVO());
            eventResponse.setRsVo(rfaInformOutVO.getRfaCustInformVO());
            eventResponse.setRsVoList(null);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchRfaInform SEARCH ]==========");
        return eventResponse;
    }
    
	/**
	 * EsmBkg1076Event retrieve event process<br>
	 * TaaInform List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchTaaInform(Event e) throws EventException {
    	log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.debug("[START:: BlRatingSC == searchTaaInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg1076Event event = (EsmBkg1076Event) e;
        TaaInformOutVO taaInformOutVO = null;
        TaaInformInVO taaInformInVO = event.getTaaInformInVO();
        String caFlg = event.getCaflag();

        try {
            // rateqtylist info.
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(taaInformInVO.getBkgNo());
            bkgBlNoVO.setCaFlg(caFlg);
            taaInformInVO.setCaFlg(caFlg);
            eventResponse.setRsVoList(command.searchRateQtyList(bkgBlNoVO));

            // scinfo info.
            taaInformOutVO = command.searchTaaInform(taaInformInVO);
            eventResponse.setRsVo(taaInformOutVO.getTaaBkgInformVOs());
            eventResponse.setRsVo(taaInformOutVO.getTaaCustInformVOs());
            eventResponse.setRsVoList(null);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInform SEARCH ]==========");
        return eventResponse;
    }
    
	/**
	 * EsmBkg1076Event retrieve event process<br>
	 * TaaInform List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchTaaInformList(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchTaaInformList SEARCH caflag]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        TaaOftAutoRatingBC command = new TaaOftAutoRatingBCImpl();

        EsmBkg1076Event event = (EsmBkg1076Event) e;
        List<SearchTaaOftAutoratingListVO> list = null;
   
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String rtaplydt = event.getrtAplyDt();
        String taaNo = event.gettaaNo();
        
        try {
        	list = command.searchTaaOftAutoratingList(bkg_no,caflag,taaNo,rtaplydt,scpcd,cmdtcd);
            eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInformList SEARCH ]==========");
        return eventResponse;
    }


	/**
	 * EsmBkg0945Event retrieve event process<br>
	 * XchRt List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchXchRt(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchXchRt SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0945Event event = (EsmBkg0945Event) e;
        List<ExchangeRateVO> list = null;
        String bkg_no = event.getBkgNo();

        try {
            list = command.searchXchRt(bkg_no);

            eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException((String)new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchXchRt SEARCH ]==========");
        return eventResponse;
    }
    
	/**
	 * BookingUtil retrieve event process<br>
	 * RateBkgDefault List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchRateBkgDefault(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bookingUtil = new BookingUtil();

		try{
			// 01. rt_bl_tp_cd data retrieve
			List<BkgComboVO> rTblTp  = bookingUtil.searchCombo("CD01639");
			eventResponse.setRsVoList(rTblTp);
			// 02 frt_term_cd data retrieve
			List<BkgComboVO> frtTerm  = bookingUtil.searchCombo("CD02080");
			eventResponse.setRsVoList(frtTerm);
			// 03. rTerm data retrieve
			List<BkgComboVO> rTerm  = bookingUtil.searchCombo("CD00764");
			Iterator<BkgComboVO> rlist = rTerm.iterator();
			StringBuffer rbuff = new StringBuffer();
			while (rlist.hasNext()) {
				BkgComboVO bkgComboVO = (BkgComboVO) rlist.next();
				rbuff.append(bkgComboVO.getVal());
			}
			rbuff.append(rbuff.toString().toLowerCase());
			eventResponse.setCustomData("rTerm", rbuff.toString());
			// 04. dTerm data retrieve
			List<BkgComboVO> dTerm  = bookingUtil.searchCombo("CD00765");
			Iterator<BkgComboVO> dlist = dTerm.iterator();
			StringBuffer dbuff = new StringBuffer();
			while (dlist.hasNext()) {
				BkgComboVO bkgComboVO = (BkgComboVO) dlist.next();
				dbuff.append(bkgComboVO.getVal());
			}
			dbuff.append(dbuff.toString().toLowerCase());
			eventResponse.setCustomData("dTerm", dbuff.toString());
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;	
	}
	
	/**
	 * EsmBkg007908Event retrieve event process<br>
	 * Rate List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchRate SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command 		= new BlRatingBCImpl();

        EsmBkg007908Event event = (EsmBkg007908Event) e;
        RateOutVO rateOut 		= null;
        String bkg_no 			= event.getBkg_no();
        String bl_no 			= event.getBl_no();

        try {
        	log.debug("/*************************************************************/");
        	log.debug("/********** [searchRate: bkg_no번호가 없는경우 :  bl_no로 bkg_no가져오기  ]/");
        	log.debug("/*************************************************************/");
			BookingUtil bookingUtil = new BookingUtil();
        	if(bl_no!=null && !"".equals(bl_no)){
        		if(bl_no.length()>=12){
        			bl_no = bl_no.substring(0,12);
        		}else if(bl_no.length()>=10){
        			bl_no = bl_no.substring(0,10);
        		}
        	}
			if(bkg_no.length() == 0 && bl_no!=null && !bl_no.equals("") ){
				if(bl_no.length()>=12){
					bl_no = bl_no.substring(0,12);
				}else if(bl_no.length()>=10){
					bl_no = bl_no.substring(0,10);
				}
				bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);	
			}
        	
			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: bkg_no 존재유무판단  1] ************/");
			log.debug("/*************************************************************/");
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setBlNo(bl_no);	
			bkgBlNo.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
			}
			
			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: bkg_no가  P 일경우 return 처리  ] *******/");
			log.debug("/*************************************************************/");
        	String bkgStsCd = bookingUtil.searchBkgCgoTp(bkgBlNoVO);
        	if (bkgStsCd.equals("P")) {
        		throw new EventException(new ErrorHandler("BKG40030").getMessage());
        	}
        	
			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: 메인 searchRate  ] *******************/");
			log.debug("/*************************************************************/");
            RateInVO rateInVO = new RateInVO();
            rateInVO.setBkg_no(bkg_no);
            rateInVO.setBl_no(bl_no);
            rateInVO.setAccount(account);
            rateOut = command.searchRate(rateInVO);

			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: manualSurchargePC  ] ****************/");
			log.debug("/*[메뉴얼로 Insert 하는 Charge 가 PRI에 Scope 및 CHG CODE 별로 등록 되어있는 항목 ]*/");
			log.debug("/*************************************************************/");
			List<ManualSurchargeVO> manualSurchargeVOs = null;
			List<ManualSurchargeVO> manualTaxCountrySurchargeVOs = null;
			List<RateMainInfoVO> rateMainInfoVO = rateOut.getRateMainInfoVOs();
			if(rateMainInfoVO.size() > 0){
				String application_date = rateMainInfoVO.get(0).getRtAplyDt();
				String svc_scp_cd ="";
				if(rateMainInfoVO.get(0).getBkgSvcScpCd() == null || rateMainInfoVO.get(0).getBkgSvcScpCd().length() == 0){
					eventResponse.setETCData("message", new ErrorHandler("BKG08136", new String[] { bkg_no }).getMessage());
				}else{
					if(rateMainInfoVO.get(0).getBkgSvcScpCd().length()>0){
						svc_scp_cd = rateMainInfoVO.get(0).getBkgSvcScpCd().substring(0,3);
					}
		            if(application_date.length()>0 && svc_scp_cd.length()>0){
		            	manualSurchargeVOs = bookingUtil.manualSurcharge(application_date, svc_scp_cd, null);
		            	manualTaxCountrySurchargeVOs = bookingUtil.manualTaxCountrySurcharge(application_date, svc_scp_cd, "VN");
		            }
				}
			}
			log.debug("/*************************************************************/");
			eventResponse.setETCData("oblIssFlg", bookingUtil.oblIssFlgCheck(bkg_no,rateOut.getCaflag()));

			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: 결과값 return  ] *********************/");
			log.debug("/*************************************************************/");
            eventResponse.setETCData("caflag", rateOut.getCaflag());
            eventResponse.setETCData("bdrflag", rateOut.getBdrflag());
            eventResponse.setETCData("rOfc_cd", rateOut.getROfc_cd());
        	eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
            
            String multiCgo = "";
            if(rateOut.getRateEtcInfo1VOs()!=null && rateOut.getRateEtcInfo1VOs().size()>0){
            	multiCgo = rateOut.getRateEtcInfo1VOs().get(0).getMultiCgo();
            }
            eventResponse.setETCData("multi_cgo", multiCgo);

            eventResponse.setRsVoList(rateOut.getRateMainInfoVOs());
            eventResponse.setRsVoList(rateOut.getBkgChgRateVOs());
            eventResponse.setRsVoList(rateOut.getRateEtcInfoVOs());
            eventResponse.setRsVoList(rateOut.getRateEtcInfo1VOs());
            eventResponse.setRsVoList(manualSurchargeVOs);
            /* Vol.difference */
            eventResponse.setRsVoList(rateOut.getRateCntrInfoVOs());
            eventResponse.setRsVoList(null);
            eventResponse.setRsVoList(manualTaxCountrySurchargeVOs);
            
//            log.debug("******** start exchange rate ***************");
            //retrieving exchange rate ( for TAX calculation )
//            List<ExchangeRateVO> xchList = bookingUtil.searchAllXchRate(bkg_no);
//            eventResponse.setRsVoList(xchList); 
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchRate SEARCH ]==========");
        return eventResponse;
    }


	/**
	 * EsmBkg1043Event retrieve event process<br>
	 * CntrRate retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchCntrRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchCntrRate SEARCH ]==========");
        EsmBkg1043Event event = (EsmBkg1043Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil bookingUtil = new BookingUtil();
        BlRatingBC rateCmd = new BlRatingBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        log.debug("=====> getBkgNo   : " + event.getBkgNo());
        log.debug("=====> getBlNo    : " + event.getBlNo());
        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException((String)new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

            CntrRtOutVO cntrRtOutVO = rateCmd.searchCntrRate(bkgBlNoVO.getBkgNo());

            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtVOs());
            eventResponse.setETCData(cntrRtOutVO.getCntrRtBkgInfoVO().getColumnValues());
            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtQtyVOs());
            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtAmtVOs());
            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtCustVOs());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchCntrRate SEARCH ]==========");
        return eventResponse;
    }

	/**
	 * EsmBkg1043Event management event process<br>
	 * CntrRate List management<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageCntrRate(Event e) throws EventException {
        // event.setCntrRtOutVO(cntrRtOutVO);
        log.debug("[START:: BlRatingSC == manageCntrRate SEARCH ]==========");
        EsmBkg1043Event event = (EsmBkg1043Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil bookingUtil = new BookingUtil();
        BlRatingBC rateCmd = new BlRatingBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        CntrRtOutVO cntrRtOutVO = event.getCntrRtOutVO();
        List<CntrRtVO> cntrRtVOs = cntrRtOutVO.getCntrRtVOs();

        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException((String)new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

            begin();
            rateCmd.manageCntrRate(cntrRtVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageCntrRate SEARCH ]==========");
        return eventResponse;
    }

    /**
     * Container Rate distribute
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse distributeCntrRate(Event e) throws EventException {
        // event.setCntrRtOutVO(cntrRtOutVO);
        log.debug("[START:: BlRatingSC == manageCntrRate SEARCH ]==========");
        EsmBkg1043Event event = (EsmBkg1043Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil bookingUtil = new BookingUtil();
        BlRatingBC rateCmd = new BlRatingBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException((String)new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            if("X".equals(bkgBlNoVO.getBkgStsCd())) {
                throw new EventException((String)new ErrorHandler("BKG00433", new String[]{event.getBkgNo()}).getMessage());
            }
            if("Y".equals(bkgBlNoVO.getCaFlg())) {
                throw new EventException((String)new ErrorHandler("BKG08036", new String[]{event.getBkgNo()}).getMessage());
            }
            
            begin();
            rateCmd.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageCntrRate SEARCH ]==========");
        return eventResponse;
    }
    
    
	/**
	 * EsmBkg1077Event retrieve event process<br>
	 * AppicationDate retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchAppicationDate(Event e) throws EventException {
    	log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.debug("[START:: Rating Application Date Search SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg1077Event event = (EsmBkg1077Event) e;
        List<SearchRatingApplyDateVO> list = null;
        
        String bkg_no = event.getBkgNo();
        String ca_flg = event.getCaFlg();
        
        try {
        	list = command.searchRatingApplyDate(bkg_no,ca_flg);
        	eventResponse.setRsVoList(list);
        	
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInform SEARCH ]==========");
        return eventResponse;
    }
    
	/**
	 * EsmBkg1084Event retrieve event process<br>
	 * RateTpbInfo List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchRateTpbInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1084Event event = (EsmBkg1084Event)e;
		BlRatingBC command = new BlRatingBCImpl();
		try{
			List<SearchTpbInfoVO> list = command.searchTpbInfo(event.getBkgNo(),
					                                     event.getNtcSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : Failed to retrieve.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * EsmBkg0704Event retrieve event process<br>
	 * DOC Adjustment List retrieve<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocAdjInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0704Event event = (EsmBkg0704Event)e;
		BlRatingBC command = new BlRatingBCImpl();
		try{
			List<DocLocVO> list = command.searchDocAdjInfo(event.getRateMainInfoVO(), event.getCaFlg());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : Failed to retrieve.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
		
	}
	
	/**
	 * EsmBkg0704Event save event process<br>
	 * DOC Adjustment manage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDocAdj(Event e) throws EventException {
		EsmBkg0704Event event = (EsmBkg0704Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();
        BookingUtil utilCmd = new BookingUtil();

        try {
            RateMainInfoVO rateMainInfoVO = event.getRateMainInfoVO();
            String caFlg = event.getCaFlg();
            
            BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
            bkgBlNoIN.setBkgNo(rateMainInfoVO.getBkgNo());
            bkgBlNoIN.setCaUsrId(account.getUsr_id());
    		
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());            
            
            begin();
            BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
            HistoryTableVO historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_0079_08", bkgBlNoVO);

            command.manageDocAdj(rateMainInfoVO, caFlg, account);

            bookingHistoryMgtBC.manageBookingHistory("ESM_BKG_0079_08", historyTableVO, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        return eventResponse;
	}
	
	/**
	 * EsmBkg0704Event location validation event process<br>
	 * POL/POD validation check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse validateDocLoc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0704Event event = (EsmBkg0704Event)e;
    	BookingUtil command = new BookingUtil();

		try{
			if(command.validateLoc(event.getRateMainInfoVO().getDocLocCd())){
				eventResponse.setETCData("doc_loc_flg", "Y");
			}else{
				eventResponse.setETCData("doc_loc_flg", "N");
			}
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : Failed to retrieve.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
		
	}
	
	
//	/**
//	 * EsmBkg007908Event Tax-retrieve event process<br>
//	 * Rate List retrieve(�엫�떆�궗�슜)<br>
//	 * @param e Event
//	 * @return response EventResponse
//	 * @exception EventException
// 	 */
//    private EventResponse searchRateTax(Event e) throws EventException {
//        log.debug("[START:: BlRatingSC == searchRateTax SEARCH01 ]==========");
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
////        BlRatingBC command 		= new BlRatingBCImpl();
//        ScOftAutoRatingBC command = new ScOftAutoRatingBCImpl();
//
//
//        EsmBkg007908Event event = (EsmBkg007908Event) e;
//        RateOutVO rateOut 		= null;
//        String bkg_no 			= event.getBkg_no();
//        String bl_no 			= event.getBl_no();
//        String svcScpCd			= "";
//        String rtAplyDt			= "";
//    	List<SearchScOftAutoratingListVO> inlist = new ArrayList<SearchScOftAutoratingListVO>();
//
//        try {
//        	log.debug("/*************************************************************/");
//        	log.debug("/********** [searchRate: bkg_no踰덊샇媛� �뾾�뒗寃쎌슦 :  bl_no濡� bkg_no媛��졇�삤湲�  ]/");
//        	log.debug("/*************************************************************/");
//			BookingUtil bookingUtil = new BookingUtil();
//        	if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
//			if(bkg_no.length() == 0 && !bl_no.equals("") ){
//				if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
//				bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);	
//			}
//        	
//			log.debug("/*************************************************************/");
//			log.debug("/********** [searchRate: bkg_no 議댁옱�쑀臾댄뙋�떒  1] ************/");
//			log.debug("/*************************************************************/");
//			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
//			bkgBlNo.setBkgNo(bkg_no);
//			bkgBlNo.setBlNo(bl_no);	
//			bkgBlNo.setCaUsrId(account.getUsr_id());
//			
//			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
//			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
//				throw new EventException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
//			}
//			
//			log.debug("/*************************************************************/");
//			log.debug("/********** [searchRate: bkg_no媛�  P �씪寃쎌슦 return 泥섎━  ] *******/");
//			log.debug("/*************************************************************/");
//        	String bkgStsCd = bookingUtil.searchBkgCgoTp(bkgBlNoVO);
//        	if (bkgStsCd.equals("P")) {
//        		throw new EventException(new ErrorHandler("BKG40030").getMessage());
//        	}
//        	
//        	
//        	inlist
//        	command.manageTaxSurcharge(inlist, bkg_no, svcScpCd, rtAplyDt);
//        	
//        	
//        	
////			log.debug("/*************************************************************/");
////			log.debug("/********** [searchRate: 硫붿씤 searchRate  ] *******************/");
////			log.debug("/*************************************************************/");
////            RateInVO rateInVO = new RateInVO();
////            rateInVO.setBkg_no(bkg_no);
////            rateInVO.setBl_no(bl_no);
////            rateInVO.setAccount(account);
////            rateOut = command.searchRate(rateInVO);
////
////			log.debug("/*************************************************************/");
////			log.debug("/********** [searchRate: manualSurchargePC  ] ****************/");
////			log.debug("/*[硫붾돱�뼹濡� Insert �븯�뒗 Charge 媛� PRI�뿉 Scope 諛� CHG CODE 蹂꾨줈 �벑濡� �릺�뼱�엳�뒗 �빆紐� ]*/");
////			log.debug("/*************************************************************/");
////			List<ManualSurchargeVO> manualSurchargeVOs = null;
////			List<RateMainInfoVO> rateMainInfoVO = rateOut.getRateMainInfoVOs();
////			if(rateMainInfoVO.size() > 0){
////				String application_date = rateMainInfoVO.get(0).getRtAplyDt();
////				String svc_scp_cd ="";
////				if(rateMainInfoVO.get(0).getBkgSvcScpCd() == null || rateMainInfoVO.get(0).getBkgSvcScpCd().length() == 0){
////					eventResponse.setETCData("message", new ErrorHandler("BKG08136", new String[] { bkg_no }).getMessage());
////				}else{
////					if(rateMainInfoVO.get(0).getBkgSvcScpCd().length()>0){
////						svc_scp_cd = rateMainInfoVO.get(0).getBkgSvcScpCd().substring(0,3);
////					}
////		            if(application_date.length()>0 && svc_scp_cd.length()>0){
////		            	manualSurchargeVOs = bookingUtil.manualSurcharge(application_date, svc_scp_cd, null);
////		            }
////				}
////			}
////			log.debug("/*************************************************************/");
////			eventResponse.setETCData("oblIssFlg", bookingUtil.oblIssFlgCheck(bkg_no,rateOut.getCaflag()));
////
////			log.debug("/*************************************************************/");
////			log.debug("/********** [searchRate: 寃곌낵媛� return  ] *********************/");
////			log.debug("/*************************************************************/");
////            eventResponse.setETCData("caflag", rateOut.getCaflag());
////            eventResponse.setETCData("bdrflag", rateOut.getBdrflag());
////            eventResponse.setETCData("rOfc_cd", rateOut.getROfc_cd());
////        	eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
////            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
////            
////            String multiCgo = "";//DG+RF �� 媛숈� 寃쎌슦 鍮� OFT row 瑜� 留뚮뱾吏� �븡湲� �쐞�븳 泥댄겕
////            if(rateOut.getRateEtcInfo1VOs()!=null && rateOut.getRateEtcInfo1VOs().size()>0){
////            	multiCgo = rateOut.getRateEtcInfo1VOs().get(0).getMultiCgo();
////            }
////            eventResponse.setETCData("multi_cgo", multiCgo);
////
////            eventResponse.setRsVoList(rateOut.getRateMainInfoVOs());
////            eventResponse.setRsVoList(rateOut.getBkgChgRateVOs());
////            eventResponse.setRsVoList(rateOut.getRateEtcInfoVOs());
////            eventResponse.setRsVoList(rateOut.getRateEtcInfo1VOs());
////            eventResponse.setRsVoList(manualSurchargeVOs);
////            /* Vol.difference */
////            eventResponse.setRsVoList(rateOut.getRateCntrInfoVOs());
////            
////            log.debug("******** start exchange rate ***************");
////            //retrieving exchange rate ( for TAX calculation )
////            List<ExchangeRateVO> xchList = bookingUtil.searchAllXchRate(bkg_no);
////            eventResponse.setRsVoList(xchList); 
//		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
//			throw ex;
//        } catch(Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
//        }
//        log.debug("[end:: BlRatingSC == searchRate SEARCH ]==========");
//        return eventResponse;
//    }	

}
