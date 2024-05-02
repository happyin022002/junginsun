/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkCostRtoInquiryRSQL.java
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

public class NetworkDistributionDBDAOSearchAgrdNtwkCostRtoInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkCostRtoInquiryRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkCostRtoInquiryRSQL").append("\n"); 
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
		query.append("SELECT A.COST_YRMON" ).append("\n"); 
		query.append("     , A.GRP_SEQ, A.COST_YRMON_SEQ" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD, 'LO', A.TRD_CD, '')      AS FM_TRD_CD" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD, 'LO', B.SLAN_CD, '')     AS FM_LANE_CD" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD, 'LO', A.IOC_CD, '')      AS FM_IOC_CD" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD, 'LO', B.HUL_BND_CD, '')  AS FM_HUL_BND_CD" ).append("\n"); 
		query.append("     , DECODE(A.LOCL_TS_STS_CD, 'LO', A.DIR_CD, '')      AS FM_DIR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD                                          AS TO_TRD_CD" ).append("\n"); 
		query.append("     , B.SLAN_CD                                         AS TO_LANE_CD" ).append("\n"); 
		query.append("     , A.IOC_CD                                          AS TO_IOC_CD" ).append("\n"); 
		query.append("     , B.HUL_BND_CD                                      AS TO_HUL_BND_CD" ).append("\n"); 
		query.append("     , A.DIR_CD                                          AS TO_DIR_CD" ).append("\n"); 
		query.append("     , A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("     , A.BZC_ALOC_TP_CD, A.BZC_ALOC_RTO, A.BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("     , A.OVR_USD_ALOC_CHG_FLG, A.OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append("  FROM MAS_AGRD_NTWK_COST_RTO A, MAS_LANE_RGST B" ).append("\n"); 
		query.append(" WHERE A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("   AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("   AND A.IOC_CD = B.IOC_CD" ).append("\n"); 
		query.append("   AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("   AND A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("   AND B.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("   AND A.cost_yrmon = replace(@[f_cost_yrmon] ,'-','')" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" ORDER BY A.COST_YRMON, A.GRP_SEQ, A.LOCL_TS_STS_CD, A.COST_YRMON_SEQ" ).append("\n"); 

	}
}