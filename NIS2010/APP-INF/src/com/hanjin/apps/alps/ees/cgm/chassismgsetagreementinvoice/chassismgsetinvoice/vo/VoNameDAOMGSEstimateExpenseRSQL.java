/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VoNameDAOMGSEstimateExpenseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.02.01 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoNameDAOMGSEstimateExpenseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VoNameDAOMGSEstimateExpenseRSQL
	  * </pre>
	  */
	public VoNameDAOMGSEstimateExpenseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo").append("\n"); 
		query.append("FileName : VoNameDAOMGSEstimateExpenseRSQL").append("\n"); 
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
		query.append("'' AS PERIOD_EDDT" ).append("\n"); 
		query.append(",'' AS EXE_YRMON" ).append("\n"); 
		query.append(",'' AS SYS_SRC_ID" ).append("\n"); 
		query.append(",'' AS REV_YRMON" ).append("\n"); 
		query.append(",'' AS ACCT_CD" ).append("\n"); 
		query.append(",'' AS AGMT_NO" ).append("\n"); 
		query.append(",'' AS AGMT_LSTM_CD" ).append("\n"); 
		query.append(",'' AS CHSS_POOL_CD" ).append("\n"); 
		query.append(",'' AS ESTM_SEQ_NO" ).append("\n"); 
		query.append(",'' AS VSL_CD" ).append("\n"); 
		query.append(",'' AS SKD_VOY_NO" ).append("\n"); 
		query.append(",'' AS SKD_DIR_CD" ).append("\n"); 
		query.append(",'' AS REV_DIR_CD" ).append("\n"); 
		query.append(",'' AS REV_VVD" ).append("\n"); 
		query.append(",'' AS ESTM_AMT" ).append("\n"); 
		query.append(",'' AS ACT_AMT" ).append("\n"); 
		query.append(",'' AS ACCL_AMT" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS CRE_DT" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_DT" ).append("\n"); 
		query.append(",'' AS REV_MONTH" ).append("\n"); 
		query.append(",'' AS DIV" ).append("\n"); 
		query.append(",'' AS INVO_NO" ).append("\n"); 
		query.append(",'' AS OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}