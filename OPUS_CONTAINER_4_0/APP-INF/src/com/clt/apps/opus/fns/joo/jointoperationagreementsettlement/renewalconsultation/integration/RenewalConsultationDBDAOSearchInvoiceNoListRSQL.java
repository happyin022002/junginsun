/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalConsultationDBDAOSearchInvoiceNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalConsultationDBDAOSearchInvoiceNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice No List 조회.
	  * </pre>
	  */
	public RenewalConsultationDBDAOSearchInvoiceNoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acctg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.renewalconsultation.integration").append("\n"); 
		query.append("FileName : RenewalConsultationDBDAOSearchInvoiceNoListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT INV.INV_NO" ).append("\n"); 
		query.append("  FROM JOO_INVOICE INV" ).append("\n"); 
		query.append("     , JOO_INV_DTL DTL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND INV.ACCT_YRMON   = DTL.ACCT_YRMON" ).append("\n"); 
		query.append("   AND INV.JO_CRR_CD    = DTL.JO_CRR_CD" ).append("\n"); 
		query.append("   AND INV.INV_NO       = DTL.INV_NO" ).append("\n"); 
		query.append("   AND INV.RE_DIVR_CD   = DTL.RE_DIVR_CD" ).append("\n"); 
		query.append("   AND INV.ACCT_YRMON   BETWEEN REPLACE(@[fr_acct_yrmon],'-') AND REPLACE(@[to_acct_yrmon],'-')" ).append("\n"); 
		query.append("#if (${acctg_crr_cd} != '') " ).append("\n"); 
		query.append("   AND INV.ACCTG_CRR_CD    = @[acctg_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY INV.INV_NO" ).append("\n"); 

	}
}