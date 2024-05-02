/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACInqEacVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEACInqEacVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB Inquiry by EAC 화면의 VO 생성쿼리
	  * </pre>
	  */
	public EacMgtDBDAOEACInqEacVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACInqEacVORSQL").append("\n"); 
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
		query.append("SELECT '' AS EAC_NO" ).append("\n"); 
		query.append("     , '' AS RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '' AS AUDR_OFC_CD" ).append("\n"); 
		query.append("     , '' AS EAC_APRO_TP_NM" ).append("\n"); 
		query.append("     , '' AS EAC_INP_DT" ).append("\n"); 
		query.append("     , '' AS EAC_YRMON" ).append("\n"); 
		query.append("     , '' AS EAC_EXPN_TP_NM" ).append("\n"); 
		query.append("     , '' AS EAC_TP_NM" ).append("\n"); 
		query.append("     , '' AS EAC_BIL_TP_NM" ).append("\n"); 
		query.append("     , '' AS RESPB_OFC_CD" ).append("\n"); 
		query.append("     , '' AS VNDR_CUST_DIV_NM" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_CD" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_NM" ).append("\n"); 
		query.append("     , '' AS EAC_COST_DESC" ).append("\n"); 
		query.append("     , '' AS VNDR_NM" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_NO" ).append("\n"); 
		query.append("     , '' AS INV_AUD_USD_AMT" ).append("\n"); 
		query.append("     , '' AS N3PTY_NO" ).append("\n"); 
		query.append("     , '' AS TPB_OFC_CD" ).append("\n"); 
		query.append("     , '' AS EQ_KND_NM" ).append("\n"); 
		query.append("     , '' AS EQ_NO" ).append("\n"); 
		query.append("     , '' AS BKG_NO" ).append("\n"); 
		query.append("     , '' AS BL_NO" ).append("\n"); 
		query.append("     , '' AS VVD_CD" ).append("\n"); 
		query.append("     , '' AS CFM_CURR_CD" ).append("\n"); 
		query.append("     , '' AS CFM_AMT" ).append("\n"); 
		query.append("     , '' AS TPB_ROC_OFC_CD" ).append("\n"); 
		query.append("     , '' AS OTS_STS_NM" ).append("\n"); 
		query.append("     , '' AS CURR_CD" ).append("\n"); 
		query.append("     , '' AS INV_AUD_AMT" ).append("\n"); 
		query.append("     , '' AS S_RHQ_OFC_CD" ).append("\n"); 
		query.append("     , '' AS S_OFC_CD" ).append("\n"); 
		query.append("     , '' AS S_EAC_YRMON_FR" ).append("\n"); 
		query.append("     , '' AS S_EAC_YRMON_TO" ).append("\n"); 
		query.append("     , '' AS S_OTS_STS_CD" ).append("\n"); 
		query.append("     , '' AS S_OTS_STS_DTL_CD" ).append("\n"); 
		query.append("     , '' AS S_EAC_EXPN_TP_CD " ).append("\n"); 
		query.append("     , '' AS S_EAC_TP_CD" ).append("\n"); 
		query.append("     , '' AS S_VNDR_CUST_DIV_CD" ).append("\n"); 
		query.append("     , '' AS S_N3TPY_SRC_CD" ).append("\n"); 
		query.append("     , '' AS S_N3TPY_SRC_NM" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}