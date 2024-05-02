/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustomerPFMCGroupDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.22
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.22 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustomerPFMCGroupDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustomerInfoManageDBDAOSearchCustomerPFMCGroupDetail
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustomerPFMCGroupDetailRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustomerPFMCGroupDetailRSQL").append("\n"); 
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
		query.append("SELECT CUST_GRP_ID" ).append("\n"); 
		query.append(",CUST_CNT_CD || LPAD(CUST_SEQ,6,0) AS CUSTOMER_CODE" ).append("\n"); 
		query.append(",CUST_LGL_ENG_NM" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 
		query.append("ORDER BY CUST_CNT_CD, CUST_SEQ" ).append("\n"); 

	}
}