/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditDBDAOGetNewAudNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.31 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG-GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAuditDBDAOGetNewAudNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Aud no.를 구한다
	  * </pre>
	  */
	public AGNCommAuditDBDAOGetNewAudNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.integration ").append("\n"); 
		query.append("FileName : AGNCommAuditDBDAOGetNewAudNoInfoRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MAX_AUD_NO,1,9)||TO_CHAR(TO_NUMBER(SUBSTR(MAX_AUD_NO,10,2)+1),'FM00')||'T' AS AUD_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT MAX(NEW_AUD_NO) AS MAX_AUD_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT MAX(AUD_NO) AS NEW_AUD_NO" ).append("\n"); 
		query.append("        FROM ACM_AGN_COMM" ).append("\n"); 
		query.append("        WHERE AUD_NO LIKE SUBSTR(@[aud_no],1,9)||'%'" ).append("\n"); 
		query.append("        UNION " ).append("\n"); 
		query.append("        SELECT MAX(AUD_NO) AS NEW_AUD_NO" ).append("\n"); 
		query.append("        FROM ACM_AGN_OTR_COMM" ).append("\n"); 
		query.append("        WHERE AUD_NO LIKE SUBSTR(@[aud_no],1,9)||'%'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE MAX_AUD_NO IS NOT NULL" ).append("\n"); 

	}
}