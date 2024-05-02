/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JOInvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOInvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOutstandingDetailCheckForInvoiceCreation
	  * </pre>
	  */
	public JOInvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.integration").append("\n"); 
		query.append("FileName : JOInvoiceManageDBDAOSearchOutstandingDetailCheckForInvoiceCreationRSQL").append("\n"); 
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
		query.append("SELECT X.ALLCNT" ).append("\n"); 
		query.append(",Y.VALIDCNT" ).append("\n"); 
		query.append(",X.ALLCNT - Y.VALIDCNT AS INVALIDCNT" ).append("\n"); 
		query.append(",DECODE( SIGN(Y.VALIDCNT)" ).append("\n"); 
		query.append(",1" ).append("\n"); 
		query.append(",DECODE( SIGN(X.ALLCNT-Y.VALIDCNT), 0, 'Y', 'N'),'N') AS VALIDYN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( /* ALL TPB TO INVOICE  */" ).append("\n"); 
		query.append("SELECT COUNT(0) ALLCNT" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A, TPB_OTS_GRP B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("AND A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("/*--- N3PTY_NO 조건, \"','\" 구분자 처리 ---  */" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append(",$s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("( /*----- VALID TPB TO INVOICE */" ).append("\n"); 
		query.append("SELECT COUNT(0) VALIDCNT" ).append("\n"); 
		query.append("FROM TPB_OTS_DTL A, TPB_OTS_GRP B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("AND A.VNDR_CUST_DIV_CD IN ('V','C')" ).append("\n"); 
		query.append("AND A.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("AND B.N3PTY_DELT_TP_CD = 'N'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT N3PTY_NO" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append("WHERE C.N3PTY_NO = A.N3PTY_NO" ).append("\n"); 
		query.append("AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("AND C.OTS_STS_CD IN ('O','M','J')   /* CHANGED BY KIM JIN-SEUNG IN 2007-08-03; ADDED J */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ( B.N3PTY_INV_NO IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("NOT EXISTS (" ).append("\n"); 
		query.append("SELECT N3PTY_INV_NO" ).append("\n"); 
		query.append("FROM TPB_INVOICE V" ).append("\n"); 
		query.append("WHERE V.N3PTY_INV_NO = B.N3PTY_INV_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.N3PTY_NO IN ( NULL" ).append("\n"); 
		query.append("/* --- n3pty_no 조건, \"','\" 구분자 처리 ---  */" ).append("\n"); 
		query.append("#if (${s_dao_n3pty_no} != '')" ).append("\n"); 
		query.append(",$s_dao_n3pty_no" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 

	}
}