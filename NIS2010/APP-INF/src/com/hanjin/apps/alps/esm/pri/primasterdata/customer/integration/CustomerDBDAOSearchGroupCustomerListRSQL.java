/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CustomerDBDAOSearchGroupCustomerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.customer.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerDBDAOSearchGroupCustomerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group Customer List 를 조회한다.
	  * </pre>
	  */
	public CustomerDBDAOSearchGroupCustomerListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.customer.integration").append("\n"); 
		query.append("FileName : CustomerDBDAOSearchGroupCustomerListRSQL").append("\n"); 
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
		query.append("    , CUST_GRP_NM" ).append("\n"); 
		query.append("    , OFC_CD AS GRP_OFC_CD" ).append("\n"); 
		query.append("    , SREP_CD AS GRP_SREP_CD" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if(${cust_grp_id} != '')" ).append("\n"); 
		query.append("AND CUST_GRP_ID LIKE UPPER(@[cust_grp_id]) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_grp_id_seq} != '')" ).append("\n"); 
		query.append("AND CUST_GRP_ID like '%'||@[cust_grp_id_seq] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_grp_nm} != '')" ).append("\n"); 
		query.append("AND CUST_GRP_NM LIKE  '%' || UPPER(@[cust_grp_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}