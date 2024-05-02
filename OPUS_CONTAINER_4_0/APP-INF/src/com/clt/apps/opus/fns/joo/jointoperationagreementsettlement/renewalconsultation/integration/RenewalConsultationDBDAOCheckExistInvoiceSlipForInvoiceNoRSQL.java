/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOCheckExistInvoiceSlipForInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOCheckExistInvoiceSlipForInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoic No에 전표가 존재 하는지 체크
	  * </pre>
	  */
	public RenewalConsultationDBDAOCheckExistInvoiceSlipForInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration ").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOCheckExistInvoiceSlipForInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(INV.INV_NO) > 0 THEN 'Y' ELSE 'N' END AS EXIST_FLG" ).append("\n"); 
		query.append("  FROM JOO_INVOICE INV" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND INV.INV_NO           = @[inv_no]" ).append("\n"); 
		query.append("   AND INV.ACCT_YRMON       = @[acct_yrmon]" ).append("\n"); 
		query.append("   AND INV.RE_DIVR_CD       = @[re_divr_cd]" ).append("\n"); 
		query.append("   AND INV.ACCTG_CRR_CD     = @[acctg_crr_cd]" ).append("\n"); 
		query.append("   AND INV.LOCL_CURR_CD     = @[locl_curr_cd]" ).append("\n"); 
		query.append("   AND INV.PRNR_REF_NO      = @[prnr_ref_no]" ).append("\n"); 
		query.append("   AND TRIM(INV.SLP_TP_CD||INV.SLP_FUNC_CD||INV.SLP_OFC_CD||INV.SLP_ISS_DT||INV.SLP_SER_NO) IS NOT NULL" ).append("\n"); 

	}
}