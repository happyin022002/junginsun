/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerGroupCodeDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.24
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2012.02.24 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chloe Mijin SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerGroupCodeDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Code에 해당하는 Customer Detail 정보를 조회한다.
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerGroupCodeDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration ").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerGroupCodeDetailRSQL").append("\n"); 
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
		query.append("SELECT CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("     , CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("     , LOC_CD" ).append("\n"); 
		query.append("     , SREP_CD" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 

	}
}