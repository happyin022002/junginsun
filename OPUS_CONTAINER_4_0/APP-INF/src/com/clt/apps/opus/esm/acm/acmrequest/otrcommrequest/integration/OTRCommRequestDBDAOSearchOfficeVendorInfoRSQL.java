/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommRequestDBDAOSearchOfficeVendorInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.24
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OTRCommRequestDBDAOSearchOfficeVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchOfficeVendorInfo
	  * </pre>
	  */
	public OTRCommRequestDBDAOSearchOfficeVendorInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.otrcommrequest.integration").append("\n");
		query.append("FileName : OTRCommRequestDBDAOSearchOfficeVendorInfoRSQL").append("\n");
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
		query.append("SELECT TO_CHAR (B.VNDR_SEQ, 'FM000000') AS VNDR_SEQ," ).append("\n");
		query.append(" B.VNDR_LGL_ENG_NM AS VNDR_LGL_ENG_NM," ).append("\n");
		query.append(" A.OFC_CD AS OFC_CD," ).append("\n");
		query.append(" A.AR_OFC_CD AS AR_OFC_CD," ).append("\n");
		query.append(" A.LOC_CD AS AC_OCCR_INFO_CD," ).append("\n");
		query.append(" A.AP_CTR_CD AS AP_CTR_CD," ).append("\n");
		query.append(" C.CURR_CD AS CURR_CD" ).append("\n");
		query.append("FROM MDM_ORGANIZATION A," ).append("\n");
		query.append("  MDM_VENDOR B," ).append("\n");
		query.append("  ACM_OFC_INFO C" ).append("\n");
		query.append("WHERE A.OFC_CD = @[ofc_cd]" ).append("\n");
		query.append("  AND NVL (A.DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("  AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n");
		query.append("  AND NVL (B.DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("  AND A.OFC_CD = C.AGN_CD" ).append("\n");
		query.append("  AND ROWNUM = 1" ).append("\n");
		query.append("UNION" ).append("\n");
		query.append("SELECT TO_CHAR (C.VNDR_SEQ, 'FM000000') AS VENDOR," ).append("\n");
		query.append("  C.VNDR_LGL_ENG_NM AS NAME," ).append("\n");
		query.append("  B.AGN_CD AS OFFICE," ).append("\n");
		query.append("  D.AR_OFC_CD AS AR_OFC_CD," ).append("\n");
		query.append("  D.LOC_CD AS CITY," ).append("\n");
		query.append("  D.AP_CTR_CD AS CENTER," ).append("\n");
		query.append("  B.CURR_CD AS CURR" ).append("\n");
		query.append("FROM BKG_CHN_AGN A," ).append("\n");
		query.append("  ACM_OFC_INFO B," ).append("\n");
		query.append("  MDM_VENDOR C," ).append("\n");
		query.append("  MDM_ORGANIZATION D" ).append("\n");
		query.append("WHERE A.VNDR_SEQ = C.VNDR_SEQ" ).append("\n");
		query.append("  AND SUBSTR(A.FINC_OFC_CD, 1, 3) || A.CHN_AGN_CD = B.AGN_CD" ).append("\n");
		query.append("  AND NVL (C.DELT_FLG, 'N') = 'N'" ).append("\n");
		query.append("  AND A.FINC_OFC_CD = D.OFC_CD" ).append("\n");
		query.append("  AND SUBSTR(A.FINC_OFC_CD, 1, 3) || A.CHN_AGN_CD = @[ofc_cd]" ).append("\n");

	}
}