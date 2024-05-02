/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOCollectionReportParmVORSQL.java
*@FileTitle : Monthly Invoiced &amp; Collection by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.28 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOCollectionReportParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOCollectionReportParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOCollectionReportParmVORSQL").append("\n"); 
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
		query.append("'' GRP_FLG" ).append("\n"); 
		query.append(",'' OFC_FLG" ).append("\n"); 
		query.append(",'' DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",'' START_DT" ).append("\n"); 
		query.append(",'' END_DT" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' CURR_FLG" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DTL_FLG" ).append("\n"); 
		query.append(",'' CHG_FLG" ).append("\n"); 
		query.append(",'' IO_BND_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}