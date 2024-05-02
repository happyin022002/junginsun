/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DailyForecastInquiryDBDAOSpcFcastOfcPolDelMapgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.11.14 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DailyForecastInquiryDBDAOSpcFcastOfcPolDelMapgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 
	  * </pre>
	  */
	public DailyForecastInquiryDBDAOSpcFcastOfcPolDelMapgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.integration").append("\n"); 
		query.append("FileName : DailyForecastInquiryDBDAOSpcFcastOfcPolDelMapgVORSQL").append("\n"); 
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
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT @[year]        AS YR         ," ).append("\n"); 
		query.append("           @[week]        AS WK         ," ).append("\n"); 
		query.append("           @[duration]    AS DUR        ," ).append("\n"); 
		query.append("           @[lane]        AS TLANE      ," ).append("\n"); 
		query.append("           @[vvd]         AS VVD        ,            " ).append("\n"); 
		query.append("           @[rhq_cd]      AS RHQ_CD     ," ).append("\n"); 
		query.append("           @[ofc_cd]      AS OFC_CD     ," ).append("\n"); 
		query.append("           @[ts_conti]    AS TS_CONTI   , " ).append("\n"); 
		query.append("           @[pol1]        AS TS_PORT    ," ).append("\n"); 
		query.append("           @[del]         AS DEL       " ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", WEEKS AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("          PRD.COST_YR  ," ).append("\n"); 
		query.append("          PRD.COST_WK  ," ).append("\n"); 
		query.append("          P.TLANE      ," ).append("\n"); 
		query.append("          P.VVD        ," ).append("\n"); 
		query.append("          P.OFC_CD     ," ).append("\n"); 
		query.append("          p.RHQ_CD     ," ).append("\n"); 
		query.append("          P.TS_CONTI   ," ).append("\n"); 
		query.append("          P.TS_PORT    ," ).append("\n"); 
		query.append("          P.DEL        ," ).append("\n"); 
		query.append("          MIN(PRD.SLS_FM_DT) OVER() AS SLS_FM_DT," ).append("\n"); 
		query.append("          MAX(PRD.SLS_TO_DT) OVER() AS SLS_TO_DT" ).append("\n"); 
		query.append("     FROM MAS_WK_PRD PRD," ).append("\n"); 
		query.append("          PARAMS     P" ).append("\n"); 
		query.append("	WHERE P.VVD IS NULL " ).append("\n"); 
		query.append("	  AND PRD.COST_YR||PRD.COST_WK >= P.YR||P.WK" ).append("\n"); 
		query.append("	  AND ROWNUM <= P.DUR" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("-- 해당 port에 들어가는 BOOKING LIST" ).append("\n"); 
		query.append(", BKG_BASE AS(" ).append("\n"); 
		query.append("SELECT /*+ INDEX(PRD XPKMAS_WK_PRD)*/" ).append("\n"); 
		query.append("       DISTINCT" ).append("\n"); 
		query.append("       B.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("       B.VSL_CD AS VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO AS SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("       COA.COST_YR, -- DEL 기준 " ).append("\n"); 
		query.append("       COA.COST_WK, " ).append("\n"); 
		query.append("--       CMV.RLANE_CD," ).append("\n"); 
		query.append("       P.RHQ_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD A, " ).append("\n"); 
		query.append("       BKG_VVD B, " ).append("\n"); 
		query.append("       --BKG_VVD TS_CHECK," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       WEEKS WK," ).append("\n"); 
		query.append("       PARAMS P," ).append("\n"); 
		query.append("       MAS_WK_PRD COA" ).append("\n"); 
		query.append("    WHERE B.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("      AND A.VSL_CD       = B.VSL_CD" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO   = B.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD   = B.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND BKG.DEL_CD     = P.DEL" ).append("\n"); 
		query.append("      AND B.POD_CD       = P.DEL --BKG_VVD중 DEL을 CALLING 배 찾기" ).append("\n"); 
		query.append("      AND A.VPS_PORT_CD  = P.DEL -- DEL CALLING ETB를 위한 SKD 조회 " ).append("\n"); 
		query.append("      AND TO_CHAR(A.VPS_ETB_DT, 'YYYYMMDD') BETWEEN WK.SLS_FM_DT AND  WK.SLS_TO_DT -- DEL CALLING 주차 가져오기 " ).append("\n"); 
		query.append("      AND TO_CHAR(A.VPS_ETB_DT, 'YYYYMMDD') BETWEEN COA.SLS_FM_DT AND  COA.SLS_TO_DT" ).append("\n"); 
		query.append("      AND A.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           Z.SLS_OFC_CD," ).append("\n"); 
		query.append("--           O.OFC_APLY_TO_YRWK," ).append("\n"); 
		query.append("--           O.OFC_CD," ).append("\n"); 
		query.append("           YRWK," ).append("\n"); 
		query.append("           --RHQ_CD ,                     " ).append("\n"); 
		query.append("           PRE_VVD1," ).append("\n"); 
		query.append("           DECODE(PRE_VVD1,'',PRE_LANE1,NVL(PRE_LANE1, 'FDR'))  AS PRE_LANE1," ).append("\n"); 
		query.append("           PRE_PORT1,   " ).append("\n"); 
		query.append("           PRE_VVD1_ETB," ).append("\n"); 
		query.append("           T_VVD," ).append("\n"); 
		query.append("           T_LANE," ).append("\n"); 
		query.append("           T_PORT T_POD,   " ).append("\n"); 
		query.append("           T_VVD_ETB," ).append("\n"); 
		query.append("           POST_VVD2," ).append("\n"); 
		query.append("           DECODE(POST_VVD2,'',POST_LANE2,NVL(POST_LANE2, 'FDR'))  AS POST_LANE2," ).append("\n"); 
		query.append("           POST_PORT2,  " ).append("\n"); 
		query.append("           POST_VVD2_ETB," ).append("\n"); 
		query.append("           POST_VVD3," ).append("\n"); 
		query.append("           DECODE(POST_VVD3,'',POST_LANE3,NVL(POST_LANE3, 'FDR'))  AS POST_LANE3," ).append("\n"); 
		query.append("           POST_PORT3,  " ).append("\n"); 
		query.append("           POST_VVD3_ETB,         " ).append("\n"); 
		query.append("           POST_VVD4," ).append("\n"); 
		query.append("           DECODE(POST_VVD4,'',POST_LANE4,NVL(POST_LANE4, 'FDR'))  AS POST_LANE4," ).append("\n"); 
		query.append("           --POST_PORT4,                                                     " ).append("\n"); 
		query.append("           POL_CD," ).append("\n"); 
		query.append("           POD_CD," ).append("\n"); 
		query.append("           DEL_CD,  " ).append("\n"); 
		query.append("           DEL_ETB, " ).append("\n"); 
		query.append("--           O.N4TH_PRNT_OFC_CD AS SLS_OFC_CD, " ).append("\n"); 
		query.append("           SLS_OFC_CD," ).append("\n"); 
		query.append("           TLANE,                   " ).append("\n"); 
		query.append("           VVD," ).append("\n"); 
		query.append("           BKG_TTL_QTY    ," ).append("\n"); 
		query.append("           BKG_TTL_WGT    ," ).append("\n"); 
		query.append("           BKG_20FT_QTY   ," ).append("\n"); 
		query.append("           BKG_40FT_QTY   ," ).append("\n"); 
		query.append("           BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("           BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("           --BKG_53FT_QTY   ," ).append("\n"); 
		query.append("           BKG_RF20_QTY   ," ).append("\n"); 
		query.append("           BKG_RF40_QTY   ," ).append("\n"); 
		query.append("           BKG_DG_QTY," ).append("\n"); 
		query.append("           BKG_AK_QTY," ).append("\n"); 
		query.append("           7 AS LVL" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      YRWK," ).append("\n"); 
		query.append("                      --RHQ_CD ,                     " ).append("\n"); 
		query.append("                      PRE_VVD1," ).append("\n"); 
		query.append("                      PRE_LANE1," ).append("\n"); 
		query.append("                      PRE_PORT1," ).append("\n"); 
		query.append("                      PRE_VVD1_ETB," ).append("\n"); 
		query.append("                      T_VVD," ).append("\n"); 
		query.append("                      T_LANE," ).append("\n"); 
		query.append("                      T_PORT,  " ).append("\n"); 
		query.append("                      T_VVD_ETB, " ).append("\n"); 
		query.append("                      POST_VVD2," ).append("\n"); 
		query.append("                      POST_LANE2," ).append("\n"); 
		query.append("                      POST_PORT2," ).append("\n"); 
		query.append("                      POST_VVD2_ETB," ).append("\n"); 
		query.append("                      POST_VVD3," ).append("\n"); 
		query.append("                      POST_LANE3," ).append("\n"); 
		query.append("                      POST_PORT3, " ).append("\n"); 
		query.append("                      POST_VVD3_ETB, " ).append("\n"); 
		query.append("                      POST_VVD4," ).append("\n"); 
		query.append("                      POST_LANE4," ).append("\n"); 
		query.append("                      --POST_PORT4,                                                     " ).append("\n"); 
		query.append("                      POL_CD," ).append("\n"); 
		query.append("                      POD_CD," ).append("\n"); 
		query.append("                      DEL_CD,      " ).append("\n"); 
		query.append("                      DEL_ETB,                 " ).append("\n"); 
		query.append("                      OB_SLS_OFC_CD AS SLS_OFC_CD,  " ).append("\n"); 
		query.append("                      TLANE,      " ).append("\n"); 
		query.append("                      VVD," ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL,  1, 14), 0))) AS BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 15, 14), 0))) AS BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 29, 14), 0))) AS BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 43, 14), 0))) AS BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 57, 14), 0))) AS BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 71, 14), 0))) AS BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 85, 14), 0))) AS BKG_RF20_QTY   ," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 99, 14), 0))) AS BKG_RF40_QTY   ," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 113,14), 0))) AS BKG_DG_QTY," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 127,14), 0))) AS BKG_AK_QTY," ).append("\n"); 
		query.append("                      SUM(TO_NUMBER(NVL(SUBSTR(VAL, 141, 14), 0))) AS BKG_TTL_WGT" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("			SELECT BKG_NO," ).append("\n"); 
		query.append("                    	      YRWK," ).append("\n"); 
		query.append("                              RHQ_CD ," ).append("\n"); 
		query.append("                              --RLANE_CD," ).append("\n"); 
		query.append("                              --VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                              VVD," ).append("\n"); 
		query.append("                              TLANE," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'S',TS_VVD,''))  AS PRE_VVD1," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'S',TS_LANE,'')) AS PRE_LANE1," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'S',TS_PORT,'')) AS PRE_PORT1,  " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'S',POD_ETB_DT,'')) AS PRE_VVD1_ETB,  " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'T',TS_VVD,''))  AS T_VVD," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'T',TS_LANE,'')) AS T_LANE," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'T',TS_PORT,'')) AS T_PORT,  " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD,'T',POD_ETB_DT,'')) AS T_VVD_ETB,  " ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,1,TS_VVD,''), ''))  AS POST_VVD2," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,1,TS_LANE,''), '')) AS POST_LANE2," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,1,DECODE(TS_PORT,POD_CD,'',TS_PORT),''), '')) AS POST_PORT2, " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,1,DECODE(TS_PORT,POD_CD,'',POL_ETB_DT),''), '')) AS POST_VVD2_ETB,  " ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,2,TS_VVD,''), ''))  AS POST_VVD3," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,2,TS_LANE,''), '')) AS POST_LANE3," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,2,DECODE(TS_PORT,POD_CD,'',TS_PORT),''), '')) AS POST_PORT3,  " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,2,DECODE(TS_PORT,POD_CD,'',POL_ETB_DT),''), '')) AS POST_VVD3_ETB," ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,3,TS_VVD,''), ''))  AS POST_VVD4," ).append("\n"); 
		query.append("                              MAX(DECODE(VSL_PRE_PST_CD, 'U', DECODE(TS_VVD_SEQ,3,TS_LANE,''), '')) AS POST_LANE4," ).append("\n"); 
		query.append("                              --MAX(DECODE(TS_VVD_SEQ,4,DECODE(TS_PORT,POD_CD,'',TS_PORT),'')) AS POST_PORT4,                                                     " ).append("\n"); 
		query.append("                              POL_CD," ).append("\n"); 
		query.append("                              POD_CD," ).append("\n"); 
		query.append("                              DEL_CD,  " ).append("\n"); 
		query.append("                              DEL_ETB," ).append("\n"); 
		query.append("                              --POL_ETB_DT,                               " ).append("\n"); 
		query.append("                              OB_SLS_OFC_CD," ).append("\n"); 
		query.append("                              --OFC_CD," ).append("\n"); 
		query.append("                              MAX(VAL) AS VAL" ).append("\n"); 
		query.append("                              --TS_CONTI" ).append("\n"); 
		query.append("                         FROM (" ).append("\n"); 
		query.append("                     		SELECT BKG_NO," ).append("\n"); 
		query.append("                		      COST_YR||COST_WK AS YRWK," ).append("\n"); 
		query.append("                                      RHQ_CD ," ).append("\n"); 
		query.append("                                      VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                                      VVD," ).append("\n"); 
		query.append("                                      TLANE," ).append("\n"); 
		query.append("                                      TS_VVD," ).append("\n"); 
		query.append("                                      TS_LANE," ).append("\n"); 
		query.append("                                      CALL_PORT," ).append("\n"); 
		query.append("                                      POL_ETB_DT," ).append("\n"); 
		query.append("                                      TS_PORT," ).append("\n"); 
		query.append("                                      POD_ETB_DT," ).append("\n"); 
		query.append("                                      POL_CD," ).append("\n"); 
		query.append("                                      POD_CD," ).append("\n"); 
		query.append("                                      DEL_CD,  " ).append("\n"); 
		query.append("                                      DEL_ETB,                             " ).append("\n"); 
		query.append("                                      OB_SLS_OFC_CD," ).append("\n"); 
		query.append("--                                      OFC_CD," ).append("\n"); 
		query.append("                                      VAL," ).append("\n"); 
		query.append("--                                      TS_CONTI," ).append("\n"); 
		query.append("                                      ROW_NUMBER() OVER(PARTITION BY BKG_NO, VSL_PRE_PST_CD  ORDER BY POL_ETB_DT) AS TS_VVD_SEQ" ).append("\n"); 
		query.append("                                 FROM (" ).append("\n"); 
		query.append("                                        SELECT" ).append("\n"); 
		query.append("                                               B.BKG_NO," ).append("\n"); 
		query.append("                                               BASE.RHQ_CD ," ).append("\n"); 
		query.append("--                                               BASE.RLANE_CD," ).append("\n"); 
		query.append("                                               BASE.COST_YR," ).append("\n"); 
		query.append("                                               BASE.COST_WK," ).append("\n"); 
		query.append("                                               B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("                                               B.SLAN_CD AS TLANE," ).append("\n"); 
		query.append("                                               BV.VSL_PRE_PST_CD," ).append("\n"); 
		query.append("                                               BV.VSL_SEQ," ).append("\n"); 
		query.append("                                               BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD AS TS_VVD," ).append("\n"); 
		query.append("                                               BV.SLAN_CD AS TS_LANE," ).append("\n"); 
		query.append("                                               BV.POL_CD AS CALL_PORT, " ).append("\n"); 
		query.append("                                               BV.POD_CD AS TS_PORT,                                     " ).append("\n"); 
		query.append("                                               B.POL_CD," ).append("\n"); 
		query.append("                                               B.POD_CD," ).append("\n"); 
		query.append("                                               B.DEL_CD,    " ).append("\n"); 
		query.append("                                               CASE WHEN BV.VSL_CD IS NULL AND BV.POD_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("                                                    TO_CHAR(BV.CRE_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                               ELSE   " ).append("\n"); 
		query.append("                                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                 WHERE VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                                                   AND SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND VPS_PORT_CD  = BV.POL_CD" ).append("\n"); 
		query.append("                                                   AND CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X')) " ).append("\n"); 
		query.append("                                               END AS POL_ETB_DT,   " ).append("\n"); 
		query.append("                                               CASE WHEN BV.VSL_CD IS NULL AND BV.POD_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("                                                    TO_CHAR(BV.CRE_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                               ELSE   " ).append("\n"); 
		query.append("                                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                 WHERE VSL_CD       = BV.VSL_CD" ).append("\n"); 
		query.append("                                                   AND SKD_VOY_NO   = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND SKD_DIR_CD   = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND VPS_PORT_CD  = BV.POD_CD" ).append("\n"); 
		query.append("                                                   AND CLPT_IND_SEQ = BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X')) " ).append("\n"); 
		query.append("                                               END AS POD_ETB_DT,                                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                               (SELECT TO_CHAR(VPS_ETB_DT , 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                  FROM VSK_VSL_PORT_SKD SKD , " ).append("\n"); 
		query.append("                                                       BKG_VVD DEL" ).append("\n"); 
		query.append("                                                 WHERE 1 =1 " ).append("\n"); 
		query.append("                                                   AND BV.BKG_NO    = DEL.BKG_NO" ).append("\n"); 
		query.append("                                                   AND SKD.VSL_CD       = DEL.VSL_CD" ).append("\n"); 
		query.append("                                                   AND SKD.SKD_VOY_NO   = DEL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                   AND SKD.SKD_DIR_CD   = DEL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                   AND SKD.VPS_PORT_CD  = DEL.POD_CD" ).append("\n"); 
		query.append("                                                   AND B.DEL_CD     = DEL.POD_CD" ).append("\n"); 
		query.append("                                                   AND CLPT_IND_SEQ = DEL.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                   AND 'S' <> NVL(SKD_CNG_STS_CD, 'X'))  AS DEL_ETB," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                               (SELECT O.N4TH_PRNT_OFC_CD " ).append("\n"); 
		query.append("                                                  FROM SPC_OFC_LVL O" ).append("\n"); 
		query.append("                                                WHERE O.OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) " ).append("\n"); 
		query.append("                                                AND O.N4TH_PRNT_OFC_CD LIKE null||'%' " ).append("\n"); 
		query.append("                                                AND O.N2ND_PRNT_OFC_CD LIKE null||'%'" ).append("\n"); 
		query.append("                                                AND BASE.COST_YR||BASE.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK) " ).append("\n"); 
		query.append("                                                 AS OB_SLS_OFC_CD, " ).append("\n"); 
		query.append("                                               -- LEVEL 정리" ).append("\n"); 
		query.append("--                                               SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) AS OB_SLS_OFC_CD," ).append("\n"); 
		query.append("--                                               V.OFC_CD," ).append("\n"); 
		query.append("                                               (" ).append("\n"); 
		query.append("                                                 SELECT    TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '4', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                										|| TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '5', Q.OP_CNTR_QTY, '9', Q.OP_CNTR_QTY, '8', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')	--R9,R8에 대해서 R5과 동일하게 HC으로 처리되도록 추가" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '7', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(DECODE(Q.CNTR_TPSZ_CD, 'DW', Q.OP_CNTR_QTY, 'DX', Q.OP_CNTR_QTY, 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY, 0), 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(DECODE(SPC_GET_CNTR_TP_FNC(Q.CNTR_TPSZ_CD), 'R', DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 0, Q.OP_CNTR_QTY - Q.EQ_SUBST_CGO_QTY), 0)), 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                        " ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(Q.DCGO_QTY),    'FM0000000000.000') -- DG" ).append("\n"); 
		query.append("                                                        || TO_CHAR(SUM(Q.AWK_CGO_QTY), 'FM0000000000.000') -- AW" ).append("\n"); 
		query.append("                                                        " ).append("\n"); 
		query.append("                                                        || TO_CHAR((R.ACT_WGT * DECODE(R.ACT_WGT,'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT" ).append("\n"); 
		query.append("                                                                                                                                                   FROM MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("                                                                                                                                                  WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001, 'FM0000000000.000')" ).append("\n"); 
		query.append("                                                   FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("                                                  WHERE B.BKG_NO = Q.BKG_NO" ).append("\n"); 
		query.append("                                               ) VAL" ).append("\n"); 
		query.append("--                                               ,V.TS_CONTI" ).append("\n"); 
		query.append("                                          FROM BKG_VVD     BV, -- PRE배 중 TRUNK 직전 1개를 제외한 모든 배 (TRUNK 도 제외)" ).append("\n"); 
		query.append("                                               BKG_VVD     TRUNK," ).append("\n"); 
		query.append("                                               BKG_BOOKING B ," ).append("\n"); 
		query.append("                                               BKG_BL_DOC  R , " ).append("\n"); 
		query.append("                                               BKG_BASE    BASE" ).append("\n"); 
		query.append("                                         WHERE BASE.BKG_NO        = B.BKG_NO  " ).append("\n"); 
		query.append("                                           AND B.BKG_NO           = R.BKG_NO " ).append("\n"); 
		query.append("                                           AND BASE.BKG_NO        = TRUNK.BKG_NO" ).append("\n"); 
		query.append("                                           AND TRUNK.VSL_PRE_PST_CD  = 'T'" ).append("\n"); 
		query.append("                                           AND BV.BKG_NO          = BASE.BKG_NO" ).append("\n"); 
		query.append("                                           AND (BV.VSL_PRE_PST_CD = 'U' OR BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                                                OR (BV.VSL_PRE_PST_CD = 'S' AND BV.VSL_SEQ = (SELECT MAX(T.VSL_SEQ)" ).append("\n"); 
		query.append("                                                                                                FROM BKG_VVD T" ).append("\n"); 
		query.append("                                                                                               WHERE T.BKG_NO = BASE.BKG_NO" ).append("\n"); 
		query.append("                                                                                                 AND T.VSL_PRE_PST_CD = 'S')))" ).append("\n"); 
		query.append("                                                                                                 " ).append("\n"); 
		query.append("                                           " ).append("\n"); 
		query.append("                                           AND B.BKG_STS_CD    IN ('W','F')" ).append("\n"); 
		query.append("                                           AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("                                           AND B.SLAN_CD LIKE @[lane]||'%'" ).append("\n"); 
		query.append("--                                           AND B.BKG_NO IN ('NKKB3B812500', 'SHCH3H213100') " ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                        GROUP BY BKG_NO," ).append("\n"); 
		query.append("                    	      YRWK," ).append("\n"); 
		query.append("                              RHQ_CD ," ).append("\n"); 
		query.append("                              VVD,  " ).append("\n"); 
		query.append("                              TLANE,                                           " ).append("\n"); 
		query.append("                              POL_CD," ).append("\n"); 
		query.append("                              POD_CD," ).append("\n"); 
		query.append("                              DEL_CD,        " ).append("\n"); 
		query.append("                              DEL_ETB,                         " ).append("\n"); 
		query.append("                              OB_SLS_OFC_CD" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("            GROUP BY YRWK," ).append("\n"); 
		query.append("                     --RHQ_CD ,                     " ).append("\n"); 
		query.append("                     PRE_VVD1," ).append("\n"); 
		query.append("                     PRE_LANE1," ).append("\n"); 
		query.append("                     PRE_PORT1, " ).append("\n"); 
		query.append("                     PRE_VVD1_ETB," ).append("\n"); 
		query.append("                     T_VVD," ).append("\n"); 
		query.append("                     T_LANE," ).append("\n"); 
		query.append("                     T_PORT,   " ).append("\n"); 
		query.append("                     T_VVD_ETB," ).append("\n"); 
		query.append("                     POST_VVD2," ).append("\n"); 
		query.append("                     POST_LANE2," ).append("\n"); 
		query.append("                     POST_PORT2, " ).append("\n"); 
		query.append("                     POST_VVD2_ETB, " ).append("\n"); 
		query.append("                     POST_VVD3," ).append("\n"); 
		query.append("                     POST_LANE3," ).append("\n"); 
		query.append("                     POST_PORT3," ).append("\n"); 
		query.append("                     POST_VVD3_ETB,   " ).append("\n"); 
		query.append("                     POST_VVD4," ).append("\n"); 
		query.append("                     POST_LANE4," ).append("\n"); 
		query.append("                     --POST_PORT4,                                                     " ).append("\n"); 
		query.append("                     POL_CD," ).append("\n"); 
		query.append("                     POD_CD," ).append("\n"); 
		query.append("                     DEL_CD,  " ).append("\n"); 
		query.append("                     DEL_ETB," ).append("\n"); 
		query.append("                     OB_SLS_OFC_CD,  " ).append("\n"); 
		query.append("                     TLANE,                   " ).append("\n"); 
		query.append("                     VVD" ).append("\n"); 
		query.append("           ) Z," ).append("\n"); 
		query.append("			SPC_OFC_LVL O" ).append("\n"); 
		query.append("     WHERE O.OFC_CD = Z.SLS_OFC_CD  " ).append("\n"); 
		query.append("       AND O.N4TH_PRNT_OFC_CD LIKE @[ofc_cd]||'%' " ).append("\n"); 
		query.append("       AND O.N2ND_PRNT_OFC_CD LIKE @[rhq_cd]||'%'" ).append("\n"); 
		query.append("       AND Z.YRWK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("--       AND DECODE(POST_VVD2,'',POST_LANE2,NVL(POST_LANE2, 'FDR')) IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY YRWK," ).append("\n"); 
		query.append("	 PRE_VVD1," ).append("\n"); 
		query.append("         POL_CD," ).append("\n"); 
		query.append("         POD_CD" ).append("\n"); 

	}
}
