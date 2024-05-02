/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScqBreakbulkDBDAOmakePriScqBbCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOmakePriScqBbCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * makePriScqBbCgoVO
	  * * 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
	  * </pre>
	  */
	public ScqBreakbulkDBDAOmakePriScqBbCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOmakePriScqBbCgoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' SCQ_RQST_NO" ).append("\n"); 
		query.append(",'' SCQ_VER_NO" ).append("\n"); 
		query.append(",'' CGO_SEQ" ).append("\n"); 
		query.append(",'' CMDT_CD" ).append("\n"); 
		query.append(",'' TTL_DIM_LEN" ).append("\n"); 
		query.append(",'' TTL_DIM_WDT" ).append("\n"); 
		query.append(",'' TTL_DIM_HGT" ).append("\n"); 
		query.append(",'' GRS_WGT" ).append("\n"); 
		query.append(",'' TTL_DIM_LEN_VW" ).append("\n"); 
		query.append(",'' TTL_DIM_WDT_VW" ).append("\n"); 
		query.append(",'' TTL_DIM_HGT_VW" ).append("\n"); 
		query.append(",'' GRS_WGT_VW" ).append("\n"); 
		query.append(",'' WGT_UT_CD" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' CMDT_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}