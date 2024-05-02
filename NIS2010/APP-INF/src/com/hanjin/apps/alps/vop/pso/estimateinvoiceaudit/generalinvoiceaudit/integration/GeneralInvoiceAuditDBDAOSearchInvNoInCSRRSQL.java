/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchInvNoInCSRRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.31
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2012.07.31 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hyemin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchInvNoInCSRRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search if there exists already the same invoice NO. in Common CSR or not.
	  * =============================================================================
	  * 2012.03.14 CHM-201216319-01 진마리아 Port charge Invocie No. Check 로직 변경 요청
	  * 2012.07.31 CHM-201219306-01 이혜민    AP VVD 와 GL VVD 일치 요청
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchInvNoInCSRRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchInvNoInCSRRSQL").append("\n"); 
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
		query.append("SELECT VNDR_SEQ" ).append("\n"); 
		query.append(", INV_NO" ).append("\n"); 
		query.append("FROM AP_PAY_INV" ).append("\n"); 
		query.append("WHERE  VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    INV_NO   = @[inv_no]" ).append("\n"); 
		query.append("AND	   DELT_FLG = 'N'" ).append("\n"); 

	}
}