/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountDBDAOSearchCurrCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2011.03.03 조인영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.account.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Cho In Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountDBDAOSearchCurrCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.02.21 조인영 Currency Code 정보를 조회한다.
	  * </pre>
	  */
	public AccountDBDAOSearchCurrCodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.account.integration").append("\n"); 
		query.append("FileName : AccountDBDAOSearchCurrCodeRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append("       ,CURR_NM" ).append("\n"); 
		query.append("       ,CURR_DESC" ).append("\n"); 
		query.append("       ,CNT_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(FM_EFF_DT,'YYYY-MM-DD') AS FM_EFF_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(TO_EFF_DT,'YYYY-MM-DD') AS TO_EFF_DT" ).append("\n"); 
		query.append("       ,DP_PRCS_KNT" ).append("\n"); 
		query.append("       ,XTD_PRCS_KNT" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,DELT_FLG" ).append("\n"); 
		query.append("       ,EAI_EVNT_DT   " ).append("\n"); 
		query.append("       ,EAI_IF_ID" ).append("\n"); 
		query.append("FROM MDM_CURRENCY" ).append("\n"); 
		query.append("WHERE CURR_CD = @[curr_cd]" ).append("\n"); 

	}
}