/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipOwVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipOwVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceByPaymentSlipOwVO
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipOwVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipOwVORSQL").append("\n"); 
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
		query.append("SELECT C.VNDR_SEQ" ).append("\n"); 
		query.append(",(SELECT M.VNDR_LGL_ENG_NM FROM MDM_VENDOR M WHERE M.VNDR_SEQ = C.VNDR_SEQ) VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM FMS_CONTRACT C, MDM_CUSTOMER M" ).append("\n"); 
		query.append("WHERE  C.CUST_CNT_CD = M.CUST_CNT_CD" ).append("\n"); 
		query.append("AND C.CUST_SEQ = M.CUST_SEQ" ).append("\n"); 
		query.append("AND C.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 

	}
}