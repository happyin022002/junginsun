/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopAROfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopAROfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR office Code list Inquiry
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopAROfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopAROfficeListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("      , OFC_ENG_NM" ).append("\n"); 
		query.append("      , OFC_LOCL_NM   AS OFC_KRN_NM" ).append("\n"); 
		query.append("FROM    MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE   AR_OFC_CD LIKE '%'||UPPER(@[ofc_cd])||'%'" ).append("\n"); 
		query.append("AND     OFC_CD IN (SELECT AR_OFC_CD FROM MDM_ORGANIZATION)" ).append("\n"); 
		query.append("#if (${security_flag} == '')" ).append("\n"); 
		query.append("   AND  SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC(UPPER(@[ofc_cd]), @[usr_id]), AP_OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}