/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStsReportList1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStsReportList1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStsReportList1RSQL
	  * * History
	  * * 2012.07.11 김보배 [CHM-201218861] [BKG] B/L Status Report 상 Web Original B/L 추가 요청
	  * * 2012.08.08 김기택 [CHM-201219181] [BKG] BL Status Report에 Issue & Release 로직 수정
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStsReportList1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_page",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sal_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_rfa_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("staff_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStsReportList1RSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("	   SELECT " ).append("\n"); 
		query.append("            ROWNUM RNUM            " ).append("\n"); 
		query.append("             /* 2009.12.28 수정 */" ).append("\n"); 
		query.append("            , NVL(BKG_GET_TOKEN_FNC(PPD_ORG0,1),'N') AS PPD_ORG" ).append("\n"); 
		query.append("            , BKG_GET_TOKEN_FNC(PPD_ORG0,2) AS PPD_ORG2" ).append("\n"); 
		query.append("            , NVL(BKG_GET_TOKEN_FNC(PPD_3RD0,1),'N') AS PPD_3RD" ).append("\n"); 
		query.append("            , BKG_GET_TOKEN_FNC(PPD_3RD0,2) AS PPD_3RD2" ).append("\n"); 
		query.append("            , NVL(BKG_GET_TOKEN_FNC(CCT_DEST0,1),'N') AS CCT_DEST" ).append("\n"); 
		query.append("            , BKG_GET_TOKEN_FNC(CCT_DEST0,2) AS CCT_DEST2" ).append("\n"); 
		query.append("            , NVL(BKG_GET_TOKEN_FNC(CCT_3RD0,1),'N') AS CCT_3RD" ).append("\n"); 
		query.append("            , BKG_GET_TOKEN_FNC(CCT_3RD0,2) AS CCT_3RD2" ).append("\n"); 
		query.append("            ,ZZ.*" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("		  SELECT " ).append("\n"); 
		query.append("		    	COUNT(BKG_NO) OVER() TOTAL_CNT, 		    	" ).append("\n"); 
		query.append("			Z.*" ).append("\n"); 
		query.append("		  FROM ( SELECT" ).append("\n"); 
		query.append("		     ( SELECT REPLACE(CUST_NM,chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("		       FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("		       WHERE BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("		       AND   BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("		     ) AS SHIPPER" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			/* 2009.12.28 수정 */" ).append("\n"); 
		query.append("			,( SELECT REPLACE(CUST_NM,chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("			FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("			WHERE BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("			AND   BKG_CUST_TP_CD ='F'" ).append("\n"); 
		query.append("			) AS FOWARDER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    ,( SELECT REPLACE(CUST_NM,chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("		       FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("		       WHERE BKG_NO = Y.BKG_NO" ).append("\n"); 
		query.append("		       AND   BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("		     ) AS CONSIGNEE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            /* 2009.12.28 수정 */" ).append("\n"); 
		query.append("            , (SELECT ORG_PPD_RCV_CD||','||ORG_PPD_RCV_UPD_OFC_CD  FROM BKG_BL_ISS         " ).append("\n"); 
		query.append("            WHERE BKG_NO = Y.BKG_NO) PPD_ORG0" ).append("\n"); 
		query.append("            , (SELECT ORG_N3PTY_PPD_CD||','||ORG_N3PTY_PPD_UPD_OFC_CD  FROM BKG_BL_ISS" ).append("\n"); 
		query.append("            WHERE BKG_NO = Y.BKG_NO) PPD_3RD0" ).append("\n"); 
		query.append("            , (SELECT DEST_CLT_RCV_CD||','||(SELECT N3PTY_RCV_OFC_CD " ).append("\n"); 
		query.append("                                    					FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("					                                    WHERE RT.BKG_NO =ISS.BKG_NO" ).append("\n"); 
		query.append("					                                    AND FRT_TERM_CD ='P'" ).append("\n"); 
		query.append("					                                    AND N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("					                                    AND ROWNUM =1 )  FROM BKG_BL_ISS ISS" ).append("\n"); 
		query.append("            WHERE BKG_NO = Y.BKG_NO) CCT_DEST0" ).append("\n"); 
		query.append("            , (SELECT ISS.DEST_N3PTY_CLT_CD||','||NVL((SELECT N3PTY_RCV_OFC_CD " ).append("\n"); 
		query.append("                                    					FROM BKG_CHG_RT RT" ).append("\n"); 
		query.append("					                                    WHERE RT.BKG_NO =ISS.BKG_NO" ).append("\n"); 
		query.append("					                                    AND FRT_TERM_CD ='P'" ).append("\n"); 
		query.append("					                                    AND N3PTY_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("					                                    AND ROWNUM =1 ),ISS.DEST_N3PTY_CLT_UPD_OFC_CD)  FROM BKG_BL_ISS ISS" ).append("\n"); 
		query.append("            WHERE ISS.BKG_NO = Y.BKG_NO) CCT_3RD0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		    , Y.*" ).append("\n"); 
		query.append("		    FROM ( SELECT   " ).append("\n"); 
		query.append("							BK.BKG_NO AS BKG_NO ," ).append("\n"); 
		query.append("							BK.BL_NO||BK.BL_TP_CD AS BL_NO," ).append("\n"); 
		query.append("							BK.POR_CD AS POR_CD," ).append("\n"); 
		query.append("							BK.POL_CD AS POL_CD," ).append("\n"); 
		query.append("							BK.POD_CD AS POD_CD," ).append("\n"); 
		query.append("							BK.DEL_CD AS DEL_CD," ).append("\n"); 
		query.append("							BK.BKG_OFC_CD       AS BKG_OFC," ).append("\n"); 
		query.append("							BK.IB_SLS_OFC_CD    AS DEL_OFC," ).append("\n"); 
		query.append("							DOC.BL_OBRD_TP_CD   AS OB_TYPE," ).append("\n"); 
		query.append("							TO_CHAR(DOC.BL_OBRD_DT, 'YYYY-MM-DD')      AS OB_DATE," ).append("\n"); 
		query.append("                            --NVL(BK.BL_TP_CD,'B')         AS IR_BL_TYPE," ).append("\n"); 
		query.append("                            CASE WHEN BK.BL_TP_CD = 'W' THEN 'SWB'" ).append("\n"); 
		query.append("                                -- WHEN (SELECT MAX(N1ST_PRN_DT||N2ND_PRN_DT) " ).append("\n"); 
		query.append("                                --         FROM BKG_INET_BL_PRN_AUTH " ).append("\n"); 
		query.append("                                --        WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                --          AND DELT_FLG = 'N') is not null THEN 'Web OB/L'" ).append("\n"); 
		query.append("								WHEN ISS.OBL_INET_FLG = 'Y' THEN 'Web OB/L'" ).append("\n"); 
		query.append("                                WHEN ISS.OBL_RLSE_FLG = 'Y' THEN 'OB/L'" ).append("\n"); 
		query.append("                                ELSE 'B'" ).append("\n"); 
		query.append("                            END AS IR_BL_TYPE," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ISS.OBL_ISS_OFC_CD  AS IR_OFFICE," ).append("\n"); 
		query.append("                            TO_CHAR(ISS.OBL_ISS_DT, 'YYYY-MM-DD')      AS IR_DATE," ).append("\n"); 
		query.append("                            ISS.OBL_ISS_USR_ID  AS IR_BY," ).append("\n"); 
		query.append("                            ISS.OBL_RDEM_OFC_CD AS ORS_OFFICE," ).append("\n"); 
		query.append("                            TO_CHAR(ISS.OBL_RDEM_DT, 'YYYY-MM-DD')     AS ORS_DATE," ).append("\n"); 
		query.append("                            /* 2009 10 06 수정*/" ).append("\n"); 
		query.append("                            NVL(ISS.OBL_ISS_FLG,'N') BL_ISSUED," ).append("\n"); 
		query.append("                            /* 2012.07.24수정 */" ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                            	WHEN ISS.OBL_PRN_FLG = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("                            	WHEN (SELECT MAX(N1ST_PRN_DT||N2ND_PRN_DT)" ).append("\n"); 
		query.append("                                      FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("                                      WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                      AND DELT_FLG ='N') IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("                                ELSE 'N'" ).append("\n"); 
		query.append("                            END BL_PRINT," ).append("\n"); 
		query.append("                            NVL(ISS.OBL_RLSE_FLG,'N') BL_RELEASED," ).append("\n"); 
		query.append("							NVL(ISS.OBL_RDEM_KNT,0)    AS ORS_NO," ).append("\n"); 
		query.append("							NVL(ISS.OBL_SRND_FLG,'N')    AS ORS_SURRENDER," ).append("\n"); 
		query.append("							(SELECT DECODE(COUNT(*),1,'Y','N')" ).append("\n"); 
		query.append("							 FROM BKG_DO A" ).append("\n"); 
		query.append("							 WHERE A.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("								 AND ROWNUM = 1" ).append("\n"); 
		query.append("							 ) AS ORS_DO," ).append("\n"); 
		query.append("							 BK.SI_FLG         AS BDI_SR," ).append("\n"); 
		query.append("							 NVL(ISS.BL_RDY_FLG,'N')  AS BDI_COMPLETE," ).append("\n"); 
		query.append("							 ISS.BL_RDY_TP_CD AS BDI_TYPE," ).append("\n"); 
		query.append("							 ISS.BL_RDY_OFC_CD AS BDI_OFFICE," ).append("\n"); 
		query.append("							 ISS.BL_RDY_USR_ID AS BDI_BY," ).append("\n"); 
		query.append("							 VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD  AS VVD_CD," ).append("\n"); 
		query.append("							 (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("                                                WHERE VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1) VVD_ETD," ).append("\n"); 
		query.append("							 (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD') " ).append("\n"); 
		query.append("                                                FROM VSK_VSL_PORT_SKD SKD " ).append("\n"); 
		query.append("                                                WHERE VVD.VSL_CD = SKD.VSL_CD " ).append("\n"); 
		query.append("                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO " ).append("\n"); 
		query.append("                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD " ).append("\n"); 
		query.append("                                                AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                AND ROWNUM = 1) POD_ETA," ).append("\n"); 
		query.append("							 NVL((SELECT 'Y' from BKG_DOC_PROC_SKD WHERE BKG_NO = BK.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N'),'N') AS CNTR_CONFIRM," ).append("\n"); 
		query.append("							 BK.OB_SLS_OFC_CD  AS SALES_OFFICE," ).append("\n"); 
		query.append("							 BK.OB_SREP_CD     AS SALES_REP," ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("							/* 2009.12.28 수정 */" ).append("\n"); 
		query.append("            			    DECODE(@[sc_rfa_cd],'SC',BK.SC_NO,BK.RFA_NO) AS SC_RFA_NO, " ).append("\n"); 
		query.append("			                (SELECT FRT_TERM_CD FROM BKG_RATE WHERE BKG_NO = VVD.BKG_NO ) AS PAY_TERM_CD," ).append("\n"); 
		query.append("							ISS.OBL_ISS_RMK," ).append("\n"); 
		query.append("                            ISS.BL_PRF_SHPR_FLG BDI_CONFIRM" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("						/* Duration Option */" ).append("\n"); 
		query.append("						/* 2012.07.24수정 */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'OS')" ).append("\n"); 
		query.append("							/* OB/L Surrender*/" ).append("\n"); 
		query.append("							FROM   BKG_VVD VVD, BKG_BOOKING BK, BKG_BL_DOC DOC, BKG_BL_ISS ISS," ).append("\n"); 
		query.append("								 BKG_DOC_PROC_TP DOC_TP, BKG_DOC_PROC_SKD DOC_SKD " ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("								AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("								AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_STS_CD !='X'" ).append("\n"); 
		query.append("								AND BK.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("								AND BK.BKG_NO = DOC_SKD.BKG_NO(+)" ).append("\n"); 
		query.append("								AND DOC_SKD.BKG_DOC_PROC_TP_CD = DOC_TP.BKG_DOC_PROC_TP_CD(+)" ).append("\n"); 
		query.append("						#elseif(${dura_opt} == 'BP')" ).append("\n"); 
		query.append("							FROM   BKG_VVD VVD, BKG_BOOKING BK, BKG_BL_DOC DOC, BKG_BL_ISS ISS," ).append("\n"); 
		query.append("								 BKG_INET_BL_PRN_AUTH WEB " ).append("\n"); 
		query.append("							WHERE 1=1 " ).append("\n"); 
		query.append("								AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("								AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_STS_CD !='X'" ).append("\n"); 
		query.append("								AND BK.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("								AND BK.BKG_NO = WEB.BKG_NO(+)" ).append("\n"); 
		query.append("                                AND WEB.DELT_FLG(+) ='N'" ).append("\n"); 
		query.append("						#elseif(${dura_opt} == 'VE' || ${dura_opt} == 'VA')" ).append("\n"); 
		query.append("							FROM   BKG_VVD VVD, BKG_BOOKING BK, BKG_BL_DOC DOC, BKG_BL_ISS ISS," ).append("\n"); 
		query.append("								 VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("								AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("								AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_STS_CD !='X'" ).append("\n"); 
		query.append("								AND BK.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("								AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("								AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							FROM   BKG_VVD VVD, BKG_BOOKING BK, BKG_BL_DOC DOC, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("								AND BK.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("								AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								AND BK.BKG_STS_CD !='X'" ).append("\n"); 
		query.append("								AND BK.BKG_CGO_TP_CD !='P'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						/* On Board */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'OB')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND DOC.BL_OBRD_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND DOC.BL_OBRD_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						/* BKG Create */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'BC')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND BK.BKG_CRE_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND BK.BKG_CRE_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* B/L Issue */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'BI')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND ISS.OBL_ISS_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND ISS.OBL_ISS_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* OB/L Surrender */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'OS')" ).append("\n"); 
		query.append("								AND DOC_TP.BKG_DOC_PROC_TP_CD  = 'OBLSRD'" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND DOC_SKD.EVNT_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND DOC_SKD.EVNT_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /* web OB/L print */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'BP')								" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND WEB.N1ST_PRN_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND WEB.N1ST_PRN_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						/* OB/L Receive */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'OR')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND ISS.OBL_RDEM_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND ISS.OBL_RDEM_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end	" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						/* OB/L Receive */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'VE')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND SKD.VPS_ETD_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                    AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND SKD.VPS_ETD_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                                    AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("								#end	" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /*  VVD ETA */" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'VA')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND SKD.VPS_ETA_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                    AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND SKD.VPS_ETA_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                                    AND VVD.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("								#end	" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        /* B/L confirm*/" ).append("\n"); 
		query.append("						#if(${dura_opt} == 'CF')" ).append("\n"); 
		query.append("								#if(${dura_from_dt} != '')" ).append("\n"); 
		query.append("									AND ISS.BL_PRF_SHPR_DT >= TO_DATE(@[dura_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if(${dura_to_dt} != '')" ).append("\n"); 
		query.append("									AND ISS.BL_PRF_SHPR_DT <= TO_DATE(@[dura_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* BL_TYPE Radio 처리*/" ).append("\n"); 
		query.append("						/* Orignal */" ).append("\n"); 
		query.append("						#if(${bl_type_ori} != '')" ).append("\n"); 
		query.append("						/*ORIGINAL BL 이 데이터 이행시 NULL 로 들어가있음 */" ).append("\n"); 
		query.append("						--AND NVL(BK.BL_TP_CD,'N') ='N'" ).append("\n"); 
		query.append("						AND NVL(BK.BL_TP_CD,DECODE((SELECT MAX(N1ST_PRN_DT||N2ND_PRN_DT) " ).append("\n"); 
		query.append("                                                      FROM BKG_INET_BL_PRN_AUTH " ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                       AND DELT_FLG = 'N'),NULL,DECODE(ISS.OBL_RLSE_FLG,'Y','N','B'),'W/B')) = 'N' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						/* Waybill */" ).append("\n"); 
		query.append("						#if(${bl_type_way} != '')" ).append("\n"); 
		query.append("						/*ORIGINAL BL 이 데이터 이행시 NULL 로 들어가있음 */" ).append("\n"); 
		query.append("						AND NVL(BK.BL_TP_CD,'N') ='W' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						/* Web O/BL */" ).append("\n"); 
		query.append("						#if(${bl_type_web} != '')" ).append("\n"); 
		query.append("						/*ORIGINAL BL 이 데이터 이행시 NULL 로 들어가있음 */" ).append("\n"); 
		query.append("						AND NVL(BK.BL_TP_CD,DECODE((SELECT MAX(N1ST_PRN_DT||N2ND_PRN_DT) " ).append("\n"); 
		query.append("                                                      FROM BKG_INET_BL_PRN_AUTH " ).append("\n"); 
		query.append("                                                     WHERE BKG_NO = BK.BKG_NO " ).append("\n"); 
		query.append("                                                       AND DELT_FLG = 'N'),NULL,'N','W/B')) = 'W/B' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* VVD */" ).append("\n"); 
		query.append("						#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("						 AND VVD.VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("						 AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("						 AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						/* VVD 로 조회 하지 않을 경우 DATA 가 중복 되므로 TRUNK 만 잡아준다 */" ).append("\n"); 
		query.append("						#if (${vvd_cd} == '') " ).append("\n"); 
		query.append("							AND VVD.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						/* POL */" ).append("\n"); 
		query.append("						#if(${pol_cd} != '')" ).append("\n"); 
		query.append("						AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						 /* POD */" ).append("\n"); 
		query.append("						#if(${pod_cd} != '')" ).append("\n"); 
		query.append("						AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("						#end   " ).append("\n"); 
		query.append("						 /* POR */ " ).append("\n"); 
		query.append("						#if(${por_cd} != '')" ).append("\n"); 
		query.append("						AND BK.POR_CD = @[por_cd]" ).append("\n"); 
		query.append("						#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							/* DEL */" ).append("\n"); 
		query.append("						#if(${del_cd} != '')" ).append("\n"); 
		query.append("						AND BK.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("						#end      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							/* DEL Control Office */" ).append("\n"); 
		query.append("						#if(${del_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND BK.IB_SLS_OFC_CD = @[del_ofc_cd]" ).append("\n"); 
		query.append("						#end      " ).append("\n"); 
		query.append("							 " ).append("\n"); 
		query.append("							/* OB/L Surrender Office */" ).append("\n"); 
		query.append("						#if(${obl_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND ISS.OBL_RDEM_OFC_CD = @[obl_ofc_cd]" ).append("\n"); 
		query.append("						#end      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							/* Booking Office*/" ).append("\n"); 
		query.append("						#if(${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND BKG_OFC_CD in (${bkg_ofc_cd})" ).append("\n"); 
		query.append("						#end      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							/* Sales Office */" ).append("\n"); 
		query.append("						#if(${sal_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND BK.OB_SLS_OFC_CD = @[sal_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							/* B/L Issue Office */" ).append("\n"); 
		query.append("						#if(${bl_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND ISS.OBL_ISS_OFC_CD = @[bl_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							/* OB/L Receive Office */" ).append("\n"); 
		query.append("						#if(${obl_rcv_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND ISS.OBL_RDEM_OFC_CD = @[obl_rcv_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            /*By*/" ).append("\n"); 
		query.append("                        #if(${by_cd} == 'BS' && ${staff_id} != '')" ).append("\n"); 
		query.append("                            /* Booking Staff*/" ).append("\n"); 
		query.append("                            AND UPPER(BK.DOC_USR_ID) = UPPER(@[staff_id])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${by_cd} == 'SR' && ${staff_id} != '')" ).append("\n"); 
		query.append("                            /* SALES REP*/              " ).append("\n"); 
		query.append("                            AND UPPER(BK.OB_SREP_CD) = UPPER(@[staff_id])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${by_cd} == 'BR' && ${staff_id} != '')" ).append("\n"); 
		query.append("                            /* BL READY */" ).append("\n"); 
		query.append("                            AND UPPER(ISS.BL_RDY_USR_ID) = UPPER(@[staff_id])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${by_cd} == 'BI' && ${staff_id} != '')" ).append("\n"); 
		query.append("                            /* B/L Issue */" ).append("\n"); 
		query.append("                            AND UPPER(ISS.OBL_ISS_USR_ID) = UPPER(@[staff_id])" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${by_cd} == 'OR' && ${staff_id} != '')" ).append("\n"); 
		query.append("                            /*OBL Receive */" ).append("\n"); 
		query.append("                            AND UPPER(ISS.OBL_RDEM_USR_ID) = UPPER(@[staff_id])" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						#if( ${bkg_bl_cd} =='BKG' && ${bkg_bl_no} != '')" ).append("\n"); 
		query.append("						 /* bkg_bl_no BKG_NO.... */" ).append("\n"); 
		query.append("                          AND BK.BKG_NO = @[bkg_bl_no]" ).append("\n"); 
		query.append("						  #if (${vvd_cd} == '' && ${pol_cd} =='' && ${pod_cd} =='' )" ).append("\n"); 
		query.append("						  	AND VVD.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("						  #end	" ).append("\n"); 
		query.append("						#end    " ).append("\n"); 
		query.append("					    #if( ${bkg_bl_cd} =='BL' && ${bkg_bl_no} != '')" ).append("\n"); 
		query.append("						 /* bkg_bl_no BL_NO.... */" ).append("\n"); 
		query.append("						 AND BK.BL_NO = @[bkg_bl_no]" ).append("\n"); 
		query.append("						  #if (${vvd_cd} == '' && ${pol_cd} =='' && ${pod_cd} =='' )" ).append("\n"); 
		query.append("							 AND VVD.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("						  #end	" ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("                        #if(${dura_opt} == 'BP')" ).append("\n"); 
		query.append("                                #if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                                AND WEB.PRN_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                #if(${cust_seq} != '')" ).append("\n"); 
		query.append("                                AND WEB.PRN_CUST_SEQ =@[cust_seq]" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                            /* Customer */" ).append("\n"); 
		query.append("                             #if(${cust_tp_cd} != '' || ${cust_cnt_cd} != '' || ${cust_seq} != '' || ${cust_nm} != '')" ).append("\n"); 
		query.append("                                AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                                        FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("                                                        WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                            #if(${cust_tp_cd} != '')" ).append("\n"); 
		query.append("                                                            AND C.BKG_CUST_TP_CD = @[cust_tp_cd]" ).append("\n"); 
		query.append("                                                            #end" ).append("\n"); 
		query.append("                                                            #if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("                                                            AND C.CUST_CNT_CD =@[cust_cnt_cd]" ).append("\n"); 
		query.append("                                                            #end" ).append("\n"); 
		query.append("                                                            #if(${cust_seq} != '')" ).append("\n"); 
		query.append("                                                            AND C.CUST_SEQ =@[cust_seq]" ).append("\n"); 
		query.append("                                                            #end" ).append("\n"); 
		query.append("                                                            #if(${cust_nm} != '')" ).append("\n"); 
		query.append("                                                            AND C.CUST_NM LIKE '%'||@[cust_nm]||'%'" ).append("\n"); 
		query.append("                                                            #end" ).append("\n"); 
		query.append("                                                        ) " ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* 2009.12.28 수정 */" ).append("\n"); 
		query.append("                        /* S/C RFA NO */" ).append("\n"); 
		query.append("						#if(${sc_rfa_no} != '')" ).append("\n"); 
		query.append("                        /* B/L Surrendered */" ).append("\n"); 
		query.append("                         AND DECODE(@[sc_rfa_cd],'SC',BK.SC_NO,BK.RFA_NO) LIKE @[sc_rfa_no]||'%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                          /* B/L Status */" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'ISS')" ).append("\n"); 
		query.append("                             /*B/L Issued */" ).append("\n"); 
		query.append("                            AND NVL(ISS.OBL_ISS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'NIS')" ).append("\n"); 
		query.append("                            /*B/L Non-Issued add-wonjoocho*/" ).append("\n"); 
		query.append("                            AND NVL(ISS.OBL_ISS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("						/* B/L Released  */" ).append("\n"); 
		query.append("						#if(${bl_sts_cd} =='REL')" ).append("\n"); 
		query.append("						AND ISS.OBL_RLSE_FLG ='Y'/* 아래의 조건이 맞으나 우선 수정 */" ).append("\n"); 
		query.append("						/*AND EXISTS (SELECT 'Y'*/" ).append("\n"); 
		query.append("								    /*FROM BKG_DOC_PROC_TP TP, BKG_DOC_PROC_SKD SKD1*/" ).append("\n"); 
		query.append("									/*WHERE TP.BKG_DOC_PROC_TP_CD = SKD1.BKG_DOC_PROC_TP_CD*/" ).append("\n"); 
		query.append("									/* AND SKD1.BKG_DOC_PROC_TP_CD ='OBLREL'*/" ).append("\n"); 
		query.append("				   				    /*AND SKD1.BKG_NO = BK.BKG_NO)*/" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						#if(${bl_sts_cd} =='NRL')" ).append("\n"); 
		query.append("						AND ISS.OBL_RLSE_FLG ='N'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'SUR')" ).append("\n"); 
		query.append("                        /* B/L Surrendered */" ).append("\n"); 
		query.append("                         AND ISS.OBL_SRND_FLG ='Y'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'REC')" ).append("\n"); 
		query.append("                        /* B/L Received*/" ).append("\n"); 
		query.append("                         AND ISS.OBL_RDEM_KNT > 0" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* 2009.12.28 수정 */" ).append("\n"); 
		query.append("						#if(${bl_sts_cd} == 'PRI')" ).append("\n"); 
		query.append("                        /* B/L Printed */" ).append("\n"); 
		query.append("                         AND ISS.OBL_PRN_FLG ='Y'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("						#if(${bl_sts_cd} == 'NPR')" ).append("\n"); 
		query.append("                        /* B/L Non-Printed add-wonjoocho*/" ).append("\n"); 
		query.append("                         AND ISS.OBL_PRN_FLG ='N'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("						#if(${bl_sts_cd} == 'DCP')" ).append("\n"); 
		query.append("						/* B/L Completed */" ).append("\n"); 
		query.append("						AND ISS.BL_RDY_FLG ='Y'" ).append("\n"); 
		query.append("  						#end" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'NCP')" ).append("\n"); 
		query.append("						/* B/L Non-Completed add-wonjoocho*/" ).append("\n"); 
		query.append("						AND ISS.BL_RDY_FLG ='N'" ).append("\n"); 
		query.append("  						#end" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'CFM')" ).append("\n"); 
		query.append("						/* B/L Confirmed */" ).append("\n"); 
		query.append("						AND ISS.BL_PRF_SHPR_FLG ='Y'" ).append("\n"); 
		query.append("  						#end" ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'NCF')" ).append("\n"); 
		query.append("						/* B/L Non-confirmed */" ).append("\n"); 
		query.append("						AND ISS.BL_PRF_SHPR_FLG ='N'" ).append("\n"); 
		query.append("  						#end" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        #if(${bl_sts_cd} == 'HLD')" ).append("\n"); 
		query.append("						AND ISS.BL_HLD_FLG ='Y'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        #if(${n3pty_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND EXISTS ( SELECT 'Y' FROM BKG_N3RD_PTY_BL_BIL_RQST WHERE BK.BKG_NO = BKG_NO AND N3PTY_OFC_CD = @[n3pty_ofc_cd])" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("			  ) Y" ).append("\n"); 
		query.append("	       ) Z" ).append("\n"); 
		query.append("        GROUP BY POD_ETA, CNTR_CONFIRM, VVD_ETD, SHIPPER,FOWARDER, CONSIGNEE,PPD_ORG0,PPD_3RD0,CCT_DEST0,CCT_3RD0, BKG_NO, BL_NO, POR_CD, POL_CD, POD_CD, DEL_CD, BKG_OFC, DEL_OFC, OB_TYPE, OB_DATE, IR_BL_TYPE, IR_OFFICE, IR_DATE, IR_BY, ORS_OFFICE, ORS_DATE, ORS_NO, ORS_SURRENDER, ORS_DO, BDI_SR, BDI_COMPLETE, BDI_OFFICE, BDI_TYPE, BDI_BY, VVD_CD, SALES_OFFICE, SALES_REP,SC_RFA_NO,BL_ISSUED,BL_PRINT,BL_RELEASED,PAY_TERM_CD,OBL_ISS_RMK,BDI_CONFIRM" ).append("\n"); 
		query.append("        ORDER BY BKG_NO" ).append("\n"); 
		query.append("        ) ZZ" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append(" WHERE RNUM BETWEEN NVL(@[rows_per_page],50) * (NVL(@[curr_page],1) - 1) + 1" ).append("\n"); 
		query.append("           AND     NVL(@[rows_per_page],50) *  NVL(@[curr_page],1)" ).append("\n"); 

	}
}