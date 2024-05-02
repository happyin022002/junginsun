/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMSalesLeadDBDAOPriCrmSlsLdCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CRMSalesLeadDBDAOPriCrmSlsLdCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRM Sales Lead 유무를 체크하기위해 Count를 조회한다.
	  * </pre>
	  */
	public CRMSalesLeadDBDAOPriCrmSlsLdCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ld_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration").append("\n"); 
		query.append("FileName : CRMSalesLeadDBDAOPriCrmSlsLdCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(SLS_LD_NO) AS CNT" ).append("\n"); 
		query.append("FROM PRI_CRM_SLS_LD" ).append("\n"); 
		query.append("WHERE	SLS_LD_NO = @[sls_ld_no]" ).append("\n"); 

	}
}