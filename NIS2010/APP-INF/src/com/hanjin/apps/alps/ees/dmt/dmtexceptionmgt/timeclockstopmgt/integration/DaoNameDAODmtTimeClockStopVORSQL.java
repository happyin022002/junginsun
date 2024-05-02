/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DaoNameDAODmtTimeClockStopVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.23 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAODmtTimeClockStopVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtTimeClockStopVO
	  * </pre>
	  */
	public DaoNameDAODmtTimeClockStopVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.integration").append("\n"); 
		query.append("FileName : DaoNameDAODmtTimeClockStopVORSQL").append("\n"); 
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
		query.append("SELECT '' AS CLK_STOP_NO" ).append("\n"); 
		query.append("      ,'' AS CXL_FLG" ).append("\n"); 
		query.append("      ,'' AS DMDT_TRF_CD" ).append("\n"); 
		query.append("      ,'' AS DMDT_TRF_NM" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_OFC_NM" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_YD_CD" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_YD_NM" ).append("\n"); 
		query.append("      ,'' AS ALL_YD_FLG" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_FM_DT" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_TO_DT" ).append("\n"); 
		query.append("      ,'' AS STOP_DAYS" ).append("\n"); 
		query.append("      ,'' AS CLK_STOP_RMK" ).append("\n"); 
		query.append("      ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' AS CRE_DT" ).append("\n"); 
		query.append("      ,'' AS CRE_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' AS UPD_DT" ).append("\n"); 
		query.append("      ,'' AS UPD_OFC_CD" ).append("\n"); 
		query.append("      ,'' AS AUTH_YN" ).append("\n"); 
		query.append("      ,'' AS DUP_YN" ).append("\n"); 
		query.append("      ,'' AS SEQ" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}