/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingReqCreateDBDAO
*@FileTitle : RailBilling Request Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.vo.twoParamVO;
import com.clt.apps.opus.esd.trs.servicesio.common.vo.CommonVo;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.CommonUtil;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
//import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.TraceLogger;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0012Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.ExpPap0021Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.inquiry.event.RailBillingInquiry;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.basic.RailBillingReqCreateBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.TrsRailOrderKey;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS 에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author leebh
 * @see RailBillingReqCreateBCImpl 참조
 * @since J2EE 1.4
 */
public class RailBillingInquiryDBDAO extends DBDAOSupport {
//	private TraceLogger  trcLogger  = new TraceLogger("WRS");
    
	/**
	 * Rail Bill Order Inquiry 화면에 대한 조회 이벤트 처리
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchRailBillingInquiry(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        Object[] result = new Object[2];

        try {
        	ExpPap0012Event event = (ExpPap0012Event)et;
        	String vndCd = event.getVender_cd();
        	String userRoleCd = event.getUser_role_cd(); // 2007-10-26 almighty 계정 구분 추가
        	String condType = event.getRailBillingInquiryCond().getCond_type();
        	String[] bkgNoList = event.getRailBillingInquiryCond().getBkg_no();
        	String[] cntrNoList = event.getRailBillingInquiryCond().getCntr_no();
        	String reqFromDt = event.getRailBillingInquiryCond().getReq_from_dt();
        	String reqToDt = event.getRailBillingInquiryCond().getReq_to_dt();
        	String statusCd = event.getRailBillingInquiryCond().getStatus();
        	String cargoType = event.getRailBillingInquiryCond().getCargo_type();
        	
        	if(vndCd == null && Constants.EMPTY.equals(vndCd)) {
        		throw new DAOException("Vendor code is incorrect.");
        	}
        	
        	if(Constants.SEARCH_REQ_DT.equals(condType)) {
        		if(reqFromDt == null || Constants.EMPTY.equals(reqFromDt)) {
        			throw new DAOException("Requested Date is incorrect.");
        		}
        		if(reqToDt == null || Constants.EMPTY.equals(reqToDt)) {
        			throw new DAOException("Requested Date is incorrect.");
        		}
        		
        		if(statusCd != null && !Constants.EMPTY.equals(statusCd)) {
	    			if(!Constants.RB_INQ_REQ.equals(statusCd) && !Constants.RB_INQ_REQ_CXL.equals(statusCd) && !Constants.RB_INQ_BILLED.equals(statusCd) &&
	    			   !Constants.RB_INQ_BILLED_CXL.equals(statusCd) && !Constants.RB_INQ_ACK.equals(statusCd) && !Constants.RB_INQ_CXL_REQ.equals(statusCd) &&
	    			   !Constants.RB_INQ_CXL_REQ_RJT.equals(statusCd) && !Constants.RB_INQ_EDI_ERROR.equals(statusCd) && !Constants.RB_INQ_BILLED_DLT.equals(statusCd) && 
	    			   !Constants.RB_INQ_BILLED_CXL_DLT.equals(statusCd)) {
	    				throw new DAOException("Status is incorrect.");
	    			}
	    		}
        		
        	} else if(Constants.SEARCH_BKG_CNTL.equals(condType)) {
        		if(!((bkgNoList != null && bkgNoList.length > 0) || (cntrNoList != null && cntrNoList.length > 0))) {
        			throw new DAOException("Search condition is incorrect.");
        		}
        	} else {
        		throw new DAOException("Search condition is incorrect.");
        	}
        	
            
        	velParam.put("condType", condType);
        	velParam.put("statusCd", statusCd);
        	velParam.put("userRoleCd", userRoleCd);
        	velParam.put("cargoType", cargoType);
        	velParam.put("bkgNoList", bkgNoList);
        	velParam.put("cntrNoList", cntrNoList);
        	
        	param.put("provVndrSeq", 	vndCd);
        	param.put("reqFromDt", 	reqFromDt);
        	param.put("reqToDt", 	reqToDt);
            param.put("cargoType", 	cargoType);

            RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL rsql = new RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL();
//            trcLogger.queryBegin("RailBillingInquiryDBDAOsearchRailBillingInquiryRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_05, rsql.getSQL());

            // 결과를 Container Array 에 담는다.
            ArrayList args = new ArrayList();
            while(dRs != null && dRs.next()) {
            	
            	// Status Code가 조회조건에 있으면 해당 Status Code만 리턴한다.
            	// where 절 조건이  Status Code가  여러가지로 조회 될수 있어서 추가함
            	if(    Constants.SEARCH_REQ_DT.equals(condType)  
            	    && statusCd != null 
            	    && !Constants.EMPTY.equals(statusCd) 
                    && !statusCd.equals(dRs.getString("status_cd")) ){
                    continue;
            	}
            	
                RailBillingInquiry oDTO = new RailBillingInquiry();
                oDTO.setRow_idx				(dRs.getString("row_idx"));
                oDTO.setSo_ofc_city			(dRs.getString("trsp_so_ofc_cty_cd"));
                oDTO.setSo_seq				(dRs.getString("trsp_so_seq"));
                oDTO.setCargo				(dRs.getString("cgo_tp_nm"));
                oDTO.setBkg_no				(dRs.getString("bkg_no"));
                oDTO.setCntr_no				(dRs.getString("cntr_no"));
                oDTO.setCntr_tpsz_cd		(dRs.getString("cntr_tpsz_cd"));
                oDTO.setCntr_tpsz_nm		(dRs.getString("cntr_tpsz_nm"));
                oDTO.setStatus_cd			(dRs.getString("status_cd"));
                oDTO.setStatus_nm			(dRs.getString("status_nm"));
                oDTO.setRail_org			(dRs.getString("org_splc_loc_nm"));
                oDTO.setRail_dest			(dRs.getString("dest_loc_nm"));
                oDTO.setReq_dt				(dRs.getString("req_dt"));
                oDTO.setRail_bill_dt		(dRs.getDate("rail_bill_dt").toString());
                oDTO.setCncl_dt				(dRs.getString("cncl_dt"));
                oDTO.setCncl_req_rsn		(dRs.getString("cxl_rqst_rsn"));
                oDTO.setCncl_req_rjt_rsn	(dRs.getString("cxl_rqst_rjct_rsn"));
                oDTO.setBil_iss_knt			(dRs.getString("bil_iss_knt"));
                oDTO.setSpcl_instr_rmk	    (dRs.getString("spcl_instr_rmk"));
                oDTO.setRail_ord_rjct_flg   (dRs.getString("rail_ord_rjct_flg"));
                oDTO.setWo_rjct_rsn         (dRs.getString("wo_rjct_rsn"));
                oDTO.setInter_rmk           (dRs.getString("inter_rmk"));
                oDTO.setFm_nod_cd           (dRs.getString("fm_nod_cd"));
                oDTO.setTo_nod_cd           (dRs.getString("to_nod_cd"));
                oDTO.setBl_no               (dRs.getString("bl_no"));
                oDTO.setBkg_cgo_tp_cd       (dRs.getString("bkg_cgo_tp_cd"));
                oDTO.setCop_no              (dRs.getString("cop_no"));
                oDTO.setCost_act_grp_seq    (dRs.getString("cost_act_grp_seq"));
                oDTO.setRepo_pln_id         (dRs.getString("repo_pln_id"));
                oDTO.setPln_yrwk            (dRs.getString("pln_yrwk"));
                oDTO.setRef_id              (dRs.getString("ref_id"));
                oDTO.setRef_seq             (dRs.getString("ref_seq"));
                oDTO.setOfc_cd              (dRs.getString("ofc_cd"));
                oDTO.setCgo_tp_cd       	(dRs.getString("cgo_tp_cd"));
                
                args.add(oDTO);
            }

            // 조회결과
            if (args.size() == 0) {
            	result[0] = null;
            }
            else {
            	result[0] = (RailBillingInquiry[])args.toArray(new RailBillingInquiry[0]);
            }
            result[1] = new Integer(args.size());
        } catch (SQLException se) {
        	log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
        	log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
        	log.error(e.getMessage(), e);
            throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
        } 
        return result;
    }
	
	/**
	 * Rail Bill Order Inquiry Excel 화면에 대한 조회 이벤트 처리
	 * @param et
	 * @return
	 * @throws DAOException
	 */
	public Object[] searchRailBillingInquiryExcel(Event et) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<CommonVo> velParamArr 	= new ArrayList<CommonVo>(); 
		Object[] result = new Object[2];
		
