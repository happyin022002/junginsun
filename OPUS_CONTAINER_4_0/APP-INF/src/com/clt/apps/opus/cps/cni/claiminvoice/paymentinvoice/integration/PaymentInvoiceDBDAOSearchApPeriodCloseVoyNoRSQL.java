/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PaymentInvoiceDBDAOSearchApPeriodCloseVoyNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PaymentInvoiceDBDAOSearchApPeriodCloseVoyNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 재무 공통 항차가  Close 상태일 경우 다음  VOY_NO 취득
	  * </pre>
	  */
	public PaymentInvoiceDBDAOSearchApPeriodCloseVoyNoRSQL(){
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
		params.put("inv_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.integration").append("\n"); 
		query.append("FileName : PaymentInvoiceDBDAOSearchApPeriodCloseVoyNoRSQL").append("\n"); 
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
		query.append("    SUBSTR (MIN (N.EFF_YRMON), 3, 4) SKD_VOY_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    AP_PERIOD N" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    N.SYS_DIV_CD     = '15'" ).append("\n"); 
		query.append("    AND N.EFF_YRMON >= SUBSTR(@[inv_iss_dt], 1, 6) -- iss_dt" ).append("\n"); 
		query.append("    AND N.OFC_CD    IN (@[cost_ofc_cd], (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            MDM_ORGANIZATION M" ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            M.OFC_CD = @[cost_ofc_cd] -- cost ofc" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    AND N.AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("    AND N.CLZ_STS_CD   = 'O'" ).append("\n"); 

	}
}