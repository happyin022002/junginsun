/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderInboxDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-05-07 sung hwan cho : Reject Count 오류로 인한 수정
* 2007-05-25 sung hwan cho : SO의 delt_flg가 Y인 경우 조회되지 않도록 수정
* 2007-07-27 Jung-Jae Kim : W/O 중 내부 invoice 처리 목적으로 발급된 W/O에 대한 SP 포탈 표시 금지.
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
* 2007-09-04 Jung-Jae Kim : so.wo_rjct_flg 부분은 무시
*@LastModifyDate : 2007-09-04
*@LastModifier : Jung-Jae Kim
**@LastVersion : 1.5
* 2006-12-20 doomi
* 1.0 최초 생성
==========================================================
History
2012.09.05 윤권영 [CHM-201219971]Master user의 조회 권한 추가
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.ArrayList;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.core.layer.event.Event;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderInboxList;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0001Event;

//import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.TraceLogUtil;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.integration.AvailabilityDBDAO;
import com.hanjin.apps.alps.esd.trs.servicesio.availability.integration.AvailabilityDBDAOsearchAvailabilityPeriodListRSQL;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see WSInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderInboxDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
//	private TraceLogUtil trcLogUtil = new TraceLogUtil("WORKORDER");
	
    /**
     * searchWorkOrderPeriodList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchWorkOrderPeriodList(Event et) throws DAOException {
        Object[] result = new Object[2];
        DBRowSet rs = null;
        try {
            ExpPap0001Event event = (ExpPap0001Event)et;
            
            String r_vender_cd					= event.getVendorCode();
			String r_cre_dt_from				= event.getDisp_dt_from();
			String r_cre_dt_to					= event.getDisp_dt_to();
			String r_wo_status					= event.getWo_status();
			String r_wo_iss_sts_cd			 	= event.getIssue_type_cd();
			String r_invoiced_cd		 		= event.getInvoiced_cd(); 	

			String r_trsp_cost_dtl_mod_cd	 	= event.getTrsp_kind_cd	();  	//Transpotation Kind			
			String r_trsp_crr_mod_cd			= event.getTrsp_mode_cd();		//Transpotation Mode
			String r_trsp_so_cmb_tp_cd	 		= event.getTrsp_type_cd();  	//Transpotation Type

			String r_fm_nod_cd					= event.getFm_location_cd();
			String r_to_nod_cd					= event.getTo_location_cd();
			String r_via_nod_cd					= event.getVia_location_cd();
			String r_dor_nod_cd					= event.getDor_location_cd();

			String r_win_cd						= event.getWin_cd();	
			
			String vndr_tmp[] = r_vender_cd.split("-");
			
			if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code");
    		}

    		if(event.getDisp_dt_from() == null || event.getDisp_dt_from().equals("")) {
    			throw new Exception("Please enter Dispatched Date");
    		}

    		if(event.getDisp_dt_to() == null || event.getDisp_dt_to().equals("")) {
    			throw new Exception("Please enter Dispatched Date");
    		}
 			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    	    if (vndr_tmp != null && vndr_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_tmp[1];
    	    }else {
    	    	tmpVndrSeq = vndr_tmp[0];
    	    }
    	    param.put("vndr_seq", tmpVndrSeq);
    		param.put("wo_iss_sts_cd", r_wo_iss_sts_cd);
    		param.put("trsp_crr_mod_cd", r_trsp_crr_mod_cd);
    		param.put("trsp_cost_dtl_mod_cd", r_trsp_cost_dtl_mod_cd);
    		
    		param.put("dor_nod_cd", r_dor_nod_cd);
    		param.put("fm_nod_cd", r_fm_nod_cd);
    		param.put("cre_dt_to", r_cre_dt_to);
    		param.put("via_nod_cd", r_via_nod_cd);
    		param.put("cre_dt_fr", r_cre_dt_from);
    		param.put("to_nod_cd", r_to_nod_cd);
    		param.put("win_cd", r_win_cd);
    		   		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		//velParam.put("vndr_tmp",tmpVndrSeq);
    		velParam.put("r_trsp_so_cmb_tp_cd",r_trsp_so_cmb_tp_cd);
    		velParam.put("r_wo_iss_sts_cd",r_wo_iss_sts_cd);
    		velParam.put("r_wo_status",r_wo_status);
    		velParam.put("r_trsp_cost_dtl_mod_cd",r_trsp_cost_dtl_mod_cd);
    		velParam.put("r_trsp_crr_mod_cd",r_trsp_crr_mod_cd);
    		velParam.put("r_fm_nod_cd",r_fm_nod_cd);
    		velParam.put("r_to_nod_cd",r_to_nod_cd);
    		velParam.put("r_via_nod_cd",r_via_nod_cd);
    		velParam.put("r_dor_nod_cd",r_dor_nod_cd);
    		velParam.put("r_invoiced_cd",r_invoiced_cd);
    		velParam.put("r_win_cd",r_win_cd);
    		
    		List<String> tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(tmpVndrSeq, ","); 
			velParam.put("sp_cd", tmpArrList);
			
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderInboxDBDAOsearchWorkOrderPeriodListRSQL template = new WorkOrderInboxDBDAOsearchWorkOrderPeriodListRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            int i = 1;
            ArrayList args = new ArrayList();
            while(rs.next()) {
            	WorkOrderInboxList wo = new WorkOrderInboxList();
     			wo.setSeq(i++);
        		wo.setTrsp_so_no(checkString(rs.getString("trsp_so_no"))); 				
        		wo.setIssue_type_cd(checkString(rs.getString("Issue_type_cd"))); 
				wo.setIssue_type_nm(checkString(rs.getString("Issue_type_nm"))); 
				wo.setTrsp_wo_no(checkString(rs.getString("trsp_wo_no"))); 
				
				wo.setTrsp_kind_cd(checkString(rs.getString("trsp_cost_dtl_mod_cd"))); 
				wo.setTrsp_kind_nm(checkString(rs.getString("trsp_kind_nm"))); 
				wo.setTrsp_mode_cd(checkString(rs.getString("trsp_crr_mod_cd"))); 				
				wo.setTrsp_mode_nm(checkString(rs.getString("trsp_mode_nm"))); 				
	            wo.setTrsp_type_cd(checkString(rs.getString("trsp_so_cmb_tp_cd"))); 
	            wo.setTrsp_type_nm(checkString(rs.getString("trsp_type_nm"))); 			
				wo.setDisp_dt(checkString(rs.getString("cre_dt"))); 
				
				//칼럼 추가 할 예정. 삭제요망.
				//New : W/O 발급되고 Trucker 가 조회하지 않은 경우
				//Opend : W/O 발급되고 Trucker 가 조회한 경우 (W/O SPP USE FLAG 필요)
				//Appointment Time Set up : W/O 모든 Container(S/O)의 Appointment Time Setup
				//Delivery Time Set up : W/O 모든 Container(S/O)의 Delivery Time Setup
				if (rs.getString("Issue_type_cd").equals("N")) {
					wo.setWo_status("Open");
				}else {
					if (!checkString(rs.getString("de_dt")).equals("")) {
						wo.setWo_status("Delivery Time Set up");
						
					}else if (!checkString(rs.getString("apnt_dt")).equals("")) {
						wo.setWo_status("Appointment Time Set up");
					}else if (!checkString(rs.getString("wo_opn_flg")).equals("")) {
						wo.setWo_status("Open");
					}else {
						wo.setWo_status("New");
					}
				}
				wo.setWo_reject(checkString(rs.getString("wo_rjct_flg"))); 	
				wo.setInvoiced_flg(checkString(rs.getString("invoiced_flg"))); 	
				wo.setTrsp_so_tp_cd(checkString(rs.getString("trsp_so_tp_cd")));
				wo.setOb_vvd_cd(checkString(rs.getString("ob_vvd_cd")));
				wo.setVendorCode(checkString(rs.getString("wo_vndr_seq")));
				wo.setBidFlg(checkString(rs.getString("bid_flg")));
        		args.add(wo);
            }
            
            result[0] = (WorkOrderInboxList[])args.toArray(new WorkOrderInboxList[0]);
            result[1] = new Integer(args.size());
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return result;
    }

    /** searchWorkOrderNoList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchWorkOrderNoList(Event et) throws DAOException {
        Object[] result = new Object[2];
        DBRowSet rs = null;
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchWorkOrderPeriodList");
            ExpPap0001Event event = (ExpPap0001Event)et;
            
            String r_vender_cd		= event.getVendorCode();
			String r_trsp_wo_no		= event.getTrsp_wo_no();
			String r_eq_tp_cd		= event.getEq_tp_cd();
    		String r_eq_no			= event.getEq_no();
    		String r_bid_no			= event.getBid_no();
    		String r_bkg_no			= event.getBkg_no();
    		String r_bl_no			= event.getBl_no();
    		String vndr_tmp[] 		= r_vender_cd.split("-");
			
			if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter Vendor Code");
    		}

			if( (r_trsp_wo_no == null || r_trsp_wo_no.equals(""))
					&& (r_eq_tp_cd == null || r_eq_tp_cd.equals(""))
					&& (r_eq_no == null || r_eq_no.equals(""))
					&& (r_bkg_no == null || r_bkg_no.equals(""))
					&& (r_bl_no == null || r_bl_no.equals(""))
					) {
    			throw new Exception("Please enter Vendor Code 2");
    		}
 			log.debug("r_vender_cd : " +r_vender_cd);
 			log.debug("r_trsp_wo_no : " + r_trsp_wo_no);
 			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = r_vender_cd.startsWith("M-")?"M":"S";
    		
    		log.debug("vndr_tmp.length : " + vndr_tmp.length);
    		
    	   if (vndr_tmp != null && vndr_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_tmp[1];
    	    	tmpVndrDvsn = vndr_tmp[0];
    	    	log.debug("vndr_tmp[0] : " + vndr_tmp[0]);
    	    	log.debug("vndr_tmp[1] : " + vndr_tmp[1]);
    	    }else {
    	    	tmpVndrSeq = vndr_tmp[0];
    	    }
    		param.put("vndr_seq", tmpVndrSeq);
    	    param.put("vndr_dvsn", tmpVndrDvsn);
    	    param.put("eq_knd_cd", r_eq_tp_cd);
    	      		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		List<String> tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_eq_no, ","); 
			velParam.put("eq_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_bid_no, ","); 
			velParam.put("bid_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_bkg_no, ","); 
			velParam.put("bkg_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_bl_no, ","); 
			velParam.put("bl_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_trsp_wo_no, ","); 
			velParam.put("trsp_wo_ofc_cty_cd", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(tmpVndrSeq, ","); 
			velParam.put("sp_cd", tmpArrList);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderInboxDBDAOsearchWorkOrderNoListRSQL template = new WorkOrderInboxDBDAOsearchWorkOrderNoListRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
            
            int i = 1;
            ArrayList args = new ArrayList();
            while(rs.next()) {
            	WorkOrderInboxList wo = new WorkOrderInboxList();
     			wo.setSeq(i++);
        		wo.setTrsp_so_no(checkString(rs.getString("trsp_so_no"))); 				
        		wo.setIssue_type_cd(checkString(rs.getString("Issue_type_cd"))); 
				wo.setIssue_type_nm(checkString(rs.getString("Issue_type_nm"))); 
				wo.setTrsp_wo_no(checkString(rs.getString("trsp_wo_no"))); 
				
				wo.setTrsp_kind_cd(checkString(rs.getString("trsp_cost_dtl_mod_cd"))); 
				wo.setTrsp_kind_nm(checkString(rs.getString("trsp_kind_nm"))); 
				wo.setTrsp_mode_cd(checkString(rs.getString("trsp_crr_mod_cd"))); 				
				wo.setTrsp_mode_nm(checkString(rs.getString("trsp_mode_nm"))); 				
	            wo.setTrsp_type_cd(checkString(rs.getString("trsp_so_cmb_tp_cd"))); 
	            wo.setTrsp_type_nm(checkString(rs.getString("trsp_type_nm"))); 			
				wo.setDisp_dt(checkString(rs.getString("cre_dt"))); 
				
				//칼럼 추가 할 예정. 삭제요망.
				//New : W/O 발급되고 Trucker 가 조회하지 않은 경우
				//Opend : W/O 발급되고 Trucker 가 조회한 경우 (W/O SPP USE FLAG 필요)
				//Appointment Time Set up : W/O 모든 Container(S/O)의 Appointment Time Setup
				//Delivery Time Set up : W/O 모든 Container(S/O)의 Delivery Time Setup
				if (rs.getString("Issue_type_cd").equals("N")) {
					wo.setWo_status("Open");
				}else {
					if (!checkString(rs.getString("de_dt")).equals("")) {
						wo.setWo_status("Delivery Time Set up");
					}else if (!checkString(rs.getString("apnt_dt")).equals("")) {
						wo.setWo_status("Appointment Time Set up");
					}else if (!checkString(rs.getString("wo_opn_flg")).equals("")) {
						wo.setWo_status("Open");
					}else {
						wo.setWo_status("New");
					}
				}
				wo.setWo_reject(checkString(rs.getString("wo_rjct_flg"))); 	
				wo.setInvoiced_flg(checkString(rs.getString("invoiced_flg"))); 	
				wo.setTrsp_so_tp_cd(checkString(rs.getString("trsp_so_tp_cd")));
				wo.setOb_vvd_cd(checkString(rs.getString("ob_vvd_cd")));
				wo.setVendorCode(checkString(rs.getString("wo_vndr_seq")));
				wo.setBidFlg(checkString(rs.getString("bid_flg")));
	    		args.add(wo);
            }
            
            result[0] = (WorkOrderInboxList[])args.toArray(new WorkOrderInboxList[0]);
            result[1] = new Integer(args.size());
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return result;
    }

    /**
     * searchInboxExcelHeader Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * @param et 이벤트객체
     * @return
     * @throws DAOException
     */
    public Object searchInboxExcelHeader(Event et) throws DAOException {
    	Object result = new Object();
        DBRowSet rs = null;
        try {
            ExpPap0001Event event = (ExpPap0001Event)et;
            
            String vndr_seq = checkString(event.getVendorCode());
        	String vndr_tmp[] = vndr_seq.split("-");
        	if (vndr_tmp != null && vndr_tmp.length == 2) {
	    		vndr_seq = vndr_tmp[1];
    	    }else {
    	    	vndr_seq = vndr_tmp[0];
    	    }

    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("vndr_seq", vndr_seq);
    	      		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderInboxDBDAOsearchInboxExcelHeaderRSQL template = new WorkOrderInboxDBDAOsearchInboxExcelHeaderRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
            WorkOrderInboxList wo = new WorkOrderInboxList();
            if(rs.next()) {
            	wo.setVendorName	(JSPUtil.getNull(rs.getString("full_name")));
                wo.setVendorAddress	(JSPUtil.getNull(rs.getString("eng_addr")));
                wo.setVendorTelNo	(JSPUtil.getNull(rs.getString("phn_no")));
                wo.setVendorFaxNo	(JSPUtil.getNull(rs.getString("fax_no")));
            }
            result = wo;
            
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
     * searchExcelPrint Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchInboxExcelPrint(Event et) throws DAOException {
    	Object[] result = new Object[2];
        DBRowSet rs = null;
        try {
//        	trcLogUtil.setTraceStart(TraceLogUtil.TRACE_GROUP, "searchInboxExcelPrint");
            ExpPap0001Event event = (ExpPap0001Event)et;
            
            String workOrderNo		 	= event.getWorkOrderNo();
            String vndrSeq		 	    = checkString(event.getVendorCode());
            String vndr_tmp[] = vndrSeq.split("-");
            
    		if(vndrSeq.indexOf("-")>-1 && !"M".equals(vndr_tmp[0])){
	    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
	    			throw new Exception("Please enter Vendor Code.");
	    		}
    		}
    		if (vndr_tmp != null && vndr_tmp.length == 2) {
    			vndrSeq = vndr_tmp[1];
    	    }else {
    	    	vndrSeq = vndr_tmp[0];
    	    }
    		
    		//if (vndrSeq.indexOf("-")>-1){
    		//	vndrSeq = vndr_tmp[0].equals("M")?"":vndr_tmp[1];
    		//}
 			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("vndr_seq", vndrSeq);
    	      		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(workOrderNo, ","); 
			velParam.put("wo_no", tmpArrList);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderInboxDBDAOsearchInboxExcelRSQL template = new WorkOrderInboxDBDAOsearchInboxExcelRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
           
            int i = 1;
            ArrayList args = new ArrayList();
            WorkOrderInboxList wo = new WorkOrderInboxList(); 
            String f = "";
            String o = "";
            String c = "";
            //ArrayList bkgNoList = new ArrayList();
            //ArrayList cntrNoList = new ArrayList();
            while(rs.next()) {
            	wo = new WorkOrderInboxList();        		
        		wo.setSeq(i++);
        		
				f = checkString(rs.getString("f" ));
				o = checkString(rs.getString("o" ));
				c = checkString(rs.getString("c" ));
				
        		wo.setTrsp_so_no(checkString(rs.getString("trsp_so_no"))); 				
        		wo.setIssue_type_cd(checkString(rs.getString("Issue_type_cd"))); 
				wo.setIssue_type_nm(checkString(rs.getString("Issue_type_nm"))); 
				wo.setTrsp_wo_no(checkString(rs.getString("trsp_wo_no"))); 
				wo.setTrsp_kind_cd(checkString(rs.getString("trsp_cost_dtl_mod_cd"))); 
				wo.setTrsp_kind_nm(checkString(rs.getString("trsp_kind_nm"))); 
				wo.setTrsp_mode_cd(checkString(rs.getString("trsp_crr_mod_cd"))); 				
				wo.setTrsp_mode_nm(checkString(rs.getString("trsp_mode_nm"))); 				
	            wo.setTrsp_type_cd(checkString(rs.getString("trsp_so_cmb_tp_cd"))); 
	            wo.setTrsp_type_nm(checkString(rs.getString("trsp_type_nm"))); 			
				wo.setDisp_dt(checkString(rs.getString("cre_dt"))); 		
				if (rs.getString("Issue_type_cd").equals("N")) {
					wo.setWo_status("Open");
				}else {
					if (!checkString(rs.getString("de_dt")).equals("")) {
						wo.setWo_status("Delivery Time Set up");
					}else if (!checkString(rs.getString("apnt_dt")).equals("")) {
						wo.setWo_status("Appointment Time Set up");
					}else if (!checkString(rs.getString("wo_opn_flg")).equals("")) {
						wo.setWo_status("Open");
					}else {
						wo.setWo_status("New");
					}
				}
				wo.setWo_reject(checkString(rs.getString("wo_rjct_flg"))); 	
				wo.setInvoiced_flg(checkString(rs.getString("invoiced_flg"))); 	
				wo.setFrom_yard			( checkString(rs.getString("fm_nod_cd")));				
				wo.setTo_yard			( checkString(rs.getString("via_nod_cd")));	
				wo.setPkup_yard			( checkString(rs.getString("dor_nod_cd")) );
				wo.setReturn_yard		( checkString(rs.getString("to_nod_cd")) );
			 	wo.setCntr_no			( checkString(rs.getString("eq_no")));				
			 	wo.setCntr_tpsz			( checkString(rs.getString("eq_tpsz_cd")));				
			 	wo.setCntr_wgt			( checkString(rs.getString("cntr_wgt")));				
			 	wo.setVendorCode		( checkString(rs.getString("vndr_seq")));	
			 	wo.setVendorName		( checkString(rs.getString("vndr_nm")));
				wo.setWo_basic_amt		( rs.getInt("bzc_amt"));		
			 	wo.setInv_etc_add_amt	( rs.getInt("inv_etc_add_amt"));                
				wo.setInv_amt			( rs.getInt("inv_amt"));			
				wo.setInv_office_cd		( checkString(rs.getString("inv_no")));				
				wo.setInv_cnfm_yn		( checkString(rs.getString("inv_cnfm")));    
				wo.setSpp_inv_act_sts_nm( checkString(rs.getString("spp_trsp_inv_sts_nm")));	
				wo.setBkg_no			( checkString(rs.getString("bkg_no")));				
				wo.setBl_no				( checkString(rs.getString("bl_no")));    
				wo.setVvd_no			( checkString(rs.getString("vvd_no")));					
				wo.setTrsp_bnd_cd		( checkString(rs.getString("trsp_bnd_cd")));			
				wo.setIss_office_cd		( checkString(rs.getString("iss_office")));			
				wo.setIss_usr			( checkString(rs.getString("iss_user")));		
				wo.setRemark			( checkString(rs.getString("remark")));                         
				wo.setShpr_cust_nm		( checkString(rs.getString("shpr_cust_nm")));		
				wo.setCnee_cust_nm		( checkString(rs.getString("cnee_cust_nm")));			
				wo.setLst_loc_cd		( checkString(rs.getString("lst_loc_cd")));				
				wo.setPre_dis_use_flg	( checkString(rs.getString("pre_dis_use_flg")));	
				wo.setWo_office_cd		( checkString(rs.getString("cre_ofc_cd")));			
				wo.setWo_receiver		( checkString(rs.getString("wo_receiver")));			
				wo.setEmail_dt			( checkString(rs.getString("email_dt")));				
				wo.setInv_office_cd		( checkString(rs.getString("inv_office")));			
				wo.setInv_usr			( checkString(rs.getString("inv_usr" )));	

				wo.setFreight_collect_flg(f);	
				wo.setOriginal_bl_flg   (o);
				wo.setCustoms_flg		(c);
				
				wo.setOb_vvd_cd   			( checkString(rs.getString("ob_vvd_cd")));
				wo.setN1st_nod_pln_dt   	( checkString(rs.getString("n1st_nod_pln_dt")));
				wo.setLst_nod_pln_dt  		( checkString(rs.getString("lst_nod_pln_dt")));
				wo.setSpcl_cgo_cntr_tp_cd   ( checkString(rs.getString("spcl_cgo_cntr_tp_cd")));
				wo.setBkg_qty   			( checkString(rs.getString("bkg_qty")));
				wo.setPod_cd   			    ( checkString(rs.getString("pod_cd")));
				wo.setWo_tot_amt_usd   		( checkString(rs.getString("wo_tot_amt_usd")));
				wo.setInv_curr_cd   		( checkString(rs.getString("inv_curr_cd")));
				wo.setInv_xch_rt   			( checkString(rs.getString("inv_xch_rt")));
				wo.setAval_dt(checkString(rs.getString("aval_dt")));		
				wo.setFree_dt(checkString(rs.getString("free_dt")));
				wo.setPkup_no(checkString(rs.getString("pkup_no")));
				wo.setApnt_dt(checkString(rs.getString("apnt_dt")));
				wo.setDelivery_dt(checkString(rs.getString("de_dt")));
/*				
				if ((f.trim().equals("Y") 
						&& o.trim().equals("Y") 
						&& (c.trim().equals("Y") || c.trim().equals("W")) ) 
						&& (rs.getString("pkup_no") != null && !"".equals(rs.getString("pkup_no")))
						&& !checkString(rs.getString("free_dt")).equals("")){
					
					wo.setPkup_no(checkString(rs.getString("pkup_no")));	//Pickup Number
					
					// first release date insert
					//   masterSPP로 로긴할 때는 update 안되도록 막음. 
					if(vndr_tmp != null){
						if(vndr_tmp.length == 2 && "S".equals(vndr_tmp[0])){
							bkgNoList.add(wo.getBkg_no());
							cntrNoList.add(wo.getCntr_no());
						}
					}
		     	}else{
					wo.setPkup_no("");	//Pickup Number
				}
*/				
				args.add(wo);
				wo = null;
            }
            /*
            if (!bkgNoList.isEmpty()) {
	    		AvailabilityDBDAO avltDao = new AvailabilityDBDAO();
				avltDao.updFirstRlsDt(bkgNoList,cntrNoList);
    		}
    		
    		bkgNoList = null;
			cntrNoList = null;
*/
            result[0] = (WorkOrderInboxList[])args.toArray(new WorkOrderInboxList[0]);
            result[1] = new Integer(args.size());
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
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

