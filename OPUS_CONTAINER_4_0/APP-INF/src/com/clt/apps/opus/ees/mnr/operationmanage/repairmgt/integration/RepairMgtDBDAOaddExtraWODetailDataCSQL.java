/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RepairMgtDBDAOaddExtraWODetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOaddExtraWODetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert ExtraWODetailData
	  * </pre>
	  */
	public RepairMgtDBDAOaddExtraWODetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rslt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_invt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_lost_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_vrfy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_otr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_dmg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ord_dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_hngr_dtl_offr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_hngr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_offh_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_ut_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_inp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_expn_dtl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_prt_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddExtraWODetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_DTL (" ).append("\n"); 
		query.append("	MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",	MNR_ORD_SEQ" ).append("\n"); 
		query.append(",	ORD_DTL_SEQ" ).append("\n"); 
		query.append(",	COST_CD" ).append("\n"); 
		query.append(",   ACCT_CD" ).append("\n"); 
		query.append(",	COST_DTL_CD" ).append("\n"); 
		query.append(",	MNR_RT_TP_CD" ).append("\n"); 
		query.append(",	MNR_EXPN_DTL_NM" ).append("\n"); 
		query.append(",	EQ_NO" ).append("\n"); 
		query.append(",	EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	RQST_REF_NO" ).append("\n"); 
		query.append(",	MNR_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",	SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(",	SPR_PRT_NO" ).append("\n"); 
		query.append(",	SPR_PRT_NM" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	RPR_RSLT_DT" ).append("\n"); 
		query.append(",	RPR_QTY" ).append("\n"); 
		query.append(",	SPR_PRT_UC_AMT" ).append("\n"); 
		query.append(",	BZC_AMT" ).append("\n"); 
		query.append(",	COST_AMT" ).append("\n"); 
		query.append(",   RPR_OFFH_FLG" ).append("\n"); 
		query.append(",	N3PTY_FLG" ).append("\n"); 
		query.append(",	N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",	ORD_DTL_RMK" ).append("\n"); 
		query.append(",	INV_NO" ).append("\n"); 
		query.append(",	RPR_RQST_SEQ" ).append("\n"); 
		query.append(",	RPR_RQST_VER_NO" ).append("\n"); 
		query.append(",	PAY_INV_SEQ" ).append("\n"); 
		query.append(",	MNR_HNGR_DTL_OFFR_DESC" ).append("\n"); 
		query.append(",	MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append(",	MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append(",	MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append(",	ACT_INVT_QTY" ).append("\n"); 
		query.append(",	MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append(",	MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   BKG_NO" ).append("\n"); 
		query.append(",   TRD_CD" ).append("\n"); 
		query.append(",   MNR_INP_TP_CD" ).append("\n"); 
		query.append(",   VSL_CD" ).append("\n"); 
		query.append(",   SKD_VOY_NO" ).append("\n"); 
		query.append(",   SKD_DIR_CD" ).append("\n"); 
		query.append(",   REV_DIR_CD" ).append("\n"); 
		query.append(",   SLAN_CD  " ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append(",	@[mnr_ord_seq]" ).append("\n"); 
		query.append(",	@[ord_dtl_seq]" ).append("\n"); 
		query.append(",	@[cost_cd]" ).append("\n"); 
		query.append(",   MNR_COMMON_PKG.MNR_GET_ACCT_CD_FNC(@[eq_knd_cd], @[cost_cd], @[eq_tpsz_cd], @[rpr_offh_flg],@[cost_dtl_cd])" ).append("\n"); 
		query.append(",	@[cost_dtl_cd]" ).append("\n"); 
		query.append(",	@[mnr_rt_tp_cd]" ).append("\n"); 
		query.append(",	@[mnr_expn_dtl_nm]" ).append("\n"); 
		query.append(",	@[eq_no]" ).append("\n"); 
		query.append(",	@[eq_tpsz_cd]" ).append("\n"); 
		query.append(",	@[rqst_ref_no]" ).append("\n"); 
		query.append(",	@[mnr_hngr_bar_tp_cd]" ).append("\n"); 
		query.append(",	@[spr_prt_ut_tp_nm]" ).append("\n"); 
		query.append(",	@[spr_prt_no]" ).append("\n"); 
		query.append(",	@[spr_prt_nm]" ).append("\n"); 
		query.append(",	@[yd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[rpr_rslt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[rpr_qty]" ).append("\n"); 
		query.append(",	@[spr_prt_uc_amt]" ).append("\n"); 
		query.append(",	@[bzc_amt]" ).append("\n"); 
		query.append(",	@[cost_amt]" ).append("\n"); 
		query.append(",	@[rpr_offh_flg]" ).append("\n"); 
		query.append(",	@[n3pty_flg]" ).append("\n"); 
		query.append(",	@[n3pty_bil_ttl_amt]" ).append("\n"); 
		query.append(",	@[inv_amt]" ).append("\n"); 
		query.append(",	@[mnr_vrfy_tp_cd]" ).append("\n"); 
		query.append(",	@[ord_dtl_rmk]" ).append("\n"); 
		query.append(",	@[inv_no]" ).append("\n"); 
		query.append(",	@[rpr_rqst_seq]" ).append("\n"); 
		query.append(",	@[rpr_rqst_ver_no]" ).append("\n"); 
		query.append(",	@[pay_inv_seq]" ).append("\n"); 
		query.append(",	@[mnr_hngr_dtl_offr_desc]" ).append("\n"); 
		query.append(",	@[mnr_hngr_trf_cd]" ).append("\n"); 
		query.append(",	@[mnr_hngr_trf_otr_desc]" ).append("\n"); 
		query.append(",	@[mnr_hngr_dmg_qty]" ).append("\n"); 
		query.append(",	@[act_invt_qty]" ).append("\n"); 
		query.append(",	@[mnr_lost_hngr_qty]" ).append("\n"); 
		query.append(",	@[mnr_disp_hngr_qty]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",   @[bkg_no]" ).append("\n"); 
		query.append(",   @[trd_cd]" ).append("\n"); 
		query.append(",   @[mnr_inp_tp_cd]" ).append("\n"); 
		query.append(",   @[vsl_cd]" ).append("\n"); 
		query.append(",   @[skd_voy_no]" ).append("\n"); 
		query.append(",   @[skd_dir_cd]" ).append("\n"); 
		query.append(",   @[rev_dir_cd]" ).append("\n"); 
		query.append(",   @[slan_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}