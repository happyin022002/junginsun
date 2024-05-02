/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountPayableCommonDBDAOsearchPopCSRNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.11 
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

public class AccountPayableCommonDBDAOsearchPopCSRNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0003의 검색조건 VO
	  * </pre>
	  */
	public AccountPayableCommonDBDAOsearchPopCSRNoListRSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOsearchPopCSRNoListRSQL").append("\n"); 
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
		query.append("SELECT SIH.INV_NO     AS INV_NO " ).append("\n"); 
		query.append("      ,SIH.INV_DESC   AS INV_DESC" ).append("\n"); 
		query.append("FROM   SAP_INV_HDR SIH" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${inv_no} != '')" ).append("\n"); 
		query.append("   AND  SIH.INV_NO LIKE '%' || @[inv_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND  SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND  SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_flg} == 'P')" ).append("\n"); 
		query.append("   AND  SIH.INV_TP_LU_CD = 'PREPAYMENT'" ).append("\n"); 
		query.append("#elseif (${inv_flg} == 'S')" ).append("\n"); 
		query.append("   AND  SIH.INV_TP_LU_CD <> 'PREPAYMENT'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}