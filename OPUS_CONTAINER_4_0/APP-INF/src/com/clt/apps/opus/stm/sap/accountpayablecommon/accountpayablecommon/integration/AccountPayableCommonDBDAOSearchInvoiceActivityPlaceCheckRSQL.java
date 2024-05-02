/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchInvoiceActivityPlaceCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchInvoiceActivityPlaceCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Line의 Activity Place에 대한 Validate 처리
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchInvoiceActivityPlaceCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("activity_place",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration ").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchInvoiceActivityPlaceCheckRSQL").append("\n"); 
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
		query.append("SELECT  ACTIVITY_PLACE AS VALUE0" ).append("\n"); 
		query.append("FROM    (SELECT MY.YD_CD AS ACTIVITY_PLACE FROM MDM_YARD MY WHERE MY.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT MO.OFC_CD AS ACTIVITY_PLACE FROM MDM_ORGANIZATION MO WHERE MO.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT ML.LOC_CD AS ACTIVITY_PLACE FROM MDM_LOCATION ML WHERE ML.DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("WHERE   ACTIVITY_PLACE = @[activity_place]" ).append("\n"); 

	}
}