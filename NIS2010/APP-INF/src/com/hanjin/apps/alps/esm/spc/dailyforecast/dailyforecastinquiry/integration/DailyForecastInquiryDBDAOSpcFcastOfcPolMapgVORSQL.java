/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
	  * 2010.11.16 남궁진호 [CHM-201007114-01] SPC_CONTI_CONV_FNC Function 사용 
	  * 2011.01.03 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청 
	  *  -T/S VVD 및 T/S ETB DATE  필드 추가 
	  * 2011.05.06 최성민[CHM-201110577-01] ALPS/SPC의 TS booking status 기능보완 요청 
	  *  - Pre/Post T/S ETB Date 항목 추가 
	  * -2011.06.01 [ CHM-201111305-01] 김종준 R5와 동일하게 R9이 적용될 수 있도록 쿼리수정
	  * -2012.12.03 [CHM-201221639] 김시몬 R9와 동일하게 R8이 적용될 수 있도록 쿼리수정
	  * 2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거
	  * * 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선
	  * 2014.12.22 박은주 [CHM-201433402] TS BKG status(new) 기능 추가 요청 (쿼리 튜닝 및 conti로만 조회 하도록 쿼리 변경)
	  * </pre>
	  */
	public DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_conti",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration").append("\n"); 
		query.append("FileName : DailyForecastInquiryDBDAOSpcFcastOfcPolMapgVORSQL").append("\n"); 
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
		query.append("WITH WEEKS AS (" ).append("\n"); 
		query.append("    SELECT PRD.cost_yr" ).append("\n"); 
		query.append("          ,PRD.cost_wk" ).append("\n"); 
		query.append("          ,@[lane]     AS TLANE" ).append("\n"); 
		query.append("          ,@[rhq_cd]   AS RHQ_CD" ).append("\n"); 
		query.append("          ,@[ofc_cd]   AS OFC_CD" ).append("\n"); 
		query.append("          ,@[ts_conti] AS TS_CONTI" ).append("\n"); 
		query.append("          ,@[pol1]     AS TS_PORT" ).append("\n"); 
		query.append("          ,@[del]      AS DEL" ).append("\n"); 
		query.append("          ,(PRD.SLS_FM_DT) AS SLS_FM_DT" ).append("\n"); 
		query.append("          ,(PRD.SLS_TO_DT) AS SLS_TO_DT" ).append("\n"); 
		query.append("      FROM MAS_WK_PRD PRD" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       and prd.cost_yr  = @[year]" ).append("\n"); 
		query.append("       and PRD.COST_WK >= @[week]" ).append("\n"); 
		query.append("       and prd.cost_yr||prd.cost_wk >= @[year]||@[week]" ).append("\n"); 
		query.append("       AND ROWNUM <= @[duration]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(", BKG_BASE AS (" ).append("\n"); 
		query.append("    SELECT BKG.BKG_NO" ).append("\n"); 
		query.append("          ,WK.COST_YR" ).append("\n"); 
		query.append("          ,WK.COST_WK" ).append("\n"); 
		query.append("          ,SKD.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("          ,SKD.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("          ,SKD.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${ts_conti} != '')     " ).append("\n"); 
		query.append("          ,NVL2(WK.TS_PORT, WK.TS_PORT, LOC.LOC_CD) TS_PORT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          ,WK.TS_PORT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          ,WK.DEL" ).append("\n"); 
		query.append("          ,WK.TS_CONTI" ).append("\n"); 
		query.append("          ,WK.RHQ_CD" ).append("\n"); 
		query.append("          ,WK.TLANE" ).append("\n"); 
		query.append("          ,WK.OFC_CD" ).append("\n"); 
		query.append("          ,SKD.YD_CD" ).append("\n"); 
		query.append("          ,SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,SKD.VPS_ETB_DT" ).append("\n"); 
		query.append("          ,BKG.POL_CD" ).append("\n"); 
		query.append("          ,BKG.POD_CD" ).append("\n"); 
		query.append("          ,BKG.DEL_CD" ).append("\n"); 
		query.append("          ,BKG.SLAN_CD" ).append("\n"); 
		query.append("          ,BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("          ,BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS TRUNK_VVD " ).append("\n"); 
		query.append("          ,WK.SLS_FM_DT" ).append("\n"); 
		query.append("          ,WK.SLS_TO_DT" ).append("\n"); 
		query.append("      FROM WEEKS WK" ).append("\n"); 
		query.append("          ,VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("          ,BKG_VVD VVD" ).append("\n"); 
		query.append("          ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("#if (${ts_conti} != '')" ).append("\n"); 
		query.append("          ,MDM_LOCATION LOC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     WHERE BKG.BKG_NO           = VVD.BKG_NO" ).append("\n"); 
		query.append("       AND BKG.POD_CD          <> VVD.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND VVD.VSL_CD           = SKD.VSL_CD" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVD.POD_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("       AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${pol1} != '')" ).append("\n"); 
		query.append("       AND VVD.POD_CD           = WK.TS_PORT" ).append("\n"); 
		query.append("       AND SKD.VPS_PORT_CD      = WK.TS_PORT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND SKD.VPS_ETB_DT       BETWEEN TO_DATE(WK.SLS_FM_DT, 'YYYY-MM-DD HH24:MI:SS') AND  TO_DATE(WK.SLS_TO_DT || '235959', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("       AND BKG.DEL_CD           LIKE WK.DEL||'%'" ).append("\n"); 
		query.append("       AND BKG.BKG_STS_CD       IN ('W','F')" ).append("\n"); 
		query.append("       AND BKG.BKG_CGO_TP_CD    IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("#if (${ts_conti} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND SKD.VPS_PORT_CD      = LOC.LOC_CD" ).append("\n"); 
		query.append("       AND LOC.CONTI_CD         = WK.TS_CONTI" ).append("\n"); 
		query.append("       AND LOC.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG AS (" ).append("\n"); 
		query.append("    SELECT YRWK    ," ).append("\n"); 
		query.append("--           RLANE_CD," ).append("\n"); 
		query.append("           Z.VVD   ," ).append("\n"); 
		query.append("           TSLAN_CD," ).append("\n"); 
		query.append("           NVL(PRE_SLAN, 'FDR')  AS PRE_SLAN,           " ).append("\n"); 
		query.append("           PRE_VVD   ," ).append("\n"); 
		query.append("           PRE_ETB_DT," ).append("\n"); 
		query.append("           NVL(POST_SLAN, 'FDR') AS POST_SLAN," ).append("\n"); 
		query.append("           POST_VVD ," ).append("\n"); 
		query.append("           POST_ETB_DT,           " ).append("\n"); 
		query.append("           POL_CD  ," ).append("\n"); 
		query.append("           POD_CD  ," ).append("\n"); 
		query.append("           DEL_CD  ,           " ).append("\n"); 
		query.append("           TS_PORT   ," ).append("\n"); 
		query.append("           DECODE(Z.OFC_CD, NULL, O.N4TH_PRNT_OFC_CD, NVL(O.N5TH_PRNT_OFC_CD, SLS_OFC_CD)) AS SLS_OFC_CD," ).append("\n"); 
		query.append("           Z.OFC_CD       ," ).append("\n"); 
		query.append("           BKG_TTL_QTY    ," ).append("\n"); 
		query.append("           BKG_RF20_QTY   ," ).append("\n"); 
		query.append("           BKG_RF40_QTY   ," ).append("\n"); 
		query.append("           BKG_TTL_WGT    ," ).append("\n"); 
		query.append("           BKG_20FT_QTY   ," ).append("\n"); 
		query.append("           BKG_40FT_QTY   ," ).append("\n"); 
		query.append("           BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("           BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("           --BKG_53FT_QTY   ," ).append("\n"); 
		query.append("           BKG_DG_QTY," ).append("\n"); 
		query.append("           BKG_AK_QTY" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT COST_YR||COST_WK AS YRWK," ).append("\n"); 
		query.append("                     RHQ_CD  ," ).append("\n"); 
		query.append("--                     RLANE_CD," ).append("\n"); 
		query.append("                     VVD     ," ).append("\n"); 
		query.append("                     TSLAN_CD," ).append("\n"); 
		query.append("                     PRE_SLAN ," ).append("\n"); 
		query.append("                     POST_SLAN," ).append("\n"); 
		query.append("                     PRE_VVD   ," ).append("\n"); 
		query.append("                     POST_VVD   ," ).append("\n"); 
		query.append("                     PRE_ETB_DT," ).append("\n"); 
		query.append("                     POST_ETB_DT," ).append("\n"); 
		query.append("                     POL_CD  ," ).append("\n"); 
		query.append("                     POD_CD  ," ).append("\n"); 
		query.append("                     DEL_CD  ," ).append("\n"); 
		query.append("                     TS_PORT," ).append("\n"); 
		query.append("                     OB_SLS_OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("                     OFC_CD     ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0))) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0))) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0))) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0))) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0))) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     --SUM(TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0))) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0))) AS BKG_RF20_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))) AS BKG_RF40_QTY   ," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 113,14), 0))) AS BKG_DG_QTY," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 127,14), 0))) AS BKG_AK_QTY," ).append("\n"); 
		query.append("                     SUM(TO_NUMBER(NVL(SUBSTR(VAL, 141, 14), 0))) AS BKG_TTL_WGT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT C.BKG_NO," ).append("\n"); 
		query.append("                               C.COST_YR," ).append("\n"); 
		query.append("                               C.COST_WK," ).append("\n"); 
		query.append("                               C.RHQ_CD ," ).append("\n"); 
		query.append("--                               C.RLANE_CD," ).append("\n"); 
		query.append("                               DECODE(BV1.VSL_PRE_PST_CD,'T',BV1.VSL_CD||BV1.SKD_VOY_NO||BV1.SKD_DIR_CD,C.TRUNK_VVD) AS VVD," ).append("\n"); 
		query.append("                               DECODE(BV1.VSL_PRE_PST_CD,'T',BV1.SLAN_CD,C.SLAN_CD) AS TSLAN_CD," ).append("\n"); 
		query.append("                               --V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                               BV1.SLAN_CD AS PRE_SLAN," ).append("\n"); 
		query.append("                               BV.SLAN_CD  AS POST_SLAN," ).append("\n"); 
		query.append("                               C.CLPT_IND_SEQ," ).append("\n"); 
		query.append("                               DECODE(C.TS_PORT, BV1.POD_CD, BV1.POD_CLPT_IND_SEQ, BV.POL_CLPT_IND_SEQ) SEQ," ).append("\n"); 
		query.append("                               BV1.POL_CLPT_IND_SEQ AS PRE_SEQ," ).append("\n"); 
		query.append("                               BV1.VSL_CD||BV1.SKD_VOY_NO||BV1.SKD_DIR_CD AS PRE_VVD," ).append("\n"); 
		query.append("                               BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD    AS POST_VVD," ).append("\n"); 
		query.append("                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD       = BV1.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO   = BV1.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD   = BV1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD  = BV1.POD_CD" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ = BV1.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X')) AS PRE_ETB_DT,                             " ).append("\n"); 
		query.append("                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                                   AND CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X')) AS POST_ETB_DT,  " ).append("\n"); 
		query.append("                               C.POL_CD AS POL_CD," ).append("\n"); 
		query.append("                               C.POD_CD AS POD_CD," ).append("\n"); 
		query.append("                               C.DEL_CD AS DEL_CD," ).append("\n"); 
		query.append("                               --BV.POL_CD AS TS_PORT," ).append("\n"); 
		query.append("							   C.TS_PORT AS TS_PORT," ).append("\n"); 
		query.append("                               SPC_SCR_OFC_CONV_FNC(C.OB_SLS_OFC_CD) AS OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                               C.OFC_CD," ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT    TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("										|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0), 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 0, Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY), 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(Q.DCGO_QTY),    'FM0000000000.000') -- DG" ).append("\n"); 
		query.append("                                        || TO_CHAR(SUM(Q.AWK_CGO_QTY), 'FM0000000000.000') -- AW" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        || TO_CHAR((R.ACT_WGT * DECODE(R.ACT_WGT,'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                                                                   FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                                                                  WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                   FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                  WHERE C.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                               ) VAL," ).append("\n"); 
		query.append("                               C.TS_CONTI" ).append("\n"); 
		query.append("                          FROM BKG_BASE     C" ).append("\n"); 
		query.append("                              ,BKG_BL_DOC   R " ).append("\n"); 
		query.append("                              ,BKG_VVD      BV  -- pre" ).append("\n"); 
		query.append("                              ,BKG_VVD      BV1 --post" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND C.BKG_NO     = R.BKG_NO " ).append("\n"); 
		query.append("                           AND C.BKG_NO     = BV.BKG_NO " ).append("\n"); 
		query.append("                           AND C.BKG_NO     = BV1.BKG_NO" ).append("\n"); 
		query.append("                           AND BV1.POD_CD   = C.TS_PORT -- TS 직전 배" ).append("\n"); 
		query.append("                           AND BV.POL_CD    = C.TS_PORT -- TS 다음 배" ).append("\n"); 
		query.append("--                           AND c.CLPT_IND_SEQ = DECODE(C.TS_PORT, BV1.POD_CD, BV1.POD_CLPT_IND_SEQ, BV.POL_CLPT_IND_SEQ) -- 더블콜링하는 경우 제외 로직" ).append("\n"); 
		query.append("--                           and b.BKG_NO IN ('NYC411630100','ATL412337700','ATL413505500','CHI413100500')" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("               WHERE TSLAN_CD     LIKE @[lane]||'%'" ).append("\n"); 
		query.append("--                 AND CLPT_IND_SEQ = PRE_SEQ -- 더블콜링하는 경우 제외 로직" ).append("\n"); 
		query.append("            GROUP BY COST_YR||COST_WK," ).append("\n"); 
		query.append("                     RHQ_CD  ," ).append("\n"); 
		query.append("--                     RLANE_CD," ).append("\n"); 
		query.append("                     VVD     ," ).append("\n"); 
		query.append("                     TSLAN_CD," ).append("\n"); 
		query.append("                     PRE_SLAN ," ).append("\n"); 
		query.append("                     POST_SLAN," ).append("\n"); 
		query.append("                     POST_VVD   ," ).append("\n"); 
		query.append("                     POST_ETB_DT," ).append("\n"); 
		query.append("                     PRE_VVD   ," ).append("\n"); 
		query.append("                     PRE_ETB_DT," ).append("\n"); 
		query.append("                     POL_CD  ," ).append("\n"); 
		query.append("                     POD_CD  ," ).append("\n"); 
		query.append("                     DEL_CD  ," ).append("\n"); 
		query.append("                     TS_PORT ," ).append("\n"); 
		query.append("                     OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                     OFC_CD" ).append("\n"); 
		query.append("           ) Z," ).append("\n"); 
		query.append("           SPC_OFC_LVL O" ).append("\n"); 
		query.append("     WHERE O.OFC_CD = Z.SLS_OFC_CD" ).append("\n"); 
		query.append("       AND (Z.OFC_CD IS NULL OR O.N4TH_PRNT_OFC_CD = Z.OFC_CD) " ).append("\n"); 
		query.append("	   AND (Z.RHQ_CD IS NULL OR Z.RHQ_CD = O.N2ND_PRNT_OFC_CD)     " ).append("\n"); 
		query.append("       AND Z.YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", BKG_LIST  AS (" ).append("\n"); 
		query.append("  SELECT YRWK," ).append("\n"); 
		query.append("         DECODE(PRE_SLAN, 'RBC', 'FDR', PRE_SLAN) AS PRE_SLAN," ).append("\n"); 
		query.append("         PRE_VVD,         " ).append("\n"); 
		query.append("		 PRE_ETB_DT," ).append("\n"); 
		query.append("         DECODE(POST_SLAN, 'RBC', 'FDR', POST_SLAN) AS POST_SLAN," ).append("\n"); 
		query.append("         POST_VVD," ).append("\n"); 
		query.append("		 POST_ETB_DT,		 " ).append("\n"); 
		query.append("		 TS_PORT," ).append("\n"); 
		query.append("		 POL_CD," ).append("\n"); 
		query.append("		 POD_CD," ).append("\n"); 
		query.append("		 DEL_CD,         " ).append("\n"); 
		query.append("         SLS_OFC_CD," ).append("\n"); 
		query.append("         TSLAN_CD," ).append("\n"); 
		query.append("         VVD," ).append("\n"); 
		query.append("         7 AS LVL," ).append("\n"); 
		query.append("         --ROUND(7 - LOG(2, GROUPING_ID(YRWK, PRE_VVD, POST_VVD, TS_PORT, POL_CD, DEL_CD, SLS_OFC_CD, VVD) + 1), 0) AS LVL," ).append("\n"); 
		query.append("         SUM(BKG_TTL_QTY)     AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("         SUM(BKG_TTL_WGT)     AS BKG_TTL_WGT    ," ).append("\n"); 
		query.append("         SUM(BKG_20FT_QTY)    AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_40FT_QTY)    AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_40FT_HC_QTY) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("         SUM(BKG_45FT_HC_QTY) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("         --SUM(BKG_53FT_QTY)    AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_RF20_QTY)    AS BKG_RF20_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_RF40_QTY)    AS BKG_RF40_QTY   ," ).append("\n"); 
		query.append("         SUM(BKG_DG_QTY)      AS BKG_DG_QTY," ).append("\n"); 
		query.append("         SUM(BKG_AK_QTY)      AS BKG_AK_QTY" ).append("\n"); 
		query.append("    FROM BKG B" ).append("\n"); 
		query.append("GROUP BY YRWK, PRE_SLAN, PRE_VVD, PRE_ETB_DT, POST_SLAN, POST_VVD, POST_ETB_DT, TS_PORT, POL_CD, POD_CD, DEL_CD, SLS_OFC_CD, TSLAN_CD, VVD" ).append("\n"); 
		query.append("ORDER BY YRWK," ).append("\n"); 
		query.append("         NVL(PRE_VVD, 	'000000000')," ).append("\n"); 
		query.append("         NVL(POST_VVD,  '000000000')," ).append("\n"); 
		query.append("         NVL(TS_PORT, 	'00000')," ).append("\n"); 
		query.append("         NVL(POL_CD, 	'00000')," ).append("\n"); 
		query.append("         NVL(POD_CD, 	'00000')," ).append("\n"); 
		query.append("         NVL(DEL_CD, 	'00000')," ).append("\n"); 
		query.append("         NVL(SLS_OFC_CD,'00000')," ).append("\n"); 
		query.append("         NVL(TSLAN_CD  ,'00000')," ).append("\n"); 
		query.append("         VVD," ).append("\n"); 
		query.append("         LVL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    YRWK,    " ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL)  = 1 THEN" ).append("\n"); 
		query.append("        PRE_SLAN" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(PRE_SLAN,'-')" ).append("\n"); 
		query.append("    END PRE_SLAN," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL)  = 1 THEN" ).append("\n"); 
		query.append("        PRE_VVD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(PRE_VVD,'-')" ).append("\n"); 
		query.append("    END PRE_VVD," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) = 1 THEN" ).append("\n"); 
		query.append("        PRE_ETB_DT" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(PRE_ETB_DT,'-')" ).append("\n"); 
		query.append("    END PRE_ETB_DT, --ts_etb_de ==> pre_etb_dt " ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2) THEN" ).append("\n"); 
		query.append("        POST_SLAN" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(POST_SLAN,'-')" ).append("\n"); 
		query.append("    END POST_SLAN," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2) THEN" ).append("\n"); 
		query.append("        POST_VVD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(POST_VVD,'-')" ).append("\n"); 
		query.append("    END POST_VVD," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2) THEN" ).append("\n"); 
		query.append("        POST_ETB_DT" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(POST_ETB_DT,'-')" ).append("\n"); 
		query.append("    END POST_ETB_DT, --ts2_etb_de ==> post_etb_dt " ).append("\n"); 
		query.append("--    TS_PORT," ).append("\n"); 
		query.append("	CASE WHEN TRUNC(LVL) IN (1,2,3) THEN" ).append("\n"); 
		query.append("        TS_PORT" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(TS_PORT,'-')" ).append("\n"); 
		query.append("    END TS_PORT," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2,3,4) THEN" ).append("\n"); 
		query.append("        POL_CD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(POL_CD,'-')" ).append("\n"); 
		query.append("    END POL_CD," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2,3,4) THEN" ).append("\n"); 
		query.append("        POD_CD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(POD_CD,'-')" ).append("\n"); 
		query.append("    END POD_CD," ).append("\n"); 
		query.append("    CASE WHEN TRUNC(LVL) IN (1,2,3,4,5) THEN" ).append("\n"); 
		query.append("        DEL_CD" ).append("\n"); 
		query.append("    ELSE" ).append("\n"); 
		query.append("        NVL(DEL_CD,'-')" ).append("\n"); 
		query.append("    END DEL_CD," ).append("\n"); 
		query.append("    SLS_OFC_CD," ).append("\n"); 
		query.append("    TSLAN_CD," ).append("\n"); 
		query.append("    VVD," ).append("\n"); 
		query.append("    LVL," ).append("\n"); 
		query.append("    BKG_TTL_QTY    ," ).append("\n"); 
		query.append("    BKG_TTL_WGT    ," ).append("\n"); 
		query.append("    BKG_20FT_QTY   ," ).append("\n"); 
		query.append("    BKG_40FT_QTY   ," ).append("\n"); 
		query.append("    BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("    --BKG_53FT_QTY   ," ).append("\n"); 
		query.append("    BKG_RF20_QTY   ," ).append("\n"); 
		query.append("    BKG_RF40_QTY   ,  " ).append("\n"); 
		query.append("    BKG_DG_QTY     ," ).append("\n"); 
		query.append("    BKG_AK_QTY" ).append("\n"); 
		query.append("FROM BKG_LIST" ).append("\n"); 

	}
}
