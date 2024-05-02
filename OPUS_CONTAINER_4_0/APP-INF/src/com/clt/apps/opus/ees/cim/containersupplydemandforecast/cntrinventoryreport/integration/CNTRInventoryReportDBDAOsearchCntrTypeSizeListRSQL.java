/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchCntrTypeSizeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.08 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchCntrTypeSizeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TP/SZ 콤보 조회
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchCntrTypeSizeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchCntrTypeSizeListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("ORDER BY RPT_DP_SEQ" ).append("\n"); 

	}
}