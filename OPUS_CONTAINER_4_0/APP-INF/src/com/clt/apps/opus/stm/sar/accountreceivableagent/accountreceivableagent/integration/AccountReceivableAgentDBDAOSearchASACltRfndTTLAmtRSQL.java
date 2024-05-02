/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASACltRfndTTLAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOSearchASACltRfndTTLAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get SUM ASA Collection & Refund TTL Amount
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASACltRfndTTLAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchASACltRfndTTLAmtRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("       MAX(AR_OFC_CD)  AS AR_OFC_CD" ).append("\n"); 
		query.append("     , MAX(ASA_CURR_CD)  AS ASA_CURR_CD" ).append("\n"); 
		query.append("     , SUM(DECODE(ASA_TP_CD, 'C',TTL_AMT,-1 * TTL_AMT)) TTL_AMT" ).append("\n"); 
		query.append("FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("WHERE ASA_NO = @[asa_no]" ).append("\n"); 

	}
}