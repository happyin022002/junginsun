/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.08.18 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2011.07.04 이석준[CHM-201111880] control by HO 화면 보완 - IPC, TS 관련
	  * 2011.12.28 김종준 [CHM-201115346-01] QTA 데이터가 확정될때까지 2012년 대상항차부터 QTA 정보를 0으로 보여달라는 요청 원복
	  * 2012.12.03 [CHM-201221639] 김시몬 R9와 동일하게 R8이 적용될 수 있도록 쿼리수정
	  * 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.04.02 [CHM-201323913] 진마리아 MDM_DTL_REV_LANE의 DELT 체크 추가
	  * 2013.12.05 김시몬 [CHM-201326854] SAQ project로 인한 SPC 변경건_테이블 변경
	  * 2014.03.25 김시몬 [선처리] SQM 분기구하는 로직 관련 보완
	  * 2014.12.17 Arie Im [SQL튜닝적용] 2014.12.23 Arie Im [SQL튜닝적용] 수정
	  * 2015.03.04 김성욱 [CHM-201534435] SQM QTA주가 변경 관련 적용 요청
	  * 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
	  * 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
	  * 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
	  * 2016.07.05 CHM-201642241 VGM(BKG상 표시되는 또 다른 WGT 정보) 도입 관련 SPC 사항
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0044MasterListVORSQL").append("\n"); 
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
		query.append("    SELECT /*+ inline */DISTINCT" ).append("\n"); 
		query.append("           M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           SUBSTR(M.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(M.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.DIR_CD  AS SKD_DIR_CD," ).append("\n"); 
		query.append("           @[office] AS SLS_OFC_CD," ).append("\n"); 
		query.append("		   M.IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           , SUBSTR(M.COST_YRMON, 1, 4) AS BSE_YR" ).append("\n"); 
		query.append("		   , CASE WHEN M.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("				  THEN CEIL(TO_NUMBER(SUBSTR(M.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("				  ELSE CEIL(TO_NUMBER(DECODE(M.COST_WK,'00','01','53','52',M.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("		   END BSE_QTR_CD -- 2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("     FROM MAS_MON_VVD M" ).append("\n"); 
		query.append("     WHERE (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("#if (${vvd} == '')" ).append("\n"); 
		query.append("       AND (SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK) IN ( SELECT /*+ INDEX(P XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                                                             P.COST_YR||P.COST_WK" ).append("\n"); 
		query.append("                                                        FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                                                        WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                                        	AND ROWNUM <= @[duration])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND M.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("       AND M.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("       AND M.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${trade} != '')" ).append("\n"); 
		query.append("       AND M.TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${subtrade} != '')" ).append("\n"); 
		query.append("       AND M.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${lane} != '')" ).append("\n"); 
		query.append("       AND M.RLANE_CD = @[lane] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} == '' && ${bound} != '')" ).append("\n"); 
		query.append("       AND M.DIR_CD = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    SELECT /*+ inline */TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           SLS_OFC_CD," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           POL_CD    ," ).append("\n"); 
		query.append("           POD_CD    ," ).append("\n"); 
		query.append("           MAX(POL_PAST) AS POL_PAST," ).append("\n"); 
		query.append("           MIN(POL_SEQ) AS POL_SEQ," ).append("\n"); 
		query.append("           MAX(POD_SEQ) AS POD_SEQ,           " ).append("\n"); 
		query.append("           POL_PORT_SEQ," ).append("\n"); 
		query.append("           POL_PORT_MAX_SEQ," ).append("\n"); 
		query.append("           POL_YD_SEQ," ).append("\n"); 
		query.append("           POD_PORT_SEQ," ).append("\n"); 
		query.append("           POD_PORT_MAX_SEQ," ).append("\n"); 
		query.append("           POD_YD_SEQ" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("             SELECT TRD_CD    ," ).append("\n"); 
		query.append("                    SUB_TRD_CD," ).append("\n"); 
		query.append("                    RLANE_CD  ," ).append("\n"); 
		query.append("                    DIR_CD    ," ).append("\n"); 
		query.append("                    SLS_OFC_CD," ).append("\n"); 
		query.append("                    VSL_CD    ," ).append("\n"); 
		query.append("                    SKD_VOY_NO," ).append("\n"); 
		query.append("                    SKD_DIR_CD," ).append("\n"); 
		query.append("                    COST_YR   ," ).append("\n"); 
		query.append("                    COST_MON  ," ).append("\n"); 
		query.append("                    COST_WK   ," ).append("\n"); 
		query.append("                    POL_CD    ," ).append("\n"); 
		query.append("                    POD_CD    ," ).append("\n"); 
		query.append("                    POL_PAST," ).append("\n"); 
		query.append("                    POL_SEQ," ).append("\n"); 
		query.append("                    POD_SEQ," ).append("\n"); 
		query.append("                    POL_MAX_SEQ," ).append("\n"); 
		query.append("                    POL_MIN_SEQ,                    " ).append("\n"); 
		query.append("                    POL_PORT_SEQ," ).append("\n"); 
		query.append("                    POL_PORT_MAX_SEQ," ).append("\n"); 
		query.append("                    POL_YD_SEQ," ).append("\n"); 
		query.append("                    POD_PORT_SEQ," ).append("\n"); 
		query.append("                    POD_PORT_MAX_SEQ," ).append("\n"); 
		query.append("                    POD_YD_SEQ" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                     SELECT V.TRD_CD    ," ).append("\n"); 
		query.append("                            V.SUB_TRD_CD," ).append("\n"); 
		query.append("                            V.RLANE_CD  ," ).append("\n"); 
		query.append("                            V.DIR_CD    ," ).append("\n"); 
		query.append("                            V.SLS_OFC_CD," ).append("\n"); 
		query.append("                            V.VSL_CD    ," ).append("\n"); 
		query.append("                            V.SKD_VOY_NO," ).append("\n"); 
		query.append("                            V.SKD_DIR_CD," ).append("\n"); 
		query.append("                            V.COST_YR   ," ).append("\n"); 
		query.append("                            V.COST_MON  ," ).append("\n"); 
		query.append("                            V.COST_WK   ," ).append("\n"); 
		query.append("                            NVL(S1.YD_CD, S1.VPS_PORT_CD) AS POL_CD    ," ).append("\n"); 
		query.append("                            NVL(S2.YD_CD, S2.VPS_PORT_CD) AS POD_CD    ," ).append("\n"); 
		query.append("                            (select DECODE(SIGN(S1.VPS_ETD_DT - GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYS_EXTRACT_UTC(SYSTIMESTAMP), S1.VPS_PORT_CD )), -1, 'Y', 'N') from dual) AS POL_PAST," ).append("\n"); 
		query.append("                            S1.CLPT_SEQ AS POL_SEQ," ).append("\n"); 
		query.append("                            S2.CLPT_SEQ AS POD_SEQ," ).append("\n"); 
		query.append("                            SPC_CONTI_CONV_FNC('',V.RLANE_CD,S1.SKD_DIR_CD,S1.VPS_PORT_CD)  AS POL_CONTI," ).append("\n"); 
		query.append("                            SPC_CONTI_CONV_FNC('',V.RLANE_CD,S2.SKD_DIR_CD,S2.VPS_PORT_CD)  AS POD_CONTI," ).append("\n"); 
		query.append("                            MAX(S1.CLPT_SEQ) OVER (PARTITION BY S1.YD_CD, S1.VSL_CD, S1.SKD_VOY_NO, S1.SKD_DIR_CD) AS POL_MAX_SEQ," ).append("\n"); 
		query.append("                            MIN(S1.CLPT_SEQ) OVER (PARTITION BY S1.YD_CD, S1.VSL_CD, S1.SKD_VOY_NO, S1.SKD_DIR_CD) AS POL_MIN_SEQ,                    " ).append("\n"); 
		query.append("                            S1.CLPT_IND_SEQ POL_PORT_SEQ," ).append("\n"); 
		query.append("                            MAX(S1.CLPT_IND_SEQ) OVER (PARTITION BY V.RLANE_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD) AS POL_PORT_MAX_SEQ," ).append("\n"); 
		query.append("                            S1.CALL_YD_IND_SEQ POL_YD_SEQ," ).append("\n"); 
		query.append("                            S2.CLPT_IND_SEQ POD_PORT_SEQ," ).append("\n"); 
		query.append("                            MAX(S2.CLPT_IND_SEQ) OVER (PARTITION BY V.RLANE_CD, V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD) AS POD_PORT_MAX_SEQ," ).append("\n"); 
		query.append("                            S2.CALL_YD_IND_SEQ POD_YD_SEQ" ).append("\n"); 
		query.append("                       FROM MAS_MON_VVD_LV   V ," ).append("\n"); 
		query.append("                            VSK_VSL_PORT_SKD S1," ).append("\n"); 
		query.append("                            VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("                      WHERE S1.VSL_CD     = V.VSL_CD" ).append("\n"); 
		query.append("                        AND S1.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND S1.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND S1.VSL_CD     = S2.VSL_CD" ).append("\n"); 
		query.append("                        AND S1.SKD_VOY_NO = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND S1.SKD_DIR_CD = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND S1.CLPT_SEQ   < S2.CLPT_SEQ" ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("                     WHERE  ( POL_SEQ = DECODE(POL_CONTI, POD_CONTI, POL_MIN_SEQ, POL_MAX_SEQ) " ).append("\n"); 
		query.append("                               OR POD_SEQ < POL_MAX_SEQ )" ).append("\n"); 
		query.append("           ) Z" ).append("\n"); 
		query.append("  GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           SLS_OFC_CD," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           POL_CD    ," ).append("\n"); 
		query.append("           POD_CD    ,           " ).append("\n"); 
		query.append("           POL_PORT_SEQ," ).append("\n"); 
		query.append("           POL_PORT_MAX_SEQ," ).append("\n"); 
		query.append("           POL_YD_SEQ," ).append("\n"); 
		query.append("           POD_PORT_SEQ," ).append("\n"); 
		query.append("           POD_PORT_MAX_SEQ," ).append("\n"); 
		query.append("           POD_YD_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" SELECT /*+ gather_plan_statistics */ L.TRD_CD    ," ).append("\n"); 
		query.append("         L.SUB_TRD_CD," ).append("\n"); 
		query.append("         L.RLANE_CD  ," ).append("\n"); 
		query.append("         L.DIR_CD    ," ).append("\n"); 
		query.append("         L.COST_WK   ," ).append("\n"); 
		query.append("         L.COST_MON  ," ).append("\n"); 
		query.append("         L.VSL_CD    ," ).append("\n"); 
		query.append("         L.SKD_VOY_NO," ).append("\n"); 
		query.append("         L.SKD_DIR_CD," ).append("\n"); 
		query.append("         L.VVD       ," ).append("\n"); 
		query.append("         L.AD_VOL    ," ).append("\n"); 
		query.append("         L.AD_WGT    ," ).append("\n"); 
		query.append("         L.TS_VOL    ," ).append("\n"); 
		query.append("         L.TS_WGT    ," ).append("\n"); 
		query.append("         L.QTA_VOL   ," ).append("\n"); 
		query.append("         L.QTA_CMB   ," ).append("\n"); 
		query.append("         L.FC_VOL    ," ).append("\n"); 
		query.append("         L.FC_WGT    ," ).append("\n"); 
		query.append("         L.FC_TS_VOL    ," ).append("\n"); 
		query.append("         L.FC_TS_WGT    ,                  " ).append("\n"); 
		query.append("         L.AP_VOL    ," ).append("\n"); 
		query.append("         L.AP_WGT    ," ).append("\n"); 
		query.append("         L.AP_TS_VOL    ," ).append("\n"); 
		query.append("         L.AP_TS_WGT    ," ).append("\n"); 
		query.append("         L.BKG_VOL   ," ).append("\n"); 
		query.append("         L.BKG_WGT   ,L.BKG_VOL_VGM,L.BKG_WGT_VGM," ).append("\n"); 
		query.append("         L.BKG_TS_VOL   ," ).append("\n"); 
		query.append("         L.BKG_TS_WGT   ,L.BKG_TS_VOL_VGM,L.BKG_TS_WGT_VGM,  " ).append("\n"); 
		query.append("         L.CM_OP," ).append("\n"); 
		query.append("         L.CM_OC," ).append("\n"); 
		query.append("         L.CM_VL,              " ).append("\n"); 
		query.append("         NVL(C.CTRL_LVL_CD     , 'L') AS CTRL_PORT_FLG   ," ).append("\n"); 
		query.append("         NVL(C.CTRL_40FT_HC_FLG, 'N') AS CTRL_40FT_HC_FLG," ).append("\n"); 
		query.append("         NVL(C.CTRL_45FT_HC_FLG, 'N') AS CTRL_45FT_HC_FLG," ).append("\n"); 
		query.append("         NVL(C.CTRL_53FT_FLG   , 'N') AS CTRL_53FT_FLG   ," ).append("\n"); 
		query.append("         NVL(C.CTRL_RF_FLG     , 'N') AS CTRL_RF_FLG     ," ).append("\n"); 
		query.append("         NVL(C.CTRL_WGT_FLG    , 'N') AS CTRL_WGT_FLG    ," ).append("\n"); 
		query.append("         NVL(C.CTRL_SPC_FLG    , 'N') AS CTRL_SPC_FLG    ," ).append("\n"); 
		query.append("         -- 2014.08.04 control 컬럼 추가 누락분 2015.07.24 RHQ 및 MainOffice와 맞춤" ).append("\n"); 
		query.append("         NVL(C.CTRL_D2_FLG      , 'N')       AS CTRL_D2_FLG     ," ).append("\n"); 
		query.append("         NVL(C.CTRL_D4_FLG      , 'N')       AS CTRL_D4_FLG     ," ).append("\n"); 
		query.append("         NVL(C.CTRL_RD_FLG      , 'N')       AS CTRL_RD_FLG     ," ).append("\n"); 
		query.append("         NVL(C.CTRL_ECC_FLG     , 'N')       AS CTRL_ECC_FLG    , " ).append("\n"); 
		query.append("         NVL(C.CTRL_LOC_FLG     , 'N')       AS CTRL_LOC_FLG    ," ).append("\n"); 
		query.append("         NVL(C.CTRL_USA_SVC_MOD_FLG, 'N')     AS CTRL_USA_SVC_MOD_FLG    ," ).append("\n"); 
		query.append("         NVL(C.CTRL_ACCT_FLG       , 'N')     AS CTRL_ACCT_FLG," ).append("\n"); 
		query.append("	     NVL(C.CTRL_DEST_LVL_CD 	, 'N')    AS CTRL_DEST_LVL_CD," ).append("\n"); 
		query.append("         NVL(C.ACCT_GRP_CTRL_FLG, 'N')        AS ACCT            ," ).append("\n"); 
		query.append("         ---------------------------------------------------------여기까지 맞춤" ).append("\n"); 
		query.append("         NVL(C.CTRL_FX_RT_FLG , 'N')          AS CTRL_FX_RT_FLG  ," ).append("\n"); 
		query.append("         DECODE(C.RLANE_CD, NULL, 'I', 'R') AS IBFLAG" ).append("\n"); 
		query.append("         ,BS_TEU AS BKG_BS_TEU, BS_WGT AS BKG_BS_WGT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR||COST_WK AS COST_WK," ).append("\n"); 
		query.append("                   COST_MON  ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD," ).append("\n"); 
		query.append("                   VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                   NVL(SUM(AD_VOL),0)  AS AD_VOL ," ).append("\n"); 
		query.append("                   NVL(SUM(AD_WGT),0)  AS AD_WGT ," ).append("\n"); 
		query.append("                   NVL(SUM(TS_VOL),0)  AS TS_VOL ," ).append("\n"); 
		query.append("                   NVL(SUM(TS_WGT),0)  AS TS_WGT ," ).append("\n"); 
		query.append("                   SUM(QTA_VOL) AS QTA_VOL," ).append("\n"); 
		query.append("                   SUM(QTA_CMB) AS QTA_CMB," ).append("\n"); 
		query.append("                   SUM(FC_VOL)  AS FC_VOL ," ).append("\n"); 
		query.append("                   SUM(FC_WGT)  AS FC_WGT ,                  " ).append("\n"); 
		query.append("                   SUM(FC_TS_VOL)  AS FC_TS_VOL ," ).append("\n"); 
		query.append("                   SUM(FC_TS_WGT)  AS FC_TS_WGT ,                   " ).append("\n"); 
		query.append("                   SUM(AP_VOL)  AS AP_VOL ," ).append("\n"); 
		query.append("                   SUM(AP_WGT)  AS AP_WGT ," ).append("\n"); 
		query.append("                   SUM(AP_TS_VOL)  AS AP_TS_VOL ," ).append("\n"); 
		query.append("                   SUM(AP_TS_WGT)  AS AP_TS_WGT ," ).append("\n"); 
		query.append("                   SUM(BKG_VOL) AS BKG_VOL," ).append("\n"); 
		query.append("                   SUM(BKG_WGT) AS BKG_WGT,SUM(BKG_VOL_VGM) AS BKG_VOL_VGM,SUM(BKG_WGT_VGM) AS BKG_WGT_VGM," ).append("\n"); 
		query.append("                   SUM(BKG_TS_VOL) AS BKG_TS_VOL," ).append("\n"); 
		query.append("                   SUM(BKG_TS_WGT) AS BKG_TS_WGT,SUM(BKG_TS_VOL_VGM) AS BKG_TS_VOL_VGM,SUM(BKG_TS_WGT_VGM) AS BKG_TS_WGT_VGM," ).append("\n"); 
		query.append("                   SUM(CM_OP) AS CM_OP," ).append("\n"); 
		query.append("                   SUM(CM_OC) AS CM_OC," ).append("\n"); 
		query.append("                   SUM(CM_VL) AS CM_VL," ).append("\n"); 
		query.append("                   SUM(BS_TEU) AS BS_TEU, SUM(BS_WGT) AS BS_WGT                            " ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      -- Forecast" ).append("\n"); 
		query.append("                      SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD," ).append("\n"); 
		query.append("                             NULL AS AD_VOL ," ).append("\n"); 
		query.append("                             NULL AS AD_WGT ," ).append("\n"); 
		query.append("                             NULL AS TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS TS_WGT , " ).append("\n"); 
		query.append("                             NULL AS QTA_VOL," ).append("\n"); 
		query.append("                             NULL AS QTA_CMB,                             " ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T',0, NVL(DA.CFM_TTL_QTY, 0) + NVL(DA.CFM_40FT_HC_QTY, 0) * 2 + NVL(DA.CFM_45FT_HC_QTY, 0) * 2 + NVL(DA.CFM_53FT_QTY, 0) * 2) AS FC_VOL," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T',0, DA.CFM_TTL_WGT) AS FC_WGT," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T', NVL(DA.CFM_TTL_QTY, 0) + NVL(DA.CFM_40FT_HC_QTY, 0) * 2 + NVL(DA.CFM_45FT_HC_QTY, 0) * 2 + NVL(DA.CFM_53FT_QTY, 0) * 2) AS FC_TS_VOL," ).append("\n"); 
		query.append("                             DECODE(DA.IOC_TS_CD, 'T', DA.CFM_TTL_WGT) AS FC_TS_WGT,                                                                    " ).append("\n"); 
		query.append("                             NULL AS AP_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS BKG_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_WGT,NULL AS BKG_VOL_VGM,NULL AS BKG_WGT_VGM," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_WGT,NULL AS BKG_TS_VOL_VGM,NULL AS BKG_TS_WGT_VGM," ).append("\n"); 
		query.append("                             NULL AS CM_OP," ).append("\n"); 
		query.append("                             NULL AS CM_OC," ).append("\n"); 
		query.append("                             NULL AS CM_VL " ).append("\n"); 
		query.append("                             ,0 AS BS_TEU,0 AS BS_WGT" ).append("\n"); 
		query.append("                        FROM VSL_PORT_SKD       B ," ).append("\n"); 
		query.append("                             SPC_DLY_FCAST_CUST DA" ).append("\n"); 
		query.append("                       WHERE B.TRD_CD = DA.TRD_CD" ).append("\n"); 
		query.append("                         AND ((B.SUB_TRD_CD IS NULL AND DA.SUB_TRD_CD IS NULL) OR B.SUB_TRD_CD = DA.SUB_TRD_CD)" ).append("\n"); 
		query.append("                         AND B.RLANE_CD   = DA.RLANE_CD" ).append("\n"); 
		query.append("                         AND B.DIR_CD     = DA.DIR_CD" ).append("\n"); 
		query.append("                         AND B.VSL_CD     = DA.VSL_CD" ).append("\n"); 
		query.append("                         AND B.SKD_VOY_NO = DA.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND B.DIR_CD     = DA.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND B.SLS_OFC_CD = DA.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("                         AND B.POL_CD     = DA.POL_YD_CD" ).append("\n"); 
		query.append("                         AND B.POD_CD     = DA.POD_YD_CD" ).append("\n"); 
		query.append("                         AND B.POL_YD_SEQ = DA.POL_YD_IND_SEQ " ).append("\n"); 
		query.append("                         AND B.POD_YD_SEQ = DA.POD_YD_IND_SEQ " ).append("\n"); 
		query.append("                         AND NVL(DA.CFM_TTL_QTY, 0) + NVL(DA.CFM_40FT_HC_QTY, 0) + NVL(DA.CFM_45FT_HC_QTY, 0) + NVL(DA.CFM_53FT_QTY, 0) + NVL(DA.CFM_TTL_WGT, 0) > 0" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      --Allocated/Allocation" ).append("\n"); 
		query.append("                      SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_QTY)) AS AD_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_WGT)) AS AD_WGT," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_QTY)) AS TS_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_OFC_CD, D.ASGN_TTL_WGT)) AS TS_WGT," ).append("\n"); 
		query.append("                             NULL AS QTA_VOL," ).append("\n"); 
		query.append("                             NULL AS QTA_CMB," ).append("\n"); 
		query.append("                             NULL AS FC_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_WGT ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_WGT ,                             " ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_QTY)) AS AP_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'N', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_WGT)) AS AP_WGT," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_QTY)) AS AP_TS_VOL," ).append("\n"); 
		query.append("                             DECODE(D.TS_FLG, 'Y', DECODE(B.SLS_OFC_CD, D.SLS_RGN_OFC_CD, D.BKG_AVAL_TTL_WGT)) AS AP_TS_WGT,                                                                    " ).append("\n"); 
		query.append("                             NULL AS BKG_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_WGT, NULL AS BKG_VOL_VGM,NULL AS BKG_WGT_VGM," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_WGT,NULL AS BKG_TS_VOL_VGM,NULL AS BKG_TS_WGT_VGM," ).append("\n"); 
		query.append("                             NULL AS CM_OP," ).append("\n"); 
		query.append("                             NULL AS CM_OC," ).append("\n"); 
		query.append("                             NULL AS CM_VL " ).append("\n"); 
		query.append("                             ,0 AS BS_TEU,0 AS BS_WGT" ).append("\n"); 
		query.append("                        FROM VSL_PORT_SKD     B," ).append("\n"); 
		query.append("                             SPC_ALOC_POL_POD D" ).append("\n"); 
		query.append("                       WHERE B.TRD_CD = D.TRD_CD" ).append("\n"); 
		query.append("                         AND ((B.SUB_TRD_CD IS NULL AND D.SUB_TRD_CD IS NULL) OR B.SUB_TRD_CD = D.SUB_TRD_CD)" ).append("\n"); 
		query.append("                         AND B.RLANE_CD               = D.RLANE_CD" ).append("\n"); 
		query.append("                         AND B.DIR_CD                 = D.DIR_CD" ).append("\n"); 
		query.append("                         AND B.VSL_CD                 = D.VSL_CD" ).append("\n"); 
		query.append("                         AND B.SKD_VOY_NO             = D.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND B.DIR_CD                 = D.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND B.POL_CD                 = D.POL_YD_CD" ).append("\n"); 
		query.append("                         AND B.POD_CD                 = D.POD_YD_CD" ).append("\n"); 
		query.append("                         AND B.POL_YD_SEQ             = D.POL_YD_IND_SEQ " ).append("\n"); 
		query.append("                         AND B.POD_YD_SEQ             = D.POD_YD_IND_SEQ " ).append("\n"); 
		query.append("                         AND (B.SLS_OFC_CD            = D.SLS_OFC_CD OR B.SLS_OFC_CD = D.SLS_RGN_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      --Booking" ).append("\n"); 
		query.append("                      SELECT T.TRD_CD    ," ).append("\n"); 
		query.append("                             T.SUB_TRD_CD," ).append("\n"); 
		query.append("                             T.RLANE_CD  ," ).append("\n"); 
		query.append("                             T.DIR_CD    ," ).append("\n"); 
		query.append("                             T.COST_YR   ," ).append("\n"); 
		query.append("                             T.COST_MON  ," ).append("\n"); 
		query.append("                             T.COST_WK   ," ).append("\n"); 
		query.append("                             T.VSL_CD    ," ).append("\n"); 
		query.append("                             T.SKD_VOY_NO," ).append("\n"); 
		query.append("                             T.SKD_DIR_CD," ).append("\n"); 
		query.append("                             NULL AS AD_VOL ," ).append("\n"); 
		query.append("                             NULL AS AD_WGT ," ).append("\n"); 
		query.append("                             NULL AS TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS QTA_VOL," ).append("\n"); 
		query.append("                             NULL AS QTA_CMB," ).append("\n"); 
		query.append("                             NULL AS FC_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_WGT ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_WGT ,                                                                " ).append("\n"); 
		query.append("                             DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T',0, TO_NUMBER(NVL(SUBSTR(T.VAL , 1, 14), 0))) AS BKG_VOL," ).append("\n"); 
		query.append("                             DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T',0, TO_NUMBER(NVL(SUBSTR(T.VAL , 99, 14), 0))) AS BKG_WGT," ).append("\n"); 
		query.append("                             DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T',0, TO_NUMBER(NVL(BKG_VOL_VGM,0))) AS BKG_VOL_VGM," ).append("\n"); 
		query.append("							 DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T',0, TO_NUMBER(NVL(BKG_WGT_VGM,0))) AS BKG_WGT_VGM," ).append("\n"); 
		query.append("                             DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T', TO_NUMBER(NVL(SUBSTR(T.VAL , 1, 14), 0))) AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T', TO_NUMBER(NVL(SUBSTR(T.VAL , 99, 14), 0))) AS BKG_TS_WGT," ).append("\n"); 
		query.append("                             DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T', TO_NUMBER(NVL(BKG_VOL_VGM, 0))) AS BKG_TS_VOL_VGM," ).append("\n"); 
		query.append("							 DECODE(DECODE(T.VSL_PRE_PST_CD, 'T', T.IOC_CD, 'T'), 'T', TO_NUMBER(NVL(BKG_WGT_VGM, 0))) AS BKG_TS_WGT_VGM," ).append("\n"); 
		query.append("                             TO_NUMBER(NVL(SUBSTR(CM_VAL,  1, 10), 0)) AS CM_OP	      ," ).append("\n"); 
		query.append("                             TO_NUMBER(NVL(SUBSTR(CM_VAL, 11, 10), 0)) AS CM_OC	      ," ).append("\n"); 
		query.append("                             TO_NUMBER(NVL(SUBSTR(CM_VAL, 21, 10), 0)) AS CM_VL       ," ).append("\n"); 
		query.append("                             DECODE( NVL( ALOC_STS_CD ,'X'),'S',TO_NUMBER(NVL(SUBSTR(T.VAL , 1, 14), 0)),'A',TO_NUMBER(NVL(SUBSTR(T.VAL , 1, 14), 0))) AS BKG_BS_VOL," ).append("\n"); 
		query.append("                             DECODE( NVL( ALOC_STS_CD ,'X'),'S',TO_NUMBER(NVL(SUBSTR(T.VAL , 99, 14), 0)),'A',TO_NUMBER(NVL(SUBSTR(T.VAL , 99, 14), 0))) AS BKG_BS_WGT" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                                SELECT " ).append("\n"); 
		query.append("                                /*+ leading(b) */" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                                     B.TRD_CD," ).append("\n"); 
		query.append("                                     B.SUB_TRD_CD," ).append("\n"); 
		query.append("                                     B.RLANE_CD," ).append("\n"); 
		query.append("                                     BV.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                                     DECODE(SUBSTR(DRL.TRD_CD, 1, 1), 'I', 'I', 'O') AS IOC_CD," ).append("\n"); 
		query.append("                                     BKG.OB_SLS_OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                                     NVL(BV.POL_YD_CD, BV.POL_CD) AS POL_CD," ).append("\n"); 
		query.append("                                     NVL(BV.POD_YD_CD, BV.POD_CD) AS POD_CD," ).append("\n"); 
		query.append("                                     BV.VSL_CD, BV.SKD_VOY_NO, BV.SKD_DIR_CD,B.DIR_CD," ).append("\n"); 
		query.append("                                     B.COST_YR   ," ).append("\n"); 
		query.append("                                     B.COST_MON  ," ).append("\n"); 
		query.append("                                     B.COST_WK   ," ).append("\n"); 
		query.append("                                     BKG.BKG_NO, " ).append("\n"); 
		query.append("                                     BKG.BKG_STS_CD," ).append("\n"); 
		query.append("                                     DOC.ACT_WGT, " ).append("\n"); 
		query.append("                                     DOC.WGT_UT_CD," ).append("\n"); 
		query.append("                                     (" ).append("\n"); 
		query.append("                                        SELECT TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 2, 1), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                        	|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 2, 1), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                        	|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 2, 1), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                        	|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 2, 1), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') --R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("                                        	|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 2, 1), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                        	|| TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                        	|| TO_CHAR(SUM(DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'R', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("                                        	|| TO_CHAR((DOC.ACT_WGT * DECODE(DOC.WGT_UT_CD, 'LBS', 0.00045, 0.001)) " ).append("\n"); 
		query.append("											 + SUM(Q.OP_CNTR_QTY * (" ).append("\n"); 
		query.append("                                                    SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                    FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                    WHERE TS.CNTR_TPSZ_CD = 	Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000') " ).append("\n"); 
		query.append("                                                    						|| TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'R2', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0)), 'FM0000000000.000') " ).append("\n"); 
		query.append("																			|| TO_CHAR(SUM(" ).append("\n"); 
		query.append("                                                                  							CASE" ).append("\n"); 
		query.append("                                                                    							WHEN SUBSTR(Q.CNTR_TPSZ_CD, 1, 1) = 'R' AND Q.CNTR_TPSZ_CD <> 'R2' " ).append("\n"); 
		query.append("																									 THEN Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY" ).append("\n"); 
		query.append("                                                                    						ELSE 0" ).append("\n"); 
		query.append("                                                                  							END), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                        WHERE BKG.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                                          AND Q.OP_CNTR_QTY > 0 ) AS VAL," ).append("\n"); 
		query.append("                                     SPC_GET_OB_MVMT_FNC(BKG.BKG_NO, B.POL_PAST) AS CM_VAL" ).append("\n"); 
		query.append("									, ALOC_STS_CD" ).append("\n"); 
		query.append("									,(" ).append("\n"); 
		query.append("									SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Z.CNTR_TPSZ_CD), '2', 1, 2)* Z.OP_CNTR_QTY) " ).append("\n"); 
		query.append("									FROM BKG_QUANTITY Z " ).append("\n"); 
		query.append("									WHERE Z.BKG_NO= BKG.BKG_NO AND OP_CNTR_QTY > 0 " ).append("\n"); 
		query.append("									AND EXISTS ( SELECT 1 FROM BKG_CONTAINER C WHERE C.BKG_NO= Z.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL )" ).append("\n"); 
		query.append("									) AS BKG_VOL_VGM" ).append("\n"); 
		query.append("                                    ,(SELECT SUM(NVL(Z.VGM_WGT,0) * DECODE(Z.VGM_WGT_UT_CD,'LBS',0.00045,0.001)) FROM BKG_CONTAINER Z WHERE Z.BKG_NO= BKG.BKG_NO AND VGM_WGT>0 AND VGM_WGT IS NOT NULL) AS BKG_WGT_VGM" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING  BKG," ).append("\n"); 
		query.append("                                     BKG_VVD BV," ).append("\n"); 
		query.append("                                     BKG_BL_DOC DOC," ).append("\n"); 
		query.append("                                     MDM_REV_LANE RL," ).append("\n"); 
		query.append("                                     MDM_DTL_REV_LANE DRL," ).append("\n"); 
		query.append("                                     VSL_PORT_SKD B," ).append("\n"); 
		query.append("                                     SPC_OFC_LVL  O," ).append("\n"); 
		query.append("									 (SELECT DISTINCT VSL_CD, SKD_VOY_NO, SKD_DIR_CD FROM MAS_MON_VVD_LV) L" ).append("\n"); 
		query.append("                               WHERE BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                                 AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("                                 AND DRL.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("                                 AND DRL.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("                                 AND DRL.RLANE_CD LIKE BV.SLAN_CD||'%'" ).append("\n"); 
		query.append("                                 AND DRL.VSL_SLAN_DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("                                 AND DRL.RLANE_CD = RL.RLANE_CD" ).append("\n"); 
		query.append("                                 AND DRL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                 AND BV.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                                 AND BV.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND BV.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                -- AND BV.POL_YD_CD  = B.POL_CD" ).append("\n"); 
		query.append("                              --   AND BV.POD_YD_CD  = B.POD_CD                                " ).append("\n"); 
		query.append("                                 AND ((BV.POL_CD = SUBSTR(B.POL_CD, 1, 5) AND BV.POL_CLPT_IND_SEQ = B.POL_PORT_SEQ) OR (BV.POL_YD_CD = B.POL_CD AND BV.POL_CLPT_IND_SEQ > 1 AND B.POL_PORT_MAX_SEQ = 1) OR (BV.POL_YD_CD = B.POL_CD AND BV.POL_CLPT_IND_SEQ = B.POL_PORT_MAX_SEQ))" ).append("\n"); 
		query.append("                                 AND ((BV.POD_CD = SUBSTR(B.POD_CD, 1, 5) AND BV.POD_CLPT_IND_SEQ = B.POD_PORT_SEQ) OR (BV.POD_YD_CD = B.POD_CD AND BV.POD_CLPT_IND_SEQ > 1 AND B.POD_PORT_MAX_SEQ = 1) OR (BV.POD_YD_CD = B.POD_CD AND BV.POD_CLPT_IND_SEQ = B.POD_PORT_MAX_SEQ))" ).append("\n"); 
		query.append("                                 AND DRL.FM_CONTI_CD = (" ).append("\n"); 
		query.append("                                                        SELECT SPC_CONTI_CONV_FNC(MLOC.CONTI_CD, B.RLANE_CD)" ).append("\n"); 
		query.append("                                                        FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                        WHERE MLOC.LOC_CD = BV.POL_CD )" ).append("\n"); 
		query.append("                                 AND DRL.TO_CONTI_CD = (" ).append("\n"); 
		query.append("                                                        SELECT SPC_CONTI_CONV_FNC(MLOC.CONTI_CD, B.RLANE_CD)" ).append("\n"); 
		query.append("                                                        FROM MDM_LOCATION MLOC" ).append("\n"); 
		query.append("                                                        WHERE MLOC.LOC_CD = BV.POD_CD )" ).append("\n"); 
		query.append("                                 AND BKG.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                                 AND BKG.BKG_STS_CD    IN ('F', 'W')" ).append("\n"); 
		query.append("                                 AND (   (B.SLS_OFC_CD = 'DXBSC' AND B.SLS_OFC_CD IN (O.N4TH_PRNT_OFC_CD, O.N5TH_PRNT_OFC_CD) )" ).append("\n"); 
		query.append("                                      OR (B.SLS_OFC_CD <> 'DXBSC' AND B.SLS_OFC_CD = O.N4TH_PRNT_OFC_CD )" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                                 AND DRL.RLANE_CD      <> 'RBCCO'" ).append("\n"); 
		query.append("                                 AND (select SPC_SCR_OFC_CONV_FNC(BKG.OB_SLS_OFC_CD, '') from dual) = O.OFC_CD" ).append("\n"); 
		query.append("--                                 AND SPC_SCR_OFC_CONV_FNC(BKG.OB_SLS_OFC_CD, '') = O.OFC_CD" ).append("\n"); 
		query.append("                                 AND B.COST_YR||B.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                 AND L.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                                 AND L.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                 AND L.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ) T" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      -- Booking Quota / CMB" ).append("\n"); 
		query.append("                      SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD," ).append("\n"); 
		query.append("                             NULL AS AD_VOL," ).append("\n"); 
		query.append("                             NULL AS AD_WGT," ).append("\n"); 
		query.append("                             NULL AS TS_VOL," ).append("\n"); 
		query.append("                             NULL AS TS_WGT," ).append("\n"); 
		query.append("                             ROUND(SUM(MQ.LOD_QTY)) AS QTA_VOL," ).append("\n"); 
		query.append("                             DECODE(ROUND(SUM(MQ.LOD_QTY)), 0, 0, (SUM(MQ.GRS_RPB_REV * MQ.LOD_QTY) - SUM(MQ.PA_CM_UC_AMT * MQ.LOD_QTY)) / ROUND(SUM(MQ.LOD_QTY))) AS QTA_CMB," ).append("\n"); 
		query.append("                             NULL AS FC_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_WGT ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS FC_TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_WGT ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_VOL ," ).append("\n"); 
		query.append("                             NULL AS AP_TS_WGT ," ).append("\n"); 
		query.append("                             NULL AS BKG_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_WGT,NULL AS BKG_VOL_VGM,NULL AS BKG_WGT_VGM," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_VOL," ).append("\n"); 
		query.append("                             NULL AS BKG_TS_WGT,NULL AS BKG_TS_VOL_VGM,NULL AS BKG_TS_WGT_VGM," ).append("\n"); 
		query.append("                             NULL AS CM_OP," ).append("\n"); 
		query.append("                             NULL AS CM_OC," ).append("\n"); 
		query.append("                             NULL AS CM_VL," ).append("\n"); 
		query.append("                             0 AS BS_TEU, 0 AS BS_WGT                 " ).append("\n"); 
		query.append("                        FROM MAS_MON_VVD_LV   B  ," ).append("\n"); 
		query.append("                             SQM_CFM_QTA      MQ ," ).append("\n"); 
		query.append("                             SQM_QTA_RLSE_VER MQR" ).append("\n"); 
		query.append("                       WHERE MQR.BSE_YR          = B.BSE_YR" ).append("\n"); 
		query.append("                         AND MQR.BSE_QTR_CD      = B.BSE_QTR_CD --CEIL(TO_NUMBER(DECODE(B.COST_WK,'00','01','53','52',B.COST_WK))/13)||'Q'--CEIL(TO_NUMBER(B.COST_MON) / 3)||'Q'" ).append("\n"); 
		query.append("                         AND MQR.SQM_VER_STS_CD  = 'R' --" ).append("\n"); 
		query.append("                         AND MQR.BSE_TP_CD       = 'Q' --" ).append("\n"); 
		query.append("                         AND MQ.QTA_RLSE_VER_NO  = MQR.QTA_RLSE_VER_NO --" ).append("\n"); 
		query.append("                         AND MQ.BSE_TP_CD        = MQR.BSE_TP_CD --" ).append("\n"); 
		query.append("                         AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("                         AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("                         AND MQ.QTA_TGT_CD       = 'D' --" ).append("\n"); 
		query.append("                         AND MQ.OFC_VW_CD        = 'L' --" ).append("\n"); 
		query.append("                         AND MQ.TRD_CD           = B.TRD_CD" ).append("\n"); 
		query.append("                         AND MQ.RLANE_CD         = B.RLANE_CD" ).append("\n"); 
		query.append("                         AND MQ.DIR_CD           = B.DIR_CD" ).append("\n"); 
		query.append("                         AND MQ.VSL_CD           = B.VSL_CD" ).append("\n"); 
		query.append("                         AND MQ.SKD_VOY_NO       = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND MQ.SKD_DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                         --AND SPC_SCR_OFC_CONV_FNC(MQ.RGN_OFC_CD,'') = B.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND MQ.RGN_OFC_CD IN (SELECT OFC_CD FROM SPC_OFC_LVL WHERE B.COST_YR || B.COST_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                                  AND N4TH_PRNT_OFC_CD = B.SLS_OFC_CD AND OFC_LVL IN ('4', '5'))" ).append("\n"); 
		query.append("                         AND MQ.LOD_QTY          > 0" ).append("\n"); 
		query.append("                    GROUP BY B.TRD_CD    ," ).append("\n"); 
		query.append("                             B.SUB_TRD_CD," ).append("\n"); 
		query.append("                             B.RLANE_CD  ," ).append("\n"); 
		query.append("                             B.DIR_CD    ," ).append("\n"); 
		query.append("                             B.COST_YR   ," ).append("\n"); 
		query.append("                             B.COST_MON  ," ).append("\n"); 
		query.append("                             B.COST_WK   ," ).append("\n"); 
		query.append("                             B.VSL_CD    ," ).append("\n"); 
		query.append("                             B.SKD_VOY_NO," ).append("\n"); 
		query.append("                             B.SKD_DIR_CD" ).append("\n"); 
		query.append("                            " ).append("\n"); 
		query.append("                   ) Z" ).append("\n"); 
		query.append("          GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   COST_YR   ," ).append("\n"); 
		query.append("                   COST_MON  ," ).append("\n"); 
		query.append("                   COST_WK   ," ).append("\n"); 
		query.append("                   VSL_CD    ," ).append("\n"); 
		query.append("                   SKD_VOY_NO," ).append("\n"); 
		query.append("                   SKD_DIR_CD" ).append("\n"); 
		query.append("         ) L," ).append("\n"); 
		query.append("         SPC_ALOC_CTRL_OPT C" ).append("\n"); 
		query.append("   WHERE L.TRD_CD     = C.REP_TRD_CD(+)" ).append("\n"); 
		query.append("     AND L.RLANE_CD   = C.RLANE_CD  (+)" ).append("\n"); 
		query.append("     AND L.DIR_CD     = C.DIR_CD    (+)" ).append("\n"); 
		query.append("     AND L.VSL_CD     = C.VSL_CD    (+)" ).append("\n"); 
		query.append("     AND L.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("     AND L.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("ORDER BY 1," ).append("\n"); 
		query.append("         2," ).append("\n"); 
		query.append("         3," ).append("\n"); 
		query.append("         4," ).append("\n"); 
		query.append("         5," ).append("\n"); 
		query.append("         6" ).append("\n"); 

	}
}