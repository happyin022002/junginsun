/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOOffHireResultAvgUsingDaySummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
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

public class LeaseReportDBDAOOffHireResultAvgUsingDaySummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 반납 임차장비에 대한 계약번호별 평균사용 실적목록을 조회합니다.
	  * 2010.10.14 남궁진호 [CHM-201006506-01]  TLL  및 SLD  Status를 조회조건에서 제외
	  * 
	  * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
	  * </pre>
	  */
	public LeaseReportDBDAOOffHireResultAvgUsingDaySummaryListRSQL(){
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
		params.put("hjs_cre_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_use_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOOffHireResultAvgUsingDaySummaryListRSQL").append("\n"); 
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
		query.append("WITH TEMP_INLINE AS (" ).append("\n"); 
		query.append("    SELECT  B.AGMT_CTY_CD, B.AGMT_SEQ, B.REF_NO, B.VNDR_SEQ, " ).append("\n"); 
		query.append("			B.LSTM_CD, A.CNTR_NO, A.YD_CD, PRNR_STS_SEQ," ).append("\n"); 
		query.append("            A.CNTR_STS_EVNT_DT AS OFF_HR_DT                " ).append("\n"); 
		query.append("    FROM   (SELECT  TO_DATE(@[str_evnt_dt],'YYYYMMDD') AS STR_EVNT_DT," ).append("\n"); 
		query.append("                    TO_DATE(@[end_evnt_dt],'YYYYMMDD') AS END_EVNT_DT," ).append("\n"); 
		query.append("                    @[lstm_cd]                         AS LSTM_CD," ).append("\n"); 
		query.append("					@[agmt_cty_cd]                     AS AGMT_CTY_CD," ).append("\n"); 
		query.append("					@[agmt_seq]                        AS AGMT_SEQ," ).append("\n"); 
		query.append("					@[hjs_cre_flg]                     AS HJS_CRE_FLG" ).append("\n"); 
		query.append("            FROM    DUAL) P," ).append("\n"); 
		query.append("			MST_CONTAINER C," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("            LSE_AGREEMENT B			" ).append("\n"); 
		query.append("    WHERE   A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("	AND		A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND     A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("	AND     A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("    AND     A.CNTR_STS_CD IN ('LSO', 'DIO', 'TLL')" ).append("\n"); 
		query.append("    AND     A.CNTR_STS_EVNT_DT BETWEEN P.STR_EVNT_DT AND P.END_EVNT_DT" ).append("\n"); 
		query.append("#if (${hjs_cre_flg} != '' )" ).append("\n"); 
		query.append("	AND     A.CNTR_LSTM_CNG_FLG = P.HJS_CRE_FLG" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("    AND 	A.AGMT_CTY_CD = P.AGMT_CTY_CD       " ).append("\n"); 
		query.append("    AND 	A.AGMT_SEQ = P.AGMT_SEQ  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    AND     B.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  AGMT_CTY_CD||LPAD(AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("        AGMT_CTY_CD, AGMT_SEQ, REF_NO, A.VNDR_SEQ, " ).append("\n"); 
		query.append("		B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM, RST_DIV," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_TOTAL_CNT,'AVG',TPSZ_TOTAL_AVG,TPSZ_TOTAL_DAY) TPSZ_TOTAL," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP01_CNT, 'AVG',TPSZ_DP01_AVG, TPSZ_DP01_DAY) TPSZ_DP01," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP02_CNT, 'AVG',TPSZ_DP02_AVG, TPSZ_DP02_DAY) TPSZ_DP02," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP03_CNT, 'AVG',TPSZ_DP03_AVG, TPSZ_DP03_DAY) TPSZ_DP03," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP04_CNT, 'AVG',TPSZ_DP04_AVG, TPSZ_DP04_DAY) TPSZ_DP04," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP05_CNT, 'AVG',TPSZ_DP05_AVG, TPSZ_DP05_DAY) TPSZ_DP05," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP06_CNT, 'AVG',TPSZ_DP06_AVG, TPSZ_DP06_DAY) TPSZ_DP06," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP07_CNT, 'AVG',TPSZ_DP07_AVG, TPSZ_DP07_DAY) TPSZ_DP07," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP08_CNT, 'AVG',TPSZ_DP08_AVG, TPSZ_DP08_DAY) TPSZ_DP08," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP09_CNT, 'AVG',TPSZ_DP09_AVG, TPSZ_DP09_DAY) TPSZ_DP09," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP10_CNT, 'AVG',TPSZ_DP10_AVG, TPSZ_DP10_DAY) TPSZ_DP10," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP11_CNT, 'AVG',TPSZ_DP11_AVG, TPSZ_DP11_DAY) TPSZ_DP11," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP12_CNT, 'AVG',TPSZ_DP12_AVG, TPSZ_DP12_DAY) TPSZ_DP12," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP13_CNT, 'AVG',TPSZ_DP13_AVG, TPSZ_DP13_DAY) TPSZ_DP13," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP14_CNT, 'AVG',TPSZ_DP14_AVG, TPSZ_DP14_DAY) TPSZ_DP14," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP15_CNT, 'AVG',TPSZ_DP15_AVG, TPSZ_DP15_DAY) TPSZ_DP15," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP16_CNT, 'AVG',TPSZ_DP16_AVG, TPSZ_DP16_DAY) TPSZ_DP16," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP17_CNT, 'AVG',TPSZ_DP17_AVG, TPSZ_DP17_DAY) TPSZ_DP17," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP18_CNT, 'AVG',TPSZ_DP18_AVG, TPSZ_DP18_DAY) TPSZ_DP18," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP19_CNT, 'AVG',TPSZ_DP19_AVG, TPSZ_DP19_DAY) TPSZ_DP19," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP20_CNT, 'AVG',TPSZ_DP20_AVG, TPSZ_DP20_DAY) TPSZ_DP20," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP21_CNT, 'AVG',TPSZ_DP21_AVG, TPSZ_DP21_DAY) TPSZ_DP21," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP22_CNT, 'AVG',TPSZ_DP22_AVG, TPSZ_DP22_DAY) TPSZ_DP22," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP23_CNT, 'AVG',TPSZ_DP23_AVG, TPSZ_DP23_DAY) TPSZ_DP23," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP24_CNT, 'AVG',TPSZ_DP24_AVG, TPSZ_DP24_DAY) TPSZ_DP24," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP25_CNT, 'AVG',TPSZ_DP25_AVG, TPSZ_DP25_DAY) TPSZ_DP25," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP26_CNT, 'AVG',TPSZ_DP26_AVG, TPSZ_DP26_DAY) TPSZ_DP26," ).append("\n"); 
		query.append("		DECODE(RST_DIV,'VOL',TPSZ_DP27_CNT, 'AVG',TPSZ_DP27_AVG, TPSZ_DP27_DAY) TPSZ_DP27," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP28_CNT, 'AVG',TPSZ_DP28_AVG, TPSZ_DP28_DAY) TPSZ_DP28," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP29_CNT, 'AVG',TPSZ_DP29_AVG, TPSZ_DP29_DAY) TPSZ_DP29," ).append("\n"); 
		query.append("        DECODE(RST_DIV,'VOL',TPSZ_DP30_CNT, 'AVG',TPSZ_DP30_AVG, TPSZ_DP30_DAY) TPSZ_DP30" ).append("\n"); 
		query.append("FROM   	MDM_VENDOR B, " ).append("\n"); 
		query.append("	   (SELECT  A.AGMT_CTY_CD, A.AGMT_SEQ, A.REF_NO, A.VNDR_SEQ, DECODE(B.DEPTH, 1,'VOL',2,'AVG',3,'DAY') RST_DIV," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 1 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP01_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 2 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP02_CNT,  " ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 3 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP03_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 4 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP04_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 5 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP05_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 6 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP06_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 7 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP07_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 8 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP08_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 9 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP09_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =10 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP10_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =11 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP11_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =12 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP12_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =13 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP13_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =14 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP14_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =15 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP15_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =16 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP16_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =17 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP17_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =18 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP18_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =19 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP19_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =20 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP20_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =21 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP21_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =22 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP22_CNT,  " ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =23 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP23_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =24 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP24_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =25 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP25_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =26 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP26_CNT," ).append("\n"); 
		query.append("				MAX(CASE WHEN C.RPT_DP_SEQ =27 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP27_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP28_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP29_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =30 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP30_CNT," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 1 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP01_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 2 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP02_AVG,  " ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 3 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP03_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 4 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP04_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 5 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP05_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 6 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP06_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 7 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP07_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 8 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP08_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 9 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP09_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =10 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP10_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =11 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP11_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =12 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP12_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =13 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP13_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =14 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP14_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =15 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP15_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =16 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP16_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =17 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP17_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =18 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP18_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =19 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP19_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =20 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP20_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =21 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP21_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =22 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP22_AVG,  " ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =23 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP23_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =24 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP24_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =25 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP25_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =26 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP26_AVG," ).append("\n"); 
		query.append("				MAX(CASE WHEN C.RPT_DP_SEQ =27 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP27_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP28_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =29 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP29_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =30 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_AVG,0) END) TPSZ_DP30_AVG," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 1 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP01_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 2 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP02_DAY,  " ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 3 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP03_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 4 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP04_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 5 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP05_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 6 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP06_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 7 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP07_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 8 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP08_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ = 9 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP09_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =10 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP10_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =11 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP11_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =12 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP12_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =13 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP13_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =14 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP14_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =15 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP15_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =16 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP16_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =17 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP17_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =18 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP18_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =19 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP19_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =20 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP20_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =21 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP21_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =22 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP22_DAY,  " ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =23 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP23_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =24 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP24_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =25 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP25_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =26 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP26_DAY," ).append("\n"); 
		query.append("				MAX(CASE WHEN C.RPT_DP_SEQ =27 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP27_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP28_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =29 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP29_DAY," ).append("\n"); 
		query.append("                MAX(CASE WHEN C.RPT_DP_SEQ =30 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0) END) TPSZ_DP30_DAY," ).append("\n"); 
		query.append("                SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0)) AS TPSZ_TOTAL_CNT," ).append("\n"); 
		query.append("                SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0)) AS TPSZ_TOTAL_DAY," ).append("\n"); 
		query.append("                ROUND(SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.USE_DAY,0)) / " ).append("\n"); 
		query.append("                      SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0))) AS TPSZ_TOTAL_AVG                                  " ).append("\n"); 
		query.append("        FROM   (SELECT  D.AGMT_CTY_CD, D.AGMT_SEQ, D.REF_NO, D.VNDR_SEQ, A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                        COUNT(D.CNTR_NO) AS VOL_CNT," ).append("\n"); 
		query.append("						CASE WHEN D.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("                        	 THEN ROUND(SUM(D.OFF_HR_DT - A.MFT_DT)) " ).append("\n"); 
		query.append("							 ELSE ROUND(SUM(D.OFF_HR_DT - B.CNTR_STS_EVNT_DT)) END USE_DAY," ).append("\n"); 
		query.append("						CASE WHEN D.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("                        	 THEN ROUND(SUM(D.OFF_HR_DT - A.MFT_DT) / COUNT(D.CNTR_NO))" ).append("\n"); 
		query.append("							 ELSE ROUND(SUM(D.OFF_HR_DT - B.CNTR_STS_EVNT_DT) / COUNT(D.CNTR_NO)) END USE_AVG" ).append("\n"); 
		query.append("                FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("                        MST_CNTR_STS_HIS B,            " ).append("\n"); 
		query.append("                        TEMP_INLINE D" ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                AND     D.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                AND     D.PRNR_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                AND     B.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("				AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cntr_use_co_cd} != '' )" ).append("\n"); 
		query.append("		        AND 	A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("          		AND 	A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '1' ) " ).append("\n"); 
		query.append("				AND     B.CNTR_STS_CD IN ('DII','LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '2')" ).append("\n"); 
		query.append("				AND     B.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '3')" ).append("\n"); 
		query.append("				AND     B.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                GROUP BY D.AGMT_CTY_CD, D.AGMT_SEQ, D.REF_NO, D.VNDR_SEQ, D.LSTM_CD, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  'G.TTL', TO_NUMBER(''), '', TO_NUMBER(''), A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("                        COUNT(D.CNTR_NO) AS VOL_CNT," ).append("\n"); 
		query.append("						CASE WHEN D.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("                        	 THEN ROUND(SUM(D.OFF_HR_DT - A.MFT_DT))" ).append("\n"); 
		query.append("							 ELSE ROUND(SUM(D.OFF_HR_DT - B.CNTR_STS_EVNT_DT)) END USE_DAY," ).append("\n"); 
		query.append("						CASE WHEN D.LSTM_CD IN('OW','LP','OL')" ).append("\n"); 
		query.append("							 THEN ROUND(SUM(D.OFF_HR_DT - A.MFT_DT) / COUNT(D.CNTR_NO))" ).append("\n"); 
		query.append("							 ELSE ROUND(SUM(D.OFF_HR_DT - B.CNTR_STS_EVNT_DT) / COUNT(D.CNTR_NO)) END USE_AVG" ).append("\n"); 
		query.append("                FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("                        MST_CNTR_STS_HIS B,            " ).append("\n"); 
		query.append("                        TEMP_INLINE D" ).append("\n"); 
		query.append("                WHERE   A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                AND     D.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                AND     D.PRNR_STS_SEQ = B.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                AND     B.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("				AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${cntr_use_co_cd} != '' )" ).append("\n"); 
		query.append("		        AND 	A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("          		AND 	A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${cntr_sts_cd} == '1' ) " ).append("\n"); 
		query.append("				AND     B.CNTR_STS_CD IN ('DII','LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '2')" ).append("\n"); 
		query.append("				AND     B.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("#elseif (${cntr_sts_cd} == '3')" ).append("\n"); 
		query.append("				AND     B.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                GROUP BY D.LSTM_CD, A.CNTR_TPSZ_CD) A," ).append("\n"); 
		query.append("               (SELECT LEVEL AS DEPTH FROM DUAL CONNECT BY LEVEL < 4) B," ).append("\n"); 
		query.append("               (SELECT  CNTR_TPSZ_CD, ROW_NUMBER() OVER(ORDER BY RPT_DP_SEQ) AS RPT_DP_SEQ  " ).append("\n"); 
		query.append("                FROM    MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                WHERE DELT_FLG = 'N' AND ACIAC_DIV_CD = 'A') C       " ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND    	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY A.AGMT_CTY_CD, A.AGMT_SEQ, A.REF_NO, A.VNDR_SEQ, B.DEPTH" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("WHERE   A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY AGMT_SEQ, RST_DIV DESC" ).append("\n"); 

	}
}