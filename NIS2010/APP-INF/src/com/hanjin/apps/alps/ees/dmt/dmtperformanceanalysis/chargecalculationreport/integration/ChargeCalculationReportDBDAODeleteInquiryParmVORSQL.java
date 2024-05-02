/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationReportDBDAODeleteInquiryParmVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.15 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAODeleteInquiryParmVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChargeCalculationReportDBDAODeleteInquiryParmVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAODeleteInquiryParmVORSQL").append("\n"); 
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
		query.append("'' DT_FLG" ).append("\n"); 
		query.append(",'' FM_DT" ).append("\n"); 
		query.append(",'' TO_DT" ).append("\n"); 
		query.append(",'' OFC_FLG" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' GRP_FLG" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}