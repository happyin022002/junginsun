/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOTrsPreAudListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.03.09 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAdvanceAuditDBDAOTrsPreAudListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsPreAudListVO
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOTrsPreAudListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOTrsPreAudListVORSQL").append("\n"); 
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
		query.append("SELECT '' CHK" ).append("\n"); 
		query.append("      ,'' SEL_AUD_CD" ).append("\n"); 
		query.append("      ,'' AUTO_AUD_STS_CD" ).append("\n"); 
		query.append("      ,'' EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("      ,'' RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,'' INV_OFC_CD" ).append("\n"); 
		query.append("      ,'' TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      ,'' INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,'' INV_VNDR_NM" ).append("\n"); 
		query.append("      ,'' INV_NO" ).append("\n"); 
		query.append("      ,'' INV_ISS_DT" ).append("\n"); 
		query.append("      ,'' INV_AUD_STS_CD" ).append("\n"); 
		query.append("      ,'' CSR_NO" ).append("\n"); 
		query.append("      ,'' CURR_CD" ).append("\n"); 
		query.append("      ,'' WO_AMT" ).append("\n"); 
		query.append("      ,'' INV_AMT" ).append("\n"); 
		query.append("      ,'' CURR_CNG_FLG" ).append("\n"); 
		query.append("      ,'' INV_DIFF_AMT" ).append("\n"); 
		query.append("      ,'' INV_DIFF_AMT_FLG" ).append("\n"); 
		query.append("      ,'' NO_AGMT_FLG" ).append("\n"); 
		query.append("      ,'' NO_OPTM_ROUT_FLG" ).append("\n"); 
		query.append("      ,'' EXCEED_AVG_DIFF_AMT" ).append("\n"); 
		query.append("      ,'' EXCEED_AVG_FLG      " ).append("\n"); 
		query.append("      ,'' INV_ISS_USR_NM" ).append("\n"); 
		query.append("      ,'' AUD_CFM_USR_NM" ).append("\n"); 
		query.append("      ,'' PAY_TERM_CD" ).append("\n"); 
		query.append("      ,'' PAY_DUE_DT" ).append("\n"); 
		query.append("      ,'' PAY_DT" ).append("\n"); 
		query.append("      ,'' EAC_IF_FLG" ).append("\n"); 
		query.append("	  ,'' S_TO_DT" ).append("\n"); 
		query.append("	  ,'' S_FM_DT" ).append("\n"); 
		query.append("	  ,'' S_OFC_CD" ).append("\n"); 
		query.append("	  ,'' S_RHQ_OFC_CD" ).append("\n"); 
		query.append("	  ,'' S_TRSP_COST_SO_TP_CD" ).append("\n"); 
		query.append("	  ,'' S_TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	  ,'' S_TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("	  ,'' S_INV_VNDR_SEQ" ).append("\n"); 
		query.append("	  ,'' S_CSR_NO" ).append("\n"); 
		query.append("	  ,'' S_INV_NO" ).append("\n"); 
		query.append("	  ,'' S_AUD_ITM_CD" ).append("\n"); 
		query.append("	  ,'' S_AUTO_AUD_STS_CD" ).append("\n"); 
		query.append("	  ,'' S_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("	  ,'' S_CSR_STS_CD" ).append("\n"); 
		query.append("      ,'' S_TRSP_SO_TP_CD" ).append("\n"); 
		query.append("	  ,'' CRE_USR_ID" ).append("\n"); 
		query.append("	  ,'' UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' LOCL_CRE_DT" ).append("\n"); 
		query.append("      ,'' CRE_OFC_CD" ).append("\n"); 
		query.append("      ,'' EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("      ,'' EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("      ,'' EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("      ,'' S_SAVE_TP_CD" ).append("\n"); 
		query.append("      ,'' INV_DIFF_PCT" ).append("\n"); 
		query.append("      ,'' DIS_INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,'' DIS_INV_VNDR_NM" ).append("\n"); 
		query.append("      ,'' HJL_INV_NO" ).append("\n"); 
		query.append("      ,'' INV_CFM_DT" ).append("\n"); 
		query.append("      ,'' ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,'' EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("      ,'' BATCH_TP_CD" ).append("\n"); 
		query.append("      ,'' TO_DATETIME" ).append("\n"); 
		query.append("      ,'' AUD_RLST_FLG" ).append("\n"); 
		query.append("      ,'' INV_ISS_USR_ID" ).append("\n"); 
		query.append("      ,'' HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("      ,'' INV_DIFF_FLG" ).append("\n"); 
		query.append("      ,'' AVG_OVR_DIFF_FLG" ).append("\n"); 
		query.append("      ,'' AUTO_AUD_CFM_DT" ).append("\n"); 
		query.append("      ,'' AUTO_AUD_CFM_USR_ID" ).append("\n"); 
		query.append("      ,'' BAT_PROG_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}