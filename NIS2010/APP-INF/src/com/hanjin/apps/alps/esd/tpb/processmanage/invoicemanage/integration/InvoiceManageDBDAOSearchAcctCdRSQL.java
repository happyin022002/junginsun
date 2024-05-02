/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchAcctCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchAcctCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.29 변종건 [CHM-201220985-01] [TPB] PSO에 대한 3자구상 개발관련 - Account 정보 조회
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchAcctCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration ").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchAcctCdRSQL").append("\n"); 
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
		query.append("SELECT  ACCT_CD NAME" ).append("\n"); 
		query.append("      , ACCT_ENG_NM VAL" ).append("\n"); 
		query.append("FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("and     (" ).append("\n"); 
		query.append("             ACCT_CD LIKE '5117%'" ).append("\n"); 
		query.append("          OR ACCT_CD LIKE '5118%'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     ESTM_TGT_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY ACCT_CD" ).append("\n"); 

	}
}