/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchAccountSrepListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchAccountSrepListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 본사에서 내려준 화주별 S.REP 매핑
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [Trouble Shooting] 성수기시 guide 내려간 화주들만 기본셋팅되도록 변경
	  * [Trouble Shooting] 진마리아 SC Join 오류 수정
	  * [Trouble Shooting] 김시몬 SC Join 오류 수정 관련 distinct  추가
	  * 2013.10.24 [선처리] Account Add/Del 과 Mapping 구분자 생성
	  * 2013.12.02 모델 불일치로 인한 컬럼명 수정. MAPG_FLG -> CUST_MAPG_FLG
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * 2014.05.30 [선반영] SMP만 존재하고 ACCT MAPPING이 안된 ACCT에 대해 SUB TRD
	  * 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청보여지도록 보완
	  * 2015.06.26 [선반영] SPC_ALOC_LANE_CTRL_OPT_DTL 테이블 구조 변경으로 인한 오류 수정, SR 접수중으로 다른 CR에 묶어 반영 함
	  * 2015.12.10 [CHM-201539142] Control Option Registration과 FCST Input 의 Account Mapping상 데이터 오류
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchAccountSrepListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchAccountSrepListRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("         M.CUST_CD             ," ).append("\n"); 
		query.append("         M.CUST_NM             ," ).append("\n"); 
		query.append("         M.CUST_CTRL_CD        ," ).append("\n"); 
		query.append("         M.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("         M.CUST_CNT_CD         ," ).append("\n"); 
		query.append("         M.CUST_SEQ            ," ).append("\n"); 
		query.append("         S.SREP_CD             ," ).append("\n"); 
		query.append("         S.SREP_NM             ," ).append("\n"); 
		query.append("         NVL(C.SUB_TRD_CD, R.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("         C.SREP_CD AS INDIV_CUST" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                   DISTINCT " ).append("\n"); 
		query.append("                   C.CUST_CNT_CD||TO_CHAR(C.CUST_SEQ, 'FM000000') AS CUST_CD," ).append("\n"); 
		query.append("                   C.CUST_CNT_CD," ).append("\n"); 
		query.append("                   C.CUST_SEQ," ).append("\n"); 
		query.append("                   C.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("                   C.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                   MC.CUST_CTRL_CD" ).append("\n"); 
		query.append("              FROM SPC_MDL_CUST_CTRL     MC," ).append("\n"); 
		query.append("                   MDM_CUSTOMER          C" ).append("\n"); 
		query.append("             WHERE MC.TRD_CD = @[trade]" ).append("\n"); 
		query.append("               AND MC.COST_YRWK||'-'||MC.VER_SEQ = NVL((SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                               COST_YRWK||'-'||VER_SEQ" ).append("\n"); 
		query.append("                                                          FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                                         WHERE @[cost_yrwk] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                           AND M.TRD_CD  = MC.TRD_CD" ).append("\n"); 
		query.append("                                                           AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                           AND ROWNUM    = 1), '200001-1')" ).append("\n"); 
		query.append("               AND EXISTS (SELECT 'X' FROM SPC_MDL_CUST_REV_LANE R" ).append("\n"); 
		query.append("                            WHERE R.TRD_CD = MC.TRD_CD" ).append("\n"); 
		query.append("                              AND R.COST_YRWK = MC.COST_YRWK" ).append("\n"); 
		query.append("                              AND R.VER_SEQ = MC.VER_SEQ" ).append("\n"); 
		query.append("                              AND R.CUST_CNT_CD      = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                              AND R.CUST_SEQ         = MC.CUST_SEQ" ).append("\n"); 
		query.append("                              AND R.RLANE_ADJ_QTY > 0" ).append("\n"); 
		query.append("                              AND R.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                              AND R.SLS_RGN_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT 'X' FROM DUAL" ).append("\n"); 
		query.append("                            WHERE MC.COST_YRWK||'-'||MC.VER_SEQ = '200001-1'" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("               AND MC.CUST_CNT_CD     = C.CUST_CNT_CD " ).append("\n"); 
		query.append("               AND MC.CUST_SEQ        = C.CUST_SEQ " ).append("\n"); 
		query.append("         ) M," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT CUST_CNT_CD||TO_CHAR(CUST_SEQ, 'FM000000') AS CUST_CD," ).append("\n"); 
		query.append("                   CUST_NM             ," ).append("\n"); 
		query.append("                   CUST_CTRL_CD        ," ).append("\n"); 
		query.append("                   RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                   CUST_CNT_CD         ," ).append("\n"); 
		query.append("                   CUST_SEQ            ," ).append("\n"); 
		query.append("                   SUBSTR(MAX(SYS_CONNECT_BY_PATH(SREP_CD, '|')), 2) AS SREP_CD," ).append("\n"); 
		query.append("                   SUBSTR(MAX(SYS_CONNECT_BY_PATH(SREP_NM, '|')), 2) AS SREP_NM" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT " ).append("\n"); 
		query.append("                             DISTINCT " ).append("\n"); 
		query.append("                             MC.CUST_CNT_CD," ).append("\n"); 
		query.append("                             MC.CUST_SEQ   ," ).append("\n"); 
		query.append("                             C.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("                             C.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                             MC.CUST_CTRL_CD       ," ).append("\n"); 
		query.append("                             R.SREP_CD             ," ).append("\n"); 
		query.append("                             S.SREP_NM             ," ).append("\n"); 
		query.append("                             DENSE_RANK() OVER (PARTITION BY MC.CUST_CNT_CD, MC.CUST_SEQ ORDER BY S.SREP_NM) AS RNUM" ).append("\n"); 
		query.append("                        FROM SPC_MDL_CUST_CTRL     MC," ).append("\n"); 
		query.append("                             SPC_SLS_REP_CUST      R ," ).append("\n"); 
		query.append("                             MDM_SLS_REP           S ," ).append("\n"); 
		query.append("                             MDM_CUSTOMER          C" ).append("\n"); 
		query.append("                       WHERE MC.TRD_CD = @[trade]" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                         AND MC.COST_YRWK = NVL((SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                         COST_YRWK" ).append("\n"); 
		query.append("                                                                    FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                                                   WHERE @[cost_yrwk] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                     AND M.TRD_CD  = MC.TRD_CD" ).append("\n"); 
		query.append("                                                                     AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                                     AND ROWNUM    = 1), '200001') " ).append("\n"); 
		query.append("                         AND MC.VER_SEQ = NVL((SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                         VER_SEQ" ).append("\n"); 
		query.append("                                                                    FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                                                   WHERE @[cost_yrwk] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                     AND M.TRD_CD  = MC.TRD_CD" ).append("\n"); 
		query.append("                                                                     AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                                     AND ROWNUM    = 1), '1')  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         AND MC.CUST_CNT_CD     = R.CUST_CNT_CD" ).append("\n"); 
		query.append("                         AND MC.CUST_SEQ        = R.CUST_SEQ" ).append("\n"); 
		query.append("                         AND R.SREP_CD          = S.SREP_CD" ).append("\n"); 
		query.append("                         AND S.SREP_STS_CD      = 'N'" ).append("\n"); 
		query.append("                         AND MC.CUST_CNT_CD     = C.CUST_CNT_CD " ).append("\n"); 
		query.append("                         AND MC.CUST_SEQ        = C.CUST_SEQ " ).append("\n"); 
		query.append("                         AND S.OFC_CD           IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                      FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                                     WHERE @[cost_yrwk] BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                                       AND N4TH_PRNT_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("          GROUP BY CUST_CNT_CD ," ).append("\n"); 
		query.append("                   CUST_SEQ    ," ).append("\n"); 
		query.append("                   CUST_NM     ," ).append("\n"); 
		query.append("                   CUST_CTRL_CD," ).append("\n"); 
		query.append("                   RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("          ORDER BY CUST_CNT_CD," ).append("\n"); 
		query.append("                   CUST_SEQ" ).append("\n"); 
		query.append("         ) S," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT CUST_CNT_CD||TO_CHAR(CUST_SEQ, 'FM000000') AS CUST_CD," ).append("\n"); 
		query.append("                   CUST_NM             ," ).append("\n"); 
		query.append("                   CUST_CTRL_CD        ," ).append("\n"); 
		query.append("                   RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                   CUST_CNT_CD         ," ).append("\n"); 
		query.append("                   CUST_SEQ            ," ).append("\n"); 
		query.append("                   SUBSTR(MAX(SYS_CONNECT_BY_PATH(SUB_TRD_CD, ',')), 2) AS SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT " ).append("\n"); 
		query.append("                             DISTINCT " ).append("\n"); 
		query.append("                             MC.CUST_CNT_CD," ).append("\n"); 
		query.append("                             MC.CUST_SEQ   ," ).append("\n"); 
		query.append("                             C.CUST_LGL_ENG_NM AS CUST_NM," ).append("\n"); 
		query.append("                             C.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                             MC.CUST_CTRL_CD       ," ).append("\n"); 
		query.append("                             DECODE(MC.COST_YRWK, '200001', MC.SUB_TRD_CD, MR.SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("                             DENSE_RANK() OVER (PARTITION BY MC.CUST_CNT_CD, MC.CUST_SEQ ORDER BY DECODE(MC.COST_YRWK, '200001', MC.SUB_TRD_CD, MR.SUB_TRD_CD)) AS RNUM" ).append("\n"); 
		query.append("                        FROM SPC_MDL_CUST_CTRL     MC," ).append("\n"); 
		query.append("                             SPC_MDL_CUST_REV_LANE MR," ).append("\n"); 
		query.append("                             MDM_CUSTOMER          C                              " ).append("\n"); 
		query.append("                       WHERE MC.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("                         AND MC.COST_YRWK||'-'||MC.VER_SEQ = NVL((SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                         COST_YRWK||'-'||VER_SEQ" ).append("\n"); 
		query.append("                                                                    FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                                                   WHERE @[cost_yrwk]  BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                     AND M.TRD_CD  = MC.TRD_CD" ).append("\n"); 
		query.append("                                                                     AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                                     AND ROWNUM    = 1), '200001-1')" ).append("\n"); 
		query.append("                         AND MC.CUST_CNT_CD     = C.CUST_CNT_CD " ).append("\n"); 
		query.append("                         AND MC.CUST_SEQ        = C.CUST_SEQ    " ).append("\n"); 
		query.append("                         AND MC.TRD_CD          = MR.TRD_CD     (+)" ).append("\n"); 
		query.append("                         AND MC.COST_YRWK       = MR.COST_YRWK  (+)" ).append("\n"); 
		query.append("                         AND MC.VER_SEQ         = MR.VER_SEQ    (+)" ).append("\n"); 
		query.append("                         AND MC.CUST_CNT_CD     = MR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                         AND MC.CUST_SEQ        = MR.CUST_SEQ   (+)" ).append("\n"); 
		query.append("                         AND @[ofc_cd]          = MR.SLS_RGN_OFC_CD (+)" ).append("\n"); 
		query.append("                         AND NVL(MC.SC_NO,NVL(MC.RFA_NO, 'X')) = NVL(MR.SC_NO(+),NVL(MR.RFA_NO(+), 'X'))" ).append("\n"); 
		query.append("                         --AND DECODE(MC.TRD_CD, 'AES', NVL(MC.RFA_NO, 'X'), NVL(MC.SC_NO, 'X')) = DECODE(MC.TRD_CD, 'AES', NVL(MR.RFA_NO(+), 'X'), NVL(MR.SC_NO(+), NVL(MC.SC_NO, 'X')))" ).append("\n"); 
		query.append("                         AND MR.RLANE_ADJ_QTY(+)>0" ).append("\n"); 
		query.append("                         AND DECODE(MC.COST_YRWK||'-'||MC.VER_SEQ,'200001-1',MR.TRD_CD,NULL) IS NULL" ).append("\n"); 
		query.append("                         AND DECODE(MC.COST_YRWK||'-'||MC.VER_SEQ,'200001-1','X',MR.TRD_CD) IS NOT NULL" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("          GROUP BY CUST_CNT_CD ," ).append("\n"); 
		query.append("                   CUST_SEQ    ," ).append("\n"); 
		query.append("                   CUST_NM     ," ).append("\n"); 
		query.append("                   CUST_CTRL_CD," ).append("\n"); 
		query.append("                   RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("          ORDER BY CUST_CNT_CD," ).append("\n"); 
		query.append("                   CUST_SEQ" ).append("\n"); 
		query.append("         ) R," ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("            SELECT DISTINCT" ).append("\n"); 
		query.append("                   CUST_CNT_CD," ).append("\n"); 
		query.append("                   CUST_SEQ   ," ).append("\n"); 
		query.append("                   SREP_CD    ," ).append("\n"); 
		query.append("                   SUBSTR(MAX(SYS_CONNECT_BY_PATH(SUB_TRD_CD, ',')), 2) AS SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT DISTINCT " ).append("\n"); 
		query.append("                             CUST_CNT_CD," ).append("\n"); 
		query.append("                             CUST_SEQ   ," ).append("\n"); 
		query.append("                             SREP_CD    ," ).append("\n"); 
		query.append("                             DECODE(SUB_TRD_CD, '*', '', SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("                             DENSE_RANK() OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY DECODE(SUB_TRD_CD, '*', '', SUB_TRD_CD)) AS RNUM" ).append("\n"); 
		query.append("                        FROM SPC_SLS_REP_CUST MC" ).append("\n"); 
		query.append("                       WHERE 1=1 " ).append("\n"); 
		query.append("                         AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                         AND NVL(INDIV_CUST_USE_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                         AND TRD_CD      = @[trade]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         AND SLS_OFC_CD  IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                               FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                              WHERE @[cost_yrwk]  BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                                AND N4TH_PRNT_OFC_CD =  @[ofc_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                         AND CUST_MAPG_FLG = 'Y'" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("             WHERE NOT (RNUM > 1 AND SUB_TRD_CD IS NULL)" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("          GROUP BY CUST_CNT_CD ," ).append("\n"); 
		query.append("                   CUST_SEQ    ," ).append("\n"); 
		query.append("                   SREP_CD" ).append("\n"); 
		query.append("          ORDER BY CUST_CNT_CD," ).append("\n"); 
		query.append("                   CUST_SEQ" ).append("\n"); 
		query.append("         ) C" ).append("\n"); 
		query.append("   WHERE M.CUST_CNT_CD  = S.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("     AND M.CUST_SEQ     = S.CUST_SEQ    (+)" ).append("\n"); 
		query.append("     AND M.CUST_CTRL_CD = S.CUST_CTRL_CD(+)" ).append("\n"); 
		query.append("     AND M.CUST_CNT_CD  = C.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("     AND M.CUST_SEQ     = C.CUST_SEQ    (+)" ).append("\n"); 
		query.append("     AND M.CUST_CNT_CD  = R.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("     AND M.CUST_SEQ     = R.CUST_SEQ    (+)" ).append("\n"); 
		query.append("     AND M.CUST_CTRL_CD = R.CUST_CTRL_CD(+)" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT M.CUST_CD" ).append("\n"); 
		query.append("       , M.CUST_NM" ).append("\n"); 
		query.append("       , M.CUST_CTRL_CD" ).append("\n"); 
		query.append("       , M.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("       , M.CUST_CNT_CD" ).append("\n"); 
		query.append("       , M.CUST_SEQ" ).append("\n"); 
		query.append("       , M.SREP_CD" ).append("\n"); 
		query.append("       , M.SREP_NM" ).append("\n"); 
		query.append("       , NVL(C.SUB_TRD_CD, M.SUB_TRD_CD) AS SUB_TRD_CD" ).append("\n"); 
		query.append("       , M.INDIV_CUST" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  CUST_CD" ).append("\n"); 
		query.append("               , CUST_NM" ).append("\n"); 
		query.append("               , CUST_CTRL_CD" ).append("\n"); 
		query.append("               , RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("               , CUST_CNT_CD" ).append("\n"); 
		query.append("               , CUST_SEQ" ).append("\n"); 
		query.append("               , SREP_CD" ).append("\n"); 
		query.append("               , SREP_NM" ).append("\n"); 
		query.append("               , SUB_TRD_CD" ).append("\n"); 
		query.append("               , INDIV_CUST" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT" ).append("\n"); 
		query.append("                       L.CUST_CD," ).append("\n"); 
		query.append("                       L.CUST_NM," ).append("\n"); 
		query.append("                       L.RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                       L.CUST_CNT_CD," ).append("\n"); 
		query.append("                       L.CUST_SEQ," ).append("\n"); 
		query.append("                       R.SREP_CD," ).append("\n"); 
		query.append("                       (SELECT SREP_NM FROM MDM_SLS_REP S WHERE S.SREP_CD = R.SREP_CD) SREP_NM," ).append("\n"); 
		query.append("                       L.SUB_TRD_CD," ).append("\n"); 
		query.append("                       DECODE(NVL(R.INDIV_CUST_USE_FLG, 'N'), 'Y', R.SREP_CD, '')  INDIV_CUST," ).append("\n"); 
		query.append("                       R.SLS_OFC_CD," ).append("\n"); 
		query.append("                       NVL((SELECT MAX(MC.CUST_CTRL_CD) CUST_CTRL_CD" ).append("\n"); 
		query.append("                              FROM SPC_MDL_CUST_CTRL MC" ).append("\n"); 
		query.append("                             WHERE MC.TRD_CD = @[trade]" ).append("\n"); 
		query.append("                               AND MC.COST_YRWK||'-'||MC.VER_SEQ = NVL((SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                              COST_YRWK||'-'||VER_SEQ" ).append("\n"); 
		query.append("                                              FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                             WHERE @[cost_yrwk]  BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                               AND M.TRD_CD = MC.TRD_CD" ).append("\n"); 
		query.append("                                               AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1), '200001-1')" ).append("\n"); 
		query.append("                               AND MC.CUST_CNT_CD = L.CUST_CNT_CD" ).append("\n"); 
		query.append("                               AND MC.CUST_SEQ = L.CUST_SEQ )" ).append("\n"); 
		query.append("                         ,'C') CUST_CTRL_CD" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                         SELECT CUST_CNT_CD||TO_CHAR(CUST_SEQ, 'FM000000') AS CUST_CD," ).append("\n"); 
		query.append("                                CUST_CNT_CD," ).append("\n"); 
		query.append("                                CUST_SEQ," ).append("\n"); 
		query.append("                                CUST_NM," ).append("\n"); 
		query.append("                                RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                                SUB_TRD_CD," ).append("\n"); 
		query.append("                                SLS_OFC_CD" ).append("\n"); 
		query.append("                           FROM (" ).append("\n"); 
		query.append("                                   SELECT " ).append("\n"); 
		query.append("                                           CUST_CNT_CD," ).append("\n"); 
		query.append("                                           CUST_SEQ," ).append("\n"); 
		query.append("                                           CUST_NM," ).append("\n"); 
		query.append("                                           RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                                           SUB_TRD_CD," ).append("\n"); 
		query.append("                                           SLS_OFC_CD, " ).append("\n"); 
		query.append("                                           DENSE_RANK() OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY DECODE(SUB_TRD_CD, '*', '', SUB_TRD_CD)) AS RNUM" ).append("\n"); 
		query.append("                                      FROM (" ).append("\n"); 
		query.append("                                            SELECT " ).append("\n"); 
		query.append("                                                   DISTINCT " ).append("\n"); 
		query.append("                                                   CUST.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                                                 , SUBSTR(CD.ALOC_CTRL_DTL_CD, 0, 2) CUST_CNT_CD" ).append("\n"); 
		query.append("--                                                 , TO_NUMBER(SUBSTR(CD.CTRL_LOC_ACCT_CD, -6)) CUST_SEQ" ).append("\n"); 
		query.append("                                                 , TO_NUMBER(SUBSTR(CD.ALOC_CTRL_DTL_CD, -6)) CUST_SEQ" ).append("\n"); 
		query.append("                                                 , CUST.CUST_LGL_ENG_NM AS CUST_NM" ).append("\n"); 
		query.append("                                                 , CD.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                 , SLS_OFC_CD" ).append("\n"); 
		query.append("                                              FROM SPC_ALOC_LANE_CTRL_OPT CO" ).append("\n"); 
		query.append("                                                 , SPC_ALOC_LANE_CTRL_OPT_DTL CD" ).append("\n"); 
		query.append("                                                 , MDM_CUSTOMER CUST  " ).append("\n"); 
		query.append("                                                 , (SELECT DISTINCT REP_TRD_CD" ).append("\n"); 
		query.append("                                                         , REP_SUB_TRD_CD" ).append("\n"); 
		query.append("                                                         , RLANE_CD" ).append("\n"); 
		query.append("                                                         , DIR_CD " ).append("\n"); 
		query.append("                                                         , SLS_OFC_CD " ).append("\n"); 
		query.append("                                                     FROM SPC_FCAST_OFC_POL_MAPG M" ).append("\n"); 
		query.append("                                                     WHERE SLS_OFC_CD  IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                              FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                                             WHERE @[cost_yrwk]  BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                                               AND N4TH_PRNT_OFC_CD = @[ofc_cd]) )OFC                      " ).append("\n"); 
		query.append("                                             WHERE CO.TRD_CD = CD.TRD_CD" ).append("\n"); 
		query.append("                                               AND CO.SUB_TRD_CD = CD.SUB_TRD_CD" ).append("\n"); 
		query.append("                                               AND CO.RLANE_CD = CD.RLANE_CD" ).append("\n"); 
		query.append("                                               AND CO.DIR_CD = CD.DIR_CD" ).append("\n"); 
		query.append("                                               AND CO.CTRL_ACCT_FLG = 'Y'" ).append("\n"); 
		query.append("                                               AND CD.ALOC_CTRL_TP_CD = 'A'" ).append("\n"); 
		query.append("                                               AND CO.TRD_CD = @[trade] " ).append("\n"); 
		query.append("                                               AND CUST.CUST_CNT_CD = SUBSTR(CD.ALOC_CTRL_DTL_CD, 0, 2)" ).append("\n"); 
		query.append("--                                               AND CUST.CUST_SEQ = TO_NUMBER(SUBSTR(CD.CTRL_LOC_ACCT_CD, -6))" ).append("\n"); 
		query.append("                                               AND CUST.CUST_SEQ = TO_NUMBER(SUBSTR(CD.ALOC_CTRL_DTL_CD, -6))" ).append("\n"); 
		query.append("                                               AND OFC.REP_TRD_CD = CD.TRD_CD" ).append("\n"); 
		query.append("                                               AND OFC.REP_SUB_TRD_CD = CD.SUB_TRD_CD" ).append("\n"); 
		query.append("                                               AND OFC.RLANE_CD = CD.RLANE_CD" ).append("\n"); 
		query.append("                                               AND OFC.DIR_CD = CD.DIR_CD" ).append("\n"); 
		query.append("                                               AND NOT EXISTS (SELECT 1" ).append("\n"); 
		query.append("                                                                  FROM SPC_MDL_CUST_CTRL     MC," ).append("\n"); 
		query.append("                                                                       MDM_CUSTOMER          C" ).append("\n"); 
		query.append("                                                                 WHERE MC.TRD_CD = @[trade]" ).append("\n"); 
		query.append("                                                                   AND MC.COST_YRWK||'-'||MC.VER_SEQ = NVL((SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                                                                                                   COST_YRWK||'-'||VER_SEQ" ).append("\n"); 
		query.append("                                                                                                              FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                                                                                             WHERE @[cost_yrwk] BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK" ).append("\n"); 
		query.append("                                                                                                               AND M.TRD_CD  = MC.TRD_CD" ).append("\n"); 
		query.append("                                                                                                               AND M.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                                                                                               AND ROWNUM    = 1), '200001-1')" ).append("\n"); 
		query.append("                                                                   AND EXISTS (SELECT 'X' FROM SPC_MDL_CUST_REV_LANE R" ).append("\n"); 
		query.append("                                                                                WHERE R.TRD_CD = MC.TRD_CD" ).append("\n"); 
		query.append("                                                                                  AND R.COST_YRWK = MC.COST_YRWK" ).append("\n"); 
		query.append("                                                                                  AND R.VER_SEQ = MC.VER_SEQ" ).append("\n"); 
		query.append("                                                                                  AND R.CUST_CNT_CD      = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                                  AND R.CUST_SEQ         = MC.CUST_SEQ" ).append("\n"); 
		query.append("                                                                                  AND R.RLANE_ADJ_QTY > 0" ).append("\n"); 
		query.append("                                                                                  AND R.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                  AND R.SLS_RGN_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                                                                               UNION ALL" ).append("\n"); 
		query.append("                                                                               SELECT 'X' FROM DUAL" ).append("\n"); 
		query.append("                                                                                WHERE MC.COST_YRWK||'-'||MC.VER_SEQ = '200001-1'" ).append("\n"); 
		query.append("                                                                               )" ).append("\n"); 
		query.append("                                                                   AND C.CUST_CNT_CD      = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                   AND C.CUST_SEQ         = MC.CUST_SEQ                       " ).append("\n"); 
		query.append("                                                                   AND CUST.RVIS_CNTR_CUST_TP_CD = C.RVIS_CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("                                                                   AND CUST.CUST_CNT_CD  = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                   AND CUST.CUST_SEQ   = C.CUST_SEQ" ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("                                ) L" ).append("\n"); 
		query.append("                          WHERE NOT (RNUM > 1 AND SUB_TRD_CD IS NULL)" ).append("\n"); 
		query.append("                          START WITH RNUM = 1" ).append("\n"); 
		query.append("                          CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("                          GROUP BY CUST_CNT_CD," ).append("\n"); 
		query.append("                                CUST_SEQ," ).append("\n"); 
		query.append("                                CUST_NM," ).append("\n"); 
		query.append("                                RVIS_CNTR_CUST_TP_CD," ).append("\n"); 
		query.append("                                SUB_TRD_CD," ).append("\n"); 
		query.append("                                SLS_OFC_CD" ).append("\n"); 
		query.append("                          ORDER BY CUST_CNT_CD," ).append("\n"); 
		query.append("                                CUST_SEQ" ).append("\n"); 
		query.append("                       ) L" ).append("\n"); 
		query.append("                       , SPC_SLS_REP_CUST R" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND R.DELT_FLG(+)      = 'N'" ).append("\n"); 
		query.append("                   AND NVL(R.INDIV_CUST_USE_FLG(+), 'N') = 'Y'" ).append("\n"); 
		query.append("                   AND R.TRD_CD(+)        = @[trade]" ).append("\n"); 
		query.append("                   AND R.CUST_MAPG_FLG(+) = 'Y'" ).append("\n"); 
		query.append("                   AND R.CUST_CNT_CD(+)   = L.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND R.CUST_SEQ(+)      = L.CUST_SEQ" ).append("\n"); 
		query.append("                   AND R.SLS_OFC_CD(+)    = L.SLS_OFC_CD" ).append("\n"); 
		query.append("                 ORDER BY CUST_NM, CUST_CTRL_CD " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE 1=1 " ).append("\n"); 
		query.append("           AND CUST_CTRL_CD = 'C'" ).append("\n"); 
		query.append("        ) M," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT CUST_CNT_CD," ).append("\n"); 
		query.append("               CUST_SEQ   ," ).append("\n"); 
		query.append("               SREP_CD    ," ).append("\n"); 
		query.append("               SUBSTR(MAX(SYS_CONNECT_BY_PATH(SUB_TRD_CD, ',')), 2) AS SUB_TRD_CD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                  SELECT DISTINCT " ).append("\n"); 
		query.append("                         CUST_CNT_CD," ).append("\n"); 
		query.append("                         CUST_SEQ   ," ).append("\n"); 
		query.append("                         SREP_CD    ," ).append("\n"); 
		query.append("                         DECODE(SUB_TRD_CD, '*', '', SUB_TRD_CD) AS SUB_TRD_CD," ).append("\n"); 
		query.append("                         DENSE_RANK() OVER (PARTITION BY CUST_CNT_CD, CUST_SEQ ORDER BY DECODE(SUB_TRD_CD, '*', '', SUB_TRD_CD)) AS RNUM" ).append("\n"); 
		query.append("                    FROM SPC_SLS_REP_CUST MC" ).append("\n"); 
		query.append("                   WHERE 1=1 " ).append("\n"); 
		query.append("                     AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                     AND NVL(INDIV_CUST_USE_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                     AND TRD_CD      = @[trade]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     AND SLS_OFC_CD  IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                           FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                          WHERE @[cost_yrwk]  BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                            AND N4TH_PRNT_OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     AND CUST_MAPG_FLG = 'Y'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE NOT (RNUM > 1 AND SUB_TRD_CD IS NULL)" ).append("\n"); 
		query.append("         START WITH RNUM = 1" ).append("\n"); 
		query.append("         CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CUST_CNT_CD = CUST_CNT_CD AND PRIOR CUST_SEQ = CUST_SEQ" ).append("\n"); 
		query.append("         GROUP BY CUST_CNT_CD ," ).append("\n"); 
		query.append("               CUST_SEQ    ," ).append("\n"); 
		query.append("               SREP_CD" ).append("\n"); 
		query.append("       ) C " ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND M.CUST_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND M.CUST_SEQ    = C.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND M.SREP_CD     = C.SREP_CD(+)" ).append("\n"); 

	}
}