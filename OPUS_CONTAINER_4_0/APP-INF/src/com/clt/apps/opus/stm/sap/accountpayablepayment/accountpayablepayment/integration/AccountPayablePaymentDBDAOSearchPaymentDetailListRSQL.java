/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
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

public class AccountPayablePaymentDBDAOSearchPaymentDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payment Detail Inquiry
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("from_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentDetailListRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SPH.PAY_DT,'YYYYMMDD')   AS PAY_DT" ).append("\n"); 
		query.append("      ,SPH.VNDR_NO            AS VNDR_NO" ).append("\n"); 
		query.append("      ,SPH.VNDR_NM            AS VNDR_NM" ).append("\n"); 
		query.append("      ,SPH.CURR_CD            AS CURR_CD" ).append("\n"); 
		query.append("      ,TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SPH.CURR_CD, SPH.PAY_AMT)) AS PAY_AMT" ).append("\n"); 
		query.append("      ,SBB.BANK_NM            AS BANK_NM" ).append("\n"); 
		query.append("      ,SBB.BANK_BRNC_NM       AS BANK_BRNC_NM" ).append("\n"); 
		query.append("      ,SPH.BANK_ACCT_NO       AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      ,SPH.PAY_MZD_LU_CD      AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      ,SPH.PAY_NO             AS PAY_NO" ).append("\n"); 
		query.append("FROM   SAP_PAY_HDR SPH" ).append("\n"); 
		query.append("      ,SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("      ,SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("WHERE  SPH.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("AND    SBA.BANK_BRNC_SEQ = SBB.BANK_BRNC_SEQ(+)" ).append("\n"); 
		query.append("AND    SPH.PAY_STS_LU_CD <> 'VOIDED'" ).append("\n"); 
		query.append("AND    SPH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND    SPH.PAY_DT >= to_date(@[from_pay_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("AND    SPH.PAY_DT <  to_date(@[to_pay_dt], 'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("#if (${vndr_no} != '') " ).append("\n"); 
		query.append("AND    SPH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_mzd_lu_cd} != '') " ).append("\n"); 
		query.append("AND    SPH.PAY_MZD_LU_CD = @[pay_mzd_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER  BY SPH.PAY_DT, SPH.VNDR_NO, SPH.CURR_CD" ).append("\n"); 

	}
}