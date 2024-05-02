/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOSubAgentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2010.03.05 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOSubAgentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_SUB_POD_AGN_CUST_CD 테이블에서 AR OFFICE로 등록된 Agent 내용을 조회한다.
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOSubAgentListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOSubAgentListRSQL").append("\n"); 
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
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("DECODE(POR_CD, 'XXXXX', '', POR_CD) POR_CD," ).append("\n"); 
		query.append("DECODE(POL_CD, 'XXXXX', '', POL_CD) POL_CD," ).append("\n"); 
		query.append("DECODE(POD_CD, 'XXXXX', '', POD_CD) POD_CD," ).append("\n"); 
		query.append("DECODE(DEL_CD, 'XXXXX', '', DEL_CD) DEL_CD," ).append("\n"); 
		query.append("AGN_NM," ).append("\n"); 
		query.append("DECODE(REP_CUST_CNT_CD,'','',DECODE(REP_CUST_SEQ,'','',REP_CUST_CNT_CD || '-' || LPAD(REP_CUST_SEQ,6,0))) CUST_CD," ).append("\n"); 
		query.append("REP_CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(REP_CUST_SEQ,6,0) REP_CUST_SEQ," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("'-' REP_CUST_BAR" ).append("\n"); 
		query.append("FROM INV_SUB_AGN_CUST_CD" ).append("\n"); 
		query.append("WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 

	}
}