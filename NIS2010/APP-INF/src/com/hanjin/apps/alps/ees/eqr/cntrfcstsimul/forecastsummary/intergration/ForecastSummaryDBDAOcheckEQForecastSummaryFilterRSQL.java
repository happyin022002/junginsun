/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ForecastSummaryDBDAOcheckEQForecastSummaryFilterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.02.17 박정민
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

public class ForecastSummaryDBDAOcheckEQForecastSummaryFilterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQForecastSummaryFilter에 데이터 입력전 중복검사를 위한 SQL
	  * </pre>
	  */
	public ForecastSummaryDBDAOcheckEQForecastSummaryFilterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.intergration").append("\n"); 
		query.append("FileName : ForecastSummaryDBDAOcheckEQForecastSummaryFilterRSQL").append("\n"); 
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
		query.append("  FROM EQR_CTRL_FCAST_SMRY_FTR" ).append("\n"); 
		query.append(" WHERE RCC_CD = @[rcc_cd] " ).append("\n"); 
		query.append("   AND LOC_GRP_CD = @[loc_grp_cd] " ).append("\n"); 
		query.append("   AND LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("   AND DELT_FTR_FLG = 'N'" ).append("\n"); 

	}
}