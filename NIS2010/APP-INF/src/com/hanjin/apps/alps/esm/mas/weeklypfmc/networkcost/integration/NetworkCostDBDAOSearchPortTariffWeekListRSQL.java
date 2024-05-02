/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchPortTariffWeekListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
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

public class NetworkCostDBDAOSearchPortTariffWeekListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주차, VVD별 항비 조회
	  * </pre>
	  */
	public NetworkCostDBDAOSearchPortTariffWeekListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchPortTariffWeekListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(A.COST_YRMON, 1, 4)||A.COST_WK COST_WK," ).append("\n"); 
		query.append("       C.SLAN_CD," ).append("\n"); 
		query.append("       C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       C.VSL_CD," ).append("\n"); 
		query.append("       C.SKD_VOY_NO," ).append("\n"); 
		query.append("       C.SKD_DIR_CD," ).append("\n"); 
		query.append("       D.CNT_CD," ).append("\n"); 
		query.append("       SUM(C.PORT_ORG_AMT) PORT_ORG_AMT," ).append("\n"); 
		query.append("       D.WK_VSL_RT," ).append("\n"); 
		query.append("       D.WK_VSL_DTRB_AMT," ).append("\n"); 
		query.append("       MAX(D.WK_TTL_AMT) WK_TTL_AMT" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD A," ).append("\n"); 
		query.append("       MAS_VSL_RGST B," ).append("\n"); 
		query.append("       MAS_PORT_TRF C," ).append("\n"); 
		query.append("       MAS_PORT_ADD_TRF D" ).append("\n"); 
		query.append(" WHERE A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.N1ST_LODG_PORT_ETD_DT BETWEEN B.VSL_APLY_FM_DT AND B.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("   AND B.VOP_CD     = 'SML'" ).append("\n"); 
		query.append("   AND A.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("   AND A.DELT_FLG   <> 'Y'" ).append("\n"); 
		query.append("   AND A.SLAN_CD    = C.SLAN_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD     = C.SKD_DIR_CD                       " ).append("\n"); 
		query.append("   AND A.SLAN_CD    = D.SLAN_CD" ).append("\n"); 
		query.append("   AND A.VSL_CD     = D.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.DIR_CD     = D.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SUBSTR(A.COST_YRMON, 1, 4)||A.COST_WK = REPLACE(@[f_yearweek], '-', '')" ).append("\n"); 
		query.append("   AND D.CNT_CD     = @[f_cust_cnt_cd]" ).append("\n"); 
		query.append("  GROUP BY A.COST_YRMON," ).append("\n"); 
		query.append("       A.COST_WK," ).append("\n"); 
		query.append("       C.SLAN_CD," ).append("\n"); 
		query.append("       C.VSL_CD," ).append("\n"); 
		query.append("       C.SKD_VOY_NO," ).append("\n"); 
		query.append("       C.SKD_DIR_CD," ).append("\n"); 
		query.append("       D.CNT_CD," ).append("\n"); 
		query.append("       D.WK_VSL_RT," ).append("\n"); 
		query.append("       D.WK_VSL_DTRB_AMT" ).append("\n"); 

	}
}