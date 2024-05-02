/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceNoticeDBDAOsearchInvoiceNoticeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceNoticeDBDAOsearchInvoiceNoticeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceNoticeList
	  * </pre>
	  */
	public InvoiceNoticeDBDAOsearchInvoiceNoticeListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_count",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.notice.integration").append("\n"); 
		query.append("FileName : InvoiceNoticeDBDAOsearchInvoiceNoticeListRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM, A.* from " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT ROWNUM row_num, " ).append("\n"); 
		query.append("	TO_CHAR(INV.cre_dt,'YYYY-MM-DD') cre_dt, " ).append("\n"); 
		query.append("	INV.inv_no, " ).append("\n"); 
		query.append("	INV.trsp_inv_aud_sts_cd, " ).append("\n"); 
		query.append("	(select intg_cd_val_dp_desc from com_intg_cd_dtl where intg_cd_id = 'CD00824' and intg_cd_val_ctnt = INV.trsp_inv_aud_sts_cd) status " ).append("\n"); 
		query.append("FROM trs_trsp_inv_wrk INV " ).append("\n"); 
		query.append("WHERE INV.inv_vndr_seq = @[inv_vndr_seq] " ).append("\n"); 
		query.append("	AND NVL(INV.delt_flg, 'E') <> 'Y'" ).append("\n"); 
		query.append(" 	AND INV.cre_dt >= to_date('20170213', 'yyyyMMdd')" ).append("\n"); 
		query.append("ORDER BY INV.cre_dt desc " ).append("\n"); 
		query.append(") A " ).append("\n"); 
		query.append("WHERE ROWNUM < (@[max_count] +1)" ).append("\n"); 

	}
}