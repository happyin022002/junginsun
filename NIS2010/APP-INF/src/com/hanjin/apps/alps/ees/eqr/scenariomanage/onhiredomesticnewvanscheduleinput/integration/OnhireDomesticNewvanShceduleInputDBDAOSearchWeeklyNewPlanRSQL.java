/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchWeeklyNewPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOSearchWeeklyNewPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_NEW_VAN_LONG_TERM + EQR_NEW_VAN_LONG_TERM_PERF 테이블 데이터 조회(Weekly)
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOSearchWeeklyNewPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_weekly",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmPlnYrmo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("month_key",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("leaseterm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchWeeklyNewPlanRSQL").append("\n"); 
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
		query.append("CO_CD ," ).append("\n"); 
		query.append("RCC_CD," ).append("\n"); 
		query.append("ECC_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("VNDR_ABBR_NM VNDR_ABBR_NM_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD||VNDR_SEQ VNDR_SEQ_CD," ).append("\n"); 
		query.append("CNTR_DE_STS_CD," ).append("\n"); 
		query.append("#if ($arrPerfixWeekly.size() > 0)" ).append("\n"); 
		query.append("#foreach( $key in ${arrPerfixWeekly})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("NVL(MAX (DECODE (PLN_YRMON,'$key' , CNTR_VOL_QTY)),0 )" ).append("\n"); 
		query.append("--해당 월의 모든 전주의 Available 수량을 구한다." ).append("\n"); 
		query.append("#if (${pikupVolSearchchk} == 'TRUE')" ).append("\n"); 
		query.append("+ (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(A.CNTR_VOL_QTY),0) QTY1" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM A" ).append("\n"); 
		query.append("WHERE A.PLN_YRMON" ).append("\n"); 
		query.append("IN (" ).append("\n"); 
		query.append("SELECT PLN_YR|| PLN_WK" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR =@[st_year]" ).append("\n"); 
		query.append("AND PLN_MON =@[st_month]" ).append("\n"); 
		query.append("AND PLN_WK < @[st_weekly]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.CO_CD = C.CO_CD" ).append("\n"); 
		query.append("AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD = C.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND A.VNDR_CNT_CD  = C.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND A.VNDR_SEQ     = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_ABBR_NM   = C.VNDR_ABBR_NM" ).append("\n"); 
		query.append("AND A.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append(")  -" ).append("\n"); 
		query.append("--전주에 해당하는 월을 구하여 pkup vol 값을 가져온다." ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(A.CNTR_PKUP_QTY),0) QTY2" ).append("\n"); 
		query.append("FROM  EQR_NEW_VAN_LONG_TERM_PERF A" ).append("\n"); 
		query.append("WHERE PERF_YRMON =@[fmPlnYrmo]" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.CO_CD = C.CO_CD" ).append("\n"); 
		query.append("AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD = C.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.VNDR_CNT_CD  = C.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND A.VNDR_SEQ     = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_ABBR_NM   = C.VNDR_ABBR_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("+" ).append("\n"); 
		query.append("--조회 주를 제외한 01월 부터 조회주 이전 달의 주의 Availble 값을 구한다." ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(A.CNTR_VOL_QTY),0) QTY1" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM A" ).append("\n"); 
		query.append("WHERE A.PLN_YRMON IN  (" ).append("\n"); 
		query.append("SELECT PLN_YR|| PLN_WK" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR =@[st_year]" ).append("\n"); 
		query.append("AND PLN_MON <=@[month_key]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.CO_CD = C.CO_CD" ).append("\n"); 
		query.append("AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD = C.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.VNDR_CNT_CD  = C.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND A.VNDR_SEQ     = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_ABBR_NM   = C.VNDR_ABBR_NM" ).append("\n"); 
		query.append("AND A.CNTR_DE_STS_CD ='A'" ).append("\n"); 
		query.append(")  -" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("--조회주 제안한 1월달 부터 조회 전주 달까지 pkup vol 총합을 가져온다" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(SUM(A.CNTR_PKUP_QTY),0) QTY2" ).append("\n"); 
		query.append("FROM  EQR_NEW_VAN_LONG_TERM_PERF A" ).append("\n"); 
		query.append("WHERE PERF_YRMON IN (SELECT DISTINCT(PLN_YR|| PLN_MON)" ).append("\n"); 
		query.append("FROM EQR_WK_PRD" ).append("\n"); 
		query.append("WHERE PLN_YR =@[st_year] AND PLN_MON <=@[month_key])" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.CO_CD = C.CO_CD" ).append("\n"); 
		query.append("AND A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD = C.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.VNDR_CNT_CD  = C.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND A.VNDR_SEQ     = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND A.VNDR_ABBR_NM   = C.VNDR_ABBR_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("S1_${key}_CNTR_VOL_QTY," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MAX (DECODE (PLN_YRMON,'$key' , CNTR_VOL_QTY)) S1_${key}_CNTR_VOL_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_ABBR_NM," ).append("\n"); 
		query.append("VNDR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT RCC_CD FROM EQR_ECC_MST WHERE A.ECC_CD = ECC_CD)RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.CNTR_DE_STS_CD," ).append("\n"); 
		query.append("A.PLN_YRMON," ).append("\n"); 
		query.append("A.SCNR_ID," ).append("\n"); 
		query.append("SUM (A.CNTR_VOL_QTY) AS CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_NEW_VAN_LONG_TERM A," ).append("\n"); 
		query.append("EQR_ECC_MST B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append("AND A.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND A.PLN_YRMON BETWEEN @[fmPlnYrwk] AND @[toPlnYrwk]" ).append("\n"); 
		query.append("AND A.CNTR_DE_STS_CD ='A'" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND B.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND B.LCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'E')" ).append("\n"); 
		query.append("AND B.ECC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($arrtpszcd.size() > 0)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpszcd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${leaseterm} != '')" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD =@[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.PLN_YRMON," ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.CNTR_DE_STS_CD," ).append("\n"); 
		query.append("A.SCNR_ID ," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM" ).append("\n"); 
		query.append(")C" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RCC_CD, ECC_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CNTR_DE_STS_CD," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("VNDR_ABBR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("RCC_CD," ).append("\n"); 
		query.append("ECC_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("VNDR_ABBR_NM," ).append("\n"); 
		query.append("VNDR_CNT_CD||VNDR_SEQ ," ).append("\n"); 
		query.append("CNTR_DE_STS_CD," ).append("\n"); 
		query.append("#if ($arrPerfixWeekly.size() > 0)" ).append("\n"); 
		query.append("#foreach( $key in ${arrPerfixWeekly})" ).append("\n"); 
		query.append("MAX (DECODE (PLN_YRMON,'$key' , CNTR_VOL_QTY)) S1_${key}_CNTR_VOL_QTY," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_ABBR_NM AS VNDER_ADDR ," ).append("\n"); 
		query.append("VNDR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(SELECT RCC_CD FROM EQR_ECC_MST WHERE A.ECC_CD = ECC_CD)RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.CNTR_DE_STS_CD," ).append("\n"); 
		query.append("A.PLN_YRMON," ).append("\n"); 
		query.append("A.SCNR_ID," ).append("\n"); 
		query.append("SUM (A.CNTR_VOL_QTY) AS CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_NEW_VAN_LONG_TERM A," ).append("\n"); 
		query.append("EQR_ECC_MST B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.ECC_CD = B.ECC_CD" ).append("\n"); 
		query.append("AND A.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("AND A.PLN_YRMON BETWEEN @[fmPlnYrwk] AND @[toPlnYrwk]" ).append("\n"); 
		query.append("AND A.CNTR_DE_STS_CD ='L'" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND B.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND B.LCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'E')" ).append("\n"); 
		query.append("AND B.ECC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($arrtpszcd.size() > 0)" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrtpszcd})" ).append("\n"); 
		query.append("#if($velocityCount < $arrtpszcd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${leaseterm} != '')" ).append("\n"); 
		query.append("AND A.CNTR_LSTM_CD =@[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("PLN_YRMON," ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CNTR_DE_STS_CD," ).append("\n"); 
		query.append("A.SCNR_ID ," ).append("\n"); 
		query.append("VNDR_ABBR_NM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RCC_CD," ).append("\n"); 
		query.append("ECC_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CNTR_DE_STS_CD," ).append("\n"); 
		query.append("SCNR_ID," ).append("\n"); 
		query.append("VNDR_ABBR_NM" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("CO_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RCC_CD ," ).append("\n"); 
		query.append("ECC_CD," ).append("\n"); 
		query.append("VNDR_ABBR_NM," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("CNTR_DE_STS_CD" ).append("\n"); 

	}
}