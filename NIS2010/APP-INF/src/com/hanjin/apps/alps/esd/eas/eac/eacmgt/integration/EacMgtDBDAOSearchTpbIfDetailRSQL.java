/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOSearchTpbIfDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.11.27 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOSearchTpbIfDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB Inquiry by EAC 내역 조회
	  * </pre>
	  */
	public EacMgtDBDAOSearchTpbIfDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_audr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3tpy_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ots_sts_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOSearchTpbIfDetailRSQL").append("\n"); 
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
		query.append("SELECT U.EAC_NO -- EAC No" ).append("\n"); 
		query.append("      ,CASE WHEN MAX(U.AUDR_OFC_CD) = 'SELADG' THEN 'SELADG'" ).append("\n"); 
		query.append("            ELSE TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(MAX(U.AUDR_OFC_CD))" ).append("\n"); 
		query.append("       END AS RHQ_OFC_CD -- RHQ" ).append("\n"); 
		query.append("      ,MAX(U.AUDR_OFC_CD) AUDR_OFC_CD -- Audit Office" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03341',MAX(U.EAC_APRO_TP_CD)) AS EAC_APRO_TP_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(MAX(U.EAC_INP_DT),'YYYY-MM-DD') EAC_INP_DT -- Entered date" ).append("\n"); 
		query.append("      ,TO_CHAR(TO_DATE(MAX(U.EAC_YRMON)||'01','YYYY-MM-DD'),'YYYY-MM')EAC_YRMON  -- Audit month" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03352',MAX(U.EAC_EXPN_TP_CD)) AS EAC_EXPN_TP_NM -- Expense type" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00587',MAX(U.EAC_TP_CD)) AS EAC_TP_NM -- EAC Type - Main" ).append("\n"); 
		query.append("      ,CASE WHEN MAX(U.EAC_TP_CD) = 'I' -- Internal Error" ).append("\n"); 
		query.append("            THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03340',MAX(U.EAC_BIL_TP_CD))" ).append("\n"); 
		query.append("            WHEN MAX(U.EAC_TP_CD) = 'M' -- Misbilling" ).append("\n"); 
		query.append("            THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD03339',MAX(U.EAC_BIL_TP_CD))" ).append("\n"); 
		query.append("            WHEN MAX(U.EAC_TP_CD) = 'T' -- Missing 3rd Party Billing" ).append("\n"); 
		query.append("            THEN MAX((SELECT N3PTY_BIL_TP_NM FROM TPB_N3RD_PTY_BIL_TP X WHERE X.N3PTY_BIL_TP_CD = U.EAC_BIL_TP_CD))" ).append("\n"); 
		query.append("       END EAC_BIL_TP_NM -- EAC Type Sub" ).append("\n"); 
		query.append("      ,MAX(U.RESPB_OFC_CD) RESPB_OFC_CD -- Responsible office" ).append("\n"); 
		query.append("      ,COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00583', MAX(W.VNDR_CUST_DIV_CD)) AS VNDR_CUST_DIV_NM -- 3rd party - Type" ).append("\n"); 
		query.append("      ,CASE WHEN MAX(W.VNDR_CUST_DIV_CD) = 'V' THEN MAX(W.VNDR_SEQ)||''" ).append("\n"); 
		query.append("            WHEN MAX(W.VNDR_CUST_DIV_CD) = 'C' THEN MAX(W.CUST_CNT_CD||W.CUST_SEQ)" ).append("\n"); 
		query.append("            WHEN MAX(W.VNDR_CUST_DIV_CD) = 'S' THEN MAX(W.N3PTY_OFC_CD)" ).append("\n"); 
		query.append("       END N3PTY_SRC_CD -- 3rd party - code" ).append("\n"); 
		query.append("      ,CASE WHEN MAX(W.VNDR_CUST_DIV_CD) = 'V' THEN MAX((SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = W.VNDR_SEQ))" ).append("\n"); 
		query.append("            WHEN MAX(W.VNDR_CUST_DIV_CD) = 'C' THEN MAX((SELECT X.CUST_LGL_ENG_NM FROM MDM_CUSTOMER X WHERE X.CUST_CNT_CD = W.CUST_CNT_CD AND X.CUST_SEQ = W.CUST_SEQ))" ).append("\n"); 
		query.append("            WHEN MAX(W.VNDR_CUST_DIV_CD) = 'S' THEN MAX(W.N3PTY_OFC_CD)" ).append("\n"); 
		query.append("       END N3PTY_SRC_NM -- 3rd party - name" ).append("\n"); 
		query.append("      ,MAX(U.EAC_COST_DESC) EAC_COST_DESC -- Cost Code" ).append("\n"); 
		query.append("      ,MAX(U.VNDR_SEQ) VNDR_SEQ -- S/P Code" ).append("\n"); 
		query.append("      ,MAX((SELECT X.VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = U.VNDR_SEQ)) AS VNDR_NM -- Service Provider Name" ).append("\n"); 
		query.append("      ,MAX(U.N3PTY_SRC_NO) N3PTY_SRC_NO -- Invoice no" ).append("\n"); 
		query.append("      ,MAX(U.INV_AUD_USD_AMT) INV_AUD_USD_AMT -- Audit Amount(US$)" ).append("\n"); 
		query.append("      ,MAX(W.N3PTY_NO) N3PTY_NO -- TPB No" ).append("\n"); 
		query.append("      ,MAX(X.OFC_CD) TPB_OFC_CD -- TPB office" ).append("\n"); 
		query.append("      ,CASE WHEN MAX(V.EQ_KND_CD) = 'V' THEN 'VVD'" ).append("\n"); 
		query.append("            ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01132', MAX(V.EQ_KND_CD))" ).append("\n"); 
		query.append("       END EQ_KND_NM" ).append("\n"); 
		query.append("      ,MAX(V.EQ_NO) EQ_NO -- EQ No" ).append("\n"); 
		query.append("      ,MAX(V.BKG_NO) BKG_NO -- BKG No" ).append("\n"); 
		query.append("      ,MAX(V.BL_NO) BL_NO -- B/L No" ).append("\n"); 
		query.append("      ,MAX(V.VVD_CD) VVD_CD -- VVD" ).append("\n"); 
		query.append("      ,MAX(V.CFM_CURR_CD) CFM_CURR_CD -- TPB I/F Amount - Cur" ).append("\n"); 
		query.append("      ,MAX(V.CFM_AMT) CFM_AMT -- TPB I/F Amount - Amount" ).append("\n"); 
		query.append("      ,MAX(Y.STL_TO_CLT_CNG_OFC_CD) TPB_ROC_OFC_CD -- ROC Office" ).append("\n"); 
		query.append("      ,MAX(CASE WHEN Z.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',X.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("                ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588',Z.OTS_STS_CD)" ).append("\n"); 
		query.append("           END) AS OTS_STS_NM -- TPB status" ).append("\n"); 
		query.append("      ,MAX(U.CURR_CD) CURR_CD -- Invoice Amount - Cur" ).append("\n"); 
		query.append("      ,MAX(U.INV_AUD_AMT) INV_AUD_AMT -- Invoice Amount - Amount" ).append("\n"); 
		query.append("  FROM TPB_OTS_GRP X" ).append("\n"); 
		query.append("      ,TPB_ADJ_STS Y" ).append("\n"); 
		query.append("      ,TPB_OTS_GRP_STS Z" ).append("\n"); 
		query.append("      ,TPB_OTS_DTL V" ).append("\n"); 
		query.append("      ,EAS_EXPN_AUD_CS_N3RD_PTY W" ).append("\n"); 
		query.append("      ,EAS_EXPN_AUD_CS_MGMT U" ).append("\n"); 
		query.append(" WHERE X.N3PTY_NO = Y.N3PTY_NO(+)" ).append("\n"); 
		query.append("   AND Y.STL_STS_LST_FLG(+) = 'Y' " ).append("\n"); 
		query.append("   AND Y.N3PTY_STL_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("   AND X.N3PTY_NO = Z.N3PTY_NO" ).append("\n"); 
		query.append("   AND Z.OTS_STS_LST_FLG = 'Y'   " ).append("\n"); 
		query.append("   AND X.N3PTY_NO = V.N3PTY_NO" ).append("\n"); 
		query.append("   AND X.N3PTY_NO = W.N3PTY_NO" ).append("\n"); 
		query.append("   AND W.EAC_NO = U.EAC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND CASE WHEN U.AUDR_OFC_CD = 'SELADG' THEN 'SELADG'" ).append("\n"); 
		query.append("            ELSE TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(U.AUDR_OFC_CD)" ).append("\n"); 
		query.append("       END = @[s_rhq_ofc_cd] -- RHQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_audr_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND U.AUDR_OFC_CD = @[s_audr_ofc_cd] -- Audit Office" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND U.EAC_YRMON BETWEEN REPLACE(@[s_eac_yrmon_fr],'-','') AND REPLACE(@[s_eac_yrmon_to],'-','') -- Audit month" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_ots_sts_cd} != '')" ).append("\n"); 
		query.append("   #if(${s_ots_sts_dtl_cd} == '') -- TPB Status - main" ).append("\n"); 
		query.append("      #if(${s_ots_sts_cd} == 'T')" ).append("\n"); 
		query.append("         AND X.OTS_STS_CD IN ('O', 'I', 'Y', 'R', 'J')" ).append("\n"); 
		query.append("      #elseif(${s_ots_sts_cd} == 'P')" ).append("\n"); 
		query.append("         AND X.OTS_STS_CD IN ('E', 'L', 'D', 'S')" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("      AND X.OTS_STS_CD = @[s_ots_sts_dtl_cd] -- TPB Status - sub" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_eac_expn_tp_cd} != '')" ).append("\n"); 
		query.append("   AND U.EAC_EXPN_TP_CD = @[s_eac_expn_tp_cd] -- Expense Type" ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("#if(${s_eac_tp_cd} != '')" ).append("\n"); 
		query.append("   AND U.EAC_TP_CD = @[s_eac_tp_cd] -- EAC Type" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("#if(${s_vndr_cust_div_cd} != '')" ).append("\n"); 
		query.append("   AND W.VNDR_CUST_DIV_CD = @[s_vndr_cust_div_cd] -- 3rd Party 구분" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_n3tpy_src_cd} != '')" ).append("\n"); 
		query.append("   AND CASE WHEN W.VNDR_CUST_DIV_CD = 'V' THEN W.VNDR_SEQ||''" ).append("\n"); 
		query.append("            WHEN W.VNDR_CUST_DIV_CD = 'C' THEN W.CUST_CNT_CD||W.CUST_SEQ" ).append("\n"); 
		query.append("            WHEN W.VNDR_CUST_DIV_CD = 'S' THEN W.N3PTY_OFC_CD" ).append("\n"); 
		query.append("       END = @[s_n3tpy_src_cd] -- 3rd Party 코드" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY X.N3PTY_NO, U.EAC_NO, V.EQ_NO" ).append("\n"); 

	}
}