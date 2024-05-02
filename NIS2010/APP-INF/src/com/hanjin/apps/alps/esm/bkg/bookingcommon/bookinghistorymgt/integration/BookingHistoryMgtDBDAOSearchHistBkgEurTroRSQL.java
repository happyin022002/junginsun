/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgEurTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgEurTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgEurTroRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgEurTroRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hlg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("corr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_in_rt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_trns_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_all_in_rt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t1_doc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trsp_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_hlg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_rtn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_vat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_rev_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgEurTroRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("WITH OLD AS " ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append(", @[tro_seq] TRO_SEQ" ).append("\n"); 
		query.append(", @[rqst_sub_seq] RQST_SUB_SEQ" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[dcgo_seq] DCGO_SEQ" ).append("\n"); 
		query.append(", @[rc_seq] RC_SEQ" ).append("\n"); 
		query.append(", @[awk_cgo_seq] AWK_CGO_SEQ" ).append("\n"); 
		query.append(", @[hlg_tp_cd] HLG_TP_CD" ).append("\n"); 
		query.append(", @[cgo_wgt] CGO_WGT" ).append("\n"); 
		query.append(", @[cntr_pkup_yd_cd] CNTR_PKUP_YD_CD" ).append("\n"); 
		query.append(", @[cntr_pkup_dt] CNTR_PKUP_DT" ).append("\n"); 
		query.append(", @[cntr_rtn_yd_cd] CNTR_RTN_YD_CD" ).append("\n"); 
		query.append(", @[cntr_rtn_dt] CNTR_RTN_DT" ).append("\n"); 
		query.append(", @[eur_trns_tp_cd] EUR_TRNS_TP_CD" ).append("\n"); 
		query.append(", @[drp_off_pkup_yd_cd] DRP_OFF_PKUP_YD_CD" ).append("\n"); 
		query.append(", @[cmdt_cd] CMDT_CD" ).append("\n"); 
		query.append(", @[rep_cmdt_cd] REP_CMDT_CD" ).append("\n"); 
		query.append(", @[rep_cmdt_desc] REP_CMDT_DESC" ).append("\n"); 
		query.append(", @[bkg_trsp_mzd_cd] BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(", @[spcl_instr_rmk] SPCL_INSTR_RMK" ).append("\n"); 
		query.append(", @[tro_proc_cd] TRO_PROC_CD" ).append("\n"); 
		query.append(", @[cxl_flg] CXL_FLG" ).append("\n"); 
		query.append(", @[cstms_clr_no] CSTMS_CLR_NO" ).append("\n"); 
		query.append(", @[all_in_rt_cd] ALL_IN_RT_CD" ).append("\n"); 
		query.append(", @[curr_cd] CURR_CD" ).append("\n"); 
		query.append(", @[vat_flg] VAT_FLG" ).append("\n"); 
		query.append(", @[t1_doc_flg] T1_DOC_FLG" ).append("\n"); 
		query.append(", @[trns_rev_amt] TRNS_REV_AMT" ).append("\n"); 
		query.append(", @[so_cty_cd] SO_CTY_CD" ).append("\n"); 
		query.append(", @[so_seq_no] SO_SEQ_NO" ).append("\n"); 
		query.append(", @[act_cnt_cd] ACT_CNT_CD" ).append("\n"); 
		query.append(", @[act_cust_seq] ACT_CUST_SEQ" ).append("\n"); 
		query.append(", @[corr_no] CORR_NO" ).append("\n"); 
		query.append(", @[corr_flg] CORR_FLG" ).append("\n"); 
		query.append(", @[cfm_flg] CFM_FLG" ).append("\n"); 
		query.append(", @[cfm_usr_id] CFM_USR_ID" ).append("\n"); 
		query.append(", @[cfm_ofc_cd] CFM_OFC_CD" ).append("\n"); 
		query.append(", @[cfm_dt] CFM_DT" ).append("\n"); 
		query.append(", @[cfm_upd_dt] CFM_UPD_DT" ).append("\n"); 
		query.append(", @[cfm_hlg_tp_cd] CFM_HLG_TP_CD" ).append("\n"); 
		query.append(", @[cfm_all_in_rt_cd] CFM_ALL_IN_RT_CD" ).append("\n"); 
		query.append(", @[cfm_curr_cd] CFM_CURR_CD" ).append("\n"); 
		query.append(", @[cfm_rev_amt] CFM_REV_AMT" ).append("\n"); 
		query.append(", @[cfm_vat_flg] CFM_VAT_FLG" ).append("\n"); 
		query.append(", @[pctl_no] PCTL_NO" ).append("\n"); 
		query.append(", @[cre_ofc_cd] CRE_OFC_CD" ).append("\n"); 
		query.append(", @[add_rev_rmk] ADD_REV_RMK" ).append("\n"); 
		query.append("from dual)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("    , PRE_CTNT" ).append("\n"); 
		query.append("    , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT 'TRO YARD' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.HLG_TP_CD||" ).append("\n"); 
		query.append("                  '/P/UP@['||OLD.CNTR_PKUP_YD_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.CNTR_PKUP_DT||" ).append("\n"); 
		query.append("                  '/RTN@['||OLD.CNTR_RTN_YD_CD||'/'||OLD.CNTR_RTN_DT PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.HLG_TP_CD||" ).append("\n"); 
		query.append("                  '/P/UP@['||NOW.CNTR_PKUP_YD_CD||" ).append("\n"); 
		query.append("                  '/'||TO_CHAR(NOW.CNTR_PKUP_DT, 'YYYY-MM-DD HH24:MI')||" ).append("\n"); 
		query.append("                  '/RTN@['||NOW.CNTR_RTN_YD_CD||" ).append("\n"); 
		query.append("                  '/'||TO_CHAR(NOW.CNTR_RTN_DT, 'YYYY-MM-DD HH24:MI') CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("             , BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO   (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD(+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ  (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO ACTUAL SHIPPER' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.ACT_CNT_CD||OLD.ACT_CUST_SEQ PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.ACT_CNT_CD||NOW.ACT_CUST_SEQ CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("             , BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO   (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD(+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ  (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'TRO RATE' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CURR_CD||" ).append("\n"); 
		query.append("                  '/''MANIFESTED RATE@['||OLD.ALL_IN_RT_CD||" ).append("\n"); 
		query.append("                  '/VAT'||OLD.VAT_FLG||" ).append("\n"); 
		query.append("                  '/T1 DOC'||OLD.T1_DOC_FLG||" ).append("\n"); 
		query.append("                  '/'||OLD.TRNS_REV_AMT PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CURR_CD||" ).append("\n"); 
		query.append("                  '/''MANIFESTED RATE@['||NOW.ALL_IN_RT_CD||" ).append("\n"); 
		query.append("                  '/VAT'||NOW.VAT_FLG||" ).append("\n"); 
		query.append("                  '/T1 DOC'||NOW.T1_DOC_FLG||" ).append("\n"); 
		query.append("                  '/'||NOW.TRNS_REV_AMT CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("             , BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO   (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD(+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.TRO_SEQ  (+) = OLD.TRO_SEQ   " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'ADDITIONAL REMARK' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.CNTR_NO|| '/'||OLD.ADD_REV_RMK PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.CNTR_NO|| '/'||NOW.ADD_REV_RMK CRNT_CTNT" ).append("\n"); 
		query.append("		FROM OLD	" ).append("\n"); 
		query.append("			, BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("		WHERE NOW.BKG_NO   (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("		  AND NOW.IO_BND_CD(+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("		  AND NOW.TRO_SEQ  (+) = OLD.TRO_SEQ	" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'TRO CFM' HIS_CATE_NM" ).append("\n"); 
		query.append("			   ,'TRO SEQ: '||OLD.TRO_SEQ ||', Confirm ' ||OLD.CFM_FLG PRE_CTNT" ).append("\n"); 
		query.append("		       ,'TRO SEQ: '||NOW.TRO_SEQ ||', Confirm ' ||NOW.CFM_FLG CRNT_CTNT" ).append("\n"); 
		query.append("		FROM OLD" ).append("\n"); 
		query.append("			, BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("		WHERE NOW.BKG_NO   (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("		  AND NOW.IO_BND_CD(+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("		  AND NOW.TRO_SEQ  (+) = OLD.TRO_SEQ" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 'TRO CANCEL' HIS_CATE_NM" ).append("\n"); 
		query.append("				, 'TRO SEQ: '||OLD.TRO_SEQ ||', Cancel ' ||OLD.CXL_FLG PRE_CTNT" ).append("\n"); 
		query.append("				, 'TRO SEQ: '||NOW.TRO_SEQ ||', Cancel ' ||NOW.CXL_FLG CRNT_CTNT" ).append("\n"); 
		query.append("		FROM OLD	" ).append("\n"); 
		query.append("			, BKG_EUR_TRO NOW" ).append("\n"); 
		query.append("		WHERE NOW.BKG_NO   (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("		  AND NOW.IO_BND_CD(+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("		  AND NOW.TRO_SEQ  (+) = OLD.TRO_SEQ		" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}