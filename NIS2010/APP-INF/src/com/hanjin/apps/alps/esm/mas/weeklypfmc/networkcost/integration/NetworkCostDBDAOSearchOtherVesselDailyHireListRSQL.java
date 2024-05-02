/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchOtherVesselDailyHireListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.02.27 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchOtherVesselDailyHireListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOtherVesselDailyHireList
	  * </pre>
	  */
	public NetworkCostDBDAOSearchOtherVesselDailyHireListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchOtherVesselDailyHireListRSQL").append("\n"); 
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
		query.append("SELECT D1.COST_YRMON," ).append("\n"); 
		query.append("       D1.COST_WK," ).append("\n"); 
		query.append("       D1.VSL_CD," ).append("\n"); 
		query.append("       D1.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("       D1.STND_COST_CD," ).append("\n"); 
		query.append("       D1.CHRG_RT*100 AS CHRG_RT," ).append("\n"); 
		query.append("       D1.VSL_COST_AMT," ).append("\n"); 
		query.append("       D1.TTL_AMT," ).append("\n"); 
		query.append("       D1.TTL_WK_AMT," ).append("\n"); 
		query.append("       D1.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM MAS_OTR_VSL_DLY_HIR D1" ).append("\n"); 
		query.append(" WHERE D1.COST_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("   AND D1.COST_WK         = @[f_fm_wk]" ).append("\n"); 
		query.append("   AND D1.STND_COST_CD(+) = @[f_cobcost]" ).append("\n"); 
		query.append("#if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND D1.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY D1.COST_YRMON," ).append("\n"); 
		query.append("       D1.COST_WK," ).append("\n"); 
		query.append("       D1.VSL_CD," ).append("\n"); 
		query.append("       D1.VSL_CLSS_CAPA" ).append("\n"); 

	}
}