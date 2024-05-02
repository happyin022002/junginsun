/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOSearchSmpRptByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2015.12.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchSmpRptByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건에 맞는 SMP Loading 정보를 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.06.25 진마리아 [선처리] CRM Customer Flag 정보 개편에 따른 작업
	  * 2013.12.05 김시몬 [CHM-201326854] SAQ project로 인한 SPC 변경건_테이블 변경
	  * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가 
	  * 2015.06.19 Arie Im 쿼리튜닝, MAS_MON_VVD, QTA, Grouping Set
	  * </pre>
	  */
	public ModelManageDBDAOSearchSmpRptByLaneRSQL(){
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
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("season",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchSmpRptByLaneRSQL").append("\n"); 
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
		query.append("WITH MAS_MON_VVD_LV AS(" ).append("\n"); 
		query.append("              SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("                     M.SUB_TRD_CD," ).append("\n"); 
		query.append("                     M.RLANE_CD  ," ).append("\n"); 
		query.append("                     M.DIR_CD    ," ).append("\n"); 
		query.append("                     SUBSTR(M.SLS_YRMON, 1, 4) AS COST_YR," ).append("\n"); 
		query.append("                     M.COST_WK   ," ).append("\n"); 
		query.append("                     SUBSTR(M.SLS_YRMON, 1, 4) || M.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                     TO_CHAR(M.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') AS N1ST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                     M.VSL_CD    ," ).append("\n"); 
		query.append("                     M.SKD_VOY_NO," ).append("\n"); 
		query.append("                     H.DIR_CD        AS SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     , SUBSTR(M.COST_YRMON, 1, 4) AS BSE_YR" ).append("\n"); 
		query.append("                     , CASE WHEN M.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                            THEN CEIL(TO_NUMBER(SUBSTR(M.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                            ELSE CEIL(TO_NUMBER(DECODE(M.COST_WK, '00', '01', '53', '52', M.COST_WK))/13)||'Q' " ).append("\n"); 
		query.append("                             END BSE_QTR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                FROM MAS_MON_VVD     M," ).append("\n"); 
		query.append("                     SPC_HD_HUL_MST H" ).append("\n"); 
		query.append("               WHERE --SUBSTR(M.SLS_YRMON, 1, 4) = TO_CHAR(SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("                     SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK LIKE TO_CHAR(SYSDATE, 'YYYY')||'%'" ).append("\n"); 
		query.append("                 AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("                 AND M.TRD_CD = @[trade]" ).append("\n"); 
		query.append("#if (${subtrade} != '') " ).append("\n"); 
		query.append("                 AND M.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("                 AND M.RLANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 AND M.TRD_CD = H.TRD_CD" ).append("\n"); 
		query.append("                 AND M.RLANE_CD = H.RLANE_CD" ).append("\n"); 
		query.append("                 AND M.SUB_TRD_CD = H.SUB_TRD_CD" ).append("\n"); 
		query.append("                 AND M.DIR_CD     = H.DIR_CD --2013.03.13 추가" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", RHQ AS ( -- RHQ를 화면에서 받는다 MULTI" ).append("\n"); 
		query.append("          SELECT DISTINCT" ).append("\n"); 
		query.append("		  	     SUBSTR(AA," ).append("\n"); 
		query.append(" 			  	     INSTR(AA,',',1,LEVEL)+1," ).append("\n"); 
		query.append("   				     INSTR(AA,',',1,LEVEL+1) - INSTR(AA,',',1,LEVEL)" ).append("\n"); 
		query.append("  				     -1" ).append("\n"); 
		query.append("  				    ) AS RHQ_CD" ).append("\n"); 
		query.append("		    FROM (SELECT ','||@[rhq]||',' AA FROM DUAL)" ).append("\n"); 
		query.append("			  	  CONNECT BY LEVEL <= LENGTH(AA) - LENGTH(REPLACE(AA,','))-1  " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(", QTA AS (     " ).append("\n"); 
		query.append("    SELECT OFC_CD," ).append("\n"); 
		query.append("           TRD_CD," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD," ).append("\n"); 
		query.append("           ROUND(SUM(LOAD)) AS LOAD_QTA" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("           SELECT " ).append("\n"); 
		query.append("                  OFC_CD," ).append("\n"); 
		query.append("                  TRD_CD," ).append("\n"); 
		query.append("                  SUB_TRD_CD," ).append("\n"); 
		query.append("                  RLANE_CD," ).append("\n"); 
		query.append("                  COST_YRWK," ).append("\n"); 
		query.append("                  VSL_CD," ).append("\n"); 
		query.append("                  SKD_VOY_NO," ).append("\n"); 
		query.append("                  SKD_DIR_CD," ).append("\n"); 
		query.append("                  MAX_CNT," ).append("\n"); 
		query.append("                  SUM(LOD_QTY) OVER(PARTITION BY OFC_CD, TRD_CD, SUB_TRD_CD,RLANE_CD,COST_YRWK, VSL_CD,SKD_VOY_NO, SKD_DIR_CD)    AS LOAD," ).append("\n"); 
		query.append("                  RANK() OVER(PARTITION BY OFC_CD, TRD_CD, SUB_TRD_CD, RLANE_CD ORDER BY OFC_CD, TRD_CD, SUB_TRD_CD,RLANE_CD,MAX_CNT DESC, COST_YRWK ASC, N1ST_LODG_PORT_ETD_DT ASC) AS CNT" ).append("\n"); 
		query.append("             FROM (     " ).append("\n"); 
		query.append("                   SELECT /*+ LEADING(B T1 C LV) */" ).append("\n"); 
		query.append("                          T2.SAQ_RGN_OFC_CD      AS OFC_CD," ).append("\n"); 
		query.append("                          T1.TRD_CD," ).append("\n"); 
		query.append("                          LV.SUB_TRD_CD," ).append("\n"); 
		query.append("                          T1.RLANE_CD," ).append("\n"); 
		query.append("                          LV.COST_YRWK," ).append("\n"); 
		query.append("                          LV.N1ST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                          T1.VSL_CD," ).append("\n"); 
		query.append("                          T1.SKD_VOY_NO," ).append("\n"); 
		query.append("                          T1.SKD_DIR_CD," ).append("\n"); 
		query.append("                          T1.LOD_QTY," ).append("\n"); 
		query.append("                          COUNT(1) OVER(PARTITION BY C.FNL_BSA_CAPA,C.DIR_CD) AS MAX_CNT  -- 동일 BSA가 가장 많은것 선택" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                     FROM SQM_CFM_QTA      T1 ," ).append("\n"); 
		query.append("                          SQM_QTA_RLSE_VER MQR," ).append("\n"); 
		query.append("                          MAS_MON_VVD_LV   LV," ).append("\n"); 
		query.append("                          SQM_CFM_TGT_VVD  C," ).append("\n"); 
		query.append("                          SPC_OFC_LVL      T2" ).append("\n"); 
		query.append("                    WHERE 1 = 1" ).append("\n"); 
		query.append("                      AND MQR.BSE_YR           = LV.BSE_YR" ).append("\n"); 
		query.append("                      AND MQR.BSE_QTR_CD       = LV.BSE_QTR_CD" ).append("\n"); 
		query.append("                      AND MQR.SQM_VER_STS_CD   = 'R' " ).append("\n"); 
		query.append("                      AND MQR.BSE_TP_CD        = 'Q'" ).append("\n"); 
		query.append("                      AND T1.QTA_RLSE_VER_NO   = MQR.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                      AND T1.BSE_TP_CD         = MQR.BSE_TP_CD" ).append("\n"); 
		query.append("                      AND T1.BSE_YR            = MQR.BSE_YR" ).append("\n"); 
		query.append("                      AND T1.BSE_QTR_CD        = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("                      AND T1.QTA_TGT_CD        = 'D'" ).append("\n"); 
		query.append("                      AND T1.OFC_VW_CD         = 'L' " ).append("\n"); 
		query.append("                      AND SPC_SCR_OFC_CONV_FNC(T1.RGN_OFC_CD,'') = T2.OFC_CD" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("                      AND T1.TRD_CD           = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      AND LV.COST_YRWK BETWEEN T2.OFC_APLY_FM_YRWK AND T2.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                      AND T2.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("                      AND T1.TRD_CD           = LV.TRD_CD" ).append("\n"); 
		query.append("                      AND T1.RLANE_CD         = LV.RLANE_CD" ).append("\n"); 
		query.append("                      AND T1.DIR_CD           = LV.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND T1.VSL_CD           = LV.VSL_CD" ).append("\n"); 
		query.append("                      AND T1.SKD_VOY_NO       = LV.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND T1.SKD_DIR_CD       = LV.SKD_DIR_CD                               " ).append("\n"); 
		query.append("                      AND T1.QTA_RLSE_VER_NO  = C.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                      AND T1.BSE_TP_CD        = C.BSE_TP_CD -- 분기 20131205추가" ).append("\n"); 
		query.append("                      AND T1.BSE_YR           = C.BSE_YR" ).append("\n"); 
		query.append("                      AND T1.BSE_QTR_CD       = C.BSE_QTR_CD" ).append("\n"); 
		query.append("                      AND T1.QTA_TGT_CD       = C.QTA_TGT_CD" ).append("\n"); 
		query.append("                      AND T1.TRD_CD           = C.TRD_CD" ).append("\n"); 
		query.append("                      AND T1.RLANE_CD         = C.RLANE_CD" ).append("\n"); 
		query.append("                      AND T1.DIR_CD           = C.DIR_CD" ).append("\n"); 
		query.append("                      AND T1.VSL_CD           = C.VSL_CD" ).append("\n"); 
		query.append("                      AND T1.SKD_VOY_NO       = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND T1.SKD_DIR_CD       = C.SKD_DIR_CD " ).append("\n"); 
		query.append("                      AND EXISTS (" ).append("\n"); 
		query.append("                                  SELECT 1                                    " ).append("\n"); 
		query.append("                                    FROM SPC_MDL_CUST_REV_LANE   MCP" ).append("\n"); 
		query.append("                                   WHERE MCP.COST_YRWK      = @[season]" ).append("\n"); 
		query.append("                                     AND MCP.VER_SEQ        = @[version]" ).append("\n"); 
		query.append("                                     AND MCP.TRD_CD         = LV.TRD_CD" ).append("\n"); 
		query.append("                                     AND MCP.SUB_TRD_CD     = LV.SUB_TRD_CD" ).append("\n"); 
		query.append("                                     AND MCP.RLANE_CD       = LV.RLANE_CD" ).append("\n"); 
		query.append("                                     AND MCP.SLS_RGN_OFC_CD = T2.SAQ_RGN_OFC_CD               " ).append("\n"); 
		query.append("                                 )    " ).append("\n"); 
		query.append("                      AND T1.LOD_QTY > 0" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     WHERE CNT = 1" ).append("\n"); 
		query.append("     GROUP BY OFC_CD," ).append("\n"); 
		query.append("           TRD_CD," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD" ).append("\n"); 
		query.append("     HAVING ROUND(SUM(LOAD)) <> 0   " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", MODEL_STRD AS ( -- 조회 버전 이전에만 존재하는 ACCT/SC/CUST_CTRL 비교하여 DELETE된건 까지 조회(N = 정상, D = DELETE)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT DTL.TRD_CD," ).append("\n"); 
		query.append("                       DTL.SUB_TRD_CD," ).append("\n"); 
		query.append("                       DTL.RLANE_CD," ).append("\n"); 
		query.append("                       DTL.SLS_RGN_OFC_CD,  " ).append("\n"); 
		query.append("                       CASE WHEN NVL(MC.NEW_KEY_ACCT_FLG,'N') = 'Y' THEN 'CC'" ).append("\n"); 
		query.append("                            WHEN NVL(MC.GLO_ACCT_FLG,'N')     = 'Y' THEN 'CC'" ).append("\n"); 
		query.append("                            WHEN NVL(MC.RGN_ACCT_FLG,'N')     = 'Y' THEN 'RC'" ).append("\n"); 
		query.append("                       ELSE " ).append("\n"); 
		query.append("                            'LC'" ).append("\n"); 
		query.append("                       END ACCT_CLSS,                                            " ).append("\n"); 
		query.append("--                       DTL.CUST_CNT_CD," ).append("\n"); 
		query.append("--                       DTL.CUST_SEQ," ).append("\n"); 
		query.append("                       MC.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                       DTL.CUST_CTRL_CD," ).append("\n"); 
		query.append("                       DTL.CTRT_OFC_CD," ).append("\n"); 
		query.append("                       DTL.SC_NO," ).append("\n"); 
		query.append("                       DTL.RFA_NO," ).append("\n"); 
		query.append("                       DTL.WK_MQC_QTY," ).append("\n"); 
		query.append("                       DTL.RLANE_ADJ_QTY               " ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT MCP.TRD_CD," ).append("\n"); 
		query.append("                               MCP.SUB_TRD_CD," ).append("\n"); 
		query.append("                               MCP.RLANE_CD," ).append("\n"); 
		query.append("                               MCP.SLS_RGN_OFC_CD,                       " ).append("\n"); 
		query.append("                               MCP.CUST_CNT_CD," ).append("\n"); 
		query.append("                               MCP.CUST_SEQ," ).append("\n"); 
		query.append("                               MCP.CUST_CTRL_CD," ).append("\n"); 
		query.append("                               MCP.CTRT_OFC_CD," ).append("\n"); 
		query.append("                               MCP.SC_NO," ).append("\n"); 
		query.append("                               MCP.RFA_NO," ).append("\n"); 
		query.append("                               MCC.WK_MQC_QTY AS WK_MQC_QTY," ).append("\n"); 
		query.append("                               MCP.RLANE_ADJ_QTY                                      " ).append("\n"); 
		query.append("                          FROM SPC_MDL_CUST_REV_LANE MCP," ).append("\n"); 
		query.append("                               SPC_MDL_CUST_CTRL     MCC," ).append("\n"); 
		query.append("                               RHQ                   RHQ_V" ).append("\n"); 
		query.append("                         WHERE MCP.TRD_CD      = @[trade]" ).append("\n"); 
		query.append("                           AND MCP.COST_YRWK   = @[season]" ).append("\n"); 
		query.append("                           AND MCP.VER_SEQ     = @[version]" ).append("\n"); 
		query.append("#if (${subtrade} != '') " ).append("\n"); 
		query.append("                           AND MCP.SUB_TRD_CD  = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lane} != '') " ).append("\n"); 
		query.append("                           AND MCP.RLANE_CD    = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           AND MCP.TRD_CD      = MCC.TRD_CD" ).append("\n"); 
		query.append("                           AND MCP.COST_YRWK   = MCC.COST_YRWK" ).append("\n"); 
		query.append("                           AND MCP.VER_SEQ     = MCC.VER_SEQ" ).append("\n"); 
		query.append("                           AND MCP.CUST_CNT_CD = MCC.CUST_CNT_CD" ).append("\n"); 
		query.append("                           AND MCP.CUST_SEQ    = MCC.CUST_SEQ" ).append("\n"); 
		query.append("                           AND NVL(MCP.SC_NO , ' ') = NVL(MCC.SC_NO , NVL(MCP.SC_NO, ' '))" ).append("\n"); 
		query.append("                           AND NVL(MCP.RFA_NO, ' ') = NVL(MCC.RFA_NO, ' ')" ).append("\n"); 
		query.append("                           AND MCP.SLS_RHQ_CD  = NVL(RHQ_V.RHQ_CD,MCP.SLS_RHQ_CD)" ).append("\n"); 
		query.append("                           AND MCP.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                       ) DTL," ).append("\n"); 
		query.append("                       MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                 WHERE DTL.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND DTL.CUST_SEQ    = MC.CUST_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", MODEL_STRD_C AS (" ).append("\n"); 
		query.append("	SELECT DISTINCT " ).append("\n"); 
		query.append("    	C.TRD_CD," ).append("\n"); 
		query.append("		C.SUB_TRD_CD," ).append("\n"); 
		query.append("		C.RLANE_CD," ).append("\n"); 
		query.append("		C.SLS_RGN_OFC_CD,                       " ).append("\n"); 
		query.append("		'' AS ACCT_CLSS, " ).append("\n"); 
		query.append("		'' AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("		'C' AS CUST_CTRL_CD," ).append("\n"); 
		query.append("		'' AS CTRT_OFC_CD," ).append("\n"); 
		query.append("		'' AS SC_NO," ).append("\n"); 
		query.append("		'' AS RFA_NO," ).append("\n"); 
		query.append("		NULL AS WK_MQC_QTY," ).append("\n"); 
		query.append("		0 AS RLANE_ADJ_QTY " ).append("\n"); 
		query.append("  FROM MODEL_STRD C    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append(",BASE_DATA AS (" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("SELECT TRD_CD         ," ).append("\n"); 
		query.append("       SUB_TRD_CD     ," ).append("\n"); 
		query.append("       RLANE_CD       ," ).append("\n"); 
		query.append("       OFC_CD         ," ).append("\n"); 
		query.append("       CUST_CTRL_CD   ," ).append("\n"); 
		query.append("       ACCT_CLSS,    " ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       SC_NO          ," ).append("\n"); 
		query.append("       RFA_NO          ," ).append("\n"); 
		query.append("       WK_MQC_QTY     ," ).append("\n"); 
		query.append("       RLANE_ADJ_QTY  ," ).append("\n"); 
		query.append("       C_LOAD_QTA     ," ).append("\n"); 
		query.append("       LOAD_QTA       " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT TRD_CD," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("               ACCT_CLSS," ).append("\n"); 
		query.append("               CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               CUST_CTRL_CD," ).append("\n"); 
		query.append("               CTRT_OFC_CD," ).append("\n"); 
		query.append("               SC_NO," ).append("\n"); 
		query.append("               RFA_NO," ).append("\n"); 
		query.append("               WK_MQC_QTY," ).append("\n"); 
		query.append("               RLANE_ADJ_QTY," ).append("\n"); 
		query.append("               CASE WHEN CUST_CTRL_CD <> 'C'" ).append("\n"); 
		query.append("                    THEN RLANE_ADJ_QTY" ).append("\n"); 
		query.append("                    ELSE (LOAD_QTA - SUM(RLANE_ADJ_QTY) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,OFC_CD))" ).append("\n"); 
		query.append("               END AS C_LOAD_QTA," ).append("\n"); 
		query.append("               --DECODE(CUST_CTRL_CD,'A',RLANE_ADJ_QTY,'B',RLANE_ADJ_QTY,'C',(LOAD_QTA - SUM(RLANE_ADJ_QTY) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,OFC_CD)))   AS C_LOAD_QTA," ).append("\n"); 
		query.append("               LOAD_QTA," ).append("\n"); 
		query.append("               RANK() OVER(PARTITION BY TRD_CD,SUB_TRD_CD,OFC_CD,RLANE_CD,CUST_CTRL_CD ORDER BY TRD_CD,SUB_TRD_CD,RLANE_CD,OFC_CD,CUST_LGL_ENG_NM,CUST_CTRL_CD ) AS CNT" ).append("\n"); 
		query.append("          FROM (  " ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("                SELECT B.TRD_CD," ).append("\n"); 
		query.append("                       B.SUB_TRD_CD," ).append("\n"); 
		query.append("                       B.RLANE_CD," ).append("\n"); 
		query.append("                       B.OFC_CD," ).append("\n"); 
		query.append("                       B.ACCT_CLSS," ).append("\n"); 
		query.append("                       B.CUST_LGL_ENG_NM AS CUST_LGL_ENG_NM,                               " ).append("\n"); 
		query.append("                       B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                       B.SC_NO," ).append("\n"); 
		query.append("                       B.RFA_NO," ).append("\n"); 
		query.append("                       B.CUST_CTRL_CD," ).append("\n"); 
		query.append("                       B.WK_MQC_QTY,                               " ).append("\n"); 
		query.append("                       NVL(B.RLANE_ADJ_QTY,0) AS RLANE_ADJ_QTY," ).append("\n"); 
		query.append("                       NVL(A.LOAD_QTA,0)      AS LOAD_QTA" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT TRD_CD," ).append("\n"); 
		query.append("                               SUB_TRD_CD," ).append("\n"); 
		query.append("                               RLANE_CD," ).append("\n"); 
		query.append("                               SLS_RGN_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                               ACCT_CLSS," ).append("\n"); 
		query.append("                               CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                               CUST_CTRL_CD," ).append("\n"); 
		query.append("                               CTRT_OFC_CD," ).append("\n"); 
		query.append("                               SC_NO," ).append("\n"); 
		query.append("                               RFA_NO," ).append("\n"); 
		query.append("                               WK_MQC_QTY,                                       " ).append("\n"); 
		query.append("                               RLANE_ADJ_QTY" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT B.TRD_CD," ).append("\n"); 
		query.append("                                       B.SUB_TRD_CD," ).append("\n"); 
		query.append("                                       B.RLANE_CD," ).append("\n"); 
		query.append("                                       B.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                                       B.ACCT_CLSS,                                         " ).append("\n"); 
		query.append("                                       B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                                       B.CUST_CTRL_CD," ).append("\n"); 
		query.append("                                       B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                       B.SC_NO," ).append("\n"); 
		query.append("                                       B.RFA_NO," ).append("\n"); 
		query.append("                                       B.WK_MQC_QTY," ).append("\n"); 
		query.append("                                       NVL(B.RLANE_ADJ_QTY,0) AS RLANE_ADJ_QTY" ).append("\n"); 
		query.append("                                  FROM MODEL_STRD B" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                                SELECT DISTINCT " ).append("\n"); 
		query.append("                                       C.TRD_CD," ).append("\n"); 
		query.append("                                       C.SUB_TRD_CD," ).append("\n"); 
		query.append("                                       C.RLANE_CD," ).append("\n"); 
		query.append("                                       C.SLS_RGN_OFC_CD,                       " ).append("\n"); 
		query.append("                                       ACCT_CLSS, " ).append("\n"); 
		query.append("                                       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                                       CUST_CTRL_CD," ).append("\n"); 
		query.append("                                       CTRT_OFC_CD," ).append("\n"); 
		query.append("                                       SC_NO," ).append("\n"); 
		query.append("                                       RFA_NO," ).append("\n"); 
		query.append("                                       WK_MQC_QTY," ).append("\n"); 
		query.append("                                       RLANE_ADJ_QTY " ).append("\n"); 
		query.append("                                  FROM MODEL_STRD_C C " ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("                       )    B, " ).append("\n"); 
		query.append("                       QTA  A" ).append("\n"); 
		query.append("                 WHERE B.TRD_CD         = A.TRD_CD(+)" ).append("\n"); 
		query.append("                   AND B.SUB_TRD_CD     = A.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                   AND B.RLANE_CD       = A.RLANE_CD(+)" ).append("\n"); 
		query.append("                   AND B.OFC_CD         = A.OFC_CD(+)" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("              ) A" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE NOT (CNT > 1 AND CUST_LGL_ENG_NM IS NULL)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       SLS_RHQ_CD," ).append("\n"); 
		query.append("       OFC_CD," ).append("\n"); 
		query.append("       CUST_CTRL_CD," ).append("\n"); 
		query.append("       ACCT_CLSS," ).append("\n"); 
		query.append("       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       NVL(RFA_NO, SC_NO) AS RFA_NO," ).append("\n"); 
		query.append("       WK_MQC_QTY," ).append("\n"); 
		query.append("       LVL," ).append("\n"); 
		query.append("       RLANE_ADJ_QTY," ).append("\n"); 
		query.append("       DECODE(RLANE_ADJ_RATIO,0,RLANE_ADJ_RATIO,DECODE(SUM_RLANE_ADJ_RATIO,100,RLANE_ADJ_RATIO,DECODE(RLANE_ADJ_RATIO_NUM,1,RLANE_ADJ_RATIO + (100 - SUM_RLANE_ADJ_RATIO),RLANE_ADJ_RATIO))) AS RLANE_ADJ_RATIO," ).append("\n"); 
		query.append("--       RLANE_ADJ_RATIO," ).append("\n"); 
		query.append("       C_LOAD_QTA," ).append("\n"); 
		query.append("       DECODE(C_LOAD_QTA_RATIO,0,C_LOAD_QTA_RATIO,DECODE(SUM_C_LOAD_QTA_RATIO,100,C_LOAD_QTA_RATIO,DECODE(C_LOAD_QTA_RATIO_NUM,1,C_LOAD_QTA_RATIO + (100 - SUM_C_LOAD_QTA_RATIO),C_LOAD_QTA_RATIO))) AS C_LOAD_QTA_RATIO" ).append("\n"); 
		query.append("--       C_LOAD_QTA_RATIO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("        SELECT TRD_CD," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD," ).append("\n"); 
		query.append("               SLS_RHQ_CD," ).append("\n"); 
		query.append("               OFC_CD ," ).append("\n"); 
		query.append("               CUST_CTRL_CD," ).append("\n"); 
		query.append("               ACCT_CLSS," ).append("\n"); 
		query.append("               CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               CTRT_OFC_CD," ).append("\n"); 
		query.append("               SC_NO," ).append("\n"); 
		query.append("               RFA_NO," ).append("\n"); 
		query.append("               WK_MQC_QTY," ).append("\n"); 
		query.append("               LVL," ).append("\n"); 
		query.append("               RLANE_ADJ_QTY," ).append("\n"); 
		query.append("               RLANE_ADJ_RATIO," ).append("\n"); 
		query.append("               C_LOAD_QTA," ).append("\n"); 
		query.append("               C_LOAD_QTA_RATIO," ).append("\n"); 
		query.append("               SUM(RLANE_ADJ_RATIO) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL) AS SUM_RLANE_ADJ_RATIO," ).append("\n"); 
		query.append("               SUM(C_LOAD_QTA_RATIO) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL)  AS SUM_C_LOAD_QTA_RATIO," ).append("\n"); 
		query.append("               ROW_NUMBER() OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL ORDER BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL,RLANE_ADJ_RATIO DESC) AS RLANE_ADJ_RATIO_NUM, " ).append("\n"); 
		query.append("               ROW_NUMBER() OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL ORDER BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL,C_LOAD_QTA_RATIO DESC)  AS C_LOAD_QTA_RATIO_NUM" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("--                        " ).append("\n"); 
		query.append("                SELECT TRD_CD," ).append("\n"); 
		query.append("                       SUB_TRD_CD," ).append("\n"); 
		query.append("                       RLANE_CD," ).append("\n"); 
		query.append("                       SLS_RHQ_CD," ).append("\n"); 
		query.append("                       OFC_CD             AS OFC_CD," ).append("\n"); 
		query.append("                       CUST_CTRL_CD       AS CUST_CTRL_CD," ).append("\n"); 
		query.append("                       ACCT_CLSS," ).append("\n"); 
		query.append("                       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                       CTRT_OFC_CD," ).append("\n"); 
		query.append("                       SC_NO," ).append("\n"); 
		query.append("                       RFA_NO," ).append("\n"); 
		query.append("                       WK_MQC_QTY," ).append("\n"); 
		query.append("                       LVL," ).append("\n"); 
		query.append("                       NVL(MAX(RLANE_ADJ_QTY),0)   AS RLANE_ADJ_QTY," ).append("\n"); 
		query.append("                       NVL(ROUND(SUM(DECODE(LVL,7,0,8,0,9,0,RLANE_ADJ_RATIO))),0) AS RLANE_ADJ_RATIO," ).append("\n"); 
		query.append("                       NVL(MAX(C_LOAD_QTA),0)        AS C_LOAD_QTA," ).append("\n"); 
		query.append("                       NVL(ROUND(SUM(DECODE(LVL,7,0,8,0,9,0,C_LOAD_QTA_RATIO))),0)  AS C_LOAD_QTA_RATIO" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                  FROM (   " ).append("\n"); 
		query.append("                        SELECT TRD_CD," ).append("\n"); 
		query.append("                               SUB_TRD_CD," ).append("\n"); 
		query.append("                               RLANE_CD," ).append("\n"); 
		query.append("                               SLS_RHQ_CD," ).append("\n"); 
		query.append("                               OFC_CD             AS OFC_CD," ).append("\n"); 
		query.append("                               CUST_CTRL_CD       AS CUST_CTRL_CD," ).append("\n"); 
		query.append("                               ACCT_CLSS," ).append("\n"); 
		query.append("                               CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                               CTRT_OFC_CD," ).append("\n"); 
		query.append("                               SC_NO," ).append("\n"); 
		query.append("                               RFA_NO," ).append("\n"); 
		query.append("                               WK_MQC_QTY," ).append("\n"); 
		query.append("                               LVL," ).append("\n"); 
		query.append("                               RLANE_ADJ_QTY," ).append("\n"); 
		query.append("                               RATIO_TO_REPORT(RLANE_ADJ_QTY) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL) * 100  AS RLANE_ADJ_RATIO," ).append("\n"); 
		query.append("                               C_LOAD_QTA," ).append("\n"); 
		query.append("                               RATIO_TO_REPORT(C_LOAD_QTA) OVER(PARTITION BY TRD_CD,SUB_TRD_CD,RLANE_CD,SLS_RHQ_CD,OFC_CD,LVL) * 100 AS C_LOAD_QTA_RATIO" ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                  SELECT Z3.TRD_CD," ).append("\n"); 
		query.append("                                         Z3.SUB_TRD_CD," ).append("\n"); 
		query.append("                                         Z3.RLANE_CD," ).append("\n"); 
		query.append("                                         DECODE(Z3.SLS_RHQ_CD,'',DECODE(Z3.OFC_CD,'',DECODE(Z3.CUST_CTRL_CD,'','00000','00001'),Z3.OFC_CD),Z3.SLS_RHQ_CD) AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                                         DECODE(Z3.OFC_CD,'',DECODE(Z3.CUST_CTRL_CD,'','00000','00001'),Z3.OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("                                         NVL(Z3.CUST_CTRL_CD,'0')  AS CUST_CTRL_CD," ).append("\n"); 
		query.append("                                         Z3.ACCT_CLSS," ).append("\n"); 
		query.append("                                         Z3.CUST_LGL_ENG_NM        AS CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                                         Z3.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                         Z3.SC_NO," ).append("\n"); 
		query.append("                                         Z3.RFA_NO," ).append("\n"); 
		query.append("                                         Z3.WK_MQC_QTY," ).append("\n"); 
		query.append("                                         CASE WHEN Z3.SLS_RHQ_CD IS NULL AND Z3.OFC_CD IS NULL AND Z3.CUST_CTRL_CD IS NULL THEN" ).append("\n"); 
		query.append("                                                     1" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NULL AND Z3.OFC_CD IS NULL AND Z3.CUST_CTRL_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("                                                     2" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NOT NULL AND Z3.OFC_CD IS NULL AND Z3.CUST_CTRL_CD IS NULL THEN" ).append("\n"); 
		query.append("                                                     3" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NOT NULL AND Z3.OFC_CD IS NULL AND Z3.CUST_CTRL_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("                                                     4" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NOT NULL AND Z3.OFC_CD IS NOT NULL AND Z3.CUST_CTRL_CD IS NULL THEN" ).append("\n"); 
		query.append("                                                     5" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NOT NULL AND Z3.OFC_CD IS NOT NULL AND Z3.CUST_CTRL_CD IS NOT NULL AND ACCT_CLSS IS NULL AND CUST_LGL_ENG_NM IS NULL AND DECODE(Z3.TRD_CD, 'AES', NVL(Z3.RFA_NO, SC_NO), 'IAS', NVL(Z3.RFA_NO, SC_NO), Z3.SC_NO) IS NULL THEN" ).append("\n"); 
		query.append("                                                     6" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NOT NULL AND Z3.OFC_CD IS NOT NULL AND Z3.CUST_CTRL_CD IS NOT NULL AND ACCT_CLSS IS NOT NULL AND CUST_LGL_ENG_NM IS NULL AND DECODE(Z3.TRD_CD, 'AES', NVL(Z3.RFA_NO, SC_NO), 'IAS', NVL(Z3.RFA_NO, SC_NO), Z3.SC_NO) IS NULL THEN" ).append("\n"); 
		query.append("                                                     7" ).append("\n"); 
		query.append("                                              WHEN Z3.SLS_RHQ_CD IS NOT NULL AND Z3.OFC_CD IS NOT NULL AND Z3.CUST_CTRL_CD IS NOT NULL AND ACCT_CLSS IS NOT NULL AND CUST_LGL_ENG_NM IS NOT NULL THEN" ).append("\n"); 
		query.append("                                                     8" ).append("\n"); 
		query.append("                                              ELSE" ).append("\n"); 
		query.append("                                                     9" ).append("\n"); 
		query.append("                                         END LVL," ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                                         Z3.RLANE_ADJ_QTY," ).append("\n"); 
		query.append("                                         Z3.C_LOAD_QTA " ).append("\n"); 
		query.append("                                    FROM (" ).append("\n"); 
		query.append("                                            SELECT DISTINCT" ).append("\n"); 
		query.append("                                                   Z2.TRD_CD," ).append("\n"); 
		query.append("                                                   Z2.SUB_TRD_CD, " ).append("\n"); 
		query.append("                                                   Z2.RLANE_CD," ).append("\n"); 
		query.append("                                                   O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                                                   Z2.OFC_CD," ).append("\n"); 
		query.append("                                                   Z2.CUST_CTRL_CD," ).append("\n"); 
		query.append("                                                   Z2.ACCT_CLSS," ).append("\n"); 
		query.append("                                                   Z2.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                                                   Z2.CTRT_OFC_CD," ).append("\n"); 
		query.append("                                                   Z2.SC_NO," ).append("\n"); 
		query.append("                                                   Z2.RFA_NO," ).append("\n"); 
		query.append("                                                   Z2.WK_MQC_QTY,  " ).append("\n"); 
		query.append("                                                   SUM(Z2.RLANE_ADJ_QTY) AS RLANE_ADJ_QTY," ).append("\n"); 
		query.append("                                                   SUM(Z2.C_LOAD_QTA)    AS C_LOAD_QTA" ).append("\n"); 
		query.append("                                              FROM BASE_DATA Z2," ).append("\n"); 
		query.append("                                                   SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                             WHERE O.OFC_CD = NVL(SPC_SCR_OFC_CONV_FNC(Z2.OFC_CD),O.OFC_CD) " ).append("\n"); 
		query.append("                                               AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND (SELECT COST_YR||COST_WK FROM MAS_WK_PRD WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT) BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                             GROUP BY GROUPING SETS(" ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD)," ).append("\n"); 
		query.append("                                                                    --(Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.CUST_CTRL_CD)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD)," ).append("\n"); 
		query.append("                                                                    --(Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD,Z2.CUST_CTRL_CD)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD, Z2.ACCT_CLSS)," ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD, Z2.ACCT_CLSS, Z2.CUST_LGL_ENG_NM)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD, Z2.ACCT_CLSS, Z2.CUST_LGL_ENG_NM, Z2.CTRT_OFC_CD, Z2.SC_NO, Z2.RFA_NO, Z2.WK_MQC_QTY)" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("                                            UNION ALL                       " ).append("\n"); 
		query.append("                                            SELECT DISTINCT" ).append("\n"); 
		query.append("                                                   Z2.TRD_CD," ).append("\n"); 
		query.append("                                                   Z2.SUB_TRD_CD, " ).append("\n"); 
		query.append("                                                   Z2.RLANE_CD," ).append("\n"); 
		query.append("                                                   O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD," ).append("\n"); 
		query.append("                                                   NULL OFC_CD," ).append("\n"); 
		query.append("                                                   Z2.CUST_CTRL_CD," ).append("\n"); 
		query.append("                                                   NULL ACCT_CLSS," ).append("\n"); 
		query.append("                                                   NULL CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                                                   NULL CTRT_OFC_CD," ).append("\n"); 
		query.append("                                                   NULL SC_NO," ).append("\n"); 
		query.append("                                                   NULL RFA_NO," ).append("\n"); 
		query.append("                                                   NULL WK_MQC_QTY,  " ).append("\n"); 
		query.append("                                                   SUM(Z2.RLANE_ADJ_QTY) AS RLANE_ADJ_QTY," ).append("\n"); 
		query.append("                                                   SUM(Z2.C_LOAD_QTA)    AS C_LOAD_QTA" ).append("\n"); 
		query.append("                                              FROM BASE_DATA Z2," ).append("\n"); 
		query.append("                                                   SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                             WHERE O.OFC_CD = NVL(SPC_SCR_OFC_CONV_FNC(Z2.OFC_CD),O.OFC_CD) " ).append("\n"); 
		query.append("                                               AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                               AND (SELECT COST_YR||COST_WK FROM MAS_WK_PRD WHERE TO_CHAR(SYSDATE,'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT) BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                             GROUP BY GROUPING SETS(" ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.CUST_CTRL_CD)," ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD)," ).append("\n"); 
		query.append("                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD,Z2.CUST_CTRL_CD)--," ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD)," ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD)," ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD, Z2.ACCT_CLSS)," ).append("\n"); 
		query.append("----                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD, Z2.ACCT_CLSS, Z2.CUST_LGL_ENG_NM)," ).append("\n"); 
		query.append("--                                                                    (Z2.TRD_CD, Z2.SUB_TRD_CD, Z2.RLANE_CD, O.N2ND_PRNT_OFC_CD, Z2.OFC_CD, Z2.CUST_CTRL_CD, Z2.ACCT_CLSS, Z2.CUST_LGL_ENG_NM, Z2.CTRT_OFC_CD, Z2.SC_NO, Z2.RFA_NO, Z2.WK_MQC_QTY)" ).append("\n"); 
		query.append("                                                                   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                         ) Z3" ).append("\n"); 
		query.append("--                                   WHERE NOT (Z3.WK_MQC_QTY IS NULL AND Z3.C_LOAD_QTA = 0)" ).append("\n"); 
		query.append("                               ) " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                 GROUP BY TRD_CD," ).append("\n"); 
		query.append("                       SUB_TRD_CD," ).append("\n"); 
		query.append("                       RLANE_CD," ).append("\n"); 
		query.append("                       SLS_RHQ_CD," ).append("\n"); 
		query.append("                       OFC_CD ," ).append("\n"); 
		query.append("                       CUST_CTRL_CD," ).append("\n"); 
		query.append("                       ACCT_CLSS," ).append("\n"); 
		query.append("                       CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("                       CTRT_OFC_CD," ).append("\n"); 
		query.append("                       SC_NO," ).append("\n"); 
		query.append("                       RFA_NO," ).append("\n"); 
		query.append("                       WK_MQC_QTY," ).append("\n"); 
		query.append("                       LVL" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       )                " ).append("\n"); 
		query.append(" ORDER BY TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       SLS_RHQ_CD," ).append("\n"); 
		query.append("       OFC_CD," ).append("\n"); 
		query.append("       CUST_CTRL_CD, " ).append("\n"); 
		query.append("       DECODE(ACCT_CLSS, NULL, '0', 'CC', '1', 'RC', '2', '3')," ).append("\n"); 
		query.append("       nvl(CUST_LGL_ENG_NM,0)," ).append("\n"); 
		query.append("       nvl(SC_NO,0)," ).append("\n"); 
		query.append("       nvl(RFA_NO,0)" ).append("\n"); 
		query.append("--       LVL," ).append("\n"); 

	}
}