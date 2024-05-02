/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppay_hir_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL").append("\n"); 
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
		query.append("SELECT CURR_CD" ).append("\n"); 
		query.append("     , TRIM(TO_CHAR(SUM(INV_AMT),'999,999,999,999,999,999.00')) INV_AMT" ).append("\n"); 
		query.append("     , CURR_CD2" ).append("\n"); 
		query.append("     , TRIM(TO_CHAR(SUM(INV_AMT2),'999,999,999,999,999,999.00')) INV_AMT2" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(FD.FLET_CURR_CHK_CD,'F',FD.CURR_CD,NULL) CURR_CD" ).append("\n"); 
		query.append("             , DECODE(FD.FLET_CURR_CHK_CD,'F',FD.INV_AMT,NULL) INV_AMT" ).append("\n"); 
		query.append("             , DECODE(FD.FLET_CURR_CHK_CD,'S',FD.CURR_CD,NULL) CURR_CD2" ).append("\n"); 
		query.append("             , DECODE(FD.FLET_CURR_CHK_CD,'S',FD.INV_AMT,NULL) INV_AMT2" ).append("\n"); 
		query.append("          FROM FMS_INVOICE FI" ).append("\n"); 
		query.append("             , FMS_INV_DTL FD" ).append("\n"); 
		query.append("             , FMS_ACCT_ITM FA" ).append("\n"); 
		query.append("         WHERE FI.FLET_CTRT_NO = FD.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND FI.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("           AND FI.PPAY_HIR_NO = @[ppay_hir_no]" ).append("\n"); 
		query.append("           AND FI.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("           AND FI.INV_SEQ = FD.INV_SEQ" ).append("\n"); 
		query.append("           AND FI.FLET_ISS_TP_CD = FD.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("           AND FD.ACCT_CD = FA.ACCT_CD" ).append("\n"); 
		query.append("           AND FD.ACCT_ITM_SEQ = FA.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("           AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                              FROM FMS_ACCT_ITM AI" ).append("\n"); 
		query.append("                                 , FMS_ACCT_CATE AC" ).append("\n"); 
		query.append("                             WHERE AI.ACCT_CD = AC.ACCT_CD" ).append("\n"); 
		query.append("                               AND AI.ACCT_ITM_SEQ = AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                               AND AC.FLET_ACCT_CATE_CD = 'BR' /*Brokerage*/" ).append("\n"); 
		query.append("                               AND AI.ACCT_CD = FD.ACCT_CD" ).append("\n"); 
		query.append("                               AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" GROUP BY CURR_CD, CURR_CD2" ).append("\n"); 

	}
}