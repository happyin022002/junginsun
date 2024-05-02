/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageDBDAOSearchCustNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.06.21 이관샨
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Kuan Sian
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesActivityManageDBDAOSearchCustNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Name 조회
	  * </pre>
	  */
	public SalesActivityManageDBDAOSearchCustNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cus_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration").append("\n"); 
		query.append("FileName : SalesActivityManageDBDAOSearchCustNameRSQL").append("\n"); 
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
		query.append("SELECT CUST_LGL_ENG_NM CUS_NAME" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER  " ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = SUBSTR(@[cus_code],1,2)" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cus_code],3,8))" ).append("\n"); 
		query.append("AND DELT_FLG ='N'" ).append("\n"); 

	}
}