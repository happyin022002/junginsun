/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PAResultDetaibySPDBDAOPAResultDetaibySPVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.19
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.19 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PAResultDetaibySPDBDAOPAResultDetaibySPVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quantitative Analysis : PA Result Detail by S/P  VO 생성쿼리
	  * </pre>
	  */
	public PAResultDetaibySPDBDAOPAResultDetaibySPVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancereport.paresultdetaibysp.integration").append("\n"); 
		query.append("FileName : PAResultDetaibySPDBDAOPAResultDetaibySPVORSQL").append("\n"); 
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
		query.append(", '' AS SP_KPI_ID" ).append("\n"); 
		query.append(", '' AS SP_KPI_NM" ).append("\n"); 
		query.append(", '' AS RSLT_SCRE_RTO" ).append("\n"); 
		query.append(", '' AS KPI_TGT_RTO" ).append("\n"); 
		query.append(", '' AS TGT_AVG" ).append("\n"); 
		query.append(", '' AS JAN_RTO" ).append("\n"); 
		query.append(", '' AS FEB_RTO" ).append("\n"); 
		query.append(", '' AS MAR_RTO" ).append("\n"); 
		query.append(", '' AS APR_RTO" ).append("\n"); 
		query.append(", '' AS MAY_RTO" ).append("\n"); 
		query.append(", '' AS JUN_RTO" ).append("\n"); 
		query.append(", '' AS JUL_RTO" ).append("\n"); 
		query.append(", '' AS AUG_RTO" ).append("\n"); 
		query.append(", '' AS SEP_RTO" ).append("\n"); 
		query.append(", '' AS OCT_RTO" ).append("\n"); 
		query.append(", '' AS NOV_RTO" ).append("\n"); 
		query.append(", '' AS DEC_RTO" ).append("\n"); 
		query.append(", '' AS S_EV_YR" ).append("\n"); 
		query.append(", '' AS S_SP_SEQ" ).append("\n"); 
		query.append(", '' AS EV_YR" ).append("\n"); 
		query.append(", '' AS SP_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}