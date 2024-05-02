/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOSearchPopAccountTypeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
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

public class AccountReceivableCommonDBDAOSearchPopAccountTypeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Account Type Code - Retrieve
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOSearchPopAccountTypeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOSearchPopAccountTypeListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    ACCT_TP_CD, ACCT_TP_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT LU_CD ACCT_TP_CD, LU_DESC   ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM SCO_LU_DTL" ).append("\n"); 
		query.append("    WHERE LU_TP_CD = 'REV TYPE SRC CD'    " ).append("\n"); 
		query.append("    --추가" ).append("\n"); 
		query.append("    AND ATTR_CTNT3 = 'REC'" ).append("\n"); 
		query.append("    AND 'REC' = NVL(@[f_acct_ctnt1] ,'REC')" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("    SELECT CHG_CD ACCT_TP_CD, CHG_NM ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM MDM_CHARGE" ).append("\n"); 
		query.append("    WHERE 'REV' = NVL(@[f_acct_ctnt1], 'REV')" ).append("\n"); 
		query.append("    AND   'MRD' <> NVL(@[f_acct_ctnt4], 'MRD')" ).append("\n"); 
		query.append("        --신규 query 추가. TPB Charge" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("    SELECT '3'||N3PTY_BIL_TP_CD ACCT_TP_CD, N3PTY_BIL_TP_NM ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM   TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("    WHERE  ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND    'REV' = NVL(@[f_acct_ctnt1], 'REV')" ).append("\n"); 
		query.append("    AND    'MRD' = NVL(@[f_acct_ctnt4], 'MRD')" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("    SELECT BANK_ACCT_NO ACCT_TP_CD, BANK_ACCT_NM   ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM SAP_BANK_ACCT" ).append("\n"); 
		query.append("    WHERE 'RCT' = NVL(@[f_acct_ctnt1], 'RCT')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --추가 acct_ctnt3이 입력된 경우" ).append("\n"); 
		query.append("    #if (${f_acct_ctnt3} != '')" ).append("\n"); 
		query.append("    AND   AR_OFC_CD = @[f_acct_ctnt3]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("    SELECT LU_CD ACCT_TP_CD, LU_DESC   ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM SCO_LU_DTL" ).append("\n"); 
		query.append("    WHERE LU_TP_CD = 'ADJUST TYPE'    " ).append("\n"); 
		query.append("    AND 'ADJ' = NVL(@[f_acct_ctnt1] ,'ADJ')" ).append("\n"); 
		query.append("        UNION ALL " ).append("\n"); 
		query.append("    SELECT LU_CD ACCT_TP_CD, LU_DESC   ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM SCO_LU_DTL" ).append("\n"); 
		query.append("    WHERE LU_TP_CD = 'WRITEOFF TYPE'   " ).append("\n"); 
		query.append("    AND 'WRTF'  = NVL(@[f_acct_ctnt1], 'WRTF')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("    SELECT LU_CD ACCT_TP_CD, LU_DESC   ACCT_TP_NM" ).append("\n"); 
		query.append("    FROM SCO_LU_DTL" ).append("\n"); 
		query.append("    WHERE LU_TP_CD = 'AR ACCOUNT TYPE'" ).append("\n"); 
		query.append("    AND   attr_ctnt1 = @[f_acct_ctnt1]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_acct_tp_cd} != '' )" ).append("\n"); 
		query.append("	WHERE   ACCT_TP_CD = @[f_acct_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    ACCT_TP_CD" ).append("\n"); 

	}
}