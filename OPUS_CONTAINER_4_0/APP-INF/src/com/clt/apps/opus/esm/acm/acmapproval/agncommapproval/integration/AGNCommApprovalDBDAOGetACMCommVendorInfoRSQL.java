/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalDBDAOGetACMCommVendorInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.22
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOGetACMCommVendorInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public AGNCommApprovalDBDAOGetACMCommVendorInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n");
		query.append("FileName : AGNCommApprovalDBDAOGetACMCommVendorInfoRSQL").append("\n");
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
		query.append("SELECT VNDR_CODE, VNDR_NAME" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("    SELECT TRIM(TO_CHAR(A.VNDR_SEQ,'000000')) AS VNDR_CODE," ).append("\n");
		query.append("           B.VNDR_LGL_ENG_NM AS VNDR_NAME ," ).append("\n");
		query.append("           CASE WHEN TO_CHAR (SYSDATE,'YYYYMMDD') BETWEEN AGN_FM_DT AND AGN_TO_DT THEN '1'" ).append("\n");
		query.append("                ELSE '2'" ).append("\n");
		query.append("           END MAT" ).append("\n");
		query.append("    FROM   ACM_OFC_INFO A, MDM_VENDOR B" ).append("\n");
		query.append("    WHERE  AGN_CD = @[agn_cd]" ).append("\n");
		query.append("      AND  A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n");
		query.append("      AND  NVL(B.DELT_FLG,'N') = 'N'" ).append("\n");
		query.append("    ORDER  BY MAT, AGN_FM_DT" ).append("\n");
		query.append(")" ).append("\n");
		query.append("WHERE ROWNUM = 1" ).append("\n");

	}
}