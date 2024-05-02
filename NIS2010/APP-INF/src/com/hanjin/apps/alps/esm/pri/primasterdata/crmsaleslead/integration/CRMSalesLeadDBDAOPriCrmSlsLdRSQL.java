/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMSalesLeadDBDAOPriCrmSlsLdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CRMSalesLeadDBDAOPriCrmSlsLdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CRM Sales Lead 정보를 조회한다.
	  * </pre>
	  */
	public CRMSalesLeadDBDAOPriCrmSlsLdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration ").append("\n"); 
		query.append("FileName : CRMSalesLeadDBDAOPriCrmSlsLdRSQL").append("\n"); 
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
		query.append("SLS_LD_NO" ).append("\n"); 
		query.append(",	SLS_LD_NM" ).append("\n"); 
		query.append(",	SLS_LD_CUST_CNT_CD" ).append("\n"); 
		query.append(",	SLS_LD_CUST_SEQ" ).append("\n"); 
		query.append(",	SLS_LD_SREP_CD" ).append("\n"); 
		query.append(",	SLS_LD_ST_DT" ).append("\n"); 
		query.append(",	SLS_LD_STS_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM PRI_CRM_SLS_LD" ).append("\n"); 
		query.append("WHERE	SLS_LD_NO = @[sls_ld_no]" ).append("\n"); 

	}
}