/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualAccountCodeRSQL.java
*@FileTitle : Accrual Result by Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualAccountCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계정코드조회   
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualAccountCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualAccountCodeRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT(A.ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append(",A.REP_ACCT_CD" ).append("\n"); 
		query.append(",B.MN_COST_TP_CD" ).append("\n"); 
		query.append(",B.SUB_COST_TP_CD" ).append("\n"); 
		query.append(",B.SUB_COST_TP_NM" ).append("\n"); 
		query.append(",A.ACCT_NM 	ACCT_NM" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	DISTINCT SUB_COST_TP_CD SUB_COST_TP_CD, ACCT_CD ACCT_CD, ACCT_NM, REP_ACCT_CD" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	DISTINCT 'TMOC' SUB_COST_TP_CD, OTR_CRR_ACCT_CD ACCT_CD, OTR_CRR_ACCT_NM ACCT_NM, OTR_CRR_REP_ACCT_CD  REP_ACCT_CD" ).append("\n"); 
		query.append("FROM	LEA_LGS_COST    --Terminal Handling - Other Carrier" ).append("\n"); 
		query.append("WHERE	OTR_CRR_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",LEA_SUB_COST_TP B" ).append("\n"); 
		query.append("WHERE	A.SUB_COST_TP_CD = B.SUB_COST_TP_CD" ).append("\n"); 
		query.append("ORDER BY	A.ACCT_CD" ).append("\n"); 
		query.append(",A.REP_ACCT_CD" ).append("\n"); 
		query.append(",B.MN_COST_TP_CD" ).append("\n"); 
		query.append(",B.SUB_COST_TP_CD" ).append("\n"); 
		query.append(",B.SUB_COST_TP_NM" ).append("\n"); 
		query.append(",A.ACCT_NM" ).append("\n"); 

	}
}