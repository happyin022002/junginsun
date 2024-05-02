/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderSheetDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-05-04 sung hwan cho : multi_stp_loc 서브 쿼리 수정
* 2007-05-10 sung hwan cho : usd total_amt 는 무조건 0으로 표시
* 2007-05-11 sung hwan cho : Door 정보를 가져오는 테이블 변경 trs_trsp_svc_ord -> trs_bkg_rqst_ord
* 2007-05-22 sung hwan cho : DB Result결과가 0건 일경우에도 Return Structure는 Return 되도록 수정
* 2007-07-27 Jung-Jae Kim : 구주 DOOR ARRIVAL TIME 변경
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
* 2007-08-29 Jung-Jae Kim : 신희정 과장 요청으로 W/O issued date를 cre_dt로 표시되게 수정.
* 2007-08-31 Jung-Jae Kim : print-out date를 local system date로 수정
*@LastModifyDate : 2007-08-29
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.7
* 2006-12-20 doomi 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.core.layer.event.Event;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetFormatType;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheet;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetTotalQuantity;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoAwkward;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoReefer;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetCargoDg;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderSheetSecondList;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0006Event;
//import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.TraceLogUtil;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.integration.AvailabilityDBDAO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see WSInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderSheetDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("WORKORDER");

	/**
     * searchWorkOrderSheetFormatType Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object
     * @throws DAOException
     */
    public Object searchWorkOrderSheetFormatType(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object result = null;
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetFormatType");
            ExpPap0006Event event = (ExpPap0006Event)et;

            String r_vender_cd	= event.getVendorCode();
			String r_trsp_wo_no		= event.getWorkOrderNo();		
			
			/*
    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code");
    		}
    		*/
			
    		if(event.getWorkOrderNo() == null || event.getWorkOrderNo().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}
	
//    		trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSheetFormatType Query-StringBuffer");
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no.substring(0,3));
    		param.put("trsp_wo_seq", r_trsp_wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("wo_vndr_seq", r_vender_cd);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchWorkOrderSheetFormatTypeRSQL template = new WorkOrderSheetDBDAOsearchWorkOrderSheetFormatTypeRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            
            WorkOrderSheetFormatType wo = new WorkOrderSheetFormatType();
            if(rs.next()) { 
            	wo.setWorkOrderFormatTypeCd (checkString(rs.getString("wo_fmt_tp_cd"))); 		
            	wo.setWorkOrderFormatTypeNm (checkString(rs.getString("wo_fmt_tp_nm"))); 		
            }
        
            result = wo;
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetFormatType");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return result;
    }

    
    
    
	/**
     * searchWorkOrderSheet Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object
     * @throws DAOException
     */
    public Object searchWorkOrderSheet(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object result = null;
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheet");
            ExpPap0006Event event = (ExpPap0006Event)et;

            String r_vender_cd	= event.getVendorCode();
			String r_trsp_wo_no		= event.getWorkOrderNo();		
			
			/*
    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code");
    		}
    		*/
    		if(event.getWorkOrderNo() == null || event.getWorkOrderNo().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}

//    		trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheet Query-StringBuffer");
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_trsp_wo_no, ","); 
    		velParam.put("wo_vndr_seq", r_vender_cd);
			velParam.put("trsp_wo_ofc_cty_cd", tmpArrList);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchWorkOrderSheetRSQL template = new WorkOrderSheetDBDAOsearchWorkOrderSheetRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheet getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheet ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheet ExecuteQuery");
            
            WorkOrderSheet wo = new WorkOrderSheet();
            if(rs.next()) { 
            	wo.setSp_code			(checkString(rs.getString("vndr_code"        	)));	                                                          
            	wo.setSp_full_nm		(checkString(rs.getString("full_name"           )));                                                     
            	wo.setSp_address		(checkString(rs.getString("eng_addr"            )));                                                     
            	wo.setSp_tel			(checkString(rs.getString("phn_no"              )));                                                     
            	wo.setSp_fax			(checkString(rs.getString("fax_no"              )));                                                     
            	wo.setSp_pic			(checkString(rs.getString("cntc_pson_nm"        )));                                                     
            	wo.setBndCode			(checkString(rs.getString("trsp_bnd_cd"         )));                                                     
            	wo.setCostDtlModCode	(checkString(rs.getString("trsp_cost_dtl_mod_cd")));                                                     
            	wo.setCrrModNm			(checkString(rs.getString("trsp_crr_mod_nm"     )));          
            	wo.setCostDtlModNm		(checkString(rs.getString("trsp_cost_dtl_mod_nm")));          
            	wo.setWorkOrderNo		(checkString(rs.getString("trsp_wo_cd"          )));           
            	wo.setIssueType			(checkString(rs.getString("wo_iss_sts_cd"       )));          
            	wo.setFr_code			(checkString(rs.getString("fm_cd"               )));                                                     
            	wo.setFr_full_nm		(checkString(rs.getString("fm_nm"               )));                                                     
            	wo.setFr_address		(checkString(rs.getString("fm_addr"             )));                                                     
            	wo.setFr_tel			(checkString(rs.getString("fm_phn_no"           )));                                                     
            	wo.setFr_fax			(checkString(rs.getString("fm_fax_no"           )));                                                     
            	wo.setFr_pic			(checkString(rs.getString("fm_pic_nm"           )));                                                     
            	wo.setTo_code			(checkString(rs.getString("to_cd"               )));                                                     
            	wo.setTo_full_nm		(checkString(rs.getString("to_nm"               )));                                                     
            	wo.setTo_address		(checkString(rs.getString("to_addr"             )));                                                     
            	wo.setTo_tel			(checkString(rs.getString("to_phn_no"           )));                                                     
            	wo.setTo_fax			(checkString(rs.getString("to_fax_no"           )));                                                     
            	wo.setTo_pic			(checkString(rs.getString("to_pic_nm"           )));                                                     
            	wo.setVia_code			(checkString(rs.getString("via_cd"              )));                                                     
            	wo.setVia_full_nm		(checkString(rs.getString("via_nm"              )));                                                     
            	wo.setVia_address		(checkString(rs.getString("via_addr"            )));                                                     
            	wo.setVia_tel			(checkString(rs.getString("via_phn_no"          )));                                                     
            	wo.setVia_fax			(checkString(rs.getString("via_fax_no"          )));                                                     
            	wo.setVia_pic			(checkString(rs.getString("via_pic_nm"          )));                                                     
            	wo.setDoor_code			(checkString(rs.getString("dr_cd"               )));                                                     
            	wo.setDoor_address		(checkString(rs.getString("dr_addr"             )));                                                     
            	wo.setDoor_full_nm		(checkString(rs.getString("dr_nm"               )));                                                     
            	wo.setDoor_tel			(checkString(rs.getString("dr_phn_no"           )));                                                     
            	wo.setDoor_fax			(checkString(rs.getString("dr_fax_no"           )));                                                     
            	wo.setDoor_pic			(checkString(rs.getString("dr_pic_nm"           )));                                                     
            	wo.setInstruction		(checkString(rs.getString("instruction"         )));                                                     
            	wo.setIbVvdCode			(checkString(rs.getString("ib_vvd_cd"           )));                                                     
            	wo.setObVvdCode			(checkString(rs.getString("ob_vvd_cd"           )));                                                     
            	wo.setFeederVVD			(checkString(rs.getString("feeder_vvd"          )));                                              
            	wo.setOfficeAddress		(checkString(rs.getString("ofc_addr"            )));                                                     
            	wo.setOfficeTel			(checkString(rs.getString("ofc_phn_no"          )));                                                     
            	wo.setOfficeFax			(checkString(rs.getString("ofc_fax_no"          )));                                                     
            	wo.setOfficePic			(checkString(rs.getString("pic"                 )));                                                     
            	wo.setWoIssuedAt		(checkString(rs.getString("wo_iss_at"           )));                    
            	wo.setPrintedAt			(checkString(rs.getString("print_at"           )));
            	wo.setMaeFlg			(checkString(rs.getString("mae_flg"             )));
            	wo.setCreOfcCd			(checkString(rs.getString("cre_ofc_cd"             )));
            	wo.setCreUsrId			(checkString(rs.getString("cre_usr_id"             )));
            }
        	result = wo;
        	
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheet");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);   
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return result;
    }
    
	/**
     * searchWorkOrderSheetTotalQuantity Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object
     * @throws DAOException
     */
    public Object searchWorkOrderSheetTotalQuantity(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object result = null;
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetTotalQuantity");
            ExpPap0006Event event = (ExpPap0006Event)et;

            String r_vender_cd	= event.getVendorCode();
			String r_trsp_wo_no		= event.getWorkOrderNo();		
			
			/*
    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code");
    		}
    		*/
			
    		if(event.getWorkOrderNo() == null || event.getWorkOrderNo().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}
  					                                                                                                        	
//    		trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSheetTotalQuantity Query-StringBuffer");
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no.substring(0,3));
    		param.put("trsp_wo_seq", r_trsp_wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("wo_vndr_seq", r_vender_cd);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchWorkOrderSheetTotalQuantityRSQL template = new WorkOrderSheetDBDAOsearchWorkOrderSheetTotalQuantityRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchDetailExcelPrint ExecuteQuery");
            
            WorkOrderSheetTotalQuantity wo = new WorkOrderSheetTotalQuantity();
           if(rs.next()) { 
            	wo.setTotalQuantity20	(checkString(rs.getString("total_20"))); 		
            	wo.setTotalQuantity40	(checkString(rs.getString("total_40"))); 		
            	wo.setTotalAmount		(checkString(rs.getString("total_amt"))); 
            	wo.setTotalQuantity		(checkString(rs.getString("total_qnt")));
				wo.setCurrencyCode		(checkString(rs.getString("curr_cd")));
				wo.setTotalAmtUsd		(checkString(rs.getString("total_amt_usd")));
            }
            result = wo;
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetTotalQuantity");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);   
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return result;
    }

    
	    
    /**
     * searchWorkOrderSheetList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et
     * @param step_no
     * @return
     * @throws DAOException
     */
    public Object[] searchWorkOrderSheetList(Event et, String step_no) throws DAOException {
    	DBRowSet rs = null;
        /* PDF내용중 MM(Empty)일경우 pikup no 번호조회 안함 최초 시간 업데이터 안됨 2008.08.21
         * 수정시 WorkOrderSheetBCImpl 수정필수
         */
//        boolean isUpdate = step_no!=null&&step_no.equals("MM")?false:true;
        step_no = step_no!=null&&step_no.equals("MM")?"":step_no;
        
        Object[] result = new Object[2];

        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetList");
            ExpPap0006Event event = (ExpPap0006Event)et;

            String r_vender_cd	= event.getVendorCode();
            String r_trsp_wo_no		= event.getWorkOrderNo();	
			
//			trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSheetList Query-StringBuffer");
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_so_cmb_srt_no", step_no);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_trsp_wo_no, ","); 
    		velParam.put("wo_no", tmpArrList);
    		velParam.put("trsp_so_cmb_srt_no", step_no);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchWorkOrderSheetListRSQL template = new WorkOrderSheetDBDAOsearchWorkOrderSheetListRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheetList getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheetList ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheetList ExecuteQuery");

			int i=1;
            ArrayList args = new ArrayList();
//            AvailabilityDBDAO avltDao = new AvailabilityDBDAO();
            while(rs.next()) {
            	WorkOrderSheetList wo = new WorkOrderSheetList();
 
				
				wo.setSeq						(i++); 												                                                                  
				wo.setEquipmentNumber			(checkString(rs.getString("equipment_number"             )));                                                                                   
				wo.setTypeSize					(checkString(rs.getString("type_size"                    )));                                                                                   
				wo.setRate						(checkString(rs.getString("rate"                         )));                                                                                   
				wo.setSpecialCargo				(checkString(rs.getString("special_cargo"                )));                                                                                   
				wo.setWeight					(checkString(rs.getString("weight"                       )));  
				wo.setCommodityDescription		(checkString(rs.getString("commodity_description"        )));                                                                                   
				wo.setInbondTransitNumber		(checkString(rs.getString("inbond_transit_number"        ))); 
				wo.setPurchaseOrderNo			(checkString(rs.getString("purchase_order_no"            )));                                                                                   
				wo.setBookingNumber				(checkString(rs.getString("booking_number"               )));                                                                                   
				wo.setBillofLadingNumber		(checkString(rs.getString("bl_no"                        )));                                                                                   
				wo.setVesselVoyageCode			(checkString(rs.getString("vessel"                       )));                                                                                   
				wo.setNextPort					(checkString(rs.getString("next_port"                    )));                                                                                   
				wo.setShipperName				(checkString(rs.getString("shipper_name"                 )));                                                                                   
				wo.setShipperTelephone			(checkString(rs.getString("shipper_telephone_number"     )));                                                                                   
				wo.setDoorServiceType			(checkString(rs.getString("door_service_type"            ))); 

				// 20070627 신희정과장 요청 : SPP avaliable status check logic추가 (TRS와 구분 필요함.)
				//* 2007-10-10 by KJJ: cstms_acpt_flg column 값이 Y,W 둘다 list에 보이도록 수정 요청 by SHIN
//				if ((rs.getString("f").trim().equals("Y") && rs.getString("o").trim().equals("Y") 
//						&& (rs.getString("c").trim().equals("Y") || rs.getString("c").trim().equals("W")) ) 
//						&& rs.getString("pickup_no") != null && !rs.getString("pickup_no").equals("")
//					    && !checkString(rs.getString("last_free_date")).equals(""))// Available
//					{
//					wo.setPickupNo					(checkString(rs.getString("pickup_no"                    )));                                                                                   
//					masterSPP로 로긴할 때는 update 안되도록 막음.
//					2010-03-16 PkupRlsDt Update 로직제거
//					if (isUpdate && !"".equals(r_vender_cd)) {
//						avltDao.updFirstRlsDt(checkString(rs.getString("bkg_no"))+checkString(rs.getString("bkg_no_split")),checkString(rs.getString("Equipment_Number")));
//					}                                                                                  
													
//				}else{											// Unavailable
//						wo.setPickupNo					("");                                                                                   
//				}
				wo.setPickupNo					(checkString(rs.getString("pickup_no"                    )));
				wo.setAvailableDate				(checkString(rs.getString("available_date"               )));                                                                                   
				wo.setLastFreeDate				(checkString(rs.getString("last_free_date"               )));
				
				wo.setCustomsClearNumber		(checkString(rs.getString("cs_clear_no"                  )));                                                                                   
				wo.setExpDepTimeFromLocation	(checkString(rs.getString("expected_departure_time"      )));                                                                                   
				wo.setExpArriTimeToLocation		(checkString(rs.getString("expected_arrival_time"        )));                                                                                   
				wo.setDoorArriAppTime			(checkString(rs.getString("door_arrival_appointment_time")));                                                                                   
				wo.setUsaLastCity				(checkString(rs.getString("usa_last_city"                )));                                                                                   
				wo.setRemark					(checkString(rs.getString("remark"                       )));                                                                                   
				wo.setSealNo1					(checkString(rs.getString("seal_no_1"                      )));                                                                                   
				wo.setSealNo2					(checkString(rs.getString("seal_no_2"                      )));                                                                                   
				wo.setDetain					(checkString(rs.getString("detain"                       )));                                                                                   
				wo.setPreDespatched				(checkString(rs.getString("predispatch"                  )));                                                                                   
				wo.setBNumberIssue				(checkString(rs.getString("bnum"                         )));                                                                                   
				wo.setBlockStwg					(checkString(rs.getString("blck_stwg"                    )));                                                                                   
				wo.setSoDelCode					(checkString(rs.getString("del_cd"                       )));                                                                                   
				wo.setMultiStopLocAppTime1		(checkString(rs.getString("mlt_stop_1"                   )));                                      
				wo.setMultiStopLocAppTime2		(checkString(rs.getString("mlt_stop_2"                   )));                                      
				wo.setMultiStopLocAppTime3		(checkString(rs.getString("mlt_stop_3"                   )));                                      
				wo.setMultiStopLocAppTime4		(checkString(rs.getString("mlt_stop_4"                   )));                                      
				wo.setMultiStopLocAppTime5		(checkString(rs.getString("mlt_stop_5"                   )));                                       
				
				wo.setRailReceivingDateFM		(checkString(rs.getString("rail_receiving_date_fm"                   )));
				wo.setRailReceivingDateTO		(checkString(rs.getString("rail_receiving_date_to"                   )));
				wo.setTroLodRefNo				(checkString(rs.getString("tro_lod_ref_no"                   )));
				
				args.add(wo);
            
            }
            
        	result[0] = (WorkOrderSheetList[])args.toArray(new WorkOrderSheetList[0]);
            result[1] = new Integer(args.size());
            
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetList");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return result;
    }
    
    /**
     * searchSpecialCargoSummaryAwkward Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object
     * @throws DAOException
     */

    public Object[] searchSpecialCargoSummaryAwkward(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchSpecialCargoSummaryAwkward");
        	
            ExpPap0006Event event = (ExpPap0006Event)et;
            String r_vender_cd	= event.getVendorCode();
            String r_trsp_wo_no		= event.getWorkOrderNo();		
           
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchSpecialCargoSummaryAwkward Query-StringBuffer");
			// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no.substring(0,3));
    		param.put("trsp_wo_seq", r_trsp_wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("wo_vndr_seq", r_vender_cd);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchSpecialCargoSummaryAwkwardRSQL template = new WorkOrderSheetDBDAOsearchSpecialCargoSummaryAwkwardRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryAwkward getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryAwkward ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryAwkward ExecuteQuery");
            
            ArrayList args = new ArrayList();
            int i = 1;
            while(rs.next()) {         		
            	WorkOrderSheetCargoAwkward wo = new WorkOrderSheetCargoAwkward();
            	wo.setAwkwardSeq		(i++); 
				wo.setAwkward			("Awkward");
				wo.setAwkwardEqNo		(checkString(rs.getString("awk_eq_no"	))); 
				wo.setAwkwardLength		(checkString(rs.getString("awk_length"))); 
				wo.setAwkwardWidth		(checkString(rs.getString("awk_width"	))); 
				wo.setAwkwardVoid		(checkString(rs.getString("awk_void"	))); 
				wo.setAwkwardHeight		(checkString(rs.getString("awk_height"	))); 
				args.add(wo);
            }

        	result[0] = (WorkOrderSheetCargoAwkward[])args.toArray(new WorkOrderSheetCargoAwkward[0]);
            result[1] = new Integer(args.size());
				
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchSpecialCargoSummaryAwkward");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);  
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return result;
    }

    /**
     * searchSpecialCargoSummaryReefer Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */

    public Object[] searchSpecialCargoSummaryReefer(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchSpecialCargoSummaryReefer");
            ExpPap0006Event event = (ExpPap0006Event)et;
            String r_vender_cd	= event.getVendorCode();
            String r_trsp_wo_no		= event.getWorkOrderNo();		
        
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchSpecialCargoSummaryReefer Query-StringBuffer");
            // query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no.substring(0,3));
    		param.put("trsp_wo_seq", r_trsp_wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("wo_vndr_seq", r_vender_cd);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchSpecialCargoSummaryReeferRSQL template = new WorkOrderSheetDBDAOsearchSpecialCargoSummaryReeferRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryReefer getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryReefer ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryReefer ExecuteQuery");
            
            ArrayList args = new ArrayList();
            int i = 1;
            while(rs.next()) {         		
            	WorkOrderSheetCargoReefer wo = new WorkOrderSheetCargoReefer();
            	wo.setReeferSeq(i++); 
				wo.setReefer						("Reefer"						);
				wo.setReeferEqNo				(checkString(rs.getString("rf_eq_no"				))); 
				wo.setReeferTemperatureC	(checkString(rs.getString("rf_temper_c"	))); 
				wo.setReeferTemperatureF	(checkString(rs.getString("rf_temper_f"	))); 
				wo.setReeferVentilation		(checkString(rs.getString("rf_vent"			))); 
				args.add(wo);
            }
            
            
        	result[0] = (WorkOrderSheetCargoReefer[])args.toArray(new WorkOrderSheetCargoReefer[0]);
            result[1] = new Integer(args.size());
					
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchSpecialCargoSummaryReefer");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);  
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return result;
    }
    
    /**
     * searchSpecialCargoSummaryDG Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */

    public Object[] searchSpecialCargoSummaryDG(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];
        
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchSpecialCargoSummaryDG");
            ExpPap0006Event event = (ExpPap0006Event)et;
            String r_vender_cd	= event.getVendorCode(); 
            String r_trsp_wo_no		= event.getWorkOrderNo();	
            
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchSpecialCargoSummaryDG Query-StringBuffer");
            Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no.substring(0,3));
    		param.put("trsp_wo_seq", r_trsp_wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("wo_vndr_seq", r_vender_cd);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchSpecialCargoSummaryDGRSQL template = new WorkOrderSheetDBDAOsearchSpecialCargoSummaryDGRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryDG getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryDG ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchSpecialCargoSummaryDG ExecuteQuery");
            
            ArrayList args = new ArrayList();
            int i = 1;
            while(rs.next()) {         		
            	WorkOrderSheetCargoDg wo = new WorkOrderSheetCargoDg();
            	wo.setDgSeq(i++); 
				wo.setDg					("DG"	);
				wo.setDgEqNo				(checkString(rs.getString("dg_eq_no"					))); 
				wo.setDgHCDG				(checkString(rs.getString("dg_hcdg"						))); 
				wo.setDgUnNo				(checkString(rs.getString("dg_un_no"					))); 
				wo.setDgIMOClass			(checkString(rs.getString("dg_imo_class"				))); 
				wo.setDgSubLabel			(checkString(rs.getString("dg_sub_label"				))); 
				wo.setDgFlashPoint			(checkString(rs.getString("dg_flash_point"				))); 
				wo.setDgPackageGroup		(checkString(rs.getString("dg_pgk_grp"					))); 
				wo.setDgPropShipName		(checkString(rs.getString("dg_prop_ship_nm"				))); 
				wo.setDgHAZContents			(checkString(rs.getString("dg_haz_conts"				))); 
				wo.setDgOuterPkgQtyType		(checkString(rs.getString("dg_outer_pkg_qty_type"		))); 
				wo.setDgInnerPkgQtyType		(checkString(rs.getString("dg_inner_pkg_qty_type"		))); 
				wo.setDgGrossNetWeight		(checkString(rs.getString("dg_gros_net_weight"			))); 
				wo.setDgEmsNo				(checkString(rs.getString("dg_ems_no"					)));
				args.add(wo);
            }
            
        	result[0] = (WorkOrderSheetCargoDg[])args.toArray(new WorkOrderSheetCargoDg[0]);
            result[1] = new Integer(args.size());
			
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchSpecialCargoSummaryDG");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);   
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        
        return result;
    }

    /**
     * searchWorkOrderSheetList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchWorkOrderSheetSecondList(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetSecondList");
            ExpPap0006Event event = (ExpPap0006Event)et;

            String r_vender_cd	= event.getVendorCode();
            String r_trsp_wo_no		= event.getWorkOrderNo();
            String r_wo_fmt_tp_cd  = "";
            
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "Full searchWorkOrderSheetSecondList Query-StringBuffer");
            Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", r_vender_cd);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no.substring(0,3));
    		param.put("trsp_wo_seq", r_trsp_wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("wo_vndr_seq", r_vender_cd);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderSheetDBDAOsearchWorkOrderSheetSecondListRSQL template = new WorkOrderSheetDBDAOsearchWorkOrderSheetSecondListRSQL();	        
    	    
//    		trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheetSecondList getConnection");
//            trcLogUtil.setTraceStart(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheetSecondList ExecuteQuery");
            rs = sqlExe.executeQuery(template,param,velParam);
//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_STEP, "searchWorkOrderSheetSecondList ExecuteQuery");
            
            ArrayList args = new ArrayList();

            int nCnt = 0;
            while(rs.next()) {
            	if(nCnt == 0){
            		r_wo_fmt_tp_cd = (checkString(rs.getString("wo_fmt_tp_cd")));
            	}
            	nCnt++;
            	WorkOrderSheetSecondList wo = new WorkOrderSheetSecondList();
				wo.setEquipmentNumber				(checkString(rs.getString("equipment_number"))); 	
				wo.setTypeSize							(checkString(rs.getString("eq_tpsz_nm"))); 	
				wo.setRemark							(checkString(rs.getString("remark"))); 	
				wo.setQuantity							(checkString(rs.getString("quantity"))); 	
				wo.setRate							(checkString(rs.getString("rate"))); 
				if(log.isDebugEnabled())log.debug("rs  rate => "+checkString(rs.getString("rate"))+"\n wo Rate  "+wo.getRate());
				wo.setEqTpszCd						(checkString(rs.getString("eq_tpsz_cd")));
				args.add(wo);
            }
           
            // 조회결과 FormtType 이 Empty 일때
            if (r_wo_fmt_tp_cd.equals("MM")) {
            	result[0] = (WorkOrderSheetSecondList[])args.toArray(new WorkOrderSheetSecondList[0]);
            	result[1] = new Integer(args.size());
            }
            else {
            	result[0] = null;
            }

//            trcLogUtil.setTraceEnd(TraceLogUtil.TRACE_GROUP, "searchWorkOrderSheetSecondList");
//            trcLogUtil.logWrite(log, TraceLogUtil.LIMIT_TIME_05);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return result;
    }
    
	/**
     * Object가 null일 경우 Blank String으로 반환한다.
     * @param strString 
     * @return String 입력 Object가 null일 경우 "" 반환,
     *         이외의 경우에는 입력 Object의 toString() 반환 
     */
    public static String checkString(String strString)
    {
        if( strString == null || strString.trim().equals("") )
        	return "";
        
        return strString;
    }
    /**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
}

