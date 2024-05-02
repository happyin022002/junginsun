/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentSlipListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30 
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

public class AccountPayablePaymentDBDAOSearchPaymentSlipListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * STM_SAP_0070(Payments Slip)  inquiry Query
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentSlipListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_tp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bank_acct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentSlipListRSQL").append("\n"); 
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
		query.append("SELECT SPH.PAY_SEQ," ).append("\n"); 
		query.append("       DECODE(SPH.PAY_TP_CD,'B','Batch','M','Manual') AS PAY_TP_CD," ).append("\n"); 
		query.append("       SPH.VNDR_NM," ).append("\n"); 
		query.append("       SPH.VNDR_NO," ).append("\n"); 
		query.append("       SPH.BANK_ACCT_NM," ).append("\n"); 
		query.append("       SPH.DOC_SEQ," ).append("\n"); 
		query.append("       TO_CHAR(SPH.PAY_DT, 'YYYY-MM-DD') AS PAY_DT," ).append("\n"); 
		query.append("       SPH.OFC_CD," ).append("\n"); 
		query.append("       SPH.CURR_CD," ).append("\n"); 
		query.append("	   TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SPH.CURR_CD, SPH.PAY_AMT)) AS PAY_AMT,	" ).append("\n"); 
		query.append("       SPH.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("       SPH.PAY_VOID_DT," ).append("\n"); 
		query.append("       SPH.PAY_STE_NM," ).append("\n"); 
		query.append("       SPH.PAY_BAT_NM," ).append("\n"); 
		query.append("       NVL(CU.USR_NM, SPH.CRE_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("FROM SAP_PAY_HDR SPH, " ).append("\n"); 
		query.append("     SAP_INV_SEL_CRTE SISC," ).append("\n"); 
		query.append("     COM_USER CU," ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO " ).append("\n"); 
		query.append("WHERE SPH.PAY_BAT_RUN_SEQ = SISC.PAY_BAT_SEQ(+)" ).append("\n"); 
		query.append("AND SPH.CRE_USR_ID = CU.USR_ID(+)" ).append("\n"); 
		query.append("AND SPH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND SPH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND SPH.PAY_DT  BETWEEN TO_DATE(@[pay_dt_fr],'YYYY-MM-DD') AND TO_DATE(@[pay_dt_to],'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND ((@[curr_tp] ='ALL' )" ).append("\n"); 
		query.append("     OR (@[curr_tp] ='LOCAL' AND  SPH.CURR_CD = MO.BIL_CURR_CD) " ).append("\n"); 
		query.append("     OR (@[curr_tp] ='OTHER' AND  SPH.CURR_CD <> MO.BIL_CURR_CD) " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if (${vndr_pay_grp_cd} != '')" ).append("\n"); 
		query.append("    AND  SISC.VNDR_PAY_GRP_CD = @[vndr_pay_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_bat_nm} != '')" ).append("\n"); 
		query.append("    AND  SPH.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pay_mzd_lu_cd} != '')" ).append("\n"); 
		query.append("    AND  SPH.PAY_MZD_LU_CD = @[pay_mzd_lu_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_no} != '')" ).append("\n"); 
		query.append("    AND  SPH.Vndr_No = @[vndr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bank_acct_nm} != '')" ).append("\n"); 
		query.append("    AND  SPH.BANK_ACCT_NM = @[bank_acct_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${doc_seq} != '')" ).append("\n"); 
		query.append("    AND  SPH.DOC_SEQ = @[doc_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}