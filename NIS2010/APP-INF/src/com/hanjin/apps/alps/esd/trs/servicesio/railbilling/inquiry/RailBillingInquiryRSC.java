/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingInquiryRSC.java
*@FileTitle : Rail Billing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry;

import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.Constants;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.basic.RailBillingInquiryBC;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.basic.RailBillingInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0012Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0013Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0013EventResponse;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0021Event;
import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.basic.RailBillingCancelManageBC;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.basic.RailBillingCancelManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.event.RailBillingCancelEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author leebh
 * @see EventResponse,RailBillingInquiryDBDAO 참조
 * @since J2EE 1.4
 */
public class RailBillingInquiryRSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * ESD-TRS 업무 시나리오 선행작업<br>
     * RailBillingInquiry 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("RailBillingInquiryRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * ESD-TRS 업무 시나리오 마감작업<br>
     * RailBillingRequestCreation 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("RailBillingInquiryRSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        
        //log.debug("event : " + e);

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("ExpPap0012Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRailBillingInquiry(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("ExpPap0013Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = cancelRailBillingList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("ExpPap0021Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchRailBillingInquiryExcel(e);
        	}
	    }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Bill Order Inquiry 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRailBillingInquiry(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ExpPap0012Event event = (ExpPap0012Event)e;
        	RailBillingInquiryBC command = new RailBillingInquiryBCImpl();
            eventResponse = command.searchRailBillingInquiry(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Bill Order Inquiry Excel 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRailBillingInquiryExcel(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	
    	try {
    		ExpPap0021Event event = (ExpPap0021Event)e;
    		RailBillingInquiryBC command = new RailBillingInquiryBCImpl();
    		eventResponse = command.searchRailBillingInquiryExcel(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	return eventResponse;
    }
    
 
    /**
     * Rail Bill Order Cancel 화면에 대한 처리 이벤트 처리
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse cancelRailBillingList(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	RailBillingCancelManageBC command = null;
    	RailBillingCancelEvent piEvent = null;
    	
        try {
        	ExpPap0013Event event = (ExpPap0013Event)e;
        	
        	// PI Call
        	command = new RailBillingCancelManageBCImpl();
        	
        	piEvent = new RailBillingCancelEvent();
        	RailBillingInquiry[] railBillCancelList = event.getRailBillingInquiryList();
        	
    		String [] soOfcCtyCd = new String[railBillCancelList.length];
    		String [] soSeq      = new String[railBillCancelList.length];
    		String [] cxlRsn     = new String[railBillCancelList.length];
    		
    		String [] bil_iss_knt             = new String[railBillCancelList.length];
    		String [] spcl_instr_rmk          = new String[railBillCancelList.length];
    		String [] rail_ord_rjct_flg       = new String[railBillCancelList.length];
    		String [] wo_rjct_rsn             = new String[railBillCancelList.length];
    		String [] inter_rmk               = new String[railBillCancelList.length];
    		String [] fm_nod_cd               = new String[railBillCancelList.length];
    		String [] to_nod_cd               = new String[railBillCancelList.length];
    		String [] bl_no                   = new String[railBillCancelList.length];
//    		String [] bl_no_tp                = new String[railBillCancelList.length];
//    		String [] bl_no_chk               = new String[railBillCancelList.length];
    		String [] bkg_cgo_tp_cd           = new String[railBillCancelList.length];
    		String [] cop_no                  = new String[railBillCancelList.length];
    		String [] cost_act_grp_seq        = new String[railBillCancelList.length];
    		String [] repo_pln_id             = new String[railBillCancelList.length];
    		String [] pln_yrwk                = new String[railBillCancelList.length];
    		String [] ref_id                  = new String[railBillCancelList.length];
    		String [] ref_seq                 = new String[railBillCancelList.length];
    		String [] ib_flag                 = new String[railBillCancelList.length];
    		String [] trsp_rqst_bkg_flg       = new String[railBillCancelList.length];
    		
    		String [] cgo_tp_cd                 = new String[railBillCancelList.length];
    		String [] bkg_no                 	= new String[railBillCancelList.length];
//    		String [] bkg_no_split       		= new String[railBillCancelList.length];
    		String [] vndr_seq                 	= new String[railBillCancelList.length];
    		String [] eq_no                 	= new String[railBillCancelList.length];
    		String [] eq_tpsz_cd       			= new String[railBillCancelList.length];
    		String [] ofc_cd       				= new String[railBillCancelList.length];
    		
    		for(int i= 0; i < railBillCancelList.length; i++) {
    			soOfcCtyCd[i] = new String(railBillCancelList[i].getSo_ofc_city()); 
    			soSeq[i]      = new String(railBillCancelList[i].getSo_seq()); 
    			cxlRsn[i]     = new String(railBillCancelList[i].getCncl_req_rsn()); 
    			
    			bil_iss_knt      [i]     = new String(railBillCancelList[i].getBil_iss_knt      ()); 
    			spcl_instr_rmk   [i]     = new String(railBillCancelList[i].getSpcl_instr_rmk   ()); 
    			rail_ord_rjct_flg[i]     = new String(railBillCancelList[i].getRail_ord_rjct_flg()); 
    			wo_rjct_rsn      [i]     = new String(railBillCancelList[i].getWo_rjct_rsn      ()); 
    			inter_rmk        [i]     = new String(railBillCancelList[i].getInter_rmk        ()); 
    			fm_nod_cd        [i]     = new String(railBillCancelList[i].getFm_nod_cd        ()); 
    			to_nod_cd        [i]     = new String(railBillCancelList[i].getTo_nod_cd        ()); 
    			bl_no            [i]     = new String(railBillCancelList[i].getBl_no            ()); 
    			bkg_cgo_tp_cd    [i]     = new String(railBillCancelList[i].getBkg_cgo_tp_cd    ()); 
    			cop_no           [i]     = new String(railBillCancelList[i].getCop_no           ()); 
    			cost_act_grp_seq [i]     = new String(railBillCancelList[i].getCost_act_grp_seq ()); 
    			repo_pln_id      [i]     = new String(railBillCancelList[i].getRepo_pln_id      ()); 
    			pln_yrwk         [i]     = new String(railBillCancelList[i].getPln_yrwk         ()); 
    			ref_id           [i]     = new String(railBillCancelList[i].getRef_id           ()); 
    			ref_seq          [i]     = new String(railBillCancelList[i].getRef_seq          ()); 
    			ib_flag          [i]     = new String("U"); 
    			trsp_rqst_bkg_flg[i]     = new String("N");
    			cgo_tp_cd      [i]     = new String(railBillCancelList[i].getCgo_tp_cd     ()); 
        		bkg_no         [i]     = new String(railBillCancelList[i].getBkg_no        ()); 
        		vndr_seq       [i]     = event.getVender_cd(); 
        		eq_no          [i]     = new String(railBillCancelList[i].getCntr_no         ()); 
        		eq_tpsz_cd     [i]     = new String(railBillCancelList[i].getCntr_tpsz_cd    ());
        		ofc_cd		   [i]     = new String(railBillCancelList[i].getOfc_cd());
    		}
            piEvent.setTrsp_so_ofc_cty_cd(soOfcCtyCd);
    		piEvent.setTrsp_so_seq(soSeq);
    		piEvent.setCxl_rqst_rsn(cxlRsn);
    		piEvent.setBil_iss_knt     (bil_iss_knt     );
    		piEvent.setSpcl_instr_rmk  (spcl_instr_rmk  );
    		piEvent.setRail_ord_rjct_flg(rail_ord_rjct_flg);
    		piEvent.setWo_rjct_rsn     (wo_rjct_rsn     );
    		piEvent.setInter_rmk       (inter_rmk       );
    		piEvent.setFm_nod_cd       (fm_nod_cd       );
    		piEvent.setTo_nod_cd       (to_nod_cd       );
    		piEvent.setBl_no           (bl_no           );
    		piEvent.setBkg_cgo_tp_cd   (bkg_cgo_tp_cd   );
    		piEvent.setCop_no          (cop_no          );
    		piEvent.setCost_act_grp_seq(cost_act_grp_seq);
    		piEvent.setRepo_pln_id     (repo_pln_id     );
    		piEvent.setPln_yrwk        (pln_yrwk        );
    		piEvent.setRef_id          (ref_id          );
    		piEvent.setRef_seq         (ref_seq         );
    		piEvent.setOfc_cd          ("PHXSA"         );
    		piEvent.setUserID          ("SPP_IF"        );
    		piEvent.setIbflag          (ib_flag        	);
    		piEvent.setCgo_tp_cd		(cgo_tp_cd);
    		piEvent.setBkg_no			(bkg_no);
    		piEvent.setVndr_seq			(vndr_seq);
    		piEvent.setEq_no			(eq_no);
    		piEvent.setEq_tpsz_cd		(eq_tpsz_cd);
    		piEvent.setTrsp_rqst_bkg_flg(trsp_rqst_bkg_flg);
    		piEvent.setOfc_cd          (ofc_cd[0]       );
    		
    		
    		piEvent.setVendor_seq(event.getVender_cd());
    		
    		log.debug("piEvent.setOfc_cd	:	" +piEvent.getOfc_cd());
    		log.debug("piEvent.setVendor_seq	:	" +piEvent.getVendor_seq());
    		
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        
        try {
    		begin();
    		command.cancelRailBillingList(piEvent);
    		commit();
    		//rollback();
        } catch (EventException ee) {
        	rollback();
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	rollback();
        	log.error("err "+ex.toString(),ex);
        	throw new EventException("Cancel Process Call Error : Code[PI-99]");
        }
        
        
        try {
    		
    		eventResponse = new ExpPap0013EventResponse("SUCCESS");
    		
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	return eventResponse;
    }
}