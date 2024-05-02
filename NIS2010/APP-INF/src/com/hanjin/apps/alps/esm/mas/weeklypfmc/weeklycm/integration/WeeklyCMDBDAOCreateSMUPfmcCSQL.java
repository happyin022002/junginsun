/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WeeklyCMDBDAOCreateSMUPfmcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCreateSMUPfmcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.07.17 이석준 [CHM-201218919-01] SMU Cost (RA) 화면 Create 기능 추가    
	  * </pre>
	  */
	public WeeklyCMDBDAOCreateSMUPfmcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCreateSMUPfmcCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_SLT_MGMT_UT" ).append("\n"); 
		query.append("(COST_YRMON,TRD_CD,RLANE_CD,VSL_SLAN_DIR_CD,COST_LANE_TP_CD,LANE_GRP_CD,BSE_UC_AMT,PLCY_PRC_UT_AMT," ).append("\n"); 
		query.append("CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  B.BSE_YR||mon  AS COST_YRMON" ).append("\n"); 
		query.append(" ,TRD_CD   AS TRD_CD" ).append("\n"); 
		query.append(" ,RLANE_CD  AS RLANE_CD" ).append("\n"); 
		query.append(" ,DIR_CD   AS VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append(" ,COST_LANE_TP_CD AS COST_LANE_TP_CD" ).append("\n"); 
		query.append(" ,SUB_TRD_CD  AS LANE_GRP_CD" ).append("\n"); 
		query.append(" ,ROUND(PLCY_PRC_UT_AMT,5) AS BSE_UC_AMT" ).append("\n"); 
		query.append(" ,PLCY_PRC_UT_AMT AS PLCY_PRC_UT_AMT" ).append("\n"); 
		query.append(" ,@[user_id] AS CRE_USR_ID --parameter" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[user_id] AS CRE_USR_ID --parameter" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append("  FROM  SAQ_SPC_TRNS_PRC A" ).append("\n"); 
		query.append("     , (SELECT BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,APPL_YR||APPL_MON AS APPL_YRMON" ).append("\n"); 
		query.append("    FROM SAQ_COST_APPL_BSE " ).append("\n"); 
		query.append("   WHERE BSE_YR      = SUBSTR(@[f_cost_yrmon],1,4)" ).append("\n"); 
		query.append("     AND COST_DIV_CD = '20' " ).append("\n"); 
		query.append("     ) B" ).append("\n"); 
		query.append("   ,( SELECT QTR_CD" ).append("\n"); 
		query.append("            ,MON " ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("   SELECT '1Q' AS QTR_CD,'01' AS MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '1Q','02' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '1Q','03' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '2Q','04' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '2Q','05' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '2Q','06' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '3Q','07' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '3Q','08' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '3Q','09' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '4Q','10' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '4Q','11' FROM DUAL UNION ALL" ).append("\n"); 
		query.append("   SELECT '4Q','12' FROM DUAL" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("  WHERE MON = SUBSTR(@[f_cost_yrmon],5,2) ) C " ).append("\n"); 
		query.append(" WHERE A.PLN_YRMON   = B.APPL_YRMON" ).append("\n"); 
		query.append("   AND  B.BSE_QTR_CD  = C.QTR_CD" ).append("\n"); 
		query.append(" ORDER BY B.BSE_YR||MON" ).append("\n"); 

	}
}