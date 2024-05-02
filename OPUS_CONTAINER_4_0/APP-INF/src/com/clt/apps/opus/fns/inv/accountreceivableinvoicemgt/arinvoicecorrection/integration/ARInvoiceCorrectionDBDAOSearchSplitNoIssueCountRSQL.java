/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchSplitNoIssueCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchSplitNoIssueCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Split No Issue Count
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchSplitNoIssueCountRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration ").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchSplitNoIssueCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE (AR_OFC_CD, BL_SRC_NO) IN (SELECT AR_OFC_CD, BL_SRC_NO" ).append("\n"); 
		query.append("                                 FROM INV_AR_MN" ).append("\n"); 
		query.append("                                 WHERE AR_IF_NO = @[ar_if_no])" ).append("\n"); 
		query.append("AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("AND INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(INV_SPLIT_CD, 'N') = 'S'" ).append("\n"); 
		query.append("AND INV_ISS_FLG = 'N'" ).append("\n"); 

	}
}