/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsAdvanceAuditDBDAOTrsPreAudDtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.03.08 최종혁
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

public class TrsAdvanceAuditDBDAOTrsPreAudDtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TrsPreAudDtListVO
	  * </pre>
	  */
	public TrsAdvanceAuditDBDAOTrsPreAudDtListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration").append("\n"); 
		query.append("FileName : TrsAdvanceAuditDBDAOTrsPreAudDtListVORSQL").append("\n"); 
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
		query.append("SELECT     '' RHQ_OFC_CD	" ).append("\n"); 
		query.append("	      ,'' WO_OFC_CD	" ).append("\n"); 
		query.append("	      ,'' INV_OFC_CD	" ).append("\n"); 
		query.append("	      ,'' BKG_NO		" ).append("\n"); 
		query.append("	      ,'' EQ_NO		" ).append("\n"); 
		query.append("	      ,'' WO_NO		" ).append("\n"); 
		query.append("	      ,'' SO_NO		" ).append("\n"); 
		query.append("	      ,'' BKG_RCVDE_TERM_CD		" ).append("\n"); 
		query.append("	      ,'' CURR_CD		" ).append("\n"); 
		query.append("	      ,'' WO_AMT		" ).append("\n"); 
		query.append("	      ,'' INV_AMT		" ).append("\n"); 
		query.append("	      ,'' CURR_CNG_FLG		" ).append("\n"); 
		query.append("	      ,'' INV_DIFF_AMT_FLG		" ).append("\n"); 
		query.append("	      ,'' INV_DIFF_AMT		" ).append("\n"); 
		query.append("          ,'' INV_DIFF_PCT" ).append("\n"); 
		query.append("	      ,'' NO_AGMT_FLG		" ).append("\n"); 
		query.append("	      ,'' NO_OPTM_ROUT_FLG		" ).append("\n"); 
		query.append("	      ,'' EXCEED_AVG_FLG		" ).append("\n"); 
		query.append("	      ,'' EXCEED_AVG_DIFF_AMT		" ).append("\n"); 
		query.append("	      ,'' EAC_IF_FLG		" ).append("\n"); 
		query.append("	      ,'' TRSP_SO_TP_CD		" ).append("\n"); 
		query.append("	      ,'' INV_VNDR_SEQ		" ).append("\n"); 
		query.append("	      ,'' INV_NO		" ).append("\n"); 
		query.append("	      ,'' CGO_TP_CD		" ).append("\n"); 
		query.append("	      ,'' TRSP_CRR_MOD_CD		" ).append("\n"); 
		query.append("	      ,'' TRSP_COST_DTL_MOD_CD		" ).append("\n"); 
		query.append("	      ,'' TRSP_BND_CD		" ).append("\n"); 
		query.append("	      ,'' INV_CFM_DT		" ).append("\n"); 
		query.append("	      ,'' AUD_STS_FLG		" ).append("\n"); 
		query.append("	      ,'' WO_ISS_DT		" ).append("\n"); 
		query.append("	      ,'' WO_ISS_PRE_MON		" ).append("\n"); 
		query.append("	      ,'' AUTO_AUD_STS_CD		" ).append("\n"); 
		query.append("	      ,'' FM_NOD_CD		" ).append("\n"); 
		query.append("	      ,'' TO_NOD_CD		" ).append("\n"); 
		query.append("	      ,'' VIA_NOD_CD		" ).append("\n"); 
		query.append("	      ,'' DOR_NOD_CD		" ).append("\n"); 
		query.append("	      ,'' EQ_TPSZ_CD" ).append("\n"); 
		query.append("          ,'' INV_DIFF_RTO" ).append("\n"); 
		query.append("	      ,'' EXCEED_AVG_RTO" ).append("\n"); 
		query.append("          ,'' S_TRSP_SO_TP_CD" ).append("\n"); 
		query.append("          ,'' S_INV_VNDR_SEQ" ).append("\n"); 
		query.append("          ,'' S_INV_NO" ).append("\n"); 
		query.append("          ,'' S_TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("          ,'' S_TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("          ,'' S_AUD_ITM_CD" ).append("\n"); 
		query.append("		  ,'' S_INV_ISS_USR_NM" ).append("\n"); 
		query.append("          ,'' CHK" ).append("\n"); 
		query.append("          ,'' TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("          ,'' TRSP_SO_SEQ" ).append("\n"); 
		query.append("          ,'' NEGO_AMT" ).append("\n"); 
		query.append("          ,'' NEGO_RMK" ).append("\n"); 
		query.append("          ,'' ETC_SCG_NM" ).append("\n"); 
		query.append("          ,'' ETC_SCG_AMT" ).append("\n"); 
		query.append("          ,'' OTR_RMK" ).append("\n"); 
		query.append("          ,'' INV_ETC_SCG_NM" ).append("\n"); 
		query.append("          ,'' INV_ETC_SCG_AMT" ).append("\n"); 
		query.append("          ,'' INV_OTR_RMK" ).append("\n"); 
		query.append("          ,'' S_HJL_INV_VNDR_SEQ" ).append("\n"); 
		query.append("          ,'' S_HJL_INV_NO" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}