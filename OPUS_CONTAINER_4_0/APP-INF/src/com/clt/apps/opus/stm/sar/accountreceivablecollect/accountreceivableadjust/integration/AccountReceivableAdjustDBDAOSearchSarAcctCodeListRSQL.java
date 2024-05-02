/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSarAcctCodeListRSQL.java
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

public class AccountReceivableAdjustDBDAOSearchSarAcctCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search AR/GAIN/LOSS Account Code
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSarAcctCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSarAcctCodeListRSQL").append("\n"); 
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
		query.append("SELECT AR_ACCT_CD," ).append("\n"); 
		query.append("  LEGR_XCH_DIFF_INCM_ACCT_CD," ).append("\n"); 
		query.append("  LEGR_XCH_DIFF_LSS_ACCT_CD" ).append("\n"); 
		query.append("FROM SAR_ACCT_MTX SAM" ).append("\n"); 
		query.append("WHERE SAM.ACCT_CTNT1 = 'ADJ'" ).append("\n"); 
		query.append("  AND SAM.ACCT_TP_CD = @[adj_tp_cd]" ).append("\n"); 

	}
}