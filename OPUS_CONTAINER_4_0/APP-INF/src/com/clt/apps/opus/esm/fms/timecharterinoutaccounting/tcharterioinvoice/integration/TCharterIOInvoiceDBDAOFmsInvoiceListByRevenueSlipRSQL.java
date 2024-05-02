/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOFmsInvoiceListByRevenueSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.17 
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

public class TCharterIOInvoiceDBDAOFmsInvoiceListByRevenueSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Revenue Retrieve / Window Select
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOFmsInvoiceListByRevenueSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOFmsInvoiceListByRevenueSlipRSQL").append("\n"); 
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
		query.append("SELECT NVL(C.TO_YRMON,SUBSTR(C.CHTR_INV_DT, 1, 6)) AS TO_YRMON" ).append("\n"); 
		query.append("     , B.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , D.ACCT_ITM_NM" ).append("\n"); 
		query.append("     , C.ACCT_CD" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , C.CURR_CD" ).append("\n"); 
		query.append("     , (SELECT SUM(INV_AMT)" ).append("\n"); 
		query.append("          FROM FMS_INV_DTL" ).append("\n"); 
		query.append("         WHERE FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND FLET_ISS_TP_CD = C.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("           AND INV_SEQ = C.INV_SEQ" ).append("\n"); 
		query.append("           AND ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("           AND INV_DESC = C.INV_DESC" ).append("\n"); 
		query.append("           AND ACCT_ITM_SEQ = C.ACCT_ITM_SEQ) INV_AMT" ).append("\n"); 
		query.append("     , C.INV_DESC" ).append("\n"); 
		query.append("     , (SELECT MAX(AR_CTR_CD)" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[slp_ofc_cd]) AR_CTR_CD" ).append("\n"); 
		query.append("     , (SELECT MAX(LOC_CD)" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("         WHERE OFC_CD = @[slp_ofc_cd]) LOC_CD" ).append("\n"); 
		query.append("     , (SUBSTR(C.FLET_CTRT_NO,1,4) || SUBSTR(C.FLET_CTRT_NO,13,3) || MAX(LPAD(C.INV_SEQ,3,'0')) || MIN(LPAD(C.INV_DTL_SEQ,2,'0'))) TO_INV_NO" ).append("\n"); 
		query.append("     , TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("     , C.INV_SEQ" ).append("\n"); 
		query.append("     , C.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , C.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("     , MIN(C.INV_DTL_SEQ) AS INV_DTL_SEQ" ).append("\n"); 
		query.append("     , DENSE_RANK() OVER(ORDER BY B.PPAY_HIR_NO||SUBSTR(C.INV_DESC,1, INSTR(C.INV_DESC,'(')) || TO_CHAR(B.EFF_DT,'YYYY-MM-DD HH24:MI') ||'~'|| TO_CHAR(B.EXP_DT,'YYYY-MM-DD HH24:MI') ||')') AS GRP_NO" ).append("\n"); 
		query.append("     , SUBSTR(C.INV_DESC,1, INSTR(C.INV_DESC,'(')) || TO_CHAR(B.EFF_DT,'YYYY-MM-DD HH24:MI') ||'~'|| TO_CHAR(B.EXP_DT,'YYYY-MM-DD HH24:MI') ||')' AS ORI_INV_DESC" ).append("\n"); 
		query.append("  FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("     , FMS_INVOICE B" ).append("\n"); 
		query.append("     , FMS_INV_DTL C" ).append("\n"); 
		query.append("     , FMS_ACCT_ITM D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("   AND A.FLET_CTRT_NO = B.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND B.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("   AND B.FLET_ISS_TP_CD = C.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("   AND B.INV_SEQ = C.INV_SEQ" ).append("\n"); 
		query.append("   AND C.SLP_TP_CD IS NULL" ).append("\n"); 
		query.append("   AND C.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("   AND C.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("   AND C.ACCT_ITM_SEQ = D.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("   AND B.FLET_ISS_TP_CD = 'PRE' /*2015.10.13 ACCOUNT 에서 등록된 부분을 빼기 위해 조건 추가.*/" ).append("\n"); 
		query.append("   AND NOT EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM FMS_ACCT_ITM AI" ).append("\n"); 
		query.append("                         , FMS_ACCT_CATE AC" ).append("\n"); 
		query.append("                     WHERE AI.ACCT_CD = AC.ACCT_CD" ).append("\n"); 
		query.append("                       AND AI.ACCT_ITM_SEQ = AC.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("                       AND AC.FLET_ACCT_CATE_CD = 'BR' /*Brokerage*/" ).append("\n"); 
		query.append("                       AND AI.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 )" ).append("\n"); 
		query.append(" GROUP BY NVL(C.TO_YRMON,SUBSTR(C.CHTR_INV_DT, 1, 6))" ).append("\n"); 
		query.append("     , B.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , D.ACCT_ITM_NM" ).append("\n"); 
		query.append("     , C.ACCT_CD" ).append("\n"); 
		query.append("     , C.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , C.CURR_CD" ).append("\n"); 
		query.append("     , C.INV_DESC" ).append("\n"); 
		query.append("     , C.EFF_DT" ).append("\n"); 
		query.append("     , C.EXP_DT" ).append("\n"); 
		query.append("     , C.INV_SEQ" ).append("\n"); 
		query.append("     , C.FLET_CTRT_NO" ).append("\n"); 
		query.append("     , C.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("     , B.EFF_DT" ).append("\n"); 
		query.append("     , B.EXP_DT" ).append("\n"); 
		query.append(" ORDER BY B.PPAY_HIR_NO" ).append("\n"); 
		query.append("     , SUBSTR(C.INV_DESC, INSTR(REPLACE(C.INV_DESC, '-', '/'), '/', 1, 1) - 4, 4)|| SUBSTR(C.INV_DESC, INSTR(REPLACE(C.INV_DESC, '-', '/'), '/', 1, 1) + 1, 2)|| SUBSTR(C.INV_DESC, INSTR(REPLACE(C.INV_DESC, '-', '/'), '/', 1, 2) + 1, 2)" ).append("\n"); 
		query.append("     , C.ACCT_CD" ).append("\n"); 

	}
}