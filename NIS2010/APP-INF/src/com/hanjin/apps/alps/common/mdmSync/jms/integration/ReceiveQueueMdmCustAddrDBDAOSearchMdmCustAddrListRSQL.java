/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ReceiveQueueMdmCustAddrDBDAOSearchMdmCustAddrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCustAddrDBDAOSearchMdmCustAddrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmCustAddrList
	  * </pre>
	  */
	public ReceiveQueueMdmCustAddrDBDAOSearchMdmCustAddrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crm_row_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCustAddrDBDAOSearchMdmCustAddrListRSQL").append("\n"); 
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
		query.append("SELECT cust_cnt_cd 									" ).append("\n"); 
		query.append("FROM mdm_cust_addr									" ).append("\n"); 
		query.append("WHERE cust_cnt_cd = @[cust_cnt_cd]	  						" ).append("\n"); 
		query.append("AND cust_seq    =   @[cust_seq]   			               " ).append("\n"); 
		query.append("AND CRM_ROW_ID = @[crm_row_id]" ).append("\n"); 

	}
}