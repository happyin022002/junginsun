/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOExpenseInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.08.06 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOExpenseInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOExpenseInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_sls_div",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_slay_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_expense_group",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_tic_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOExpenseInquiryRSQL").append("\n"); 
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
		query.append("SELECT   LVL1_CODE" ).append("\n"); 
		query.append(",LVL1_NAME" ).append("\n"); 
		query.append(",LVL2_CODE" ).append("\n"); 
		query.append(",LVL2_NAME" ).append("\n"); 
		query.append(",LVL3_CODE" ).append("\n"); 
		query.append(",LVL3_NAME" ).append("\n"); 
		query.append(",LVL4_CODE" ).append("\n"); 
		query.append(",LVL4_NAME" ).append("\n"); 
		query.append(",LVL4_TIC" ).append("\n"); 
		query.append(",ACCT_CODE" ).append("\n"); 
		query.append(",ACCT_NAME" ).append("\n"); 
		query.append(",ACCT_DESC" ).append("\n"); 
		query.append(",SALY_FLG" ).append("\n"); 
		query.append(",DECODE (GEN_EXPN_SLS_DIV_CD, 'C', 'COM', 'Y', 'Yes', 'N', 'No') SLS_DIV" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("#if (${sch_expense_gbn} == 'N')" ).append("\n"); 
		query.append("SELECT E.GEN_EXPN_CD LVL1_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', E.KRN_ABBR_NM, 'E', E.ENG_ABBR_NM) LVL1_NAME" ).append("\n"); 
		query.append(",D.GEN_EXPN_CD LVL2_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', D.KRN_ABBR_NM, 'E', D.ENG_ABBR_NM) LVL2_NAME" ).append("\n"); 
		query.append(",C.GEN_EXPN_CD LVL3_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', C.KRN_ABBR_NM, 'E', C.ENG_ABBR_NM) LVL3_NAME" ).append("\n"); 
		query.append(",A.GEN_EXPN_CD LVL4_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', B.KRN_ABBR_NM, 'E', B.ENG_ABBR_NM) LVL4_NAME" ).append("\n"); 
		query.append(",B.TIC_CD LVL4_TIC" ).append("\n"); 
		query.append(",A.ACCT_CD ACCT_CODE" ).append("\n"); 
		query.append(",A.ACCT_NM ACCT_NAME" ).append("\n"); 
		query.append(",A.KRN_DESC ACCT_DESC" ).append("\n"); 
		query.append(",B.SALY_FLG" ).append("\n"); 
		query.append(",B.GEN_EXPN_SLS_DIV_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K',KRN_NM, 'E',ENG_NM) ACCT_NM" ).append("\n"); 
		query.append(",KRN_DESC" ).append("\n"); 
		query.append(",GEN_EXPN_CD" ).append("\n"); 
		query.append("FROM GEM_ACCT_MTX" ).append("\n"); 
		query.append("WHERE ACCT_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${sch_expense_div} == 'Y')" ).append("\n"); 
		query.append("AND ACCT_CD LIKE '56%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_expense_div} == 'N')" ).append("\n"); 
		query.append("AND ACCT_CD NOT LIKE '56%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",GEM_EXPENSE B" ).append("\n"); 
		query.append(",GEM_EXPENSE C" ).append("\n"); 
		query.append(",GEM_EXPENSE D" ).append("\n"); 
		query.append(",GEM_EXPENSE E" ).append("\n"); 
		query.append("WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${sch_tic_cd} != '')" ).append("\n"); 
		query.append("AND B.TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_slay_flg} != '')" ).append("\n"); 
		query.append("AND B.SALY_FLG = @[sch_slay_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_sls_div} != '')" ).append("\n"); 
		query.append("AND B.GEN_EXPN_SLS_DIV_CD = @[sch_sls_div]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.PRNT_GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND C.PRNT_GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND D.PRNT_GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT E.GEN_EXPN_CD LVL1_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', E.KRN_ABBR_NM, 'E', E.ENG_ABBR_NM) LVL1_NAME" ).append("\n"); 
		query.append(",D.GEN_EXPN_CD LVL2_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', D.KRN_ABBR_NM, 'E', D.ENG_ABBR_NM) LVL2_NAME" ).append("\n"); 
		query.append(",C.GEN_EXPN_CD LVL3_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', C.KRN_ABBR_NM, 'E', C.ENG_ABBR_NM) LVL3_NAME" ).append("\n"); 
		query.append(",B.GEN_EXPN_CD LVL4_CODE" ).append("\n"); 
		query.append(",B.ABBR_NM LVL4_NAME" ).append("\n"); 
		query.append(",B.TIC_CD LVL4_TIC" ).append("\n"); 
		query.append(",A.ACCT_CD ACCT_CODE" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', A.KRN_NM,    'E', A.ENG_NM) ACCT_NAME" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K', A.KRN_DESC,  'E', A.ENG_DESC) ACCT_DESC" ).append("\n"); 
		query.append(",B.SALY_FLG" ).append("\n"); 
		query.append(",B.GEN_EXPN_SLS_DIV_CD" ).append("\n"); 
		query.append("FROM GEM_ACCT_MTX A" ).append("\n"); 
		query.append(", (" ).append("\n"); 
		query.append("SELECT GEN_EXPN_CD" ).append("\n"); 
		query.append(",DECODE(@[sch_lang],'K',KRN_ABBR_NM, 'E',ENG_ABBR_NM) ABBR_NM" ).append("\n"); 
		query.append(",PRNT_GEN_EXPN_CD" ).append("\n"); 
		query.append(",TIC_CD" ).append("\n"); 
		query.append(",SALY_FLG" ).append("\n"); 
		query.append(",GEN_EXPN_SLS_DIV_CD" ).append("\n"); 
		query.append("FROM GEM_EXPENSE" ).append("\n"); 
		query.append("WHERE GEN_EXPN_CD BETWEEN DECODE (@[sch_expense_from], '', '111111', @[sch_expense_from]) AND DECODE (@[sch_expense_to], '', '999999', @[sch_expense_to])" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_tic_cd} != '')" ).append("\n"); 
		query.append("AND TIC_CD = @[sch_tic_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_slay_flg} != '')" ).append("\n"); 
		query.append("AND SALY_FLG = @[sch_slay_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${sch_sls_div} != '')" ).append("\n"); 
		query.append("AND GEN_EXPN_SLS_DIV_CD = @[sch_sls_div]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(", GEM_EXPENSE C" ).append("\n"); 
		query.append(", GEM_EXPENSE D" ).append("\n"); 
		query.append(", GEM_EXPENSE E" ).append("\n"); 
		query.append("WHERE A.GEN_EXPN_CD = B.GEN_EXPN_CD" ).append("\n"); 
		query.append("#if (${sch_expense_div} == 'Y')" ).append("\n"); 
		query.append("AND A.ACCT_CD LIKE '56%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_expense_div} == 'N')" ).append("\n"); 
		query.append("AND A.ACCT_CD NOT LIKE '56%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND B.PRNT_GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND C.PRNT_GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("AND D.PRNT_GEN_EXPN_CD = E.GEN_EXPN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${sch_expense_group} != '')" ).append("\n"); 
		query.append("WHERE 	 LVL1_CODE LIKE SUBSTR(@[sch_expense_group],1,2)||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY LVL1_CODE, LVL2_CODE, LVL3_CODE, LVL4_CODE, LVL4_TIC, ACCT_CODE" ).append("\n"); 

	}
}