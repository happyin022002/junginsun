/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEACCfmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.12
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.12 백형인
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

public class EacMgtDBDAOEACCfmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC Inquiry Confirm 화면의 VO 생성쿼리
	  * </pre>
	  */
	public EacMgtDBDAOEACCfmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEACCfmVORSQL").append("\n"); 
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
		query.append("     , '' AS VNDR_SEQ" ).append("\n"); 
		query.append("     , '' AS VNDR_NM" ).append("\n"); 
		query.append("     , '' AS EAC_COST_DESC" ).append("\n"); 
		query.append("     , '' AS VVD_CD_CTNT" ).append("\n"); 
		query.append("     , '' AS BKG_NO" ).append("\n"); 
		query.append("     , '' AS YD_CD" ).append("\n"); 
		query.append("     , '' AS WO_NO_CTNT" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_NO" ).append("\n"); 
		query.append("     , '' AS N3PTY_SRC_DT" ).append("\n"); 
		query.append("     , '' AS CURR_CD" ).append("\n"); 
		query.append("     , '' AS INV_AMT" ).append("\n"); 
		query.append("     , '' AS INV_CNG_AMT" ).append("\n"); 
		query.append("     , '' AS INV_AUD_USD_AMT" ).append("\n"); 
		query.append("     , '' AS STL_AMT" ).append("\n"); 
		query.append("     , '' AS EAC_DESC" ).append("\n"); 
		query.append("     , '' AS EAC_INTER_RMK" ).append("\n"); 
		query.append("     , '' AS EAC_RSN_NM" ).append("\n"); 
		query.append("     , '' AS EAC_RSN_DESC" ).append("\n"); 
		query.append("     , '' AS EAC_EVID_DESC" ).append("\n"); 
		query.append("     , '' AS AUDR_USR_NM" ).append("\n"); 
		query.append("     , '' AS EAC_STS_NM" ).append("\n"); 
		query.append("     , '' AS EAC_CMPL_NM" ).append("\n"); 
		query.append("     , '' AS EAC_CMPL_DT" ).append("\n"); 
		query.append("     , '' AS RJCT_DESC" ).append("\n"); 
		query.append("     , '' AS RJCT_OFC_CD" ).append("\n"); 
		query.append("     , '' AS EAC_DUP" ).append("\n"); 
		query.append("     , '' AS TPB_DUP" ).append("\n"); 
		query.append("     , '' AS EAC_VRFY_DIV_CD" ).append("\n"); 
		query.append("     , '' AS EAC_STS_CD" ).append("\n"); 
		query.append("     , '' AS EAC_SYS_IF_CD" ).append("\n"); 
		query.append("     , '' AS EXPN_EVID_DESC" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}