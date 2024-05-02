/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchOtherOfficeInfoRSQL.java
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

public class AGTCommonDBDAOSearchOtherOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOtherOfficeInfo
	  * </pre>
	  */
	public AGTCommonDBDAOSearchOtherOfficeInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchOtherOfficeInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.VNDR_CNT_CD || TO_CHAR (B.VNDR_SEQ, 'FM000000') AS VENDOR," ).append("\n"); 
		query.append("B.VNDR_LGL_ENG_NM AS NAME," ).append("\n"); 
		query.append("A.OFC_CD AS OFFICE," ).append("\n"); 
		query.append("A.LOC_CD AS CITY," ).append("\n"); 
		query.append("A.AP_CTR_CD AS CENTER," ).append("\n"); 
		query.append("C.CURR_CD AS CURR" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_VENDOR B," ).append("\n"); 
		query.append("AGT_OFC_VNDR_MTCH C" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ofcCd]" ).append("\n"); 
		query.append("AND NVL (A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND C.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND NVL (B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}