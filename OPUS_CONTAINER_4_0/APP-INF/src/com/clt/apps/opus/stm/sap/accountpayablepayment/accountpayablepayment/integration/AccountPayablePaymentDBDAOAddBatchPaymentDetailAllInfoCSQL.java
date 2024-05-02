/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddBatchPaymentDetailAllInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.11 
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

public class AccountPayablePaymentDBDAOAddBatchPaymentDetailAllInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBatchPaymentDetailAllInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddBatchPaymentDetailAllInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddBatchPaymentDetailAllInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_PAY_DTL " ).append("\n"); 
		query.append("(   INV_PAY_SEQ" ).append("\n"); 
		query.append("  , PAY_SEQ" ).append("\n"); 
		query.append("  , INV_SEQ" ).append("\n"); 
		query.append("  , ACCTG_DT" ).append("\n"); 
		query.append("  , ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("  , PAY_AMT" ).append("\n"); 
		query.append("  , LIAB_COA_RGN_CD" ).append("\n"); 
		query.append("  , LIAB_COA_CTR_CD" ).append("\n"); 
		query.append("  , LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append("  , LIAB_COA_VVD_CD" ).append("\n"); 
		query.append("  , LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("  , EFF_YRMON" ).append("\n"); 
		query.append("  , ACCTG_PST_FLG" ).append("\n"); 
		query.append("  , PAY_FUNC_AMT" ).append("\n"); 
		query.append("  , ATTR_CATE_CTNT" ).append("\n"); 
		query.append("  , ATTR_CTNT1" ).append("\n"); 
		query.append("  , ATTR_CTNT2" ).append("\n"); 
		query.append("  , ATTR_CTNT3" ).append("\n"); 
		query.append("  , ATTR_CTNT4" ).append("\n"); 
		query.append("  , ATTR_CTNT5" ).append("\n"); 
		query.append("  , ATTR_CTNT6" ).append("\n"); 
		query.append("  , ATTR_CTNT7" ).append("\n"); 
		query.append("  , ATTR_CTNT8" ).append("\n"); 
		query.append("  , ATTR_CTNT9" ).append("\n"); 
		query.append("  , ATTR_CTNT10" ).append("\n"); 
		query.append("  , ATTR_CTNT11" ).append("\n"); 
		query.append("  , ATTR_CTNT12" ).append("\n"); 
		query.append("  , ATTR_CTNT13" ).append("\n"); 
		query.append("  , ATTR_CTNT14" ).append("\n"); 
		query.append("  , ATTR_CTNT15" ).append("\n"); 
		query.append("  , GLO_ATTR_CATE_CTNT" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("  , GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("  , PAY_SKD_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  SAP_PAY_DTL_SEQ.NEXTVAL        AS INV_PAY_SEQ" ).append("\n"); 
		query.append("      , @[pay_seq]                     AS PAY_SEQ" ).append("\n"); 
		query.append("      , SSI.INV_SEQ                    AS INV_SEQ" ).append("\n"); 
		query.append("      , SISC.PAY_DT                    AS ACCTG_DT" ).append("\n"); 
		query.append("      , ''                             AS ACCTG_EVNT_SEQ" ).append("\n"); 
		query.append("      , SSI.PAY_AMT                    AS PAY_AMT" ).append("\n"); 
		query.append("      , ''                             AS LIAB_COA_RGN_CD" ).append("\n"); 
		query.append("      , ''                             AS LIAB_COA_CTR_CD" ).append("\n"); 
		query.append("      , ''                             AS LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append("      , ''                             AS LIAB_COA_VVD_CD" ).append("\n"); 
		query.append("      , ''                             AS LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SISC.PAY_DT, 'YYYYMM') AS EFF_YRMON" ).append("\n"); 
		query.append("      , 'N'                            AS ACCTG_PST_FLG" ).append("\n"); 
		query.append("      , DECODE(SISC.PAY_XCH_RT, NULL, NULL," ).append("\n"); 
		query.append("               ROUND(SSI.PAY_AMT * SISC.PAY_XCH_RT, (SELECT NVL(MC.DP_PRCS_KNT, 0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = SISC.PAY_CURR_CD))) AS PAY_FUNC_AMT" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CATE_CTNT" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT1" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT2" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT3" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT4" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT5" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT6" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT7" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT8" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT9" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT10" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT11" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT12" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT13" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT14" ).append("\n"); 
		query.append("      , ''                             AS ATTR_CTNT15" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CATE_CTNT" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT1" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT2" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT3" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT4" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT5" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT6" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT7" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT8" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT9" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT10" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT11" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT12" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT13" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT14" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT15" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT16" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT17" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT18" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT19" ).append("\n"); 
		query.append("      , ''                             AS GLO_ATTR_CTNT20" ).append("\n"); 
		query.append("      , @[usr_id]                      AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                        AS CRE_DT" ).append("\n"); 
		query.append("      , @[usr_id]                      AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                        AS UPD_DT" ).append("\n"); 
		query.append("      , SSI.LIAB_CD_CMB_SEQ            AS LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("      , SSI.PAY_SKD_NO                 AS PAY_SKD_NO" ).append("\n"); 
		query.append("FROM    SAP_SEL_INV SSI" ).append("\n"); 
		query.append("      , SAP_INV_SEL_CRTE SISC" ).append("\n"); 
		query.append("WHERE   SSI.PAY_BAT_SEQ = SISC.PAY_BAT_SEQ" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = SISC.PAY_BAT_NM " ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_SEQ = @[pay_bat_seq]" ).append("\n"); 
		query.append("AND     SSI.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("AND     SSI.VNDR_NO = @[vndr_no]" ).append("\n"); 

	}
}