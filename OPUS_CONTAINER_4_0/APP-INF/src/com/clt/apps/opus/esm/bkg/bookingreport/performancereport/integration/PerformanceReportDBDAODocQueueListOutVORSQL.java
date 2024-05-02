/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueListOutVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.12.30 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueListOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueListOutVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueListOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueListOutVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' USR_ID" ).append("\n"); 
		query.append(", '' DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append(", '' RETURN_CD" ).append("\n"); 
		query.append(", '' SR_KIND" ).append("\n"); 
		query.append(", '' SRC" ).append("\n"); 
		query.append(", '' TOTAL_BDR" ).append("\n"); 
		query.append(", '' TOTAL_URGENT" ).append("\n"); 
		query.append(", '' TOTAL_VIP" ).append("\n"); 
		query.append(", '' TOTAL_BKG" ).append("\n"); 
		query.append(", '' URGENCY" ).append("\n"); 
		query.append(", '' SR_KIND_CD" ).append("\n"); 
		query.append(", '' RETURN_SRC" ).append("\n"); 
		query.append(", '' SRC_CD" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' SHIPPER" ).append("\n"); 
		query.append(", '' VVD_CD" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' PCT_DATE" ).append("\n"); 
		query.append(", '' BDR_DATE" ).append("\n"); 
		query.append(", '' SR_DATE" ).append("\n"); 
		query.append(", '' LAST_DATE" ).append("\n"); 
		query.append(", '' QUEUE_STATUS" ).append("\n"); 
		query.append(", '' FAX" ).append("\n"); 
		query.append(", '' MESSAGE_YN" ).append("\n"); 
		query.append(", '' MESSAGE" ).append("\n"); 
		query.append(", '' BDR_FLG" ).append("\n"); 
		query.append(", '' SR_CRNT_INFO_CD" ).append("\n"); 
		query.append(", '' MAX_SR_NO" ).append("\n"); 
		query.append(", '' CRNT_USR_ID" ).append("\n"); 
		query.append(", '' IMG_FILE_IP" ).append("\n"); 
		query.append(", '' IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append(", '' IMG_FILE_NM" ).append("\n"); 
		query.append(", '' BKG_STS_CD" ).append("\n"); 
		query.append(", '' RTN_FM_USR_ID" ).append("\n"); 
		query.append(", '' RTN_TO_USR_ID" ).append("\n"); 
		query.append(", '' RTN_TO_RTN_USR_ID" ).append("\n"); 
		query.append(", '' RTN_TO_RTN_STS_CD" ).append("\n"); 
		query.append(", '' SR_STS_CD" ).append("\n"); 
		query.append(", '' PND_FLG" ).append("\n"); 
		query.append(", '' SR_CRNT_STS_CD" ).append("\n"); 
		query.append(", '' PIC_ID" ).append("\n"); 
		query.append(", '' TOTAL_CNT" ).append("\n"); 
		query.append(", '' ROWS_PER_PAGE" ).append("\n"); 
		query.append(", '' CURR_PAGE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' RETURN_TO" ).append("\n"); 
		query.append(", '' BL_DOC_INP_FLG" ).append("\n"); 
		query.append(", '' BL_RT_FLG" ).append("\n"); 
		query.append(", '' BL_AUD_FLG" ).append("\n"); 
		query.append(", '' BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append(", '' SR_WRK_STS_CD" ).append("\n"); 
		query.append(", '' SR_WRK_STS_USR_ID" ).append("\n"); 
		query.append(", '' TOTAL_INPUT" ).append("\n"); 
		query.append(", '' TOTAL_RATE" ).append("\n"); 
		query.append(", '' TOTAL_QA" ).append("\n"); 
		query.append(", '' TOTAL_FAX" ).append("\n"); 
		query.append(", '' TOTAL_PENDING" ).append("\n"); 
		query.append(", '' TOTAL_WORKING" ).append("\n"); 
		query.append(", '' TOTAL_CANCELED" ).append("\n"); 
		query.append(", '' TOTAL_COMPLETED" ).append("\n"); 
		query.append(", '' TOTAL_NA" ).append("\n"); 
		query.append(", '' TOTAL_BDR" ).append("\n"); 
		query.append(", '' TOTAL_PCT" ).append("\n"); 
		query.append(", '' IMG_FILE_REAL_PATH" ).append("\n"); 
		query.append(", '' BKG_OFC_CD" ).append("\n"); 
		query.append(", '' SR_NO" ).append("\n"); 
		query.append(", '' TOTAL_SR" ).append("\n"); 
		query.append(", '' TOTAL_NORMAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}