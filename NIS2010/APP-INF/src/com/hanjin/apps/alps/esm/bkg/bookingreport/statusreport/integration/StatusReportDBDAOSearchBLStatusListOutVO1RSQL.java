/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusListOutVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.04.13 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusListOutVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusListOutVO1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusListOutVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusListOutVO1RSQL").append("\n"); 
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
		query.append("/* StatusReportOutVO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	  'BKG_STS_CD'              BKG_STS_CD            " ).append("\n"); 
		query.append("	, 'SI_FLG'                  SI_FLG                " ).append("\n"); 
		query.append("	, 'BKG_NO1'                 BKG_NO                " ).append("\n"); 
		query.append("	, 'SHPR_NAME'               SHPR_NAME             " ).append("\n"); 
		query.append("	, 'POR_CD'                  POR_CD                " ).append("\n"); 
		query.append("	, 'REP'                     REP                   " ).append("\n"); 
		query.append("	, 'TEU'                     TEU                   " ).append("\n"); 
		query.append("	, 'BKG_MEA_QTY'             BKG_MEA_QTY           " ).append("\n"); 
		query.append("	, 'PCK_TP_CD'               PCK_TP_CD             " ).append("\n"); 
		query.append("	, 'DCGO_FLG'                DCGO_FLG              " ).append("\n"); 
		query.append("	, 'RC_FLG'                  RC_FLG                " ).append("\n"); 
		query.append("	, 'FD_GRD_FLG'              FD_GRD_FLG            " ).append("\n"); 
		query.append("	, 'ITN_FLG'                 ITN_FLG               " ).append("\n"); 
		query.append("	, 'CAED_FLG'                CAED_FLG              " ).append("\n"); 
		query.append("	, 'BKG_OFC_CD'              BKG_OFC_CD            " ).append("\n"); 
		query.append("	, 'CTRT_OFC_CD'             CTRT_OFC_CD           " ).append("\n"); 
		query.append("	, 'OB_SLS_OFC_CD'           OB_SLS_OFC_CD         " ).append("\n"); 
		query.append("	, 'REMARK'                  REMARK                " ).append("\n"); 
		query.append("	, 'EXTER_REMARK'			EXTER_REMARK" ).append("\n"); 
		query.append("	, 'INTER_REMARK'			INTER_REMARK" ).append("\n"); 
		query.append("	, 'INTER_REMARK_DETAIL'		INTER_REMARK_DETAIL" ).append("\n"); 
		query.append("	, 'SC_NO'                   SC_NO              " ).append("\n"); 
		query.append("																										" ).append("\n"); 
		query.append("	, 'BDR_FLG'                 BDR_FLG               " ).append("\n"); 
		query.append("	, 'BL_NO'                   BL_NO                 " ).append("\n"); 
		query.append("	, 'CNEE_NAME'               CNEE_NAME             " ).append("\n"); 
		query.append("	, 'DEL_CD'                  DEL_CD                " ).append("\n"); 
		query.append("	, 'COMMODITY'               COMMODITY             " ).append("\n"); 
		query.append("	, 'FEU'                     FEU                   " ).append("\n"); 
		query.append("	, 'BKG_ACTWGT_QTY'          BKG_ACTWGT_QTY        " ).append("\n"); 
		query.append("	, 'RCV_TERM_CD'             RCV_TERM_CD           " ).append("\n"); 
		query.append("	, 'DE_TERM_CD'              DE_TERM_CD            " ).append("\n"); 
		query.append("	, 'AWK_CGO_FLG'             AWK_CGO_FLG           " ).append("\n"); 
		query.append("	, 'BB_CGO_FLG'              BB_CGO_FLG            " ).append("\n"); 
		query.append("	, 'PC'                      PC                    " ).append("\n"); 
		query.append("	, 'ITN_TYPE'                ITN_TYPE              " ).append("\n"); 
		query.append("	, 'CAED_TYPE'               CAED_TYPE             " ).append("\n"); 
		query.append("	, 'DOC_USR_ID'              DOC_USR_ID            " ).append("\n"); 
		query.append("	, 'CTRT_SREP_CD'            CTRT_SREP_CD          " ).append("\n"); 
		query.append("	, 'OB_SREP_CD'              OB_SREP_CD            " ).append("\n"); 
		query.append("	, 'RFA_NO'                  RFA_NO                " ).append("\n"); 
		query.append("																										" ).append("\n"); 
		query.append("	, 'TRUNK_VVD'               TRUNK_VVD             " ).append("\n"); 
		query.append("	, 'ORG_TRNS_SVC_MOD_CD'     ORG_TRNS_SVC_MOD_CD  " ).append("\n"); 
		query.append("	, 'DEST_TRNS_SVC_MOD_CD'    DEST_TRNS_SVC_MOD_CD" ).append("\n"); 
		query.append("	, 'POR_NOD_CD'              POR_NOD_CD            " ).append("\n"); 
		query.append("	, 'FNL_DEST_CD'             FNL_DEST_CD           " ).append("\n"); 
		query.append("	, 'SLAN_CD'                 SLAN_CD               " ).append("\n"); 
		query.append("	, 'BKG_CRE_DT'              BKG_CRE_DT            " ).append("\n"); 
		query.append("	, 'CMDT_CD'                 CMDT_CD               " ).append("\n"); 
		query.append("	, 'POL_CD'                  POL_CD                " ).append("\n"); 
		query.append("	, 'POD_CD'                  POD_CD                " ).append("\n"); 
		query.append("	, 'SHIPPER'                 SHIPPER               " ).append("\n"); 
		query.append("	, 'CONSIGNEE'               CONSIGNEE" ).append("\n"); 
		query.append("	, 'STWG_CD'					STWG_CD" ).append("\n"); 
		query.append("	, 'BLCK_STWG_CD'			BLCK_STWG_CD" ).append("\n"); 
		query.append("	, 'DEL_NOD_CD'				DEL_NOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, 'CNEE_NAME'          		CNEE_NAME" ).append("\n"); 
		query.append("	, 'NTFY'                    NTFY                  " ).append("\n"); 
		query.append("	, 'FFDR'                    FFDR                  " ).append("\n"); 
		query.append("	, 'PRE_1_VVD'               PRE_1_VVD             " ).append("\n"); 
		query.append("	, 'PRE_2_VVD'               PRE_2_VVD             " ).append("\n"); 
		query.append("	, 'PRE_3_VVD'               PRE_3_VVD             " ).append("\n"); 
		query.append("	, 'PRE_4_VVD'               PRE_4_VVD             " ).append("\n"); 
		query.append("	, 'POST_1_VVD'              POST_1_VVD            " ).append("\n"); 
		query.append("	, 'POST_2_VVD'              POST_2_VVD            " ).append("\n"); 
		query.append("	, 'POST_3_VVD'              POST_3_VVD            " ).append("\n"); 
		query.append("	, 'POST_4_VVD'              POST_4_VVD            " ).append("\n"); 
		query.append("	, 'PRE_1_POL_CD'            PRE_1_POL_CD          " ).append("\n"); 
		query.append("	, 'PRE_2_POL_CD'            PRE_2_POL_CD          " ).append("\n"); 
		query.append("	, 'PRE_3_POL_CD'            PRE_3_POL_CD          " ).append("\n"); 
		query.append("	, 'PRE_4_POL_CD'            PRE_4_POL_CD          " ).append("\n"); 
		query.append("	, 'PRE_1_POD_CD'            PRE_1_POD_CD          " ).append("\n"); 
		query.append("	, 'PRE_2_POD_CD'            PRE_2_POD_CD          " ).append("\n"); 
		query.append("	, 'PRE_3_POD_CD'            PRE_3_POD_CD          " ).append("\n"); 
		query.append("	, 'PRE_4_POD_CD'            PRE_4_POD_CD          " ).append("\n"); 
		query.append("	, 'BKG_CLZ_FLG'             BKG_CLZ_FLG           " ).append("\n"); 
		query.append("	, 'NTFY_NAME'               NTFY_NAME             " ).append("\n"); 
		query.append("	, 'ANTY_NAME'               ANTY_NAME             " ).append("\n"); 
		query.append("	, 'FFDR_NAME'               FFDR_NAME             " ).append("\n"); 
		query.append("	, 'EXPT_NAME'               EXPT_NAME             " ).append("\n"); 
		query.append("	, 'HNGR_FLG'                HNGR_FLG              " ).append("\n"); 
		query.append("	, 'SOC_FLG'                 SOC_FLG               " ).append("\n"); 
		query.append("	, 'EQ_SUBST_FLG'            EQ_SUBST_FLG          " ).append("\n"); 
		query.append("	, 'RD_CGO_FLG'              RD_CGO_FLG            " ).append("\n"); 
		query.append("	, 'TRUNK_POL'               TRUNK_POL             " ).append("\n"); 
		query.append("	, 'TRUNK_POD'               TRUNK_POD             " ).append("\n"); 
		query.append("	, 'HOT_DE_FLG'              HOT_DE_FLG            " ).append("\n"); 
		query.append("	, 'BKG_CTRL_OFC_CD'         BKG_CTRL_OFC_CD       " ).append("\n"); 
		query.append("	, 'EQ_CTRL_OFC_CD'          EQ_CTRL_OFC_CD        " ).append("\n"); 
		query.append("	, 'CNTR_TPSZ_CD'            CNTR_TPSZ_CD          " ).append("\n"); 
		query.append("	, 'CNTR_NO'                 CNTR_NO               " ).append("\n"); 
		query.append("	, 'AES_NO'                  AES_NO                " ).append("\n"); 
		query.append("	, 'CAED_NO'                 CAED_NO  " ).append("\n"); 
		query.append("    , 'Remark Detail'           REMARK_DETAIL  " ).append("\n"); 
		query.append("    , 'SHP_CALL_NO'             SHP_CALL_NO" ).append("\n"); 
		query.append("    , 'VSL_ENG_NM'              VSL_ENG_NM" ).append("\n"); 
		query.append("    , '' PCK_QTY" ).append("\n"); 
		query.append("    , '' ORDERBY_TITLE_SQL" ).append("\n"); 
		query.append("    , '' ORDERBY_TITLE    " ).append("\n"); 
		query.append("    , '' ORDERBY_CNT" ).append("\n"); 
		query.append("    , '' LAST_ORDERBY" ).append("\n"); 
		query.append("    , '' ORDERBY" ).append("\n"); 
		query.append("    , '' ROWS_PER_PAGE " ).append("\n"); 
		query.append("    , '' CURR_PAGE" ).append("\n"); 
		query.append("    , '' RNUM" ).append("\n"); 
		query.append("    , '' CONTACT" ).append("\n"); 
		query.append("    , '' TEL" ).append("\n"); 
		query.append("    , '' ACTUAL_POL" ).append("\n"); 
		query.append("    , '' ACTUAL_POD" ).append("\n"); 
		query.append("	, '' TOTAL_BKG" ).append("\n"); 
		query.append("	, '' TOTAL_BL" ).append("\n"); 
		query.append("	, '' TOTAL_TEU" ).append("\n"); 
		query.append("	, '' TOTAL_FEU" ).append("\n"); 
		query.append("	, '' TOTAL_WGT" ).append("\n"); 
		query.append("    , '' TOTAL_MEA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , '' RD_TOTAL_D2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_Q4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_D4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_R2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_D5" ).append("\n"); 
		query.append("    , '' RD_TOTAL_R4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_D7" ).append("\n"); 
		query.append("    , '' RD_TOTAL_R5" ).append("\n"); 
		query.append("    , '' RD_TOTAL_F2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_T2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_F4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_T4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_F5" ).append("\n"); 
		query.append("    , '' RD_TOTAL_P2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_O2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_P4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_O4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_Z4" ).append("\n"); 
		query.append("    , '' RD_TOTAL_Q2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_Z2" ).append("\n"); 
		query.append("    , '' RD_TOTAL_R9" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , '' FRT_TERM_CD" ).append("\n"); 
		query.append("    , '' CHG_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , '' CMDT_NM" ).append("\n"); 
		query.append("    , '' INTER_RMK" ).append("\n"); 
		query.append("    , '' TAA_NO" ).append("\n"); 
		query.append("    , '' CNTC_PSON_EML" ).append("\n"); 
		query.append("    , '' S_ADDR			-- Shipper Address" ).append("\n"); 
		query.append("    , '' C_ADDR			-- Consignee Address" ).append("\n"); 
		query.append("    , '' N_ADDR			-- Notify Address" ).append("\n"); 
		query.append("    , '' CSTMS_DESC		-- Customs Decription" ).append("\n"); 
		query.append("    , COUNT(1) OVER() TOTAL_CNT " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}