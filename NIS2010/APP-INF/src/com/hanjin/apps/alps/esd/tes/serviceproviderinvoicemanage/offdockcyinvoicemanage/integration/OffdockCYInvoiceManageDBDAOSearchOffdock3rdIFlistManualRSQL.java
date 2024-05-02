/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOffdock3rdIFlistManual
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistManualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistManualRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    ROWNUM TMP_TPB_SEQ," ).append("\n"); 
		query.append("    @[calc_tp_cd] CALC_TP_CD," ).append("\n"); 
		query.append("    @[calc_cost_grp_cd] CALC_COST_GRP_CD, " ).append("\n"); 
		query.append("    P.CNTR_NO, " ).append("\n"); 
		query.append("    P.TML_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("    P.TML_SO_SEQ," ).append("\n"); 
		query.append("    P.TML_SO_CNTR_LIST_SEQ, " ).append("\n"); 
		query.append("    P.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("    P.LGS_COST_CD, " ).append("\n"); 
		query.append("    P.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("    P.IO_BND_CD," ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN T.TML_IF_OFC_CD IS NOT NULL AND T.TML_IF_SEQ IS NOT NULL THEN 1" ).append("\n"); 
		query.append("    ELSE 0" ).append("\n"); 
		query.append("    END CHK," ).append("\n"); 
		query.append("    T.TML_IF_OFC_CD, T.TML_IF_SEQ, T.TML_N3PTY_TP_CD, T.TML_N3PTY_IF_STS_CD," ).append("\n"); 
		query.append("    T.INV_NO, T.VNDR_SEQ, T.YD_CD, T.ACCT_CD, T.CSR_NO," ).append("\n"); 
		query.append("    T.N3PTY_BIL_TP_CD, T.BKG_NO," ).append("\n"); 
		query.append("    T.BL_NO," ).append("\n"); 
		query.append("    T.FINC_VSL_CD, T.FINC_SKD_VOY_NO, T.FINC_SKD_DIR_CD, " ).append("\n"); 
		query.append("    T.REF_VNDR_SEQ, T.TML_CRR_CD, " ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("    WHEN T.VNDR_CUST_DIV_CD = 'C' THEN T.CUST_CNT_CD||T.CUST_SEQ" ).append("\n"); 
		query.append("    WHEN T.VNDR_CUST_DIV_CD = 'S' THEN T.N3PTY_OFC_CD" ).append("\n"); 
		query.append("    WHEN T.VNDR_CUST_DIV_CD = 'V' THEN T.VNDR_CNT_CD||T.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("    END TRD_PARTY_VAL," ).append("\n"); 
		query.append("    T.VNDR_CUST_DIV_CD," ).append("\n"); 
		query.append("    T.VNDR_CNT_CD, T.N3PTY_VNDR_SEQ, T.CUST_CNT_CD, T.CUST_SEQ, T.N3PTY_OFC_CD," ).append("\n"); 
		query.append("    NVL(T.CURR_CD,P.CURR_CD) CURR_CD, T.IF_AMT, T.IF_RMK, T.N3PTY_INV_DT, T.N3PTY_TERM_DT," ).append("\n"); 
		query.append("    T.N3PTY_CSR_CURR_CD, T.N3PTY_AMT, T.N3PTY_DESC, T.CXL_FLG" ).append("\n"); 
		query.append("FROM ( 	SELECT  H.CURR_CD," ).append("\n"); 
		query.append("            H.INV_OFC_CD," ).append("\n"); 
		query.append("            L.TML_RVIS_IND_FLG," ).append("\n"); 
		query.append("            L.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("            L.TML_SO_SEQ," ).append("\n"); 
		query.append("            L.TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("            @[tml_so_dtl_seq] TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("            L.CNTR_NO," ).append("\n"); 
		query.append("            L.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            L.IO_BND_CD," ).append("\n"); 
		query.append("            @[param_lgs_cost_cd] LGS_COST_CD," ).append("\n"); 
		query.append("            L.BKG_NO" ).append("\n"); 
		query.append("        FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND H.TML_SO_SEQ        = L.TML_SO_SEQ" ).append("\n"); 
		query.append("        AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("        AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("        AND L.VRFY_RSLT_IND_CD = 'CO'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT H.CURR_CD, " ).append("\n"); 
		query.append("            H.INV_OFC_CD," ).append("\n"); 
		query.append("            NULL TML_RVIS_IND_FLG," ).append("\n"); 
		query.append("            D.TML_SO_OFC_CTY_CD, " ).append("\n"); 
		query.append("            D.TML_SO_SEQ, " ).append("\n"); 
		query.append("            NULL TML_SO_CNTR_LIST_SEQ," ).append("\n"); 
		query.append("            TO_CHAR(D.TML_SO_DTL_SEQ) TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("            R.CNTR_NO," ).append("\n"); 
		query.append("            D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("            D.IO_BND_CD," ).append("\n"); 
		query.append("            D.LGS_COST_CD,  " ).append("\n"); 
		query.append("            R.BKG_NO" ).append("\n"); 
		query.append("        FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_RVIS_LIST R" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND H.TML_SO_SEQ        = D.TML_SO_SEQ" ).append("\n"); 
		query.append("        AND D.TML_SO_OFC_CTY_CD = R.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        AND D.TML_SO_SEQ        = R.TML_SO_SEQ" ).append("\n"); 
		query.append("        AND D.TML_SO_DTL_SEQ 	= R.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("        AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("        AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("        AND D.TML_SO_DTL_SEQ = @[tml_so_dtl_seq]" ).append("\n"); 
		query.append("    ) P, TES_N3RD_PTY_IF T" ).append("\n"); 
		query.append("WHERE P.TML_SO_OFC_CTY_CD = T.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND P.TML_SO_SEQ        = T.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("AND P.TML_SO_DTL_SEQ 	= T.TML_SO_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND P.CNTR_NO      = T.CNTR_NO(+)" ).append("\n"); 

	}
}