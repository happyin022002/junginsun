/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOsearchOpenAsaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOsearchOpenAsaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpenAsa
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOsearchOpenAsaRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOsearchOpenAsaRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("    SELECT ASA_NO_CTNT1" ).append("\n"); 
		query.append("          ,ASA_NO_CTNT2" ).append("\n"); 
		query.append("          ,ASA_NO_CTNT3" ).append("\n"); 
		query.append("    FROM SAR_ASA_MST" ).append("\n"); 
		query.append("    WHERE ASA_NO = @[asa_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT ASA_NO" ).append("\n"); 
		query.append("FROM SAR_ASA_MST A" ).append("\n"); 
		query.append(" ,PARAM" ).append("\n"); 
		query.append("WHERE A.ASA_NO_CTNT1 = PARAM.ASA_NO_CTNT1" ).append("\n"); 
		query.append("AND A.ASA_STS_CD = 'O'" ).append("\n"); 
		query.append("AND TO_NUMBER(A.ASA_NO_CTNT2 || A.ASA_NO_CTNT3) >= TO_NUMBER(PARAM.ASA_NO_CTNT2 || PARAM.ASA_NO_CTNT3)" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(A.ASA_NO_CTNT2 || A.ASA_NO_CTNT3) ASC" ).append("\n"); 

	}
}