/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ForecastReportDBDAOsearchLocationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.07.11 문동선
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

public class ForecastReportDBDAOsearchLocationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * LCC/ECC/SCC 에 포함된 LOCATION CODE(PORT) 조회
	  * </pre>
	  */
	public ForecastReportDBDAOsearchLocationListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.integration").append("\n"); 
		query.append("FileName : ForecastReportDBDAOsearchLocationListRSQL").append("\n"); 
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
		query.append("SELECT B.LOC_CD YD_CD, B.LOC_CD YD_CD" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("    ,MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE A.SCC_CD=B.SCC_CD" ).append("\n"); 
		query.append("AND   B.PORT_INLND_CD = 'Y'  -- PORT 만 조회" ).append("\n"); 
		query.append("AND   B.DELT_FLG      = 'N'  -- 사용중인 LOCATION " ).append("\n"); 
		query.append("#if(${loc_grp_cd} == 'S')" ).append("\n"); 
		query.append("  AND A.SCC_CD = @[loc_cd]  -- IF GRP_CD=S" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'E')" ).append("\n"); 
		query.append("  AND A.ECC_CD = @[loc_cd]  -- IF GRP_CD=E" ).append("\n"); 
		query.append("#elseif(${loc_grp_cd} == 'L')" ).append("\n"); 
		query.append("  AND A.LCC_CD = @[loc_cd]  -- IF GRP_CD=L" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.LOC_CD" ).append("\n"); 

	}
}