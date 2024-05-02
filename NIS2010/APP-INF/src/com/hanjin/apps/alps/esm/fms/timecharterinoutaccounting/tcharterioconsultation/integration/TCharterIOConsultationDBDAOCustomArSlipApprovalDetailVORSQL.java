/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.16 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slip Approval AR Detail
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomArSlipApprovalDetailVORSQL").append("\n"); 
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
		query.append("'' AR_IF_NO" ).append("\n"); 
		query.append(",'' AR_IF_SER_NO" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' CHG_CD" ).append("\n"); 
		query.append(",'' REP_CHG_CD" ).append("\n"); 
		query.append(",'' CHG_AMT" ).append("\n"); 
		query.append(",'' TRF_RT_AMT" ).append("\n"); 
		query.append(",'' RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(",'' SOB_ID" ).append("\n"); 
		query.append(",'' CHG_FULL_NM" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' TAX_AMT" ).append("\n"); 
		query.append(",'' REV_COA_CO_CD" ).append("\n"); 
		query.append(",'' REV_COA_RGN_CD" ).append("\n"); 
		query.append(",'' REV_COA_CTR_CD" ).append("\n"); 
		query.append(",'' REV_COA_ACCT_CD" ).append("\n"); 
		query.append(",'' REV_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",'' REV_COA_VSL_CD" ).append("\n"); 
		query.append(",'' REV_COA_VOY_NO" ).append("\n"); 
		query.append(",'' REV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append(",'' REV_COA_DIR_CD" ).append("\n"); 
		query.append(",'' ACCT_CD" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' JO_REV_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}