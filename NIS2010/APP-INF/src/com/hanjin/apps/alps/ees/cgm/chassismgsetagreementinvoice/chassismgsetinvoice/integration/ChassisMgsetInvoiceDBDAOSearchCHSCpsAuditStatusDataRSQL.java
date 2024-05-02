/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetInvoiceDBDAOSearchCHSCpsAuditStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInvoiceDBDAOSearchCHSCpsAuditStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ----------------------------------------------------------------------------------------------------------------------------
	  * 조경완 [CHM-201326006-01]  ALPS-CHSS-COPS DUMMY YARD로 IN/Out된 CHSS의 로직 변경
	  * 2014-02-07 JongHee Han COST_YRMON_SEQ 조건 누락으로 Payable Charge Creation의 Audit Result & P. Amt Confirm Popup Data 오류 해결
	  * ----------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public ChassisMgsetInvoiceDBDAOSearchCHSCpsAuditStatusDataRSQL(){
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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInvoiceDBDAOSearchCHSCpsAuditStatusDataRSQL").append("\n"); 
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
		query.append("SELECT B.INV_NO," ).append("\n"); 
		query.append("       B.AGMT_OFC_CTY_CD || LPAD(B.AGMT_SEQ,6,'0') AS AGMT_NO," ).append("\n"); 
		query.append("       B.INV_REF_NO," ).append("\n"); 
		query.append("       B.INV_EQ_NO," ).append("\n"); 
		query.append("       B.INV_CUST_EQ_NO," ).append("\n"); 
		query.append("       B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("       B.CHG_CD," ).append("\n"); 
		query.append("       B.INV_EQ_ONH_LOC_NM," ).append("\n"); 
		query.append("       TO_CHAR(B.INV_EQ_ONH_DT, 'YYYY-MM-DD') INV_EQ_ONH_DT," ).append("\n"); 
		query.append("       TO_CHAR(B.INV_EQ_OFFH_DT, 'YYYY-MM-DD') INV_EQ_OFFH_DT," ).append("\n"); 
		query.append("       TO_CHAR(B.INV_BIL_ST_DT, 'YYYY-MM-DD') INV_BIL_ST_DT," ).append("\n"); 
		query.append("       TO_CHAR(B.INV_BIL_END_DT, 'YYYY-MM-DD') INV_BIL_END_DT," ).append("\n"); 
		query.append("       B.INV_LSE_USE_DYS," ).append("\n"); 
		query.append("       B.INV_BIL_UT_DYS," ).append("\n"); 
		query.append("       B.INV_LSE_RT_AMT," ).append("\n"); 
		query.append("       B.INV_TAX_AMT," ).append("\n"); 
		query.append("       B.LSE_CHG_AUD_STS_CD," ).append("\n"); 
		query.append("       B.PAY_LSE_CHG_STS_CD," ).append("\n"); 
		query.append("       B.LSE_CHG_AUD_RSLT_RSN_CD," ).append("\n"); 
		query.append("	   (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("   		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("  		WHERE INTG_CD_ID = 'CD01942' AND INTG_CD_VAL_CTNT = B.LSE_CHG_AUD_RSLT_RSN_CD) AS LSE_CHG_AUD_RSLT_RSN_NM," ).append("\n"); 
		query.append("       TO_CHAR(B.EQ_FM_MVMT_DT, 'YYYY-MM-DD') EQ_FM_MVMT_DT," ).append("\n"); 
		query.append("       B.EQ_FM_YD_CD," ).append("\n"); 
		query.append("       B.EQ_FM_MVMT_CD," ).append("\n"); 
		query.append("       TO_CHAR(B.EQ_TO_MVMT_DT, 'YYYY-MM-DD') EQ_TO_MVMT_DT," ).append("\n"); 
		query.append("       B.EQ_TO_YD_CD," ).append("\n"); 
		query.append("       B.EQ_TO_MVMT_CD," ).append("\n"); 
		query.append("       B.PAY_LSE_USE_DYS," ).append("\n"); 
		query.append("       B.PAY_BIL_UT_DYS," ).append("\n"); 
		query.append("       B.PAY_LSE_RT_AMT," ).append("\n"); 
		query.append("       B.PAY_TAX_AMT," ).append("\n"); 
		query.append("       B.PAY_LSE_CHG_AMT," ).append("\n"); 
		query.append("       B.INV_SC_NO," ).append("\n"); 
		query.append("       B.INV_BKG_NO," ).append("\n"); 
		query.append("       B.INV_BKG_TERM_CD," ).append("\n"); 
		query.append("       B.INV_BIL_UT_DYS - LSE_BIL_UT_DYS AS DIFF_BIL_UT," ).append("\n"); 
		query.append("	   B.AGMT_SEQ," ).append("\n"); 
		query.append("	   B.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("	   B.AGMT_VER_NO," ).append("\n"); 
		query.append("	   B.INV_CR_AMT," ).append("\n"); 
		query.append("	   B.CHG_SEQ," ).append("\n"); 
		query.append("	   B.EQ_NO," ).append("\n"); 
		query.append("	   B.INV_LSE_CHG_AMT," ).append("\n"); 
		query.append("	   B.INV_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("	   B.INV_TAX_RT_AMT," ).append("\n"); 
		query.append("	   B.PAY_LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("	   B.PAY_TAX_RT_AMT," ).append("\n"); 
		query.append("	   B.LSE_CHG_AMT," ).append("\n"); 
		query.append("	   B.LSE_RT_AMT," ).append("\n"); 
		query.append("	   B.LSE_CHG_TTL_AMT," ).append("\n"); 
		query.append("	   B.LSE_BIL_UT_DYS," ).append("\n"); 
		query.append("	   B.LSE_TAX_AMT," ).append("\n"); 
		query.append("	   B.LSE_TAX_RT_AMT," ).append("\n"); 
		query.append("	   B.LSE_USE_DYS," ).append("\n"); 
		query.append("	   B.PAY_CR_AMT," ).append("\n"); 
		query.append("	   B.PAY_CHG_AUD_RMK," ).append("\n"); 
		query.append("	   B.INV_GATE_ACT_ID," ).append("\n"); 
		query.append("	   B.INV_BIL_MOD_RMK," ).append("\n"); 
		query.append("	   TO_CHAR(B.EQ_MTY_MVMT_DT, 'YYYY-MM-DD') EQ_MTY_MVMT_DT," ).append("\n"); 
		query.append("	   B.EQ_MTY_MVMT_YD_CD," ).append("\n"); 
		query.append("	   B.EQ_TO_SC_NO," ).append("\n"); 
		query.append("	   B.EQ_TO_BKG_NO," ).append("\n"); 
		query.append("	   B.EQ_TO_BKG_TERM_CD," ).append("\n"); 
		query.append("       A.COST_YRMON_SEQ,  -- HIDDEN VALUE, 20140324,신용찬" ).append("\n"); 
		query.append("       -- 조회항목 추가 2015.05.14 Chang-Young Kim [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정" ).append("\n"); 
		query.append("       B.VNDR_PAY_CHG_RMK," ).append("\n"); 
		query.append("       B.VNDR_PAY_CHG_CMT_CTNT," ).append("\n"); 
		query.append("       B.VNDR_PAY_CHG_CR_STY_CTNT," ).append("\n"); 
		query.append("       B.VNDR_PAY_CHG_CR_DUE_CTNT" ).append("\n"); 
		query.append("       -- 조회항목 추가 2015.05.14 Chang-Young Kim [CHM-201535809] CHZ AUDITING 시 MONTH 적용 로직 수정.끝" ).append("\n"); 
		query.append("  FROM CGM_LSE_CHG_HDR A, CGM_LSE_CHG_DTL B" ).append("\n"); 
		query.append(" WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("    AND A.COST_YRMON = B.COST_YRMON" ).append("\n"); 
		query.append("    AND A.COST_YRMON_SEQ = B.COST_YRMON_SEQ" ).append("\n"); 
		query.append("    AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("    AND A.COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("    AND A.CHG_CRE_SEQ = @[chg_cre_seq]" ).append("\n"); 
		query.append("    AND B.PAY_LSE_CHG_STS_CD = @[pay_lse_chg_sts_cd]" ).append("\n"); 

	}
}