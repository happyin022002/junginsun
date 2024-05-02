/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueReportByPolListOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.21 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueReportByPolListOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueReportByPolListOutVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueReportByPolListOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueReportByPolListOutVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'seq' seq" ).append("\n"); 
		query.append(", 'bkg_no' bkg_no" ).append("\n"); 
		query.append(", 'sr' sr" ).append("\n"); 
		query.append(", 'vvd_cd' vvd_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'pol_cd' pol_cd" ).append("\n"); 
		query.append(", 'pod_cd' pod_cd" ).append("\n"); 
		query.append(", 'sr_knd_cd' sr_knd_cd" ).append("\n"); 
		query.append(", 'status' status" ).append("\n"); 
		query.append(", to_char(sysdate, 'YYYY-MM-DD HH24:MI') last_upd_dt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'shipper_code' shipper_code" ).append("\n"); 
		query.append(", 'shipper_nm' shipper_nm" ).append("\n"); 
		query.append(", 'consignee_nm' consignee_nm" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'ttl_bkg' ttl_bkg" ).append("\n"); 
		query.append(", 'input queue' inputter_queue" ).append("\n"); 
		query.append(", 's/r trans'   sr_transferred" ).append("\n"); 
		query.append(", 'inputting'   inputting" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 's/r y'       sr_y" ).append("\n"); 
		query.append(", 'rater queue' rater_queue" ).append("\n"); 
		query.append(", 'inputted'    inputted" ).append("\n"); 
		query.append(", 'rating'      rating" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 's/r n'       sr_n" ).append("\n"); 
		query.append(", 'auditor queue' auditor_queue" ).append("\n"); 
		query.append(", 'rated'         rated" ).append("\n"); 
		query.append(", 'auditing'      auditing" ).append("\n"); 
		query.append(", 'audited'       audited" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'stopped queue'  stopped_queue" ).append("\n"); 
		query.append(", 'f/ofc returned' fofc_returned" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'queue total' queue_total" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'bst matched Q'  bst_matched_q" ).append("\n"); 
		query.append(", 'bst unmatched Q' bst_unmatched_q" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' total_cnt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}