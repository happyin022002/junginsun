/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchYearNewPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireDomesticNewvanShceduleInputDBDAOSearchYearNewPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_NEW_VAN_LONG_TERM + EQR_NEW_VAN_LONG_TERM_PERF 테이블 데이터 조회
	  * </pre>
	  */
	public OnhireDomesticNewvanShceduleInputDBDAOSearchYearNewPlanRSQL(){
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
		params.put("toPlnYrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("leaseterm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration").append("\n"); 
		query.append("FileName : OnhireDomesticNewvanShceduleInputDBDAOSearchYearNewPlanRSQL").append("\n"); 
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
		query.append("DECODE(B.NUM, 1, A.CO_CD, 		2, B.NAME , 3, A.CO_CD         ) CO_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.RCC_CD, 		2, ''     , 3, A.RCC_CD||' TTL') RCC_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.ECC_CD, 		2, ''     , 3, ''              ) ECC_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_LSTM_CD,   2, ''     , 3, ''              ) CNTR_LSTM_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_TPSZ_CD,   2, ''     , 3, ''              ) CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_ABBR_NM,   2, ''     , 3, ''              ) VNDR_ABBR_NM_CD" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CODE ,  	    2, ''     , 3, ''              ) VNDR_SEQ_CD" ).append("\n"); 
		query.append(",A.STATUS CNTR_DE_STS_CD" ).append("\n"); 
		query.append(",SUM(A.TOTAL) TOTAL" ).append("\n"); 
		query.append("#if ($arrPerfixMonth.size() > 0)" ).append("\n"); 
		query.append("#foreach( $key in ${arrPerfixMonth})" ).append("\n"); 
		query.append(",SUM(A.QTY${key}) S1_${key}_CNTR_VOL_QTY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_CNT_CD,  2, ''       , 3, ''              ) VNDR_CNT_CD" ).append("\n"); 
		query.append(",A.NUM NUM1" ).append("\n"); 
		query.append(",B.NUM NUM2" ).append("\n"); 
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
		query.append(",A.VNDR_CNT_CD||A.VNDR_SEQ   CODE" ).append("\n"); 
		query.append(",B.NUM" ).append("\n"); 
		query.append(",B.STATUS" ).append("\n"); 
		query.append(",SUM(DECODE(B.NUM, 1, A.QTY1, 2, A.QTY2, 3, A.QTY3, 4, QTY4)) TOTAL" ).append("\n"); 
		query.append("#if ($arrPerfixMonth.size() > 0)" ).append("\n"); 
		query.append("#foreach( $key in ${arrPerfixMonth})" ).append("\n"); 
		query.append(",SUM(DECODE(A.MONTH, '$key', DECODE(B.NUM, 1, A.QTY1, 2, A.QTY2, 3, A.QTY3, 4, QTY4))) AS QTY${key}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("B.CO_CD," ).append("\n"); 
		query.append("B.CNTR_LSTM_CD," ).append("\n"); 
		query.append("B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("B.ECC_CD," ).append("\n"); 
		query.append("B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("B.VNDR_CNT_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("A.PLN_YR || A.PLN_MON AS MONTH," ).append("\n"); 
		query.append("1 SEQ," ).append("\n"); 
		query.append("SUM (B.CNTR_VOL_QTY) AS QTY1," ).append("\n"); 
		query.append("0 QTY2," ).append("\n"); 
		query.append("0 QTY3," ).append("\n"); 
		query.append("0 QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_SCNR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_WK_PRD A," ).append("\n"); 
		query.append("EQR_ECC_MST C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("B.PLN_YRMON BETWEEN @[fmPlnYrwk]  AND @[toPlnYrwk]" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   B.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND   A.PLN_YR || A.PLN_WK = B.PLN_YRMON" ).append("\n"); 
		query.append("AND   B.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_TPSZ_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_LSTM_CD =@[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY CO_CD," ).append("\n"); 
		query.append("CNTR_LSTM_CD," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("B.ECC_CD," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("A.PLN_YR || A.PLN_MON," ).append("\n"); 
		query.append("VNDR_ABBR_NM" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON AS MONTH," ).append("\n"); 
		query.append("2 SEQ," ).append("\n"); 
		query.append("0 QTY1," ).append("\n"); 
		query.append("MAX(A.CNTR_AUTH_QTY) AS QTY2," ).append("\n"); 
		query.append("0 QTY3," ).append("\n"); 
		query.append("0 QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM_PERF A," ).append("\n"); 
		query.append("EQR_SCNR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_ECC_MST C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append("AND   A.ECC_CD       = B.ECC_CD" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   A.VNDR_CNT_CD  = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ     = B.VNDR_SEQ" ).append("\n"); 
		query.append("#if ($arrtpszcd.size() > 0 && $arrPerfixMonth.size() > 0)" ).append("\n"); 
		query.append("AND A.PERF_YRMON IN(" ).append("\n"); 
		query.append("#foreach($key in ${arrPerfixMonth})" ).append("\n"); 
		query.append("#if($velocityCount < $arrPerfixMonth.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND   B.SCNR_ID =@[scnr_id]" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_TPSZ_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_LSTM_CD =@[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON AS MONTH," ).append("\n"); 
		query.append("3 SEQ," ).append("\n"); 
		query.append("0 QTY1," ).append("\n"); 
		query.append("0 QTY2," ).append("\n"); 
		query.append("MAX(A.CNTR_PKUP_QTY) AS QTY3," ).append("\n"); 
		query.append("0 QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM_PERF A," ).append("\n"); 
		query.append("EQR_SCNR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_ECC_MST C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append("AND   A.ECC_CD       = B.ECC_CD" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   A.VNDR_CNT_CD  = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ     = B.VNDR_SEQ" ).append("\n"); 
		query.append("#if ($arrtpszcd.size() > 0 && $arrPerfixMonth.size() > 0)" ).append("\n"); 
		query.append("AND A.PERF_YRMON IN(" ).append("\n"); 
		query.append("#foreach($key in ${arrPerfixMonth})" ).append("\n"); 
		query.append("#if($velocityCount < $arrPerfixMonth.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND   B.SCNR_ID = @[scnr_id]" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_TPSZ_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_LSTM_CD =@[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("A.PERF_YRMON AS MONTH," ).append("\n"); 
		query.append("4 SEQ," ).append("\n"); 
		query.append("0 QTY1," ).append("\n"); 
		query.append("0 QTY2," ).append("\n"); 
		query.append("0 QTY3," ).append("\n"); 
		query.append("MAX(A.CNTR_AUTH_QTY-A.CNTR_PKUP_QTY) AS QTY4" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("EQR_NEW_VAN_LONG_TERM_PERF A," ).append("\n"); 
		query.append("EQR_SCNR_NEW_VAN_LONG_TERM B," ).append("\n"); 
		query.append("EQR_ECC_MST C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append("AND   A.ECC_CD       = B.ECC_CD" ).append("\n"); 
		query.append("AND   A.CNTR_LSTM_CD = B.CNTR_LSTM_CD" ).append("\n"); 
		query.append("AND   A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND   A.VNDR_CNT_CD  = B.VNDR_CNT_CD" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ     = B.VNDR_SEQ" ).append("\n"); 
		query.append("#if ($arrtpszcd.size() > 0 && $arrPerfixMonth.size() > 0)" ).append("\n"); 
		query.append("AND A.PERF_YRMON IN(" ).append("\n"); 
		query.append("#foreach($key in ${arrPerfixMonth})" ).append("\n"); 
		query.append("#if($velocityCount < $arrPerfixMonth.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   B.CNTR_DE_STS_CD = 'A'" ).append("\n"); 
		query.append("AND   A.ECC_CD = C.ECC_CD" ).append("\n"); 
		query.append("AND   B.SCNR_ID =@[scnr_id]" ).append("\n"); 
		query.append("#if (${location} == 'R')" ).append("\n"); 
		query.append("AND C.RCC_CD IN(" ).append("\n"); 
		query.append("#foreach( $key in ${arrlocation})" ).append("\n"); 
		query.append("#if($velocityCount < $arrlocation.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${location} == 'L')" ).append("\n"); 
		query.append("AND C.LCC_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_TPSZ_CD IN(" ).append("\n"); 
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
		query.append("AND B.CNTR_LSTM_CD =@[leaseterm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
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
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CNTR_LSTM_CD," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.RCC_CD," ).append("\n"); 
		query.append("A.ECC_CD," ).append("\n"); 
		query.append("A.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.VNDR_CNT_CD," ).append("\n"); 
		query.append("A.VNDR_CNT_CD|| A.VNDR_SEQ ," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("B.NUM," ).append("\n"); 
		query.append("B.STATUS" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 1 NUM, ''      NAME FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 NUM, 'TOTAL' NAME FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 3 NUM, 'TTL'   NAME FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("DECODE(B.NUM, 1, A.CO_CD, 	     2, B.NAME  , 3, A.CO_CD )" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_LSTM_CD, 2, ''      , 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.CNTR_TPSZ_CD, 2, ''      , 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.RCC_CD, 	     2, ''      , 3, A.RCC_CD||' TTL')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.ECC_CD, 	     2, ''      , 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_ABBR_NM, 2, ''      , 3, '')" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, CODE, 	         2, ''      , 3, '')" ).append("\n"); 
		query.append(",A.STATUS" ).append("\n"); 
		query.append(",DECODE(B.NUM, 1, A.VNDR_CNT_CD,  2, ''       , 3, '')" ).append("\n"); 
		query.append(",A.NUM" ).append("\n"); 
		query.append(",B.NUM  -- NORMAL, SUB, GRAND TOTAL" ).append("\n"); 
		query.append("ORDER BY 1, 2, 3, 4, 5, 6, 7, A.NUM" ).append("\n"); 

	}
}