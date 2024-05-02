/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EQCOrgChartDBDAOTotalListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.15
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.10.15 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQCOrgChartDBDAOTotalListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQC Organization의 총 카운트를 조회한다.
	  * </pre>
	  */
	public EQCOrgChartDBDAOTotalListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.eqcorgchart.integration").append("\n"); 
		query.append("FileName : EQCOrgChartDBDAOTotalListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1)" ).append("\n"); 
		query.append("FROM EQR_LOC_LVL" ).append("\n"); 
		query.append("#if (${idepth} != '') " ).append("\n"); 
		query.append("WHERE LOC_DPTH_CD <> 'S'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}