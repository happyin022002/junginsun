/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDataDBDAOSearchPercentBaseChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.04.25 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDataDBDAOSearchPercentBaseChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * retrieve PCT_BSE_CD, PATT_DESC
	  * </pre>
	  */
	public PRICommonDataDBDAOSearchPercentBaseChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommondata.pricommondata.integration").append("\n"); 
		query.append("FileName : PRICommonDataDBDAOSearchPercentBaseChargeRSQL").append("\n"); 
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
		query.append("SELECT BSE.PCT_BSE_CD" ).append("\n"); 
		query.append("--     , PRF.PCT_BSE_CD" ).append("\n"); 
		query.append("     , BSE.PATT_DESC" ).append("\n"); 
		query.append("     , BSE.DP_SEQ" ).append("\n"); 
		query.append("     , NVL2(PRF.PCT_BSE_CD ,'Y','N') PRI_SCG_PRF_USE_YN" ).append("\n"); 
		query.append("     , (SELECT MAX(PCT_BSE_CD)" ).append("\n"); 
		query.append("          FROM PRI_SCG_PCT_BSE" ).append("\n"); 
		query.append("       ) MAX_PCT_BSE_CD    " ).append("\n"); 
		query.append("FROM   PRI_SCG_PCT_BSE BSE" ).append("\n"); 
		query.append("     , (SELECT DISTINCT PCT_BSE_CD" ).append("\n"); 
		query.append("          FROM PRI_SCG_PRF" ).append("\n"); 
		query.append("       ) PRF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND  BSE.PCT_BSE_CD = PRF.PCT_BSE_CD(+)" ).append("\n"); 
		query.append("AND  BSE.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}