/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
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
		query.append("           FULL      ," ).append("\n"); 
		query.append("           ROUND(COA_BSA, 10) AS BSA" ).append("\n"); 
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
		query.append("                     NVL(SUM(COA_QTY), 0)      AS FULL   ," ).append("\n"); 
		query.append("                     NVL(SUM(VVD_BSA_CAPA), 0) AS COA_BSA" ).append("\n"); 
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
		query.append("                               DECODE(NVL(A3.LOD_SPL_CNG_FLG,'N'), 'Y', SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD, -1, 1)" ).append("\n"); 
		query.append("                                                                 , '2', NVL(A2.BKG_QTY, 0), NVL(A2.BKG_QTY, 0) * 2))" ).append("\n"); 
		query.append("                                                                 , 'N', MAX(A1.VVD_BSA_CAPA)" ).append("\n"); 
		query.append("                               ) AS VVD_BSA_CAPA," ).append("\n"); 
		query.append("                               SUM(DECODE(SUBSTR(A2.CNTR_TPSZ_CD, -1, 1), '2', NVL(A2.BKG_QTY, 0), NVL(A2.BKG_QTY, 0) * 2)) AS COA_QTY" ).append("\n"); 
		query.append("                         FROM  COA_MON_VVD   A1," ).append("\n"); 
		query.append("                               COA_BKG_EXPN_DTL_WK A2," ).append("\n"); 
		query.append("                               COA_LANE_RGST A3," ).append("\n"); 
		query.append("							   --SPC_OFC_LVL   A4," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                  SELECT /*+ INDEX (P XPKCOA_WK_PRD)*/" ).append("\n"); 
		query.append("                                         P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                                         ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                                    FROM COA_WK_PRD P" ).append("\n"); 
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
		query.append("                           --AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = A2.BKG_WK" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("                           AND A2.BKG_STS_CD         IN ('F','S')" ).append("\n"); 
		query.append("                           AND A2.BKG_CGO_TP_CD      <> 'P'" ).append("\n"); 
		query.append("                           AND A2.BL_NO_TP           IN ('M','0')" ).append("\n"); 
		query.append("                           AND A1.TRD_CD              = @[trade]" ).append("\n"); 
		query.append("                           --AND A4.OFC_TP_CD          IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           --AND A4.OFC_CD              = SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD)" ).append("\n"); 
		query.append("                           --AND P.COST_YRWK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("	#if (${rhq} == 'SHAAS')" ).append("\n"); 
		query.append("							AND (SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                          WHERE A4.N2ND_PRNT_OFC_CD = 'SHAAS'" ).append("\n"); 
		query.append("                                                                            AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                            AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("							    OR EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("							                  FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("							                 WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("							                   AND SPC_SCR_OFC_CONV_FNC(A2.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("							                   AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("							               CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD " ).append("\n"); 
		query.append("							                 START WITH O.PRNT_OFC_CD ='SINWA' )" ).append("\n"); 
		query.append("							   )							               " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("						   AND EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                         WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                           AND SPC_SCR_OFC_CONV_FNC(A2.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("                                           AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                       CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD" ).append("\n"); 
		query.append("                                                 START WITH O.PRNT_OFC_CD = @[rhq] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("	#if (${rhq} == 'SHAAS')" ).append("\n"); 
		query.append("	                       AND (( SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                            FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                           WHERE A4.N2ND_PRNT_OFC_CD = 'SHAAS'" ).append("\n"); 
		query.append("                                                                             AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                             AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("	                            AND 'A' = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, SUBSTR(A1.RLANE_CD,1,3), A1.DIR_CD)" ).append("\n"); 
		query.append("                                              FROM MDM_LOCATION L, BKG_BOOKING B" ).append("\n"); 
		query.append("                                             WHERE L.LOC_CD = NVL(B.PRE_RLY_PORT_CD, B.POL_CD)" ).append("\n"); 
		query.append("                                               AND B.BKG_NO = A2.BKG_NO ))" ).append("\n"); 
		query.append("                                OR SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                             FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                            WHERE A4.N2ND_PRNT_OFC_CD = 'SINWA'" ).append("\n"); 
		query.append("                                                                              AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                              AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )                               " ).append("\n"); 
		query.append("                               )    " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("						   AND SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD) IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                                                                         FROM SPC_OFC_LVL A4" ).append("\n"); 
		query.append("                                                                        WHERE A4.N2ND_PRNT_OFC_CD = @[rhq]" ).append("\n"); 
		query.append("                                                                          AND A4.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                                                          AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
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
		query.append("     WHERE FULL + COA_BSA <> 0" ).append("\n"); 
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
		query.append("           SUM(M.SLOT_QTY) AS EMPTY" ).append("\n"); 
		query.append("     FROM  RDR_HEADER  H," ).append("\n"); 
		query.append("           RDR_UTILIZE M," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("              SELECT /*+ INDEX (P XPKCOA_WK_PRD)*/" ).append("\n"); 
		query.append("                     P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                     ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                FROM COA_WK_PRD P" ).append("\n"); 
		query.append("               WHERE P.COST_YR > ' '" ).append("\n"); 
		query.append("                 AND P.COST_WK > ' '" ).append("\n"); 
		query.append("                 AND P.COST_YR||P.COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                 AND ROWNUM               <= @[duration]" ).append("\n"); 
		query.append("           ) P," ).append("\n"); 
		query.append("           COA_MON_VVD C" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND SUBSTR(C.SLS_YRMON, 1, 4)||C.COST_WK = P.COST_YRWK" ).append("\n"); 
		query.append("       AND (C.DELT_FLG IS NULL OR C.DELT_FLG = 'N')" ).append("\n"); 
		query.append("       AND C.IOC_CD     = 'O'" ).append("\n"); 
		query.append("       AND M.OPR_CD     = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC" ).append("\n"); 
		query.append("       AND M.TYPE       = 'E'" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       AND C.TRD_CD     = @[trade]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${subtrade} != '')" ).append("\n"); 
		query.append("       AND C.SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != '')" ).append("\n"); 
		query.append("       AND C.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq} == 'SHAAS')" ).append("\n"); 
		query.append("       AND M.REGION    IN ('A', 'D', 'F')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${rhq} == 'NYCNA')" ).append("\n"); 
		query.append("       AND M.REGION    IN ('M', 'S')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("       AND M.REGION     = DECODE(@[rhq], 'HAMUR', 'E', '')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
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
		query.append("                     NVL(DECODE(BKG_CGO_TP_CD, 'P', DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', OP_CNTR_QTY, OP_CNTR_QTY * 2)),0) AS MTY" ).append("\n"); 
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
		query.append("                             COA_MON_VVD  M," ).append("\n"); 
		query.append("                             (" ).append("\n"); 
		query.append("                               SELECT /*+ INDEX (P XPKCOA_WK_PRD)*/" ).append("\n"); 
		query.append("                                      P.COST_YR||P.COST_WK AS COST_YRWK," ).append("\n"); 
		query.append("                                      ROWNUM               AS RNUM" ).append("\n"); 
		query.append("                                 FROM COA_WK_PRD P" ).append("\n"); 
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
		query.append("	#if (${rhq} == 'SHAAS')" ).append("\n"); 
		query.append("						   										   AND N2ND_PRNT_OFC_CD		IN ('SHAAS', 'SINWA')" ).append("\n"); 
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
		query.append("    SELECT 'BSA_FULL' AS TY," ).append("\n"); 
		query.append("           TRD_CD    ," ).append("\n"); 
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
		query.append("           BSA       ," ).append("\n"); 
		query.append("           FULL      ," ).append("\n"); 
		query.append("           NULL AS EMPTY" ).append("\n"); 
		query.append("      FROM BSA_FULL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'MTY' AS TY," ).append("\n"); 
		query.append("           TRD_CD    ," ).append("\n"); 
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
		query.append("           NULL AS BSA," ).append("\n"); 
		query.append("           NULL AS FULL," ).append("\n"); 
		query.append("           EMPTY" ).append("\n"); 
		query.append("      FROM RDR_MTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trade} == 'IAS' || ${trade} == 'IES' || ${trade} == 'IMS')" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 'INTRA_MTY' AS TY," ).append("\n"); 
		query.append("           TRD_CD    ," ).append("\n"); 
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
		query.append("           0 AS BSA," ).append("\n"); 
		query.append("           0 AS FULL," ).append("\n"); 
		query.append("           EMPTY" ).append("\n"); 
		query.append("      FROM INTRA_MTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( $key in $new_dur )" ).append("\n"); 
		query.append("           MIN(DECODE(Z1.NUM, ${key}, Z1.VVD))              AS MIN_VVD$key," ).append("\n"); 
		query.append("           MAX(DECODE(Z1.NUM, ${key}, Z1.VVD))              AS MAX_VVD$key," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.BSA  , 0), 0)) AS BSA$key    ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.FULL , 0), 0)) AS FULL$key   ," ).append("\n"); 
		query.append("           SUM(DECODE(Z1.NUM, ${key}, NVL(Z1.EMPTY, 0), 0)) AS EMPTY$key  ," ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("                   SUM(Z2.FULL$key)  AS FULL$key ," ).append("\n"); 
		query.append("                   SUM(Z2.EMPTY$key) AS EMPTY$key," ).append("\n"); 
		query.append("                   SUM(Z2.FULL$key + Z2.EMPTY$key) AS TTL_LOAD$key," ).append("\n"); 
		query.append("" ).append("\n"); 
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