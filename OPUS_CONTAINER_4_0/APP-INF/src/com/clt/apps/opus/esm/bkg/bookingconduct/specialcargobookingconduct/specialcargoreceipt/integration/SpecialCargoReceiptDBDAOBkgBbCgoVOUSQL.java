/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgBbCgoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgBbCgoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgBbCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgBbCgoVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scr_dng_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grav_ctr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_lodg_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_instr_desc",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("slng_pnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgBbCgoVOUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_BB_CGO_HIS SET" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(",	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append(",	RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append(",	DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append(",	PCK_QTY = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	DIM_LEN = @[dim_len]" ).append("\n"); 
		query.append(",	DIM_WDT = @[dim_wdt]" ).append("\n"); 
		query.append(",	DIM_HGT = @[dim_hgt]" ).append("\n"); 
		query.append(",	CGO_WGT = @[cgo_wgt]" ).append("\n"); 
		query.append(",	STWG_INSTR_DESC = @[stwg_instr_desc]" ).append("\n"); 
		query.append(",	BB_DCGO_SEQ = @[bb_dcgo_seq]" ).append("\n"); 
		query.append(",	CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append(",	SLNG_PNT_FLG = @[slng_pnt_flg]" ).append("\n"); 
		query.append(",	GRAV_CTR_DESC = @[grav_ctr_desc]" ).append("\n"); 
		query.append(",	PCK_DTL_DESC = @[pck_dtl_desc]" ).append("\n"); 
		query.append(",	CGO_LODG_MZD_CD = @[cgo_lodg_mzd_cd]" ).append("\n"); 
		query.append(",	SCR_DNG_CTNT = @[scr_dng_ctnt]" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC = @[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD = @[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE BKG_BB_CGO SET" ).append("\n"); 
		query.append("BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(",	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append(",	RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append(",	DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append(",	PCK_QTY = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]" ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]" ).append("\n"); 
		query.append(",	WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",	DIM_LEN = @[dim_len]" ).append("\n"); 
		query.append(",	DIM_WDT = @[dim_wdt]" ).append("\n"); 
		query.append(",	DIM_HGT = @[dim_hgt]" ).append("\n"); 
		query.append(",	CGO_WGT = @[cgo_wgt]" ).append("\n"); 
		query.append(",	STWG_INSTR_DESC = @[stwg_instr_desc]" ).append("\n"); 
		query.append(",	BB_DCGO_SEQ = @[bb_dcgo_seq]" ).append("\n"); 
		query.append(",	CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append(",	SLNG_PNT_FLG = @[slng_pnt_flg]" ).append("\n"); 
		query.append(",	GRAV_CTR_DESC = @[grav_ctr_desc]" ).append("\n"); 
		query.append(",	PCK_DTL_DESC = @[pck_dtl_desc]" ).append("\n"); 
		query.append(",	CGO_LODG_MZD_CD = @[cgo_lodg_mzd_cd]" ).append("\n"); 
		query.append(",	SCR_DNG_CTNT = @[scr_dng_ctnt]" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC = @[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	DIFF_RMK = @[diff_rmk]" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD = @[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND	BB_CGO_SEQ = @[bb_cgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}