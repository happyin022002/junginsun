/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardVesselAllInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.29 
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

public class CommonDBDAOSearchLocYardVesselAllInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD를 조회후 Yard정보 추출
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardVesselAllInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocYardVesselAllInfoRSQL").append("\n"); 
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
		query.append("				WHERE LOC_CD IN (" ).append("\n"); 
		query.append("		#if($searchwordArr.size() == 0)" ).append("\n"); 
		query.append("			''" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#foreach( ${key} in ${searchwordArr}) " ).append("\n"); 
		query.append("				#if($velocityCount < $searchwordArr.size()) " ).append("\n"); 
		query.append("					'$key', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					'$key' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("			   ) 											 " ).append("\n"); 
		query.append("	AND B.CALL_PORT_FLG = @[delt_flg]     -- CALL_PORT_FLG=Y is mean major port" ).append("\n"); 
		query.append("	AND A.LOC_CD= B.LOC_CD	                                    " ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}