/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkCostRtoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.20 송민석
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

public class NetworkDistributionDBDAOSearchAgrdNtwkCostRtoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkCostRtoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_locl_ts_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkCostRtoRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("    RTO.COST_YRMON" ).append("\n"); 
		query.append("    , RTO.COST_YRMON_SEQ" ).append("\n"); 
		query.append("    , RTO.GRP_SEQ" ).append("\n"); 
		query.append("    , RTO.TRD_CD" ).append("\n"); 
		query.append("    , RTO.RLANE_CD" ).append("\n"); 
		query.append("    , RTO.IOC_CD" ).append("\n"); 
		query.append("    , RTO.DIR_CD" ).append("\n"); 
		query.append("    , RTO.BZC_ALOC_TP_CD" ).append("\n"); 
		query.append("    , RTO.BZC_ALOC_RTO" ).append("\n"); 
		query.append("    , RTO.BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("    , RTO.OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append("    , RTO.OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append("    , RTO.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("	, RGST.HUL_BND_CD  " ).append("\n"); 
		query.append("from MAS_AGRD_NTWK_COST_RTO RTO, MAS_LANE_RGST RGST" ).append("\n"); 
		query.append("where " ).append("\n"); 
		query.append("    RTO.RLANE_CD = RGST.RLANE_CD " ).append("\n"); 
		query.append("    AND RTO.DIR_CD = RGST.DIR_CD" ).append("\n"); 
		query.append("    AND RTO.TRD_CD = RGST.TRD_CD" ).append("\n"); 
		query.append("    AND RTO.IOC_CD = RGST.IOC_CD" ).append("\n"); 
		query.append("	AND RGST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND RTO.cost_yrmon = replace(@[f_cost_yrmon] ,'-','')" ).append("\n"); 
		query.append("#if (${f_locl_ts_sts_cd} != '')" ).append("\n"); 
		query.append("	and RTO.LOCL_TS_STS_CD = @[f_locl_ts_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by GRP_SEQ,LOCL_TS_STS_CD" ).append("\n"); 

	}
}