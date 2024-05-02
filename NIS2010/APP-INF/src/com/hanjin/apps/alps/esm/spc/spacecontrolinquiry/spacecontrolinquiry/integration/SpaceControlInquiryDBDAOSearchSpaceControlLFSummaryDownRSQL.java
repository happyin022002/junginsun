/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryDownRSQL.java
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

public class SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryDownRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2010.11.02 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
	  * 2010.12.21 최윤성 [CHM-201007718-01] L/F Summary 화면 BKG 로직 수정
	  * 2011.01.04 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2011.01.19 최윤성 [CHM-201108422-01] L/F Summary 화면 하드코딩 및 보완 요청
	  *  - IAS/IP sub-trade 에 한하여 BSA 는 Full BKG volume 과 동일하게 보여지도록 수정
	  *  - IAS 한하여 Empty 값은 From ~ To 의 Conti 가 모두 A 인 값만 보이고 나머지는 0.
	  * 2011.05.24 김종준 [CHM-201111032-01] L/F Summary 화면 로직 보완
	  *   - Daily F"cast Status 화면과 동일하도록 로직 보완 
	  *   - RHQ 선택시 loading office 뿐만이 아니라 From conti 까지 일치 하는 BKG 정보만 가지고 오도록 추가
	  * 2017.1.23 SM상선 전환에 따른 소스변경
	  * </pre>
	  */
	public SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryDownRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpaceControlInquiryDBDAOSearchSpaceControlLFSummaryDownRSQL").append("\n"); 
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
		query.append("           ROUND(MAS_BSA, 10) AS BSA" ).append("\n"); 
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
		query.append("                     NVL(SUM(VVD_BSA_CAPA), 0) AS MAS_BSA" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT /*+ USE_HASH(A2, A1, A3, A4) PARALLEL(A2, A4) */" ).append("\n"); 
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
		query.append("                               SUM(DECODE(SPC_GET_CNTR_SZ_FNC(A2.CNTR_TPSZ_CD), '2', NVL(A2.BKG_QTY, 0), NVL(A2.BKG_QTY, 0) * 2)) AS MAS_QTY" ).append("\n"); 
		query.append("                         FROM  (" ).append("\n"); 
		query.append("                                /* 대상 BKG만을 가져옴 */" ).append("\n"); 
		query.append("                                SELECT TRD_CD, RLANE_CD, IOC_CD," ).append("\n"); 
		query.append("                                       VSL_CD, SKD_VOY_NO, DIR_CD, SLS_OFC_CD," ).append("\n"); 
		query.append("                                       SUBSTR(SLS_YRMON, 1, 4)||COST_WK BKG_WK," ).append("\n"); 
		query.append("                                       CNTR_TPSZ_CD, BKG_QTY," ).append("\n"); 
		query.append("                                       BKG_STS_CD, BKG_CGO_TP_CD, BL_NO_TP, BKG_OFC_CD, BKG_NO" ).append("\n"); 
		query.append("                                  FROM MAS_BKG_EXPN_DTL_WK" ).append("\n"); 
		query.append("                                 WHERE SUBSTR(SLS_YRMON, 1, 4)||COST_WK >= @[year]||@[week]" ).append("\n"); 
		query.append("                                   AND BKG_STS_CD         IN ('F','S')" ).append("\n"); 
		query.append("                                   AND BKG_CGO_TP_CD      <> 'P'" ).append("\n"); 
		query.append("                                   AND BL_NO_TP           IN ('M','0')" ).append("\n"); 
		query.append("                               ) A2," ).append("\n"); 
		query.append("                               MAS_MON_VVD   A1," ).append("\n"); 
		query.append("                               MAS_LANE_RGST A3," ).append("\n"); 
		query.append("							   SPC_OFC_LVL   A4," ).append("\n"); 
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
		query.append("                           --AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = SUBSTR(A2.SLS_YRMON, 1, 4)||A2.COST_WK" ).append("\n"); 
		query.append("						   AND SUBSTR(A1.SLS_YRMON, 1, 4)||A1.COST_WK = A2.BKG_WK" ).append("\n"); 
		query.append("                           AND NVL(A1.DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("                           --AND A2.BKG_STS_CD         IN ('F','S')" ).append("\n"); 
		query.append("                           --AND A2.BKG_CGO_TP_CD      <> 'P'" ).append("\n"); 
		query.append("                           --AND A2.BL_NO_TP           IN ('M','0')" ).append("\n"); 
		query.append("                           AND A1.TRD_CD              = @[trade]" ).append("\n"); 
		query.append("                           AND A4.OFC_TP_CD          IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                           AND A4.OFC_CD              = SPC_SCR_OFC_CONV_FNC(A2.SLS_OFC_CD)" ).append("\n"); 
		query.append("                           AND P.COST_YRWK BETWEEN A4.OFC_APLY_FM_YRWK AND A4.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("	#if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("						   AND (A4.N2ND_PRNT_OFC_CD = 'SHARC' " ).append("\n"); 
		query.append("							                                OR EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("							                                              FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("							                                             WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("							                                               AND SPC_SCR_OFC_CONV_FNC(A2.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("							                                               AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("							                                           CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD " ).append("\n"); 
		query.append("							                                           START WITH O.PRNT_OFC_CD ='SINRS'" ).append("\n"); 
		query.append("							                                           )" ).append("\n"); 
		query.append("							   )		" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("						   AND EXISTS ( SELECT O.OFC_CD" ).append("\n"); 
		query.append("                                          FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                         WHERE O.OFC_TP_CD IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                                           AND SPC_SCR_OFC_CONV_FNC(A2.BKG_OFC_CD) = O.OFC_CD" ).append("\n"); 
		query.append("                                           AND P.COST_YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                                       CONNECT BY NOCYCLE O.PRNT_OFC_CD = PRIOR O.OFC_CD" ).append("\n"); 
		query.append("                                                 START WITH O.PRNT_OFC_CD IN @[rhq] )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq} != '')" ).append("\n"); 
		query.append("	#if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("	                       AND ((A4.N2ND_PRNT_OFC_CD='SHARC' AND " ).append("\n"); 
		query.append("	                            'A' = ( SELECT SPC_CONTI_CONV_FNC(L.CONTI_CD, A1.RLANE_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("                                                            FROM MDM_LOCATION L, BKG_BOOKING B" ).append("\n"); 
		query.append("                                                           WHERE L.LOC_CD = NVL(B.PRE_RLY_PORT_CD, B.POL_CD)" ).append("\n"); 
		query.append("                                                           AND B.BKG_NO = A2.BKG_NO ))	  " ).append("\n"); 
		query.append("                               OR A4.N2ND_PRNT_OFC_CD='SINRS'                                                           " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("						   AND A4.N2ND_PRNT_OFC_CD    IN @[rhq]" ).append("\n"); 
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
		query.append("           SUM(M.SLOT_QTY) AS EMPTY," ).append("\n"); 
		query.append("           MAX(C.VVD_BSA_CAPA) AS BSA -- 2014.07.14 [CHM-201431072]" ).append("\n"); 
		query.append("     FROM  RDR_HEADER  H," ).append("\n"); 
		query.append("           RDR_UTILIZE M," ).append("\n"); 
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
		query.append("       AND (C.DELT_FLG IS NULL OR C.DELT_FLG = 'N')" ).append("\n"); 
		query.append("       AND C.IOC_CD     = 'O'" ).append("\n"); 
		query.append("       AND M.OPR_CD     = 'SML'" ).append("\n"); 
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
		query.append("#if (${rhq} == 'SHARC')" ).append("\n"); 
		query.append("       AND M.REGION    IN ('A', 'D', 'F')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${rhq} == 'NYCRA')" ).append("\n"); 
		query.append("       AND M.REGION    IN ('M', 'S')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("       AND M.REGION     = DECODE(@[rhq], 'HAMRU', 'E', '')" ).append("\n"); 
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
		query.append("      FROM (SELECT M.TRD_CD    ," ).append("\n"); 
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
		query.append("" ).append("\n"); 
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
		query.append("         , MAX(BSA) BSA" ).append("\n"); 
		query.append("         , MAX(FULL) FULL" ).append("\n"); 
		query.append("         , MAX(EMPTY) EMPTY" ).append("\n"); 
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
		query.append("               BSA       ," ).append("\n"); 
		query.append("               FULL      ," ).append("\n"); 
		query.append("               0 AS EMPTY" ).append("\n"); 
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
		query.append("               BSA," ).append("\n"); 
		query.append("               0 AS FULL," ).append("\n"); 
		query.append("               EMPTY" ).append("\n"); 
		query.append("          FROM RDR_MTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("               0 AS BSA," ).append("\n"); 
		query.append("               0 AS FULL," ).append("\n"); 
		query.append("               EMPTY" ).append("\n"); 
		query.append("          FROM INTRA_MTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("       GROUP BY TRD_CD , SUB_TRD_CD, RLANE_CD , DIR_CD , COST_YR , COST_MON , NUM , COST_WK , VSL_CD , SKD_VOY_NO, SKD_DIR_CD, VVD , SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT COST_WK   ," ).append("\n"); 
		query.append("         TRD_CD    ," ).append("\n"); 
		query.append("         SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD  ," ).append("\n"); 
		query.append("         VVD       ," ).append("\n"); 
		query.append("         DIR_CD    ," ).append("\n"); 
		query.append("         SUM(DECODE(TRD_CD||SUB_TRD_CD, 'IASIP', FULL, BSA)) AS BSA ," ).append("\n"); 
		query.append("         SUM(FULL)                                           AS FULL," ).append("\n"); 
		query.append("         SUM(EMPTY)        AS EMPTY   ," ).append("\n"); 
		query.append("         SUM(FULL + EMPTY) AS TTL_LOAD," ).append("\n"); 
		query.append("         ROUND(DECODE(SUM(DECODE(TRD_CD||SUB_TRD_CD, 'IASIP', FULL, BSA)), 0, 0, DECODE(SUM(FULL), 0, 0, SUM(FULL) * 100 / SUM(DECODE(TRD_CD||SUB_TRD_CD, 'IASIP', FULL, BSA)))), 1) AS FULL_LF," ).append("\n"); 
		query.append("         ROUND(DECODE(SUM(DECODE(TRD_CD||SUB_TRD_CD, 'IASIP', FULL, BSA)), 0, 0, DECODE(SUM(FULL + EMPTY), 0, 0, SUM(FULL + EMPTY) * 100 / SUM(DECODE(TRD_CD||SUB_TRD_CD, 'IASIP', FULL, BSA)))), 1) AS TTL_LF" ).append("\n"); 
		query.append("    FROM BASE_DATA" ).append("\n"); 
		query.append("GROUP BY COST_WK   ," ).append("\n"); 
		query.append("         TRD_CD    ," ).append("\n"); 
		query.append("         SUB_TRD_CD," ).append("\n"); 
		query.append("         RLANE_CD  ," ).append("\n"); 
		query.append("         VVD       ," ).append("\n"); 
		query.append("         DIR_CD" ).append("\n"); 
		query.append("ORDER BY COST_WK   ," ).append("\n"); 
		query.append("         TRD_CD    ," ).append("\n"); 
		query.append("         SUB_TRD_CD DESC," ).append("\n"); 
		query.append("         BSA        DESC," ).append("\n"); 
		query.append("         RLANE_CD  ," ).append("\n"); 
		query.append("         VVD       ," ).append("\n"); 
		query.append("         DIR_CD" ).append("\n"); 

	}
}