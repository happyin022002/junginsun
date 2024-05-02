/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL.java
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

public class SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.01 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
	  * 2010.12.21 최윤성 [CHM-201007718-01] L/F Summary 화면 BKG 로직 수정
	  * 2011.01.04 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2011.01.19 최윤성 [CHM-201108422-01] L/F Summary 화면 하드코딩 및 보완 요청
	  *  - IAS/IP sub-trade 에 한하여 BSA 는 Full BKG volume 과 동일하게 보여지도록 수정
	  *  - IAS 한하여 Empty 값은 From ~ To 의 Conti 가 모두 A 인 값만 보이고 나머지는 0.
	  *  - 화면에 주차별로 display 된 데이터의 총합을 보여주는 열 추가.
	  * 2011.05.24 김종준 [CHM-201111032-01] L/F Summary 화면 로직 보완
	  *   - Daily F"cast Status 화면과 동일하도록 로직 보완 
	  *   - RHQ 선택시 loading office 뿐만이 아니라 From conti 까지 일치 하는 BKG 정보만 가지고 오도록 추가
	  * 2012.12.10 김시몬 [CHM-201221639]  SQL 튜닝 - USE_HASH(A2, A1, A3, A4) PARALLEL(A2, A4) 삭제
	  * 2014.07.14 Arie Im [CHM-201431072]  L/F summary 메뉴 로직 수정
	  * 2014.08.07 김시몬 L/F summary 메뉴 로직 수정
	  * 2015.12.03 이혜민 [CHM-201538975] VVOBA Office 관련 수정
	  * 2017.1.23 SM상선 전환에 따른 소스변경
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL(){
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
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_month",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL").append("\n"); 
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
		query.append("WITH BSA_FULL AS (" ).append("\n"); 
		query.append("    SELECT TRD_CD    , " ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           NUM       ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD       ," ).append("\n"); 
		query.append("           SLAN_CD   ," ).append("\n"); 
		query.append("           FULL      ,FULL_WGT      ," ).append("\n"); 
		query.append("           ROUND(MAS_BSA, 10) AS BSA" ).append("\n"); 
		query.append("		   ,ROUND(BSA_WGT, 10) AS BSA_WGT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT TRD_CD    ," ).append("\n"); 
		query.append("                     SUB_TRD_CD," ).append("\n"); 
		query.append("                     RLANE_CD  ," ).append("\n"); 
		query.append("                     DIR_CD    ," ).append("\n"); 
		query.append("                     COST_YR   ," ).append("\n"); 
		query.append("                     COST_MON  ," ).append("\n"); 
		query.append("                     NUM       ," ).append("\n"); 
		query.append("                     COST_WK   ," ).append("\n"); 
		query.append("                     VSL_CD    ," ).append("\n"); 
		query.append("                     SKD_VOY_NO," ).append("\n"); 
		query.append("                     SKD_DIR_CD," ).append("\n"); 
		query.append("                     VVD       ," ).append("\n"); 
		query.append("                     SLAN_CD   ," ).append("\n"); 
		query.append("                     NVL(SUM(MAS_QTY), 0)      AS FULL   ," ).append("\n"); 
		query.append("                     NVL(SUM(MAS_WGT), 0)      AS FULL_WGT   , " ).append("\n"); 
		query.append("                     NVL(SUM(VVD_BSA_CAPA), 0) AS MAS_BSA," ).append("\n"); 
		query.append("					 NVL(SUM(BSA_WGT), 0) AS BSA_WGT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT --/*+ USE_HASH(A2, A1, A3, A4) PARALLEL(A2, A4) */ -- 2012.12.10 SQL 튜닝으로 제거" ).append("\n"); 
		query.append("                               A1.TRD_CD    ," ).append("\n"); 
		query.append("                               A1.SUB_TRD_CD," ).append("\n"); 
		query.append("                               A1.RLANE_CD  ," ).append("\n"); 
		query.append("                               A1.DIR_CD    ," ).append("\n"); 
		query.append("                               SUBSTR(A1.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("                               SUBSTR(A1.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("                               P.RNUM AS NUM," ).append("\n"); 
		query.append("                               A1.COST_WK   ," ).append("\n"); 
		query.append("                               A1.VSL_CD    ," ).append("\n"); 
		query.append("                               A1.SKD_VOY_NO," ).append("\n"); 
		query.append("                               A1.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("                               A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD AS VVD," ).append("\n"); 
		query.append("                               A1.SLAN_CD   ," ).append("\n"); 
		query.append("                               NVL(A3.LOD_SPL_CNG_FLG,'N') AS LOD_SPL_CNG_FLG," ).append("\n"); 
		query.append("                               DECODE(NVL(A3.LOD_SPL_CNG_FLG,'N'), 'Y', SUM(DECODE(SPC_GET_CNTR_SZ_FNC(A2.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                                                                 , '2', NVL(A2.BKG_QTY, 0), NVL(A2.BKG_QTY, 0) * 2))" ).append("\n"); 
		query.append("                                                                 , 'N', MAX(A1.VVD_BSA_CAPA)" ).append("\n"); 
		query.append("                               ) AS VVD_BSA_CAPA," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					 		   SUM(DECODE(SPC_GET_CNTR_SZ_FNC(A2.SPCL_CNTR_TPSZ_CD),'2', A2.BKG_QTY, '3', A2.BKG_QTY, A2.BKG_QTY*2)) AS MAS_QTY" ).append("\n"); 
		query.append("							, MAX(SPC_GET_WK_VVD_BSA_FNC('WGT', A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD, SUBSTR(A1.COST_YRMON, 1, 4)||A1.COST_WK, A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD)) AS BSA_WGT " ).append("\n"); 
		query.append("                             " ).append("\n"); 
		query.append("                             ,(TO_CHAR((MAX(A2.BKG_CGO_WGT) * DECODE(MAX(A2.BKG_WGT_TP_CD), 'LBS', 0.00045, 0.001))" ).append("\n"); 
		query.append("                              + SUM(A2.BKG_QTY * (SELECT TS.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ TS WHERE TS.CNTR_TPSZ_CD = A2.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                             ) AS MAS_WGT" ).append("\n"); 
		query.append("                         FROM  MAS_MON_VVD   A1," ).append("\n"); 
		query.append("                               MAS_BKG_EXPN_DTL_WK A2," ).append("\n"); 
		query.append("                               MAS_LANE_RGST A3," ).append("\n"); 
		query.append("							   --SPC_OFC_LVL   A4," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT /*+ INDEX (P XPKMAS_WK_PRD)*/" ).append("\n"); 
		query.append("                                         P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                                         ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                                    FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                                   WHERE P.COST_YR > ' '" ).append("\n"); 
		query.append("                                     AND P.COST_WK > ' '" ).append("\n"); 
		query.append("                                     AND P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                     AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("                               ) P" ).append("\n"); 
		query.append("                         WHERE A1.TRD_CD              = A2.TRD_CD" ).append("\n"); 
		query.append("                           AND A1.RLANE_CD            = A2.RLANE_CD" ).append("\n"); 
		query.append("                           AND A1.IOC_CD              = A2.IOC_CD" ).append("\n"); 
		query.append("                           AND A1.VSL_CD              = A2.VSL_CD" ).append("\n"); 
		query.append("                           AND A1.SKD_VOY_NO          = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A1.DIR_CD              = A2.DIR_CD" ).append("\n"); 
		query.append("                           AND A1.TRD_CD              = A3.TRD_CD" ).append("\n"); 
		query.append("                           AND A1.RLANE_CD            = A3.RLANE_CD" ).append("\n"); 
		query.append("                           AND A1.IOC_CD              = A3.IOC_CD" ).append("\n"); 
		query.append("                           AND A1.DIR_CD              = A3.DIR_CD" ).append("\n"); 
		query.append("                           AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("                           AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = SUBSTR(A2.SLS_YRMON, 1, 4)||A2.COST_WK" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("                           AND A1.COST_YRMON              = @[rev_month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           --AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = A2.BKG_WK" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("                           AND A2.BKG_STS_CD         IN ('F','S')" ).append("\n"); 
		query.append("                           AND A2.BKG_CGO_TP_CD      <> 'P'" ).append("\n"); 
		query.append("                           AND A2.BL_NO_TP           IN ('M','0')" ).append("\n"); 
		query.append("                           AND A1.TRD_CD              = @[trade]" ).append("\n"); 
		query.append("                           --AND A4.OFC_TP_CD          IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           --AND A4.OFC_CD              = SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD)" ).append("\n"); 
		query.append("                           --AND P.COST_YRWK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("    #if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("                              AND A2.RHQ_CD IN ('SHARC', 'SINRS', 'TYOIB', 'SELIB', 'VVOIA')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                              AND A2.RHQ_CD IN @[rhq]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    #if (${rhq} != '')" ).append("\n"); 
		query.append("	    #if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("							AND (SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                          WHERE A4.N2ND_PRNT_OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("                                                                            AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                            AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("							    OR EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("							                  FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("							                 WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("							                   AND SPC_SCR_OFC_CONV_FNC(A2.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("							                   AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("							               CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD " ).append("\n"); 
		query.append("							                 START WITH O.PRNT_OFC_CD ='SINRS' )" ).append("\n"); 
		query.append("							   )							               " ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("						   AND EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                         WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                           AND SPC_SCR_OFC_CONV_FNC(A2.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("                                           AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                       CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD" ).append("\n"); 
		query.append("                                                 START WITH O.PRNT_OFC_CD = @[rhq] )" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${rhq} != '')" ).append("\n"); 
		query.append("	    #if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("	                       AND (( SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                            FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                           WHERE A4.N2ND_PRNT_OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("                                                                             AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                             AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("	                            AND 'A' = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, A1.RLANE_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("                                              FROM MDM_LOCATION L, BKG_BOOKING B" ).append("\n"); 
		query.append("                                             WHERE L.LOC_CD = NVL(B.PRE_RLY_PORT_CD, B.POL_CD)" ).append("\n"); 
		query.append("                                               AND B.BKG_NO = A2.BKG_NO ))" ).append("\n"); 
		query.append("                                OR SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                             FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                            WHERE A4.N2ND_PRNT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                                                              AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                              AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )                               " ).append("\n"); 
		query.append("                               )    " ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("						   AND SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                         FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                        WHERE A4.N2ND_PRNT_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("                                                                          AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                          AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("                           AND A1.SUB_TRD_CD          = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("                           AND A1.DIR_CD              = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      GROUP BY A1.TRD_CD    ," ).append("\n"); 
		query.append("                               A1.SUB_TRD_CD," ).append("\n"); 
		query.append("                               A1.RLANE_CD  ," ).append("\n"); 
		query.append("                               A1.DIR_CD    ," ).append("\n"); 
		query.append("                               SUBSTR(A1.SLS_YRMON, 1, 4)," ).append("\n"); 
		query.append("                               SUBSTR(A1.SLS_YRMON, 5)   ," ).append("\n"); 
		query.append("                               P.RNUM       ," ).append("\n"); 
		query.append("                               A1.COST_WK   ," ).append("\n"); 
		query.append("                               A1.VSL_CD    ," ).append("\n"); 
		query.append("                               A1.SKD_VOY_NO," ).append("\n"); 
		query.append("                               A1.DIR_CD    ," ).append("\n"); 
		query.append("                               A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD," ).append("\n"); 
		query.append("                               A1.SLAN_CD   ," ).append("\n"); 
		query.append("                               NVL(A3.LOD_SPL_CNG_FLG, 'N')" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("            GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("                     SUB_TRD_CD," ).append("\n"); 
		query.append("                     RLANE_CD  ," ).append("\n"); 
		query.append("                     DIR_CD    ," ).append("\n"); 
		query.append("                     COST_YR   ," ).append("\n"); 
		query.append("                     COST_MON  ," ).append("\n"); 
		query.append("                     NUM       ," ).append("\n"); 
		query.append("                     COST_WK   ," ).append("\n"); 
		query.append("                     VSL_CD    ," ).append("\n"); 
		query.append("                     SKD_VOY_NO," ).append("\n"); 
		query.append("                     SKD_DIR_CD," ).append("\n"); 
		query.append("                     VVD       ," ).append("\n"); 
		query.append("                     SLAN_CD" ).append("\n"); 
		query.append("            ORDER BY TRD_CD    ," ).append("\n"); 
		query.append("                     SUB_TRD_CD," ).append("\n"); 
		query.append("                     RLANE_CD  ," ).append("\n"); 
		query.append("                     DIR_CD    ," ).append("\n"); 
		query.append("                     COST_YR   ," ).append("\n"); 
		query.append("                     COST_MON  ," ).append("\n"); 
		query.append("                     NUM       ," ).append("\n"); 
		query.append("                     COST_WK   ," ).append("\n"); 
		query.append("                     VSL_CD    ," ).append("\n"); 
		query.append("                     SKD_VOY_NO," ).append("\n"); 
		query.append("                     SKD_DIR_CD," ).append("\n"); 
		query.append("                     VVD       ," ).append("\n"); 
		query.append("                     SLAN_CD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     WHERE FULL + MAS_BSA <> 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", RDR_MTY AS (" ).append("\n"); 
		query.append("    SELECT C.TRD_CD    ," ).append("\n"); 
		query.append("           C.SUB_TRD_CD," ).append("\n"); 
		query.append("           C.RLANE_CD  ," ).append("\n"); 
		query.append("           C.DIR_CD    ," ).append("\n"); 
		query.append("           SUBSTR(C.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("           SUBSTR(c.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("           P.RNUM AS NUM," ).append("\n"); 
		query.append("           C.COST_WK   ," ).append("\n"); 
		query.append("           C.VSL_CD    ," ).append("\n"); 
		query.append("           C.SKD_VOY_NO," ).append("\n"); 
		query.append("           C.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           C.VSL_CD||C.SKD_VOY_NO||C.DIR_CD AS VVD," ).append("\n"); 
		query.append("           C.SLAN_CD   ," ).append("\n"); 
		query.append("           SUM(M.SLOT_QTY) AS EMPTY, SUM(M.WEIGHT) AS EMPTY_WGT, " ).append("\n"); 
		query.append("           MAX(C.VVD_BSA_CAPA) AS BSA -- 2014.07.14 [CHM-201431072]   " ).append("\n"); 
		query.append("		   ,MAX(NVL(B.BSA_WGT, 0)) AS BSA_WGT" ).append("\n"); 
		query.append("     FROM  RDR_HEADER  H," ).append("\n"); 
		query.append("           RDR_UTILIZE M," ).append("\n"); 
		query.append("		   RDR_ALLOCATION B," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("              SELECT /*+ INDEX (P XPKMAS_WK_PRD)*/" ).append("\n"); 
		query.append("                     P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                     ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("               WHERE P.COST_YR > ' '" ).append("\n"); 
		query.append("                 AND P.COST_WK > ' '" ).append("\n"); 
		query.append("                 AND P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                 AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("           ) P," ).append("\n"); 
		query.append("           MAS_MON_VVD C" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND SUBSTR(C.SLS_YRMON, 1, 4)||C.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("#if (${mon_flg} == 'Y')" ).append("\n"); 
		query.append("       AND C.COST_YRMON              = @[rev_month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND (C.DELT_FLG IS NULL OR C.DELT_FLG = 'N')" ).append("\n"); 
		query.append("       AND C.IOC_CD     = 'O'" ).append("\n"); 
		query.append("       AND M.OPR_CD     = 'SML'" ).append("\n"); 
		query.append("       AND M.TYPE       = 'E'" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND C.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("       AND M.VSL_CD = B.VSL_CD (+)" ).append("\n"); 
		query.append("	   AND M.VOY_NO = B.VOY_NO (+)" ).append("\n"); 
		query.append("	   AND M.DIR_CD = B.DIR_CD (+)" ).append("\n"); 
		query.append("	   AND M.OPR_CD = B.OPR_CD (+)" ).append("\n"); 
		query.append("	   AND M.REGION = B.REGION (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("       AND C.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("       AND C.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("       AND M.REGION    IN ('A', 'D', 'F')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${rhq} == 'NYCRA')" ).append("\n"); 
		query.append("       AND M.REGION    IN ('M', 'S')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("       AND M.REGION     = DECODE(@[rhq], 'HAMRU', 'E', '')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND H.VSL_CD     = M.VSL_CD" ).append("\n"); 
		query.append("       AND H.VOY_NO     = M.VOY_NO" ).append("\n"); 
		query.append("       AND H.DIR_CD     = M.DIR_CD" ).append("\n"); 
		query.append("       AND H.REGION     = M.REGION" ).append("\n"); 
		query.append("       AND H.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("       AND H.VOY_NO     = C.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND H.DIR_CD     = C.DIR_CD" ).append("\n"); 
		query.append("  GROUP BY C.TRD_CD    ," ).append("\n"); 
		query.append("           C.SUB_TRD_CD," ).append("\n"); 
		query.append("           C.RLANE_CD  ," ).append("\n"); 
		query.append("           C.DIR_CD    ," ).append("\n"); 
		query.append("           SUBSTR(C.SLS_YRMON, 1, 4)," ).append("\n"); 
		query.append("           SUBSTR(C.SLS_YRMON, 5)   ," ).append("\n"); 
		query.append("           P.RNUM      ," ).append("\n"); 
		query.append("           C.COST_WK   ," ).append("\n"); 
		query.append("           C.VSL_CD    ," ).append("\n"); 
		query.append("           C.SKD_VOY_NO," ).append("\n"); 
		query.append("           C.DIR_CD    ," ).append("\n"); 
		query.append("           C.VSL_CD||C.SKD_VOY_NO||C.DIR_CD," ).append("\n"); 
		query.append("           C.SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${trade} == 'IAS' || ${trade} == 'IES' || ${trade} == 'IMS')" ).append("\n"); 
		query.append(", INTRA_MTY AS (" ).append("\n"); 
		query.append("    SELECT TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           NUM       ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD       ," ).append("\n"); 
		query.append("           SLAN_CD   ," ).append("\n"); 
		query.append("           SUM(MTY) AS EMPTY" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("                     M.SUB_TRD_CD," ).append("\n"); 
		query.append("                     M.RLANE_CD  ," ).append("\n"); 
		query.append("                     M.DIR_CD    ," ).append("\n"); 
		query.append("                     M.COST_YR ," ).append("\n"); 
		query.append("                     M.COST_MON," ).append("\n"); 
		query.append("                     M.NUM," ).append("\n"); 
		query.append("                     M.COST_WK   ," ).append("\n"); 
		query.append("                     M.VSL_CD    ," ).append("\n"); 
		query.append("                     M.SKD_VOY_NO," ).append("\n"); 
		query.append("                     M.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("                     M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD AS VVD," ).append("\n"); 
		query.append("                     M.SLAN_CD   ," ).append("\n"); 
		query.append("                     NVL(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SPC_GET_CNTR_SZ_FNC(CNTR_TPSZ_CD), '2', OP_CNTR_QTY, OP_CNTR_QTY * 2)),0) AS MTY" ).append("\n"); 
		query.append("                FROM BKG_BOOKING  BKG," ).append("\n"); 
		query.append("                     BKG_VVD      VVD," ).append("\n"); 
		query.append("                     BKG_QUANTITY QUA," ).append("\n"); 
		query.append("                     MDM_LOCATION ORG," ).append("\n"); 
		query.append("                     MDM_LOCATION DES," ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("                        SELECT M.VSL_CD,  " ).append("\n"); 
		query.append("							   M.SKD_VOY_NO, " ).append("\n"); 
		query.append("							   M.DIR_CD, " ).append("\n"); 
		query.append("							   M.TRD_CD, " ).append("\n"); 
		query.append("							   M.SUB_TRD_CD," ).append("\n"); 
		query.append("							   M.RLANE_CD, " ).append("\n"); 
		query.append("							   P.COST_YRWK," ).append("\n"); 
		query.append("                               SUBSTR(M.SLS_YRMON, 1, 4) AS COST_YR ," ).append("\n"); 
		query.append("                               SUBSTR(M.SLS_YRMON, 5)    AS COST_MON," ).append("\n"); 
		query.append("                               P.RNUM AS NUM," ).append("\n"); 
		query.append("                               M.COST_WK   ," ).append("\n"); 
		query.append("                               M.SLAN_CD" ).append("\n"); 
		query.append("                        FROM " ).append("\n"); 
		query.append("                             MAS_MON_VVD  M," ).append("\n"); 
		query.append("                             (" ).append("\n"); 
		query.append("                               SELECT /*+ INDEX (P XPKMAS_WK_PRD)*/" ).append("\n"); 
		query.append("                                      P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                                      ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                                 FROM MAS_WK_PRD P" ).append("\n"); 
		query.append("                                WHERE P.COST_YR > ' '" ).append("\n"); 
		query.append("                                  AND P.COST_WK > ' '" ).append("\n"); 
		query.append("                                  AND P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                  AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("                             ) P" ).append("\n"); 
		query.append("                        WHERE SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("                          AND NVL(M.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                          AND M.WKY_TGT_FLG   = 'Y'" ).append("\n"); 
		query.append("                 		  AND M.TRD_CD        = @[trade]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("                 		  AND M.SUB_TRD_CD    = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("                 		  AND M.DIR_CD        = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    ) M" ).append("\n"); 
		query.append("               WHERE BKG.BKG_NO      = VVD.BKG_NO" ).append("\n"); 
		query.append("                 AND BKG.BKG_NO      = QUA.BKG_NO" ).append("\n"); 
		query.append("                 AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("                 AND BKG.POL_CD      = ORG.LOC_CD" ).append("\n"); 
		query.append("                 AND BKG.POD_CD      = DES.LOC_CD" ).append("\n"); 
		query.append("                 AND SPC_CONTI_CONV_FNC(ORG.CONTI_CD, M.RLANE_CD, M.DIR_CD) = DECODE(M.TRD_CD||M.SUB_TRD_CD, 'IASIA', 'A'," ).append("\n"); 
		query.append("                                                                                                             'IASIP', 'A'," ).append("\n"); 
		query.append("                                                                                                             'IMSIP', 'M'," ).append("\n"); 
		query.append("                                                                                                             'IESIP', 'E'," ).append("\n"); 
		query.append("                                                                                                             SPC_CONTI_CONV_FNC(ORG.CONTI_CD, M.RLANE_CD, M.DIR_CD))" ).append("\n"); 
		query.append("                 AND SPC_CONTI_CONV_FNC(DES.CONTI_CD, M.RLANE_CD, M.DIR_CD) = DECODE(M.TRD_CD||M.SUB_TRD_CD, 'IASIA', 'A'," ).append("\n"); 
		query.append("                                                                                                             'IASIP', 'A'," ).append("\n"); 
		query.append("                                                                                                             'IMSIP', 'M'," ).append("\n"); 
		query.append("                                                                                                             'IESIP', 'E'," ).append("\n"); 
		query.append("                                                                                                             SPC_CONTI_CONV_FNC(DES.CONTI_CD, M.RLANE_CD, M.DIR_CD))" ).append("\n"); 
		query.append("                 AND VVD.VSL_CD      = M.VSL_CD" ).append("\n"); 
		query.append("                 AND VVD.SKD_VOY_NO  = M.SKD_VOY_NO" ).append("\n"); 
		query.append("                 AND VVD.SKD_DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("                 --AND (M.DELT_FLG IS NULL OR M.DELT_FLG = 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 --AND SKD.VSL_CD      = M.VSL_CD " ).append("\n"); 
		query.append("                 --AND SKD.SKD_VOY_NO  = M.SKD_VOY_NO" ).append("\n"); 
		query.append("                 --AND SKD.SKD_DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("                 --AND SKD.SLAN_CD     = M.SLAN_CD" ).append("\n"); 
		query.append("              	AND EXISTS (SELECT 'X' FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("             				 WHERE SKD.VSL_CD     = M.VSL_CD " ).append("\n"); 
		query.append("             				   AND SKD.SKD_VOY_NO = M.SKD_VOY_NO" ).append("\n"); 
		query.append("           					   AND SKD.SKD_DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("           					   AND SKD.SLAN_CD    = M.SLAN_CD" ).append("\n"); 
		query.append("           					   AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 --AND M.WKY_TGT_FLG   = 'Y'" ).append("\n"); 
		query.append("                 --AND SPC_SCR_OFC_CONV_FNC(BKG.OB_SLS_OFC_CD)  = O.OFC_CD" ).append("\n"); 
		query.append("                 --AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                AND SPC_SCR_OFC_CONV_FNC(BKG.OB_SLS_OFC_CD) IN (SELECT OFC_CD " ).append("\n"); 
		query.append("																  FROM SPC_OFC_LVL " ).append("\n"); 
		query.append("																 WHERE 1=1" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("	#if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("						   										   AND N2ND_PRNT_OFC_CD		IN ('SHARC', 'SINRS')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("															       AND N2ND_PRNT_OFC_CD    IN @[rhq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                   AND M.COST_YRWK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK)" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     WHERE MTY > 0" ).append("\n"); 
		query.append("  GROUP BY TRD_CD    ," ).append("\n"); 
		query.append("           SUB_TRD_CD," ).append("\n"); 
		query.append("           RLANE_CD  ," ).append("\n"); 
		query.append("           DIR_CD    ," ).append("\n"); 
		query.append("           COST_YR   ," ).append("\n"); 
		query.append("           COST_MON  ," ).append("\n"); 
		query.append("           NUM       ," ).append("\n"); 
		query.append("           COST_WK   ," ).append("\n"); 
		query.append("           VSL_CD    ," ).append("\n"); 
		query.append("           SKD_VOY_NO," ).append("\n"); 
		query.append("           SKD_DIR_CD," ).append("\n"); 
		query.append("           VVD       ," ).append("\n"); 
		query.append("           SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BASE_DATA AS (" ).append("\n"); 
		query.append("    SELECT TRD_CD" ).append("\n"); 
		query.append("         , SUB_TRD_CD" ).append("\n"); 
		query.append("         , RLANE_CD" ).append("\n"); 
		query.append("         , DIR_CD" ).append("\n"); 
		query.append("         , COST_YR" ).append("\n"); 
		query.append("         , COST_MON" ).append("\n"); 
		query.append("         , NUM" ).append("\n"); 
		query.append("         , COST_WK" ).append("\n"); 
		query.append("         , VSL_CD" ).append("\n"); 
		query.append("         , SKD_VOY_NO" ).append("\n"); 
		query.append("         , SKD_DIR_CD" ).append("\n"); 
		query.append("         , VVD" ).append("\n"); 
		query.append("         , SLAN_CD" ).append("\n"); 
		query.append("         , MAX(BSA) BSA , MAX(DECODE(BSA_WGT,0, FULL_WGT+EMPTY_WGT,BSA_WGT)) BSA_WGT" ).append("\n"); 
		query.append("         , MAX(FULL) FULL, MAX(FULL_WGT) FULL_WGT" ).append("\n"); 
		query.append("         , MAX(EMPTY) EMPTY, MAX(EMPTY_WGT) EMPTY_WGT" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT 'BSA_FULL' AS TY," ).append("\n"); 
		query.append("               TRD_CD    ," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD  ," ).append("\n"); 
		query.append("               DIR_CD    ," ).append("\n"); 
		query.append("               COST_YR   ," ).append("\n"); 
		query.append("               COST_MON  ," ).append("\n"); 
		query.append("               NUM       ," ).append("\n"); 
		query.append("               COST_WK   ," ).append("\n"); 
		query.append("               VSL_CD    ," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               VVD       ," ).append("\n"); 
		query.append("               SLAN_CD   ," ).append("\n"); 
		query.append("               BSA       ,BSA_WGT," ).append("\n"); 
		query.append("               FULL      ,FULL_WGT," ).append("\n"); 
		query.append("               0 AS EMPTY," ).append("\n"); 
		query.append("               0 AS EMPTY_WGT" ).append("\n"); 
		query.append("          FROM BSA_FULL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'MTY' AS TY," ).append("\n"); 
		query.append("               TRD_CD    ," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD  ," ).append("\n"); 
		query.append("               DIR_CD    ," ).append("\n"); 
		query.append("               COST_YR   ," ).append("\n"); 
		query.append("               COST_MON  ," ).append("\n"); 
		query.append("               NUM       ," ).append("\n"); 
		query.append("               COST_WK   ," ).append("\n"); 
		query.append("               VSL_CD    ," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               VVD       ," ).append("\n"); 
		query.append("               SLAN_CD   ," ).append("\n"); 
		query.append("               --NULL AS BSA," ).append("\n"); 
		query.append("               BSA,BSA_WGT, --2014.07.14 Arie Im [CHM-201431072]  L/F summary 메뉴 로직 수정" ).append("\n"); 
		query.append("               0 AS FULL," ).append("\n"); 
		query.append("               0 AS FULL_WGT," ).append("\n"); 
		query.append("               EMPTY, EMPTY_WGT" ).append("\n"); 
		query.append("          FROM RDR_MTY" ).append("\n"); 
		query.append("#if (${trade} == 'IAS' || ${trade} == 'IES' || ${trade} == 'IMS')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'INTRA_MTY' AS TY," ).append("\n"); 
		query.append("               TRD_CD    ," ).append("\n"); 
		query.append("               SUB_TRD_CD," ).append("\n"); 
		query.append("               RLANE_CD  ," ).append("\n"); 
		query.append("               DIR_CD    ," ).append("\n"); 
		query.append("               COST_YR   ," ).append("\n"); 
		query.append("               COST_MON  ," ).append("\n"); 
		query.append("               NUM       ," ).append("\n"); 
		query.append("               COST_WK   ," ).append("\n"); 
		query.append("               VSL_CD    ," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               VVD       ," ).append("\n"); 
		query.append("               SLAN_CD   ," ).append("\n"); 
		query.append("               0 AS BSA,0 AS BSA_WGT," ).append("\n"); 
		query.append("               0 AS FULL, 0 AS FULL_WGT," ).append("\n"); 
		query.append("               EMPTY,  0 AS EMPTY_WGT" ).append("\n"); 
		query.append("          FROM INTRA_MTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       GROUP BY TRD_CD , SUB_TRD_CD, RLANE_CD , DIR_CD , COST_YR , COST_MON , NUM , COST_WK , VSL_CD , SKD_VOY_NO, SKD_DIR_CD, VVD , SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BASE_DATA2 AS (" ).append("\n"); 
		query.append("    SELECT 1 AS BSA_AVG ," ).append("\n"); 
		query.append("           Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("#elseif(${duration} == '7')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7'])" ).append("\n"); 
		query.append("#elseif(${duration} == '8')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8'])" ).append("\n"); 
		query.append("#elseif(${duration} == '9')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9'])" ).append("\n"); 
		query.append("#elseif(${duration} == '10')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10'])" ).append("\n"); 
		query.append("#elseif(${duration} == '11')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11'])" ).append("\n"); 
		query.append("#elseif(${duration} == '12')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12'])" ).append("\n"); 
		query.append("#elseif(${duration} == '13')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13'])" ).append("\n"); 
		query.append("#elseif(${duration} == '14')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14'])" ).append("\n"); 
		query.append("#elseif(${duration} == '15')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'])" ).append("\n"); 
		query.append("#elseif(${duration} == '16')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16'])" ).append("\n"); 
		query.append("#elseif(${duration} == '17')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17'])" ).append("\n"); 
		query.append("#elseif(${duration} == '18')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18'])" ).append("\n"); 
		query.append("#elseif(${duration} == '19')" ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19'])" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	#set($new_dur = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20'])" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("           MIN(DECODE(Z1.NUM, ${key}, Z1.VVD))              AS MIN_VVD$key," ).append("\n"); 
		query.append("           MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))              AS MAX_VVD$key," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.BSA  , 0), 0)) AS BSA$key    ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, 1, NVL(Z1.BSA_WGT  , 0), 0)) AS BSA_WGT$key    ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.FULL , 0), 0)) AS FULL$key   ," ).append("\n"); 
		query.append("		   SUM(DECODE(Z1.NUM, 1, NVL(Z1.FULL_WGT , 0), 0)) AS FULL_WGT$key   ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.EMPTY, 0), 0)) AS EMPTY$key  ," ).append("\n"); 
		query.append("		   SUM(DECODE(Z1.NUM, 1, NVL(Z1.EMPTY_WGT, 0), 0)) AS EMPTY_WGT$key  ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ''" ).append("\n"); 
		query.append("      FROM BASE_DATA Z1" ).append("\n"); 
		query.append("  GROUP BY Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD" ).append("\n"); 
		query.append("  ORDER BY Z1.TRD_CD    ," ).append("\n"); 
		query.append("           Z1.SUB_TRD_CD," ).append("\n"); 
		query.append("           Z1.RLANE_CD  ," ).append("\n"); 
		query.append("           Z1.DIR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT Z3.TRD_CD    ," ).append("\n"); 
		query.append("         Z3.SUB_TRD_CD," ).append("\n"); 
		query.append("         Z3.RLANE_CD  ," ).append("\n"); 
		query.append("         Z3.DIR_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("         Z3.VVD$key    ," ).append("\n"); 
		query.append("         Z3.BSA$key    ," ).append("\n"); 
		query.append("         Z3.FULL$key   ," ).append("\n"); 
		query.append("         Z3.EMPTY$key  ," ).append("\n"); 
		query.append("         Z3.TTL_LOAD$key," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA$key, 0, 0, DECODE(Z3.FULL$key    , 0, 0, Z3.FULL$key     * 100 / Z3.BSA$key)), 1) AS FULL_LF$key," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA$key, 0, 0, DECODE(Z3.TTL_LOAD$key, 0, 0, Z3.TTL_LOAD$key * 100 / Z3.BSA$key)), 1) AS TTL_LF$key ," ).append("\n"); 
		query.append("         Z3.BSA_WGT$key    ," ).append("\n"); 
		query.append("         Z3.FULL_WGT$key   ," ).append("\n"); 
		query.append("         Z3.EMPTY_WGT$key  ," ).append("\n"); 
		query.append("         Z3.TTL_LOAD_WGT$key," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.BSA_WGT$key, 0, 0, DECODE(Z3.TTL_LOAD_WGT$key, 0, 0, Z3.TTL_LOAD_WGT$key * 100 / Z3.BSA_WGT$key)), 1) AS TTL_WGT_LF$key ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         Z3.T_BSA  ," ).append("\n"); 
		query.append("         Z3.T_FULL ," ).append("\n"); 
		query.append("         Z3.T_EMPTY," ).append("\n"); 
		query.append("         Z3.T_LOAD ," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.T_BSA, 0, 0, DECODE(Z3.T_FULL, 0, 0, Z3.T_FULL * 100 / Z3.T_BSA)), 1) AS T_FULL_LF," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.T_BSA, 0, 0, DECODE(Z3.T_LOAD, 0, 0, Z3.T_LOAD * 100 / Z3.T_BSA)), 1) AS T_TTL_LF ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         Z3.T_BSA_WGT  ," ).append("\n"); 
		query.append("         Z3.T_FULL_WGT ," ).append("\n"); 
		query.append("         Z3.T_EMPTY_WGT," ).append("\n"); 
		query.append("         Z3.T_LOAD_WGT ," ).append("\n"); 
		query.append("         ROUND(DECODE(Z3.T_BSA_WGT, 0, 0, DECODE(Z3.T_LOAD_WGT, 0, 0, Z3.T_LOAD_WGT * 100 / Z3.T_BSA_WGT)), 1) AS T_TTL_WGT_LF ," ).append("\n"); 
		query.append("         '' AS T" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT NVL(( SELECT SUM(BSA) / COUNT(1) AS BSA" ).append("\n"); 
		query.append("                           FROM BSA_FULL L" ).append("\n"); 
		query.append("                          WHERE L.SUB_TRD_CD = Z2.SUB_TRD_CD" ).append("\n"); 
		query.append("                            AND L.RLANE_CD   = Z2.RLANE_CD" ).append("\n"); 
		query.append("                            AND L.DIR_CD     = Z2.DIR_CD), 0) AS BSA_AVG," ).append("\n"); 
		query.append("                   NVL(Z2.TRD_CD    , 'TOTAL') AS TRD_CD    ," ).append("\n"); 
		query.append("                   NVL(Z2.SUB_TRD_CD, 'TOTAL') AS SUB_TRD_CD," ).append("\n"); 
		query.append("                   NVL(Z2.RLANE_CD  , 'TOTAL') AS RLANE_CD  ," ).append("\n"); 
		query.append("                   NVL(Z2.DIR_CD    , 'TOTAL') AS DIR_CD    ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                   MAX(DECODE((NVL(Z2.MIN_VVD$key, ' ')), (NVL(Z2.MAX_VVD$key, ' ')), Z2.MIN_VVD$key, Z2.MAX_VVD$key || '/' || Z2.MIN_VVD$key)) AS VVD${key}," ).append("\n"); 
		query.append("                   SUM(DECODE(Z2.TRD_CD||Z2.SUB_TRD_CD, 'IASIP', Z2.FULL$key, Z2.BSA$key)) AS BSA$key," ).append("\n"); 
		query.append("				   SUM(DECODE(Z2.TRD_CD||Z2.SUB_TRD_CD, 'IASIP', Z2.FULL_WGT$key, Z2.BSA_WGT$key)) AS BSA_WGT$key," ).append("\n"); 
		query.append("                   SUM(Z2.FULL$key)  AS FULL$key ," ).append("\n"); 
		query.append("                   SUM(Z2.EMPTY$key) AS EMPTY$key," ).append("\n"); 
		query.append("                   SUM(Z2.FULL$key + Z2.EMPTY$key) AS TTL_LOAD$key," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   SUM(Z2.FULL_WGT$key)  AS FULL_WGT$key ," ).append("\n"); 
		query.append("                   SUM(Z2.EMPTY_WGT$key) AS EMPTY_WGT$key," ).append("\n"); 
		query.append("                   SUM(Z2.FULL_WGT$key + Z2.EMPTY_WGT$key) AS TTL_LOAD_WGT$key," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + DECODE(Z2.TRD_CD||Z2.SUB_TRD_CD, 'IASIP', Z2.FULL$key, Z2.BSA$key)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_BSA," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + DECODE(Z2.TRD_CD||Z2.SUB_TRD_CD, 'IASIP', Z2.FULL_WGT$key, Z2.BSA_WGT$key)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_BSA_WGT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + Z2.FULL$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_FULL," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + Z2.EMPTY$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_EMPTY," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + Z2.FULL$key + Z2.EMPTY$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_LOAD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + Z2.FULL_WGT$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_FULL_WGT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + Z2.EMPTY_WGT$key " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_EMPTY_WGT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   SUM( 0 " ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("                        + Z2.FULL_WGT$key + Z2.EMPTY_WGT$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   ) AS T_LOAD_WGT," ).append("\n"); 
		query.append("                   ''" ).append("\n"); 
		query.append("              FROM BASE_DATA2 Z2" ).append("\n"); 
		query.append("          GROUP BY Z2.TRD_CD," ).append("\n"); 
		query.append("                   CUBE(Z2.SUB_TRD_CD, Z2.RLANE_CD, Z2.DIR_CD)" ).append("\n"); 
		query.append("            HAVING     (NOT (SUB_TRD_CD IS NULL     AND RLANE_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NOT NULL AND RLANE_CD IS NOT NULL AND DIR_CD IS NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NULL     AND RLANE_CD IS NULL     AND DIR_CD IS NOT NULL))" ).append("\n"); 
		query.append("                   AND (NOT (SUB_TRD_CD IS NOT NULL AND RLANE_CD IS NULL     AND DIR_CD IS NOT NULL))" ).append("\n"); 
		query.append("         ) Z3" ).append("\n"); 
		query.append("ORDER BY DECODE(SUB_TRD_CD, 'TOTAL', '00', SUB_TRD_CD) DESC," ).append("\n"); 
		query.append("         BSA_AVG DESC," ).append("\n"); 
		query.append("         DECODE(RLANE_CD, 'TOTAL', 'ZZZZZ', RLANE_CD)," ).append("\n"); 
		query.append("		 DECODE(DIR_CD  , 'TOTAL', 'ZZZZZ', DIR_CD)" ).append("\n"); 

	}
}