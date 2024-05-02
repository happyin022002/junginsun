/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOsearchPayerNameRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17 
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

public class DMTCommonDBDAOsearchPayerNameRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PayerName을 조회한다.
	  * </pre>
	  */
	public DMTCommonDBDAOsearchPayerNameRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.dmtcommonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOsearchPayerNameRSQL").append("\n"); 
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
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("SELECT	DELT_FLG, LPAD(VNDR_SEQ,6,'0') AS CUST_CD, VNDR_LGL_ENG_NM AS CUST_NAME" ).append("\n"); 
		query.append("FROM	MDM_VENDOR" ).append("\n"); 
		query.append("WHERE	VNDR_SEQ = @[s_cust_cd]" ).append("\n"); 
		query.append("AND	DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2')" ).append("\n"); 
		query.append("SELECT	DELT_FLG, CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') AS CUST_CD, CUST_LGL_ENG_NM AS CUST_NAME" ).append("\n"); 
		query.append("FROM	MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE	CUST_CNT_CD = SUBSTR(@[s_cust_cd], 1,2)" ).append("\n"); 
		query.append("AND	CUST_SEQ = substr(@[s_cust_cd], 3,6)" ).append("\n"); 
		query.append("AND DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}