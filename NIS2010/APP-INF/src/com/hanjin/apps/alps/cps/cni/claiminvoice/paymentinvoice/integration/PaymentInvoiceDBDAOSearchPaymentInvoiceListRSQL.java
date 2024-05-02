/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentInvoiceDBDAOSearchPaymentInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.04
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.04 진윤오
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

public class PaymentInvoiceDBDAOSearchPaymentInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 클레임별 인보이스 리스트
	  * </pre>
	  */
	public PaymentInvoiceDBDAOSearchPaymentInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration").append("\n"); 
		query.append("FileName : PaymentInvoiceDBDAOSearchPaymentInvoiceListRSQL").append("\n"); 
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
		query.append("    A.INV_RGST_NO" ).append("\n"); 
		query.append("  , A.CGO_CLM_PAY_NO" ).append("\n"); 
		query.append("  , A.CGO_CLM_NO" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC ('30', A.CLM_COST_TP_CD, '2') CLM_COST_TP_NM" ).append("\n"); 
		query.append("  , CNI_GET_PTY_NM_FNC (A.CLM_PTY_NO, '2') CLM_PTY_NM" ).append("\n"); 
		query.append("  , A.INV_NO" ).append("\n"); 
		query.append("  , A.INV_DT" ).append("\n"); 
		query.append("  , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("  , A.INV_AMT" ).append("\n"); 
		query.append("  , B.CSR_NO" ).append("\n"); 
		query.append("  , B.INV_STS_CD" ).append("\n"); 
		query.append("  , TO_CHAR(B.AP_CXL_DT, 'YYYYMMDD') AP_CXL_DT" ).append("\n"); 
		query.append("  , B.AP_PAY_FLG" ).append("\n"); 
		query.append("  , TO_CHAR(B.AP_PAY_DT, 'YYYYMMDD') AP_PAY_DT" ).append("\n"); 
		query.append("  , B.AP_PAY_AMT" ).append("\n"); 
		query.append("  , A.COST_DESC" ).append("\n"); 
		query.append("  , TO_CHAR(A.PAY_DT , 'YYYYMMDD') PAY_DT" ).append("\n"); 
		query.append("  , TO_CHAR(B.INV_EFF_DT , 'YYYYMMDD') INV_EFF_DT" ).append("\n"); 
		query.append("  , A.INV_XCH_RT" ).append("\n"); 
		query.append("  , A.INV_USD_AMT" ).append("\n"); 
		query.append("  , A.INV_RMK" ).append("\n"); 
		query.append("  , C.CLM_AREA_CD" ).append("\n"); 
		query.append("  , C.HDLR_OFC_CD" ).append("\n"); 
		query.append("  , C.HDLR_USR_ID" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC ('08', C.CGO_CLM_STS_CD, '2') CGO_CLM_STS_NM" ).append("\n"); 
		query.append("  , CNI_GET_CLM_MISC_NM_FNC ('37', C.CGO_CLM_DIV_CD, '2') CGO_CLM_DIV_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CGO_CLM_COST A" ).append("\n"); 
		query.append("LEFT OUTER JOIN AP_PAY_INV B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    A.INV_RGST_NO  = B.INV_RGST_NO" ).append("\n"); 
		query.append("    AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("INNER JOIN CNI_CLM_V C" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("    A.CGO_CLM_NO = C.CGO_CLM_NO" ).append("\n"); 
		query.append("    AND C.HDLR_USR_ID = @[hdlr_usr_id]" ).append("\n"); 
		query.append("    AND A.CGO_CLM_NO  = @[cgo_clm_no]	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	" ).append("\n"); 

	}
}