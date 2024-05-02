/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAO21PfmcRatioRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : Arie
*@LastVersion : 1.0
* 2017.01.23 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAO21PfmcRatioRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Daily Forecast Status 화면 내 PFMC Ratio vs QTA & BSA 탭 조회
	  * QTA & BSA 대비 F'cast 와 BKG 실적 달성율
	  * 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2013.02.22 김시몬[CHM-201323235-01]WAX 노선은 Dest. 를 AU 로 집계되도록 보완, WAXIA 의 경우 Direction 변경(E=> W, W=> E)
	  * 2013.09.05 진마리아 [CHM-201326612] AAZ Direction Conversion
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * 2013.12.05 김시몬 [CHM-201326854] SAQ project로 인한 SPC 변경건_테이블 변경
	  * 2014.01.13 김시몬 [선처리] SELSC/TYOSC RHQ변경에 따른 SQM SPC_OFC_LVL추가
	  * 2014.02.26 신자영 [CHM-201428699] Daily FCST status report _ TTL 값 산출 logic변경
	  * 2014.03.25 김시몬 [선처리] SQM 분기구하는 로직 관련 보완
	  * 2014.12.16 박은주 [CHM-201433153] Daily FCST status 리포트 보완 요청(겹선) 
	  * 2015.03.03 CHM-201534458 SQM QTA주가 변경 관련 적용 요청
	  * 2015.09.16 이혜민 선반영 SPC_CONTI_CONV_FNC 태울때 SLAN_CD를 인자로 가져가던것 RLANE_CD로 수정 (RLANE_CD로 가져가야 제대로 펑션을 탐)
	  * 2015.11.23 이혜민 선반영 RUS 노선 Bound 변경 요청
	  * 2015.12.03 이혜민 [CHM-201538975] VVOBA Office 관련 수정(Area를 SHARC 대신 E.RUSIA로 치환)
	  * 2016.05.27 이혜민 SELSC, TYOSC RHQ 독립분리
	  * 2017.1.23 SM상선 전환에 따른 소스변경
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAO21PfmcRatioRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ui_name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAO21PfmcRatioRSQL").append("\n"); 
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
		query.append("    SELECT B.TRD_CD    ," ).append("\n"); 
		query.append("           B.SUB_TRD_CD," ).append("\n"); 
		query.append("           B.RLANE_CD  ," ).append("\n"); 
		query.append("           B.DIR_CD    ," ).append("\n"); 
		query.append("           B.IOC_CD    ," ).append("\n"); 
		query.append("           B.COST_YR   ," ).append("\n"); 
		query.append("           B.COST_MON  ," ).append("\n"); 
		query.append("           B.NUM       ," ).append("\n"); 
		query.append("           DENSE_RANK() OVER(PARTITION BY B.TRD_CD, B.RLANE_CD, B.DIR_CD, B.NUM ORDER BY B.DIR_CD, B.PORT_ETD) NUM_1," ).append("\n"); 
		query.append("           B.COST_WK   ," ).append("\n"); 
		query.append("           B.VSL_CD    ," ).append("\n"); 
		query.append("           B.SKD_VOY_NO," ).append("\n"); 
		query.append("           B.SKD_DIR_CD," ).append("\n"); 
		query.append("           B.RHQ_CD    ," ).append("\n"); 
		query.append("           B.AQ_CD     ," ).append("\n"); 
		query.append("           B.RGN_OFC_CD," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("             SELECT DECODE(O.OFC_TP_CD, 'QT', O.PRNT_OFC_CD, DECODE(@[ofc_cd], 'ATLSA', 'NYCRA', 'SLSSC', 'NYCRA', 'PHXSA', 'NYCRA', O.OFC_CD))" ).append("\n"); 
		query.append("               FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                    COM_USER COM" ).append("\n"); 
		query.append("              WHERE COM.USR_ID = @[login_id]" ).append("\n"); 
		query.append("                AND B.COST_YR || B.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                AND O.OFC_CD = SPC_SCR_OFC_CONV_FNC(COM.OFC_CD, @[ui_name])		--Login Office가 ISTSC인 경우에는 Origin Office가 아닌 Login Office가 Loading Office와 일치할 경우 Alloc 이 조회될 수 있도록 수정 요청" ).append("\n"); 
		query.append("           ) AS OFC_CD," ).append("\n"); 
		query.append("           B.POL_CD," ).append("\n"); 
		query.append("           B.BSA   ," ).append("\n"); 
		query.append("           B.PAST," ).append("\n"); 
		query.append("		   B.BSE_QTR_CD," ).append("\n"); 
		query.append("		   B.BSE_YR" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("                     M.SUB_TRD_CD," ).append("\n"); 
		query.append("                     M.RLANE_CD  ," ).append("\n"); 
		query.append("                     M.DIR_CD    ," ).append("\n"); 
		query.append("                     M.IOC_CD    ," ).append("\n"); 
		query.append("                     SUBSTR(M.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("                     SUBSTR(M.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("                     P.RNUM NUM  ," ).append("\n"); 
		query.append("                     M.COST_WK   ," ).append("\n"); 
		query.append("                     M.VSL_CD    ," ).append("\n"); 
		query.append("                     M.SKD_VOY_NO," ).append("\n"); 
		query.append("                     M.DIR_CD               AS SKD_DIR_CD," ).append("\n"); 
		query.append("                     C.RHQ_CD               AS RHQ_CD    ," ).append("\n"); 
		query.append("                     @[area]                AS AQ_CD     ," ).append("\n"); 
		query.append("                     @[sales_office]        AS RGN_OFC_CD," ).append("\n"); 
		query.append("                     @[pol_cd]              AS POL_CD    ," ).append("\n"); 
		query.append("                     NVL(B.CRR_BSA_CAPA, 0) AS BSA       ," ).append("\n"); 
		query.append("                     DECODE(SIGN(SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK - ( SELECT PRD.COST_YR||TO_CHAR(CEIL((TO_CHAR(SYSDATE, 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) / 7), 'FM00')" ).append("\n"); 
		query.append("                                                                            FROM MAS_WK_PRD PRD" ).append("\n"); 
		query.append("                                                                           WHERE PRD.COST_YR = TO_CHAR(SYSDATE, 'YYYY')" ).append("\n"); 
		query.append("                                                                             AND PRD.COST_WK = '01')), -1, 'Y', 'N') AS PAST" ).append("\n"); 
		query.append("                    ,TO_CHAR(M.LST_LODG_PORT_ETD_DT,'YYYYMMDD') AS PORT_ETD" ).append("\n"); 
		query.append("                    , CASE WHEN M.COST_YRMON >= '201501' " ).append("\n"); 
		query.append("                          THEN CEIL(TO_NUMBER(SUBSTR(M.COST_YRMON, -2))/3)||'Q' " ).append("\n"); 
		query.append("                          ELSE CEIL(TO_NUMBER(DECODE(M.COST_WK,'00','01','53','52',M.COST_WK))/13)||'Q'" ).append("\n"); 
		query.append("                      END BSE_QTR_CD --2015.03.04 CHM-201534435 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("                   , SUBSTR(M.COST_YRMON, 1,4) AS BSE_YR" ).append("\n"); 
		query.append("                FROM MAS_MON_VVD     M," ).append("\n"); 
		query.append("                     BSA_VVD_OTR_CRR B," ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX (P, XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                               P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                               ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                          FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                         WHERE P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                           AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("                     ) P," ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("       				 SELECT DISTINCT" ).append("\n"); 
		query.append("            			    SUBSTR(AA," ).append("\n"); 
		query.append("             					   INSTR(AA,',',1,LEVEL)+1," ).append("\n"); 
		query.append("               					   INSTR(AA,',',1,LEVEL+1) - INSTR(AA,',',1,LEVEL)" ).append("\n"); 
		query.append("              					  -1" ).append("\n"); 
		query.append("              					  ) RHQ_CD" ).append("\n"); 
		query.append("         			   FROM (SELECT ','||@[rhq2]||',' AA FROM DUAL)" ).append("\n"); 
		query.append("          					  CONNECT BY LEVEL <= LENGTH(AA) - LENGTH(REPLACE(AA,','))-1" ).append("\n"); 
		query.append("                     ) C" ).append("\n"); 
		query.append("               WHERE SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("                 AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("                 AND M.TRD_CD = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade1} != '')" ).append("\n"); 
		query.append("                 AND M.SUB_TRD_CD = @[subtrade1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("                 AND M.DIR_CD = (CASE" ).append("\n"); 
		query.append("                                    WHEN M.RLANE_CD IN ('AUSIA', 'CKAIA', 'WAXIA', 'AAZIA', 'QISIA', 'RUSIA', 'FOXIA') THEN" ).append("\n"); 
		query.append("                                            DECODE(@[bound], 'E', 'W', 'W', 'E', @[bound])" ).append("\n"); 
		query.append("                                    ELSE" ).append("\n"); 
		query.append("                                        (CASE WHEN M.SLAN_CD = 'CAT' THEN DECODE(@[bound], 'W', 'E', 'E', 'W', @[bound]) ELSE @[bound] END)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                END)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND B.BSA_OP_JB_CD(+) = '007'" ).append("\n"); 
		query.append("                 AND B.CRR_CD      (+) = 'SML'" ).append("\n"); 
		query.append("                 AND M.TRD_CD          = B.TRD_CD    (+)" ).append("\n"); 
		query.append("                 AND M.RLANE_CD        = B.RLANE_CD  (+)" ).append("\n"); 
		query.append("                 AND M.VSL_CD          = B.VSL_CD    (+)" ).append("\n"); 
		query.append("                 AND M.SKD_VOY_NO      = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                 AND M.DIR_CD          = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       #if (${rlane1} != '')" ).append("\n"); 
		query.append("      			 AND M.RLANE_CD         IN ($rlane1)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("           ) B" ).append("\n"); 
		query.append("  ORDER BY B.VSL_CD    ," ).append("\n"); 
		query.append("           B.SKD_VOY_NO," ).append("\n"); 
		query.append("           B.DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTA_DATA AS (" ).append("\n"); 
		query.append("    SELECT 1 AS FLG    ," ).append("\n"); 
		query.append("           R.TRD_CD    ," ).append("\n"); 
		query.append("           R.DIR_CD    ," ).append("\n"); 
		query.append("           R.SUB_TRD_CD," ).append("\n"); 
		query.append("           R.RLANE_CD  ," ).append("\n"); 
		query.append("           R.RHQ_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           R.AREA      ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           NVL(( SELECT T2.CONV_RGN_OFC_CD" ).append("\n"); 
		query.append("                   FROM SPC_RGN_OFC_CONV T2" ).append("\n"); 
		query.append("                  WHERE T2.SLS_RGN_OFC_CD = R.OFC_CD), R.OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("           R.WK ," ).append("\n"); 
		query.append("           R.NUM," ).append("\n"); 
		query.append("           R.NUM_1," ).append("\n"); 
		query.append("           R.VVD," ).append("\n"); 
		query.append("           R.BSA," ).append("\n"); 
		query.append("           ROUND(SUM(R.QTA_QTY)) AS QTA_QTY ," ).append("\n"); 
		query.append("           SUM(R.QTA_GREV)       AS QTA_GREV," ).append("\n"); 
		query.append("           SUM(R.QTA_CM)         AS QTA_CM  ," ).append("\n"); 
		query.append("           0 AS FCT_QTY ," ).append("\n"); 
		query.append("           0 AS FCT_GREV," ).append("\n"); 
		query.append("           0 AS FCT_CM  ," ).append("\n"); 
		query.append("           0 AS ALC_QTY ," ).append("\n"); 
		query.append("           0 AS ALC_GREV," ).append("\n"); 
		query.append("           0 AS ALC_CM  ," ).append("\n"); 
		query.append("           0 AS BKG_QTY ," ).append("\n"); 
		query.append("           0 AS BKG_GREV," ).append("\n"); 
		query.append("           0 AS BKG_CM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT MQ.TRD_CD     ," ).append("\n"); 
		query.append("                     A.SUB_TRD_CD  ," ).append("\n"); 
		query.append("                     MQ.RLANE_CD   ," ).append("\n"); 
		query.append("                     MQ.DIR_CD     ," ).append("\n"); 
		query.append("                     O.N2ND_PRNT_OFC_CD AS RHQ_CD     ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                     '0' AS AREA," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                     NVL(( SELECT O2.CONV_RGN_OFC_CD" ).append("\n"); 
		query.append("                                            FROM SPC_RGN_OFC_CONV O2" ).append("\n"); 
		query.append("                                           WHERE O2.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD), MQ.RGN_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("                     --MQ.RGN_OFC_CD        AS OFC_CD," ).append("\n"); 
		query.append("                     A.COST_YR||A.COST_WK AS WK    ," ).append("\n"); 
		query.append("                     A.NUM," ).append("\n"); 
		query.append("                     A.NUM_1," ).append("\n"); 
		query.append("                     MQ.VSL_CD||MQ.SKD_VOY_NO||MQ.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                     A.BSA," ).append("\n"); 
		query.append("                     (MQ.LOD_QTY) AS QTA_QTY," ).append("\n"); 
		query.append("                     0 AS QTA_GREV," ).append("\n"); 
		query.append("                     0 AS QTA_CM" ).append("\n"); 
		query.append("                FROM MAS_MON_VVD_LV   A  ," ).append("\n"); 
		query.append("                     SQM_CFM_QTA      MQ ," ).append("\n"); 
		query.append("                     SQM_QTA_RLSE_VER MQR," ).append("\n"); 
		query.append("                     SPC_OFC_LVL      O" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                 --AND MQ.POL_CD <> '00000'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq2} != '')" ).append("\n"); 
		query.append("                 AND A.RHQ_CD = O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area} != '')" ).append("\n"); 
		query.append("                 AND A.AQ_CD = MQ.AQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sales_office} != '')" ).append("\n"); 
		query.append("                 AND A.RGN_OFC_CD = NVL(( SELECT O2.CONV_RGN_OFC_CD" ).append("\n"); 
		query.append("                                            FROM SPC_RGN_OFC_CONV O2" ).append("\n"); 
		query.append("                                           WHERE O2.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD), MQ.RGN_OFC_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("                 AND A.POL_CD = '00000'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND MQR.BSE_YR          = A.BSE_YR" ).append("\n"); 
		query.append("                 --AND MQR.BSE_QTR_CD      = CEIL(TO_NUMBER(DECODE(A.COST_WK,'00','01','53','52',A.COST_WK))/13)||'Q' --CEIL(TO_NUMBER(A.COST_MON)/3)||'Q'" ).append("\n"); 
		query.append("				-- CHM-201534458 SQM QTA주가 변경 관련 적용 요청" ).append("\n"); 
		query.append("       			 AND MQR.BSE_QTR_CD      = A.BSE_QTR_CD" ).append("\n"); 
		query.append("                 AND MQR.SQM_VER_STS_CD  = 'R'" ).append("\n"); 
		query.append("                 AND MQR.BSE_TP_CD       = 'Q' -- 분기 20131205추가" ).append("\n"); 
		query.append("                 AND MQ.QTA_RLSE_VER_NO  = MQR.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("                 AND MQ.BSE_TP_CD        = MQR.BSE_TP_CD -- 분기 20131205추가 " ).append("\n"); 
		query.append("                 AND MQ.BSE_YR           = MQR.BSE_YR" ).append("\n"); 
		query.append("                 AND MQ.BSE_QTR_CD       = MQR.BSE_QTR_CD" ).append("\n"); 
		query.append("                 AND MQ.QTA_TGT_CD       = 'D'" ).append("\n"); 
		query.append("                 AND MQ.OFC_VW_CD        = 'L'  -- 20131205추가" ).append("\n"); 
		query.append("                 AND MQ.TRD_CD           = A.TRD_CD" ).append("\n"); 
		query.append("                 AND MQ.RLANE_CD         = A.RLANE_CD" ).append("\n"); 
		query.append("                 AND MQ.DIR_CD           = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND MQ.VSL_CD           = A.VSL_CD" ).append("\n"); 
		query.append("                 AND MQ.SKD_VOY_NO       = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND MQ.SKD_DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                 AND A.COST_YR || A.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                 --AND MQ.RGN_OFC_CD        = O.OFC_CD" ).append("\n"); 
		query.append("                 AND NVL((SELECT O2.CONV_RGN_OFC_CD" ).append("\n"); 
		query.append("                            FROM SPC_RGN_OFC_CONV O2" ).append("\n"); 
		query.append("                           WHERE O2.SLS_RGN_OFC_CD = MQ.RGN_OFC_CD), MQ.RGN_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("           ) R" ).append("\n"); 
		query.append("  GROUP BY R.TRD_CD    ," ).append("\n"); 
		query.append("           R.DIR_CD    ," ).append("\n"); 
		query.append("           R.SUB_TRD_CD," ).append("\n"); 
		query.append("           R.RLANE_CD  ," ).append("\n"); 
		query.append("           R.RHQ_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           R.AREA      ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           R.OFC_CD    ," ).append("\n"); 
		query.append("           R.WK        ," ).append("\n"); 
		query.append("           R.NUM       ," ).append("\n"); 
		query.append("           R.NUM_1," ).append("\n"); 
		query.append("           R.VVD       ," ).append("\n"); 
		query.append("           R.BSA" ).append("\n"); 
		query.append("    HAVING ROUND(SUM(R.QTA_QTY)) > 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCT_DATA AS (" ).append("\n"); 
		query.append("    SELECT 2 AS FLG    ," ).append("\n"); 
		query.append("           B.TRD_CD    ," ).append("\n"); 
		query.append("           B.DIR_CD    ," ).append("\n"); 
		query.append("           B.SUB_TRD_CD," ).append("\n"); 
		query.append("           B.RLANE_CD  ," ).append("\n"); 
		query.append("           B.SLS_RHQ_CD AS RHQ_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           B.TRNK_POL_CD AS AREA," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           B.SLS_RGN_OFC_CD     AS OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK AS WK    ," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           A.NUM_1," ).append("\n"); 
		query.append("           B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("           A.BSA," ).append("\n"); 
		query.append("           0 AS QTA_QTY ," ).append("\n"); 
		query.append("           0 AS QTA_GREV," ).append("\n"); 
		query.append("           0 AS QTA_CM  ," ).append("\n"); 
		query.append("           SUM(NVL(B.CFM_TTL_QTY, 0) + NVL(B.CFM_40FT_HC_QTY, 0) * 2 + NVL(B.CFM_45FT_HC_QTY, 0) * 2 + NVL(B.CFM_53FT_QTY, 0) * 2) AS FCT_QTY," ).append("\n"); 
		query.append("           0 AS FCT_GREV," ).append("\n"); 
		query.append("           0 AS FCT_CM  ," ).append("\n"); 
		query.append("           0 AS ALC_QTY ," ).append("\n"); 
		query.append("           0 AS ALC_GREV," ).append("\n"); 
		query.append("           0 AS ALC_CM  ," ).append("\n"); 
		query.append("           0 AS BKG_QTY ," ).append("\n"); 
		query.append("           0 AS BKG_GREV," ).append("\n"); 
		query.append("           0 AS BKG_CM  ," ).append("\n"); 
		query.append("           MAX(A.PAST) AS PAST" ).append("\n"); 
		query.append("      FROM MAS_MON_VVD_LV     A," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST B" ).append("\n"); 
		query.append("     WHERE A.TRD_CD      = B.TRD_CD" ).append("\n"); 
		query.append("       AND A.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("       AND A.IOC_CD      = B.IOC_TS_CD" ).append("\n"); 
		query.append("       AND A.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.DIR_CD      = B.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND A.DIR_CD      = B.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq2} != '')" ).append("\n"); 
		query.append("       AND ((     A.RHQ_CD = 'SHARC'" ).append("\n"); 
		query.append("              AND EXISTS ( SELECT 1" ).append("\n"); 
		query.append("                             FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                            WHERE SUBSTR(B.POL_YD_CD, 1, 5) = L.LOC_CD" ).append("\n"); 
		query.append("                              AND SPC_CONTI_CONV_FNC(L.CONTI_CD,A.RLANE_CD,A.DIR_CD) = 'A')" ).append("\n"); 
		query.append("                              AND A.RHQ_CD = B.SLS_RHQ_CD)  " ).append("\n"); 
		query.append("             OR A.RHQ_CD = B.SLS_RHQ_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${area} != '')" ).append("\n"); 
		query.append("       AND B.SLS_RGN_OFC_CD IN ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("                                   FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                  WHERE A.AQ_CD = O.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                                    AND A.COST_YR || A.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sales_office} != '')" ).append("\n"); 
		query.append("       AND A.RGN_OFC_CD = NVL(( SELECT T2.CONV_RGN_OFC_CD" ).append("\n"); 
		query.append("                                  FROM SPC_RGN_OFC_CONV T2" ).append("\n"); 
		query.append("                                 WHERE T2.SLS_RGN_OFC_CD = B.SLS_RGN_OFC_CD), B.SLS_RGN_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND A.POL_CD = B.POL_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("  GROUP BY B.TRD_CD        ," ).append("\n"); 
		query.append("           B.DIR_CD        ," ).append("\n"); 
		query.append("           B.SUB_TRD_CD    ," ).append("\n"); 
		query.append("           B.RLANE_CD      ," ).append("\n"); 
		query.append("           B.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           B.TRNK_POL_CD   ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           B.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           A.NUM_1," ).append("\n"); 
		query.append("           B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("           A.BSA" ).append("\n"); 
		query.append("    HAVING SUM(NVL(B.CFM_TTL_QTY, 0) + NVL(B.CFM_40FT_HC_QTY, 0) * 2 + NVL(B.CFM_45FT_HC_QTY, 0) * 2 + NVL(B.CFM_53FT_QTY, 0) * 2) > 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG_DATA AS (" ).append("\n"); 
		query.append("    SELECT 4 AS FLG    ," ).append("\n"); 
		query.append("           A.TRD_CD    ," ).append("\n"); 
		query.append("           A.DIR_CD    ," ).append("\n"); 
		query.append("           A.SUB_TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD  ," ).append("\n"); 
		query.append("           O.N2ND_PRNT_OFC_CD   AS RHQ_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           NVL(B.PRE_RLY_PORT_CD, B.POL_CD) AS AREA," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           O.N4TH_PRNT_OFC_CD   AS OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK AS WK    ," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           A.NUM_1," ).append("\n"); 
		query.append("           A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("           A.BSA," ).append("\n"); 
		query.append("           0 AS QTA_QTY ," ).append("\n"); 
		query.append("           0 AS QTA_GREV," ).append("\n"); 
		query.append("           0 AS QTA_CM  ," ).append("\n"); 
		query.append("           0 AS FCT_QTY ," ).append("\n"); 
		query.append("           0 AS FCT_GREV," ).append("\n"); 
		query.append("           0 AS FCT_CM  ," ).append("\n"); 
		query.append("           0 AS ALC_QTY ," ).append("\n"); 
		query.append("           0 AS ALC_GREV," ).append("\n"); 
		query.append("           0 AS ALC_CM  ," ).append("\n"); 
		query.append("           SUM(( SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY)" ).append("\n"); 
		query.append("                   FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                  WHERE B.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                 HAVING SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY) > 0" ).append("\n"); 
		query.append("           )) AS BKG_QTY," ).append("\n"); 
		query.append("           0 AS BKG_GREV," ).append("\n"); 
		query.append("           0 AS BKG_CM  ," ).append("\n"); 
		query.append("           MAX(A.PAST) AS PAST" ).append("\n"); 
		query.append("      FROM SPC_OFC_LVL        O  ," ).append("\n"); 
		query.append("           BKG_BOOKING        B  ," ).append("\n"); 
		query.append("           MDM_DTL_REV_LANE   DRL," ).append("\n"); 
		query.append("           MDM_REV_LANE       RL ," ).append("\n"); 
		query.append("           MAS_MON_VVD_LV     A" ).append("\n"); 
		query.append("     WHERE O.OFC_CD         = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND B.BKG_STS_CD    IN('W','F')" ).append("\n"); 
		query.append("       AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("       AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("       AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq2} != '' || ${area} != '' || ${sales_office} != '')" ).append("\n"); 
		query.append("       AND (    (A.RHQ_CD = 'SHARC' AND A.AQ_CD IS NULL AND A.RGN_OFC_CD IS NULL) " ).append("\n"); 
		query.append("             OR EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("                           FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                          WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                            AND SPC_SCR_OFC_CONV_FNC(B.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("						    AND A.RHQ_CD = O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("                            AND A.COST_YR || A.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                     CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD" ).append("\n"); 
		query.append("                             START WITH (A.RGN_OFC_CD IS NULL AND (O.PRNT_OFC_CD = A.AQ_CD OR O.PRNT_OFC_CD = A.RHQ_CD)) OR (O.OFC_CD = A.RGN_OFC_CD)))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND A.POL_CD = NVL(B.PRE_RLY_PORT_CD, B.POL_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND DRL.RLANE_CD        = A.RLANE_CD" ).append("\n"); 
		query.append("       AND DRL.VSL_SLAN_DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("       AND DRL.IOC_CD          = A.IOC_CD" ).append("\n"); 
		query.append("       AND DRL.SUB_TRD_CD      = A.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND DRL.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("       AND DRL.RLANE_CD        = RL.RLANE_CD" ).append("\n"); 
		query.append("       AND DRL.FM_CONTI_CD     =( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, A.RLANE_CD, A.DIR_CD)" ).append("\n"); 
		query.append("                                    FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                   WHERE L.LOC_CD = NVL(B.PRE_RLY_PORT_CD, B.POL_CD) )" ).append("\n"); 
		query.append("       AND DRL.TO_CONTI_CD     =( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, A.RLANE_CD, A.DIR_CD)" ).append("\n"); 
		query.append("                                    FROM MDM_LOCATION L" ).append("\n"); 
		query.append("                                   WHERE L.LOC_CD = NVL(B.PST_RLY_PORT_CD, B.POD_CD) )" ).append("\n"); 
		query.append("       AND (    ((A.RHQ_CD = 'SHARC' AND A.AQ_CD IS NULL AND A.RGN_OFC_CD IS NULL AND  A.RHQ_CD = O.N2ND_PRNT_OFC_CD) AND DRL.FM_CONTI_CD = 'A')" ).append("\n"); 
		query.append("             OR A.RHQ_CD <> 'SHARC'" ).append("\n"); 
		query.append("             OR A.AQ_CD      IS NOT NULL" ).append("\n"); 
		query.append("             OR A.RGN_OFC_CD IS NOT NULL )" ).append("\n"); 
		query.append("       AND RL.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("       AND RL.VSL_SLAN_CD = B.SLAN_CD" ).append("\n"); 
		query.append("       AND RL.VSL_TP_CD   = 'C'" ).append("\n"); 
		query.append("       AND RL.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("       AND A.COST_YR || A.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("  GROUP BY A.TRD_CD    ," ).append("\n"); 
		query.append("           A.DIR_CD    ," ).append("\n"); 
		query.append("           A.SUB_TRD_CD," ).append("\n"); 
		query.append("           A.RLANE_CD  ," ).append("\n"); 
		query.append("           O.N2ND_PRNT_OFC_CD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           NVL(B.PRE_RLY_PORT_CD, B.POL_CD)," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           O.N4TH_PRNT_OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           A.NUM_1," ).append("\n"); 
		query.append("           A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD," ).append("\n"); 
		query.append("           A.BSA" ).append("\n"); 
		query.append("    HAVING O.N4TH_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BASE_DATA AS(" ).append("\n"); 
		query.append("    SELECT TRD_CD" ).append("\n"); 
		query.append("          ,DIR_CD" ).append("\n"); 
		query.append("          ,SUB_TRD_CD" ).append("\n"); 
		query.append("          ,RLANE_CD" ).append("\n"); 
		query.append("		   -- 2014.02.11 KOREA/JAPAN AREA 분리 cateshin" ).append("\n"); 
		query.append("		  ,DECODE(Z1.OFC_CD, 'SELSC', 'KOREA' , 'TYOSC', 'JAPAN', 'VVOBA', 'E.RUSIA', Z1.RHQ_CD) AS RHQ_CD" ).append("\n"); 
		query.append("--		   Z1.RHQ_CD    ," ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("          ,Z1.AREA AS AQ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,DECODE(Z1.OFC_CD, 'SELSC', 'KOREA' , 'TYOSC', 'JAPAN', 'VVOBA', 'E.RUSIA', ( " ).append("\n"); 
		query.append("             #if(${check_area4} =='Y')" ).append("\n"); 
		query.append("             SELECT SPC_RGN_OFC_CONV_FNC(NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD),Z1.OFC_CD)" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("             SELECT SPC_RGN_OFC_CONV_FNC2(NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD), Z1.OFC_CD)             " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("               FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("              WHERE O.OFC_CD = Z1.OFC_CD" ).append("\n"); 
		query.append("                AND Z1.WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("           )) AS AQ_CD" ).append("\n"); 
		query.append("#end          " ).append("\n"); 
		query.append("          ,OFC_CD" ).append("\n"); 
		query.append("          ,WK" ).append("\n"); 
		query.append("          ,NUM" ).append("\n"); 
		query.append("#if(${checkVvd4} == 'Y')" ).append("\n"); 
		query.append("          ,DENSE_RANK() OVER(PARTITION BY TRD_CD, RLANE_CD, DIR_CD, NUM ORDER BY NUM_1) NUM_1 -- 누락되는 vvd 들이 존재해서 순번을 다시 만듬" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,'' NUM_1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,VVD" ).append("\n"); 
		query.append("          ,BSA" ).append("\n"); 
		query.append("          ,QTA_QTY" ).append("\n"); 
		query.append("          ,QTA_GREV" ).append("\n"); 
		query.append("          ,QTA_CM" ).append("\n"); 
		query.append("          ,FCT_QTY" ).append("\n"); 
		query.append("          ,FCT_GREV" ).append("\n"); 
		query.append("          ,FCT_CM" ).append("\n"); 
		query.append("          ,BKG_QTY" ).append("\n"); 
		query.append("          ,BKG_GREV" ).append("\n"); 
		query.append("          ,BKG_CM" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT TRD_CD    ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   RHQ_CD    ," ).append("\n"); 
		query.append("                   OFC_CD    ," ).append("\n"); 
		query.append("                   WK        ," ).append("\n"); 
		query.append("                   NUM       ," ).append("\n"); 
		query.append("                   NUM_1," ).append("\n"); 
		query.append("                   VVD       ," ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("           AREA      ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   BSA       ," ).append("\n"); 
		query.append("                   SUM(QTA_QTY)  AS QTA_QTY ," ).append("\n"); 
		query.append("                   SUM(QTA_GREV) AS QTA_GREV," ).append("\n"); 
		query.append("                   SUM(QTA_CM)   AS QTA_CM  ," ).append("\n"); 
		query.append("                   SUM(FCT_QTY)  AS FCT_QTY ," ).append("\n"); 
		query.append("                   SUM(FCT_GREV) AS FCT_GREV," ).append("\n"); 
		query.append("                   SUM(FCT_CM)   AS FCT_CM  ," ).append("\n"); 
		query.append("                   SUM(BKG_QTY)  AS BKG_QTY ," ).append("\n"); 
		query.append("                   SUM(BKG_GREV) AS BKG_GREV," ).append("\n"); 
		query.append("                   SUM(BKG_CM)   AS BKG_CM" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT TRD_CD    ," ).append("\n"); 
		query.append("                             DIR_CD    ," ).append("\n"); 
		query.append("                             SUB_TRD_CD," ).append("\n"); 
		query.append("                             RLANE_CD  ," ).append("\n"); 
		query.append("                             RHQ_CD    ," ).append("\n"); 
		query.append("                             OFC_CD    ," ).append("\n"); 
		query.append("                             WK        ," ).append("\n"); 
		query.append("                             NUM       ," ).append("\n"); 
		query.append("                             NUM_1," ).append("\n"); 
		query.append("                             VVD       ," ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                             AREA      ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             BSA       ," ).append("\n"); 
		query.append("                             QTA_QTY   ," ).append("\n"); 
		query.append("                             QTA_GREV  ," ).append("\n"); 
		query.append("                             QTA_CM    ," ).append("\n"); 
		query.append("                             FCT_QTY   ," ).append("\n"); 
		query.append("                             FCT_GREV  ," ).append("\n"); 
		query.append("                             FCT_CM    ," ).append("\n"); 
		query.append("                             ALC_QTY   ," ).append("\n"); 
		query.append("                             ALC_GREV  ," ).append("\n"); 
		query.append("                             ALC_CM    ," ).append("\n"); 
		query.append("                             BKG_QTY   ," ).append("\n"); 
		query.append("                             BKG_GREV  ," ).append("\n"); 
		query.append("                             BKG_CM" ).append("\n"); 
		query.append("                        FROM QTA_DATA" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT TRD_CD    ," ).append("\n"); 
		query.append("                             DIR_CD    ," ).append("\n"); 
		query.append("                             SUB_TRD_CD," ).append("\n"); 
		query.append("                             RLANE_CD  ," ).append("\n"); 
		query.append("                             RHQ_CD    ," ).append("\n"); 
		query.append("                             OFC_CD    ," ).append("\n"); 
		query.append("                             WK        ," ).append("\n"); 
		query.append("                             NUM       ," ).append("\n"); 
		query.append("                             NUM_1," ).append("\n"); 
		query.append("                             VVD       ," ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                             AREA      ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             BSA       ," ).append("\n"); 
		query.append("                             QTA_QTY   ," ).append("\n"); 
		query.append("                             QTA_GREV  ," ).append("\n"); 
		query.append("                             QTA_CM    ," ).append("\n"); 
		query.append("                             FCT_QTY  AS FCT_QTY ," ).append("\n"); 
		query.append("                             FCT_GREV AS FCT_GREV," ).append("\n"); 
		query.append("                             FCT_CM   AS FCT_CM  ," ).append("\n"); 
		query.append("                             ALC_QTY ," ).append("\n"); 
		query.append("                             ALC_GREV," ).append("\n"); 
		query.append("                             ALC_CM  ," ).append("\n"); 
		query.append("                             BKG_QTY ," ).append("\n"); 
		query.append("                             BKG_GREV," ).append("\n"); 
		query.append("                             BKG_CM" ).append("\n"); 
		query.append("                        FROM FCT_DATA" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      SELECT TRD_CD    ," ).append("\n"); 
		query.append("                             DIR_CD    ," ).append("\n"); 
		query.append("                             SUB_TRD_CD," ).append("\n"); 
		query.append("                             RLANE_CD  ," ).append("\n"); 
		query.append("                             RHQ_CD    ," ).append("\n"); 
		query.append("                             OFC_CD    ," ).append("\n"); 
		query.append("                             WK        ," ).append("\n"); 
		query.append("                             NUM       ," ).append("\n"); 
		query.append("                             NUM_1," ).append("\n"); 
		query.append("                             VVD       ," ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                             AREA      ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             BSA       ," ).append("\n"); 
		query.append("                             QTA_QTY   ," ).append("\n"); 
		query.append("                             QTA_GREV  ," ).append("\n"); 
		query.append("                             QTA_CM    ," ).append("\n"); 
		query.append("                             0 AS FCT_QTY ," ).append("\n"); 
		query.append("                             0 AS FCT_GREV," ).append("\n"); 
		query.append("                             0 AS FCT_CM  ," ).append("\n"); 
		query.append("                             ALC_QTY ," ).append("\n"); 
		query.append("                             ALC_GREV," ).append("\n"); 
		query.append("                             ALC_CM  ," ).append("\n"); 
		query.append("                             BKG_QTY ," ).append("\n"); 
		query.append("                             BKG_GREV," ).append("\n"); 
		query.append("                             BKG_CM" ).append("\n"); 
		query.append("                        FROM BKG_DATA" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("          GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("                   DIR_CD    ," ).append("\n"); 
		query.append("                   SUB_TRD_CD," ).append("\n"); 
		query.append("                   RLANE_CD  ," ).append("\n"); 
		query.append("                   RHQ_CD    ," ).append("\n"); 
		query.append("                   OFC_CD    ," ).append("\n"); 
		query.append("                   WK        ," ).append("\n"); 
		query.append("                   NUM       ," ).append("\n"); 
		query.append("                   NUM_1," ).append("\n"); 
		query.append("                   VVD       ," ).append("\n"); 
		query.append("                   BSA" ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                 , AREA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ) Z1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BASE_DATA1 AS (" ).append("\n"); 
		query.append("#if(${is_sha} == 'Y' || ${is_sel} == 'Y' || ${is_tyo} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT 1 AS BSA_AVG ," ).append("\n"); 
		query.append("           Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("#if(${trade} == 'IAS')" ).append("\n"); 
		query.append("           NVL(SPC_GET_DEST_FNC(Z1.TRD_CD, Z1.SUB_TRD_CD, Z1.RLANE_CD), '-') AS DEST," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           SPC_GET_DEST_FNC(Z1.TRD_CD, Z1.SUB_TRD_CD, Z1.RLANE_CD) AS DEST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.RHQ_CD    ," ).append("\n"); 
		query.append("           Z1.AQ_CD     ," ).append("\n"); 
		query.append("           --DECODE(Z1.OFC_CD, 'SELSC', 'SELSC', 'TYOSC', 'TYOSC', Z1.AQ_CD) AQ_CD      ," ).append("\n"); 
		query.append("           Z1.OFC_CD    ," ).append("\n"); 
		query.append("           Z1.NUM_1     ," ).append("\n"); 
		query.append("#set($primate = 'new_dur')" ).append("\n"); 
		query.append("#if(${duration} == '1')" ).append("\n"); 
		query.append("	#set($new_dur = ['1'])" ).append("\n"); 
		query.append("#elseif(${duration} == '2')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2'])" ).append("\n"); 
		query.append("#elseif(${duration} == '3')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3'])" ).append("\n"); 
		query.append("#elseif(${duration} == '4')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4'])" ).append("\n"); 
		query.append("#elseif(${duration} == '5')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5'])" ).append("\n"); 
		query.append("#elseif(${duration} == '6')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6'])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.BSA, 0), 0)) AS BSA${key} ," ).append("\n"); 
		query.append("#if(${checkVvd4} == 'Y')" ).append("\n"); 
		query.append("            MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))            AS VVD${key}1," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            MIN(DECODE(Z1.NUM, ${key}, Z1.VVD))            AS VVD${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))            AS VVD${key}2," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, Z1.QTA_QTY, 0))     AS QTA${key}1," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, Z1.FCT_QTY, 0))     AS FCT${key}1," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, Z1.BKG_QTY, 0))     AS BKG${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ''" ).append("\n"); 
		query.append("      FROM BASE_DATA Z1" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("#if(${area} != '' && ${area} != 'null')" ).append("\n"); 
		query.append("	  AND Z1.AQ_CD = @[area]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${is_sha} == 'Y')" ).append("\n"); 
		query.append("#if(${is_sel} == 'Y' && ${is_tyo} == 'N')" ).append("\n"); 
		query.append("      AND Z1.OFC_CD <> 'TYOSC'" ).append("\n"); 
		query.append("#elseif(${is_sel} == 'N' && ${is_tyo} == 'Y')" ).append("\n"); 
		query.append("      AND Z1.OFC_CD <> 'SELSC'" ).append("\n"); 
		query.append("#elseif(${is_sel} == 'N' && ${is_tyo} == 'N')" ).append("\n"); 
		query.append("      AND Z1.OFC_CD <> 'SELSC' AND Z1.OFC_CD <> 'TYOSC'" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${is_sha} == 'N')" ).append("\n"); 
		query.append("#if(${is_sel} == 'Y' && ${is_tyo} == 'N')" ).append("\n"); 
		query.append("      AND Z1.OFC_CD = 'SELSC'" ).append("\n"); 
		query.append("#elseif(${is_sel} == 'N' && ${is_tyo} == 'Y')" ).append("\n"); 
		query.append("      AND Z1.OFC_CD = 'TYOSC'" ).append("\n"); 
		query.append("#elseif(${is_sel} == 'Y' && ${is_tyo} == 'Y')" ).append("\n"); 
		query.append("      AND Z1.OFC_CD = 'SELSC' OR Z1.OFC_CD = 'TYOSC'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  GROUP BY Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           SPC_GET_DEST_FNC(Z1.TRD_CD, Z1.SUB_TRD_CD, Z1.RLANE_CD)," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.RHQ_CD    ," ).append("\n"); 
		query.append("           Z1.AQ_CD     ," ).append("\n"); 
		query.append("           Z1.OFC_CD    ," ).append("\n"); 
		query.append("           Z1.NUM_1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(( ${is_sha} == 'N' && ${is_sel} == 'Y' ) || ( ${is_sha} == 'N' && ${is_tyo} == 'Y' ))" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${is_sha} == 'N')" ).append("\n"); 
		query.append("    SELECT 1 AS BSA_AVG ," ).append("\n"); 
		query.append("           Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("#if(${trade} == 'IAS')" ).append("\n"); 
		query.append("           NVL(SPC_GET_DEST_FNC(Z1.TRD_CD, Z1.SUB_TRD_CD, Z1.RLANE_CD), '-') AS DEST," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("           SPC_GET_DEST_FNC(Z1.TRD_CD, Z1.SUB_TRD_CD, Z1.RLANE_CD) AS DEST," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.RHQ_CD    ," ).append("\n"); 
		query.append("           Z1.AQ_CD," ).append("\n"); 
		query.append("           Z1.OFC_CD    ," ).append("\n"); 
		query.append("           Z1.NUM_1     ," ).append("\n"); 
		query.append("#set($primate = 'new_dur')" ).append("\n"); 
		query.append("#if(${duration} == '1')" ).append("\n"); 
		query.append("	#set($new_dur = ['1'])" ).append("\n"); 
		query.append("#elseif(${duration} == '2')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2'])" ).append("\n"); 
		query.append("#elseif(${duration} == '3')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3'])" ).append("\n"); 
		query.append("#elseif(${duration} == '4')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4'])" ).append("\n"); 
		query.append("#elseif(${duration} == '5')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5'])" ).append("\n"); 
		query.append("#elseif(${duration} == '6')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6'])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.BSA, 0), 0)) AS BSA${key} ," ).append("\n"); 
		query.append("#if(${checkVvd4} == 'Y')" ).append("\n"); 
		query.append("            MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))            AS VVD${key}1," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            MIN(DECODE(Z1.NUM, ${key}, Z1.VVD))            AS VVD${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))            AS VVD${key}2," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, Z1.QTA_QTY, 0))     AS QTA${key}1," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, Z1.FCT_QTY, 0))     AS FCT${key}1," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, Z1.BKG_QTY, 0))     AS BKG${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ''" ).append("\n"); 
		query.append("      FROM BASE_DATA Z1" ).append("\n"); 
		query.append("      WHERE 1=1" ).append("\n"); 
		query.append("      AND Z1.RHQ_CD <> 'SHARC' " ).append("\n"); 
		query.append("      AND Z1.RHQ_CD <> 'KOREA' " ).append("\n"); 
		query.append("      AND Z1.RHQ_CD <> 'JAPAN'" ).append("\n"); 
		query.append("#if(${area} != '' && ${area} != 'null')" ).append("\n"); 
		query.append("	  AND Z1.AQ_CD = @[area]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  GROUP BY Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           SPC_GET_DEST_FNC(Z1.TRD_CD, Z1.SUB_TRD_CD, Z1.RLANE_CD)," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("           Z1.RHQ_CD    ," ).append("\n"); 
		query.append("           Z1.AQ_CD," ).append("\n"); 
		query.append("           Z1.OFC_CD    ," ).append("\n"); 
		query.append("           Z1.NUM_1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT /* + USE_MERGE(Z4 Z3) */" ).append("\n"); 
		query.append("         Z3.TRD_CD    ," ).append("\n"); 
		query.append("         Z3.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z3.RLANE_CD  ," ).append("\n"); 
		query.append("         Z3.DIR_CD    ," ).append("\n"); 
		query.append("         Z3.RHQ_CD    ," ).append("\n"); 
		query.append("         Z3.AQ_CD     ," ).append("\n"); 
		query.append("         Z3.OFC_CD    ," ).append("\n"); 
		query.append("         SPC_GET_PORT_ROTATION(Z3.RLANE_CD) AS PORT1," ).append("\n"); 
		query.append("         CNT          ," ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("         MAX(Z3.VVD${key} ) OVER (PARTITION BY Z3.TRD_CD, Z3.SUB_TRD_CD, Z3.RLANE_CD, Z3.DIR_CD, Z3.NUM_1) AS VVD${key}," ).append("\n"); 
		query.append("         Z3.BSA${key}," ).append("\n"); 
		query.append("         Z3.QTA${key}1," ).append("\n"); 
		query.append("         Z3.FCT${key}1," ).append("\n"); 
		query.append("         Z3.BKG${key}1,         " ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.QTA${key}1, 0, 0, Z3.FCT${key}1 * 100 / Z3.QTA${key}1), 0)||'%' AS FQTA${key}1," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA$key, 0, 0, Z3.FCT${key}1 * 100 / Z3.BSA$key), 0)||'%' AS FBSA${key}1," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.QTA${key}1, 0, 0, Z3.BKG${key}1 * 100 / Z3.QTA${key}1), 0)||'%' AS BQTA${key}1," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA$key, 0, 0, Z3.BKG${key}1 * 100 / Z3.BSA$key), 0)||'%' AS BBSA${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         '' AS T" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT NVL(( SELECT SUM(BSA) / COUNT(1) AS BSA" ).append("\n"); 
		query.append("                           FROM MAS_MON_VVD_LV L" ).append("\n"); 
		query.append("                          WHERE L.SUB_TRD_CD = Z2.SUB_TRD_CD" ).append("\n"); 
		query.append("                            AND L.RLANE_CD   = Z2.RLANE_CD" ).append("\n"); 
		query.append("                      ), 0) AS BSA_AVG," ).append("\n"); 
		query.append("                   NVL(Z2.TRD_CD    , 'TOTAL') AS TRD_CD    ," ).append("\n"); 
		query.append("                   NVL(Z2.SUB_TRD_CD, 'TOTAL') AS SUB_TRD_CD," ).append("\n"); 
		query.append("                   NVL(Z2.RLANE_CD  , 'TOTAL') AS RLANE_CD  ," ).append("\n"); 
		query.append("                   NVL(Z2.DIR_CD    , 'TOTAL') AS DIR_CD    ," ).append("\n"); 
		query.append("                   NVL(Z2.RHQ_CD     , '+')    AS RHQ_CD    ," ).append("\n"); 
		query.append("                   NVL(Z2.AQ_CD     , '+')     AS AQ_CD     ," ).append("\n"); 
		query.append("                   NVL(Z2.OFC_CD    , '+')     AS OFC_CD    ," ).append("\n"); 
		query.append("#if(${checkVvd4} == 'Y')" ).append("\n"); 
		query.append("                   Z2.NUM_1," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                   '' NUM_1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                   MAX(Z2.BSA${key}) AS BSA${key}," ).append("\n"); 
		query.append("                   MAX(DECODE((NVL(Z2.VVD${key}1, ' ')), (NVL(Z2.VVD${key}2, ' ')), Z2.VVD${key}1, Z2.VVD${key}2||'/'||Z2.VVD${key}1)) AS VVD${key}," ).append("\n"); 
		query.append("                   SUM(Z2.QTA${key}1) AS QTA${key}1," ).append("\n"); 
		query.append("                   SUM(Z2.FCT${key}1) AS FCT${key}1," ).append("\n"); 
		query.append("                   SUM(Z2.BKG${key}1) AS BKG${key}1," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   CASE" ).append("\n"); 
		query.append("                        WHEN (Z2.RHQ_CD IS NULL AND Z2.AQ_CD IS NULL) OR (Z2.DIR_CD IS NOT NULL AND Z2.OFC_CD IS NOT NULL) THEN COUNT(1) * CASE" ).append("\n"); 
		query.append("                                                                                                                        WHEN Z2.OFC_CD IS NOT NULL THEN -1" ).append("\n"); 
		query.append("                                                                                                                        WHEN Z2.RHQ_CD IS NULL AND Z2.AQ_CD IS NULL AND Z2.DIR_CD IS NOT NULL AND Z2.RLANE_CD IS NULL THEN 0" ).append("\n"); 
		query.append("                                                                                                                        ELSE 1" ).append("\n"); 
		query.append("                                                                                                                    END" ).append("\n"); 
		query.append("                        WHEN Z2.RHQ_CD IS NOT NULL AND Z2.AQ_CD IS NOT NULL AND Z2.DIR_CD IS NULL AND Z2.RLANE_CD IS NULL AND Z2.OFC_CD IS NOT NULL THEN COUNT(1) * -1     " ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                    END AS CNT" ).append("\n"); 
		query.append("              FROM BASE_DATA1 Z2" ).append("\n"); 
		query.append("          GROUP BY" ).append("\n"); 
		query.append("#if (${subtrade1} == '')" ).append("\n"); 
		query.append("                    Z2.TRD_CD," ).append("\n"); 
		query.append("                    CUBE(Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.DIR_CD, Z2.RHQ_CD, Z2.AQ_CD, Z2.OFC_CD #if(${checkVvd4} == 'Y') ,Z2.NUM_1 #end)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                    Z2.TRD_CD," ).append("\n"); 
		query.append("                    Z2.SUB_TRD_CD," ).append("\n"); 
		query.append("                    CUBE(Z2.RLANE_CD, Z2.DIR_CD, Z2.RHQ_CD, Z2.AQ_CD, Z2.OFC_CD #if(${checkVvd4} == 'Y') ,Z2.NUM_1 #end)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("            HAVING     (NOT (RHQ_CD IS NULL AND AQ_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (AQ_CD IS NULL AND OFC_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (RLANE_CD IS NOT NULL AND DIR_CD IS NULL))" ).append("\n"); 
		query.append("                   AND (NOT (RLANE_CD IS NULL AND DIR_CD IS NOT NULL AND RHQ_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NOT NULL AND RLANE_CD IS NULL AND DIR_CD IS NOT NULL AND AQ_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NULL AND RLANE_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NULL AND RLANE_CD IS NULL AND DIR_CD IS NOT NULL AND AQ_CD IS NOT NULL))" ).append("\n"); 
		query.append("#if(${checkVvd4} == 'Y')" ).append("\n"); 
		query.append("                    AND (NOT (TRD_CD IS NOT NULL AND SUB_TRD_CD IS NOT NULL AND RLANE_CD IS NOT NULL AND DIR_CD IS NOT NULL AND NUM_1 IS     NULL))" ).append("\n"); 
		query.append("                    AND (NOT (TRD_CD IS NOT NULL AND SUB_TRD_CD IS NOT NULL AND RLANE_CD IS     NULL AND DIR_CD IS NOT NULL AND NUM_1 IS NOT NULL))" ).append("\n"); 
		query.append("                    AND (NOT (TRD_CD IS NOT NULL AND SUB_TRD_CD IS NOT NULL AND RLANE_CD IS     NULL AND DIR_CD IS     NULL AND NUM_1 IS NOT NULL))" ).append("\n"); 
		query.append("                    AND (NOT (TRD_CD IS NOT NULL AND SUB_TRD_CD IS     NULL AND RLANE_CD IS     NULL AND DIR_CD IS NOT NULL AND NUM_1 IS NOT NULL))" ).append("\n"); 
		query.append("                    AND (NOT (TRD_CD IS NOT NULL AND SUB_TRD_CD IS     NULL AND RLANE_CD IS     NULL AND DIR_CD IS     NULL AND NUM_1 IS NOT NULL))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) Z3" ).append("\n"); 
		query.append("ORDER BY DECODE(Z3.SUB_TRD_CD, 'TOTAL', '00', Z3.SUB_TRD_CD) DESC," ).append("\n"); 
		query.append("         Z3.BSA_AVG DESC," ).append("\n"); 
		query.append("         DECODE(Z3.RLANE_CD, 'TOTAL', 'ZZZZZ', Z3.RLANE_CD)," ).append("\n"); 
		query.append("         DECODE(Z3.DIR_CD  , 'TOTAL', DECODE(Z3.RHQ_CD, '+', 'Z', '1'), Z3.DIR_CD)," ).append("\n"); 
		query.append("         Z3.NUM_1," ).append("\n"); 
		query.append("         DECODE(Z3.RHQ_CD  , 'TOTAL', 'Z', '+', 'Y', 'KOREA', '1', 'JAPAN', '2', Z3.RHQ_CD)," ).append("\n"); 
		query.append("         DECODE(Z3.AQ_CD   , 'TOTAL', DECODE(Z3.RLANE_CD, 'TOTAL', 'ZZZZZ', 'ZZZZ')," ).append("\n"); 
		query.append("#if (${chkview} == 'P')" ).append("\n"); 
		query.append("                                                                                      Z3.AQ_CD)," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("         DECODE(Z3.AQ_CD, NULL, 'Z', '+', 'Y', 'SHADNC', '1', 'SZPDC', '2', 'SHARC','3','KOREA', '4', 'JAPAN', '5', 'TAIWAN', '6','SHADKJ', '7', 'SINDSA', '8', 'SINDPI', '9', 'E.RUSIA', '10', Z3.AQ_CD))," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         DECODE(Z3.OFC_CD, 'TOTAL', 'ZZZZZ', '+', 'ZZZZ', Z3.OFC_CD)" ).append("\n"); 

	}
}