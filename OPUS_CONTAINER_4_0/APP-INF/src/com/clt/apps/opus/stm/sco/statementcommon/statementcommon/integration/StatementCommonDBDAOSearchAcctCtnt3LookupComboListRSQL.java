/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOSearchAcctCtnt3LookupComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchAcctCtnt3LookupComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAcctCtnt3LookupComboList
	  * </pre>
	  */
	public StatementCommonDBDAOSearchAcctCtnt3LookupComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_acct_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchAcctCtnt3LookupComboListRSQL").append("\n"); 
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
		query.append("#if (${f_acct_ctnt1} == 'RCT') " ).append("\n"); 
		query.append("    SELECT LU_CD, LU_DESC" ).append("\n"); 
		query.append("    FROM   (" ).append("\n"); 
		query.append("            SELECT SCO.OFC_CD LU_CD, MO.OFC_ENG_NM LU_DESC" ).append("\n"); 
		query.append("            FROM   SCO_OFC_INFO SCO," ).append("\n"); 
		query.append("                   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("            WHERE  SCO.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("            AND    SCO.BANK_CTRL_CD = 'ARO'" ).append("\n"); 
		query.append("            UNION ALL    " ).append("\n"); 
		query.append("            SELECT SCO.BANK_OFC, MO.OFC_ENG_NM LU_DESC" ).append("\n"); 
		query.append("            FROM   SCO_OFC_INFO SCO," ).append("\n"); 
		query.append("                   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("            WHERE  SCO.BANK_OFC = MO.OFC_CD" ).append("\n"); 
		query.append("            AND    SCO.BANK_CTRL_CD = 'OTH'" ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("                   SCO.BANK_OFC, MO.OFC_ENG_NM " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    ORDER BY LU_CD" ).append("\n"); 
		query.append("#elseif (${f_acct_ctnt1} == 'INIT')" ).append("\n"); 
		query.append("	SELECT LU_CD, LU_DESC" ).append("\n"); 
		query.append("    FROM   (" ).append("\n"); 
		query.append("            SELECT SCO.OFC_CD LU_CD, MO.OFC_ENG_NM LU_DESC" ).append("\n"); 
		query.append("            FROM   SCO_OFC_INFO SCO," ).append("\n"); 
		query.append("                   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("            WHERE  SCO.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("            AND    SCO.BANK_CTRL_CD = 'ARO'" ).append("\n"); 
		query.append("            UNION ALL    " ).append("\n"); 
		query.append("            SELECT LU_CD, LU_DESC" ).append("\n"); 
		query.append("    				FROM   SCO_LU_DTL" ).append("\n"); 
		query.append("    		WHERE  LU_TP_CD LIKE 'ACCT CTNT3%'" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT SCO.BANK_OFC, MO.OFC_ENG_NM LU_DESC" ).append("\n"); 
		query.append("            FROM   SCO_OFC_INFO SCO," ).append("\n"); 
		query.append("                   MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("            WHERE  SCO.BANK_OFC = MO.OFC_CD" ).append("\n"); 
		query.append("            AND    SCO.BANK_CTRL_CD = 'OTH'" ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("                   SCO.BANK_OFC, MO.OFC_ENG_NM " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    ORDER BY LU_CD	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT LU_CD, LU_DESC" ).append("\n"); 
		query.append("    FROM   SCO_LU_DTL" ).append("\n"); 
		query.append("    WHERE  LU_TP_CD LIKE 'ACCT CTNT3%'" ).append("\n"); 
		query.append("    #if (${f_acct_ctnt1} == 'REC' or ${f_acct_ctnt1} == 'REV')" ).append("\n"); 
		query.append("        AND    ATTR_CTNT1 IN (@[f_acct_ctnt1], 'OTS')" ).append("\n"); 
		query.append("    #elseif (${f_acct_ctnt1} == 'ADJ' or ${f_acct_ctnt1} == 'WRTF')" ).append("\n"); 
		query.append("        AND    ATTR_CTNT1 IN (@[f_acct_ctnt1], 'COM')" ).append("\n"); 
		query.append("	#elseif (${f_acct_ctnt1} == 'ALL' or ${f_acct_ctnt1} == '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND    ATTR_CTNT1 = (@[f_acct_ctnt1])" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}