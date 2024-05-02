/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchCurrencyCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCommonDBDAOsearchCurrencyCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Currency List 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchCurrencyCodeRSQL(){
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
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchCurrencyCodeRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   CURR_CD" ).append("\n"); 
		query.append(" , CURR_NM" ).append("\n"); 
		query.append(" , CURR_DESC" ).append("\n"); 
		query.append(" , CNT_CD" ).append("\n"); 
		query.append(" , FM_EFF_DT" ).append("\n"); 
		query.append(" , TO_EFF_DT" ).append("\n"); 
		query.append(" , DP_PRCS_KNT" ).append("\n"); 
		query.append(" , XTD_PRCS_KNT" ).append("\n"); 
		query.append(" , DELT_FLG" ).append("\n"); 
		query.append(" , EAI_EVNT_DT" ).append("\n"); 
		query.append(" , EAI_IF_ID" ).append("\n"); 
		query.append("FROM MDM_CURRENCY " ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${curr_cd} != '') " ).append("\n"); 
		query.append("AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CURR_CD" ).append("\n"); 

	}
}