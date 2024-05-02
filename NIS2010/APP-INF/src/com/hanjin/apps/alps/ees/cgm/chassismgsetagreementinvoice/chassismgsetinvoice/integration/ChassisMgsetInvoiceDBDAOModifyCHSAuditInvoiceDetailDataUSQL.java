/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDetailDataUSQL.java
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

public class ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDetailDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyCHSAuditInvoiceDetailData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDetailDataUSQL(){
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
		params.put("inv_lse_use_dys",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyCHSAuditInvoiceDetailDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_LSE_CHG_DTL" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("LSE_CHG_AUD_STS_CD = @[lse_chg_aud_sts_cd]," ).append("\n"); 
		query.append("LSE_CHG_AUD_RSLT_RSN_CD = @[lse_chg_aud_rslt_rsn_cd]," ).append("\n"); 
		query.append("INV_NO = @[inv_no]," ).append("\n"); 
		query.append("INV_REF_NO = @[inv_ref_no]," ).append("\n"); 
		query.append("INV_EQ_NO = @[inv_eq_no]," ).append("\n"); 
		query.append("INV_CUST_EQ_NO = @[inv_cust_eq_no]," ).append("\n"); 
		query.append("INV_EQ_ONH_DT = DECODE(@[inv_eq_onh_dt],'','',TO_DATE(@[inv_eq_onh_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("INV_EQ_ONH_LOC_NM = @[inv_eq_onh_loc_nm]," ).append("\n"); 
		query.append("INV_EQ_OFFH_DT = DECODE(@[inv_eq_offh_dt],'','',TO_DATE(@[inv_eq_offh_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("INV_EQ_OFFH_LOC_NM = @[inv_eq_offh_loc_nm]," ).append("\n"); 
		query.append("INV_BIL_ST_DT = DECODE(@[inv_bil_st_dt],'','',TO_DATE(@[inv_bil_st_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("INV_BIL_END_DT = DECODE(@[inv_bil_end_dt],'','',TO_DATE(@[inv_bil_end_dt],'YYYYMMDD'))," ).append("\n"); 
		query.append("INV_LSE_USE_DYS = @[inv_lse_use_dys]," ).append("\n"); 
		query.append("INV_LSE_RT_AMT = @[inv_lse_rt_amt]," ).append("\n"); 
		query.append("INV_LSE_CHG_AMT = CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX','CRD') THEN 0 ELSE TO_NUMBER(@[inv_lse_chg_amt]) END," ).append("\n"); 
		query.append("INV_TAX_AMT = CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX') THEN TO_NUMBER(@[inv_lse_chg_amt]) ELSE 0 END," ).append("\n"); 
		query.append("INV_CR_AMT = CASE WHEN @[chg_cd] = 'CRD' THEN -1 * ABS(TO_NUMBER(@[inv_lse_chg_amt])) ELSE 0 END," ).append("\n"); 
		query.append("COST_CD = @[cost_cd]," ).append("\n"); 
		query.append("ACCT_CD = @[acct_cd]," ).append("\n"); 
		query.append("PAY_LSE_CHG_STS_CD = @[pay_lse_chg_sts_cd]," ).append("\n"); 
		query.append("PAY_LSE_USE_DYS = @[inv_lse_use_dys]," ).append("\n"); 
		query.append("PAY_LSE_RT_AMT = @[inv_lse_rt_amt]," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("PAY_LSE_CHG_AMT = CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX','CRD') THEN 0 ELSE TO_NUMBER(@[inv_lse_chg_amt]) END," ).append("\n"); 
		query.append("PAY_TAX_AMT = CASE WHEN @[chg_cd] IN ('X S', 'X V', 'X W', 'XSE', 'XVI', 'XWA', 'TAX') THEN TO_NUMBER(@[inv_lse_chg_amt]) ELSE 0 END," ).append("\n"); 
		query.append("PAY_CR_AMT = CASE WHEN @[chg_cd] = 'CRD' THEN -1 * ABS(TO_NUMBER(@[inv_lse_chg_amt])) ELSE 0 END," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND CHG_SEQ = @[inv_seq]" ).append("\n"); 

	}
}