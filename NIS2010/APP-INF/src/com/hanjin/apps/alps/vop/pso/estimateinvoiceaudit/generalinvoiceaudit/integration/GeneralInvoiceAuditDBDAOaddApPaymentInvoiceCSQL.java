/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOaddApPaymentInvoiceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.10.05 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOaddApPaymentInvoiceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addApPaymentInvoice
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOaddApPaymentInvoiceCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration ").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOaddApPaymentInvoiceCSQL").append("\n"); 
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
		query.append("INSERT INTO AP_PAY_INV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INV_RGST_NO,        --PUS20090100090" ).append("\n"); 
		query.append("INV_SUB_SYS_CD," ).append("\n"); 
		query.append("INV_OFC_CD," ).append("\n"); 
		query.append("COST_OFC_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("INV_ISS_DT," ).append("\n"); 
		query.append("INV_RCV_DT," ).append("\n"); 
		query.append("INV_EFF_DT," ).append("\n"); 
		query.append("INV_CFM_DT," ).append("\n"); 
		query.append("VNDR_TERM_NM," ).append("\n"); 
		query.append("PAY_DUE_DT," ).append("\n"); 
		query.append("INV_CURR_CD," ).append("\n"); 
		query.append("INV_TTL_AMT," ).append("\n"); 
		query.append("INV_VAT_AMT," ).append("\n"); 
		query.append("INV_NET_AMT," ).append("\n"); 
		query.append("INV_DDCT_AMT," ).append("\n"); 
		query.append("TAX_RFND_FLG,--'N'" ).append("\n"); 
		query.append("INV_AMT," ).append("\n"); 
		query.append("JO_FLG,--'N'" ).append("\n"); 
		query.append("COM_VVD_FLG,--'N'" ).append("\n"); 
		query.append("INV_RJCT_FLG,--'N'" ).append("\n"); 
		query.append("INV_CXL_FLG,--'N'" ).append("\n"); 
		query.append("EVID_HLD_FLG,--'N'" ).append("\n"); 
		query.append("DELT_FLG,--'N'" ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("(	SELECT CASE" ).append("\n"); 
		query.append("WHEN A.CNT = 0 THEN SUBSTR(@[cost_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMM')||'00001'" ).append("\n"); 
		query.append("ELSE SUBSTR(@[cost_ofc_cd],1,3)||RGST_NO" ).append("\n"); 
		query.append("END  INV_RGST_NO" ).append("\n"); 
		query.append("FROM   ( SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   AP_PAY_INV" ).append("\n"); 
		query.append("WHERE  SUBSTR(INV_RGST_NO,1,9) = SUBSTR(@[cost_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMM') ) A," ).append("\n"); 
		query.append("( SELECT MAX(TO_NUMBER(SUBSTR(INV_RGST_NO,4,11)))+1 RGST_NO" ).append("\n"); 
		query.append("FROM   AP_PAY_INV" ).append("\n"); 
		query.append("WHERE  SUBSTR(INV_RGST_NO,1,9) = SUBSTR(@[cost_ofc_cd],1,3)||TO_CHAR(SYSDATE,'YYYYMM') ) B)" ).append("\n"); 
		query.append("'PSO'," ).append("\n"); 
		query.append("INV_OFC_CD," ).append("\n"); 
		query.append("COST_OFC_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("ISS_DT," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("EFF_DT," ).append("\n"); 
		query.append("ACPT_DT," ).append("\n"); 
		query.append("PAY_TERM_DYS," ).append("\n"); 
		query.append("DUE_DT,       --iss + Term" ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("TTL_LOCL_AMT," ).append("\n"); 
		query.append("LOCL_TAX_AMT," ).append("\n"); 
		query.append("LOCL_NET_AMT," ).append("\n"); 
		query.append("LOCL_DDCT_AMT," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("TTL_LOCL_AMT," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'USERID'," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("'USERID'," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM PSO_CHARGE" ).append("\n"); 
		query.append("WHERE ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("and SO_SEQ = @[so_seq]" ).append("\n"); 

	}
}