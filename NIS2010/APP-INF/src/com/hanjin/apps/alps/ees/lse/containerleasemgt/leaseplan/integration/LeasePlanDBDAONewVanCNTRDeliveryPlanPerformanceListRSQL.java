/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanPerformanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.07
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.12.07 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAONewVanCNTRDeliveryPlanPerformanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신조(자가/장기)장비 인수계획 대비 실적목록을 조회한다.
	  * </pre>
	  */
	public LeasePlanDBDAONewVanCNTRDeliveryPlanPerformanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanPerformanceListRSQL").append("\n"); 
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
		query.append("WITH TEMP_PARAM AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT A.PLN_YRMON, A.AGMT_CTY_CD, A.AGMT_SEQ, " ).append("\n"); 
		query.append("            A.DEL_CD, A.MFT_VNDR_SEQ, A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("			A.NEW_VAN_YRMON AS BASE_DE_YRMON" ).append("\n"); 
		query.append("    FROM    LSE_NEW_VAN_DE_PLN A" ).append("\n"); 
		query.append("    WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${pln_yrmon} != '')" ).append("\n"); 
		query.append("	AND 	A.PLN_YRMON LIKE @[pln_yrmon]||'%'" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if (${pln_mon_cd} != '')" ).append("\n"); 
		query.append("	AND 	SUBSTR(A.NEW_VAN_YRMON, 5,2) IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${pln_mon_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $pln_mon_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '')" ).append("\n"); 
		query.append("    AND    	A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("    AND    	A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("), INLINE_1 AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT P.PLN_YRMON, P.AGMT_CTY_CD, P.AGMT_SEQ," ).append("\n"); 
		query.append("            P.AGMT_CTY_CD||LPAD(P.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("            P.MFT_VNDR_SEQ, P.DEL_CD, P.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            P.BASE_DE_YRMON, 1 AS RSLT_TP_SEQ," ).append("\n"); 
		query.append("            NVL(PLAN.DE_QTY, 0) AS PLAN_DE_QTY, 0 AS PFMC_DE_QTY," ).append("\n"); 
		query.append("			C.RCC_CD, C.LCC_CD, C.SCC_CD" ).append("\n"); 
		query.append("    FROM    TEMP_PARAM P," ).append("\n"); 
		query.append("            LSE_NEW_VAN_DE_PLN PLAN," ).append("\n"); 
		query.append("			MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("    WHERE  1 = 1" ).append("\n"); 
		query.append("    AND    P.BASE_DE_YRMON = PLAN.NEW_VAN_YRMON(+)" ).append("\n"); 
		query.append("    AND    P.CNTR_TPSZ_CD = PLAN.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("    AND    P.DEL_CD = PLAN.DEL_CD(+)" ).append("\n"); 
		query.append("    AND    P.MFT_VNDR_SEQ = PLAN.MFT_VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND    P.AGMT_SEQ = PLAN.AGMT_SEQ(+)" ).append("\n"); 
		query.append("    AND    P.AGMT_CTY_CD = PLAN.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("    AND    P.PLN_YRMON = PLAN.PLN_YRMON(+)" ).append("\n"); 
		query.append("	AND    P.DEL_CD = C.SCC_CD" ).append("\n"); 
		query.append("), INLINE_2 AS (" ).append("\n"); 
		query.append("    SELECT  AGMT_CTY_CD||LPAD(AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("            AGMT_CTY_CD, AGMT_SEQ, MFT_VNDR_SEQ, " ).append("\n"); 
		query.append("			RCC_CD, LCC_CD, SCC_CD, " ).append("\n"); 
		query.append("            CNTR_TPSZ_CD, DE_YRMON AS BASE_DE_YRMON," ).append("\n"); 
		query.append("            2 AS RSLT_TP_SEQ, 0 AS PLAN_DE_QTY," ).append("\n"); 
		query.append("            NVL(COUNT(CNTR_NO), 0) AS PFMC_DE_QTY, PLN_YRMON" ).append("\n"); 
		query.append("    FROM   (SELECT  /*+ ORDERED USE_HASH(P HS CN) */" ).append("\n"); 
		query.append("                    DISTINCT TO_CHAR(CN.ONH_DT, 'YYYYMM') AS DE_YRMON," ).append("\n"); 
		query.append("                    HS.AGMT_CTY_CD, HS.AGMT_SEQ, CN.MFTR_VNDR_SEQ AS MFT_VNDR_SEQ," ).append("\n"); 
		query.append("                    CN.CNTR_TPSZ_CD, CN.CNTR_NO, P.PLN_YRMON," ).append("\n"); 
		query.append("					E.RCC_CD, E.LCC_CD, E.SCC_CD" ).append("\n"); 
		query.append("            FROM    TEMP_PARAM P," ).append("\n"); 
		query.append("                    MST_CNTR_STS_HIS HS," ).append("\n"); 
		query.append("                    MST_CONTAINER CN," ).append("\n"); 
		query.append("				   (SELECT  A.YD_CD, A.LOC_CD, C.RCC_CD, C.LCC_CD, C.SCC_CD" ).append("\n"); 
		query.append("                    FROM    MDM_YARD A," ).append("\n"); 
		query.append("                            MDM_LOCATION B," ).append("\n"); 
		query.append("                            MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("                    WHERE   A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("                    AND     B.SCC_CD = C.SCC_CD) E" ).append("\n"); 
		query.append("            WHERE  1 = 1" ).append("\n"); 
		query.append("			AND    CN.ONH_DT >= TO_DATE(P.BASE_DE_YRMON, 'YYYYMM')" ).append("\n"); 
		query.append("--			AND    CN.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("#if (${pln_mon_cd} != '')			" ).append("\n"); 
		query.append("			AND    TO_CHAR(CN.ONH_DT, 'MM') = SUBSTR(P.BASE_DE_YRMON, 5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND    SUBSTR(NVL(HS.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("            AND    HS.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("            AND    HS.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("            AND    HS.CNTR_NO = CN.CNTR_NO" ).append("\n"); 
		query.append("            AND    CN.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("            AND    CN.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("			AND    CN.ONH_YD_CD = E.YD_CD" ).append("\n"); 
		query.append("            AND    HS.AGMT_SEQ = P.AGMT_SEQ" ).append("\n"); 
		query.append("            AND    HS.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    GROUP BY DE_YRMON, AGMT_CTY_CD, AGMT_SEQ, MFT_VNDR_SEQ, RCC_CD, LCC_CD, SCC_CD, CNTR_TPSZ_CD, PLN_YRMON    " ).append("\n"); 
		query.append("), TEMP_DROP AS (" ).append("\n"); 
		query.append("	SELECT  A.PLN_YRMON, A.AGMT_NO, A.AGMT_CTY_CD, A.AGMT_SEQ, B.REF_NO, A.MFT_VNDR_SEQ, " ).append("\n"); 
		query.append("			A.RCC_CD, A.LCC_CD, A.SCC_CD, A.LCC_CD AS DEL_CD," ).append("\n"); 
		query.append("			A.CNTR_TPSZ_CD, A.DE_YR, A.DE_MON, A.RSLT_TP_SEQ, A.DE_QTY" ).append("\n"); 
		query.append("    FROM   (SELECT  A.PLN_YRMON, A.AGMT_NO, A.AGMT_CTY_CD, A.AGMT_SEQ, " ).append("\n"); 
		query.append("                    A.MFT_VNDR_SEQ, A.RCC_CD, A.LCC_CD, A.SCC_CD, A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                    SUBSTR(A.BASE_DE_YRMON, 0, 4) AS DE_YR, " ).append("\n"); 
		query.append("                    SUBSTR(A.BASE_DE_YRMON, 5, 2) AS DE_MON, " ).append("\n"); 
		query.append("                    C.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("                    CASE C.RSLT_TP_SEQ WHEN 1 THEN A.PLAN_DE_QTY" ).append("\n"); 
		query.append("                         WHEN 2 THEN B.PFMC_DE_QTY" ).append("\n"); 
		query.append("                         WHEN 3 THEN DECODE(NVL(A.PLAN_DE_QTY,0),0,0,ROUND(B.PFMC_DE_QTY/A.PLAN_DE_QTY*100))" ).append("\n"); 
		query.append("                    END DE_QTY" ).append("\n"); 
		query.append("            FROM    INLINE_1 A," ).append("\n"); 
		query.append("                    INLINE_2 B, " ).append("\n"); 
		query.append("                   (SELECT  LEVEL AS RSLT_TP_SEQ  " ).append("\n"); 
		query.append("                    FROM    DUAL  CONNECT BY LEVEL <= 3) C" ).append("\n"); 
		query.append("            WHERE   A.AGMT_NO = B.AGMT_NO(+)" ).append("\n"); 
		query.append("            AND     A.MFT_VNDR_SEQ = B.MFT_VNDR_SEQ(+)" ).append("\n"); 
		query.append("            AND     A.SCC_CD = B.SCC_CD(+)" ).append("\n"); 
		query.append("            AND     A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("            AND     A.BASE_DE_YRMON = B.BASE_DE_YRMON(+)" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT  NVL(A.PLN_YRMON, B.PLN_YRMON) AS PLN_YRMON, B.AGMT_NO, B.AGMT_CTY_CD, B.AGMT_SEQ, " ).append("\n"); 
		query.append("                    B.MFT_VNDR_SEQ, B.RCC_CD, B.LCC_CD, B.SCC_CD, B.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                    SUBSTR(B.BASE_DE_YRMON, 0, 4) AS DE_YR, " ).append("\n"); 
		query.append("                    SUBSTR(B.BASE_DE_YRMON, 5, 2) AS DE_MON, " ).append("\n"); 
		query.append("                    C.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("                    CASE C.RSLT_TP_SEQ WHEN 1 THEN A.PLAN_DE_QTY" ).append("\n"); 
		query.append("                         WHEN 2 THEN B.PFMC_DE_QTY" ).append("\n"); 
		query.append("                         WHEN 3 THEN DECODE(NVL(A.PLAN_DE_QTY,0),0,0,ROUND(B.PFMC_DE_QTY/A.PLAN_DE_QTY*100))" ).append("\n"); 
		query.append("                    END DE_QTY" ).append("\n"); 
		query.append("            FROM    INLINE_1 A," ).append("\n"); 
		query.append("                    INLINE_2 B, " ).append("\n"); 
		query.append("                   (SELECT  LEVEL AS RSLT_TP_SEQ  " ).append("\n"); 
		query.append("                    FROM    DUAL  CONNECT BY LEVEL <= 3) C" ).append("\n"); 
		query.append("            WHERE   A.AGMT_NO(+) = B.AGMT_NO" ).append("\n"); 
		query.append("            AND     A.MFT_VNDR_SEQ(+) = B.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("            AND     A.SCC_CD(+) = B.SCC_CD" ).append("\n"); 
		query.append("            AND     A.CNTR_TPSZ_CD(+) = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            AND     A.BASE_DE_YRMON(+) = B.BASE_DE_YRMON    " ).append("\n"); 
		query.append("            AND     A.PLAN_DE_QTY IS NULL) A," ).append("\n"); 
		query.append("    LSE_AGREEMENT B" ).append("\n"); 
		query.append("    WHERE   1 = 1" ).append("\n"); 
		query.append("    AND    A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("    AND    A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("	#if (${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("    AND    	A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("    AND    	A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    AND    	A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if (${mft_vndr_seq} != '')" ).append("\n"); 
		query.append("    AND    	A.MFT_VNDR_SEQ IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${mft_vndr_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $mft_vndr_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    AND    	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT	X.PLN_YRMON, X.AGMT_NO, X.DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ, X.REF_NO," ).append("\n"); 
		query.append("		SUBSTR(Y.VNDR_ABBR_NM,0,8) AS VNDR_ABBR_NM, Y.VNDR_LGL_ENG_NM, " ).append("\n"); 
		query.append("		TO_CHAR(Y.VNDR_SEQ) AS MFT_VNDR_SEQ, X.DEL_CD, X.CNTR_TPSZ_CD, X.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("		DECODE(X.RSLT_TP_SEQ, 1, 'Plan', 2, 'PFMC', 3, 'Ratio') AS RSLT_TP, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) AS MNTH_01, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) AS MNTH_02, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) AS MNTH_03, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) AS MNTH_04, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) AS MNTH_05, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) AS MNTH_06, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) AS MNTH_07, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) AS MNTH_08, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) AS MNTH_09, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) AS MNTH_10, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) AS MNTH_11, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS MNTH_12, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRST_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS SCND_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS THRD_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRTH_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS YR_TOT" ).append("\n"); 
		query.append("FROM   	TEMP_DROP X, " ).append("\n"); 
		query.append("		MDM_VENDOR Y" ).append("\n"); 
		query.append("WHERE  	Y.VNDR_SEQ = X.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("GROUP BY X.PLN_YRMON, X.AGMT_NO, X.DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ,X.REF_NO, Y.VNDR_ABBR_NM, " ).append("\n"); 
		query.append("		 Y.VNDR_LGL_ENG_NM, Y.VNDR_SEQ, X.CNTR_TPSZ_CD, X.DEL_CD, X.RSLT_TP_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	X.PLN_YRMON, X.AGMT_NO, X.DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ,X.REF_NO, " ).append("\n"); 
		query.append("		'S.TTL' AS VNDR_ABBR_NM, '' AS VNDR_LGL_ENG_NM, '' AS MFT_VNDR_SEQ, " ).append("\n"); 
		query.append("		'' AS DEL_CD, X.CNTR_TPSZ_CD, X.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("		DECODE(X.RSLT_TP_SEQ, 1, 'Plan', 2, 'PFMC', 3, 'Ratio') AS RSLT_TP, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) AS MNTH_01, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) AS MNTH_02, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) AS MNTH_03, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) AS MNTH_04, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) AS MNTH_05, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) AS MNTH_06, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) AS MNTH_07, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) AS MNTH_08, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) AS MNTH_09, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) AS MNTH_10, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) AS MNTH_11, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS MNTH_12, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRST_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS SCND_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS THRD_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRTH_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("              	+ SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS YR_TOT" ).append("\n"); 
		query.append("FROM   	TEMP_DROP X, " ).append("\n"); 
		query.append("		MDM_VENDOR Y" ).append("\n"); 
		query.append("WHERE  	Y.VNDR_SEQ = X.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("GROUP BY X.PLN_YRMON, X.AGMT_NO, X.DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ,X.REF_NO, X.CNTR_TPSZ_CD, X.RSLT_TP_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	X.PLN_YRMON, X.AGMT_NO, X.DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ,X.REF_NO, " ).append("\n"); 
		query.append("		'S.TTL' AS VNDR_ABBR_NM, '' AS VNDR_LGL_ENG_NM, '' AS MFT_VNDR_SEQ, " ).append("\n"); 
		query.append("		'' AS DEL_CD, 'Total' AS CNTR_TPSZ_CD, X.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("		DECODE(X.RSLT_TP_SEQ, 1, 'Plan', 2, 'PFMC', 3, 'Ratio') AS RSLT_TP, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) AS MNTH_01, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) AS MNTH_02, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) AS MNTH_03, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) AS MNTH_04, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) AS MNTH_05, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) AS MNTH_06, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) AS MNTH_07, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) AS MNTH_08, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) AS MNTH_09, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) AS MNTH_10, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) AS MNTH_11, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS MNTH_12, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRST_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS SCND_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS THRD_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRTH_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("              	+ SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS YR_TOT" ).append("\n"); 
		query.append("FROM   	TEMP_DROP X, " ).append("\n"); 
		query.append("		MDM_VENDOR Y" ).append("\n"); 
		query.append("WHERE  	Y.VNDR_SEQ = X.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("GROUP BY X.PLN_YRMON, X.AGMT_NO, X.DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ,X.REF_NO, X.RSLT_TP_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	X.PLN_YRMON, X.AGMT_NO, 'G.TTL' AS DE_YR, X.AGMT_CTY_CD, X.AGMT_SEQ, X.REF_NO," ).append("\n"); 
		query.append("		'' AS VNDR_ABBR_NM, '' AS VNDR_LGL_ENG_NM, '' AS MFT_VNDR_SEQ, " ).append("\n"); 
		query.append("		'' AS DEL_CD, '' AS CNTR_TPSZ_CD, X.RSLT_TP_SEQ, " ).append("\n"); 
		query.append("		DECODE(X.RSLT_TP_SEQ, 1, 'Plan', 2, 'PFMC', 3, 'Ratio') AS RSLT_TP, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) AS MNTH_01, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) AS MNTH_02, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) AS MNTH_03, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) AS MNTH_04, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) AS MNTH_05, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'06',DE_QTY,0)) AS MNTH_06, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) AS MNTH_07, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) AS MNTH_08, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) AS MNTH_09, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) AS MNTH_10, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) AS MNTH_11, " ).append("\n"); 
		query.append("		SUM(DECODE(X.DE_MON,'12',DE_QTY,0)) AS MNTH_12, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRST_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS SCND_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS THRD_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS FRTH_QURT_TOT, " ).append("\n"); 
		query.append("		CASE WHEN X.RSLT_TP_SEQ = 1 OR X.RSLT_TP_SEQ = 2 " ).append("\n"); 
		query.append("			 THEN SUM(DECODE(X.DE_MON,'01',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'02',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'03',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'04',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'05',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'06',DE_QTY,0))" ).append("\n"); 
		query.append("                + SUM(DECODE(X.DE_MON,'07',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'08',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'09',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'10',DE_QTY,0)) " ).append("\n"); 
		query.append("				+ SUM(DECODE(X.DE_MON,'11',DE_QTY,0)) + SUM(DECODE(X.DE_MON,'12',DE_QTY,0))" ).append("\n"); 
		query.append("             WHEN X.RSLT_TP_SEQ = 3 THEN 0 " ).append("\n"); 
		query.append("		END AS YR_TOT" ).append("\n"); 
		query.append("FROM   	TEMP_DROP X, " ).append("\n"); 
		query.append("		MDM_VENDOR Y" ).append("\n"); 
		query.append("WHERE  	Y.VNDR_SEQ = X.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("GROUP BY X.PLN_YRMON, X.AGMT_NO, X.AGMT_CTY_CD, X.AGMT_SEQ,X.REF_NO, X.RSLT_TP_SEQ" ).append("\n"); 
		query.append("ORDER BY PLN_YRMON, AGMT_NO, DE_YR, AGMT_CTY_CD, AGMT_SEQ, VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("         CNTR_TPSZ_CD, DEL_CD, VNDR_ABBR_NM, RSLT_TP_SEQ, RSLT_TP" ).append("\n"); 

	}
}