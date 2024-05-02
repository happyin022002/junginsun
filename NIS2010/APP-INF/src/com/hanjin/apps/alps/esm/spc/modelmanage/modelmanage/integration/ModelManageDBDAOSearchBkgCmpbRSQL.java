/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOSearchBkgCmpbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchBkgCmpbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선택된 Customer, SC 에 대한 Sub Trade별, 노선별 BKG pol,pod CMPB를 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청 - SPC_GET_SMP_AMEND_FNC 적용
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOSearchBkgCmpbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchBkgCmpbRSQL").append("\n"); 
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
		query.append("SELECT SUB_TRD_CD," ).append("\n"); 
		query.append("       SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("       USA_BKG_MOD_CD," ).append("\n"); 
		query.append("       BKG_POL_CD," ).append("\n"); 
		query.append("       BKG_POD_CD," ).append("\n"); 
		query.append("       BKG_DEL_CD," ).append("\n"); 
		query.append("#if (${rlane_cd} == '')" ).append("\n"); 
		query.append("       STRD_CMPB / DECODE(@[unit], 'T', 1, 2) AS STRD_CMPB," ).append("\n"); 
		query.append("       STRD_GREV / DECODE(@[unit], 'T', 1, 2) AS STRD_GREV," ).append("\n"); 
		query.append("       SUB_TRD_QTY_SUM / DECODE(@[unit], 'T', 1, 2) AS STRD_AVG_QTY" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       LANE_CMPB / DECODE(@[unit], 'T', 1, 2) AS LANE_CMPB," ).append("\n"); 
		query.append("       LANE_GREV / DECODE(@[unit], 'T', 1, 2) AS LANE_GREV," ).append("\n"); 
		query.append("       LANE_QTY_SUM / DECODE(@[unit], 'T', 1, 2) AS LANE_AVG_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SUB_TRD_CD," ).append("\n"); 
		query.append("               SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("               USA_BKG_MOD_CD," ).append("\n"); 
		query.append("               BKG_POL_CD," ).append("\n"); 
		query.append("               BKG_POD_CD," ).append("\n"); 
		query.append("               BKG_DEL_CD," ).append("\n"); 
		query.append("#if (${rlane_cd} == '')" ).append("\n"); 
		query.append("               ROUND(SUB_TRD_CM_SUM  / SUB_TRD_QTY_SUM,2)  AS STRD_CMPB," ).append("\n"); 
		query.append("               ROUND(SUB_TRD_REV_SUM / SUB_TRD_QTY_SUM,2)  AS STRD_GREV," ).append("\n"); 
		query.append("               ROUND(SUB_TRD_QTY_SUM,2) AS SUB_TRD_QTY_SUM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               ROUND(LANE_CM_SUM     / LANE_QTY_SUM,2)     AS LANE_CMPB," ).append("\n"); 
		query.append("               ROUND(LANE_REV_SUM    / LANE_QTY_SUM,2)     AS LANE_GREV," ).append("\n"); 
		query.append("               ROUND(LANE_QTY_SUM,2) AS LANE_QTY_SUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                       SUB_TRD_CD," ).append("\n"); 
		query.append("                       SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                       USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                       BKG_POL_CD," ).append("\n"); 
		query.append("                       BKG_POD_CD," ).append("\n"); 
		query.append("                       BKG_DEL_CD," ).append("\n"); 
		query.append("#if (${rlane_cd} == '')" ).append("\n"); 
		query.append("                       SUM(RLANE_CMPB_AMT) OVER(PARTITION BY SUB_TRD_CD,SLS_RGN_OFC_CD,USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD)               AS SUB_TRD_CM_SUM," ).append("\n"); 
		query.append("                       SUM(GRS_TTL_REV) OVER(PARTITION BY SUB_TRD_CD,SLS_RGN_OFC_CD,USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD)                  AS SUB_TRD_REV_SUM," ).append("\n"); 
		query.append("                       SUM(RLANE_BKG_QTY)  OVER(PARTITION BY SUB_TRD_CD,SLS_RGN_OFC_CD,USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD)               AS SUB_TRD_QTY_SUM" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                       SUM(RLANE_CMPB_AMT) OVER(PARTITION BY SUB_TRD_CD, RLANE_CD, SLS_RGN_OFC_CD, USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD)   AS LANE_CM_SUM," ).append("\n"); 
		query.append("                       SUM(GRS_TTL_REV) OVER(PARTITION BY SUB_TRD_CD, RLANE_CD, SLS_RGN_OFC_CD, USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD)      AS LANE_REV_SUM," ).append("\n"); 
		query.append("                       SUM(RLANE_BKG_QTY)  OVER(PARTITION BY SUB_TRD_CD, RLANE_CD, SLS_RGN_OFC_CD, USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD)   AS LANE_QTY_SUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--                       ROUND((SUM(RLANE_BKG_QTY)  OVER(PARTITION BY SUB_TRD_CD, RLANE_CD, SLS_RGN_OFC_CD, USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD))/" ).append("\n"); 
		query.append("--                             (MAX(NUM) OVER(PARTITION BY SUB_TRD_CD, RLANE_CD, SLS_RGN_OFC_CD, USA_BKG_MOD_CD, BKG_POL_CD, BKG_POD_CD, BKG_DEL_CD))" ).append("\n"); 
		query.append("--                            ,2) AS LANE_AVG_QTY" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT MCP.COST_YRWK," ).append("\n"); 
		query.append("                               MCP.SUB_TRD_CD," ).append("\n"); 
		query.append("                               MCP.RLANE_CD," ).append("\n"); 
		query.append("                               MCP.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                               MCP.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                               MCP.BKG_POL_CD," ).append("\n"); 
		query.append("                               MCP.BKG_POD_CD," ).append("\n"); 
		query.append("                               MCP.BKG_DEL_CD," ).append("\n"); 
		query.append("                               SUM(MCP.RLANE_CMPB_AMT) AS RLANE_CMPB_AMT," ).append("\n"); 
		query.append("                               SUM(MCP.RLANE_BKG_QTY)  AS RLANE_BKG_QTY," ).append("\n"); 
		query.append("                               SUM(MCP.GRS_TTL_REV)    AS GRS_TTL_REV," ).append("\n"); 
		query.append("                               MAX((SELECT COUNT(1)" ).append("\n"); 
		query.append("                                      FROM MAS_WK_PRD CWP" ).append("\n"); 
		query.append("                                     WHERE CWP.COST_YR||CWP.COST_WK BETWEEN V.PERF_ST_YRWK AND V.PERF_END_YRWK)) NUM" ).append("\n"); 
		query.append("                          FROM SPC_MDL_CUST_PERF   MCP," ).append("\n"); 
		query.append("                               SPC_MDL_VER_MST     V" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND V.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("                           AND V.COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                           AND V.VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("                           AND MCP.COST_YRWK BETWEEN V.PERF_ST_YRWK AND V.PERF_END_YRWK" ).append("\n"); 
		query.append("                           AND MCP.CUST_CNT_CD    = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                           AND MCP.CUST_SEQ       = @[cust_seq]" ).append("\n"); 
		query.append("                           AND NVL(SPC_GET_SMP_AMEND_FNC(V.TRD_CD, V.COST_YRWK, V.VER_SEQ, MCP.SC_NO ), 'X') = NVL(@[sc_no] , 'X')" ).append("\n"); 
		query.append("                           AND NVL(SPC_GET_SMP_AMEND_FNC(V.TRD_CD, V.COST_YRWK, V.VER_SEQ, MCP.RFA_NO), 'X') = NVL(@[rfa_no], 'X')" ).append("\n"); 
		query.append("                           AND MCP.SLS_RGN_OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("                           AND MCP.TRD_CD         = @[trd_cd]" ).append("\n"); 
		query.append("                           AND MCP.SUB_TRD_CD     = @[sub_trd_cd]" ).append("\n"); 
		query.append("                           AND MCP.SLS_RHQ_CD     = @[sls_rhq_cd]" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                           AND MCP.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY MCP.COST_YRWK," ).append("\n"); 
		query.append("                               MCP.SUB_TRD_CD," ).append("\n"); 
		query.append("                               MCP.RLANE_CD," ).append("\n"); 
		query.append("                               MCP.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                               MCP.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                               MCP.BKG_POL_CD," ).append("\n"); 
		query.append("                               MCP.BKG_POD_CD," ).append("\n"); 
		query.append("                               MCP.BKG_DEL_CD" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD," ).append("\n"); 
		query.append("      SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("      USA_BKG_MOD_CD," ).append("\n"); 
		query.append("      BKG_POL_CD," ).append("\n"); 
		query.append("      BKG_POD_CD," ).append("\n"); 
		query.append("      BKG_DEL_CD" ).append("\n"); 

	}
}
