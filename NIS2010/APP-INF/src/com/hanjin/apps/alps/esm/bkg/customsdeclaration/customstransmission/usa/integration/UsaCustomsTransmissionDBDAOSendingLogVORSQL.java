/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOSendingLogVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.18 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOSendingLogVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim SendingLogVO 작성용.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOSendingLogVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOSendingLogVORSQL").append("\n"); 
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
		query.append("SELECT '' CNT_CD, '' IO_BND_CD, '' SND_DT, '' HIS_SEQ, '' TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("'' VVD, '' POL_CD, '' POD_CD," ).append("\n"); 
		query.append("'' VSL_DEP_RPT_FLG, '' AUTO_VSL_DEP_RPT_FLG, '' SND_USR_ID, '' SND_USR_OFC_CD, '' ACK_TP_NO," ).append("\n"); 
		query.append("'' ACK_SND_KNT, '' CRE_USR_ID, '' ACK_RCV_DT, '' DTL_SEQ, '' EDI_SND_LOG_CTNT, '' UPD_USR_ID," ).append("\n"); 
		query.append("'' ETA_DT, '' ETA_DT_FORMAT, '' CRR_BAT_NO, '' BL_PARAMS, '' ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}