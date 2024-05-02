/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchSakuraInterfaceInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchSakuraInterfaceInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Sakura Interface Info
	  * </pre>
	  */
	public StatementCommonDBDAOSearchSakuraInterfaceInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchSakuraInterfaceInfoRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT ORG_T.*" ).append("\n"); 
		query.append(" ,ROWNUM AS RNUM " ).append("\n"); 
		query.append(" ,COUNT(*) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${module} != 'AP' )" ).append("\n"); 
		query.append("SELECT  IF_DOC_TP_CD," ).append("\n"); 
		query.append("        DOC_DT," ).append("\n"); 
		query.append("        PST_DT," ).append("\n"); 
		query.append("        REF_DOC_NO," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        PST_KEY_CD," ).append("\n"); 
		query.append("        VAT_TAX_CD," ).append("\n"); 
		query.append("        SAR_GET_FMT_MASK_FNC('JPY', LOCL_AMT) LOCL_AMT," ).append("\n"); 
		query.append("        SAR_GET_FMT_MASK_FNC(CURR_CD, DOC_AMT) DOC_AMT," ).append("\n"); 
		query.append("        ASGN_NO," ).append("\n"); 
		query.append("        GL_ACCT_NO," ).append("\n"); 
		query.append("        CUST_NO," ).append("\n"); 
		query.append("        REC_TP_CD," ).append("\n"); 
		query.append("        IF_FLG," ).append("\n"); 
		query.append("		IF_FILE_ID," ).append("\n"); 
		query.append("        IF_DT," ).append("\n"); 
		query.append("        ERP_IF_ERR_FLG," ).append("\n"); 
		query.append("        ERP_IF_ERR_RSN       " ).append("\n"); 
		query.append("FROM    SAR_AR_IF" ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("		IF_FLG <> 'H'" ).append("\n"); 
		query.append("#if (${pst_dt_fm} != '')" ).append("\n"); 
		query.append("	AND PST_DT >= REPLACE(@[pst_dt_fm], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pst_dt_to} != '')" ).append("\n"); 
		query.append("	AND PST_DT <= REPLACE(@[pst_dt_to], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_dt_fm} != '')" ).append("\n"); 
		query.append("	AND	TO_CHAR(IF_DT,'YYYYMMDD') >= REPLACE(@[if_dt_fm], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_dt_to} != '')" ).append("\n"); 
		query.append("	AND TO_CHAR(IF_DT,'YYYYMMDD') <= REPLACE(@[if_dt_to], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${asgn_no} != '' )" ).append("\n"); 
		query.append("    AND     ASGN_NO = @[asgn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ref_doc_no} != '' )" ).append("\n"); 
		query.append("    AND     REF_DOC_NO = @[ref_doc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_doc_tp_cd} != '')" ).append("\n"); 
		query.append("    AND     IF_DOC_TP_CD = @[if_doc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_flg} != '')" ).append("\n"); 
		query.append("    AND     IF_FLG = @[if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${module} == '' )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${module} != 'AR') " ).append("\n"); 
		query.append("SELECT  IF_DOC_TP_CD," ).append("\n"); 
		query.append("        DOC_DT," ).append("\n"); 
		query.append("        PST_DT," ).append("\n"); 
		query.append("        REF_DOC_NO," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        PST_KEY_CD," ).append("\n"); 
		query.append("        VAT_TAX_CD," ).append("\n"); 
		query.append("        SAR_GET_FMT_MASK_FNC('JPY', LOCL_AMT) LOCL_AMT," ).append("\n"); 
		query.append("        SAR_GET_FMT_MASK_FNC(CURR_CD, DOC_AMT) DOC_AMT," ).append("\n"); 
		query.append("        ASGN_NO," ).append("\n"); 
		query.append("        GL_ACCT_NO," ).append("\n"); 
		query.append("        CUST_NO," ).append("\n"); 
		query.append("        '' REC_TP_CD," ).append("\n"); 
		query.append("        IF_FLG," ).append("\n"); 
		query.append("		IF_FILE_ID," ).append("\n"); 
		query.append("        IF_DT," ).append("\n"); 
		query.append("        ERP_IF_ERR_FLG," ).append("\n"); 
		query.append("        ERP_IF_ERR_RSN       " ).append("\n"); 
		query.append("FROM    SAP_AP_IF" ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("		IF_FLG <> 'H'" ).append("\n"); 
		query.append("#if (${pst_dt_fm} != '')" ).append("\n"); 
		query.append("	AND PST_DT >= REPLACE(@[pst_dt_fm], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pst_dt_to} != '')" ).append("\n"); 
		query.append("	AND PST_DT <= REPLACE(@[pst_dt_to], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_dt_fm} != '')" ).append("\n"); 
		query.append("	AND TO_CHAR(IF_DT,'YYYYMMDD') >= REPLACE(@[if_dt_fm], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${if_dt_to} != '')" ).append("\n"); 
		query.append("	AND TO_CHAR(IF_DT,'YYYYMMDD') <= REPLACE(@[if_dt_to], '-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${asgn_no} != '' )" ).append("\n"); 
		query.append("    AND     ASGN_NO = @[asgn_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ref_doc_no} != '' )" ).append("\n"); 
		query.append("    AND     REF_DOC_NO = @[ref_doc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_doc_tp_cd} != '')" ).append("\n"); 
		query.append("    AND     IF_DOC_TP_CD = @[if_doc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${if_flg} != '')" ).append("\n"); 
		query.append("    AND     IF_FLG = @[if_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") ORG_T" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}