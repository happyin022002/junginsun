/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOcheckMultiInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOcheckMultiInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Multi Invoice 체크
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOcheckMultiInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOcheckMultiInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT inv_no" ).append("\n"); 
		query.append("FROM trs_trsp_inv_wrk a" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if ($inv_no.size() > 0)" ).append("\n"); 
		query.append("AND (a.inv_no) in (" ).append("\n"); 
		query.append("#foreach($invNoKey in ${inv_no})" ).append("\n"); 
		query.append("#if($velocityCount < $inv_no.size())" ).append("\n"); 
		query.append("('$invNoKey')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("('$invNoKey')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(a.delt_flg, 'E') <> 'Y'" ).append("\n"); 
		query.append("AND a.inv_vndr_seq = @[inv_vndr_seq]" ).append("\n"); 

	}
}