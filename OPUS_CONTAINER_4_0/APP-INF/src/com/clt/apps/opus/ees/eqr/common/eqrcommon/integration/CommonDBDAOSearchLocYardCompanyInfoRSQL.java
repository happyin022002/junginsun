/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardCompanyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchLocYardCompanyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC Yard (INLAND+VESSEL) combo box 정보를 검색
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardCompanyInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard_searchword",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocYardCompanyInfoRSQL").append("\n"); 
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
		query.append("  LSE_CO_YD_CD YD_CD ,                                  " ).append("\n"); 
		query.append("  REPLACE(LSE_CO_YD_NM, '''', ' ') YD_NM                                  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("  MDM_LSE_CO_YD				 				            		" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("  SUBSTR(LSE_CO_YD_CD, 0, 5) IN ( 						" ).append("\n"); 
		query.append("				SELECT  " ).append("\n"); 
		query.append("				  SCC_CD 								" ).append("\n"); 
		query.append("				FROM " ).append("\n"); 
		query.append("				  MDM_EQ_ORZ_CHT 						" ).append("\n"); 
		query.append("				WHERE ECC_CD LIKE @[locyard_searchword]                         " ).append("\n"); 
		query.append("	) 											 " ).append("\n"); 
		query.append("                 	    		" ).append("\n"); 
		query.append("  AND  DELT_FLG <> @[delt_flg]                               " ).append("\n"); 
		query.append("ORDER BY LSE_CO_YD_CD" ).append("\n"); 

	}
}