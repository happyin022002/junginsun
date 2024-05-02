/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAOLongTermCNTRDeliveryPerformanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.12.03 남궁진호
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

public class LeasePlanDBDAOLongTermCNTRDeliveryPerformanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Long Term Container Delivery Plan & Performance List Search
	  *  2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
	  * </pre>
	  */
	public LeasePlanDBDAOLongTermCNTRDeliveryPerformanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOLongTermCNTRDeliveryPerformanceListRSQL").append("\n"); 
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
		query.append("SELECT DD.PLN_YR" ).append("\n"); 
		query.append("     , DD.DE_YR" ).append("\n"); 
		query.append("     , NVL(DD.AGMT_NO, 'G.TTL') AS AGMT_NO" ).append("\n"); 
		query.append("	 , DD.REF_NO" ).append("\n"); 
		query.append("     , NVL2(DD.MFT_VNDR_SEQ, SUBSTR(VNDR.VNDR_ABBR_NM,0,3), NVL2(DD.AGMT_NO,'S.TTL','')) AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , DD.DEL_CD" ).append("\n"); 
		query.append("     , DD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DD.TYPE_CD AS RSLT_TP_SEQ" ).append("\n"); 
		query.append("     , DECODE(DD.TYPE_CD, 1, 'Plan', 2, 'PFMC', 3, 'Ratio') AS RSLT_TP" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '01', DD.VAL, 0)) AS MNTH_01" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '02', DD.VAL, 0)) AS MNTH_02" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '03', DD.VAL, 0)) AS MNTH_03" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '14', DD.VAL, 0)) AS FRST_QURT_TOT" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '04', DD.VAL, 0)) AS MNTH_04" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '05', DD.VAL, 0)) AS MNTH_05" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '06', DD.VAL, 0)) AS MNTH_06" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '24', DD.VAL, 0)) AS SCND_QURT_TOT" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '07', DD.VAL, 0)) AS MNTH_07" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '08', DD.VAL, 0)) AS MNTH_08" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '09', DD.VAL, 0)) AS MNTH_09" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '34', DD.VAL, 0)) AS THRD_QURT_TOT" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '10', DD.VAL, 0)) AS MNTH_10" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '11', DD.VAL, 0)) AS MNTH_11" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '12', DD.VAL, 0)) AS MNTH_12" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, '44', DD.VAL, 0)) AS FRTH_QURT_TOT" ).append("\n"); 
		query.append("     , SUM(DECODE(DD.DE_MON, 'S.TTL', DD.VAL, 0)) AS YR_TOT" ).append("\n"); 
		query.append("FROM   ( " ).append("\n"); 
		query.append("         SELECT BB.PLN_YR" ).append("\n"); 
		query.append("              , BB.DE_YR" ).append("\n"); 
		query.append("              , BB.AGMT_NO" ).append("\n"); 
		query.append("			  , AGMT.REF_NO" ).append("\n"); 
		query.append("              , BB.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("              , BB.DEL_CD" ).append("\n"); 
		query.append("              , BB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , NVL(BB.DE_MON, 'S.TTL') AS DE_MON" ).append("\n"); 
		query.append("              , TP.TYPE_CD" ).append("\n"); 
		query.append("              , DECODE(TP.TYPE_CD," ).append("\n"); 
		query.append("                           1, BB.PLAN_DE_QTY," ).append("\n"); 
		query.append("                           2, BB.PFMC_DE_QTY," ).append("\n"); 
		query.append("                           DECODE(BB.PLAN_DE_QTY, 0, 0, ROUND(BB.PFMC_DE_QTY/BB.PLAN_DE_QTY*100, 2))" ).append("\n"); 
		query.append("                ) AS VAL" ).append("\n"); 
		query.append("              --, DECODE(BB.GRP_ID, 1, 0, 7, 6, 31, 30, GRP_ID) AS GRP_ID" ).append("\n"); 
		query.append("              , DECODE(BB.GRP_ID, 1, 0, 15, 14, 31, 30, GRP_ID) AS GRP_ID" ).append("\n"); 
		query.append("         FROM   ( " ).append("\n"); 
		query.append("                  SELECT AA.PLN_YR" ).append("\n"); 
		query.append("                       , AA.DE_YR" ).append("\n"); 
		query.append("                       , AA.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                       , AA.AGMT_NO" ).append("\n"); 
		query.append("                       , AA.DEL_CD" ).append("\n"); 
		query.append("                       , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                       , AA.DE_MON" ).append("\n"); 
		query.append("                       , CASE WHEN AA.DE_MON IS NULL THEN SUM(AA.PLAN_DE_QTY)/2 ELSE SUM(AA.PLAN_DE_QTY) END AS PLAN_DE_QTY -- 분기별 합계 데이터로 인해 수량이 2배 뻥튀기 됨으로 2로 나눔." ).append("\n"); 
		query.append("                       , CASE WHEN AA.DE_MON IS NULL THEN SUM(AA.PFMC_DE_QTY)/2 ELSE SUM(AA.PFMC_DE_QTY) END AS PFMC_DE_QTY -- 분기별 합계 데이터로 인해 수량이 2배 뻥튀기 됨으로 2로 나눔." ).append("\n"); 
		query.append("                       , GROUPING_ID ( AA.PLN_YR" ).append("\n"); 
		query.append("                                     , AA.DE_YR" ).append("\n"); 
		query.append("                                     , AA.AGMT_NO" ).append("\n"); 
		query.append("                                     , AA.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                                     , AA.DEL_CD" ).append("\n"); 
		query.append("                                     , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , AA.DE_MON ) GRP_ID" ).append("\n"); 
		query.append("                  FROM   (" ).append("\n"); 
		query.append("                           SELECT A.PLN_YR" ).append("\n"); 
		query.append("                                , SUBSTR(A.DE_YRMON, 0, 4) AS DE_YR" ).append("\n"); 
		query.append("                                , A.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                                , A.AGMT_NO" ).append("\n"); 
		query.append("                                , A.DEL_CD" ).append("\n"); 
		query.append("                                , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                , CASE WHEN B.FLAG = 1 THEN SUBSTR(A.DE_YRMON, 5, 2)" ).append("\n"); 
		query.append("                                       ELSE CASE TO_CHAR(TO_DATE(A.DE_YRMON,'YYYYMM'),'Q')" ).append("\n"); 
		query.append("                                              WHEN '1' THEN '14'" ).append("\n"); 
		query.append("                                              WHEN '2' THEN '24'" ).append("\n"); 
		query.append("                                              WHEN '3' THEN '34'" ).append("\n"); 
		query.append("                                              WHEN '4' THEN '44'" ).append("\n"); 
		query.append("                                            END" ).append("\n"); 
		query.append("                                  END AS DE_MON" ).append("\n"); 
		query.append("                                , SUM(DECODE(B.FLAG, 1, A.PLAN_DE_QTY, A.PLAN_DE_QTY)) AS PLAN_DE_QTY" ).append("\n"); 
		query.append("                                , SUM(DECODE(B.FLAG, 1, A.PFMC_DE_QTY, A.PFMC_DE_QTY)) AS PFMC_DE_QTY" ).append("\n"); 
		query.append("                           FROM   (" ).append("\n"); 
		query.append("                                    SELECT PLN.PLN_YR" ).append("\n"); 
		query.append("                                         , PLN.DE_YRMON" ).append("\n"); 
		query.append("                                         , PLN.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                                         , PLN.AGMT_CTY_CD || LPAD(PLN.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("                                         , C.LCC_CD AS DEL_CD" ).append("\n"); 
		query.append("                                         , PLN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         , PLN.DE_QTY AS PLAN_DE_QTY" ).append("\n"); 
		query.append("                                         , 0          AS PFMC_DE_QTY" ).append("\n"); 
		query.append("										 , C.RCC_CD, C.LCC_CD, C.SCC_CD" ).append("\n"); 
		query.append("                                    FROM   LSE_LONG_TERM_DE_PLN PLN" ).append("\n"); 
		query.append("										 , MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("                                    WHERE  1 = 1" ).append("\n"); 
		query.append("									AND    PLN.DEL_CD = C.SCC_CD" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                                    AND    PLN.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("                                                                '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                                '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("#if (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("                                    AND    C.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("                                    AND    C.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                    AND    C.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_mon} != '')" ).append("\n"); 
		query.append("                                    AND    SUBSTR(PLN.DE_YRMON,5,2) IN (" ).append("\n"); 
		query.append("#foreach($key IN ${de_mon_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $de_mon_seq.size())" ).append("\n"); 
		query.append("                                                                        '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                                        '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mft_vndr_seq} != '')" ).append("\n"); 
		query.append("                                    AND    PLN.MFT_VNDR_SEQ = @[mft_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("                                    AND    PLN.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '')" ).append("\n"); 
		query.append("                                    AND    PLN.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pln_yr} != '')" ).append("\n"); 
		query.append("                                    AND    PLN.PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                    UNION ALL" ).append("\n"); 
		query.append("                                    SELECT NVL(PLN.PLN_YR, @[pln_yr])			 AS PLN_YR" ).append("\n"); 
		query.append("                                         , TO_CHAR(HS.CNTR_STS_EVNT_DT,'YYYYMM') AS DE_YRMON" ).append("\n"); 
		query.append("                                         , CN.VNDR_SEQ                           AS MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                                         , HS.AGMT_CTY_CD || LPAD(HS.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("                                         , HS.LCC_CD                             AS DEL_CD" ).append("\n"); 
		query.append("                                         , CN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                         , 0                                     AS PLAN_DE_QTY" ).append("\n"); 
		query.append("                                         , COUNT(CN.CNTR_NO)                     AS PFMC_DE_QTY" ).append("\n"); 
		query.append("										 , HS.RCC_CD, HS.LCC_CD, HS.SCC_CD" ).append("\n"); 
		query.append("                                    FROM   MST_CONTAINER        CN" ).append("\n"); 
		query.append("                                         , MST_CNTR_STS_HIS     HS" ).append("\n"); 
		query.append("                                         , ( SELECT DISTINCT PLN_YR, AGMT_CTY_CD, AGMT_SEQ" ).append("\n"); 
		query.append("                                             FROM   LSE_LONG_TERM_DE_PLN" ).append("\n"); 
		query.append("                                             WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${mft_vndr_seq} != '')" ).append("\n"); 
		query.append("                                             AND    MFT_VNDR_SEQ = @[mft_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("                                             AND    AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '')" ).append("\n"); 
		query.append("                                             AND    AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pln_yr} != '')" ).append("\n"); 
		query.append("                                             AND    PLN_YR = @[pln_yr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                           ) PLN" ).append("\n"); 
		query.append("                                    WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                                    AND    CN.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("                                                                '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                                '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                    AND    CN.CNTR_NO = HS.CNTR_NO" ).append("\n"); 
		query.append("                                    AND    SUBSTR(nvl(HS.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("                                    AND    HS.CNTR_LSTM_CNG_FLG <> 'Y'" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("#if (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("                                    AND    HS.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("                                    AND    HS.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                    AND    HS.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_mon} != '')" ).append("\n"); 
		query.append("                                    AND    TO_CHAR(HS.CNTR_STS_EVNT_DT,'MM') IN (" ).append("\n"); 
		query.append("#foreach($key IN ${de_mon_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $de_mon_seq.size())" ).append("\n"); 
		query.append("                                                                                 '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                                                 '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                    AND    HS.CNTR_STS_CD in ('LSI','DII')" ).append("\n"); 
		query.append("                                    AND    HS.AGMT_SEQ    = PLN.AGMT_SEQ(+)" ).append("\n"); 
		query.append("                                    AND    HS.AGMT_CTY_CD = PLN.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("									AND    HS.CNTR_STS_EVNT_DT >= TO_DATE(@[pln_yr]||'01', 'YYYYMM')" ).append("\n"); 
		query.append("                                    AND    CN.LSTM_CD = 'LT'" ).append("\n"); 
		query.append("                                    GROUP  BY PLN.PLN_YR" ).append("\n"); 
		query.append("                                            , TO_CHAR(HS.CNTR_STS_EVNT_DT,'YYYYMM')" ).append("\n"); 
		query.append("                                            , HS.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                            , HS.AGMT_SEQ" ).append("\n"); 
		query.append("                                            , CN.VNDR_SEQ" ).append("\n"); 
		query.append("                                            , CN.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("											, HS.RCC_CD, HS.LCC_CD, HS.SCC_CD" ).append("\n"); 
		query.append("                                  ) A" ).append("\n"); 
		query.append("                                , ( SELECT LEVEL FLAG FROM DUAL CONNECT BY LEVEL <= 2 ) B" ).append("\n"); 
		query.append("                           GROUP  BY A.PLN_YR" ).append("\n"); 
		query.append("                                   , SUBSTR(A.DE_YRMON, 0, 4)" ).append("\n"); 
		query.append("                                   , A.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                                   , A.AGMT_NO" ).append("\n"); 
		query.append("                                   , A.DEL_CD" ).append("\n"); 
		query.append("                                   , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                   , ( CASE WHEN B.FLAG = 1 THEN SUBSTR(A.DE_YRMON, 5, 2)" ).append("\n"); 
		query.append("                                            ELSE CASE TO_CHAR(TO_DATE(A.DE_YRMON,'YYYYMM'),'Q')" ).append("\n"); 
		query.append("                                                   WHEN '1' THEN '14'" ).append("\n"); 
		query.append("                                                   WHEN '2' THEN '24'" ).append("\n"); 
		query.append("                                                   WHEN '3' THEN '34'" ).append("\n"); 
		query.append("                                                   WHEN '4' THEN '44'" ).append("\n"); 
		query.append("                                                 END" ).append("\n"); 
		query.append("                                       END )" ).append("\n"); 
		query.append("                         ) AA" ).append("\n"); 
		query.append("                  GROUP  BY CUBE ( AA.PLN_YR" ).append("\n"); 
		query.append("                                 , AA.DE_YR" ).append("\n"); 
		query.append("                                 , AA.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("                                 , AA.AGMT_NO" ).append("\n"); 
		query.append("                                 , AA.DEL_CD" ).append("\n"); 
		query.append("                                 , AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                 , AA.DE_MON )" ).append("\n"); 
		query.append("                ) BB" ).append("\n"); 
		query.append("              , ( SELECT LEVEL TYPE_CD FROM DUAL CONNECT BY LEVEL <= 3 ) TP" ).append("\n"); 
		query.append("			  , LSE_AGREEMENT AGMT" ).append("\n"); 
		query.append("         WHERE  GRP_ID IN (0, 1, 14, 15, 30, 31)" ).append("\n"); 
		query.append("         AND BB.AGMT_NO = AGMT.AGMT_CTY_CD || LPAD(AGMT.AGMT_SEQ, 6, '0')" ).append("\n"); 
		query.append("         --WHERE  GRP_ID IN (0, 1, 6, 7, 30, 31)         " ).append("\n"); 
		query.append("       ) DD" ).append("\n"); 
		query.append("     , MDM_VENDOR VNDR" ).append("\n"); 
		query.append("WHERE  DD.MFT_VNDR_SEQ = VNDR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("GROUP  BY DD.PLN_YR" ).append("\n"); 
		query.append("        , DD.DE_YR" ).append("\n"); 
		query.append("        , DD.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("        , VNDR.VNDR_ABBR_NM" ).append("\n"); 
		query.append("        , DD.AGMT_NO" ).append("\n"); 
		query.append("		, DD.REF_NO" ).append("\n"); 
		query.append("        , DD.DEL_CD" ).append("\n"); 
		query.append("        , DD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , DD.TYPE_CD" ).append("\n"); 
		query.append("ORDER  BY DD.PLN_YR" ).append("\n"); 
		query.append("        , DD.DE_YR" ).append("\n"); 
		query.append("        , DD.AGMT_NO" ).append("\n"); 
		query.append("        , DD.MFT_VNDR_SEQ" ).append("\n"); 
		query.append("        , DD.DEL_CD" ).append("\n"); 
		query.append("        , DD.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , DD.TYPE_CD" ).append("\n"); 

	}
}