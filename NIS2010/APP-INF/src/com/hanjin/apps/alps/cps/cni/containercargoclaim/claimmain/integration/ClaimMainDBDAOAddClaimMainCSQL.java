/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ClaimMainDBDAOAddClaimMainCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOAddClaimMainCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Claim Main 정보 등록
	  * </pre>
	  */
	public ClaimMainDBDAOAddClaimMainCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_plc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_cgo_clm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CLOB + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fact_fnd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmal_clm_rcv_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fmal_clm_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CLOB + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_cuz_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crm_voc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_acknak_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_inci_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.CLOB + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_rvw_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("past_cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_cgo_clm_clz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fact_fnd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tm_bar_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_suit_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_agn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_ropn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_ropn_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_ropn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prlm_clm_ntc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_occr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmal_clm_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_labl_pty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mjr_clm_dmg_lss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cs_clz_ropn_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOAddClaimMainCSQL").append("\n"); 
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
		query.append("INSERT INTO CNI_CGO_CLM (   " ).append("\n"); 
		query.append("   CGO_CLM_NO " ).append("\n"); 
		query.append(",  HDLR_USR_ID " ).append("\n"); 
		query.append(",  HDLR_OFC_CD " ).append("\n"); 
		query.append(",  CS_CLZ_DT " ).append("\n"); 
		query.append(",  CS_CLZ_OFC_CD " ).append("\n"); 
		query.append(",  CS_CLZ_USR_ID " ).append("\n"); 
		query.append(",  TM_BAR_DT " ).append("\n"); 
		query.append(",  PRLM_CLM_NTC_DT " ).append("\n"); 
		query.append(",  CGO_CLM_ACKNAK_DT " ).append("\n"); 
		query.append(",  FACT_FND_DT " ).append("\n"); 
		query.append(",  FACT_FND_DESC " ).append("\n"); 
		query.append(",  TRNS_FLG" ).append("\n"); 
		query.append(",  CS_CLZ_ROPN_FLG " ).append("\n"); 
		query.append(",  CS_CLZ_ROPN_DT " ).append("\n"); 
		query.append(",  CS_CLZ_ROPN_OFC_CD " ).append("\n"); 
		query.append(",  CS_CLZ_ROPN_USR_ID " ).append("\n"); 
		query.append(",  CGO_CLM_DIV_CD " ).append("\n"); 
		query.append(",  CP_DESC " ).append("\n"); 
		query.append(",  CLMT_CLM_PTY_NO " ).append("\n"); 
		query.append(",  CLMT_DESC " ).append("\n"); 
		query.append(",  CLMT_CLM_TP_CD " ).append("\n"); 
		query.append(",  CLMT_REF_NO " ).append("\n"); 
		query.append(",  FMAL_CLM_RCV_OFC_CD " ).append("\n"); 
		query.append(",  FMAL_CLM_RCV_DT " ).append("\n"); 
		query.append(",  FMAL_CLM_RCV_USR_ID " ).append("\n"); 
		query.append(",  CGO_CLM_TP_CD " ).append("\n"); 
		query.append(",  MJR_CLM_DMG_LSS_CD " ).append("\n"); 
		query.append(",  N3RD_LABL_PTY_CD" ).append("\n"); 
		query.append(",  CGO_CLM_INCI_NO " ).append("\n"); 
		query.append(",  CLMT_LOCL_AMT " ).append("\n"); 
		query.append(",  CLMT_LOCL_CURR_CD " ).append("\n"); 
		query.append(",  CLMT_LOCL_XCH_RT " ).append("\n"); 
		query.append(",  CLMT_USD_AMT " ).append("\n"); 
		query.append(",  CLM_CUZ_DESC" ).append("\n"); 
		query.append(",  CLM_RVW_DESC " ).append("\n"); 
		query.append(",  AGN_CLM_PTY_NO " ).append("\n"); 
		query.append(",  CLMT_AGN_TP_CD " ).append("\n"); 
		query.append(",  CLMT_AGN_APNT_DT " ).append("\n"); 
		query.append(",  CLMT_AGN_REF_NO " ).append("\n"); 
		query.append(",  CGO_CLM_RCV_OFC_CD " ).append("\n"); 
		query.append(",  CGO_CLM_SUIT_FLG " ).append("\n"); 
		query.append(",  CLMT_AGN_DESC " ).append("\n"); 
		query.append(",  CGO_CLM_STS_CD " ).append("\n"); 
		query.append(",  BFR_CGO_CLM_STS_CD " ).append("\n"); 
		query.append(",  CGO_CLM_CLZ_CD " ).append("\n"); 
		query.append(",  PRE_CGO_CLM_CLZ_CD " ).append("\n"); 
		query.append(",  CGO_CLM_CXL_FLG " ).append("\n"); 
		query.append(",  PAST_CGO_CLM_NO" ).append("\n"); 
		query.append(",  CRM_VOC_NO " ).append("\n"); 
		query.append(",  INCI_PLC_TP_CD" ).append("\n"); 
		query.append(",  INCI_OCCR_DT" ).append("\n"); 
		query.append(",  CRE_USR_ID " ).append("\n"); 
		query.append(",  CRE_DT " ).append("\n"); 
		query.append(",  UPD_USR_ID " ).append("\n"); 
		query.append(",  UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("   @[cgo_clm_no]" ).append("\n"); 
		query.append(",  @[hdlr_usr_id]" ).append("\n"); 
		query.append(",  @[hdlr_ofc_cd]" ).append("\n"); 
		query.append(",  @[cs_clz_dt]" ).append("\n"); 
		query.append(",  @[cs_clz_ofc_cd]" ).append("\n"); 
		query.append(",  @[cs_clz_usr_id]" ).append("\n"); 
		query.append(",  @[tm_bar_dt]" ).append("\n"); 
		query.append(",  @[prlm_clm_ntc_dt]" ).append("\n"); 
		query.append(",  @[cgo_clm_acknak_dt]" ).append("\n"); 
		query.append(",  @[fact_fnd_dt]" ).append("\n"); 
		query.append(",  @[fact_fnd_desc]" ).append("\n"); 
		query.append(",  @[trns_flg]" ).append("\n"); 
		query.append(",  @[cs_clz_ropn_flg]" ).append("\n"); 
		query.append(",  @[cs_clz_ropn_dt]" ).append("\n"); 
		query.append(",  @[cs_clz_ropn_ofc_cd]" ).append("\n"); 
		query.append(",  @[cs_clz_ropn_usr_id]" ).append("\n"); 
		query.append(",  @[cgo_clm_div_cd]" ).append("\n"); 
		query.append(",  @[cp_desc]" ).append("\n"); 
		query.append(",  @[clmt_clm_pty_no]" ).append("\n"); 
		query.append(",  @[clmt_desc]" ).append("\n"); 
		query.append(",  @[clmt_clm_tp_cd]" ).append("\n"); 
		query.append(",  @[clmt_ref_no]" ).append("\n"); 
		query.append(",  @[fmal_clm_rcv_ofc_cd]" ).append("\n"); 
		query.append(",  @[fmal_clm_rcv_dt]" ).append("\n"); 
		query.append(",  @[fmal_clm_rcv_usr_id]" ).append("\n"); 
		query.append(",  @[cgo_clm_tp_cd]" ).append("\n"); 
		query.append(",  @[mjr_clm_dmg_lss_cd]" ).append("\n"); 
		query.append(",  @[n3rd_labl_pty_cd]" ).append("\n"); 
		query.append(",  @[cgo_clm_inci_no]" ).append("\n"); 
		query.append(",  @[clmt_locl_amt]" ).append("\n"); 
		query.append(",  @[clmt_locl_curr_cd]" ).append("\n"); 
		query.append(",  @[clmt_locl_xch_rt]" ).append("\n"); 
		query.append(",  @[clmt_usd_amt]" ).append("\n"); 
		query.append(",  @[clm_cuz_desc]" ).append("\n"); 
		query.append(",  @[clm_rvw_desc]" ).append("\n"); 
		query.append(",  @[agn_clm_pty_no]" ).append("\n"); 
		query.append(",  @[clmt_agn_tp_cd]" ).append("\n"); 
		query.append(",  @[clmt_agn_apnt_dt]" ).append("\n"); 
		query.append(",  @[clmt_agn_ref_no]" ).append("\n"); 
		query.append(",  @[cgo_clm_rcv_ofc_cd]" ).append("\n"); 
		query.append(",  @[cgo_clm_suit_flg]" ).append("\n"); 
		query.append(",  @[clmt_agn_desc]" ).append("\n"); 
		query.append(",  @[cgo_clm_sts_cd]" ).append("\n"); 
		query.append(",  @[bfr_cgo_clm_sts_cd]" ).append("\n"); 
		query.append(",  'O'" ).append("\n"); 
		query.append(",  @[pre_cgo_clm_clz_cd]" ).append("\n"); 
		query.append(",  @[cgo_clm_cxl_flg]" ).append("\n"); 
		query.append(",  @[past_cgo_clm_no]" ).append("\n"); 
		query.append(",  @[crm_voc_no]" ).append("\n"); 
		query.append(",  @[inci_plc_tp_cd]" ).append("\n"); 
		query.append(",  @[inci_occr_dt]" ).append("\n"); 
		query.append(",  @[cre_usr_id]" ).append("\n"); 
		query.append(",  CNI_GET_GMT_FNC(@[cre_usr_id])" ).append("\n"); 
		query.append(",  @[upd_usr_id]" ).append("\n"); 
		query.append(",  CNI_GET_GMT_FNC(@[upd_usr_id])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}