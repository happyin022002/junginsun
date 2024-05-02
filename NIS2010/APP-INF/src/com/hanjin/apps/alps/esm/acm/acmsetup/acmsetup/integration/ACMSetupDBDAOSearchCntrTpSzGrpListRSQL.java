/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOSearchCntrTpSzGrpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.25 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOSearchCntrTpSzGrpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ACMSetupDBDAOSearchCntrTpSzGrpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOSearchCntrTpSzGrpListRSQL").append("\n"); 
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
		query.append("SELECT B.CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("       B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       B.CNTR_TPSZ_GRP_NM AS ORG_CNTR_TPSZ_GRP_NM" ).append("\n"); 
		query.append("  FROM (SELECT CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("               (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                      FROM ACM_AGN_SET_CNTR_GRP" ).append("\n"); 
		query.append("                                     WHERE CNTR_TPSZ_GRP_NM = A.CNTR_TPSZ_GRP_NM" ).append("\n"); 
		query.append("                                     GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     ORDER BY CNTR_TPSZ_CD))) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_SET_CNTR_GRP A) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY B.CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("          B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" ORDER BY B.CNTR_TPSZ_GRP_NM," ).append("\n"); 
		query.append("          B.CNTR_TPSZ_CD" ).append("\n"); 

	}
}