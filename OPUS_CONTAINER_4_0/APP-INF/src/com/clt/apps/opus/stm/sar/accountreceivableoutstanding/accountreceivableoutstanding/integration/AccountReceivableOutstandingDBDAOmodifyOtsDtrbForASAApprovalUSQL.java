/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOmodifyOtsDtrbForASAApprovalUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOmodifyOtsDtrbForASAApprovalUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyOtsDtrbForASAApproval
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOmodifyOtsDtrbForASAApprovalUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOmodifyOtsDtrbForASAApprovalUSQL").append("\n"); 
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
		query.append("UPDATE SAR_OTS_DTRB A SET " ).append("\n"); 
		query.append("	    A.GL_INP_DR_AMT = DECODE(A.ACCT_CLSS_CD, 'HDR_RND', NULL, DECODE(INSTR(A.ACCT_CLSS_CD,'EXCH_'),0,A.INP_DR_AMT,NULL))    " ).append("\n"); 
		query.append("	  , A.GL_INP_CR_AMT = DECODE(A.ACCT_CLSS_CD, 'HDR_RND', NULL, DECODE(INSTR(A.ACCT_CLSS_CD,'EXCH_'),0,A.INP_CR_AMT,NULL))" ).append("\n"); 
		query.append("	  , A.GL_ACCT_DR_AMT = A.ACCT_DR_AMT" ).append("\n"); 
		query.append("	  , A.GL_ACCT_CR_AMT = A.ACCT_CR_AMT" ).append("\n"); 
		query.append("	  , A.GL_CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("      , A.GL_CONV_XCH_RT = DECODE(A.ACCT_CLSS_CD, 'HDR_RND', NULL, DECODE(INSTR(A.ACCT_CLSS_CD,'EXCH_'),0,A.CONV_XCH_RT,NULL))" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("      OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 

	}
}