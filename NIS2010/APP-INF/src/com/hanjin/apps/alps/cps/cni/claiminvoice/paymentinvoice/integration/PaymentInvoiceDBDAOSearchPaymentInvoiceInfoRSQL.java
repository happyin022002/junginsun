/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentInvoiceDBDAOSearchPaymentInvoiceInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.04.07 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PaymentInvoiceDBDAOSearchPaymentInvoiceInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * invoice 기초 데이타 생성
	  * </pre>
	  */
	public PaymentInvoiceDBDAOSearchPaymentInvoiceInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_pay_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration").append("\n"); 
		query.append("FileName : PaymentInvoiceDBDAOSearchPaymentInvoiceInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    A.CGO_CLM_PAY_NO" ).append("\n"); 
		query.append("  , A.CGO_CLM_NO" ).append("\n"); 
		query.append("  , A.INV_NO" ).append("\n"); 
		query.append("  , A.INV_DT" ).append("\n"); 
		query.append("  , A.CLM_COST_TP_CD" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC ('30', A.CLM_COST_TP_CD, '2') CLM_COST_TP_NM" ).append("\n"); 
		query.append("  , C.ACCT_CD" ).append("\n"); 
		query.append("  , B.INV_OFC_CD" ).append("\n"); 
		query.append("  , E.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("  , E.PTY_NM" ).append("\n"); 
		query.append("  , B.COST_OFC_CD" ).append("\n"); 
		query.append("  , D.TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("  , D.SLAN_CD" ).append("\n"); 
		query.append("  , TO_CHAR(A.PAY_DT , 'YYYYMMDD') PAY_DT" ).append("\n"); 
		query.append("  , E.VNDR_SEQ" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            MDM_VENDOR" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("  , (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            MDM_ORGANIZATION" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            OFC_CD = B.COST_OFC_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AP_CTRL_OFC_CD" ).append("\n"); 
		query.append("  , A.COST_DESC" ).append("\n"); 
		query.append("  , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("  , A.INV_AMT" ).append("\n"); 
		query.append("  , B.INV_NET_AMT" ).append("\n"); 
		query.append("  , B.INV_VAT_AMT" ).append("\n"); 
		query.append("  , B.WHLD_TAX_AMT" ).append("\n"); 
		query.append("  , B.INV_RGST_NO" ).append("\n"); 
		query.append("  , TO_CHAR(B.CRE_DT , 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("  , TO_CHAR(B.INV_EFF_DT , 'YYYYMMDD') INV_EFF_DT" ).append("\n"); 
		query.append("  , B.VNDR_TERM_NM" ).append("\n"); 
		query.append("  , C.INV_RGST_SEQ" ).append("\n"); 
		query.append("  , B.INV_STS_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CGO_CLM_COST A" ).append("\n"); 
		query.append("LEFT OUTER JOIN AP_PAY_INV B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    A.INV_RGST_NO  = B.INV_RGST_NO" ).append("\n"); 
		query.append("    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("LEFT OUTER JOIN AP_PAY_INV_DTL C" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    B.INV_RGST_NO = C.INV_RGST_NO" ).append("\n"); 
		query.append("INNER JOIN CNI_CLM_V D" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    A.CGO_CLM_NO         = D.CGO_CLM_NO" ).append("\n"); 
		query.append("    AND A.CGO_CLM_PAY_NO = @[cgo_clm_pay_no]" ).append("\n"); 
		query.append("LEFT OUTER JOIN CNI_PARTY E" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    A.CLM_PTY_NO = E.CLM_PTY_NO" ).append("\n"); 

	}
}