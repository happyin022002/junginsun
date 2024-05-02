/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOsearchApPayInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOsearchApPayInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchApPayInv
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOsearchApPayInvRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOsearchApPayInvRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("INV_RGST_NO," ).append("\n"); 
		query.append("'PSO' INV_SUB_SYS_CD," ).append("\n"); 
		query.append("COST_OFC_CD," ).append("\n"); 
		query.append("INV_OFC_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("INV_NO," ).append("\n"); 
		query.append("to_char(ISS_DT, 'YYYYMMDD') INV_ISS_DT," ).append("\n"); 
		query.append("to_char(ACPT_DT, 'YYYYMMDD')  INV_RCV_DT," ).append("\n"); 
		query.append("to_char(EFF_DT, 'YYYYMMDD')  INV_EFF_DT," ).append("\n"); 
		query.append("to_char(ACPT_DT, 'YYYYMMDD')  INV_CFM_DT," ).append("\n"); 
		query.append("PAY_TERM_DYS VNDR_TERM_NM," ).append("\n"); 
		query.append("to_char(DUE_DT, 'YYYYMMDD')  PAY_DUE_DT,       --iss + Term" ).append("\n"); 
		query.append("CURR_CD INV_CURR_CD," ).append("\n"); 
		query.append("--NVL(INV_LOCL_AMT, 0) - NVL(LOCL_WHLD_TAX_AMT, 0)  INV_TTL_AMT,	--CSR연계시 Withholding Tax를 뺀다." ).append("\n"); 
		query.append("NVL(INV_LOCL_AMT, 0)  INV_TTL_AMT," ).append("\n"); 
		query.append("LOCL_TAX_AMT INV_VAT_AMT," ).append("\n"); 
		query.append("LOCL_WHLD_TAX_AMT WHLD_TAX_AMT, --" ).append("\n"); 
		query.append("LOCL_NET_AMT INV_NET_AMT," ).append("\n"); 
		query.append("LOCL_DDCT_AMT INV_DDCT_AMT," ).append("\n"); 
		query.append("'N' TAX_RFND_FLG," ).append("\n"); 
		query.append("--TTL_LOCL_AMT INV_AMT," ).append("\n"); 
		query.append("LOCL_NET_AMT INV_AMT," ).append("\n"); 
		query.append("'N' JO_FLG," ).append("\n"); 
		query.append("'N' COM_VVD_FLG," ).append("\n"); 
		query.append("'N' INV_RJCT_FLG," ).append("\n"); 
		query.append("'N' INV_CXL_FLG," ).append("\n"); 
		query.append("'N' EVID_HLD_FLG," ).append("\n"); 
		query.append("'N' DELT_FLG," ).append("\n"); 
		query.append("'USERID' CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("'USERID' UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE UPD_DT," ).append("\n"); 
		query.append("PSO_TRNS_SLP_CTNT," ).append("\n"); 
		query.append("DECODE(PSO_TRNS_SLP_CTNT, 'AR', '투자비보전관련 항비대체 ('||to_char(ISS_DT, 'YYYY.MM')||')' ) INV_RMK" ).append("\n"); 
		query.append("FROM PSO_CHARGE" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if(${inv_no}!='')" ).append("\n"); 
		query.append("AND INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and ISS_CTY_CD = @[iss_cty_cd]" ).append("\n"); 
		query.append("and SO_SEQ = @[so_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}