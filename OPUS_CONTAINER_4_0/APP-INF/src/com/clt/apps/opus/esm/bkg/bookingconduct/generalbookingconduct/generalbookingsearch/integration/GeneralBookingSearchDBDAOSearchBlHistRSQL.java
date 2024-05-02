/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBlHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBlHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchBlHistRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBlHistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBlHistRSQL").append("\n"); 
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
		query.append("SELECT mst.his_seq" ).append("\n"); 
		query.append("		,DTL.HIS_DTL_SEQ" ).append("\n"); 
		query.append("		, (SELECT ATTR_CTNT2 " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT " ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'HIST_UI_NAME' " ).append("\n"); 
		query.append("           AND ATTR_CTNT1 = MST.BKG_HIS_ISS_UI_ID) ITEM_HDR" ).append("\n"); 
		query.append("        , DTL.HIS_CATE_NM" ).append("\n"); 
		query.append("        , CASE  WHEN REPLACE(DTL.PRE_CTNT,CHR(13),'☞') LIKE '%☞%' THEN 'View Detail'" ).append("\n"); 
		query.append("              WHEN LENGTHB(DTL.PRE_CTNT) > 200 THEN 'View Detail'" ).append("\n"); 
		query.append("              ELSE DTL.PRE_CTNT" ).append("\n"); 
		query.append("          END PRE_CTNT" ).append("\n"); 
		query.append("        , DTL.PRE_CTNT PRE_CTNT_ORG" ).append("\n"); 
		query.append("        , CASE  WHEN REPLACE(DTL.CRNT_CTNT,CHR(13),'☞') LIKE '%☞%' THEN 'View Detail'" ).append("\n"); 
		query.append("              WHEN LENGTHB(DTL.CRNT_CTNT) > 200 THEN 'View Detail'" ).append("\n"); 
		query.append("              ELSE DTL.CRNT_CTNT" ).append("\n"); 
		query.append("          END CRNT_CTNT" ).append("\n"); 
		query.append("        , DTL.CRNT_CTNT CRNT_CTNT_ORG" ).append("\n"); 
		query.append("        , NVL(USR.USR_NM, MST.CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("        , (SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(MST.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 ) OFFICE" ).append("\n"); 
		query.append("        , TO_CHAR(DECODE(DTL.HIS_CATE_NM,'EXPORT INFORMATION-USA',DTL.UPD_DT,MST.EVNT_DT), 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("--		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BKG_COM_USER_LOC_FNC(MST.CRE_USR_ID), DECODE(DTL.HIS_CATE_NM,'EXPORT INFORMATION-USA',DTL.UPD_DT,MST.EVNT_DT), 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DT" ).append("\n"); 
		query.append("--        Batch call AutoratingTaxCalculate Hard Coding 'TAXBATCH'" ).append("\n"); 
		query.append("		, CASE WHEN MST.CRE_USR_ID='TAXBATCH' THEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', DECODE(DTL.HIS_CATE_NM,'EXPORT INFORMATION-USA',DTL.UPD_DT,MST.EVNT_DT), 'GMT'), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("		  ELSE TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(BKG_COM_USER_LOC_FNC(MST.CRE_USR_ID), DECODE(DTL.HIS_CATE_NM,'EXPORT INFORMATION-USA',DTL.UPD_DT,MST.EVNT_DT), 'GMT'), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("		  END GMT_DT" ).append("\n"); 
		query.append("		, MST.CORR_NO" ).append("\n"); 
		query.append("  FROM BKG_HIS_MST MST" ).append("\n"); 
		query.append("     , BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("     , COM_USER USR" ).append("\n"); 
		query.append(" WHERE MST.BKG_NO  = DTL.BKG_NO" ).append("\n"); 
		query.append("   AND MST.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("   AND UPPER(MST.CRE_USR_ID) = UPPER(USR.USR_ID(+))" ).append("\n"); 
		query.append("   AND MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND NVL(MST.CORR_NO, 'X') <> 'TMP0000001'" ).append("\n"); 
		query.append("   AND UPPER(NVL(DTL.CRNT_CTNT,'TMP')) NOT IN ('SEE CUSTOMER INFORMATION TAB', 'SEE FREIGHT & CHARGE TAB')" ).append("\n"); 
		query.append(" --ORDER BY MST.HIS_SEQ, HIS_DTL_SEQ" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  (SELECT MAX(MST.HIS_SEQ)+1 FROM BKG_HIS_MST MST WHERE MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND NVL(MST.CORR_NO, 'X') <> 'TMP0000001' " ).append("\n"); 
		query.append("                                 AND MST.EVNT_DT < TO_DATE(DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_DT,T.MF_SND_DT),'YYYY-MM-DD HH24:MI')) AS his_seq " ).append("\n"); 
		query.append(",	    0  as HIS_DTL_SEQ" ).append("\n"); 
		query.append(",	    DECODE(SUBSTR(T.PORT,0,2),'US','USAMS','CA','Canada ACI',T.PORT)	AS ITEM_HDR" ).append("\n"); 
		query.append(",       T.PORT_NM AS HIS_CATE_NM" ).append("\n"); 
		query.append(",	    '' PRE_CTNT" ).append("\n"); 
		query.append(",	    '' PRE_CTNT_ORG" ).append("\n"); 
		query.append("--,       DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_FLAG,T.CUST_STATUS) AS CRNT_CTNT" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_FLAG,NVL(T.CUST_STATUS_NM,'Manifest Transmit')) AS CRNT_CTNT" ).append("\n"); 
		query.append(",	    '' CRNT_CTNT_ORG" ).append("\n"); 
		query.append(",		NVL((SELECT USR.USR_NM  " ).append("\n"); 
		query.append("               FROM COM_USER USR " ).append("\n"); 
		query.append("              WHERE UPPER(USR.USR_ID) = UPPER(DECODE(XDT.BY_SEQ, 1, T.DOWN_USR_ID, T.SEND_USER_ID))" ).append("\n"); 
		query.append("                AND NVL(USE_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                AND ROWNUM = 1),DECODE(XDT.BY_SEQ, 1, T.DOWN_USR_ID, T.SEND_USER_ID))  CRE_USR_ID" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ, 1, T.DOWN_OFC_NM, T.SEND_OFC_NM) AS OFC_NM" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_DT,T.MF_SND_DT) AS MF_SND_DT" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.GMT_DOWNLOAD_DT,T.GMT_MF_SND_DT) AS GMT_DT" ).append("\n"); 
		query.append(",       ''  CORR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  ( " ).append("\n"); 
		query.append("SELECT CS.CSTMS_PORT_CD AS PORT" ).append("\n"); 
		query.append("      ,(SELECT M.LOC_NM" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION M" ).append("\n"); 
		query.append("        WHERE  M.LOC_CD = CS.CSTMS_PORT_CD) PORT_NM" ).append("\n"); 
		query.append("      ,DECODE(IF_DT,NULL,'','DownLoad') DOWNLOAD_FLAG" ).append("\n"); 
		query.append("      --,TO_CHAR(IF_DT, 'YYYY-MM-DD HH24:MI') DOWNLOAD_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(IF_DT, 'YYYY-MM-DD HH24:MI') DOWNLOAD_DT" ).append("\n"); 
		query.append("  	  ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',IF_DT, 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DOWNLOAD_DT" ).append("\n"); 
		query.append("      ,CS.CSTMS_MF_TP_CD CUST_STATUS" ).append("\n"); 
		query.append("      ,(SELECT B.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("        WHERE  INTG_CD_ID = 'CD02235' AND" ).append("\n"); 
		query.append("               B.INTG_CD_VAL_CTNT = CS.CSTMS_MF_TP_CD) CUST_STATUS_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(CS.CSTMS_MF_TP_CD,'MI',CS.MF_SND_DT,CS.AMDT_SND_DT),'YYYY-MM-DD HH24:MI') MF_SND_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',DECODE(CS.CSTMS_MF_TP_CD,'MI',CS.MF_SND_DT,CS.AMDT_SND_DT), 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_MF_SND_DT " ).append("\n"); 
		query.append("      ,CS.CRE_USR_ID AS DOWN_USR_ID" ).append("\n"); 
		query.append("      ,U.CRE_USR_ID AS SEND_USER_ID" ).append("\n"); 
		query.append("      ,(SELECT OFC.OFC_CD FROM COM_USER OFC WHERE OFC.USR_ID = CS.CRE_USR_ID) AS DOWN_OFC_NM" ).append("\n"); 
		query.append("      ,(SELECT OFC.OFC_CD FROM COM_USER OFC WHERE OFC.USR_ID = U.CRE_USR_ID) AS SEND_OFC_NM" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_BL CS," ).append("\n"); 
		query.append("	   ( SELECT DISTINCT L.CNT_CD," ).append("\n"); 
		query.append("						 L.SND_DT AS SND_DATE," ).append("\n"); 
		query.append("						 L.TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("						 L.SND_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("						 L.SND_USR_OFC_CD OFC_CD," ).append("\n"); 
		query.append("						 E.BL_NO" ).append("\n"); 
		query.append("		 FROM BKG_CSTMS_ADV_SND_LOG L," ).append("\n"); 
		query.append("			  BKG_CSTMS_ADV_EDI_BL_RSPN E" ).append("\n"); 
		query.append("		 WHERE 1=1" ).append("\n"); 
		query.append("		   AND L.CNT_CD = E.CNT_CD(+)" ).append("\n"); 
		query.append("		   AND L.CRR_BAT_NO = E.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("		   AND L.IO_BND_CD ='I'" ).append("\n"); 
		query.append("		   AND E.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("		   AND L.SND_DT IN (SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("							FROM BKG_CSTMS_ADV_SND_LOG L," ).append("\n"); 
		query.append("								 BKG_CSTMS_ADV_EDI_BL_RSPN E" ).append("\n"); 
		query.append("						    WHERE L.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("							  AND L.CNT_CD = E.CNT_CD(+)" ).append("\n"); 
		query.append("							  AND L.CRR_BAT_NO = E.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("							  AND E.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("						    )" ).append("\n"); 
		query.append("		) U" ).append("\n"); 
		query.append("WHERE  CS.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("  AND  CS.BL_NO = U.BL_NO" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(",(SELECT ROWNUM BY_SEQ" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= 2) XDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  999999  AS HIS_SEQ," ).append("\n"); 
		query.append("     1  as HIS_DTL_SEQ," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        'WEB B/L' ITEM_HDR," ).append("\n"); 
		query.append("        'INTERNET AUTH' HIS_CATE_NM," ).append("\n"); 
		query.append("        '' PRE_CTNT, " ).append("\n"); 
		query.append("        '' PRE_CTNT_ORG, " ).append("\n"); 
		query.append("        'AUTHORIZED' CRNT_CTNT," ).append("\n"); 
		query.append("        'AUTHORIZED' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("        AUTH_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("        AUTH_OFC_CD OFFICE," ).append("\n"); 
		query.append("        TO_CHAR(AUTH_DT,'YYYY-MM-DD HH24:MI') CRE_DT, " ).append("\n"); 
		query.append("        NULL GMT_DT," ).append("\n"); 
		query.append("        '' CORR_NO" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND AUTH_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("AND AUTH_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND AUTH_DT IS NOT NULL" ).append("\n"); 
		query.append("AND PRN_CUST_TP_CD <> 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  DISTINCT 999999 AS HIS_SEQ," ).append("\n"); 
		query.append("     1  as HIS_DTL_SEQ," ).append("\n"); 
		query.append("        'WEB B/L' ITEM_HDR," ).append("\n"); 
		query.append("        'CANCEL AUTH' HIS_CATE_NM," ).append("\n"); 
		query.append("        '' PRE_CTNT, " ).append("\n"); 
		query.append("        '' PRE_CTNT_ORG, " ).append("\n"); 
		query.append("        'CANCELED' CRNT_CTNT," ).append("\n"); 
		query.append("        'CANCELED' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("        DELT_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("        DELT_OFC_CD OFFICE," ).append("\n"); 
		query.append("        TO_CHAR(DELT_DT,'YYYY-MM-DD HH24:MI') CRE_DT, " ).append("\n"); 
		query.append("        NULL GMT_DT," ).append("\n"); 
		query.append("        '' CORR_NO" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("AND PRN_CUST_TP_CD <> 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  999999  AS HIS_SEQ," ).append("\n"); 
		query.append("     1  as HIS_DTL_SEQ," ).append("\n"); 
		query.append("        'WEB B/L' ITEM_HDR," ).append("\n"); 
		query.append("        'WEB B/L PRINT' HIS_CATE_NM," ).append("\n"); 
		query.append("        '' PRE_CTNT, " ).append("\n"); 
		query.append("        '' PRE_CTNT_ORG, " ).append("\n"); 
		query.append("        'Print-1ST' CRNT_CTNT," ).append("\n"); 
		query.append("        'Print-1ST' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("        PRN_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("        '' OFFICE," ).append("\n"); 
		query.append("        TO_CHAR(N1ST_PRN_DT,'YYYY-MM-DD HH24:MI') CRE_DT, " ).append("\n"); 
		query.append("        NULL GMT_DT," ).append("\n"); 
		query.append("        '' CORR_NO" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND N1ST_PRN_DT IS NOT NULL" ).append("\n"); 
		query.append("AND PRN_CUST_TP_CD <> 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  999999  AS HIS_SEQ," ).append("\n"); 
		query.append("     1  as HIS_DTL_SEQ," ).append("\n"); 
		query.append("        'WEB B/L' ITEM_HDR," ).append("\n"); 
		query.append("        'WEB B/L PRINT' HIS_CATE_NM," ).append("\n"); 
		query.append("        '' PRE_CTNT, " ).append("\n"); 
		query.append("        '' PRE_CTNT_ORG, " ).append("\n"); 
		query.append("        'Print-2nd' CRNT_CTNT," ).append("\n"); 
		query.append("        'Print-2nd' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("        PRN_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("        '' OFFICE," ).append("\n"); 
		query.append("        TO_CHAR(N2ND_PRN_DT,'YYYY-MM-DD HH24:MI') CRE_DT, " ).append("\n"); 
		query.append("        NULL GMT_DT," ).append("\n"); 
		query.append("        '' CORR_NO" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND N2ND_PRN_DT IS NOT NULL" ).append("\n"); 
		query.append("AND PRN_CUST_TP_CD <> 'O'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  999999  AS HIS_SEQ," ).append("\n"); 
		query.append("     1  as HIS_DTL_SEQ," ).append("\n"); 
		query.append("        'WEB B/L' ITEM_HDR," ).append("\n"); 
		query.append("        'SWB B/L PRINT' HIS_CATE_NM," ).append("\n"); 
		query.append("        '' PRE_CTNT, " ).append("\n"); 
		query.append("        '' PRE_CTNT_ORG, " ).append("\n"); 
		query.append("        'SWB PRINTED' CRNT_CTNT," ).append("\n"); 
		query.append("        'SWB PRINTED' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("        PRN_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("        '' OFFICE," ).append("\n"); 
		query.append("        TO_CHAR(WBL_PRN_DT,'YYYY-MM-DD HH24:MI') CRE_DT, " ).append("\n"); 
		query.append("        NULL GMT_DT," ).append("\n"); 
		query.append("        '' CORR_NO" ).append("\n"); 
		query.append("FROM BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND PRN_CUST_TP_CD ='W'" ).append("\n"); 
		query.append("AND WBL_PRN_DT IS NOT NULL " ).append("\n"); 
		query.append("ORDER BY HIS_SEQ, HIS_DTL_SEQ, CRE_DT -- web내역 순서 조정을 위한 추가" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--ORDER BY   T.PORT,XDT.BY_SEQ" ).append("\n"); 

	}
}