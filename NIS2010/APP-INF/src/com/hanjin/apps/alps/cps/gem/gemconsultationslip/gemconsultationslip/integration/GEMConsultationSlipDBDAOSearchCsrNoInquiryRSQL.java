/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOSearchCsrNoInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMConsultationSlipDBDAOSearchCsrNoInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSR No를 조회를 한다.
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOSearchCsrNoInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOSearchCsrNoInquiryRSQL").append("\n"); 
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
		query.append("SELECT distinct A.SUBS_CSR_NO SUBS_CSR_NO" ).append("\n"); 
		query.append("    ,A.SUBS_OFC_CD SUBS_OFC_CD" ).append("\n"); 
		query.append("    ,A.INP_DT INP_DT" ).append("\n"); 
		query.append("    ,A.INV_DT INV_DT" ).append("\n"); 
		query.append("    ,DECODE(A.EXPN_DIV_CD,'S','Salary & Allowance','W','Welfare','E','Entertainment','M','Management & Other') EXPN_DIV_CD" ).append("\n"); 
		query.append("    ,A.APRO_RSLT_CD APRO_RSLT_CD" ).append("\n"); 
		query.append("    ,A.INV_CURR_CD INV_CURR_CD" ).append("\n"); 
		query.append("    ,A.INV_LOCL_TTL_AMT INV_LOCL_TTL_AMT" ).append("\n"); 
		query.append("    ,A.INV_USD_TTL_AMT INV_USD_TTL_AMT" ).append("\n"); 
		query.append("    ,A.CRE_USR_ID CRE_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT SUBS_CSR_NO" ).append("\n"); 
		query.append("        ,SUBS_OFC_CD" ).append("\n"); 
		query.append("        ,INP_DT" ).append("\n"); 
		query.append("        ,INV_DT" ).append("\n"); 
		query.append("        ,EXPN_DIV_CD" ).append("\n"); 
		query.append("        ,DECODE(APRO_RSLT_CD,'X','Saved','C','Deleted','P','Submitted','N','Rejected','Y','Approved','E','Error') APRO_RSLT_CD" ).append("\n"); 
		query.append("        ,INV_CURR_CD" ).append("\n"); 
		query.append("        ,INV_LOCL_TTL_AMT" ).append("\n"); 
		query.append("        ,INV_USD_TTL_AMT" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("    FROM GEM_SUBS_CSUL_HDR" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    -- Input Date (From ~ To) 입력" ).append("\n"); 
		query.append("    AND TO_DATE(INP_DT,'YYYY-MM-DD') BETWEEN TO_DATE(@[period_stdt],'YYYY-MM-DD') AND TO_DATE(@[period_eddt],'YYYY-MM-DD') + 0.99999421" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",GEM_OFFICE B" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    SELECT OFC_CD, EXPN_DIV_CD,LVL4_CODE GEN_EXPN_CD,LVL4_NAME, LVL4_TIC" ).append("\n"); 
		query.append("    FROM GEM_CSR_LEVEL_V" ).append("\n"); 
		query.append("    GROUP BY OFC_CD,EXPN_DIV_CD,LVL4_CODE,LVL4_NAME, LVL4_TIC" ).append("\n"); 
		query.append(" ) C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND A.SUBS_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append(" AND A.SUBS_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append(" AND A.EXPN_DIV_CD = C.EXPN_DIV_CD" ).append("\n"); 
		query.append("#if(${login_ofc_cd} != 'SELBPG')  " ).append("\n"); 
		query.append("#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("     AND ( A.SUBS_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                          FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                    START WITH OFC_CD IN (@[login_ofc_cd]) " ).append("\n"); 
		query.append("              CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR C.LVL4_TIC = @[login_ofc_cd] )" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("     AND ( A.SUBS_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                     START WITH OFC_CD IN ( SELECT L_4" ).append("\n"); 
		query.append("                                              FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                                             WHERE L_3 = @[login_ofc_cd] )" ).append("\n"); 
		query.append("               CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR C.LVL4_TIC = @[login_ofc_cd] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("   AND A.SUBS_OFC_CD in (" ).append("\n"); 
		query.append("              SELECT OFC_CD" ).append("\n"); 
		query.append("         FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("       START WITH OFC_CD IN (" ).append("\n"); 
		query.append("              SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("              FROM GEM_OFC_LEVEL_V A, GEM_OFFICE B" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("              AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("             AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("       #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("             AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '')" ).append("\n"); 
		query.append("       AND A.L_4 LIKE @[ofc_lvl3]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '')" ).append("\n"); 
		query.append("       AND A.L_3 LIKE @[ofc_lvl2]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '')" ).append("\n"); 
		query.append("       AND A.L_2 LIKE @[ofc_lvl1]||'%'" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}