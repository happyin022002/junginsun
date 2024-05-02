/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceAuditDBDAOCalculateExchangeRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.08.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceAuditDBDAOCalculateExchangeRateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Currency 환률을 계산한다.
	  * </pre>
	  */
	public InvoiceAuditDBDAOCalculateExchangeRateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apply_currency",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
		query.append("FileName : InvoiceAuditDBDAOCalculateExchangeRateRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ TRSP_SO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append("      ,ROUND((NVL(A.BZC_AMT, 0) + NVL(A.NEGO_AMT, 0) + NVL(A.FUEL_SCG_AMT, 0) + NVL(A.ETC_ADD_AMT, 0)) " ).append("\n"); 
		query.append("		#if( ${trsp_inv_calc_lgc_tp_cd} == 'DV' )" ).append("\n"); 
		query.append("             /" ).append("\n"); 
		query.append(" 		#else" ).append("\n"); 
		query.append("			 *" ).append("\n"); 
		query.append(" 		#end			  " ).append("\n"); 
		query.append("			 TO_NUMBER(@[inv_xch_rt])," ).append("\n"); 
		query.append("			  NVL((SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[apply_currency]), 0)" ).append("\n"); 
		query.append("			) AS INV_BZC_AMT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(" WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}