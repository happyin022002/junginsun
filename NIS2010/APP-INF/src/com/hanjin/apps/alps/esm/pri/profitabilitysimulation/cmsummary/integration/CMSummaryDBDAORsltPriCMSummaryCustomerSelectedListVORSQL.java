/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CMSummaryDBDAORsltPriCMSummaryCustomerSelectedListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.02.10 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAORsltPriCMSummaryCustomerSelectedListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CMSummaryDBDAORsltPriCMSummaryCustomerSelectedListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAORsltPriCMSummaryCustomerSelectedListVORSQL").append("\n"); 
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
		query.append("SELECT A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, '0') AS CUST_CD,OFC_CD," ).append("\n"); 
		query.append("  A.CUST_CNT_CD," ).append("\n"); 
		query.append("  A.CUST_SEQ," ).append("\n"); 
		query.append("  A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A" ).append("\n"); 
		query.append("WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND (A.CUST_CNT_CD , A.CUST_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${cust_list}) " ).append("\n"); 
		query.append("	#if($velocityCount != 1 ) " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("			substr('$key',1,2),substr('$key',3)" ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.NMD_CUST_FLG = 'N'" ).append("\n"); 

	}
}