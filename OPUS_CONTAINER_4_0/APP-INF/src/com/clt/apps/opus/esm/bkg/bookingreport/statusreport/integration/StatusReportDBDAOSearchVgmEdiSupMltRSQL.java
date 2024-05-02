/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatusReportDBDAOSearchVgmEdiSupMltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
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

public class StatusReportDBDAOSearchVgmEdiSupMltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search VGM EDI SUP for MULTI
	  * </pre>
	  */
	public StatusReportDBDAOSearchVgmEdiSupMltRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchVgmEdiSupMltRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT NTC_KND_NM," ).append("\n"); 
		query.append("                NTC_KND_CD," ).append("\n"); 
		query.append("                EDI_SND_ID," ).append("\n"); 
		query.append("                EDI_RECEIVE_ID," ).append("\n"); 
		query.append("                REF_CODE," ).append("\n"); 
		query.append("			    ORD" ).append("\n"); 
		query.append("FROM ( SELECT 'VERMAS (A) - CY' NTC_KND_NM," ).append("\n"); 
		query.append("              'VC' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  1 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 31" ).append("\n"); 
		query.append("          AND (EY.PRNR_SUB_LNK_CD = BB.POR_NOD_CD" ).append("\n"); 
		query.append("              OR EY.PRNR_SUB_LNK_CD = BB.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("              OR EY.PRNR_SUB_LNK_CD = BB.MTY_RTN_YD_CD )" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT 'VERMAS (A) - POL' NTC_KND_NM," ).append("\n"); 
		query.append("              'VP' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  2 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 32" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_CD = BB.POL_NOD_CD" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT 'VERMAS (A) - T/S' NTC_KND_NM," ).append("\n"); 
		query.append("              'VT' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  3 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 33" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'Y' FROM BKG_VVD WHERE BB.BKG_NO = BKG_NO AND EY.PRNR_SUB_LNK_CD = POL_YD_CD AND BB.POL_NOD_CD <> POL_YD_CD)" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT 'VERMAS (M)' NTC_KND_NM," ).append("\n"); 
		query.append("              'VM' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  6 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 34" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT '301 (A) - CY' NTC_KND_NM," ).append("\n"); 
		query.append("              '3C' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  4 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 35" ).append("\n"); 
		query.append("          AND (EY.PRNR_SUB_LNK_CD = BB.POR_NOD_CD" ).append("\n"); 
		query.append("              OR EY.PRNR_SUB_LNK_CD = BB.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("              OR EY.PRNR_SUB_LNK_CD = BB.MTY_RTN_YD_CD )" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT '301 (A) - POL' NTC_KND_NM," ).append("\n"); 
		query.append("              '3P' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  5 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 36" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_CD = BB.POL_NOD_CD" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("       SELECT '301 (M)' NTC_KND_NM," ).append("\n"); 
		query.append("              '3M' NTC_KND_CD ," ).append("\n"); 
		query.append("              EY.SNDR_TRD_PRNR_ID AS EDI_SND_ID," ).append("\n"); 
		query.append("              EY.RCVR_TRD_PRNR_ID AS EDI_RECEIVE_ID," ).append("\n"); 
		query.append("              EY.PRNR_SUB_LNK_CD AS REF_CODE," ).append("\n"); 
		query.append("			  7 ORD" ).append("\n"); 
		query.append("         FROM BKG_EDI_TRD_PRNR_SUB_LNK EY," ).append("\n"); 
		query.append("              BKG_EDI_SUB_LNK_MSG MSG," ).append("\n"); 
		query.append("              BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO IN (${bkg_nos})" ).append("\n"); 
		query.append("          AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("          AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("          AND MSG.EDI_MSG_TP_ID = 'VGM'" ).append("\n"); 
		query.append("          AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("		  AND MSG.EDI_MSG_IND_CD = 37" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${in_yd_cd} != '')" ).append("\n"); 
		query.append("   AND REF_CODE LIKE '%'||@[in_yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${in_rcvr_id} != '')" ).append("\n"); 
		query.append("   AND EDI_RECEIVE_ID LIKE '%'||@[in_rcvr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${in_sndr_id} != '')" ).append("\n"); 
		query.append("   AND EDI_SND_ID LIKE '%'||@[in_sndr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ORD" ).append("\n"); 

	}
}