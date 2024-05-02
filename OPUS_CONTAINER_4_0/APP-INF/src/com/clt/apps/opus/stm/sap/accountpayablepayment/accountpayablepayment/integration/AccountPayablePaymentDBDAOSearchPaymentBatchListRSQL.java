/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentBatchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.30 
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

public class AccountPayablePaymentDBDAOSearchPaymentBatchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPaymentBatchList
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentBatchListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentBatchListRSQL").append("\n"); 
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
		query.append("SELECT  SISC.PAY_BAT_SEQ           AS PAY_BAT_SEQ" ).append("\n"); 
		query.append("      , SISC.PAY_BAT_NM            AS PAY_BAT_NM" ).append("\n"); 
		query.append("      , SISC.OFC_CD                AS OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(SISC.PAY_THRU_DT, 'YYYYMMDD') AS PAY_THRU_DT" ).append("\n"); 
		query.append("      , TO_CHAR(SISC.PAY_DT, 'YYYYMMDD') AS PAY_DT" ).append("\n"); 
		query.append("      , SISC.PAY_PRD_NM            AS PAY_PRD_NM" ).append("\n"); 
		query.append("      , SISC.LOW_PAY_PRIO_NO       AS LOW_PAY_PRIO_NO" ).append("\n"); 
		query.append("      , SISC.HIGH_PAY_PRIO_NO      AS HIGH_PAY_PRIO_NO" ).append("\n"); 
		query.append("      , SISC.VNDR_PAY_GRP_CD       AS VNDR_PAY_GRP_CD" ).append("\n"); 
		query.append("      , SISC.BANK_ACCT_NM          AS BANK_ACCT_NM" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO           AS BANK_ACCT_NO" ).append("\n"); 
		query.append("      , SISC.BANK_ACCT_SEQ         AS BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      , SISC.PAY_CURR_CD           AS PAY_CURR_CD" ).append("\n"); 
		query.append("      , SISC.PAY_MZD_LU_CD         AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      , SISC.PAY_ONY_DUE_DT_FLG    AS PAY_ONY_DUE_DT_FLG" ).append("\n"); 
		query.append("      , SISC.ZR_AMT_ALW_FLG        AS ZR_AMT_ALW_FLG" ).append("\n"); 
		query.append("      , SISC.VNDR_NO               AS VNDR_NO" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR MV WHERE TO_NUMBER(SISC.VNDR_NO) = MV.VNDR_SEQ AND ROWNUM=1) AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , SISC.PAY_STS_CD            AS PAY_STS_CD" ).append("\n"); 
		query.append("      , SISC.XCH_RT_TP_CD          AS XCH_RT_TP_CD" ).append("\n"); 
		query.append("      , DECODE(SISC.XCH_RT_TP_CD, '1', 'Corporate', '')AS XCH_RT_TP_NM" ).append("\n"); 
		query.append("      , TO_CHAR(SISC.PAY_XCH_DT, 'YYYYMMDD')   AS PAY_XCH_DT" ).append("\n"); 
		query.append("      , SISC.PAY_XCH_RT            AS PAY_XCH_RT" ).append("\n"); 
		query.append("      , SISC.PAY_DOC_NO            AS PAY_DOC_NO" ).append("\n"); 
		query.append("      , SISC.ATTR_CATE_NM          AS ATTR_CATE_NM" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT1            AS ATTR_CTNT1" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT2            AS ATTR_CTNT2" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT3            AS ATTR_CTNT3" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT4            AS ATTR_CTNT4" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT5            AS ATTR_CTNT5" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT6            AS ATTR_CTNT6" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT7            AS ATTR_CTNT7" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT8            AS ATTR_CTNT8" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT9            AS ATTR_CTNT9" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT10           AS ATTR_CTNT10" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT11           AS ATTR_CTNT11" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT12           AS ATTR_CTNT12" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT13           AS ATTR_CTNT13" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT14           AS ATTR_CTNT14" ).append("\n"); 
		query.append("      , SISC.ATTR_CTNT15           AS ATTR_CTNT15" ).append("\n"); 
		query.append("      , SISC.ST_PRN_DOC_NO         AS ST_PRN_DOC_NO" ).append("\n"); 
		query.append("      , SISC.END_PRN_DOC_NO        AS END_PRN_DOC_NO" ).append("\n"); 
		query.append("      , SISC.N1ST_AVAL_DOC_NO      AS N1ST_AVAL_DOC_NO" ).append("\n"); 
		query.append("      , SISC.ZR_INV_ALW_FLG        AS ZR_INV_ALW_FLG" ).append("\n"); 
		query.append("      , SISC.FTU_DT_PAY_FLG        AS FTU_DT_PAY_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  ,'Y'                         AS PERIOD_CHK" ).append("\n"); 
		query.append("FROM    SAP_INV_SEL_CRTE SISC" ).append("\n"); 
		query.append("      , SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("WHERE   SISC.BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ" ).append("\n"); 
		query.append("AND     SISC.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND     SISC.PAY_DT >= TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND     SISC.PAY_DT <  TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD')  + 1" ).append("\n"); 
		query.append("#if (${pay_bat_nm} != '')" ).append("\n"); 
		query.append("   AND  SISC.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bank_acct_nm} != '')" ).append("\n"); 
		query.append("   AND  SBA.BANK_ACCT_NM = @[bank_acct_nm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_pay_grp_cd} != '')" ).append("\n"); 
		query.append("   AND  SISC.VNDR_PAY_GRP_CD = @[vndr_pay_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SISC.PAY_DT, SISC.PAY_BAT_NM  " ).append("\n"); 

	}
}