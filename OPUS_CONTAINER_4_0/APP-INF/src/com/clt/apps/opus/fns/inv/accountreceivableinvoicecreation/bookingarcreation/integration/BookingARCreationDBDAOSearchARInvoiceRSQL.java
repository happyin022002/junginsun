/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchARInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchARInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select * from INV_AR_MN a, INV_AR_AMT b, INV_AR_CHG c, INV_AR_CNTR d
	  * where a.ar_if_no = b.ar_if_no
	  * and a.ar_if_no = c.ar_if_no
	  * and a.ar_if_no = d.ar_if_no
	  * and b.ar_if_no = c.ar_if_no
	  * and b.ar_if_no = d.ar_if_no
	  * and c.ar_if_no = d.ar_if_no
	  * 
	  * [] BookingARCreationDBDAO::searchARInvoice ( ifNo )
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchARInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchARInvoiceRSQL").append("\n"); 
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
		query.append(",BKG_SEQ" ).append("\n"); 
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
		query.append(",CO_STF_CTNT	" ).append("\n"); 
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
		query.append(",WHF_MRN_NO" ).append("\n"); 
		query.append(",WHF_NTC_NO		" ).append("\n"); 
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
		query.append(",TAX_XCH_RT" ).append("\n"); 
		query.append(",CRE_USR_ID	" ).append("\n"); 
		query.append(",CRE_DT	" ).append("\n"); 
		query.append(",UPD_USR_ID	" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",INV_ISS_FLG" ).append("\n"); 
		query.append(",INV_CLR_FLG" ).append("\n"); 
		query.append(",CSR_NO" ).append("\n"); 
		query.append(",WHF_FLG" ).append("\n"); 
		query.append(",CTRT_OFC_CD" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",ISS_DT" ).append("\n"); 
		query.append(",INV_SVC_SCP_CD" ).append("\n"); 
		query.append(",OLD_AR_IF_NO" ).append("\n"); 
		query.append("--,INV_CURR_CD" ).append("\n"); 
		query.append(",BFR_INV_CURR_CD" ).append("\n"); 
		query.append(",INV_LOCL_XCH_RT" ).append("\n"); 
		query.append(",INV_USD_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_MN " ).append("\n"); 
		query.append("WHERE	AR_IF_NO = @[if_no]" ).append("\n"); 

	}
}