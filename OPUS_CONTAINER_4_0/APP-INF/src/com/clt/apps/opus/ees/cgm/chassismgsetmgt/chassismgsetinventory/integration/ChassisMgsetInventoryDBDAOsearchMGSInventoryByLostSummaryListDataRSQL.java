/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLostSummaryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByLostSummaryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090915 2080 start
	  * 
	  * [CHM-201004960-01] Genset Ineventory Logic error 수정건
	  *     : SCC를 조회조건으로 Retrive시 사용되는 조회쿼리 수정 by 김상수
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByLostSummaryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s2_agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s1_inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_crnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_crnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s2_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLostSummaryListDataRSQL").append("\n"); 
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
		query.append("#if(${program_id}== '2020')" ).append("\n"); 
		query.append("	#if ( ${s_eq_tpsz_cd} == 'LST')" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("			 AAA.EQ_NO" ).append("\n"); 
		query.append("			,AAA.AGMT_NO" ).append("\n"); 
		query.append("			,AAA.AGMT_LSTM_CD" ).append("\n"); 
		query.append("			,AAA.EQ_TPSZ_CD" ).append("\n"); 
		query.append("			,AAA.VNDR_ABBR_NM" ).append("\n"); 
		query.append("			,AAA.CHSS_NO" ).append("\n"); 
		query.append("			,AAA.CNTR_NO" ).append("\n"); 
		query.append("			,AAA.LCC_CD" ).append("\n"); 
		query.append("			,AAA.SCC_CD" ).append("\n"); 
		query.append("			,AAA.CRNT_YD_CD" ).append("\n"); 
		query.append("			,AAA.LSDAYS" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("						 A.EQ_NO" ).append("\n"); 
		query.append("						,A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("						,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("						,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("						,F.VNDR_LGL_ENG_NM VNDR_ABBR_NM" ).append("\n"); 
		query.append("						,E.CHSS_NO" ).append("\n"); 
		query.append("						,E.CNTR_NO" ).append("\n"); 
		query.append("						,D.LCC_CD" ).append("\n"); 
		query.append("						,C.SCC_CD" ).append("\n"); 
		query.append("						,A.CRNT_YD_CD" ).append("\n"); 
		query.append("						, CASE WHEN LAG ( B.EQ_ASET_STS_CD ) OVER (PARTITION BY  B.EQ_NO ORDER BY B.EQ_NO,B.STS_EVNT_DT,B.EQ_STS_SEQ )  = 'LST' AND  B.EQ_ASET_STS_CD = 'FND' THEN NULL" ).append("\n"); 
		query.append("							ELSE  B.EQ_ASET_STS_CD" ).append("\n"); 
		query.append("						  END EVENT_KNT" ).append("\n"); 
		query.append("						,  CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("								(SELECT CHSS_MVMT_STS_CD FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("								(SELECT CNMV_STS_CD FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("							END MVMT," ).append("\n"); 
		query.append("							CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("								(SELECT CHSS_MVMT_DT FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("								(SELECT CNMV_DT FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("							END MVMT_DATE," ).append("\n"); 
		query.append("							CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("								(SELECT TRUNC(SYSDATE - CHSS_MVMT_DT,0) FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("							ELSE" ).append("\n"); 
		query.append("								(SELECT TRUNC(SYSDATE - CNMV_DT,0) FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("							END LSDAYS" ).append("\n"); 
		query.append("				FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("				,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("				,MDM_LOCATION C" ).append("\n"); 
		query.append("				,MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("				,CGM_EQ_ATCH_DTCH_HIS E" ).append("\n"); 
		query.append("				,MDM_VENDOR F" ).append("\n"); 
		query.append("				WHERE  A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("				AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("				--AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("				--AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("				AND A.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("				#if ( ${s_eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("				AND B.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("				AND B.STS_EVNT_DT <  TO_DATE(@[sts_evnt_dt_to] ,'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				AND  C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("				AND  C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				AND  D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("					  AND A.EQ_NO = E.EQ_NO(+)" ).append("\n"); 
		query.append("					  AND NVL(E.ATCH_DT,  sysdate )= (SELECT  /*+ INDEX_DESC(B XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("															NVL(MAX(ATCH_DT), sysdate )" ).append("\n"); 
		query.append("														 FROM CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("														 WHERE" ).append("\n"); 
		query.append("															B.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("															AND ROWNUM =1" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("				AND B.STS_EVNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("				AND B.EQ_ASET_STS_CD IN  ('LST','FND','TLL' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${scc_cd} != '' )" ).append("\n"); 
		query.append("					#if ( ${s_location} == 'R' )" ).append("\n"); 
		query.append("						AND  D.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("					#elseif ( ${s_location} == 'L' )" ).append("\n"); 
		query.append("						AND  D.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("					#elseif ( ${s_location} == 'S' )" ).append("\n"); 
		query.append("						AND   D.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("						AND   D.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("				 AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${s_crnt_loc_cd} != '' )" ).append("\n"); 
		query.append("					 #if ( ${s_location} == 'R' )" ).append("\n"); 
		query.append("						AND D.LCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("					 #elseif ( ${s_location} == 'L' )" ).append("\n"); 
		query.append("						AND  D.SCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("					 #else" ).append("\n"); 
		query.append("						AND B.STS_EVNT_YD_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${s2_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("					AND A.AGMT_LSTM_CD = @[s2_agmt_lstm_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			) AAA" ).append("\n"); 
		query.append("			WHERE AAA.EVENT_KNT IS NOT NULL" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			SELECT" ).append("\n"); 
		query.append("					 A.EQ_NO" ).append("\n"); 
		query.append("					,A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("					,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("					,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("					,F.VNDR_LGL_ENG_NM VNDR_ABBR_NM" ).append("\n"); 
		query.append("					,E.CHSS_NO" ).append("\n"); 
		query.append("					,E.CNTR_NO" ).append("\n"); 
		query.append("					,D.LCC_CD" ).append("\n"); 
		query.append("					,C.SCC_CD" ).append("\n"); 
		query.append("					,A.CRNT_YD_CD" ).append("\n"); 
		query.append("					,  CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("							(SELECT CHSS_MVMT_STS_CD FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							(SELECT CNMV_STS_CD FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("						END MVMT," ).append("\n"); 
		query.append("						CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("							(SELECT CHSS_MVMT_DT FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							(SELECT CNMV_DT FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("						END MVMT_DATE," ).append("\n"); 
		query.append("						CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("							(SELECT TRUNC(SYSDATE - CHSS_MVMT_DT,0) FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("						ELSE" ).append("\n"); 
		query.append("							(SELECT TRUNC(SYSDATE - CNMV_DT,0) FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("						END LSDAYS" ).append("\n"); 
		query.append("			FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("			,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("			,MDM_LOCATION C" ).append("\n"); 
		query.append("			,MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("			,CGM_EQ_ATCH_DTCH_HIS E" ).append("\n"); 
		query.append("			,MDM_VENDOR F" ).append("\n"); 
		query.append("			WHERE  A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("			AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("			--AND A.AGMT_OFC_CTY_CD = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("			--AND A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("			AND A.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("			#if ( ${s_eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("			AND B.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("			AND B.STS_EVNT_DT <  TO_DATE(@[sts_evnt_dt_to] ,'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND  C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("			AND  C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("			AND  D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				  AND A.EQ_NO = E.EQ_NO(+)" ).append("\n"); 
		query.append("				  AND NVL(E.ATCH_DT,  sysdate )= (SELECT  /*+ INDEX_DESC(B XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("														NVL(MAX(ATCH_DT), sysdate )" ).append("\n"); 
		query.append("													 FROM CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("													 WHERE" ).append("\n"); 
		query.append("														B.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("														AND ROWNUM =1" ).append("\n"); 
		query.append("													)" ).append("\n"); 
		query.append("			AND B.STS_EVNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("			#if ( ${s_eq_tpsz_cd} == 'LST')" ).append("\n"); 
		query.append("				AND B.EQ_ASET_STS_CD IN  ('LST','FND' )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if ( ${scc_cd} != '' )" ).append("\n"); 
		query.append("				#if ( ${s_location} == 'R' )" ).append("\n"); 
		query.append("					AND  D.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("				#elseif ( ${s_location} == 'L' )" ).append("\n"); 
		query.append("					AND  D.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("				#elseif ( ${s_location} == 'S' )" ).append("\n"); 
		query.append("					AND   D.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("					AND   D.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("			 AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${s_crnt_loc_cd} != '' )" ).append("\n"); 
		query.append("				 #if ( ${s_location} == 'R' )" ).append("\n"); 
		query.append("					AND D.LCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("				 #elseif ( ${s_location} == 'L' )" ).append("\n"); 
		query.append("					AND  D.SCC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("				 #else" ).append("\n"); 
		query.append("					AND B.STS_EVNT_YD_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${s_eq_tpsz_cd} == 'FND')" ).append("\n"); 
		query.append("				AND B.EQ_ASET_STS_CD =  'FND'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${s_eq_tpsz_cd} == '')" ).append("\n"); 
		query.append("				AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("				AND A.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("				AND B.EQ_ASET_STS_CD =  'LST'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if ( ${s2_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("				AND A.AGMT_LSTM_CD = @[s2_agmt_lstm_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif ( ${program_id}== '2012' )" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("			 A.EQ_NO" ).append("\n"); 
		query.append("			,A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append("			,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("			,A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("			,F.VNDR_LGL_ENG_NM VNDR_ABBR_NM" ).append("\n"); 
		query.append("			,E.CHSS_NO" ).append("\n"); 
		query.append("			,E.CNTR_NO" ).append("\n"); 
		query.append("			,D.LCC_CD" ).append("\n"); 
		query.append("			,C.SCC_CD" ).append("\n"); 
		query.append("			,A.CRNT_YD_CD" ).append("\n"); 
		query.append("			,  CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("					(SELECT CHSS_MVMT_STS_CD FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("				ELSE" ).append("\n"); 
		query.append("					(SELECT CNMV_STS_CD FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("				END MVMT," ).append("\n"); 
		query.append("				CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("					(SELECT CHSS_MVMT_DT FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("				ELSE" ).append("\n"); 
		query.append("					(SELECT CNMV_DT FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("				END MVMT_DATE," ).append("\n"); 
		query.append("				CASE WHEN E.CHSS_NO != '' THEN" ).append("\n"); 
		query.append("					(SELECT TRUNC(SYSDATE - CHSS_MVMT_DT,0) FROM CGM_EQUIPMENT WHERE EQ_NO = E.CHSS_NO)" ).append("\n"); 
		query.append("				ELSE" ).append("\n"); 
		query.append("					(SELECT TRUNC(SYSDATE - CNMV_DT,0) FROM MST_CONTAINER WHERE CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("				END LSDAYS" ).append("\n"); 
		query.append("	FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("	,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("	,MDM_LOCATION C" ).append("\n"); 
		query.append("    ,CGM_AGREEMENT CC" ).append("\n"); 
		query.append("	,MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	,CGM_EQ_ATCH_DTCH_HIS E" ).append("\n"); 
		query.append("	,MDM_VENDOR F" ).append("\n"); 
		query.append("	WHERE  A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("	AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("	AND A.AGMT_OFC_CTY_CD = CC.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND A.AGMT_SEQ = CC.AGMT_SEQ" ).append("\n"); 
		query.append("	AND A.VNDR_SEQ = F.VNDR_SEQ" ).append("\n"); 
		query.append("    AND CC.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("	AND B.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	AND B.STS_EVNT_DT <  TO_DATE(@[sts_evnt_dt_to] ,'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("    AND B.TERM_CNG_SEQ IS NULL" ).append("\n"); 
		query.append("	AND  C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("	AND  C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("	AND  D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		  AND A.EQ_NO = E.EQ_NO(+)" ).append("\n"); 
		query.append("		  AND NVL(E.ATCH_DT,  sysdate )= (SELECT  /*+ INDEX_DESC(B XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("												NVL(MAX(ATCH_DT), sysdate )" ).append("\n"); 
		query.append("											 FROM CGM_EQ_ATCH_DTCH_HIS B" ).append("\n"); 
		query.append("											 WHERE" ).append("\n"); 
		query.append("												B.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append("												AND ROWNUM =1" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("	AND B.STS_EVNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("    AND B.EQ_ASET_STS_CD = @[s1_inq_to_dys]" ).append("\n"); 
		query.append("    #if (${s_crnt_loc_cd} != '')" ).append("\n"); 
		query.append("       #if (${s_location} == 'S')" ).append("\n"); 
		query.append("  	AND B.STS_EVNT_YD_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("   	AND B.STS_EVNT_LOC_CD = @[s_crnt_loc_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("       #if (${s2_group1} == 'L' )" ).append("\n"); 
		query.append("		   AND	CC.VNDR_SEQ IN ($s_vndr_seq)" ).append("\n"); 
		query.append("	   #elseif ( ${s2_group1} == 'A' )" ).append("\n"); 
		query.append("		   AND  (CC.AGMT_OFC_CTY_CD,CC.AGMT_SEQ ) IN ($vndr_seq)" ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${s2_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("    	AND A.AGMT_LSTM_CD = @[s2_agmt_lstm_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${s_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("		AND A.AGMT_LSTM_CD IN ($s_agmt_lstm_cd)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if( ${s_crnt_yd_cd} != '')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_YD_CD = @[s_crnt_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${s2_loc_cd} != '' )" ).append("\n"); 
		query.append("		#if ( ${s_location} == 'R' )" ).append("\n"); 
		query.append("			AND  D.RCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${s_location} == 'L' )" ).append("\n"); 
		query.append("			AND  D.LCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${s_location} == 'S' )" ).append("\n"); 
		query.append("			AND   D.SCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			AND   D.SCC_CD = @[s2_loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("		AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}