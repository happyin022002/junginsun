/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchNoticeHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
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

public class GeneralBookingSearchDBDAOSearchNoticeHistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchNoticeHistRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchNoticeHistRSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAOSearchNoticeHistRSQL").append("\n"); 
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
		query.append("SELECT  ORD.KIND AS KIND" ).append("\n"); 
		query.append("        ,(SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01552' " ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = ORD.KIND) ITEM" ).append("\n"); 
		query.append("        , FROM1 FRM_A" ).append("\n"); 
		query.append("        , FROM2 FRM_B" ).append("\n"); 
		query.append("        , TO1 TO_A" ).append("\n"); 
		query.append("        , TO2 TO_B" ).append("\n"); 
		query.append("        , VIA" ).append("\n"); 
		query.append("        , TO_CHAR(SEND.SEND_DT, 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("        , USR_NM CRE_USR_ID" ).append("\n"); 
		query.append("        , OFFICE " ).append("\n"); 
		query.append("  FROM  ( SELECT 'BR' KIND" ).append("\n"); 
		query.append("		         , MST.XTER_SNDR_ID FROM1" ).append("\n"); 
		query.append("	    	     , '' FROM2" ).append("\n"); 
		query.append("		         , NULL TO1" ).append("\n"); 
		query.append("	    	     , NULL TO2" ).append("\n"); 
		query.append("	        	 , BK.XTER_BKG_RQST_CD VIA" ).append("\n"); 
		query.append("		         , MST.RQST_DT          SEND_DT" ).append("\n"); 
		query.append("	    	     , NULL USR_NM" ).append("\n"); 
		query.append("	        	 , NULL OFFICE" ).append("\n"); 
		query.append(" 		    FROM BKG_BOOKING BK, BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append(" 		   WHERE BK.BKG_NO     = MST.BKG_NO" ).append("\n"); 
		query.append("    		 AND BK.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("			 AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("	    	 AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("         UNION " ).append("\n"); 
		query.append("         SELECT 'SI' KIND" ).append("\n"); 
		query.append("                 , MST.XTER_SNDR_ID FROM1" ).append("\n"); 
		query.append("    	     	 , '' FROM2" ).append("\n"); 
		query.append("                 , NULL TO1" ).append("\n"); 
		query.append("                 , NULL TO2" ).append("\n"); 
		query.append("                 , BK.XTER_SI_CD VIA" ).append("\n"); 
		query.append("                 , MST.RQST_DT    SEND_DT" ).append("\n"); 
		query.append("                 , NULL USR_NM" ).append("\n"); 
		query.append("                 , NULL OFFICE" ).append("\n"); 
		query.append("           FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("              , BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("          WHERE BK.BKG_NO       = MST.BKG_NO" ).append("\n"); 
		query.append("            AND BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("			 AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("            AND MST.DOC_TP_CD   = 'S'" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("         SELECT 'IB' KIND" ).append("\n"); 
		query.append("                 , '' FROM1" ).append("\n"); 
		query.append("                 , '' FROM2" ).append("\n"); 
		query.append("                 , NULL TO1" ).append("\n"); 
		query.append("                 , NULL TO2" ).append("\n"); 
		query.append("                 , 'PRINT' VIA" ).append("\n"); 
		query.append("                 , N1ST_PRN_DT SEND_DT" ).append("\n"); 
		query.append("                 , UPD_USR_ID USR_NM" ).append("\n"); 
		query.append("                 , '' OFFICE" ).append("\n"); 
		query.append("           FROM BKG_INET_BL_PRN_AUTH INET" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND N1ST_PRN_DT IS NOT NULL" ).append("\n"); 
		query.append("         UNION  " ).append("\n"); 
		query.append("         SELECT NTC_KND_CD KIND" ).append("\n"); 
		query.append("                 , CASE WHEN NTC_VIA_CD = 'T' THEN " ).append("\n"); 
		query.append("                          CASE WHEN SUBSTR((SELECT SUBSTR(FTP_DIR_CTNT,INSTR(FTP_DIR_CTNT, '/', -1, 1)) " ).append("\n"); 
		query.append("                                            FROM COM_FTP_SND_INFO " ).append("\n"); 
		query.append("                                            WHERE FTP_SND_NO = NTC.SND_ID),0,1) = '/' " ).append("\n"); 
		query.append("                                  THEN SUBSTR((SELECT SUBSTR(FTP_DIR_CTNT,INSTR(FTP_DIR_CTNT, '/', -1, 1)) " ).append("\n"); 
		query.append("                                               FROM COM_FTP_SND_INFO " ).append("\n"); 
		query.append("                                               WHERE FTP_SND_NO = NTC.SND_ID) , 2)" ).append("\n"); 
		query.append("                          ELSE (SELECT SUBSTR(FTP_DIR_CTNT,INSTR(FTP_DIR_CTNT, '/', -1, 1)) " ).append("\n"); 
		query.append("                                FROM COM_FTP_SND_INFO " ).append("\n"); 
		query.append("                                WHERE FTP_SND_NO = NTC.SND_ID)" ).append("\n"); 
		query.append("                          END  " ).append("\n"); 
		query.append("                        WHEN NTC_VIA_CD = 'M' AND (NTC_KND_CD = 'TE' OR NTC_KND_CD = 'TU') THEN DIFF_RMK" ).append("\n"); 
		query.append("                   ELSE NULL" ).append("\n"); 
		query.append("                   END FROM1" ).append("\n"); 
		query.append("                 , NULL FROM2" ).append("\n"); 
		query.append("                 , DECODE(NTC_VIA_CD, 'F', NTC_FAX_NO, 'M', NTC_EML, 'E', EDI_ID, NULL) TO1" ).append("\n"); 
		query.append("                 , DECODE(NTC_VIA_CD, 'E', ntc.esvc_grp_cd, NULL) TO2 " ).append("\n"); 
		query.append("                 , DECODE(NTC_VIA_CD, 'F', 'FAX', 'M', 'EMAIL', 'E', 'EDI', 'T', 'FTP', NULL)   VIA" ).append("\n"); 
		query.append("                 , NVL(SND_RQST_DT, SND_DT) AS SEND_DT" ).append("\n"); 
		query.append("                 , NVL((SELECT USR_NM FROM COM_USER WHERE USR_ID = NTC.SND_USR_ID), NTC.SND_USR_ID) USR_NM" ).append("\n"); 
		query.append("                 , SND_OFC_CD OFFICE" ).append("\n"); 
		query.append("           FROM BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("          WHERE NTC.BKG_NO = @[bkg_no]) SEND" ).append("\n"); 
		query.append("     , (SELECT 1 NO, 'BR' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 NO, 'CN' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 3 NO, 'BK' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 4 NO, 'BT' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 5 NO, 'SI' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 6 NO, 'BL' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("        SELECT 7 NO, 'NN' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 8 NO, 'WB' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 9 NO, 'CW' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 10 NO, 'IB' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 11 NO, 'ED' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 12 NO, 'EI' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 13 NO, 'ES' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 14 NO, 'SN' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 4.5 NO, 'FC' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 15 NO, 'TO' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 16 NO, 'TW' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 17 NO, 'TN' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 18 NO, 'TC' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 19 NO, 'TE' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 20 NO, 'TU' KIND FROM DUAL" ).append("\n"); 
		query.append("		) ORD" ).append("\n"); 
		query.append(" WHERE ORD.KIND = SEND.KIND(+)" ).append("\n"); 
		query.append(" ORDER BY ORD.NO, SEND.SEND_DT" ).append("\n"); 

	}
}