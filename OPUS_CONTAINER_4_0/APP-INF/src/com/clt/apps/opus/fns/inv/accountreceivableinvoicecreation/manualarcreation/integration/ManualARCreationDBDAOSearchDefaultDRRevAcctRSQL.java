/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualARCreationDBDAOSearchDefaultDRRevAcctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOSearchDefaultDRRevAcctRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDefaultDRRevAcct
	  * </pre>
	  */
	public ManualARCreationDBDAOSearchDefaultDRRevAcctRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOSearchDefaultDRRevAcctRSQL").append("\n"); 
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
		query.append("SELECT AR_ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_TP_NM ACCT_ENG_NM" ).append("\n"); 
		query.append("FROM SAR_ACCT_MTX" ).append("\n"); 
		query.append("WHERE ACCT_CTNT1 = 'REC'" ).append("\n"); 
		query.append("AND ACCT_CTNT2 = 'INVAR'" ).append("\n"); 
		query.append("AND ACCT_TP_CD = 'MTH'" ).append("\n"); 
		query.append("#if (${gl_eff_dt} != '')" ).append("\n"); 
		query.append("AND NVL(ACCT_END_DT, REPLACE(@[gl_eff_dt],'-','')) >= REPLACE(@[gl_eff_dt],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ROWNUM = 1 " ).append("\n"); 

	}
}