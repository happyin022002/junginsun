/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchNoticeHistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.22 
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
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
		query.append("         UNION  " ).append("\n"); 
		query.append("         SELECT NTC_KND_CD KIND" ).append("\n"); 
		query.append("                 , NULL FROM1" ).append("\n"); 
		query.append("                 , NULL FROM2" ).append("\n"); 
		query.append("                 , DECODE(NTC_VIA_CD, 'F', NTC_FAX_NO, 'M', NTC_EML, EDI_ID) TO1" ).append("\n"); 
		query.append("                 , DECODE(NTC_VIA_CD, 'E', ntc.esvc_grp_cd, NULL) TO2 " ).append("\n"); 
		query.append("                 , DECODE(NTC_VIA_CD, 'F', 'FAX', 'M', 'EMAIL', 'E', 'EDI')   VIA" ).append("\n"); 
		query.append("                 , CASE WHEN NTC_KND_CD IN ('UR','DR') AND SND_USR_ID = 'SYSTEM' THEN GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SND_RQST_DT,BKG.POL_CD)" ).append("\n"); 
		query.append("                        ELSE NVL(SND_RQST_DT, SND_DT) " ).append("\n"); 
		query.append("                        END AS SEND_DT" ).append("\n"); 
		query.append("                 , NVL((SELECT USR_NM FROM COM_USER WHERE USR_ID = NTC.SND_USR_ID), NTC.SND_USR_ID) USR_NM" ).append("\n"); 
		query.append("                 , SND_OFC_CD OFFICE" ).append("\n"); 
		query.append("           FROM BKG_NTC_HIS NTC" ).append("\n"); 
		query.append("               ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("          WHERE NTC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND NTC.BKG_NO = BKG.BKG_NO) SEND" ).append("\n"); 
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
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 7 NO, 'WB' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 8 NO, 'IB' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 9 NO, 'SR' KIND FROM DUAL " ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 10 NO, 'SS' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 11 NO, 'RR' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 12 NO, 'SB' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 13 NO, 'DR' KIND FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("		SELECT 14 NO, 'UR' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 15 NO, 'NR' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 16 NO, 'RP' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 17 NO, 'RC' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 18 NO, 'OM' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 19 NO, 'RO' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 20 NO, 'VM' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 21 NO, 'VC' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 22 NO, 'VR' KIND FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT 23 NO, 'VI' KIND FROM DUAL" ).append("\n"); 
		query.append("        ) ORD" ).append("\n"); 
		query.append(" WHERE ORD.KIND = SEND.KIND(+)" ).append("\n"); 
		query.append(" ORDER BY ORD.NO, SEND.SEND_DT" ).append("\n"); 

	}
}