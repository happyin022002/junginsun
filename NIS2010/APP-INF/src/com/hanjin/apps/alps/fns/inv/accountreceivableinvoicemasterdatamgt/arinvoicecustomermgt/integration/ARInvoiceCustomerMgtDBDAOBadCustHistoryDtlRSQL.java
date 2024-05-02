/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOBadCustHistoryDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOBadCustHistoryDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 악성화주 히스토리를 조회한다.
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOBadCustHistoryDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOBadCustHistoryDtlRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(TO_DATE(A.SLS_DELT_EFF_DT,'YYYY-MM-DD'),'YYYY-MM-DD') SLS_DELT_EFF_DT " ).append("\n"); 
		query.append("     , A.BAD_CUST_KND_CD BAD_CUST_KND_CD" ).append("\n"); 
		query.append("     , A.BAD_CUST_RSN BAD_CUST_RSN" ).append("\n"); 
		query.append("     , DECODE(A.BAD_CUST_KND_CD, 'N', 'No Use in Sale', 'F', 'Financial Risk to release B/L and Cargo') BAD_CUST_KND_CD" ).append("\n"); 
		query.append("     , DECODE(A.BAD_CUST_KND_CD, 'N', DECODE(A.BAD_CUST_RSN, '04', 'Bankruptcy', '05', 'Bad OTS')     " ).append("\n"); 
		query.append("                          , 'F', A.BAD_CUST_RSN) BAD_CUST_RSN" ).append("\n"); 
		query.append("     , A.UPD_OFC_CD UPD_OFC" ).append("\n"); 
		query.append("     , A.UPD_USR_ID UPD_USR_ID" ).append("\n"); 
		query.append("     , B.USR_NM UPD_USR_NM" ).append("\n"); 
		query.append("FROM INV_BAD_CUST_HIS A, COM_USER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND A.UPD_USR_ID = UPPER(B.USR_ID(+))  -- COM_USER 테이블에는 USR_ID 가 소문자로 존재하는것도 있음. 하지만 MDM 테이블에는 대문자로 존재하여 UPPER 를 사용함" ).append("\n"); 

	}
}