/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchLedgerCombinationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOSearchLedgerCombinationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Ledger Combination
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchLedgerCombinationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aset_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchLedgerCombinationRSQL").append("\n"); 
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
		query.append("SELECT B.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB A," ).append("\n"); 
		query.append("     SCO_LEGR_CD_CMB B" ).append("\n"); 
		query.append("WHERE A.SGM_CTNT1 = B.SGM_CTNT1" ).append("\n"); 
		query.append("AND A.SGM_CTNT2 = B.SGM_CTNT2" ).append("\n"); 
		query.append("AND A.CD_CMB_SEQ = @[aset_cd_cmb_seq]" ).append("\n"); 
		query.append("AND B.SGM_CTNT4 = @[ar_acct_cd]" ).append("\n"); 
		query.append("#if (${acct_ctnt2} != '')" ).append("\n"); 
		query.append("	AND B.SGM_CTNT3 = @[acct_ctnt2]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND A.SGM_CTNT3 = B.SGM_CTNT3" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_ctnt1} == 'WRTF')" ).append("\n"); 
		query.append("	#if (${acct_ctnt3} == 'COM')" ).append("\n"); 
		query.append("		AND A.SGM_CTNT5 = B.SGM_CTNT5" ).append("\n"); 
		query.append("		AND B.SGM_CTNT6 = 'CNTC0000MM'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.SGM_CTNT5 = B.SGM_CTNT5" ).append("\n"); 
		query.append("		AND A.SGM_CTNT6 = B.SGM_CTNT6" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#elseif (${acct_ctnt1} == 'SYS')" ).append("\n"); 
		query.append("	#if (${acct_ctnt3} != '')" ).append("\n"); 
		query.append("		AND B.SGM_CTNT5 = @[acct_ctnt3]" ).append("\n"); 
		query.append("		AND A.SGM_CTNT6 = B.SGM_CTNT6" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND A.SGM_CTNT5 = B.SGM_CTNT5" ).append("\n"); 
		query.append("		AND A.SGM_CTNT6 = B.SGM_CTNT6" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND A.SGM_CTNT5 = B.SGM_CTNT5" ).append("\n"); 
		query.append("	AND A.SGM_CTNT6 = B.SGM_CTNT6" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND @[gl_dt] BETWEEN NVL(B.COA_ST_DT, @[gl_dt]) AND NVL(B.COA_END_DT, @[gl_dt])" ).append("\n"); 
		query.append("AND B.ENBL_FLG = 'Y'" ).append("\n"); 

	}
}