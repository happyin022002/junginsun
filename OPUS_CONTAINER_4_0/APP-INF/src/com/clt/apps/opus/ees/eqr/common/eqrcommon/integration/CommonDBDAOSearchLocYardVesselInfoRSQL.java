/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardVesselInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.04.07 이주현
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

public class CommonDBDAOSearchLocYardVesselInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC Yard(vessel) combo box 정보를 검색
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardVesselInfoRSQL(){
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
		query.append("FileName : CommonDBDAOSearchLocYardVesselInfoRSQL").append("\n"); 
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
		query.append("	A.YD_CD                                              " ).append("\n"); 
		query.append("    , REPLACE(A.YD_NM, '''', ' ') YD_NM                                              " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MDM_YARD A,  								            " ).append("\n"); 
		query.append("    MDM_LOCATION B   						                		               					" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.DELT_FLG <> @[delt_flg]                  					" ).append("\n"); 
		query.append("   			" ).append("\n"); 
		query.append("	AND A.LOC_CD IN ( 				 							" ).append("\n"); 
		query.append("				SELECT LOC_CD 								" ).append("\n"); 
		query.append("				FROM MDM_LOCATION 						" ).append("\n"); 
		query.append("				WHERE LOC_CD LIKE @[locyard_searchword]                         " ).append("\n"); 
		query.append("			   ) 											 " ).append("\n"); 
		query.append("	AND B.CALL_PORT_FLG = @[delt_flg]     -- CALL_PORT_FLG=Y is mean major port" ).append("\n"); 
		query.append("	AND A.LOC_CD= B.LOC_CD	                                    " ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}