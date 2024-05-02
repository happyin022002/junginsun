/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOGenExpStndCostLanePopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOGenExpStndCostLanePopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * General Expense Lane Check 를 조회한다.
	  * 2015.03.18 컬럼 속성명 변경으로 수정(GEN_EXPN_AMT,ADD_EXPN_AMT)
	  * </pre>
	  */
	public NetworkCostDBDAOGenExpStndCostLanePopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOGenExpStndCostLanePopRSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD AS RLANE_CD1," ).append("\n"); 
		query.append("	   RLANE_CD AS RLANE_CD2," ).append("\n"); 
		query.append("       --DIR_CD," ).append("\n"); 
		query.append("       SUM(ORG_GEN_EXPN) AS ORG_GEN_EXPN," ).append("\n"); 
		query.append("       SUM(TGT_GEN_EXPN) AS TGT_GEN_EXPN," ).append("\n"); 
		query.append("	   SUM(TGT_GEN_EXPN) - SUM(ORG_GEN_EXPN) AS DIFF_GEN_EXPN " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.RLANE_CD||B.DIR_CD AS RLANE_CD," ).append("\n"); 
		query.append("               0 AS ORG_GEN_EXPN," ).append("\n"); 
		query.append("               NVL(SUM(A.GEN_EXPN_AMT),0) + NVL(SUM(A.ADD_EXPN_AMT),0) AS TGT_GEN_EXPN                       " ).append("\n"); 
		query.append("          FROM  " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                       B1.COST_YRMON," ).append("\n"); 
		query.append("                       B1.TRD_CD,      " ).append("\n"); 
		query.append("                       B1.RLANE_CD," ).append("\n"); 
		query.append("                       B1.DIR_CD," ).append("\n"); 
		query.append("                       B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                  FROM MAS_MON_VVD   B1," ).append("\n"); 
		query.append("                       (SELECT A1.VSL_SEQ," ).append("\n"); 
		query.append("                               A1.VSL_CD," ).append("\n"); 
		query.append("                               A1.VSL_TP_CD," ).append("\n"); 
		query.append("                               A1.VSL_OSHP_CD," ).append("\n"); 
		query.append("                               A1.VOP_CD," ).append("\n"); 
		query.append("                               A1.PORT_CLSS_CAPA," ).append("\n"); 
		query.append("                               A1.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("    						   NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT)  AS FM_DT,			" ).append("\n"); 
		query.append("                      		   NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT) AS TO_DT " ).append("\n"); 
		query.append("                          FROM MAS_VSL_RGST A1" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                       ) B2" ).append("\n"); 
		query.append("                 WHERE B1.VSL_CD              = B2.VSL_CD" ).append("\n"); 
		query.append("                   AND B1.COST_YRMON          = @[f_yearweek]" ).append("\n"); 
		query.append("                   AND B1.DELT_FLG           <> 'Y'" ).append("\n"); 
		query.append("                   AND B1.RLANE_CD           != 'RBCCO'" ).append("\n"); 
		query.append("                   AND B2.VSL_TP_CD           = 'C'" ).append("\n"); 
		query.append("                   AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                               BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                               AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("				   AND B1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("               ) B, MAS_STND_GEN_EXPN A" ).append("\n"); 
		query.append("         WHERE B.COST_YRMON = A.COST_YRMON(+)" ).append("\n"); 
		query.append("           AND B.TRD_CD     = A.TRD_CD(+)" ).append("\n"); 
		query.append("           AND B.RLANE_CD   = A.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND B.DIR_CD     = A.DIR_CD(+)" ).append("\n"); 
		query.append("           AND B.SUB_TRD_CD = A.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("         GROUP BY B.RLANE_CD||B.DIR_CD" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT A.RLANE_CD||A.DIR_CD AS RLANE_CD," ).append("\n"); 
		query.append("               NVL(SUM(A.GEN_EXPN_AMT),0) + NVL(SUM(A.ADD_EXPN_AMT),0) AS ORG_GEN_EXPN," ).append("\n"); 
		query.append("               0 AS TGT_GEN_EXPN" ).append("\n"); 
		query.append("          FROM MAS_STND_GEN_EXPN A                " ).append("\n"); 
		query.append("         WHERE A.COST_YRMON = @[f_yearweek]" ).append("\n"); 
		query.append("         GROUP BY A.RLANE_CD||A.DIR_CD         " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY RLANE_CD" ).append("\n"); 

	}
}