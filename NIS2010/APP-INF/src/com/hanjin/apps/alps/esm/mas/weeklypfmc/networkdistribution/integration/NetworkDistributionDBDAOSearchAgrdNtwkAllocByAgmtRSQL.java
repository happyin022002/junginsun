/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.14
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.08.14 송민석
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

public class NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtRSQL(){
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
		query.append("FileName : NetworkDistributionDBDAOSearchAgrdNtwkAllocByAgmtRSQL").append("\n"); 
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
		query.append("SELECT B.COST_YRMON, B.COST_WK AS FM_COST_WK" ).append("\n"); 
		query.append("     , A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD" ).append("\n"); 
		query.append("     , A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("     , A.FM_VSL_CD || A.FM_SKD_VOY_NO || A.FM_DIR_CD AS FM_VVD" ).append("\n"); 
		query.append("     , A.TS_UC_AMT, A.SML_SLS_AMT, A.CHT_OUT_AMT" ).append("\n"); 
		query.append("     , B.COST_WK AS TO_COST_WK" ).append("\n"); 
		query.append("     , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD" ).append("\n"); 
		query.append("     , A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD     " ).append("\n"); 
		query.append("     , A.TO_VSL_CD || A.TO_SKD_VOY_NO || A.TO_DIR_CD AS TO_VVD" ).append("\n"); 
		query.append("     , A.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("     , DECODE(A.BZC_ALOC_TP_CD, 'R', 'Y', 'N') AS RAT_FLG" ).append("\n"); 
		query.append("     , DECODE(A.BZC_ALOC_TP_CD, 'F', 'Y', 'N') AS FX_AMT_FLG" ).append("\n"); 
		query.append("     , A.OVR_USD_ALOC_CHG_FLG" ).append("\n"); 
		query.append("     , A.BSA, DECODE(A.BSA,0,0,A.AGRD_TEU / A.BSA) * 100 AS RTO, A.AGRD_TEU, A.TS_TEU, A.OVR_TEU" ).append("\n"); 
		query.append("     , A.OVR_USD_ALOC_CHG_RTO, A.OVR_SLT_PRC, A.BZC_ALOC_FX_AMT" ).append("\n"); 
		query.append("     , A.AGRD_EXPN_AMT, A.OVR_USD_AMT, A.FX_EXPN_AMT" ).append("\n"); 
		query.append("	 , A.CRE_USR_ID,A.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM MAS_ALOC_AGMT_EXPN A, MAS_MON_VVD B" ).append("\n"); 
		query.append(" WHERE A.TO_TRD_CD       = B.TRD_CD    " ).append("\n"); 
		query.append("   AND A.TO_RLANE_CD     = B.RLANE_CD  " ).append("\n"); 
		query.append("   AND A.TO_IOC_CD       = B.IOC_CD    " ).append("\n"); 
		query.append("   AND A.TO_VSL_CD       = B.VSL_CD    " ).append("\n"); 
		query.append("   AND A.TO_SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.TO_DIR_CD       = B.DIR_CD" ).append("\n"); 
		query.append("   AND B.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("	AND B.COST_YRMON = @[f_year] || @[f_mon]  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("	AND B.COST_YRMON LIKE @[f_year]  || '%'  " ).append("\n"); 
		query.append("   	AND B.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" ORDER BY B.COST_YRMON, B.COST_WK" ).append("\n"); 
		query.append("        , A.FM_TRD_CD, A.FM_RLANE_CD, A.FM_IOC_CD, A.FM_VSL_CD, A.FM_SKD_VOY_NO, A.FM_DIR_CD" ).append("\n"); 
		query.append("        , A.LOCL_TS_STS_CD " ).append("\n"); 
		query.append("        , A.TO_TRD_CD, A.TO_RLANE_CD, A.TO_IOC_CD, A.TO_VSL_CD, A.TO_SKD_VOY_NO, A.TO_DIR_CD" ).append("\n"); 

	}
}