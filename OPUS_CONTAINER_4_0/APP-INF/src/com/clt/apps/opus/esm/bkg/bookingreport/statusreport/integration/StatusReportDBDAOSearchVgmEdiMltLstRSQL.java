/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOSearchVgmEdiMltLstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchVgmEdiMltLstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VGM EDI MULTI List
	  * </pre>
	  */
	public StatusReportDBDAOSearchVgmEdiMltLstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchVgmEdiMltLstRSQL").append("\n"); 
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
		query.append("SELECT BB.BKG_NO," ).append("\n"); 
		query.append("       BC.CNTR_NO," ).append("\n"); 
		query.append("       BB.POL_NOD_CD YD_CD," ).append("\n"); 
		query.append("       BC.VGM_WGT," ).append("\n"); 
		query.append("       BC.VGM_WGT_UT_CD," ).append("\n"); 
		query.append("	   ROW_NUMBER() OVER(PARTITION BY BB.BKG_NO ORDER BY BB.BKG_NO, BC.CNTR_NO) BKG_ORD " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BB," ).append("\n"); 
		query.append("       BKG_CONTAINER BC" ).append("\n"); 
		query.append(" WHERE BB.BKG_NO =BC.BKG_NO" ).append("\n"); 
		query.append("   AND BC.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("   AND BC.CNTR_NO IN (${cntr_nos})" ).append("\n"); 

	}
}