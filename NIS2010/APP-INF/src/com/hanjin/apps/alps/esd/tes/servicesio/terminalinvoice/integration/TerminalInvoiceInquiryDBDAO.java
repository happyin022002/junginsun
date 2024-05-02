/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TerminalInvoiceInquiryDBDAO.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.component.rowset.DBRowSet;

import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalInvoiceDiscrepancyCntrList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.MarineTerminalStorageInvoiceDiscrepancyCntrList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.OffDockCYInvoiceDiscrepancyCntrList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0006Event;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.TerminalInvoiceInquiryList;
import com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event.SppTes0005Event;


/**
 * SPP_TES에 대한 DB 처리를 담당<br>
 * - SPP_TES Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author doomi
 * @see TerminalInvoiceInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class TerminalInvoiceInquiryDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
	
		
    /**
     * searchTerminalInvoiceList Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * 2008-04-17 by KJJ 개정
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */
    public Object[] searchTerminalInvoiceList(Event et) throws DAOException {

    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {
            SppTes0005Event event = (SppTes0005Event)et;
            
            String r_vendorCode			= event.getVendorCode();
            String r_dateGubun			= event.getDateGubun();
			String r_fromDt				= event.getFromDt();
			String r_toDt				= event.getToDt();
			String r_invoiceStatus		= event.getInvoiceStatus();
			String r_invoiceNo		 	= event.getInvoiceNo(); 	
			
    		if(event.getVendorCode() == null || event.getVendorCode().equals("")) {
    			throw new Exception("Please endter Vendor Code.");
    		}
    		
    		Map<String, Object> param = new HashMap<String, Object>();
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		if (!r_vendorCode.equals("")) {
    			param.put("r_vendorCode", r_vendorCode.trim());
    			velParam.put("r_vendorCode",r_vendorCode.trim());
    		}
    		if (!r_invoiceStatus.equals("")) {
    			param.put("r_invoiceStatus", r_invoiceStatus.trim());
    			velParam.put("r_invoiceStatus",r_invoiceStatus.trim());
    		}
    		if (!r_dateGubun.equals("")) {
    			param.put("r_dateGubun", r_dateGubun.trim());
    			velParam.put("r_dateGubun",r_dateGubun.trim());
    		}
    		if (!r_fromDt.equals("") && !r_toDt.equals("")) {
    			param.put("r_fromDt", r_fromDt.trim());
    			param.put("r_toDt", r_toDt.trim());
    			velParam.put("r_fromDt",r_fromDt.trim());
    			velParam.put("r_toDt",r_toDt.trim());
    		}
    		if (!r_invoiceNo.equals("") && !r_invoiceNo.equals("")) {
    			
    			ArrayList tmpArrList = null;
        		tmpArrList = new ArrayList();
        		tmpArrList = this.seperationParameter(r_invoiceNo, ","); 
        		
    			param.put("r_invoiceNo", tmpArrList);
    			velParam.put("r_invoiceNo",tmpArrList);
    		}
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceListRSQL template = new TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceListRSQL();
    		
            rs = sqlExe.executeQuery(template,param,velParam);

            int i = 1;
            ArrayList args = new ArrayList();
    		
            while(rs.next()) {
            		TerminalInvoiceInquiryList tm = new TerminalInvoiceInquiryList();	
            		tm.setSeq(i++);
            		tm.setYardCd(checkString(rs.getString("yd_cd")));		
            		tm.setYardNm(checkString(rs.getString("yd_nm")));		
            		tm.setInvoiceNumber(checkString(rs.getString("inv_no")));				
            		tm.setInvoiceCurrency(checkString(rs.getString("curr_cd")));
            		tm.setVatAMT(checkString(rs.getString("vat_amt")));
					tm.setTtlInvAMT(checkString(rs.getString("ttl_inv_amt")));
					tm.setInvoiceTotalAMT(checkString(rs.getString("ttl_amt")));
					tm.setIssuedDate(checkString(rs.getString("iss_dt")));
					tm.setReceivedDate(checkString(rs.getString("rcv_dt")));
					tm.setTml_inv_sts_cd(checkString(rs.getString("tml_inv_sts_cd")));
					tm.setInvoiceStatus(checkString(rs.getString("tml_inv_sts_nm")));
					tm.setRjct_sts(checkString(rs.getString("rjct_sts")));
					tm.setTml_inv_rjct_sts_nm(checkString(rs.getString("tml_inv_rjct_sts_nm")));
					tm.setInv_rjct_rmk(checkString(rs.getString("inv_rjct_rmk")));
					tm.setTes_tml_so_hdr_csr_no(checkString(rs.getString("tes_tml_so_hdr_csr_no")));
					tm.setAp_inv_hdr_csr_no(checkString(rs.getString("ap_inv_hdr_csr_no")));
					tm.setPaymentMethod(checkString(rs.getString("inv_pay_mzd_cd")));				
		            tm.setCheckTTNumber(checkString(rs.getString("inv_chk_trns_no")));
		            tm.setTmlServiceOrderNo(checkString(rs.getString("tmlServiceOrderNo")));
		            tm.setTml_inv_tp_cd(checkString(rs.getString("tml_inv_tp_cd")));
            		args.add(tm);
            }
            
            result[0] = (TerminalInvoiceInquiryList[])args.toArray(new TerminalInvoiceInquiryList[0]);
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
     * searchTerminalInvoiceExcelPrint Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */					
    public Object[] searchTerminalInvoiceExcelPrint(Event et) throws DAOException {

    	DBRowSet rs = null;
        Object[] result = new Object[2];
        
        try {    		
            SppTes0005Event event = (SppTes0005Event)et;
            
    		ArrayList tmpArrList = null;
    		
            String r_serviceOrderNo	= event.getServiceOrderNo();
            
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		tmpArrList = new ArrayList();
    		tmpArrList = this.seperationParameter(r_serviceOrderNo, ","); 
    		velParam.put("r_serviceOrderNo", tmpArrList);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceExcelPrintRSQL template = new TerminalInvoiceInquiryDBDAOSearchTerminalInvoiceExcelPrintRSQL();
    		
            rs = sqlExe.executeQuery(template,null,velParam);

            int i = 1;
            ArrayList args = new ArrayList();
    		
            while(rs.next()) {
            	    TerminalInvoiceInquiryList tm = new TerminalInvoiceInquiryList();	
            		tm.setSeq(i++);
            		tm.setYardCd(checkString(rs.getString("yd_cd")));		
            		tm.setYardNm(checkString(rs.getString("yd_nm")));		
            		tm.setInvoiceNumber(checkString(rs.getString("inv_no")));				
            		tm.setInvoiceCurrency(checkString(rs.getString("curr_cd")));
            		tm.setVatAMT(checkString(rs.getString("vat_amt")));
					tm.setTtlInvAMT(checkString(rs.getString("ttl_inv_amt")));
					tm.setInvoiceTotalAMT(checkString(rs.getString("ttl_amt")));
					tm.setIssuedDate(checkString(rs.getString("iss_dt")));
					tm.setReceivedDate(checkString(rs.getString("rcv_dt")));
					tm.setTml_inv_sts_cd(checkString(rs.getString("tml_inv_sts_cd")));
					tm.setInvoiceStatus(checkString(rs.getString("tml_inv_sts_nm")));
					tm.setRjct_sts(checkString(rs.getString("rjct_sts")));
					tm.setTml_inv_rjct_sts_nm(checkString(rs.getString("tml_inv_rjct_sts_nm")));
					tm.setInv_rjct_rmk(checkString(rs.getString("inv_rjct_rmk")));
					tm.setTes_tml_so_hdr_csr_no(checkString(rs.getString("tes_tml_so_hdr_csr_no")));
					tm.setAp_inv_hdr_csr_no(checkString(rs.getString("ap_inv_hdr_csr_no")));
					tm.setPaymentMethod(checkString(rs.getString("inv_pay_mzd_cd")));				
		            tm.setCheckTTNumber(checkString(rs.getString("inv_chk_trns_no")));
            		args.add(tm);
            }
            
            result[0] = (TerminalInvoiceInquiryList[])args.toArray(new TerminalInvoiceInquiryList[0]);
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
     * searchMarineTerminalInvoiceDiscrepancyCntr Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */	
    public Object[] searchMarineTerminalInvoiceDiscrepancyCntr(Event et) throws DAOException {

    	DBRowSet rs = null;      
        Object[] result = new Object[2];

        try {
            SppTes0006Event event = (SppTes0006Event)et;
            
            String r_tml_so_ofc_cty_cd	= (event.getTml_so_ofc_cty_cd() == null) ? "" : event.getTml_so_ofc_cty_cd();
            String r_tml_so_seq			= (event.getTml_so_seq() == null) ? "" : event.getTml_so_seq();
			String r_seq				= (event.getSeq() == null) ? "" : event.getSeq();
			String r_vsl_cd 			= (event.getVsl_cd() == null) ? "" : event.getVsl_cd();
			String r_skd_voy_no			= (event.getSkd_voy_no() == null) ? "" : event.getSkd_voy_no();
			String r_skd_dir_cd			= (event.getSkd_dir_cd() == null) ? "" : event.getSkd_dir_cd();
			String r_io_bnd_cd			= (event.getIo_bnd_cd() == null) ? "" : event.getIo_bnd_cd();
            
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("r_tml_so_ofc_cty_cd" ,checkString(r_tml_so_ofc_cty_cd));
    		param.put("r_tml_so_seq"	    ,checkString(r_tml_so_seq.trim()));
    		param.put("r_seq"				,checkString(r_seq.trim()));
    		param.put("r_vsl_cd"			,checkString(r_vsl_cd.trim()));
    		param.put("r_skd_voy_no"		,checkString(r_skd_voy_no.trim()));
    		param.put("r_skd_dir_cd"		,checkString(r_skd_dir_cd.trim()));
    		param.put("r_io_bnd_cd"			,checkString(r_io_bnd_cd.trim()));
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		TerminalInvoiceInquiryDBDAOSearchMarineTerminalInvoiceDiscrepancyCntrRSQL template = new TerminalInvoiceInquiryDBDAOSearchMarineTerminalInvoiceDiscrepancyCntrRSQL();
    		
            rs = sqlExe.executeQuery(template,param,null);
            
            ArrayList args = new ArrayList();
            MarineTerminalInvoiceDiscrepancyCntrList tm = null;
            
            while(rs.next()) {
            	tm = new MarineTerminalInvoiceDiscrepancyCntrList();	
        		tm.setTml_so_ofc_cty_cd(checkString(rs.getString("tml_so_ofc_cty_cd")));		
        		tm.setTml_so_seq(checkString(rs.getString("tml_so_seq")));
        		tm.setTml_so_cntr_list_seq(checkString(rs.getString("tml_so_cntr_list_seq")));		
        		tm.setVrfy_rslt_ind_cd(checkString(rs.getString("vrfy_rslt_ind_cd")));				
        		tm.setModi_flg(checkString(rs.getString("modi_flg")));
        		tm.setDscr_ind_cd(checkString(rs.getString("dscr_ind_cd")));
				tm.setDscr_ind_nm(checkString(rs.getString("dscr_ind_nm")));
				tm.setRvis_ind_flg(checkString(rs.getString("rvis_ind_flg")));
				tm.setVsl_cd(checkString(rs.getString("vsl_cd")));
				tm.setSkd_voy_no(checkString(rs.getString("skd_voy_no")));
				tm.setSkd_dir_cd(checkString(rs.getString("skd_dir_cd")));
				tm.setIo_bnd_cd(checkString(rs.getString("io_bnd_cd")));				
	            tm.setIoc_cd(checkString(rs.getString("ioc_cd")));
	            tm.setLane_cd(checkString(rs.getString("lane_cd")));
	            tm.setLane_cd2(checkString(rs.getString("lane_cd2")));
	            tm.setAtb_dt(checkString(rs.getString("atb_dt")));
	            tm.setCntr_no(checkString(rs.getString("cntr_no")));
	            tm.setCntr_tpsz_cd(checkString(rs.getString("cntr_tpsz_cd")));
	            tm.setCntr_sty_cd(checkString(rs.getString("cntr_sty_cd")));
	            tm.setLocl_ts_ind_cd(checkString(rs.getString("locl_ts_ind_cd")));
	            tm.setSam_locl_ts_ind_cd(checkString(rs.getString("sam_locl_ts_ind_cd")));
	            tm.setRcvde_term_ind_cd(checkString(rs.getString("rcvde_term_ind_cd")));
	            tm.setPre_yd_cd(checkString(rs.getString("pre_yd_cd")));
	            tm.setMvmt_gate_in_dt(checkString(rs.getString("mvmt_gate_in_dt")));
	            tm.setInv_gate_in_dt(checkString(rs.getString("inv_gate_in_dt")));
	            tm.setGate_in_td_dys(checkString(rs.getString("gate_in_td_dys")));
	            tm.setMvmt_gate_out_dt(checkString(rs.getString("mvmt_gate_out_dt")));
	            tm.setInv_gate_out_dt(checkString(rs.getString("inv_gate_out_dt")));
	            tm.setGate_out_td_dys(checkString(rs.getString("gate_out_td_dys")));
	            tm.setMvmt_stay_dys(checkString(rs.getString("mvmt_stay_dys")));
	            tm.setInv_stay_dys(checkString(rs.getString("inv_stay_dys")));
	            tm.setStay_diff_dys(checkString(rs.getString("stay_diff_dys")));
	            tm.setDcgo_clss_cd(checkString(rs.getString("dcgo_clss_cd")));
	            tm.setBb_cgo_flg(checkString(rs.getString("bb_cgo_flg")));
	            tm.setWrk_dt(checkString(rs.getString("wrk_dt")));
	            tm.setClm_dt(checkString(rs.getString("clm_dt")));
	            tm.setRail_bil_dt(checkString(rs.getString("rail_bil_dt")));
	            tm.setBkg_no(checkString(rs.getString("bkg_no")));
	            tm.setBl_no(checkString(rs.getString("bl_no")));
	            tm.setDscr_rsn(checkString(rs.getString("dscr_rsn")));
	            tm.setHndl_rslt_rmk(checkString(rs.getString("hndl_rslt_rmk")));
	            tm.setCntr_rmk(checkString(rs.getString("cntr_rmk")));
	            tm.setVvd(checkString(rs.getString("vvd")));
	            tm.setDscr_dtl_ind_cd(checkString(rs.getString("dscr_dtl_ind_cd")));
	            tm.setTml_trns_mod_cd(checkString(rs.getString("tml_trns_mod_cd")));
	            tm.setAwk_cgo_flg(checkString(rs.getString("awk_cgo_flg")));
	            tm.setRc_flg(checkString(rs.getString("rc_flg")));
        		args.add(tm);
            }
            
            if(tm == null && !"".equals(r_seq)){
            	throw new EventException("no more data.");
            }
            
            result[0] = (MarineTerminalInvoiceDiscrepancyCntrList[])args.toArray(new MarineTerminalInvoiceDiscrepancyCntrList[0]);
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
     * searchOffDockCYInvoiceDiscrepancyCntr Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */	
    public Object[] searchOffDockCYInvoiceDiscrepancyCntr(Event et) throws DAOException {

    	DBRowSet rs = null;
        Object[] result = new Object[2];

        try {
            SppTes0006Event event = (SppTes0006Event)et;
            
            String r_tml_so_ofc_cty_cd	= event.getTml_so_ofc_cty_cd();
            String r_tml_so_seq			= event.getTml_so_seq();
            
            Map<String, Object> param = new HashMap<String, Object>();
    		param.put("r_tml_so_ofc_cty_cd", checkString(r_tml_so_ofc_cty_cd));
    		param.put("r_tml_so_seq"	   , checkString(r_tml_so_seq.trim()));
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		TerminalInvoiceInquiryDBDAOSearchOffDockCYInvoiceDiscrepancyCntrRSQL template = new TerminalInvoiceInquiryDBDAOSearchOffDockCYInvoiceDiscrepancyCntrRSQL();
    		
            rs = sqlExe.executeQuery(template,param,null);

            ArrayList args = new ArrayList();
    		
            while(rs.next()) {
            	OffDockCYInvoiceDiscrepancyCntrList tm = new OffDockCYInvoiceDiscrepancyCntrList();	
        		
        		tm.setBb_cgo_flg(checkString(rs.getString("bb_cgo_flg")));		
        		tm.setWrk_dt(checkString(rs.getString("wrk_dt")));
        		tm.setClm_dt(checkString(rs.getString("clm_dt")));		
        		tm.setRail_bil_dt(checkString(rs.getString("rail_bil_dt")));				
        		tm.setDscr_rsn(checkString(rs.getString("dscr_rsn")));
        		tm.setHndl_rslt_rmk(checkString(rs.getString("hndl_rslt_rmk")));
				tm.setCntr_rmk(checkString(rs.getString("cntr_rmk")));
				tm.setCre_usr_id(checkString(rs.getString("cre_usr_id")));
				tm.setCre_dt(checkString(rs.getString("cre_dt")));
				tm.setUpd_usr_id(checkString(rs.getString("upd_usr_id")));
				tm.setUpd_dt(checkString(rs.getString("upd_dt")));
				tm.setTml_so_ofc_cty_cd(checkString(rs.getString("tml_so_ofc_cty_cd")));				
	            tm.setTml_so_seq(checkString(rs.getString("tml_so_seq")));
	            tm.setTml_so_cntr_list_seq(checkString(rs.getString("tml_so_cntr_list_seq")));
	            tm.setVrfy_rslt_ind_cd(checkString(rs.getString("vrfy_rslt_ind_cd")));
	            tm.setModi_flg(checkString(rs.getString("modi_flg")));
	            tm.setDscr_ind_cd(checkString(rs.getString("dscr_ind_cd")));
	            tm.setTml_rvis_ind_flg(checkString(rs.getString("tml_rvis_ind_flg")));
	            tm.setIo_bnd_cd(checkString(rs.getString("io_bnd_cd")));
	            tm.setIoc_cd(checkString(rs.getString("ioc_cd")));
	            tm.setLane_cd(checkString(rs.getString("lane_cd")));
	            tm.setAtb_dt(checkString(rs.getString("atb_dt")));
	            tm.setCntr_no(checkString(rs.getString("cntr_no")));
	            tm.setCntr_tpsz_cd(checkString(rs.getString("cntr_tpsz_cd")));
	            tm.setCntr_sty_cd(checkString(rs.getString("cntr_sty_cd")));
	            tm.setLocl_ts_ind_cd(checkString(rs.getString("locl_ts_ind_cd")));
	            tm.setSam_locl_ts_ind_cd(checkString(rs.getString("sam_locl_ts_ind_cd")));
	            tm.setRcvde_term_ind_cd(checkString(rs.getString("rcvde_term_ind_cd")));
	            tm.setPre_yd_cd(checkString(rs.getString("pre_yd_cd")));
	            tm.setMvmt_gate_in_dt(checkString(rs.getString("mvmt_gate_in_dt")));
	            tm.setInv_gate_in_dt(checkString(rs.getString("inv_gate_in_dt")));
	            tm.setGate_in_td_dys(checkString(rs.getString("gate_in_td_dys")));
	            tm.setMvmt_gate_out_dt(checkString(rs.getString("mvmt_gate_out_dt")));
	            tm.setInv_gate_out_dt(checkString(rs.getString("inv_gate_out_dt")));
	            tm.setGate_out_td_dys(checkString(rs.getString("gate_out_td_dys")));
	            tm.setMvmt_stay_dys(checkString(rs.getString("mvmt_stay_dys")));
	            tm.setInv_stay_dys(checkString(rs.getString("inv_stay_dys")));
	            tm.setStay_diff_dys(checkString(rs.getString("stay_diff_dys")));
	            tm.setAwk_cgo_flg(checkString(rs.getString("awk_cgo_flg")));
	            tm.setRc_flg(checkString(rs.getString("rc_flg")));
	            tm.setDcgo_clss_cd(checkString(rs.getString("dcgo_clss_cd")));
        		args.add(tm);
            }
            
            result[0] = (OffDockCYInvoiceDiscrepancyCntrList[])args.toArray(new OffDockCYInvoiceDiscrepancyCntrList[0]);
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
     * searchMarineTerminalStorageInvoiceDiscrepancyCntr Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     * 
     * @param et 이벤트객체
     * @return Object[]
     * @throws DAOException
     */	
    public Object[] searchMarineTerminalStorageInvoiceDiscrepancyCntr(Event et) throws DAOException {

    	DBRowSet rs = null;       
        Object[] result = new Object[2];

        try {
            SppTes0006Event event = (SppTes0006Event)et;
            
            String r_tml_so_ofc_cty_cd	= event.getTml_so_ofc_cty_cd();
            String r_tml_so_seq			= event.getTml_so_seq();
            
            Map<String, Object> param = new HashMap<String, Object>();
    		param.put("r_tml_so_ofc_cty_cd", checkString(r_tml_so_ofc_cty_cd));
    		param.put("r_tml_so_seq"	   , checkString(r_tml_so_seq.trim()));
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		TerminalInvoiceInquiryDBDAOSearchMarineTerminalStorageInvoiceDiscrepancyCntrRSQL template = new TerminalInvoiceInquiryDBDAOSearchMarineTerminalStorageInvoiceDiscrepancyCntrRSQL();
    		
            rs = sqlExe.executeQuery(template,param,null);
            
            ArrayList args = new ArrayList();
    		
            while(rs.next()) {
            	MarineTerminalStorageInvoiceDiscrepancyCntrList tm = new MarineTerminalStorageInvoiceDiscrepancyCntrList();	
        		tm.setTml_so_ofc_cty_cd(checkString(rs.getString("tml_so_ofc_cty_cd")));		
        		tm.setTml_so_seq(checkString(rs.getString("tml_so_seq")));
        		tm.setTml_so_cntr_list_seq(checkString(rs.getString("tml_so_cntr_list_seq")));		
        		tm.setVrfy_rslt_ind_cd(checkString(rs.getString("vrfy_rslt_ind_cd")));				
        		tm.setModi_flg(checkString(rs.getString("modi_flg")));
        		tm.setDscr_ind_cd(checkString(rs.getString("dscr_ind_cd")));
				tm.setRvis_ind_flg(checkString(rs.getString("rvis_ind_flg")));
				tm.setVsl_cd(checkString(rs.getString("vsl_cd")));
				tm.setSkd_voy_no(checkString(rs.getString("skd_voy_no")));
				tm.setSkd_dir_cd(checkString(rs.getString("skd_dir_cd")));
				tm.setFinc_vsl_cd(checkString(rs.getString("finc_vsl_cd")));
				tm.setFinc_skd_voy_no(checkString(rs.getString("finc_skd_voy_no")));				
	            tm.setFinc_skd_dir_cd(checkString(rs.getString("finc_skd_dir_cd")));
	            tm.setIo_bnd_cd(checkString(rs.getString("io_bnd_cd")));
	            tm.setIoc_cd(checkString(rs.getString("ioc_cd")));
	            tm.setLane_cd(checkString(rs.getString("lane_cd")));
	            tm.setAtb_dt(checkString(rs.getString("atb_dt")));
	            tm.setCntr_no(checkString(rs.getString("cntr_no")));
	            tm.setCntr_tpsz_cd(checkString(rs.getString("cntr_tpsz_cd")));
	            tm.setCntr_sty_cd(checkString(rs.getString("cntr_sty_cd")));
	            tm.setLocl_ts_ind_cd(checkString(rs.getString("locl_ts_ind_cd")));
	            tm.setSam_locl_ts_ind_cd(checkString(rs.getString("sam_locl_ts_ind_cd")));
	            tm.setRcvde_term_ind_cd(checkString(rs.getString("rcvde_term_ind_cd")));
	            tm.setPre_yd_cd(checkString(rs.getString("pre_yd_cd")));
	            tm.setMvmt_gate_in_dt(checkString(rs.getString("mvmt_gate_in_dt")));
	            tm.setInv_gate_in_dt(checkString(rs.getString("inv_gate_in_dt")));
	            tm.setGate_in_td_dys(checkString(rs.getString("gate_in_td_dys")));
	            tm.setMvmt_gate_out_dt(checkString(rs.getString("mvmt_gate_out_dt")));
	            tm.setInv_gate_out_dt(checkString(rs.getString("inv_gate_out_dt")));
	            tm.setGate_out_td_dys(checkString(rs.getString("gate_out_td_dys")));
	            tm.setMvmt_stay_dys(checkString(rs.getString("mvmt_stay_dys")));
	            tm.setInv_stay_dys(checkString(rs.getString("inv_stay_dys")));
	            tm.setStay_diff_dys(checkString(rs.getString("stay_diff_dys")));
	            tm.setDcgo_clss_cd(checkString(rs.getString("dcgo_clss_cd")));
	            tm.setBb_cgo_flg(checkString(rs.getString("bb_cgo_flg")));
	            tm.setWrk_dt(checkString(rs.getString("wrk_dt")));
	            tm.setClm_dt(checkString(rs.getString("clm_dt")));
	            tm.setRail_bil_dt(checkString(rs.getString("rail_bil_dt")));
	            tm.setBkg_no(checkString(rs.getString("bkg_no")));
	            tm.setBl_no(checkString(rs.getString("bl_no")));
	            tm.setDscr_rsn(checkString(rs.getString("dscr_rsn")));
	            tm.setHndl_rslt_rmk(checkString(rs.getString("hndl_rslt_rmk")));
	            tm.setCntr_rmk(checkString(rs.getString("cntr_rmk")));
	            tm.setCre_usr_id(checkString(rs.getString("cre_usr_id")));
	            tm.setCre_dt(checkString(rs.getString("cre_dt")));
	            tm.setUpd_usr_id(checkString(rs.getString("upd_usr_id")));
	            tm.setUpd_dt(checkString(rs.getString("upd_dt")));
        		args.add(tm);
            }
            
            result[0] = (MarineTerminalStorageInvoiceDiscrepancyCntrList[])args.toArray(new MarineTerminalStorageInvoiceDiscrepancyCntrList[0]);
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

