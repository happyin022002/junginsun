/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.11 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchAGNCommAuditConfirmNo
	  * </pre>
	  */
	public AGNCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.integration ").append("\n");
		query.append("FileName : AGNCommAuditDBDAOSearchAGNCommAuditConfirmNoRSQL").append("\n");
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
		query.append("    AUD_NO AS AUD_NO" ).append("\n");
		query.append("FROM" ).append("\n");
		query.append("(" ).append("\n");
		query.append("    SELECT " ).append("\n");
		query.append("        1 AS NO," ).append("\n");
		query.append("        SUBSTRB (B.R_AR_OFC_CD, 1, 3)" ).append("\n");
		query.append("        || TO_CHAR (SYSDATE, 'YYMMDD')" ).append("\n");
		query.append("        || TRIM (TO_CHAR (SUBSTR (MAX (B.AUD_NO), 10, 2) + 1, '00'))" ).append("\n");
		query.append("        || 'T' AS AUD_NO" ).append("\n");
		query.append("     FROM (        " ).append("\n");
		query.append("        " ).append("\n");
		query.append("        SELECT AUD_NO, R_AR_OFC_CD" ).append("\n");
		query.append("        FROM (" ).append("\n");
		query.append("            SELECT AUD_NO, SUBSTRB (AR_OFC_CD,1,3) AS R_AR_OFC_CD" ).append("\n");
		query.append("            FROM ACM_AGN_COMM AGN" ).append("\n");
		query.append("            WHERE 1=1" ).append("\n");
		query.append("            AND AGN.AGN_CD in (select agn_cd from acm_ofc_info where SUBSTR(ar_ofc_cd,1,3) = SUBSTR(@[ar_ofc_cd],1,3) GROUP BY agn_cd )" ).append("\n");
		query.append("            AND AGN.AUD_DT  >= TRUNC(SYSDATE)" ).append("\n");
		query.append("            AND AGN.AC_STS_CD" ).append("\n");
		query.append("            IN" ).append("\n");
		query.append("                (" ).append("\n");
		query.append("                'AS', 'PS', 'IF'" ).append("\n");
		query.append("                )" ).append("\n");
		query.append("            UNION ALL" ).append("\n");
		query.append("            SELECT AUD_NO, SUBSTRB (AR_OFC_CD,1,3) AS R_AR_OFC_CD" ).append("\n");
		query.append("            FROM ACM_AGN_OTR_COMM OTR" ).append("\n");
		query.append("            WHERE 1=1" ).append("\n");
		query.append("            AND OTR.AGN_CD in (select agn_cd from acm_ofc_info where SUBSTR(ar_ofc_cd,1,3) = SUBSTR(@[ar_ofc_cd],1,3) GROUP BY agn_cd )" ).append("\n");
		query.append("            AND OTR.AUD_DT  >= TRUNC(SYSDATE)" ).append("\n");
		query.append("            AND OTR.AC_STS_CD" ).append("\n");
		query.append("            IN" ).append("\n");
		query.append("                (" ).append("\n");
		query.append("                'AS', 'PS', 'IF'" ).append("\n");
		query.append("                )" ).append("\n");
		query.append("        )" ).append("\n");
		query.append("    )B" ).append("\n");
		query.append("    GROUP BY R_AR_OFC_CD" ).append("\n");
		query.append("    UNION ALL" ).append("\n");
		query.append("    SELECT" ).append("\n");
		query.append("        2 AS No," ).append("\n");
		query.append("        SUBSTR (@[ar_ofc_cd], 1, 3)" ).append("\n");
		query.append("        || TO_CHAR (SYSDATE,'YYMMDD')" ).append("\n");
		query.append("        || '01T' AS AUD_NO     " ).append("\n");
		query.append("    FROM DUAL" ).append("\n");
		query.append("    ORDER BY NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("WHERE ROWNUM = 1" ).append("\n");

	}
}