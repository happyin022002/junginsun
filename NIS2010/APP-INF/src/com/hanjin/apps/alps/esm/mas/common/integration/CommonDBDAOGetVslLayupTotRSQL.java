/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CommonDBDAOGetVslLayupTotRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOGetVslLayupTotRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total값 구하기
	  * </pre>
	  */
	public CommonDBDAOGetVslLayupTotRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOGetVslLayupTotRSQL").append("\n"); 
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
		query.append("#if (${rlane_cd} == 'CDMCO')" ).append("\n"); 
		query.append("SELECT SUM(VSL_CHARTER) - (SUM(PORT_EXP) + SUM(CANAL_TRANS) + SUM(BUNKER) + SUM(CREW_EXP) + SUM(INSUR) + SUM(LUBRI_EXP) + SUM(STORE_SUP)" ).append("\n"); 
		query.append("    + SUM(VSL_MNR) + SUM(DEPREC) + SUM(TEL_EXP) + SUM(OTHER_OPER) + SUM(TIME_CHART) + SUM(SPACE_CHART)) AS TOT" ).append("\n"); 
		query.append("#elseif (${rlane_cd} == 'CNTLY')" ).append("\n"); 
		query.append("SELECT (SUM(PORT_EXP) + SUM(CANAL_TRANS) + SUM(BUNKER) + SUM(CREW_EXP) + SUM(INSUR) + SUM(LUBRI_EXP) + SUM(STORE_SUP)" ).append("\n"); 
		query.append("    + SUM(VSL_MNR) + SUM(DEPREC) + SUM(TEL_EXP) + SUM(OTHER_OPER) + SUM(TIME_CHART) + SUM(SPACE_CHART)) AS TOT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("#if (${rlane_cd} == 'CDMCO')" ).append("\n"); 
		query.append("		(CASE WHEN STND_COST_CD='43101011' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS VSL_CHARTER," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='53101000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS PORT_EXP," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='53102000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS CANAL_TRANS," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='53200000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS BUNKER," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54100000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS CREW_EXP," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54250000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS INSUR," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54300000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS LUBRI_EXP," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54200000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS STORE_SUP," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54150000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS VSL_MNR," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54450000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS DEPREC," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54180000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS TEL_EXP," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54550000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS OTHER_OPER," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54350000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS TIME_CHART," ).append("\n"); 
		query.append("           (CASE WHEN STND_COST_CD='54400000' THEN TTL_AMT" ).append("\n"); 
		query.append("           END) AS SPACE_CHART" ).append("\n"); 
		query.append("    FROM MAS_MNL_DTL_COST" ).append("\n"); 
		query.append("    WHERE COST_YRMON LIKE SUBSTR(REPLACE(@[f_tar_week],'-',''),1,4)||'%'" ).append("\n"); 
		query.append("        AND COST_WK = SUBSTR(REPLACE(@[f_tar_week],'-',''),5,2)    " ).append("\n"); 
		query.append("        AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}