/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.27 류선우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDN Issue 메일링 리스트
	  * </pre>
	  */
	public RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAORsltSearchRDNIssueMailingListRSQL").append("\n"); 
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
		query.append("       USER_GB" ).append("\n"); 
		query.append("      ,GROUP_GB" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,USR_ID" ).append("\n"); 
		query.append("      ,USR_EML" ).append("\n"); 
		query.append("      ,PRE_STR" ).append("\n"); 
		query.append("      ,SUF_STR" ).append("\n"); 
		query.append("      ,NULL AS MAIL_TITLE" ).append("\n"); 
		query.append("	  ,NULL AS RCT_OFC_CD -- 메일본분 TO" ).append("\n"); 
		query.append("      ,NULL AS CONT_FM    -- 메일본분 FM" ).append("\n"); 
		query.append("	  ,NULL AS RDN_NO" ).append("\n"); 
		query.append("	  ,NULL AS RDN_AMOUNT" ).append("\n"); 
		query.append("      ,NULL AS RDN_ISS_DT -- issue date" ).append("\n"); 
		query.append("	  ,NULL AS RDN_ISS_DT_WK -- issue date wk" ).append("\n"); 
		query.append("	  ,NULL AS SC_RFA_NO  -- Contract No" ).append("\n"); 
		query.append("      ,NULL AS ERROR_KIND" ).append("\n"); 
		query.append("	  ,NULL AS RDN_RMK    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               'TEST_USER' AS USER_GB" ).append("\n"); 
		query.append("              ,GROUP_GB" ).append("\n"); 
		query.append("              ,NULL AS BL_NO     --" ).append("\n"); 
		query.append("              ,NULL AS USR_ID" ).append("\n"); 
		query.append("              ,USR_EML" ).append("\n"); 
		query.append("              ,NULL AS PRE_STR" ).append("\n"); 
		query.append("              ,NULL AS SUF_STR" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("                  SELECT 'swryu@cyberlogitec.com' AS USR_EML, 'C' AS GROUP_GB FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                  SELECT 'herbwaffle@ebstorm.com' AS USR_EML, 'C' AS GROUP_GB FROM DUAL" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("               'REAL_USER' AS USER_GB" ).append("\n"); 
		query.append("              ,CASE WHEN INSTR(R.USR_EML, 'hanjin.') > 0 THEN 'G'" ).append("\n"); 
		query.append("                    WHEN INSTR(R.USR_EML, 'cyberlogitec.') > 0 THEN 'C'" ).append("\n"); 
		query.append("                    ELSE 'N'" ).append("\n"); 
		query.append("                END AS GROUP_GB" ).append("\n"); 
		query.append("              ,@[bl_no] AS BL_NO -- param" ).append("\n"); 
		query.append("              ,R.USR_ID" ).append("\n"); 
		query.append("              ,R.USR_EML" ).append("\n"); 
		query.append("              ,SUBSTR(R.USR_EML, 0, INSTR(R.USR_EML, '@')-1) AS PRE_STR" ).append("\n"); 
		query.append("        	  ,SUBSTR(R.USR_EML, INSTR(R.USR_EML, '@')+1)    AS SUF_STR  " ).append("\n"); 
		query.append("        FROM   " ).append("\n"); 
		query.append("        	  (" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                       CU.USR_ID" ).append("\n"); 
		query.append("                      ,CU.USR_EML" ).append("\n"); 
		query.append("                FROM   (" ).append("\n"); 
		query.append("                        SELECT ( SELECT A.EMPE_CD FROM MDM_SLS_REP A WHERE A.SREP_CD = BK.OB_SREP_CD ) USR_ID" ).append("\n"); 
		query.append("                        FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("                        WHERE  BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                        UNION" ).append("\n"); 
		query.append("                        SELECT CR.UPD_USR_ID   USR_ID" ).append("\n"); 
		query.append("                        FROM   BKG_CHG_RT  CR" ).append("\n"); 
		query.append("                        WHERE  CR.BKG_NO = ( SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no] )" ).append("\n"); 
		query.append("                        ) BK ," ).append("\n"); 
		query.append("                        COM_USER    CU" ).append("\n"); 
		query.append("                WHERE  CU.USR_ID  = BK.USR_ID" ).append("\n"); 
		query.append("                AND    CU.USR_EML IS NOT NULL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	    UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	    SELECT USR_ID" ).append("\n"); 
		query.append("                      ,USR_EML " ).append("\n"); 
		query.append("                FROM   COM_USER " ).append("\n"); 
		query.append("                WHERE  USR_ID = @[usr_id]" ).append("\n"); 
		query.append("                AND    USR_EML IS NOT NULL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        	   ) R" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        WHERE  R.USR_EML IS NOT NULL" ).append("\n"); 
		query.append("        AND    INSTR(R.USR_EML, '@') > 1" ).append("\n"); 
		query.append("        AND    LENGTH(SUBSTR(R.USR_EML, 0, INSTR(R.USR_EML, '@')-1)) > 0" ).append("\n"); 
		query.append("        AND    LENGTH(SUBSTR(R.USR_EML, INSTR(R.USR_EML, '@')+1)) > 0" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}