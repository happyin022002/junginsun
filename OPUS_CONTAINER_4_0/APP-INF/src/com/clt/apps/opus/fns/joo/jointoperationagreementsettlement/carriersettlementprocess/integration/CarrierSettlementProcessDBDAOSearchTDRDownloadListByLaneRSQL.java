/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchTDRDownloadListByLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * [2015.07.21]Virtual Add Calling 처리. VSK_VSL_PORT_SKD.NVL(VT_ADD_CALL_FLG, 'N') = 'N'
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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
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
		query.append("WITH VSL AS (SELECT VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , VPS_PORT_CD" ).append("\n"); 
		query.append("             , CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , VPS_ETA_DT" ).append("\n"); 
		query.append("             , VPS_ETD_DT" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , YD_CD" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("           AND ( (VPS_ETA_DT BETWEEN TO_DATE (REPLACE (@[pre_fr], '-', ''), 'YYYYMMDD') AND TO_DATE (REPLACE (@[pre_to], '-', ''), 'YYYYMMDD') + 0.99999)" ).append("\n"); 
		query.append("                    OR VPS_ETA_DT IS NULL )" ).append("\n"); 
		query.append("           AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("           AND NVL(VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT OPR_CD" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , VPS_PORT_CD" ).append("\n"); 
		query.append("     , SLAN_CD" ).append("\n"); 
		query.append("     , VPS_ETD_DT" ).append("\n"); 
		query.append("     , ALL_TEU" ).append("\n"); 
		query.append("     , ALL_WGT" ).append("\n"); 
		query.append("     , GRAND_TTL_SLOT" ).append("\n"); 
		query.append("     , GRAND_TTL_WGT" ).append("\n"); 
		query.append("     , CASE WHEN GRAND_TTL_SLOT > ALL_TEU AND ALL_TEU > 0 THEN GRAND_TTL_SLOT - ALL_TEU" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END OVER_SLOT" ).append("\n"); 
		query.append("     , CASE WHEN GRAND_TTL_WGT > ALL_WGT AND ALL_WGT > 0 THEN GRAND_TTL_WGT - ALL_WGT" ).append("\n"); 
		query.append("            ELSE 0" ).append("\n"); 
		query.append("       END OVER_WGT" ).append("\n"); 
		query.append("     , HC_LD_20" ).append("\n"); 
		query.append("     , HC_BSA_20" ).append("\n"); 
		query.append("     , HC_LD_40" ).append("\n"); 
		query.append("     , HC_BSA_40" ).append("\n"); 
		query.append("     , HC_LD_45" ).append("\n"); 
		query.append("     , HC_BSA_45" ).append("\n"); 
		query.append("     , AK_UNIT" ).append("\n"); 
		query.append("     , AK_VOID" ).append("\n"); 
		query.append("     , RF_20_QTY" ).append("\n"); 
		query.append("     , RF_40_QTY" ).append("\n"); 
		query.append("     , MT_TEU" ).append("\n"); 
		query.append("     , FULL_20" ).append("\n"); 
		query.append("     , MT_20" ).append("\n"); 
		query.append("     , FULL_40" ).append("\n"); 
		query.append("     , MT_40" ).append("\n"); 
		query.append("     , MT_WT" ).append("\n"); 
		query.append("     , SOURCE" ).append("\n"); 
		query.append("  FROM (SELECT OPR_CD" ).append("\n"); 
		query.append("             , VVD" ).append("\n"); 
		query.append("             , VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , VPS_PORT_CD" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , VPS_ETD_DT" ).append("\n"); 
		query.append("             , ALL_TEU" ).append("\n"); 
		query.append("             , ALL_WGT" ).append("\n"); 
		query.append("             , FULL_20+MT_20+HC_LD_20+HC_BSA_20+((FULL_40+MT_40+HC_LD_40+HC_BSA_40+HC_LD_45+HC_BSA_45)*2)+AK_VOID AS GRAND_TTL_SLOT" ).append("\n"); 
		query.append("             , GRAND_TTL_WGT" ).append("\n"); 
		query.append("             , OVER_SLOT" ).append("\n"); 
		query.append("             , OVER_WGT" ).append("\n"); 
		query.append("             , HC_LD_20" ).append("\n"); 
		query.append("             , HC_BSA_20" ).append("\n"); 
		query.append("             , HC_LD_40" ).append("\n"); 
		query.append("             , HC_BSA_40" ).append("\n"); 
		query.append("             , HC_LD_45" ).append("\n"); 
		query.append("             , HC_BSA_45" ).append("\n"); 
		query.append("             , AK_UNIT" ).append("\n"); 
		query.append("             , AK_VOID" ).append("\n"); 
		query.append("             , RF_20_QTY" ).append("\n"); 
		query.append("             , RF_40_QTY" ).append("\n"); 
		query.append("             , MT_TEU" ).append("\n"); 
		query.append("             , FULL_20" ).append("\n"); 
		query.append("             , MT_20" ).append("\n"); 
		query.append("             , FULL_40" ).append("\n"); 
		query.append("             , MT_40" ).append("\n"); 
		query.append("             , MT_WT" ).append("\n"); 
		query.append("             , SOURCE" ).append("\n"); 
		query.append("          FROM (SELECT OPR_CD" ).append("\n"); 
		query.append("                     , VSL_CD || VOY_NO || DIR_CD VVD" ).append("\n"); 
		query.append("                     , VSL_CD" ).append("\n"); 
		query.append("                     , VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("                     , DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("                     , PORT_CD VPS_PORT_CD" ).append("\n"); 
		query.append("                     , SLAN_CD" ).append("\n"); 
		query.append("                     , VPS_ETD_DT" ).append("\n"); 
		query.append("                     , SUM (ALL_TEU) ALL_TEU" ).append("\n"); 
		query.append("                     , SUM (ALL_WGT) ALL_WGT" ).append("\n"); 
		query.append("                     , SUM (GRAND_TTL_SLOT) GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                     , SUM (GRAND_TTL_WGT) GRAND_TTL_WGT" ).append("\n"); 
		query.append("					 , 0 OVER_SLOT" ).append("\n"); 
		query.append("					 , 0 OVER_WGT" ).append("\n"); 
		query.append("                     , SUM (HC_LD_20) HC_LD_20" ).append("\n"); 
		query.append("                     , SUM (HC_BSA_20) HC_BSA_20" ).append("\n"); 
		query.append("                     , SUM (HC_LD_40) HC_LD_40" ).append("\n"); 
		query.append("                     , SUM (HC_BSA_40) HC_BSA_40" ).append("\n"); 
		query.append("                     , SUM (HC_LD_45) HC_LD_45" ).append("\n"); 
		query.append("                     , SUM (HC_BSA_45) HC_BSA_45" ).append("\n"); 
		query.append("                     , SUM (AK_UNIT) AK_UNIT" ).append("\n"); 
		query.append("                     , SUM (AK_VOID) AK_VOID" ).append("\n"); 
		query.append("                     , SUM (RF_20_QTY) RF_20_QTY" ).append("\n"); 
		query.append("                     , SUM (RF_40_QTY) RF_40_QTY" ).append("\n"); 
		query.append("                     , SUM (MT_TEU) MT_TEU" ).append("\n"); 
		query.append("                     , SUM (FULL_20) FULL_20" ).append("\n"); 
		query.append("                     , SUM (MT_20) MT_20" ).append("\n"); 
		query.append("                     , SUM (FULL_40) FULL_40" ).append("\n"); 
		query.append("                     , SUM (MT_40) MT_40" ).append("\n"); 
		query.append("                     , SUM (MT_WT) MT_WT" ).append("\n"); 
		query.append("                     , 'Bay Plan' SOURCE" ).append("\n"); 
		query.append("                  FROM ( " ).append("\n"); 
		query.append("                        /* 20HC, 40HC, 45HC, F20, E20, F40, E40 */" ).append("\n"); 
		query.append("                        SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.PORT_CD PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                             , 0 ALL_TEU" ).append("\n"); 
		query.append("                             , 0 ALL_WGT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                             , SUM(B.WEIGHT) GRAND_TTL_WGT" ).append("\n"); 
		query.append("                             , 0 OVER_SLOT" ).append("\n"); 
		query.append("                             , 0 OVER_WGT" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HF1', 1, 0)) HC_LD_20" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HE1', 1, 0)) HC_BSA_20" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HF0', 1, 0)) HC_LD_40" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE || MOD (B.BAY, 2), 'HE0', 1, 0)) HC_BSA_40" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE, 'LF', 1, 0)) HC_LD_45" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE, 'LE', 1, 0)) HC_BSA_45" ).append("\n"); 
		query.append("                             , 0 AK_UNIT" ).append("\n"); 
		query.append("                             , 0 AK_VOID" ).append("\n"); 
		query.append("                             , 0 RF_20_QTY" ).append("\n"); 
		query.append("                             , 0 RF_40_QTY" ).append("\n"); 
		query.append("                             , 0 MT_TEU" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE, '2F', 1, 0)) FULL_20" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE, '2E', 1, 0)) MT_20" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE, '4F', 1, 0)) FULL_40" ).append("\n"); 
		query.append("                             , SUM (DECODE (B.CNTR_SIZE || B.FE, '4E', 1, 0)) MT_40" ).append("\n"); 
		query.append("                             , 0 MT_WT" ).append("\n"); 
		query.append("                          FROM BAY_PLAN B" ).append("\n"); 
		query.append("                             , VSL K" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                           AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                           AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                           AND B.PLAN_TYPE= 'F'" ).append("\n"); 
		query.append("                           AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%' " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                           AND B.OPR_CD IN (${opr_cd}) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY B.OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                         UNION ALL " ).append("\n"); 
		query.append("                        /* RF20, RF40 */" ).append("\n"); 
		query.append("                        SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.POL PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                             , 0 ALL_TEU" ).append("\n"); 
		query.append("                             , 0 ALL_WGT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_WGT" ).append("\n"); 
		query.append("                             , 0 OVER_SLOT" ).append("\n"); 
		query.append("                             , 0 OVER_WGT" ).append("\n"); 
		query.append("                             , 0 HC_LD_20" ).append("\n"); 
		query.append("                             , 0 HC_BSA_20" ).append("\n"); 
		query.append("                             , 0 HC_LD_40" ).append("\n"); 
		query.append("                             , 0 HC_BSA_40" ).append("\n"); 
		query.append("                             , 0 HC_LD_45" ).append("\n"); 
		query.append("                             , 0 HC_BSA_45" ).append("\n"); 
		query.append("                             , 0 AK_UNIT" ).append("\n"); 
		query.append("                             , 0 AK_VOID" ).append("\n"); 
		query.append("                             , SUM (DECODE (MOD (B.BAY, 2), 1, 1)) RF_20_QTY" ).append("\n"); 
		query.append("                             , SUM (DECODE (MOD (B.BAY, 2), 0, 1)) RF_40_QTY" ).append("\n"); 
		query.append("                             , 0 MT_TEU" ).append("\n"); 
		query.append("                             , 0 FULL_20" ).append("\n"); 
		query.append("                             , 0 MT_20" ).append("\n"); 
		query.append("                             , 0 FULL_40" ).append("\n"); 
		query.append("                             , 0 MT_40" ).append("\n"); 
		query.append("                             , 0 MT_WT" ).append("\n"); 
		query.append("                          FROM BAY_PLAN B" ).append("\n"); 
		query.append("                             , VSL K" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                           AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                           AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                           AND B.CARGO_TYPE = 'RF'" ).append("\n"); 
		query.append("                           AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                           AND B.POL = B.PORT_CD" ).append("\n"); 
		query.append("                           AND B.PORT_CD = K.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%' " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                           AND B.OPR_CD IN (${opr_cd}) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY B.OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.POL" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                         UNION ALL " ).append("\n"); 
		query.append("                        /* empty */" ).append("\n"); 
		query.append("                        SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.PORT_CD PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                             , 0 ALL_TEU" ).append("\n"); 
		query.append("                             , 0 ALL_WGT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_WGT" ).append("\n"); 
		query.append("                             , 0 OVER_SLOT" ).append("\n"); 
		query.append("                             , 0 OVER_WGT" ).append("\n"); 
		query.append("                             , 0 HC_LD_20" ).append("\n"); 
		query.append("                             , 0 HC_BSA_20" ).append("\n"); 
		query.append("                             , 0 HC_LD_40" ).append("\n"); 
		query.append("                             , 0 HC_BSA_40" ).append("\n"); 
		query.append("                             , 0 HC_LD_45" ).append("\n"); 
		query.append("                             , 0 HC_BSA_45" ).append("\n"); 
		query.append("                             , 0 AK_UNIT" ).append("\n"); 
		query.append("                             , 0 AK_VOID" ).append("\n"); 
		query.append("                             , 0 RF_20_QTY" ).append("\n"); 
		query.append("                             , 0 RF_40_QTY" ).append("\n"); 
		query.append("                             , SUM (DECODE (MOD (B.BAY, 2), 0, 2, 1)) MT_TEU" ).append("\n"); 
		query.append("                             , 0 FULL_20" ).append("\n"); 
		query.append("                             , 0 MT_20" ).append("\n"); 
		query.append("                             , 0 FULL_40" ).append("\n"); 
		query.append("                             , 0 MT_40" ).append("\n"); 
		query.append("                             , SUM (B.WEIGHT) MT_WT" ).append("\n"); 
		query.append("                          FROM BAY_PLAN B" ).append("\n"); 
		query.append("                             , VSL K" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                           AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                           AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                           AND B.FE = 'E'" ).append("\n"); 
		query.append("                           AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                           AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%' " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                           AND B.OPR_CD IN (${opr_cd}) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY B.OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                         UNION ALL " ).append("\n"); 
		query.append("                        /* 'AK' UNIT */" ).append("\n"); 
		query.append("                        SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.PORT_CD PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                             , 0 ALL_TEU" ).append("\n"); 
		query.append("                             , 0 ALL_WGT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_WGT" ).append("\n"); 
		query.append("                             , 0 OVER_SLOT" ).append("\n"); 
		query.append("                             , 0 OVER_WGT" ).append("\n"); 
		query.append("                             , 0 HC_LD_20" ).append("\n"); 
		query.append("                             , 0 HC_BSA_20" ).append("\n"); 
		query.append("                             , 0 HC_LD_40" ).append("\n"); 
		query.append("                             , 0 HC_BSA_40" ).append("\n"); 
		query.append("                             , 0 HC_LD_45" ).append("\n"); 
		query.append("                             , 0 HC_BSA_45" ).append("\n"); 
		query.append("                             , COUNT (*) AK_UNIT" ).append("\n"); 
		query.append("                             , 0 AK_VOID" ).append("\n"); 
		query.append("                             , 0 RF_20_QTY" ).append("\n"); 
		query.append("                             , 0 RF_40_QTY" ).append("\n"); 
		query.append("                             , 0 MT_TEU" ).append("\n"); 
		query.append("                             , 0 FULL_20" ).append("\n"); 
		query.append("                             , 0 MT_20" ).append("\n"); 
		query.append("                             , 0 FULL_40" ).append("\n"); 
		query.append("                             , 0 MT_40" ).append("\n"); 
		query.append("                             , 0 MT_WT" ).append("\n"); 
		query.append("                          FROM BAY_PLAN B" ).append("\n"); 
		query.append("                             , VSL K" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                           AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                           AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                           AND ( B.CARGO_TYPE IN ('AK', 'BB')" ).append("\n"); 
		query.append("                                 OR ((B.ACT_SLOT>0 OR B.OVH_SLOT>0 OR B.OVP_SLOT>0 OR B.OVS_SLOT>0 OR B.OVF_SLOT>0 OR B.OVA_SLOT>0))" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                           AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                           AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                           AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%' " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                           AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                           AND B.OPR_CD IN (${opr_cd}) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         GROUP BY B.OPR_CD" ).append("\n"); 
		query.append("                             , B.VSL_CD" ).append("\n"); 
		query.append("                             , B.VOY_NO" ).append("\n"); 
		query.append("                             , B.DIR_CD" ).append("\n"); 
		query.append("                             , B.PORT_CD" ).append("\n"); 
		query.append("                             , K.SLAN_CD" ).append("\n"); 
		query.append("                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                         UNION ALL " ).append("\n"); 
		query.append("                        /* 'AK' Void */" ).append("\n"); 
		query.append("                        SELECT NVL(OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                             , VSL_CD" ).append("\n"); 
		query.append("                             , VOY_NO" ).append("\n"); 
		query.append("                             , DIR_CD" ).append("\n"); 
		query.append("                             , PORT_CD" ).append("\n"); 
		query.append("                             , SLAN_CD" ).append("\n"); 
		query.append("                             , VPS_ETD_DT" ).append("\n"); 
		query.append("                             , 0 ALL_TEU" ).append("\n"); 
		query.append("                             , 0 ALL_WGT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_WGT" ).append("\n"); 
		query.append("                             , 0 OVER_SLOT" ).append("\n"); 
		query.append("                             , 0 OVER_WGT" ).append("\n"); 
		query.append("                             , 0 HC_LD_20" ).append("\n"); 
		query.append("                             , 0 HC_BSA_20" ).append("\n"); 
		query.append("                             , 0 HC_LD_40" ).append("\n"); 
		query.append("                             , 0 HC_BSA_40" ).append("\n"); 
		query.append("                             , 0 HC_LD_45" ).append("\n"); 
		query.append("                             , 0 HC_BSA_45" ).append("\n"); 
		query.append("                             , 0 AK_UNIT" ).append("\n"); 
		query.append("                             , SUM (CASE WHEN ACT_SLOT <> '' THEN TO_NUMBER(ACT_SLOT)" ).append("\n"); 
		query.append("                                         WHEN X * Y * Z > 0 THEN (X + 1) * (Y + 1) * (Z + 1) * S - S" ).append("\n"); 
		query.append("                                         WHEN X * Y > 0 THEN (X + 1) * (Y + 1) * S - S" ).append("\n"); 
		query.append("                                         WHEN X * Z > 0 THEN (X + 1) * (Z + 1) - 1 + X * (S - 1)" ).append("\n"); 
		query.append("                                         WHEN Y * Z > 0 THEN (Y + 1) * (Z + 1) - 1 + Y * (S - 1)" ).append("\n"); 
		query.append("                                         WHEN X + Y > 0 THEN (X + Y + 1) * S - S" ).append("\n"); 
		query.append("                                         WHEN Z > 0 THEN Z" ).append("\n"); 
		query.append("                                         ELSE 0" ).append("\n"); 
		query.append("                                       END) AS AK_VOID" ).append("\n"); 
		query.append("                             , 0 RF_20_QTY" ).append("\n"); 
		query.append("                             , 0 RF_40_QTY" ).append("\n"); 
		query.append("                             , 0 MT_TEU" ).append("\n"); 
		query.append("                             , 0 FULL_20" ).append("\n"); 
		query.append("                             , 0 MT_20" ).append("\n"); 
		query.append("                             , 0 FULL_40" ).append("\n"); 
		query.append("                             , 0 MT_40" ).append("\n"); 
		query.append("                             , 0 MT_WT" ).append("\n"); 
		query.append("                          FROM (SELECT NVL(B.OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                                     , B.VSL_CD" ).append("\n"); 
		query.append("                                     , B.VOY_NO" ).append("\n"); 
		query.append("                                     , B.DIR_CD" ).append("\n"); 
		query.append("                                     , B.PORT_CD" ).append("\n"); 
		query.append("                                     , K.SLAN_CD" ).append("\n"); 
		query.append("                                     , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                                     , NVL (B.OVP_SLOT, 0) + NVL (B.OVS_SLOT, 0) X" ).append("\n"); 
		query.append("                                     , NVL (B.OVH_SLOT, 0) Y" ).append("\n"); 
		query.append("                                     , NVL (B.OVA_SLOT, 0) + NVL (B.OVF_SLOT, 0) Z" ).append("\n"); 
		query.append("                                     , (2 - MOD (B.BAY, 2)) S" ).append("\n"); 
		query.append("                                     , ACT_SLOT" ).append("\n"); 
		query.append("                                  FROM BAY_PLAN B" ).append("\n"); 
		query.append("                                     , VSL K" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                   AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                                   AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                                   AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                                   AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                                   AND ( B.CARGO_TYPE IN ('AK', 'BB')" ).append("\n"); 
		query.append("                                           OR ((B.ACT_SLOT>0 OR B.OVH_SLOT>0 OR B.OVP_SLOT>0 OR B.OVS_SLOT>0 OR B.OVF_SLOT>0 OR B.OVA_SLOT>0))" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                                   AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                                   AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                                   AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%' " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                                   AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                                   AND B.OPR_CD IN (${opr_cd}) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                         GROUP BY OPR_CD" ).append("\n"); 
		query.append("                             , VSL_CD" ).append("\n"); 
		query.append("                             , VOY_NO" ).append("\n"); 
		query.append("                             , DIR_CD" ).append("\n"); 
		query.append("                             , PORT_CD" ).append("\n"); 
		query.append("                             , SLAN_CD" ).append("\n"); 
		query.append("                             , VPS_ETD_DT" ).append("\n"); 
		query.append("                         UNION ALL " ).append("\n"); 
		query.append("                        /*Allocation TEU/WT*/" ).append("\n"); 
		query.append("                        SELECT NVL(OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                             , VSL_CD" ).append("\n"); 
		query.append("                             , VOY_NO" ).append("\n"); 
		query.append("                             , DIR_CD" ).append("\n"); 
		query.append("                             , PORT_CD" ).append("\n"); 
		query.append("                             , SLAN_CD" ).append("\n"); 
		query.append("                             , VPS_ETD_DT" ).append("\n"); 
		query.append("                             , ALL_TEU" ).append("\n"); 
		query.append("                             , ALL_WGT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_SLOT" ).append("\n"); 
		query.append("                             , 0 GRAND_TTL_WGT" ).append("\n"); 
		query.append("                             , 0 OVER_SLOT" ).append("\n"); 
		query.append("                             , 0 OVER_WGT" ).append("\n"); 
		query.append("                             , 0 HC_LD_20" ).append("\n"); 
		query.append("                             , 0 HC_BSA_20" ).append("\n"); 
		query.append("                             , 0 HC_LD_40" ).append("\n"); 
		query.append("                             , 0 HC_BSA_40" ).append("\n"); 
		query.append("                             , 0 HC_LD_45" ).append("\n"); 
		query.append("                             , 0 HC_BSA_45" ).append("\n"); 
		query.append("                             , 0 AK_UNIT" ).append("\n"); 
		query.append("                             , 0 AK_VOID" ).append("\n"); 
		query.append("                             , 0 RF_20_QTY" ).append("\n"); 
		query.append("                             , 0 RF_40_QTY" ).append("\n"); 
		query.append("                             , 0 MT_TEU" ).append("\n"); 
		query.append("                             , 0 FULL_20" ).append("\n"); 
		query.append("                             , 0 MT_20" ).append("\n"); 
		query.append("                             , 0 FULL_40" ).append("\n"); 
		query.append("                             , 0 MT_40" ).append("\n"); 
		query.append("                             , 0 MT_WT" ).append("\n"); 
		query.append("                          FROM (SELECT A.OPR_CD" ).append("\n"); 
		query.append("                                     , A.VSL_CD" ).append("\n"); 
		query.append("                                     , A.VOY_NO" ).append("\n"); 
		query.append("                                     , A.DIR_CD" ).append("\n"); 
		query.append("                                     , A.PORT_CD" ).append("\n"); 
		query.append("                                     , A.CALL_IND" ).append("\n"); 
		query.append("                                     , A.SLAN_CD" ).append("\n"); 
		query.append("                                     , A.VPS_ETD_DT" ).append("\n"); 
		query.append("                                     , NVL(SUM(C.ALL_TEU),0) AS ALL_TEU" ).append("\n"); 
		query.append("                                     , NVL(SUM(C.ALL_WGT),0) AS ALL_WGT" ).append("\n"); 
		query.append("                                  FROM (SELECT DISTINCT NVL(B.OPR_CD, 'ZZZ') OPR_CD" ).append("\n"); 
		query.append("                                             , B.VSL_CD" ).append("\n"); 
		query.append("                                             , B.VOY_NO" ).append("\n"); 
		query.append("                                             , B.DIR_CD" ).append("\n"); 
		query.append("                                             , B.PORT_CD" ).append("\n"); 
		query.append("                                             , B.CALL_IND" ).append("\n"); 
		query.append("                                             , K.SLAN_CD" ).append("\n"); 
		query.append("                                             , TO_CHAR (K.VPS_ETD_DT, 'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("                                          FROM BAY_PLAN B" ).append("\n"); 
		query.append("                                             , VSL K" ).append("\n"); 
		query.append("                                         WHERE 1=1" ).append("\n"); 
		query.append("                                           AND K.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                                           AND K.SKD_VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("                                           AND K.SKD_DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("                                           AND K.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("                                           AND K.CLPT_IND_SEQ = B.CALL_IND" ).append("\n"); 
		query.append("                                           AND B.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("                                           AND K.SLAN_CD LIKE @[rlane_cd] || '%'" ).append("\n"); 
		query.append("                                           AND K.SKD_DIR_CD LIKE @[skd_dir_cd] || '%' " ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("                                           AND B.VSL_CD || B.VOY_NO || B.DIR_CD LIKE @[vvd] || '%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("                                           AND B.OPR_CD IN (${opr_cd}) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                                       ) A" ).append("\n"); 
		query.append("                                     , (SELECT H.VSL_CD" ).append("\n"); 
		query.append("                                             , H.VOY_NO" ).append("\n"); 
		query.append("                                             , H.DIR_CD" ).append("\n"); 
		query.append("                                             , H.PORT_CD" ).append("\n"); 
		query.append("                                             , H.CALL_IND" ).append("\n"); 
		query.append("                                             , A.OPR_CD" ).append("\n"); 
		query.append("                                             , NVL(SUM(A.BSA_SLOT),0) + NVL(SUM(A.SWAP_SLOT),0) + NVL(SUM(A.RELEASE_SLOT),0) AS ALL_TEU" ).append("\n"); 
		query.append("                                             , NVL(SUM(A.BSA_WGT),0) + NVL(SUM(A.SWAP_WGT),0) + NVL(SUM(A.RELEASE_WGT),0) AS ALL_WGT" ).append("\n"); 
		query.append("                                          FROM TDR_HEADER H" ).append("\n"); 
		query.append("                                             , TDR_ALLOCATION A" ).append("\n"); 
		query.append("                                             , VSL K" ).append("\n"); 
		query.append("                                         WHERE H.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                                           AND H.VOY_NO = A.VOY_NO" ).append("\n"); 
		query.append("                                           AND H.DIR_CD = A.DIR_CD" ).append("\n"); 
		query.append("                                           AND H.PORT_CD = A.PORT_CD" ).append("\n"); 
		query.append("                                           AND H.CALL_IND = A.CALL_IND" ).append("\n"); 
		query.append("                                           AND A.VSL_CD = K.VSL_CD" ).append("\n"); 
		query.append("                                           AND A.VOY_NO = K.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND A.DIR_CD = K.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND A.PORT_CD = K.VPS_PORT_CD" ).append("\n"); 
		query.append("                                           AND A.CALL_IND = K.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                         GROUP BY H.VSL_CD" ).append("\n"); 
		query.append("                                             , H.VOY_NO" ).append("\n"); 
		query.append("                                             , H.DIR_CD" ).append("\n"); 
		query.append("                                             , H.PORT_CD" ).append("\n"); 
		query.append("                                             , H.CALL_IND" ).append("\n"); 
		query.append("                                             , A.OPR_CD ) C" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("                                   AND A.VOY_NO = C.VOY_NO(+)" ).append("\n"); 
		query.append("                                   AND A.DIR_CD = C.DIR_CD(+)" ).append("\n"); 
		query.append("                                   AND A.PORT_CD = C.PORT_CD(+)" ).append("\n"); 
		query.append("                                   AND A.CALL_IND = C.CALL_IND(+)" ).append("\n"); 
		query.append("                                   AND A.OPR_CD = C.OPR_CD(+)" ).append("\n"); 
		query.append("                                 GROUP BY A.OPR_CD" ).append("\n"); 
		query.append("                                     , A.VSL_CD" ).append("\n"); 
		query.append("                                     , A.VOY_NO" ).append("\n"); 
		query.append("                                     , A.DIR_CD" ).append("\n"); 
		query.append("                                     , A.PORT_CD" ).append("\n"); 
		query.append("                                     , A.CALL_IND" ).append("\n"); 
		query.append("                                     , A.SLAN_CD" ).append("\n"); 
		query.append("                                     , A.VPS_ETD_DT ) )" ).append("\n"); 
		query.append("                 GROUP BY OPR_CD" ).append("\n"); 
		query.append("                     , VSL_CD" ).append("\n"); 
		query.append("                     , VOY_NO" ).append("\n"); 
		query.append("                     , DIR_CD" ).append("\n"); 
		query.append("                     , PORT_CD" ).append("\n"); 
		query.append("                     , SLAN_CD" ).append("\n"); 
		query.append("                     , VPS_ETD_DT " ).append("\n"); 
		query.append("             ) A " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" ORDER BY 2, 8, 6, 1" ).append("\n"); 

	}
}