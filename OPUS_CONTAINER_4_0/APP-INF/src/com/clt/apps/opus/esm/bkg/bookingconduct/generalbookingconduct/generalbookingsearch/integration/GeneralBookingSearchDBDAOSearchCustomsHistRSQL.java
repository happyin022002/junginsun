/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCustomsHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
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

public class GeneralBookingSearchDBDAOSearchCustomsHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchCustomsHistRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCustomsHistRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOSearchCustomsHistRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(SUBSTR(T.PORT,0,2),'US','USAMS','CA','Canada AIC',T.PORT) AS PORT" ).append("\n"); 
		query.append(",       T.PORT_NM" ).append("\n"); 
		query.append(",       XDT.BY_SEQ" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_FLAG,T.CUST_STATUS) AS CUST_STATUS" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_FLAG,NVL(T.CUST_STATUS_NM,'Manifest Transmit')) AS CUST_STATUS_NM" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.DOWNLOAD_DT,T.MF_SND_DT) AS MF_SND_DT" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ,1,T.GMT_DOWNLOAD_DT,T.GMT_MF_SND_DT) AS GMT_DT" ).append("\n"); 
		query.append(",		NVL((SELECT USR.USR_NM  " ).append("\n"); 
		query.append("               FROM COM_USER USR " ).append("\n"); 
		query.append("              WHERE UPPER(USR.USR_ID) = UPPER(DECODE(XDT.BY_SEQ, 1, T.DOWN_USR_ID, T.SEND_USER_ID))" ).append("\n"); 
		query.append("                AND NVL(USE_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("                AND ROWNUM = 1),DECODE(XDT.BY_SEQ, 1, T.DOWN_USR_ID, T.SEND_USER_ID))  CRE_USR_ID" ).append("\n"); 
		query.append(",       DECODE(XDT.BY_SEQ, 1, T.DOWN_OFC_NM, T.SEND_OFC_NM) AS OFC_NM" ).append("\n"); 
		query.append("FROM  ( " ).append("\n"); 
		query.append("SELECT CS.CSTMS_PORT_CD AS PORT" ).append("\n"); 
		query.append("      ,(SELECT M.LOC_NM" ).append("\n"); 
		query.append("        FROM   MDM_LOCATION M" ).append("\n"); 
		query.append("        WHERE  M.LOC_CD = CS.CSTMS_PORT_CD) PORT_NM" ).append("\n"); 
		query.append("      ,DECODE(IF_DT,NULL,'','DownLoad') DOWNLOAD_FLAG" ).append("\n"); 
		query.append("      ,TO_CHAR(IF_DT, 'YYYY-MM-DD HH24:MI') DOWNLOAD_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',IF_DT, 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_DOWNLOAD_DT" ).append("\n"); 
		query.append("      ,CS.CSTMS_MF_TP_CD CUST_STATUS" ).append("\n"); 
		query.append("      ,(SELECT B.INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("        FROM   COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("        WHERE  INTG_CD_ID = 'CD02235' AND" ).append("\n"); 
		query.append("               B.INTG_CD_VAL_CTNT = CS.CSTMS_MF_TP_CD) CUST_STATUS_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(DECODE(CS.CSTMS_MF_TP_CD,'MI',CS.MF_SND_DT,CS.AMDT_SND_DT),'YYYY-MM-DD HH24:MI') MF_SND_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',DECODE(CS.CSTMS_MF_TP_CD,'MI',CS.MF_SND_DT,CS.AMDT_SND_DT), 'GMT'), 'YYYY-MM-DD HH24:MI') GMT_MF_SND_DT" ).append("\n"); 
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
		query.append("		   AND E.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		   AND L.SND_DT IN (SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("							FROM BKG_CSTMS_ADV_SND_LOG L," ).append("\n"); 
		query.append("								 BKG_CSTMS_ADV_EDI_BL_RSPN E" ).append("\n"); 
		query.append("						    WHERE L.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("							  AND L.CNT_CD = E.CNT_CD(+)" ).append("\n"); 
		query.append("							  AND L.CRR_BAT_NO = E.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("							  AND E.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("						    )" ).append("\n"); 
		query.append("		) U" ).append("\n"); 
		query.append("WHERE  CS.BL_NO = (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("  AND  CS.BL_NO = U.BL_NO" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append(",(SELECT ROWNUM BY_SEQ" ).append("\n"); 
		query.append("        FROM   DUAL" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= 2) XDT" ).append("\n"); 
		query.append("ORDER BY   T.PORT,XDT.BY_SEQ" ).append("\n"); 

	}
}