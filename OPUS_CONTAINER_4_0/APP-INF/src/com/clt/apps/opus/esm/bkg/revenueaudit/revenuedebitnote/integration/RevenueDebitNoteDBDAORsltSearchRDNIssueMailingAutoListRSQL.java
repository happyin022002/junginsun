/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RevenueDebitNoteDBDAORsltSearchRDNIssueMailingAutoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.03.09 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author taekyoung.kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAORsltSearchRDNIssueMailingAutoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDN 자동발행 대상자 조회
	  * </pre>
	  */
	public RevenueDebitNoteDBDAORsltSearchRDNIssueMailingAutoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAORsltSearchRDNIssueMailingAutoListRSQL").append("\n"); 
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
		query.append("SELECT 'REAL_USER' AS USER_GB" ).append("\n"); 
		query.append("      ,USR_EML" ).append("\n"); 
		query.append("      ,USR_ID" ).append("\n"); 
		query.append("      ,CASE WHEN INSTR(USR_EML, 'opus.') > 0 THEN 'G'" ).append("\n"); 
		query.append("            WHEN INSTR(USR_EML, 'cyberlogitec.') > 0 THEN 'C'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("        END AS GROUP_GB" ).append("\n"); 
		query.append("      ,SUBSTR(USR_EML, 0, INSTR(USR_EML, '@') - 1) AS PRE_STR" ).append("\n"); 
		query.append("      ,SUBSTR(USR_EML, INSTR(USR_EML, '@') + 1)    AS SUF_STR" ).append("\n"); 
		query.append("  FROM COM_USER" ).append("\n"); 
		query.append(" WHERE USR_ID IN " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT DECODE(LEVEL, 1, DOC_USR_ID, 2, EMPE_CD) AS USR_ID" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT BK.DOC_USR_ID, REP.EMPE_CD " ).append("\n"); 
		query.append("                  FROM MDM_SLS_REP REP" ).append("\n"); 
		query.append("                      ,BKG_BOOKING BK" ).append("\n"); 
		query.append("                 WHERE REP.SREP_CD = BK.OB_SREP_CD " ).append("\n"); 
		query.append("                   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        CONNECT BY LEVEL <= 2" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("        SELECT ATTR_CTNT1 " ).append("\n"); 
		query.append("          FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("         WHERE HRD_CDG_ID = 'RDN_AUTO_MAIL_LIST'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND USR_EML IS NOT NULL" ).append("\n"); 
		query.append("   AND INSTR(USR_EML, '@') > 1" ).append("\n"); 
		query.append("   AND LENGTH(SUBSTR(USR_EML, 0, INSTR(USR_EML, '@')-1)) > 0" ).append("\n"); 
		query.append("   AND LENGTH(SUBSTR(USR_EML, INSTR(USR_EML, '@')+1)) > 0" ).append("\n"); 

	}
}