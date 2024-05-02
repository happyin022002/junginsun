/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOcheckPlannedRepoInYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.26
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.07.26 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ForecastReportDBDAOcheckPlannedRepoInYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ForecastReportDBDAOcheckPlannedRepoInYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yard",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOcheckPlannedRepoInYardRSQL").append("\n"); 
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
		query.append("       END YARD_CHK                       " ).append("\n"); 
		query.append("FROM MDM_YARD       A" ).append("\n"); 
		query.append("    ,MDM_LOCATION   B" ).append("\n"); 
		query.append("    ,MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND   B.SCC_CD = C.SCC_CD" ).append("\n"); 
		query.append("AND   A.YD_CD  = @[yard] -- YARD 입력값" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'L')          " ).append("\n"); 
		query.append("AND C.LCC_CD = @[loc_cd] -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')         " ).append("\n"); 
		query.append("AND C.ECC_CD = @[loc_cd] -- E:ECC, L:LCC, S:SCC" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'S')       " ).append("\n"); 
		query.append("AND C.SCC_CD = @[loc_cd] -- E:ECC, L:LCC, S:SCC " ).append("\n"); 
		query.append("#end  " ).append("\n"); 

	}
}