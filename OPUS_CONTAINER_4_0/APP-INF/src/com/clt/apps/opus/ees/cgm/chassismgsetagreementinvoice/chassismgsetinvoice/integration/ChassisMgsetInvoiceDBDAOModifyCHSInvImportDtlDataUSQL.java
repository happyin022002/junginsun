/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOModifyCHSInvImportDtlDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.01.06 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOModifyCHSInvImportDtlDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInvoiceDB.ModifyCHSInvImportDtlData
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOModifyCHSInvImportDtlDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOModifyCHSInvImportDtlDataUSQL").append("\n"); 
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
		query.append("LSE_CHG_AUD_RSLT_RSN_CD = ''," ).append("\n"); 
		query.append("INV_NO = ''," ).append("\n"); 
		query.append("INV_REF_NO = ''," ).append("\n"); 
		query.append("INV_EQ_NO = ''," ).append("\n"); 
		query.append("INV_CUST_EQ_NO = ''," ).append("\n"); 
		query.append("INV_EQ_ONH_DT = ''," ).append("\n"); 
		query.append("INV_EQ_ONH_LOC_NM = ''," ).append("\n"); 
		query.append("INV_EQ_OFFH_DT = ''," ).append("\n"); 
		query.append("INV_EQ_OFFH_LOC_NM = ''," ).append("\n"); 
		query.append("INV_BIL_ST_DT = ''," ).append("\n"); 
		query.append("INV_BIL_END_DT = ''," ).append("\n"); 
		query.append("INV_LSE_USE_DYS = 0," ).append("\n"); 
		query.append("INV_LSE_RT_AMT = 0," ).append("\n"); 
		query.append("INV_LSE_CHG_AMT = 0," ).append("\n"); 
		query.append("INV_TAX_AMT = 0," ).append("\n"); 
		query.append("INV_CR_AMT = 0," ).append("\n"); 
		query.append("COST_CD = ''," ).append("\n"); 
		query.append("ACCT_CD = ''," ).append("\n"); 
		query.append("AUD_UMCH_EQ_STS_EVNT_YD_CD = ''," ).append("\n"); 
		query.append("AUD_UMCH_EQ_ASET_STS_CD = ''," ).append("\n"); 
		query.append("AUD_UMCH_EQ_STS_EVNT_DT = ''," ).append("\n"); 
		query.append("PAY_LSE_CHG_STS_CD = @[pay_lse_chg_sts_cd]," ).append("\n"); 
		query.append("PAY_LSE_USE_DYS = ''," ).append("\n"); 
		query.append("PAY_LSE_RT_AMT = ''," ).append("\n"); 
		query.append("PAY_LSE_CHG_AMT = ''," ).append("\n"); 
		query.append("PAY_TAX_AMT = ''," ).append("\n"); 
		query.append("PAY_CR_AMT = ''," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND LSE_CHG_AUD_STS_CD IN ('C','D')" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND (AGMT_OFC_CTY_CD,AGMT_SEQ,COST_YRMON) IN (" ).append("\n"); 
		query.append("SELECT AGMT_OFC_CTY_CD,AGMT_SEQ,COST_YRMON" ).append("\n"); 
		query.append("FROM CGM_LSE_CHG_HDR" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("AND CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd])" ).append("\n"); 

	}
}