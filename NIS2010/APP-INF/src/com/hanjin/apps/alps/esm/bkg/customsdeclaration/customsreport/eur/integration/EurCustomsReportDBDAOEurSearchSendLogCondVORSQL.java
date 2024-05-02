/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurCustomsReportDBDAOEurSearchSendLogCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsReportDBDAOEurSearchSendLogCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EurSearchSendLogCondVO 생성을 위해 사용
	  * </pre>
	  */
	public EurCustomsReportDBDAOEurSearchSendLogCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsReportDBDAOEurSearchSendLogCondVORSQL").append("\n"); 
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
		query.append("    '' S_VPS_ETA_DT" ).append("\n"); 
		query.append("    ,'' E_VPS_ETA_DT" ).append("\n"); 
		query.append("    ,'' BL_NO" ).append("\n"); 
		query.append("    ,'' CNTR_NO" ).append("\n"); 
		query.append("	,'' VVD" ).append("\n"); 
		query.append("	,'' FR_ACK" ).append("\n"); 
		query.append("	,'' VVD_FOR_FR" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}