/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchNotIssueListByCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchNotIssueListByCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer의  Invoice 미발행내용을 현재일로부터 조회기간 사이에 해당하는 due date데이터를 조회한다.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchNotIssueListByCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_over_due",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("as_of_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_over_due",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchNotIssueListByCustomerRSQL").append("\n"); 
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
		query.append("SELECT TB.AR_OFC_CD," ).append("\n"); 
		query.append("  DECODE(TB.IO_BND_CD, 'I', 'I/B', 'O', 'O/B', TB.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("  TB.TYPE," ).append("\n"); 
		query.append("  TB.VVD," ).append("\n"); 
		query.append("  TB.SAIL_ARR_DT," ).append("\n"); 
		query.append("  TB.POL_CD," ).append("\n"); 
		query.append("  TB.POD_CD," ).append("\n"); 
		query.append("  TB.BL_SRC_NO," ).append("\n"); 
		query.append("  TB.AR_IF_NO," ).append("\n"); 
		query.append("  TB.BKG_TEU_QTY," ).append("\n"); 
		query.append("  TB.BKG_FEU_QTY," ).append("\n"); 
		query.append("  TB.INV_LCL," ).append("\n"); 
		query.append("  TB.USD_XCH_RT," ).append("\n"); 
		query.append("  TB.DUE_DT," ).append("\n"); 
		query.append("  TB.OVER," ).append("\n"); 
		query.append("  TRIM(TO_CHAR(ST1.CR_AMT,'99999999990.00')) CR_AMT," ).append("\n"); 
		query.append("  ST1.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("  ST1.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("  ST2.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("      A.AR_IF_NO," ).append("\n"); 
		query.append("      A.POL_CD," ).append("\n"); 
		query.append("      A.POD_CD," ).append("\n"); 
		query.append("      A.SAIL_ARR_DT," ).append("\n"); 
		query.append("      SUM(SAR_GET_CUR_AMT_FNC(A.LOCL_CURR_CD,B.CHG_AMT * B.INV_XCH_RT)) INV_LCL," ).append("\n"); 
		query.append("      A.USD_XCH_RT," ).append("\n"); 
		query.append("      A.DUE_DT," ).append("\n"); 
		query.append("      A.IO_BND_CD," ).append("\n"); 
		query.append("      A.BL_SRC_NO," ).append("\n"); 
		query.append("      A.BKG_TEU_QTY," ).append("\n"); 
		query.append("      A.BKG_FEU_QTY," ).append("\n"); 
		query.append("      A.REV_TP_CD||A.REV_SRC_CD TYPE," ).append("\n"); 
		query.append("      A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("      A.ACT_CUST_SEQ," ).append("\n"); 
		query.append("      A.LOCL_CURR_CD," ).append("\n"); 
		query.append("      ROUND(TO_DATE(REPLACE(@[as_of_date], '-', ''),'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD'), 0) OVER" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG B" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("      AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("      AND A.AR_OFC_CD = @[ar_ofc_cd] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("      AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                            WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                         FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                        WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                          WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                              AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("    GROUP BY A.AR_OFC_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.AR_IF_NO, A.POL_CD, A.POD_CD, A.SAIL_ARR_DT, A.USD_XCH_RT, A.DUE_DT, A.IO_BND_CD, A.BL_SRC_NO, A.BKG_TEU_QTY, A.BKG_FEU_QTY, A.REV_TP_CD, A.REV_SRC_CD, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.LOCL_CURR_CD) TB," ).append("\n"); 
		query.append("  MDM_CR_CUST ST1," ).append("\n"); 
		query.append("  MDM_CURRENCY ST2" ).append("\n"); 
		query.append("WHERE TB.ACT_CUST_CNT_CD = ST1.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND TB.ACT_CUST_SEQ = ST1.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND TB.LOCL_CURR_CD = ST2.CURR_CD" ).append("\n"); 
		query.append("#if (${amount_option} == 'P')" ).append("\n"); 
		query.append("  AND TB.INV_LCL > 0" ).append("\n"); 
		query.append("#elseif (${amount_option} == 'M')" ).append("\n"); 
		query.append("  AND TB.INV_LCL < 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND TB.OVER BETWEEN REPLACE(@[from_over_due], ',', '') AND REPLACE(@[to_over_due], ',', '')" ).append("\n"); 
		query.append("ORDER BY TB.AR_OFC_CD," ).append("\n"); 
		query.append("  TB.IO_BND_CD DESC," ).append("\n"); 
		query.append("  TB.BL_SRC_NO," ).append("\n"); 
		query.append("  TB.AR_IF_NO" ).append("\n"); 

	}
}