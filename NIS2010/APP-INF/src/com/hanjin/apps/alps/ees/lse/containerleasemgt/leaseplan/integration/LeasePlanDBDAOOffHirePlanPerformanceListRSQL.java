/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAOOffHirePlanPerformanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.05.18 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAOOffHirePlanPerformanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Off-Hire Plan Performance List Search
	  * </pre>
	  */
	public LeasePlanDBDAOOffHirePlanPerformanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_offh_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_offh_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_pln_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAOOffHirePlanPerformanceListRSQL").append("\n"); 
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
		query.append("SELECT NVL(OFFH_RGN_LOC_CD,'G.TTL') AS OFFH_RGN_LOC_CD," ).append("\n"); 
		query.append("       DECODE(NVL(OFFH_RGN_LOC_CD,'G.TTL'),'G.TTL','',NVL(OFFH_LOC_CD,'TTL')) AS OFFH_LOC_CD," ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} == 'O' )" ).append("\n"); 
		query.append("       DECODE(NVL(OFFH_RGN_LOC_CD,'G.TTL'),'G.TTL','',LSTM_CD) AS LSTM_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       DECODE(NVL(OFFH_RGN_LOC_CD,'G.TTL'),'G.TTL','',NVL(LSTM_CD,'TTL')) AS LSTM_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       TYPE_CD," ).append("\n"); 
		query.append("       DECODE(TYPE_CD, 1, 'Plan', 2, 'PFMC', 3, 'Ratio') AS TYPE_NM," ).append("\n"); 
		query.append("#foreach($key IN ${offh_yrmon_seq})" ).append("\n"); 
		query.append("#set ($col_name='MNTH_'+$velocityCount)" ).append("\n"); 
		query.append("       MAX(DECODE(OFFH_YRMON, '$key', VAL, DECODE(TYPE_CD, 3, '0%', '0'))) AS $col_name," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       MAX(DECODE(OFFH_YRMON, 'G.TTL',  VAL, DECODE(TYPE_CD, 3, '0%', '0'))) AS TTL_QTY" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT AA.OFFH_RGN_LOC_CD," ).append("\n"); 
		query.append("                AA.OFFH_LOC_CD," ).append("\n"); 
		query.append("                AA.LSTM_CD," ).append("\n"); 
		query.append("                AA.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                NVL(AA.OFFH_YRMON, 'G.TTL') AS OFFH_YRMON," ).append("\n"); 
		query.append("                TP.TYPE_CD," ).append("\n"); 
		query.append("                DECODE(TP.TYPE_CD, 1, TRIM(TO_CHAR(AA.PLAN_OFFH_QTY,'999,999,999')), " ).append("\n"); 
		query.append("                                   2, TRIM(TO_CHAR(AA.PFMC_OFFH_QTY,'999,999,999')), " ).append("\n"); 
		query.append("                                   DECODE(AA.PLAN_OFFH_QTY, 0, '0%', TO_CHAR(ROUND(AA.PFMC_OFFH_QTY/AA.PLAN_OFFH_QTY*100, 2))||'%')) AS VAL" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                  SELECT OFFH_RGN_LOC_CD," ).append("\n"); 
		query.append("                         OFFH_LOC_CD," ).append("\n"); 
		query.append("                         LSTM_CD," ).append("\n"); 
		query.append("                         CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                         OFFH_YRMON," ).append("\n"); 
		query.append("                         SUM(PLAN_OFFH_QTY) AS PLAN_OFFH_QTY," ).append("\n"); 
		query.append("                         SUM(PFMC_OFFH_QTY) AS PFMC_OFFH_QTY," ).append("\n"); 
		query.append("                         GROUPING_ID ( OFFH_RGN_LOC_CD," ).append("\n"); 
		query.append("                                       OFFH_LOC_CD," ).append("\n"); 
		query.append("                                       LSTM_CD," ).append("\n"); 
		query.append("                                       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                       OFFH_YRMON ) AS GRP_ID" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                           SELECT A.OFFH_YRMON," ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} == 'O' )" ).append("\n"); 
		query.append("                                  'ALL' AS LSTM_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                  A.LSTM_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                  A.OFFH_RGN_LOC_CD," ).append("\n"); 
		query.append("                                  A.OFFH_LOC_CD," ).append("\n"); 
		query.append("                                  A.OFFH_QTY AS PLAN_OFFH_QTY," ).append("\n"); 
		query.append("                                  0 AS PFMC_OFFH_QTY" ).append("\n"); 
		query.append("                             FROM LSE_OFFH_PLN A" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("                              AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("                                                      '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                      '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${offh_yrmon} != '' )" ).append("\n"); 
		query.append("                              AND A.OFFH_YRMON IN (" ).append("\n"); 
		query.append("#foreach($key IN ${offh_yrmon_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $offh_yrmon_seq.size())" ).append("\n"); 
		query.append("                                                    '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                    '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${lstm_cd} != '' )" ).append("\n"); 
		query.append("                              AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${loc_cd} != '' )" ).append("\n"); 
		query.append("#if ( ${loc_tp} == 'RCC' )" ).append("\n"); 
		query.append("                              AND A.OFFH_RGN_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif ( ${loc_tp} == 'LCC' )" ).append("\n"); 
		query.append("                              AND A.OFFH_LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} != '' )" ).append("\n"); 
		query.append("                              AND A.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${offh_loc_tp_cd} != '' )" ).append("\n"); 
		query.append("                              AND A.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                              AND A.OFFH_VER_SEQ = ( SELECT /*+ INDEX_DESC (B XPKLSE_OFFH_PLN) */" ).append("\n"); 
		query.append("                                                            OFFH_VER_SEQ" ).append("\n"); 
		query.append("                                                       FROM LSE_OFFH_PLN B" ).append("\n"); 
		query.append("                                                      WHERE 1 = 1" ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} != '' )" ).append("\n"); 
		query.append("                                                        AND B.OFFH_PLN_TP_CD = @[offh_pln_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${offh_loc_tp_cd} != '' )" ).append("\n"); 
		query.append("                                                        AND B.OFFH_LOC_TP_CD = @[offh_loc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                        AND B.OFFH_VER_SEQ > 0" ).append("\n"); 
		query.append("                                                        AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                           UNION ALL" ).append("\n"); 
		query.append("                           SELECT TO_CHAR(B.CNTR_STS_EVNT_DT, 'YYYYMM') AS OFFH_YRMON," ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} == 'O' )" ).append("\n"); 
		query.append("                                  'ALL' AS LSTM_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                  A.LSTM_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                  B.RCC_CD AS OFFH_RGN_LOC_CD," ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} == 'O' )" ).append("\n"); 
		query.append("                                  B.LCC_CD AS OFFH_LOC_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                  B.RCC_CD AS OFFH_LOC_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                  0 AS PLAN_OFFH_QTY," ).append("\n"); 
		query.append("                                  COUNT(B.CNTR_NO) AS PFMC_OFFH_QTY" ).append("\n"); 
		query.append("                             FROM MST_CONTAINER C," ).append("\n"); 
		query.append("                                  MST_CNTR_STS_HIS B," ).append("\n"); 
		query.append("                                  LSE_AGREEMENT A" ).append("\n"); 
		query.append("                            WHERE C.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if ( ${cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("                              AND C.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("                                                     '$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                     '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                              AND C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                              AND SUBSTR(NVL(B.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("                              AND B.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("                              AND B.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                              AND B.CNTR_STS_EVNT_DT BETWEEN TO_DATE(@[from_offh_yrmon], 'YYYY-MM') AND LAST_DAY(TO_DATE(@[to_offh_yrmon], 'YYYY-MM'))+0.99999" ).append("\n"); 
		query.append("#if ( ${loc_cd} != '' )" ).append("\n"); 
		query.append("#if ( ${loc_tp} == 'RCC' )" ).append("\n"); 
		query.append("                              AND B.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif ( ${loc_tp} == 'LCC' )" ).append("\n"); 
		query.append("                              AND B.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                              --AND B.CNTR_STS_CD IN ('LSO', 'DIO', 'TLL', 'SRO', 'DON', 'SCR', 'SLD')" ).append("\n"); 
		query.append("                              AND B.CNTR_STS_CD IN ('LSO', 'DIO')" ).append("\n"); 
		query.append("                              AND B.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("                              AND B.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("#if ( ${lstm_cd} != '' )" ).append("\n"); 
		query.append("                              AND A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                              AND A.LSTM_CD IN ('LT','ST')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            GROUP BY B.CNTR_STS_EVNT_DT, A.LSTM_CD, C.CNTR_TPSZ_CD, B.RCC_CD, " ).append("\n"); 
		query.append("#if ( ${offh_pln_tp_cd} == 'O' )" ).append("\n"); 
		query.append("                                  B.LCC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                  B.RCC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                   GROUP BY CUBE ( OFFH_RGN_LOC_CD, OFFH_LOC_CD, LSTM_CD, CNTR_TPSZ_CD, OFFH_YRMON )" ).append("\n"); 
		query.append("                ) AA" ).append("\n"); 
		query.append("              , ( SELECT LEVEL TYPE_CD FROM DUAL CONNECT BY LEVEL <= 3 ) TP" ).append("\n"); 
		query.append("          WHERE GRP_ID IN (0,1,14,15,30,31)" ).append("\n"); 
		query.append("       ) BB" ).append("\n"); 
		query.append(" GROUP BY BB.OFFH_RGN_LOC_CD, BB.OFFH_LOC_CD, BB.LSTM_CD, BB.CNTR_TPSZ_CD, BB.TYPE_CD" ).append("\n"); 
		query.append(" ORDER BY BB.OFFH_RGN_LOC_CD, BB.OFFH_LOC_CD, BB.LSTM_CD, BB.CNTR_TPSZ_CD, BB.TYPE_CD" ).append("\n"); 

	}
}