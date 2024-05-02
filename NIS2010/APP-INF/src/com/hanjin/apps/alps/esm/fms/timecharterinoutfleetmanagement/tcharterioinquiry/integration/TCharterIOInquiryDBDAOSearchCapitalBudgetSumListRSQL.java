/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOSearchCapitalBudgetSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOSearchCapitalBudgetSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInquiryDBDAOSearchCapitalBudgetSumListRSQL
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOSearchCapitalBudgetSumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration").append("\n"); 
		query.append("FileName : TCharterIOInquiryDBDAOSearchCapitalBudgetSumListRSQL").append("\n"); 
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
		query.append("SELECT  TI_CURR_CD,TI_INV_AMT,TI_CURR_CD2,TI_INV_AMT2,TO_CURR_CD,TO_INV_AMT,TO_CURR_CD2,TO_INV_AMT2" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  TI_CURR_CD" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY TI_CURR_CD ORDER BY TI_INV_AMT) AS NO01" ).append("\n"); 
		query.append(", SUM(TI_INV_AMT) OVER (PARTITION BY TI_CURR_CD) AS TI_INV_AMT" ).append("\n"); 
		query.append(", TI_CURR_CD2" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY TI_CURR_CD2 ORDER BY TI_INV_AMT2) AS NO02" ).append("\n"); 
		query.append(", SUM(TI_INV_AMT2) OVER (PARTITION BY TI_CURR_CD2) TI_INV_AMT2" ).append("\n"); 
		query.append(", TO_CURR_CD" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY TO_CURR_CD ORDER BY TO_INV_AMT) AS NO03" ).append("\n"); 
		query.append(", SUM(TO_INV_AMT) OVER (PARTITION BY TO_CURR_CD) TO_INV_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TO_CURR_CD2" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY TO_CURR_CD2 ORDER BY TO_INV_AMT2) AS NO04" ).append("\n"); 
		query.append(", SUM(TO_INV_AMT2) OVER (PARTITION BY TO_CURR_CD2) TO_INV_AMT2" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  TI_C11 AS TI_CURR_CD," ).append("\n"); 
		query.append("SUM(TI_V11) AS TI_INV_AMT, TI_C12 AS TI_CURR_CD2, SUM(TI_V12) AS TI_INV_AMT2, TO_C21 AS TO_CURR_CD," ).append("\n"); 
		query.append("SUM(TO_V21) AS TO_INV_AMT, TO_C22 AS TO_CURR_CD2, SUM(TO_V22) AS TO_INV_AMT2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DT," ).append("\n"); 
		query.append("AGMT," ).append("\n"); 
		query.append("VSL_NM ," ).append("\n"); 
		query.append("DECODE(IO, 'TI', CUR01 ) AS TI_C11 ," ).append("\n"); 
		query.append("DECODE(IO, 'TI', TTL_AMT01) AS TI_V11 ," ).append("\n"); 
		query.append("DECODE(IO, 'TI', CUR02 ) AS TI_C12 ," ).append("\n"); 
		query.append("DECODE(IO, 'TI', TTL_AMT02) AS TI_V12 ," ).append("\n"); 
		query.append("DECODE(IO, 'TO', CUR01 ) AS TO_C21 ," ).append("\n"); 
		query.append("DECODE(IO, 'TO', TTL_AMT01) AS TO_V21 ," ).append("\n"); 
		query.append("DECODE(IO, 'TO', CUR02 ) AS TO_C22 ," ).append("\n"); 
		query.append("DECODE(IO, 'TO', TTL_AMT02) AS TO_V22" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT AGMT," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("PAY_TP," ).append("\n"); 
		query.append("RK," ).append("\n"); 
		query.append("DT," ).append("\n"); 
		query.append("DT2," ).append("\n"); 
		query.append("TO_DT," ).append("\n"); 
		query.append("DIFF_MIN ," ).append("\n"); 
		query.append("SUBSTR(AGMT, 5, 2) AS IO ," ).append("\n"); 
		query.append("CALC_POINT ," ).append("\n"); 
		query.append("KEY_VALUE ," ).append("\n"); 
		query.append("AMT01," ).append("\n"); 
		query.append("CUR01," ).append("\n"); 
		query.append("AMT02," ).append("\n"); 
		query.append("AMT03," ).append("\n"); 
		query.append("CUR02 ," ).append("\n"); 
		query.append("ROUND(SUM(AMT03) OVER (PARTITION BY KEY_VALUE), 2) AS TTL_AMT01 ," ).append("\n"); 
		query.append("ROUND(SUM(AMT04) OVER (PARTITION BY KEY_VALUE), 2) AS TTL_AMT02" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT AGMT," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("PAY_TP," ).append("\n"); 
		query.append("RK," ).append("\n"); 
		query.append("DT," ).append("\n"); 
		query.append("DT2," ).append("\n"); 
		query.append("TO_DT," ).append("\n"); 
		query.append("(DT2 - DT) * (24 * 60) AS DIFF_MIN," ).append("\n"); 
		query.append("AMT01," ).append("\n"); 
		query.append("CUR01," ).append("\n"); 
		query.append("AMT02," ).append("\n"); 
		query.append("( (DT2 - DT) * (24 * 60) * AMT01) AS AMT03," ).append("\n"); 
		query.append("( (DT2 - DT) * (24 * 60) * AMT02) AS AMT04," ).append("\n"); 
		query.append("CUR02," ).append("\n"); 
		query.append("CALC_POINT ," ).append("\n"); 
		query.append("AGMT ||'-'|| PAY_TP ||'-'|| RK ||'-'|| SUBSTR(MAX(CALC_POINT||TO_CHAR(DT, 'YYYY-MM-DD')) OVER (PARTITION BY AGMT, PAY_TP, RK" ).append("\n"); 
		query.append("ORDER BY DT ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW), 2, 10) AS KEY_VALUE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T01.* ," ).append("\n"); 
		query.append("NVL(LEAD(DT) OVER (PARTITION BY AGMT, T02.CTRT_PAY_TERM_CD" ).append("\n"); 
		query.append("ORDER BY AGMT, DT), CASE WHEN TO_DT < TO_DATE(TO_CHAR(DT, 'YYYYMMDD')||'235959', 'YYYYMMDDHH24MISS') THEN TO_DT ELSE TO_DATE(TO_CHAR(DT, 'YYYYMMDD')||'235959', 'YYYYMMDDHH24MISS') END ) AS DT2 ," ).append("\n"); 
		query.append("T02.EFF_DT ," ).append("\n"); 
		query.append("T02.EXP_DT ," ).append("\n"); 
		query.append("T02.CTRT_PAY_TERM_CD AS PAY_TP ," ).append("\n"); 
		query.append("DENSE_RANK() OVER (PARTITION BY AGMT" ).append("\n"); 
		query.append("ORDER BY AGMT, EFF_DT) AS RK ," ).append("\n"); 
		query.append("CASE WHEN (T02.CTRT_PAY_TERM_CD = 'A')" ).append("\n"); 
		query.append("AND (TO_CHAR(T01.DT, 'DD') IN ('01'," ).append("\n"); 
		query.append("'16')) THEN 'Y' WHEN (T02.CTRT_PAY_TERM_CD = 'B') THEN DECODE(MOD(ROW_NUMBER() OVER (PARTITION BY AGMT, T02.CTRT_PAY_TERM_CD" ).append("\n"); 
		query.append("ORDER BY AGMT, DT) + 14, 15), 0, 'Y', 'N') WHEN (T02.CTRT_PAY_TERM_CD = 'C')" ).append("\n"); 
		query.append("AND TO_CHAR(T01.DT, 'DD') = TO_CHAR(T01.FM_DT, 'DD') THEN 'Y' ELSE 'N' END AS CALC_POINT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT FLET_CTRT_NO AS AGMT," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("EFF_DT + SEQ AS DT," ).append("\n"); 
		query.append("EFF_DT AS FM_DT," ).append("\n"); 
		query.append("EXP_DT AS TO_DT ," ).append("\n"); 
		query.append("AMT01," ).append("\n"); 
		query.append("CUR01," ).append("\n"); 
		query.append("AMT02," ).append("\n"); 
		query.append("CUR02" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T01.FLET_CTRT_NO," ).append("\n"); 
		query.append("T01.EFF_DT," ).append("\n"); 
		query.append("T01.EXP_DT," ).append("\n"); 
		query.append("(T01.EXP_DT - T01.EFF_DT) AS TM," ).append("\n"); 
		query.append("VSL_ENG_NM AS VSL_NM ," ).append("\n"); 
		query.append("HIR_RT_N1ST_AMT / ( 24 * 60 ) AS AMT01 ," ).append("\n"); 
		query.append("HIR_CURR_N1ST_CD AS CUR01 ," ).append("\n"); 
		query.append("HIR_RT_N2ND_AMT / ( 24 * 60 ) AS AMT02 ," ).append("\n"); 
		query.append("HIR_CURR_N2ND_CD AS CUR02" ).append("\n"); 
		query.append("FROM FMS_HIRE T01," ).append("\n"); 
		query.append("MDM_VSL_CNTR T2, FMS_CONTRACT C" ).append("\n"); 
		query.append("WHERE SUBSTR(T01.FLET_CTRT_NO, 1, 4) = T2.VSL_CD" ).append("\n"); 
		query.append("AND C.FLET_CTRT_NO = T01.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND ((TO_DATE(@[eff_dt], 'YYYYMMDD' ) BETWEEN T01.EFF_DT AND T01.EXP_DT )" ).append("\n"); 
		query.append("OR (TO_DATE(@[eff_dt]||'235959', 'YYYYMMDDHH24MISS') BETWEEN T01.EFF_DT AND T01.EXP_DT )" ).append("\n"); 
		query.append("OR (T01.EFF_DT BETWEEN TO_DATE(@[eff_dt], 'YYYYMMDD' ) AND TO_DATE(@[exp_dt]||'235959', 'YYYYMMDDHH24MISS'))" ).append("\n"); 
		query.append("OR (T01.EXP_DT BETWEEN TO_DATE(@[eff_dt], 'YYYYMMDDHH24MI') AND TO_DATE(@[exp_dt]||'235959', 'YYYYMMDDHH24MISS')) /* 조회 기간*/" ).append("\n"); 
		query.append(") )," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ROWNUM - 1 AS SEQ" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE ROWNUM <= 5000) /* 최고 기간(EXP_DT - EFF_DT)을 약 13년을 설정했으며 그 이상이 되면 문제가 됨.*/" ).append("\n"); 
		query.append("WHERE SEQ BETWEEN 0 AND TM" ).append("\n"); 
		query.append("AND EFF_DT + SEQ <> EXP_DT /* FMS_HIRE에 대한 마지막 날짜와 다음 계약에 시작날짜가 중복 발생 방지 */" ).append("\n"); 
		query.append(") T01," ).append("\n"); 
		query.append("FMS_PAY_TERM T02" ).append("\n"); 
		query.append("WHERE 1 =1" ).append("\n"); 
		query.append("AND AGMT = T02.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND DT BETWEEN T02.EFF_DT AND T02.EXP_DT ) T11" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DT <> EXP_DT /* FMS_PAY_TERM에 대한 마지막 날짜와 다음 계약에 시작날짜가 중복 발생 방지 */" ).append("\n"); 
		query.append("ORDER BY AGMT, RK, DT ) T21" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY AGMT, RK, DT )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DT BETWEEN TO_DATE(@[eff_dt], 'YYYYMMDD') AND TO_DATE(@[exp_dt]||'235959', 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND CALC_POINT = 'Y'" ).append("\n"); 
		query.append("ORDER BY AGMT, DT )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY TI_C11," ).append("\n"); 
		query.append("TI_C12," ).append("\n"); 
		query.append("TO_C21," ).append("\n"); 
		query.append("TO_C22" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T51" ).append("\n"); 
		query.append("WHERE NO01 = 1" ).append("\n"); 

	}
}