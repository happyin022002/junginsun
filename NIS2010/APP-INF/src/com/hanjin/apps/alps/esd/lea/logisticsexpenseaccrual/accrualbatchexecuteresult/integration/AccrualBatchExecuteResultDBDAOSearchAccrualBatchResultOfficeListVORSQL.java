/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAccrualBatchResultOfficeListVO
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultOfficeListVORSQL").append("\n"); 
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
		query.append("'' AS RHQ_CD" ).append("\n"); 
		query.append(", '' AS CTRL_OFC_CD" ).append("\n"); 
		query.append(", '' AS SUB_OFC_CD" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_F" ).append("\n"); 
		query.append(", '' AS REV_YRMON" ).append("\n"); 
		query.append(", '' AS EXE_YRMON" ).append("\n"); 
		query.append(", '' AS COA_COST_SRC_CD" ).append("\n"); 
		query.append(", '' AS N2ND_NOD_CD" ).append("\n"); 
		query.append(", '' AS ADJ_ACCL_COST_AMT" ).append("\n"); 
		query.append(", '' AS MN_COST_TP_NM" ).append("\n"); 
		query.append(", '' AS F_RHQ_CD" ).append("\n"); 
		query.append(", '' AS DIF_COST_AMT" ).append("\n"); 
		query.append(", '' AS ESTM_COST_AMT" ).append("\n"); 
		query.append(", '' AS SUB_COST_TP_NM" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_V" ).append("\n"); 
		query.append(", '' AS F_CTRL_OFC_CD" ).append("\n"); 
		query.append(", '' AS N4TH_NOD_CD" ).append("\n"); 
		query.append(", '' AS N1ST_NOD_CD" ).append("\n"); 
		query.append(", '' AS ACCT_CD" ).append("\n"); 
		query.append(", '' AS F_REPORT" ).append("\n"); 
		query.append(", '' AS CFM_COST_AMT" ).append("\n"); 
		query.append(", '' AS CNTR_QTY" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_M" ).append("\n"); 
		query.append(", '' AS PRE_ACT_COST_AMT" ).append("\n"); 
		query.append(", '' AS PST_ACT_COST_AMT" ).append("\n"); 
		query.append(", '' AS N3RD_NOD_CD" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_C" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_U" ).append("\n"); 
		query.append(", '' AS FRM_REV_YRMON_TO" ).append("\n"); 
		query.append(", '' AS FRM_REV_YRMON_FROM" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_FV" ).append("\n"); 
		query.append(", '' AS F_COST_TYPE_EV" ).append("\n"); 
		query.append(", '' AS F_SUB_OFC_CD" ).append("\n"); 
		query.append(", '' AS ACT_COST_AMT" ).append("\n"); 
		query.append(", '' AS DIF_ACT_COST_AMT" ).append("\n"); 
		query.append(", '' AS ACT_COST_RATIO" ).append("\n"); 
		query.append(", '' AS BIND_OFC_CD" ).append("\n"); 
		query.append(", '' AS BIND_SUB_OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}