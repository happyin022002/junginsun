/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetailDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-05-07 sung hwan cho, Global Time 적용시 MDM_VENDOR에서 WO의 CRE_OFC_CD 사용으로 변경
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
* 2007-08-13 Jung-Jae Kim : TRS 요청에 의해 bkg_no, bkg_no_split 추가.
* 2007-09-04 Jung-Jae Kim : so.wo_rjct_flg 부분은 무시
*@LastModifyDate : 2007-09-04
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.4
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
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
import com.hanjin.syscommon.common.table.TrsTrspSoPkupCntrVO;

import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailSubmitRejectList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailTitle;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetail;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.common.document.WorkOrderDetailExcelUploadList;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration.InvoiceCreationDetailDBDAOsaveMultiInvoiceNoCSQL;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration.InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL;

import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0002Event;
import com.hanjin.apps.alps.esd.trs.servicesio.workorder.event.ExpPap0007Event;

//import com.hanjin.apps.alps.esd.trs.servicesio.railbilling.common.TraceLogUtil;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see WSInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetailDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
		
    /**
     * searchWorkOrderPeriodList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchWorkOrderDetailList(Event et) throws DAOException {
        Object[] result = new Object[2];
        DBRowSet rs = null;

        try {

            ExpPap0002Event event = (ExpPap0002Event)et;

            String r_vender_cd	= event.getVendorCode();            
            String vndr_tmp[] = r_vender_cd.split("-");
			String r_trsp_wo_no		= event.getTrsp_wo_no();
			String r_trsp_wo_seq = "";
			if(r_trsp_wo_no != null && r_trsp_wo_no.length() > 4) {
				r_trsp_wo_seq = r_trsp_wo_no.substring(3,r_trsp_wo_no.length());
				r_trsp_wo_no = r_trsp_wo_no.substring(0,3);
			}
			String user_id = event.getUserID().trim();
			
			if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please enter  VendorCode.");
    		}

    		if(event.getTrsp_wo_no() == null || event.getTrsp_wo_no().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}
					
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = "S";
    	    if (vndr_tmp != null && vndr_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_tmp[1];
    	    	tmpVndrDvsn = vndr_tmp[0];
    	    }else {
    	    	tmpVndrSeq = vndr_tmp[0];
    	    }
    	    param.put("vndr_dvsn", tmpVndrDvsn);
    	    param.put("vndr_seq", tmpVndrSeq);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		param.put("trsp_wo_seq", r_trsp_wo_seq);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderDetailDBDAOsearchWorkOrderDetailListRSQL template = new WorkOrderDetailDBDAOsearchWorkOrderDetailListRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
     
			int i=1;
            ArrayList args = new ArrayList();
            
            while(rs.next()) {
            	if(i == 1) {
            		Map<String, Object> param2 = new HashMap<String, Object>();
            		param2.put("user_id", user_id);
            		param2.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
            		param2.put("trsp_wo_seq", r_trsp_wo_seq);
            		WorkOrderDetailDBDAOupdateWorkOrderOpenFlagUSQL upTemplate = new WorkOrderDetailDBDAOupdateWorkOrderOpenFlagUSQL();
            		sqlExe.executeUpdate(upTemplate, param2,null);
            	}
            	WorkOrderDetailList wo = new WorkOrderDetailList();
            	wo.setSeq(i++);
            	wo.setValidity(checkString(rs.getString("validity"))); 
            	wo.setTrsp_so_no(checkString(rs.getString("trsp_so_no"))); 	
            	wo.setEq_no(checkString(rs.getString("eq_no"))); 		
				wo.setEq_tpsz_cd(checkString(rs.getString("eq_tpsz_cd"))); 	
				wo.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm"))); 	
				wo.setIso_cd(checkString(rs.getString("iso_cd"))); 
				wo.setIso_nm(checkString(rs.getString("iso_nm"))); 
				wo.setApnt_dt(checkString(rs.getString("apnt_dt"))); 		
				wo.setDeli_dt(checkString(rs.getString("de_dt"))); 		
				wo.setReject_rsn(checkString(rs.getString("wo_rjct_rsn"))); 		
				wo.setBkg_no(checkString(rs.getString("bkg_no")));
				wo.setOrg_bkg_no(checkString(rs.getString("org_bkg_no")));
            	wo.setDor_nod_cd(checkString(rs.getString("dor_nod_cd")));
            	wo.setTrsp_bnd_cd(checkString(rs.getString("trsp_bnd_cd")));
    			//2007.12.26 by KJJ
    			//Door SVC type이 'Drop & Pick'인 경우, 
    			//Empty/Full Container#를 SO Table에 I/F 시키기 위한 SQL 변경에 따른 결과값 추가.
            	wo.setDor_pkup_cntr_no(checkString(rs.getString("dor_pkup_cntr_no")));
            	wo.setWo_amt(rs.getDouble("wo_amt"));
            	wo.setWo_cre_dt(checkString(rs.getString("wo_cre_dt")));
            	
            	//2014.04.30
            	// Door Delivery Date 입력시 Local Cop Creation Date Validation을 위해 추가
            	wo.setLocl_cop_cre_dt(checkString(rs.getString("locl_cop_cre_dt")));
            	//2015.09.02
            	// Door Delivery Date 입력시 Local Cop Creation Date Validation을 위해 추가
            	wo.setCnmv_vdsts_dt(checkString(rs.getString("cnmv_vdsts_dt")));
            	
            	//2015.10.07
            	// W/O Detail 에 Bid No 컬럼 추가
            	wo.setSpot_bid_no(checkString(rs.getString("spot_bid_no")));
            	args.add(wo);
            }
            
            result[0] = (WorkOrderDetailList[])args.toArray(new WorkOrderDetailList[0]);
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
     * searchWorkOrderDetail Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * @param et 이벤트객체
     * @return
     * @throws DAOException
     */
    public Object searchWorkOrderDetail(Event et) throws DAOException {
        Object result = null;
        DBRowSet rs = null;
        try {
            ExpPap0002Event event = (ExpPap0002Event)et;

            String r_vender_cd	= event.getVendorCode();		
			String r_trsp_wo_no		= event.getTrsp_wo_no();
			String r_trsp_wo_seq = "";
			if(r_trsp_wo_no != null && r_trsp_wo_no.length() > 4) {
				r_trsp_wo_seq = r_trsp_wo_no.substring(3,r_trsp_wo_no.length());
				r_trsp_wo_no = r_trsp_wo_no.substring(0,3);
			}
			String vndr_tmp[] = r_vender_cd.split("-");
			
    		if(event.getTrsp_wo_no() == null || event.getTrsp_wo_no().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}
   			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = "S";
    	    if (vndr_tmp != null && vndr_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_tmp[1];
    	    	tmpVndrDvsn = vndr_tmp[0];
    	    }else {
    	    	tmpVndrSeq = vndr_tmp[0];
    	    }
    	    param.put("vndr_dvsn", tmpVndrDvsn);
    	    param.put("vndr_seq", tmpVndrSeq);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		param.put("trsp_wo_seq", r_trsp_wo_seq);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL template = new WorkOrderDetailDBDAOsearchWorkOrderDetailRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
			
            while(rs.next()) { 
            	WorkOrderDetail wo = new WorkOrderDetail();            	
            	wo.setFr_code(checkString(rs.getString("fm_code"))); 		
				wo.setFr_full_nm(checkString(rs.getString("fm_full_name"))); 		
				wo.setFr_address(checkString(rs.getString("fm_address"))); 			
				wo.setFr_tel(checkString(rs.getString("fm_tel"))); 						
				wo.setFr_fax(checkString(rs.getString("fm_fax"))); 				
				wo.setFr_pic(checkString(rs.getString("fm_pic"))); 			
				wo.setVia_code(checkString(rs.getString("via_code"))); 		
				wo.setVia_full_nm(checkString(rs.getString("via_full_name"))); 		
				wo.setVia_address(checkString(rs.getString("via_address"))); 			
				wo.setVia_tel(checkString(rs.getString("via_tel"))); 						
				wo.setVia_fax(checkString(rs.getString("via_fax"))); 				
				wo.setVia_pic(checkString(rs.getString("via_pic"))); 			
				wo.setTo_code(checkString(rs.getString("to_code"))); 		
				wo.setTo_full_nm(checkString(rs.getString("to_full_name"))); 		
				wo.setTo_address(checkString(rs.getString("to_address"))); 			
				wo.setTo_tel(checkString(rs.getString("to_tel"))); 						
				wo.setTo_fax(checkString(rs.getString("to_fax"))); 				
				wo.setTo_pic(checkString(rs.getString("to_pic"))); 			
				wo.setDoor_code(checkString(rs.getString("dor_code"))); 		
				wo.setDoor_full_nm(checkString(rs.getString("dor_full_name"))); 		
				wo.setDoor_address(checkString(rs.getString("dor_address"))); 			
				wo.setDoor_tel(checkString(rs.getString("dor_tel"))); 						
				wo.setDoor_fax(checkString(rs.getString("dor_fax"))); 				
				wo.setDoor_pic(checkString(rs.getString("dor_pic")));
				wo.setZn_nm(checkString(rs.getString("zn_nm")));
				result = wo;
            }
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
     * searchWorkOrderDetailTitle Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * @param et 이벤트객체
     * @return
     * @throws DAOException
     */
    public Object searchWorkOrderDetailTitle(Event et) throws DAOException {
        Object result = null;
        DBRowSet rs = null;
        try {
            ExpPap0002Event event = (ExpPap0002Event)et;
            
            String r_vender_cd	= event.getVendorCode();		
            String r_trsp_so_no		= event.getTrsp_so_no();
            String r_trsp_so_seq = "";
			if(r_trsp_so_no != null && r_trsp_so_no.length() > 4) {
				r_trsp_so_seq = r_trsp_so_no.substring(3,r_trsp_so_no.length());
				r_trsp_so_no = r_trsp_so_no.substring(0,3);
			}
			String r_trsp_wo_no		= event.getTrsp_wo_no();
			String r_trsp_wo_seq = "";
			if(r_trsp_wo_no != null && r_trsp_wo_no.length() > 4) {
				r_trsp_wo_seq = r_trsp_wo_no.substring(3,r_trsp_wo_no.length());
				r_trsp_wo_no = r_trsp_wo_no.substring(0,3);
			}
				
			String vndr_tmp[] = r_vender_cd.split("-");
   		
    		if(event.getTrsp_wo_no() == null || event.getTrsp_wo_no().equals("")) {
    			throw new Exception("Please enter WorkOrderNumber");
    		}
    		
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = "S";
    	    if (vndr_tmp != null && vndr_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_tmp[1];
    	    	tmpVndrDvsn = vndr_tmp[0];
    	    }else {
    	    	tmpVndrSeq = vndr_tmp[0];
    	    }
    	    param.put("vndr_dvsn", tmpVndrDvsn);
    	    param.put("vndr_seq", tmpVndrSeq);
    		param.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		param.put("trsp_wo_seq", r_trsp_wo_seq);
    		param.put("trsp_so_ofc_cty_cd", r_trsp_so_no);
    		param.put("trsp_so_seq", r_trsp_so_seq);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("trsp_wo_ofc_cty_cd", r_trsp_wo_no);
    		velParam.put("trsp_so_ofc_cty_cd", r_trsp_so_no);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderDetailDBDAOsearchWorkOrderDetailTitleRSQL template = new WorkOrderDetailDBDAOsearchWorkOrderDetailTitleRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
            
            while(rs.next()) { 
        		WorkOrderDetailTitle wot = new WorkOrderDetailTitle();
        		wot.setIssue_type_nm(checkString(rs.getString("Issue_type_nm"))); 
				wot.setTrsp_wo_no(checkString(rs.getString("trsp_wo_no"))); 
				wot.setTrsp_kind_nm(checkString(rs.getString("trsp_kind_nm"))); 
				wot.setTrsp_mode_nm(checkString(rs.getString("trsp_mode_nm"))); 				
	            wot.setTrsp_type_nm(checkString(rs.getString("trsp_type_nm"))); 			
				wot.setDisp_dt(checkString(rs.getString("cre_dt"))); 	
				wot.setDoor_svc_type_cd(checkString(rs.getString("dor_svc_tp_cd")));
				wot.setTrsp_cre_ofc_cd(checkString(rs.getString("cre_ofc_cd")));
				wot.setTrsp_cre_usr_eml(checkString(rs.getString("cre_usr_eml")));
				
				result = wot;
            }
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
     * 
     * @param et
     * @return
     * @throws DAOException
     */
    public String searchWorkOrderLocalTime(Event et) throws DAOException {
    	DBRowSet rs = null;        
        WorkOrderDetailSubmitRejectList[] detailSubmitReject = null;
        String so_no = null;
        String local_time = null;
        
        try {
        	ExpPap0002Event event = (ExpPap0002Event)et;

	        detailSubmitReject 		= event.getWorkOrderDetailSubmitRejectList();
	        
	        for ( int i=0; detailSubmitReject != null && i<detailSubmitReject.length; i++ ) {
	        	if(detailSubmitReject[i] != null && detailSubmitReject[i].getSo_no() != null 
	        			&& !"".equals(detailSubmitReject[i].getSo_no()) && !"null".equals(detailSubmitReject[i].getSo_no())){
	        		so_no = detailSubmitReject[i].getSo_no();
	        	}
	        }
	        
	        if(detailSubmitReject == null){
	        	so_no = (String)event.getTrsp_so_no();
	        }
	        
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String so_no_seq = "";
    		if(so_no != null && so_no.length() > 0){
    			so_no_seq = so_no.substring(3);
    			so_no = so_no.substring(0,3);
    		}
    		param.put("trsp_so_ofc_cty_cd", so_no);
    		param.put("trsp_so_seq", so_no_seq);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderDetailDBDAOsearchWorkOrderLocalTimeRSQL template = new WorkOrderDetailDBDAOsearchWorkOrderLocalTimeRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
			
            if(rs.next()) { 
            	local_time = checkString(rs.getString("lcl_time"));
            }
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
        
        return local_time;
    }    
	
    
  	/**
	 * WorkOrderDetail 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param et Event
	 * @return
	 * @throws DAOException
	 */
	public int modifyWorkOrderDetail(Event et)  throws DAOException {
	    int resultCount = 0;
        boolean isUpdate = false ;
        boolean isInsertSce = false ; 
        ExpPap0002Event event = null;
        WorkOrderDetailSubmitRejectList[] detailSubmitReject = null;
        
        DBRowSet rs = null;
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        String tmpFlg = "";
        String tmpCntrNo = "";
        String tmpActDtInfo = "";
        
		try {
	        event = (ExpPap0002Event)et;
	        detailSubmitReject 		= event.getWorkOrderDetailSubmitRejectList();
	    
	        String local_time = searchWorkOrderLocalTime(event);
	        ArrayList iModifyWorkOrderDetail = new ArrayList();
    		ArrayList uModifyWorkOrderDetail = new ArrayList();
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		WorkOrderDetailDBDAOmodifyWorkOrderDetailUSQL uTemplate = new WorkOrderDetailDBDAOmodifyWorkOrderDetailUSQL();	        
    		WorkOrderDetailDBDAOmodifyWorkOrderDetailCSQL iTemplate = new WorkOrderDetailDBDAOmodifyWorkOrderDetailCSQL();
    		Map<String, Object> uParam = new HashMap<String, Object>();
    		Map<String, Object> iParam = new HashMap<String, Object>();
    		
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = "S";
    		String vndr_seq_tmp[] = event.getVendorCode().split("-");
    		if (vndr_seq_tmp != null && vndr_seq_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_seq_tmp[1];
    	    	tmpVndrDvsn = vndr_seq_tmp[0];
    	    }else {
    	    	tmpVndrSeq = vndr_seq_tmp[0];
    	    }
    		
    		int[] uCnt = null,iCnt = null;
			for ( int i=0; i<detailSubmitReject.length; i++ ) {
				uParam = new HashMap<String, Object>();
				iParam = new HashMap<String, Object>();
				
  				log.info("####  event.getEq_no() = " + detailSubmitReject[i].getEq_no());
   				log.info("####  event.getAppointmentTime() = " + detailSubmitReject[i].getAppointmentTime());
   				log.info("####  event.getDeliveryTime() = " + detailSubmitReject[i].getDeliveryTime());
   				log.debug("#### detailSubmitReject["+i+"].getEq_tpsz_cd() >>>> "+detailSubmitReject[i].getEq_tpsz_cd());
   				isUpdate = true;
   				uParam.put("apnt_dt"			, detailSubmitReject[i].getAppointmentTime().trim());
   				uParam.put("de_dt"				, detailSubmitReject[i].getDeliveryTime().trim());
   				uParam.put("eq_no"				, detailSubmitReject[i].getEq_no().trim());
   				uParam.put("upd_usr_id"			, event.getUserID().trim());
   				uParam.put("upd_dt"				, local_time);
   				if(detailSubmitReject[i].getEq_tpsz_cd() == null) {
   					detailSubmitReject[i].setEq_tpsz_cd("");
   				}
   				uParam.put("eq_tpsz_cd"			, detailSubmitReject[i].getEq_tpsz_cd().trim());
   				uParam.put("trsp_so_ofc_cty_cd"	, detailSubmitReject[i].getSo_no().trim().substring(0,3));
   				uParam.put("trsp_so_seq"		, detailSubmitReject[i].getSo_no().trim().substring(3));
   				
   				uModifyWorkOrderDetail.add(uParam);
   				// EQ_no , DeliveryTime 존재여부확인
				if(!detailSubmitReject[i].getEq_no().equals("") && detailSubmitReject[i].getEq_no() != null &&
						!detailSubmitReject[i].getDeliveryTime().equals("") && detailSubmitReject[i].getDeliveryTime() != null 	) {
					isInsertSce = true;
					
					iParam.put("cntr_no"			, detailSubmitReject[i].getEq_no().trim());
					iParam.put("act_dt"				, detailSubmitReject[i].getDeliveryTime().trim());
					iParam.put("bkg_no"				, detailSubmitReject[i].getBkg_no().trim());
					iParam.put("nod_cd"				, detailSubmitReject[i].getDor_nod_cd().trim());
					iParam.put("act_sts_mapg_cd"	, detailSubmitReject[i].getTrsp_bnd_cd().trim());
					iParam.put("vndr_nm"			, event.getUserID().trim()+"(WORKORDER)");
					iParam.put("act_gdt"			, local_time);
					iParam.put("vndr_seq"			, tmpVndrSeq);
					iParam.put("user_id"			, event.getUserID());
					log.debug("#### event.getVendorCode() >>>> "+tmpVndrSeq);
					iModifyWorkOrderDetail.add(iParam);

				}				
				
				if (detailSubmitReject[i].getTrsp_bnd_cd().trim().equalsIgnoreCase("I") && detailSubmitReject[i].getDeliveryTime().trim() != null && !"".equals(detailSubmitReject[i].getDeliveryTime().trim()) && isInsertSce) {
					param.put("in_act_dt", detailSubmitReject[i].getDeliveryTime().trim());
					param.put("bkg_no", detailSubmitReject[i].getBkg_no().trim());
					param.put("cntr_no", detailSubmitReject[i].getEq_no().trim());
					
					WorkOrderDetailDBDAOactualTimeVerificationRSQL template = new WorkOrderDetailDBDAOactualTimeVerificationRSQL();
					rs = sqlExe.executeQuery(template,param,velParam);
					
					if (rs.next()) {
						tmpFlg = rs.getString("RV").toString();
						tmpCntrNo = rs.getString("CNTR_NO").toString();
						tmpActDtInfo = rs.getString("PRE_ACT_DT_INFO").toString();
					}
					
					if ("N".equals(tmpFlg)) {
						throw new Exception("Please check delivery date & time you input. \\n" + tmpCntrNo + " gated out at " + tmpActDtInfo + ".");
					}
				}
	 	        
		        // Loggable Statement 사용에 의해 추가 
		        if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
		            if(isUpdate) 	log.info("\n updateSQL : \n" + uTemplate.getSQL());
	            	if(isInsertSce){
		            	log.info("\n insertSceSQL : \n" + iTemplate.getSQL());
		            }
		            
		        }
			}
	        
            if ( isUpdate )		{  
            	uCnt = sqlExe.executeBatch(uTemplate, uModifyWorkOrderDetail, null);
            	resultCount = 1;  
            }
                
            if ( isInsertSce )	{  
            	iCnt = sqlExe.executeBatch(iTemplate, iModifyWorkOrderDetail, null);
            	resultCount = 1;   
            }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			if(event == null) {
				log.error("modifyWorkOrderDetail ======> EXP_PAP_002Event is null");
			} else {
				log.error("modifyWorkOrderDetail ======> EXP_PAP_002Event is not null");
				log.error("  event.getUserID           [" + event.getUserID() + "]");
				log.error("  event.getParentVendorCode [" + event.getParentVendorCode() + "]");
				log.error("  event.getVendorCode       [" + event.getVendorCode() + "]");
				log.error("  event.getTrsp_wo_no       [" + event.getTrsp_wo_no() + "]");
				log.error("  event.getTrsp_so_no       [" + event.getTrsp_so_no() + "]");
				log.error("  event.getEq_no            [" + event.getEq_no() + "]");
				log.error("  event.getWorkOrderNo      [" + event.getWorkOrderNo() + "]");
				log.error("  event.getSubmitMode       [" + event.getSubmitMode() + "]");
				log.error("  event.getUserID           [" + event.getUserID() + "]");
				if(detailSubmitReject == null) {
					log.error("  modifyWorkOrderDetail.WorkOrderDetailSubmitRejectList ======> detailSubmitReject is null");
				}else {
					log.error("  modifyWorkOrderDetail.WorkOrderDetailSubmitRejectList ======> detailSubmitReject.length ["+ detailSubmitReject.length +"]");
					for (int i=0;i<detailSubmitReject.length;i++){
						if(detailSubmitReject[i] == null) 
							log.error("  modifyWorkOrderDetail.detailSubmitReject[" + i +"] is null");
							
						log.error("    detailSubmitReject.getEq_no            "+ i +" [" + detailSubmitReject[i].getEq_no() + "]");
						log.error("    detailSubmitReject.getWo_iss_knt       "+ i +" [" + detailSubmitReject[i].getWo_iss_knt() + "]");
						log.error("    detailSubmitReject.getAppointmentTime  "+ i +" [" + detailSubmitReject[i].getAppointmentTime() + "]");
						log.error("    detailSubmitReject.getDeliveryTime     "+ i +" [" + detailSubmitReject[i].getDeliveryTime() + "]");
						log.error("    detailSubmitReject.getRejectReason     "+ i +" [" + detailSubmitReject[i].getRejectReason() + "]");
						log.error("    detailSubmitReject.getBkg_no           "+ i +" [" + detailSubmitReject[i].getBkg_no() + "]");
						log.error("    detailSubmitReject.getDor_nod_cd       "+ i +" [" + detailSubmitReject[i].getDor_nod_cd() + "]");
						log.error("    detailSubmitReject.getTrsp_bnd_cd      "+ i +" [" + detailSubmitReject[i].getTrsp_bnd_cd() + "]");
						log.error("    detailSubmitReject.getEq_tpsz_cd       "+ i +" [" + detailSubmitReject[i].getEq_tpsz_cd() + "]");
						log.error("    detailSubmitReject.getDor_pkup_cntr_no "+ i +" [" + detailSubmitReject[i].getDor_pkup_cntr_no() + "]");
						log.error("    ==============================================");
					}
				}
			}
			throw new DAOException(e.getMessage());
		}
		
		return resultCount;
	}
	
    /**
     * searchDetailExcelPrint Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchDetailExcelPrint(Event et) throws DAOException {
    	DBRowSet rs = null;
        
        Object[] result = new Object[2];

        try {
            ExpPap0002Event event = (ExpPap0002Event)et;
	
			String r_trsp_so_no			= event.getTrsp_so_no();		
			
			
	   		if(event.getTrsp_so_no() == null || event.getTrsp_so_no().equals("")) {
    			throw new Exception("Please enter ServiceOrderNumber");
    		}

	   		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(r_trsp_so_no, ","); 
			velParam.put("trsp_so_no", tmpArrList);
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderDetailDBDAOsearchDetailExcelPrintRSQL template = new WorkOrderDetailDBDAOsearchDetailExcelPrintRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

			int i=1;
            ArrayList args = new ArrayList();
            while(rs.next()) {
            	WorkOrderDetailList woList = new WorkOrderDetailList();
            	woList.setSeq(i++);
            	woList.setValidity(checkString(rs.getString("validity"))); 
				woList.setEq_no(checkString(rs.getString("eq_no"))); 		
				woList.setEq_tpsz_cd(checkString(rs.getString("eq_tpsz_cd"))); 	
				woList.setEq_tpsz_nm(checkString(rs.getString("eq_tpsz_nm"))); 	
				woList.setIso_cd(checkString(rs.getString("iso_cd"))); 
				woList.setIso_nm(checkString(rs.getString("iso_nm"))); 
				woList.setApnt_dt(checkString(rs.getString("apnt_dt"))); 		
				woList.setDeli_dt(checkString(rs.getString("de_dt"))); 		
				woList.setReject_rsn(checkString(rs.getString("wo_rjct_rsn")));
				woList.setWo_amt(rs.getDouble("wo_amt"));
				woList.setSpot_bid_no(checkString(rs.getString("spot_bid_no")));
            	args.add(woList);
            }
            
            result[0] = (WorkOrderDetailList[])args.toArray(new WorkOrderDetailList[0]);
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
     * searchDetailExcelUpload Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchDetailExcelUpload(Event et) throws DAOException {
    	DBRowSet rs = null;
        Object[] result = new Object[2];
        
        
        try {
            ExpPap0007Event event = (ExpPap0007Event)et;

            ArrayList args = new ArrayList();
			String[] eq_no = event.getEq_no().replaceAll(" ", "").split(",");
			log.info("Eq_no.length :" + eq_no.length);
			
			// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		WorkOrderDetailDBDAOsearchDetailExcelUploadRSQL template = new WorkOrderDetailDBDAOsearchDetailExcelUploadRSQL();
			for ( int i=0; i<eq_no.length; i++ ) {
				rs = null;
				param = new HashMap<String, Object>();
	    		param.put("cntr_no",eq_no[i].trim());
	            
	            rs = sqlExe.executeQuery(template,param,velParam);
	            WorkOrderDetailExcelUploadList wo = new WorkOrderDetailExcelUploadList();
	            if (rs.next()) {  
	              	wo.setEq_no(checkString(rs.getString("cntr_no"))); 		
	  				wo.setEq_tpsz_cd(checkString(rs.getString("cntr_tpsz_cd"))); 	
	            }
	            else 
	            {
	  	        	wo.setEq_no(eq_no[i].trim());		
	  				wo.setEq_tpsz_cd("");	
	  	     	}
	            args.add(wo);
			}//end for. 
			
            result[0] = (WorkOrderDetailExcelUploadList[])args.toArray(new WorkOrderDetailExcelUploadList[0]);
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
	 * @return ArrayList
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

