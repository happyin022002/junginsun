/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOPrintGemCsrHeaderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOPrintGemCsrHeaderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * G/W xml header 정보 수집
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOPrintGemCsrHeaderInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration ").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOPrintGemCsrHeaderInfoRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append(" SUBS_CSR_NO  CSR_NO" ).append("\n"); 
		query.append(",SUBS_OFC_CD" ).append("\n"); 
		query.append(",SUBSTR(INP_DT,1,4)||'/'||SUBSTR(INP_DT,5,2)||'/'||SUBSTR(INP_DT,7,2)  CSRDATE" ).append("\n"); 
		query.append(",SUBSTR(INV_DT,1,4)||'/'||SUBSTR(INV_DT,5,2)||'/'||SUBSTR(INV_DT,7,2)  INVOICE_DATE" ).append("\n"); 
		query.append(",APRO_DT" ).append("\n"); 
		query.append(",APRO_RSLT_CD" ).append("\n"); 
		query.append(",GW_APRO_URL_CTNT" ).append("\n"); 
		query.append(",GW_CSR_RQST_ID" ).append("\n"); 
		query.append(",GW_CSR_RQSTR_ID" ).append("\n"); 
		query.append(",GW_APROR_ID" ).append("\n"); 
		query.append(",PAY_VNDR_NM    PAY_TO" ).append("\n"); 
		query.append(",INV_CURR_CD" ).append("\n"); 
		query.append(",INV_LOCL_TTL_AMT  INV_LCL_AMT" ).append("\n"); 
		query.append(",INV_USD_TTL_AMT   INV_USD_AMT" ).append("\n"); 
		query.append(",DECODE(EXPN_DIV_CD,'R','Salary&Allowance','W','Welfare','E','Enterainment','Management&Other') EXPN_TYPE " ).append("\n"); 
		query.append(",GEM_GET_FNL_JB_CD_FNC(@[csr_no]) APR_LINE" ).append("\n"); 
		query.append("FROM GEM_SUBS_CSUL_HDR" ).append("\n"); 
		query.append("WHERE SUBS_CSR_NO = @[csr_no]" ).append("\n"); 

	}
}