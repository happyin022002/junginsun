/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.05
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.02.05 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLocYardInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC Yard combo box 정보를 검색
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocYardInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  YD_CD                                               " ).append("\n"); 
		query.append("  ,REPLACE(YD_NM, '''', ' ') YD_NM                                               " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("  MDM_YARD   								            " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("  DELT_FLG <> 'Y'	" ).append("\n"); 
		query.append("#if(${loc_type} == 'ECC') " ).append("\n"); 
		query.append("AND LOC_CD IN ( 											" ).append("\n"); 
		query.append("				SELECT ML.LOC_CD 								" ).append("\n"); 
		query.append("				FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                    , MDM_LOCATION ML 						" ).append("\n"); 
		query.append("				WHERE A.ECC_CD LIKE '${locyard_searchword}%' " ).append("\n"); 
		query.append("                  AND A.SCC_CD = ML.SCC_CD" ).append("\n"); 
		query.append("			   ) " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND LOC_CD IN ( 											" ).append("\n"); 
		query.append("				SELECT ML.LOC_CD " ).append("\n"); 
		query.append("                FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                     , MDM_LOCATION ML" ).append("\n"); 
		query.append("				WHERE A.LCC_CD LIKE '${locyard_searchword}%' " ).append("\n"); 
		query.append("				  AND A.SCC_CD = ML.SCC_CD " ).append("\n"); 
		query.append("			   ) " ).append("\n"); 
		query.append("#end										 " ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}