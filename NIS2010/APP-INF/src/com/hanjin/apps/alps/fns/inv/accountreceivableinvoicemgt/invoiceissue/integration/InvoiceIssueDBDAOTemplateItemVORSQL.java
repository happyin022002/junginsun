/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueDBDAOTemplateItemVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.03.28 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOTemplateItemVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TemplateItemVO
	  * </pre>
	  */
	public InvoiceIssueDBDAOTemplateItemVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_tmplt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOTemplateItemVORSQL").append("\n"); 
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
		query.append("WITH T10 AS (" ).append("\n"); 
		query.append("    SELECT   A.RPT_ITM_NM" ).append("\n"); 
		query.append("            ,B.RPT_TMPLT_NM" ).append("\n"); 
		query.append("            ,B.RPT_ITM_ID" ).append("\n"); 
		query.append("            ,B.USR_DEF_NM" ).append("\n"); 
		query.append("            ,B.ITM_SEQ" ).append("\n"); 
		query.append("            ,B.RPT_AUTH_ID" ).append("\n"); 
		query.append("    FROM    INV_CPRT_ITM A,INV_CPRT_TMPLT B" ).append("\n"); 
		query.append("    WHERE   A.RPT_ITM_ID = B.RPT_ITM_ID" ).append("\n"); 
		query.append("    AND     B.RPT_TMPLT_NM = @[rpt_tmplt_nm]" ).append("\n"); 
		query.append("    AND     B.AR_OFC_CD     = @[ar_ofc_cd]" ).append("\n"); 
		query.append("), T20 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  ROW_NUMBER() OVER ( ORDER BY T2.DP_SEQ) AS NO" ).append("\n"); 
		query.append("            ,900+ROW_NUMBER() OVER (ORDER BY T2.DP_SEQ) AS ITM_SEQ" ).append("\n"); 
		query.append("            , T2.RPT_TMPLT_NM, T2.RPT_ITM_ID" ).append("\n"); 
		query.append("            , '' AS RPT_ITM_NM" ).append("\n"); 
		query.append("            , T2.CHG_CD AS USR_DEF_NM" ).append("\n"); 
		query.append("            , T2.CPRT_TP_CTNT, T2.CPRT_VAL_CTNT, T2.CHG_CD, T1.RPT_AUTH_ID" ).append("\n"); 
		query.append("    FROM    INV_CPRT_TMPLT T1, INV_CPRT_TMPLT_CHG T2" ).append("\n"); 
		query.append("    WHERE   T1.AR_OFC_CD     = T2.AR_OFC_CD" ).append("\n"); 
		query.append("    AND     T1.RPT_TMPLT_NM  = T2.RPT_TMPLT_NM" ).append("\n"); 
		query.append("    AND     T1.RPT_ITM_ID    = T2.RPT_ITM_ID" ).append("\n"); 
		query.append("    AND     T2.AR_OFC_CD     = @[ar_ofc_cd]" ).append("\n"); 
		query.append("    AND     T2.RPT_TMPLT_NM  = @[rpt_tmplt_nm]" ).append("\n"); 
		query.append("#if (${sc_no} != '')" ).append("\n"); 
		query.append("    AND     T2.CPRT_TP_CTNT  = 'S'" ).append("\n"); 
		query.append("    AND     T2.CPRT_VAL_CTNT = @[sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rfa_no} != '')" ).append("\n"); 
		query.append("    AND     T2.CPRT_TP_CTNT  = 'R'" ).append("\n"); 
		query.append("    AND     T2.CPRT_VAL_CTNT = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rfa_no} == '' && ${sc_no} == '')" ).append("\n"); 
		query.append("    AND   1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND     T2.RPT_ITM_ID    = 'INV143'    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  *" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("      SELECT  RPT_ITM_NM, RPT_TMPLT_NM, RPT_ITM_ID, USR_DEF_NM, ITM_SEQ, RPT_AUTH_ID" ).append("\n"); 
		query.append("      FROM    T10" ).append("\n"); 
		query.append("      WHERE   T10.RPT_ITM_ID  <> 'INV143'" ).append("\n"); 
		query.append("      UNION ALL " ).append("\n"); 
		query.append("      SELECT  *" ).append("\n"); 
		query.append("      FROM    (" ).append("\n"); 
		query.append("              SELECT    'CHG' || LPAD(TO_CHAR(NO), 3, '0') AS RPT_ITM_NM, RPT_TMPLT_NM" ).append("\n"); 
		query.append("                      , 'CHG' || LPAD(TO_CHAR(NO), 3, '0') AS RPT_ITM_ID" ).append("\n"); 
		query.append("                      ,  USR_DEF_NM, ITM_SEQ, RPT_AUTH_ID" ).append("\n"); 
		query.append("              FROM    T20" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              SELECT   'CHG999' AS RPT_ITM_NM, RPT_TMPLT_NM" ).append("\n"); 
		query.append("                      ,'CHG999' RPT_ITM_ID" ).append("\n"); 
		query.append("                      ,'OTHER' AS USR_DEF_NM,  MAX(ITM_SEQ) + 1 as  ITM_SEQ, RPT_AUTH_ID" ).append("\n"); 
		query.append("              FROM    T20  " ).append("\n"); 
		query.append("              GROUP BY RPT_TMPLT_NM, RPT_AUTH_ID" ).append("\n"); 
		query.append("              )        " ).append("\n"); 
		query.append("ORDER BY ITM_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}