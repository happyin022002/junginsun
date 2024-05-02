/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.09.22 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOutstandingDetailCheckForInvoiceCreation
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL").append("\n"); 
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
		query.append("x.allCnt," ).append("\n"); 
		query.append("y.validCnt," ).append("\n"); 
		query.append("x.allCnt - y.validCnt As invalidCnt," ).append("\n"); 
		query.append("DECODE( SIGN(y.validCnt)," ).append("\n"); 
		query.append("1, DECODE( SIGN(x.allCnt-y.validCnt), 0, 'Y', 'N')," ).append("\n"); 
		query.append("'N'" ).append("\n"); 
		query.append(") As validYn" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( /* all tpb to invoice  */" ).append("\n"); 
		query.append("SELECT COUNT(0) allCnt" ).append("\n"); 
		query.append("FROM tpb_ots_dtl a, tpb_ots_grp b" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND a.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("AND a.n3pty_no IN ( NULL" ).append("\n"); 
		query.append("/*--- n3pty_no 조건, \"','\" 구분자 처리 ---  */" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append(", $s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") x," ).append("\n"); 
		query.append("( /*----- valid tpb to invoice */" ).append("\n"); 
		query.append("SELECT COUNT(0) validCnt" ).append("\n"); 
		query.append("FROM tpb_ots_dtl a, tpb_ots_grp b" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND a.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("AND a.vndr_cust_div_cd IN ('V','C')" ).append("\n"); 
		query.append("AND a.n3pty_delt_tp_cd IN ('N','S')" ).append("\n"); 
		query.append("AND b.n3pty_delt_tp_cd = 'N'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT n3pty_no" ).append("\n"); 
		query.append("FROM tpb_ots_grp_sts c" ).append("\n"); 
		query.append("WHERE c.n3pty_no = a.n3pty_no" ).append("\n"); 
		query.append("AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND c.ots_sts_cd IN ('O','M','J')   /* Changed By Kim Jin-seung In 2007-08-03; added J */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ( b.n3pty_inv_no IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("NOT EXISTS (" ).append("\n"); 
		query.append("SELECT n3pty_inv_no" ).append("\n"); 
		query.append("FROM tpb_invoice v" ).append("\n"); 
		query.append("WHERE v.n3pty_inv_no = b.n3pty_inv_no" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND a.n3pty_no IN ( NULL" ).append("\n"); 
		query.append("/* --- n3pty_no 조건, \"','\" 구분자 처리 ---  */" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append(", $s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 

	}
}