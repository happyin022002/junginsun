/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCommonDBDAOsearchRevAcctMatrixInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.15 
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

public class AccountReceivableCommonDBDAOsearchRevAcctMatrixInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Account Matrix Search
	  * </pre>
	  */
	public AccountReceivableCommonDBDAOsearchRevAcctMatrixInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dup_acct_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dup_acct_ctnt3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_rev_acct_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dup_acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_acct_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_ctnt4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dup_acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dup_acct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.integration").append("\n"); 
		query.append("FileName : AccountReceivableCommonDBDAOsearchRevAcctMatrixInfoRSQL").append("\n"); 
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
		query.append("SELECT ACCT_CTNT1," ).append("\n"); 
		query.append("       ACCT_CTNT2," ).append("\n"); 
		query.append("       ACCT_CTNT3," ).append("\n"); 
		query.append("       ACCT_CTNT4," ).append("\n"); 
		query.append("       ACCT_CTNT5," ).append("\n"); 
		query.append("       ACCT_CTNT6," ).append("\n"); 
		query.append("       ACCT_CTNT7," ).append("\n"); 
		query.append("       ACCT_CTNT8," ).append("\n"); 
		query.append("       ACCT_END_DT," ).append("\n"); 
		query.append("       ACCT_MTX_SEQ," ).append("\n"); 
		query.append("       ACCT_ST_DT," ).append("\n"); 
		query.append("       ACCT_TP_CD," ).append("\n"); 
		query.append("       ACCT_TP_NM," ).append("\n"); 
		query.append("       AMT_SGN_CD," ).append("\n"); 
		query.append("       AR_ACCT_CD," ).append("\n"); 
		query.append("       BANK_CHG_ACCT_CD," ).append("\n"); 
		query.append("       CLR_ACCT_CD," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       DECODE(NVL(DELT_FLG,'N'), 'Y', 1, 0) AS DELT_FLG," ).append("\n"); 
		query.append("      -- DR_CR_TP_CD," ).append("\n"); 
		query.append("       LEGR_XCH_DIFF_INCM_ACCT_CD," ).append("\n"); 
		query.append("       LEGR_XCH_DIFF_LSS_ACCT_CD," ).append("\n"); 
		query.append("       PAY_ACCT_CD," ).append("\n"); 
		query.append("       PAY_CURR_XCH_ACCT_CD," ).append("\n"); 
		query.append("       REP_CHG_CD," ).append("\n"); 
		query.append("       REV_ACCT_DIV_CD," ).append("\n"); 
		query.append("       UPD_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       'Y' AS SEARCH_FLG" ).append("\n"); 
		query.append("  FROM SAR_ACCT_MTX" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${f_dup_chk} == 'Y')" ).append("\n"); 
		query.append("  AND ACCT_CTNT1 = @[f_dup_acct_ctnt1]" ).append("\n"); 
		query.append("  AND ACCT_CTNT2 = @[f_dup_acct_ctnt2]" ).append("\n"); 
		query.append("  AND ACCT_CTNT3 = @[f_dup_acct_ctnt3]" ).append("\n"); 
		query.append("  AND ACCT_CTNT4 = @[f_dup_acct_ctnt4]" ).append("\n"); 
		query.append("  AND ACCT_TP_CD = @[f_dup_acct_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" #if(${f_delt_flg} != 'ALL' && ${f_delt_flg} != '')" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG, 'N') = @[f_delt_flg] " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_acct_ctnt1} != 'ALL' && ${f_acct_ctnt1} != '')" ).append("\n"); 
		query.append("   AND ACCT_CTNT1 = @[f_acct_ctnt1]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_acct_ctnt2} != 'ALL' && ${f_acct_ctnt2} != '')" ).append("\n"); 
		query.append("   AND ACCT_CTNT2 = @[f_acct_ctnt2]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_acct_ctnt3} != 'ALL' && ${f_acct_ctnt3} != '')" ).append("\n"); 
		query.append("   AND ACCT_CTNT3 = @[f_acct_ctnt3]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_acct_ctnt4} != 'ALL' && ${f_acct_ctnt4} != '')" ).append("\n"); 
		query.append("   AND ACCT_CTNT4 = @[f_acct_ctnt4]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_acct_rev_acct_div_cd} != 'ALL' && ${f_acct_rev_acct_div_cd} != '')" ).append("\n"); 
		query.append("   AND REV_ACCT_DIV_CD = @[f_acct_rev_acct_div_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_acct_tp_cd} != 'ALL' && ${f_acct_tp_cd} != '')" ).append("\n"); 
		query.append("   AND ACCT_TP_CD = @[f_acct_tp_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if(${f_ar_acct_cd} != 'ALL' && ${f_ar_acct_cd} != '')" ).append("\n"); 
		query.append("   AND AR_ACCT_CD = @[f_ar_acct_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY ACCT_CTNT1,ACCT_TP_CD,ACCT_CTNT2,ACCT_CTNT3,ACCT_CTNT4" ).append("\n"); 

	}
}