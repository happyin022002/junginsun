/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ConstraintMasterDBDAOSpcAlocCtrlOptVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintMasterDBDAOSpcAlocCtrlOptVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_BKG_ALOC_MGMT SELECT
	  * 
	  * -기존 BKG 시스템 검색조건 삭제 및 Trade, Sub Trade, Lane 검색조건 적용 변경
	  * ( Trunk 뿐 아니라 TS정보에도 적용)
	  * -TRUNK, T/S의 경우, Free Type은 Trunk pol-pod, TS pol-pod 동시입력 가능하므로 LOC_DIV_CD 변경함
	  * </pre>
	  */
	public ConstraintMasterDBDAOSpcAlocCtrlOptVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aloc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.integration").append("\n"); 
		query.append("FileName : ConstraintMasterDBDAOSpcAlocCtrlOptVORSQL").append("\n"); 
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
		query.append("#if(${tab_rhq_cd} != 'SHARC/SINRS')" ).append("\n"); 
		query.append("SELECT BKG_ALOC_SEQ" ).append("\n"); 
		query.append(" , BKG_ALOC_TP_CD" ).append("\n"); 
		query.append(" , TRNK_SLAN_CD" ).append("\n"); 
		query.append(" , TRNK_DIR_CD" ).append("\n"); 
		query.append(" , VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append(" , SLS_RHQ_CD" ).append("\n"); 
		query.append(" , OB_SLS_OFC_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POR' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_POR_CNT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POR' AND LENGTH(BAMD.SB_LOC_CD) = 5) POR_CD" ).append("\n"); 
		query.append(" , POR_NOD_CD" ).append("\n"); 
		query.append(" , BKG_POR_SCC_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POL' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_POL_CNT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POL' AND LENGTH(BAMD.SB_LOC_CD) = 5) POL_CD" ).append("\n"); 
		query.append(" , POL_NOD_CD" ).append("\n"); 
		query.append(" , N1ST_TS_SLAN_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(BAMD.SB_LOC_CD) = 5) N1ST_TS_POL_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(BAMD.SB_LOC_CD) = 5) N1ST_TS_POD_CD" ).append("\n"); 
		query.append(" , N1ST_TS_DIR_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(BAMD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(BAMD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SAY') TS_NOD_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SLY') TS_POL_NOD_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD" ).append("\n"); 
		query.append(" , N2ND_TS_SLAN_CD" ).append("\n"); 
		query.append(" , N2ND_TS_POL_CD" ).append("\n"); 
		query.append(" , N2ND_TS_POD_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POD' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_POD_CNT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POD' AND LENGTH(BAMD.SB_LOC_CD) = 5) POD_CD" ).append("\n"); 
		query.append(" , POD_NOD_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_DEL_CNT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(BAMD.SB_LOC_CD) = 5) DEL_CD" ).append("\n"); 
		query.append(" , DEL_NOD_CD" ).append("\n"); 
		query.append(" , BKG_DEL_SCC_CD" ).append("\n"); 
		query.append(" , SC_NO" ).append("\n"); 
		query.append(" , RFA_NO" ).append("\n"); 
		query.append(" , CTRT_CUST_CNT_CD||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append(" , CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_CNT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(Z.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL Z WHERE Z.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ) CNTR_TPSZ_CD" ).append("\n"); 
		query.append(" --, CMDT_CD" ).append("\n"); 
		query.append(" --, (SELECT CMDT_NM FROM MDM_COMMODITY MDM WHERE BAM.CMDT_CD = MDM.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ) CMDT_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(MDM.CMDT_NM) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT, MDM_COMMODITY MDM WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND TRIM(TO_CHAR(CMDT.CMDT_CD,'000000'))= MDM.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append(" , TO_CHAR(SCG_GRP_CMDT_SEQ,'00') SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append(" , (SELECT PSGC.SCG_GRP_CMDT_DESC FROM PRI_SCG_GRP_CMDT PSGC WHERE PSGC.SVC_SCP_CD = 'TPW' AND PSGC.CHG_CD = 'GRI' AND PSGC.SCG_GRP_CMDT_SEQ = BAM.SCG_GRP_CMDT_SEQ AND ROWNUM = 1) SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append(" , ALOC_LOD_QTY , ALOC_LOD_QTY AS OLD_ALOC_LOD_QTY -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append(" , ALOC_LOD_QTY_RTO, ALOC_LOD_QTY_RTO AS OLD_ALOC_LOD_QTY_RTO -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append(" , ASGN_TTL_WGT , ASGN_TTL_WGT AS OLD_ASGN_TTL_WGT -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append(" , ASGN_WGT_RTO, ASGN_WGT_RTO AS OLD_AASGN_WGT_RTO -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append(" , ALOC_SVC_CD" ).append("\n"); 
		query.append(" , BKG_ALOC_RMK" ).append("\n"); 
		query.append(" , ALOC_USE_FLG" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' AND LENGTH(BAMD.SB_LOC_CD) = 5) TRUNK_POL_CD" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' AND LENGTH(BAMD.SB_LOC_CD) = 5) TRUNK_POD_CD" ).append("\n"); 
		query.append(" , CMPB_AMT, CMPB_AMT OLD_CMPB_AMT -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append(" , BKG_CTRL_TP_CD" ).append("\n"); 
		query.append(" , DCGO_FLG" ).append("\n"); 
		query.append(" , RD_CGO_FLG" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(CUST.CUST_CNT_CD||LPAD(CUST.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL CUST WHERE CUST.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND CUST.BKG_CUST_TP_CD = 'B' ) AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append(" , ALOC_APLY_FM_DT" ).append("\n"); 
		query.append(" , ALOC_APLY_TO_DT" ).append("\n"); 
		query.append(" , SUB_TRD_CD" ).append("\n"); 
		query.append(" --, CMPB_RULE_CD " ).append("\n"); 
		query.append(" , DECODE(DCGO_FLG, 'Y', 'dg', DECODE (RD_CGO_FLG, 'Y', 'rd', '') ) AS DG_RD" ).append("\n"); 
		query.append(" , OFT_CHG_AMT, OFT_CHG_AMT OLD_OFT_CHG_AMT -- 조건 완화 체크를 위해" ).append("\n"); 
		query.append(" , USA_BKG_MOD_CD" ).append("\n"); 
		query.append(" , HUL_BND_CD" ).append("\n"); 
		query.append(" , APLY_FM_YRWK" ).append("\n"); 
		query.append(" , APLY_TO_YRWK" ).append("\n"); 
		query.append(" , CMPB_ONY_FLG --" ).append("\n"); 
		query.append(" , RVIS_CNTR_CUST_TP_CD AS ACCT_TP" ).append("\n"); 
		query.append(" , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = BAM.CTRT_CUST_CNT_CD  AND  M.CUST_SEQ = BAM.CTRT_CUST_SEQ ) AS CTRT_CUST_CNT_NM" ).append("\n"); 
		query.append(" , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = BAM.CUST_CNT_CD  AND  M.CUST_SEQ = BAM.CUST_SEQ ) AS CUST_CNT_NM" ).append("\n"); 
		query.append(" , (SELECT DISTINCT(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = PTY.CUST_CNT_CD AND CUST_SEQ = PTY.CUST_SEQ) AS SC_NM" ).append("\n"); 
		query.append("    FROM  PRI_SP_HDR HDR, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("        AND PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("        AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("        AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("        AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("        AND PTY.PRC_CTRT_PTY_TP_CD  = 'C'" ).append("\n"); 
		query.append("        AND HDR.SC_NO =  BAM.SC_NO AND ROWNUM=1 ) AS SC_NM" ).append("\n"); 
		query.append(" , (SELECT  DISTINCT(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = CTRT_CUST_CNT_CD AND CUST_SEQ = CTRT_CUST_SEQ) AS RFA_NM" ).append("\n"); 
		query.append("    FROM PRI_RP_HDR HDR ,PRI_RP_MN MN" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("    AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND HDR.RFA_NO = BAM.RFA_NO AND ROWNUM=1) AS RFA_NM" ).append("\n"); 
		query.append(" , OP_CNTR_QTY, OP_CNTR_QTY AS OLD_OP_CNTR_QTY " ).append("\n"); 
		query.append(" , OP_CNTR_QTY_RTO, OP_CNTR_QTY_RTO AS OLD_OP_CNTR_QTY_RTO" ).append("\n"); 
		query.append(" , CUST_GRP_ID" ).append("\n"); 
		query.append(" ,(SELECT CUST_GRP_NM from MDM_CUST_PERF_GRP z WHERE z.CUST_GRP_ID = BAM.CUST_GRP_ID ) AS CUST_GRP_NM" ).append("\n"); 
		query.append(" ,RFA_CTRT_TP_CD	" ).append("\n"); 
		query.append(" ,CMPB_PER_TON_AMT	AS CMPB_PER_WGT" ).append("\n"); 
		query.append(" ,TON_PER_TEU_WGT	AS WGT_PER_TEU" ).append("\n"); 
		query.append("	-- 20170629 로켓배송-stowage 추가(송민석)" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'STW' ) STWG_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if(${tab_rhq_cd} != '')" ).append("\n"); 
		query.append("AND SLS_RHQ_CD = @[tab_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${bkg_aloc_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("AND BKG_ALOC_TP_CD = @[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ((SUB_TRD_CD IS NULL AND TRNK_SLAN_CD IS NULL AND N1ST_TS_SLAN_CD IS NULL) OR" ).append("\n"); 
		query.append("( 1=1" ).append("\n"); 
		query.append("-- LANE/Bound" ).append("\n"); 
		query.append("AND SUBSTR(NVL(@[lane], 'XXX'), 1, 3)||NVL(@[bound], 'X') IN ('XXXX', NVL(TRNK_SLAN_CD, 'XXX')||NVL2(@[bound],TRNK_DIR_CD, 'X'), NVL(N1ST_TS_SLAN_CD, 'XXX')||NVL2(@[bound],N1ST_TS_DIR_CD, 'X'))" ).append("\n"); 
		query.append("#if(${subtrade} != '')" ).append("\n"); 
		query.append("--SubTrade가 있으면" ).append("\n"); 
		query.append("AND (SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append(" OR N1ST_TS_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                 , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                 , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                             WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                               AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                               AND B.SUB_TRD_CD = @[subtrade])" ).append("\n"); 
		query.append(" OR TRNK_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                 , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                 , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                             WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                               AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                               AND B.SUB_TRD_CD = @[subtrade])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("--SubTrade가 없고, Trade가 있으면" ).append("\n"); 
		query.append("AND (SUB_TRD_CD IN (SELECT DISTINCT B.SUB_TRD_CD" ).append("\n"); 
		query.append("                      FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                         , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                         , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                     WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                       AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                       AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                       AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                       AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                       AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                       AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                       AND B.TRD_CD = @[trade])" ).append("\n"); 
		query.append(" OR N1ST_TS_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                 , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                 , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                             WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                               AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                               AND B.TRD_CD = @[trade])" ).append("\n"); 
		query.append(" OR TRNK_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                 , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                 , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                             WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                               AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                               AND B.TRD_CD = @[trade])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append("ORDER BY BKG_ALOC_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WITH BASIC_DATA AS (" ).append("\n"); 
		query.append("SELECT BKG_ALOC_SEQ" ).append("\n"); 
		query.append("    , BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("    , TRNK_SLAN_CD" ).append("\n"); 
		query.append("    , TRNK_DIR_CD" ).append("\n"); 
		query.append("    , VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append("    , SLS_RHQ_CD" ).append("\n"); 
		query.append("    , OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POR' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_POR_CNT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POR' AND LENGTH(BAMD.SB_LOC_CD) = 5) POR_CD" ).append("\n"); 
		query.append("    , POR_NOD_CD" ).append("\n"); 
		query.append("    , BKG_POR_SCC_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POL' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_POL_CNT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POL' AND LENGTH(BAMD.SB_LOC_CD) = 5) POL_CD" ).append("\n"); 
		query.append("    , POL_NOD_CD" ).append("\n"); 
		query.append("    , N1ST_TS_SLAN_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(BAMD.SB_LOC_CD) = 5) N1ST_TS_POL_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(BAMD.SB_LOC_CD) = 5) N1ST_TS_POD_CD" ).append("\n"); 
		query.append("    , N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(BAMD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(BAMD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SAY') TS_NOD_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SLY') TS_POL_NOD_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD" ).append("\n"); 
		query.append("    , N2ND_TS_SLAN_CD" ).append("\n"); 
		query.append("    , N2ND_TS_POL_CD" ).append("\n"); 
		query.append("    , N2ND_TS_POD_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POD' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_POD_CNT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'POD' AND LENGTH(BAMD.SB_LOC_CD) = 5) POD_CD" ).append("\n"); 
		query.append("    , POD_NOD_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(BAMD.SB_LOC_CD) = 2) BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(BAMD.SB_LOC_CD) = 5) DEL_CD" ).append("\n"); 
		query.append("    , DEL_NOD_CD" ).append("\n"); 
		query.append("    , BKG_DEL_SCC_CD" ).append("\n"); 
		query.append("    , SC_NO" ).append("\n"); 
		query.append("    , RFA_NO" ).append("\n"); 
		query.append("    , CTRT_CUST_CNT_CD||TRIM(TO_CHAR(CTRT_CUST_SEQ,'000000')) CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , CUST_CNT_CD||TRIM(TO_CHAR(CUST_SEQ,'000000')) CUST_CNT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(Z.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL Z WHERE Z.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    --, CMDT_CD" ).append("\n"); 
		query.append("    --, (SELECT CMDT_NM FROM MDM_COMMODITY MDM WHERE BAM.CMDT_CD = MDM.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ) CMDT_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(MDM.CMDT_NM) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT, MDM_COMMODITY MDM WHERE CMDT.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND TRIM(TO_CHAR(CMDT.CMDT_CD,'000000')) = MDM.CMDT_CD) CMDT_NM" ).append("\n"); 
		query.append("    , TO_CHAR(SCG_GRP_CMDT_SEQ,'00') SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    , (SELECT PSGC.SCG_GRP_CMDT_DESC FROM PRI_SCG_GRP_CMDT PSGC WHERE PSGC.SVC_SCP_CD = 'TPW' AND PSGC.CHG_CD = 'GRI' AND PSGC.SCG_GRP_CMDT_SEQ = BAM.SCG_GRP_CMDT_SEQ AND ROWNUM = 1) SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("    , ALOC_LOD_QTY" ).append("\n"); 
		query.append("    , ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("    , ASGN_TTL_WGT" ).append("\n"); 
		query.append("    , ASGN_WGT_RTO" ).append("\n"); 
		query.append("    , ALOC_SVC_CD" ).append("\n"); 
		query.append("    , BKG_ALOC_RMK" ).append("\n"); 
		query.append("    , ALOC_USE_FLG" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' AND LENGTH(BAMD.SB_LOC_CD) = 5) TRUNK_POL_CD" ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' AND LENGTH(BAMD.SB_LOC_CD) = 5) TRUNK_POD_CD" ).append("\n"); 
		query.append("    , CMPB_AMT" ).append("\n"); 
		query.append("    , BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("    , DCGO_FLG" ).append("\n"); 
		query.append("    , RD_CGO_FLG" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    , (SELECT WM_CONCAT(CUST.CUST_CNT_CD||LPAD(CUST.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL CUST WHERE CUST.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND CUST.BKG_CUST_TP_CD = 'B' ) AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("    , ALOC_APLY_FM_DT" ).append("\n"); 
		query.append("    , ALOC_APLY_TO_DT" ).append("\n"); 
		query.append("    , SUB_TRD_CD" ).append("\n"); 
		query.append("    --, CMPB_RULE_CD" ).append("\n"); 
		query.append("    , DECODE(DCGO_FLG, 'Y', 'dg', DECODE (RD_CGO_FLG, 'Y', 'rd', '') ) AS DG_RD" ).append("\n"); 
		query.append("    , OFT_CHG_AMT" ).append("\n"); 
		query.append("    , USA_BKG_MOD_CD" ).append("\n"); 
		query.append("    , HUL_BND_CD" ).append("\n"); 
		query.append("    , APLY_FM_YRWK" ).append("\n"); 
		query.append("    , APLY_TO_YRWK" ).append("\n"); 
		query.append("    , CMPB_ONY_FLG" ).append("\n"); 
		query.append("    , RVIS_CNTR_CUST_TP_CD AS ACCT_TP" ).append("\n"); 
		query.append("    , CTRT_CUST_CNT_CD AS CTRT_CUST_CNT_CD1" ).append("\n"); 
		query.append("    , CUST_CNT_CD AS CUST_CNT_CD1" ).append("\n"); 
		query.append("    , CTRT_CUST_SEQ" ).append("\n"); 
		query.append("    , CUST_SEQ" ).append("\n"); 
		query.append("	, OP_CNTR_QTY" ).append("\n"); 
		query.append("    , OP_CNTR_QTY_RTO" ).append("\n"); 
		query.append("    , CUST_GRP_ID" ).append("\n"); 
		query.append("	, RFA_CTRT_TP_CD	" ).append("\n"); 
		query.append("    , CMPB_PER_TON_AMT" ).append("\n"); 
		query.append("    , TON_PER_TEU_WGT" ).append("\n"); 
		query.append("	-- 20170629 로켓배송-stowage 추가(송민석)" ).append("\n"); 
		query.append(" , (SELECT WM_CONCAT(BAMD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'STW' ) STWG_CD" ).append("\n"); 
		query.append("FROM SPC_BKG_ALOC_MGMT BAM" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SLS_RHQ_CD IN ('SHARC', 'SINRS')" ).append("\n"); 
		query.append("#if(${bkg_aloc_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("AND BKG_ALOC_TP_CD = @[bkg_aloc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ((SUB_TRD_CD IS NULL AND TRNK_SLAN_CD IS NULL AND N1ST_TS_SLAN_CD IS NULL) OR" ).append("\n"); 
		query.append("( 1=1" ).append("\n"); 
		query.append("-- LANE/Bound" ).append("\n"); 
		query.append("AND SUBSTR(NVL(@[lane], 'XXX'), 1, 3)||NVL(@[bound], 'X') IN ('XXXX', NVL(TRNK_SLAN_CD, 'XXX')||NVL2(@[bound],TRNK_DIR_CD, 'X'), NVL(N1ST_TS_SLAN_CD, 'XXX')||NVL2(@[bound],N1ST_TS_DIR_CD, 'X'))" ).append("\n"); 
		query.append("#if(${subtrade} != '')" ).append("\n"); 
		query.append("--SubTrade가 있으면" ).append("\n"); 
		query.append("AND (SUB_TRD_CD = @[subtrade]" ).append("\n"); 
		query.append(" OR N1ST_TS_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                 , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                 , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                             WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                               AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                               AND B.SUB_TRD_CD = @[subtrade])" ).append("\n"); 
		query.append(" OR TRNK_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                              FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                 , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                 , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                             WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                               AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                               AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                               AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                               AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                               AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                               AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                               AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                               AND B.SUB_TRD_CD = @[subtrade])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if(${trade} != '')" ).append("\n"); 
		query.append("  --SubTrade가 없고, Trade가 있으면" ).append("\n"); 
		query.append("  AND (SUB_TRD_CD IN (SELECT DISTINCT B.SUB_TRD_CD" ).append("\n"); 
		query.append("                        FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                           , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                           , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                       WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                         AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                         AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                         AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                         AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                         AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                         AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                         AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                         AND B.TRD_CD = @[trade])" ).append("\n"); 
		query.append("   OR N1ST_TS_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                                FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                   , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                   , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                               WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                                 AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                                 AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                                 AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                 AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                                 AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                 AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                                 AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                                 AND B.TRD_CD = @[trade])" ).append("\n"); 
		query.append("   OR TRNK_SLAN_CD IN (SELECT DISTINCT SUBSTR(B.RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("                                FROM MDM_REV_LANE A" ).append("\n"); 
		query.append("                                   , MDM_DTL_REV_LANE B" ).append("\n"); 
		query.append("                                   , MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("                               WHERE A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                                 AND A.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("                                 AND A.REP_TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("                                 AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                 AND B.TRD_CD <> 'COM'" ).append("\n"); 
		query.append("                                 AND A.VSL_SLAN_CD = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                 AND DECODE(C.VSL_SVC_TP_CD, 'I', C.CO_CD, '1') = DECODE(C.VSL_SVC_TP_CD, 'I', 'H', '1')" ).append("\n"); 
		query.append("                                 AND C.VSL_SVC_TP_CD <> 'O'" ).append("\n"); 
		query.append("                                 AND B.TRD_CD = @[trade])" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SH.BKG_ALOC_SEQ SHAAS_SEQ" ).append("\n"); 
		query.append("    , SW.BKG_ALOC_SEQ SINWA_SEQ" ).append("\n"); 
		query.append("    , DECODE(COPY.RN, 1, SH.BKG_ALOC_SEQ, 2, SW.BKG_ALOC_SEQ) BKG_ALOC_SEQ" ).append("\n"); 
		query.append("    , SH.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("    , DECODE(COPY.RN, 1, SH.SLS_RHQ_CD, 2, SW.SLS_RHQ_CD) SLS_RHQ_CD" ).append("\n"); 
		query.append("    , SH.TRUNK_POL_CD" ).append("\n"); 
		query.append("    , SH.TRUNK_POD_CD" ).append("\n"); 
		query.append("    , SH.TRNK_SLAN_CD" ).append("\n"); 
		query.append("    , SH.TRNK_DIR_CD" ).append("\n"); 
		query.append("    , SH.VVD" ).append("\n"); 
		query.append("    , SH.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("    , SH.BKG_POR_CNT_CD" ).append("\n"); 
		query.append("    , SH.POR_CD" ).append("\n"); 
		query.append("    , SH.POR_NOD_CD" ).append("\n"); 
		query.append("    , SH.BKG_POR_SCC_CD" ).append("\n"); 
		query.append("    , SH.BKG_POL_CNT_CD" ).append("\n"); 
		query.append("    , SH.POL_CD" ).append("\n"); 
		query.append("    , SH.POL_NOD_CD" ).append("\n"); 
		query.append("    , SH.N1ST_TS_SLAN_CD " ).append("\n"); 
		query.append("    , SH.TS_NOD_CD" ).append("\n"); 
		query.append("    , SH.TS_POL_NOD_CD" ).append("\n"); 
		query.append("    , SH.TS_POD_NOD_CD    " ).append("\n"); 
		query.append("    , SH.N1ST_TS_POL_CD" ).append("\n"); 
		query.append("    , SH.N1ST_TS_POD_CD" ).append("\n"); 
		query.append("    , SH.N1ST_TS_DIR_CD" ).append("\n"); 
		query.append("    , SH.N1ST_TS_POL_CNT_CD" ).append("\n"); 
		query.append("    , SH.N1ST_TS_POD_CNT_CD" ).append("\n"); 
		query.append("    , SH.N2ND_TS_SLAN_CD" ).append("\n"); 
		query.append("    , SH.N2ND_TS_POL_CD" ).append("\n"); 
		query.append("    , SH.N2ND_TS_POD_CD" ).append("\n"); 
		query.append("    , SH.BKG_POD_CNT_CD" ).append("\n"); 
		query.append("    , SH.POD_CD" ).append("\n"); 
		query.append("    , SH.POD_NOD_CD" ).append("\n"); 
		query.append("    , SH.BKG_DEL_CNT_CD" ).append("\n"); 
		query.append("    , SH.DEL_CD" ).append("\n"); 
		query.append("    , SH.DEL_NOD_CD" ).append("\n"); 
		query.append("    , SH.BKG_DEL_SCC_CD" ).append("\n"); 
		query.append("    , SH.SC_NO" ).append("\n"); 
		query.append("    , SH.RFA_NO" ).append("\n"); 
		query.append("    , SH.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("    , SH.CUST_CNT_CD" ).append("\n"); 
		query.append("    , SH.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    , SH.CMDT_CD" ).append("\n"); 
		query.append("    , SH.CMDT_NM" ).append("\n"); 
		query.append("    , SH.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("    , SH.SCG_GRP_CMDT_DESC" ).append("\n"); 
		query.append("    , SH.ALOC_LOD_QTY, SH.ALOC_LOD_QTY OLD_ALOC_LOD_QTY" ).append("\n"); 
		query.append("    , SH.ALOC_LOD_QTY_RTO, SH.ALOC_LOD_QTY_RTO OLD_ALOC_LOD_QTY_RTO" ).append("\n"); 
		query.append("    , SH.ASGN_TTL_WGT , SH.ASGN_TTL_WGT OLD_ASGN_TTL_WGT" ).append("\n"); 
		query.append("    , SH.ASGN_WGT_RTO, SH.ASGN_WGT_RTO OLD_AASGN_WGT_RTO" ).append("\n"); 
		query.append("    , SH.ALOC_SVC_CD" ).append("\n"); 
		query.append("    , SH.BKG_ALOC_RMK" ).append("\n"); 
		query.append("    , SH.ALOC_USE_FLG" ).append("\n"); 
		query.append("    , DECODE(COPY.RN, 1, SH.CRE_USR_ID, 2, SW.CRE_USR_ID) CRE_USR_ID" ).append("\n"); 
		query.append("    , DECODE(COPY.RN, 1, SH.CRE_DT, 2, SW.CRE_DT) CRE_DT" ).append("\n"); 
		query.append("    , DECODE(COPY.RN, 1, SH.UPD_USR_ID, 2, SW.UPD_USR_ID) UPD_USR_ID" ).append("\n"); 
		query.append("    , DECODE(COPY.RN, 1, SH.UPD_DT, 2, SW.UPD_DT) UPD_DT" ).append("\n"); 
		query.append("    , SH.CMPB_AMT, SH.CMPB_AMT" ).append("\n"); 
		query.append("    , SH.BKG_CTRL_TP_CD" ).append("\n"); 
		query.append("    , SH.DCGO_FLG" ).append("\n"); 
		query.append("    , SH.RD_CGO_FLG" ).append("\n"); 
		query.append("    , SH.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("    , SH.ALOC_APLY_FM_DT" ).append("\n"); 
		query.append("    , SH.ALOC_APLY_TO_DT" ).append("\n"); 
		query.append("    , SH.SUB_TRD_CD" ).append("\n"); 
		query.append("    --, SH.CMPB_RULE_CD" ).append("\n"); 
		query.append("    , SH.DG_RD" ).append("\n"); 
		query.append("    , SH.OFT_CHG_AMT, SH.OFT_CHG_AMT OLD_OFT_CHG_AMT" ).append("\n"); 
		query.append("    , SH.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("    , SH.HUL_BND_CD" ).append("\n"); 
		query.append("    , SH.APLY_FM_YRWK" ).append("\n"); 
		query.append("    , SH.APLY_TO_YRWK" ).append("\n"); 
		query.append("    , SH.CMPB_ONY_FLG" ).append("\n"); 
		query.append("    , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = SH.CTRT_CUST_CNT_CD1  AND  M.CUST_SEQ = SH.CTRT_CUST_SEQ ) AS CTRT_CUST_CNT_NM" ).append("\n"); 
		query.append("    , (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER M WHERE M.CUST_CNT_CD = SH.CUST_CNT_CD1  AND  M.CUST_SEQ = SH.CUST_SEQ ) AS CUST_CNT_NM" ).append("\n"); 
		query.append("    , (SELECT DISTINCT(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = PTY.CUST_CNT_CD AND CUST_SEQ = PTY.CUST_SEQ) AS SC_NM" ).append("\n"); 
		query.append("    FROM  PRI_SP_HDR HDR, PRI_SP_MN MN, PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("    AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("    AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("    AND PTY.PRC_CTRT_PTY_TP_CD  = 'C'" ).append("\n"); 
		query.append("    AND HDR.SC_NO =  SH.SC_NO  ) AS SC_NM" ).append("\n"); 
		query.append("    , (SELECT  DISTINCT(SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = CTRT_CUST_CNT_CD AND CUST_SEQ = CTRT_CUST_SEQ) AS RFA_NM" ).append("\n"); 
		query.append("    FROM PRI_RP_HDR HDR ,PRI_RP_MN MN" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("    AND HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("    AND HDR.RFA_NO = SH.RFA_NO ) AS RFA_NM" ).append("\n"); 
		query.append("    , SH.ACCT_TP" ).append("\n"); 
		query.append("    , SH.OP_CNTR_QTY" ).append("\n"); 
		query.append("    , SH.OP_CNTR_QTY_RTO" ).append("\n"); 
		query.append("    , SH.CUST_GRP_ID" ).append("\n"); 
		query.append("	,(SELECT CUST_GRP_NM from MDM_CUST_PERF_GRP z WHERE z.CUST_GRP_ID = SH.CUST_GRP_ID ) AS CUST_GRP_NM" ).append("\n"); 
		query.append("	,SH.RFA_CTRT_TP_CD	" ).append("\n"); 
		query.append("	,SH.CMPB_PER_TON_AMT AS CMPB_PER_WGT" ).append("\n"); 
		query.append("	,SH.TON_PER_TEU_WGT	AS WGT_PER_TEU" ).append("\n"); 
		query.append("	,SH.STWG_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    BASIC_DATA SH" ).append("\n"); 
		query.append("  , BASIC_DATA SW" ).append("\n"); 
		query.append("  , (SELECT ROWNUM AS RN FROM DUAL CONNECT BY ROWNUM <= 2) COPY" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    SH.SLS_RHQ_CD = 'SHARC'" ).append("\n"); 
		query.append("    AND SW.SLS_RHQ_CD = 'SINRS'" ).append("\n"); 
		query.append("    AND SH.BKG_ALOC_TP_CD = SW.BKG_ALOC_TP_CD" ).append("\n"); 
		query.append("    AND NVL(SH.TRNK_SLAN_CD, 'X')		= NVL(SW.TRNK_SLAN_CD, 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.TRNK_DIR_CD, 'X')		    = NVL(SW.TRNK_DIR_CD, 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.VVD, 'X')				    = NVL(SW.VVD, 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.OB_SLS_OFC_CD, 'X')		= NVL(SW.OB_SLS_OFC_CD, 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_POR_CNT_CD, 'X')		= NVL(SW.BKG_POR_CNT_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.POR_CD		, 'X')		= NVL(SW.POR_CD           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.POR_NOD_CD	, 'X')		= NVL(SW.POR_NOD_CD        , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_POR_SCC_CD, 'X')		= NVL(SW.BKG_POR_SCC_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_POL_CNT_CD, 'X')		= NVL(SW.BKG_POL_CNT_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.POL_CD		, 'X')		= NVL(SW.POL_CD           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.POL_NOD_CD	, 'X')		= NVL(SW.POL_NOD_CD        , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N1ST_TS_SLAN_CD, 'X')	    = NVL(SW.N1ST_TS_SLAN_CD   , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N1ST_TS_POL_CD, 'X')		= NVL(SW.N1ST_TS_POL_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N1ST_TS_POD_CD, 'X')		= NVL(SW.N1ST_TS_POD_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N1ST_TS_DIR_CD, 'X')		= NVL(SW.N1ST_TS_DIR_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N1ST_TS_POL_CNT_CD, 'X')	= NVL(SW.N1ST_TS_POL_CNT_CD, 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N1ST_TS_POD_CNT_CD, 'X')	= NVL(SW.N1ST_TS_POD_CNT_CD, 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N2ND_TS_SLAN_CD, 'X')	    = NVL(SW.N2ND_TS_SLAN_CD   , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N2ND_TS_POL_CD, 'X')		= NVL(SW.N2ND_TS_POL_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.N2ND_TS_POD_CD, 'X')		= NVL(SW.N2ND_TS_POD_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_POD_CNT_CD, 'X')		= NVL(SW.BKG_POD_CNT_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.POD_CD		, 'X')		= NVL(SW.POD_CD           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.POD_NOD_CD	, 'X')		= NVL(SW.POD_NOD_CD        , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_DEL_CNT_CD, 'X')		= NVL(SW.BKG_DEL_CNT_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.DEL_CD		, 'X')		= NVL(SW.DEL_CD           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.DEL_NOD_CD	, 'X')		= NVL(SW.DEL_NOD_CD        , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_DEL_SCC_CD, 'X')		= NVL(SW.BKG_DEL_SCC_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.SC_NO		, 'X')		    = NVL(SW.SC_NO            , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.RFA_NO		, 'X')		= NVL(SW.RFA_NO           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CTRT_CUST_CNT_CD, 'X')	= NVL(SW.CTRT_CUST_CNT_CD  , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CUST_CNT_CD	, 'X')		= NVL(SW.CUST_CNT_CD       , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CNTR_TPSZ_CD	, 'X')		= NVL(SW.CNTR_TPSZ_CD      , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CMDT_CD		, 'X')		= NVL(SW.CMDT_CD           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CMDT_NM		, 'X')		= NVL(SW.CMDT_NM           , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.SCG_GRP_CMDT_SEQ, 'X')	= NVL(SW.SCG_GRP_CMDT_SEQ  , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.SCG_GRP_CMDT_DESC, 'X')	= NVL(SW.SCG_GRP_CMDT_DESC , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.ALOC_LOD_QTY	, 0)		= NVL(SW.ALOC_LOD_QTY      , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.ALOC_LOD_QTY_RTO, 0)	    = NVL(SW.ALOC_LOD_QTY_RTO  , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.ASGN_TTL_WGT	, 0)		= NVL(SW.ASGN_TTL_WGT      , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.ASGN_WGT_RTO  , 0)	    = NVL(SW.ASGN_WGT_RTO      , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.ALOC_SVC_CD	, 'X')		= NVL(SW.ALOC_SVC_CD       , 'X')" ).append("\n"); 
		query.append("    --AND NVL(SH.BKG_ALOC_RMK	, 'X')		= NVL(SW.BKG_ALOC_RMK      , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.ALOC_USE_FLG	, 'X')		= NVL(SW.ALOC_USE_FLG      , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CMPB_AMT		, 0)		= NVL(SW.CMPB_AMT          , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.BKG_CTRL_TP_CD, 'X')		= NVL(SW.BKG_CTRL_TP_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.DCGO_FLG		, 'X')		= NVL(SW.DCGO_FLG          , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.RD_CGO_FLG	, 'X')		= NVL(SW.RD_CGO_FLG        , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.AGMT_ACT_CNT_CD, 'X')	    = NVL(SW.AGMT_ACT_CNT_CD   , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.ALOC_APLY_FM_DT, 'X')	    = NVL(SW.ALOC_APLY_FM_DT   , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.ALOC_APLY_TO_DT, 'X')	    = NVL(SW.ALOC_APLY_TO_DT   , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.SUB_TRD_CD	, 'X')		= NVL(SW.SUB_TRD_CD        , 'X')" ).append("\n"); 
		query.append("    --AND NVL(SH.CMPB_RULE_CD	, 'X')		= NVL(SW.CMPB_RULE_CD      , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.DG_RD		, 'X')		    = NVL(SW.DG_RD            , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.OFT_CHG_AMT	, 0)		= NVL(SW.OFT_CHG_AMT       , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.USA_BKG_MOD_CD, 'X')		= NVL(SW.USA_BKG_MOD_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.APLY_FM_YRWK, 'X')		= NVL(SW.APLY_FM_YRWK    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.APLY_TO_YRWK, 'X')		= NVL(SW.APLY_TO_YRWK    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.HUL_BND_CD, 'X')		    = NVL(SW.HUL_BND_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.ACCT_TP, 'X')		    = NVL(SW.ACCT_TP    , 'X')" ).append("\n"); 
		query.append("	AND NVL(SH.OP_CNTR_QTY, 0)		= NVL(SW.OP_CNTR_QTY    , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.OP_CNTR_QTY_RTO, 0)		= NVL(SW.OP_CNTR_QTY_RTO    , 0)" ).append("\n"); 
		query.append("	AND NVL(SH.CUST_GRP_ID, 0)		= NVL(SW.CUST_GRP_ID    , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.TS_NOD_CD, 'X')		= NVL(SW.TS_NOD_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.TS_POL_NOD_CD, 'X')		= NVL(SW.TS_POL_NOD_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.TS_POD_NOD_CD, 'X')		= NVL(SW.TS_POD_NOD_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.RFA_CTRT_TP_CD, 'X')		= NVL(SW.RFA_CTRT_TP_CD    , 'X')" ).append("\n"); 
		query.append("    AND NVL(SH.CMPB_PER_TON_AMT, 0)	= NVL(SW.CMPB_PER_TON_AMT    , 0)" ).append("\n"); 
		query.append("    AND NVL(SH.TON_PER_TEU_WGT, 0)	= NVL(SW.TON_PER_TEU_WGT    , 0)" ).append("\n"); 
		query.append("ORDER BY SH.BKG_ALOC_SEQ, COPY.RN" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}