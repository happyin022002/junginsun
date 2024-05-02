/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPayCaptureSelectedInvoiceInfoCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOSearchPayCaptureSelectedInvoiceInfoCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPayCaptureSelectedInvoiceInfoCount
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPayCaptureSelectedInvoiceInfoCountRSQL(){
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
		params.put("low_pay_prio_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_thru_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("high_pay_prio_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration ").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPayCaptureSelectedInvoiceInfoCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT " ).append("\n"); 
		query.append("FROM   SAP_INV_HDR SIH" ).append("\n"); 
		query.append("     , SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("     , MDM_VENDOR MV" ).append("\n"); 
		query.append("     , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("WHERE  SIH.INV_SEQ = SPS.INV_SEQ" ).append("\n"); 
		query.append("AND    TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("AND    SPS.XTER_BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("AND    SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND    NVL(SIH.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    NVL(SPS.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    NVL(SPS.INV_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND    SPS.PAY_BAT_RUN_SEQ IS NULL" ).append("\n"); 
		query.append("AND    SIH.AP_APSTS_CD = 'MANUALLY APPROVED'" ).append("\n"); 
		query.append("#if (${pay_ony_due_dt_flg} != 'N') " ).append("\n"); 
		query.append("   AND SPS.DUE_DT = TO_DATE(REPLACE(@[pay_thru_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND SPS.DUE_DT <= TO_DATE(REPLACE(@[pay_thru_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    SPS.PAY_PRIO_CD BETWEEN @[low_pay_prio_no] AND @[high_pay_prio_no]" ).append("\n"); 
		query.append("AND    SIH.AP_PAY_GRP_LU_CD = @[vndr_pay_grp_cd]" ).append("\n"); 
		query.append("AND    SIH.INV_PAY_CURR_CD = @[pay_curr_cd]" ).append("\n"); 
		query.append("AND    SPS.PAY_MZD_LU_CD = @[pay_mzd_lu_cd]" ).append("\n"); 
		query.append("#if (${zr_amt_alw_flg} != 'Y') " ).append("\n"); 
		query.append("   AND NVL(SPS.PAY_RMN_AMT, 0) <> 0" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("   AND SPS.PAY_RMN_AMT = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("   AND SIH.VNDR_NO =@[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}