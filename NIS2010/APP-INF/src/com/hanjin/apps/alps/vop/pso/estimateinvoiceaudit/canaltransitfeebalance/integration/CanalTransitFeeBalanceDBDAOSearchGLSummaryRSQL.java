/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceDBDAOSearchGLSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.10.23 정명훈
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

public class CanalTransitFeeBalanceDBDAOSearchGLSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/L Data Summay
	  * </pre>
	  */
	public CanalTransitFeeBalanceDBDAOSearchGLSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeBalanceDBDAOSearchGLSummaryRSQL").append("\n"); 
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
		query.append("SELECT 'THIS' SECTION" ).append("\n"); 
		query.append(",SUM(DECODE(SUBSTR(A.INV_NO, 13, 3), 'ADV', INV_TTL_AMT, 0)) DEBIT" ).append("\n"); 
		query.append(",SUM(DECODE(SUBSTR(INV_NO, 13, 3), 'INV', INV_TTL_AMT, 'OWN', INV_TTL_AMT, 0)) CREDIT" ).append("\n"); 
		query.append(",NULL AMT" ).append("\n"); 
		query.append("FROM   AP_PAY_INV A" ).append("\n"); 
		query.append(",AP_INV_HDR B" ).append("\n"); 
		query.append("WHERE  A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("AND    B.GL_DT >= REPLACE(@[rqst_dt], '-', '') || '01' AND B.GL_DT < TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[rqst_dt], '-', ''), 'YYYYMM'), 1), 'YYYYMM') || '01'" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    SUBSTR(A.INV_NO, 13, 3) IN ('ADV', 'INV', 'OWN')" ).append("\n"); 
		query.append("AND    RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("AND    IF_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'PREV' SECTION" ).append("\n"); 
		query.append(",NULL DEBIT" ).append("\n"); 
		query.append(",NULL CREDIT" ).append("\n"); 
		query.append(",SUM(DECODE(SUBSTR(A.INV_NO, 13, 3), 'ADV', INV_TTL_AMT, 0)) -  SUM(DECODE(SUBSTR(INV_NO, 13, 3),'INV', INV_TTL_AMT, 'OWN', INV_TTL_AMT, 0)) AMT" ).append("\n"); 
		query.append("FROM   AP_PAY_INV A" ).append("\n"); 
		query.append(",AP_INV_HDR B" ).append("\n"); 
		query.append("WHERE  A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("AND    B.GL_DT >= TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[rqst_dt], '-', ''), 'YYYYMM'), -1), 'YYYYMM') || '01' AND B.GL_DT < REPLACE(@[rqst_dt], '-', '') || '01'" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    SUBSTR(A.INV_NO, 13, 3) IN ('ADV', 'INV', 'OWN')" ).append("\n"); 
		query.append("AND    RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("AND    IF_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'THIS' SECTION" ).append("\n"); 
		query.append(",NULL DEBIT" ).append("\n"); 
		query.append(",NULL CREDIT" ).append("\n"); 
		query.append(",SUM(DECODE(SUBSTR(A.INV_NO, 13, 3), 'ADV', INV_TTL_AMT, 0)) -SUM(DECODE(SUBSTR(INV_NO, 13, 3),'INV',INV_TTL_AMT,'OWN',INV_TTL_AMT, 0)) AMT" ).append("\n"); 
		query.append("FROM   AP_PAY_INV A" ).append("\n"); 
		query.append(",AP_INV_HDR B" ).append("\n"); 
		query.append("WHERE  A.CSR_NO = B.CSR_NO" ).append("\n"); 
		query.append("AND    B.GL_DT >= REPLACE(@[rqst_dt], '-', '') || '01' AND B.GL_DT < TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[rqst_dt], '-', ''), 'YYYYMM'), 1), 'YYYYMM') || '01'" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    SUBSTR(A.INV_NO, 13, 3) IN ('ADV', 'INV', 'OWN')" ).append("\n"); 
		query.append("AND    RCV_ERR_FLG IS NULL" ).append("\n"); 
		query.append("AND    IF_FLG = 'Y'" ).append("\n"); 

	}
}