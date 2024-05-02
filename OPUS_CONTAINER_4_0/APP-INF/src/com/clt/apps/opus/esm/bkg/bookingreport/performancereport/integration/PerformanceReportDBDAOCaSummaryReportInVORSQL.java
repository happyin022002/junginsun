/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOCaSummaryReportInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.03.26 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOCaSummaryReportInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOCaSummaryReportInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaSummaryReportInVORSQL").append("\n"); 
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
		query.append("SELECT '' CORR_FROM_DT" ).append("\n"); 
		query.append(",'' CORR_TO_DT" ).append("\n"); 
		query.append(",'' CRE_FROM_DT" ).append("\n"); 
		query.append(",'' CRE_TO_DT" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' CA_REASON" ).append("\n"); 
		query.append(",'' CA_REASON_M" ).append("\n"); 
		query.append(",'' CA_REASON_C" ).append("\n"); 
		query.append(",'' CA_REASON_G" ).append("\n"); 
		query.append(",'' CA_REASON_A" ).append("\n"); 
		query.append(",'' CA_REASON_O" ).append("\n"); 
		query.append(",'' CA_CLASS" ).append("\n"); 
		query.append(",'' CA_CLASS_1" ).append("\n"); 
		query.append(",'' CA_CLASS_2" ).append("\n"); 
		query.append(",'' CA_CLASS_3" ).append("\n"); 
		query.append(",'' CA_KIND" ).append("\n"); 
		query.append(",'' CA_KIND_A" ).append("\n"); 
		query.append(",'' CA_KIND_B" ).append("\n"); 
		query.append(",'' CA_KIND_C" ).append("\n"); 
		query.append(",'' CA_KIND_D" ).append("\n"); 
		query.append(",'' CA_KIND_E" ).append("\n"); 
		query.append(",'' CA_KIND_F" ).append("\n"); 
		query.append(",'' CA_KIND_G" ).append("\n"); 
		query.append(",'' CA_KIND_H" ).append("\n"); 
		query.append(",'' CA_KIND_I" ).append("\n"); 
		query.append(",'' CA_KIND_J" ).append("\n"); 
		query.append(",'' CA_KIND_K" ).append("\n"); 
		query.append(",'' CA_ISSUE_OFF" ).append("\n"); 
		query.append(",'' BKG_OFF" ).append("\n"); 
		query.append(",'' DEL_OFF" ).append("\n"); 
		query.append(",'' PART" ).append("\n"); 
		query.append(",'' CONTRACT_OFF" ).append("\n"); 
		query.append(",'' CA_ISSUE_STAFF" ).append("\n"); 
		query.append(",'' OFF_DIS_OP" ).append("\n"); 
		query.append(",'' OFF_DIS_OP_1" ).append("\n"); 
		query.append(",'' OFF_DIS_OP_2" ).append("\n"); 
		query.append(",'' OFF_DIS_OP_3" ).append("\n"); 
		query.append(",'' OFF_DIS_OP_4" ).append("\n"); 
		query.append(",'' OFF_DIS_OP_5" ).append("\n"); 
		query.append(",'' OFF_DIS_OP_6" ).append("\n"); 
		query.append(",'' POR" ).append("\n"); 
		query.append(",'' POL" ).append("\n"); 
		query.append(",'' POD" ).append("\n"); 
		query.append(",'' DEL" ).append("\n"); 
		query.append(",'' OTHER_OP" ).append("\n"); 
		query.append(",'' OTHER_OP_1" ).append("\n"); 
		query.append(",'' OTHER_OP_2" ).append("\n"); 
		query.append(",'' OTHER_OP_3" ).append("\n"); 
		query.append(",'' dlv_ctnt_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}