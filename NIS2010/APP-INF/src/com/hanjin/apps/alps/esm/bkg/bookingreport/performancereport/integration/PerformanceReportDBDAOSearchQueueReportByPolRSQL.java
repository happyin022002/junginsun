/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchQueueReportByPolRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchQueueReportByPolRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchQueueReportByPolRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchQueueReportByPolRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("queue_source",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rows_per_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("list_by_queue",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchQueueReportByPolRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    TTL_BKG - BST_UNMATCHED_Q AS BST_MATCHED_Q   /* BST Matched Q */" ).append("\n"); 
		query.append("    , Y.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("           ROWNUM RNUM" ).append("\n"); 
		query.append("        , COUNT(BKG_NO) OVER()                             AS TTL_BKG /* TTL BKG */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD,'ST',1,'IG',1,0)) OVER()        AS INPUTTER_QUEUE /* INPUTTER QUEUE*/        " ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD ,'ST',1,0)) OVER()              AS SR_TRANSFERRED /* SR Trsfrd */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD ,'IG',1,0)) OVER()              AS INPUTTING      /* Inputting */" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , SUM(DECODE(SR ,'Y',1,0)) OVER()                           AS SR_Y          /* S/R Y */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD,'ID',1,'RG',1,0)) OVER()        AS RATER_QUEUE   /* RATEER QUEUE */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD ,'ID',1,0)) OVER()              AS INPUTTED      /* Inputted */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD ,'RG',1,0)) OVER()              AS RATING        /* Rating */" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , SUM(DECODE(SR ,'N',1,0)) OVER() AS SR_N/* S/R N */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD,'AD',1,'AG',1,'RD',1,0)) OVER() AS AUDITOR_QUEUE /* AUDITOR QUERE */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD ,'RD',1,0)) OVER()              AS RATED         /* Rated */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD ,'AG',1,0)) OVER()              AS AUDITING      /* Auditing */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD,'AD',1,0)) OVER()               AS AUDITED       /* Audited */" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD,'XX',1,0)) OVER()               AS STOPPED_QUEUE /* STOPPED_QUEUE */" ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_INFO_CD,'R',1, DECODE(SR_RTN_TO_STS_CD,'S',1,0)))         OVER() AS FOFC_RETURNED /* FO Returned */" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , SUM(DECODE(SR_CRNT_STS_CD,'ST',1,'IG',1,'ID',1,'RG',1,'RD',1,'AG',1,'AD',1,0)) OVER() AS QUEUE_TOTAL/*QUEUE TTL */ " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        , COUNT(DISTINCT FOR_UNMATCH_Q_BKG_NO) OVER()                                         AS BST_UNMATCHED_Q /* BST Unmatched Q */" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("        , COUNT(BKG_NO) OVER() TOTAL_CNT" ).append("\n"); 
		query.append("        , X.*" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                    DISTINCT A.BKG_NO AS BKG_NO," ).append("\n"); 
		query.append("                    B.SI_FLG          AS SR," ).append("\n"); 
		query.append("                    A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("                    A.POL_CD                             AS POL_CD," ).append("\n"); 
		query.append("                    A.POD_CD                             AS POD_CD," ).append("\n"); 
		query.append("                    (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("                     WHERE INTG_CD_ID ='CD01577'" ).append("\n"); 
		query.append("                       AND INTG_CD_VAL_CTNT = C.SR_AMD_TP_CD)    AS SR_KND_CD, " ).append("\n"); 
		query.append("                    C.SR_CRNT_STS_CD," ).append("\n"); 
		query.append("                    (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                     WHERE INTG_CD_ID ='CD01579'" ).append("\n"); 
		query.append("                       AND INTG_CD_VAL_CTNT = C.SR_CRNT_STS_CD ) AS STATUS," ).append("\n"); 
		query.append("                    TO_CHAR(C.CRNT_DT,'YYYY-MM-DD HH24:MI')      AS LAST_UPD_DT,   " ).append("\n"); 
		query.append("                    DECODE(C.FNT_OFC_CD, NULL,'1','0')," ).append("\n"); 
		query.append("                    C.FNT_OFC_CD," ).append("\n"); 
		query.append("                    DECODE(FNT_OFC_CD, NULL,A.BKG_NO) FOR_UNMATCH_Q_BKG_NO ," ).append("\n"); 
		query.append("                    DECODE(C.SR_CRNT_INFO_CD,'R','1','0')," ).append("\n"); 
		query.append("                    C.SR_CRNT_INFO_CD," ).append("\n"); 
		query.append("                    DECODE(C.SR_RTN_TO_STS_CD,'S','1','0')," ).append("\n"); 
		query.append("                    C.SR_RTN_TO_STS_CD," ).append("\n"); 
		query.append("                    (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("                     AND BKG_NO = A.BKG_NO ) AS SHIPPER_CODE," ).append("\n"); 
		query.append("                     (SELECT REPLACE(CUST_NM,CHR(13)||CHR(10),' ')  FROM BKG_CUSTOMER WHERE BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("                     AND BKG_NO = A.BKG_NO ) AS SHIPPER_NM," ).append("\n"); 
		query.append("                     (SELECT REPLACE(CUST_NM,CHR(13)||CHR(10),' ')  FROM BKG_CUSTOMER WHERE BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("                     AND BKG_NO = A.BKG_NO ) AS CONSIGNEE_NM" ).append("\n"); 
		query.append("							#if(${doc_part} !='Y')" ).append("\n"); 
		query.append("								,NVL((SELECT 'Y' FROM" ).append("\n"); 
		query.append("									  BKG_SR_FAX" ).append("\n"); 
		query.append("									  WHERE SR_NO = C.SR_NO" ).append("\n"); 
		query.append("									  AND SR_KND_CD = C.SR_KND_CD" ).append("\n"); 
		query.append("									  AND RCV_OFC_CD IN (" ).append("\n"); 
		query.append("							#if(${doc_part_eu} =='Y')" ).append("\n"); 
		query.append("							'ANRSO','BRESO','DUSSO','FRASO','FXTBO','HAMSC','LONBB','MANBS','MUCSO','RTMSC','FXTSC','HAMRUG'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part_jp} =='Y')" ).append("\n"); 
		query.append("							'KIJBA','OSASO','TYOSC'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part_sw} =='Y')" ).append("\n"); 
		query.append("							'PENSO','PGUSO','PKGSC','SINSC'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							'$$')),'N') DOC_PART" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part} =='Y')" ).append("\n"); 
		query.append("								,'Y' DOC_PART " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("            FROM	 BKG_VVD A, " ).append("\n"); 
		query.append("                     BKG_BOOKING B, " ).append("\n"); 
		query.append("                     BKG_SR_CRNT_RQST C, " ).append("\n"); 
		query.append("                     --COM_SYS_AREA_GRP_ID D," ).append("\n"); 
		query.append("                     " ).append("\n"); 
		query.append("                     /* ETD */" ).append("\n"); 
		query.append("                     #if(${period_gubun} == 'ETD')" ).append("\n"); 
		query.append("                     (SELECT DISTINCT BKG_NO " ).append("\n"); 
		query.append("                      FROM BKG_VVD Z ,VSK_VSL_PORT_SKD VSP" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                      AND Z.VSL_CD = VSP.VSL_CD" ).append("\n"); 
		query.append("                      AND Z.SKD_VOY_NO = VSP.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND Z.SKD_DIR_CD = VSP.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND Z.POL_CD = VSP.VPS_PORT_CD " ).append("\n"); 
		query.append("                      AND  VSP.VPS_ETD_DT >= TO_DATE(@[etd_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                      AND  VSP.VPS_ETD_DT <= TO_DATE(@[etd_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("                      AND  VSP.VPS_PORT_CD = @[pol_cd] ) G" ).append("\n"); 
		query.append("                      #end" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                       /* S/R Transferred Date */" ).append("\n"); 
		query.append("                      #if(${period_gubun} == 'SR')" ).append("\n"); 
		query.append("                      (SELECT DISTINCT C.BKG_NO" ).append("\n"); 
		query.append("                       FROM  BKG_SR_CRNT_RQST C" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                       AND CRNT_DT >= TO_DATE(@[sr_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                       AND CRNT_DT <= TO_DATE(@[sr_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("                       )G" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                      /* PCT */" ).append("\n"); 
		query.append("                      #if(${period_gubun} == 'PCT')" ).append("\n"); 
		query.append("                      (SELECT DISTINCT Z.BKG_NO" ).append("\n"); 
		query.append("                       FROM BKG_VVD Z , BKG_BOOKING B" ).append("\n"); 
		query.append("                       WHERE 1=1" ).append("\n"); 
		query.append("                       AND Z.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND B.PORT_CLZ_DT >= TO_DATE(@[pct_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                       AND B.PORT_CLZ_DT <= TO_DATE(@[pct_to_dt],'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("					   #if(${pol_cd} != '')" ).append("\n"); 
		query.append("					      AND Z.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("					   #end" ).append("\n"); 
		query.append("                       ) G" ).append("\n"); 
		query.append("                       #end" ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND  G.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("            AND  G.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND	 B.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("            --AND  D.SYS_AREA_GRP_ID ='SWA'" ).append("\n"); 
		query.append("            --AND  SUBSTR(A.POD_CD,1,2) = D.CNT_CD" ).append("\n"); 
		query.append("            --AND  D.CO_IND_CD ='H'" ).append("\n"); 
		query.append("            AND	 B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("            AND	 B.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("            --AND	 B.SPLIT_RSN_CD IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            --AND	 (C.SR_CRNT_STS_CD IN ('SR', 'ST', 'IG', 'ID', 'RG', 'RD', 'AG', 'AD', 'DF', 'BL') OR C.SR_CRNT_STS_CD IS NULL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* BKG MATCH==ALL,M */" ).append("\n"); 
		query.append("            #if(${bst_match} =='A' || ${bst_match} =='M')" ).append("\n"); 
		query.append("             #if( ${list_by_queue} != '' && ${list_by_queue} != '%')" ).append("\n"); 
		query.append("              AND	 NVL(C.SR_CRNT_STS_CD,' ') IN (DECODE(@[list_by_queue],'I','ST','R','ID','AU','RD','C','DF')," ).append("\n"); 
		query.append("                                                          DECODE(@[list_by_queue],'I','IG','R','RG','AU','AG','C','BL')," ).append("\n"); 
		query.append("                                                          DECODE(@[list_by_queue],'AU','AD')," ).append("\n"); 
		query.append("                                                          DECODE(@[list_by_queue],'DF','DF')," ).append("\n"); 
		query.append("                                                          DECODE(@[list_by_queue],'A',NVL(C.SR_CRNT_STS_CD,' '))) " ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            /* S/R 일 경우*/" ).append("\n"); 
		query.append("            #if(${period_gubun} == 'ETD')" ).append("\n"); 
		query.append("            AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* B/Office */								  			  " ).append("\n"); 
		query.append("            #if(${bkg_ofc} != '')" ).append("\n"); 
		query.append("            AND B.bkg_ofc_cd = @[bkg_ofc]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* TOTAL VVD */" ).append("\n"); 
		query.append("            #if(${total_vvd} != '')" ).append("\n"); 
		query.append("            AND A.VSL_CD     = SUBSTR(@[total_vvd], 1, 4)" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = SUBSTR(@[total_vvd], 5, 4)" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD = SUBSTR(@[total_vvd], 9, 1) " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* Queue Source */" ).append("\n"); 
		query.append("            #if(${queue_source} != '')" ).append("\n"); 
		query.append("            AND C.SR_KND_CD = SUBSTR(@[queue_source],1,1)" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /*BKG MATCH==M,U*/" ).append("\n"); 
		query.append("            #if(${bst_match} =='M' || ${bst_match} =='U')" ).append("\n"); 
		query.append("            AND C.FNT_OFC_CD IS NOT NULL " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("            ORDER BY BKG_NO" ).append("\n"); 
		query.append("         ) X" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("			AND X.DOC_PART ='Y'" ).append("\n"); 
		query.append("     ) Y" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1) - 1) + 1" ).append("\n"); 
		query.append("           AND     NVL(@[rows_per_page],50) *  NVL(@[curr_page],1)" ).append("\n"); 

	}
}