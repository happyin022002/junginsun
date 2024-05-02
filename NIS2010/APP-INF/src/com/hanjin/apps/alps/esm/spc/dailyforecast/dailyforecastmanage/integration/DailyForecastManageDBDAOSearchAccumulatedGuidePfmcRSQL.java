/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastManageDBDAOSearchAccumulatedGuidePfmcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2014.05.22 김시몬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author simonkim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastManageDBDAOSearchAccumulatedGuidePfmcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
	  * [Trouble Shooting] 진마리아 SC Join 오류 수정
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.03.13 김시몬 [선처리] BKG RFA NULL 관련 보완
	  * 2014.03.17 [CHM-20142960] SMP/Allocation control보완 요청 - SPC_GET_SMP_AMEND_FNC 적용
	  * 2014.05.22 [선반영] AES-SC관련 로직 추가
	  * </pre>
	  */
	public DailyForecastManageDBDAOSearchAccumulatedGuidePfmcRSQL(){
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
		params.put("week1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.integration").append("\n"); 
		query.append("FileName : DailyForecastManageDBDAOSearchAccumulatedGuidePfmcRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT @[year1]||@[week1] AS FM_YRWK," ).append("\n"); 
		query.append("           @[year2]||@[week2] AS TO_YRWK        ," ).append("\n"); 
		query.append("           @[trade]         AS TRD_CD         ," ).append("\n"); 
		query.append("           @[rhq]           AS SLS_RHQ_CD     ," ).append("\n"); 
		query.append("           @[ofc_cd]        AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VVDS AS (" ).append("\n"); 
		query.append("    SELECT P.FM_YRWK       ," ).append("\n"); 
		query.append("           P.TO_YRWK       ," ).append("\n"); 
		query.append("           MV.TRD_CD       ," ).append("\n"); 
		query.append("           MV.SUB_TRD_CD   ," ).append("\n"); 
		query.append("           MV.RLANE_CD     ," ).append("\n"); 
		query.append("           SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK AS COST_WK," ).append("\n"); 
		query.append("           MV.VSL_CD       ," ).append("\n"); 
		query.append("           MV.SKD_VOY_NO   ," ).append("\n"); 
		query.append("           MV.DIR_CD       ," ).append("\n"); 
		query.append("           P.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("           P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           (SELECT /*+ INDEX_DESC ( V XPKSPC_MDL_VER_MST ) */" ).append("\n"); 
		query.append("                   DECODE(Q.DIR_CD, NULL, '200001-1', COST_YRWK||'-'||VER_SEQ)" ).append("\n"); 
		query.append("              FROM SPC_MDL_VER_MST V " ).append("\n"); 
		query.append("             WHERE SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK BETWEEN VER_ST_YRWK AND VER_END_YRWK" ).append("\n"); 
		query.append("               AND TRD_CD    = P.TRD_CD" ).append("\n"); 
		query.append("               AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("               AND ROWNUM  = 1) AS SEASON" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD       MV," ).append("\n"); 
		query.append("           PARAM             P ," ).append("\n"); 
		query.append("           SPC_HD_HUL_MST    Q" ).append("\n"); 
		query.append("     WHERE SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK BETWEEN P.FM_YRWK AND P.TO_YRWK" ).append("\n"); 
		query.append("       AND MV.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("       AND MV.TRD_CD       = P.TRD_CD" ).append("\n"); 
		query.append("       AND Q.TRD_CD        = MV.TRD_CD" ).append("\n"); 
		query.append("       AND Q.RLANE_CD      = MV.RLANE_CD" ).append("\n"); 
		query.append("       AND Q.DIR_CD        = MV.DIR_CD" ).append("\n"); 
		query.append(")       " ).append("\n"); 
		query.append(", MODEL_DATA AS (" ).append("\n"); 
		query.append("    SELECT R.COST_YRWK     ," ).append("\n"); 
		query.append("           R.VER_SEQ       ," ).append("\n"); 
		query.append("           P.FM_YRWK       ," ).append("\n"); 
		query.append("           P.TO_YRWK       ," ).append("\n"); 
		query.append("           R.TRD_CD        ," ).append("\n"); 
		query.append("           R.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           P.RLANE_CD      ," ).append("\n"); 
		query.append("           P.COST_WK       ," ).append("\n"); 
		query.append("           P.VSL_CD        ," ).append("\n"); 
		query.append("           P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           P.DIR_CD        ," ).append("\n"); 
		query.append("           R.CUST_CNT_CD   ," ).append("\n"); 
		query.append("           R.CUST_SEQ      ," ).append("\n"); 
		query.append("           R.CUST_CTRL_CD  ," ).append("\n"); 
		query.append("           R.SC_NO         ," ).append("\n"); 
		query.append("           R.RFA_NO        ," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           SUM(R.RLANE_ADJ_QTY) AS GUIDE" ).append("\n"); 
		query.append("      FROM SPC_MDL_CUST_REV_LANE R," ).append("\n"); 
		query.append("           SPC_MDL_CUST_CTRL     C," ).append("\n"); 
		query.append("           VVDS                  P" ).append("\n"); 
		query.append("     WHERE R.COST_YRWK      = SUBSTR(P.SEASON, 1, 6)" ).append("\n"); 
		query.append("       AND R.VER_SEQ        = SUBSTR(P.SEASON, 8)" ).append("\n"); 
		query.append("       AND R.TRD_CD         = P.TRD_CD" ).append("\n"); 
		query.append("       AND R.SUB_TRD_CD     = P.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND R.RLANE_CD       = P.RLANE_CD" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("       AND R.SLS_RGN_OFC_CD = P.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${rhq} != '')" ).append("\n"); 
		query.append("       AND R.SLS_RHQ_CD     = P.SLS_RHQ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND R.SLS_RHQ_CD     IN ('SHARC', 'SINRS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND R.TRD_CD         = C.TRD_CD" ).append("\n"); 
		query.append("       AND R.COST_YRWK      = C.COST_YRWK" ).append("\n"); 
		query.append("       AND R.VER_SEQ        = C.VER_SEQ" ).append("\n"); 
		query.append("       AND R.CUST_CNT_CD    = C.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND R.CUST_SEQ       = C.CUST_SEQ" ).append("\n"); 
		query.append("       AND NVL(R.SC_NO,NVL(R.RFA_NO, 'X')) = NVL(C.SC_NO,NVL(C.RFA_NO, 'X'))" ).append("\n"); 
		query.append("       --AND DECODE(R.TRD_CD, 'AES', NVL(R.RFA_NO, 'X'), NVL(R.SC_NO, 'X')) = DECODE(R.TRD_CD, 'AES', NVL(C.RFA_NO, 'X'), NVL(C.SC_NO, NVL(R.SC_NO, 'X')))" ).append("\n"); 
		query.append("       AND R.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("       AND R.RLANE_ADJ_QTY  > 0" ).append("\n"); 
		query.append("       AND SUBSTR(P.SEASON, 1, 6) <> '200001'" ).append("\n"); 
		query.append("  GROUP BY R.COST_YRWK     ," ).append("\n"); 
		query.append("           R.VER_SEQ       ," ).append("\n"); 
		query.append("           P.FM_YRWK       ," ).append("\n"); 
		query.append("           P.TO_YRWK       ," ).append("\n"); 
		query.append("           R.TRD_CD        ," ).append("\n"); 
		query.append("           R.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           P.RLANE_CD      ," ).append("\n"); 
		query.append("           P.COST_WK       ," ).append("\n"); 
		query.append("           P.VSL_CD        ," ).append("\n"); 
		query.append("           P.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           P.DIR_CD        ," ).append("\n"); 
		query.append("           R.CUST_CNT_CD   ," ).append("\n"); 
		query.append("           R.CUST_SEQ      ," ).append("\n"); 
		query.append("           R.CUST_CTRL_CD  ," ).append("\n"); 
		query.append("           R.SC_NO         ," ).append("\n"); 
		query.append("           R.RFA_NO        ," ).append("\n"); 
		query.append("           R.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("    SELECT C.COST_YRWK     ," ).append("\n"); 
		query.append("           C.VER_SEQ       ," ).append("\n"); 
		query.append("           P.FM_YRWK       ," ).append("\n"); 
		query.append("           P.TO_YRWK       ," ).append("\n"); 
		query.append("           P.TRD_CD        ," ).append("\n"); 
		query.append("           P.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           P.RLANE_CD      ," ).append("\n"); 
		query.append("           P.COST_WK       ," ).append("\n"); 
		query.append("           V.VSL_CD        ," ).append("\n"); 
		query.append("           V.SKD_VOY_NO    ," ).append("\n"); 
		query.append("           V.SKD_DIR_CD    ," ).append("\n"); 
		query.append("           C.CUST_CNT_CD   ," ).append("\n"); 
		query.append("           C.CUST_SEQ      ," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           CASE WHEN P.TRD_CD = 'AES' AND DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO) IS NULL AND BC.CUST_CNT_CD = 'CN' AND B.SC_NO IS NULL THEN" ).append("\n"); 
		query.append("                     SPC_GET_SMP_RFA_FNC('C',P.SEASON,  BC.CUST_CNT_CD||LPAD(BC.CUST_SEQ,6,'0'), B.POL_CD,B.POD_CD)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("           ELSE   " ).append("\n"); 
		query.append("                      C.CUST_CTRL_CD" ).append("\n"); 
		query.append("           END AS CUST_CTRL_CD," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, B.SC_NO) AS SC_NO," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           CASE WHEN P.TRD_CD = 'AES' AND DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO) IS NULL AND BC.CUST_CNT_CD = 'CN' AND B.SC_NO IS NULL THEN" ).append("\n"); 
		query.append("                     SPC_GET_SMP_RFA_FNC('R',P.SEASON,  BC.CUST_CNT_CD||LPAD(BC.CUST_SEQ,6,'0'), B.POL_CD,B.POD_CD)" ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("           ELSE   " ).append("\n"); 
		query.append("                     SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO))" ).append("\n"); 
		query.append("           END AS RFA_NO," ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           P.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("              SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY)" ).append("\n"); 
		query.append("                FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("               WHERE B.BKG_NO      = Q.BKG_NO" ).append("\n"); 
		query.append("                 AND Q.OP_CNTR_QTY > 0" ).append("\n"); 
		query.append("           ) AS BKG_QTY" ).append("\n"); 
		query.append("      FROM BKG_BOOKING       B," ).append("\n"); 
		query.append("           BKG_VVD           V," ).append("\n"); 
		query.append("           VVDS              P," ).append("\n"); 
		query.append("           SPC_MDL_CUST_CTRL C," ).append("\n"); 
		query.append("           MDM_DTL_REV_LANE  L," ).append("\n"); 
		query.append("           BKG_CUSTOMER      BC  --20140304 추가" ).append("\n"); 
		query.append("     WHERE B.BKG_NO           = V.BKG_NO" ).append("\n"); 
		query.append("       AND B.BKG_STS_CD      IN ('F', 'W')" ).append("\n"); 
		query.append("       AND B.BKG_CGO_TP_CD   <> 'P'" ).append("\n"); 
		query.append("       AND V.VSL_CD           = P.VSL_CD" ).append("\n"); 
		query.append("       AND V.SKD_VOY_NO       = P.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND V.SKD_DIR_CD       = P.DIR_CD" ).append("\n"); 
		query.append("       AND V.VSL_PRE_PST_CD   = 'T'" ).append("\n"); 
		query.append("       AND L.RLANE_CD         = P.RLANE_CD" ).append("\n"); 
		query.append("       AND L.VSL_SLAN_DIR_CD  = P.DIR_CD" ).append("\n"); 
		query.append("       AND L.FM_CONTI_CD      = (SELECT SPC_CONTI_CONV_FNC(CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("                                   FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                  WHERE LOC_CD = V.POL_CD)" ).append("\n"); 
		query.append("       AND L.TO_CONTI_CD      = (SELECT SPC_CONTI_CONV_FNC(CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("                                   FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                  WHERE LOC_CD = V.POD_CD)" ).append("\n"); 
		query.append("       AND L.TRD_CD           = P.TRD_CD" ).append("\n"); 
		query.append("       AND L.SUB_TRD_CD       = P.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND L.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("       AND C.TRD_CD           = P.TRD_CD" ).append("\n"); 
		query.append("       AND C.COST_YRWK        = SUBSTR(P.SEASON, 1, 6)" ).append("\n"); 
		query.append("       AND C.VER_SEQ          = SUBSTR(P.SEASON, 8)" ).append("\n"); 
		query.append("       AND B.CTRT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("       AND B.CTRT_CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("       AND B.BKG_NO           = BC.BKG_NO  --20140304 추가" ).append("\n"); 
		query.append("       AND BC.BKG_CUST_TP_CD  = 'S'        --20140304 추가" ).append("\n"); 
		query.append("       AND NVL(SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, B.SC_NO),NVL(SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO)), 'X'))" ).append("\n"); 
		query.append("           = NVL(C.SC_NO,NVL(C.RFA_NO, 'X'))" ).append("\n"); 
		query.append("       --AND DECODE(P.TRD_CD, 'AES', NVL(SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, DECODE(SUBSTR(B.RFA_NO, 1, 3), 'DUM', '', B.RFA_NO)), 'X'), NVL(SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, B.SC_NO), 'X')) " ).append("\n"); 
		query.append("       --    = DECODE(P.TRD_CD, 'AES', NVL(C.RFA_NO, 'X'), NVL(C.SC_NO, NVL(SPC_GET_SMP_AMEND_FNC(C.TRD_CD, C.COST_YRWK, C.VER_SEQ, B.SC_NO), 'X')))" ).append("\n"); 
		query.append("       AND SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)   IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                         FROM SPC_OFC_LVL" ).append("\n"); 
		query.append("                                                        WHERE P.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                                          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("                                                          AND N4TH_PRNT_OFC_CD = P.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${rhq} != '')" ).append("\n"); 
		query.append("                                                          AND N2ND_PRNT_OFC_CD = P.SLS_RHQ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                          AND N2ND_PRNT_OFC_CD IN ('SHARC', 'SINRS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("       AND SUBSTR(P.SEASON, 1, 6) <> '200001'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT FM_YRWK     ," ).append("\n"); 
		query.append("         TO_YRWK     ," ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("         SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         'RHQ' AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         CUST_CNT_CD ," ).append("\n"); 
		query.append("         CUST_SEQ    ,         " ).append("\n"); 
		query.append("         NVL(CUST_NM, 'TTL') AS CUST_NM," ).append("\n"); 
		query.append("         NVL(SC_NO, ' ')     AS SC_NO  ," ).append("\n"); 
		query.append("         DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' ')    AS RFA_NO ," ).append("\n"); 
		query.append("         CUST_CTRL_CD," ).append("\n"); 
		query.append("         RLANE_CD    ," ).append("\n"); 
		query.append("         SUB_TRD_CD  ," ).append("\n"); 
		query.append("         SUM(GUIDE)   AS GUIDE  ," ).append("\n"); 
		query.append("         SUM(BKG_QTY) AS BKG_QTY," ).append("\n"); 
		query.append("         ROUND(DECODE(SUM(GUIDE), 0, 0, SUM(BKG_QTY) / SUM(GUIDE)), 2) * 100 ||' %' AS PERF" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT COST_YRWK     ," ).append("\n"); 
		query.append("                   VER_SEQ       ," ).append("\n"); 
		query.append("                   FM_YRWK       ," ).append("\n"); 
		query.append("                   TO_YRWK       ," ).append("\n"); 
		query.append("                   TRD_CD        ," ).append("\n"); 
		query.append("                   SUB_TRD_CD    ," ).append("\n"); 
		query.append("                   RLANE_CD      ," ).append("\n"); 
		query.append("                   COST_WK       ," ).append("\n"); 
		query.append("                   VSL_CD        ," ).append("\n"); 
		query.append("                   SKD_VOY_NO    ," ).append("\n"); 
		query.append("                   DIR_CD        ," ).append("\n"); 
		query.append("                   CUST_CNT_CD   ," ).append("\n"); 
		query.append("                   CUST_SEQ      ," ).append("\n"); 
		query.append("                   CUST_CTRL_CD  ,         " ).append("\n"); 
		query.append("                   (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                     WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND CUST_SEQ    = A.CUST_SEQ) AS CUST_NM," ).append("\n"); 
		query.append("                   SC_NO         ," ).append("\n"); 
		query.append("                   RFA_NO        ," ).append("\n"); 
		query.append("                   SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   GUIDE         ," ).append("\n"); 
		query.append("                   0 AS BKG_QTY" ).append("\n"); 
		query.append("              FROM MODEL_DATA A" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT COST_YRWK     ," ).append("\n"); 
		query.append("                   VER_SEQ       ," ).append("\n"); 
		query.append("                   FM_YRWK       ," ).append("\n"); 
		query.append("                   TO_YRWK       ," ).append("\n"); 
		query.append("                   TRD_CD        ," ).append("\n"); 
		query.append("                   SUB_TRD_CD    ," ).append("\n"); 
		query.append("                   RLANE_CD      ," ).append("\n"); 
		query.append("                   COST_WK       ," ).append("\n"); 
		query.append("                   VSL_CD        ," ).append("\n"); 
		query.append("                   SKD_VOY_NO    ," ).append("\n"); 
		query.append("                   SKD_DIR_CD AS DIR_CD," ).append("\n"); 
		query.append("                   CUST_CNT_CD   ," ).append("\n"); 
		query.append("                   CUST_SEQ      ," ).append("\n"); 
		query.append("                   CUST_CTRL_CD  ,         " ).append("\n"); 
		query.append("                   (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                      FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                     WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                       AND CUST_SEQ    = A.CUST_SEQ) AS CUST_NM," ).append("\n"); 
		query.append("                   SC_NO         ," ).append("\n"); 
		query.append("                   RFA_NO        ," ).append("\n"); 
		query.append("                   SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   0 AS GUIDE    ," ).append("\n"); 
		query.append("                   BKG_QTY" ).append("\n"); 
		query.append("              FROM BKG_DATA A" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, CUST_CNT_CD, CUST_SEQ, CUST_NM, CUST_CTRL_CD, SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '), TRD_CD, SUB_TRD_CD, RLANE_CD,SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, CUST_CNT_CD, CUST_SEQ, CUST_NM, CUST_CTRL_CD, SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '), TRD_CD, SUB_TRD_CD, SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, CUST_CNT_CD, CUST_SEQ, CUST_NM, CUST_CTRL_CD, SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '), SLS_RGN_OFC_CD)," ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, SLS_RGN_OFC_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, CUST_CNT_CD, CUST_SEQ, CUST_NM, CUST_CTRL_CD, SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '), TRD_CD, SUB_TRD_CD, RLANE_CD)," ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, CUST_CNT_CD, CUST_SEQ, CUST_NM, CUST_CTRL_CD, SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '), TRD_CD, SUB_TRD_CD)," ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK, CUST_CNT_CD, CUST_SEQ, CUST_NM, CUST_CTRL_CD, SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '))," ).append("\n"); 
		query.append("                          (FM_YRWK, TO_YRWK)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(CUST_NM, 'TTL', 'ZZZZZ', CUST_NM), SC_NO, DECODE(TRD_CD,'AES',NVL(SC_NO,NVL(RFA_NO, ' ')),' '), SUB_TRD_CD,  RLANE_CD DESC" ).append("\n"); 

	}
}
