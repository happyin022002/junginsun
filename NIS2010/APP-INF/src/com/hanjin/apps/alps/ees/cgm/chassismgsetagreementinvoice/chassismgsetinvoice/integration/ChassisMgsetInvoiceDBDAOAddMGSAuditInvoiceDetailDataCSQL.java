/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOAddMGSAuditInvoiceDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.04.28 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOAddMGSAuditInvoiceDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.AddMGSAuditInvoiceDetailData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOAddMGSAuditInvoiceDetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_chg_aud_rslt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_cust_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_bil_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_offh_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_chg_aud_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_use_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_lse_chg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_chg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_eq_onh_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_bil_st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_lse_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOAddMGSAuditInvoiceDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("AGMT_SEQ," ).append("\n"); 
		query.append("AGMT_VER_NO," ).append("\n"); 
		query.append("COST_YRMON," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("CHG_CD," ).append("\n"); 
		query.append("CHG_SEQ," ).append("\n"); 
		query.append("EQ_KND_CD," ).append("\n"); 
		query.append("LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("LSE_CHG_AUD_RSLT_RSN_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("INV_REF_NO," ).append("\n"); 
		query.append("INV_EQ_NO," ).append("\n"); 
		query.append("INV_CUST_EQ_NO," ).append("\n"); 
		query.append("INV_EQ_ONH_DT," ).append("\n"); 
		query.append("INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("INV_EQ_OFFH_DT," ).append("\n"); 
		query.append("INV_EQ_OFFH_LOC_NM," ).append("\n"); 
		query.append("INV_BIL_ST_DT," ).append("\n"); 
		query.append("INV_BIL_END_DT," ).append("\n"); 
		query.append("INV_LSE_USE_DYS," ).append("\n"); 
		query.append("INV_LSE_RT_AMT," ).append("\n"); 
		query.append("INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("INV_TAX_AMT," ).append("\n"); 
		query.append("INV_CR_AMT," ).append("\n"); 
		query.append("COST_CD," ).append("\n"); 
		query.append("ACCT_CD," ).append("\n"); 
		query.append("PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("PAY_LSE_USE_DYS," ).append("\n"); 
		query.append("PAY_LSE_RT_AMT," ).append("\n"); 
		query.append("PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("PAY_CR_AMT," ).append("\n"); 
		query.append("PAY_TAX_AMT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("T1.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("T1.AGMT_SEQ," ).append("\n"); 
		query.append("T1.AGMT_VER_NO," ).append("\n"); 
		query.append("T1.COST_YRMON," ).append("\n"); 
		query.append("T1.EQ_NO," ).append("\n"); 
		query.append("T1.CHG_CD," ).append("\n"); 
		query.append("T1.CHG_SEQ," ).append("\n"); 
		query.append("T1.EQ_KND_CD," ).append("\n"); 
		query.append("T1.LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("T1.LSE_CHG_AUD_RSLT_RSN_CD," ).append("\n"); 
		query.append("T1.INV_NO," ).append("\n"); 
		query.append("T1.INV_REF_NO," ).append("\n"); 
		query.append("T1.INV_EQ_NO," ).append("\n"); 
		query.append("T1.INV_CUST_EQ_NO," ).append("\n"); 
		query.append("T1.INV_EQ_ONH_DT," ).append("\n"); 
		query.append("T1.INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("T1.INV_EQ_OFFH_DT," ).append("\n"); 
		query.append("T1.INV_EQ_OFFH_LOC_NM," ).append("\n"); 
		query.append("T1.INV_BIL_ST_DT," ).append("\n"); 
		query.append("T1.INV_BIL_END_DT," ).append("\n"); 
		query.append("T1.INV_LSE_USE_DYS," ).append("\n"); 
		query.append("T1.INV_LSE_RT_AMT," ).append("\n"); 
		query.append("T1.INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("T1.INV_TAX_AMT," ).append("\n"); 
		query.append("T1.INV_CR_AMT," ).append("\n"); 
		query.append("T1.COST_CD," ).append("\n"); 
		query.append("T1.ACCT_CD," ).append("\n"); 
		query.append("T1.PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("T1.PAY_LSE_USE_DYS," ).append("\n"); 
		query.append("T1.PAY_LSE_RT_AMT," ).append("\n"); 
		query.append("T1.PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("T1.PAY_CR_AMT," ).append("\n"); 
		query.append("T1.PAY_TAX_AMT," ).append("\n"); 
		query.append("T1.CRE_USR_ID," ).append("\n"); 
		query.append("T1.CRE_DT," ).append("\n"); 
		query.append("T1.UPD_USR_ID," ).append("\n"); 
		query.append("T1.UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[agmt_ofc_cty_cd]  AS AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("@[agmt_seq]         AS AGMT_SEQ," ).append("\n"); 
		query.append("@[agmt_ver_no]      AS AGMT_VER_NO," ).append("\n"); 
		query.append("@[cost_yrmon]       AS COST_YRMON," ).append("\n"); 
		query.append("@[eq_no]            AS EQ_NO," ).append("\n"); 
		query.append("@[chg_cd]           AS CHG_CD," ).append("\n"); 
		query.append("@[inv_seq]          AS CHG_SEQ," ).append("\n"); 
		query.append("@[eq_knd_cd]        AS EQ_KND_CD," ).append("\n"); 
		query.append("@[lse_chg_aud_sts_cd]       AS LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("@[lse_chg_aud_rslt_rsn_cd]  AS LSE_CHG_AUD_RSLT_RSN_CD," ).append("\n"); 
		query.append("@[inv_no]           AS INV_NO," ).append("\n"); 
		query.append("@[inv_ref_no]       AS INV_REF_NO," ).append("\n"); 
		query.append("@[inv_eq_no]        AS INV_EQ_NO," ).append("\n"); 
		query.append("@[inv_cust_eq_no]   AS INV_CUST_EQ_NO," ).append("\n"); 
		query.append("DECODE(@[inv_eq_onh_dt],null,'',TO_DATE(@[inv_eq_onh_dt],'YYYYMMDD')) AS INV_EQ_ONH_DT," ).append("\n"); 
		query.append("@[inv_eq_onh_loc_nm] AS INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("DECODE(@[inv_eq_offh_dt],null,'',TO_DATE(@[inv_eq_offh_dt],'YYYYMMDD')) AS INV_EQ_OFFH_DT," ).append("\n"); 
		query.append("@[inv_eq_offh_loc_nm] AS INV_EQ_OFFH_LOC_NM," ).append("\n"); 
		query.append("DECODE(@[inv_bil_st_dt],null,'',TO_DATE(@[inv_bil_st_dt],'YYYYMMDD')) AS INV_BIL_ST_DT," ).append("\n"); 
		query.append("DECODE(@[inv_bil_end_dt],null,'',TO_DATE(@[inv_bil_end_dt],'YYYYMMDD')) AS INV_BIL_END_DT," ).append("\n"); 
		query.append("@[inv_lse_use_dys]  AS INV_LSE_USE_DYS," ).append("\n"); 
		query.append("@[inv_lse_rt_amt]   AS INV_LSE_RT_AMT," ).append("\n"); 
		query.append("CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX','CRD') THEN 0 ELSE TO_NUMBER(@[inv_lse_chg_amt]) END AS INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX') THEN TO_NUMBER(@[inv_lse_chg_amt]) ELSE 0 END AS INV_TAX_AMT," ).append("\n"); 
		query.append("CASE WHEN @[chg_cd] = 'CRD' THEN -1 * ABS(TO_NUMBER(@[inv_lse_chg_amt])) ELSE 0 END AS INV_CR_AMT," ).append("\n"); 
		query.append("@[cost_cd]          AS COST_CD," ).append("\n"); 
		query.append("@[acct_cd]          AS ACCT_CD," ).append("\n"); 
		query.append("@[pay_lse_chg_sts_cd] AS PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("@[inv_lse_use_dys]  AS PAY_LSE_USE_DYS," ).append("\n"); 
		query.append("@[inv_lse_rt_amt]   AS PAY_LSE_RT_AMT," ).append("\n"); 
		query.append("CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX','CRD') THEN 0 ELSE TO_NUMBER(@[inv_lse_chg_amt]) END AS PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX') THEN TO_NUMBER(@[inv_lse_chg_amt]) ELSE 0 END AS PAY_TAX_AMT," ).append("\n"); 
		query.append("CASE WHEN @[chg_cd] = 'CRD' THEN -1 * ABS(TO_NUMBER(@[inv_lse_chg_amt])) ELSE 0 END AS PAY_CR_AMT," ).append("\n"); 
		query.append("@[cre_usr_id]   AS CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE         AS CRE_DT," ).append("\n"); 
		query.append("@[upd_usr_id]   AS UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE         AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") T1" ).append("\n"); 

	}
}