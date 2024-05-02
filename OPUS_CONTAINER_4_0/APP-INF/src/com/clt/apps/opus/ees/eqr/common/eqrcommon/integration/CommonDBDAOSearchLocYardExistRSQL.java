/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOSearchLocYardExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.07.28 이주현
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

public class CommonDBDAOSearchLocYardExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC Yard 가 사용해도 되는것인지 확인
	  * </pre>
	  */
	public CommonDBDAOSearchLocYardExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchLocYardExistRSQL").append("\n"); 
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
		query.append("	COUNT(1) YD_CD							" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	MDM_YARD A, 								" ).append("\n"); 
		query.append("    MDM_LOCATION B   			                " ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	A.LOC_CD = B.SCC_CD 						" ).append("\n"); 
		query.append("	AND   A.DELT_FLG <> 'Y'                        " ).append("\n"); 
		query.append("	AND   A.YD_CD = @[locyard]                              " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ecc} != '')" ).append("\n"); 
		query.append("	AND   A.LOC_CD IN ( 							" ).append("\n"); 
		query.append("					      SELECT SCC_CD 			" ).append("\n"); 
		query.append("					      FROM MDM_EQ_ORZ_CHT 		" ).append("\n"); 
		query.append("					      WHERE ECC_CD = @[ecc]" ).append("\n"); 
		query.append("                          UNION ALL" ).append("\n"); 
		query.append("                          SELECT SUBSTR(@[locyard], 1, 5) FROM DUAL 			" ).append("\n"); 
		query.append("				       ) 							 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.YD_CD" ).append("\n"); 

	}
}