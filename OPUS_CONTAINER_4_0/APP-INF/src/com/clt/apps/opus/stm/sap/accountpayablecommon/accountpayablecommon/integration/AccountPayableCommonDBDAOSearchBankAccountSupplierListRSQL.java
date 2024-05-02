/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchBankAccountSupplierListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.12 
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

public class AccountPayableCommonDBDAOSearchBankAccountSupplierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bank Account ( Supplier ) 정보 조회
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchBankAccountSupplierListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchBankAccountSupplierListRSQL").append("\n"); 
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
		query.append("SELECT SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      ,SBA.BANK_ACCT_NO" ).append("\n"); 
		query.append("      ,SBA.BANK_ACCT_NM" ).append("\n"); 
		query.append("      ,SBA.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("      ,SBA.CURR_CD" ).append("\n"); 
		query.append("      ,SBA.BANK_ACCT_VNDR_SEQ" ).append("\n"); 
		query.append("      ,(SELECT MV.VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE SBA.BANK_ACCT_VNDR_SEQ = MV.VNDR_SEQ AND ROWNUM = 1 ) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,SBA.BANK_ACCT_PRIO_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(SBA.INACT_DT, 'YYYY-MM-DD') AS INACT_DT" ).append("\n"); 
		query.append("      ,SBA.ATTR_CTNT5" ).append("\n"); 
		query.append("      ,SBA.ATTR_CTNT6" ).append("\n"); 
		query.append("      ,SBA.IBAN_NO" ).append("\n"); 
		query.append("      ,SBA.ATTR_CTNT2" ).append("\n"); 
		query.append("      ,SBA.CNTC_AREA_CD" ).append("\n"); 
		query.append("      ,(SELECT MC.CNT_NM FROM MDM_COUNTRY MC WHERE SBA.CNTC_AREA_CD = MC.CNT_CD AND NVL(MC.DELT_FLG, 'N') <> 'Y' AND ROWNUM = 1 ) AS CNTC_AREA_NM" ).append("\n"); 
		query.append("      ,SBA.ATTR_CTNT7" ).append("\n"); 
		query.append("      ,SBA.CRE_USR_ID AS USR_ID" ).append("\n"); 
		query.append("FROM SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("WHERE SBA.BANK_ACCT_SEQ = @[bank_acct_seq]" ).append("\n"); 

	}
}