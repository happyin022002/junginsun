/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOremoveInvChargeDetailDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.09.14 김진일
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

public class GeneralInvoiceAuditDBDAOremoveInvChargeDetailDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeInvChargeDetail
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOremoveInvChargeDetailDSQL(){
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
		query.append("FileName : GeneralInvoiceAuditDBDAOremoveInvChargeDetailDSQL").append("\n"); 
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
		query.append("DELETE FROM pso_chg_dtl" ).append("\n"); 
		query.append("WHERE (iss_cty_cd, so_seq ) IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT iss_cty_cd, so_seq" ).append("\n"); 
		query.append("FROM pso_charge" ).append("\n"); 
		query.append("WHERE vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("AND yd_cd = @[yd_cd]" ).append("\n"); 
		query.append("AND inv_no = @[inv_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}