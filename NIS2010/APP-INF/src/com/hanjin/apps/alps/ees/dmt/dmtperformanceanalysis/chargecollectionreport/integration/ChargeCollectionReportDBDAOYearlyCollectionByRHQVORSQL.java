/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOYearlyCollectionByRHQVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOYearlyCollectionByRHQVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dd
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOYearlyCollectionByRHQVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOYearlyCollectionByRHQVORSQL").append("\n"); 
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
		query.append("select	  '' BACKENDJOB_KEY, '' BACKENDJOB_ID" ).append("\n"); 
		query.append("		, '' OFC_CD, '' OFC_RHQ_CD, '' OFC_CD_LIST, '' OFC_FLG,  '' F_YEAR, '' GRP_FLG" ).append("\n"); 
		query.append("		, '' CURR_FLG, '' UCLM_FLG, '' DMDT_TRF_CD, '' TRF_CD_LIST, '' DMDT_CNTR_TP_CD, '' CNTR_TP_LIST" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '' AS G030_INCR_QTY" ).append("\n"); 
		query.append("        , '' AS G030_INCR_AMT" ).append("\n"); 
		query.append("        , '' AS G030_EXPT_QTY" ).append("\n"); 
		query.append("        , '' AS G030_EXPT_AMT" ).append("\n"); 
		query.append("        , '' AS G030_DCNT_QTY" ).append("\n"); 
		query.append("        , '' AS G030_DCNT_AMT" ).append("\n"); 
		query.append("        , '' AS G030_BILL_QTY" ).append("\n"); 
		query.append("        , '' AS G030_BILL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '' AS G060_INCR_QTY" ).append("\n"); 
		query.append("        , '' AS G060_INCR_AMT" ).append("\n"); 
		query.append("        , '' AS G060_EXPT_QTY" ).append("\n"); 
		query.append("        , '' AS G060_EXPT_AMT" ).append("\n"); 
		query.append("        , '' AS G060_DCNT_QTY" ).append("\n"); 
		query.append("        , '' AS G060_DCNT_AMT" ).append("\n"); 
		query.append("        , '' AS G060_BILL_QTY" ).append("\n"); 
		query.append("        , '' AS G060_BILL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '' AS G090_INCR_QTY" ).append("\n"); 
		query.append("        , '' AS G090_INCR_AMT" ).append("\n"); 
		query.append("        , '' AS G090_EXPT_QTY" ).append("\n"); 
		query.append("        , '' AS G090_EXPT_AMT" ).append("\n"); 
		query.append("        , '' AS G090_DCNT_QTY" ).append("\n"); 
		query.append("        , '' AS G090_DCNT_AMT" ).append("\n"); 
		query.append("        , '' AS G090_BILL_QTY" ).append("\n"); 
		query.append("        , '' AS G090_BILL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '' AS G180_INCR_QTY" ).append("\n"); 
		query.append("        , '' AS G180_INCR_AMT" ).append("\n"); 
		query.append("        , '' AS G180_EXPT_QTY" ).append("\n"); 
		query.append("        , '' AS G180_EXPT_AMT" ).append("\n"); 
		query.append("        , '' AS G180_DCNT_QTY" ).append("\n"); 
		query.append("        , '' AS G180_DCNT_AMT" ).append("\n"); 
		query.append("        , '' AS G180_BILL_QTY" ).append("\n"); 
		query.append("        , '' AS G180_BILL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , '' AS G181_INCR_QTY" ).append("\n"); 
		query.append("        , '' AS G181_INCR_AMT" ).append("\n"); 
		query.append("        , '' AS G181_EXPT_QTY" ).append("\n"); 
		query.append("        , '' AS G181_EXPT_AMT" ).append("\n"); 
		query.append("        , '' AS G181_DCNT_QTY" ).append("\n"); 
		query.append("        , '' AS G181_DCNT_AMT" ).append("\n"); 
		query.append("        , '' AS G181_BILL_QTY" ).append("\n"); 
		query.append("        , '' AS G181_BILL_AMT  " ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}