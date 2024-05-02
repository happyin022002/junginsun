/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceNoticeDBDAOsearchInvoicePendingCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceNoticeDBDAOsearchInvoicePendingCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 건수 조회
	  * </pre>
	  */
	public InvoiceNoticeDBDAOsearchInvoicePendingCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.integration ").append("\n"); 
		query.append("FileName : InvoiceNoticeDBDAOsearchInvoicePendingCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) pendingCount" ).append("\n"); 
		query.append("FROM trs_trsp_inv_wrk INV" ).append("\n"); 
		query.append("WHERE INV.trsp_inv_aud_sts_cd IN ('RC')" ).append("\n"); 
		query.append("AND INV.inv_vndr_seq = @[inv_vndr_seq]" ).append("\n"); 
		query.append("AND NVL(INV.delt_flg, 'E') <> 'Y'" ).append("\n"); 

	}
}