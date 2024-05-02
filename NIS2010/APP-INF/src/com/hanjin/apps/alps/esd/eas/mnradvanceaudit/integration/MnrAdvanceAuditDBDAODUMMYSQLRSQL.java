/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAODUMMYSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.06.24 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAODUMMYSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WEB PARAMETER 생성용
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAODUMMYSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAODUMMYSQLRSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("	ESD_EES_0360 : MNR INVOICE CHARGE LIST input parameter" ).append("\n"); 
		query.append("    MNRInvoiceChargeINVO.java" ).append("\n"); 
		query.append("select '' s_rhq_ofc_cd" ).append("\n"); 
		query.append("     , '' s_ofc_cd" ).append("\n"); 
		query.append("     , '' s_start_dt" ).append("\n"); 
		query.append("     , '' s_end_dt" ).append("\n"); 
		query.append("     , '' s_cost_group_cd" ).append("\n"); 
		query.append("     , '' s_cost_cd" ).append("\n"); 
		query.append("     , '' s_auto_aud_sts_cd" ).append("\n"); 
		query.append("     , '' s_expn_aud_sts_cd" ).append("\n"); 
		query.append("     , '' s_difference" ).append("\n"); 
		query.append("     , '' s_err_type" ).append("\n"); 
		query.append("     , '' s_vndr_seq" ).append("\n"); 
		query.append("     , '' s_eq_knd_cd" ).append("\n"); 
		query.append("     , '' s_csr_no" ).append("\n"); 
		query.append("     , '' s_inv_no" ).append("\n"); 
		query.append("     , '' s_csr_status" ).append("\n"); 
		query.append("     , '' s_mnr_code_type" ).append("\n"); 
		query.append("  from dual" ).append("\n"); 
		query.append("	ESD_EES_0360 : MNR INVOICE CHARGE LIST OUTPUT VO" ).append("\n"); 
		query.append("    MnrChargeListVO.java" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT '' AUDIT_RESULT" ).append("\n"); 
		query.append("     , '' CHEKED_DT" ).append("\n"); 
		query.append("     , '' SEL" ).append("\n"); 
		query.append("     , '' AUTO_AUDIT" ).append("\n"); 
		query.append("     , '' SELECT_FLG" ).append("\n"); 
		query.append("     , '' SELECT_FLG_TEMP" ).append("\n"); 
		query.append("     , '' CHECKED_USER_NM" ).append("\n"); 
		query.append("     , '' INV_NO" ).append("\n"); 
		query.append("     , '' CSR_NO" ).append("\n"); 
		query.append("     , '' EQ_KND_CD_NM" ).append("\n"); 
		query.append("     , '' EQ_KND_CD" ).append("\n"); 
		query.append("     , '' VNDR_SEQ" ).append("\n"); 
		query.append("     , '' VNDR_NM" ).append("\n"); 
		query.append("     , '' RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("     , '' INV_OFC_CD" ).append("\n"); 
		query.append("     , '' WO_CURR_CD" ).append("\n"); 
		query.append("     , '' MNR_AGMT_AMT" ).append("\n"); 
		query.append("     , '' MNR_WRK_AMT" ).append("\n"); 
		query.append("     , '' TTL_INV_AMT" ).append("\n"); 
		query.append("     , '' SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("     , '' INV_CURR_CD" ).append("\n"); 
		query.append("     , '' REFL_EX_YN" ).append("\n"); 
		query.append("     , '' BZC_AMT" ).append("\n"); 
		query.append("     , '' COST_AMT" ).append("\n"); 
		query.append("     , '' INV_AMT" ).append("\n"); 
		query.append("     , '' INV_CHG_AMT" ).append("\n"); 
		query.append("     , '' GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("     , '' ISS_DT" ).append("\n"); 
		query.append("     , '' AP_PAY_DT" ).append("\n"); 
		query.append("     , '' PAY_DUE_DT" ).append("\n"); 
		query.append("     , '' CFM_DT" ).append("\n"); 
		query.append("     , '' INV_RMK" ).append("\n"); 
		query.append("     , '' INV_STS_CD" ).append("\n"); 
		query.append("     , '' CHG_WO_AMT" ).append("\n"); 
		query.append("     , '' WK_VRFY_YN" ).append("\n"); 
		query.append("     , '' EST_VRFY_YN" ).append("\n"); 
		query.append("     , '' WO_INV_RTO" ).append("\n"); 
		query.append("     , '' EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("     , '' INV_STS_NM" ).append("\n"); 
		query.append("     , '' INV_STS_CD" ).append("\n"); 
		query.append("     , '' INV_CRE_USER_NM" ).append("\n"); 
		query.append("     , '' EAC_YN" ).append("\n"); 
		query.append("     , '' AUDIT_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("--MnrReportINVO" ).append("\n"); 
		query.append("SELECT '' S_EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , '' S_SERIAL" ).append("\n"); 
		query.append("     , '' S_EQ_NO" ).append("\n"); 
		query.append("     , '' S_RANGE_START" ).append("\n"); 
		query.append("     , '' S_RANGE_END" ).append("\n"); 
		query.append("     , '' S_OWNERSHIP" ).append("\n"); 
		query.append("     , '' S_START_DT" ).append("\n"); 
		query.append("     , '' S_END_DT" ).append("\n"); 
		query.append("     , '' S_RCC" ).append("\n"); 
		query.append("     , '' S_NO_OF_REPAIRS" ).append("\n"); 
		query.append("     , '' S_REPAIR_AMT" ).append("\n"); 
		query.append("     , '' S_DV_AMT" ).append("\n"); 
		query.append("     , '' S_CNT_CD" ).append("\n"); 
		query.append("     , '' S_LOC_CD" ).append("\n"); 
		query.append("     , '' S_LOCATION_CD" ).append("\n"); 
		query.append("     , '' S_YD_CD" ).append("\n"); 
		query.append("     , '' S_VNDR_SEQ" ).append("\n"); 
		query.append("     , '' S_COST_DTL_CD" ).append("\n"); 
		query.append("     -- EAD_EAS_365 DATA START" ).append("\n"); 
		query.append("     , '' S_OWNERSHIP" ).append("\n"); 
		query.append("     , '' S_RCC_CD" ).append("\n"); 
		query.append("     , '' S_RPR_CNT" ).append("\n"); 
		query.append("     , '' S_RPR_AMT" ).append("\n"); 
		query.append("     , '' S_OVER_DV_AMT" ).append("\n"); 
		query.append("     , '' S_PREFIX_EQ_NO" ).append("\n"); 
		query.append("     , '' S_FROM_EQ_NO" ).append("\n"); 
		query.append("     , '' S_TO_EQ_NO" ).append("\n"); 
		query.append("     , '' S_PARAM_LOC_CD" ).append("\n"); 
		query.append("     -- EAD_EAS_365 DATA END" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}