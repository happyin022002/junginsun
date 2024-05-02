/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GEMConsultationSlipDBDAOSearchConsultaionInquiryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class GEMConsultationSlipDBDAOSearchConsultaionInquiryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquery deltail 정보 조회 하기
	  * </pre>
	  */
	public GEMConsultationSlipDBDAOSearchConsultaionInquiryDetailRSQL(){
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
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("expn_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("subs_expn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.integration").append("\n"); 
		query.append("FileName : GEMConsultationSlipDBDAOSearchConsultaionInquiryDetailRSQL").append("\n"); 
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
		query.append("SELECT DENSE_RANK() OVER (ORDER BY SUBS_CSR_NO) RID" ).append("\n"); 
		query.append("    ,SUBS_CSR_NO" ).append("\n"); 
		query.append("    ,SUBS_OFC_CD" ).append("\n"); 
		query.append("    ,SUBS_CSR_SEQ" ).append("\n"); 
		query.append("    ,INP_DT" ).append("\n"); 
		query.append("    ,INV_DT" ).append("\n"); 
		query.append("    ,GEN_EXPN_CD" ).append("\n"); 
		query.append("    ,GEN_EXPN_NM" ).append("\n"); 
		query.append("    ,EXPN_DIV_CD" ).append("\n"); 
		query.append("    ,INV_LOCL_AMT INV_LOCL_TTL_AMT" ).append("\n"); 
		query.append("    ,INV_USD_AMT  INV_USD_TTL_AMT" ).append("\n"); 
		query.append("    ,PAY_VNDR_NM" ).append("\n"); 
		query.append("    ,INV_SLP_DESC" ).append("\n"); 
		query.append("    ,APRO_RSLT_CD " ).append("\n"); 
		query.append("    ,APRO_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT A.SUBS_CSR_NO SUBS_CSR_NO" ).append("\n"); 
		query.append("        ,A.SUBS_OFC_CD SUBS_OFC_CD --hidden" ).append("\n"); 
		query.append("        ,B.SUBS_CSR_SEQ SUBS_CSR_SEQ" ).append("\n"); 
		query.append("        ,INP_DT" ).append("\n"); 
		query.append("        ,INV_DT" ).append("\n"); 
		query.append("        ,B.GEN_EXPN_CD GEN_EXPN_CD" ).append("\n"); 
		query.append("        ,B.GEN_EXPN_NM GEN_EXPN_NM" ).append("\n"); 
		query.append("        ,DECODE(A.EXPN_DIV_CD,'S','Salary & Allowance','W','Welfare','E','Entertainment','M','Management & Other') EXPN_DIV_CD" ).append("\n"); 
		query.append("        ,NVL(B.INV_LOCL_AMT,0.00) INV_LOCL_AMT" ).append("\n"); 
		query.append("        ,NVL(B.INV_USD_AMT,0.00) INV_USD_AMT" ).append("\n"); 
		query.append("        ,A.PAY_VNDR_NM PAY_VNDR_NM" ).append("\n"); 
		query.append("        ,B.INV_SLP_DESC INV_SLP_DESC" ).append("\n"); 
		query.append("        ,A.APRO_RSLT_CD APRO_RSLT_CD" ).append("\n"); 
		query.append("        ,A.APRO_DT APRO_DT" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT SUBS_CSR_NO" ).append("\n"); 
		query.append("            ,SUBS_OFC_CD" ).append("\n"); 
		query.append("            ,EXPN_DIV_CD" ).append("\n"); 
		query.append("            ,TO_CHAR(TO_DATE(INP_DT,'YYYY-MM-DD'),'YYYY-MM-DD') INP_DT" ).append("\n"); 
		query.append("            ,TO_CHAR(TO_DATE(INV_DT,'YYYY-MM-DD'),'YYYY-MM-DD') INV_DT" ).append("\n"); 
		query.append("            ,INV_CURR_CD" ).append("\n"); 
		query.append("            ,INV_LOCL_TTL_AMT" ).append("\n"); 
		query.append("            ,INV_USD_TTL_AMT" ).append("\n"); 
		query.append("            ,PAY_VNDR_NM" ).append("\n"); 
		query.append("            ,DECODE(APRO_RSLT_CD,'X','Saved','C','Deleted','P','Submitted','N','Rejected','Y','Approved','E','Error') APRO_RSLT_CD" ).append("\n"); 
		query.append("            ,TO_CHAR(APRO_DT,'YYYY-MM-DD') APRO_DT" ).append("\n"); 
		query.append("        FROM GEM_SUBS_CSUL_HDR" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("         #if (${status} != '')" ).append("\n"); 
		query.append("            #if (${status} == 'C')" ).append("\n"); 
		query.append("                AND DELT_FLG='Y'" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                AND DELT_FLG='N'" ).append("\n"); 
		query.append("                AND APRO_RSLT_CD = @[status]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND DELT_FLG IN ('Y','N')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${gen_expn_rqst_tp_cd} == 'I')" ).append("\n"); 
		query.append("        AND TO_DATE(INP_DT,'YYYY-MM-DD') BETWEEN TO_DATE(@[period_stdt],'YYYY-MM-DD') AND TO_DATE(@[period_eddt],'YYYY-MM-DD') + 0.99999421" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${gen_expn_rqst_tp_cd} == 'E')" ).append("\n"); 
		query.append("        AND TO_DATE(INV_DT,'YYYY-MM-DD') BETWEEN TO_DATE(@[period_stdt],'YYYY-MM-DD') AND TO_DATE(@[period_eddt],'YYYY-MM-DD') + 0.99999421" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${gen_expn_rqst_tp_cd} == 'A')" ).append("\n"); 
		query.append("        AND APRO_DT BETWEEN TO_DATE(@[period_stdt],'YYYY-MM-DD') AND TO_DATE(@[period_eddt],'YYYY-MM-DD') + 0.99999421" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${gen_expn_rqst_tp_cd} == 'C')" ).append("\n"); 
		query.append("        AND SUBS_CSR_NO LIKE '%'||@[csr_no]||'%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${subs_expn_nm} != '')" ).append("\n"); 
		query.append("        AND UPPER(PAY_VNDR_NM) LIKE UPPER('%'||@[subs_expn_nm]||'%')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${expn_div_cd} != '')" ).append("\n"); 
		query.append("          AND EXPN_DIV_CD = @[expn_div_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    ,GEM_SUBS_CSUL_DTL B" ).append("\n"); 
		query.append("    ,GEM_OFFICE C" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT OFC_CD, EXPN_DIV_CD,LVL4_CODE GEN_EXPN_CD,LVL4_NAME, LVL4_TIC" ).append("\n"); 
		query.append("        FROM GEM_CSR_LEVEL_V" ).append("\n"); 
		query.append("        GROUP BY OFC_CD,EXPN_DIV_CD,LVL4_CODE,LVL4_NAME, LVL4_TIC" ).append("\n"); 
		query.append("     ) D" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.SUBS_CSR_NO = B.SUBS_CSR_NO" ).append("\n"); 
		query.append("    AND A.SUBS_OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("    AND A.SUBS_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("    AND A.EXPN_DIV_CD = D.EXPN_DIV_CD" ).append("\n"); 
		query.append("    AND B.GEN_EXPN_CD = D.GEN_EXPN_CD" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("	#if(${auth_flg} == 'YNYN')" ).append("\n"); 
		query.append("     AND ( A.SUBS_OFC_CD IN (SELECT OFC_CD" ).append("\n"); 
		query.append("                          FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                    START WITH OFC_CD IN (@[login_ofc_cd]) " ).append("\n"); 
		query.append("              CONNECT BY PRIOR OFC_CD = BFR_OFC_CD )" ).append("\n"); 
		query.append("          OR D.LVL4_TIC = @[login_ofc_cd] )" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if(${auth_flg} == 'YYYN')" ).append("\n"); 
		query.append("     AND ( A.SUBS_OFC_CD IN ( SELECT OFC_CD" ).append("\n"); 
		query.append("                           FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("                     START WITH OFC_CD IN ( SELECT L_4" ).append("\n"); 
		query.append("                                              FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                                             WHERE L_3 = @[login_ofc_cd] )" ).append("\n"); 
		query.append("               CONNECT BY PRIOR OFC_CD = BFR_OFC_CD ) OR D.LVL4_TIC = @[login_ofc_cd] )" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("   AND A.SUBS_OFC_CD in (" ).append("\n"); 
		query.append("              SELECT OFC_CD" ).append("\n"); 
		query.append("         FROM GEM_OFC_HIS" ).append("\n"); 
		query.append("       START WITH OFC_CD IN (" ).append("\n"); 
		query.append("              SELECT DISTINCT L_4 CODE" ).append("\n"); 
		query.append("                FROM GEM_OFC_LEVEL_V A, GEM_OFFICE B" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("        AND A.L_4 = B.OFC_CD" ).append("\n"); 
		query.append("                                AND B.OFC_CO_DIV_CD = 'S'" ).append("\n"); 
		query.append("           #if(${sls_ofc_div_cd} != '')" ).append("\n"); 
		query.append("                 AND A.RGN_OFC_FLG LIKE @[sls_ofc_div_cd]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} != '')" ).append("\n"); 
		query.append("           AND A.L_4 LIKE @[ofc_lvl3]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${ofc_lvl1} != '' && ${ofc_lvl2} != '' && ${ofc_lvl3} == '')" ).append("\n"); 
		query.append("           AND A.L_3 LIKE @[ofc_lvl2]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if(${ofc_lvl1} != '' && ${ofc_lvl2} == '' && ${ofc_lvl3} == '')" ).append("\n"); 
		query.append("           AND A.L_2 LIKE @[ofc_lvl1]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       CONNECT BY PRIOR OFC_CD = BFR_OFC_CD" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    ORDER BY B.SUBS_CSR_NO, B.SUBS_CSR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}