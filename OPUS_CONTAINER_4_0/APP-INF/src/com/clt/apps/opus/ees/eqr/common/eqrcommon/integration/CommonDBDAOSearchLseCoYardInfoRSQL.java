/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchLseCoYardInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.08
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.04.08 이주현
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

public class CommonDBDAOSearchLseCoYardInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 임대사  Yard combo box 정보를 검색
	  * * EES_EQR_059 TAB3
	  * </pre>
	  */
	public CommonDBDAOSearchLseCoYardInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CommonDBDAOSearchLseCoYardInfoRSQL").append("\n"); 
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
		query.append("	LSE_CO_YD_CD YD_CD                                  " ).append("\n"); 
		query.append("    ,REPLACE(LSE_CO_YD_NM, '''', ' ') YD_NM                                  " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	MDM_LSE_CO_YD				 				            				" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		LSE_CO_VNDR_SEQ1 = @[locyard_vndr_seq] " ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ2 = @[locyard_vndr_seq]  		" ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ3 = @[locyard_vndr_seq] " ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ4 = @[locyard_vndr_seq]	" ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ5 = @[locyard_vndr_seq]   " ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ6 = @[locyard_vndr_seq]	" ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ7 = @[locyard_vndr_seq] " ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ8 = @[locyard_vndr_seq]	" ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ9 = @[locyard_vndr_seq] " ).append("\n"); 
		query.append("		OR LSE_CO_VNDR_SEQ10 = @[locyard_vndr_seq]	" ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	AND SUBSTR(LSE_CO_YD_CD, 0, 5) IN (                                                " ).append("\n"); 
		query.append("										SELECT ML.LOC_CD 						         		" ).append("\n"); 
		query.append("	                                   	FROM MDM_EQ_ORZ_CHT SEC" ).append("\n"); 
		query.append("                                            ,MDM_EQ_ORZ_CHT EC" ).append("\n"); 
		query.append("                                            ,MDM_LOCATION ML   		" ).append("\n"); 
		query.append("	                                    WHERE SEC.ECC_CD LIKE @[locyard_searchword]" ).append("\n"); 
		query.append("                                        AND   SEC.LCC_CD = EC.LCC_CD" ).append("\n"); 
		query.append("                                        AND   EC.SCC_CD  = ML.SCC_CD   " ).append("\n"); 
		query.append("	                                  )														" ).append("\n"); 
		query.append("	AND  DELT_FLG <> @[delt_flg]                           " ).append("\n"); 
		query.append("ORDER BY LSE_CO_YD_CD" ).append("\n"); 

	}
}