/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueDetailReturnInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.13
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.13 김기종
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

public class PerformanceReportDBDAODocQueueDetailReturnInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.03 김기종 [CHM-201109394-01] DPCS고도화일환으로 START TIME 관리
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueDetailReturnInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueDetailReturnInVORSQL").append("\n"); 
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
		query.append("/* DocQueueDetailReturnIn VO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  '' SRC_CD" ).append("\n"); 
		query.append(", '' SR_NO" ).append("\n"); 
		query.append(", '' BKG_NO" ).append("\n"); 
		query.append(", '' SR_KND_CD" ).append("\n"); 
		query.append(", '' GRP_CD" ).append("\n"); 
		query.append(", '' USR_ID" ).append("\n"); 
		query.append(", '' UI_GRP_CD" ).append("\n"); 
		query.append(", '' MESSAGE" ).append("\n"); 
		query.append(", '' RSN_BKG_MN_FLG" ).append("\n"); 
		query.append(", '' RSN_CUST_INFO_FLG" ).append("\n"); 
		query.append(", '' RSN_FRT_CHG_FLG" ).append("\n"); 
		query.append(", '' RSN_CNTR_FLG" ).append("\n"); 
		query.append(", '' RSN_CNTR_MF_FLG" ).append("\n"); 
		query.append(", '' RSN_DCGO_FLG" ).append("\n"); 
		query.append(", '' RSN_AWK_CGO_FLG" ).append("\n"); 
		query.append(", '' RSN_RC_FLG" ).append("\n"); 
		query.append(", '' RSN_BB_CGO_FLG" ).append("\n"); 
		query.append(", '' RSN_RLY_PORT_FLG" ).append("\n"); 
		query.append(", '' RSN_NEW_BKG_FLG" ).append("\n"); 
		query.append(", '' RSN_SPLIT_FLG" ).append("\n"); 
		query.append(", '' RSN_BL_INFO_FLG" ).append("\n"); 
		query.append(", '' RSN_HBL_FLG" ).append("\n"); 
		query.append(", '' CUST_VERIF_FLG" ).append("\n"); 
		query.append(", '' SR_HIS_SEQ" ).append("\n"); 
		query.append(", '' UP_DT" ).append("\n"); 
		query.append(", '' RTN_TO_USR_EML" ).append("\n"); 
		query.append(", '' FNT_OFC_EML" ).append("\n"); 
		query.append(", '' INPUTER_EML" ).append("\n"); 
		query.append(", '' RATER_EML" ).append("\n"); 
		query.append(", '' CUST_EML" ).append("\n"); 
		query.append(", '' EML_SND_YN" ).append("\n"); 
		query.append(", '' RTN_SUBJECT" ).append("\n"); 
		query.append(", '' EML_SUBJ_CTNT" ).append("\n"); 
		query.append(", '' EML_CPY_TO_CUST_FLG" ).append("\n"); 
		query.append(", '' ST_DT" ).append("\n"); 
		query.append(", '' SR_STS_CD                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      " ).append("\n"); 
		query.append(", '' SR_PROC_STS_CD" ).append("\n"); 
		query.append(", '' FO_INCL_EML_FLG" ).append("\n"); 
		query.append(", '' RTN_FREQ" ).append("\n"); 
		query.append(", '' FO_RCV_EML" ).append("\n"); 
		query.append(", '' SREP_EML" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}