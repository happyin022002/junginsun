/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOSearchPortTariffDistributeListRSQL.java
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

public class NetworkCostDBDAOSearchPortTariffDistributeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 금액에 따른 배부된 항비 조회
	  * 2015.06.03 김시몬 RATION 구할때 연도 기준 으로 변경(SLS_YRMON 여러개가 한주로 귀속있음)
	  * </pre>
	  */
	public NetworkCostDBDAOSearchPortTariffDistributeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchPortTariffDistributeListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(COST_YRMON, 1, 4)||'-'||COST_WK COST_WK," ).append("\n"); 
		query.append("       SLAN_CD," ).append("\n"); 
		query.append("       VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       @[cnt_cd] CNT_CD," ).append("\n"); 
		query.append("       PORT_ORG_AMT," ).append("\n"); 
		query.append("       --PORT_TTL_AMT," ).append("\n"); 
		query.append("       ROUND(PORT_ORG_AMT / PORT_TTL_AMT, 3) * 100 WK_VSL_RT," ).append("\n"); 
		query.append("       ROUND(@[wk_ttl_amt] * (PORT_ORG_AMT / PORT_TTL_AMT), 2) WK_VSL_DTRB_AMT," ).append("\n"); 
		query.append("       @[wk_ttl_amt] WK_TTL_AMT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.COST_YRMON," ).append("\n"); 
		query.append("               A.COST_WK," ).append("\n"); 
		query.append("               A.SLAN_CD," ).append("\n"); 
		query.append("               A.VSL_CD," ).append("\n"); 
		query.append("               A.SKD_VOY_NO," ).append("\n"); 
		query.append("               A.SKD_DIR_CD," ).append("\n"); 
		query.append("               A.PORT_ORG_AMT," ).append("\n"); 
		query.append("               SUM(A.PORT_ORG_AMT) OVER (PARTITION BY SUBSTR(A.COST_YRMON,1,4), A.COST_WK) PORT_TTL_AMT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                    SELECT A.COST_YRMON," ).append("\n"); 
		query.append("                           A.COST_WK," ).append("\n"); 
		query.append("                           C.SLAN_CD," ).append("\n"); 
		query.append("                           C.VSL_CD," ).append("\n"); 
		query.append("                           C.SKD_VOY_NO," ).append("\n"); 
		query.append("                           C.SKD_DIR_CD," ).append("\n"); 
		query.append("                           SUM(C.PORT_ORG_AMT) PORT_ORG_AMT" ).append("\n"); 
		query.append("                      FROM MAS_MON_VVD A," ).append("\n"); 
		query.append("                           MAS_VSL_RGST B," ).append("\n"); 
		query.append("                           MAS_PORT_TRF C" ).append("\n"); 
		query.append("                     WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                       AND A.N1ST_LODG_PORT_ETD_DT BETWEEN B.VSL_APLY_FM_DT AND B.VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                       AND B.VOP_CD = 'SML'" ).append("\n"); 
		query.append("                       AND A.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("                       AND A.DELT_FLG   <> 'Y'" ).append("\n"); 
		query.append("                       AND A.SLAN_CD    = C.SLAN_CD" ).append("\n"); 
		query.append("                       AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                       AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND A.DIR_CD     = C.SKD_DIR_CD " ).append("\n"); 
		query.append("                       AND SUBSTR(A.COST_YRMON, 1, 4)||A.COST_WK = REPLACE(@[cost_wk], '-', '')" ).append("\n"); 
		query.append("                       AND EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                                     FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                    WHERE VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("                                      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      AND SKD_DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("                                      AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                      AND VPS_PORT_CD LIKE @[cnt_cd]||'%')" ).append("\n"); 
		query.append("                      GROUP BY A.COST_YRMON," ).append("\n"); 
		query.append("                           A.COST_WK," ).append("\n"); 
		query.append("                           C.SLAN_CD," ).append("\n"); 
		query.append("                           C.VSL_CD," ).append("\n"); 
		query.append("                           C.SKD_VOY_NO," ).append("\n"); 
		query.append("                           C.SKD_DIR_CD" ).append("\n"); 
		query.append("                ) A           " ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}