/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAuditDBDAOCalculateExchangeRateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.12.22 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
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
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration").append("\n"); 
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
		query.append("SELECT															" ).append("\n"); 
		query.append(" A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ TRSP_SO_OFC_CTY_CD_SEQ		" ).append("\n"); 
		query.append(" ,ROUND(( 														 		" ).append("\n"); 
		query.append("		NVL(A.BZC_AMT,0)	+							 	" ).append("\n"); 
		query.append("		NVL(A.NEGO_AMT,0)	+							 	" ).append("\n"); 
		query.append("		NVL(A.FUEL_SCG_AMT,0)	+	" ).append("\n"); 
		query.append("		NVL(A.SCG_VAT_AMT,0)	+							 	" ).append("\n"); 
		query.append("		NVL(A.ETC_ADD_AMT,0)	+" ).append("\n"); 
		query.append("        NVL(A.TOLL_FEE_AMT,0)								 	" ).append("\n"); 
		query.append(" )	" ).append("\n"); 
		query.append(" #if( ${trsp_inv_calc_lgc_tp_cd} == 'DV' )" ).append("\n"); 
		query.append("	/" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("	*" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("	TO_NUMBER(@[inv_xch_rt]), 2) AS INV_BZC_AMT			" ).append("\n"); 
		query.append(" FROM										 						" ).append("\n"); 
		query.append(" 	TRS_TRSP_SVC_ORD A												" ).append("\n"); 
		query.append(" WHERE																" ).append("\n"); 
		query.append(" 		TRSP_SO_OFC_CTY_CD 	= @[trsp_so_ofc_cty_cd]								" ).append("\n"); 
		query.append(" AND	TRSP_SO_SEQ 			= @[trsp_so_seq]						" ).append("\n"); 
		query.append("		/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append(" AND	A.HJL_NO IS NULL" ).append("\n"); 

	}
}