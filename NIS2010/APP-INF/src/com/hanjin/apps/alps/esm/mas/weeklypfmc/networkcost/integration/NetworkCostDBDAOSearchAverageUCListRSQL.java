/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkCostDBDAOSearchAverageUCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.23
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2011.12.23 김성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SUNG-HUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchAverageUCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History------------------------------
	  * 2010.11.15 이행지 [CHM-201006375-01] [MAS] Trunk IPC와 Ocean간 내부거래 신규 추가로 인해서
	  *                                                         기존로직에서 제외하도록 수정
	  * </pre>
	  */
	public NetworkCostDBDAOSearchAverageUCListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_avg_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_avg_suvgrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_mas_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_use_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchAverageUCListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      '' 									 IBFLAG " ).append("\n"); 
		query.append("    , '' 									 F_COST_YRMON  /* 저장시 사용위해*/	" ).append("\n"); 
		query.append("    , TRIM(B.TRD_CD)  						 TRD_CD  	 " ).append("\n"); 
		query.append("    , TRIM(B.RLANE_CD) 						 RLANE_CD 	" ).append("\n"); 
		query.append("    , (SELECT MGRP_COST_CD_DESC    	    		" ).append("\n"); 
		query.append(" 	     FROM MAS_MN_GRP_COST    	    	" ).append("\n"); 
		query.append(" 	     WHERE MGRP_COST_CD =A.MGRP_COST_CD) SUB_GROUP 	" ).append("\n"); 
		query.append(" 	, A.STND_COST_CD 						 STND_COST_CD 	" ).append("\n"); 
		query.append(" 	, A.STND_COST_NM 						 STND_COST_NM 	" ).append("\n"); 
		query.append(" 	, B.OP_COST_AMT 					     OP_COST_AMT  	" ).append("\n"); 
		query.append(" 	, B.BSA_CAPA 							 BSA_CAPA 	" ).append("\n"); 
		query.append(" 	, ROUND(DECODE(B.BSA_CAPA, 0, 0, B.OP_COST_AMT/B.BSA_CAPA),3) 	 BSA_CAPA_CAL 	" ).append("\n"); 
		query.append(" 	, B.OP_UC_AMT 				             OP_UC_AMT" ).append("\n"); 
		query.append("	, (CASE WHEN B.OP_LANE_TP_CD = 'T' THEN 'VESSEL POOL' " ).append("\n"); 
		query.append("     		WHEN B.OP_LANE_TP_CD = 'S' THEN 'SUB TRADE AVG U/C' " ).append("\n"); 
		query.append("     		WHEN B.OP_LANE_TP_CD IN ('L', 'LA') THEN 'LANE AVG U/C' " ).append("\n"); 
		query.append("     		ELSE 'SUB TRADE AVG U/C: '||B.OP_LANE_TP_CD" ).append("\n"); 
		query.append("     		END)  						   AS VVD_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MAS_OP_AVG_UT_COST B , MAS_STND_ACCT A  " ).append("\n"); 
		query.append(" WHERE B.COST_YRMON= @[f_cost_yrmon]	" ).append("\n"); 
		query.append("   AND B.COST_USE_TP_CD	= @[f_cost_use_tp_cd]   " ).append("\n"); 
		query.append(" #if (${f_trd_cd} != '')  	  " ).append("\n"); 
		query.append("   AND B.TRD_CD	    = @[f_trd_cd] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_rlane_cd} != '') " ).append("\n"); 
		query.append("   AND B.RLANE_CD     = @[f_rlane_cd] " ).append("\n"); 
		query.append(" #end 	  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" /*GROUP*/" ).append("\n"); 
		query.append(" #if (${f_avg_grp_cd} != '') " ).append("\n"); 
		query.append("   AND B.OP_LANE_TP_CD= @[f_avg_grp_cd] " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" /*SUB GROUP*/" ).append("\n"); 
		query.append(" #if (${f_avg_suvgrp} != '') " ).append("\n"); 
		query.append("   AND A.MGRP_COST_CD = @[f_avg_suvgrp]" ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" /*MAS CODE*/" ).append("\n"); 
		query.append(" #if (${f_mas_cd} != '') " ).append("\n"); 
		query.append("   AND A.STND_COST_CD = @[f_mas_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("   AND (a.mgrp_cost_cd in ('OV','OF') or a.stnd_cost_cd = '43102011')   " ).append("\n"); 
		query.append("   AND A.STND_COST_CD <> '54600000'" ).append("\n"); 
		query.append("   AND A.STND_COST_CD = B.STND_COST_CD  " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" ORDER BY B.TRD_CD,  B.RLANE_CD, B.STND_COST_CD" ).append("\n"); 

	}
}