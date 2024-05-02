/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KrWharfageDecMgtDBDAOmergeSearchBkgKrWhfBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KrWharfageDecMgtDBDAOmergeSearchBkgKrWhfBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * I
	  * </pre>
	  */
	public KrWharfageDecMgtDBDAOmergeSearchBkgKrWhfBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("whf_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration").append("\n"); 
		query.append("FileName : KrWharfageDecMgtDBDAOmergeSearchBkgKrWhfBlCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_KR_WHF_BL X" ).append("\n"); 
		query.append(" USING (" ).append("\n"); 
		query.append(" SELECT DISTINCT @[vsl_cd] AS VSL_CD, @[skd_voy_no] AS SKD_VOY_NO, @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("        CASE WHEN @[cstms_decl_tp_cd] = 'I' THEN 'II'" ).append("\n"); 
		query.append("             WHEN @[cstms_decl_tp_cd] = 'T' THEN 'IT'" ).append("\n"); 
		query.append("             WHEN @[cstms_decl_tp_cd] = 'E' THEN 'OO'" ).append("\n"); 
		query.append("             WHEN @[cstms_decl_tp_cd] = 'R' THEN 'OT'" ).append("\n"); 
		query.append("             ELSE NULL" ).append("\n"); 
		query.append("        END AS WHF_BND_CD," ).append("\n"); 
		query.append("        A.BL_NO, A.BKG_NO," ).append("\n"); 
		query.append("        A.POR_CD, A.POL_CD, A.POD_CD, A.DEL_CD," ).append("\n"); 
		query.append("        DECODE(A.TS_POL_CD, @[whf_pol_cd], A.TS_POL_CD, NULL) AS WHF_POL_CD," ).append("\n"); 
		query.append("        DECODE(A.TS_POD_CD, @[whf_pol_cd], A.TS_POD_CD, NULL) AS WHF_POD_CD," ).append("\n"); 
		query.append("        NVL(A.PCK_QTY, 0) AS PCK_QTY, A.PCK_TP_CD," ).append("\n"); 
		query.append("        NVL(A.CNTR_TTL_WGT, 0) AS WGT_QTY, A.WGT_UT_CD," ).append("\n"); 
		query.append("        NVL(A.MEAS_QTY, 0) AS MEAS_QTY, A.BL_MEAS_UT_CD AS MEAS_UT_CD," ).append("\n"); 
		query.append("        B.RCV_TERM_CD, B.DE_TERM_CD," ).append("\n"); 
		query.append("        @[cstms_decl_tp_cd] AS CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("        NULL AS CMDT_CD, " ).append("\n"); 
		query.append("        C.BKG_RT_WHF_EXPT_CD AS WFG_EXPT_CD," ).append("\n"); 
		query.append("        B.OB_SLS_OFC_CD AS SLS_OFC_CD," ).append("\n"); 
		query.append("        B.SLAN_CD AS RLANE_CD," ).append("\n"); 
		query.append("        0 AS RTON_WGT," ).append("\n"); 
		query.append("        0 AS WHF_AMT," ).append("\n"); 
		query.append("        DECODE(B.BKG_STS_CD, 'X', 'D', 'N') AS WHF_BL_STS_CD," ).append("\n"); 
		query.append("        NULL AS WHF_BL_ADD_RSN_CD," ).append("\n"); 
		query.append("        CASE WHEN @[whf_bnd_cd] = 'II' AND" ).append("\n"); 
		query.append("                  @[whf_pol_cd] IN ('KRPUS', 'KRKAN', 'KRINC', 'KRPTK') AND" ).append("\n"); 
		query.append("                  A.POD_CD IN ('KRPUS', 'KRKAN', 'KRINC', 'KRPTK') AND" ).append("\n"); 
		query.append("                  @[whf_pol_cd] <> A.POD_CD THEN 'Y'" ).append("\n"); 
		query.append("             WHEN  @[whf_bnd_cd] = 'II' AND SUBSTR(A.POD_CD, 1, 2) <> 'KR' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN @[whf_bnd_cd] = 'OO' AND" ).append("\n"); 
		query.append("                  @[whf_pol_cd] IN ('KRPUS', 'KRKAN', 'KRINC', 'KRPTK') AND" ).append("\n"); 
		query.append("                  A.POL_CD IN ('KRPUS', 'KRKAN', 'KRINC', 'KRPTK') AND" ).append("\n"); 
		query.append("                  @[whf_pol_cd] <> A.POL_CD THEN 'Y'" ).append("\n"); 
		query.append("             WHEN  @[whf_bnd_cd] = 'OO' AND SUBSTR(A.POL_CD, 1, 2) <> 'KR' THEN 'Y'" ).append("\n"); 
		query.append("             ELSE 'N'" ).append("\n"); 
		query.append("        END AS WHF_BL_THRU_TS_FLG," ).append("\n"); 
		query.append("        DECODE(A.BKG_CGO_TP_CD, 'P', 'M', A.BKG_CGO_TP_CD) AS WHF_BL_CGO_TP_CD," ).append("\n"); 
		query.append("        @[cre_usr_id] AS CRE_USR_ID, SYSDATE AS CRE_DT," ).append("\n"); 
		query.append("        @[upd_usr_id] AS UPD_USR_ID, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("   FROM BKG_CSTMS_KR_BL A, BKG_BOOKING B, BKG_RATE C," ).append("\n"); 
		query.append("        (SELECT D.BKG_NO, D.CSTMS_DECL_TP_CD, D.DMST_PORT_CD, MAX(D.TRNS_SEQ) MAX_TRNS_SEQ" ).append("\n"); 
		query.append("           FROM BKG_CSTMS_KR_BL D, (SELECT E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      FROM BKG_CSTMS_KR_VVD_SMRY E" ).append("\n"); 
		query.append("                                     WHERE E.MRN_NO     = SUBSTR(@[mrn_no], 1, 10)" ).append("\n"); 
		query.append("                                       AND E.MRN_CHK_NO = SUBSTR(@[mrn_no], 11, 1)" ).append("\n"); 
		query.append("                                       AND E.PORT_CD    = @[whf_pol_cd]" ).append("\n"); 
		query.append("                                       AND E.IO_BND_CD  = SUBSTR(@[whf_bnd_cd], 1, 1)) F" ).append("\n"); 
		query.append("          WHERE D.BKG_NO           =  @[bkg_no]" ).append("\n"); 
		query.append("            AND D.CSTMS_DECL_TP_CD IN (DECODE(@[whf_bnd_cd], 'II', 'I', 'E'), DECODE(@[whf_bnd_cd], 'II', 'T', 'R'))" ).append("\n"); 
		query.append("            AND D.DMST_PORT_CD     = @[whf_pol_cd]" ).append("\n"); 
		query.append("            AND D.VSL_CD           =  F.VSL_CD" ).append("\n"); 
		query.append("            AND D.SKD_VOY_NO       =  F.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND D.SKD_DIR_CD       =  F.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND D.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("          GROUP BY D.BKG_NO, D.CSTMS_DECL_TP_CD, D.DMST_PORT_CD) G" ).append("\n"); 
		query.append("  WHERE A.BKG_NO           = G.BKG_NO" ).append("\n"); 
		query.append("    AND A.CSTMS_DECL_TP_CD = G.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("    AND A.DMST_PORT_CD     = G.DMST_PORT_CD" ).append("\n"); 
		query.append("    AND A.TRNS_SEQ         = G.MAX_TRNS_SEQ" ).append("\n"); 
		query.append("    AND B.BKG_NO(+)        = A.BKG_NO" ).append("\n"); 
		query.append("    AND C.BKG_NO(+)        = A.BKG_NO) Y" ).append("\n"); 
		query.append(" ON (X.VSL_CD = Y.VSL_CD AND" ).append("\n"); 
		query.append("     X.SKD_VOY_NO = Y.SKD_VOY_NO AND" ).append("\n"); 
		query.append("     X.SKD_DIR_CD = Y.SKD_DIR_CD AND" ).append("\n"); 
		query.append("     X.WHF_BND_CD = Y.WHF_BND_CD AND" ).append("\n"); 
		query.append("     X.BL_NO = Y.BL_NO)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET X.BKG_NO = Y.BKG_NO," ).append("\n"); 
		query.append("            X.POR_CD = Y.POR_CD," ).append("\n"); 
		query.append("            X.POL_CD = Y.POL_CD," ).append("\n"); 
		query.append("            X.POD_CD = Y.POD_CD," ).append("\n"); 
		query.append("            X.DEL_CD = Y.DEL_CD," ).append("\n"); 
		query.append("            X.WHF_POL_CD = Y.WHF_POL_CD," ).append("\n"); 
		query.append("            X.WHF_POD_CD = Y.WHF_POD_CD," ).append("\n"); 
		query.append("            X.PCK_QTY = Y.PCK_QTY," ).append("\n"); 
		query.append("            X.WGT_QTY = Y.WGT_QTY," ).append("\n"); 
		query.append("            X.WGT_UT_CD = Y.WGT_UT_CD," ).append("\n"); 
		query.append("            X.MEAS_QTY = Y.MEAS_QTY," ).append("\n"); 
		query.append("            X.MEAS_UT_CD = Y.MEAS_UT_CD," ).append("\n"); 
		query.append("            X.RCV_TERM_CD = Y.RCV_TERM_CD," ).append("\n"); 
		query.append("            X.DE_TERM_CD = Y.DE_TERM_CD," ).append("\n"); 
		query.append("            X.CMDT_CD = Y.CMDT_CD," ).append("\n"); 
		query.append("            X.WFG_EXPT_CD = Y.WFG_EXPT_CD," ).append("\n"); 
		query.append("            X.SLS_OFC_CD = Y.SLS_OFC_CD," ).append("\n"); 
		query.append("            X.RLANE_CD = Y.RLANE_CD," ).append("\n"); 
		query.append("            X.RTON_WGT = Y.RTON_WGT," ).append("\n"); 
		query.append("            X.WHF_AMT = Y.WHF_AMT," ).append("\n"); 
		query.append("            X.WHF_BL_STS_CD = Y.WHF_BL_STS_CD," ).append("\n"); 
		query.append("            X.WHF_BL_ADD_RSN_CD = Y.WHF_BL_ADD_RSN_CD," ).append("\n"); 
		query.append("            X.WHF_BL_THRU_TS_FLG = Y.WHF_BL_THRU_TS_FLG," ).append("\n"); 
		query.append("            X.WHF_BL_CGO_TP_CD = Y.WHF_BL_CGO_TP_CD," ).append("\n"); 
		query.append("            X.CSTMS_DECL_TP_CD = Y.CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("            X.PCK_TP_CD = Y.PCK_TP_CD," ).append("\n"); 
		query.append("            X.UPD_USR_ID = Y.UPD_USR_ID," ).append("\n"); 
		query.append("            X.UPD_DT = Y.UPD_DT" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (X.VSL_CD," ).append("\n"); 
		query.append("            X.SKD_VOY_NO," ).append("\n"); 
		query.append("            X.SKD_DIR_CD," ).append("\n"); 
		query.append("            X.WHF_BND_CD," ).append("\n"); 
		query.append("            X.BL_NO," ).append("\n"); 
		query.append("            X.BKG_NO," ).append("\n"); 
		query.append("            X.POR_CD," ).append("\n"); 
		query.append("            X.POL_CD," ).append("\n"); 
		query.append("            X.POD_CD," ).append("\n"); 
		query.append("            X.DEL_CD," ).append("\n"); 
		query.append("            X.WHF_POL_CD," ).append("\n"); 
		query.append("            X.WHF_POD_CD," ).append("\n"); 
		query.append("            X.PCK_QTY," ).append("\n"); 
		query.append("            X.WGT_QTY," ).append("\n"); 
		query.append("            X.WGT_UT_CD," ).append("\n"); 
		query.append("            X.MEAS_QTY," ).append("\n"); 
		query.append("            X.MEAS_UT_CD," ).append("\n"); 
		query.append("            X.RCV_TERM_CD," ).append("\n"); 
		query.append("            X.DE_TERM_CD," ).append("\n"); 
		query.append("            X.CMDT_CD," ).append("\n"); 
		query.append("            X.WFG_EXPT_CD," ).append("\n"); 
		query.append("            X.SLS_OFC_CD," ).append("\n"); 
		query.append("            X.RLANE_CD," ).append("\n"); 
		query.append("            X.RTON_WGT," ).append("\n"); 
		query.append("            X.WHF_AMT," ).append("\n"); 
		query.append("            X.WHF_BL_STS_CD," ).append("\n"); 
		query.append("            X.WHF_BL_ADD_RSN_CD," ).append("\n"); 
		query.append("            X.WHF_BL_THRU_TS_FLG," ).append("\n"); 
		query.append("            X.WHF_BL_CGO_TP_CD," ).append("\n"); 
		query.append("            X.CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("            X.PCK_TP_CD," ).append("\n"); 
		query.append("            X.CRE_USR_ID," ).append("\n"); 
		query.append("            X.CRE_DT," ).append("\n"); 
		query.append("            X.UPD_USR_ID," ).append("\n"); 
		query.append("            X.UPD_DT)" ).append("\n"); 
		query.append("    VALUES (Y.VSL_CD," ).append("\n"); 
		query.append("            Y.SKD_VOY_NO," ).append("\n"); 
		query.append("            Y.SKD_DIR_CD," ).append("\n"); 
		query.append("            Y.WHF_BND_CD," ).append("\n"); 
		query.append("            Y.BL_NO," ).append("\n"); 
		query.append("            Y.BKG_NO," ).append("\n"); 
		query.append("            Y.POR_CD," ).append("\n"); 
		query.append("            Y.POL_CD," ).append("\n"); 
		query.append("            Y.POD_CD," ).append("\n"); 
		query.append("            Y.DEL_CD," ).append("\n"); 
		query.append("            Y.WHF_POL_CD," ).append("\n"); 
		query.append("            Y.WHF_POD_CD," ).append("\n"); 
		query.append("            Y.PCK_QTY," ).append("\n"); 
		query.append("            Y.WGT_QTY," ).append("\n"); 
		query.append("            Y.WGT_UT_CD," ).append("\n"); 
		query.append("            Y.MEAS_QTY," ).append("\n"); 
		query.append("            Y.MEAS_UT_CD," ).append("\n"); 
		query.append("            Y.RCV_TERM_CD," ).append("\n"); 
		query.append("            Y.DE_TERM_CD," ).append("\n"); 
		query.append("            Y.CMDT_CD," ).append("\n"); 
		query.append("            Y.WFG_EXPT_CD," ).append("\n"); 
		query.append("            Y.SLS_OFC_CD," ).append("\n"); 
		query.append("            Y.RLANE_CD," ).append("\n"); 
		query.append("            Y.RTON_WGT," ).append("\n"); 
		query.append("            Y.WHF_AMT," ).append("\n"); 
		query.append("            Y.WHF_BL_STS_CD," ).append("\n"); 
		query.append("            Y.WHF_BL_ADD_RSN_CD," ).append("\n"); 
		query.append("            Y.WHF_BL_THRU_TS_FLG," ).append("\n"); 
		query.append("            Y.WHF_BL_CGO_TP_CD," ).append("\n"); 
		query.append("            Y.CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("            Y.PCK_TP_CD," ).append("\n"); 
		query.append("            Y.CRE_USR_ID," ).append("\n"); 
		query.append("            Y.CRE_DT," ).append("\n"); 
		query.append("            Y.UPD_USR_ID," ).append("\n"); 
		query.append("            Y.UPD_DT)" ).append("\n"); 

	}
}