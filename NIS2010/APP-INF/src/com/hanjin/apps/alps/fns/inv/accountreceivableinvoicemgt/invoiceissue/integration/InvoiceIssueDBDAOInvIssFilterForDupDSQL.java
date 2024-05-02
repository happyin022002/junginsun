/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOInvIssFilterForDupDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.02.03 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOInvIssFilterForDupDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvIssFilterForDup
	  * </pre>
	  */
	public InvoiceIssueDBDAOInvIssFilterForDupDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOInvIssFilterForDupDSQL").append("\n"); 
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
		query.append("DELETE FROM INV_AR_ISS_FTR" ).append("\n"); 
		query.append(" WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("   AND BL_SRC_NO NOT IN (SELECT A.BL_SRC_NO" ).append("\n"); 
		query.append("                           FROM (SELECT BL_SRC_NO" ).append("\n"); 
		query.append("                                      , MAX(AR_IF_NO) AR_IF_NO" ).append("\n"); 
		query.append("                                   FROM INV_AR_ISS_FTR" ).append("\n"); 
		query.append("                                  WHERE INV_ISS_WRK_NO = @[wrk_no]" ).append("\n"); 
		query.append("                                  GROUP BY BL_SRC_NO ) A" ).append("\n"); 
		query.append("                              , INV_AR_MN B" ).append("\n"); 
		query.append("                              , MDM_CUSTOMER C" ).append("\n"); 
		query.append("                          WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                            AND B.USD_XCH_RT <> 0" ).append("\n"); 
		query.append("                            AND B.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND B.ACT_CUST_SEQ    = C.CUST_SEQ" ).append("\n"); 
		query.append("                            AND NVL(C.CNTR_DIV_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                            AND NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                            AND B.ACT_CUST_CNT_CD||B.ACT_CUST_SEQ NOT IN (SELECT S2.REP_CUST_CNT_CD||S2.REP_CUST_SEQ" ).append("\n"); 
		query.append("                                                                            FROM MDM_ORGANIZATION S2" ).append("\n"); 
		query.append("                                                                           WHERE B.AR_OFC_CD = S2.AR_OFC_CD" ).append("\n"); 
		query.append("                                                                             AND S2.DELT_FLG = 'N'))" ).append("\n"); 

	}
}