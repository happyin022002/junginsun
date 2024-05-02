/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOSearchToOfficeL2ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.21 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOSearchToOfficeL2ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * From에 선택된 OFFICE별 TO OFFICE의 레벨2(L2)의 리스트를 취득한다.
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOSearchToOfficeL2ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fm_ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOSearchToOfficeL2ListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT L_3 CODE" ).append("\n"); 
		query.append("FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND RGN_OFC_FLG = @[to_sls_ofc_div_cd]" ).append("\n"); 
		query.append("AND L_2 =  @[to_ofc_lvl1]" ).append("\n"); 
		query.append("AND L_4 IN (" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("FROM GEM_OFFICE" ).append("\n"); 
		query.append("WHERE RQST_AUTH_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${ofc_co_div_cd} == 'S')" ).append("\n"); 
		query.append("AND PRNT_OFC_CD   = @[fm_ofc_lvl2]" ).append("\n"); 
		query.append("AND OFC_CO_DIV_CD =  @[ofc_co_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 

	}
}