/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopBankAccountInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.25 
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

public class AccountPayableCommonDBDAOSearchPopBankAccountInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조건을 기준으로 등록되어 있는 은행계좌 정보에서 해당하는 계좌 내역을 조회 처리
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopBankAccountInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopBankAccountInfoListRSQL").append("\n"); 
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
		query.append("SELECT A.BANK_ACCT_NM," ).append("\n"); 
		query.append("       A.BANK_ACCT_NO," ).append("\n"); 
		query.append("       A.BANK_ACCT_SEQ," ).append("\n"); 
		query.append("       A.CURR_CD," ).append("\n"); 
		query.append("       A.MLT_CURR_FLG," ).append("\n"); 
		query.append("       B.BANK_NM," ).append("\n"); 
		query.append("       DECODE(A.ACCT_TP_CD, 'O', 'AP/AR','P','AP','R','AR') AS ACCT_TP_CD" ).append("\n"); 
		query.append("  FROM SAP_BANK_ACCT A," ).append("\n"); 
		query.append("       SAP_BANK_BRNC B" ).append("\n"); 
		query.append(" WHERE A.BANK_BRNC_SEQ = B.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("#if (${acct_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND A.ACCT_TP_CD <> 'R'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bank_acct_nm} != '')" ).append("\n"); 
		query.append("   AND UPPER(A.BANK_ACCT_NM) LIKE UPPER(@[bank_acct_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bank_acct_no} != '')" ).append("\n"); 
		query.append("   AND UPPER(A.BANK_ACCT_NO) LIKE UPPER(@[bank_acct_no]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.OPN_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bank_acct_tp_nm} != '')" ).append("\n"); 
		query.append("   AND A.BANK_ACCT_TP_NM = @[bank_acct_tp_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}