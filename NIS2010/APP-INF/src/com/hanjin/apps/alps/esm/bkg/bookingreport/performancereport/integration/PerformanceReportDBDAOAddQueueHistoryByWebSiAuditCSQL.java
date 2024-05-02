/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOAddQueueHistoryByWebSiAuditCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.08
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.10.08 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOAddQueueHistoryByWebSiAuditCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WEB SI Audit 처리된 Queue의 QA History 기록
	  * </pre>
	  */
	public PerformanceReportDBDAOAddQueueHistoryByWebSiAuditCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOAddQueueHistoryByWebSiAuditCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_SR_HIS" ).append("\n"); 
		query.append("(           SR_KND_CD," ).append("\n"); 
		query.append("            SR_NO," ).append("\n"); 
		query.append("            BKG_NO," ).append("\n"); 
		query.append("            SR_HIS_SEQ," ).append("\n"); 
		query.append("            SR_STS_CD," ).append("\n"); 
		query.append("            SR_PROC_STS_CD," ).append("\n"); 
		query.append("            SR_PROC_UPD_DT," ).append("\n"); 
		query.append("            SR_PROC_UPD_GDT," ).append("\n"); 
		query.append("            ATND_USR_ID," ).append("\n"); 
		query.append("            ST_DT," ).append("\n"); 
		query.append("            ST_GDT," ).append("\n"); 
		query.append("            FNT_OFC_RTN_CD," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT," ).append("\n"); 
		query.append("            SR_PROC_HRS," ).append("\n"); 
		query.append("            BL_DOC_WRK_HRS," ).append("\n"); 
		query.append("            BL_DOC_OVT_HRS," ).append("\n"); 
		query.append("            SR_IDLE_HRS," ).append("\n"); 
		query.append("            SR_WRK_TM_IDLE_HRS," ).append("\n"); 
		query.append("            SR_OVT_IDLE_HRS," ).append("\n"); 
		query.append("            HOL_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     SR_KND_CD," ).append("\n"); 
		query.append("     SR_NO," ).append("\n"); 
		query.append("     BKG_NO," ).append("\n"); 
		query.append("     ( SELECT NVL(MAX(SR_HIS_SEQ) + 1,0)" ).append("\n"); 
		query.append("        FROM BKG_SR_HIS" ).append("\n"); 
		query.append("        WHERE SR_KND_CD = X.SR_KND_CD /* 0421의 SRC_CD*/" ).append("\n"); 
		query.append("          AND  SR_NO    = X.SR_NO" ).append("\n"); 
		query.append("          AND  BKG_NO   = X.BKG_NO               " ).append("\n"); 
		query.append("     ) SR_HIS_SEQ," ).append("\n"); 
		query.append("     'AD' SR_STS_CD," ).append("\n"); 
		query.append("     'N' SR_PROC_STS_CD, /*상수 */" ).append("\n"); 
		query.append("	 SYSDATE SR_PROC_UPD_DT," ).append("\n"); 
		query.append("	 SYSDATE SR_PROC_UPD_GDT," ).append("\n"); 
		query.append("     @[usr_id] ATND_USR_ID," ).append("\n"); 
		query.append("	 GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') ST_DT," ).append("\n"); 
		query.append("	 GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG') ST_GDT," ).append("\n"); 
		query.append("     RTN_FM_STS_CD FNT_OFC_RTN_CD," ).append("\n"); 
		query.append("     @[usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("     SYSDATE CRE_DT," ).append("\n"); 
		query.append("     @[usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("     SYSDATE UPD_DT," ).append("\n"); 
		query.append("	 0 SR_PROC_HRS," ).append("\n"); 
		query.append("	 0 BL_DOC_WRK_HRS,     " ).append("\n"); 
		query.append("     0 BL_DOC_OVT_HRS," ).append("\n"); 
		query.append("     0 SR_IDLE_HRS," ).append("\n"); 
		query.append("     0 SR_WRK_TM_IDLE_HRS," ).append("\n"); 
		query.append("     0 SR_OVT_IDLE_HRS," ).append("\n"); 
		query.append("     (SELECT DECODE(COUNT(DISTINCT HOL_DT),0,'N','Y')" ).append("\n"); 
		query.append("                      FROM DMT_HOLIDAY H, MDM_ORGANIZATION O,MDM_LOCATION L" ).append("\n"); 
		query.append("				      WHERE O.OFC_CD = (SELECT BKG_OFC_CD FROM BKG_BOOKING WHERE BKG_NO = X.bkg_no)" ).append("\n"); 
		query.append("                      AND O.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("                      AND (H.CNT_CD = L.CNT_CD OR H.CNT_CD = ' ')" ).append("\n"); 
		query.append("                      AND (H.RGN_CD = L.RGN_CD OR H.RGN_CD = ' ')" ).append("\n"); 
		query.append("                      AND (H.STE_CD = L.STE_CD OR H.STE_CD = ' ')" ).append("\n"); 
		query.append("                      AND (H.LOC_CD = L.LOC_CD OR H.LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND HOL_DT = TRUNC(GLOBALDATE_PKG.TIME_LOCAL_FNC('MYPKG'))) HOL_FLG" ).append("\n"); 
		query.append("FROM BKG_SR_CRNT_RQST X" ).append("\n"); 
		query.append("WHERE X.BKG_NO = (SELECT BKG_NO " ).append("\n"); 
		query.append("                  FROM BKG_XTER_RQST_MST " ).append("\n"); 
		query.append("                  WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                  AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("                  AND XTER_RQST_SEQ = @[xter_rqst_seq])" ).append("\n"); 
		query.append(" AND X.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append(" AND X.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append(" AND X.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append(" AND X.SR_CRNT_STS_CD !='XX'" ).append("\n"); 

	}
}