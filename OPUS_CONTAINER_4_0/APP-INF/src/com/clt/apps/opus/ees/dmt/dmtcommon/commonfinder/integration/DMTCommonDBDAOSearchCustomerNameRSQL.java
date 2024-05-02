/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOSearchCustomerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchCustomerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Country Code 와 Customer Seq 로 Customer Name 정보를 조회하기 위한 쿼리
	  * </pre>
	  */
	public DMTCommonDBDAOSearchCustomerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchCustomerNameRSQL").append("\n"); 
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
		query.append("SELECT	CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("FROM	MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE	DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("AND	CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 

	}
}