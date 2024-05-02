/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeRCVRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeRCVRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request & Approval Status 조회(AfterBooking, DATE-Office, Received)용 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeRCVRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeRCVRSQL").append("\n"); 
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
		query.append("#if((${to_cc} == '' && ${usr_ofc_only} == 'N') || (${to_cc} == 'cc' && ${usr_ofc_only} == 'N'))" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  DISTINCT 'CC' TO_CC" ).append("\n"); 
		query.append("	,	AFT_RQST.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("    ,   AFT_RQST.AFT_BKG_APRO_NO AS APVL_NO" ).append("\n"); 
		query.append("    ,   CD_DTL.INTG_CD_VAL_DP_DESC AS STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,   CASE" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DMIF', 'DMOF') THEN SUBSTR(CHG_CALC.FM_MVMT_YD_CD, 1, 5)" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DTIC', 'CTIC') THEN CHG_CNTR.DEL_CD" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DTOC', 'CTOC') THEN CHG_CNTR.POR_CD" ).append("\n"); 
		query.append("        END AS COVERAGE" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_OFC_CD" ).append("\n"); 
		query.append("			FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("			WHERE	AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("		) AS REQ_OFC_CD" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_OFC_CD" ).append("\n"); 
		query.append("			FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("			WHERE	AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND DMDT_EXPT_RQST_STS_CD IN ('A', 'C', 'J', 'O')" ).append("\n"); 
		query.append("				AND AFT_RQST.DMDT_EXPT_RQST_STS_CD NOT IN ('C', 'R')" ).append("\n"); 
		query.append("				AND ROWNUM = 1" ).append("\n"); 
		query.append("		) AS APRO_OFC_CD" ).append("\n"); 
		query.append("        ,	(" ).append("\n"); 
		query.append("        	SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("			FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("            AND C.AFT_BKG_PATH_LVL = ( SELECT MAX(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                       WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                       AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            ) AS FINAL_OFC_CD" ).append("\n"); 
		query.append("    ,   TO_CHAR(AFT_RQST.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("    ,   CHG_CNTR.SC_NO" ).append("\n"); 
		query.append("    ,   CHG_CNTR.RFA_NO" ).append("\n"); 
		query.append("	,	DECODE(NVL(CHG_CNTR.RFA_NO, ''), '', PRI_SP_CUST.CUST_CD, PRI_RP_CUST.CUST_CD) AS CUST_CD" ).append("\n"); 
		query.append("	,	DECODE(NVL(CHG_CNTR.RFA_NO, ''), '', PRI_SP_CUST.CUST_NM, PRI_RP_CUST.CUST_NM) AS CUST_NM" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	FROM	DMT_AFT_BKG_ADJ_RQST AFT_RQST" ).append("\n"); 
		query.append("		,	DMT_AFT_BKG_ADJ_RQST_DTL AFT_RQST_DTL" ).append("\n"); 
		query.append("    	,   DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append("	    ,   DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("				SELECT	HDR.RFA_NO" ).append("\n"); 
		query.append("					, 	MN.CTRT_CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("					, 	MN.CTRT_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("					,	MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("					, 	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("				FROM	PRI_RP_HDR HDR, PRI_RP_MN MN, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("				WHERE	HDR.PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("					AND	MN.AMDT_SEQ 	= " ).append("\n"); 
		query.append("						(	" ).append("\n"); 
		query.append("							SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("							FROM	PRI_RP_MN" ).append("\n"); 
		query.append("							WHERE	PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("								AND	ROWNUM 		= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND MN.CTRT_CUST_CNT_CD 	= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("					AND MN.CTRT_CUST_SEQ 		= CUST.CUST_SEQ" ).append("\n"); 
		query.append("			) PRI_RP_CUST" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("				SELECT	HDR.SC_NO" ).append("\n"); 
		query.append("					, 	PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("					,	PTY.CUST_SEQ" ).append("\n"); 
		query.append("					,	PTY.CUST_CNT_CD || LPAD(PTY.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("					, 	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("				FROM	PRI_SP_HDR HDR, PRI_SP_CTRT_PTY PTY, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("				WHERE	HDR.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("					AND	PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("						( " ).append("\n"); 
		query.append("							SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ" ).append("\n"); 
		query.append("							FROM	PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("							WHERE	PROP_NO 			= PTY.PROP_NO" ).append("\n"); 
		query.append("								AND PRC_CTRT_PTY_TP_CD 	= 'C'" ).append("\n"); 
		query.append("								AND	ROWNUM 				= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND PTY.PRC_CTRT_PTY_TP_CD 	= 'C'" ).append("\n"); 
		query.append("					AND PTY.CUST_CNT_CD 		= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("					AND PTY.CUST_SEQ 			= CUST.CUST_SEQ" ).append("\n"); 
		query.append("			) PRI_SP_CUST" ).append("\n"); 
		query.append("		,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("	WHERE	AFT_RQST.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		AND	AFT_RQST.AFT_EXPT_DAR_NO 		= AFT_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("		AND AFT_RQST_DTL.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   		AND AFT_RQST_DTL.BKG_NO 			= CHG_CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("		AND	(" ).append("\n"); 
		query.append("				CHG_CNTR.SYS_AREA_GRP_ID = " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("					WHERE   CNT_CD = " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								CASE " ).append("\n"); 
		query.append("									WHEN SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I' " ).append("\n"); 
		query.append("										THEN SUBSTR(CHG_CNTR.POD_CD, 0, 2)" ).append("\n"); 
		query.append("									WHEN SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O' " ).append("\n"); 
		query.append("										THEN SUBSTR(CHG_CNTR.POL_CD, 0, 2)" ).append("\n"); 
		query.append("									WHEN SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I' " ).append("\n"); 
		query.append("										THEN SUBSTR(CHG_CNTR.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("									WHEN SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(AFT_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O' " ).append("\n"); 
		query.append("										THEN SUBSTR(CHG_CNTR.POR_CD, 0, 2)" ).append("\n"); 
		query.append("								END    " ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("				CHG_CNTR.SYS_AREA_GRP_ID IS NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		AND CHG_CNTR.SYS_AREA_GRP_ID 		= CHG_CALC.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("		AND CHG_CNTR.CNTR_NO 				= CHG_CALC.CNTR_NO(+)" ).append("\n"); 
		query.append("		AND CHG_CNTR.CNTR_CYC_NO 			= CHG_CALC.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				CHG_CALC.DMDT_TRF_CD 		= AFT_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("				CHG_CALC.DMDT_TRF_CD IS NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		AND (" ).append("\n"); 
		query.append("				CHG_CALC.DMDT_CHG_LOC_DIV_CD 	<> 'TSP'" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("				CHG_CALC.DMDT_CHG_LOC_DIV_CD IS NULL" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		AND CHG_CNTR.SC_NO 					= PRI_SP_CUST.SC_NO(+)" ).append("\n"); 
		query.append("		AND CHG_CNTR.RFA_NO 				= PRI_RP_CUST.RFA_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${is_owned_role} == 'Y')" ).append("\n"); 
		query.append("		AND CHG_CALC.OFC_CD IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT	OFC_CD " ).append("\n"); 
		query.append("				FROM	( " ).append("\n"); 
		query.append("							SELECT	OFC_CD, PRNT_OFC_CD " ).append("\n"); 
		query.append("					        FROM	MDM_ORGANIZATION O" ).append("\n"); 
		query.append("			             	WHERE	NVL(O.DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("					    )" ).append("\n"); 
		query.append("			    START WITH OFC_CD 				= @[usr_ofc_cd]" ).append("\n"); 
		query.append("			    CONNECT BY NOCYCLE PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND CHG_CALC.OFC_CD IN			" ).append("\n"); 
		query.append("		( SELECT OFC_CD FROM MAS_OFC_LVL WHERE TO_CHAR(SYSDATE,'YYYYMM') BETWEEN OFC_APLY_FM_YRMON AND OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("				  AND OFC_N5TH_LVL_CD IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		 )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${cust_cd} != '')" ).append("\n"); 
		query.append("		AND (	PRI_SP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_SP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				PRI_RP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_RP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND AFT_RQST.DMDT_EXPT_RQST_STS_CD 	= CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("		AND CD_DTL.INTG_CD_ID 				= 'CD02069'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_cc} == '' && ${usr_ofc_only} == 'N')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${to_cc} == '' || ${to_cc} == 'to')" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  DISTINCT 'TO' TO_CC" ).append("\n"); 
		query.append("	,	AFT_RQST.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("    ,   AFT_RQST.AFT_BKG_APRO_NO AS APVL_NO" ).append("\n"); 
		query.append("    ,   CD_DTL.INTG_CD_VAL_DP_DESC AS STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,   CASE" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD = 'DMIF' THEN SUBSTR(BOOKING.POD_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("			WHEN AFT_RQST_DTL.DMDT_TRF_CD = 'DMOF' THEN SUBSTR(BOOKING.POL_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DTIC', 'CTIC') THEN BOOKING.DEL_CD" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DTOC', 'CTOC') THEN BOOKING.POR_CD" ).append("\n"); 
		query.append("        END AS COVERAGE" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   AFT_PROG.PROG_OFC_CD AS REQ_OFC_CD" ).append("\n"); 
		query.append("	,	DECODE(AFT_RQST.DMDT_EXPT_RQST_STS_CD, 'C', '', AFT_PROG2.PROG_OFC_CD) AS APRO_OFC_CD" ).append("\n"); 
		query.append("        ,	(" ).append("\n"); 
		query.append("        	SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("			FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("            AND C.AFT_BKG_PATH_LVL = ( SELECT MAX(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                       WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                       AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            ) AS FINAL_OFC_CD" ).append("\n"); 
		query.append("    ,   TO_CHAR(AFT_RQST.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("    ,   BOOKING.SC_NO" ).append("\n"); 
		query.append("    ,   BOOKING.RFA_NO" ).append("\n"); 
		query.append("	,	DECODE(NVL(BOOKING.RFA_NO, ''), '', PRI_SP_CUST.CUST_CD, PRI_RP_CUST.CUST_CD) AS CUST_CD" ).append("\n"); 
		query.append("	,	DECODE(NVL(BOOKING.RFA_NO, ''), '', PRI_SP_CUST.CUST_NM, PRI_RP_CUST.CUST_NM) AS CUST_NM" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	FROM	DMT_AFT_BKG_ADJ_RQST AFT_RQST" ).append("\n"); 
		query.append("		,	DMT_AFT_BKG_ADJ_PROG AFT_PROG" ).append("\n"); 
		query.append("		,	DMT_AFT_BKG_ADJ_PROG AFT_PROG2" ).append("\n"); 
		query.append("		,	DMT_AFT_BKG_ADJ_RQST_DTL AFT_RQST_DTL" ).append("\n"); 
		query.append("		,	BKG_BOOKING BOOKING" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("				SELECT	HDR.RFA_NO" ).append("\n"); 
		query.append("					, 	MN.CTRT_CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("					, 	MN.CTRT_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("					,	MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("					, 	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("				FROM	PRI_RP_HDR HDR, PRI_RP_MN MN, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("				WHERE	HDR.PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("					AND	MN.AMDT_SEQ 	= " ).append("\n"); 
		query.append("						(	" ).append("\n"); 
		query.append("							SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("							FROM	PRI_RP_MN" ).append("\n"); 
		query.append("							WHERE	PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("								AND	ROWNUM 		= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND MN.CTRT_CUST_CNT_CD 	= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("					AND MN.CTRT_CUST_SEQ 		= CUST.CUST_SEQ" ).append("\n"); 
		query.append("			) PRI_RP_CUST" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("				SELECT	HDR.SC_NO" ).append("\n"); 
		query.append("					, 	PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("					,	PTY.CUST_SEQ" ).append("\n"); 
		query.append("					,	PTY.CUST_CNT_CD || LPAD(PTY.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("					, 	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("				FROM	PRI_SP_HDR HDR, PRI_SP_CTRT_PTY PTY, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("				WHERE	HDR.PROP_NO 	= PTY.PROP_NO" ).append("\n"); 
		query.append("					AND	PTY.AMDT_SEQ 	= " ).append("\n"); 
		query.append("						( " ).append("\n"); 
		query.append("							SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ" ).append("\n"); 
		query.append("		 					FROM	PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("							WHERE	PROP_NO 			= PTY.PROP_NO" ).append("\n"); 
		query.append("								AND PRC_CTRT_PTY_TP_CD 	= 'C'" ).append("\n"); 
		query.append("								AND	ROWNUM 				= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND PTY.PRC_CTRT_PTY_TP_CD 	= 'C'" ).append("\n"); 
		query.append("					AND PTY.CUST_CNT_CD 		= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("					AND PTY.CUST_SEQ 			= CUST.CUST_SEQ" ).append("\n"); 
		query.append("			) PRI_SP_CUST" ).append("\n"); 
		query.append("		,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("	WHERE	AFT_RQST.AFT_EXPT_DAR_NO 		= AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("		AND	AFT_RQST.AFT_EXPT_DAR_NO 		= AFT_PROG2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	    AND AFT_RQST.DMDT_EXPT_RQST_STS_CD IN ('A', 'J', 'O')" ).append("\n"); 
		query.append("		AND AFT_RQST.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		AND	AFT_PROG.PROG_SEQ 				=" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("				FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("				WHERE	AFT_EXPT_DAR_NO 		= AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND DMDT_EXPT_RQST_STS_CD 	= 'R'" ).append("\n"); 
		query.append("					AND ROWNUM 					= 1" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${usr_ofc_only} == 'Y')" ).append("\n"); 
		query.append("		AND AFT_PROG.PROG_OFC_CD 			= @[usr_ofc_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND AFT_PROG.PROG_OFC_CD IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND	AFT_PROG2.PROG_SEQ 				=" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("				FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("				WHERE	AFT_EXPT_DAR_NO 	= AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND DMDT_EXPT_RQST_STS_CD IN ('A', 'C', 'J', 'O')" ).append("\n"); 
		query.append("					AND	ROWNUM 				= 1	" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		AND	AFT_RQST.AFT_EXPT_DAR_NO = AFT_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("		AND AFT_RQST_DTL.DMDT_TRF_CD IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("   		AND AFT_RQST_DTL.BKG_NO 			= BOOKING.BKG_NO(+)" ).append("\n"); 
		query.append("		AND BOOKING.SC_NO 					= PRI_SP_CUST.SC_NO(+)" ).append("\n"); 
		query.append("		AND BOOKING.RFA_NO 					= PRI_RP_CUST.RFA_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${cust_cd} != '')" ).append("\n"); 
		query.append("		AND (	PRI_SP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_SP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				PRI_RP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_RP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND AFT_RQST.DMDT_EXPT_RQST_STS_CD 	= CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("		AND CD_DTL.INTG_CD_ID 				= 'CD02069'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT  DISTINCT 'TO' TO_CC" ).append("\n"); 
		query.append("	,	AFT_RQST.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("    ,   AFT_RQST.AFT_BKG_APRO_NO AS APVL_NO" ).append("\n"); 
		query.append("    ,   CD_DTL.INTG_CD_VAL_DP_DESC AS STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,   CASE" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD = 'DMIF' THEN SUBSTR(BOOKING.POD_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("			WHEN AFT_RQST_DTL.DMDT_TRF_CD = 'DMOF' THEN SUBSTR(BOOKING.POL_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DTIC', 'CTIC') THEN BOOKING.DEL_CD" ).append("\n"); 
		query.append("            WHEN AFT_RQST_DTL.DMDT_TRF_CD IN ('DTOC', 'CTOC') THEN BOOKING.POR_CD" ).append("\n"); 
		query.append("        END AS COVERAGE" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("    ,   AFT_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   AFT_PROG.PROG_OFC_CD AS REQ_OFC_CD" ).append("\n"); 
		query.append("	,	'' AS APRO_OFC_CD" ).append("\n"); 
		query.append("        ,	(" ).append("\n"); 
		query.append("        	SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("			FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("            AND C.AFT_BKG_PATH_LVL = ( SELECT MAX(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                       WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                       AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            ) AS FINAL_OFC_CD" ).append("\n"); 
		query.append("    ,   TO_CHAR(AFT_RQST.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("    ,   BOOKING.SC_NO" ).append("\n"); 
		query.append("    ,   BOOKING.RFA_NO" ).append("\n"); 
		query.append("	,	DECODE(NVL(BOOKING.RFA_NO, ''), '', PRI_SP_CUST.CUST_CD, PRI_RP_CUST.CUST_CD) AS CUST_CD" ).append("\n"); 
		query.append("	,	DECODE(NVL(BOOKING.RFA_NO, ''), '', PRI_SP_CUST.CUST_NM, PRI_RP_CUST.CUST_NM) AS CUST_NM" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	FROM	DMT_AFT_BKG_ADJ_RQST AFT_RQST" ).append("\n"); 
		query.append("		,	DMT_AFT_BKG_ADJ_PROG AFT_PROG" ).append("\n"); 
		query.append("		,	DMT_AFT_BKG_ADJ_RQST_DTL AFT_RQST_DTL" ).append("\n"); 
		query.append("		,	BKG_BOOKING BOOKING" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("				SELECT	HDR.RFA_NO" ).append("\n"); 
		query.append("					, 	MN.CTRT_CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("					, 	MN.CTRT_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("					,	MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("					, 	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("				FROM	PRI_RP_HDR HDR, PRI_RP_MN MN, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("				WHERE	HDR.PROP_NO 	= MN.PROP_NO" ).append("\n"); 
		query.append("					AND	MN.AMDT_SEQ 	= " ).append("\n"); 
		query.append("						(	" ).append("\n"); 
		query.append("							SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("							FROM	PRI_RP_MN" ).append("\n"); 
		query.append("							WHERE	PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("								AND	ROWNUM 	= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("					AND MN.CTRT_CUST_SEQ 	= CUST.CUST_SEQ" ).append("\n"); 
		query.append("			) PRI_RP_CUST" ).append("\n"); 
		query.append("		,	(" ).append("\n"); 
		query.append("				SELECT	HDR.SC_NO" ).append("\n"); 
		query.append("					, 	PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("					,	PTY.CUST_SEQ" ).append("\n"); 
		query.append("					,	PTY.CUST_CNT_CD || LPAD(PTY.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("					, 	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("				FROM	PRI_SP_HDR HDR, PRI_SP_CTRT_PTY PTY, MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("				WHERE	HDR.PROP_NO 	= PTY.PROP_NO" ).append("\n"); 
		query.append("					AND	PTY.AMDT_SEQ 	= " ).append("\n"); 
		query.append("						( " ).append("\n"); 
		query.append("							SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ" ).append("\n"); 
		query.append("							FROM	PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("							WHERE	PROP_NO 			= PTY.PROP_NO" ).append("\n"); 
		query.append("								AND PRC_CTRT_PTY_TP_CD 	= 'C'" ).append("\n"); 
		query.append("								AND	ROWNUM 				= 1" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND PTY.PRC_CTRT_PTY_TP_CD 	= 'C'" ).append("\n"); 
		query.append("					AND PTY.CUST_CNT_CD 		= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("					AND PTY.CUST_SEQ 			= CUST.CUST_SEQ" ).append("\n"); 
		query.append("			) PRI_SP_CUST" ).append("\n"); 
		query.append("		,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("	WHERE	AFT_RQST.AFT_EXPT_DAR_NO 		= AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	    AND AFT_RQST.DMDT_EXPT_RQST_STS_CD 	IN ('R', 'C', 'B', 'P', 'Q')" ).append("\n"); 
		query.append("		AND AFT_RQST.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		AND	AFT_PROG.PROG_SEQ =" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("				FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("				WHERE	AFT_EXPT_DAR_NO 		= AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND DMDT_EXPT_RQST_STS_CD 	IN ('R', 'C', 'B', 'P', 'Q')" ).append("\n"); 
		query.append("					AND	ROWNUM 					= 1	" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- 2014.02.26 APPROVAL OFFICE ( SELHO ) 지정 가능" ).append("\n"); 
		query.append("        -- 실제 승인 업무는 SELHO 또는 SELCON에서 가능토록 HARD CODING." ).append("\n"); 
		query.append("		#if(${usr_ofc_only} == 'Y')" ).append("\n"); 
		query.append("		AND ( ( " ).append("\n"); 
		query.append("        	SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("			FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("            AND C.AFT_BKG_PATH_LVL = ( SELECT MIN(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                       WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                       AND DMDT_EXPT_RQST_STS_CD IS NULL" ).append("\n"); 
		query.append("                                       AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("            AND ROWNUM = 1 )" ).append("\n"); 
		query.append("			IN ( DECODE( @[usr_ofc_cd], 'SELCON', 'SELHO', NULL), @[usr_ofc_cd] )" ).append("\n"); 
		query.append("             OR AFT_RQST.RQST_OFC_CD = DECODE(@[login_ofc_cd],'SELCON',AFT_RQST.RQST_OFC_CD,@[login_ofc_cd]) )" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND ( ( " ).append("\n"); 
		query.append("        	SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("			FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("            AND C.AFT_BKG_PATH_LVL = ( SELECT MIN(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                       WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                       AND DMDT_EXPT_RQST_STS_CD IS NULL" ).append("\n"); 
		query.append("                                       AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("            AND ROWNUM = 1 ) IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($ofc_cd == 'SELCON') , 'SELHO' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			) OR AFT_RQST.RQST_OFC_CD = DECODE(@[login_ofc_cd],'SELCON',AFT_RQST.RQST_OFC_CD,@[login_ofc_cd]) )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND	AFT_RQST.AFT_EXPT_DAR_NO 		= AFT_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("		AND AFT_RQST_DTL.DMDT_TRF_CD IN " ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("	   	AND AFT_RQST_DTL.BKG_NO 			= BOOKING.BKG_NO(+)" ).append("\n"); 
		query.append("		AND BOOKING.SC_NO 					= PRI_SP_CUST.SC_NO(+)" ).append("\n"); 
		query.append("		AND BOOKING.RFA_NO 					= PRI_RP_CUST.RFA_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${cust_cd} != '')" ).append("\n"); 
		query.append("		AND (	PRI_SP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_SP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("				OR" ).append("\n"); 
		query.append("				PRI_RP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_RP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND AFT_RQST.DMDT_EXPT_RQST_STS_CD 	= CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("		AND CD_DTL.INTG_CD_ID 				= 'CD01971'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY TO_CC, UPD_DT, DAR_NO" ).append("\n"); 

	}
}