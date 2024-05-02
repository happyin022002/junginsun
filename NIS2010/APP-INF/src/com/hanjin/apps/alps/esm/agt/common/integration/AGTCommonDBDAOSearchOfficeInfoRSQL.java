/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTCommonDBDAOSearchOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfficeInfo
	  * </pre>
	  */
	public AGTCommonDBDAOSearchOfficeInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchOfficeInfoRSQL").append("\n"); 
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
		query.append("AGT_FINC_OFC_INFO C" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ofcCd]" ).append("\n"); 
		query.append("AND NVL (A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND NVL (B.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.OFC_CD = C.AGN_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("C.VNDR_CNT_CD || TO_CHAR (C.VNDR_SEQ, 'FM000000') AS VENDOR," ).append("\n"); 
		query.append("C.VNDR_LGL_ENG_NM AS NAME," ).append("\n"); 
		query.append("B.AGN_CD AS OFFICE," ).append("\n"); 
		query.append("D.LOC_CD AS CITY," ).append("\n"); 
		query.append("D.AP_CTR_CD AS CENTER," ).append("\n"); 
		query.append("B.CURR_CD AS CURR" ).append("\n"); 
		query.append("FROM AGT_CHN_BKG_AGN A," ).append("\n"); 
		query.append("AGT_FINC_OFC_INFO B," ).append("\n"); 
		query.append("MDM_VENDOR C," ).append("\n"); 
		query.append("MDM_ORGANIZATION D" ).append("\n"); 
		query.append("WHERE A.AGN_VNDR_SEQ = C.VNDR_SEQ" ).append("\n"); 
		query.append("AND SUBSTR(A.AGN_FINC_OFC_CD,1,3) || A.CHN_BKG_AGN_CD = B.AGN_CD" ).append("\n"); 
		query.append("AND NVL (C.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND A.AGN_FINC_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("AND SUBSTR(A.AGN_FINC_OFC_CD,1,3) || A.CHN_BKG_AGN_CD = @[ofcCd]" ).append("\n"); 

	}
}