		try {
			ExpPap0021Event event = (ExpPap0021Event)et;
			TrsRailOrderKey[] trsRailOrderKeyList = event.getTrsRailOrderKeyList();
			
			String vndCd = event.getVender_cd();
			String userRoleCd = event.getUser_role_cd();
			
			if(vndCd == null && Constants.EMPTY.equals(vndCd)) {
        		throw new DAOException("Vendor code is incorrect.");
        	}
			
			if(trsRailOrderKeyList == null || trsRailOrderKeyList.length <= 0) {
    			throw new DAOException("No data found.");
    		}
			
			for(int i = 0; i < trsRailOrderKeyList.length; i++) {
				CommonVo paramVO 			= new CommonVo();
				paramVO.setVelParamField1(trsRailOrderKeyList[i].getSo_ofc_city()); 
				paramVO.setVelParamField2(trsRailOrderKeyList[i].getSo_seq()); 
				velParamArr.add(paramVO); 				
			}
	       	
			velParam.put("userRoleCd", userRoleCd);
        	velParam.put("trsRailOrderKey", velParamArr);
                 	
        	param.put("provVndrSeq", 	vndCd);
        	RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL rsql = new RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL();
//            trcLogger.queryBegin("RailBillingInquiryDBDAOsearchRailBillingInquiryExcelRSQL Query");
            dRs = new SQLExecuter("DEFAULT").executeQuery(rsql, param, velParam);
//            trcLogger.queryEnd(TraceLogger.LIMIT_01, rsql.getSQL());
			// 결과를 Container Array 에 담는다.
			ArrayList args = new ArrayList();
			while(dRs != null && dRs.next()) {
				RailBillingInquiry oDTO = new RailBillingInquiry();
				oDTO.setRow_idx				(dRs.getString("row_idx"));
				oDTO.setSo_ofc_city			(dRs.getString("trsp_so_ofc_cty_cd"));
				oDTO.setSo_seq				(dRs.getString("trsp_so_seq"));
				oDTO.setCargo				(dRs.getString("cgo_tp_nm"));
				oDTO.setBkg_no				(dRs.getString("bkg_no"));
				oDTO.setCntr_no				(dRs.getString("cntr_no"));
				oDTO.setCntr_tpsz_cd		(dRs.getString("cntr_tpsz_cd"));
				oDTO.setCntr_tpsz_nm		(dRs.getString("cntr_tpsz_nm"));
				oDTO.setStatus_cd			(dRs.getString("status_cd"));
				oDTO.setStatus_nm			(dRs.getString("status_nm"));
				oDTO.setRail_org			(dRs.getString("org_splc_loc_nm"));
				oDTO.setRail_dest			(dRs.getString("dest_loc_nm"));
				oDTO.setReq_dt				(dRs.getString("req_dt"));
				oDTO.setRail_bill_dt		(dRs.getDate("rail_bill_dt").toString());
				oDTO.setCncl_dt				(dRs.getString("cncl_dt"));
				oDTO.setCncl_req_rsn		(dRs.getString("cxl_rqst_rsn"));
				oDTO.setCncl_req_rjt_rsn	(dRs.getString("cxl_rqst_rjct_rsn"));
				oDTO.setBil_iss_knt			(dRs.getString("bil_iss_knt"));
                oDTO.setSpcl_instr_rmk	    (dRs.getString("spcl_instr_rmk"));
                oDTO.setRail_ord_rjct_flg   (dRs.getString("rail_ord_rjct_flg"));
                oDTO.setWo_rjct_rsn         (dRs.getString("wo_rjct_rsn"));
                oDTO.setInter_rmk           (dRs.getString("inter_rmk"));
                oDTO.setFm_nod_cd           (dRs.getString("fm_nod_cd"));
                oDTO.setTo_nod_cd           (dRs.getString("to_nod_cd"));
                oDTO.setBl_no               (dRs.getString("bl_no"));
                oDTO.setBkg_cgo_tp_cd       (dRs.getString("bkg_cgo_tp_cd"));
                oDTO.setCop_no              (dRs.getString("cop_no"));
                oDTO.setCost_act_grp_seq    (dRs.getString("cost_act_grp_seq"));
                oDTO.setRepo_pln_id         (dRs.getString("repo_pln_id"));
                oDTO.setPln_yrwk            (dRs.getString("pln_yrwk"));
                oDTO.setRef_id              (dRs.getString("ref_id"));
                oDTO.setRef_seq             (dRs.getString("ref_seq"));
                oDTO.setTrsp_rqst_bkg_flg   (dRs.getString("trsp_rqst_bkg_flg"));
                oDTO.setOfc_cd   			(dRs.getString("ofc_cd"));
                oDTO.setCgo_tp_cd       	(dRs.getString("cgo_tp_cd"));
				args.add(oDTO);
			}
			
			// 조회결과
			if (args.size() == 0) {
				result[0] = null;
			}
			else {
				result[0] = (RailBillingInquiry[])args.toArray(new RailBillingInquiry[0]);
			}
			result[1] = new Integer(args.size());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(Constants.UNHANDLED_EXPT_MSG);
		} 
		return result;
	}

}