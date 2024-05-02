/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingSubjectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingSubjectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingSubject
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingSubjectRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingSubjectRSQL").append("\n"); 
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
		query.append("SELECT  '[DEM/DET] DAR No. '||AFT_EXPT_DAR_NO||' - '||" ).append("\n"); 
		query.append("		 CASE WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'BBOPIC' THEN 'SCO PIC Counter-Offer' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'OOMMGR' THEN 'OFC O.Manager Counter-Offer' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'BBGMGR' THEN 'SSZ/BAG Counter-Offer' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOPIC' THEN 'HO PIC Counter-Offer' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOMGR' THEN 'HO O.MGR Counter-Offer' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOECD' THEN 'Sales & Operations Division Executive Counter-Offer' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOCEO' THEN 'CEO Counter-Offer' " ).append("\n"); 
		query.append("								  " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'BBOPIC' THEN 'SCO PIC Reject' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'OOMMGR' THEN 'OFC O.Manager Reject'" ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'BBGMGR' THEN 'SSZ/BAG Reject' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOPIC' THEN 'HO PIC Reject' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOMGR' THEN 'HO O.MGR Reject' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOECD' THEN 'Sales & Operations Division Executive Reject' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOCEO' THEN 'CEO Reject' " ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			  ELSE INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		 END " ).append("\n"); 
		query.append("		 ||'|'||" ).append("\n"); 
		query.append("		 'After Booking DAR No. '||AFT_EXPT_DAR_NO||' was '||" ).append("\n"); 
		query.append("		 CASE WHEN DMDT_EXPT_RQST_STS_CD = 'F'  THEN 'Confirm by SCO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'V'  THEN 'Approval by OFC O.Manager' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'G'  THEN 'Approval by SSZ/BAG' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'H'  THEN 'Confirm by HO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'W'  THEN 'Approval by HO O.MGR'" ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'E'  THEN 'Approval by Sales & Operations Division Executive'" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'BBOPIC' THEN 'Approval by SCO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'OOMMGR' THEN 'Approval by OFC O.Manager' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'BBGMGR' THEN 'Approval by SSZ/BAG' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'HDOPIC' THEN 'Approval by HO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'HDOMGR' THEN 'Approval by HO O.MGR' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'HDOECD' THEN 'Approval by Sales & Operations Division Executive' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'A' AND AFT_BKG_PATH_CD = 'HDOCEO' THEN 'Approval by CEO' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'BBOPIC' THEN 'Counter-Offer by SCO PIC ' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'OOMMGR' THEN 'Counter-Offer by OFC O.Manager' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'BBGMGR' THEN 'Counter-Offer by SSZ/BAG' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOPIC' THEN 'Counter-Offer by HO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOMGR' THEN 'Counter-Offer by HO O.MGR' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOECD' THEN 'Counter-Offer by Sales & Operations Division Executive' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'O' AND AFT_BKG_PATH_CD = 'HDOCEO' THEN 'Counter-Offer by CEO' " ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'BBOPIC' THEN 'Reject by SCO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'OOMMGR' THEN 'Reject by OFC O.Manager' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'BBGMGR' THEN 'Reject by SSZ/BAG' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOPIC' THEN 'Reject by HO PIC' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOMGR' THEN 'Reject by HO O.MGR' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOECD' THEN 'Reject by Sales & Operations Division Executive' " ).append("\n"); 
		query.append("			  WHEN DMDT_EXPT_RQST_STS_CD = 'J' AND AFT_BKG_PATH_CD = 'HDOCEO' THEN 'Reject by CEO' " ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			  ELSE INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		 END " ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("			SELECT  * " ).append("\n"); 
		query.append("			  FROM  DMT_AFT_BKG_ADJ_PROG" ).append("\n"); 
		query.append("			 WHERE  AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("			ORDER BY PROG_SEQ DESC" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("	   ,COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  A.DMDT_EXPT_RQST_STS_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("   AND  B.INTG_CD_ID(+) = 'CD01971'" ).append("\n"); 
		query.append("   AND  ROWNUM = 1" ).append("\n"); 

	}
}