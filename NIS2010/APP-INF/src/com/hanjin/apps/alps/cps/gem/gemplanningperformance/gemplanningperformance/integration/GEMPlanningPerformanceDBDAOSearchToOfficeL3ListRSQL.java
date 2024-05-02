/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchToOfficeL3ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchToOfficeL3ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From에 선택된 OFFICE별 TO OFFICE의 레벨3(L3)의 리스트를 취득한다.
	  *  * 2014.10.23 이준범 [CHM-201432499-01]
	  *  * 요청사항: [GEM] Office 코드 하드코딩 수정 ( Committee 권한 확대 ) 
	  *  * 보완: ofc_co_div_cd 조건 추가
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchToOfficeL3ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ofc_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_sls_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchToOfficeL3ListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("  FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND RGN_OFC_FLG = @[to_sls_ofc_div_cd]" ).append("\n"); 
		query.append("   AND L_3 = @[to_ofc_lvl2]" ).append("\n"); 
		query.append("   AND L_4 IN ( " ).append("\n"); 
		query.append("               SELECT OFC_CD" ).append("\n"); 
		query.append("                 FROM GEM_OFFICE" ).append("\n"); 
		query.append("                WHERE RQST_AUTH_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${ofc_co_div_cd} != '') " ).append("\n"); 
		query.append("                  AND OFC_CO_DIV_CD = @[ofc_co_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_co_div_cd} == 'S') " ).append("\n"); 
		query.append("                  AND OFC_CD = @[fm_ofc_lvl3]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND DELT_FLG = 'N')" ).append("\n"); 
		query.append(" ORDER BY CODE" ).append("\n"); 

	}
}