/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBlHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 2011.02.14 이일민 [SRM-201113338] [BKG main history 상 ENS 전송 history 표기]
	  * 2011.02.14 이일민 [SRM-201113375] MI 전송시 bkg history상에 Local 시간 조회 기능 보완
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("        , CASE  " ).append("\n"); 
		query.append("              WHEN LENGTHB(DTL.PRE_CTNT) > 200 THEN 'View Detail'" ).append("\n"); 
		query.append("              ELSE DTL.PRE_CTNT" ).append("\n"); 
		query.append("          END PRE_CTNT" ).append("\n"); 
		query.append("        , DTL.PRE_CTNT PRE_CTNT_ORG" ).append("\n"); 
		query.append("        , CASE  " ).append("\n"); 
		query.append("              WHEN LENGTHB(DTL.CRNT_CTNT) > 200 THEN 'View Detail'" ).append("\n"); 
		query.append("              ELSE DTL.CRNT_CTNT" ).append("\n"); 
		query.append("          END CRNT_CTNT" ).append("\n"); 
		query.append("        , DTL.CRNT_CTNT CRNT_CTNT_ORG" ).append("\n"); 
		query.append("		--CUP I/F의 경우 CRE_USR_ID가 WEB, UPD_USR_ID가  WEB USER ID가 입력됨" ).append("\n"); 
		query.append("        , DECODE(DTL.CRE_USR_ID, 'WEB', DTL.UPD_USR_ID, 'BATCH', DTL.UPD_USR_ID, USR.USR_NM) CRE_USR_ID" ).append("\n"); 
		query.append("        , NVL(MST.CRE_OFC_CD,(SELECT OFC_CD FROM COM_USER WHERE UPPER(USR_ID) = UPPER(MST.CRE_USR_ID) AND USE_FLG = 'Y' AND ROWNUM = 1 )) OFFICE" ).append("\n"); 
		query.append("        , TO_CHAR(DECODE(DTL.HIS_CATE_NM,'EXPORT INFORMATION-USA',DTL.UPD_DT,MST.EVNT_DT), 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("		, TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(NVL(BKG_COM_USER_LOC_FNC(MST.CRE_USR_ID),(SELECT POR_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])), DECODE(DTL.HIS_CATE_NM,'EXPORT INFORMATION-USA',DTL.UPD_DT,MST.EVNT_DT), 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DT" ).append("\n"); 
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
		query.append("SELECT NVL((SELECT /*+ index_desc(his XPKBKG_HIS_MST)*/" ).append("\n"); 
		query.append("                   HIS_SEQ" ).append("\n"); 
		query.append("              FROM BKG_HIS_MST HIS" ).append("\n"); 
		query.append("             WHERE HIS.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("               AND HIS.CRE_DT < TO_DATE(T.MF_SND_DT,'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("               AND ROWNUM = 1), 0) + 1 AS HIS_SEQ" ).append("\n"); 
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
		query.append("  from  (select CS.CSTMS_PORT_CD AS PORT" ).append("\n"); 
		query.append("              ,(SELECT M.LOC_NM" ).append("\n"); 
		query.append("                FROM   MDM_LOCATION M" ).append("\n"); 
		query.append("                WHERE  M.LOC_CD = CS.CSTMS_PORT_CD) PORT_NM" ).append("\n"); 
		query.append("              ,DECODE(IF_DT,NULL,'','DownLoad') DOWNLOAD_FLAG" ).append("\n"); 
		query.append("              ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',CS.CRE_DT,(SELECT LOC_CD " ).append("\n"); 
		query.append("                                                                         FROM COM_USER USR" ).append("\n"); 
		query.append("                                                                             ,MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("                                                                        WHERE USR.USR_ID = CS.CRE_USR_ID" ).append("\n"); 
		query.append("                                                                          AND USR.OFC_CD = ORG.OFC_CD)), 'YYYY-MM-DD HH24:MI') DOWNLOAD_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',CS.CRE_DT, 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DOWNLOAD_DT" ).append("\n"); 
		query.append("              ,CS.CSTMS_MF_TP_CD CUST_STATUS" ).append("\n"); 
		query.append("              ,(SELECT B.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("                FROM   COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("                WHERE  INTG_CD_ID = 'CD02235' AND" ).append("\n"); 
		query.append("                       B.INTG_CD_VAL_CTNT = CS.CSTMS_MF_TP_CD) CUST_STATUS_NM" ).append("\n"); 
		query.append("              ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',CASE WHEN CS.CNT_CD = 'US' THEN DECODE(CS.CSTMS_MF_TP_CD,'MI',CS.MF_SND_DT,CS.AMDT_SND_DT)" ).append("\n"); 
		query.append("                                                                 WHEN CS.CNT_CD = 'CA' THEN NVL(CS.AMDT_SND_DT,CS.MF_SND_DT)" ).append("\n"); 
		query.append("                                                            END ,SEND_LOC_CD),'YYYY-MM-DD HH24:MI') MF_SND_DT" ).append("\n"); 
		query.append("              ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',CASE WHEN CS.CNT_CD = 'US' THEN DECODE(CS.CSTMS_MF_TP_CD,'MI',CS.MF_SND_DT,CS.AMDT_SND_DT)" ).append("\n"); 
		query.append("                                                                 WHEN CS.CNT_CD = 'CA' THEN NVL(CS.AMDT_SND_DT,CS.MF_SND_DT)" ).append("\n"); 
		query.append("                                                            END, 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_MF_SND_DT " ).append("\n"); 
		query.append("              ,CS.CRE_USR_ID AS DOWN_USR_ID" ).append("\n"); 
		query.append("              ,U.SND_USR_ID AS SEND_USER_ID" ).append("\n"); 
		query.append("              ,(SELECT OFC.OFC_CD FROM COM_USER OFC WHERE OFC.USR_ID = CS.CRE_USR_ID) AS DOWN_OFC_NM" ).append("\n"); 
		query.append("              ,(SELECT OFC.OFC_CD FROM COM_USER OFC WHERE OFC.USR_ID = U.SND_USR_ID) AS SEND_OFC_NM" ).append("\n"); 
		query.append("        from (select *" ).append("\n"); 
		query.append("                from (  select L.CNT_CD" ).append("\n"); 
		query.append("                              ,L.SND_USR_ID" ).append("\n"); 
		query.append("                              ,L.SND_DT" ).append("\n"); 
		query.append("                              ,ORG.LOC_CD AS SEND_LOC_CD" ).append("\n"); 
		query.append("                              ,MAX(L.SND_DT) OVER (PARTITION BY L.CNT_CD) AS MAX_SND_DT" ).append("\n"); 
		query.append("                              ,E.BL_NO" ).append("\n"); 
		query.append("                          from BKG_CSTMS_ADV_SND_LOG L," ).append("\n"); 
		query.append("                               BKG_CSTMS_ADV_EDI_BL_RSPN E," ).append("\n"); 
		query.append("                               COM_USER USR," ).append("\n"); 
		query.append("                               MDM_ORGANIZATION ORG " ).append("\n"); 
		query.append("                         where 1 = 1" ).append("\n"); 
		query.append("                           and L.CNT_CD = E.CNT_CD(+)" ).append("\n"); 
		query.append("                           AND L.CRR_BAT_NO = E.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("                           AND L.IO_BND_CD ='I'" ).append("\n"); 
		query.append("                           AND E.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                           AND USR.USR_ID = L.SND_USR_ID" ).append("\n"); 
		query.append("                           AND USR.OFC_CD = ORG.OFC_CD  ) " ).append("\n"); 
		query.append("               where SND_DT = MAX_SND_DT                       ) U" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_BL CS  " ).append("\n"); 
		query.append("        where CS.BL_NO = U.BL_NO (+)" ).append("\n"); 
		query.append("          and CS.CNT_CD = U.CNT_CD (+)" ).append("\n"); 
		query.append("          and CS.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) ) T" ).append("\n"); 
		query.append("        ,(SELECT ROWNUM BY_SEQ" ).append("\n"); 
		query.append("                FROM   DUAL" ).append("\n"); 
		query.append("                CONNECT BY LEVEL <= 2) XDT      " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*" ).append("\n"); 
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
		query.append("WHERE BKG_NO = [bkg_no]" ).append("\n"); 
		query.append("AND AUTH_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("AND AUTH_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND AUTH_DT IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY AUTH_USR_ID, AUTH_OFC_CD,AUTH_DT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  999999 AS HIS_SEQ," ).append("\n"); 
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
		query.append("WHERE BKG_NO = [bkg_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY DELT_USR_ID, DELT_OFC_CD,DELT_DT" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
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
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL((SELECT /*+ index_desc(his XPKBKG_HIS_MST)*/" ).append("\n"); 
		query.append("                   HIS_SEQ" ).append("\n"); 
		query.append("              FROM BKG_HIS_MST HIS" ).append("\n"); 
		query.append("             WHERE HIS.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("               AND HIS.CRE_DT < ENS.CRE_DT " ).append("\n"); 
		query.append("               AND ROWNUM = 1), 0) + 1 AS HIS_SEQ," ).append("\n"); 
		query.append("       0 HIS_SEQ_DTL," ).append("\n"); 
		query.append("       'EU ENS' AS ITEM_HDR," ).append("\n"); 
		query.append("       CSTMS_PORT_CD || ' (POFE)' AS HIS_CATE_NM," ).append("\n"); 
		query.append("       '' PRE_CTNT," ).append("\n"); 
		query.append("       '' PRE_CTNT_ORG," ).append("\n"); 
		query.append("       'Manifest Transmit (' || ENS.VSL_CD || ENS.SKD_VOY_NO || ENS.SKD_DIR_CD || ')' CRNT_CTNT," ).append("\n"); 
		query.append("       'Manifest Transmit (' || ENS.VSL_CD || ENS.SKD_VOY_NO || ENS.SKD_DIR_CD || ')' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("       ENS.CRE_USR_ID," ).append("\n"); 
		query.append("       ENS.SND_USR_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR (ENS.SND_DT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       TO_CHAR (ENS.SND_GDT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       '' CORR_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_EUR_SND ENS" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BL_NO = ENS.BL_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       NVL((SELECT /*+ index_desc(his XPKBKG_HIS_MST)*/" ).append("\n"); 
		query.append("                   HIS_SEQ" ).append("\n"); 
		query.append("              FROM BKG_HIS_MST HIS" ).append("\n"); 
		query.append("             WHERE HIS.BKG_NO = BKG.BKG_NO " ).append("\n"); 
		query.append("               AND HIS.CRE_DT < SND.CRE_DT " ).append("\n"); 
		query.append("               AND ROWNUM = 1), 0) + 1 AS HIS_SEQ," ).append("\n"); 
		query.append("       0 HIS_SEQ_DTL," ).append("\n"); 
		query.append("       'CCAM('|| DECODE(SND.CHN_MF_SND_IND_CD, 'D', 'I/B' , 'R', 'I/B', 'O/B') || ')' AS ITEM_HDR," ).append("\n"); 
		query.append("       'Manifest Transmit'  AS HIS_CATE_NM," ).append("\n"); 
		query.append("       '' PRE_CTNT," ).append("\n"); 
		query.append("       '' PRE_CTNT_ORG," ).append("\n"); 
		query.append("       'Manifest Transmit (' || SND.VSL_CD || SND.SKD_VOY_NO || SND.SKD_DIR_CD || ')' CRNT_CTNT," ).append("\n"); 
		query.append("       'Manifest Transmit (' || SND.VSL_CD || SND.SKD_VOY_NO || SND.SKD_DIR_CD || ')' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("       SND.MF_SND_USR_ID," ).append("\n"); 
		query.append("       SND.MF_SND_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR (SND.MF_SND_DT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       TO_CHAR (SND.MF_SND_GDT, 'YYYY-MM-DD HH24:MI')," ).append("\n"); 
		query.append("       '' CORR_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_SND_LOG_BL BL," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_SND_LOG SND" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BL_NO = BL.BL_NO" ).append("\n"); 
		query.append("   AND BL.EDI_REF_ID = SND.EDI_REF_ID" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL((SELECT /*+ index_desc(his XPKBKG_HIS_MST)*/" ).append("\n"); 
		query.append("                   HIS_SEQ" ).append("\n"); 
		query.append("              FROM BKG_HIS_MST HIS" ).append("\n"); 
		query.append("             WHERE HIS.BKG_NO = NTC.BKG_NO " ).append("\n"); 
		query.append("               AND HIS.CRE_DT < NTC.CRE_DT " ).append("\n"); 
		query.append("               AND ROWNUM = 1), 0) + 1 AS HIS_SEQ," ).append("\n"); 
		query.append("       0 HIS_DTL_SEQ," ).append("\n"); 
		query.append("       'Mexico' AS ITEM_HDR," ).append("\n"); 
		query.append("       'Manifest Transmit' AS HIS_CATE_NM," ).append("\n"); 
		query.append("       '' PRE_CTNT," ).append("\n"); 
		query.append("       '' PRE_CTNT_ORG," ).append("\n"); 
		query.append("       'Manifest Transmit(' || NTC.DIFF_RMK || ')' CRNT_CTNT," ).append("\n"); 
		query.append("       'Manifest Transmit(' || NTC.DIFF_RMK || ')' CRNT_CTNT_ORG," ).append("\n"); 
		query.append("       NTC.CRE_USR_ID," ).append("\n"); 
		query.append("       NTC.SND_OFC_CD," ).append("\n"); 
		query.append("       TO_CHAR (NTC.SND_DT, 'YYYY-MM-DD HH24:MI') CRE_DT," ).append("\n"); 
		query.append("       TO_CHAR (NTC.SND_GDT, 'YYYY-MM-DD HH24:MI') CRE_GDT," ).append("\n"); 
		query.append("       '' CORR_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("   AND NTC.NTC_KND_CD= 'IM'" ).append("\n"); 
		query.append("   AND NTC.EDI_ID = 'MEXCUS'" ).append("\n"); 
		query.append("ORDER BY 1, 2, 11 -- web내역 순서 조정을 위한 추가, HIS_SEQ->HIS_DTL_SEQ->CRE_DT" ).append("\n"); 

	}
}