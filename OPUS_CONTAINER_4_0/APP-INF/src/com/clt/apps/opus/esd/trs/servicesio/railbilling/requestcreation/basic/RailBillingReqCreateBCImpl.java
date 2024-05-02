/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingReqCreateBCImpl.java
*@FileTitle : RailBillingReqCreate Invoice
*Open Issues :
*Change history :
*2007-06-15 
*     수정자  : leebh
*     내   역  : 해당 Booking의 Container가 All Rail Billed 되어도 화면에 표시
*            
*@LastModifyDate : 2007-06-15
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================
History
2010.11.23 윤권영 [] 품질결함수정 - 객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다(railRampLocation객체) : 객체의 null 배정 대신 새로운 객체를 생성
2012.10.30 윤권영 [CHM-201220914]Rail billing verification 순서 변경
=========================================================*/


package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.basic;

import java.util.HashMap;
import java.util.Iterator;
 
import com.clt.apps.opus.esd.trs.servicesio.common.util.HashMapEnumeration;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
//import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.TraceLogger;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.BkgVerifyVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.BookingDetail;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.BookingSummary;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ContainerTypeSize;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0020Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0014Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0014EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0016Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0016EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0017Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0017EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.EmptyContainer;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0020EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.LocationDetail;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.RailBillErrorVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.RailRampLocation;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.Usa404EDISendVO;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration.RailBillingReqCreateDBDAO;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.basic.RailBillingVerifyManageBC;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.basic.RailBillingVerifyManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyEvent;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyEventResponse;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event.RailBillingVerifyList;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration.USA404EDIStatusInquiryDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS에 대한 비지니스 로직을 처리한다.<br> 
 * @author leebh
 * @see RailBillingReqCreateBCDAO 클래스 참조
 * @since J2EE 1.4
 */
public class RailBillingReqCreateBCImpl   extends BasicCommandSupport implements RailBillingReqCreateBC {

    // Database Access Object
    private transient RailBillingReqCreateDBDAO dbDao=null;
//    private TraceLogger trcLogger = null;
    

