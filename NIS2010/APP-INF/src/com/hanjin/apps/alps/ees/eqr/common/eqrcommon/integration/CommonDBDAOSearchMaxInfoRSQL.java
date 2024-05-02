/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchMaxInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.12
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.07.12 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMaxInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *      각 테이블의 UPDATE된 최근  아이디와 UPDATE 날짜를 구해오는 로직 
	  * </pre>
	  */
	public CommonDBDAOSearchMaxInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMaxInfoRSQL").append("\n"); 
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
		query.append("SELECT 	MAX_USRID" ).append("\n"); 
		query.append("   		,MAX_UPDATE" ).append("\n"); 
		query.append("        ,UPD_DT 								" ).append("\n"); 
		query.append("FROM  																" ).append("\n"); 
		query.append("	(   SELECT NVL(UPD_USR_ID,' ') MAX_USRID 						" ).append("\n"); 
		query.append("			  ,TO_CHAR(MAX(NVL(UPD_DT,'')),'YYYY-MM-DD') MAX_UPDATE 			" ).append("\n"); 
		query.append("			  ,MAX(NVL(UPD_DT,'')) UPD_DT  						" ).append("\n"); 
		query.append("		 FROM  ${table_name}											" ).append("\n"); 
		query.append("		 	   WHERE UPD_DT IS NOT NULL " ).append("\n"); 
		query.append("#if (${condition} != '')" ).append("\n"); 
		query.append("	#if (${condition} == 'SQL')" ).append("\n"); 
		query.append("				AND ST_DT BETWEEN (SELECT WK_ST_DT FROM EQR_WK_PRD	WHERE PLN_YR||PLN_WK = @[st_pln_yrwk])" ).append("\n"); 
		query.append("		    	AND (SELECT WK_END_DT FROM EQR_WK_PRD WHERE PLN_YR||PLN_WK = @[end_pln_yrwk])" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			    AND ${condition}  	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end                          		" ).append("\n"); 
		query.append(" 	    GROUP BY UPD_USR_ID                      " ).append("\n"); 
		query.append("        ORDER BY UPD_DT DESC                     					" ).append("\n"); 
		query.append("	 )															" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}