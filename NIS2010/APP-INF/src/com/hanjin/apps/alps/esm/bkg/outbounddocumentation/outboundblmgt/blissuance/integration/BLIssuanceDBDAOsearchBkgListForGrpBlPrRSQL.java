/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.09.02 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0280 Sheet Result
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("twn_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pre_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("booking_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_post_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_post_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pre_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL").append("\n"); 
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
		query.append("------------------------------------------------------" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       #if (''!=${sort_header})" ).append("\n"); 
		query.append("       ${sort_header}" ).append("\n"); 
		query.append("       #elseif (''!=${masterBlnos})" ).append("\n"); 
		query.append("       NULL" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("       'POL : '||POL||' / POD : '||POD" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AS ORDERBY_TITLE," ).append("\n"); 
		query.append("       T.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("------------------------------------------------------" ).append("\n"); 
		query.append("SELECT /*+ USE_NL(T1 T2 T3 T7) */" ).append("\n"); 
		query.append("       T1.BKG_NO," ).append("\n"); 
		query.append("       T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD AS POL_POD," ).append("\n"); 
		query.append("       T1.BL_NO||T1.BL_TP AS BL_NO," ).append("\n"); 
		query.append("       T1.POR_CD AS POR," ).append("\n"); 
		query.append("       T1.POL_CD AS POL," ).append("\n"); 
		query.append("       T1.POD_CD AS POD," ).append("\n"); 
		query.append("       T1.DEL_CD AS DEL," ).append("\n"); 
		query.append("       T1.BKG_RCV_TERM AS R_TERM," ).append("\n"); 
		query.append("       T1.BKG_DLV_TERM AS D_TERM," ).append("\n"); 
		query.append("       T1.PRE_RLY_PORT_CD AS RLY_POL_CD," ).append("\n"); 
		query.append("       T1.PST_RLY_PORT_CD AS RLY_POD_CD," ).append("\n"); 
		query.append("       T1.CMDT_REP AS REP," ).append("\n"); 
		query.append("       T1.CMDT_CD AS COMMODITY," ).append("\n"); 
		query.append("       T1.BKG_SPE_DG AS D_SC," ).append("\n"); 
		query.append("       T1.BKG_SPE_RF AS R_SC," ).append("\n"); 
		query.append("       T1.BKG_SPE_AK AS A_SC," ).append("\n"); 
		query.append("       T1.BKG_SPE_BB AS B_SC," ).append("\n"); 
		query.append("       T1.BKG_ADV_SHT AS A_S," ).append("\n"); 
		query.append("       T1.BKG_STS AS ST," ).append("\n"); 
		query.append("       T1.BKG_BDR_IND AS BDR," ).append("\n"); 
		query.append("       T1.BKG_BDR_CHG AS CA," ).append("\n"); 
		query.append("       T1.BKG_SO_NO AS TWN_SO_NO," ).append("\n"); 
		query.append("       (SELECT FINC_CTRL_OFC_CD FROM MDM_LOCATION X1 WHERE X1.LOC_CD = T1.POR_CD) AS POR_EQ," ).append("\n"); 
		query.append("       (SELECT FINC_CTRL_OFC_CD FROM MDM_LOCATION X1 WHERE X1.LOC_CD = T1.DEL_CD) AS DEL_EQ," ).append("\n"); 
		query.append("       #if (''!=${sc_rfa_no})" ).append("\n"); 
		query.append("           #if ('sc'==${sc_rfa_chk})" ).append("\n"); 
		query.append("               T1.SC_NO" ).append("\n"); 
		query.append("           #elseif ('rfa'==${sc_rfa_chk})" ).append("\n"); 
		query.append("               T1.RFA_NO" ).append("\n"); 
		query.append("           #elseif ('taa'==${sc_rfa_chk})" ).append("\n"); 
		query.append("               T1.TAA_NO" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #else" ).append("\n"); 
		query.append("           NVL(NVL(T1.RFA_NO,T1.SC_NO),T1.TAA_NO)" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       AS SC_RFA_NO," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(1), 0, 'N','Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC X1" ).append("\n"); 
		query.append("         WHERE X1.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("           AND 'US'=X1.CNT_CD" ).append("\n"); 
		query.append("           AND 'O'=X1.IO_BND_CD" ).append("\n"); 
		query.append("           AND X1.AES_TP_CD IS NOT NULL) AS AES," ).append("\n"); 
		query.append("       (SELECT DECODE(COUNT(1), 0, 'N','Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC X1" ).append("\n"); 
		query.append("         WHERE X1.BKG_NO = T1.BKG_NO" ).append("\n"); 
		query.append("           AND 'CA'=X1.CNT_CD" ).append("\n"); 
		query.append("           AND 'O'=X1.IO_BND_CD" ).append("\n"); 
		query.append("       AND X1.CAED_TP_CD IS NOT NULL) AS CAED," ).append("\n"); 
		query.append("       DECODE(" ).append("\n"); 
		query.append("       CASE WHEN 'Y'=NVL(T1.CUST_TO_ORD_FLG, 'N') AND T1.NTFY_NAME IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("            WHEN 'N'=NVL(T1.CUST_TO_ORD_FLG, 'Y') AND T1.CONSIGNEE_NAME IS NOT NULL THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N' END" ).append("\n"); 
		query.append("       ||" ).append("\n"); 
		query.append("       DECODE(T7.MK_SEQ, NULL, 'N', 'Y')||DECODE(NVL((SELECT CNTR_NO FROM BKG_CONTAINER WHERE BKG_NO = T1.BKG_NO AND 1=ROWNUM), 'N'), 'N' ,'N', 'Y'), 'YYY', 'Y', 'N') AS MANIFEST," ).append("\n"); 
		query.append("       DECODE(NVL((SELECT BKG_NO FROM BKG_CHG_RT WHERE BKG_NO = T1.BKG_NO AND 1=ROWNUM), 'N'), 'N', 'N', 'Y') AS RATE," ).append("\n"); 
		query.append("       REPLACE(REPLACE(T1.SHIPPER_NAME,CHR(13),' '),CHR(10),' ') AS SHIPPER," ).append("\n"); 
		query.append("       REPLACE(REPLACE(T1.CONSIGNEE_NAME,CHR(13),' '),CHR(10),' ') AS CONSIGNEE," ).append("\n"); 
		query.append("       T1.BL_BKG_NO," ).append("\n"); 
		query.append("       T1.BL_ACT_WGT," ).append("\n"); 
		query.append("       T1.BL_MEAS_QTY," ).append("\n"); 
		query.append("       NVL(T1.OBL_ISS_FLG,'N') OBL_ISS_FLG," ).append("\n"); 
		query.append("       NVL(T1.OBL_PRN_FLG,'N') OBL_PRN_FLG," ).append("\n"); 
		query.append("       NVL(T1.OBL_RLSE_FLG,'N') OBL_RLSE_FLG," ).append("\n"); 
		query.append("------------------------------------------------------SORT COLUMN START" ).append("\n"); 
		query.append("       T1.BKG_CRE_DT," ).append("\n"); 
		query.append("       T1.BKG_OFC_CD," ).append("\n"); 
		query.append("       T1.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("       T1.DOC_USR_ID," ).append("\n"); 
		query.append("       T1.OB_SREP_CD," ).append("\n"); 
		query.append("       T1.BKG_STS_CD," ).append("\n"); 
		query.append("       T1.FFDR," ).append("\n"); 
		query.append("       T1.NTFY," ).append("\n"); 
		query.append("       T1.RCV_TERM_CD," ).append("\n"); 
		query.append("       T1.DE_TERM_CD," ).append("\n"); 
		query.append("       T1.ORG_SVC," ).append("\n"); 
		query.append("       T1.DST_SVC," ).append("\n"); 
		query.append("       T1.BKG_ORG_ROUTE," ).append("\n"); 
		query.append("       T1.BKG_DST_ROUTE," ).append("\n"); 
		query.append("       T1.POR_CD," ).append("\n"); 
		query.append("       T1.POL_CD," ).append("\n"); 
		query.append("       T1.POD_CD," ).append("\n"); 
		query.append("       T1.DEL_CD," ).append("\n"); 
		query.append("       T1.SORT_PRE_POL," ).append("\n"); 
		query.append("       T1.SORT_PRE_POD," ).append("\n"); 
		query.append("       T1.SORT_POST_POL," ).append("\n"); 
		query.append("       T1.SORT_POST_POD," ).append("\n"); 
		query.append("       T1.TRUNK_VVD," ).append("\n"); 
		query.append("       T1.SORT_PRE_VVD," ).append("\n"); 
		query.append("       T1.SORT_POST_VVD," ).append("\n"); 
		query.append("       T1.TRUNK_POL," ).append("\n"); 
		query.append("       T1.TRUNK_POD," ).append("\n"); 
		query.append("       T1.BKG_LANE," ).append("\n"); 
		query.append("       T1.OBL_ISS_USR_ID," ).append("\n"); 
		query.append("       T1.OBL_ISS_OFC_CD," ).append("\n"); 
		query.append("       T1.BKG_CGO_TP," ).append("\n"); 
		query.append("       T1.CHINA_AGENT_CD," ).append("\n"); 
		query.append("       T1.POR_EQ_OFC," ).append("\n"); 
		query.append("       T1.DEL_EQ_OFC," ).append("\n"); 
		query.append("       T1.SC_NO," ).append("\n"); 
		query.append("       REPLACE(REPLACE(T1.SHPR_NAME,CHR(13),' '),CHR(10),' ') AS SHPR_NAME," ).append("\n"); 
		query.append("       REPLACE(REPLACE(T1.CNEE_NAME,CHR(13),' '),CHR(10),' ') AS CNEE_NAME," ).append("\n"); 
		query.append("	   T1.ENTR_CLSS_TP_CD" ).append("\n"); 
		query.append("------------------------------------------------------SORT COLUMN END" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       #if (''==${masterBlnos})" ).append("\n"); 
		query.append("       /*+ USE_NL(B REF) INDEX(B B(BKG_NO, BKG_OFC_CD)) */" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       B.SC_NO," ).append("\n"); 
		query.append("       B.BKG_CGO_TP_CD AS BKG_CGO_TP," ).append("\n"); 
		query.append("       B.REP_CMDT_CD AS CMDT_REP," ).append("\n"); 
		query.append("       B.CMDT_CD," ).append("\n"); 
		query.append("       B.BKG_OFC_CD AS BKG_OFC," ).append("\n"); 
		query.append("       BL.BKG_CLZ_FLG AS BKG_CBF_IND," ).append("\n"); 
		query.append("       B.RC_FLG AS BKG_SPE_RF," ).append("\n"); 
		query.append("       B.DCGO_FLG AS BKG_SPE_DG," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.RAIL_BLK_CD," ).append("\n"); 
		query.append("       B.STWG_CD," ).append("\n"); 
		query.append("       B.HOT_DE_FLG," ).append("\n"); 
		query.append("       B.PRCT_FLG," ).append("\n"); 
		query.append("       B.FD_GRD_FLG," ).append("\n"); 
		query.append("       B.SPCL_HIDE_FLG," ).append("\n"); 
		query.append("       B.WT_RSN_SPCL_CGO_FLG," ).append("\n"); 
		query.append("       B.WT_RSN_HLD_FLG," ).append("\n"); 
		query.append("       B.STOP_OFF_LOC_CD," ).append("\n"); 
		query.append("       B.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("       BL.BKG_NO AS BL_BKG_NO," ).append("\n"); 
		query.append("       DECODE(BL.WGT_UT_CD,'KGS',BL.ACT_WGT/1000,'LBS',BL.ACT_WGT*0.45359/1000,0) AS BL_ACT_WGT," ).append("\n"); 
		query.append("       DECODE(BL.MEAS_UT_CD,'CBF',BL.MEAS_QTY*0.02,'CBM',BL.MEAS_QTY,0) AS BL_MEAS_QTY," ).append("\n"); 
		query.append("       B.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("       B.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("       B.BL_TP_CD AS BL_TP," ).append("\n"); 
		query.append("       B.AWK_CGO_FLG AS BKG_SPE_AK," ).append("\n"); 
		query.append("       B.RD_CGO_FLG AS BKG_SPE_RD," ).append("\n"); 
		query.append("       B.BB_CGO_FLG AS BKG_SPE_BB," ).append("\n"); 
		query.append("       B.HNGR_FLG AS BKG_HANG_IND," ).append("\n"); 
		query.append("       B.SOC_FLG AS BKG_SOC_IND," ).append("\n"); 
		query.append("       B.EQ_SUBST_FLG AS BKG_ESUB," ).append("\n"); 
		query.append("       B.DOC_USR_ID AS BKG_STF," ).append("\n"); 
		query.append("       B.OB_SLS_OFC_CD AS SAL_OFC," ).append("\n"); 
		query.append("       B.OB_SREP_CD," ).append("\n"); 
		query.append("       B.RCV_TERM_CD AS BKG_RCV_TERM," ).append("\n"); 
		query.append("       B.DE_TERM_CD AS BKG_DLV_TERM," ).append("\n"); 
		query.append("       B.ORG_TRNS_SVC_MOD_CD AS ORG_SVC," ).append("\n"); 
		query.append("       B.DEST_TRNS_SVC_MOD_CD AS DST_SVC," ).append("\n"); 
		query.append("       B.ORG_SCONTI_CD AS BKG_ORG_ROUTE," ).append("\n"); 
		query.append("       B.DEST_SCONTI_CD AS BKG_DST_ROUTE," ).append("\n"); 
		query.append("       B.BKG_STS_CD AS BKG_STS," ).append("\n"); 
		query.append("       B.SLAN_CD AS BKG_LANE," ).append("\n"); 
		query.append("       B.HOT_DE_FLG AS BKG_HOT," ).append("\n"); 
		query.append("       B.BKG_CRE_DT AS BKG_DT," ).append("\n"); 
		query.append("       B.ADV_SHTG_CD AS BKG_ADV_SHT," ).append("\n"); 
		query.append("       B.TWN_SO_NO AS BKG_SO_NO," ).append("\n"); 
		query.append("       REF.CUST_REF_NO_CTNT AS BKG_PSA_NO," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS TRUNK_VVD," ).append("\n"); 
		query.append("       B.VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       BL.BDR_FLG AS BKG_BDR_IND," ).append("\n"); 
		query.append("       BL.BDR_CNG_FLG AS BKG_BDR_CHG," ).append("\n"); 
		query.append("       B.EQ_CTRL_OFC_CD AS BKG_EQ_OFC," ).append("\n"); 
		query.append("       ISS.OBL_ISS_DT," ).append("\n"); 
		query.append("       ISS.OBL_ISS_OFC_CD," ).append("\n"); 
		query.append("       ISS.OBL_ISS_USR_ID," ).append("\n"); 
		query.append("       ISS.OBL_ISS_FLG," ).append("\n"); 
		query.append("       ISS.OBL_PRN_FLG," ).append("\n"); 
		query.append("       ISS.OBL_RLSE_FLG," ).append("\n"); 
		query.append("       B.RFA_NO," ).append("\n"); 
		query.append("       B.TAA_NO," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'S',C.CUST_CNT_CD || C.CUST_SEQ)) AS SHIPPER," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'C',C.CUST_CNT_CD || C.CUST_SEQ)) AS CONSIGNEE," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'F',C.CUST_CNT_CD || C.CUST_SEQ)) AS FFDR," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'N',C.CUST_CNT_CD || C.CUST_SEQ)) AS NTFY," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'A',C.CUST_CNT_CD || C.CUST_SEQ)) AS ANTY," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'E',C.CUST_CNT_CD || C.CUST_SEQ)) AS EXPT," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'S',C.CUST_NM)) AS SHIPPER_NAME," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'C',C.CUST_NM)) AS CONSIGNEE_NAME," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'F',C.CUST_NM)) AS FFDR_NAME," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'N',C.CUST_NM)) AS NTFY_NAME," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'A',C.CUST_NM)) AS ANTY_NAME," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD,'E',C.CUST_NM)) AS EXPT_NAME," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS PRE_1_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS PRE_2_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS PRE_3_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS PRE_4_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END) AS PRE_1_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POL_CD END) AS PRE_2_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POL_CD END) AS PRE_3_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POL_CD END) AS PRE_4_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POD_CD END) AS PRE_1_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POD_CD END) AS PRE_2_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POD_CD END) AS PRE_3_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POD_CD END) AS PRE_4_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS POST_1_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS POST_2_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS POST_3_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END) AS POST_4_VVD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END) AS POST_1_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POL_CD END) AS POST_2_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POL_CD END) AS POST_3_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POL_CD END) AS POST_4_POL_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POD_CD END) AS POST_1_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POD_CD END) AS POST_2_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POD_CD END) AS POST_3_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POD_CD END) AS POST_4_POD_CD," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'T'=V2.VSL_PRE_PST_CD THEN V2.POL_CD END) AS TRUNK_POL," ).append("\n"); 
		query.append("       MAX(CASE WHEN 'T'=V2.VSL_PRE_PST_CD THEN V2.POD_CD END) AS TRUNK_POD," ).append("\n"); 
		query.append("------------------------------------------------------" ).append("\n"); 
		query.append("       TO_CHAR(B.BKG_CRE_DT, 'RRRR-MM-DD') AS BKG_CRE_DT," ).append("\n"); 
		query.append("       B.BKG_OFC_CD," ).append("\n"); 
		query.append("       B.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("       B.DOC_USR_ID," ).append("\n"); 
		query.append("       B.BKG_STS_CD," ).append("\n"); 
		query.append("       B.RCV_TERM_CD," ).append("\n"); 
		query.append("       B.DE_TERM_CD," ).append("\n"); 
		query.append("       MAX(DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,' ',NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("              NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POL_CD END,' ')))))) AS SORT_PRE_POL," ).append("\n"); 
		query.append("       MAX(DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POD_CD END, NULL,' '," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POD_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POD_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POD_CD END,' ')," ).append("\n"); 
		query.append("              NVL(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POD_CD END,' ')))))) AS SORT_PRE_POD," ).append("\n"); 
		query.append("       MAX(DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,' '," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POL_CD END,NULL,NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POL_CD END,' ')," ).append("\n"); 
		query.append("              NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POL_CD END,' ')))))) AS SORT_POST_POL," ).append("\n"); 
		query.append("       MAX(DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,' '," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.POD_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.POD_CD END,' ')," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POD_CD END,NULL,NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.POD_CD END,' ')," ).append("\n"); 
		query.append("              NVL(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.POD_CD END,' ')))))) AS SORT_POST_POD," ).append("\n"); 
		query.append("       MAX(DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL," ).append("\n"); 
		query.append("                  CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL," ).append("\n"); 
		query.append("                  CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL," ).append("\n"); 
		query.append("                  CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END," ).append("\n"); 
		query.append("                  CASE WHEN 'S'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END)))) AS SORT_PRE_VVD," ).append("\n"); 
		query.append("       MAX(DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL,' '," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL," ).append("\n"); 
		query.append("                  CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '1'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL," ).append("\n"); 
		query.append("                  CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '2'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END," ).append("\n"); 
		query.append("           DECODE(CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END,NULL," ).append("\n"); 
		query.append("                  CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '3'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END," ).append("\n"); 
		query.append("                  CASE WHEN 'U'=V2.VSL_PRE_PST_CD AND '4'=V2.VSL_SEQ THEN V2.VSL_CD||V2.SKD_VOY_NO||V2.SKD_DIR_CD END))))) AS SORT_POST_VVD," ).append("\n"); 
		query.append("       B.CHN_AGN_CD AS CHINA_AGENT_CD," ).append("\n"); 
		query.append("       (SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = B.POR_CD) AS POR_EQ_OFC," ).append("\n"); 
		query.append("       (SELECT EQ_CTRL_OFC_CD FROM MDM_LOCATION WHERE LOC_CD = B.DEL_CD) AS DEL_EQ_OFC," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD, 'S', SUBSTRB(C.CUST_NM, 1, 20))) AS SHPR_NAME," ).append("\n"); 
		query.append("       MAX(DECODE(C.BKG_CUST_TP_CD, 'C', SUBSTRB(C.CUST_NM, 1, 20))) AS CNEE_NAME," ).append("\n"); 
		query.append("	  (SELECT ENTR_CLSS_TP_CD " ).append("\n"); 
		query.append("	    FROM BKG_XPT_IMP_LIC A " ).append("\n"); 
		query.append("	    WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	      AND 'O' = A.IO_BND_CD" ).append("\n"); 
		query.append("           AND 'US' = A.CNT_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) ENTR_CLSS_TP_CD" ).append("\n"); 
		query.append("------------------------------------------------------" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_BL_DOC BL," ).append("\n"); 
		query.append("       BKG_CUSTOMER C," ).append("\n"); 
		query.append("       BKG_VVD V1," ).append("\n"); 
		query.append("       BKG_BL_ISS ISS," ).append("\n"); 
		query.append("       BKG_REFERENCE REF," ).append("\n"); 
		query.append("       BKG_VVD V2" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd})" ).append("\n"); 
		query.append("   AND V1.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND V1.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND V1.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vsl_pre_pst_cd})" ).append("\n"); 
		query.append("   AND @[vvd] = B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_pol_cd})" ).append("\n"); 
		query.append("   AND V1.POL_CD LIKE @[vvd_pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_pol_local} && ''!=${vvd_pol_ts})" ).append("\n"); 
		query.append("   AND B.POL_CD = V1.POL_CD" ).append("\n"); 
		query.append("#elseif (''!=${vvd_pol_ts} && ''!=${vvd_pol_local})" ).append("\n"); 
		query.append("   AND B.POL_CD <> V1.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_pod_cd})" ).append("\n"); 
		query.append("   AND V1.POD_CD LIKE @[vvd_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_pod_local})" ).append("\n"); 
		query.append("   AND B.POD_CD = V1.POD_CD" ).append("\n"); 
		query.append("#elseif (''!=${vvd_pod_ts})" ).append("\n"); 
		query.append("   AND B.POD_CD <> V1.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD IN ('F','W','A','S') --NOT 'X'" ).append("\n"); 
		query.append("   AND B.BKG_NO = C.BKG_NO (+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = V1.BKG_NO (+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = BL.BKG_NO (+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = ISS.BKG_NO (+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = REF.BKG_NO (+)" ).append("\n"); 
		query.append("   AND 'RGBK' = REF.BKG_REF_TP_CD (+)" ).append("\n"); 
		query.append("   AND B.BKG_NO = V2.BKG_NO (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${adv_shtg_cd_a} && ''!=${adv_shtg_cd_s})" ).append("\n"); 
		query.append("   AND B.SPLIT_RSN_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ('I'==${obl_iss_date})" ).append("\n"); 
		query.append("    #if (''!=${obl_iss_from_dt})" ).append("\n"); 
		query.append("       AND ( ISS.OBL_ISS_DT >= TO_DATE(REPLACE(@[obl_iss_from_dt],'-',''),'YYYYMMDD') )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (''!=${obl_iss_to_dt})" ).append("\n"); 
		query.append("       AND ( ISS.OBL_ISS_DT < TO_DATE(REPLACE(@[obl_iss_to_dt],'-',''),'YYYYMMDD') + 1 )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ('R'==${obl_iss_date} && ''!=${obl_iss_from_dt} && ''!=${obl_iss_to_dt})" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BKG_DOC_PROC_SKD" ).append("\n"); 
		query.append("                WHERE BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                  AND 'OBLREL'=BKG_DOC_PROC_TP_CD" ).append("\n"); 
		query.append("                  AND 'N'=DOC_PERF_DELT_FLG" ).append("\n"); 
		query.append("                  AND EVNT_DT BETWEEN TO_DATE(REPLACE(@[obl_iss_from_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("                                  AND TO_DATE(REPLACE(@[obl_iss_to_dt],'-',''),'YYYYMMDD')+1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${booking_por_cd})" ).append("\n"); 
		query.append("   AND B.POR_CD LIKE @[booking_por_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${booking_pol_cd})" ).append("\n"); 
		query.append("   AND B.POL_CD LIKE @[booking_pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${booking_pod_cd})" ).append("\n"); 
		query.append("   AND B.POD_CD LIKE @[booking_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${booking_del_cd})" ).append("\n"); 
		query.append("   AND B.DEL_CD LIKE @[booking_del_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${bkgRcvTermCds})" ).append("\n"); 
		query.append("   AND B.RCV_TERM_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgRcvTermCds_OfcCd IN ${bkgRcvTermCds})" ).append("\n"); 
		query.append("        '$bkgRcvTermCds_OfcCd'#if($velocityCount < $bkgRcvTermCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${bkgDeTermCds})" ).append("\n"); 
		query.append("   AND B.DE_TERM_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgDeTermCds_OfcCd IN ${bkgDeTermCds})" ).append("\n"); 
		query.append("        '$bkgDeTermCds_OfcCd'#if($velocityCount < $bkgDeTermCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${eq_por_cd} && ''!=${eq_ctrl_ofc_cd})" ).append("\n"); 
		query.append("   AND B.EQ_CTRL_OFC_CD LIKE @[eq_ctrl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${masterBlnos})" ).append("\n"); 
		query.append("   AND B.BL_NO IN (" ).append("\n"); 
		query.append("    #foreach($masterBlnos_OfcCd IN ${masterBlnos})" ).append("\n"); 
		query.append("        '$masterBlnos_OfcCd'#if($velocityCount < $masterBlnos.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${bkg_ofc_cd})" ).append("\n"); 
		query.append("   AND B.BKG_OFC_CD LIKE @[bkg_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${doc_usr_cd})" ).append("\n"); 
		query.append("   AND B.DOC_USR_ID LIKE @[doc_usr_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${ob_sls_ofc_cd})" ).append("\n"); 
		query.append("   AND B.OB_SLS_OFC_CD LIKE @[ob_sls_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${ob_srep_cd})" ).append("\n"); 
		query.append("   AND B.OB_SREP_CD LIKE @[ob_srep_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${obl_iss_ofc_cd})" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_OFC_CD LIKE @[obl_iss_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${obl_iss_usr_id})" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_USR_ID LIKE @[obl_iss_usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${rep_cmdt_cd})" ).append("\n"); 
		query.append("   AND B.REP_CMDT_CD LIKE @[rep_cmdt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${cmdt_cd})" ).append("\n"); 
		query.append("   AND B.CMDT_CD LIKE @[cmdt_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${twn_so_no})" ).append("\n"); 
		query.append("   AND B.TWN_SO_NO LIKE @[twn_so_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${cust_ref_no})" ).append("\n"); 
		query.append("   AND REF.CUST_REF_NO_CTNT LIKE @[cust_ref_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${sc_rfa_no})" ).append("\n"); 
		query.append("    #if ('sc'==${sc_rfa_chk})" ).append("\n"); 
		query.append("       AND B.SC_NO LIKE @[sc_rfa_no]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ('rfa'==${sc_rfa_chk})" ).append("\n"); 
		query.append("       AND @[sc_rfa_no]=B.RFA_NO" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if ('taa'==${sc_rfa_chk})" ).append("\n"); 
		query.append("       AND @[sc_rfa_no]=B.TAA_NO" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${orgScontiCds} != '')" ).append("\n"); 
		query.append("   AND B.ORG_SCONTI_CD IN (" ).append("\n"); 
		query.append("    #foreach($orgScontiCds_OfcCd IN ${orgScontiCds})" ).append("\n"); 
		query.append("        '$orgScontiCds_OfcCd'#if($velocityCount < $orgScontiCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${descScontiCds})" ).append("\n"); 
		query.append("   AND B.DEST_SCONTI_CD IN (" ).append("\n"); 
		query.append("    #foreach($descScontiCds_OfcCd IN ${descScontiCds})" ).append("\n"); 
		query.append("        '$descScontiCds_OfcCd'#if($velocityCount < $descScontiCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${orgSvcModCds})" ).append("\n"); 
		query.append("   AND B.ORG_TRNS_SVC_MOD_CD IN (" ).append("\n"); 
		query.append("    #foreach($orgSvcModCds_OfcCd IN ${orgSvcModCds})" ).append("\n"); 
		query.append("        '$orgSvcModCds_OfcCd'#if($velocityCount < $orgSvcModCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${descInlndSvcModCds})" ).append("\n"); 
		query.append("   AND B.DEST_TRNS_SVC_MOD_CD IN (" ).append("\n"); 
		query.append("    #foreach($descInlndSvcModCds_OfcCd IN ${descInlndSvcModCds})" ).append("\n"); 
		query.append("        '$descInlndSvcModCds_OfcCd'#if($velocityCount < $descInlndSvcModCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${dcgo_flg} || ''!=${rc_flg} || ''!=${awk_cgo_flg} || ''!=${bb_cgo_flg} || ''!=${hngr_flg} || ''!=${shpr_ownr_cntr_flg} || ''!=${eq_subst_flg} || ''!=${rd_cgo_flg} || ''!=${rail_blk_cd} || ''!=${stwg_cd} || ''!=${prct_flg} || ''!=${fd_grd_flg} || ''!=${spcl_hide_flg})" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${dcgo_flg})" ).append("\n"); 
		query.append("        'Y'=B.DCGO_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${rc_flg})" ).append("\n"); 
		query.append("        'Y'=B.RC_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${awk_cgo_flg})" ).append("\n"); 
		query.append("        'Y'=B.AWK_CGO_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${bb_cgo_flg})" ).append("\n"); 
		query.append("        'Y'=B.BB_CGO_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${hngr_flg})" ).append("\n"); 
		query.append("        'Y'=B.HNGR_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${shpr_ownr_cntr_flg})" ).append("\n"); 
		query.append("        'Y'=B.SOC_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${eq_subst_flg})" ).append("\n"); 
		query.append("        'Y'=B.EQ_SUBST_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${rd_cgo_flg})" ).append("\n"); 
		query.append("        'Y'=B.RD_CGO_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${rail_blk_cd})" ).append("\n"); 
		query.append("        B.RAIL_BLK_CD IS NOT NULL OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${stwg_cd})" ).append("\n"); 
		query.append("        B.STWG_CD IS NOT NULL OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${prct_flg})" ).append("\n"); 
		query.append("        'Y'=B.PRCT_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${fd_grd_flg})" ).append("\n"); 
		query.append("        'Y'=B.FD_GRD_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${spcl_hide_flg})" ).append("\n"); 
		query.append("        'Y'=B.SPCL_HIDE_FLG OR" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${dcgo_flg} || ''!=${rc_flg} || ''!=${awk_cgo_flg} || ''!=${bb_cgo_flg} || ''!=${hngr_flg} || ''!=${shpr_ownr_cntr_flg} || ''!=${eq_subst_flg} || ''!=${rd_cgo_flg} || ''!=${rail_blk_cd} || ''!=${stwg_cd} || ''!=${prct_flg} || ''!=${fd_grd_flg} || ''!=${spcl_hide_flg})" ).append("\n"); 
		query.append("       1=2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${bkgCgoTpCds})" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgCgoTpCds_OfcCd IN ${bkgCgoTpCds})" ).append("\n"); 
		query.append("        '$bkgCgoTpCds_OfcCd'#if($velocityCount < $bkgCgoTpCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${bkgStsCds})" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD IN (" ).append("\n"); 
		query.append("    #foreach($bkgStsCds_OfcCd IN ${bkgStsCds})" ).append("\n"); 
		query.append("        '$bkgStsCds_OfcCd'#if($velocityCount < $bkgStsCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${bkg_rsn_spcl_cgo_flg})" ).append("\n"); 
		query.append("   AND 'Y'=B.WT_RSN_SPCL_CGO_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${wt_rsn_hld_flg})" ).append("\n"); 
		query.append("   AND 'Y'=B.WT_RSN_HLD_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${advShtgCds})" ).append("\n"); 
		query.append("   AND B.ADV_SHTG_CD IN (" ).append("\n"); 
		query.append("    #foreach($advShtgCds_OfcCd IN ${advShtgCds})" ).append("\n"); 
		query.append("        '$advShtgCds_OfcCd'#if($velocityCount < $advShtgCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${revenueCds})" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN (" ).append("\n"); 
		query.append("    #foreach($revenue_OfcCd IN ${revenueCds})" ).append("\n"); 
		query.append("        '$revenue_OfcCd'#if($velocityCount < $revenueCds.size()),#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${stop_cargo})" ).append("\n"); 
		query.append("   AND B.STOP_OFF_LOC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${cust_tp_cd_s} || ''!=${cust_tp_cd_c} || ''!=${cust_tp_cd_n} || ''!=${cust_tp_cd_f} || ''!=${cust_tp_cd_a})" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD IN (''" ).append("\n"); 
		query.append("    #if (''!=${cust_tp_cd_s}) ,'S' #end" ).append("\n"); 
		query.append("    #if (''!=${cust_tp_cd_c}) ,'C' #end" ).append("\n"); 
		query.append("    #if (''!=${cust_tp_cd_n}) ,'N' #end" ).append("\n"); 
		query.append("    #if (''!=${cust_tp_cd_f}) ,'F' #end" ).append("\n"); 
		query.append("    #if (''!=${cust_tp_cd_a}) ,'A' #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("   AND @[cust_cnt_cd]=C.CUST_CNT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${cust_seq})" ).append("\n"); 
		query.append("   AND LTRIM(@[cust_seq],'0')=C.CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (''!=${cust_nm})" ).append("\n"); 
		query.append("   AND C.CUST_NM LIKE '%'||@[cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_pre_vvd})" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'T'=V1.VSL_PRE_PST_CD THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END))))))) LIKE @[vvd_pre_vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_pre_pol})" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POL_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POL_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POL_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POL_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'T'=V1.VSL_PRE_PST_CD THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'T'=V1.VSL_PRE_PST_CD THEN V1.POL_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POL_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POD_CD END,B.POL_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POL_CD END," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POL_CD END))))))) LIKE @[vvd_pre_pol]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_post_vvd})" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'T'=V1.VSL_PRE_PST_CD THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.VSL_CD||V1.SKD_VOY_NO||V1.SKD_DIR_CD END))))))) LIKE @[vvd_post_vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vvd_post_pod})" ).append("\n"); 
		query.append("   AND DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POD_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POD_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POD_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'U'=V1.VSL_PRE_PST_CD AND '1'=V1.VSL_SEQ THEN V1.POD_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'T'=V1.VSL_PRE_PST_CD THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'T'=V1.VSL_PRE_PST_CD THEN V1.POD_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '4'=V1.VSL_SEQ THEN V1.POD_CD END," ).append("\n"); 
		query.append("       DECODE(CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POL_CD END,B.POD_CD," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '3'=V1.VSL_SEQ THEN V1.POD_CD END," ).append("\n"); 
		query.append("              CASE WHEN 'S'=V1.VSL_PRE_PST_CD AND '2'=V1.VSL_SEQ THEN V1.POD_CD END))))))) LIKE @[vvd_post_pod]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${aes_itn_y} && ''==${aes_itn_n})" ).append("\n"); 
		query.append("   AND EXISTS (SELECT 'X' FROM BKG_XPT_IMP_LIC XI WHERE B.BKG_NO = XI.BKG_NO AND XI.AES_TP_CD IS NOT NULL)" ).append("\n"); 
		query.append("#elseif (''!=${aes_itn_n} && ''==${aes_itn_y})" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X' FROM BKG_XPT_IMP_LIC XI WHERE B.BKG_NO = XI.BKG_NO AND XI.AES_TP_CD IS NOT NULL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${entr_clss_rmk})" ).append("\n"); 
		query.append("	AND B.BKG_NO = XPT.BKG_NO" ).append("\n"); 
		query.append("	AND XPT.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       B.SC_NO," ).append("\n"); 
		query.append("       B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       B.REP_CMDT_CD," ).append("\n"); 
		query.append("       B.CMDT_CD," ).append("\n"); 
		query.append("       B.BKG_OFC_CD," ).append("\n"); 
		query.append("       BL.BKG_CLZ_FLG," ).append("\n"); 
		query.append("       B.RC_FLG," ).append("\n"); 
		query.append("       B.DCGO_FLG," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.RAIL_BLK_CD," ).append("\n"); 
		query.append("       B.STWG_CD," ).append("\n"); 
		query.append("       B.HOT_DE_FLG," ).append("\n"); 
		query.append("       B.PRCT_FLG," ).append("\n"); 
		query.append("       B.FD_GRD_FLG," ).append("\n"); 
		query.append("       B.SPCL_HIDE_FLG," ).append("\n"); 
		query.append("       B.WT_RSN_SPCL_CGO_FLG," ).append("\n"); 
		query.append("       B.WT_RSN_HLD_FLG," ).append("\n"); 
		query.append("       B.STOP_OFF_LOC_CD," ).append("\n"); 
		query.append("       B.CUST_TO_ORD_FLG," ).append("\n"); 
		query.append("       BL.BKG_NO," ).append("\n"); 
		query.append("       DECODE(BL.WGT_UT_CD,'KGS',BL.ACT_WGT/1000,'LBS',BL.ACT_WGT*0.45359/1000,0)," ).append("\n"); 
		query.append("       DECODE(BL.MEAS_UT_CD,'CBF',BL.MEAS_QTY*0.02,'CBM',BL.MEAS_QTY,0)," ).append("\n"); 
		query.append("       B.PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("       B.PST_RLY_PORT_CD," ).append("\n"); 
		query.append("       B.BL_TP_CD," ).append("\n"); 
		query.append("       B.AWK_CGO_FLG," ).append("\n"); 
		query.append("       B.RD_CGO_FLG," ).append("\n"); 
		query.append("       B.BB_CGO_FLG," ).append("\n"); 
		query.append("       B.HNGR_FLG," ).append("\n"); 
		query.append("       B.SOC_FLG," ).append("\n"); 
		query.append("       B.EQ_SUBST_FLG," ).append("\n"); 
		query.append("       B.DOC_USR_ID," ).append("\n"); 
		query.append("       B.OB_SLS_OFC_CD," ).append("\n"); 
		query.append("       B.OB_SREP_CD," ).append("\n"); 
		query.append("       B.RCV_TERM_CD," ).append("\n"); 
		query.append("       B.DE_TERM_CD," ).append("\n"); 
		query.append("       B.ORG_TRNS_SVC_MOD_CD," ).append("\n"); 
		query.append("       B.DEST_TRNS_SVC_MOD_CD," ).append("\n"); 
		query.append("       B.ORG_SCONTI_CD," ).append("\n"); 
		query.append("       B.DEST_SCONTI_CD," ).append("\n"); 
		query.append("       B.BKG_STS_CD," ).append("\n"); 
		query.append("       B.SLAN_CD," ).append("\n"); 
		query.append("       B.HOT_DE_FLG," ).append("\n"); 
		query.append("       B.BKG_CRE_DT," ).append("\n"); 
		query.append("       B.ADV_SHTG_CD," ).append("\n"); 
		query.append("       B.TWN_SO_NO," ).append("\n"); 
		query.append("       REF.CUST_REF_NO_CTNT," ).append("\n"); 
		query.append("       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.VSL_CD," ).append("\n"); 
		query.append("       B.SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       BL.BDR_FLG," ).append("\n"); 
		query.append("       BL.BDR_CNG_FLG," ).append("\n"); 
		query.append("       B.EQ_CTRL_OFC_CD," ).append("\n"); 
		query.append("       ISS.OBL_ISS_DT," ).append("\n"); 
		query.append("       ISS.OBL_ISS_OFC_CD," ).append("\n"); 
		query.append("       ISS.OBL_ISS_USR_ID," ).append("\n"); 
		query.append("       ISS.OBL_ISS_FLG," ).append("\n"); 
		query.append("       ISS.OBL_PRN_FLG," ).append("\n"); 
		query.append("       ISS.OBL_RLSE_FLG," ).append("\n"); 
		query.append("       B.RFA_NO," ).append("\n"); 
		query.append("       B.TAA_NO," ).append("\n"); 
		query.append("       B.CHN_AGN_CD" ).append("\n"); 
		query.append("       ) T1," ).append("\n"); 
		query.append("       MDM_LOCATION T2," ).append("\n"); 
		query.append("       BKG_BL_MK_DESC T7" ).append("\n"); 
		query.append(" WHERE T1.DEL_CD = T2.LOC_CD" ).append("\n"); 
		query.append("   AND T1.BKG_NO = T7.BKG_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${eq_del_cd} && ''!=${eq_ctrl_ofc_cd})" ).append("\n"); 
		query.append("   AND T2.FINC_CTRL_OFC_CD LIKE @[eq_ctrl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("------------------------------------------------------" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    #if (''!=${query_sort})" ).append("\n"); 
		query.append("    ${query_sort},BL_NO" ).append("\n"); 
		query.append("    #elseif (''!=${masterBlnos})" ).append("\n"); 
		query.append("    DECODE(SUBSTRB(T.BL_NO,1,12)," ).append("\n"); 
		query.append("    #foreach($masterBlnos_OfcCd IN ${masterBlnos})" ).append("\n"); 
		query.append("    '$masterBlnos_OfcCd', $velocityCount#if($velocityCount < $masterBlnos.size()) ,#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    POL,POD,BL_NO" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("------------------------------------------------------" ).append("\n"); 

	}
}