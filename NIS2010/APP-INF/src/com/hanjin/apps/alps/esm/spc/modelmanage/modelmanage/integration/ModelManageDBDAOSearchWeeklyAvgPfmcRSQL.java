/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOSearchWeeklyAvgPfmcRSQL.java
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

public class ModelManageDBDAOSearchWeeklyAvgPfmcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.06.29 김시몬 [CHM-201325016] PFMC AVG 기준 변경 수정
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청 - SPC_GET_SMP_AMEND_FNC 적용
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOSearchWeeklyAvgPfmcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchWeeklyAvgPfmcRSQL").append("\n"); 
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
		query.append("WITH T AS (" ).append("\n"); 
		query.append("    SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("         , CUST_SEQ" ).append("\n"); 
		query.append("         , SC_NO" ).append("\n"); 
		query.append("         , RFA_NO" ).append("\n"); 
		query.append("         , CTRT_OFC_CD" ).append("\n"); 
		query.append("         , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("         , SUB_TRD_CD" ).append("\n"); 
		query.append("         , RLANE_CD" ).append("\n"); 
		query.append("         , COST_YRWK" ).append("\n"); 
		query.append("         , SUM_RLANE_BKG_QTY AS RLANE_BKG_QTY" ).append("\n"); 
		query.append("         , RNUM" ).append("\n"); 
		query.append("         , (SUM(SUM_RLANE_BKG_QTY) OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ, RFA_NO, SC_NO, CTRT_OFC_CD, SLS_RGN_OFC_CD, SUB_TRD_CD, RLANE_CD)) / @[duration] AS SMPL_AVG_PFMC-- 20130629 신혜성차장요청" ).append("\n"); 
		query.append("         , AVG(SUM_RLANE_BKG_QTY)  OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ, RFA_NO, SC_NO, CTRT_OFC_CD, SLS_RGN_OFC_CD, SUB_TRD_CD, RLANE_CD) AS AVG_PFMC" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("                 , CUST_SEQ" ).append("\n"); 
		query.append("                 , SPC_GET_SMP_AMEND_FNC(TRD_CD, NUM.COST_YRWK, NUM.VER_SEQ, SC_NO)  AS SC_NO" ).append("\n"); 
		query.append("                 , SPC_GET_SMP_AMEND_FNC(TRD_CD, NUM.COST_YRWK, NUM.VER_SEQ, RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("                 , CTRT_OFC_CD" ).append("\n"); 
		query.append("                 , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                 , TRD_CD" ).append("\n"); 
		query.append("                 , SUB_TRD_CD" ).append("\n"); 
		query.append("                 , RLANE_CD" ).append("\n"); 
		query.append("                 , P.COST_YRWK" ).append("\n"); 
		query.append("                 , NUM.RNUM" ).append("\n"); 
		query.append("                 , SUM(RLANE_BKG_QTY) AS SUM_RLANE_BKG_QTY" ).append("\n"); 
		query.append("              FROM SPC_MDL_CUST_PERF P" ).append("\n"); 
		query.append("                 , (SELECT ROWNUM RNUM, C.COST_YR, C.COST_WK, M.COST_YRWK, M.VER_SEQ" ).append("\n"); 
		query.append("                      FROM SPC_MDL_VER_MST M, MAS_WK_PRD C" ).append("\n"); 
		query.append("                     WHERE M.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("                       AND M.COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("                       AND M.VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("                       AND C.COST_YR||C.COST_WK BETWEEN M.PERF_ST_YRWK AND M.PERF_END_YRWK" ).append("\n"); 
		query.append("                   ) NUM" ).append("\n"); 
		query.append("             WHERE P.TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("               AND P.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("               AND P.CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("               AND NVL(SPC_GET_SMP_AMEND_FNC(TRD_CD, NUM.COST_YRWK, NUM.VER_SEQ, P.SC_NO) , 'X') = NVL(@[sc_no] , 'X')" ).append("\n"); 
		query.append("               AND NVL(SPC_GET_SMP_AMEND_FNC(TRD_CD, NUM.COST_YRWK, NUM.VER_SEQ, P.RFA_NO), 'X') = NVL(@[rfa_no], 'X')" ).append("\n"); 
		query.append("#if (${sls_rhq_cd} != '') " ).append("\n"); 
		query.append("               AND P.SLS_RHQ_CD     = @[sls_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("               AND P.SUB_TRD_CD     = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sls_rgn_ofc_cd} != '') " ).append("\n"); 
		query.append("               AND P.SLS_RGN_OFC_CD = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("               AND P.RLANE_CD       = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND P.COST_YRWK      = NUM.COST_YR||NUM.COST_WK" ).append("\n"); 
		query.append("          GROUP BY CUST_CNT_CD" ).append("\n"); 
		query.append("                 , CUST_SEQ" ).append("\n"); 
		query.append("                 , SPC_GET_SMP_AMEND_FNC(TRD_CD, NUM.COST_YRWK, NUM.VER_SEQ, SC_NO)" ).append("\n"); 
		query.append("                 , SPC_GET_SMP_AMEND_FNC(TRD_CD, NUM.COST_YRWK, NUM.VER_SEQ, RFA_NO)" ).append("\n"); 
		query.append("                 , CTRT_OFC_CD" ).append("\n"); 
		query.append("                 , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                 , TRD_CD" ).append("\n"); 
		query.append("                 , SUB_TRD_CD" ).append("\n"); 
		query.append("                 , RLANE_CD" ).append("\n"); 
		query.append("                 , P.COST_YRWK" ).append("\n"); 
		query.append("                 , NUM.RNUM" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT T1.CUST_CNT_CD" ).append("\n"); 
		query.append("     , T1.CUST_SEQ" ).append("\n"); 
		query.append("     , T1.CUST_CNT_CD||TO_CHAR(T1.CUST_SEQ, 'FM000000') CUST_CD" ).append("\n"); 
		query.append("     , T2.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , T2.CUST_GRP_ID" ).append("\n"); 
		query.append("     , NVL((SELECT CUST_GRP_NM FROM MDM_CUST_PERF_GRP WHERE T2.CUST_GRP_ID=CUST_GRP_ID), T2.CUST_LGL_ENG_NM) AS CUST_GRP_NM" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , NVL(RFA_NO, SC_NO) AS RFA_NO" ).append("\n"); 
		query.append("     , CTRT_OFC_CD" ).append("\n"); 
		query.append("     , SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("     , SUB_TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , ROUND(SMPL_AVG_PFMC / DECODE(@[unit], 'T', 1, 2),2) SMPL_AVG_PFMC" ).append("\n"); 
		query.append("     , ROUND(AVG_PFMC / DECODE(@[unit], 'T', 1, 2),2) AVG_PFMC" ).append("\n"); 
		query.append("#foreach( $key in ${dur} )" ).append("\n"); 
		query.append("     , SUM(AVG_PFMC_${key}) / DECODE(@[unit], 'T', 1, 2) AS AVG_PFMC_${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT T.CUST_CNT_CD" ).append("\n"); 
		query.append("         , T.CUST_SEQ" ).append("\n"); 
		query.append("         , T.SC_NO" ).append("\n"); 
		query.append("         , T.RFA_NO" ).append("\n"); 
		query.append("         , T.CTRT_OFC_CD" ).append("\n"); 
		query.append("         , T.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("         , T.SUB_TRD_CD" ).append("\n"); 
		query.append("         , T.RLANE_CD" ).append("\n"); 
		query.append("         , T.SMPL_AVG_PFMC" ).append("\n"); 
		query.append("         , T.AVG_PFMC" ).append("\n"); 
		query.append("         , C1.CPY_NO" ).append("\n"); 
		query.append("#foreach( $key in ${dur} )" ).append("\n"); 
		query.append("         , DECODE(C1.CPY_NO, ${key} , DECODE(RNUM , C1.CPY_NO, RLANE_BKG_QTY, 0), 0) AS AVG_PFMC_${key} " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    FROM T, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT CPY_NO" ).append("\n"); 
		query.append("        FROM COM_CPY_NO" ).append("\n"); 
		query.append("        WHERE CPY_NO<=@[duration]" ).append("\n"); 
		query.append("        ) C1" ).append("\n"); 
		query.append("    ) T1, MDM_CUSTOMER T2" ).append("\n"); 
		query.append("WHERE T1.CUST_CNT_CD = T2.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND T1.CUST_SEQ    = T2.CUST_SEQ" ).append("\n"); 
		query.append("GROUP BY T1.CUST_CNT_CD" ).append("\n"); 
		query.append("       , T1.CUST_SEQ" ).append("\n"); 
		query.append("       , T2.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       , T2.CUST_GRP_ID" ).append("\n"); 
		query.append("       , T1.SC_NO" ).append("\n"); 
		query.append("       , NVL(T1.RFA_NO, T1.SC_NO)" ).append("\n"); 
		query.append("       , T1.CTRT_OFC_CD" ).append("\n"); 
		query.append("       , T1.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("       , T1.SUB_TRD_CD" ).append("\n"); 
		query.append("       , T1.RLANE_CD" ).append("\n"); 
		query.append("       , T1.SMPL_AVG_PFMC" ).append("\n"); 
		query.append("       , T1.AVG_PFMC" ).append("\n"); 
		query.append("ORDER BY SLS_RGN_OFC_CD, SUB_TRD_CD, RLANE_CD" ).append("\n"); 

	}
}
