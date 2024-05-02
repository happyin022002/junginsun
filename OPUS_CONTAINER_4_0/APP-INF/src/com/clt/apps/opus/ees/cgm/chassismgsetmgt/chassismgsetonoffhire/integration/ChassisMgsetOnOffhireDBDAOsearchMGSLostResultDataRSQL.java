/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchMGSLostResultDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchMGSLostResultDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lost M.G. Set Summary    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchMGSLostResultDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_aset_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_str",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchMGSLostResultDataRSQL").append("\n"); 
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
		query.append("#if ( ${eq_aset_sts_cd} == 'LST')" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("		 AAA.AGREEMENT" ).append("\n"); 
		query.append("		,AAA.STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("		,AAA.AGMT_LSTM_CD" ).append("\n"); 
		query.append("		,COUNT(AAA.EQ_TPSZ_CD)                  AS TOTAL," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '1' THEN 1 END),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '2' THEN 1 END),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '3' THEN 1 END),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '4' THEN 1 END),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '5' THEN 1 END),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '6' THEN 1 END),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '7' THEN 1 END),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '8' THEN 1 END),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '9' THEN 1 END),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '10' THEN 1 END),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '11' THEN 1 END),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '12' THEN 1 END),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '13' THEN 1 END),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '14' THEN 1 END),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '15' THEN 1 END),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '16' THEN 1 END),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '17' THEN 1 END),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '18' THEN 1 END),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '19' THEN 1 END),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("NVL(SUM(CASE WHEN AAA.DP_SEQ = '20' THEN 1 END),0) AS EQ_TPSZ_CD20" ).append("\n"); 
		query.append("	FROM (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("		#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("			   BB.LCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT " ).append("\n"); 
		query.append("			 , BB.LCC_CD                    AS STS_EVNT_LOC_CD " ).append("\n"); 
		query.append("		#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("			   BB.SCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT " ).append("\n"); 
		query.append("			 , BB.SCC_CD                    AS STS_EVNT_LOC_CD " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			   B.STS_EVNT_YD_CD  || A.AGMT_LSTM_CD  AS AGREEMENT " ).append("\n"); 
		query.append("			 , B.STS_EVNT_YD_CD                   AS STS_EVNT_LOC_CD " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		    ,A.AGMT_LSTM_CD                       AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("			,A.EQ_TPSZ_CD                  AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("			,A.VNDR_SEQ , t1.DP_SEQ" ).append("\n"); 
		query.append("			, CASE WHEN LAG ( B.EQ_ASET_STS_CD ) OVER (PARTITION BY  B.EQ_NO ORDER BY B.EQ_NO,B.STS_EVNT_DT,B.EQ_STS_SEQ )  = 'LST' AND  B.EQ_ASET_STS_CD = 'FND' THEN NULL" ).append("\n"); 
		query.append("				ELSE  B.EQ_ASET_STS_CD" ).append("\n"); 
		query.append("			  END EVENT_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM CGM_EQUIPMENT A " ).append("\n"); 
		query.append("			,CGM_EQ_STS_HIS B " ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("			,MDM_LOCATION AA" ).append("\n"); 
		query.append("			,MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("			,CGM_EQ_TP_SZ t1" ).append("\n"); 
		query.append("		WHERE  A.EQ_KND_CD = 'G' " ).append("\n"); 
		query.append("		AND A.EQ_NO = B.EQ_NO " ).append("\n"); 
		query.append(" 		AND A.EQ_TPSZ_CD = t1.EQ_TPSZ_CD" ).append("\n"); 
		query.append("		#if ( ${eq_aset_sts_cd} != '')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_DT >= TO_DATE(@[evnt_dt_str],'YYYY-MM-DD')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_DT <= TO_DATE(@[evnt_dt_end] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		AND  AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("		AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND  (BB.DELT_FLG = 'N' OR BB.DELT_FLG IS NULL)" ).append("\n"); 
		query.append("		AND B.STS_EVNT_LOC_CD = AA.LOC_CD		 " ).append("\n"); 
		query.append("		AND B.EQ_ASET_STS_CD IN  ('LST','FND','TLL' )" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("		#if ( ${scc_cd} != '' )" ).append("\n"); 
		query.append("			#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("				AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("			#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("				AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("			#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("				AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("		 AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) AAA" ).append("\n"); 
		query.append("	WHERE  AAA.EVENT_KNT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY AAA.AGREEMENT" ).append("\n"); 
		query.append("		,AAA.STS_EVNT_LOC_CD" ).append("\n"); 
		query.append("		,AAA.AGMT_LSTM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("		   BB.LCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT " ).append("\n"); 
		query.append("		 , BB.LCC_CD                    AS STS_EVNT_LOC_CD " ).append("\n"); 
		query.append("	#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("		   BB.SCC_CD || A.AGMT_LSTM_CD  AS AGREEMENT " ).append("\n"); 
		query.append("		 , BB.SCC_CD                    AS STS_EVNT_LOC_CD " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		   B.STS_EVNT_YD_CD  || A.AGMT_LSTM_CD  AS AGREEMENT " ).append("\n"); 
		query.append("		 , B.STS_EVNT_YD_CD                   AS STS_EVNT_LOC_CD " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		 ,A.AGMT_LSTM_CD                       AS AGMT_LSTM_CD " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("		 ,COUNT(A.EQ_TPSZ_CD)                  AS TOTAL ," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '1' THEN 1 END),0) AS EQ_TPSZ_CD1," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '2' THEN 1 END),0) AS EQ_TPSZ_CD2," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '3' THEN 1 END),0) AS EQ_TPSZ_CD3," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '4' THEN 1 END),0) AS EQ_TPSZ_CD4," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '5' THEN 1 END),0) AS EQ_TPSZ_CD5," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '6' THEN 1 END),0) AS EQ_TPSZ_CD6," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '7' THEN 1 END),0) AS EQ_TPSZ_CD7," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '8' THEN 1 END),0) AS EQ_TPSZ_CD8," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '9' THEN 1 END),0) AS EQ_TPSZ_CD9," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '10' THEN 1 END),0) AS EQ_TPSZ_CD10," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '11' THEN 1 END),0) AS EQ_TPSZ_CD11," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '12' THEN 1 END),0) AS EQ_TPSZ_CD12," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '13' THEN 1 END),0) AS EQ_TPSZ_CD13," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '14' THEN 1 END),0) AS EQ_TPSZ_CD14," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '15' THEN 1 END),0) AS EQ_TPSZ_CD15," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '16' THEN 1 END),0) AS EQ_TPSZ_CD16," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '17' THEN 1 END),0) AS EQ_TPSZ_CD17," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '18' THEN 1 END),0) AS EQ_TPSZ_CD18," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '19' THEN 1 END),0) AS EQ_TPSZ_CD19," ).append("\n"); 
		query.append("		NVL(SUM(CASE WHEN t1.DP_SEQ = '20' THEN 1 END),0) AS EQ_TPSZ_CD20	" ).append("\n"); 
		query.append("	FROM CGM_EQUIPMENT A " ).append("\n"); 
		query.append("		,CGM_EQ_STS_HIS B " ).append("\n"); 
		query.append("		,MDM_LOCATION AA" ).append("\n"); 
		query.append("		,MDM_EQ_ORZ_CHT BB " ).append("\n"); 
		query.append("		,CGM_EQ_TP_SZ t1" ).append("\n"); 
		query.append("	WHERE  A.EQ_KND_CD = 'G' " ).append("\n"); 
		query.append("	AND A.EQ_NO = B.EQ_NO " ).append("\n"); 
		query.append(" 	AND A.EQ_TPSZ_CD = t1.EQ_TPSZ_CD" ).append("\n"); 
		query.append("	#if ( ${eq_aset_sts_cd} != '')" ).append("\n"); 
		query.append("	AND B.STS_EVNT_DT >= TO_DATE(@[evnt_dt_str],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	AND B.STS_EVNT_DT <= TO_DATE(@[evnt_dt_end] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND  AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("	AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND  (BB.DELT_FLG = 'N' OR BB.DELT_FLG IS NULL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND B.STS_EVNT_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${scc_cd} != '' )" ).append("\n"); 
		query.append("		#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("			AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("			AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("			AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("	 AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${eq_aset_sts_cd} == 'FND')" ).append("\n"); 
		query.append("		AND B.EQ_ASET_STS_CD =  @[eq_aset_sts_cd]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${eq_aset_sts_cd} == '')" ).append("\n"); 
		query.append("		AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("		AND A.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("		AND B.EQ_ASET_STS_CD =  'LST' " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${location} == 'R' )" ).append("\n"); 
		query.append("	GROUP BY  BB.LCC_CD ,A.AGMT_LSTM_CD--,D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	ORDER BY BB.LCC_CD ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("	GROUP BY  BB.SCC_CD ,A.AGMT_LSTM_CD--,D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	ORDER BY BB.SCC_CD ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	GROUP BY  B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD--,D.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	ORDER BY B.STS_EVNT_YD_CD ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}