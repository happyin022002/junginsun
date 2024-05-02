/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchOtsDtrbREVASARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
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

public class AccountReceivableOutstandingDBDAOsearchOtsDtrbREVASARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOtsDtrbREVASA
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchOtsDtrbREVASARSQL(){
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
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchOtsDtrbREVASARSQL").append("\n"); 
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
		query.append("SELECT A.CHG_TP_CD" ).append("\n"); 
		query.append("     , A.INP_DR_AMT" ).append("\n"); 
		query.append("     , A.INP_CR_AMT" ).append("\n"); 
		query.append("     , A.ACCT_DR_AMT" ).append("\n"); 
		query.append("     , A.ACCT_CR_AMT" ).append("\n"); 
		query.append("     , A.CURR_CD" ).append("\n"); 
		query.append("     , A.CONV_XCH_RT" ).append("\n"); 
		query.append("     , 'REV' AS ACCT_CLSS_CD" ).append("\n"); 
		query.append("     , A.OTS_HIS_SEQ" ).append("\n"); 
		query.append("  FROM SAR_OTS_DTRB A" ).append("\n"); 
		query.append(" WHERE A.OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 
		query.append("   AND A.ACCT_CLSS_CD = 'REC'" ).append("\n"); 

	}
}