/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.10.22 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History --------------------------------------------------------
	  * 2010.12.07 김상수 [CHM-201007318-01] JOO - TDR Inquiry 기능 보완 요청 - i-stowage 연계
	  *                    1. 조회조건에 Carrier Code를 Multi Select 할 수 있는 멀티콤보 추가
	  *                    2. Sheet에 컬럼 추가
	  *                      (※ Data 조회 Logic 보완)
	  *                      - 기존처럼  해당 VVD 와 Port를 선정할때  Upload Status가  N (증빙 가)일 경우
	  *                         해당 정보(20’, 40’, 20HC, 40HC, 45, AK, RF, EMPTY)를 I-Stowage에서 조회
	  *                      - Source 컬럼 추가
	  *                         OPF : OPF 모듈에서  Data 조회
	  *                         IST : I-Stowage에서 Data 조회
	  * 2010.12.24 김상수 [CHM-201007932-01] JOO- TDR Inquiry by VVD 기능 보완 요청 - Weight 반영
	  *                    - TDR Inquiry by VVD 기능 보완 요청 - Weight 반영
	  * 2011.02.08 이병훈 [CHM-201108610-01] JOO/TDR 보완 요청 - I-Stowage 전면 연계
	  * 2011.04.04 표준희 [CHM-201109938-01] JOO/TDR Inquiry by VVD 보완 요청 - KRPU1 반영
	  * 2012.05.11 김창헌 [CHM-201217413-01]
	  *                    [ALPS JOO] TDR Inquiry by VVD 및 RDR Inquiry by Lane
	  *                    - Sum 기능 추가, 정렬순서 및 표시형식 변경
	  * 2012.06.19 김상근 [CHM-201218380]
	  *                   [ALPS JOO] TDR Inquiry by VVD : Additional Slot 칼럼 및 Sub Alloc and Ratio
	  * 2013.10.31 이수진 [선반영] Reefer 로직 변경(Cargo Type이 'RF'이거나 Temp에 값이 있는것)
	  * 2014.05.13 이영두 [CHM-201430221]TDR Inquiry by VVD 변경 (KRPUS 하드코딩 부분 제거)
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pre_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL").append("\n"); 
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
		query.append("WITH VSL AS (SELECT VSL_CD," ).append("\n"); 
		query.append("                    SKD_VOY_NO," ).append("\n"); 
		query.append("                    SKD_DIR_CD," ).append("\n"); 
		query.append("                    VPS_PORT_CD," ).append("\n"); 
		query.append("                    CLPT_IND_SEQ," ).append("\n"); 
		query.append("                    VPS_ETA_DT," ).append("\n"); 
		query.append("                    VPS_ETD_DT," ).append("\n"); 
		query.append("                    SLAN_CD," ).append("\n"); 
		query.append("                    YD_CD" ).append("\n"); 
		query.append("               FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("              WHERE SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                AND ( (VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                      AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR VPS_ETD_DT IS NULL )" ).append("\n"); 
		query.append("                AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" , SRC AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT Y.OPR_CD," ).append("\n"); 
		query.append("       Y.VSL_CD || Y.VOY_NO || Y.DIR_CD VVD," ).append("\n"); 
		query.append("       Y.VSL_CD," ).append("\n"); 
		query.append("       Y.VOY_NO  SKD_VOY_NO," ).append("\n"); 
		query.append("       Y.DIR_CD  SKD_DIR_CD," ).append("\n"); 
		query.append("       Y.PORT_CD  VPS_PORT_CD," ).append("\n"); 
		query.append("       Y.SLAN_CD," ).append("\n"); 
		query.append("       Y.VPS_ETD_DT," ).append("\n"); 
		query.append("       1 SUB_CHK,  " ).append("\n"); 
		query.append("       SUM(Y.GRAND_TTL_SLOT) GRAND_TTL_SLOT," ).append("\n"); 
		query.append("       SUM(Y.GRAND_TTL_WGT) GRAND_TTL_WGT," ).append("\n"); 
		query.append("       SUM(Y.HC_LD_20) HC_LD_20," ).append("\n"); 
		query.append("       SUM(Y.HC_BSA_20) HC_BSA_20," ).append("\n"); 
		query.append("       SUM(Y.HC_LD_40) HC_LD_40," ).append("\n"); 
		query.append("       SUM(Y.HC_BSA_40) HC_BSA_40," ).append("\n"); 
		query.append("       SUM(Y.HC_LD_45) HC_LD_45," ).append("\n"); 
		query.append("       SUM(Y.HC_BSA_45) HC_BSA_45," ).append("\n"); 
		query.append("       SUM(Y.AK_UNIT) AK_UNIT," ).append("\n"); 
		query.append("       SUM(Y.AK_VOID) AK_VOID," ).append("\n"); 
		query.append("       SUM(Y.DG_20) DG_20," ).append("\n"); 
		query.append("       SUM(Y.DG_40) DG_40," ).append("\n"); 
		query.append("       SUM(Y.RF_20_QTY) RF_20_QTY," ).append("\n"); 
		query.append("       SUM(Y.RF_40_QTY) RF_40_QTY," ).append("\n"); 
		query.append("       SUM(Y.MT_TEU) MT_TEU," ).append("\n"); 
		query.append("       SUM(Y.FULL_20) FULL_20," ).append("\n"); 
		query.append("       SUM(Y.MT_20) MT_20," ).append("\n"); 
		query.append("       SUM(Y.FULL_40) FULL_40," ).append("\n"); 
		query.append("       SUM(Y.MT_40) MT_40," ).append("\n"); 
		query.append("       SUM(Y.MT_WT) MT_WT," ).append("\n"); 
		query.append("       'IST'  SOURCE," ).append("\n"); 
		query.append("       NVL(Z.JO_20FT_N1ST_RTO, 0) JO_20FT_N1ST_RTO," ).append("\n"); 
		query.append("       NVL(Z.JO_20FT_SUB_TEU_QTY, 0) JO_20FT_SUB_TEU_QTY," ).append("\n"); 
		query.append("       NVL(Z.JO_40FT_N1ST_RTO, 0) JO_40FT_N1ST_RTO," ).append("\n"); 
		query.append("       NVL(Z.JO_40FT_SUB_TEU_QTY, 0) JO_40FT_SUB_TEU_QTY," ).append("\n"); 
		query.append("       NVL(Z.JO_45FT_N1ST_RTO, 0) JO_45FT_N1ST_RTO," ).append("\n"); 
		query.append("       NVL(Z.JO_45FT_N2ND_RTO, 0) JO_45FT_N2ND_RTO," ).append("\n"); 
		query.append("       NVL(Z.JO_45FT_SUB_TEU_QTY, 0) JO_45FT_SUB_TEU_QTY," ).append("\n"); 
		query.append("       NVL(Z.JO_RND_RULE_LVL, '4') JO_RND_RULE_LVL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               /* ALLOCATION  - TEU/WGT : Port Step Up/Down by VVD */" ).append("\n"); 
		query.append("                SELECT NVL(B.CRR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       B.VSL_CD," ).append("\n"); 
		query.append("                       B.SKD_VOY_NO VOY_NO," ).append("\n"); 
		query.append("                       B.SKD_DIR_CD DIR_CD," ).append("\n"); 
		query.append("                       B.PORT_CD," ).append("\n"); 
		query.append("                       K.CLPT_IND_SEQ CALL_IND," ).append("\n"); 
		query.append("                       K.SLAN_CD," ).append("\n"); 
		query.append("                       TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       0 HC_LD_20," ).append("\n"); 
		query.append("                       0 HC_BSA_20," ).append("\n"); 
		query.append("                       0 HC_LD_40," ).append("\n"); 
		query.append("                       0 HC_BSA_40," ).append("\n"); 
		query.append("                       0 HC_LD_45," ).append("\n"); 
		query.append("                       0 HC_BSA_45," ).append("\n"); 
		query.append("                       0 AK_UNIT," ).append("\n"); 
		query.append("                       0 AK_VOID," ).append("\n"); 
		query.append("                       0 DG_20," ).append("\n"); 
		query.append("                       0 DG_40,                       " ).append("\n"); 
		query.append("                       0 RF_20_QTY," ).append("\n"); 
		query.append("                       0 RF_40_QTY," ).append("\n"); 
		query.append("                       0 MT_TEU," ).append("\n"); 
		query.append("                       0 FULL_20," ).append("\n"); 
		query.append("                       0 MT_20," ).append("\n"); 
		query.append("                       0 FULL_40," ).append("\n"); 
		query.append("                       0 MT_40," ).append("\n"); 
		query.append("                       0 MT_WT" ).append("\n"); 
		query.append("                  FROM BSA_VVD_PORT_DWN B," ).append("\n"); 
		query.append("                       VSL K" ).append("\n"); 
		query.append("                 WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND K.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                   AND K.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                   AND B.BSA_OP_JB_CD IN ('007','016') " ).append("\n"); 
		query.append("                   AND B.PORT_SEQ     <> 999" ).append("\n"); 
		query.append("                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SLAN_CD  =  SUBSTR(B.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                   AND B.CRR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'A'" ).append("\n"); 
		query.append("                                 FROM BAY_PLAN" ).append("\n"); 
		query.append("                                WHERE VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("                                  AND VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("                                  AND DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  AND OPR_CD = B.CRR_CD" ).append("\n"); 
		query.append("                                  AND PORT_CD =B.PORT_CD" ).append("\n"); 
		query.append("                                  AND CALL_IND = K.CLPT_IND_SEQ ) " ).append("\n"); 
		query.append("                 GROUP BY B.CRR_CD," ).append("\n"); 
		query.append("                          B.VSL_CD," ).append("\n"); 
		query.append("                          B.SKD_VOY_NO," ).append("\n"); 
		query.append("                          B.SKD_DIR_CD," ).append("\n"); 
		query.append("                          B.PORT_CD," ).append("\n"); 
		query.append("                          K.CLPT_IND_SEQ," ).append("\n"); 
		query.append("                          K.SLAN_CD," ).append("\n"); 
		query.append("                          TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               /* 20HC, 40HC, 45HC, F20, E20, F40, E40 */" ).append("\n"); 
		query.append("                SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       B.VSL_CD," ).append("\n"); 
		query.append("                       B.VOY_NO," ).append("\n"); 
		query.append("                       B.DIR_CD," ).append("\n"); 
		query.append("                       B.PORT_CD," ).append("\n"); 
		query.append("                       B.CALL_IND," ).append("\n"); 
		query.append("                       K.SLAN_CD," ).append("\n"); 
		query.append("                       TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       SUM(B.WEIGHT) GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HF1', 1, 0)) HC_LD_20," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HE1', 1, 0)) HC_BSA_20," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HF0', 1, 0)) HC_LD_40," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HE0', 1, 0)) HC_BSA_40," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE, 'LF', 1, 0)) HC_LD_45," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE, 'LE', 1, 0)) HC_BSA_45," ).append("\n"); 
		query.append("                       0 AK_UNIT," ).append("\n"); 
		query.append("                       0 AK_VOID," ).append("\n"); 
		query.append("                       0 DG_20," ).append("\n"); 
		query.append("                       0 DG_40,    " ).append("\n"); 
		query.append("                       0 RF_20_QTY," ).append("\n"); 
		query.append("                       0 RF_40_QTY," ).append("\n"); 
		query.append("                       0 MT_TEU," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE, '2F', 1, 0)) FULL_20," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE, '2E', 1, 0)) MT_20," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE, '4F', 1, 0)) FULL_40," ).append("\n"); 
		query.append("                       SUM (DECODE (B.CNTR_SIZE || B.FE, '4E', 1, 0)) MT_40," ).append("\n"); 
		query.append("                       0 MT_WT" ).append("\n"); 
		query.append("                  FROM BAY_PLAN B," ).append("\n"); 
		query.append("                       VSL K" ).append("\n"); 
		query.append("                 WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                   AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                   AND B.PLAN_TYPE= 'F'" ).append("\n"); 
		query.append("                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                   AND B.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY B.OPR_CD," ).append("\n"); 
		query.append("                          B.VSL_CD," ).append("\n"); 
		query.append("                          B.VOY_NO," ).append("\n"); 
		query.append("                          B.DIR_CD," ).append("\n"); 
		query.append("                          B.PORT_CD," ).append("\n"); 
		query.append("                          B.CALL_IND," ).append("\n"); 
		query.append("                          K.SLAN_CD," ).append("\n"); 
		query.append("                          TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /* DG20, DG40 */" ).append("\n"); 
		query.append("                SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       B.VSL_CD," ).append("\n"); 
		query.append("                       B.VOY_NO," ).append("\n"); 
		query.append("                       B.DIR_CD," ).append("\n"); 
		query.append("                       B.PORT_CD," ).append("\n"); 
		query.append("                       B.CALL_IND," ).append("\n"); 
		query.append("                       K.SLAN_CD," ).append("\n"); 
		query.append("                       TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       0 HC_LD_20," ).append("\n"); 
		query.append("                       0 HC_BSA_20," ).append("\n"); 
		query.append("                       0 HC_LD_40," ).append("\n"); 
		query.append("                       0 HC_BSA_40," ).append("\n"); 
		query.append("                       0 HC_LD_45," ).append("\n"); 
		query.append("                       0 HC_BSA_45," ).append("\n"); 
		query.append("                       0 AK_UNIT," ).append("\n"); 
		query.append("                       0 AK_VOID," ).append("\n"); 
		query.append("                       SUM(DECODE(CNTR_SIZE,'2',1, 'H', DECODE(SUBSTR(SZTP_ISO,0,1), '2', 1, 0), 0))DG_20," ).append("\n"); 
		query.append("                       SUM(DECODE(CNTR_SIZE,'4',1, 'L', 1, 'W', 1, 'X', 1,'H', DECODE(SUBSTR(SZTP_ISO,0,1), '4', 1, 0), 0) ) DG_40," ).append("\n"); 
		query.append("                       0 RF_20_QTY," ).append("\n"); 
		query.append("                       0 RF_40_QTY," ).append("\n"); 
		query.append("                       0 MT_TEU," ).append("\n"); 
		query.append("                       0 FULL_20," ).append("\n"); 
		query.append("                       0 MT_20," ).append("\n"); 
		query.append("                       0 FULL_40," ).append("\n"); 
		query.append("                       0 MT_40," ).append("\n"); 
		query.append("                       0 MT_WT" ).append("\n"); 
		query.append("                  FROM BAY_PLAN B," ).append("\n"); 
		query.append("                       STO_PLN_VSL_PORT_SKD S," ).append("\n"); 
		query.append("                       VSL K" ).append("\n"); 
		query.append("                 WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.9999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                   AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                   AND B.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("                   AND B.VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND B.DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.PORT_CD =S.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND B.CALL_IND = S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                   AND B.CARGO_TYPE = 'DG'" ).append("\n"); 
		query.append("                   AND DECODE(S.REP_PORT_CD,NULL,B.PORT_CD,S.REP_PORT_CD) = B.POL" ).append("\n"); 
		query.append("                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                   AND B.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY B.OPR_CD," ).append("\n"); 
		query.append("                          B.VSL_CD," ).append("\n"); 
		query.append("                          B.VOY_NO," ).append("\n"); 
		query.append("                          B.DIR_CD," ).append("\n"); 
		query.append("                          B.PORT_CD," ).append("\n"); 
		query.append("                          B.CALL_IND," ).append("\n"); 
		query.append("                          K.SLAN_CD," ).append("\n"); 
		query.append("                          TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /* RF20, RF40 */" ).append("\n"); 
		query.append("                SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       B.VSL_CD," ).append("\n"); 
		query.append("                       B.VOY_NO," ).append("\n"); 
		query.append("                       B.DIR_CD," ).append("\n"); 
		query.append("                       B.PORT_CD," ).append("\n"); 
		query.append("                       B.CALL_IND,   " ).append("\n"); 
		query.append("                       K.SLAN_CD," ).append("\n"); 
		query.append("                       TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       0 HC_LD_20," ).append("\n"); 
		query.append("                       0 HC_BSA_20," ).append("\n"); 
		query.append("                       0 HC_LD_40," ).append("\n"); 
		query.append("                       0 HC_BSA_40," ).append("\n"); 
		query.append("                       0 HC_LD_45," ).append("\n"); 
		query.append("                       0 HC_BSA_45," ).append("\n"); 
		query.append("                       0 AK_UNIT," ).append("\n"); 
		query.append("                       0 AK_VOID," ).append("\n"); 
		query.append("                       0 DG_20," ).append("\n"); 
		query.append("                       0 DG_40,    " ).append("\n"); 
		query.append("                       SUM (DECODE (MOD (B.BAY, 2), 1, 1)) RF_20_QTY," ).append("\n"); 
		query.append("                       SUM (DECODE (MOD (B.BAY, 2), 0, 1)) RF_40_QTY," ).append("\n"); 
		query.append("                       0 MT_TEU," ).append("\n"); 
		query.append("                       0 FULL_20," ).append("\n"); 
		query.append("                       0 MT_20," ).append("\n"); 
		query.append("                       0 FULL_40," ).append("\n"); 
		query.append("                       0 MT_40," ).append("\n"); 
		query.append("                       0 MT_WT" ).append("\n"); 
		query.append("                  FROM BAY_PLAN B," ).append("\n"); 
		query.append("                       STO_PLN_VSL_PORT_SKD S," ).append("\n"); 
		query.append("                       VSL K" ).append("\n"); 
		query.append("                 WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.9999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                   AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                   AND B.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("                   AND B.VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND B.DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.PORT_CD =S.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND B.CALL_IND = S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND B.TEMP IS NOT NULL" ).append("\n"); 
		query.append("                   AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                   AND DECODE(S.REP_PORT_CD,NULL,B.PORT_CD,S.REP_PORT_CD) = B.POL" ).append("\n"); 
		query.append("                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                   AND B.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY B.OPR_CD," ).append("\n"); 
		query.append("                          B.VSL_CD," ).append("\n"); 
		query.append("                          B.VOY_NO," ).append("\n"); 
		query.append("                          B.DIR_CD," ).append("\n"); 
		query.append("                          B.PORT_CD," ).append("\n"); 
		query.append("                          B.CALL_IND," ).append("\n"); 
		query.append("                          K.SLAN_CD," ).append("\n"); 
		query.append("                          TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  /* empty */" ).append("\n"); 
		query.append("                SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       B.VSL_CD," ).append("\n"); 
		query.append("                       B.VOY_NO," ).append("\n"); 
		query.append("                       B.DIR_CD," ).append("\n"); 
		query.append("                       B.PORT_CD," ).append("\n"); 
		query.append("                       B.CALL_IND," ).append("\n"); 
		query.append("                       K.SLAN_CD," ).append("\n"); 
		query.append("                       TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       0 HC_LD_20," ).append("\n"); 
		query.append("                       0 HC_BSA_20," ).append("\n"); 
		query.append("                       0 HC_LD_40," ).append("\n"); 
		query.append("                       0 HC_BSA_40," ).append("\n"); 
		query.append("                       0 HC_LD_45," ).append("\n"); 
		query.append("                       0 HC_BSA_45," ).append("\n"); 
		query.append("                       0 AK_UNIT," ).append("\n"); 
		query.append("                       0 AK_VOID," ).append("\n"); 
		query.append("                       0 DG_20," ).append("\n"); 
		query.append("                       0 DG_40,    " ).append("\n"); 
		query.append("                       0 RF_20_QTY," ).append("\n"); 
		query.append("                       0 RF_40_QTY," ).append("\n"); 
		query.append("                       SUM (DECODE (MOD (B.BAY, 2), 0, 2, 1)) MT_TEU," ).append("\n"); 
		query.append("                       0 FULL_20," ).append("\n"); 
		query.append("                       0 MT_20," ).append("\n"); 
		query.append("                       0 FULL_40," ).append("\n"); 
		query.append("                       0 MT_40," ).append("\n"); 
		query.append("                       SUM (B.WEIGHT) MT_WT" ).append("\n"); 
		query.append("                  FROM BAY_PLAN B," ).append("\n"); 
		query.append("                       VSL K" ).append("\n"); 
		query.append("                 WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                   AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                   AND B.FE = 'E'" ).append("\n"); 
		query.append("                   AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                   AND B.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY B.OPR_CD," ).append("\n"); 
		query.append("                          B.VSL_CD," ).append("\n"); 
		query.append("                          B.VOY_NO," ).append("\n"); 
		query.append("                          B.DIR_CD," ).append("\n"); 
		query.append("                          B.PORT_CD," ).append("\n"); 
		query.append("                          B.CALL_IND," ).append("\n"); 
		query.append("                          K.SLAN_CD," ).append("\n"); 
		query.append("                          TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /* 'AK' UNIT */" ).append("\n"); 
		query.append("                SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       B.VSL_CD," ).append("\n"); 
		query.append("                       B.VOY_NO," ).append("\n"); 
		query.append("                       B.DIR_CD," ).append("\n"); 
		query.append("                       B.PORT_CD," ).append("\n"); 
		query.append("                       B.CALL_IND," ).append("\n"); 
		query.append("                       K.SLAN_CD," ).append("\n"); 
		query.append("                       TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       0 HC_LD_20," ).append("\n"); 
		query.append("                       0 HC_BSA_20," ).append("\n"); 
		query.append("                       0 HC_LD_40," ).append("\n"); 
		query.append("                       0 HC_BSA_40," ).append("\n"); 
		query.append("                       0 HC_LD_45," ).append("\n"); 
		query.append("                       0 HC_BSA_45," ).append("\n"); 
		query.append("                       COUNT (*) AK_UNIT," ).append("\n"); 
		query.append("                       0 AK_VOID," ).append("\n"); 
		query.append("                       0 DG_20," ).append("\n"); 
		query.append("                       0 DG_40,    " ).append("\n"); 
		query.append("                       0 RF_20_QTY," ).append("\n"); 
		query.append("                       0 RF_40_QTY," ).append("\n"); 
		query.append("                       0 MT_TEU," ).append("\n"); 
		query.append("                       0 FULL_20," ).append("\n"); 
		query.append("                       0 MT_20," ).append("\n"); 
		query.append("                       0 FULL_40," ).append("\n"); 
		query.append("                       0 MT_40," ).append("\n"); 
		query.append("                       0 MT_WT" ).append("\n"); 
		query.append("                  FROM BAY_PLAN B," ).append("\n"); 
		query.append("                       VSL K" ).append("\n"); 
		query.append("                 WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                           AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                   AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                   AND ( B.CARGO_TYPE IN ('AK', 'BB')" ).append("\n"); 
		query.append("                        OR ((B.ACT_SLOT>0 OR B.OVH_SLOT>0 OR B.OVP_SLOT>0 OR B.OVS_SLOT>0 OR B.OVF_SLOT>0 OR B.OVA_SLOT>0))" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                   AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                   AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                   AND B.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                 GROUP BY B.OPR_CD," ).append("\n"); 
		query.append("                          B.VSL_CD," ).append("\n"); 
		query.append("                          B.VOY_NO," ).append("\n"); 
		query.append("                          B.DIR_CD," ).append("\n"); 
		query.append("                          B.PORT_CD," ).append("\n"); 
		query.append("                          CALL_IND," ).append("\n"); 
		query.append("                          K.SLAN_CD," ).append("\n"); 
		query.append("                          TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                /* 'AK' Void */" ).append("\n"); 
		query.append("                SELECT NVL(OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                       VSL_CD," ).append("\n"); 
		query.append("                       VOY_NO," ).append("\n"); 
		query.append("                       DIR_CD," ).append("\n"); 
		query.append("                       PORT_CD," ).append("\n"); 
		query.append("                       CALL_IND," ).append("\n"); 
		query.append("                       SLAN_CD," ).append("\n"); 
		query.append("                       VPS_ETD_DT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_SLOT," ).append("\n"); 
		query.append("                       0 GRAND_TTL_WGT," ).append("\n"); 
		query.append("                       0 OVER_SLOT," ).append("\n"); 
		query.append("                       0 OVER_WGT," ).append("\n"); 
		query.append("                       0 HC_LD_20," ).append("\n"); 
		query.append("                       0 HC_BSA_20," ).append("\n"); 
		query.append("                       0 HC_LD_40," ).append("\n"); 
		query.append("                       0 HC_BSA_40," ).append("\n"); 
		query.append("                       0 HC_LD_45," ).append("\n"); 
		query.append("                       0 HC_BSA_45," ).append("\n"); 
		query.append("                       0 AK_UNIT," ).append("\n"); 
		query.append("                       SUM (CASE" ).append("\n"); 
		query.append("                            WHEN ACT_SLOT <> '' THEN" ).append("\n"); 
		query.append("                                        TO_NUMBER(ACT_SLOT)" ).append("\n"); 
		query.append("                                     WHEN X * Y * Z > 0 THEN" ).append("\n"); 
		query.append("                                        (X + 1) * (Y + 1) * (Z + 1) - S" ).append("\n"); 
		query.append("                                     WHEN X * Y > 0 THEN" ).append("\n"); 
		query.append("                                        (X + 1) * (Y + 1) * S - S" ).append("\n"); 
		query.append("                                     WHEN X * Z > 0 THEN" ).append("\n"); 
		query.append("                                        (X + 1) * (Z + 1) - 1 + X * (S - 1)" ).append("\n"); 
		query.append("                                     WHEN Y * Z > 0 THEN" ).append("\n"); 
		query.append("                                        (Y + 1) * (Z + 1) - 1 + Y * (S - 1)" ).append("\n"); 
		query.append("                                     WHEN X + Y > 0 THEN" ).append("\n"); 
		query.append("                                        (X + Y + 1) * S - S" ).append("\n"); 
		query.append("                                     WHEN Z > 0 THEN Z" ).append("\n"); 
		query.append("                                     ELSE 0" ).append("\n"); 
		query.append("                          END) AS AK_VOID," ).append("\n"); 
		query.append("                       0 DG_20," ).append("\n"); 
		query.append("                       0 DG_40,    " ).append("\n"); 
		query.append("                       0 RF_20_QTY," ).append("\n"); 
		query.append("                       0 RF_40_QTY," ).append("\n"); 
		query.append("                       0 MT_TEU," ).append("\n"); 
		query.append("                       0 FULL_20," ).append("\n"); 
		query.append("                       0 MT_20," ).append("\n"); 
		query.append("                       0 FULL_40," ).append("\n"); 
		query.append("                       0 MT_40," ).append("\n"); 
		query.append("                       0 MT_WT" ).append("\n"); 
		query.append("                  FROM (SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD," ).append("\n"); 
		query.append("                               B.VSL_CD," ).append("\n"); 
		query.append("                               B.VOY_NO," ).append("\n"); 
		query.append("                               B.DIR_CD," ).append("\n"); 
		query.append("                               B.PORT_CD," ).append("\n"); 
		query.append("                               B.CALL_IND," ).append("\n"); 
		query.append("                               K.SLAN_CD," ).append("\n"); 
		query.append("                               TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') VPS_ETD_DT," ).append("\n"); 
		query.append("                               NVL (B.OVP_SLOT, 0) + NVL (B.OVS_SLOT, 0) X," ).append("\n"); 
		query.append("                               NVL (B.OVH_SLOT, 0) Y," ).append("\n"); 
		query.append("                               NVL (B.OVA_SLOT, 0) + NVL (B.OVF_SLOT, 0) Z," ).append("\n"); 
		query.append("                               (2 - MOD (B.BAY, 2)) S," ).append("\n"); 
		query.append("                               ACT_SLOT" ).append("\n"); 
		query.append("                          FROM BAY_PLAN B," ).append("\n"); 
		query.append("                               VSL K" ).append("\n"); 
		query.append("                         WHERE ( (K.VPS_ETD_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                   AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') +  1) OR K.VPS_ETD_DT IS NULL)" ).append("\n"); 
		query.append("                           AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                           AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                           AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                           AND ( B.CARGO_TYPE IN ('AK', 'BB')" ).append("\n"); 
		query.append("                               OR ((B.ACT_SLOT>0 OR B.OVH_SLOT>0 OR B.OVP_SLOT>0 OR B.OVS_SLOT>0 OR B.OVF_SLOT>0 OR B.OVA_SLOT>0))" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                           AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                           AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%'" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                           AND B.OPR_CD IN (${opr_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                 GROUP BY OPR_CD," ).append("\n"); 
		query.append("                          VSL_CD," ).append("\n"); 
		query.append("                          VOY_NO," ).append("\n"); 
		query.append("                          DIR_CD," ).append("\n"); 
		query.append("                          PORT_CD," ).append("\n"); 
		query.append("                          CALL_IND," ).append("\n"); 
		query.append("                          SLAN_CD," ).append("\n"); 
		query.append("                          VPS_ETD_DT" ).append("\n"); 
		query.append("     ) Y, JOO_TDR_RTO Z" ).append("\n"); 
		query.append("WHERE Y.SLAN_CD = Z.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND Y.OPR_CD = Z.JO_CRR_CD(+)" ).append("\n"); 
		query.append("GROUP BY Y.OPR_CD," ).append("\n"); 
		query.append("        Y.VSL_CD," ).append("\n"); 
		query.append("        Y.VOY_NO," ).append("\n"); 
		query.append("        Y.DIR_CD," ).append("\n"); 
		query.append("        Y.PORT_CD," ).append("\n"); 
		query.append("        Y.CALL_IND," ).append("\n"); 
		query.append("        Y.SLAN_CD," ).append("\n"); 
		query.append("        Y.VPS_ETD_DT," ).append("\n"); 
		query.append("        Z.JO_20FT_N1ST_RTO," ).append("\n"); 
		query.append("        Z.JO_20FT_SUB_TEU_QTY," ).append("\n"); 
		query.append("        Z.JO_40FT_N1ST_RTO," ).append("\n"); 
		query.append("        Z.JO_40FT_SUB_TEU_QTY," ).append("\n"); 
		query.append("        Z.JO_45FT_N1ST_RTO," ).append("\n"); 
		query.append("        Z.JO_45FT_N2ND_RTO," ).append("\n"); 
		query.append("        Z.JO_45FT_SUB_TEU_QTY," ).append("\n"); 
		query.append("        Z.JO_RND_RULE_LVL   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("* " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT  " ).append("\n"); 
		query.append("		 A.PORT_CD" ).append("\n"); 
		query.append("		,A.TRD_CD" ).append("\n"); 
		query.append("		,RLANE_CD " ).append("\n"); 
		query.append("		,CASE WHEN (T2.VPS_PORT_CD = A.PORT_CD OR A.PORT_CD = 'ALL') AND T2.VVD = A.VVD THEN A.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("		     ELSE 0" ).append("\n"); 
		query.append("	    	 END ALL_TEU" ).append("\n"); 
		query.append("		,CASE WHEN (T2.VPS_PORT_CD = A.PORT_CD OR A.PORT_CD = 'ALL') AND T2.VVD = A.VVD THEN A.JO_OVR_TON_WGT" ).append("\n"); 
		query.append("		     ELSE 0" ).append("\n"); 
		query.append("		     END ALL_WGT" ).append("\n"); 
		query.append("		," ).append("\n"); 
		query.append("		T2.*" ).append("\n"); 
		query.append("		FROM    (" ).append("\n"); 
		query.append("        			SELECT    " ).append("\n"); 
		query.append("	                  MIN(T1.VVD || T1.VPS_ETD_DT) OVER (PARTITION BY T1.VVD) AS VVD_ETD_GROUP" ).append("\n"); 
		query.append("    	            , T1.*" ).append("\n"); 
		query.append("	    		    FROM    SRC T1" ).append("\n"); 
		query.append("    		    ) T2" ).append("\n"); 
		query.append("		       ,(" ).append("\n"); 
		query.append("				 SELECT A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("        	       ,A.JO_CRR_CD" ).append("\n"); 
		query.append("            	   ,A.PORT_CD" ).append("\n"); 
		query.append("            	   ,A.JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("	               ,A.JO_OVR_TON_WGT               " ).append("\n"); 
		query.append("                   ,A.TRD_CD" ).append("\n"); 
		query.append("                   ,A.RLANE_CD                   " ).append("\n"); 
		query.append("    		     FROM JOO_BSA_AGMT A" ).append("\n"); 
		query.append("				 WHERE A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("				) A" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("	 AND T2.VVD = A.VVD(+) " ).append("\n"); 
		query.append("	 AND T2.OPR_CD = A.JO_CRR_CD(+)" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (PORT_CD IS NULL" ).append("\n"); 
		query.append("	 OR PORT_CD = 'ALL' " ).append("\n"); 
		query.append("	 OR PORT_CD = VPS_PORT_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("ORDER BY SUBSTR(VVD_ETD_GROUP, 10), AA.VVD, AA.VPS_ETD_DT, AA.VPS_PORT_CD, AA.OPR_CD" ).append("\n"); 

	}
}