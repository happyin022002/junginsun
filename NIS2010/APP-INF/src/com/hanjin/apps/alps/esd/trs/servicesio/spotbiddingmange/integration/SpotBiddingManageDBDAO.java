/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAO.java
*@FileTitle : Spot Bidding Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.basic.SpotBiddingManageBCImpl;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSend;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingListSendEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmt;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingLowestAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmt;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingReceiveBiddingAmtEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendAwkwardCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendReeferCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSendDangerCargoInfoEvent;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfo;
import com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event.SpotBiddingSpUsrInfoEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see SpotBiddingManageBCImpl 참조
 * @since J2EE 1.6
 */
public class SpotBiddingManageDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 조회 이벤트 처리<br>
	 * SPP의 조회조건을 I/F받아 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e SpotBiddingListSendEvent
	 * @return SpotBiddingListSend[]
	 * @throws DAOException
	 */
	public SpotBiddingListSend[] sendSpotBiddingList(SpotBiddingListSendEvent e) throws DAOException {
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SpotBiddingListSendEvent event = (SpotBiddingListSendEvent)e;
		SpotBiddingListSend[] spotBiddingListSend = null;
		
		String bid_vndr_seq  = 	event.getBid_vndr_seq();
		String bid_no 		 = 	event.getBid_no();
		String bid_fm_due_dt = 	event.getBid_fm_due_dt();
		String bid_to_due_dt = 	event.getBid_to_due_dt();
		String bid_sts_cd	 = 	event.getBid_sts_cd();
		String bkg_no		 = 	event.getBkg_no();
		String wo_no		 = 	event.getWo_no();
		String win_flg		 = 	event.getWin_flg();
		
		try {		
			param.put("bid_vndr_seq", 	bid_vndr_seq);
			param.put("bid_no", 		bid_no);
			param.put("bid_fm_due_dt",	bid_fm_due_dt);
			param.put("bid_to_due_dt",	bid_to_due_dt);
			param.put("bid_sts_cd", 	bid_sts_cd);
			param.put("bkg_no",			bkg_no);
			param.put("wo_no", 			wo_no);
			param.put("win_flg", 		win_flg);
			
			Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		List<String> tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(bid_no, ","); 
			velParam.put("arr_bid_no", tmpArrList);
			
			tmpArrList  = this.seperationParameter(bkg_no, ","); 
			velParam.put("arr_bkg_no", tmpArrList);
			
			tmpArrList  = this.seperationParameter(wo_no, ","); 
			velParam.put("arr_wo_no", tmpArrList);
			
			velParam.put("arr_bid_fm_due_dt", bid_fm_due_dt);
			velParam.put("arr_bid_to_due_dt", bid_to_due_dt);
			velParam.put("arr_bid_sts_cd", bid_sts_cd);
			velParam.put("win_flg", win_flg);
			
			dbRowset = new SQLExecuter().executeQuery(new SpotBiddingManageDBDAOSearchSendSpotBiddingListRSQL(), param,velParam);
			ArrayList args = new ArrayList();
			while(dbRowset.next()){
				SpotBiddingListSend biddingList = new SpotBiddingListSend();
				
				biddingList.setBid_no(dbRowset.getString("BID_NO"));
				biddingList.setBid_due_dt(dbRowset.getString("BID_DUE_DT"));
				biddingList.setBkg_no(dbRowset.getString("BKG_NO"));
				biddingList.setWo_no(dbRowset.getString("WO_NO"));
				biddingList.setBid_vndr_seq(dbRowset.getString("BID_VNDR_SEQ"));
				biddingList.setEq_no(dbRowset.getString("EQ_NO"));
				biddingList.setEq_tpsz_cd(dbRowset.getString("EQ_TPSZ_CD"));
				biddingList.setTrsp_cost_dtl_mod_cd(dbRowset.getString("TRSP_COST_DTL_MOD_CD"));
				biddingList.setTrsp_crr_mod_cd(dbRowset.getString("TRSP_CRR_MOD_CD"));
				biddingList.setCgo_tp_cd(dbRowset.getString("CGO_TP_CD"));
				biddingList.setSpcl_cgo_cntr_tp_cd(dbRowset.getString("SPCL_CGO_CNTR_TP_CD"));
				biddingList.setTrsp_bnd_cd(dbRowset.getString("TRSP_BND_CD"));
				biddingList.setCntr_kgs_wgt(dbRowset.getString("CNTR_KGS_WGT"));
				biddingList.setCntr_lbs_wgt(dbRowset.getString("CNTR_LBS_WGT"));
				biddingList.setFm_nod_cd(dbRowset.getString("FM_NOD_CD"));
				biddingList.setFm_nod_nm(dbRowset.getString("FM_NOD_NM"));              																																				
				biddingList.setFm_nod_addr(dbRowset.getString("FM_NOD_ADDR"));              																																				
				biddingList.setVia_nod_cd(dbRowset.getString("VIA_NOD_CD"));               																																				
				biddingList.setVia_nod_nm(dbRowset.getString("VIA_NOD_NM"));              																																				
				biddingList.setVia_nod_addr(dbRowset.getString("VIA_NOD_ADDR"));            																																				
				biddingList.setDor_nod_cd(dbRowset.getString("DOR_NOD_CD"));               																																				
				biddingList.setDor_nod_nm(dbRowset.getString("DOR_NOD_NM"));               																																				
				biddingList.setDor_nod_addr(dbRowset.getString("DOR_NOD_ADDR"));
				biddingList.setTo_nod_cd(dbRowset.getString("TO_NOD_CD"));                																																				
				biddingList.setTo_nod_nm(dbRowset.getString("TO_NOD_NM"));                																																				
				biddingList.setTo_nod_addr(dbRowset.getString("TO_NOD_ADDR"));
				biddingList.setFm_dept_dt(dbRowset.getString("FM_DEPT_DT"));
				biddingList.setDor_arvl_dt(dbRowset.getString("DOR_ARVL_DT"));
				biddingList.setTo_arvl_dt(dbRowset.getString("TO_ARVL_DT"));
				biddingList.setLocl_low_bid_curr_cd(dbRowset.getString("LOCL_LOW_BID_CURR_CD"));
				biddingList.setLocl_low_bid_amt(dbRowset.getString("LOCL_LOW_BID_AMT"));
				biddingList.setLow_bid_amt(dbRowset.getString("LOW_BID_AMT"));              																																				
				biddingList.setBid_curr_cd(dbRowset.getString("BID_CURR_CD"));              																																				
				biddingList.setBid_amt(dbRowset.getString("BID_AMT"));                  																																				
				biddingList.setBid_win_flg(dbRowset.getString("BID_WIN_FLG"));
				biddingList.setBid_sts_cd(dbRowset.getString("BID_STS_CD"));
				biddingList.setBid_vndr_sts_cd(dbRowset.getString("BID_VNDR_STS_CD"));     
				
				args.add(biddingList);
			}

			spotBiddingListSend = (SpotBiddingListSend[])args.toArray(new SpotBiddingListSend[0]);
            
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
		return spotBiddingListSend;
	}
	/**
	 * Bidding의 최저가 Bidding Amount를 SPP로 I/F받는다.
	 * 
	 * @param e SpotBiddingLowestAmtEvent
	 * @return SpotBiddingLowestAmt[]
	 * @throws DAOException
	 */
	public SpotBiddingLowestAmt[] sendSpotBiddingLowestAmt(SpotBiddingLowestAmtEvent e) throws DAOException {
		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SpotBiddingLowestAmtEvent event = (SpotBiddingLowestAmtEvent)e;
		SpotBiddingLowestAmt[] spotBiddingLowestAmt = (SpotBiddingLowestAmt[])event.getSpotBiddingLowestAmt();
		List<String> arg_param = new ArrayList();
	
		for(int i = 0 ; spotBiddingLowestAmt != null && i < spotBiddingLowestAmt.length ; i++){
			arg_param.add(spotBiddingLowestAmt[i].getBid_no());
				}
		param.put("vndr_seq", event.getVndr_seq());
		param.put("arr_bid_no", arg_param);

		try {
			dbRowset = new SQLExecuter().executeQuery(new SpotBiddingManageDBDAOSearchSendSpotBiddingLowestAmtRSQL(), param,param);
			ArrayList args = new ArrayList();
			while(dbRowset.next()){
				SpotBiddingLowestAmt biddingLowestAmt = new SpotBiddingLowestAmt();
				biddingLowestAmt.setBid_no(dbRowset.getString("BID_NO"));
				biddingLowestAmt.setBid_curr_cd(dbRowset.getString("BID_CURR_CD"));	
				biddingLowestAmt.setBid_amt(dbRowset.getString("BID_AMT"));
				biddingLowestAmt.setUsd_amt(dbRowset.getString("USD_AMT"));
				biddingLowestAmt.setCurr_dt(dbRowset.getString("CURR_DT"));
				
				args.add(biddingLowestAmt);
			}
			// 조회결과
           spotBiddingLowestAmt = (SpotBiddingLowestAmt[])args.toArray(new SpotBiddingLowestAmt[0]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
		return spotBiddingLowestAmt;
	}
	/**
	 * SPP에서 Bidding Amount를 I/F받는다.
	 * 
	 * @param e SpotBiddingReceiveBiddingAmtEvent
	 * @throws DAOException
	 */
	public void spotBiddingReceiveBiddingAmt(SpotBiddingReceiveBiddingAmtEvent e) throws DAOException {

		SpotBiddingReceiveBiddingAmtEvent event = (SpotBiddingReceiveBiddingAmtEvent) e;
		SpotBiddingReceiveBiddingAmt[] spotBiddingReceiveBiddingAmt = (SpotBiddingReceiveBiddingAmt[])event.getSpotBiddingSendBiddingAmt();
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			for(int i = 0 ; spotBiddingReceiveBiddingAmt != null && i < spotBiddingReceiveBiddingAmt.length ; i++ ){
				log.debug("spotBiddingReceiveBiddingAmt[i].getBid_no("+i+") : " + spotBiddingReceiveBiddingAmt[i].getBid_no());
				
				param.put("bid_no",			spotBiddingReceiveBiddingAmt[i].getBid_no());
				param.put("bid_vndr_seq",	spotBiddingReceiveBiddingAmt[i].getBid_vndr_seq());
				param.put("bid_vndr_sts_cd",spotBiddingReceiveBiddingAmt[i].getBid_vndr_sts_cd());
				param.put("bid_curr_cd",	spotBiddingReceiveBiddingAmt[i].getBid_curr_cd());
				param.put("bid_amt",		spotBiddingReceiveBiddingAmt[i].getBid_amt());
				param.put("bid_usr_id",		spotBiddingReceiveBiddingAmt[i].getBid_usr_id());
				
				new SQLExecuter().executeUpdate(new SpotBiddingManageDBDAOReceiveBiddingAmtUSQL(), param,param);
				
				new SQLExecuter().executeUpdate(new SpotBiddingManageDBDAOReceiveBiddingAmtHisCSQL(), param,param);				
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
	}
	
	/**
	 * SPP에서 User정보를 I/F받아 Vendor의 SPP Flag를 Update한다.
	 * 
	 * @param e SpotBiddingSpUsrInfoEvent
	 * @throws DAOException
	 */
	public void modifySpotBiddingSpUsrInfo(SpotBiddingSpUsrInfoEvent e) throws DAOException {
		
		SpotBiddingSpUsrInfoEvent event = (SpotBiddingSpUsrInfoEvent)e;
		SpotBiddingSpUsrInfo[] spotBiddingSpUsrInfo = (SpotBiddingSpUsrInfo[])event.getSpotBiddingSpUsrInfo();
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			
		
			for(int i = 0 ; spotBiddingSpUsrInfo != null && i < spotBiddingSpUsrInfo.length ; i++ ){
				
			
				param.put("vndr_seq",	spotBiddingSpUsrInfo[i].getVndr_seq());
				param.put("usr_id",		spotBiddingSpUsrInfo[i].getUsr_id());
				param.put("vndr_ofc_cd",spotBiddingSpUsrInfo[i].getVndr_ofc_cd());
				param.put("usr_eml",	spotBiddingSpUsrInfo[i].getUsr_eml());
				param.put("use_flg",	spotBiddingSpUsrInfo[i].getUse_flg());
				param.put("cre_usr_id",	spotBiddingSpUsrInfo[i].getCre_usr_id());
				param.put("cre_ofc_cd",	spotBiddingSpUsrInfo[i].getCre_ofc_cd());
	
				/**
				 * SP I/F받은 데이터를 TRS_SVC_PROV_PTAL_USR_IF에 저장
				 */
				 new SQLExecuter().executeUpdate(new SpotBiddingManageDBDAOInsertSpUsrInfoCSQL(), param,param);
				 /**
				  * TRS_SPOT_BID_CNDDT_VNDR 테이블에 SP_PTAL_EXIST_FLG update
				  */
				 new SQLExecuter().executeUpdate(new SpotBiddingManageDBDAOModifySpExistFlgUSQL(), param,param);
				 /**
				  * TRS_SPOT_BID_CNDDT_VNDR_HIS 테이블에 Insert
				  */
				 new SQLExecuter().executeUpdate(new SpotBiddingManageDBDAOAddSpotBidCnddtVndrHisCSQL(), param,param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
	}
	
	/**
	 * SPP의 조회조건을 I/F받아 Reefer Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e SpotBiddingSendReeferCargoInfoEvent
	 * @return SpotBiddingSendReeferCargoInfoEvent[]
	 * @throws DAOException
	 */
	public SpotBiddingSendReeferCargoInfo[] searchSpotBiddingSendReeferCargoInfo(SpotBiddingSendReeferCargoInfoEvent e) throws DAOException {
		
		DBRowSet dbRowset = null;
		SpotBiddingSendReeferCargoInfo[] spotBiddingSendReeferCargoInfo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SpotBiddingSendReeferCargoInfoEvent event = (SpotBiddingSendReeferCargoInfoEvent)e;
		
		param.put("bkg_no", event.getBkg_no());
		param.put("eq_no", event.getEq_no());

		try {
			dbRowset = new SQLExecuter().executeQuery(new SpotBiddingManageDBDAOSearchReeferCargoInfoRSQL(), param,param);
			ArrayList args = new ArrayList();
			while(dbRowset.next()){
				SpotBiddingSendReeferCargoInfo reeferCargoInfo = new SpotBiddingSendReeferCargoInfo();
				reeferCargoInfo.setBkg_no(dbRowset.getString("BKG_NO"));
				reeferCargoInfo.setEq_no(dbRowset.getString("EQ_NO"));	
				reeferCargoInfo.setCtrl_atms_flg(dbRowset.getString("CTRL_ATMS_FLG"));
				reeferCargoInfo.setModi_atms_flg(dbRowset.getString("MODI_ATMS_FLG"));
				reeferCargoInfo.setHumid_ctrl_flg(dbRowset.getString("HUMID_CTRL_FLG"));
				reeferCargoInfo.setCmdt_cd(dbRowset.getString("CMDT_CD"));
				reeferCargoInfo.setCmdt_nm(dbRowset.getString("CMDT_NM"));
				reeferCargoInfo.setClng_tp_cd(dbRowset.getString("CLNG_TP_CD"));
				reeferCargoInfo.setCdo_temp(dbRowset.getString("CDO_TEMP"));
				reeferCargoInfo.setFdo_temp(dbRowset.getString("FDO_TEMP"));
				reeferCargoInfo.setHumid_no(dbRowset.getString("HUMID_NO"));
				reeferCargoInfo.setVent_rto(dbRowset.getString("VENT_RTO"));
				reeferCargoInfo.setPck_qty(dbRowset.getString("PCK_QTY"));        
				reeferCargoInfo.setPck_tp_cd(dbRowset.getString("PCK_TP_CD"));      
				reeferCargoInfo.setGrs_wgt_tp_cd(dbRowset.getString("GRS_WGT_TP_CD"));  
				reeferCargoInfo.setNet_wgt_tp_cd(dbRowset.getString("NET_WGT_TP_CD")); 
				reeferCargoInfo.setGrs_wgt(dbRowset.getString("GRS_WGT"));        
				reeferCargoInfo.setNet_wgt(dbRowset.getString("NET_WGT"));        
				reeferCargoInfo.setCntr_drn_cd(dbRowset.getString("CNTR_DRN_CD"));    
				reeferCargoInfo.setPwr_spl_cbl_flg(dbRowset.getString("PWR_SPL_CBL_FLG"));
				reeferCargoInfo.setVltg_no(dbRowset.getString("VLTG_NO"));        
				reeferCargoInfo.setDiff_rmk(dbRowset.getString("DIFF_RMK")); 
				
				args.add(reeferCargoInfo);
			}
			// 조회결과
			spotBiddingSendReeferCargoInfo = (SpotBiddingSendReeferCargoInfo[])args.toArray(new SpotBiddingSendReeferCargoInfo[0]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
		return spotBiddingSendReeferCargoInfo;
	}
	
	/**
	 * SPP의 조회조건을 I/F받아 Awkward Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e SpotBiddingSendAwkwardCargoInfoEvent
	 * @return SpotBiddingSendAwkwardCargoInfo[]
	 * @throws DAOException
	 */
	public SpotBiddingSendAwkwardCargoInfo[] searchSpotBiddingSendAwkwardCargoInfo(SpotBiddingSendAwkwardCargoInfoEvent e) throws DAOException {
		
		DBRowSet dbRowset = null;
		SpotBiddingSendAwkwardCargoInfo[] spotBiddingSendAwkwardCargoInfo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SpotBiddingSendAwkwardCargoInfoEvent event = (SpotBiddingSendAwkwardCargoInfoEvent)e;
		
		param.put("bkg_no", event.getBkg_no());
		param.put("eq_no", event.getEq_no());

		try {
			dbRowset = new SQLExecuter().executeQuery(new SpotBiddingManageDBDAOSearchAwkwardCargoInfoRSQL(), param,param);
			ArrayList args = new ArrayList();
			while(dbRowset.next()){
				SpotBiddingSendAwkwardCargoInfo awkwardCargoInfo = new SpotBiddingSendAwkwardCargoInfo();
				awkwardCargoInfo.setBkg_no(dbRowset.getString("BKG_NO"));
				awkwardCargoInfo.setEq_no(dbRowset.getString("EQ_NO"));
				awkwardCargoInfo.setPck_tp_cd(dbRowset.getString("PCK_TP_CD"));
				awkwardCargoInfo.setPck_qty(dbRowset.getString("PCK_QTY"));
				awkwardCargoInfo.setGrs_wgt_tp_cd(dbRowset.getString("GRS_WGT_TP_CD"));  
				awkwardCargoInfo.setNet_wgt_tp_cd(dbRowset.getString("NET_WGT_TP_CD"));
				awkwardCargoInfo.setGrs_wgt(dbRowset.getString("GRS_WGT"));        
				awkwardCargoInfo.setNet_wgt(dbRowset.getString("NET_WGT"));
				awkwardCargoInfo.setCmdt_cd(dbRowset.getString("CMDT_CD"));
				awkwardCargoInfo.setCmdt_nm(dbRowset.getString("CMDT_NM"));
				awkwardCargoInfo.setTtl_dim_len(dbRowset.getString("TTL_DIM_LEN"));        
				awkwardCargoInfo.setTtl_dim_wdt(dbRowset.getString("TTL_DIM_WDT"));
				awkwardCargoInfo.setTtl_dim_hgt(dbRowset.getString("TTL_DIM_HGT"));
				awkwardCargoInfo.setOvr_fwrd_len(dbRowset.getString("OVR_FWRD_LEN"));
				awkwardCargoInfo.setOvr_bkwd_len(dbRowset.getString("OVR_BKWD_LEN"));        
				awkwardCargoInfo.setOvr_hgt(dbRowset.getString("OVR_HGT"));
				awkwardCargoInfo.setOvr_lf_len(dbRowset.getString("OVR_LF_LEN"));
				awkwardCargoInfo.setOvr_rt_len(dbRowset.getString("OVR_RT_LEN"));
				awkwardCargoInfo.setStwg_rqst_desc(dbRowset.getString("STWG_RQST_DESC"));
				awkwardCargoInfo.setOvr_void_slt_qty(dbRowset.getString("OVR_VOID_SLT_QTY"));
				awkwardCargoInfo.setDiff_rmk(dbRowset.getString("DIFF_RMK")); 
				
				args.add(awkwardCargoInfo);
			}
			// 조회결과
			spotBiddingSendAwkwardCargoInfo = (SpotBiddingSendAwkwardCargoInfo[])args.toArray(new SpotBiddingSendAwkwardCargoInfo[0]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
		return spotBiddingSendAwkwardCargoInfo;
	}
	
	/**
	 * SPP의 조회조건을 I/F받아 Danger Cargo 조회결과를 SPP로 I/F해준다.<br>
	 * 
	 * @param e SpotBiddingSendDangerCargoInfoEvent
	 * @return SpotBiddingSendDangerCargoInfo[]
	 * @throws DAOException
	 */
	public SpotBiddingSendDangerCargoInfo[] searchSpotBiddingSendDangerCargoInfo(SpotBiddingSendDangerCargoInfoEvent e) throws DAOException {
		
		DBRowSet dbRowset = null;
		SpotBiddingSendDangerCargoInfo[] spotBiddingSendDangerCargoInfo = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SpotBiddingSendDangerCargoInfoEvent event = (SpotBiddingSendDangerCargoInfoEvent)e;
		
		param.put("bkg_no", event.getBkg_no());
		param.put("eq_no", event.getEq_no());

		try {
			dbRowset = new SQLExecuter().executeQuery(new SpotBiddingManageDBDAOSearchDangerCargoInfoRSQL(), param,param);
			ArrayList args = new ArrayList();
			while(dbRowset.next()){
				SpotBiddingSendDangerCargoInfo dangerCargoInfo = new SpotBiddingSendDangerCargoInfo();
				dangerCargoInfo.setBkg_no(dbRowset.getString("BKG_NO"));
				dangerCargoInfo.setEq_no(dbRowset.getString("EQ_NO"));
				dangerCargoInfo.setDcgo_seq(dbRowset.getString("DCGO_SEQ"));
				dangerCargoInfo.setHcdg_flg(dbRowset.getString("HCDG_FLG"));
				dangerCargoInfo.setImdg_un_no(dbRowset.getString("IMDG_UN_NO"));  
				dangerCargoInfo.setImdg_clss_cd(dbRowset.getString("IMDG_CLSS_CD"));
				dangerCargoInfo.setGrs_wgt(dbRowset.getString("GRS_WGT"));        
				dangerCargoInfo.setNet_wgt(dbRowset.getString("NET_WGT"));
				dangerCargoInfo.setPrp_shp_nm(dbRowset.getString("PRP_SHP_NM"));
				dangerCargoInfo.setHzd_desc(dbRowset.getString("HZD_DESC"));
				dangerCargoInfo.setFlsh_pnt_cdo_temp(dbRowset.getString("FLSH_PNT_CDO_TEMP"));        
				dangerCargoInfo.setCtrl_temp_ctnt(dbRowset.getString("CTRL_TEMP_CTNT"));
				dangerCargoInfo.setEmer_temp_ctnt(dbRowset.getString("EMER_TEMP_CTNT"));
				dangerCargoInfo.setImdg_pck_grp_cd(dbRowset.getString("IMDG_PCK_GRP_CD"));
				dangerCargoInfo.setImdg_subs_rsk_lbl_cd1(dbRowset.getString("IMDG_SUBS_RSK_LBL_CD1"));        
				dangerCargoInfo.setEms_no(dbRowset.getString("EMS_NO"));
				dangerCargoInfo.setImdg_lmt_qty_flg(dbRowset.getString("IMDG_LMT_QTY_FLG"));
				dangerCargoInfo.setMrn_polut_flg(dbRowset.getString("MRN_POLUT_FLG"));
				dangerCargoInfo.setEmer_rspn_gid_no(dbRowset.getString("EMER_RSPN_GID_NO"));
				dangerCargoInfo.setEmer_rspn_gid_chr_no(dbRowset.getString("EMER_RSPN_GID_CHR_NO"));
				dangerCargoInfo.setPsa_no(dbRowset.getString("PSA_NO"));
				dangerCargoInfo.setDcgo_sts_cd(dbRowset.getString("DCGO_STS_CD"));
				dangerCargoInfo.setEmer_cntc_phn_no_ctnt(dbRowset.getString("EMER_CNTC_PHN_NO_CTNT"));
				dangerCargoInfo.setCerti_no(dbRowset.getString("CERTI_NO"));
				dangerCargoInfo.setCnee_dtl_desc(dbRowset.getString("CNEE_DTL_DESC"));
				dangerCargoInfo.setNet_explo_wgt(dbRowset.getString("NET_EXPLO_WGT"));
				dangerCargoInfo.setRada_skd_no(dbRowset.getString("RADA_SKD_NO"));
				dangerCargoInfo.setRada_amt(dbRowset.getString("RADA_AMT"));
				dangerCargoInfo.setRada_ut_cd(dbRowset.getString("RADA_UT_CD"));
				dangerCargoInfo.setRada_trsp_no(dbRowset.getString("RADA_TRSP_NO"));
				dangerCargoInfo.setIn_imdg_pck_qty1(dbRowset.getString("IN_IMDG_PCK_QTY1"));
				dangerCargoInfo.setOut_imdg_pck_cd1(dbRowset.getString("OUT_IMDG_PCK_CD1"));
				dangerCargoInfo.setPck_desc(dbRowset.getString("PCK_DESC"));
				dangerCargoInfo.setMax_in_pck_qty(dbRowset.getString("MAX_IN_PCK_QTY"));
				dangerCargoInfo.setIn_imdg_pck_cd1(dbRowset.getString("IN_IMDG_PCK_CD1"));
				dangerCargoInfo.setPck_desc2(dbRowset.getString("PCK_DESC2"));
				dangerCargoInfo.setDiff_rmk(dbRowset.getString("DIFF_RMK")); 
				
				args.add(dangerCargoInfo);
			}
			// 조회결과
			spotBiddingSendDangerCargoInfo = (SpotBiddingSendDangerCargoInfo[])args.toArray(new SpotBiddingSendDangerCargoInfo[0]);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e1) {
			log.error(e1.getMessage(), e1);
			throw new DAOException(e1.getMessage());
		}
		return spotBiddingSendDangerCargoInfo;
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