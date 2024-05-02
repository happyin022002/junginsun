/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterRSQL.java
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

public class NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtInterRSQL").append("\n"); 
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
		query.append("SELECT FM_VVD.COST_YRMON AS FM_COST_YRMON, FM_VVD.COST_WK AS FM_COST_WK" ).append("\n"); 
		query.append("     , A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD" ).append("\n"); 
		query.append("     , A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("     , A.FM_VSL_CD || A.FM_SKD_VOY_NO || A.FM_DIR_CD AS FM_VVD" ).append("\n"); 
		query.append("     , A.FM_TS_UC_AMT, A.FM_SML_SLS_AMT" ).append("\n"); 
		query.append("     , TO_VVD.COST_YRMON AS TO_COST_YRMON, TO_VVD.COST_WK AS TO_COST_WK" ).append("\n"); 
		query.append("     , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD" ).append("\n"); 
		query.append("     , A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD" ).append("\n"); 
		query.append("     , A.TO_VSL_CD || A.TO_SKD_VOY_NO || A.TO_DIR_CD AS TO_VVD" ).append("\n"); 
		query.append("     , A.LOCL_TS_STS_CD, A.TS_QTY" ).append("\n"); 
		query.append("     , A.TS_QTY_RTO, A.TS_EXPN_AMT" ).append("\n"); 
		query.append("	 , A.CRE_USR_ID" ).append("\n"); 
		query.append("	 , A.UPD_USR_ID" ).append("\n"); 
		query.append("	 , '' AS COST_YRMON" ).append("\n"); 
		query.append("  FROM MAS_ALOC_INTER_TS_EXPN A, MAS_MON_VVD FM_VVD, MAS_MON_VVD TO_VVD" ).append("\n"); 
		query.append(" WHERE A.FM_TRD_CD        = FM_VVD.TRD_CD" ).append("\n"); 
		query.append("   AND A.FM_RLANE_CD      = FM_VVD.RLANE_CD" ).append("\n"); 
		query.append("   AND A.FM_IOC_CD        = FM_VVD.IOC_CD" ).append("\n"); 
		query.append("   AND A.FM_VSL_CD        = FM_VVD.VSL_CD" ).append("\n"); 
		query.append("   AND A.FM_SKD_VOY_NO    = FM_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.FM_DIR_CD        = FM_VVD.DIR_CD" ).append("\n"); 
		query.append("   AND A.TO_TRD_CD        = TO_VVD.TRD_CD" ).append("\n"); 
		query.append("   AND A.TO_RLANE_CD      = TO_VVD.RLANE_CD" ).append("\n"); 
		query.append("   AND A.TO_IOC_CD        = TO_VVD.IOC_CD" ).append("\n"); 
		query.append("   AND A.TO_VSL_CD        = TO_VVD.VSL_CD" ).append("\n"); 
		query.append("   AND A.TO_SKD_VOY_NO    = TO_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.TO_DIR_CD        = TO_VVD.DIR_CD" ).append("\n"); 
		query.append("   AND FM_VVD.DELT_FLG   <> 'Y'" ).append("\n"); 
		query.append("   AND TO_VVD.DELT_FLG   <> 'Y'" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("	AND FM_VVD.COST_YRMON = @[f_year] || @[f_mon]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("	AND FM_VVD.COST_YRMON LIKE @[f_year]  || '%'  " ).append("\n"); 
		query.append("   	AND FM_VVD.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY FM_VVD.COST_YRMON, FM_VVD.COST_WK" ).append("\n"); 
		query.append("        , A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("        , A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("        , TO_VVD.COST_YRMON, TO_VVD.COST_WK" ).append("\n"); 
		query.append("        , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD, A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD" ).append("\n"); 

	}
}