/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
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

public class AccountPayableCommonDBDAOSearchPopAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0450 - Account Popup
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_mng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnd_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopAccountListRSQL").append("\n"); 
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
		query.append("SELECT ACCT_CD       AS ACCT_CD," ).append("\n"); 
		query.append("       ACCT_ENG_NM   AS ACCT_ENG_NM" ).append("\n"); 
		query.append(" FROM  MDM_ACCOUNT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND NVL(JNL_CRE_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("#if (${acct_cd} != '')" ).append("\n"); 
		query.append("  AND ACCT_CD LIKE @[acct_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_eng_nm} != '')" ).append("\n"); 
		query.append("  AND UPPER(ACCT_ENG_NM) LIKE '%'||UPPER(@[acct_eng_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acctg_mng_tp_cd} != '')" ).append("\n"); 
		query.append("   AND ACCTG_MNG_TP_CD  = @[acctg_mng_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pnd_tgt_flg} != '')" ).append("\n"); 
		query.append("   AND PND_TGT_FLG =@[pnd_tgt_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${line_type} == 'ITEM') " ).append("\n"); 
		query.append("   AND (    ACCT_CD LIKE '5%' " ).append("\n"); 
		query.append("         OR ACCT_CD LIKE '8%'" ).append("\n"); 
		query.append("         OR ACCT_CD LIKE '9%' " ).append("\n"); 
		query.append("         OR ACCT_CD  IN (SELECT D.LU_CD " ).append("\n"); 
		query.append("                  FROM SCO_LU_HDR H,  SCO_LU_DTL D " ).append("\n"); 
		query.append("                  WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("                  AND   D.LU_TP_CD = 'AP TAX ACCOUNT' " ).append("\n"); 
		query.append("                  --AND   D.ATTR_CTNT1 = 'EXTERNAL'" ).append("\n"); 
		query.append("                  AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("                  AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#elseif (${line_type} == 'MISCELLANEOUS') " ).append("\n"); 
		query.append("   AND (    ACCT_CD LIKE '5%' " ).append("\n"); 
		query.append("         OR ACCT_CD LIKE '8%'" ).append("\n"); 
		query.append("         OR ACCT_CD LIKE '9%' " ).append("\n"); 
		query.append("         OR ACCT_CD  IN (SELECT D.LU_CD " ).append("\n"); 
		query.append("                  FROM SCO_LU_HDR H,  SCO_LU_DTL D " ).append("\n"); 
		query.append("                  WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("                  AND   D.LU_TP_CD = 'AP TAX ACCOUNT' " ).append("\n"); 
		query.append("                  --AND   D.ATTR_CTNT1 = 'EXTERNAL'" ).append("\n"); 
		query.append("                  AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("                  AND   D.ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("                  ) " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#elseif (${line_type} == 'PREPAY_ITEM') " ).append("\n"); 
		query.append("   AND ACCT_CD LIKE '1%'" ).append("\n"); 
		query.append("   AND PND_TGT_FLG = 'Y'" ).append("\n"); 
		query.append("#elseif (${line_type} == 'TAX') " ).append("\n"); 
		query.append("   AND ACCT_CD  IN (SELECT D.LU_CD " ).append("\n"); 
		query.append("                  FROM SCO_LU_HDR H,  SCO_LU_DTL D " ).append("\n"); 
		query.append("                  WHERE H.LU_TP_CD = D.LU_TP_CD " ).append("\n"); 
		query.append("                  AND   D.LU_TP_CD = 'AP TAX ACCOUNT' " ).append("\n"); 
		query.append("                  AND   D.ATTR_CTNT1 <> 'WITHHOLDING'" ).append("\n"); 
		query.append("                  AND   H.LU_APPL_CD = 'SAP'" ).append("\n"); 
		query.append("                  AND   D.ENBL_FLG = 'Y' )" ).append("\n"); 
		query.append("                  --AND   ROWNUM = 1 ) " ).append("\n"); 
		query.append("#elseif (${line_type} == 'MAIN') " ).append("\n"); 
		query.append("   AND ACCT_CD LIKE '2%'" ).append("\n"); 
		query.append("#elseif (${line_type} == 'CASH') " ).append("\n"); 
		query.append("   AND ( ACCT_CD LIKE '1%' OR ACCT_CD LIKE '9%' )" ).append("\n"); 
		query.append("#elseif (${line_type} == 'CHARGE') " ).append("\n"); 
		query.append("   AND ( ACCT_CD LIKE '5%'  )" ).append("\n"); 
		query.append("#elseif (${line_type} == 'GAIN') " ).append("\n"); 
		query.append("   AND ( ACCT_CD LIKE '4%' OR ACCT_CD LIKE '7%' )" ).append("\n"); 
		query.append("#elseif (${line_type} == 'LOSS') " ).append("\n"); 
		query.append("   AND ( ACCT_CD LIKE '5%' OR ACCT_CD LIKE '6%' )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  AND ACCT_CD LIKE '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}