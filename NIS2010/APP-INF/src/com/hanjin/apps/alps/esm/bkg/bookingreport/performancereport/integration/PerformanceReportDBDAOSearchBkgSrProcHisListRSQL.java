/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBkgSrProcHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchBkgSrProcHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchBkgSrProcHisListRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBkgSrProcHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_log_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBkgSrProcHisListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    SR_NO," ).append("\n"); 
		query.append("    FAX_LOG_REF_NO, " ).append("\n"); 
		query.append("    SR_PROC_SEQ, " ).append("\n"); 
		query.append("   ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("   	   FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   	  WHERE INTG_CD_ID = 'CD02898'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT =SR_PROC_TP_CD ) SR_PROC_TP_CD, " ).append("\n"); 
		query.append("    EVNT_DT, " ).append("\n"); 
		query.append("    EVNT_GDT, " ).append("\n"); 
		query.append("    EVNT_USR_ID, " ).append("\n"); 
		query.append("    HIS_CATE_NM, " ).append("\n"); 
		query.append("    PRE_CTNT, " ).append("\n"); 
		query.append("    CRNT_CTNT, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT" ).append("\n"); 
		query.append("FROM BKG_SR_PROC_HIS  " ).append("\n"); 
		query.append("WHERE (SR_NO,FAX_LOG_REF_NO)  =" ).append("\n"); 
		query.append("       (select FM_FAX_SR_NO ,FM_FAX_LOG_REF_NO from bkg_sr_fax where SR_NO =@[sr_no]" ).append("\n"); 
		query.append("  AND FAX_LOG_REF_NO =@[fax_log_ref_no])" ).append("\n"); 
		query.append("union   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    SR_NO," ).append("\n"); 
		query.append("    FAX_LOG_REF_NO, " ).append("\n"); 
		query.append("    SR_PROC_SEQ, " ).append("\n"); 
		query.append("   ( SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("   	   FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   	  WHERE INTG_CD_ID = 'CD02898'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT =SR_PROC_TP_CD ) SR_PROC_TP_CD, " ).append("\n"); 
		query.append("    EVNT_DT, " ).append("\n"); 
		query.append("    EVNT_GDT, " ).append("\n"); 
		query.append("    EVNT_USR_ID, " ).append("\n"); 
		query.append("    HIS_CATE_NM, " ).append("\n"); 
		query.append("    PRE_CTNT, " ).append("\n"); 
		query.append("    CRNT_CTNT, " ).append("\n"); 
		query.append("    CRE_USR_ID, " ).append("\n"); 
		query.append("    CRE_DT" ).append("\n"); 
		query.append("FROM BKG_SR_PROC_HIS  " ).append("\n"); 
		query.append("WHERE SR_NO =@[sr_no]" ).append("\n"); 
		query.append("  AND FAX_LOG_REF_NO =@[fax_log_ref_no]" ).append("\n"); 

	}
}