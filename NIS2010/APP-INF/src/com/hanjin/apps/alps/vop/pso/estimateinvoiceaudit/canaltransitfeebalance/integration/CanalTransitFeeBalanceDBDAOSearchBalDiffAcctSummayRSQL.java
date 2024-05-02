/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceDBDAOSearchBalDiffAcctSummayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.23 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeBalanceDBDAOSearchBalDiffAcctSummayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Balance Diff. Account (Top Grid)
	  * </pre>
	  */
	public CanalTransitFeeBalanceDBDAOSearchBalDiffAcctSummayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyymm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeBalanceDBDAOSearchBalDiffAcctSummayRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(Y.SORT, NULL, '3=1-2', TO_CHAR(LAST_DAY(TO_DATE(Y.YYYYMM, 'YYYY-MM')), 'YYYY-MM-DD'))  DT" ).append("\n"); 
		query.append(",DECODE(Y.SORT, NULL, Y.AMT_, Y.AMT)      AMT" ).append("\n"); 
		query.append(",DECODE(Y.SORT, NULL, '', Y.DESCRIPTION)  DESCRIPTION" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT  MAX(X.YYYYMM)                         YYYYMM" ).append("\n"); 
		query.append(",X.SORT                                SORT" ).append("\n"); 
		query.append(",SUM(X.AMT)                            AMT" ).append("\n"); 
		query.append(",SUM(DECODE(X.SORT, 1, X.AMT, -X.AMT)) AMT_" ).append("\n"); 
		query.append(",MAX(X.DESCRIPTION)                    DESCRIPTION" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT 'GL COEFFICIENT' 			DESCRIPTION" ).append("\n"); 
		query.append(",@[yyyymm]  					YYYYMM" ).append("\n"); 
		query.append(",NVL(SUM(DECODE(SUBSTR(A.INV_NO, 13, 3), 'ADV', INV_TTL_AMT)), 0) - NVL(SUM(DECODE(SUBSTR(INV_NO, 13, 3), 'INV', INV_TTL_AMT, 'OWN', INV_TTL_AMT)), 0) AMT" ).append("\n"); 
		query.append(",1 SORT" ).append("\n"); 
		query.append("FROM   AP_PAY_INV A" ).append("\n"); 
		query.append(",AP_INV_HDR B" ).append("\n"); 
		query.append("WHERE  A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("AND    B.GL_DT >= REPLACE(@[yyyymm], '-', '') || '01' AND B.GL_DT < TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[yyyymm], '-', ''), 'YYYYMM'), 1), 'YYYYMM') || '01'" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    SUBSTR(A.INV_NO, 13, 3) IN ('ADV', 'INV', 'OWN')" ).append("\n"); 
		query.append("AND    RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("AND    IF_FLG = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'ENDING BALANCE' 			DESCRIPTION" ).append("\n"); 
		query.append(",@[yyyymm]  					YYYYMM" ).append("\n"); 
		query.append("--,NVL(SUM(A.TTL_AMT), 0) 		AMT" ).append("\n"); 
		query.append(",NVL(SUM(DECODE(PSO_MSA_AMT_TP_CD, 'B', -1 * A.TTL_AMT, A.TTL_AMT)), 0) 		AMT" ).append("\n"); 
		query.append(",2 SORT" ).append("\n"); 
		query.append("FROM   PSO_MSA_DTL A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.REV_YRMON = REPLACE(@[yyyymm], '-', '')" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ  = @[vndr_seq]" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY ROLLUP(X.SORT)" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("ORDER BY Y.SORT" ).append("\n"); 

	}
}