    /**
     * RailBillingReqCreateBCImpl 객체 생성<br>
     * RailBillingReqCreateBCDAO를 생성한다.<br>
     */
    public RailBillingReqCreateBCImpl(){
        dbDao = new RailBillingReqCreateDBDAO();
//        trcLogger = new TraceLogger("WRS");
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0010Event
     * @return EventResponse ExpPap010EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingReqCreateFull(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        ExpPap0010Event event = (ExpPap0010Event)e;
        ExpPap0010EventResponse eventResponse = null;
        
    	BkgVerifyVO bkgVrfyInfo = new BkgVerifyVO();
    	String rcv_dt_fm = "";
        boolean isPath = false;
        try {
        	BookingSummary bookingSummary = null;
        	BookingDetail[] bookingDetailList = null;
        	RailRampLocation[] railRampLocationList = null;
        	RailRampLocation railRampLocation = null;
        	
    		// Split Booking 인지 확인
        	// ToBe split Booking의 master booking도 RailBilling가능하도록 변경(COL요청)
//				String bkgSplitMsg = dbDao.searchBkgSplitMsg(event.getBkg_no());
//				if(!Constants.EMPTY.equals(bkgSplitMsg)) {
//					// Split 이 발생한 경우
//					throw new EventException(bkgSplitMsg); 
//				}
//				 log.debug("RailBillingReqCreateBCImpl searchRailBillingReqCreateFull bkgSplitMsg : "+ bkgSplitMsg + "\n");
        	
        	// All Rail Billed된 내역도 화면에 표시 하기 위해 추가
        	String allRailBilledStatus = Constants.NO;
        	
    		// TRS 에러 메시지 리스트  저장
    		Object[] result4 = dbDao.searchComErrMsgList();
    		HashMapEnumeration htErrCodeList = (HashMapEnumeration)result4[0];
    		
    		// Bkg 정보 조회
        	Object[] result1 = dbDao.searchBookingSummaryFull(event);
        	bookingSummary  = (BookingSummary)result1[0];
        	if(bookingSummary != null) {
        		if(!bkgVrfyInfo.isNoWrsFlag() && bookingSummary.getRrcv_dt_fm() != null && !bookingSummary.getRrcv_dt_fm().equals("")){
              		setBkgVrfyResult("TRS50110", htErrCodeList, bkgVrfyInfo);
              		rcv_dt_fm = bookingSummary.getRrcv_dt_fm();
        		}
        		
        		if(!bkgVrfyInfo.isNoWrsFlag() && bookingSummary.getRrcv_dt_to() != null && !bookingSummary.getRrcv_dt_to().equals("")){
        			setBkgVrfyResult("TRS50111", htErrCodeList, bkgVrfyInfo);
        		}
        		// Cntr List 조회
            	if(!bkgVrfyInfo.isNoWrsFlag()){
	        		Object[] result2 = dbDao.searchBookingDetailListFull(event);
		        	bookingDetailList  = (BookingDetail[])result2[0];
		        	allRailBilledStatus = (String)result2[1];
		        	
		        	if(allRailBilledStatus == null || Constants.EMPTY.equals(allRailBilledStatus)) {
		        		allRailBilledStatus = Constants.NO;
		        	}else if(Constants.YES.equals(allRailBilledStatus)) {
		        		// ORG/DEST Node 조회
		        		Object[] result90 = dbDao.searchRailRampLocationByAllBilledFull(event.getBkg_no());
		        		railRampLocation  = (RailRampLocation)result90[0];
		        	}
            	}
        	} 
        	
        	// IRG 기본 조회
        	if(!bkgVrfyInfo.isNoWrsFlag() && Constants.NO.equals(allRailBilledStatus) && bookingSummary != null && bookingDetailList != null && bookingDetailList.length > 0) {
        		Object[] result3 = dbDao.searchRailRampLocationFull(event);
        		railRampLocationList  = (RailRampLocation[])result3[0];
        	}
        	
        	// Bkg Verify 시작
        	// Bkg 정보가 존재 하지 않으면
        	if(!bkgVrfyInfo.isNoWrsFlag() && bookingSummary == null) {
        		setBkgVrfyResult("TRS00401", htErrCodeList, bkgVrfyInfo);
        	} else if(!bkgVrfyInfo.isNoWrsFlag() && Constants.NO.equals(allRailBilledStatus)){
        		// Booking 정보 Verification
        		
        		// Spec Cargo DG, AK, SC
        		if(!bkgVrfyInfo.isNoWrsFlag() && (Constants.SPEC_CARGO_DG.equals(bookingSummary.getDg()) || Constants.SPEC_CARGO_AK.equals(bookingSummary.getAk()) || Constants.SPEC_CARGO_SC.equals(bookingSummary.getSc()))) {
        			setBkgVrfyResult("TRS00018", htErrCodeList, bkgVrfyInfo);
        		}
        		
        		// Spec Cargo RF
        		if(!bkgVrfyInfo.isNoWrsFlag() && Constants.SPEC_CARGO_RF.equals(bookingSummary.getRf()))  {
        			setBkgVrfyResult("TRS00048", htErrCodeList, bkgVrfyInfo);
        		}

        		// Bkg Cancel
        		if(!bkgVrfyInfo.isNoWrsFlag() && Constants.BKG_STS_CXL.equals(bookingSummary.getStatus_cd())) {
        			setBkgVrfyResult("TRS00045", htErrCodeList, bkgVrfyInfo);	
        		}
        		
        		// Bkg Standby Status
        		if(!bkgVrfyInfo.isNoWrsFlag() && Constants.BKG_ALOC_STS_STBY.equals(bookingSummary.getAlocStsCd())) {
        			setBkgVrfyResult("TRS50116", htErrCodeList, bkgVrfyInfo);	
        		}
        		
        		// Bkg No Rate Status
        		if(!bkgVrfyInfo.isNoWrsFlag() && Constants.BKG_NO_RATE_STS.equals(bookingSummary.getNonRtStsCd())) {
        			setBkgVrfyResult("TRS50117", htErrCodeList, bkgVrfyInfo);	
        		}
        		
        		// Bkg Split
//        		if(!bkgVrfyInfo.isNoWrsFlag() && Constants.BKG_STS_SPLIT.equals(bookingSummary.getStatus_cd())) {
//        			setBkgVrfyResult("TRS00045", htErrCodeList, bkgVrfyInfo);
//        		}
        		
    			// Cntr List Verification
        		if(!bkgVrfyInfo.isNoWrsFlag()) {
	        		if(bookingDetailList == null) {
	        			setBkgVrfyResult("TRS00402", htErrCodeList, bkgVrfyInfo);
	        		} else {
	        			for(int i = 0; i < bookingDetailList.length; i++) {
	        				
	        				if(!"D2".equals(bookingDetailList[i].getCntr_tpsz_cd()) && !"D4".equals(bookingDetailList[i].getCntr_tpsz_cd()) &&
	        				   !"D5".equals(bookingDetailList[i].getCntr_tpsz_cd()) && !"D7".equals(bookingDetailList[i].getCntr_tpsz_cd())    
	        				   && !"CA".equals(bookingDetailList[i].getUs_region()) && !isPath
	        				) {
	        					log.debug("TRS00019   bookingDetailList[i].getCntr_tpsz_cd() : "+bookingDetailList[i].getCntr_tpsz_cd());
	        					log.debug("TRS00019   bookingDetailList[i].getUs_region() : "+bookingDetailList[i].getUs_region());
	        					log.debug("TRS00019   isPath : "+isPath);
	        					setBkgVrfyResult("TRS00019", htErrCodeList, bkgVrfyInfo);
	        					isPath = true;
	        				} else 
	        				if(!"D2".equals(bookingDetailList[i].getCntr_tpsz_cd()) && !"D4".equals(bookingDetailList[i].getCntr_tpsz_cd()) &&
	 	        				   !"D5".equals(bookingDetailList[i].getCntr_tpsz_cd()) && !"D7".equals(bookingDetailList[i].getCntr_tpsz_cd())    
	 	        				   /*&& !"R2".equals(bookingDetailList[i].getCntr_tpsz_cd()) && !"R4".equals(bookingDetailList[i].getCntr_tpsz_cd())
	 	        				   && !"R5".equals(bookingDetailList[i].getCntr_tpsz_cd())*/
		        				   && "CA".equals(bookingDetailList[i].getUs_region()) && !isPath
		        			) {
		        				setBkgVrfyResult("TRS00048", htErrCodeList, bkgVrfyInfo);
		        				isPath = true;
		        			}
	        			}
	        		}
        		}
	        		
    			// Location Verification
        		if(!bkgVrfyInfo.isNoWrsFlag()) {
	    			railRampLocation = new RailRampLocation();
	        		if(railRampLocationList == null || railRampLocationList.length <= 0) {
	        			setBkgVrfyResult("TRS00403", htErrCodeList, bkgVrfyInfo);
	        	// multi rail route validation 조직제거 (multi Rail Route 존재시 priority 높은 rail route		
				//	} else if(railRampLocationList.length > 1) {
				//		setBkgVrfyResult("TRS00033", htErrCodeList, bkgVrfyInfo);						
					} else {
						
                		// 화면에 보일 IRG 세팅(기본 IRG 세팅)
                		railRampLocation = railRampLocationList[0];
                		
		        		// IRG Auto Adjust 해야 하는지 확인 
		        		// Multi IRG가 아니면 처리
		        		if(!bkgVrfyInfo.isNoWrsFlag()) {
		        			// IRG NOWRS 처리 확인
		        			// Plan Nod로 IRG는 구했으나 prd_inland_rout_mst에 데이터 존재 하지 않는 경우 
							if(!bkgVrfyInfo.isNoWrsFlag() && (railRampLocationList[0].getRout_org_nod_cd() == null || Constants.EMPTY.equals(railRampLocationList[0].getRout_org_nod_cd()) ||
							                                  railRampLocationList[0].getRout_dest_nod_cd() == null || Constants.EMPTY.equals(railRampLocationList[0].getRout_dest_nod_cd())))
							{
								setBkgVrfyResult("TRS00042", htErrCodeList, bkgVrfyInfo);
							}
							
							// Block Vendor 
							if(!bkgVrfyInfo.isNoWrsFlag() && Constants.YES.equals(railRampLocationList[0].getBlock_vndr_flg())) {
								setBkgVrfyResult("TRS00017", htErrCodeList, bkgVrfyInfo);
							}
							
							// Bill Type Rule 11
							if(!bkgVrfyInfo.isNoWrsFlag() && Constants.YES.equals(railRampLocationList[0].getBill_type_flg())) {
								setBkgVrfyResult("TRS00017", htErrCodeList, bkgVrfyInfo);
							}
							
							// Embargo 
							if(!bkgVrfyInfo.isNoWrsFlag() && Constants.YES.equals(railRampLocationList[0].getEmbargo_flg())) {
								setBkgVrfyResult("TRS00022", htErrCodeList, bkgVrfyInfo);
							}
							
							// TOFC
							if(!bkgVrfyInfo.isNoWrsFlag() && Constants.YES.equals(railRampLocationList[0].getTofc_flg())) {
								setBkgVrfyResult("TRS00049", htErrCodeList, bkgVrfyInfo);
							}
							
							// MT Rout
							if(!bkgVrfyInfo.isNoWrsFlag() && Constants.PRD_MST_PCTL_IO_BND_CD_M.equals(railRampLocationList[0].getPctl_io_bnd_cd())) {
								// MT Rail Rout 이면
								setBkgVrfyResult("TRS00043", htErrCodeList, bkgVrfyInfo);
							}
		        			
							// NOWRS가 아니고 WRS Flag가 없고 IRG Auto Adjust 처리 가능한 건이면	
			        		if( !bkgVrfyInfo.isNoWrsFlag() && Constants.NO.equals(railRampLocationList[0].getWrs_full_flg()) ) {
			        			// IRG Auto Adjust 처리 가능한 건이면(SCE_COST_ACT_GRP.INV_BIL_PATT_DIV_FLG = N)
			        			if(Constants.NO.equals(railRampLocationList[0].getAuto_irg_flg())){
			        				Object[] result91 = dbDao.searchRailRampAutoAdjustLocationFull(event);
			                		railRampLocationList  = (RailRampLocation[])result91[0];
			                		
			    	        		if(railRampLocationList == null || railRampLocationList.length <= 0) {
			    	        			setBkgVrfyResult("TRS00404", htErrCodeList, bkgVrfyInfo);
			    					} else {
			                			result91 = dbDao.searchRailRampLocationByAutoAdjustFull(railRampLocationList[0].getRout_org_nod_cd(), railRampLocationList[0].getRout_dest_nod_cd(), railRampLocationList[0].getRout_seq());
				                		RailRampLocation rampInfo = (RailRampLocation)result91[0];
				                		if(rampInfo != null) {
					                		railRampLocationList[0].setOrg_loc_cd(rampInfo.getOrg_loc_cd());
					                		railRampLocationList[0].setOrg_loc_nm(rampInfo.getOrg_loc_nm());
					                		railRampLocationList[0].setOrg_yd_cd(rampInfo.getOrg_yd_cd());
					                		railRampLocationList[0].setOrg_yd_nm(rampInfo.getOrg_yd_nm());
					                		railRampLocationList[0].setOrg_yd_addr(rampInfo.getOrg_yd_addr());
					                		railRampLocationList[0].setDest_loc_cd(rampInfo.getDest_loc_cd());
					                		railRampLocationList[0].setDest_loc_nm(rampInfo.getDest_loc_nm());
					                		railRampLocationList[0].setDest_yd_cd(rampInfo.getDest_yd_cd());
					                		railRampLocationList[0].setDest_yd_nm(rampInfo.getDest_yd_nm());
					                		railRampLocationList[0].setDest_yd_addr(rampInfo.getDest_yd_addr());
					                		
					                		// 화면에 보일 IRG 세팅 (Auto IRG Adjust 세팅)
					                		railRampLocation = railRampLocationList[0];
				                		} else {
				                			setBkgVrfyResult("TRS00405", htErrCodeList, bkgVrfyInfo);
				                		}
			                		}
			        			} else {
			        				// IRG Auto Adjust 처리 가능한 건이 아니면 (SCE_COST_ACT_GRP.INV_BIL_PATT_DIV_FLG = Y)
			        				setBkgVrfyResult("TRS00017", htErrCodeList, bkgVrfyInfo);
			        			}
			        		}
		        		}						
					}
        		}
        		
    			// Rail Bulk Flag 확인 
    			if(!bkgVrfyInfo.isNoWrsFlag() &&
    				 ( 
    				    (Constants.YES.equals(railRampLocationList[0].getRail_bulk_vndr_flg()) && Constants.SPEC_CARGO_RB.equals(bookingSummary.getRb())) || 
    				    (Constants.YES.equals(railRampLocationList[0].getRail_bulk_vndr_flg()) && Constants.SPEC_CARGO_RB.equals(bookingSummary.getBkg_cmdt_cd()))||
    				    (Constants.YES.equals(railRampLocationList[0].getRail_ns_vndr_flg()) && Constants.SPEC_CARGO_RB.equals(bookingSummary.getRb()) && 
      				     (("USCMH".equals(railRampLocationList[0].getOrg_loc_cd())|| "USCLE".equals(railRampLocationList[0].getOrg_loc_cd())|| "USCVG".equals(railRampLocationList[0].getOrg_loc_cd()))&& "USORF".equals(railRampLocationList[0].getDest_loc_cd()))) 
    				  )  
    			   )  
    			{
    				log.debug("Rail Bulk TRS50101 bookingSummary.getSpcl_cust_flg() : "+bookingSummary.getSpcl_cust_flg());
    				log.debug("Rail Bulk TRS50101 railRampLocationList[0].getRail_ns_vndr_flg() : "+railRampLocationList[0].getRail_ns_vndr_flg());
    				log.debug("Rail Bulk TRS50101 bookingSummary.getRb() : "+bookingSummary.getRb());
    				log.debug("Rail Bulk TRS50101 railRampLocationList[0].getOrg_loc_cd() : "+railRampLocationList[0].getOrg_loc_cd());
    				log.debug("Rail Bulk TRS50101 railRampLocationList[0].getDest_loc_cd() : "+railRampLocationList[0].getDest_loc_cd());
    				setBkgVrfyResult("TRS50101", htErrCodeList, bkgVrfyInfo);
    			}
    			
    			
        		// Spec Cargo BB, RD, HD
        		if(!bkgVrfyInfo.isNoWrsFlag() &&
        		  (Constants.YES.equals(railRampLocationList[0].getRail_bulk_vndr_flg()) && (   Constants.SPEC_CARGO_BB.equals(bookingSummary.getBb()) 
        				                                                                     || Constants.SPEC_CARGO_RD.equals(bookingSummary.getRd()) 
        				                                                                     || Constants.SPEC_CARGO_HD.equals(bookingSummary.getHd())
        				                                                                     || Constants.SPEC_CARGO_RD.equals(bookingSummary.getBkg_cmdt_cd())
        				                                                                     || Constants.SPEC_CARGO_HD.equals(bookingSummary.getBkg_cmdt_cd())
        				                                                                     ) 
        		   ) ) {
        			setBkgVrfyResult("TRS00020", htErrCodeList, bkgVrfyInfo);
        		} 
        		
        			
        	}
        	
        	// Stop Off
    		if(!bkgVrfyInfo.isNoWrsFlag() && bookingSummary != null && Constants.YES.equals(bookingSummary.getStop_off_ind())) {
    			setBkgVrfyResult("TRS00016", htErrCodeList, bkgVrfyInfo);
    		}
        	
        	if(bkgVrfyInfo.getBkgVrfyErrCd() != null && !Constants.EMPTY.equals(bkgVrfyInfo.getBkgVrfyErrCd())) {
        		
        		// NOWRS가 존재한경우 해당 Error 코드 값 세팅
        		if(bkgVrfyInfo.isNoWrsFlag()) {
        			bkgVrfyInfo.setBkgVrfyErrCd(bkgVrfyInfo.getNoWrsErrCode());
        		}
        		
        		RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(bkgVrfyInfo.getBkgVrfyErrCd() + bkgVrfyInfo.getBkgVrfyErrLangTpCd());
				
         		errVO = (RailBillErrorVO)htErrCodeList.get(bkgVrfyInfo.getBkgVrfyErrCd() + bkgVrfyInfo.getBkgVrfyErrLangTpCd());
				if(errVO != null) {
					if(Constants.VRFY_TYPE_NOGOOD.equals(errVO.getErr_tp_cd())) {
						bkgVrfyInfo.setBkgVrfyRstCd(Constants.VRFY_NOGOOD);
					} else if(Constants.VRFY_TYPE_NOWRS.equals(errVO.getErr_tp_cd())) {
						bkgVrfyInfo.setBkgVrfyRstCd(Constants.VRFY_NOWRS);
					} else if(Constants.VRFY_TYPE_NOBILLING.equals(errVO.getErr_tp_cd())) {
						bkgVrfyInfo.setBkgVrfyRstCd(Constants.VRFY_NOBILLING);
					} else {
						throw new EventException("Booking Verify Process Error : Verify type is incorrect."); // Verify Type이 (E, W)가 아닌경우
					}
					bkgVrfyInfo.setBkgVrfyErrMsg(errVO.getErr_msg());
        			if(bkgVrfyInfo.getBkgVrfyErrCd().equals("TRS50110")){
        				bkgVrfyInfo.setBkgVrfyErrMsg(bkgVrfyInfo.getBkgVrfyErrMsg().replaceAll("YYYY-MM-DD",rcv_dt_fm));
        			}
				} else {
					throw new EventException("Booking Verify Process Error : Verify message code is incorrect."); // DB에 메시지가 없는 경우
				}
        	}
        	
        	if(bookingSummary != null && bookingDetailList != null && bkgVrfyInfo != null){
	        	eventResponse = new ExpPap0010EventResponse(	bkgVrfyInfo.getBkgVrfyRstCd(),
	            												bkgVrfyInfo.getBkgVrfyErrCd(),
	            												bkgVrfyInfo.getBkgVrfyErrLangTpCd(),
	            												StringEscapeUtils.unescapeXml(bkgVrfyInfo.getBkgVrfyErrMsg()),
	            												bookingSummary,
											            		bookingDetailList,
											            		railRampLocation,
	            												"SUCCESS");
	            
	            // Bkg Verify 정보 로그 
	            dbDao.wrsFullBkgVerifyResultLog(event, eventResponse);
        	}else{
        		eventResponse = new ExpPap0010EventResponse(	bkgVrfyInfo.getBkgVrfyRstCd(),
																bkgVrfyInfo.getBkgVrfyErrCd(),
																bkgVrfyInfo.getBkgVrfyErrLangTpCd(),
																StringEscapeUtils.unescapeXml(bkgVrfyInfo.getBkgVrfyErrMsg()),
																bookingSummary,
											            		bookingDetailList,
											            		railRampLocation,
																"FAIL");
        	}
            
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
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
     * setBkgVrfyResult
     * @param inputErrCd
     * @param htErrCodeList
     * @param bkgVrfyInfo
     * @throws EventException
     */
    public void setBkgVrfyResult(String inputErrCd, HashMapEnumeration htErrCodeList, BkgVerifyVO bkgVrfyInfo) throws EventException {
    	bkgVrfyInfo.setBkgVrfyErrCd(inputErrCd);
		if(getBkgVerify(bkgVrfyInfo.getBkgVrfyErrCd(), bkgVrfyInfo.getBkgVrfyErrLangTpCd(), htErrCodeList)) {
			bkgVrfyInfo.setNoWrsFlag(true);
			bkgVrfyInfo.setNoWrsErrCode(bkgVrfyInfo.getBkgVrfyErrCd());
		}
    }
    
    /**
     * getBkgVerify
     * @param bkgVrfyErrCd
     * @param bkgVrfyErrLangTpCd
     * @param htErrCodeList
     * @return
     * @throws EventException
     */
    public boolean getBkgVerify(String bkgVrfyErrCd, String bkgVrfyErrLangTpCd, HashMapEnumeration htErrCodeList) throws EventException {
    	boolean result = false;
    	
		RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(bkgVrfyErrCd + bkgVrfyErrLangTpCd);
		if(errVO != null) {
			result = Constants.VRFY_TYPE_NOWRS.equals(errVO.getErr_tp_cd())||Constants.VRFY_TYPE_NOBILLING.equals(errVO.getErr_tp_cd());
		}
		
		return result;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Request(Excel) 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap020Event
     * @return EventResponse ExpPap0020EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingReqCreateExcelFull(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	ExpPap0020Event event = (ExpPap0020Event)e;
    	ExpPap0020EventResponse eventResponse = null;
    	
    	try {
    		Object[] result1 = dbDao.searchTrsRailOrderListFull(event);
    		BookingDetail[] bookingDetailList  = (BookingDetail[])result1[0];
    		
    		eventResponse = new ExpPap0020EventResponse(	
    									bookingDetailList,
    									"SUCCESS");
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Verify Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0014Event
     * @return EventResponse ExpPap0014EventResponse
     * @exception EventException
     */
    public EventResponse verifyRailBillingReqCreateFull(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	ExpPap0014Event event = (ExpPap0014Event)e;
    	ExpPap0014EventResponse eventResponse = null;
    	
    	try {
    		BookingDetail[] bookingDetailList = null;

        	// Verify 요청 및 결과 세팅
        	bookingDetailList = getVerifyResultListFull(Constants.VRFY_PROC_REQ, event, event.getBookingDetailList());
    		
        	eventResponse = new ExpPap0014EventResponse(bookingDetailList,"SUCCESS");
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
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
     * getVerifyResultListFull
     * @param procFlag
     * @param e
     * @param bookingDetailList
     * @return
     * @throws Exception
     */
    public BookingDetail[] getVerifyResultListFull(String procFlag, Event e, BookingDetail[] bookingDetailList) throws Exception {
    	ExpPap0014Event event014 = null;
    	ExpPap0015Event event015 = null;
    	String userId = "";
    	String bkgNo  = "";
    	String orgYdCd = "";
    	String destYdCd = "";
    	String bkgVrfyRstCd = "";
    	String bkgVrfyRsnCd = "";
    	String bkgVrfyLangTpCd = "";
    	String vndrSeq  = "";
    	
    	RailBillingVerifyManageBC piVrfyBC = null;
    	RailBillingVerifyEvent vfEvent = null;
    	RailBillingVerifyEventResponse vfEvtRes = null;
    	
//    	trcLogger.masterBegin("Full getVerifyResultListFull");
    	
    	try {
        	if(Constants.VRFY_PROC_REQ.equals(procFlag)) {
        		event014        = (ExpPap0014Event)e;
        		userId          = event014.getUser_id();
        		bkgNo           = event014.getBkg_no();
        		orgYdCd         = event014.getOrg_yd_cd();
        		destYdCd        = event014.getDest_yd_cd();
        		bkgVrfyRstCd    = event014.getBkg_vrfy_rst_cd();
        		bkgVrfyRsnCd    = event014.getBkg_vrfy_err_cd();
        		bkgVrfyLangTpCd = event014.getBkg_vrfy_err_lang_tp_cd();
        		vndrSeq			= event014.getVender_cd();
        	} else if(Constants.VRFY_PROC_RE_REQ.equals(procFlag)) {
        		event015 = (ExpPap0015Event)e;
        		userId          = event015.getUser_id();
        		bkgNo           = event015.getBkg_no();
        		orgYdCd         = event015.getRailRampLocation().getOrg_yd_cd();
        		destYdCd        = event015.getRailRampLocation().getDest_yd_cd();
        		bkgVrfyRstCd    = event015.getBkg_vrfy_rst_cd();
        		bkgVrfyRsnCd    = event015.getBkg_vrfy_err_cd();
        		bkgVrfyLangTpCd = event015.getBkg_vrfy_err_lang_tp_cd();
        		vndrSeq			= event015.getVender_cd();
        	} else {
        		throw new EventException("No define process.");	
        	}
        	
    		RailBillingVerifyList[] railBillingVerifyList = new RailBillingVerifyList[bookingDetailList.length];
    		
    		for(int i=0; i<bookingDetailList.length; i++) {
    			RailBillingVerifyList railBillingVerifyInfo = new RailBillingVerifyList();
    			railBillingVerifyInfo.setEq_no(bookingDetailList[i].getCntr_no());
    			railBillingVerifyInfo.setEq_tpsz_cd(bookingDetailList[i].getCntr_tpsz_cd());
    			railBillingVerifyInfo.setBlk_flg(bookingDetailList[i].getBulk());
    			railBillingVerifyInfo.setStl_wire_flg(bookingDetailList[i].getSteelwire());
    			railBillingVerifyInfo.setCoil_shp_flg(bookingDetailList[i].getCoil_shipment());
    			railBillingVerifyInfo.setFmgt_flg(bookingDetailList[i].getFumigation());
    			railBillingVerifyInfo.setPiece(bookingDetailList[i].getPiece());
    			railBillingVerifyInfo.setWeight(bookingDetailList[i].getWeight());
    			railBillingVerifyInfo.setVndr_seq(vndrSeq);

    			log.debug("railBillingVerifyInfo.getEq_no()    	:	"+railBillingVerifyInfo.getEq_no()    			+"\n");
    			log.debug("railBillingVerifyInfo.getEq_tpsz_cd()	:       "+railBillingVerifyInfo.getEq_tpsz_cd()                 +"\n");
    			log.debug("railBillingVerifyInfo.getBlk_flg()          :	"+railBillingVerifyInfo.getBlk_flg()                    +"\n");
    			log.debug("railBillingVerifyInfo.getStl_wire_flg()     :	"+railBillingVerifyInfo.getStl_wire_flg()               +"\n");
    			log.debug("railBillingVerifyInfo.getCoil_shp_flg()     :	"+railBillingVerifyInfo.getCoil_shp_flg()               +"\n");
    			log.debug("railBillingVerifyInfo.getFmgt_flg()         :	"+railBillingVerifyInfo.getFmgt_flg()                   +"\n");
    			log.debug("railBillingVerifyInfo.getPiece()            :	"+railBillingVerifyInfo.getPiece()                      +"\n");
    			log.debug("railBillingVerifyInfo.getWeight()           :	"+railBillingVerifyInfo.getWeight()                     +"\n");
    			log.debug("railBillingVerifyInfo.getVndr_seq()         :	"+railBillingVerifyInfo.getVndr_seq()                   +"\n");
    			log.debug("railBillingVerifyInfo.getCop_no()         :	"+railBillingVerifyInfo.getCop_no()                   +"\n");
    			log.debug("railBillingVerifyInfo.getCost_act_grp_seq()         :	"+railBillingVerifyInfo.getCost_act_grp_seq()                   +"\n");
    			
    			railBillingVerifyList[i] = railBillingVerifyInfo;
   		}
				log.debug("userId	:	"+userId+"\n");    		
				log.debug("Constants.CARGO_TYPE_FULL	:	"+Constants.CARGO_TYPE_FULL+"\n");    		
				log.debug("bkgNo	:	"+bkgNo+"\n");    		
				log.debug("orgYdCd	:	"+orgYdCd+"\n");    		
				log.debug("bkgVrfyRstCd	:	"+bkgVrfyRstCd+"\n");    		
				log.debug("bkgVrfyRsnCd	:	"+bkgVrfyRsnCd+"\n");    		
				log.debug("bkgVrfyLangTpCd	:	"+bkgVrfyLangTpCd+"\n");    		
				log.debug("destYdCd	:	"+destYdCd+"\n");    		
    		// Verify 요청 Event
    		vfEvent = new RailBillingVerifyEvent(
    				userId,
    				Constants.CARGO_TYPE_FULL,
    				bkgNo,
    				orgYdCd,
    				bkgVrfyRstCd,
    				bkgVrfyRsnCd,
    				bkgVrfyLangTpCd,
    				destYdCd,
    				railBillingVerifyList
    				);

        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	
    	try {
    		// Verify 요청
//    		trcLogger.detailBegin("Full TRS Call Verify");
    		piVrfyBC = new RailBillingVerifyManageBCImpl();
     		vfEvtRes = (RailBillingVerifyEventResponse)piVrfyBC.verifyRailBillingCNTRList(vfEvent);
//    		trcLogger.detailEnd();
 /*       } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
 */       } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException("Verify Process Call Error : Code[PI-01]");
        }

    	
    	try {
   		
    		if(!Constants.PROC_SUCCESS.equals(vfEvtRes.getIsSuccessFlag())  ) {
    			throw new EventException("Verify Process Call Error : Code[PI-02]");
    		}
    		
    		// TRS 에러 메시지 리스트  저장
    		Object[] result1 = dbDao.searchComErrMsgList();
    		HashMapEnumeration htErrCodeList = (HashMapEnumeration)result1[0];
    		
    		String vrfyRstCd = "";
    		String errCodeKey = "";
    		HashMapEnumeration htVrfyList = new HashMapEnumeration();
    		Iterator itr = vfEvtRes.getModels().iterator();
			
			while (itr != null && itr.hasNext()) {
				
				RailBillingVerifyList vrfyInfo = (RailBillingVerifyList)itr.next();
//    			log.debug("TRS Result vrfyInfo.getEq_no()    	:	"+vrfyInfo.getEq_no()    			+"\n");
//    			log.debug("TRS Result vrfyInfo.getEq_tpsz_cd()	:       "+vrfyInfo.getEq_tpsz_cd()                 +"\n");
//    			log.debug("TRS Result vrfyInfo.getBlk_flg()          :	"+vrfyInfo.getBlk_flg()                    +"\n");
//    			log.debug("TRS Result vrfyInfo.getStl_wire_flg()     :	"+vrfyInfo.getStl_wire_flg()               +"\n");
//    			log.debug("TRS Result vrfyInfo.getCoil_shp_flg()     :	"+vrfyInfo.getCoil_shp_flg()               +"\n");
//    			log.debug("TRS Result vrfyInfo.getFmgt_flg()         :	"+vrfyInfo.getFmgt_flg()                   +"\n");
//    			log.debug("TRS Result vrfyInfo.getPiece()            :	"+vrfyInfo.getPiece()                      +"\n");
//    			log.debug("TRS Result vrfyInfo.getWeight()           :	"+vrfyInfo.getWeight()                     +"\n");
//    			log.debug("TRS Result vrfyInfo.getVndr_seq()         :	"+vrfyInfo.getVndr_seq()                   +"\n");
//    			log.debug("TRS Result vrfyInfo.getCop_no()         :	"+vrfyInfo.getCop_no()                   +"\n");
//    			log.debug("TRS Result vrfyInfo.getCost_act_grp_seq()         :	"+vrfyInfo.getCost_act_grp_seq()                   +"\n");
//    			log.debug("TRS Result vrfyInfo.getPctlNo()         :	"+vrfyInfo.getPctlNo()                   +"\n");
 
				if(vrfyInfo.getEq_no() == null) {
					throw new EventException("Verify Process Call Error : Code[PI-03]");
				}
    			log.debug("TRS Result vrfyInfo.getErr_msg_cd()         :	"+vrfyInfo.getErr_msg_cd()                   +"\n");
				
				// Good 인지 확인
				vrfyRstCd = (vrfyInfo.getErr_msg_cd() == null || Constants.EMPTY.equals(vrfyInfo.getErr_msg_cd())) ? Constants.VRFY_GOOD : "";
    			log.debug("Good 인지 확인 vrfyRstCd         :	"+vrfyRstCd                   +"\n");
				
				if(Constants.EMPTY.equals(vrfyRstCd)) {
					errCodeKey = vrfyInfo.getErr_msg_cd()+vrfyInfo.getLang_tp_cd();
	    			log.debug(" vrfyInfo.getLang_tp_cd()         :	"+vrfyInfo.getLang_tp_cd()                   +"\n");
	    			log.debug("errCodeKey         :	"+errCodeKey                   +"\n");
	    			log.debug("htErrCodeList.size         :	"+htErrCodeList.size()                  +"\n");

	    			log.debug("htErrCodeList.get(errCodeKey)         :	"+htErrCodeList.get(errCodeKey)                  +"\n");
					RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(errCodeKey);
					
	    			log.debug("errVO  getErr_tp_cd/getErr_msg_cd/getErr_msg       :	"+errVO.getErr_tp_cd() +"/"+errVO.getErr_msg_cd() + "/"+ errVO.getErr_msg()                  +"\n");
					if(errVO != null) {
    					if(Constants.VRFY_TYPE_NOGOOD.equals(errVO.getErr_tp_cd())) {
    						vrfyRstCd = Constants.VRFY_NOGOOD;
    					} else if(Constants.VRFY_TYPE_NOWRS.equals(errVO.getErr_tp_cd())) {
    						vrfyRstCd = Constants.VRFY_NOWRS;
    					} else if(Constants.VRFY_TYPE_NOBILLING.equals(errVO.getErr_tp_cd())) {
    						vrfyRstCd = Constants.VRFY_NOBILLING;
    					} else {
    						throw new EventException("Verify Process Call Error : Code[PI-07]"); // Verify Type이 (E, W)가 아닌경우
    					}
					} else {
						throw new EventException("Verify Process Call Error : Code[PI-08]"); // 에러코드 데이블에 해당 에러코드가 없는 경우
					}
				}
    			log.debug(" vrfyRstCd   2222      :	"+vrfyRstCd                   +"\n");

				if(Constants.VRFY_GOOD.equals(vrfyRstCd) || Constants.VRFY_NOGOOD.equals(vrfyRstCd)) {
					if( vrfyInfo.getCop_no() == null || Constants.EMPTY.equals(vrfyInfo.getCop_no()) ||
						vrfyInfo.getCost_act_grp_seq() == null || Constants.EMPTY.equals(vrfyInfo.getCost_act_grp_seq()) ) {
						
						throw new EventException("Verify Process Call Error : Code[PI-04]");
					}
					
				}
				
				if(Constants.VRFY_NOGOOD.equals(vrfyRstCd) || Constants.VRFY_NOWRS.equals(vrfyRstCd)
						 || Constants.VRFY_NOBILLING.equals(vrfyRstCd)) {
					if( vrfyInfo.getErr_msg_cd() == null || Constants.EMPTY.equals(vrfyInfo.getErr_msg_cd()) ||
				        vrfyInfo.getLang_tp_cd() == null || Constants.EMPTY.equals(vrfyInfo.getLang_tp_cd()) ) {
						
						throw new EventException("Verify Process Call Error : Code[PI-05]");
					}
				}
				
				htVrfyList.put(vrfyInfo.getEq_no(), vrfyInfo);
			}
			
			log.debug("htVrfyList.size         :	"+htVrfyList.size()                   +"\n");
			for(int i=0; i<bookingDetailList.length; i++) {
				// Verify 결과 세팅
				RailBillingVerifyList vrfyInfo = (RailBillingVerifyList)htVrfyList.get(bookingDetailList[i].getCntr_no());
				(bookingDetailList[i]).setVrfy_rst_cd("");
				(bookingDetailList[i]).setVrfy_rst_msg("");
    			(bookingDetailList[i]).setVrfy_rsn_cd("");
    			(bookingDetailList[i]).setVrfy_rsn_msg("");
    			(bookingDetailList[i]).setVrfy_lang_tp_cd("");
						
				if(vrfyInfo != null) {
	    			(bookingDetailList[i]).setCop_no(vrfyInfo.getCop_no());
	    			(bookingDetailList[i]).setCost_act_grp_seq(vrfyInfo.getCost_act_grp_seq());
	    			(bookingDetailList[i]).setPctl_no(vrfyInfo.getPctlNo());
	    			(bookingDetailList[i]).setTare_wgt(vrfyInfo.getTare_wgt());
//	    			(bookingDetailList[i]).setVgm_wgt(Integer.toString(Integer.parseInt(vrfyInfo.getTare_wgt())+Integer.parseInt(vrfyInfo.getWeight())));
	    			// Good 확인
	    			vrfyRstCd = (vrfyInfo.getErr_msg_cd() == null || Constants.EMPTY.equals(vrfyInfo.getErr_msg_cd())) ? Constants.VRFY_GOOD : "";
	    			
	    			if(Constants.VRFY_GOOD.equals(vrfyRstCd)) {
	    				
/*	    		    Fm:"Tae-Woo LEE" <twlee@cyberlogitec.com> 
	    			Re: Full Rail Billing - Verify Result 변경 요청
	    			 
	    			1. 미주지역 요청에 따라서 다음 표와 같이 Verify Result 변경 바랍니다.
	    			    1. Good -> No Good : 운송 담당자가 직접 eNIS에서 확인, Rail Billing 처리 
	    			    2. No Good -> No Good : 변경 없음 
	    			    3. No WRS -> No WRS : 변경 없음 
	    			2. 사용자 테스트 후, 
	    			   안정적으로 Full Rail Billing을 사용할 수 있는 시기에 현재와 같이 Good으로 처리 예정 입니다.*/
                    
	    				// 정상소스 
	    				(bookingDetailList[i]).setVrfy_rst_cd(Constants.VRFY_GOOD);
	    				(bookingDetailList[i]).setVrfy_rst_msg(Constants.VRFY_GOOD_NM);
    	    			(bookingDetailList[i]).setVrfy_rsn_msg(Constants.VRFY_GOOD_NM);
    	    			(bookingDetailList[i]).setVrfy_lang_tp_cd("");
    	    			
//    	    			(bookingDetailList[i]).setVrfy_rst_cd(Constants.VRFY_NOGOOD);
//    	    			(bookingDetailList[i]).setVrfy_rst_msg(Constants.VRFY_NOGOOD_NM);
//    	    			String errMsg_cd = "TRS00046";
//    	    			String langTpCd  = "ENG";
//    	    			errCodeKey = errMsg_cd + langTpCd;
//    	    			RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(errCodeKey);
//    	    			(bookingDetailList[i]).setVrfy_rsn_cd(errMsg_cd);
//    	    			(bookingDetailList[i]).setVrfy_rsn_msg(errVO.getErr_msg());
//    	    			(bookingDetailList[i]).setVrfy_lang_tp_cd(langTpCd);
    	    			
	    			} else {
	    				// 에러 메시지 세팅
	    				errCodeKey = vrfyInfo.getErr_msg_cd()+vrfyInfo.getLang_tp_cd();
	    				RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(errCodeKey);
	    				
	    				if(errVO != null) {
	    					if(Constants.VRFY_TYPE_NOGOOD.equals(errVO.getErr_tp_cd())) {
	    	    				(bookingDetailList[i]).setVrfy_rst_cd(Constants.VRFY_NOGOOD);
	    	    				(bookingDetailList[i]).setVrfy_rst_msg(Constants.VRFY_NOGOOD_NM);
	    					} else if(Constants.VRFY_TYPE_NOWRS.equals(errVO.getErr_tp_cd())) {
	    	    				(bookingDetailList[i]).setVrfy_rst_cd(Constants.VRFY_NOWRS);
	    	    				(bookingDetailList[i]).setVrfy_rst_msg(Constants.VRFY_NOWRS_NM);
	    					} else if(Constants.VRFY_TYPE_NOBILLING.equals(errVO.getErr_tp_cd())) {
	    	    				(bookingDetailList[i]).setVrfy_rst_cd(Constants.VRFY_NOBILLING);
	    	    				(bookingDetailList[i]).setVrfy_rst_msg(Constants.VRFY_NOBILLING_NM);
	    					} else {
	    						throw new EventException("Verify Process Call Error : Code[PI-06]"); // Verify Type이 (E, W)가 아닌경우
	    					}
	    					
	    	    			(bookingDetailList[i]).setVrfy_rsn_cd(vrfyInfo.getErr_msg_cd());
	    	    			(bookingDetailList[i]).setVrfy_rsn_msg(errVO.getErr_msg());
	    	    			(bookingDetailList[i]).setVrfy_lang_tp_cd(vrfyInfo.getLang_tp_cd());
	    	    			
	    	    			if(vrfyInfo.getErr_msg_cd().equals("TRS50110"))
	    	    				(bookingDetailList[i]).setVrfy_rsn_msg(vrfyInfo.getErr_msg());
	    	    			
	    	    		} else {
	    					throw new EventException("Verify Process Call Error : Code[PI-07]"); // 에러코드 데이블에 해당 에러코드가 없는 경우
	    				}
	    			}
				} else {
					throw new EventException("Verify Process Call Error : Code[PI-08]"); // 요청 리스트갯수와 결과 리스트 갯수가 다른경우
				}
			}
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }

//       trcLogger.masterEnd(TraceLogger.LIMIT_05);
        
        // Cntr Verify 정보  Log
//        dbDao.wrsFullCntrVerifyResultLog(bkgNo, procFlag, bookingDetailList);
        
    	return bookingDetailList;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Full Cntr Creation Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap015Event
     * @return EventResponse ExpPap015EventResponse
     * @exception EventException
     */
    public EventResponse insertRailBillingReqCreateFull(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	ExpPap0015Event event = (ExpPap0015Event)e;
    	ExpPap0015EventResponse eventResponse = null;
    	boolean isSuccessful = false; 
    	String  resultStr = "FAIL"; 
    	
    	try {
    		// 업무처리
    		
    		// Verify 요청 및 결과 세팅 (submit 전에 다시 확인 한다.)
     		BookingDetail[] bookingDetailList = null;

        	// Verify 요청 및 결과 세팅
    		bookingDetailList = getVerifyResultListFull(Constants.VRFY_PROC_RE_REQ, event, event.getBookingDetailList());
    		event.setBookingDetailList(bookingDetailList);
    		
    		// WRS Full Cntr Creation IRG 정보 Log
    		dbDao.wrsFullBkgIRGVerifyResultLog(event.getBkg_no(), event.getRailRampLocation());
    		
    		Object[] result1 = dbDao.insertRailBillingReqCreateFull(event);
    		isSuccessful = ((Boolean)result1[0]).booleanValue();
    		
    		Usa404EDISendVO ediSendInfo  = (Usa404EDISendVO)result1[1];
    		
    		if(isSuccessful) {
    			resultStr = "SUCCESS";
    		}
    		eventResponse = new ExpPap0015EventResponse(ediSendInfo, resultStr);
    	
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
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
     * Rail Billing Empty Cntr Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0016Event
     * @return EventResponse ExpPap0016EventResponse
     * @exception EventException
     */
    public EventResponse searchRailBillingReqCreateEmpty(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        ExpPap0016Event event = (ExpPap0016Event)e;
        ExpPap0016EventResponse eventResponse = null;
        
        try {
        	Object[] result1 = dbDao.searchRailBillingReqCreateEmpty(event);
        	LocationDetail[] locationDetailList  = (LocationDetail[])result1[0];
        	
        	Object[] result2 = dbDao.searchEmptyCntrTpSz();
        	ContainerTypeSize[]  cntrTpSzList = (ContainerTypeSize[])result2[0];
        	
//        	String  userFavFmNodCd = dbDao.searchUserEmptyFmNodCd(event.getUser_id());
        	String  userFavFmNodCd = "";
        	
            eventResponse = new ExpPap0016EventResponse(	locationDetailList,
            												cntrTpSzList,
            												userFavFmNodCd,
            												"SUCCESS");
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Empty Cntr Verify Request 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0017Event
     * @return EventResponse ExpPap0017EventResponse
     * @exception EventException
     */
    public EventResponse verifyRailBillingReqCreateEmpty(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	ExpPap0017Event event = (ExpPap0017Event)e;
    	ExpPap0017EventResponse eventResponse = null;
    	
    	try {
    		EmptyContainer[] emptyContainerList = null;

    		// Verify 요청 및 결과 세팅
			emptyContainerList = getVerifyResultListEmpty(Constants.VRFY_PROC_REQ, event, event.getEmptyContainerList());
    		
    		eventResponse = new ExpPap0017EventResponse(emptyContainerList, "SUCCESS");
    		
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
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
     * getVerifyResultListEmpty
     * @param procFlag
     * @param e
     * @param emptyContainerList
     * @return
     * @throws Exception
     */
    public EmptyContainer[] getVerifyResultListEmpty(String procFlag, Event e, EmptyContainer[] emptyContainerList) throws Exception {
    	ExpPap0017Event event017 = null;
    	ExpPap0018Event event018 = null;
    	String userId = "";
    	String bkgNo  = "";
    	String orgYdCd = "";
    	String bkgVrfyRstCd = "";
    	String bkgVrfyRsnCd = "";
    	String bkgVrfyLangTpCd = "";
    	RailBillingVerifyManageBC piVrfyBC = null;
    	RailBillingVerifyEvent vfEvent = null;
    	RailBillingVerifyEventResponse vfEvtRes = null;
    	
//    	trcLogger.masterBegin("MT getVerifyResultListEmpty");
    	
    	try {
        	if(Constants.VRFY_PROC_REQ.equals(procFlag)) {
        		event017        = (ExpPap0017Event)e;
        		userId          = event017.getUser_id();
        		bkgNo           = "";
        		orgYdCd         = event017.getYd_cd();
        		bkgVrfyRstCd    = "";
        		bkgVrfyRsnCd    = "";
        		bkgVrfyLangTpCd = "";
        	} else if(Constants.VRFY_PROC_RE_REQ.equals(procFlag)) {
        		event018        = (ExpPap0018Event)e;
        		userId          = event018.getUser_id();
        		bkgNo           = "";
        		orgYdCd         = event018.getYd_cd();
        		bkgVrfyRstCd    = "";
        		bkgVrfyRsnCd    = "";
        		bkgVrfyLangTpCd = "";
        	} else {
        		throw new EventException("No define process.");	
        	}
        	
        	if(orgYdCd == null || Constants.EMPTY.equals(orgYdCd)) {
        		throw new EventException("From Yard is incorrect.");
        	}
        	
    		RailBillingVerifyList[] railBillingVerifyList = new RailBillingVerifyList[emptyContainerList.length];
    		
    		// Cntr TpSz 조회
    		Object[] result1 = dbDao.searchCntrTpSz(emptyContainerList);
    		EmptyContainer[] cntrTpSzList  = (EmptyContainer[])result1[0];
    		
    		HashMapEnumeration htCntrTpSzList = new HashMapEnumeration();
    		if(cntrTpSzList != null && cntrTpSzList.length > 0) {
    			for(int i=0; i<cntrTpSzList.length; i++) {
    				htCntrTpSzList.put(cntrTpSzList[i].getCntr_no(), cntrTpSzList[i]);
    			}
    		}
    		
    		for(int i=0; i<emptyContainerList.length; i++) {
    			RailBillingVerifyList railBillingVerifyInfo = new RailBillingVerifyList();
    			railBillingVerifyInfo.setEq_no(emptyContainerList[i].getCntr_no());
    			
    			// TpSz 확인
    			EmptyContainer cntrTpSzInfo = (EmptyContainer)htCntrTpSzList.get(emptyContainerList[i].getCntr_no());
        		if(cntrTpSzInfo != null) {
        			railBillingVerifyInfo.setEq_tpsz_cd(cntrTpSzInfo.getCntr_tpsz_cd());
        			railBillingVerifyInfo.setEq_tpsz_nm(cntrTpSzInfo.getCntr_tpsz_nm());        			
        		} else {
        			// Container Mst에 데이터 없으면
        			railBillingVerifyInfo.setEq_tpsz_cd("XX");
        			railBillingVerifyInfo.setEq_tpsz_nm("");        			
        		}
    			railBillingVerifyList[i] = railBillingVerifyInfo;
    		}
    		
    		// Verify 요청 Event
    		vfEvent = new RailBillingVerifyEvent(
    				userId,
    				Constants.CARGO_TYPE_EMPTY,
    				bkgNo,
    				orgYdCd,
    				bkgVrfyRstCd,
    				bkgVrfyRsnCd,
    				bkgVrfyLangTpCd,
    				"",
    				railBillingVerifyList
    				);

        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	
    	try {
    		// Verify 요청
//    		trcLogger.detailBegin("MT TRS Call Verify");
    		piVrfyBC = new RailBillingVerifyManageBCImpl();
    		vfEvtRes = (RailBillingVerifyEventResponse)piVrfyBC.verifyRailBillingCNTRList(vfEvent);
//    		trcLogger.detailEnd();
/*        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
*/        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException("Verify Process Call Error : Code[PI-01]");
        }
        
    	try {
    		if(!Constants.PROC_SUCCESS.equals(vfEvtRes.getIsSuccessFlag())  ) {
    			throw new EventException("Verify Process Call Error : Code[PI-02]");
    		}
    		
    		
    		Object[] result2 = dbDao.searchComErrMsgList();
    		HashMapEnumeration htErrCodeList = (HashMapEnumeration)result2[0];
    		
    		String vrfyRstCd = "";
    		String errCodeKey = "";
    		HashMapEnumeration htVrfyList = new HashMapEnumeration();
    		Iterator itr = vfEvtRes.getModels().iterator();
			while (itr != null && itr.hasNext()) {					
				RailBillingVerifyList vrfyInfo = (RailBillingVerifyList)itr.next();
				if(vrfyInfo.getEq_no() == null) {
					throw new EventException("Verify Process Call Error : Code[PI-03]");
				}
				 
				// Goods 확인
				vrfyRstCd = (vrfyInfo.getErr_msg_cd() == null || Constants.EMPTY.equals(vrfyInfo.getErr_msg_cd())) ? Constants.VRFY_GOOD : "";
				
				if(Constants.EMPTY.equals(vrfyRstCd)) {
					errCodeKey = vrfyInfo.getErr_msg_cd()+vrfyInfo.getLang_tp_cd();
					RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(errCodeKey);
					
					if(errVO != null) {
    					if(Constants.VRFY_TYPE_NOGOOD.equals(errVO.getErr_tp_cd())) {
    						vrfyRstCd = Constants.VRFY_NOGOOD;
    					} else if(Constants.VRFY_TYPE_NOWRS.equals(errVO.getErr_tp_cd())) {
    						vrfyRstCd = Constants.VRFY_NOWRS;
    					} else if(Constants.VRFY_TYPE_NOBILLING.equals(errVO.getErr_tp_cd())) {
    						vrfyRstCd = Constants.VRFY_NOBILLING;
    					} else {
    						throw new EventException("Verify Process Call Error : Code[PI-07]"); // Verify Type이 (E, W)가 아닌경우
    					}
					} else {
						throw new EventException("Verify Process Call Error : Code[PI-08]"); // 에러코드 데이블에 해당 에러코드가 없는 경우
					}
				}
				
				if(Constants.VRFY_GOOD.equals(vrfyRstCd) || Constants.VRFY_NOGOOD.equals(vrfyRstCd)) {
					if( vrfyInfo.getRepo_pln_id() == null || Constants.EMPTY.equals(vrfyInfo.getRepo_pln_id()) ||
						vrfyInfo.getPln_yrwk() == null || Constants.EMPTY.equals(vrfyInfo.getPln_yrwk()) ||
						vrfyInfo.getRef_id() == null || Constants.EMPTY.equals(vrfyInfo.getRef_id()) ||
						vrfyInfo.getRef_seq() == null || Constants.EMPTY.equals(vrfyInfo.getRef_seq()) ||
						vrfyInfo.getRoute_org_nod_cd() == null || Constants.EMPTY.equals(vrfyInfo.getRoute_org_nod_cd()) ||
						vrfyInfo.getRoute_dest_nod_cd() == null || Constants.EMPTY.equals(vrfyInfo.getRoute_dest_nod_cd()) ||
						vrfyInfo.getRoute_seq() == null || Constants.EMPTY.equals(vrfyInfo.getRoute_seq()) ||
						vrfyInfo.getRail_route() == null || Constants.EMPTY.equals(vrfyInfo.getRail_route()) ) {
						
						throw new EventException("Verify Process Call Error : Code[PI-04]");
					}
				}
				
				if(Constants.VRFY_NOGOOD.equals(vrfyRstCd) || Constants.VRFY_NOWRS.equals(vrfyRstCd)
						 || Constants.VRFY_NOBILLING.equals(vrfyRstCd)) {
					if( vrfyInfo.getErr_msg_cd() == null || Constants.EMPTY.equals(vrfyInfo.getErr_msg_cd()) ||
				        vrfyInfo.getLang_tp_cd() == null || Constants.EMPTY.equals(vrfyInfo.getLang_tp_cd()) ) {
					
						throw new EventException("Verify Process Call Error : Code[PI-06]");
					}
				}
				
				htVrfyList.put(vrfyInfo.getEq_no(), vrfyInfo);
			}
    		
			log.debug("emptyContainerList.length : "+ emptyContainerList.length +"\n\n\n");

			for(int i=0; i<emptyContainerList.length; i++) {
				// Verify 결과 세팅
				RailBillingVerifyList vrfyInfo = (RailBillingVerifyList)htVrfyList.get(emptyContainerList[i].getCntr_no());
				(emptyContainerList[i]).setVrfy_rst_cd("");
				(emptyContainerList[i]).setVrfy_rst_msg("");
    			(emptyContainerList[i]).setVrfy_rsn_cd("");
    			(emptyContainerList[i]).setVrfy_rsn_msg("");
    			(emptyContainerList[i]).setVrfy_lang_tp_cd("");
				
    			
				if(vrfyInfo != null) {
	    			(emptyContainerList[i]).setRepo_pln_id(vrfyInfo.getRepo_pln_id());
	    			(emptyContainerList[i]).setPln_yrwk(vrfyInfo.getPln_yrwk());
	    			(emptyContainerList[i]).setRef_id(vrfyInfo.getRef_id());
	    			(emptyContainerList[i]).setRef_seq(vrfyInfo.getRef_seq());
	    			
	    			(emptyContainerList[i]).setRoute_org_nod_cd(vrfyInfo.getRoute_org_nod_cd());
	    			(emptyContainerList[i]).setRoute_dest_nod_cd(vrfyInfo.getRoute_dest_nod_cd());
	    			(emptyContainerList[i]).setRoute_seq(vrfyInfo.getRoute_seq());
	    			(emptyContainerList[i]).setRail_route(vrfyInfo.getRail_route());
	    			(emptyContainerList[i]).setCntr_tpsz_cd(vrfyInfo.getEq_tpsz_cd());
	    			(emptyContainerList[i]).setCntr_tpsz_nm(vrfyInfo.getEq_tpsz_nm());
	    			
//	    			 Good 확인
	    			vrfyRstCd = (vrfyInfo.getErr_msg_cd() == null || Constants.EMPTY.equals(vrfyInfo.getErr_msg_cd())) ? Constants.VRFY_GOOD : "";
	    			
	    			if(Constants.VRFY_GOOD.equals(vrfyRstCd)) {
	    				// 2007-07-12 신희정 과정님 요청으로 자동EDI 전송 안되게 한시적으로 Good -> No Good 처리
	    				// 정상 소스 - Start 
	    				(emptyContainerList[i]).setVrfy_rst_cd(Constants.VRFY_GOOD);
	    				(emptyContainerList[i]).setVrfy_rst_msg(Constants.VRFY_GOOD_NM);
    	    			(emptyContainerList[i]).setVrfy_rsn_msg(Constants.VRFY_GOOD_NM);
    	    			(emptyContainerList[i]).setVrfy_lang_tp_cd("");
	    				// 정상소스 - End

	    				// 한시적으로 사용 - Start
//	    				(emptyContainerList[i]).setVrfy_rst_cd(Constants.VRFY_NOGOOD);
//	    				(emptyContainerList[i]).setVrfy_rst_msg(Constants.VRFY_NOGOOD_NM);
//	    				
//    	    			String errMsg_cd = "TRS00046";
//    	    			String langTpCd  = "ENG";
//    	    			errCodeKey = errMsg_cd + langTpCd;
//    	    			RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(errCodeKey);
//	    				(emptyContainerList[i]).setVrfy_rsn_cd(errMsg_cd);
//    	    			(emptyContainerList[i]).setVrfy_rsn_msg(errVO.getErr_msg());
//    	    			(emptyContainerList[i]).setVrfy_lang_tp_cd(langTpCd);
    	    			// 한시적으로 사용 -End
    	    			
	    			} else {
	    				// 에러 메시지 세팅
	    				errCodeKey = vrfyInfo.getErr_msg_cd()+vrfyInfo.getLang_tp_cd();
	    				RailBillErrorVO errVO = (RailBillErrorVO)htErrCodeList.get(errCodeKey);
	    				
	    				if(errVO != null) {
	    					if(Constants.VRFY_TYPE_NOGOOD.equals(errVO.getErr_tp_cd())) {
	    	    				(emptyContainerList[i]).setVrfy_rst_cd(Constants.VRFY_NOGOOD);
	    	    				(emptyContainerList[i]).setVrfy_rst_msg(Constants.VRFY_NOGOOD_NM);
	    					} else if(Constants.VRFY_TYPE_NOWRS.equals(errVO.getErr_tp_cd())) {
	    	    				(emptyContainerList[i]).setVrfy_rst_cd(Constants.VRFY_NOWRS);
	    	    				(emptyContainerList[i]).setVrfy_rst_msg(Constants.VRFY_NOWRS_NM);
	    					} else if(Constants.VRFY_TYPE_NOBILLING.equals(errVO.getErr_tp_cd())) {
	    	    				(emptyContainerList[i]).setVrfy_rst_cd(Constants.VRFY_NOBILLING);
	    	    				(emptyContainerList[i]).setVrfy_rst_msg(Constants.VRFY_NOBILLING_NM);
	    					} else {
	    						throw new EventException("Verify Process Call Error : Code[PI-07]"); // Verify Type이 (E, W)가 아닌경우
	    					}
	    					
	    	    			(emptyContainerList[i]).setVrfy_rsn_cd(vrfyInfo.getErr_msg_cd());
	    	    			(emptyContainerList[i]).setVrfy_rsn_msg(errVO.getErr_msg());
	    	    			(emptyContainerList[i]).setVrfy_lang_tp_cd(vrfyInfo.getLang_tp_cd());
	    	    			
	    				} else {
	    					throw new EventException("Verify Process Call Error : Code[PI-08]"); // 에러코드 데이블에 해당 에러코드가 없는 경우
	    				}
	    			}
				} else {
					throw new EventException("Verify Process Call Error : Code[PI-09]"); // 요청 리스트갯수와 결과 리스트 갯수가 다른경우
				}
			}
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }

//        trcLogger.masterEnd(TraceLogger.LIMIT_05);
    	return emptyContainerList;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Rail Billing Empty Cntr Request Creation 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e ExpPap0017Event
     * @return EventResponse ExpPap0017EventResponse
     * @exception EventException
     */
    public EventResponse insertRailBillingReqCreateEmpty(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	ExpPap0018Event event = (ExpPap0018Event)e;
    	ExpPap0018EventResponse eventResponse = null;
    	boolean isSuccessful = false; 
    	String  resultStr = "FAIL"; 
    	
    	try {
    		// 업무처리
    		
    		// Verify 요청 및 결과 세팅 (submit 전에 다시 확인 한다.)
    		EmptyContainer[] emptyContainerList = null;

    		// Verify 요청 및 결과 세팅
			emptyContainerList = getVerifyResultListEmpty(Constants.VRFY_PROC_RE_REQ, event, event.getEmptyContainerList());
    		event.setEmptyContainerList(emptyContainerList);
    		
    		Object[] result1 = dbDao.insertRailBillingReqCreateEmpty(event);
    		isSuccessful = ((Boolean)result1[0]).booleanValue();
    		Usa404EDISendVO ediSendInfo  = (Usa404EDISendVO)result1[1];
    		
    		if(isSuccessful) {
    			resultStr = "SUCCESS";
    		}
    		
    		eventResponse = new ExpPap0018EventResponse(ediSendInfo, resultStr);
    		
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
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
     * 이벤트 처리<br>
     * Rail Billing EDI 전송 요청 처리<br>
     * 
     * @param ediSendInfo Usa404EDISendVO
     * @exception EventException
     */
    public void multiUSA404EDISend(Usa404EDISendVO ediSendInfo) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	String cntr_ofc_cd = "";
    	String user_id = "";
    	int ediSendErrCnt = 0;
    	
    	try {
    		
        	cntr_ofc_cd = ediSendInfo.getCntr_ofc_cd();
        	user_id = ediSendInfo.getUser_id();
        	
    		Iterator it = ediSendInfo.getEdi_send_list().iterator();
    		TrsTrspEdiRailOrdVO ediSendVO = null;
    		while (it.hasNext()) {
    			ediSendVO = (TrsTrspEdiRailOrdVO)it.next();
    			if(ediSendVO.getRailCmbThruTpCd() != null) {
    				if("S2R".equals(ediSendVO.getRailCmbThruTpCd())) {
    					ediSendErrCnt++;
    				} else if("S3R".equals(ediSendVO.getRailCmbThruTpCd())) {
    					ediSendErrCnt++;
    				} 
    			}
    		}
    		
    		if(ediSendErrCnt > 0) {
    			throw new DAOException("EDI Send Error : RAIL COMBINED THROUGH TYPE CODE IS S2R, S3R");
    		}
    		
    		
    		if( cntr_ofc_cd != null && !Constants.EMPTY.equals(cntr_ofc_cd) &&
    			user_id != null && !Constants.EMPTY.equals(user_id) &&
    			ediSendInfo.getEdi_send_list() != null && ediSendInfo.getEdi_send_list().size() > 0 ) {
    			
    			HashMap hashParams = new HashMap();
    			hashParams.put("ctrl_ofc_cd", cntr_ofc_cd);
    			hashParams.put("user_id", user_id);

	    		// EDI 전송 
//	    		USA404EDIStatusInquiryDBDAO piDao = new USA404EDIStatusInquiryDBDAO();
/* 20091017 임시 주석처리 
	    		piDao.multiTRS_TRSP_EDI_RAIL_ORDER_VO(hashParams, ediSendInfo.getEdi_send_list());
	    		*/
    		}
    		
        } catch (DAOException de) {
        	log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    }
    

	
    /**
     * ESD_TRS 업무 시나리오 마감작업<br>
     * RailBilling업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        dbDao = null;
    }
}