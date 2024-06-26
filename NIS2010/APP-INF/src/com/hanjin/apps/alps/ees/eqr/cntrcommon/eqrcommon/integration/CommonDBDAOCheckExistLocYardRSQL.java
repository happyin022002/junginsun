/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOCheckExistLocYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCheckExistLocYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LOC YARD 가 사용해도 되는 것인지 확인
	  * </pre>
	  */
	public CommonDBDAOCheckExistLocYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locyard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCheckExistLocYardRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) YD_CD							" ).append("\n"); 
		query.append("FROM	MDM_YARD A, 								" ).append("\n"); 
		query.append("      MDM_LOCATION B   			                " ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.SCC_CD 						" ).append("\n"); 
		query.append("AND   A.DELT_FLG <> 'Y'                         " ).append("\n"); 
		query.append("AND   A.YD_CD = @[locyard]                              " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ecc} != '')" ).append("\n"); 
		query.append("AND   A.LOC_CD IN ( 							" ).append("\n"); 
		query.append("					          SELECT SCC_CD 			" ).append("\n"); 
		query.append("					          FROM MDM_EQ_ORZ_CHT 		" ).append("\n"); 
		query.append("					          WHERE ECC_CD = @[ecc] 			" ).append("\n"); 
		query.append("				          ) 							 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- 20160623, 유저요청으로 제거, 신용찬" ).append("\n"); 
		query.append("--AND A.YD_CD <> 'OMSOHY3'  -- HJS 유저요청에 의해 수정(박해진, 20160526), OMSOHY3 는 POD 포함 안됨." ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.YD_CD" ).append("\n"); 

	}
}