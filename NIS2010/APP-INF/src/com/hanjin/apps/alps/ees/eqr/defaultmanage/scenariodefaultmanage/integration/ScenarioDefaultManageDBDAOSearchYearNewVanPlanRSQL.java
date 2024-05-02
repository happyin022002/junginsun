/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAOSearchYearNewVanPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScenarioDefaultManageDBDAOSearchYearNewVanPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_NEW_VAN_LONG_TERM, EQR_NEW_VAN_LONG_TERM_PERF 테이블 조회
	  * </pre>
	  */
	public ScenarioDefaultManageDBDAOSearchYearNewVanPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("leaseterm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration").append("\n"); 
		query.append("FileName : ScenarioDefaultManageDBDAOSearchYearNewVanPlanRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(B.NUM, 1, A.CO_CD, 		2, B.NAME, 3, A.CO_CD) CO_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.RCC_CD, 		2, '',     3, A.RCC_CD||' TTL') RCC_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.ECC_CD, 		2, '',     3, '')     ECC_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_TPSZ_CD, 2, '',     3, '')     CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_LSTM_CD, 2, '',     3, '')     CNTR_LSTM_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_ABBR_NM, 2, '',     3, '')     VNDR_ABBR_NM" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_CNT_CD||A.VNDR_SEQ, 	2, '',  3, '') VNDR_SEQ" ).append("\n"); 
		query.append(",A.STATUS" ).append("\n"); 
		query.append(",NVL(SUM(A.TOTAL),0) TOTAL" ).append("\n"); 
		query.append("#foreach(${key} IN ${monthArr})" ).append("\n"); 
		query.append(",NVL(SUM(A.QTY$key), 0) QTY$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("## HIDDEN" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_CNT_CD, 2, '',     3, '')      VNDR_CNT_CD" ).append("\n"); 
		query.append("## HIDDEN" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_ABBR_NM,2, '',     3, '')      VNDR_ABBR_NM" ).append("\n"); 
		query.append("## HIDDEN" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_SEQ,    2, '',     3, '')      VNDR_SEQ" ).append("\n"); 
		query.append("## HIDDEN" ).append("\n"); 
		query.append(",A.NUM" ).append("\n"); 
		query.append("## HIDDEN" ).append("\n"); 
		query.append(",B.NUM" ).append("\n"); 
		query.append("## MODIFY FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${key} in ${monthArr})" ).append("\n"); 
		query.append(",'F' FLAG$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD" ).append("\n"); 
		query.append(",A.CNTR_LSTM_CD" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.RCC_CD" ).append("\n"); 
		query.append(",A.ECC_CD" ).append("\n"); 
		query.append(",A.VNDR_ABBR_NM" ).append("\n"); 
		query.append(",A.VNDR_CNT_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",B.NUM" ).append("\n"); 
		query.append(",B.STATUS" ).append("\n"); 
		query.append(",SUM(DECODE(B.NUM, 1, A.QTY1, 2, A.QTY2, 3, A.QTY3, 4, QTY4)) TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${key} in ${monthArr})" ).append("\n"); 
		query.append(",SUM(DECODE(A.MONTH, '$key', DECODE(B.NUM, 1, A.QTY1, 2, A.QTY2, 3, A.QTY3, 4, QTY4))) AS QTY$key" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("## Status : Manufactured EQR_NEW_VAN_LONG_TERM - CNTR_VOL_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("##if (${company} == '')" ).append("\n"); 
		query.append("##	SELECT 'Both' CO_CD," ).append("\n"); 
		query.append("##else" ).append("\n"); 
		query.append("SELECT A.CO_CD," ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("B.PLN_YR || B.PLN_MON AS MONTH," ).append("\n"); 
		query.append("##'Manufactured' STATUS," ).append("\n"); 
		query.append("1 SEQ," ).append("\n"); 
		query.append("SUM(A.CNTR_VOL_QTY) AS QTY1," ).append("\n"); 
		query.append("0 QTY2," ).append("\n"); 
		query.append("0 QTY3," ).append("\n"); 
		query.append("0 QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM A," ).append("\n"); 
		query.append("EQR_WK_PRD B," ).append("\n"); 
		query.append("EQR_ECC_MST C" ).append("\n"); 
		query.append("WHERE SUBSTR(A.PLN_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("## AVAILABLE" ).append("\n"); 
		query.append("AND A.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND B.PLN_YR || B.PLN_WK = A.PLN_YRMON" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("B.PLN_YR || B.PLN_MON," ).append("\n"); 
		query.append("VNDR_ABBR_NM" ).append("\n"); 
		query.append("## Status : Auth Vol EQR_NEW_VAN_LONG_TERM_PERF - CNTR_AUTH_QTY" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("##if (${company} == '')" ).append("\n"); 
		query.append("##	SELECT 'Both' CO_CD," ).append("\n"); 
		query.append("##else" ).append("\n"); 
		query.append("SELECT A.CO_CD," ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON AS MONTH," ).append("\n"); 
		query.append("##--'Auth Vol.' STATUS," ).append("\n"); 
		query.append("2 SEQ," ).append("\n"); 
		query.append("##--A.PERF_YRMON," ).append("\n"); 
		query.append("0 QTY1," ).append("\n"); 
		query.append("MAX(A.CNTR_AUTH_QTY) AS QTY2," ).append("\n"); 
		query.append("0 QTY3," ).append("\n"); 
		query.append("0 QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM_PERF A," ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_ECC_MST C," ).append("\n"); 
		query.append("EQR_WK_PRD D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append("AND   A.ECC_CD       = B.ECC_CD" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   A.VNDR_CNT_CD  = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ     = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND   D.PLN_YR || D.PLN_WK = B.PLN_YRMON" ).append("\n"); 
		query.append("AND   D.PLN_YR || D.PLN_MON = A.PERF_YRMON" ).append("\n"); 
		query.append("AND   SUBSTR(A.PERF_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   SUBSTR(B.PLN_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON" ).append("\n"); 
		query.append("##-- Status : P/Up Vol EQR_NEW_VAN_LONG_TERM_PERF - CNTR_PKUP_QTY" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("##if (${company} == '')" ).append("\n"); 
		query.append("##	SELECT 'Both' CO_CD," ).append("\n"); 
		query.append("##else" ).append("\n"); 
		query.append("SELECT A.CO_CD," ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON AS MONTH," ).append("\n"); 
		query.append("##--'P/Up Vol.' STATUS," ).append("\n"); 
		query.append("3 SEQ," ).append("\n"); 
		query.append("0 QTY1," ).append("\n"); 
		query.append("0 QTY2," ).append("\n"); 
		query.append("MAX(A.CNTR_PKUP_QTY) AS QTY3," ).append("\n"); 
		query.append("0 QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM_PERF A," ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_ECC_MST C," ).append("\n"); 
		query.append("EQR_WK_PRD D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append("AND   A.ECC_CD       = B.ECC_CD" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   A.VNDR_CNT_CD  = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ     = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND   D.PLN_YR || D.PLN_WK = B.PLN_YRMON" ).append("\n"); 
		query.append("AND   D.PLN_YR || D.PLN_MON = A.PERF_YRMON" ).append("\n"); 
		query.append("AND   SUBSTR(A.PERF_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   SUBSTR(B.PLN_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON" ).append("\n"); 
		query.append("##-- Status : Balance EQR_NEW_VAN_LONG_TERM_PERF - CNTR_AUTH_QTY-CNTR_PKUP_QTY" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("##if (${company} == '')" ).append("\n"); 
		query.append("##	SELECT 'Both' CO_CD," ).append("\n"); 
		query.append("##else" ).append("\n"); 
		query.append("SELECT A.CO_CD," ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON AS MONTH," ).append("\n"); 
		query.append("##--'Balance' STATUS," ).append("\n"); 
		query.append("4 SEQ," ).append("\n"); 
		query.append("0 QTY1," ).append("\n"); 
		query.append("0 QTY2," ).append("\n"); 
		query.append("0 QTY3," ).append("\n"); 
		query.append("MAX(A.CNTR_AUTH_QTY-A.CNTR_PKUP_QTY) AS QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM_PERF A," ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_ECC_MST C," ).append("\n"); 
		query.append("EQR_WK_PRD D" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append("AND   A.ECC_CD       = B.ECC_CD" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   A.VNDR_CNT_CD  = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ     = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND   D.PLN_YR || D.PLN_WK = B.PLN_YRMON" ).append("\n"); 
		query.append("AND   D.PLN_YR || D.PLN_MON = A.PERF_YRMON" ).append("\n"); 
		query.append("AND   SUBSTR(A.PERF_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   SUBSTR(B.PLN_YRMON, 0, 4) = @[year]" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 1 NUM, 'Manufactured' STATUS FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 NUM, 'Auth Vol.' STATUS FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 3 NUM, 'P/Up Vol.' STATUS FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 4 NUM, 'Balance' STATUS FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("## loc 검색조건" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} != '')" ).append("\n"); 
		query.append("AND A.ECC_CD IN (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${key} in ${eccArr})" ).append("\n"); 
		query.append("#if($velocityCount < $eccArr.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("## type size 검색조건" ).append("\n"); 
		query.append("## TP/SZ 에 따른 조건값을 넣어 준다." ).append("\n"); 
		query.append("#if(${tpsztype} != '')" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("#foreach(${key} IN ${perfix1})" ).append("\n"); 
		query.append("#if($velocityCount < $perfix1.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("## company  검색조건" ).append("\n"); 
		query.append("##if(${company} != '')" ).append("\n"); 
		query.append("##    AND   A.CO_CD = --@ [company]" ).append("\n"); 
		query.append("##end" ).append("\n"); 
		query.append("## lease term 검색조건" ).append("\n"); 
		query.append("#if(${leaseterm} != '')" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = @[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("--A.MONTH," ).append("\n"); 
		query.append("B.NUM," ).append("\n"); 
		query.append("B.STATUS" ).append("\n"); 
		query.append(") A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 1 NUM, ''      NAME FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 NUM, 'TOTAL' NAME FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 3 NUM, 'TTL'   NAME FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("DECODE(B.NUM, 1, A.CO_CD, 	   2, B.NAME, 3, A.CO_CD)" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_LSTM_CD, 2, '',     3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_TPSZ_CD, 2, '', 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.RCC_CD, 	   2, '', 3, A.RCC_CD||' TTL')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.ECC_CD, 	   2, '', 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_ABBR_NM, 2, '', 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_CNT_CD||A.VNDR_SEQ, 	2, '', 3, '')" ).append("\n"); 
		query.append(",A.STATUS" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_CNT_CD, 2, '', 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_ABBR_NM,2, '', 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_SEQ,    2, '', 3, '')" ).append("\n"); 
		query.append("##-- STATUS" ).append("\n"); 
		query.append(",A.NUM" ).append("\n"); 
		query.append("##-- NORMAL, SUB, GRAND TOTAL" ).append("\n"); 
		query.append(",B.NUM" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, 4, 5, 6, 7, A.NUM" ).append("\n"); 

	}
}