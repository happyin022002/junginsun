/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ConstraintMasterDBDAOTempSpcAlocMgmtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOTempSpcAlocMgmtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO생성용
	  * </pre>
	  */
	public ConstraintMasterDBDAOTempSpcAlocMgmtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOTempSpcAlocMgmtVORSQL").append("\n"); 
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
		query.append("SELECT BKG_ALOC_SEQ, BKG_ALOC_SEQ SHAAS_SEQ, BKG_ALOC_SEQ SINWA_SEQ" ).append("\n"); 
		query.append("     , BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("     , TRNK_SLAN_CD" ).append("\n"); 
		query.append("     , TRNK_DIR_CD" ).append("\n"); 
		query.append("     , VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("     , SLS_RHQ_CD" ).append("\n"); 
		query.append("     , OB_SLS_OFC_CD" ).append("\n"); 
		query.append("     , BKG_POR_CNT_CD" ).append("\n"); 
		query.append("     , POR_CD" ).append("\n"); 
		query.append("     , POR_NOD_CD" ).append("\n"); 
		query.append("     , BKG_POR_SCC_CD" ).append("\n"); 
		query.append("     , BKG_POL_CNT_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POL_NOD_CD" ).append("\n"); 
		query.append("     , N1ST_TS_SLAN_CD" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM SPC_BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAM.BKG_ALOC_TP_CD = 'S' ) N1ST_TS_POL_CD" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM SPC_BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAM.BKG_ALOC_TP_CD = 'S' ) N1ST_TS_POD_CD" ).append("\n"); 
		query.append("     , N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("     , N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append("     , N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("     , N2ND_TS_SLAN_CD" ).append("\n"); 
		query.append("     , N2ND_TS_POL_CD" ).append("\n"); 
		query.append("     , N2ND_TS_POD_CD" ).append("\n"); 
		query.append("     , BKG_POD_CNT_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , POD_NOD_CD" ).append("\n"); 
		query.append("     , BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("     , DEL_CD" ).append("\n"); 
		query.append("     , DEL_NOD_CD" ).append("\n"); 
		query.append("     , BKG_DEL_SCC_CD" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CTRT_CUST_CNT_CD||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_CNT_CD" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , CMDT_CD" ).append("\n"); 
		query.append("     , (SELECT CMDT_NM FROM MDM_COMMODITY MDM WHERE BAM.CMDT_CD = MDM.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("     , TO_CHAR(SCG_GRP_CMDT_SEQ,'00') SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("     , (SELECT PSGC.SCG_GRP_CMDT_DESC FROM PRI_SCG_GRP_CMDT PSGC WHERE PSGC.SVC_SCP_CD = 'TPW' AND PSGC.CHG_CD = 'GRI' AND PSGC.SCG_GRP_CMDT_SEQ = BAM.SCG_GRP_CMDT_SEQ AND ROWNUM = 1) SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("     , ALOC_LOD_QTY, ALOC_LOD_QTY OLD_ALOC_LOD_QTY -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append("     , ALOC_LOD_QTY_RTO, ALOC_LOD_QTY_RTO OLD_ALOC_LOD_QTY_RTO -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append("     , ASGN_TTL_WGT, ASGN_TTL_WGT OLD_ASGN_TTL_WGT -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append("     , ASGN_WGT_RTO, ASGN_WGT_RTO OLD_AASGN_WGT_RTO -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append("     , ALOC_SVC_CD" ).append("\n"); 
		query.append("     , BKG_ALOC_RMK" ).append("\n"); 
		query.append("     , ALOC_USE_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM SPC_BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POL' AND BAM.BKG_ALOC_TP_CD = 'T') TRUNK_POL_CD" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(BAMD.LOC_CD) FROM SPC_BKG_ALOC_MGMT_LOC_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.LOC_DIV_CD = 'POD' AND BAM.BKG_ALOC_TP_CD = 'T') TRUNK_POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 , CMPB_AMT, CMPB_AMT OLD_CMPB_AMT -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append("	 , BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("	 , DCGO_FLG" ).append("\n"); 
		query.append("	 , RD_CGO_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , (SELECT WM_CONCAT(CUST.CUST_CNT_CD||LPAD(CUST.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL CUST WHERE CUST.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND CUST.BKG_CUST_TP_CD = 'B' ) AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("	 , ALOC_APLY_FM_DT" ).append("\n"); 
		query.append("	 , ALOC_APLY_TO_DT" ).append("\n"); 
		query.append("	 , SUB_TRD_CD" ).append("\n"); 
		query.append("	 --, CMPB_RULE_CD" ).append("\n"); 
		query.append("	 , DECODE(DCGO_FLG, 'Y', 'dg', DECODE (RD_CGO_FLG, 'Y', 'rd', '') ) AS DG_RD" ).append("\n"); 
		query.append("	 , OFT_CHG_AMT, OFT_CHG_AMT OLD_OFT_CHG_AMT -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append("     , USA_BKG_MOD_CD" ).append("\n"); 
		query.append("     , HUL_BND_CD" ).append("\n"); 
		query.append("     , APLY_FM_YRWK" ).append("\n"); 
		query.append("     , APLY_TO_YRWK" ).append("\n"); 
		query.append("	 , CMPB_ONY_FLG" ).append("\n"); 
		query.append("--VO용이라고 함" ).append("\n"); 
		query.append("	 , '' LANE_CNT" ).append("\n"); 
		query.append("	 , '' DIR_CNT" ).append("\n"); 
		query.append("	 , '' CMDT_CNT" ).append("\n"); 
		query.append("	 , '' VAL_VALUE" ).append("\n"); 
		query.append("	 , '' VAL_TYPE" ).append("\n"); 
		query.append("	 , '' VAL_CNT" ).append("\n"); 
		query.append("	 , '' subtrade" ).append("\n"); 
		query.append("     , '' lane" ).append("\n"); 
		query.append("	 , '' bound" ).append("\n"); 
		query.append("	 , '' trade" ).append("\n"); 
		query.append("	 , '' tab_rhq_cd" ).append("\n"); 
		query.append("     , '' ofc_ty" ).append("\n"); 
		query.append("     , '' chk_op" ).append("\n"); 
		query.append("     , '' vvd_sig" ).append("\n"); 
		query.append("     , '' ofc_cd" ).append("\n"); 
		query.append("--     , AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("	 , '' STWG_CD" ).append("\n"); 
		query.append("	, '' OP_CNTR_QTY, '' OLD_OP_CNTR_QTY" ).append("\n"); 
		query.append("    , '' OP_CNTR_QTY_RTO, '' OLD_OP_CNTR_QTY_RTO" ).append("\n"); 
		query.append("	, '' SC_NM" ).append("\n"); 
		query.append("	, '' CTRT_CUST_CNT_NM" ).append("\n"); 
		query.append("	, '' RFA_NM" ).append("\n"); 
		query.append("	, '' TS_NOD_CD" ).append("\n"); 
		query.append("	, '' TS_POD_NOD_CD" ).append("\n"); 
		query.append("	, '' ACCT_TP" ).append("\n"); 
		query.append("	, '' CUST_CNT_NM" ).append("\n"); 
		query.append("	, '' TS_POL_NOD_CD" ).append("\n"); 
		query.append("	, '' VAL_VALUE2" ).append("\n"); 
		query.append("	, '' CUST_GRP_ID" ).append("\n"); 
		query.append("	, '' CUST_GRP_NM" ).append("\n"); 
		query.append("	, '' CMPB_PER_WGT" ).append("\n"); 
		query.append("	, '' WGT_PER_TEU" ).append("\n"); 
		query.append("	, '' RFA_CTRT_TP_CD" ).append("\n"); 
		query.append("	, '' CRR_CD" ).append("\n"); 
		query.append("	, '' CRR_NM" ).append("\n"); 
		query.append("	, '' LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 

	}
}