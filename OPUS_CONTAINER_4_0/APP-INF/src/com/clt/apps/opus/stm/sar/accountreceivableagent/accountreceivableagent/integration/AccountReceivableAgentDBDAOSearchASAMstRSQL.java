/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASAMstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
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

public class AccountReceivableAgentDBDAOSearchASAMstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select SAR_ASA_MST
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASAMstRSQL(){
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
		query.append("FileName : AccountReceivableAgentDBDAOSearchASAMstRSQL").append("\n"); 
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
		query.append("SELECT    ASA_NO" ).append("\n"); 
		query.append("              , AGN_CD" ).append("\n"); 
		query.append("              , ASA_PRD_FM_DT" ).append("\n"); 
		query.append("              , ASA_PRD_TO_DT" ).append("\n"); 
		query.append("              , CURR_CD" ).append("\n"); 
		query.append("              , ACT_BAL_AMT" ).append("\n"); 
		query.append("              , TO_CHAR(ASA_FSH_DT,'YYYY-MM-DD HH:MI:SS')  ASA_FSH_DT" ).append("\n"); 
		query.append("              , ASA_FSH_USR_ID" ).append("\n"); 
		query.append("              , ASA_APRO_USR_ID" ).append("\n"); 
		query.append("              , TO_CHAR(ASA_APRO_DT,'YYYY-MM-DD HH:MI:SS')  ASA_APRO_DT" ).append("\n"); 
		query.append("              , NVL(ASA_NO_CTNT1,SUBSTR(AGN_CD,0,3)) AS ASA_NO_CTNT1" ).append("\n"); 
		query.append("              , ASA_NO_CTNT2" ).append("\n"); 
		query.append("              , ASA_NO_CTNT3" ).append("\n"); 
		query.append("              , ASA_STS_CD" ).append("\n"); 
		query.append("              , PRE_ASA_NO" ).append("\n"); 
		query.append("              , OFC_CD" ).append("\n"); 
		query.append("              , CRE_USR_ID" ).append("\n"); 
		query.append("              , CRE_DT" ).append("\n"); 
		query.append("              , UPD_USR_ID" ).append("\n"); 
		query.append("              , UPD_DT" ).append("\n"); 
		query.append("    FROM      SAR_ASA_MST" ).append("\n"); 
		query.append("    WHERE     1 = 1        " ).append("\n"); 
		query.append("      AND     ASA_NO = @[asa_no]" ).append("\n"); 

	}
}