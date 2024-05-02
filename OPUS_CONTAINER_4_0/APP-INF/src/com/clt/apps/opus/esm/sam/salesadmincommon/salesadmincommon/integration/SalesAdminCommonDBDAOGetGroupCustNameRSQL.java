/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesAdminCommonDBDAOGetGroupCustNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesAdminCommonDBDAOGetGroupCustNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * group customer id 조화용 쿼리
	  * </pre>
	  */
	public SalesAdminCommonDBDAOGetGroupCustNameRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.integration ").append("\n"); 
		query.append("FileName : SalesAdminCommonDBDAOGetGroupCustNameRSQL").append("\n"); 
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
		query.append("SELECT CUST_GRP_NM" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("WHERE CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 

	}
}