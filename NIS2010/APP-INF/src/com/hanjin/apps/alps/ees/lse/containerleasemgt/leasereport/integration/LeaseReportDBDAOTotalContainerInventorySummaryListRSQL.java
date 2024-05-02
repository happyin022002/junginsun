/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LeaseReportDBDAOTotalContainerInventorySummaryListRSQL.java
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

public class LeaseReportDBDAOTotalContainerInventorySummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HJS의 관리하는 자가 및 임차장비 현황목록을 조회합니다.
	  * 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
	  * </pre>
	  */
	public LeaseReportDBDAOTotalContainerInventorySummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOTotalContainerInventorySummaryListRSQL").append("\n"); 
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
		query.append("SELECT  /*+ USE_NL(A B) */ " ).append("\n"); 
		query.append("		CASE WHEN LSTM_CD IS NULL THEN 'Total'" ).append("\n"); 
		query.append("             WHEN AGMT_NO IS NULL THEN LSTM_CD" ).append("\n"); 
		query.append("             ELSE AGMT_NO END LSTM_CD," ).append("\n"); 
		query.append("		AGMT_NO, AGMT_CTY_CD, AGMT_SEQ, REF_NO, A.Lse_Ctrt_No AS CTRT_NO," ).append("\n"); 
		query.append("		A.VNDR_SEQ, B.VNDR_ABBR_NM, B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("        CASE WHEN LSTM_CD IS NULL THEN 0" ).append("\n"); 
		query.append("             WHEN AGMT_NO IS NULL THEN 0" ).append("\n"); 
		query.append("             ELSE 1 END LEVEL_NO, TPSZ_TOTAL," ).append("\n"); 
		query.append("        TPSZ_DP01, TPSZ_DP02, TPSZ_DP03, TPSZ_DP04, TPSZ_DP05, TPSZ_DP06," ).append("\n"); 
		query.append("        TPSZ_DP07, TPSZ_DP08, TPSZ_DP09, TPSZ_DP10, TPSZ_DP11, TPSZ_DP12," ).append("\n"); 
		query.append("        TPSZ_DP13, TPSZ_DP14, TPSZ_DP15, TPSZ_DP16, TPSZ_DP17, TPSZ_DP18," ).append("\n"); 
		query.append("        TPSZ_DP19, TPSZ_DP20, TPSZ_DP21, TPSZ_DP22, TPSZ_DP23, TPSZ_DP24," ).append("\n"); 
		query.append("        TPSZ_DP25, TPSZ_DP26, TPSZ_DP27, TPSZ_DP28, TPSZ_DP29, TPSZ_DP30" ).append("\n"); 
		query.append("FROM   	MDM_VENDOR B," ).append("\n"); 
		query.append("	   (SELECT  A.LSTM_CD, A.AGMT_NO, A.AGMT_CTY_CD, A.AGMT_SEQ, A.REF_NO, A.Lse_Ctrt_No," ).append("\n"); 
		query.append("				CASE WHEN A.AGMT_NO IS NULL AND A.VNDR_SEQ IS NULL THEN @[vndr_seq]" ).append("\n"); 
		query.append("                     ELSE A.VNDR_SEQ END VNDR_SEQ, A.TPSZ_TOTAL," ).append("\n"); 
		query.append("	            A.TPSZ_DP01, A.TPSZ_DP02, A.TPSZ_DP03, A.TPSZ_DP04, A.TPSZ_DP05, A.TPSZ_DP06," ).append("\n"); 
		query.append("	            A.TPSZ_DP07, A.TPSZ_DP08, A.TPSZ_DP09, A.TPSZ_DP10, A.TPSZ_DP11, A.TPSZ_DP12," ).append("\n"); 
		query.append("	            A.TPSZ_DP13, A.TPSZ_DP14, A.TPSZ_DP15, A.TPSZ_DP16, A.TPSZ_DP17, A.TPSZ_DP18," ).append("\n"); 
		query.append("	            A.TPSZ_DP19, A.TPSZ_DP20, A.TPSZ_DP21, A.TPSZ_DP22, A.TPSZ_DP23, A.TPSZ_DP24," ).append("\n"); 
		query.append("	            A.TPSZ_DP25, A.TPSZ_DP26, A.TPSZ_DP27, A.TPSZ_DP28, A.TPSZ_DP29, A.TPSZ_DP30" ).append("\n"); 
		query.append("	    FROM    MST_LSE_TERM B," ).append("\n"); 
		query.append("           	   (SELECT  A.LSTM_CD, A.AGMT_CTY_CD||LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("			            A.AGMT_CTY_CD, A.AGMT_SEQ, A.REF_NO, A.VNDR_SEQ, A.Lse_Ctrt_No," ).append("\n"); 
		query.append("			            SUM(DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0)) AS TPSZ_TOTAL," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 1 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP01," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 2 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP02,  " ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 3 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP03," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 4 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP04," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 5 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP05," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 6 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP06," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 7 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP07," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 8 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP08," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ = 9 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP09," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =10 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP10," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =11 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP11," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =12 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP12," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =13 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP13," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =14 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP14," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =15 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP15," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =16 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP16," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =17 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP17," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =18 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP18," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =19 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP19," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =20 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP20," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =21 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP21," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =22 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP22,  " ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =23 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP23," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =24 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP24," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =25 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP25," ).append("\n"); 
		query.append("			            SUM(CASE WHEN C.RPT_DP_SEQ =26 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP26," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =27 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP27," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =28 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP28," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =29 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP29," ).append("\n"); 
		query.append("                        SUM(CASE WHEN C.RPT_DP_SEQ =30 THEN DECODE(A.CNTR_TPSZ_CD, C.CNTR_TPSZ_CD, A.VOL_CNT,0) END) TPSZ_DP30" ).append("\n"); 
		query.append("			    FROM   (SELECT  /*+ LEADING(C) USE_HASH(C A) FULL(A) */" ).append("\n"); 
		query.append("								C.LSTM_CD, A.AGMT_CTY_CD, A.AGMT_SEQ, C.REF_NO, C.Lse_Ctrt_No," ).append("\n"); 
		query.append("			                    A.CNTR_TPSZ_CD, C.VNDR_SEQ, COUNT(A.CNTR_NO) AS VOL_CNT" ).append("\n"); 
		query.append("			            FROM    MST_CONTAINER A," ).append("\n"); 
		query.append("			                    LSE_AGREEMENT C            " ).append("\n"); 
		query.append("			            WHERE   A.CNTR_STS_CD NOT IN ('LSO','DIO','DON','SCR','TLL','SLD','SRO')" ).append("\n"); 
		query.append("			            AND     A.AGMT_CTY_CD = C.AGMT_CTY_CD        " ).append("\n"); 
		query.append("			            AND     A.AGMT_SEQ = C.AGMT_SEQ        " ).append("\n"); 
		query.append("			            AND     A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("--						AND     A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("					    AND     A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("#if (${loc_tp} == 'RCC')" ).append("\n"); 
		query.append("						AND     A.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'LCC')" ).append("\n"); 
		query.append("						AND     A.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'SCC')" ).append("\n"); 
		query.append("						AND     A.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end						" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("						AND     C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end						" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("						AND     A.AGMT_CTY_CD = 'HHO'" ).append("\n"); 
		query.append("        				AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("   						AND     A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($key IN ${cnmv_sts_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cnmv_sts_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                    			)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("			            GROUP BY C.LSTM_CD, A.AGMT_CTY_CD, A.AGMT_SEQ, C.REF_NO, C.Lse_Ctrt_No, A.CNTR_TPSZ_CD, C.VNDR_SEQ) A," ).append("\n"); 
		query.append("			           (SELECT  CNTR_TPSZ_CD, ROW_NUMBER() OVER(ORDER BY RPT_DP_SEQ) AS RPT_DP_SEQ  " ).append("\n"); 
		query.append("			            FROM    MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                        WHERE  DELT_FLG = 'N' AND ACIAC_DIV_CD = 'A') C       " ).append("\n"); 
		query.append("			    WHERE   1 = 1" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    			AND     A.LSTM_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${lstm_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $lstm_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            			)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    			AND     A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_tpsz_cd_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_tpsz_cd_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("            			)" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("			    GROUP BY ROLLUP(A.LSTM_CD, A.AGMT_CTY_CD, A.AGMT_SEQ, A.REF_NO, A.Lse_Ctrt_No, A.VNDR_SEQ)             " ).append("\n"); 
		query.append("				) A				" ).append("\n"); 
		query.append("		WHERE   A.LSTM_CD = B.LSTM_CD(+)" ).append("\n"); 
		query.append("    	ORDER BY B.DP_SEQ, A.LSTM_CD, DECODE(A.AGMT_SEQ,'',0,1), A.AGMT_SEQ  				" ).append("\n"); 
		query.append("		) A    " ).append("\n"); 
		query.append("WHERE   A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND	   (A.REF_NO IS NOT NULL" ).append("\n"); 
		query.append("AND     A.VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("OR      A.AGMT_NO IS NULL" ).append("\n"); 
		query.append("OR      A.LSTM_CD IS NULL)" ).append("\n"); 

	}
}