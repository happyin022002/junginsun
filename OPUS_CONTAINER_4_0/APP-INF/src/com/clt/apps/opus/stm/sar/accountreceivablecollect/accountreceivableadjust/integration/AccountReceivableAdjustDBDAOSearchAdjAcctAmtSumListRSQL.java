/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchAdjAcctAmtSumListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchAdjAcctAmtSumListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search sum of adj_acct_amt
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchAdjAcctAmtSumListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchAdjAcctAmtSumListRSQL").append("\n"); 
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
		query.append("SELECT SUM(ADJ_ACCT_AMT) ADJ_ACCT_AMT" ).append("\n"); 
		query.append("FROM   SAR_ADJ_HIS  SAH" ).append("\n"); 
		query.append("WHERE  ADJ_TP_CD LIKE 'OFF%'" ).append("\n"); 
		query.append("AND    SAH.ADJ_NO = @[off_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rvs_flg} == 'N')" ).append("\n"); 
		query.append("AND ADJ_STS_CD = 'ADJUST'" ).append("\n"); 
		query.append("#elseif(${rvs_flg} == 'Y')" ).append("\n"); 
		query.append("AND ADJ_STS_CD = 'REVERSE'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}