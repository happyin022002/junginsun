/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOCaIssueDateInRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.05.14 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaIssueDateInRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaIssueDateInRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaIssueDateInRSQL").append("\n"); 
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
		query.append("''	FROM_DT" ).append("\n"); 
		query.append(",'' TO_DT" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' BL_TP_CD" ).append("\n"); 
		query.append(",'' USR_ID" ).append("\n"); 
		query.append(",'' BKG_CORR_RMK" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append(",'' CORR_NO" ).append("\n"); 
		query.append(",'' PK_TP" ).append("\n"); 
		query.append(",'' CORR_DT" ).append("\n"); 
		query.append(",'' CNT_CD" ).append("\n"); 
		query.append(",'' POD_TP" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}