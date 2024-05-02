/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.26 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtCreDSQL").append("\n"); 
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
		query.append("DELETE FROM MAS_ALOC_AGMT_EXPN " ).append("\n"); 
		query.append("WHERE (FM_TRD_CD, FM_RLANE_CD, FM_IOC_CD, FM_VSL_CD, FM_SKD_VOY_NO, FM_DIR_CD )" ).append("\n"); 
		query.append("	IN ( " ).append("\n"); 
		query.append("		SELECT   A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD " ).append("\n"); 
		query.append("		FROM MAS_MON_VVD A " ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("			#if (${fm_cost_wk} != '')" ).append("\n"); 
		query.append("			   AND A.COST_YRMON LIKE substr(@[cost_yrmon],0,4) || '%' " ).append("\n"); 
		query.append("			   AND A.COST_WK BETWEEN @[fm_cost_wk] AND @[to_cost_wk]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${fm_cost_wk} == '')" ).append("\n"); 
		query.append("			    AND A.COST_YRMON = @[cost_yrmon]  " ).append("\n"); 
		query.append("			#end	" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}