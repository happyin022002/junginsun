/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOsearchASADtlForUpdateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.22 
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

public class AccountReceivableAgentDBDAOsearchASADtlForUpdateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchASADtlForUpdate
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOsearchASADtlForUpdateRSQL(){
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
		query.append("FileName : AccountReceivableAgentDBDAOsearchASADtlForUpdateRSQL").append("\n"); 
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
		query.append("SELECT    " ).append("\n"); 
		query.append("                A.ASA_NO" ).append("\n"); 
		query.append("              , A.ASA_DTL_SEQ" ).append("\n"); 
		query.append("              , A.ASA_DTL_DESC" ).append("\n"); 
		query.append("              , A.ASA_DR_AMT" ).append("\n"); 
		query.append("              , A.ASA_CR_AMT" ).append("\n"); 
		query.append("              , A.EFF_DT" ).append("\n"); 
		query.append("              , A.ASA_DTL_TP_CD" ).append("\n"); 
		query.append("              , A.CRE_USR_ID" ).append("\n"); 
		query.append("              , A.CRE_DT" ).append("\n"); 
		query.append("              , A.UPD_USR_ID" ).append("\n"); 
		query.append("              , A.UPD_DT" ).append("\n"); 
		query.append("    FROM      SAR_ASA_DTL  A                " ).append("\n"); 
		query.append("    WHERE     1 = 1      " ).append("\n"); 
		query.append("      AND    A.ASA_NO = @[asa_no]  	  " ).append("\n"); 
		query.append("    FOR UPDATE OF ASA_DTL_SEQ WAIT 30" ).append("\n"); 
		query.append("ORDER BY A.ASA_DTL_SEQ" ).append("\n"); 

	}
}