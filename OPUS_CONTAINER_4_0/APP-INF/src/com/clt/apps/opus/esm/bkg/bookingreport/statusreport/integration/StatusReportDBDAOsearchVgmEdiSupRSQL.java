/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOsearchVgmEdiSupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOsearchVgmEdiSupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VGM EDI SUP
	  * </pre>
	  */
	public StatusReportDBDAOsearchVgmEdiSupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_rcvr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOsearchVgmEdiSupRSQL").append("\n"); 
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
		query.append("SELECT NTC_KND_NM ," ).append("\n"); 
		query.append("       KIND.NTC_KND_CD ," ).append("\n"); 
		query.append("       REF_CODE ," ).append("\n"); 
		query.append("       EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("       EDI_SND_ID ," ).append("\n"); 
		query.append("       SENDER ," ).append("\n"); 
		query.append("       SENDER_NM ," ).append("\n"); 
		query.append("       SEND_DT ," ).append("\n"); 
		query.append("       BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE 'CD02396' = INTG_CD_ID" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = DECODE(MST.BKG_NTC_SND_RSLT_CD, 'A', 3, 'F', 4, 'N', 4, NULL)) AS RESULT" ).append("\n"); 
		query.append("  FROM (SELECT 'VERMAS (A) - CY' NTC_KND_NM," ).append("\n"); 
		query.append("               'VC' NTC_KND_CD," ).append("\n"); 
		query.append("               1 ORD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'VERMAS (A) - POL' NTC_KND_NM," ).append("\n"); 
		query.append("               'VP' NTC_KND_CD," ).append("\n"); 
		query.append("               2 ORD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'VERMAS (A) - T/S' NTC_KND_NM," ).append("\n"); 
		query.append("               'VT' NTC_KND_CD," ).append("\n"); 
		query.append("               3 ORD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'VERMAS (M)' NTC_KND_NM," ).append("\n"); 
		query.append("               'VM' NTC_KND_CD," ).append("\n"); 
		query.append("               4 ORD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT '301 (A) - CY' NTC_KND_NM," ).append("\n"); 
		query.append("               '3C' NTC_KND_CD," ).append("\n"); 
		query.append("               5 ORD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT '301 (A) - POL' NTC_KND_NM," ).append("\n"); 
		query.append("               '3P' NTC_KND_CD," ).append("\n"); 
		query.append("               6 ORD" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT '301 (M)' NTC_KND_NM," ).append("\n"); 
		query.append("               '3M' NTC_KND_CD," ).append("\n"); 
		query.append("               7 ORD" ).append("\n"); 
		query.append("          FROM DUAL ) KIND ," ).append("\n"); 
		query.append("       (SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID , " ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT 'VC' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID," ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 31" ).append("\n"); 
		query.append("                                   AND (EY.PRNR_SUB_LNK_CD = BB.POR_NOD_CD" ).append("\n"); 
		query.append("                                            OR EY.PRNR_SUB_LNK_CD = BB.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                                            OR EY.PRNR_SUB_LNK_CD = BB.MTY_RTN_YD_CD ) ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND 'VC' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID," ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT 'VP' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID ," ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 32" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_CD = BB.POL_NOD_CD ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND 'VP' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID , " ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT 'VT' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID ," ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 33" ).append("\n"); 
		query.append("                                              AND EXISTS (SELECT 'Y' FROM BKG_VVD WHERE BB.BKG_NO = BKG_NO AND EY.PRNR_SUB_LNK_CD = POL_YD_CD AND BB.POL_NOD_CD <> POL_YD_CD)" ).append("\n"); 
		query.append("                                              ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND 'VT' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID ," ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT 'VM' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID , " ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 34" ).append("\n"); 
		query.append("                                       ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND 'VM' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID ," ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT '3C' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID , " ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 35" ).append("\n"); 
		query.append("                                   AND (EY.PRNR_SUB_LNK_CD = BB.POR_NOD_CD" ).append("\n"); 
		query.append("                                            OR EY.PRNR_SUB_LNK_CD = BB.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                                            OR EY.PRNR_SUB_LNK_CD = BB.MTY_RTN_YD_CD ) ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND '3C' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID ," ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT '3P' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID , " ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 36" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_CD = BB.POL_NOD_CD ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND '3P' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID)" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT NTC_KND_CD ," ).append("\n"); 
		query.append("               REF_CODE ," ).append("\n"); 
		query.append("               EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("               EDI_SND_ID ," ).append("\n"); 
		query.append("               SENDER ," ).append("\n"); 
		query.append("               SENDER_NM ," ).append("\n"); 
		query.append("               SEND_DT ," ).append("\n"); 
		query.append("               BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("          FROM (SELECT '3M' NTC_KND_CD ," ).append("\n"); 
		query.append("                       NTC.YD_CD REF_CODE ," ).append("\n"); 
		query.append("                       NTC.EDI_ID EDI_RECEIVE_ID ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID EDI_SND_ID ," ).append("\n"); 
		query.append("                       NTC.SND_USR_ID SENDER ," ).append("\n"); 
		query.append("                       (SELECT USR.USR_NM" ).append("\n"); 
		query.append("                          FROM COM_USER USR" ).append("\n"); 
		query.append("                         WHERE USR.USR_ID = NTC.SND_USR_ID) SENDER_NM ," ).append("\n"); 
		query.append("                       TO_CHAR(NTC.SND_RQST_DT, 'YYYY-MM-DD HH24:MI') SEND_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK ," ).append("\n"); 
		query.append("                       (SELECT NTC.BKG_NO ," ).append("\n"); 
		query.append("                               NTC.SND_USR_ID," ).append("\n"); 
		query.append("                               NTC.SND_RQST_DT," ).append("\n"); 
		query.append("                               NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                               EDI_YD.EDI_RCV_ID EDI_ID," ).append("\n"); 
		query.append("                               EDI_YD.YD_CD," ).append("\n"); 
		query.append("                               EDI_YD.EDI_SND_ID EDI_SND_ID" ).append("\n"); 
		query.append("                          FROM BKG_NTC_HIS NTC ," ).append("\n"); 
		query.append("                               (SELECT DISTINCT EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("                                       EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID ," ).append("\n"); 
		query.append("                                       EY.PRNR_PORT_CD AS PORT_CD ," ).append("\n"); 
		query.append("                                       EY.PRNR_SUB_LNK_CD AS YD_CD ," ).append("\n"); 
		query.append("                                       BB.BKG_NO" ).append("\n"); 
		query.append("                                  FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("                                       BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("                                       BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("                                   AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("                                   AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("                                   AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("								   AND MSG.EDI_MSG_IND_CD = 37" ).append("\n"); 
		query.append("                                       ) EDI_YD" ).append("\n"); 
		query.append("                         WHERE 'E' = NTC.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("                           AND '3M' = NTC.NTC_KND_CD(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.BKG_NO = NTC.BKG_NO(+)" ).append("\n"); 
		query.append("                           AND EDI_YD.EDI_RCV_ID = NTC.EDI_ID(+)" ).append("\n"); 
		query.append("                           AND NVL(NTC.HIS_SEQ, 1) = NVL2(NTC.HIS_SEQ, (SELECT MAX(HIS_SEQ)" ).append("\n"); 
		query.append("                                          FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                                         WHERE BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("                                           AND NTC_VIA_CD = NTC.NTC_VIA_CD" ).append("\n"); 
		query.append("                                           AND NTC_KND_CD = NTC.NTC_KND_CD" ).append("\n"); 
		query.append("                                           AND EDI_ID = NTC.EDI_ID" ).append("\n"); 
		query.append("                                           AND NVL(ESVC_GRP_CD, 1) = NVL(NTC.ESVC_GRP_CD, 1) ), 1)) NTC" ).append("\n"); 
		query.append("                 WHERE NTC.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("                 GROUP BY YD_CD ," ).append("\n"); 
		query.append("                       EDI_ID ," ).append("\n"); 
		query.append("                       SND_USR_ID ," ).append("\n"); 
		query.append("                       NTC.SND_RQST_DT ," ).append("\n"); 
		query.append("                       NTC.BKG_NTC_SND_RSLT_CD ," ).append("\n"); 
		query.append("                       NTC.EDI_SND_ID) ) MST" ).append("\n"); 
		query.append(" WHERE KIND.NTC_KND_CD = MST.NTC_KND_CD(+)" ).append("\n"); 
		query.append("#if( ${in_yd_cd} != '')" ).append("\n"); 
		query.append("   AND REF_CODE LIKE '%'||@[in_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${in_rcvr_id} != '')" ).append("\n"); 
		query.append("   AND EDI_RECEIVE_ID LIKE '%'||@[in_rcvr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${in_sndr_id} != '')" ).append("\n"); 
		query.append("   AND EDI_SND_ID LIKE '%'||@[in_sndr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY ORD," ).append("\n"); 
		query.append("       DECODE(NTC_KND_CD, 'VC', 1, 'VP', 2, 'VT', 3, 'VM', 4, '3C', 5, '3P', 6, '3M', 7)," ).append("\n"); 
		query.append("       EDI_RECEIVE_ID" ).append("\n"); 

	}
}