/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOCustomArSlipApprovalHeaderVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.09.04 윤세영
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

public class TCharterIOConsultationDBDAOCustomArSlipApprovalHeaderVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR Slip Approval Header
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOCustomArSlipApprovalHeaderVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOCustomArSlipApprovalHeaderVORSQL").append("\n"); 
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
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' AR_SRC_CD" ).append("\n"); 
		query.append(",'' INV_NO" ).append("\n"); 
		query.append(",'' RHQ_CD" ).append("\n"); 
		query.append(",'' AR_OFC_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_SEQ" ).append("\n"); 
		query.append(",'' INV_CUST_CNT_CD" ).append("\n"); 
		query.append(",'' INV_CUST_SEQ" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' SKD_DIR_CD" ).append("\n"); 
		query.append(",'' TRNK_VSL_CD" ).append("\n"); 
		query.append(",'' TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append(",'' TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append(",'' REV_VSL_CD" ).append("\n"); 
		query.append(",'' REV_SKD_VOY_NO" ).append("\n"); 
		query.append(",'' REV_SKD_DIR_CD" ).append("\n"); 
		query.append(",'' REV_DIR_CD" ).append("\n"); 
		query.append(",'' SAIL_ARR_DT" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' SLAN_CD" ).append("\n"); 
		query.append(",'' IO_BND_CD" ).append("\n"); 
		query.append(",'' CUST_CR_FLG" ).append("\n"); 
		query.append(",'' DUE_DT" ).append("\n"); 
		query.append(",'' USD_AMT" ).append("\n"); 
		query.append(",'' LOCL_AMT" ).append("\n"); 
		query.append(",'' ZN_IOC_CD" ).append("\n"); 
		query.append(",'' ERP_IF_FLG" ).append("\n"); 
		query.append(",'' ERP_IF_DT" ).append("\n"); 
		query.append(",'' ERR_MSG" ).append("\n"); 
		query.append(",'' RLANE_CD" ).append("\n"); 
		query.append(",'' INV_CTRT_NO" ).append("\n"); 
		query.append(",'' CR_TERM_DYS" ).append("\n"); 
		query.append(",'' SAIL_DT" ).append("\n"); 
		query.append(",'' XCH_RT_TP_CD" ).append("\n"); 
		query.append(",'' AR_TAX_IND_CD" ).append("\n"); 
		query.append(",'' SLS_OFC_CD" ).append("\n"); 
		query.append(",'' INV_RMK" ).append("\n"); 
		query.append(",'' INV_RMK_ENC" ).append("\n"); 
		query.append(",'' INV_COA_CO_CD" ).append("\n"); 
		query.append(",'' INV_COA_RGN_CD" ).append("\n"); 
		query.append(",'' INV_COA_CTR_CD" ).append("\n"); 
		query.append(",'' INV_COA_ACCT_CD" ).append("\n"); 
		query.append(",'' INV_COA_INTER_CO_CD" ).append("\n"); 
		query.append(",'' INV_COA_VSL_CD" ).append("\n"); 
		query.append(",'' INV_COA_VOY_NO" ).append("\n"); 
		query.append(",'' INV_COA_SKD_DIR_CD" ).append("\n"); 
		query.append(",'' INV_COA_REV_DIR_CD" ).append("\n"); 
		query.append(",'' GL_DT" ).append("\n"); 
		query.append(",'' TAX_XCH_RT" ).append("\n"); 
		query.append(",'' AR_CTY_CD" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' USR_ID" ).append("\n"); 
		query.append(",'' LOG_UPD_DT" ).append("\n"); 
		query.append(",'' ISS_DT" ).append("\n"); 
		query.append(",'' SLP_NO" ).append("\n"); 
		query.append(",'' CSR_OFFST_NO" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}