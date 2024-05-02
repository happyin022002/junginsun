/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOmodifyCsrAttachTariffFileUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOmodifyCsrAttachTariffFileUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * file attach 유무를 updat하기 위함
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOmodifyCsrAttachTariffFileUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOmodifyCsrAttachTariffFileUSQL").append("\n"); 
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
		query.append("UPDATE AP_INV_HDR SET AGMT_FILE_CFM_CD ='Y'" ).append("\n"); 
		query.append("WHERE CSR_NO              = @[csr_no]" ).append("\n"); 
		query.append("  AND SRC_CTNT            = 'SO_PORT'" ).append("\n"); 
		query.append("  AND 'Y'  IN ( SELECT CASE WHEN COUNT(1) > 0 THEN 'Y'" ).append("\n"); 
		query.append("                                ELSE  'N' " ).append("\n"); 
		query.append("                           END " ).append("\n"); 
		query.append("                  FROM COM_AP_FILE_UPLD" ).append("\n"); 
		query.append("                 WHERE CSR_NO              = @[csr_no]" ).append("\n"); 
		query.append("                   AND CSR_FILE_UPLD_TP_CD = 'PF'" ).append("\n"); 
		query.append("                   AND NVL(DELT_FLG ,'N')  = 'N'" ).append("\n"); 
		query.append("                   AND AP_FILE_DIV_CD      = 'C' ) " ).append("\n"); 

	}
}