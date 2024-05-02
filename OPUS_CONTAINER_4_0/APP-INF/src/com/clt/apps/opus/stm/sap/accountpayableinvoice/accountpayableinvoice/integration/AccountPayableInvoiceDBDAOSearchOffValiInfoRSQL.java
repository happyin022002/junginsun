/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchOffValiInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchOffValiInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOffValiInfo
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchOffValiInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchOffValiInfoRSQL").append("\n"); 
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
		query.append("SELECT MO.AP_OFC_CD        AS VALUE0" ).append("\n"); 
		query.append("      ,MO.SO_IF_CD         AS VALUE1" ).append("\n"); 
		query.append("      ,MO.AP_CTR_CD        AS VALUE2" ).append("\n"); 
		query.append("      ,MO.FINC_RGN_CD      AS VALUE3" ).append("\n"); 
		query.append("      ,NVL(ML.CNT_CD, SUBSTR(MO.LOC_CD, 1, 2)) AS VALUE4" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("     , MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE  MO.LOC_CD = ML.LOC_CD(+)" ).append("\n"); 
		query.append("AND    MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${security_flag} == '')" ).append("\n"); 
		query.append("   AND  MO.OFC_CD IN (SELECT AP_OFC_CD FROM MDM_ORGANIZATION)" ).append("\n"); 
		query.append("   AND  SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC(@[login_ofc_cd], @[usr_id]), MO.AP_OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}