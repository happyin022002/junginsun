/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOcheckApPayInvRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.11.25 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOcheckApPayInvRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkApPayInv
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOcheckApPayInvRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOcheckApPayInvRSQL").append("\n"); 
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
		query.append("SELECT NVL(COUNT(*), 0) cnt FROM pso_charge t1" ).append("\n"); 
		query.append("WHERE t1.vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("AND t1.yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("AND t1.inv_no = @[inv_no]" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 1 FROM ap_pay_inv t2" ).append("\n"); 
		query.append("WHERE t1.inv_rgst_no = t2.inv_rgst_no" ).append("\n"); 
		query.append("AND t2.csr_no IS NOT NULL" ).append("\n"); 
		query.append("AND INV_STS_CD NOT IN ('C', 'X')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}