/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueDetailListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.12
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.04.12 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAODocQueueDetailListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueDetailListVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueDetailListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueDetailListVORSQL").append("\n"); 
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
		query.append("/* DocQueueDetailList VO*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' BKG_NO" ).append("\n"); 
		query.append(", '' P_SR_KIND_CD" ).append("\n"); 
		query.append(", '' SR_KIND" ).append("\n"); 
		query.append(", '' URGENCY_CD" ).append("\n"); 
		query.append(", '' URGENCY" ).append("\n"); 
		query.append(", '' SOURCE" ).append("\n"); 
		query.append(", '' VVD" ).append("\n"); 
		query.append(", '' SR_NO" ).append("\n"); 
		query.append(", '' POL_CD" ).append("\n"); 
		query.append(", '' POD_CD" ).append("\n"); 
		query.append(", '' PAGE" ).append("\n"); 
		query.append(", '' SHIPPER_CNT_CD" ).append("\n"); 
		query.append(", '' SHIPPER_SEQ" ).append("\n"); 
		query.append(", '' SHIPPER_NM" ).append("\n"); 
		query.append(", '' SEQ" ).append("\n"); 
		query.append(", '' SR_STS" ).append("\n"); 
		query.append(", '' SR_STS_CD" ).append("\n"); 
		query.append(", '' RETURN_CD" ).append("\n"); 
		query.append(", '' UP_DT" ).append("\n"); 
		query.append(", '' GMT_DT" ).append("\n"); 
		query.append(", '' PIC" ).append("\n"); 
		query.append(", '' MESSAGE" ).append("\n"); 
		query.append(", '' MESSAGE_ALL" ).append("\n"); 
		query.append(", '' PND_FLG" ).append("\n"); 
		query.append(", '' USR_ID" ).append("\n"); 
		query.append(", '' USR_NM" ).append("\n"); 
		query.append(", '' WRK_GRP_CD" ).append("\n"); 
		query.append(", '' SRC_CD" ).append("\n"); 
		query.append(", '' SR_CRNT_INFO_CD" ).append("\n"); 
		query.append(", '' PIC_NM" ).append("\n"); 
		query.append(", '' PIC_OFC_CD" ).append("\n"); 
		query.append(", '' TOTAL_CNT" ).append("\n"); 
		query.append(", '' ROWS_PER_PAGE" ).append("\n"); 
		query.append(", '' CURR_PAGE" ).append("\n"); 
		query.append(", '' PND_FLG" ).append("\n"); 
		query.append(", '' BL_DOC_INP_FLG" ).append("\n"); 
		query.append(", '' BL_RT_FLG" ).append("\n"); 
		query.append(", '' BL_AUD_FLG" ).append("\n"); 
		query.append(", '' BL_DRFT_FAX_OUT_FLG" ).append("\n"); 
		query.append(", '' COM_FLG" ).append("\n"); 
		query.append(", '' MAX_SR_NO" ).append("\n"); 
		query.append(", '' XTER_RQST_NO" ).append("\n"); 
		query.append(", '' XTER_RQST_SEQ" ).append("\n"); 
		query.append(", '' SR_WRK_STS_CD" ).append("\n"); 
		query.append(", '' SR_WRK_STS_USR_ID" ).append("\n"); 
		query.append(", '' IMG_FILE_NM" ).append("\n"); 
		query.append(", '' IMG_FILE_PATH_CTNT" ).append("\n"); 
		query.append(", '' IMG_FILE_REAL_PATH" ).append("\n"); 
		query.append(", '' SR_HIS_SEQ" ).append("\n"); 
		query.append(", '' SEL" ).append("\n"); 
		query.append(", '' SR_KND_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}