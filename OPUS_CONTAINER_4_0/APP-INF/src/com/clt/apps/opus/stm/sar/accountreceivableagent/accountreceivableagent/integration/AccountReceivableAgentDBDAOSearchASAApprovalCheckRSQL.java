/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASAApprovalCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
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

public class AccountReceivableAgentDBDAOSearchASAApprovalCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchASAApprovalCheck
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASAApprovalCheckRSQL(){
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
		query.append("FileName : AccountReceivableAgentDBDAOSearchASAApprovalCheckRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(BAT_RSLT_CD),'N') AS BAT_RSLT_CD FROM " ).append("\n"); 
		query.append("(  " ).append("\n"); 
		query.append("SELECT BAT_RSLT_CD" ).append("\n"); 
		query.append("  FROM SCO_BAT_HIS" ).append("\n"); 
		query.append(" WHERE BAT_PGM_NO = 'STM_SAR_B5002'" ).append("\n"); 
		query.append("   AND APPL_PGM_NO = 'STM_SAR_5002'" ).append("\n"); 
		query.append("   AND BAT_PARA_CTNT LIKE @[asa_no]||'%'" ).append("\n"); 
		query.append("   AND BAT_RSLT_CD = 'S'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BAT_RSLT_CD" ).append("\n"); 
		query.append("  FROM SCO_BAT_HIS" ).append("\n"); 
		query.append(" WHERE BAT_PGM_NO = 'STM_SAR_B5002'" ).append("\n"); 
		query.append("   AND APPL_PGM_NO = 'STM_SAR_5002'" ).append("\n"); 
		query.append("   AND BAT_PARA_CTNT LIKE @[asa_no]||'%'" ).append("\n"); 
		query.append("   AND BAT_RSLT_CD <> 'E'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}