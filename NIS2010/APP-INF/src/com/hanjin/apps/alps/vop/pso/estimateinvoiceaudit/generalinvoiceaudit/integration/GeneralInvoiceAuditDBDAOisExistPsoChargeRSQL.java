/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOisExistPsoChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.04.17 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOisExistPsoChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * isExistPsoCharge
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOisExistPsoChargeRSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOisExistPsoChargeRSQL").append("\n"); 
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
		query.append("SELECT A.ISS_CTY_CD" ).append("\n"); 
		query.append("      ,A.SO_SEQ" ).append("\n"); 
		query.append("      ,A.INV_NO" ).append("\n"); 
		query.append("FROM   PSO_CHARGE A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("-- vndr_seq, inv_no = unique" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    A.INV_NO   = RTRIM(@[inv_no])" ).append("\n"); 

	}
}