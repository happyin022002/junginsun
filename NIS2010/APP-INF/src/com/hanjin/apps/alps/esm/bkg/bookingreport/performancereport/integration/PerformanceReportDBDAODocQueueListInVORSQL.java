/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueListInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.24
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.05.24 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueListInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueListInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueListInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueListInVORSQL").append("\n"); 
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
		query.append("'' VVD_CD" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' USR_ID" ).append("\n"); 
		query.append(", '' PRT_CD" ).append("\n"); 
		query.append(", '' SVR_CD" ).append("\n"); 
		query.append(", '' OFC_CD" ).append("\n"); 
		query.append(", '' CUR_QUEUE" ).append("\n"); 
		query.append(", '' DURA_FROM_DT" ).append("\n"); 
		query.append(", '' DURA_TO_DT" ).append("\n"); 
		query.append(", '' QUEUE_STATUS" ).append("\n"); 
		query.append(", '' PENDING_ONLY" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' BKG_OFC_CD" ).append("\n"); 
		query.append(", '' input" ).append("\n"); 
		query.append(", '' rate" ).append("\n"); 
		query.append(", '' qa" ).append("\n"); 
		query.append(", '' fax" ).append("\n"); 
		query.append(", '' region" ).append("\n"); 
		query.append(", '' sts" ).append("\n"); 
		query.append(", '' curr_page" ).append("\n"); 
		query.append(", '' rows_per_page" ).append("\n"); 
		query.append(", '' SRC_CD" ).append("\n"); 
		query.append(", '' SR_AMD_TP_CD" ).append("\n"); 
		query.append(", '' SR_KND_CD" ).append("\n"); 
		query.append(", '' RETURN_TO" ).append("\n"); 
		query.append(", '' SLAN_CD" ).append("\n"); 
		query.append(", '' SET_SLCT_FLG" ).append("\n"); 
		query.append(", '' SET_QRY_WHERE" ).append("\n"); 
		query.append(", '' SREP_CD" ).append("\n"); 
		query.append(", '' BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", '' CUST_CNT_CD" ).append("\n"); 
		query.append(", '' CUST_SEQ" ).append("\n"); 
		query.append(", '' CUST_NM" ).append("\n"); 
		query.append(", '' SPLIT_ONLY_FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}