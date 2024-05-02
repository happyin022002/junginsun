/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchDisposalCandidateFlagByRangeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchDisposalCandidateFlagByRangeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalCandidateFlagByRangeData
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchDisposalCandidateFlagByRangeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fryear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("toyear",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchDisposalCandidateFlagByRangeDataRSQL").append("\n"); 
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
		query.append("#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		 A.LOT_CNTR_PFX_CD AS LOT_EQ_PFX_CD" ).append("\n"); 
		query.append("		, A.FM_SER_NO" ).append("\n"); 
		query.append("		, A.TO_SER_NO" ).append("\n"); 
		query.append("		, 'DSP' AS MNR_GRP_TP_CD" ).append("\n"); 
		query.append("		, 'U' AS EQ_KND_CD" ).append("\n"); 
		query.append("		, A.CNTR_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("		, B.EQ_MKR_NM" ).append("\n"); 
		query.append("		, B.EQ_MDL_NM" ).append("\n"); 
		query.append("		, DECODE(B.MNR_DISP_SEL_FLG ,NULL,0,'Y',1,0) AS MNR_DISP_SEL_FLG " ).append("\n"); 
		query.append("        , TO_CHAR(B.MNR_DISP_SEL_FLG_DT, 'YYYY-MM-DD') AS MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append("		, B.FM_WARR_DT" ).append("\n"); 
		query.append("		, B.TO_WARR_DT" ).append("\n"); 
		query.append("		, B.WARR_RMK" ).append("\n"); 
		query.append("		, TO_CHAR(A.MFT_DT, 'YYYY') AS MFT_YR" ).append("\n"); 
		query.append("		, (A.TO_SER_NO - A.FM_SER_NO +1) AS EQ_QTY" ).append("\n"); 
		query.append("		, B.CRE_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), B.CRE_DT,@[user_ofc_cd]), 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("		, B.UPD_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), B.UPD_DT,@[user_ofc_cd]), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("		, (A.LOT_CNTR_PFX_CD || A.FM_SER_NO || '-' || A.TO_SER_NO ) EQ_RANGE_NO" ).append("\n"); 
		query.append("        ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("            FROM    MST_CONTAINER MC" ).append("\n"); 
		query.append("           WHERE   1=1" ).append("\n"); 
		query.append("             AND A.LOT_PLN_YR    = MC.LOT_PLN_YR" ).append("\n"); 
		query.append("             AND A.LOT_LOC_CD    = MC.LOT_LOC_CD" ).append("\n"); 
		query.append("             AND A.CNTR_TPSZ_CD  = MC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             AND A.LOT_SEQ       = MC.LOT_SEQ" ).append("\n"); 
		query.append("             AND MC.ACIAC_DIV_CD   = 'A'" ).append("\n"); 
		query.append("             AND MC.LSTM_CD = 'OW'" ).append("\n"); 
		query.append("          ) AS ACT_QTY" ).append("\n"); 
		query.append("		FROM MST_CNTR_LOT A, MNR_EQ_RNG_STS B" ).append("\n"); 
		query.append("		WHERE A.LOT_CNTR_PFX_CD  = B.LOT_EQ_PFX_CD (+)" ).append("\n"); 
		query.append("		AND   A.FM_SER_NO   = B.FM_SER_NO(+)           " ).append("\n"); 
		query.append("		AND   A.TO_SER_NO   = B.TO_SER_NO(+)" ).append("\n"); 
		query.append("		AND   A.CNTR_TPSZ_CD= B.EQ_TPSZ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("		 A.EQ_PFX_CD AS LOT_EQ_PFX_CD" ).append("\n"); 
		query.append("		, A.FM_SER_NO" ).append("\n"); 
		query.append("		, A.TO_SER_NO" ).append("\n"); 
		query.append("		, 'DSP' AS MNR_GRP_TP_CD" ).append("\n"); 
		query.append("		, @[eq_knd_cd] AS EQ_KND_CD" ).append("\n"); 
		query.append("		, C.EQ_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("		, B.EQ_MKR_NM" ).append("\n"); 
		query.append("		, B.EQ_MDL_NM" ).append("\n"); 
		query.append("		, DECODE(B.MNR_DISP_SEL_FLG ,NULL,0,'Y',1,0) AS MNR_DISP_SEL_FLG " ).append("\n"); 
		query.append("        , TO_CHAR(B.MNR_DISP_SEL_FLG_DT, 'YYYY-MM-DD') AS MNR_DISP_SEL_FLG_DT" ).append("\n"); 
		query.append("		, B.FM_WARR_DT" ).append("\n"); 
		query.append("		, B.TO_WARR_DT" ).append("\n"); 
		query.append("		, B.WARR_RMK" ).append("\n"); 
		query.append("		, TO_CHAR(A.EQ_LOT_ISS_DT, 'YYYY') AS MFT_YR" ).append("\n"); 
		query.append("		, (A.TO_SER_NO - A.FM_SER_NO +1) AS EQ_QTY" ).append("\n"); 
		query.append("		, B.CRE_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), B.CRE_DT,@[user_ofc_cd]), 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("		, B.UPD_USR_ID" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), B.UPD_DT,@[user_ofc_cd]), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("		, (A.EQ_PFX_CD || A.FM_SER_NO || '-' || A.TO_SER_NO ) EQ_RANGE_NO" ).append("\n"); 
		query.append("        , (SELECT COUNT(*)" ).append("\n"); 
		query.append("             FROM CGM_EQUIPMENT CE" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.EQ_LOT_NO = CE.EQ_LOT_NO" ).append("\n"); 
		query.append("              AND A.EQ_KND_CD = CE.EQ_KND_CD" ).append("\n"); 
		query.append("              AND A.EQ_SPEC_NO = CE.EQ_SPEC_NO" ).append("\n"); 
		query.append("              AND CE.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("              AND CE.AGMT_LSTM_CD = 'OW') ACT_QTY" ).append("\n"); 
		query.append("FROM CGM_EQ_LOT A,  MNR_EQ_RNG_STS B" ).append("\n"); 
		query.append("       ,(SELECT DISTINCT EQ_LOT_NO,AGMT_OFC_CTY_CD,AGMT_SEQ,AGMT_VER_NO,EQ_KND_CD,EQ_TPSZ_CD, AGMT_LSTM_CD FROM CGM_EQUIPMENT) C" ).append("\n"); 
		query.append("		WHERE A.EQ_PFX_CD  = B.LOT_EQ_PFX_CD (+)" ).append("\n"); 
		query.append("		AND   A.FM_SER_NO   = B.FM_SER_NO(+)           " ).append("\n"); 
		query.append("		AND   A.TO_SER_NO   = B.TO_SER_NO(+)" ).append("\n"); 
		query.append("		AND   A.EQ_LOT_NO  = C.EQ_LOT_NO" ).append("\n"); 
		query.append("		AND   A.AGMT_OFC_CTY_CD   = C.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND   A.AGMT_SEQ  = C.AGMT_SEQ" ).append("\n"); 
		query.append("		AND   A.AGMT_VER_NO   = C.AGMT_VER_NO" ).append("\n"); 
		query.append("		AND   C.AGMT_LSTM_CD = 'OW'" ).append("\n"); 
		query.append("		AND   A.EQ_KND_CD = @[eq_knd_cd] " ).append("\n"); 
		query.append("		AND   C.EQ_KND_CD = @[eq_knd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND   B.MNR_GRP_TP_CD(+) = 'DSP'" ).append("\n"); 
		query.append("		AND   B.EQ_KND_CD(+) = @[eq_knd_cd] " ).append("\n"); 
		query.append("		#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("			#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("			AND	A.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("					#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("						#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("							'$user_tpszCds'," ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							'$user_tpszCds'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end			  " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			AND (A.AGMT_CTY_CD, A.AGMT_SEQ) IN (SELECT AGMT_CTY_CD, AGMT_SEQ" ).append("\n"); 
		query.append("                                      			FROM LSE_AGREEMENT" ).append("\n"); 
		query.append("                                     			WHERE LSTM_CD = 'OW')" ).append("\n"); 
		query.append("		#if (${fryear} != '')" ).append("\n"); 
		query.append("			#if(${toyear} != '')" ).append("\n"); 
		query.append("		        AND  TO_CHAR(A.MFT_DT,'YYYY') BETWEEN @[fryear] AND @[toyear]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			#if (${eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("			AND	C.EQ_TPSZ_CD IN (" ).append("\n"); 
		query.append("					#foreach ($user_tpszCds IN ${tpszCds})" ).append("\n"); 
		query.append("						#if($velocityCount < $tpszCds.size())" ).append("\n"); 
		query.append("							'$user_tpszCds'," ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							'$user_tpszCds'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end			  " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#if (${fryear} != '')" ).append("\n"); 
		query.append("			#if(${toyear} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		        AND TO_CHAR(A.EQ_LOT_ISS_DT, 'YYYY') BETWEEN @[fryear] AND @[toyear]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${eq_knd_cd} == 'U')" ).append("\n"); 
		query.append("		ORDER BY TO_CHAR(A.MFT_DT, 'YYYY'),A.LOT_CNTR_PFX_CD,A.FM_SER_NO" ).append("\n"); 
		query.append("                 ,A.TO_SER_NO,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		ORDER BY TO_CHAR(A.EQ_LOT_ISS_DT, 'YYYY'),A.EQ_PFX_CD,A.FM_SER_NO" ).append("\n"); 
		query.append("                 ,A.TO_SER_NO,C.EQ_TPSZ_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}