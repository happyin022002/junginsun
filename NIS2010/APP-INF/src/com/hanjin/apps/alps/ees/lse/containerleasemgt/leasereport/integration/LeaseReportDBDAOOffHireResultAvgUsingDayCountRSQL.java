/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LeaseReportDBDAOOffHireResultAvgUsingDayCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOOffHireResultAvgUsingDayCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차장비별 사용실적에 대한 전체건수를 조회합니다.
	  * </pre>
	  */
	public LeaseReportDBDAOOffHireResultAvgUsingDayCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_use_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOOffHireResultAvgUsingDayCountRSQL").append("\n"); 
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
		query.append("SELECT  COUNT(*) AS TOTAL_CNT" ).append("\n"); 
		query.append("FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("        MST_CNTR_STS_HIS B, " ).append("\n"); 
		query.append("       (SELECT  /*+ INDEX(A XAK4MST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("				B.AGMT_CTY_CD, B.AGMT_SEQ, B.REF_NO, A.CNTR_NO," ).append("\n"); 
		query.append("                A.YD_CD, A.CNTR_STS_EVNT_DT AS OFF_HR_DT," ).append("\n"); 
		query.append("                A.PRNR_STS_SEQ, A.CNTR_LSTM_CNG_FLG," ).append("\n"); 
		query.append("                DECODE(A.CNTR_STS_CD,'DIO','Y','N') AS DII_FLG," ).append("\n"); 
		query.append("                A.CNTR_LFT_CHG_AMT, A.CNTR_DRFF_CR_AMT," ).append("\n"); 
		query.append("				P.STR_EVNT_DT, P.END_EVNT_DT, P.LSTM_CD, P.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                P.CNTR_USE_CO_CD, P.VNDR_SEQ, P.HJS_CRE_FLG" ).append("\n"); 
		query.append("        FROM   (SELECT  TO_DATE(@[str_evnt_dt],'YYYYMMDD') AS STR_EVNT_DT," ).append("\n"); 
		query.append("			            TO_DATE(@[end_evnt_dt],'YYYYMMDD') AS END_EVNT_DT," ).append("\n"); 
		query.append("			            @[lstm_cd]        AS LSTM_CD," ).append("\n"); 
		query.append("			            @[agmt_cty_cd]    AS AGMT_CTY_CD," ).append("\n"); 
		query.append("			            @[agmt_seq]       AS AGMT_SEQ," ).append("\n"); 
		query.append("			            @[cntr_tpsz_cd]   AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			            @[cntr_use_co_cd] AS CNTR_USE_CO_CD," ).append("\n"); 
		query.append("			            @[vndr_seq]       AS VNDR_SEQ," ).append("\n"); 
		query.append("						@[hjs_cre_flg]    AS HJS_CRE_FLG" ).append("\n"); 
		query.append("			    FROM    DUAL) P," ).append("\n"); 
		query.append("				MST_CONTAINER C," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                LSE_AGREEMENT B" ).append("\n"); 
		query.append("        WHERE   A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("		AND		A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     A.AGMT_SEQ = B.AGMT_SEQ        " ).append("\n"); 
		query.append("        AND     A.CNTR_STS_CD IN ('LSO','DIO','TLL')" ).append("\n"); 
		query.append("        AND     A.CNTR_STS_EVNT_DT BETWEEN P.STR_EVNT_DT AND P.END_EVNT_DT" ).append("\n"); 
		query.append("#if (${hjs_cre_flg} != '' )" ).append("\n"); 
		query.append("        AND     A.CNTR_LSTM_CNG_FLG = P.HJS_CRE_FLG" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        AND     B.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("		AND 	B.AGMT_CTY_CD = P.AGMT_CTY_CD       " ).append("\n"); 
		query.append("		AND 	B.AGMT_SEQ = P.AGMT_SEQ  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("        ) C, " ).append("\n"); 
		query.append("        MDM_CNTR_TP_SZ D" ).append("\n"); 
		query.append("        , BKG_BOOKING BKG     " ).append("\n"); 
		query.append("WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND     C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND     C.PRNR_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("AND     A.CNTR_TPSZ_CD = D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND     B.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("AND     BKG.BKG_NO(+)  = A.BKG_NO    " ).append("\n"); 
		query.append("--		AND     A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cntr_use_co_cd} != '' )" ).append("\n"); 
		query.append("AND 	A.CNTR_USE_CO_CD = C.CNTR_USE_CO_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("AND 	A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '1' ) " ).append("\n"); 
		query.append("AND     B.CNTR_STS_CD IN ('DII','LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '2')" ).append("\n"); 
		query.append("AND     B.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '3')" ).append("\n"); 
		query.append("AND     B.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND    	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}