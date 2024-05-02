/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgAwkCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.26 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgAwkCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgAwkCgoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgAwkCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_rt_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtd_ovr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_bkwd_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grav_ctr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("awk_dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_void_slt_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_ga_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_pst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_lf_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pst_lck_pin_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_fwrd_len",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgAwkCgoRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[awk_cgo_seq] AWK_CGO_SEQ" ).append("\n"); 
		query.append(", @[rcv_term_cd] RCV_TERM_CD" ).append("\n"); 
		query.append(", @[de_term_cd] DE_TERM_CD" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[pck_tp_cd] PCK_TP_CD" ).append("\n"); 
		query.append(", @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append(", @[grs_wgt] GRS_WGT" ).append("\n"); 
		query.append(", @[net_wgt] NET_WGT" ).append("\n"); 
		query.append(", @[wgt_ut_cd] WGT_UT_CD" ).append("\n"); 
		query.append(", @[ovr_fwrd_len] OVR_FWRD_LEN" ).append("\n"); 
		query.append(", @[ovr_bkwd_len] OVR_BKWD_LEN" ).append("\n"); 
		query.append(", @[ovr_hgt] OVR_HGT" ).append("\n"); 
		query.append(", @[ovr_lf_len] OVR_LF_LEN" ).append("\n"); 
		query.append(", @[ovr_rt_len] OVR_RT_LEN" ).append("\n"); 
		query.append(", @[ovr_void_slt_qty] OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append(", @[ttl_dim_len] TTL_DIM_LEN" ).append("\n"); 
		query.append(", @[ttl_dim_wdt] TTL_DIM_WDT" ).append("\n"); 
		query.append(", @[ttl_dim_hgt] TTL_DIM_HGT" ).append("\n"); 
		query.append(", @[awk_dcgo_seq] AWK_DCGO_SEQ" ).append("\n"); 
		query.append(", @[cmdt_cd] CMDT_CD" ).append("\n"); 
		query.append(", @[in_ga_flg] IN_GA_FLG" ).append("\n"); 
		query.append(", @[crn_pst_sts_cd] CRN_PST_STS_CD" ).append("\n"); 
		query.append(", @[xtd_ovr_qty] XTD_OVR_QTY" ).append("\n"); 
		query.append(", @[pst_lck_pin_flg] PST_LCK_PIN_FLG" ).append("\n"); 
		query.append(", @[grav_ctr_desc] GRAV_CTR_DESC" ).append("\n"); 
		query.append(", @[stwg_rqst_desc] STWG_RQST_DESC" ).append("\n"); 
		query.append(", @[diff_rmk] DIFF_RMK" ).append("\n"); 
		query.append(", @[rqst_dt] RQST_DT" ).append("\n"); 
		query.append(", @[rqst_usr_id] RQST_USR_ID" ).append("\n"); 
		query.append(", @[spcl_cgo_apro_cd] SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(", @[cntr_vol_qty] CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append(", PRE_CTNT" ).append("\n"); 
		query.append(", CRNT_CTNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'AWKWARD' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.AWK_CGO_SEQ||" ).append("\n"); 
		query.append("'/'||OLD.CNTR_NO||" ).append("\n"); 
		query.append("'/'||TO_CHAR(OLD.OVR_FWRD_LEN,        '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(OLD.OVR_BKWD_LEN,     '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(OLD.OVR_HGT,          '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(OLD.OVR_LF_LEN,       '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(OLD.OVR_RT_LEN,       '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(OLD.OVR_VOID_SLT_QTY, '9999.0')||" ).append("\n"); 
		query.append("'FEU' PRE_CTNT" ).append("\n"); 
		query.append(", NOW.AWK_CGO_SEQ||" ).append("\n"); 
		query.append("'/'||NOW.CNTR_NO||" ).append("\n"); 
		query.append("'/'||TO_CHAR(NOW.OVR_FWRD_LEN,        '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(NOW.OVR_BKWD_LEN,     '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(NOW.OVR_HGT,          '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(NOW.OVR_LF_LEN,       '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(NOW.OVR_RT_LEN,       '99999')||" ).append("\n"); 
		query.append("' CM/'||TO_CHAR(NOW.OVR_VOID_SLT_QTY, '9999.0')||" ).append("\n"); 
		query.append("'FEU' CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("BKG_AWK_CGO_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO    (+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BKG_AWK_CGO NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO     (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW.AWK_CGO_SEQ(+) = OLD.AWK_CGO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}