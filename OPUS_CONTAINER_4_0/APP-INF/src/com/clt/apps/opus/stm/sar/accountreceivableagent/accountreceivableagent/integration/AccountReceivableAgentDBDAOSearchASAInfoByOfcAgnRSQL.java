/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASAInfoByOfcAgnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.30 
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

public class AccountReceivableAgentDBDAOSearchASAInfoByOfcAgnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search ASA info
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASAInfoByOfcAgnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchASAInfoByOfcAgnRSQL").append("\n"); 
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
		query.append("SELECT MAX(A.ASA_PRD_TO_DT) AS MAX_ASA_PRD_TO_DT" ).append("\n"); 
		query.append("     , COUNT(A.ASA_NO) AS CNT_ASA_NO" ).append("\n"); 
		query.append("     , MAX(A.ASA_NO) AS MAX_ASA_NO             " ).append("\n"); 
		query.append("     , @[ofc_cd] AS OFC_CD" ).append("\n"); 
		query.append("     , @[agn_cd] AS AGN_CD     " ).append("\n"); 
		query.append("     , @[curr_cd] AS CURR_CD" ).append("\n"); 
		query.append("     , 'N' AS OPEN_ASA_YN" ).append("\n"); 
		query.append("     , '' AS ASA_NO" ).append("\n"); 
		query.append("     , '' AS ASA_PRD_FM_DT" ).append("\n"); 
		query.append("     , '' AS ASA_PRD_TO_DT" ).append("\n"); 
		query.append("     , '' AS USER_ID" ).append("\n"); 
		query.append("  FROM SAR_ASA_MST A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("   #if(${open_asa_yn} == 'Y')   " ).append("\n"); 
		query.append("   AND A.ASA_STS_CD IN ('O' , 'F')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}