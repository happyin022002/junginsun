/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastSummaryDBDAOsearchLocationCodeByTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.01.19 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastSummaryDBDAOsearchLocationCodeByTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1101 RCC_CD, LOC_GRP_CD에 따른 하위 LOCATION 코드 조회
	  * </pre>
	  */
	public ForecastSummaryDBDAOsearchLocationCodeByTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration").append("\n"); 
		query.append("FileName : ForecastSummaryDBDAOsearchLocationCodeByTypeRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append(" WHERE RCC_CD = @[s_rcc_cd]" ).append("\n"); 
		query.append(" #if(${s_loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("   AND ECC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append(" #elseif(${s_loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("   AND SCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append(" #elseif(${s_loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("   AND LCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("       LCC_CD = @[s_loc_cd] OR ECC_CD = @[s_loc_cd] OR SCC_CD = @[s_loc_cd]" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}