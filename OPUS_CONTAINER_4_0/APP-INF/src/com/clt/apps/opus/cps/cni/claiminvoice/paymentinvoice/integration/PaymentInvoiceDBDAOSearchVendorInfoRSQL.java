/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PaymentInvoiceDBDAOSearchVendorInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.12.24 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PaymentInvoiceDBDAOSearchVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor 정보 취득
	  * </pre>
	  */
	public PaymentInvoiceDBDAOSearchVendorInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.integration").append("\n"); 
		query.append("FileName : PaymentInvoiceDBDAOSearchVendorInfoRSQL").append("\n"); 
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
		query.append("    VNDR_SEQ" ).append("\n"); 
		query.append("  , VNDR_CNT_CD" ).append("\n"); 
		query.append("  , INV_CURR_CD" ).append("\n"); 
		query.append("  , NVL(PAY_CURR_CD,  INV_CURR_CD) AS PAY_CURR_CD" ).append("\n"); 
		query.append("  , GEN_PAY_TERM_CD  " ).append("\n"); 
		query.append("  , VNDR_OFC_CD  " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}