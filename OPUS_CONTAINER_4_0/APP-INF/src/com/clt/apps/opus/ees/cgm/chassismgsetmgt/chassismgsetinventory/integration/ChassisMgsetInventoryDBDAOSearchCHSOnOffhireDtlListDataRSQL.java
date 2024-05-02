/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOSearchCHSOnOffhireDtlListDataRSQL.java
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

public class ChassisMgsetInventoryDBDAOSearchCHSOnOffhireDtlListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChassisMgsetInventoryDBDAOSearchCHSOnOffhireDtlListDataRSQL
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOSearchCHSOnOffhireDtlListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("agmt_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sts_evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOSearchCHSOnOffhireDtlListDataRSQL").append("\n"); 
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
		query.append("#if(${program_id}== '1010')" ).append("\n"); 
		query.append("	SELECT /* distinct */" ).append("\n"); 
		query.append("		A.EQ_NO," ).append("\n"); 
		query.append("		A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("		A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("		A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("		B.VNDR_LGL_ENG_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("		A.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("		D.LCC_CD," ).append("\n"); 
		query.append("		C.SCC_CD," ).append("\n"); 
		query.append("		E.STS_EVNT_YD_CD CRNT_YD_CD," ).append("\n"); 
		query.append("		A.ONH_DT," ).append("\n"); 
		query.append("		A.CHSS_MVMT_DT," ).append("\n"); 
		query.append("		TRUNC(SYSDATE - A.CHSS_MVMT_DT,0) AS LSDAYS" ).append("\n"); 
		query.append("	FROM     " ).append("\n"); 
		query.append("		CGM_EQUIPMENT A," ).append("\n"); 
		query.append("		MDM_VENDOR B," ).append("\n"); 
		query.append("		MDM_LOCATION C," ).append("\n"); 
		query.append("		MDM_EQ_ORZ_CHT D," ).append("\n"); 
		query.append("		CGM_EQ_STS_HIS E," ).append("\n"); 
		query.append("		CGM_AGREEMENT F" ).append("\n"); 
		query.append("	WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("		  AND E.STS_EVNT_LOC_CD = C.LOC_CD" ).append("\n"); 
		query.append("		  AND C.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("		  AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		  AND D.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		  AND A.AGMT_OFC_CTY_CD = F.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		  AND A.AGMT_SEQ = F.AGMT_SEQ" ).append("\n"); 
		query.append("          AND F.LST_VER_FLG ='Y'" ).append("\n"); 
		query.append("		  AND A.EQ_KND_CD =  @[eq_knd_cd]" ).append("\n"); 
		query.append("		  AND A.EQ_NO = E.EQ_NO" ).append("\n"); 
		query.append("		  AND E.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYY-MM-DD')  --" ).append("\n"); 
		query.append("		  AND E.STS_EVNT_DT <  TO_DATE(@[sts_evnt_dt_to],'YYYY-MM-DD')+1  --   " ).append("\n"); 
		query.append("		  AND E.EQ_ASET_STS_CD = @[eq_aset_sts_cd]" ).append("\n"); 
		query.append("		  AND E.TERM_CNG_SEQ IS NULL" ).append("\n"); 
		query.append("	#if (${crnt_yd_cd} != '') " ).append("\n"); 
		query.append("		  AND E.STS_EVNT_YD_CD = @[crnt_yd_cd]  " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 #if ( ${location} == 'R' ) " ).append("\n"); 
		query.append("	   AND  D.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("	   AND  D.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	#elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("	  AND   D.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${eq_tpsz_cd} != '') " ).append("\n"); 
		query.append("		AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${sts_evnt_loc_cd} != '') " ).append("\n"); 
		query.append("		AND E.STS_EVNT_LOC_CD  = @[sts_evnt_loc_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${agmt_lstm_cd} != '' && ${agmt_lstm_cd} != 'ALL') " ).append("\n"); 
		query.append("		AND A.AGMT_LSTM_CD  = @[agmt_lstm_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${s_agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("		AND A.AGMT_LSTM_CD IN ($s_agmt_lstm_cd)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (  ${vndr_seq} != '' )" ).append("\n"); 
		query.append("	   #if (${kind} == 'L' )" ).append("\n"); 
		query.append("		   AND	F.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("	   #elseif ( ${kind} == 'A' )" ).append("\n"); 
		query.append("		   AND  (F.AGMT_OFC_CTY_CD,F.AGMT_SEQ ) IN ($vndr_seq)       " ).append("\n"); 
		query.append("	   #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif ( ${program_id}== '1019' )" ).append("\n"); 
		query.append("#if ( ${eq_aset_sts_cd} == 'LST')" ).append("\n"); 
		query.append("SELECT AAA.EQ_NO," ).append("\n"); 
		query.append("	   AAA.EQ_TPSZ_CD," ).append("\n"); 
		query.append("	   AAA.AGMT_LSTM_CD," ).append("\n"); 
		query.append("	   AAA.AGMT_NO," ).append("\n"); 
		query.append("	   AAA.VNDR_ABBR_NM," ).append("\n"); 
		query.append("	   AAA.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("	   AAA.LCC_CD," ).append("\n"); 
		query.append("	   AAA.SCC_CD," ).append("\n"); 
		query.append("	   AAA.CRNT_YD_CD," ).append("\n"); 
		query.append("	   AAA.ONH_DT," ).append("\n"); 
		query.append("	   AAA.CHSS_MVMT_DT," ).append("\n"); 
		query.append("	   AAA.LSDAYS" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("			SELECT /* distinct */" ).append("\n"); 
		query.append("				A.EQ_NO," ).append("\n"); 
		query.append("				A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("				A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("				A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("				D.VNDR_LGL_ENG_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("				A.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("				BB.LCC_CD," ).append("\n"); 
		query.append("				AA.SCC_CD," ).append("\n"); 
		query.append("				B.STS_EVNT_YD_CD CRNT_YD_CD," ).append("\n"); 
		query.append("				A.ONH_DT," ).append("\n"); 
		query.append("				A.CHSS_MVMT_DT," ).append("\n"); 
		query.append("				TRUNC(SYSDATE - A.CHSS_MVMT_DT,0) AS LSDAYS," ).append("\n"); 
		query.append(" 				CASE WHEN LAG ( B.EQ_ASET_STS_CD ) OVER (PARTITION BY  B.EQ_NO ORDER BY B.EQ_NO,B.STS_EVNT_DT,B.EQ_STS_SEQ )  = 'LST' AND  B.EQ_ASET_STS_CD = 'FND' THEN NULL" ).append("\n"); 
		query.append("					ELSE  B.EQ_ASET_STS_CD" ).append("\n"); 
		query.append("			  	END EVENT_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("			,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("			,MDM_VENDOR D" ).append("\n"); 
		query.append("			,MDM_LOCATION AA" ).append("\n"); 
		query.append("			,MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("		WHERE  A.EQ_KND_CD = 'Z'  " ).append("\n"); 
		query.append("		AND A.EQ_NO = B.EQ_NO " ).append("\n"); 
		query.append("		AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("	#if ( ${eq_aset_sts_cd} != '')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_DT <  TO_DATE(@[sts_evnt_dt_to] ,'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND  AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("		AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND B.STS_EVNT_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("	#if ( ${eq_aset_sts_cd} == 'LST')" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("		AND B.EQ_ASET_STS_CD IN  ('LST','FND', 'TLL' )" ).append("\n"); 
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
		query.append("		#if (${eq_tpsz_cd} != '') " ).append("\n"); 
		query.append("			AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${agmt_lstm_cd} != '' && ${agmt_lstm_cd} != 'ALL') " ).append("\n"); 
		query.append("			AND A.AGMT_LSTM_CD  = @[agmt_lstm_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("		   AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${crnt_yd_cd} != '') " ).append("\n"); 
		query.append("			  AND B.STS_EVNT_YD_CD = @[crnt_yd_cd]  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (  ${vndr_seq} != '' )" ).append("\n"); 
		query.append("		   AND	A.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${sts_evnt_loc_cd} != '')  " ).append("\n"); 
		query.append("		#if ( ${location} == 'C' )" ).append("\n"); 
		query.append("			AND  BB.RCC_CD = @[sts_evnt_loc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${location} == 'R' )" ).append("\n"); 
		query.append("			AND  BB.LCC_CD = @[sts_evnt_loc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("			AND   BB.SCC_CD = @[sts_evnt_loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    #if (${scc_cd} != '')  " ).append("\n"); 
		query.append("        #if ( ${location} == 'R' ) " ).append("\n"); 
		query.append("	       AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	    #elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("	       AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	    #elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("	      AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	) AAA" ).append("\n"); 
		query.append("	WHERE AAA.EVENT_KNT IS NOT NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			SELECT /* distinct */" ).append("\n"); 
		query.append("				A.EQ_NO," ).append("\n"); 
		query.append("				A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("				A.AGMT_LSTM_CD," ).append("\n"); 
		query.append("				A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO," ).append("\n"); 
		query.append("				D.VNDR_LGL_ENG_NM VNDR_ABBR_NM," ).append("\n"); 
		query.append("				A.CHSS_MVMT_STS_CD," ).append("\n"); 
		query.append("				BB.LCC_CD," ).append("\n"); 
		query.append("				AA.SCC_CD," ).append("\n"); 
		query.append("				B.STS_EVNT_YD_CD CRNT_YD_CD," ).append("\n"); 
		query.append("				A.ONH_DT," ).append("\n"); 
		query.append("				A.CHSS_MVMT_DT," ).append("\n"); 
		query.append("				TRUNC(SYSDATE - A.CHSS_MVMT_DT,0) AS LSDAYS" ).append("\n"); 
		query.append("			FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("			,CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("			,MDM_VENDOR D" ).append("\n"); 
		query.append("			,MDM_LOCATION AA" ).append("\n"); 
		query.append("			,MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("		WHERE  A.EQ_KND_CD = 'Z'  " ).append("\n"); 
		query.append("		AND A.EQ_NO = B.EQ_NO " ).append("\n"); 
		query.append("		AND A.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("	#if ( ${eq_aset_sts_cd} != '')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_DT >= TO_DATE(@[sts_evnt_dt_fr],'YYYY-MM-DD')" ).append("\n"); 
		query.append("		AND B.STS_EVNT_DT <  TO_DATE(@[sts_evnt_dt_to] ,'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		AND  AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("		AND  AA.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND  BB.DELT_FLG = 'N'" ).append("\n"); 
		query.append("		AND B.STS_EVNT_LOC_CD = AA.LOC_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
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
		query.append("		#if (${eq_tpsz_cd} != '') " ).append("\n"); 
		query.append("			AND A.EQ_TPSZ_CD = @[eq_tpsz_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${agmt_lstm_cd} != '' && ${agmt_lstm_cd} != 'ALL') " ).append("\n"); 
		query.append("			AND A.AGMT_LSTM_CD  = @[agmt_lstm_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if ( ${sts_evnt_yd_cd} != '' )" ).append("\n"); 
		query.append("		   AND B.STS_EVNT_YD_CD = @[sts_evnt_yd_cd] " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${crnt_yd_cd} != '') " ).append("\n"); 
		query.append("			  AND B.STS_EVNT_YD_CD = @[crnt_yd_cd]  " ).append("\n"); 
		query.append("		#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (  ${vndr_seq} != '' )" ).append("\n"); 
		query.append("		   AND	A.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${sts_evnt_loc_cd} != '')  " ).append("\n"); 
		query.append("		#if ( ${location} == 'C' )" ).append("\n"); 
		query.append("			AND  BB.RCC_CD = @[sts_evnt_loc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${location} == 'R' )" ).append("\n"); 
		query.append("			AND  BB.LCC_CD = @[sts_evnt_loc_cd]" ).append("\n"); 
		query.append("		#elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("			AND   BB.SCC_CD = @[sts_evnt_loc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${scc_cd} != '')  " ).append("\n"); 
		query.append("        #if ( ${location} == 'R' ) " ).append("\n"); 
		query.append("	       AND  BB.RCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	    #elseif ( ${location} == 'L' )" ).append("\n"); 
		query.append("	       AND  BB.LCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	    #elseif ( ${location} == 'S' )" ).append("\n"); 
		query.append("	      AND   BB.SCC_CD = @[scc_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}