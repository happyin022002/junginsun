/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SpaceAllocationManageDBDAOSearchInqByCondition0049ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.06
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.06 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchInqByCondition0049ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --2014.08 이전 주석 쿼리안으로
	  * 2015.02.25 박은주 [CHM-201534464] Allocation by HO/Main office T/S 부킹의 SMP 그룹인지 요청 : T/S의 경우 SMP에서 관리되지 않는데 Trade가 누락되어 Ocean 정보를 읽어 물량이 누락되는 현상이 발생,  Trade정보를 걸어줌
	  * 2015.03.09 [CHM-201534504]SMP IAS 보완에 따른 FCST 추가 개발 요청 -->0021번화면에 대한 예외처리 오류 수정
	  * 2015.07.06 [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결)
	  * 2015.07.15 [CHM-201537094]MAS CMB 산출 로직 변경 적용
	  * 2015.08.05 [CHM-201537473]Control by HO의 T/S화물 부킹 팝업 수정 요청
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchInqByCondition0049ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchInqByCondition0049ListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("      ,(SELECT B.ALOC_STS_CD FROM BKG_BOOKING B WHERE B.BKG_NO = AA.BKG_NO) ALOC_STS_CD" ).append("\n"); 
		query.append("      ,SC_NO AS SC_NO" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(RFA_NO,1,1),'1',SUBSTR(RFA_NO,2),RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("      ,SC_CUST_NM AS SC_CUST_NM" ).append("\n"); 
		query.append("      ,BKG_SHPR_NM AS BKG_SHPR_NM" ).append("\n"); 
		query.append("      ,BKG_CGO_WGT AS BKG_CGO_WGT" ).append("\n"); 
		query.append("      ,VGM_WGT" ).append("\n"); 
		query.append("#foreach(${keys} IN ${keyList1})" ).append("\n"); 
		query.append("    #if (${keys} == 'obrd_dt' || ${keys} == 'cntr_rcv_dt')" ).append("\n"); 
		query.append("      ,TO_CHAR($keys,'YYYY-MM-DD') AS $keys" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("      ,$keys AS $keys" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,TPSZ_CODE                                                   AS TPSZ_CODE" ).append("\n"); 
		query.append("      ,SUM(LOAD)                                                   AS LOAD" ).append("\n"); 
		query.append("      ,SUM(BKG_REV)                                                AS REV" ).append("\n"); 
		query.append("      ,SUM(DEM_DET)                                                AS DMDT --dem/det추가" ).append("\n"); 
		query.append("      ,SUM(CM_COST)                                                AS CMC" ).append("\n"); 
		query.append("      ,SUM(BKG_REV+MISC_REV+DEM_DET)-SUM(CM_COST)                  AS CM --dem/det추가" ).append("\n"); 
		query.append("      ,SUM(OP_COST + DEM_DET)                                      AS OPC" ).append("\n"); 
		query.append("      ,SUM(BKG_REV+MISC_REV)-SUM(CM_COST)-SUM(OP_COST)             AS OP" ).append("\n"); 
		query.append("      ,SUM(BKG_REV)/SUM(LOAD)                                      AS G_RPB" ).append("\n"); 
		query.append("      ,SUM(CM_COST)                                                AS CM_COST" ).append("\n"); 
		query.append("      ,SUM(CM_COST)/SUM(LOAD)                                      AS CMCOST" ).append("\n"); 
		query.append("      ,(SUM(BKG_REV+MISC_REV+DEM_DET)-SUM(CM_COST))/SUM(LOAD)      AS CMB --dem/det추가" ).append("\n"); 
		query.append("      ,(SELECT MAX(RV.CMPB_AMT) KEEP (DENSE_RANK LAST ORDER BY RV.REV_COST_SEQ) FROM BKG_REV_COST RV WHERE RV.BKG_NO = AA.BKG_NO) AS B_CMPB" ).append("\n"); 
		query.append("      ,SUM(OP_COST+ DEM_DET)                                       AS OP_COST" ).append("\n"); 
		query.append("      ,SUM(OP_COST+ DEM_DET)/SUM(LOAD)                             AS OPCOST" ).append("\n"); 
		query.append("      ,(SUM(BKG_REV+MISC_REV)-SUM(CM_COST)-SUM(OP_COST))/SUM(LOAD) AS OPB" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DUMMY_COLUMN" ).append("\n"); 
		query.append("               ,CHG_BKG_NO" ).append("\n"); 
		query.append("               ,BKG_NO" ).append("\n"); 
		query.append("               ,SC_NO" ).append("\n"); 
		query.append("               ,SHPR_CNT_CD1" ).append("\n"); 
		query.append("               ,SHPR_CUST_SEQ1" ).append("\n"); 
		query.append("               ,BKG_POL_CD1" ).append("\n"); 
		query.append("               ,BKG_POD_CD1" ).append("\n"); 
		query.append("               ,AGMT_CNT_CD1" ).append("\n"); 
		query.append("               ,AGMT_CUST_SEQ1" ).append("\n"); 
		query.append("               ,SEASON" ).append("\n"); 
		query.append("               ,CASE WHEN TRD_CD1 = 'AES' AND RFA_NO IS NULL AND SHPR_CNT_CD1 = 'CN' AND SC_NO IS NULL THEN" ).append("\n"); 
		query.append("                     '1'||SPC_GET_SMP_RFA_FNC('R',SEASON,  SHPR_CNT_CD1||LPAD(SHPR_CUST_SEQ1,6,'0'), BKG_POL_CD1,BKG_POD_CD1)" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                     RFA_NO" ).append("\n"); 
		query.append("                END AS RFA_NO" ).append("\n"); 
		query.append("               ,SC_CUST_NM" ).append("\n"); 
		query.append("               ,BKG_SHPR_NM" ).append("\n"); 
		query.append("               ,BKG_CGO_WGT" ).append("\n"); 
		query.append("               ,VGM_WGT" ).append("\n"); 
		query.append("               ,TPSZ_CODE" ).append("\n"); 
		query.append("#foreach(${keys} IN ${keyList5})" ).append("\n"); 
		query.append("              ,$keys AS $keys" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,LOAD" ).append("\n"); 
		query.append("              ,BKG_REV" ).append("\n"); 
		query.append("              ,MISC_REV" ).append("\n"); 
		query.append("              ,CM_COST" ).append("\n"); 
		query.append("              ,OP_COST" ).append("\n"); 
		query.append("              ,DEM_DET" ).append("\n"); 
		query.append("              ,CHARGE_LOAD" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT DUMMY_COLUMN" ).append("\n"); 
		query.append("                       ,CHG_BKG_NO" ).append("\n"); 
		query.append("                       ,BKG_NO" ).append("\n"); 
		query.append("                       ,SC_NO" ).append("\n"); 
		query.append("                       ,SHPR_CNT_CD1" ).append("\n"); 
		query.append("                       ,SHPR_CUST_SEQ1" ).append("\n"); 
		query.append("                       ,BKG_POL_CD1" ).append("\n"); 
		query.append("                       ,BKG_POD_CD1" ).append("\n"); 
		query.append("                       ,AGMT_CNT_CD1" ).append("\n"); 
		query.append("                       ,AGMT_CUST_SEQ1" ).append("\n"); 
		query.append("                       ,SEASON" ).append("\n"); 
		query.append("                       ,SPC_GET_SMP_AMEND_FNC(TRD_CD1, SUBSTR(SEASON,1,6), SUBSTR(SEASON,8), RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("                       ,SC_CUST_NM" ).append("\n"); 
		query.append("                       ,BKG_SHPR_NM" ).append("\n"); 
		query.append("                       ,BKG_CGO_WGT" ).append("\n"); 
		query.append("                       ,VGM_WGT " ).append("\n"); 
		query.append("                       ,TPSZ_CODE" ).append("\n"); 
		query.append("#foreach(${keys} IN ${keyList6})" ).append("\n"); 
		query.append("                       ,$keys AS $keys" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      ,LOAD" ).append("\n"); 
		query.append("                      ,BKG_REV" ).append("\n"); 
		query.append("                      ,MISC_REV" ).append("\n"); 
		query.append("                      ,CM_COST" ).append("\n"); 
		query.append("                      ,OP_COST" ).append("\n"); 
		query.append("                      ,DEM_DET" ).append("\n"); 
		query.append("                      ,CHARGE_LOAD" ).append("\n"); 
		query.append("                      ,TRD_CD1" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                        SELECT 'dummy'  DUMMY_COLUMN" ).append("\n"); 
		query.append("                              ,D.BKG_NO AS CHG_BKG_NO" ).append("\n"); 
		query.append("                              ,D.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("                              ,D.SC_NO  AS SC_NO" ).append("\n"); 
		query.append("                              ,DECODE(UPPER(SUBSTR(D.RFA_NO,1,3)), 'DUM', '', D.RFA_NO) AS RFA_NO" ).append("\n"); 
		query.append("                              ,D.TRD_CD         AS TRD_CD1" ).append("\n"); 
		query.append("                              ,D.SHPR_CNT_CD    AS SHPR_CNT_CD1" ).append("\n"); 
		query.append("                              ,D.SHPR_CUST_SEQ  AS SHPR_CUST_SEQ1" ).append("\n"); 
		query.append("                              ,D.BKG_POL_CD     AS BKG_POL_CD1" ).append("\n"); 
		query.append("                              ,D.BKG_POD_CD     AS BKG_POD_CD1" ).append("\n"); 
		query.append("                              ,D.AGMT_CNT_CD    AS AGMT_CNT_CD1" ).append("\n"); 
		query.append("                              ,D.AGMT_CUST_SEQ  AS AGMT_CUST_SEQ1" ).append("\n"); 
		query.append("                              ,(SELECT /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */" ).append("\n"); 
		query.append("                                       COST_YRWK ||'-'||VER_SEQ" ).append("\n"); 
		query.append("                                 FROM SPC_MDL_VER_MST M" ).append("\n"); 
		query.append("                                WHERE TRD_CD  = D.TRD_CD" ).append("\n"); 
		query.append("                                  AND SUBSTR(D.SLS_YRMON, 1, 4)||D.COST_WK BETWEEN VER_ST_YRWK AND VER_END_YRWK" ).append("\n"); 
		query.append("                                  AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                                  AND ROWNUM  = 1" ).append("\n"); 
		query.append("                               ) AS SEASON" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER B1" ).append("\n"); 
		query.append("                                 WHERE D.AGMT_CNT_CD   = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                   AND D.AGMT_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("                               )                                          AS SC_CUST_NM" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER B1" ).append("\n"); 
		query.append("                                 WHERE D.SHPR_CNT_CD   = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                   AND D.SHPR_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("                               )                                          AS BKG_SHPR_NM" ).append("\n"); 
		query.append("                              ,D.BKG_CGO_WGT                              AS BKG_CGO_WGT" ).append("\n"); 
		query.append("                              ,(SELECT SUM(NVL(VGM_WGT,0)) FROM BKG_CONTAINER B1 WHERE D.BKG_NO   = B1.BKG_NO(+))  AS VGM_WGT" ).append("\n"); 
		query.append("                              ,D.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("#foreach(${keys} IN ${keyList2})" ).append("\n"); 
		query.append("    #if (${keys} == 'rep_cmdt_desc')" ).append("\n"); 
		query.append("                              ,F.rep_cmdt_desc AS rep_cmdt_desc" ).append("\n"); 
		query.append("    #set($cmdt_desc_flg = 'TRUE')" ).append("\n"); 
		query.append("    #elseif (${keys} == 'shpr_nm')" ).append("\n"); 
		query.append("                              ,D.SHPR_NM                                          AS SHPR_NM" ).append("\n"); 
		query.append("    #set($bl_shpr_flg = 'TRUE')" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bkg_no')" ).append("\n"); 
		query.append("                              ,D.BKG_NO                                                                           AS BKG_NO" ).append("\n"); 
		query.append("    #elseif (${keys} == 'rev_vvd')" ).append("\n"); 
		query.append("                              ,D.VSL_CD||D.SKD_VOY_NO||D.DIR_CD                                                   AS REV_VVD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bl_no')" ).append("\n"); 
		query.append("                              ,DECODE(SUBSTR(D.BL_NO, 1, 4), 'KOSA', 'K' || D.BKG_NO, D.BL_NO || D.BL_NO_TP || D.BL_NO_CHK) BL_NO" ).append("\n"); 
		query.append("    #elseif (${keys} == 'slan_cd')" ).append("\n"); 
		query.append("                              ,D.SLAN_CD                                                                          AS SLAN_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'soc_flg' || ${keys} == 'spcl_dg_cgo_flg' || ${keys} == 'spcl_bb_cgo_flg' || ${keys} == 'spcl_awk_cgo_flg')" ).append("\n"); 
		query.append("                              ,NVL(D.$keys, 'N') AS $keys" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bkg_cgo_tp_cd_r')" ).append("\n"); 
		query.append("                              ,DECODE(D.BKG_CGO_TP_CD, 'R', 'Y', 'N')                                             AS BKG_CGO_TP_CD_R" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bkg_cgo_wgt')" ).append("\n"); 
		query.append("                              ,D.BKG_CGO_WGT                                                                      AS BKG_CGO_WGT" ).append("\n"); 
		query.append("    #elseif (${keys} == 'sc_cust_cd')" ).append("\n"); 
		query.append("                              ,D.AGMT_CNT_CD || TO_CHAR(lpad(DECODE(D.AGMT_CUST_SEQ,0,'',D.AGMT_CUST_SEQ),6,'0')) AS SC_CUST_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'cmdt_desc')" ).append("\n"); 
		query.append("                              ,K.CMDT_NM                                                                          AS CMDT_DESC" ).append("\n"); 
		query.append("    #elseif (${keys} == 'sc_cust_nm')" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER B1" ).append("\n"); 
		query.append("                                 WHERE D.AGMT_CNT_CD   = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                   AND D.AGMT_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("                               )                                          AS SC_CUST_NM" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bkg_shpr_cd')" ).append("\n"); 
		query.append("                              ,D.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(D.SHPR_CUST_SEQ,0,'',D.SHPR_CUST_SEQ),6,'0')) AS BKG_SHPR_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bkg_shpr_nm')" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER B1" ).append("\n"); 
		query.append("                                 WHERE D.SHPR_CNT_CD   = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                   AND D.SHPR_CUST_SEQ = B1.CUST_SEQ(+)" ).append("\n"); 
		query.append("                               )                                          AS BKG_SHPR_NM" ).append("\n"); 
		query.append("    #elseif (${keys} == 'cnee_cd')" ).append("\n"); 
		query.append("                              ,D.CNEE_CNT_CD || TO_CHAR(LPAD(DECODE(D.CNEE_CUST_SEQ,0,'',D.CNEE_CUST_SEQ),6,'0')) AS CNEE_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'cnee_nm')" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER B1" ).append("\n"); 
		query.append("                                 WHERE D.CNEE_CNT_CD   = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                   AND D.CNEE_CUST_SEQ = B1.CUST_SEQ(+))                                          AS CNEE_NM" ).append("\n"); 
		query.append("    #elseif (${keys} == 'ntfy_cd')" ).append("\n"); 
		query.append("                              ,D.NTFY_CNT_CD || TO_CHAR(LPAD(DECODE(D.NTFY_CUST_SEQ,0,'',D.NTFY_CUST_SEQ),6,'0')) AS NTFY_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'ntfy_nm')" ).append("\n"); 
		query.append("                              ,(SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER B1" ).append("\n"); 
		query.append("                                 WHERE D.NTFY_CNT_CD   = B1.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                   AND D.NTFY_CUST_SEQ = B1.CUST_SEQ(+))                                          AS NTFY_NM" ).append("\n"); 
		query.append("    #elseif (${keys} == 'shpr_cd')" ).append("\n"); 
		query.append("                              ,D.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(D.SHPR_CUST_SEQ,0,'',D.SHPR_CUST_SEQ),6,'0')) AS SHPR_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'bl_shpr_cd')" ).append("\n"); 
		query.append("                              ,D.SHPR_CNT_CD || TO_CHAR(LPAD(DECODE(D.SHPR_CUST_SEQ,0,'',D.SHPR_CUST_SEQ),6,'0')) AS BL_SHPR_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'agmt_act_cust_cd')" ).append("\n"); 
		query.append("                              ,D.AGMT_ACT_CNT_CD||TO_CHAR(D.AGMT_ACT_CUST_SEQ, 'FM000000') AS AGMT_ACT_CUST_CD" ).append("\n"); 
		query.append("    #elseif (${keys} == 'mty_pkup_yd_cd' || ${keys} == 'bkg_por_scc_cd' || ${keys} == 'bkg_del_scc_cd' || ${keys} == 'ias_rgn_cd' || ${keys} == 'hul_bnd_cd' || ${keys} == 'bkg_por_ecc_cd'" ).append("\n"); 
		query.append("          || ${keys} == 'bkg_del_ecc_cd' || ${keys} == 'bkg_por_lcc_cd' || ${keys} == 'bkg_del_lcc_cd' || ${keys} == 'bkg_por_rcc_cd' || ${keys} == 'bkg_del_rcc_cd' || ${keys} == 'ofc_team_cd'" ).append("\n"); 
		query.append("           || ${keys} == 'rhq_cd_team'|| ${keys} == 'n5th_trd_cd' || ${keys} == 'n5th_rlane_cd' || ${keys} == 'n5th_finc_vvd_cd' || ${keys} == 'n5th_pol_cd' || ${keys} == 'n5th_pod_cd' " ).append("\n"); 
		query.append("           || ${keys} == 'rfa_ctrt_tp_cd'|| ${keys} == 'fixed_rate_flag'|| ${keys} == 'rert_dt'|| ${keys} == 'ra_dt'|| ${keys} == 'act_feu'|| ${keys} == 'act_teu' " ).append("\n"); 
		query.append("           || ${keys} == 'bkg_cre_dt' || ${keys} == 'cfm_dt' || ${keys} == 'spc_bkg_sts_cd' || ${keys} == 'cmpb_amt'|| ${keys} == 'mst_rfa_rout_id'|| ${keys} == 'l_sls_ofc_cd'" ).append("\n"); 
		query.append("           || ${keys} == 'pol_etb1'|| ${keys} == 'pol_etb2'|| ${keys} == 'pol_etb3' || ${keys} == 'pol_etb4'|| ${keys} == 'pol_etb5'" ).append("\n"); 
		query.append("           || ${keys} == 'pod_etb1'|| ${keys} == 'pod_etb2'|| ${keys} == 'pod_etb3' || ${keys} == 'pod_etb4'|| ${keys} == 'pod_etb5'" ).append("\n"); 
		query.append("           || ${keys} == 'rt_dt')   " ).append("\n"); 
		query.append("                              ,NULL AS $keys" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("    #elseif (${keys} == 'stwg_cd')" ).append("\n"); 
		query.append("                              ,(SELECT stwg_cd" ).append("\n"); 
		query.append("                                  FROM BKG_BOOKING B1" ).append("\n"); 
		query.append("                                 WHERE D.BKG_NO   = B1.BKG_NO" ).append("\n"); 
		query.append("                                   )                                          AS stwg_cd" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                              ,D.$keys AS $keys" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             ,DECODE('${tpsz_sts}', 'BOX', D.SPCL_CNTR_TPSZ_CD, 'TEU','')                                          AS TPSZ_CODE" ).append("\n"); 
		query.append("                             ,DECODE('${tpsz_sts}', 'BOX', NVL(D.BKG_QTY,0), 'TEU', DECODE(SPC_GET_CNTR_SZ_FNC(D.SPCL_CNTR_TPSZ_CD), '2', 1, 2) * D.BKG_QTY) AS LOAD" ).append("\n"); 
		query.append("                             ,NVL(D.BKG_REV,0)+NVL(D.BKG_OFT_REV,0)                                                              AS BKG_REV" ).append("\n"); 
		query.append("                             ,NVL(D.BKG_MISC_REV,0)+NVL(D.SCR_CHG_REV,0)                                                         AS MISC_REV" ).append("\n"); 
		query.append("                             ,DECODE('${pro_vw}', 'P', NVL(D.PA_CM_COST_TTL_AMT, 0)   , 'R', NVL(D.RA_CM_COST_TTL_AMT, 0))    AS CM_COST" ).append("\n"); 
		query.append("                             ,DECODE('${pro_vw}', 'P', 0, 'R', NVL(D.RA_OP_COST_TTL_AMT, 0))                                  AS OP_COST" ).append("\n"); 
		query.append("                             ,NVL(D.DMDT_COM_AMT,0)                                                                                     AS DEM_DET" ).append("\n"); 
		query.append("                             ,NVL(D.BKG_QTY, 0) AS CHARGE_LOAD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                             MAS_BKG_EXPN_DTL_WK D" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                             ,BKG_VVD BV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             ,SPC_OFC_LVL L" ).append("\n"); 
		query.append("                             ,MDM_COMMODITY    K" ).append("\n"); 
		query.append("                             ,(SELECT REP_CMDT_CD AS REP_CMDT_CD" ).append("\n"); 
		query.append("                                    , REP_CMDT_NM AS REP_CMDT_DESC" ).append("\n"); 
		query.append("                                 FROM MDM_REP_CMDT" ).append("\n"); 
		query.append("                                WHERE NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                              ) F" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                        AND D.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${call_ui} == 'ESM_SPC_0021' && ${vsl_cd} == '' && ${year} != '' && ${fm_wk} != '')" ).append("\n"); 
		query.append("                        AND SUBSTR(D.SLS_YRMON,1,4)||D.COST_WK = '${year}'||'${fm_wk}'" ).append("\n"); 
		query.append("                        AND '${year}'||'${fm_wk}' BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("#elseif(${vsl_cd} == '' && ${year} != '' && ${fm_wk} != '')" ).append("\n"); 
		query.append("                        AND SUBSTR(D.SLS_YRMON,1,4)||D.COST_WK = '${year}'||'${fm_wk}'" ).append("\n"); 
		query.append("                        AND '${year}'||'${fm_wk}' BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        AND SUBSTR(D.SLS_YRMON, 1, 4)||D.COST_WK BETWEEN L.OFC_APLY_FM_YRWK AND L.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                        AND L.OFC_TP_CD  IN ('BB', 'BA', 'BS')" ).append("\n"); 
		query.append("                        AND SPC_SCR_OFC_CONV_FNC(D.SLS_OFC_CD) = L.OFC_CD" ).append("\n"); 
		query.append("#if(${ofc_lvl} == '6')" ).append("\n"); 
		query.append("                        AND L.OFC_CD = '${ofc_cd}'" ).append("\n"); 
		query.append("#elseif(${sls_ofc_cd} !='' && ${sls_ofc_cd} !='TTL')" ).append("\n"); 
		query.append("                        AND L.N4TH_PRNT_OFC_CD = '${ofc_cd}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${rhq_cd} != '')" ).append("\n"); 
		query.append("                        AND L.N2ND_PRNT_OFC_CD = '${rhq_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${srep_cd} != '')" ).append("\n"); 
		query.append("                        AND D.SREP_CD          = '${srep_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_cd} != '')" ).append("\n"); 
		query.append("#if(${cust_cd} == 'XX999999')" ).append("\n"); 
		query.append("                        AND (D.AGMT_CNT_CD, D.AGMT_CUST_SEQ, NVL(D.SC_NO, 'X'), NVL(DECODE(UPPER(SUBSTR(D.RFA_NO,1,3)), 'DUM', '', D.RFA_NO), 'X')) NOT IN" ).append("\n"); 
		query.append("                                                                                    (SELECT CUST_CNT_CD, CUST_SEQ, NVL(SC_NO, 'X'), NVL(RFA_NO, 'X')" ).append("\n"); 
		query.append("                                                                                       FROM SPC_SLS_REP_CUST" ).append("\n"); 
		query.append("                                                                                      WHERE SREP_CD = D.SREP_CD" ).append("\n"); 
		query.append("                                                                                        AND TRD_CD  = '${trd_cd}'" ).append("\n"); 
		query.append("                                                                                        AND CUST_CNT_CD <> 'XX'" ).append("\n"); 
		query.append("                                                                                        AND NVL(INDIV_CUST_USE_FLG,'N') = 'Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                        AND D.AGMT_CNT_CD||TO_CHAR(D.AGMT_CUST_SEQ, 'FM000000') = '${cust_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        AND D.CMDT_CD              = K.CMDT_CD(+)" ).append("\n"); 
		query.append("                        AND D.REP_CMDT_CD          = F.REP_CMDT_CD" ).append("\n"); 
		query.append("                        AND D.DELT_FLG             = 'N'" ).append("\n"); 
		query.append("                        AND D.BL_NO_TP             IN ('M','0')" ).append("\n"); 
		query.append("                        AND D.BKG_STS_CD           IN ('F','S','W')" ).append("\n"); 
		query.append("                        AND D.BKG_CGO_TP_CD  	   IN ('F', 'R')" ).append("\n"); 
		query.append("#if (${call_ui} == 'ESM_SPC_0021' && ${trd_cd} != '')" ).append("\n"); 
		query.append("                        AND  '${trd_cd}' IN (D.N1ST_TRD_CD, D.N2ND_TRD_CD, D.N3RD_TRD_CD, D.N4TH_TRD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${call_ui} == 'ESM_SPC_0021' && ${sub_trd_cd} != '' && ${rlane_cd} == '')" ).append("\n"); 
		query.append("                        AND  D.SUB_TRD_CD = '${sub_trd_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("                        AND '${rlane_cd}' IN (D.RLANE_CD, D.N1ST_RLANE_CD, D.N2ND_RLANE_CD, N3RD_RLANE_CD, N4TH_RLANE_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                        AND BV.VSL_CD = '${vsl_cd}'" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("                        AND BV.SKD_VOY_NO = '${skd_voy_no}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("                        AND BV.SKD_DIR_CD = '${skd_dir_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_pol_cd} != '')" ).append("\n"); 
		query.append("                        AND BV.POL_YD_CD LIKE '${rev_pol_cd}' ||'%'" ).append("\n"); 
		query.append("#elseif(${sls_ofc_cd} =='TTL' && ${rhq_cd} == '')" ).append("\n"); 
		query.append("                        AND 'A' =(SELECT SPC_CONTI_CONV_FNC(K.CONTI_CD, D.RLANE_CD, BV.SKD_DIR_CD) FROM MDM_LOCATION K WHERE LOC_CD = SUBSTR(BV.POL_YD_CD,1,5))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_pod_cd} != '')" ).append("\n"); 
		query.append("                        AND BV.POD_YD_CD LIKE '${rev_pod_cd}' ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ioc} != '')" ).append("\n"); 
		query.append("                        AND '${ioc}' = DECODE(BV.VSL_PRE_PST_CD, 'T', SPC_GET_OCN_IPC_FNC(D.RLANE_CD, BV.POL_CD, BV.POD_CD), 'T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '' )" ).append("\n"); 
		query.append("                        AND (" ).append("\n"); 
		query.append("    #foreach($field_id in ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("        #if($velocityCount > 1)" ).append("\n"); 
		query.append("                              OR #end      D.SPCL_CNTR_TPSZ_CD = '$field_id'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- 2014.08.13 CSY dest(DEST_LOC_CD) , us_mod(MAS_BKG_EXPN_DTL_WK.USA_BKG_MOD_CD) 조건추가" ).append("\n"); 
		query.append("#if(${dest_loc_tp} == 'L')" ).append("\n"); 
		query.append("    #if(${bkg_del_cd} != '')" ).append("\n"); 
		query.append("                        AND D.BKG_DEL_CD = '${bkg_del_cd}'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${bkg_pod_cd} != '')" ).append("\n"); 
		query.append("                        AND D.BKG_POD_CD = '${bkg_pod_cd}'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dest_loc_tp} == 'E')" ).append("\n"); 
		query.append("    #if(${bkg_del_cd} != '')" ).append("\n"); 
		query.append("                        AND MAS_LOC_FNC(D.BKG_DEL_CD, 'ECC') = '${bkg_del_cd}'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${bkg_pod_cd} != '')" ).append("\n"); 
		query.append("                        AND MAS_LOC_FNC(D.BKG_POD_CD, 'ECC') = '${bkg_pod_cd}'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${usa_bkg_mod_cd} != '' && ${usa_bkg_mod_cd} != '1' && ${usa_bkg_mod_cd} != 'OTHERS')" ).append("\n"); 
		query.append("    --AND USA_BKG_MOD_CD =    " ).append("\n"); 
		query.append("    AND CASE WHEN (SUBSTR(D.BKg_POL_CD,1,2) IN ('US','CA') OR SUBSTR(D.BKg_POD_CD,1,2) IN ('US','CA')) THEN" ).append("\n"); 
		query.append("                NVL(SPC_USA_MODE_FNC(D.bkg_RCV_TERM_CD, D.bkg_DE_TERM_CD, D.BKg_POL_CD, D.BKg_POL_CD, D.BKg_POD_CD, D.BKG_DEL_CD),'OTHERS') " ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                'OTHERS'" ).append("\n"); 
		query.append("     END =  '${usa_bkg_mod_cd}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if(${cust_ctrl} != '')" ).append("\n"); 
		query.append("#if(${cust_ctrl} != 'C')" ).append("\n"); 
		query.append("             AND (AA.AGMT_CNT_CD1, AA.AGMT_CUST_SEQ1, NVL(AA.SC_NO, 'X'), DECODE(SUBSTR(AA.RFA_NO,1,1),'1',NVL(SUBSTR(AA.RFA_NO,2), 'X'),NVL(AA.RFA_NO, 'X'))) IN" ).append("\n"); 
		query.append("                                                     (SELECT DECODE(SUBSTR(AA.RFA_NO,1,1),'1',AA.AGMT_CNT_CD1, C.CUST_CNT_CD)," ).append("\n"); 
		query.append("                                                             DECODE(SUBSTR(AA.RFA_NO,1,1),'1',AA.AGMT_CUST_SEQ1 ,C.CUST_SEQ)," ).append("\n"); 
		query.append("                                                             NVL(C.SC_NO, 'X')," ).append("\n"); 
		query.append("                                                             NVL(C.RFA_NO, 'X')" ).append("\n"); 
		query.append("                                                        FROM SPC_MDL_CUST_CTRL C" ).append("\n"); 
		query.append("                                                       WHERE COST_YRWK = SUBSTR(SEASON,1,6)" ).append("\n"); 
		query.append("                                                         AND VER_SEQ   = SUBSTR(SEASON,8)" ).append("\n"); 
		query.append("                                                         AND CUST_CTRL_CD = '${cust_ctrl}'" ).append("\n"); 
		query.append("                                                         AND TRD_CD       = '${trd_cd}'  -- 2015.02.25 SMP계약은 Trade 별 Season을 가지고 있기 때문에 Trade를 걸어 주는 것이 맞음(또한 T/S는 SMP 대상이 아님)" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             AND (AA.AGMT_CNT_CD1, AA.AGMT_CUST_SEQ1, NVL(AA.SC_NO, 'X'), DECODE(SUBSTR(AA.RFA_NO,1,1),'1',NVL(SUBSTR(AA.RFA_NO,2), 'X'),NVL(AA.RFA_NO, 'X'))) NOT IN" ).append("\n"); 
		query.append("                                                     (SELECT DECODE(SUBSTR(AA.RFA_NO,1,1),'1',AA.AGMT_CNT_CD1, C.CUST_CNT_CD)," ).append("\n"); 
		query.append("                                                             DECODE(SUBSTR(AA.RFA_NO,1,1),'1',AA.AGMT_CUST_SEQ1 ,C.CUST_SEQ)," ).append("\n"); 
		query.append("                                                             NVL(C.SC_NO, 'X')," ).append("\n"); 
		query.append("                                                             NVL(C.RFA_NO, 'X')" ).append("\n"); 
		query.append("                                                        FROM SPC_MDL_CUST_CTRL C" ).append("\n"); 
		query.append("                                                       WHERE COST_YRWK = SUBSTR(SEASON,1,6)" ).append("\n"); 
		query.append("                                                         AND VER_SEQ   = SUBSTR(SEASON,8)" ).append("\n"); 
		query.append("                                                         AND TRD_CD    = '${trd_cd}'  -- 2015.02.25 SMP계약은 Trade 별 Season을 가지고 있기 때문에 Trade를 걸어 주는 것이 맞음(또한 T/S는 SMP 대상이 아님)" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${sc_no} != '')" ).append("\n"); 
		query.append("             AND NVL(SC_NO, 'X')  = '${sc_no}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${rfa_no} != '') -- 20140311 추가" ).append("\n"); 
		query.append("             AND DECODE(SUBSTR(RFA_NO,1,1),'1',NVL(SUBSTR(RFA_NO,2), 'X'),NVL(RFA_NO, 'X'))  = '${rfa_no}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 
		query.append("        ,BKG_NO" ).append("\n"); 
		query.append("        ,SC_NO" ).append("\n"); 
		query.append("        ,DECODE(SUBSTR(RFA_NO,1,1),'1',SUBSTR(RFA_NO,2),RFA_NO)" ).append("\n"); 
		query.append("        ,SC_CUST_NM" ).append("\n"); 
		query.append("        ,BKG_SHPR_NM" ).append("\n"); 
		query.append("        ,BKG_CGO_WGT" ).append("\n"); 
		query.append("        ,VGM_WGT" ).append("\n"); 
		query.append("#foreach(${keys} IN ${keyList4})" ).append("\n"); 
		query.append("    #if (${keys} == 'obrd_dt' || ${keys} == 'cntr_rcv_dt' )" ).append("\n"); 
		query.append("        ,TO_CHAR($keys,'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        ,$keys" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ,TPSZ_CODE" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가" ).append("\n"); 
		query.append("2011.09.15 이행지 [CHM-201113449-01] COA 링크 화면 보완 - MAS_OFC_LVL => SPC_OFC_LVL, BKG_VVD 를 참조 OCN/IPC/T/S 여부를 체크하는 부분 추가" ).append("\n"); 
		query.append("2012.03.19 김성훈 [CHM-201216752-01] COA Report 화면과 동일하게 구성 - 해당 항차, Load Office, POL/POD 조건에 맞는 실적정보 조회" ).append("\n"); 
		query.append("2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진" ).append("\n"); 
		query.append("2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - TTL 라인 COA 팝업 연결" ).append("\n"); 
		query.append("2013.07.01 진마리아 [선처리] alps error log 관련, coa에서 추가되는 항목에 대해 조회하지 않도록 수정" ).append("\n"); 
		query.append("2013.11.14 진마리아 ALPS ERROR LOG 조치 - 신규 항목에 대해 조회하지 않도록 예외 추가" ).append("\n"); 
		query.append("2013.11.26 진마리아 [CHM-201326854] SAQ project로 인한 SPC 변경건_FNC 우선제거" ).append("\n"); 
		query.append("2014.02.04 [CHM-201428383-01] RFA 로직 추가" ).append("\n"); 
		query.append("2014.03.05 김시몬 [선처리] BKG RFA NULL 관련 보완" ).append("\n"); 
		query.append("2014.05.29 김시몬 [선처리] BKG RFA NULL 관련 smp 비교 보완" ).append("\n"); 
		query.append("2014.05.30 김시몬 [CHM-201430245] TYPE SIZE 로직(SPC_GET_CNTR_SZ_FNC) 사용으로 변경" ).append("\n"); 
		query.append("2014.07.04 Arie Im [CHM-201431038] SPC기능보완요청 - COA pop 및 가이드 존재시 Alloc셀 활성화" ).append("\n"); 
		query.append("2014.08.13 CSY [CHM-201431081] SPC Allocation Control Option 추가 보완" ).append("\n"); 
		query.append("*/" ).append("\n"); 

	}
}