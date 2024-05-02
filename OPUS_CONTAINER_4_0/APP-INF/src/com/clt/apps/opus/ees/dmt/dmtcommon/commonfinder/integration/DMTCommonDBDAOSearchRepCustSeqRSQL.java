/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DMTCommonDBDAOSearchRepCustSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.02.01 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOSearchRepCustSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오피스별 대표고객코드 조회
	  * </pre>
	  */
	public DMTCommonDBDAOSearchRepCustSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOSearchRepCustSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(REP_CUST_CNT_CD,'') ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("       NVL(REP_CUST_SEQ,'') ACT_CUST_SEQ" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE OFC_CD = (SELECT AR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}