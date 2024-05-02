/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQAvailabilityFinderDBDAOsearchAvailONListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.07.15 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQAvailabilityFinderDBDAOsearchAvailONListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * On-hire 계획 및 실적(조회당일)의 Detail 정보를 확인
	  * </pre>
	  */
	public EQAvailabilityFinderDBDAOsearchAvailONListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration").append("\n"); 
		query.append("FileName : EQAvailabilityFinderDBDAOsearchAvailONListRSQL").append("\n"); 
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
		query.append("	 A.FCAST_DT" ).append("\n"); 
		query.append("	,A.YD_CD" ).append("\n"); 
		query.append("	,A.EVNT_DT" ).append("\n"); 
		query.append("	,A.EVNT_YD_CD" ).append("\n"); 
		query.append("	,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,A.CNTR_VOL_QTY" ).append("\n"); 
		query.append("	,A.LSTM_CD " ).append("\n"); 
		query.append("	,A.LESSOR" ).append("\n"); 
		query.append("	,A.AGMT_NO" ).append("\n"); 
		query.append("	,A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT   " ).append("\n"); 
		query.append("		 TO_CHAR(A.FCAST_DT,'YYYY-MM-DD') FCAST_DT" ).append("\n"); 
		query.append("		,A.YD_CD" ).append("\n"); 
		query.append("		,NULL EVNT_DT" ).append("\n"); 
		query.append("		,NULL EVNT_YD_CD" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,SUM(A.CNTR_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("		,'OW' LSTM_CD " ).append("\n"); 
		query.append("		, NULL LESSOR" ).append("\n"); 
		query.append("		,NULL AGMT_NO " ).append("\n"); 
		query.append("		, NULL CNTR_AUTH_NO" ).append("\n"); 
		query.append("	FROM  CIM_AVAL_DTL A, MDM_LOCATION L, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	WHERE A.CNTR_AVAL_FCAST_TP_CD ='N1'" ).append("\n"); 
		query.append("    AND   L.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("    AND L.LOC_CD = SUBSTR(@[loc_cd],1,5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	AND   L.LOC_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("	#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("		AND A.FCAST_DT BETWEEN TO_DATE(@[fcast_dt],'YYYYMMDD') AND TO_DATE(@[fcast_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	GROUP BY TO_CHAR(A.FCAST_DT,'YYYY-MM-DD'), A.YD_CD, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("         TO_CHAR(A.EVNT_DT,'YYYY-MM-DD') FCAST_DT" ).append("\n"); 
		query.append("		,A.EVNT_YD_CD YD_CD" ).append("\n"); 
		query.append("		,TO_CHAR(A.FCAST_DT,'YYYY-MM-DD')  EVNT_DT" ).append("\n"); 
		query.append("		,A.YD_CD EVNT_YD_CD" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,SUM(A.CNTR_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("		,MAX(B.LSTM_CD) LSTM_CD " ).append("\n"); 
		query.append("		,MAX(NVL(C.VNDR_ABBR_NM,C.VNDR_LGL_ENG_NM)) LESSOR" ).append("\n"); 
		query.append("		,A.AGMT_CTY_CD||A.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("		,A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("	FROM  CIM_AVAL_DTL A, MDM_LOCATION L, LSE_AGREEMENT B, MDM_VENDOR C, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	WHERE A.CNTR_AVAL_FCAST_TP_CD = 'N2'" ).append("\n"); 
		query.append("    AND   L.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("    AND L.LOC_CD = SUBSTR(@[loc_cd],1,5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	AND   L.LOC_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("	#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("		AND A.FCAST_DT BETWEEN TO_DATE(@[fcast_dt],'YYYYMMDD') AND TO_DATE(@[fcast_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND   A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("	AND   A.AGMT_SEQ    = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("	AND   B.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	GROUP BY TO_CHAR(A.FCAST_DT,'YYYY-MM-DD'), A.YD_CD, TO_CHAR(A.EVNT_DT,'YYYY-MM-DD'),A.EVNT_YD_CD,A.CNTR_TPSZ_CD, A.AGMT_CTY_CD, A.AGMT_SEQ , A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		 NULL FCAST_DT" ).append("\n"); 
		query.append("		,NULL YD_CD" ).append("\n"); 
		query.append("		,TO_CHAR(A.FCAST_DT,'YYYY-MM-DD') EVNT_DT" ).append("\n"); 
		query.append("		,A.YD_CD EVNT_YD_CD" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,SUM(A.CNTR_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("		,MAX(B.LSTM_CD) LSTM_CD " ).append("\n"); 
		query.append("		,MAX(NVL(C.VNDR_ABBR_NM,C.VNDR_LGL_ENG_NM)) LESSOR" ).append("\n"); 
		query.append("		,A.AGMT_CTY_CD||A.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("		,NULL CNTR_AUTH_NO" ).append("\n"); 
		query.append("	FROM  CIM_AVAL_DTL A, MDM_LOCATION L ,LSE_AGREEMENT B, MDM_VENDOR C, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	WHERE A.CNTR_AVAL_FCAST_TP_CD ='N3'" ).append("\n"); 
		query.append("    AND   L.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("    AND L.LOC_CD = SUBSTR(@[loc_cd],1,5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	AND   L.LOC_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("	#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("		AND A.FCAST_DT BETWEEN TO_DATE(@[fcast_dt],'YYYYMMDD') AND TO_DATE(@[fcast_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND   A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("	AND   A.AGMT_SEQ    = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("	AND   B.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	GROUP BY TO_CHAR(A.FCAST_DT,'YYYY-MM-DD'), A.YD_CD, A.CNTR_TPSZ_CD, A.AGMT_CTY_CD, A.AGMT_SEQ" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT   " ).append("\n"); 
		query.append("		 TO_CHAR(A.FCAST_DT,'YYYY-MM-DD') FCAST_DT" ).append("\n"); 
		query.append("		,A.YD_CD" ).append("\n"); 
		query.append("		,NULL EVNT_DT" ).append("\n"); 
		query.append("		,NULL EVNT_YD_CD" ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		,SUM(A.CNTR_QTY) CNTR_VOL_QTY" ).append("\n"); 
		query.append("		,MAX(B.LSTM_CD) LSTM_CD " ).append("\n"); 
		query.append("		,MAX(NVL(C.VNDR_ABBR_NM,C.VNDR_LGL_ENG_NM)) LESSOR" ).append("\n"); 
		query.append("		,A.AGMT_CTY_CD||A.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("		,A.CNTR_AUTH_NO CNTR_AUTH_NO" ).append("\n"); 
		query.append("	FROM  CIM_AVAL_DTL A, MDM_LOCATION L ,LSE_AGREEMENT B, MDM_VENDOR C, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	WHERE A.CNTR_AVAL_FCAST_TP_CD IN('N4')" ).append("\n"); 
		query.append("    AND   L.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("    AND L.LOC_CD = SUBSTR(@[loc_cd],1,5)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("    AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND   A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	AND   L.LOC_CD = SUBSTR(A.YD_CD,1,5)" ).append("\n"); 
		query.append("	#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("		AND A.FCAST_DT BETWEEN TO_DATE(@[fcast_dt],'YYYYMMDD') AND TO_DATE(@[fcast_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND   A.AGMT_CTY_CD = B.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("	AND   A.AGMT_SEQ    = B.AGMT_SEQ(+)" ).append("\n"); 
		query.append("	AND   B.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	GROUP BY TO_CHAR(A.FCAST_DT,'YYYY-MM-DD'), A.YD_CD, A.CNTR_TPSZ_CD, A.AGMT_CTY_CD, A.AGMT_SEQ, A.CNTR_AUTH_NO" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY A.FCAST_DT, A.YD_CD, NVL(A.EVNT_DT,'1111111111'),NVL(A.EVNT_YD_CD,'111111')" ).append("\n"); 

	}
}