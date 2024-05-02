/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustRefPartyManageDBDAOsearchCustRefPartyManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.05.19 김종호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRefPartyManageDBDAOsearchCustRefPartyManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public CustRefPartyManageDBDAOsearchCustRefPartyManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pk1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.integration").append("\n"); 
		query.append("FileName : CustRefPartyManageDBDAOsearchCustRefPartyManageListRSQL").append("\n"); 
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
		query.append("SELECT COUNT(CRM_ROW_ID) " ).append("\n"); 
		query.append("FROM TRS_TRSP_ACT_CUST_ADDR	" ).append("\n"); 
		query.append("WHERE CRM_ROW_ID = @[pk1]" ).append("\n"); 

	}
}