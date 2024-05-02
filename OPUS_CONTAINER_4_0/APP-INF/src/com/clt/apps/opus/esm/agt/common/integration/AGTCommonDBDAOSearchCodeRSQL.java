/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVendorCode
	  * </pre>
	  */
	public AGTCommonDBDAOSearchCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmpCnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmpSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchCodeRSQL").append("\n"); 
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
		query.append("#if (${codeGubun} == 'C')" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CUST_CNT_CD||TO_CHAR(CUST_SEQ,'FM000000') AS CODE," ).append("\n"); 
		query.append("CUST_LGL_ENG_NM NAME" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD = @[tmpCnt]" ).append("\n"); 
		query.append("AND CUST_SEQ = @[tmpSeq]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("VNDR_CNT_CD||TO_CHAR(VNDR_SEQ,'FM000000') AS CODE," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM NAME" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[tmpSeq]" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}