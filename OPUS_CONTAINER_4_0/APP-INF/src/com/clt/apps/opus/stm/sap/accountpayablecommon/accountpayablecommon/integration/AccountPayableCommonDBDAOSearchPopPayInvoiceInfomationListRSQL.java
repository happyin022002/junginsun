/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopPayInvoiceInfomationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.25 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopPayInvoiceInfomationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableCommonDBDAOsearchPopPayInvoiceInfomationListRSQL
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopPayInvoiceInfomationListRSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopPayInvoiceInfomationListRSQL").append("\n"); 
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
		query.append("	   SIH.INV_NO," ).append("\n"); 
		query.append("       SPS.PAY_SKD_NO," ).append("\n"); 
		query.append("	   TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SPS.PAY_RMN_AMT)) AS PAY_RMN_AMT," ).append("\n"); 
		query.append("       SIH.INV_CURR_CD," ).append("\n"); 
		query.append("       TO_CHAR(SIH.INV_DT,'YYYYMMDD') AS INV_DT," ).append("\n"); 
		query.append("       SIH.GL_DT," ).append("\n"); 
		query.append("       SIH.INV_DESC," ).append("\n"); 
		query.append("	   TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SIH.INV_AMT)) AS INV_AMT," ).append("\n"); 
		query.append("	   SIH.LIAB_CD_CMB_SEQ," ).append("\n"); 
		query.append("       SPS.XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("       SPS.REMIT_VNDR_NO," ).append("\n"); 
		query.append("	   SIH.INV_SEQ			" ).append("\n"); 
		query.append("FROM  SAP_INV_HDR SIH," ).append("\n"); 
		query.append("      SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("WHERE SIH.INV_SEQ = SPS.INV_SEQ" ).append("\n"); 
		query.append("AND SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("AND NVL(SIH.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(SPS.PAY_STS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(SPS.INV_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND SPS.PAY_BAT_RUN_SEQ IS NULL" ).append("\n"); 
		query.append("AND SIH.AP_APSTS_CD = 'MANUALLY APPROVED'" ).append("\n"); 
		query.append("AND SIH.INV_NO LIKE NVL(@[inv_no], '')||'%'" ).append("\n"); 
		query.append("#if (${inv_curr_cd} != '')" ).append("\n"); 
		query.append("AND SIH.INV_PAY_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("AND SIH.VNDR_NO =@[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_mzd_lu_cd} != '')" ).append("\n"); 
		query.append("AND SIH.PAY_MZD_LU_CD =@[pay_mzd_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}