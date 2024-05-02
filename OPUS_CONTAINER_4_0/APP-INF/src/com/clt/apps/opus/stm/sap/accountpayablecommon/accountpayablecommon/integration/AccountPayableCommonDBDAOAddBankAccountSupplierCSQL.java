/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOAddBankAccountSupplierCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.16 
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

public class AccountPayableCommonDBDAOAddBankAccountSupplierCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bank Account(Supplier) 정보를 저장
	  * </pre>
	  */
	public AccountPayableCommonDBDAOAddBankAccountSupplierCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_prio_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_acct_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inact_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_area_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("attr_ctnt6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt7",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_brnc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOAddBankAccountSupplierCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_BANK_ACCT" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("  BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" ,BANK_ACCT_NO" ).append("\n"); 
		query.append(" ,BANK_ACCT_NM" ).append("\n"); 
		query.append(" ,BANK_BRNC_SEQ" ).append("\n"); 
		query.append(" ,CURR_CD" ).append("\n"); 
		query.append(" ,BANK_ACCT_VNDR_SEQ" ).append("\n"); 
		query.append(" ,BANK_ACCT_PRIO_CD" ).append("\n"); 
		query.append(" ,INACT_DT" ).append("\n"); 
		query.append(" ,BANK_ACCT_TP_NM" ).append("\n"); 
		query.append(" ,MLT_CURR_FLG" ).append("\n"); 
		query.append(" ,ACCT_TP_CD" ).append("\n"); 
		query.append(" ,ATTR_CTNT5" ).append("\n"); 
		query.append(" ,ATTR_CTNT6" ).append("\n"); 
		query.append(" ,IBAN_NO" ).append("\n"); 
		query.append(" ,ATTR_CTNT2" ).append("\n"); 
		query.append(" ,CNTC_AREA_CD" ).append("\n"); 
		query.append(" ,ATTR_CTNT7" ).append("\n"); 
		query.append(" ,CRE_USR_ID" ).append("\n"); 
		query.append(" ,CRE_DT" ).append("\n"); 
		query.append(" ,UPD_USR_ID" ).append("\n"); 
		query.append(" ,UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  @[bank_acct_seq]" ).append("\n"); 
		query.append(" ,@[bank_acct_no]" ).append("\n"); 
		query.append(" ,@[bank_acct_nm]" ).append("\n"); 
		query.append(" ,@[bank_brnc_seq]" ).append("\n"); 
		query.append(" ,@[curr_cd]" ).append("\n"); 
		query.append(" ,@[bank_acct_vndr_seq]" ).append("\n"); 
		query.append(" ,NVL(@[bank_acct_prio_cd], 'N')" ).append("\n"); 
		query.append(" ,TO_DATE(@[inact_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append(" ,'SUPPLIER'" ).append("\n"); 
		query.append(" ,'Y'" ).append("\n"); 
		query.append(" ,'S'" ).append("\n"); 
		query.append(" ,@[attr_ctnt5]" ).append("\n"); 
		query.append(" ,@[attr_ctnt6]" ).append("\n"); 
		query.append(" ,@[iban_no]" ).append("\n"); 
		query.append(" ,@[attr_ctnt2]" ).append("\n"); 
		query.append(" ,@[cntc_area_cd]" ).append("\n"); 
		query.append(" ,@[attr_ctnt7]" ).append("\n"); 
		query.append(" ,@[usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(" ,@[usr_id]" ).append("\n"); 
		query.append(" ,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}