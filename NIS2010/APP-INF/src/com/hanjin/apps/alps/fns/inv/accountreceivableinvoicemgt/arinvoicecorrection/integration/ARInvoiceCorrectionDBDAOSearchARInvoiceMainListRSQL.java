/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceMainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.01.18 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchARInvoiceMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchARInvoiceMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchARInvoiceMainListRSQL").append("\n"); 
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
		query.append("AR_IF_NO" ).append("\n"); 
		query.append(",BL_NO	" ).append("\n"); 
		query.append(",BL_TP_CD	" ).append("\n"); 
		query.append(",BL_SRC_NO	" ).append("\n"); 
		query.append(",INV_SRC_NO	" ).append("\n"); 
		query.append(",BKG_NO	" ).append("\n"); 
		query.append(",BKG_CORR_NO	" ).append("\n"); 
		query.append(",TO_CHAR(BKG_CORR_DT,'YYYY/MM/DD HH24:MI:SS') BKG_CORR_DT	" ).append("\n"); 
		query.append(",VVD_TRNS_FLG	" ).append("\n"); 
		query.append(",ACT_CUST_CNT_CD	" ).append("\n"); 
		query.append(",ACT_CUST_SEQ	" ).append("\n"); 
		query.append(",AR_OFC_CD	" ).append("\n"); 
		query.append(",REV_TP_CD	" ).append("\n"); 
		query.append(",REV_SRC_CD	" ).append("\n"); 
		query.append(",VSL_CD	" ).append("\n"); 
		query.append(",SKD_VOY_NO	" ).append("\n"); 
		query.append(",SKD_DIR_CD	" ).append("\n"); 
		query.append(",LOCL_CURR_CD	" ).append("\n"); 
		query.append(",SVC_SCP_CD	" ).append("\n"); 
		query.append(",SAIL_DT	" ).append("\n"); 
		query.append(",SAIL_ARR_DT	" ).append("\n"); 
		query.append(",SLAN_CD	" ).append("\n"); 
		query.append(",IO_BND_CD	" ).append("\n"); 
		query.append(",TRNK_VSL_CD	" ).append("\n"); 
		query.append(",TRNK_SKD_VOY_NO	" ).append("\n"); 
		query.append(",TRNK_SKD_DIR_CD	" ).append("\n"); 
		query.append(",POR_CD	" ).append("\n"); 
		query.append(",POL_CD	" ).append("\n"); 
		query.append(",POD_CD	" ).append("\n"); 
		query.append(",DEL_CD	" ).append("\n"); 
		query.append(",CUST_CR_FLG	" ).append("\n"); 
		query.append(",INV_CUST_CNT_CD	" ).append("\n"); 
		query.append(",INV_CUST_SEQ	" ).append("\n"); 
		query.append(",FRT_FWRD_CNT_CD	" ).append("\n"); 
		query.append(",FRT_FWRD_CUST_SEQ	" ).append("\n"); 
		query.append(",CGO_WGT	" ).append("\n"); 
		query.append(",CGO_MEAS_QTY	" ).append("\n"); 
		query.append(",BKG_TEU_QTY	" ).append("\n"); 
		query.append(",BKG_FEU_QTY	" ).append("\n"); 
		query.append(",SC_NO	" ).append("\n"); 
		query.append(",RFA_NO	" ).append("\n"); 
		query.append(",SREP_CD	" ).append("\n"); 
		query.append(",MST_BL_NO	" ).append("\n"); 
		query.append(",CXL_FLG	" ).append("\n"); 
		query.append(",DUE_DT	" ).append("\n"); 
		query.append(",BL_INV_IF_DT	" ).append("\n"); 
		query.append(",BL_INV_CFM_DT	" ).append("\n"); 
		query.append(",GL_EFF_DT	" ).append("\n"); 
		query.append(",INV_RMK	" ).append("\n"); 
		query.append(",INV_DELT_DIV_CD	" ).append("\n"); 
		query.append(",BKG_REF_NO	" ).append("\n"); 
		query.append(",INV_REF_NO	" ).append("\n"); 
		query.append(",SI_REF_NO	" ).append("\n"); 
		query.append(",HJS_STF_CTNT	" ).append("\n"); 
		query.append(",INV_SPLIT_CD	" ).append("\n"); 
		query.append(",INV_VVD_CXL_CD	" ).append("\n"); 
		query.append(",DEST_TRNS_SVC_MOD_CD	" ).append("\n"); 
		query.append(",ACCT_XCH_RT_YRMON	" ).append("\n"); 
		query.append(",WHF_DECL_NO	" ).append("\n"); 
		query.append(",WHF_DECL_CFM_DT	" ).append("\n"); 
		query.append(",WHF_DECL_VSL_CD	" ).append("\n"); 
		query.append(",WHF_DECL_VOY_NO	" ).append("\n"); 
		query.append(",WHF_DECL_DIR_CD	" ).append("\n"); 
		query.append(",WHF_DECL_OFC_CD	" ).append("\n"); 
		query.append(",WHF_MRN_NO	" ).append("\n"); 
		query.append(",USD_XCH_RT	" ).append("\n"); 
		query.append(",XCH_RT_USD_TP_CD	" ).append("\n"); 
		query.append(",XCH_RT_N3RD_TP_CD	" ).append("\n"); 
		query.append(",XCH_RT_DT	" ).append("\n"); 
		query.append(",OBRD_DT	" ).append("\n"); 
		query.append(",INV_TTL_LOCL_AMT	" ).append("\n"); 
		query.append(",TRSP_RQST_ORD_FLG	" ).append("\n"); 
		query.append(",TO_CHAR(EDI_SND_DT	,'YYYY/MM/DD HH24:MI:SS') EDI_SND_DT	" ).append("\n"); 
		query.append(",REV_VSL_CD	" ).append("\n"); 
		query.append(",REV_SKD_VOY_NO	" ).append("\n"); 
		query.append(",REV_SKD_DIR_CD	" ).append("\n"); 
		query.append(",REV_DIR_CD	" ).append("\n"); 
		query.append(",RLANE_CD	" ).append("\n"); 
		query.append(",ZN_IOC_CD	" ).append("\n"); 
		query.append(",CR_TERM_DYS	" ).append("\n"); 
		query.append(",AR_TAX_IND_CD	" ).append("\n"); 
		query.append(",AR_CTY_CD	" ).append("\n"); 
		query.append(",SLS_OFC_CD	" ).append("\n"); 
		query.append(",INV_ORG_OFC_CD	" ).append("\n"); 
		query.append(",SLP_NO	" ).append("\n"); 
		query.append(",AP_AR_OFFST_NO	" ).append("\n"); 
		query.append(",CLR_STS_FLG	" ).append("\n"); 
		query.append(",CLR_DT	" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",IF_SEQ	" ).append("\n"); 
		query.append(",TAX_XCH_RT	" ).append("\n"); 
		query.append(",CRE_USR_ID	" ).append("\n"); 
		query.append(",CRE_DT	" ).append("\n"); 
		query.append(",UPD_USR_ID	" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("  AND BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("  AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("  AND NVL(INV_DELT_DIV_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("  AND AR_IF_NO <> @[ar_if_no]" ).append("\n"); 
		query.append("  AND NVL(INV_ISS_FLG,'N') = 'N'" ).append("\n"); 

	}
}