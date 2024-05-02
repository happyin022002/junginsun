/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchSlipApprovalTaxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchSlipApprovalTaxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ERP AP 전송하기 위한 세금 계산서 정보 조회한다
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchSlipApprovalTaxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchSlipApprovalTaxRSQL").append("\n"); 
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
		query.append("SELECT  A.ISS_DT, A.SPL_RGST_NO, A.OFC_CD, " ).append("\n"); 
		query.append("        A.TAX_VAT_TP_CD," ).append("\n"); 
		query.append("        A.TAX_INV_YRMON||A.OFC_CD||A.TAX_SER_NO TAX_NO, A.SPL_AMT, " ).append("\n"); 
		query.append("        A.TAX_AMT, A.CURR_CD, DECODE(A.TAX_PL_CD, '1', '매입0%일반', B.AP_TAX_NM) TAX_CODE, " ).append("\n"); 
		query.append("	    A.CO_NM," ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(A.ISS_DT, 'YYYYMMDD'), 'YYYY/MM/DD HH24:MI:SS') ISS_DT_TIME" ).append("\n"); 
		query.append("FROM    FMS_TAX A, AP_TAX B " ).append("\n"); 
		query.append("WHERE	A.FA_FLG = B.FA_FLG(+)" ).append("\n"); 
		query.append("AND     A.TAX_NAID_FLG = B.TAX_NAID_FLG(+)" ).append("\n"); 
		query.append("AND     A.TAX_NSL_FLG = B.TAX_NSL_FLG(+)" ).append("\n"); 
		query.append("AND     A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || A.SLP_ISS_DT || A.SLP_SER_NO IN (" ).append("\n"); 
		query.append("                                                                                            SELECT MIN(CSR_NO) AS CSR_NO" ).append("\n"); 
		query.append("                                                                                            FROM" ).append("\n"); 
		query.append("                                                                                            (" ).append("\n"); 
		query.append("                                                                                                SELECT F.VAT_SLP_TP_CD || F.VAT_SLP_FUNC_CD || F.VAT_SLP_OFC_CD || F.VAT_SLP_ISS_DT || F.VAT_SLP_SER_NO  AS CSR_NO" ).append("\n"); 
		query.append("                                                                                                FROM FMS_CONSULTATION F" ).append("\n"); 
		query.append("                                                                                                WHERE F.SLP_TP_CD||F.SLP_FUNC_CD||F.SLP_OFC_CD||F.SLP_ISS_DT||F.SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("                                                                                                UNION  " ).append("\n"); 
		query.append("                                                                                                SELECT @[csr_no] AS CSR_NO" ).append("\n"); 
		query.append("                                                                                                FROM DUAL" ).append("\n"); 
		query.append("                                                                                            )    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     DECODE(A.TAX_VAT_TP_CD, '1', 0, 10) = B.TAX_RT(+)" ).append("\n"); 
		query.append("AND    (B.AP_TAX_NM LIKE '매입%0%' OR B.AP_TAX_NM LIKE 'FA%')" ).append("\n"); 

	}
}