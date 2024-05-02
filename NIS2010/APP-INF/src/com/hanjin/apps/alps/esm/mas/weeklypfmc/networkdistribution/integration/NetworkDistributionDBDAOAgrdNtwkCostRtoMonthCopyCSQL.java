/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOAgrdNtwkCostRtoMonthCopyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.10 송민석
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

public class NetworkDistributionDBDAOAgrdNtwkCostRtoMonthCopyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOAgrdNtwkCostRtoMonthCopyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_src_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tar_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOAgrdNtwkCostRtoMonthCopyCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_AGRD_NTWK_COST_RTO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COST_YRMON" ).append("\n"); 
		query.append(", COST_YRMON_SEQ" ).append("\n"); 
		query.append(", GRP_SEQ" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", IOC_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", BZC_ALOC_TP_CD" ).append("\n"); 
		query.append(", BZC_ALOC_RTO" ).append("\n"); 
		query.append(", BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append(", OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append(", OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", LOCL_TS_STS_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[f_tar_mon] as COST_YRMON" ).append("\n"); 
		query.append(", COST_YRMON_SEQ" ).append("\n"); 
		query.append(", GRP_SEQ" ).append("\n"); 
		query.append(", TRD_CD" ).append("\n"); 
		query.append(", RLANE_CD" ).append("\n"); 
		query.append(", IOC_CD" ).append("\n"); 
		query.append(", DIR_CD" ).append("\n"); 
		query.append(", BZC_ALOC_TP_CD" ).append("\n"); 
		query.append(", BZC_ALOC_RTO" ).append("\n"); 
		query.append(", BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append(", OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append(", OVR_USD_ALOC_CHG_RTO" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append("        , SYSDATE CRE_DT" ).append("\n"); 
		query.append("        , @[user_id] CRE_USR_ID" ).append("\n"); 
		query.append("        , SYSDATE UPD_DT" ).append("\n"); 
		query.append("        , @[user_id] UPD_USR_ID" ).append("\n"); 
		query.append(", LOCL_TS_STS_CD " ).append("\n"); 
		query.append("  FROM MAS_AGRD_NTWK_COST_RTO" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_src_mon]" ).append("\n"); 

	}
}