/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEXSReportOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchEXSReportOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEXSReportOBRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEXSReportOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_b_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_search_pofe_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_to_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEXSReportOBRSQL").append("\n"); 
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
		query.append("/* Eu24ExsListOB VO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" SENT_BL_CNT + UNSENT_BL_CNT AS TOTAL_BL_CNT" ).append("\n"); 
		query.append(", MM.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT Z.*    " ).append("\n"); 
		query.append("     ,COUNT(DECODE(RESULT2,'A',1,NULL)) OVER()      AS A_CNT" ).append("\n"); 
		query.append("     ,COUNT(DECODE(RESULT2,'R',1,NULL)) OVER()      AS R_CNT" ).append("\n"); 
		query.append("     ,COUNT(DECODE(RESULT2,'DNL',1,NULL)) OVER()    AS DNL_CNT" ).append("\n"); 
		query.append("	 ,COUNT(DECODE(RESULT2,'D',1,'P',1,'H',1,NULL)) OVER()  AS H_CNT" ).append("\n"); 
		query.append("     ,COUNT(DECODE(RESULT2,'L',1,NULL)) OVER()      AS L_CNT" ).append("\n"); 
		query.append("     ,COUNT(DECODE(RESULT2,'NR',1,NULL)) OVER()     AS NR_CNT" ).append("\n"); 
		query.append("     ,COUNT(DECODE(MSG_SND_NO,NULL,1,NULL)) OVER()  AS UNSENT_BL_CNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT Y.*" ).append("\n"); 
		query.append("       /*,COUNT(DECODE(ACK_CD,'A',1,NULL)) OVER()         AS SENT_SUCCESS_CNT*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,CASE WHEN ACK_CD IS NOT NULL                       THEN 'Yes'" ).append("\n"); 
		query.append("             WHEN MSG_SND_NO IS NOT NULL AND RCV IS NULL   THEN 'Not Received'" ).append("\n"); 
		query.append("             WHEN MSG_SND_NO IS NULL                       THEN 'N/A'" ).append("\n"); 
		query.append("        END AS ACK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , CASE WHEN DOWNLOAD_YN = 'N'                        THEN 'N/A'" ).append("\n"); 
		query.append("             WHEN MSG_FUNC_ID = 'O'                        THEN 'Original'" ).append("\n"); 
		query.append("             WHEN MSG_FUNC_ID = 'U'                        THEN 'Amend'" ).append("\n"); 
		query.append("             WHEN MSG_SND_NO IS NULL                       THEN 'D/L'" ).append("\n"); 
		query.append("        END AS SENT_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      , CASE WHEN DOWNLOAD_YN = 'N'                              THEN ''" ).append("\n"); 
		query.append("			 WHEN RESULT_CD ='561'                               THEN 'Hold' 	   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("             WHEN ACK_CD = 'A'                                   THEN 'Accepted'   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("             WHEN ACK_CD = 'R'              AND RESULT_CD ='351' THEN 'Do Not Load'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("             WHEN ACK_CD = 'R'                                   THEN 'Rejected'   ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("			 WHEN ACK_CD = 'D'                                   THEN 'Hold(Doc.)' ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("			 WHEN ACK_CD = 'P'                                   THEN 'Hold(Phys.)' ||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("             WHEN ACK_CD = 'L'                                   THEN 'Hold Release'||DECODE(ACK_KND_ID,'S','(S)')" ).append("\n"); 
		query.append("             WHEN MSG_SND_NO IS NOT NULL AND RCV IS NULL         THEN 'Not Received'" ).append("\n"); 
		query.append("        END AS RESULT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, CASE WHEN DOWNLOAD_YN = 'N'                              THEN ''" ).append("\n"); 
		query.append("		   WHEN RESULT_CD ='561'                               THEN 'H' 	   " ).append("\n"); 
		query.append("		   WHEN ACK_CD = 'A'                                   THEN 'A'" ).append("\n"); 
		query.append("		   WHEN ACK_CD = 'R'           AND RESULT_CD ='351'    THEN 'DNL'" ).append("\n"); 
		query.append("		   WHEN ACK_CD = 'R'                                   THEN 'R'" ).append("\n"); 
		query.append("		   WHEN ACK_CD = 'D'                                   THEN 'D'" ).append("\n"); 
		query.append("		   WHEN ACK_CD = 'P'                                   THEN 'P'" ).append("\n"); 
		query.append("		   WHEN ACK_CD = 'L'                                   THEN 'L'" ).append("\n"); 
		query.append("		   WHEN MSG_SND_NO IS NOT NULL AND RCV IS NULL         THEN 'NR'" ).append("\n"); 
		query.append("	  END AS RESULT2" ).append("\n"); 
		query.append("      ,COUNT(MSG_SND_NO) OVER() AS SENT_BL_CNT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT X.*" ).append("\n"); 
		query.append("             ,BKG_GET_TOKEN_FNC(RCV,1) AS EDI_RCV_DT" ).append("\n"); 
		query.append("             ,BKG_GET_TOKEN_FNC(RCV,2) AS EDI_RCV_SEQ" ).append("\n"); 
		query.append("             ,BKG_GET_TOKEN_FNC(RCV,3) AS ACK_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),TO_DATE(BKG_GET_TOKEN_FNC(RCV,4),'YYYY-MM-DD HH24:MI'), SND_USR_OFC_CD ), 'YYYY-MM-DD HH24:MI')  AS ACK_RCV_DT" ).append("\n"); 
		query.append("             ,BKG_GET_TOKEN_FNC(RCV,5) AS RESULT_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(COM_ConstantMgr_PKG.COM_getHeadOfficeCode_FNC(),TO_DATE(BKG_GET_TOKEN_FNC(RCV,4),'YYYY-MM-DD HH24:MI'), 'GMT'),           'YYYY-MM-DD HH24:MI')  AS ACK_RCV_GMT_DT" ).append("\n"); 
		query.append("             ,BKG_GET_TOKEN_FNC(RCV,6) AS ACK_KND_ID" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("			/* 다운로드 안된 데이타 조회 */  " ).append("\n"); 
		query.append("		SELECT *" ).append("\n"); 
		query.append("        FROM  (     " ).append("\n"); 
		query.append("            SELECT  " ).append("\n"); 
		query.append("                VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("               ,(SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = VVD.VSL_CD AND SKD_VOY_NO = VVD.SKD_VOY_NO AND SKD_DIR_CD = VVD.SKD_DIR_CD)   AS LANE" ).append("\n"); 
		query.append("               ,VVD.POL_CD         AS POL" ).append("\n"); 
		query.append("               ,SUBSTR(VVD.POL_YD_CD,6)  AS POL_YD" ).append("\n"); 
		query.append("			   ,BKG.POL_CD         AS BPOL" ).append("\n"); 
		query.append("			   ,SUBSTR(BKG.POL_NOD_CD,6) AS BPOL_YD " ).append("\n"); 
		query.append("               ,BKG.BL_NO          AS BL_NO           " ).append("\n"); 
		query.append("               ,VVD.POD_CD         AS POD           " ).append("\n"); 
		query.append("               ,VVD.POD_YD_CD      AS POD_YD" ).append("\n"); 
		query.append("               ,BKG.DEL_CD         AS DEL" ).append("\n"); 
		query.append("               ,''                 AS DEL_YD" ).append("\n"); 
		query.append("               ,''                 AS MSG_SND_NO" ).append("\n"); 
		query.append("               ,BKG.BKG_CGO_TP_CD  AS CT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			   , ( SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("					 FROM BKG_CSTMS_EUR_IO_BL EBL" ).append("\n"); 
		query.append("					WHERE EBL.MSG_SND_NO    = (SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("    							                 FROM BKG_CSTMS_EUR_IO_SND" ).append("\n"); 
		query.append("												WHERE BL_NO          = BKG.BL_NO" ).append("\n"); 
		query.append("									              AND CSTMS_PORT_CD  = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("							                      AND (VSL_CD != VVD.VSL_CD OR SKD_VOY_NO != VVD.SKD_VOY_NO OR SKD_DIR_CD != VVD.SKD_DIR_CD)" ).append("\n"); 
		query.append("												  AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("											   )" ).append("\n"); 
		query.append("				   AND EBL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("					) AS MRN_NO " ).append("\n"); 
		query.append("               ,NULL               AS ENS_SEND_DT" ).append("\n"); 
		query.append("               ,NULL               AS ENS_SEND_GMT_DT" ).append("\n"); 
		query.append("               ,''                 AS RCV" ).append("\n"); 
		query.append("               ,BKG.BKG_NO         AS BKG_NO" ).append("\n"); 
		query.append("               ,''                 AS SND_CRE_USR_ID" ).append("\n"); 
		query.append("               ,''                 AS SND_USR_OFC_CD" ).append("\n"); 
		query.append("               ,'N'                AS DOWNLOAD_YN" ).append("\n"); 
		query.append("               ,''                 AS MSG_FUNC_ID" ).append("\n"); 
		query.append("               ,BKG.BKG_STS_CD" ).append("\n"); 
		query.append("              ,BKG_JOIN_CLOB_FNC(CURSOR(SELECT  CNTR_NO FROM BKG_CONTAINER BC WHERE BC.BKG_NO = BKG.BKG_NO),CHR(10)) AS CNTRS				" ).append("\n"); 
		query.append("            FROM  BKG_VVD VVD " ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("               ,BKG_BL_DOC BD" ).append("\n"); 
		query.append("               ,VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("            WHERE  1=1" ).append("\n"); 
		query.append("            AND VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("			#if(${p_cancel_yn} == '')" ).append("\n"); 
		query.append("	            AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				/* Incl. Canceled Booking */" ).append("\n"); 
		query.append("	            AND BKG.BKG_STS_CD IN ('F', 'W','X')" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("            AND BKG.BKG_CGO_TP_CD IN ('F', 'R')   " ).append("\n"); 
		query.append("            AND BKG.BL_NO IS NOT NULL" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = BD.BKG_NO " ).append("\n"); 
		query.append("            AND VVD.VSL_CD        = SKD2.VSL_CD" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO    = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD    = SKD2.SKD_DIR_CD " ).append("\n"); 
		query.append("            AND SKD2.CLPT_IND_SEQ  = 1" ).append("\n"); 
		query.append("            AND VVD.POL_CD 		= SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND VVD.POL_CLPT_IND_SEQ= SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            /* 다운로드 안된 데이타 조회 */ " ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_EUR_IO_BL" ).append("\n"); 
		query.append("                            WHERE VSL_CD       = VVD.VSL_CD" ).append("\n"); 
		query.append("                            AND  SKD_VOY_NO    = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND  SKD_DIR_CD    = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND  BL_NO         = BKG.BL_NO " ).append("\n"); 
		query.append("                            AND  CSTMS_PORT_CD = SKD2.VPS_PORT_CD  " ).append("\n"); 
		query.append("                            AND  BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("			#if (${p_vvd} != '')                             " ).append("\n"); 
		query.append("            	AND VVD.VSL_CD        = SUBSTR(@[p_vvd],1,4)" ).append("\n"); 
		query.append("	            AND VVD.SKD_VOY_NO    = SUBSTR(@[p_vvd],5,4)" ).append("\n"); 
		query.append("    	        AND VVD.SKD_DIR_CD    = SUBSTR(@[p_vvd],9,1)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            AND VVD.BKG_NO > ' '" ).append("\n"); 
		query.append("            AND VVD.SLAN_CD > ' '" ).append("\n"); 
		query.append("			#if (${p_pol} != '') " ).append("\n"); 
		query.append("    	      AND VVD.POL_CD             = SUBSTR(@[p_pol], 1, 5)" ).append("\n"); 
		query.append("			  AND VVD.POL_YD_CD			 LIKE @[p_pol]||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${p_b_ofc_cd} != '') " ).append("\n"); 
		query.append("			  AND BKG.BKG_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${p_search_pofe_yard_cd} != '') " ).append("\n"); 
		query.append("			--	AND SKD2.YD_CD LIKE  @[p_search_pofe_yard_cd]||'%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${p_bl_no} != '') " ).append("\n"); 
		query.append("			  AND BKG.BL_NO = @[p_bl_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${p_from_dt} != '' || ${p_to_dt} != '' || ${p_type} == 'O' || ${p_type} == 'U'  || ${p_type} == 'DL' ) " ).append("\n"); 
		query.append("              /* 전송관련 조회이면 무조건 걸러낸다 */" ).append("\n"); 
		query.append("    	      AND 1=2" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	        /* Ack. Stauts가 Accepted,Reject,Do Not Load, Not Received 또는 '' 이면서 Amendment이면  제외한다.*/" ).append("\n"); 
		query.append("			#if (${p_ack_status} == 'A' || ${p_ack_status} == 'R'|| ${p_ack_status} == 'DNL' || ${p_ack_status} == 'H'  || ${p_ack_status} == 'L' || ${p_ack_status} == 'NR' ) " ).append("\n"); 
		query.append("				AND 1=2" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE 1=1 " ).append("\n"); 
		query.append("			#if (${p_lane} != '') " ).append("\n"); 
		query.append("    	      AND LANE        = @[p_lane]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			/* 다운로드 된 데이타 조회 */ " ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("              /* Send 날짜만 입력 됐을 경우 */" ).append("\n"); 
		query.append("              #if (${p_vvd} == '' && ${p_from_dt} != '' && ${p_date_gb} == 'S' ) " ).append("\n"); 
		query.append("                  /*+ USE_NL(SND A) INDEX(B XPKVSK_VSL_SKD )*/" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("             ,B.VSL_SLAN_CD   AS LANE" ).append("\n"); 
		query.append("             ,A.POL_CD        AS POL" ).append("\n"); 
		query.append("             ,SUBSTR(A.POL_YD_CD,6)    AS POL_YD" ).append("\n"); 
		query.append("			 ,BKG.POL_CD      AS BPOL " ).append("\n"); 
		query.append("			 ,SUBSTR(BKG.POL_NOD_CD,6) AS BPOL_YD" ).append("\n"); 
		query.append("             ,A.BL_NO         AS BL_NO" ).append("\n"); 
		query.append("             ,A.POD_CD        AS POD" ).append("\n"); 
		query.append("             ,A.POD_YD_CD     AS POD_YD" ).append("\n"); 
		query.append("             ,A.DEL_CD        AS DEL" ).append("\n"); 
		query.append("             ,''              AS DEL_YD" ).append("\n"); 
		query.append("             ,A.MSG_SND_NO" ).append("\n"); 
		query.append("             ,(SELECT BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING" ).append("\n"); 
		query.append("                 WHERE BL_NO = A.BL_NO ) AS CT" ).append("\n"); 
		query.append("           , NVL(A.MVMT_REF_NO,   ( SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("								        FROM BKG_CSTMS_EUR_IO_BL EBL" ).append("\n"); 
		query.append("								       WHERE EBL.MSG_SND_NO    = (SELECT MAX(MSG_SND_NO) " ).append("\n"); 
		query.append("                                    							 	FROM BKG_CSTMS_EUR_IO_SND" ).append("\n"); 
		query.append("								                                   WHERE BL_NO          = A.BL_NO" ).append("\n"); 
		query.append("                                								     AND CSTMS_PORT_CD  = A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("				                                                     AND (VSL_CD != A.VSL_CD OR SKD_VOY_NO != A.SKD_VOY_NO OR SKD_DIR_CD != A.SKD_DIR_CD)" ).append("\n"); 
		query.append("																	 AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("									                               )" ).append("\n"); 
		query.append("									    AND EBL.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("								      )" ).append("\n"); 
		query.append("             ) AS MRN_NO" ).append("\n"); 
		query.append("             ,TO_CHAR(SND.SND_DT  ,'YYYY-MM-DD HH24:MI')AS ENS_SEND_DT" ).append("\n"); 
		query.append("             ,TO_CHAR(SND.SND_GDT ,'YYYY-MM-DD HH24:MI')AS ENS_SEND_GMT_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             ,(SELECT EDI_RCV_DT||','||EDI_RCV_SEQ||','|| ACK_RCV_STS_CD||','|| TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI')||','||EUR_CSTMS_ACK_CD||','||ACK_KND_ID" ).append("\n"); 
		query.append("               FROM  BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("               WHERE RCV_TMS = ( SELECT MAX(RCV_TMS)" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("                                  WHERE MSG_RCV_NO = SND.MSG_SND_NO" ).append("\n"); 
		query.append("								   AND (ACK_KND_ID != 'S' OR ACK_RCV_STS_CD != 'A')" ).append("\n"); 
		query.append("								   AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("			   AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("              ) RCV" ).append("\n"); 
		query.append("            , (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = A.BL_NO) AS BKG_NO" ).append("\n"); 
		query.append("            , SND.CRE_USR_ID AS SND_CRE_USR_ID" ).append("\n"); 
		query.append("            , SND.SND_USR_OFC_CD " ).append("\n"); 
		query.append("            ,'Y'                AS DOWNLOAD_YN" ).append("\n"); 
		query.append("			,SND.MSG_FUNC_ID" ).append("\n"); 
		query.append("            ,BKG.BKG_STS_CD AS BKG_STS_CD" ).append("\n"); 
		query.append("            ,BKG_JOIN_CLOB_FNC(CURSOR(SELECT CNTR_NO" ).append("\n"); 
		query.append("                                      FROM BKG_CSTMS_EUR_IO_CNTR BC" ).append("\n"); 
		query.append("                                     WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                       AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("                                       AND BND_TP_CD = 'O')" ).append("\n"); 
		query.append("                                 ,CHR(10)) AS CNTRS" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_IO_BL A" ).append("\n"); 
		query.append("			 , BKG_BOOKING BKG" ).append("\n"); 
		query.append("             , VSK_VSL_SKD B" ).append("\n"); 
		query.append("             , BKG_CSTMS_EUR_IO_SND SND" ).append("\n"); 
		query.append("             , BKG_VVD BVVD" ).append("\n"); 
		query.append("         WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("           AND A.BL_NO      = BKG.BL_NO" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.MSG_SND_NO = SND.MSG_SND_NO(+)" ).append("\n"); 
		query.append("           AND A.BND_TP_CD = 'O'" ).append("\n"); 
		query.append("		   AND SND.BND_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("		#if (${p_vvd} != '') " ).append("\n"); 
		query.append("          AND A.VSL_CD        = SUBSTR(@[p_vvd],1,4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO    = SUBSTR(@[p_vvd],5,4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD    = SUBSTR(@[p_vvd],9,1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("          AND A.VSL_CD        = BVVD.VSL_CD" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO    = BVVD.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD    = BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BKG.BKG_NO      = BVVD.BKG_NO" ).append("\n"); 
		query.append("		#if (${p_lane} != '') " ).append("\n"); 
		query.append("          AND B.VSL_SLAN_CD        = @[p_lane]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${p_pol} != '') " ).append("\n"); 
		query.append("          AND A.CSTMS_PORT_CD      = SUBSTR(@[p_pol], 1, 5)" ).append("\n"); 
		query.append("   	      AND A.CSTMS_YD_CD        LIKE @[p_pol]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${p_b_ofc_cd} != '') " ).append("\n"); 
		query.append("		  AND BKG.BKG_OFC_CD = @[p_b_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${p_bl_no} != '') " ).append("\n"); 
		query.append("		  AND A.BL_NO = @[p_bl_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if(${p_cancel_yn} == '')" ).append("\n"); 
		query.append("			AND EXISTS ( SELECT 'Y' FROM BKG_BOOKING WHERE BL_NO = A.BL_NO AND BKG_STS_CD != 'X')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${p_date_gb} == 'S') " ).append("\n"); 
		query.append("			#if (${p_from_dt} != '') " ).append("\n"); 
		query.append("    	      AND SND.SND_DT        >= TO_DATE(@[p_from_dt]||' ' ||NVL(@[p_from_mt],'00:00'),'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${p_to_dt} != '') " ).append("\n"); 
		query.append("    	      AND SND.SND_DT        <= TO_DATE(@[p_to_dt]||' ' ||NVL(@[p_to_mt],'23:59')||':59','YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        /* Received 날짜만 입력 됐을 경우 먼저 조회 범위를 줄여준 다음 바깥쪽에서 체크조건으로 한번더 날짜로 걸러낸다.*/" ).append("\n"); 
		query.append("        #if (${p_vvd} == '' && ${p_date_gb} != 'S' && ${p_from_dt} != '' ) " ).append("\n"); 
		query.append("          AND SND.MSG_SND_NO IN  (SELECT MSG_RCV_NO" ).append("\n"); 
		query.append("                                    FROM  BKG_CSTMS_EUR_IO_RCV" ).append("\n"); 
		query.append("                                   WHERE 1=1" ).append("\n"); 
		query.append("                                     AND RCV_TMS >= TO_TIMESTAMP(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ||':00.000000' ,'YYYYMMDD HH24:MI:SS.FF')-1 " ).append("\n"); 
		query.append("									#if (${p_to_dt} != '')" ).append("\n"); 
		query.append("                                     AND RCV_TMS <= TO_TIMESTAMP(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'23:59') ||':59.999999' ,'YYYYMMDD HH24:MI:SS.FF') +1" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									 AND BND_TP_CD = 'O'" ).append("\n"); 
		query.append("                                  ) " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		#if (${p_vvd} == '') " ).append("\n"); 
		query.append("			/* SEND 또는 RECEIVE DATE가 입력되면 NVL이 사실상 필요가 없으나 차후를 위해 처리함 */" ).append("\n"); 
		query.append("			AND NVL(A.MSG_SND_NO,'X') =  DECODE(A.MSG_SND_NO,NULL,'X',( SELECT MAX(MSG_SND_NO) FROM BKG_CSTMS_EUR_IO_BL WHERE BL_NO = A.BL_NO AND CSTMS_PORT_CD = A.CSTMS_PORT_CD AND BND_TP_CD = 'O'))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${p_type} == 'O' || ${p_type} == 'U') " ).append("\n"); 
		query.append("          AND SND.MSG_FUNC_ID        = @[p_type]" ).append("\n"); 
		query.append("        #elseif (${p_type} == 'DL') " ).append("\n"); 
		query.append("		  AND SND.MSG_SND_NO IS NULL" ).append("\n"); 
		query.append("        #elseif (${p_type} == 'NA') " ).append("\n"); 
		query.append("		  AND 1=2" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		/* Ack. Status is Not Received */" ).append("\n"); 
		query.append("		#if (${p_ack_status} == 'NR' ) " ).append("\n"); 
		query.append("			AND SND.MSG_SND_NO IS NOT NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		/* Ack. Status is N/A */" ).append("\n"); 
		query.append("		#if (${p_ack_status} == 'NA' ) " ).append("\n"); 
		query.append("			AND SND.MSG_SND_NO IS NULL" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("       ) X" ).append("\n"); 
		query.append("    ) Y" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("		#if (${p_date_gb} != 'S') " ).append("\n"); 
		query.append("			#if (${p_from_dt} != '') " ).append("\n"); 
		query.append("    	      AND TO_DATE(ACK_RCV_DT,'YYYY-MM-DD HH24:MI')  >= TO_DATE(REPLACE(@[p_from_dt],'-','')||' ' ||NVL(@[p_from_mt],'00:00') ,'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${p_to_dt} != '') " ).append("\n"); 
		query.append("    	      AND TO_DATE(ACK_RCV_DT,'YYYY-MM-DD HH24:MI')  <= TO_DATE(REPLACE(@[p_to_dt],'-','')||' ' ||NVL(@[p_to_mt],'59:59'),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${p_status} != '') " ).append("\n"); 
		query.append("          AND ACK                   = @[p_status]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#if (${p_ack_status} == 'A' ) " ).append("\n"); 
		query.append("		AND ACK_CD  = 'A'" ).append("\n"); 
		query.append("    #elseif (${p_ack_status} == 'R') " ).append("\n"); 
		query.append("		AND ACK_CD  = 'R'" ).append("\n"); 
		query.append("		AND RESULT_CD  != '351'" ).append("\n"); 
		query.append("    #elseif (${p_ack_status} == 'DNL') " ).append("\n"); 
		query.append("		AND RESULT_CD  = '351'" ).append("\n"); 
		query.append("	#elseif (${p_ack_status} == 'H') " ).append("\n"); 
		query.append("		AND (RESULT_CD  = '561' OR ACK_CD IN ('D', 'P'))" ).append("\n"); 
		query.append("	#elseif (${p_ack_status} == 'L') " ).append("\n"); 
		query.append("		AND ACK_CD = 'L'" ).append("\n"); 
		query.append("    #elseif (${p_ack_status} == 'NR') " ).append("\n"); 
		query.append("		AND RCV IS NULL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   ) Z" ).append("\n"); 
		query.append(") MM" ).append("\n"); 
		query.append("ORDER BY BL_NO" ).append("\n"); 

	}
}