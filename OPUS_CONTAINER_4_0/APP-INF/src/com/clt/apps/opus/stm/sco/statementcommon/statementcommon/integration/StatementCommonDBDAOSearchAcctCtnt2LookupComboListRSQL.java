/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchAcctCtnt2LookupComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchAcctCtnt2LookupComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAcctCtnt2LookupComboList
	  * </pre>
	  */
	public StatementCommonDBDAOSearchAcctCtnt2LookupComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchAcctCtnt2LookupComboListRSQL").append("\n"); 
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
		query.append("SELECT LU_CD, LU_DESC" ).append("\n"); 
		query.append("FROM   SCO_LU_DTL" ).append("\n"); 
		query.append("WHERE  LU_TP_CD LIKE 'ACCT CTNT2%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_acct_ctnt1} == 'REC' or ${f_acct_ctnt1} == 'REV')" ).append("\n"); 
		query.append("AND    ATTR_CTNT1 IN (@[f_acct_ctnt1], 'OTS')" ).append("\n"); 
		query.append("#elseif (${f_acct_ctnt1} == 'ALL' or ${f_acct_ctnt1} == '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND    ATTR_CTNT1 = (@[f_acct_ctnt1])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}