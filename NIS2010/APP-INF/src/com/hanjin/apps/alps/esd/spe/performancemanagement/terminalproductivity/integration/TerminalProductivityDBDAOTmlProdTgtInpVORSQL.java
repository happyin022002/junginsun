/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalProductivityDBDAOTmlProdTgtInpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalProductivityDBDAOTmlProdTgtInpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Productivity Target Input VO 생성쿼리
	  * </pre>
	  */
	public TerminalProductivityDBDAOTmlProdTgtInpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration").append("\n"); 
		query.append("FileName : TerminalProductivityDBDAOTmlProdTgtInpVORSQL").append("\n"); 
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
		query.append("SELECT '' AS EG_ID" ).append("\n"); 
		query.append(", '' AS EG_NM" ).append("\n"); 
		query.append(", '' AS EV_YR" ).append("\n"); 
		query.append(", '' AS SP_SEQ" ).append("\n"); 
		query.append(", '' AS SP_NAME" ).append("\n"); 
		query.append(", '' AS TML_CD" ).append("\n"); 
		query.append(", '' AS PRE_PERF_RTO" ).append("\n"); 
		query.append(", '' AS PRE_TGT_RTO" ).append("\n"); 
		query.append(", '' AS KPI_TGT_RTO" ).append("\n"); 
		query.append(", '' AS KPI_RMK" ).append("\n"); 
		query.append(", '' AS S_EG_RHQ_CD" ).append("\n"); 
		query.append(", '' AS S_EG_OFC_CD" ).append("\n"); 
		query.append(", '' AS S_EV_SVC_CATE_CD" ).append("\n"); 
		query.append(", '' AS S_EV_YR" ).append("\n"); 
		query.append(", '' AS S_TML_CD" ).append("\n"); 
		query.append(", '' AS S_SP_SEQ" ).append("\n"); 
		query.append(", '' AS ISFLAG" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS CRE_DT" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS UPD_DT " ).append("\n"); 
		query.append(", '' AS EG_TML_PROD_TGT_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}