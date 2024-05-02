/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOsearchAutosettlementSetupDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOsearchAutosettlementSetupDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Sail Arrival Date, GL Date, Balance Update Date
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOsearchAutosettlementSetupDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("l_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOsearchAutosettlementSetupDateRSQL").append("\n"); 
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
		query.append("    TO_CHAR(ADD_MONTHS(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT AR_OFC_CD                                           " ).append("\n"); 
		query.append("						   FROM MDM_ORGANIZATION                                           " ).append("\n"); 
		query.append("						   WHERE OFC_CD = @[l_ofc_cd])), - 2)," ).append("\n"); 
		query.append("       'YYYYMMDD') AS SAIL_ARR_DT," ).append("\n"); 
		query.append("	TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT AR_OFC_CD                                           " ).append("\n"); 
		query.append("						   FROM MDM_ORGANIZATION                                           " ).append("\n"); 
		query.append("						   WHERE OFC_CD = @[l_ofc_cd]))," ).append("\n"); 
		query.append("       'YYYYMMDD') AS ADJ_DT," ).append("\n"); 
		query.append("    TO_CHAR(ADD_MONTHS(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT AR_OFC_CD                                           " ).append("\n"); 
		query.append("						   FROM MDM_ORGANIZATION                                           " ).append("\n"); 
		query.append("						   WHERE OFC_CD = @[l_ofc_cd])), - 1)," ).append("\n"); 
		query.append("       'YYYYMMDD') AS BAL_UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}