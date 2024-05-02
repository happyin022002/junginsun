/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchVIEDailyExrateMaxToDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.02.02 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchVIEDailyExrateMaxToDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchVIEDailyExrateMaxToDtRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchVIEDailyExrateMaxToDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchVIEDailyExrateMaxToDtRSQL").append("\n"); 
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
		query.append("SELECT INV_XCH_RT XCH_RT" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("AND CUST_SEQ = 0" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("AND LOCL_CURR_CD = (SELECT AR_CURR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND XCH_RT_TP_CD ='D'" ).append("\n"); 
		query.append("AND TO_DT = (SELECT MAX(TO_DT)" ).append("\n"); 
		query.append("FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("AND CUST_SEQ = 0" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_CURR_CD = 'USD'" ).append("\n"); 
		query.append("AND XCH_RT_TP_CD ='D'" ).append("\n"); 
		query.append("AND LOCL_CURR_CD = (SELECT AR_CURR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("AND TO_CHAR(SYSDATE, 'YYYYMMDD') >= TO_DT)" ).append("\n"); 

	}
}