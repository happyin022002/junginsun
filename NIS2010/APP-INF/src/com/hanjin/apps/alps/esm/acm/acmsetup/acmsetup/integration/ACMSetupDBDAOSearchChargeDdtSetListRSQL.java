/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOSearchChargeDdtSetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.18
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.18 김상수
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

public class ACMSetupDBDAOSearchChargeDdtSetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ACMSetupDBDAOSearchChargeDdtSetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration").append("\n"); 
		query.append("FileName : ACMSetupDBDAOSearchChargeDdtSetListRSQL").append("\n"); 
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
		query.append("SELECT B.CHG_DDCT_GRP_NM," ).append("\n"); 
		query.append("       B.REP_CHG_CD," ).append("\n"); 
		query.append("       B.CHG_CD," ).append("\n"); 
		query.append("       B.ORG_CHG_CD," ).append("\n"); 
		query.append("       B.CHG_DDCT_GRP_NM AS ORG_CHG_DDCT_GRP_NM" ).append("\n"); 
		query.append("  FROM (SELECT CHG_DDCT_GRP_NM," ).append("\n"); 
		query.append("               (ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n"); 
		query.append("                                      FROM ACM_AGN_SET_DDCT_CHG_GRP" ).append("\n"); 
		query.append("                                     WHERE CHG_DDCT_GRP_NM = A.CHG_DDCT_GRP_NM" ).append("\n"); 
		query.append("                                       AND CHG_DIV_CD = 'R'" ).append("\n"); 
		query.append("                                     ORDER BY CHG_CD))) AS REP_CHG_CD," ).append("\n"); 
		query.append("               (ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n"); 
		query.append("                                      FROM ACM_AGN_SET_DDCT_CHG_GRP" ).append("\n"); 
		query.append("                                     WHERE CHG_DDCT_GRP_NM = A.CHG_DDCT_GRP_NM" ).append("\n"); 
		query.append("                                       AND CHG_DIV_CD = 'C'" ).append("\n"); 
		query.append("                                       AND CHG_CD NOT IN (SELECT CHG_CD" ).append("\n"); 
		query.append("                                                            FROM MDM_CHARGE" ).append("\n"); 
		query.append("                                                           WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                                             AND REP_CHG_CD IN (SELECT CHG_CD" ).append("\n"); 
		query.append("                                                                                  FROM ACM_AGN_SET_DDCT_CHG_GRP" ).append("\n"); 
		query.append("                                                                                 WHERE CHG_DDCT_GRP_NM = A.CHG_DDCT_GRP_NM" ).append("\n"); 
		query.append("                                                                                   AND CHG_DIV_CD = 'R')) ORDER BY CHG_CD))) AS CHG_CD," ).append("\n"); 
		query.append("               (ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n"); 
		query.append("                                      FROM ACM_AGN_SET_DDCT_CHG_GRP" ).append("\n"); 
		query.append("                                     WHERE CHG_DDCT_GRP_NM = A.CHG_DDCT_GRP_NM" ).append("\n"); 
		query.append("                                       AND CHG_DIV_CD = 'C'" ).append("\n"); 
		query.append("                                     ORDER BY CHG_CD))) AS ORG_CHG_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_SET_DDCT_CHG_GRP A" ).append("\n"); 
		query.append("         ORDER BY A.CHG_DDCT_GRP_NM) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY B.CHG_DDCT_GRP_NM," ).append("\n"); 
		query.append("          B.REP_CHG_CD," ).append("\n"); 
		query.append("          B.CHG_CD," ).append("\n"); 
		query.append("          B.ORG_CHG_CD" ).append("\n"); 
		query.append(" ORDER BY B.CHG_DDCT_GRP_NM," ).append("\n"); 
		query.append("          B.REP_CHG_CD," ).append("\n"); 
		query.append("          B.CHG_CD," ).append("\n"); 
		query.append("          B.ORG_CHG_CD" ).append("\n"); 

	}
}