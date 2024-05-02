/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchINVChargeInfoForIssueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchINVChargeInfoForIssueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR_IF_NO 로 발행대상 Charge 정보 조회
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchINVChargeInfoForIssueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchINVChargeInfoForIssueRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	  IAC.AR_IF_NO" ).append("\n"); 
		query.append("	, IAC.CHG_SEQ" ).append("\n"); 
		query.append("	, IAC.CHG_CD" ).append("\n"); 
		query.append(" 	, IAC.CURR_CD" ).append("\n"); 
		query.append("	, IAC.INV_XCH_RT" ).append("\n"); 
		query.append("    , '' AS ISS_XCH_RT" ).append("\n"); 
		query.append("    , IAM.BL_SRC_NO" ).append("\n"); 
		query.append("    , IAM.INV_DELT_DIV_CD" ).append("\n"); 
		query.append("    , IAM.AR_OFC_CD" ).append("\n"); 
		query.append("    , IAC.USD_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_CHG IAC, INV_AR_MN IAM" ).append("\n"); 
		query.append("WHERE IAC.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND   IAC.AR_IF_NO = IAM.AR_IF_NO" ).append("\n"); 

	}
}