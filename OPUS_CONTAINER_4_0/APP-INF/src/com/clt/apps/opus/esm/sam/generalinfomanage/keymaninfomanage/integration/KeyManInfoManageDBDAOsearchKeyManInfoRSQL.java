/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KeyManInfoManageDBDAOsearchKeyManInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.01
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2015.07.01 김경미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kmy(Kyeongmi) Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyManInfoManageDBDAOsearchKeyManInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KeyManInfoDBDAOsearchKeyManInfo
	  * </pre>
	  */
	public KeyManInfoManageDBDAOsearchKeyManInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration").append("\n"); 
		query.append("FileName : KeyManInfoManageDBDAOsearchKeyManInfoRSQL").append("\n"); 
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
		query.append("SELECT A.KMAN_N1ST_NM," ).append("\n"); 
		query.append("	 A.KMAN_LST_NM, " ).append("\n"); 
		query.append("	 A.KMAN_GND_CD, " ).append("\n"); 
		query.append(" 	 A.JB_TIT_RMK, " ).append("\n"); 
		query.append("     B.CUST_LGL_ENG_NM, " ).append("\n"); 
		query.append("     B.SREP_CD," ).append("\n"); 
		query.append(" 	 A.INTL_PHN_NO, " ).append("\n"); 
		query.append("	 A.KMAN_OFC_FAX_NO," ).append("\n"); 
		query.append(" 	 A.CUST_KMAN_SEQ" ).append("\n"); 
		query.append("FROM SAM_CUST_KMAN_INFO A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   LPAD(A.CUST_SEQ,6,0) = LPAD(B.CUST_SEQ,6,0)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,0) = @[cust_cd]" ).append("\n"); 
		query.append("ORDER BY CUST_KMAN_SEQ" ).append("\n"); 

	}
}