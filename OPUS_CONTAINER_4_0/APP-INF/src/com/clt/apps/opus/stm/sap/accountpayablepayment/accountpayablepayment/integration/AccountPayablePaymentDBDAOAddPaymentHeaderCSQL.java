/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddPaymentHeaderCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOAddPaymentHeaderCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayablePaymentDBDAOAddPaymentHeaderCSQL
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddPaymentHeaderCSQL(){
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
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iban_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_func_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddPaymentHeaderCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_PAY_HDR" ).append("\n"); 
		query.append("(   PAY_SEQ," ).append("\n"); 
		query.append("    BANK_ACCT_SEQ," ).append("\n"); 
		query.append("    BANK_ACCT_NM," ).append("\n"); 
		query.append("    PAY_DT," ).append("\n"); 
		query.append("    PAY_NO," ).append("\n"); 
		query.append("    PAY_TP_CD," ).append("\n"); 
		query.append("    PAY_AMT," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    PAY_MZD_LU_CD," ).append("\n"); 
		query.append("    PAY_ADDR1," ).append("\n"); 
		query.append("    PAY_ADDR2," ).append("\n"); 
		query.append("    PAY_CNT_CD," ).append("\n"); 
		query.append("    PAY_CTY_CD," ).append("\n"); 
		query.append("    PAY_ZIP_CD," ).append("\n"); 
		query.append("    VNDR_NM," ).append("\n"); 
		query.append("    BANK_ACCT_NO," ).append("\n"); 
		query.append("    BANK_ACCT_TP_NM," ).append("\n"); 
		query.append("    DOC_SEQ," ).append("\n"); 
		query.append("    PAY_STE_NM," ).append("\n"); 
		query.append("    PAY_VOID_DT," ).append("\n"); 
		query.append("    FTU_PAY_DUE_DT," ).append("\n"); 
		query.append("    VNDR_NO," ).append("\n"); 
		query.append("    PAY_XCH_RT," ).append("\n"); 
		query.append("    PAY_XCH_DT," ).append("\n"); 
		query.append("    XCH_RT_TP_CD," ).append("\n"); 
		query.append("    PAY_FUNC_AMT," ).append("\n"); 
		query.append("    XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("    PAY_DESC," ).append("\n"); 
		query.append("    IBAN_NO," ).append("\n"); 
		query.append("    OFC_CD," ).append("\n"); 
		query.append("	PAY_STS_LU_CD," ).append("\n"); 
		query.append("	PAY_BAT_NM," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    @[pay_seq]," ).append("\n"); 
		query.append("    @[bank_acct_seq]," ).append("\n"); 
		query.append("    @[bank_acct_nm]," ).append("\n"); 
		query.append("    TO_DATE( REPLACE(@[pay_dt],'-','') ,'YYYYMMDD') ," ).append("\n"); 
		query.append("    @[pay_no]," ).append("\n"); 
		query.append("    DECODE(@[pay_tp_cd], 'Manual', 'M', @[pay_tp_cd]),-- 'M'," ).append("\n"); 
		query.append("    REPLACE(@[pay_amt], ',', '')," ).append("\n"); 
		query.append("    @[curr_cd]," ).append("\n"); 
		query.append("    @[pay_mzd_lu_cd]," ).append("\n"); 
		query.append("    ENG_ADDR AS PAY_ADDR1," ).append("\n"); 
		query.append("    LOCL_LANG_ADDR AS PAY_ADDR2," ).append("\n"); 
		query.append("    @[pay_cnt_cd]," ).append("\n"); 
		query.append("    LOC_CD AS PAY_CTY_CD," ).append("\n"); 
		query.append("    ZIP_CD AS PAY_ZIP_CD," ).append("\n"); 
		query.append("    @[vndr_nm]," ).append("\n"); 
		query.append("    @[bank_acct_no]," ).append("\n"); 
		query.append("    @[bank_acct_tp_nm]," ).append("\n"); 
		query.append("    SAP_PAY_HDR_DOC_SEQ.NEXTVAL," ).append("\n"); 
		query.append("    CHK_DE_CTY_NM AS PAY_STE_NM," ).append("\n"); 
		query.append("    null," ).append("\n"); 
		query.append("    null," ).append("\n"); 
		query.append("    @[vndr_no]," ).append("\n"); 
		query.append("    @[pay_xch_rt]," ).append("\n"); 
		query.append("    @[pay_xch_dt]," ).append("\n"); 
		query.append("    1," ).append("\n"); 
		query.append("    REPLACE(@[pay_func_amt] , ',', '')," ).append("\n"); 
		query.append("    @[xter_bank_acct_seq]," ).append("\n"); 
		query.append("    null," ).append("\n"); 
		query.append("    @[iban_no]," ).append("\n"); 
		query.append("    @[ofc_cd]," ).append("\n"); 
		query.append("	'NEGOTIABLE'," ).append("\n"); 
		query.append("	@[pay_bat_nm]," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_no]" ).append("\n"); 

	}
}