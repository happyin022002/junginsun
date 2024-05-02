/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesAuditConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.14 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesAuditConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesAuditCondition
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesAuditConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesAuditConditionRSQL").append("\n"); 
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
		query.append("SELECT '1' AS S_LOC_CD" ).append("\n"); 
		query.append("     , '1' AS S_NOD_CD" ).append("\n"); 
		query.append("     , '1' AS S_YD_CD" ).append("\n"); 
		query.append("     , '1' AS S_VNDR_SEQ" ).append("\n"); 
		query.append("     , '1' AS S_INV_OFC_CD" ).append("\n"); 
		query.append("     , '1' AS S_FROM_INV_CFM_DT" ).append("\n"); 
		query.append("     , '1' AS S_TO_INV_CFM_DT" ).append("\n"); 
		query.append("     , '1' AS S_LANE_CD" ).append("\n"); 
		query.append("     , '1' AS S_CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , '1' AS S_VSL_CD" ).append("\n"); 
		query.append("     , '1' AS S_LGS_COST_SUBJ_CD" ).append("\n"); 
		query.append("     , '1' AS S_LGS_COST_DTL_CD" ).append("\n"); 
		query.append("     , '1' AS S_AUD_OFC_CD" ).append("\n"); 
		query.append("     , '1' AS S_COST_CALC_MZD_CD" ).append("\n"); 
		query.append("     , '1' AS S_EXPN_AUD_TGT_FLG" ).append("\n"); 
		query.append("     , '1' AS S_BAT_RSLT_CD" ).append("\n"); 
		query.append("     , '1' AS S_INV_NO" ).append("\n"); 
		query.append("     , '1' AS S_CALC_TP_CD" ).append("\n"); 
		query.append("     , '1' AS S_VVD" ).append("\n"); 
		query.append("     , '1' AS S_IO_BND_CD" ).append("\n"); 
		query.append("     , '1' AS S_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , '1' AS S_RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '1' AS S_TML_INV_TP_CD" ).append("\n"); 
		query.append("     , '1' AS S_DIFF_SGN" ).append("\n"); 
		query.append("     , '1' AS S_DIFF_RTO" ).append("\n"); 
		query.append("     , '1' AS S_CSR_NO" ).append("\n"); 
		query.append("     , '1' AS S_AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("     , '1' AS S_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("     , '1' AS S_CSR_STS_CD" ).append("\n"); 
		query.append("     , '1' AS S_EAC_FLG" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}