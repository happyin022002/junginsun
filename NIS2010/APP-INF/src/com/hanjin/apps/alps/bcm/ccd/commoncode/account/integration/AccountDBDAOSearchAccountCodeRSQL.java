/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AccountDBDAOSearchAccountCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOSearchAccountCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.19 조인영 Account Code 정보를 조회한다.
	  * </pre>
	  */
	public AccountDBDAOSearchAccountCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOSearchAccountCodeRSQL").append("\n"); 
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
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append("       ,ACCT_ENG_NM         " ).append("\n"); 
		query.append("       ,ACCT_LOCL_NM        " ).append("\n"); 
		query.append("       ,BUD_IF_FLG          " ).append("\n"); 
		query.append("       ,BUD_USE_FLG         " ).append("\n"); 
		query.append("       ,JNL_CRE_FLG         " ).append("\n"); 
		query.append("       ,ACCTG_MNG_TP_CD     " ).append("\n"); 
		query.append("       ,PND_TGT_FLG         " ).append("\n"); 
		query.append("       ,ESTM_TGT_FLG        " ).append("\n"); 
		query.append("       ,VVD_LVL_FLG1        " ).append("\n"); 
		query.append("       ,VVD_LVL_FLG2        " ).append("\n"); 
		query.append("       ,VVD_LVL_FLG3        " ).append("\n"); 
		query.append("       ,VVD_LVL_FLG4        " ).append("\n"); 
		query.append("       ,VVD_LVL_FLG5        " ).append("\n"); 
		query.append("       ,VVD_LVL_FLG6        " ).append("\n"); 
		query.append("       ,AUTO_CURR_XCH_RT_FLG" ).append("\n"); 
		query.append("       ,ENTR_EXPN_FLG       " ).append("\n"); 
		query.append("       ,CRE_USR_ID          " ).append("\n"); 
		query.append("       ,CRE_DT              " ).append("\n"); 
		query.append("       ,UPD_USR_ID          " ).append("\n"); 
		query.append("       ,UPD_DT              " ).append("\n"); 
		query.append("       ,DELT_FLG            " ).append("\n"); 
		query.append("       ,EAI_EVNT_DT         " ).append("\n"); 
		query.append("       ,EAI_IF_ID           " ).append("\n"); 
		query.append("       ,MODI_ACCT_CD" ).append("\n"); 
		query.append("FROM MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE  ACCT_CD = @[acct_cd]" ).append("\n"); 

	}
}