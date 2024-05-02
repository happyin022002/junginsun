/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchMissingStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.27
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.02.27 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchMissingStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchMissingStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_week_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_week_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_month_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_month_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchMissingStatusRSQL").append("\n"); 
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
		query.append("SELECT SUM (MSS_CNT) MSS_CNT" ).append("\n"); 
		query.append("  FROM (SELECT COUNT (*) MSS_CNT" ).append("\n"); 
		query.append("          FROM COA_MSS_STS" ).append("\n"); 
		query.append("         #if (${priod} == 'M')" ).append("\n"); 
		query.append("            WHERE SUBSTR(cost_yrwk, 1, 4)||COST_MON BETWEEN @[cost_year]||@[cost_month_s] AND @[cost_year]||@[cost_month_e]" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("            WHERE COST_YRWK BETWEEN @[cost_year]||@[cost_week_s] AND @[cost_year]||@[cost_week_e]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         AND PRC_NM IN('COA_CREATE_NTCOST_PRC','COA_CREATE_SPC_CHT_PRC')" ).append("\n"); 
		query.append("         AND BSA_ZR_FLG = 'N' /* BSA_ZR_FLG = 'Y' 이면 카운트 안함 */" ).append("\n"); 
		query.append("         #if (${trd_cd} != '')" ).append("\n"); 
		query.append("           AND TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${rlane_cd} != '')" ).append("\n"); 
		query.append("           AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${ioc_cd} != '')" ).append("\n"); 
		query.append("           AND IOC_CD = @[ioc_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("           AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         #if (${dir_cd} != '')" ).append("\n"); 
		query.append("           AND DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}