/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeSNDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
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

public class RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeSNDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request & Approval Status 조회(AfterBooking, DATE-Office, Sent)용 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeSNDRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchAfterBookingListByDateUserOfficeSNDRSQL").append("\n"); 
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
		query.append("SELECT	/*+ ordered */ DISTINCT TTL.DAR_NO" ).append("\n"); 
		query.append("	,	TTL.APVL_NO" ).append("\n"); 
		query.append("	,	TTL.REQ_OFC_CD" ).append("\n"); 
		query.append("	,	TTL.APRO_OFC_CD" ).append("\n"); 
		query.append("	,	TTL.FINAL_OFC_CD" ).append("\n"); 
		query.append("	,	TTL.UPD_DT" ).append("\n"); 
		query.append("	,	BOOKING.SC_NO" ).append("\n"); 
		query.append("	,	BOOKING.RFA_NO" ).append("\n"); 
		query.append("	,	DECODE(NVL(BOOKING.RFA_NO, ''), '', PRI_SP_CUST.CUST_CD, PRI_RP_CUST.CUST_CD) AS CUST_CD" ).append("\n"); 
		query.append("	,	DECODE(NVL(BOOKING.RFA_NO, ''), '', PRI_SP_CUST.CUST_NM, PRI_RP_CUST.CUST_NM) AS CUST_NM " ).append("\n"); 
		query.append("    ,   CD_DTL.INTG_CD_VAL_DP_DESC AS STATUS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${group_by} == 'CVRG')" ).append("\n"); 
		query.append("    ,   TTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,   CASE" ).append("\n"); 
		query.append("            WHEN TTL.DMDT_TRF_CD = 'DMIF' THEN SUBSTR(BOOKING.POD_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("			WHEN TTL.DMDT_TRF_CD = 'DMOF' THEN SUBSTR(BOOKING.POL_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("            WHEN TTL.DMDT_TRF_CD IN ('DTIC', 'CTIC') THEN BOOKING.DEL_CD" ).append("\n"); 
		query.append("            WHEN TTL.DMDT_TRF_CD IN ('DTOC', 'CTOC') THEN BOOKING.POR_CD" ).append("\n"); 
		query.append("        END AS COVERAGE" ).append("\n"); 
		query.append("    ,   TTL.BKG_NO" ).append("\n"); 
		query.append("    ,   TTL.BL_NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("			SELECT	AFT_RQST.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("				,	AFT_RQST.AFT_BKG_APRO_NO AS APVL_NO" ).append("\n"); 
		query.append("				,	AFT_PROG.PROG_OFC_CD AS REQ_OFC_CD" ).append("\n"); 
		query.append("				,	'' AS APRO_OFC_CD" ).append("\n"); 
		query.append("            	,	(" ).append("\n"); 
		query.append("                            SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("						    FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("							AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                            AND C.AFT_BKG_PATH_LVL = ( SELECT MAX(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                                                  WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                                                    AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            		) AS FINAL_OFC_CD" ).append("\n"); 
		query.append("				,	TO_CHAR(AFT_RQST.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("				,	AFT_RQST.DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("				,	AFT_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("				,	AFT_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("				,	AFT_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM	DMT_AFT_BKG_ADJ_RQST AFT_RQST" ).append("\n"); 
		query.append("				,	DMT_AFT_BKG_ADJ_PROG AFT_PROG" ).append("\n"); 
		query.append("				,	DMT_AFT_BKG_ADJ_RQST_DTL AFT_RQST_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			WHERE	AFT_RQST.AFT_EXPT_DAR_NO = AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND AFT_RQST.DMDT_EXPT_RQST_STS_CD IN ('R', 'C', 'T')" ).append("\n"); 
		query.append("				AND AFT_RQST.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				AND AFT_PROG.PROG_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */ PROG_SEQ" ).append("\n"); 
		query.append("						FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("						WHERE	AFT_EXPT_DAR_NO = AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${usr_ofc_only} == 'Y')" ).append("\n"); 
		query.append("							AND	PROG_OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("							AND PROG_OFC_CD IN " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("										#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							AND DMDT_EXPT_RQST_STS_CD IN ('R','C', 'T')" ).append("\n"); 
		query.append("							AND ROWNUM = 1 " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				AND AFT_RQST.AFT_EXPT_DAR_NO = AFT_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND AFT_RQST_DTL.DMDT_TRF_CD IN " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		UNION" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("			SELECT	AFT_RQST.AFT_EXPT_DAR_NO AS DAR_NO" ).append("\n"); 
		query.append("				,	AFT_RQST.AFT_BKG_APRO_NO AS APVL_NO" ).append("\n"); 
		query.append("      			,	AFT_PROG2.PROG_OFC_CD AS REQ_OFC_CD" ).append("\n"); 
		query.append("				,	DECODE(AFT_RQST.DMDT_EXPT_RQST_STS_CD, 'C', '', AFT_PROG.PROG_OFC_CD) AS APRO_OFC_CD" ).append("\n"); 
		query.append("            	,	(" ).append("\n"); 
		query.append("                            SELECT APRO_OFC_CD" ).append("\n"); 
		query.append("						    FROM DMT_AFT_BKG_APRO_PATH C" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("							AND C.AFT_EXPT_DAR_NO = AFT_RQST.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                            AND C.AFT_BKG_PATH_LVL = ( SELECT MAX(AFT_BKG_PATH_LVL) FROM DMT_AFT_BKG_APRO_PATH" ).append("\n"); 
		query.append("                                                                  WHERE AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("                                                                    AND AFT_BKG_PATH_CPLS_FLG = 'Y' )" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            		) AS FINAL_OFC_CD" ).append("\n"); 
		query.append("				,	TO_CHAR(AFT_RQST.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("				,	AFT_RQST.DMDT_EXPT_RQST_STS_CD" ).append("\n"); 
		query.append("				,	AFT_RQST_DTL.BKG_NO" ).append("\n"); 
		query.append("				,	AFT_RQST_DTL.BL_NO" ).append("\n"); 
		query.append("				,	AFT_RQST_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM 	DMT_AFT_BKG_ADJ_RQST AFT_RQST" ).append("\n"); 
		query.append("				,	DMT_AFT_BKG_ADJ_PROG AFT_PROG" ).append("\n"); 
		query.append("				,	DMT_AFT_BKG_ADJ_PROG AFT_PROG2" ).append("\n"); 
		query.append("				,	DMT_AFT_BKG_ADJ_RQST_DTL AFT_RQST_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			WHERE	AFT_RQST.AFT_EXPT_DAR_NO = AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND AFT_RQST.AFT_EXPT_DAR_NO = AFT_PROG2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND AFT_RQST.DMDT_EXPT_RQST_STS_CD IN ('A', 'J', 'O')" ).append("\n"); 
		query.append("				AND AFT_RQST.UPD_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				AND AFT_PROG.PROG_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */PROG_SEQ" ).append("\n"); 
		query.append("						FROM	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("						WHERE	AFT_EXPT_DAR_NO = AFT_PROG.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${usr_ofc_only} == 'Y')" ).append("\n"); 
		query.append("							AND PROG_OFC_CD = @[usr_ofc_cd]" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("							AND PROG_OFC_CD IN" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("										#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							AND DMDT_EXPT_RQST_STS_CD IN ('A', 'J', 'O')" ).append("\n"); 
		query.append("							AND ROWNUM = 1 " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				AND AFT_PROG2.PROG_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX_DESC(DMT_AFT_BKG_ADJ_PROG XPKDMT_AFT_BKG_ADJ_PROG) */PROG_SEQ" ).append("\n"); 
		query.append("						FROM 	DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("						WHERE 	AFT_EXPT_DAR_NO = AFT_PROG2.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("							AND DMDT_EXPT_RQST_STS_CD = 'R'" ).append("\n"); 
		query.append("							AND ROWNUM = 1 " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				AND AFT_RQST.AFT_EXPT_DAR_NO = AFT_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("				AND AFT_RQST_DTL.DMDT_TRF_CD IN" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("  		) TTL" ).append("\n"); 
		query.append("	,	BKG_BOOKING BOOKING" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT	HDR.RFA_NO" ).append("\n"); 
		query.append("				,	MN.CTRT_CUST_CNT_CD CUST_CNT_CD" ).append("\n"); 
		query.append("				,	MN.CTRT_CUST_SEQ CUST_SEQ" ).append("\n"); 
		query.append("				,	MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("				,	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM	PRI_RP_HDR HDR" ).append("\n"); 
		query.append("				,	PRI_RP_MN MN" ).append("\n"); 
		query.append("				,	MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			WHERE 	HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("				AND MN.AMDT_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("						FROM 	PRI_RP_MN" ).append("\n"); 
		query.append("						WHERE	PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("							AND ROWNUM = 1 " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				AND MN.CTRT_CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("				AND MN.CTRT_CUST_SEQ = CUST.CUST_SEQ " ).append("\n"); 
		query.append("		) PRI_RP_CUST" ).append("\n"); 
		query.append("	,	(" ).append("\n"); 
		query.append("			SELECT	HDR.SC_NO" ).append("\n"); 
		query.append("				,	PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("				,	PTY.CUST_SEQ" ).append("\n"); 
		query.append("				,	PTY.CUST_CNT_CD || LPAD(PTY.CUST_SEQ, 6, '0') CUST_CD" ).append("\n"); 
		query.append("				,	CUST.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			FROM	PRI_SP_HDR HDR" ).append("\n"); 
		query.append("				,	PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("				,	MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("			WHERE	HDR.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("				AND PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ" ).append("\n"); 
		query.append("						FROM	PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("						WHERE	PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("							AND PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("							AND ROWNUM = 1 " ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("				AND PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("				AND PTY.CUST_CNT_CD = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("				AND PTY.CUST_SEQ = CUST.CUST_SEQ " ).append("\n"); 
		query.append("		) PRI_SP_CUST" ).append("\n"); 
		query.append("	,	COM_INTG_CD_DTL CD_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	TTL.BKG_NO 					= BOOKING.BKG_NO(+)" ).append("\n"); 
		query.append("	AND BOOKING.SC_NO 				= PRI_SP_CUST.SC_NO(+)" ).append("\n"); 
		query.append("	AND BOOKING.RFA_NO 				= PRI_RP_CUST.RFA_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${cust_cd} != '')" ).append("\n"); 
		query.append("	AND (	PRI_SP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_SP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("			OR" ).append("\n"); 
		query.append("			PRI_RP_CUST.CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND PRI_RP_CUST.CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND TTL.DMDT_EXPT_RQST_STS_CD 	= CD_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("	AND CD_DTL.INTG_CD_ID 			= 'CD02069'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY UPD_DT, DAR_NO" ).append("\n"); 

	}
}