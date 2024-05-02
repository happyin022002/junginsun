/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOSearchLocationTypeAndNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOSearchLocationTypeAndNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.07 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청
	  *                                                 - Location 체크 및 Location Type 을 조회한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOSearchLocationTypeAndNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOSearchLocationTypeAndNameRSQL").append("\n"); 
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
		query.append("#if (${cd_length} == '5') " ).append("\n"); 
		query.append("SELECT LOC_CD CD" ).append("\n"); 
		query.append("     , LOC_NM NM" ).append("\n"); 
		query.append("     , 'L' ETC1" ).append("\n"); 
		query.append("  FROM MDM_LOCATION" ).append("\n"); 
		query.append(" WHERE LOC_CD= @[cd]" ).append("\n"); 
		query.append("   AND DELT_FLG ='N'" ).append("\n"); 
		query.append("#elseif (${cd_length} == '3')" ).append("\n"); 
		query.append("SELECT RGN_CD CD" ).append("\n"); 
		query.append("     , RGN_NM NM" ).append("\n"); 
		query.append("     , 'R' ETC1" ).append("\n"); 
		query.append("  FROM MDM_REGION" ).append("\n"); 
		query.append(" WHERE RGN_CD = @[cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${cd_length} == '2') " ).append("\n"); 
		query.append("SELECT CNT_CD CD" ).append("\n"); 
		query.append("     , CNT_NM NM" ).append("\n"); 
		query.append("     , 'C' ETC1  " ).append("\n"); 
		query.append("  FROM MDM_COUNTRY" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${cd_length} == '1') " ).append("\n"); 
		query.append("SELECT CONTI_CD CD" ).append("\n"); 
		query.append("     , CONTI_NM NM" ).append("\n"); 
		query.append("     , 'O' ETC1  " ).append("\n"); 
		query.append("  FROM MDM_CONTINENT" ).append("\n"); 
		query.append(" WHERE CONTI_CD = @[cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}