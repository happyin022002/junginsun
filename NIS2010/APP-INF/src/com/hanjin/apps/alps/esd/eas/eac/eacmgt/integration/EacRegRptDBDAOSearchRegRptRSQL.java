/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacRegRptDBDAOSearchRegRptRSQL.java
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

public class EacRegRptDBDAOSearchRegRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC 통계 리포트 조회조건
	  * </pre>
	  */
	public EacRegRptDBDAOSearchRegRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacRegRptDBDAOSearchRegRptRSQL").append("\n"); 
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
		query.append("SELECT '' S_EAC_YRMON_FM" ).append("\n"); 
		query.append("      ,'' S_EAC_YRMON_TO" ).append("\n"); 
		query.append("      ,'' S_RHQ_OFC_CD" ).append("\n"); 
		query.append("      ,'' S_OFC_CD" ).append("\n"); 
		query.append("      ,'' S_CAL_VAL" ).append("\n"); 
		query.append("      ,'' S_EAC_TP_CD" ).append("\n"); 
		query.append("      ,'' S_EAC_APRO_TP_CD" ).append("\n"); 
		query.append("      ,'' S_RNK_DIV_CD" ).append("\n"); 
		query.append("      ,'' S_OFC_TP_CD" ).append("\n"); 
		query.append("      ,'' S_EAC_RSN_CD" ).append("\n"); 
		query.append("      ,'' S_EAC_EXPN_TP_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}