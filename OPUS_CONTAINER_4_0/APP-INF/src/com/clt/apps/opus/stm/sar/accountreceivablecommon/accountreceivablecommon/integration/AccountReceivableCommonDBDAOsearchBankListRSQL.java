/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchBankListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.04 
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

public class AccountReceivableCommonDBDAOsearchBankListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bank 정보 조회
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchBankListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("local_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchBankListRSQL").append("\n"); 
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
		query.append("SELECT  A.BANK_ACCT_SEQ, " ).append("\n"); 
		query.append("        A.BANK_ACCT_NM," ).append("\n"); 
		query.append("        A.BANK_ACCT_NO," ).append("\n"); 
		query.append("        A.CURR_CD," ).append("\n"); 
		query.append("        A.MLT_CURR_FLG," ).append("\n"); 
		query.append("        A.OPN_OFC_CD," ).append("\n"); 
		query.append("        A.AR_OFC_CD," ).append("\n"); 
		query.append("		B.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM    SAP_BANK_ACCT A," ).append("\n"); 
		query.append("		MDM_CURRENCY B" ).append("\n"); 
		query.append("WHERE   A.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("  --AND   A.BANK_ACCT_TP_MN_CD = 'R'  --REVENUE" ).append("\n"); 
		query.append("  AND   A.ACCT_TP_CD IN ('O', 'R')  --O : AR/AP, R : AR, P : AP" ).append("\n"); 
		query.append("  AND   A.INACT_DT IS NULL" ).append("\n"); 
		query.append("#if (${bank_acct_nm} != '')" ).append("\n"); 
		query.append("  AND UPPER(A.BANK_ACCT_NM) LIKE '%'||UPPER(@[bank_acct_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rct_tp_cd} == 'OFF' )" ).append("\n"); 
		query.append("  AND A.ATTR_CTNT1 = @[rct_tp_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${bank_ctrl_cd} == 'ARO' )" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("#elseif (${bank_ctrl_cd} == 'OTH')" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = (SELECT BANK_OFC" ).append("\n"); 
		query.append("                     FROM SCO_OFC_INFO" ).append("\n"); 
		query.append("                     WHERE OFC_CD = @[rct_ofc_cd]" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND 1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${local_curr_cd} != '')" ).append("\n"); 
		query.append("  AND A.CURR_CD = @[local_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.BANK_ACCT_NM" ).append("\n"); 

	}
}