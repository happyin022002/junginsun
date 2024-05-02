/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BSAManageDBDAOSearchOverCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchOverCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSAManageDBDAOSearchOverCostListVORSQL
	  * </pre>
	  */
	public BSAManageDBDAOSearchOverCostListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdotype",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchOverCostListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      RANK() OVER (ORDER BY A.TRD_CD||A.RLANE_CD||A.DIR_CD||A.BSA_SLT_COST_TP_CD) GRP," ).append("\n"); 
		query.append("	  MAX(A.OVR_USD_SLT_PRC_SEQ) OVER(PARTITION BY A.TRD_CD||A.RLANE_CD||A.DIR_CD||A.BSA_SLT_COST_TP_CD) MAXSEQ, " ).append("\n"); 
		query.append("	  A.OVR_USD_SLT_PRC_SEQ, " ).append("\n"); 
		query.append("	  A.VVD_CD, " ).append("\n"); 
		query.append("	  A.TRD_CD, " ).append("\n"); 
		query.append("	  A.RLANE_CD, " ).append("\n"); 
		query.append("	  A.DIR_CD," ).append("\n"); 
		query.append("	  A.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("	  A.BSA_SLT_PRC_TO_DT," ).append("\n"); 
		query.append("	  A.CNTR_FULL_FLG, " ).append("\n"); 
		query.append("	  A.BSA_SLT_COST_TP_CD   " ).append("\n"); 
		query.append("	#set($count = 0) " ).append("\n"); 
		query.append("    #foreach( ${keys} in ${keyList}) " ).append("\n"); 
		query.append("       ,MAX(DECODE(B.CRR_CD,'${keys}',B.UC_AMT,0 ) ) AS SLT_PRC_CAPA$count" ).append("\n"); 
		query.append("    #set($count = $count + 1)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("    BSA_OCN_OVR_MST     A " ).append("\n"); 
		query.append("   ,BSA_OCN_OVR_SLT_PRC B " ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("      A.BSA_SLT_COST_TP_CD    = B.BSA_SLT_COST_TP_CD " ).append("\n"); 
		query.append("  AND A.TRD_CD				= B.TRD_CD" ).append("\n"); 
		query.append("  AND A.RLANE_CD			= B.RLANE_CD" ).append("\n"); 
		query.append("  AND A.DIR_CD				= B.DIR_CD" ).append("\n"); 
		query.append("  AND A.OVR_USD_SLT_PRC_SEQ   = B.OVR_USD_SLT_PRC_SEQ " ).append("\n"); 
		query.append("  AND A.BSA_SLT_COST_TP_CD    = @[rdotype]" ).append("\n"); 
		query.append("  AND A.BSA_SLT_PRC_TO_DT     >= @[txtsdate] " ).append("\n"); 
		query.append("  AND  A.DELT_FLG             = 'N'  /*Legacy 전환 요건 협의 결과 요청사항 (JOO vs BSA)*/" ).append("\n"); 
		query.append("#if (${cobtrade} !='') " ).append("\n"); 
		query.append("	 AND A.TRD_CD     = @[cobtrade] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${coblane}!='') " ).append("\n"); 
		query.append("	 AND A.RLANE_CD   = @[coblane] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cobdir}!='') " ).append("\n"); 
		query.append("     AND A.DIR_CD     = @[cobdir] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY " ).append("\n"); 
		query.append("       A.TRD_CD, " ).append("\n"); 
		query.append("       A.RLANE_CD, " ).append("\n"); 
		query.append("       A.DIR_CD, " ).append("\n"); 
		query.append("       A.BSA_SLT_COST_TP_CD, " ).append("\n"); 
		query.append("       A.OVR_USD_SLT_PRC_SEQ, " ).append("\n"); 
		query.append("       A.VVD_CD, " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_TO_DT, " ).append("\n"); 
		query.append("       A.CNTR_FULL_FLG " ).append("\n"); 
		query.append("ORDER BY " ).append("\n"); 
		query.append("       A.TRD_CD, A" ).append("\n"); 
		query.append("       .RLANE_CD, " ).append("\n"); 
		query.append("       A.DIR_CD, " ).append("\n"); 
		query.append("       A.CNTR_FULL_FLG, " ).append("\n"); 
		query.append("       A.OVR_USD_SLT_PRC_SEQ, " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_FM_DT, " ).append("\n"); 
		query.append("       A.BSA_SLT_COST_TP_CD,  " ).append("\n"); 
		query.append("       A.BSA_SLT_PRC_TO_DT" ).append("\n"); 

	}
}