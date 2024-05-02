/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ForecastReportDBDAOcheckSubLocCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOcheckSubLocCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sub_loc_cd가 입력 되었을 때 입력 가능 여부 체크
	  * </pre>
	  */
	public ForecastReportDBDAOcheckSubLocCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd_second",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOcheckSubLocCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'T'" ).append("\n"); 
		query.append("                              ELSE 'F'" ).append("\n"); 
		query.append("       END LOCA_FLAG                              " ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("WHERE RCC_CD = @[loc_cd] -- RCC SELECT BOX에서 선택된 정보" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${div_flag} == '1')  -- Location By 라디오 버튼 선택" ).append("\n"); 
		query.append("	#if(${loc_type_code} == 'RE' || ${loc_type_code} == 'RS')  -- RCC(by ECC), RCC(by SCC) 일때 조건" ).append("\n"); 
		query.append("AND	  RCC_CD = @[sub_loc_cd]" ).append("\n"); 
		query.append("	#elseif(${loc_type_code} == 'LE' || ${loc_type_code} == 'LS')" ).append("\n"); 
		query.append("AND   LCC_CD = @[sub_loc_cd] -- LCC(by ECC), LCC(by SCC) 일때 조건" ).append("\n"); 
		query.append("	#elseif(${loc_type_code} == 'ES')  -- E 일때" ).append("\n"); 
		query.append("AND   ECC_CD = @[sub_loc_cd] -- ECC(by SCC) 일때 조건" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${loc_tp_cd_second} == 'L')      -- LCC 일때 조건" ).append("\n"); 
		query.append("AND	  LCC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("    #elseif(${loc_tp_cd_second} == 'E')  -- ECC 일때 조건" ).append("\n"); 
		query.append("AND	  ECC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("    #else   -- SCC조건일때" ).append("\n"); 
		query.append("AND	  SCC_CD = @[loc_cd_second]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}