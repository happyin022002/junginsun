/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgRfCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.26 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgRfCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgRfCgoRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgRfCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pwr_spl_cbl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_apro_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vent_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vent_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_atms_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vltg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_drn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("humid_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("humid_ctrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_atms_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vent_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgRfCgoRSQL").append("\n"); 
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
		query.append(", @[rc_seq] RC_SEQ" ).append("\n"); 
		query.append(", @[cntr_tpsz_cd] CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", @[cntr_no] CNTR_NO" ).append("\n"); 
		query.append(", @[pck_tp_cd] PCK_TP_CD" ).append("\n"); 
		query.append(", @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append(", @[net_wgt] NET_WGT" ).append("\n"); 
		query.append(", @[grs_wgt] GRS_WGT" ).append("\n"); 
		query.append(", @[wgt_ut_cd] WGT_UT_CD" ).append("\n"); 
		query.append(", @[cmdt_cd] CMDT_CD" ).append("\n"); 
		query.append(", @[cmdt_desc] CMDT_DESC" ).append("\n"); 
		query.append(", @[fdo_temp] FDO_TEMP" ).append("\n"); 
		query.append(", @[cdo_temp] CDO_TEMP" ).append("\n"); 
		query.append(", @[cntr_vent_tp_cd] CNTR_VENT_TP_CD" ).append("\n"); 
		query.append(", @[vent_rto] VENT_RTO" ).append("\n"); 
		query.append(", @[cntr_vent_rto] CNTR_VENT_RTO" ).append("\n"); 
		query.append(", @[humid_no] HUMID_NO" ).append("\n"); 
		query.append(", @[diff_rmk] DIFF_RMK" ).append("\n"); 
		query.append(", @[rf_dcgo_seq] RF_DCGO_SEQ" ).append("\n"); 
		query.append(", @[pwr_spl_cbl_flg] PWR_SPL_CBL_FLG" ).append("\n"); 
		query.append(", @[vltg_no] VLTG_NO" ).append("\n"); 
		query.append(", @[ctrl_atms_flg] CTRL_ATMS_FLG" ).append("\n"); 
		query.append(", @[modi_atms_flg] MODI_ATMS_FLG" ).append("\n"); 
		query.append(", @[humid_ctrl_flg] HUMID_CTRL_FLG" ).append("\n"); 
		query.append(", @[cntr_drn_cd] CNTR_DRN_CD" ).append("\n"); 
		query.append(", @[clng_tp_cd] CLNG_TP_CD" ).append("\n"); 
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
		query.append("SELECT 'REEFER' HIS_CATE_NM" ).append("\n"); 
		query.append(", OLD.RC_SEQ||" ).append("\n"); 
		query.append("'/'||OLD.CNTR_NO||" ).append("\n"); 
		query.append("'/'||OLD.CDO_TEMP||" ).append("\n"); 
		query.append("' C/'||OLD.FDO_TEMP||" ).append("\n"); 
		query.append("' F/'||OLD.PWR_SPL_CBL_FLG||" ).append("\n"); 
		query.append("'/'||DECODE(OLD.CNTR_VENT_TP_CD, 'P', '%', 'C', 'CMH') PRE_CTNT" ).append("\n"); 
		query.append(", NOW.RC_SEQ||" ).append("\n"); 
		query.append("'/'||NOW.CNTR_NO||" ).append("\n"); 
		query.append("'/'||NOW.CDO_TEMP||" ).append("\n"); 
		query.append("' C/'||NOW.FDO_TEMP||" ).append("\n"); 
		query.append("' F/'||NOW.PWR_SPL_CBL_FLG||" ).append("\n"); 
		query.append("'/'||DECODE(NOW.CNTR_VENT_TP_CD, 'P', '%', 'C', 'CMH') CRNT_CTNT" ).append("\n"); 
		query.append("FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append(", BKG_RF_CGO_HIS NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO(+)  = OLD.BKG_NO" ).append("\n"); 
		query.append("AND NOW.CORR_NO(+) = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", BKG_RF_CGO NOW" ).append("\n"); 
		query.append("WHERE NOW.BKG_NO(+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOW.RC_SEQ(+) = OLD.RC_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}