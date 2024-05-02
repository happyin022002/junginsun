/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : NetworkCostDBDAOcreateAverageOwnDailyHireCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOcreateAverageOwnDailyHireCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.08.14 이석준 [CHM-201219592-01] AVG-hire by Own-VSL (PA) 화면에 Load excel 기능 추가
	  * </pre>
	  */
	public NetworkCostDBDAOcreateAverageOwnDailyHireCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOcreateAverageOwnDailyHireCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_OWN_VSL_DLY_HIR" ).append("\n"); 
		query.append(" (COST_YRMON," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("VSL_CLSS_CAPA," ).append("\n"); 
		query.append("STND_COST_CD," ).append("\n"); 
		query.append("DHIR_AMT," ).append("\n"); 
		query.append("OWN_VSL_RMK," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append(" SELECT COST_YRMON" ).append("\n"); 
		query.append("               ,'XXXX' AS VSL_CD" ).append("\n"); 
		query.append("              ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("              ,STND_COST_CD" ).append("\n"); 
		query.append("              ,SUM(DHIR_AMT)/COUNT(DISTINCT VSL_CD) AMT" ).append("\n"); 
		query.append("              ,'AVG'" ).append("\n"); 
		query.append("              ,@[user_id]" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("              ,@[user_id]" ).append("\n"); 
		query.append("              ,SYSDATE" ).append("\n"); 
		query.append("      FROM COA_OWN_VSL_DLY_HIR" ).append("\n"); 
		query.append("    WHERE COST_YRMON = @[f_yearweek]" ).append("\n"); 
		query.append("    GROUP BY COST_YRMON" ).append("\n"); 
		query.append("              , VSL_CLSS_CAPA" ).append("\n"); 
		query.append("              , STND_COST_CD" ).append("\n"); 

	}
}