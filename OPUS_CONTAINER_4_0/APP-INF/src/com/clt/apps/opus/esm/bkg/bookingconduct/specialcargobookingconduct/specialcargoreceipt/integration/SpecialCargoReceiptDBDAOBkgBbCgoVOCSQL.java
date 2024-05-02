/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOBkgBbCgoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2010.01.05 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOBkgBbCgoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgBbCgoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOBkgBbCgoVOCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOBkgBbCgoVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_BB_CGO_HIS (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",	BB_CGO_SEQ" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	DIM_LEN" ).append("\n"); 
		query.append(",	DIM_WDT" ).append("\n"); 
		query.append(",	DIM_HGT" ).append("\n"); 
		query.append(",	CGO_WGT" ).append("\n"); 
		query.append(",	STWG_INSTR_DESC" ).append("\n"); 
		query.append(",	BB_DCGO_SEQ" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	SLNG_PNT_FLG" ).append("\n"); 
		query.append(",	GRAV_CTR_DESC" ).append("\n"); 
		query.append(",	PCK_DTL_DESC" ).append("\n"); 
		query.append(",	CGO_LODG_MZD_CD" ).append("\n"); 
		query.append(",	SCR_DNG_CTNT" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	CORR_NO" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[bkg_no]" ).append("\n"); 
		query.append(",	@[bb_cgo_seq]" ).append("\n"); 
		query.append(",	@[rcv_term_cd]" ).append("\n"); 
		query.append(",	@[de_term_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[dim_len]" ).append("\n"); 
		query.append(",	@[dim_wdt]" ).append("\n"); 
		query.append(",	@[dim_hgt]" ).append("\n"); 
		query.append(",	@[cgo_wgt]" ).append("\n"); 
		query.append(",	@[stwg_instr_desc]" ).append("\n"); 
		query.append(",	@[bb_dcgo_seq]" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[slng_pnt_flg]" ).append("\n"); 
		query.append(",	@[grav_ctr_desc]" ).append("\n"); 
		query.append(",	@[pck_dtl_desc]" ).append("\n"); 
		query.append(",	@[cgo_lodg_mzd_cd]" ).append("\n"); 
		query.append(",	@[scr_dng_ctnt]" ).append("\n"); 
		query.append(",	@[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'TMP0000001'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT INTO BKG_BB_CGO (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",	BB_CGO_SEQ" ).append("\n"); 
		query.append(",	RCV_TERM_CD" ).append("\n"); 
		query.append(",	DE_TERM_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	GRS_WGT" ).append("\n"); 
		query.append(",	NET_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	DIM_LEN" ).append("\n"); 
		query.append(",	DIM_WDT" ).append("\n"); 
		query.append(",	DIM_HGT" ).append("\n"); 
		query.append(",	CGO_WGT" ).append("\n"); 
		query.append(",	STWG_INSTR_DESC" ).append("\n"); 
		query.append(",	BB_DCGO_SEQ" ).append("\n"); 
		query.append(",	CMDT_CD" ).append("\n"); 
		query.append(",	SLNG_PNT_FLG" ).append("\n"); 
		query.append(",	GRAV_CTR_DESC" ).append("\n"); 
		query.append(",	PCK_DTL_DESC" ).append("\n"); 
		query.append(",	CGO_LODG_MZD_CD" ).append("\n"); 
		query.append(",	SCR_DNG_CTNT" ).append("\n"); 
		query.append(",	SPCL_RQST_DESC" ).append("\n"); 
		query.append(",	DIFF_RMK" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[bkg_no]" ).append("\n"); 
		query.append(",	@[bb_cgo_seq]" ).append("\n"); 
		query.append(",	@[rcv_term_cd]" ).append("\n"); 
		query.append(",	@[de_term_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[grs_wgt]" ).append("\n"); 
		query.append(",	@[net_wgt]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[dim_len]" ).append("\n"); 
		query.append(",	@[dim_wdt]" ).append("\n"); 
		query.append(",	@[dim_hgt]" ).append("\n"); 
		query.append(",	@[cgo_wgt]" ).append("\n"); 
		query.append(",	@[stwg_instr_desc]" ).append("\n"); 
		query.append(",	@[bb_dcgo_seq]" ).append("\n"); 
		query.append(",	@[cmdt_cd]" ).append("\n"); 
		query.append(",	@[slng_pnt_flg]" ).append("\n"); 
		query.append(",	@[grav_ctr_desc]" ).append("\n"); 
		query.append(",	@[pck_dtl_desc]" ).append("\n"); 
		query.append(",	@[cgo_lodg_mzd_cd]" ).append("\n"); 
		query.append(",	@[scr_dng_ctnt]" ).append("\n"); 
		query.append(",	@[spcl_rqst_desc]" ).append("\n"); 
		query.append(",	@[diff_rmk]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[spcl_cgo_apro_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}