/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : FACCommCalculationDBDAOModifyAGNBKGInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACCommCalculationDBDAOModifyAGNBKGInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FACCommCalculationDBDAOModifyAGNBKGInfoUSQL
	  * 
	  * 2015.11.06 Sang-Hyun Kim [CHM-201538500] PDM Rev. Lane 귀속 로직 변경 관련 ACM 처리 요청
	  *  - Revenue Lane direct code 조회 쿼리 변경(AR_FINC_DIR_CONV 조회 쿼리 변경 - POD 조건 추가)
	  * </pre>
	  */
	public FACCommCalculationDBDAOModifyAGNBKGInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_proc_rslt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.integration").append("\n"); 
		query.append("FileName : FACCommCalculationDBDAOModifyAGNBKGInfoUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_AGN_BKG_INFO TBL" ).append("\n"); 
		query.append("USING (SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("         (SELECT CASE WHEN BKG.BKG_STS_CD = 'X' THEN 1" ).append("\n"); 
		query.append("                      WHEN DOC.BL_CVRD_TP_CD = 'B' THEN 1" ).append("\n"); 
		query.append("                      WHEN DOC.BL_CVRD_TP_CD = 'C' THEN 1" ).append("\n"); 
		query.append("                      ELSE 0" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("          FROM BKG_BL_DOC DOC" ).append("\n"); 
		query.append("          WHERE DOC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("         ) AS WDR_CHK," ).append("\n"); 
		query.append("         BKG.BL_NO," ).append("\n"); 
		query.append("         BKG.BL_NO_TP," ).append("\n"); 
		query.append("         BKG.BL_TP_CD," ).append("\n"); 
		query.append("         BKG.BKG_STS_CD," ).append("\n"); 
		query.append("         BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("         DOC.BL_CVRD_TP_CD," ).append("\n"); 
		query.append("         BKG.CHN_AGN_CD AS CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("         BKG.BKG_OFC_CD," ).append("\n"); 
		query.append("         CRB.CLT_OFC_CD," ).append("\n"); 
		query.append("         BKG.BKG_CRE_DT," ).append("\n"); 
		query.append("         DOC.BDR_FLG," ).append("\n"); 
		query.append("         DOC.BDR_DT," ).append("\n"); 
		query.append("         BKG.POR_CD," ).append("\n"); 
		query.append("         BAR.POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("         BAR.POR_AR_OFC_CD," ).append("\n"); 
		query.append("         BKG.POL_CD," ).append("\n"); 
		query.append("         BAR.POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("         BAR.POL_AR_OFC_CD," ).append("\n"); 
		query.append("         BKG.POD_CD," ).append("\n"); 
		query.append("         BAR.POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("         BAR.POD_AR_OFC_CD," ).append("\n"); 
		query.append("         BKG.DEL_CD," ).append("\n"); 
		query.append("         BAR.DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("         BAR.DEL_AR_OFC_CD," ).append("\n"); 
		query.append("         BKG.RCV_TERM_CD AS BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("         BKG.DE_TERM_CD AS BKG_DE_TERM_CD," ).append("\n"); 
		query.append("         CRB.TRD_CD, -- [CHM-201324678] ACM 계산 시, Trade 정보 source 변경 요청" ).append("\n"); 
		query.append("         BKG.SLAN_CD," ).append("\n"); 
		query.append("         CASE MAS_RANK_INFO_FNC(NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'), -- N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END, -- N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END, -- N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END, -- N4TH_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL1.LOC_CD, NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD1.LOC_CD, NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD1.LOC_CD, NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N1ST_CONTI" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL2.LOC_CD, ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD2.LOC_CD, ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD2.LOC_CD, ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N2ND_CONTI" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL3.LOC_CD, ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD3.LOC_CD, ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD3.LOC_CD, ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N3RD_CONTI" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL4.LOC_CD, ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD4.LOC_CD, ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD4.LOC_CD, ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N4TH_CONTI" ).append("\n"); 
		query.append("                                  VV1.VSL_CD || VV1.SKD_VOY_NO || VV1.SKD_DIR_CD," ).append("\n"); 
		query.append("                                  VV2.VSL_CD || VV2.SKD_VOY_NO || VV2.SKD_DIR_CD," ).append("\n"); 
		query.append("                                  VV3.VSL_CD || VV3.SKD_VOY_NO || VV3.SKD_DIR_CD," ).append("\n"); 
		query.append("                                  VV4.VSL_CD || VV4.SKD_VOY_NO || VV4.SKD_DIR_CD " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           WHEN 1 THEN NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO')" ).append("\n"); 
		query.append("           WHEN 2 THEN CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END" ).append("\n"); 
		query.append("           WHEN 3 THEN CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END" ).append("\n"); 
		query.append("           WHEN 4 THEN CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END" ).append("\n"); 
		query.append("         END AS RLANE_CD," ).append("\n"); 
		query.append("         CASE MAS_RANK_INFO_FNC(NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'), -- N1ST_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN VV2.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD) END, -- N2ND_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN VV3.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD) END, -- N3RD_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN VV4.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD) END, -- N4TH_RLANE_CD" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL1.LOC_CD, NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD1.LOC_CD, NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD1.LOC_CD, NVL(ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD), 'RBCCO'))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N1ST_CONTI" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL2.LOC_CD, ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD2.LOC_CD, ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD2.LOC_CD, ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N2ND_CONTI" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL3.LOC_CD, ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD3.LOC_CD, ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD3.LOC_CD, ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N3RD_CONTI" ).append("\n"); 
		query.append("                                  CASE WHEN ACM_GET_CONTI_FNC(POL4.LOC_CD, ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD))" ).append("\n"); 
		query.append("                                              = ACM_GET_CONTI_FNC(POD4.LOC_CD, ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD))" ).append("\n"); 
		query.append("                                         THEN 'I' || ACM_GET_CONTI_FNC(POD4.LOC_CD, ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD))" ).append("\n"); 
		query.append("                                       ELSE 'OO'" ).append("\n"); 
		query.append("                                  END, -- N4TH_CONTI" ).append("\n"); 
		query.append("                                  VV1.VSL_CD || VV1.SKD_VOY_NO || VV1.SKD_DIR_CD," ).append("\n"); 
		query.append("                                  VV2.VSL_CD || VV2.SKD_VOY_NO || VV2.SKD_DIR_CD," ).append("\n"); 
		query.append("                                  VV3.VSL_CD || VV3.SKD_VOY_NO || VV3.SKD_DIR_CD," ).append("\n"); 
		query.append("                                  VV4.VSL_CD || VV4.SKD_VOY_NO || VV4.SKD_DIR_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("           WHEN 1 THEN NVL(CASE 'RBCCO' WHEN ACM_GET_RLANE_FNC(VV1.SLAN_CD, VV1.POL_CD, VV1.POD_CD)" ).append("\n"); 
		query.append("                                          THEN 'CFDR' || TO_CHAR(SYSDATE, 'YYMM') || 'EE'" ).append("\n"); 
		query.append("                           END," ).append("\n"); 
		query.append("                           VV1.VSL_CD || VV1.SKD_VOY_NO || VV1.SKD_DIR_CD || NVL((SELECT NVL(POD_RLANE_DIR_CD, RLANE_DIR_CD) RLANE_DIR_CD" ).append("\n"); 
		query.append("                                                                                  FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append("                                                                                  WHERE SLAN_CD = VV1.SLAN_CD" ).append("\n"); 
		query.append("                                                                                    AND SCONTI_CD = POL1.SCONTI_CD" ).append("\n"); 
		query.append("                                                                                    AND SLAN_DIR_CD = VV1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                    AND NVL(POD_CONTI_CD, '*') = CASE WHEN POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                                                                                                      WHEN POD_CONTI_CD IS NOT NULL THEN POD1.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                 END" ).append("\n"); 
		query.append("                                                                                 ), VV1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                             )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           WHEN 2 THEN NVL(CASE 'RBCCO' WHEN ACM_GET_RLANE_FNC(VV2.SLAN_CD, VV2.POL_CD, VV2.POD_CD)" ).append("\n"); 
		query.append("                                          THEN 'CFDR' || TO_CHAR(SYSDATE, 'YYMM') || 'EE'" ).append("\n"); 
		query.append("                           END," ).append("\n"); 
		query.append("                           VV2.VSL_CD || VV2.SKD_VOY_NO || VV2.SKD_DIR_CD || NVL((SELECT NVL(POD_RLANE_DIR_CD, RLANE_DIR_CD) RLANE_DIR_CD" ).append("\n"); 
		query.append("                                                                                  FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append("                                                                                  WHERE SLAN_CD = VV2.SLAN_CD" ).append("\n"); 
		query.append("                                                                                    AND SCONTI_CD = POL2.SCONTI_CD" ).append("\n"); 
		query.append("                                                                                    AND SLAN_DIR_CD = VV2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                    AND NVL(POD_CONTI_CD, '*') = CASE WHEN POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                                                                                                      WHEN POD_CONTI_CD IS NOT NULL THEN POD2.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                 END" ).append("\n"); 
		query.append("                                                                                 )," ).append("\n"); 
		query.append("                                                                                 VV2.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                             )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           WHEN 3 THEN NVL(CASE 'RBCCO' WHEN ACM_GET_RLANE_FNC(VV3.SLAN_CD, VV3.POL_CD, VV3.POD_CD)" ).append("\n"); 
		query.append("                                          THEN 'CFDR' || TO_CHAR(SYSDATE, 'YYMM') || 'EE'" ).append("\n"); 
		query.append("                           END," ).append("\n"); 
		query.append("                           VV3.VSL_CD || VV3.SKD_VOY_NO || VV3.SKD_DIR_CD || NVL((SELECT NVL(POD_RLANE_DIR_CD, RLANE_DIR_CD) RLANE_DIR_CD" ).append("\n"); 
		query.append("                                                                                  FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append("                                                                                  WHERE SLAN_CD = VV3.SLAN_CD" ).append("\n"); 
		query.append("                                                                                    AND SCONTI_CD = POL3.SCONTI_CD" ).append("\n"); 
		query.append("                                                                                    AND SLAN_DIR_CD = VV3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                    AND NVL(POD_CONTI_CD, '*') = CASE WHEN POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                                                                                                      WHEN POD_CONTI_CD IS NOT NULL THEN POD3.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                 END" ).append("\n"); 
		query.append("                                                                                 )," ).append("\n"); 
		query.append("                                                                                 VV3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                             )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           WHEN 4 THEN NVL(CASE 'RBCCO' WHEN ACM_GET_RLANE_FNC(VV4.SLAN_CD, VV4.POL_CD, VV4.POD_CD)" ).append("\n"); 
		query.append("                                          THEN 'CFDR' || TO_CHAR(SYSDATE, 'YYMM') || 'EE'" ).append("\n"); 
		query.append("                           END," ).append("\n"); 
		query.append("                           VV4.VSL_CD || VV4.SKD_VOY_NO || VV4.SKD_DIR_CD || NVL((SELECT NVL(POD_RLANE_DIR_CD, RLANE_DIR_CD) RLANE_DIR_CD" ).append("\n"); 
		query.append("                                                                                  FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append("                                                                                  WHERE SLAN_CD = VV4.SLAN_CD" ).append("\n"); 
		query.append("                                                                                    AND SCONTI_CD = POL4.SCONTI_CD" ).append("\n"); 
		query.append("                                                                                    AND SLAN_DIR_CD = VV4.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                    AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                                                    AND NVL(POD_CONTI_CD, '*') = CASE WHEN POD_CONTI_CD IS NULL THEN '*'" ).append("\n"); 
		query.append("                                                                                                                      WHEN POD_CONTI_CD IS NOT NULL THEN POD4.CONTI_CD" ).append("\n"); 
		query.append("                                                                                                                 END" ).append("\n"); 
		query.append("                                                                                 )," ).append("\n"); 
		query.append("                                                                                 VV4.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                             )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("         END AS REV_VVD_CD," ).append("\n"); 
		query.append("         BKG.SLAN_CD AS TRNK_SLAN_CD," ).append("\n"); 
		query.append("         BKG.SLAN_CD || POL.CONTI_CD || POD.CONTI_CD AS TRNK_RLANE_CD, -- TRUNK의 RLANE_CD(TRUNK의 SLAN_CD(3자리) + POL의 CONTI(1자리) + POD의 CONTI(1자리))" ).append("\n"); 
		query.append("         BKG.VSL_CD AS TRNK_VSL_CD," ).append("\n"); 
		query.append("         BKG.SKD_VOY_NO AS TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("         BKG.SKD_DIR_CD AS TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("         BKG.REV_DIR_CD AS TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("         BKG.SVC_SCP_CD AS SVC_SCP_CD," ).append("\n"); 
		query.append("         NVL(BKG.PRE_RLY_PORT_CD, '*') AS PRE_PORT_CD," ).append("\n"); 
		query.append("         NVL(BKG.PST_RLY_PORT_CD, '*') AS PST_PORT_CD," ).append("\n"); 
		query.append("         (SELECT CASE WHEN BKG.BKG_STS_CD = 'X' THEN 'BKG Canceled'" ).append("\n"); 
		query.append("                      WHEN DOC.BL_CVRD_TP_CD = 'B' THEN 'BL No[' || BKG.BL_NO || '] is CO-BIZ BL!'" ).append("\n"); 
		query.append("                      WHEN DOC.BL_CVRD_TP_CD = 'C' THEN 'BL No[' || BKG.BL_NO || '] is Covered BL!'" ).append("\n"); 
		query.append("                      ELSE @[comm_proc_rslt_rsn] " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("          FROM BKG_BL_DOC DOC" ).append("\n"); 
		query.append("          WHERE DOC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("         ) AS COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("         'ACM SYSTEM' AS UPD_USR_ID," ).append("\n"); 
		query.append("         SYSDATE AS UPD_DT," ).append("\n"); 
		query.append("         'ACM SYSTEM' AS CRE_USR_ID," ).append("\n"); 
		query.append("         SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("       FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("         MDM_LOCATION POL," ).append("\n"); 
		query.append("         MDM_LOCATION POD," ).append("\n"); 
		query.append("         BKG_VVD VV1," ).append("\n"); 
		query.append("         BKG_VVD VV2," ).append("\n"); 
		query.append("         BKG_VVD VV3," ).append("\n"); 
		query.append("         BKG_VVD VV4," ).append("\n"); 
		query.append("         MDM_LOCATION POL1," ).append("\n"); 
		query.append("         MDM_LOCATION POD1," ).append("\n"); 
		query.append("         MDM_LOCATION POL2," ).append("\n"); 
		query.append("         MDM_LOCATION POD2," ).append("\n"); 
		query.append("         MDM_LOCATION POL3," ).append("\n"); 
		query.append("         MDM_LOCATION POD3," ).append("\n"); 
		query.append("         MDM_LOCATION POL4," ).append("\n"); 
		query.append("         MDM_LOCATION POD4," ).append("\n"); 
		query.append("         BKG_BL_DOC DOC," ).append("\n"); 
		query.append("         MAS_RGST_BKG CRB," ).append("\n"); 
		query.append("         (SELECT B.BKG_NO," ).append("\n"); 
		query.append("            B.BKG_OFC_CD," ).append("\n"); 
		query.append("            OB.AR_OFC_CD AS BKG_OFC_AR," ).append("\n"); 
		query.append("            B.POR_CD," ).append("\n"); 
		query.append("            L1.FINC_CTRL_OFC_CD AS POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("            O1.AR_OFC_CD AS POR_AR_OFC_CD," ).append("\n"); 
		query.append("            B.POL_CD," ).append("\n"); 
		query.append("            L2.FINC_CTRL_OFC_CD AS POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("            O2.AR_OFC_CD AS POL_AR_OFC_CD," ).append("\n"); 
		query.append("            B.POD_CD," ).append("\n"); 
		query.append("            L3.FINC_CTRL_OFC_CD AS POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("            O3.AR_OFC_CD AS POD_AR_OFC_CD," ).append("\n"); 
		query.append("            B.DEL_CD," ).append("\n"); 
		query.append("            L4.FINC_CTRL_OFC_CD AS DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("            O4.AR_OFC_CD AS DEL_AR_OFC_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING B," ).append("\n"); 
		query.append("            MDM_LOCATION L1," ).append("\n"); 
		query.append("            MDM_LOCATION L2," ).append("\n"); 
		query.append("            MDM_LOCATION L3," ).append("\n"); 
		query.append("            MDM_LOCATION L4," ).append("\n"); 
		query.append("            MDM_ORGANIZATION OB," ).append("\n"); 
		query.append("            MDM_ORGANIZATION O1," ).append("\n"); 
		query.append("            MDM_ORGANIZATION O2," ).append("\n"); 
		query.append("            MDM_ORGANIZATION O3," ).append("\n"); 
		query.append("            MDM_ORGANIZATION O4" ).append("\n"); 
		query.append("          WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND B.POR_CD = L1.LOC_CD" ).append("\n"); 
		query.append("            AND B.POL_CD = L2.LOC_CD" ).append("\n"); 
		query.append("            AND B.POD_CD = L3.LOC_CD" ).append("\n"); 
		query.append("            AND B.DEL_CD = L4.LOC_CD" ).append("\n"); 
		query.append("            AND B.BKG_OFC_CD = OB.OFC_CD " ).append("\n"); 
		query.append("            AND L1.FINC_CTRL_OFC_CD = O1.OFC_CD" ).append("\n"); 
		query.append("            AND L2.FINC_CTRL_OFC_CD = O2.OFC_CD" ).append("\n"); 
		query.append("            AND L3.FINC_CTRL_OFC_CD = O3.OFC_CD" ).append("\n"); 
		query.append("            AND L4.FINC_CTRL_OFC_CD = O4.OFC_CD" ).append("\n"); 
		query.append("         ) BAR" ).append("\n"); 
		query.append("       WHERE BKG.BKG_NO = BAR.BKG_NO" ).append("\n"); 
		query.append("         AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("         AND BKG.BKG_NO = CRB.BKG_NO" ).append("\n"); 
		query.append("         AND BKG.POL_CD = POL.LOC_CD(+)" ).append("\n"); 
		query.append("         AND BKG.POD_CD = POD.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV1.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("         AND VV1.POL_CD = BKG.POL_CD" ).append("\n"); 
		query.append("         AND VV1.BKG_NO = VV2.BKG_NO(+)" ).append("\n"); 
		query.append("         AND VV2.BKG_NO = VV3.BKG_NO(+)" ).append("\n"); 
		query.append("         AND VV3.BKG_NO = VV4.BKG_NO(+)" ).append("\n"); 
		query.append("         AND VV1.POL_CD = VV2.POD_CD(+)" ).append("\n"); 
		query.append("         AND VV2.POL_CD = VV3.POD_CD(+)" ).append("\n"); 
		query.append("         AND VV3.POL_CD = VV4.POD_CD(+)" ).append("\n"); 
		query.append("         AND VV1.POL_CD = POL1.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV2.POL_CD = POL2.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV3.POL_CD = POL3.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV4.POL_CD = POL4.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV1.POD_CD = POD1.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV2.POD_CD = POD2.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV3.POD_CD = POD3.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV4.POD_CD = POD4.LOC_CD(+)" ).append("\n"); 
		query.append("         AND VV1.VSL_SEQ <= '1'" ).append("\n"); 
		query.append("         AND VV1.VSL_PRE_PST_CD IN (CASE WHEN EXISTS(SELECT 1" ).append("\n"); 
		query.append("                                                     FROM BKG_VVD VV0" ).append("\n"); 
		query.append("                                                     WHERE VV0.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("                                                       AND VV0.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                           THEN 'S'" ).append("\n"); 
		query.append("                                         ELSE 'T'" ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                                   )" ).append("\n"); 
		query.append("         AND VV1.VSL_PRE_PST_CD = (CASE WHEN VV2.VSL_PRE_PST_CD(+) = 'T' AND VV1.VSL_SEQ < NVL((SELECT MAX(VV0.VSL_SEQ)" ).append("\n"); 
		query.append("                                                                                                FROM BKG_VVD VV0" ).append("\n"); 
		query.append("                                                                                                WHERE VV0.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("                                                                                                  AND VV0.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                                                                               )," ).append("\n"); 
		query.append("                                                                                               0" ).append("\n"); 
		query.append("                                                                                           )" ).append("\n"); 
		query.append("                                          THEN 'X'" ).append("\n"); 
		query.append("                                        WHEN VV2.VSL_PRE_PST_CD(+) = 'T' THEN 'S'" ).append("\n"); 
		query.append("                                        WHEN VV2.VSL_PRE_PST_CD(+) = 'S' THEN 'S'" ).append("\n"); 
		query.append("                                        WHEN VV2.VSL_PRE_PST_CD(+) = 'U' AND VV2.VSL_SEQ(+) = '1' THEN 'T'" ).append("\n"); 
		query.append("                                        WHEN VV2.VSL_PRE_PST_CD(+) = 'U' AND VV2.VSL_SEQ(+) <> '1' THEN 'U'" ).append("\n"); 
		query.append("                                        ELSE VV1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("         AND VV2.VSL_PRE_PST_CD = (CASE WHEN VV3.VSL_PRE_PST_CD(+) = 'S' THEN 'S'" ).append("\n"); 
		query.append("                                        WHEN VV3.VSL_PRE_PST_CD(+) = 'T' THEN 'S'" ).append("\n"); 
		query.append("                                        WHEN VV3.VSL_PRE_PST_CD(+) = 'U' AND VV3.VSL_SEQ(+) = '1' THEN 'T'" ).append("\n"); 
		query.append("                                        WHEN VV3.VSL_PRE_PST_CD(+) = 'U' AND VV3.VSL_SEQ(+) <> '1' THEN 'U'" ).append("\n"); 
		query.append("                                        ELSE VV2.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("         AND VV3.VSL_PRE_PST_CD = (CASE WHEN VV4.VSL_PRE_PST_CD(+) = 'T' THEN 'S'" ).append("\n"); 
		query.append("                                        WHEN VV4.VSL_PRE_PST_CD(+) = 'U' AND VV4.VSL_SEQ(+) = '1' THEN 'T'" ).append("\n"); 
		query.append("                                        WHEN VV4.VSL_PRE_PST_CD(+) = 'U' AND VV4.VSL_SEQ(+) <> '1' THEN 'U'" ).append("\n"); 
		query.append("                                        ELSE VV3.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("         AND VV2.VSL_SEQ = (CASE WHEN VV3.VSL_PRE_PST_CD(+) = 'S' THEN VV3.VSL_SEQ(+) - 1" ).append("\n"); 
		query.append("                                 WHEN VV3.VSL_PRE_PST_CD(+) = 'U' THEN VV3.VSL_SEQ(+) - 1" ).append("\n"); 
		query.append("                                 ELSE VV2.VSL_SEQ" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("         AND VV3.VSL_SEQ = (CASE WHEN VV4.VSL_PRE_PST_CD(+) = 'S' THEN VV4.VSL_SEQ(+) - 1" ).append("\n"); 
		query.append("                                 WHEN VV4.VSL_PRE_PST_CD(+) = 'U' THEN VV4.VSL_SEQ(+) - 1" ).append("\n"); 
		query.append("                                 ELSE VV3.VSL_SEQ" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("  ) PSD" ).append("\n"); 
		query.append("ON (TBL.BKG_NO = PSD.BKG_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET TBL.BL_NO = PSD.BL_NO," ).append("\n"); 
		query.append("    TBL.BL_NO_TP = PSD.BL_NO_TP," ).append("\n"); 
		query.append("    TBL.BL_TP_CD = PSD.BL_TP_CD," ).append("\n"); 
		query.append("    TBL.BKG_STS_CD = PSD.BKG_STS_CD," ).append("\n"); 
		query.append("    TBL.BKG_CGO_TP_CD = PSD.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    TBL.BL_CVRD_TP_CD = PSD.BL_CVRD_TP_CD," ).append("\n"); 
		query.append("    TBL.CHN_BKG_AGN_CD = PSD.CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("    TBL.BKG_OFC_CD = PSD.BKG_OFC_CD," ).append("\n"); 
		query.append("    TBL.CLT_OFC_CD = PSD.CLT_OFC_CD," ).append("\n"); 
		query.append("    TBL.BKG_CRE_DT = PSD.BKG_CRE_DT," ).append("\n"); 
		query.append("    TBL.BDR_FLG = PSD.BDR_FLG," ).append("\n"); 
		query.append("    TBL.BDR_DT = PSD.BDR_DT," ).append("\n"); 
		query.append("    TBL.POR_CD = PSD.POR_CD," ).append("\n"); 
		query.append("    TBL.POR_FINC_CTRL_OFC_CD = PSD.POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.POR_AR_OFC_CD = PSD.POR_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.POL_CD = PSD.POL_CD," ).append("\n"); 
		query.append("    TBL.POL_FINC_CTRL_OFC_CD = PSD.POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.POL_AR_OFC_CD = PSD.POL_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.POD_CD = PSD.POD_CD," ).append("\n"); 
		query.append("    TBL.POD_FINC_CTRL_OFC_CD = PSD.POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.POD_AR_OFC_CD = PSD.POD_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.DEL_CD = PSD.DEL_CD," ).append("\n"); 
		query.append("    TBL.DEL_FINC_CTRL_OFC_CD = PSD.DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.DEL_AR_OFC_CD = PSD.DEL_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.BKG_RCV_TERM_CD = PSD.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("    TBL.BKG_DE_TERM_CD = PSD.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("    TBL.TRD_CD = PSD.TRD_CD,TBL.SLAN_CD = PSD.SLAN_CD," ).append("\n"); 
		query.append("    TBL.RLANE_CD = PSD.RLANE_CD," ).append("\n"); 
		query.append("    TBL.REV_VVD_CD = CASE WHEN PSD.WDR_CHK = 1 AND PSD.TRNK_VSL_CD IN ('SMXX', 'SMYY', 'SMZZ') THEN 'CNTC' || TO_CHAR(SYSDATE, 'YYMM') || 'MM'" ).append("\n"); 
		query.append("                          ELSE PSD.REV_VVD_CD" ).append("\n"); 
		query.append("                     END," ).append("\n"); 
		query.append("    TBL.TRNK_SLAN_CD = PSD.TRNK_SLAN_CD," ).append("\n"); 
		query.append("    TBL.TRNK_RLANE_CD = PSD.TRNK_RLANE_CD," ).append("\n"); 
		query.append("    TBL.TRNK_VSL_CD = PSD.TRNK_VSL_CD," ).append("\n"); 
		query.append("    TBL.TRNK_SKD_VOY_NO = PSD.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("    TBL.TRNK_SKD_DIR_CD = PSD.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("    TBL.TRNK_REV_DIR_CD = PSD.TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("    TBL.SVC_SCP_CD = PSD.SVC_SCP_CD," ).append("\n"); 
		query.append("    TBL.PRE_PORT_CD = PSD.PRE_PORT_CD," ).append("\n"); 
		query.append("    TBL.PST_PORT_CD = PSD.PST_PORT_CD," ).append("\n"); 
		query.append("    TBL.COMM_PROC_RSLT_RSN = PSD.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("    TBL.CRE_USR_ID = PSD.CRE_USR_ID," ).append("\n"); 
		query.append("    TBL.CRE_DT = PSD.CRE_DT," ).append("\n"); 
		query.append("    TBL.UPD_USR_ID = PSD.UPD_USR_ID," ).append("\n"); 
		query.append("    TBL.UPD_DT = PSD.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT (" ).append("\n"); 
		query.append("    TBL.BKG_NO," ).append("\n"); 
		query.append("    TBL.BL_NO," ).append("\n"); 
		query.append("    TBL.BL_NO_TP," ).append("\n"); 
		query.append("    TBL.BL_TP_CD," ).append("\n"); 
		query.append("    TBL.BKG_STS_CD," ).append("\n"); 
		query.append("    TBL.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    TBL.BL_CVRD_TP_CD," ).append("\n"); 
		query.append("    TBL.CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("    TBL.BKG_OFC_CD," ).append("\n"); 
		query.append("    TBL.CLT_OFC_CD," ).append("\n"); 
		query.append("    TBL.BKG_CRE_DT," ).append("\n"); 
		query.append("    TBL.BDR_FLG," ).append("\n"); 
		query.append("    TBL.BDR_DT," ).append("\n"); 
		query.append("    TBL.POR_CD," ).append("\n"); 
		query.append("    TBL.POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.POR_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.POL_CD," ).append("\n"); 
		query.append("    TBL.POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.POL_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.POD_CD," ).append("\n"); 
		query.append("    TBL.POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.POD_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.DEL_CD," ).append("\n"); 
		query.append("    TBL.DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    TBL.DEL_AR_OFC_CD," ).append("\n"); 
		query.append("    TBL.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("    TBL.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("    TBL.TRD_CD," ).append("\n"); 
		query.append("    TBL.SLAN_CD," ).append("\n"); 
		query.append("    TBL.RLANE_CD," ).append("\n"); 
		query.append("    TBL.REV_VVD_CD," ).append("\n"); 
		query.append("    TBL.TRNK_SLAN_CD," ).append("\n"); 
		query.append("    TBL.TRNK_RLANE_CD," ).append("\n"); 
		query.append("    TBL.TRNK_VSL_CD," ).append("\n"); 
		query.append("    TBL.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("    TBL.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("    TBL.TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("    TBL.SVC_SCP_CD," ).append("\n"); 
		query.append("    TBL.PRE_PORT_CD," ).append("\n"); 
		query.append("    TBL.PST_PORT_CD," ).append("\n"); 
		query.append("    TBL.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("    TBL.CRE_USR_ID," ).append("\n"); 
		query.append("    TBL.CRE_DT," ).append("\n"); 
		query.append("    TBL.UPD_USR_ID," ).append("\n"); 
		query.append("    TBL.UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  VALUES (" ).append("\n"); 
		query.append("    PSD.BKG_NO," ).append("\n"); 
		query.append("    PSD.BL_NO," ).append("\n"); 
		query.append("    PSD.BL_NO_TP," ).append("\n"); 
		query.append("    PSD.BL_TP_CD," ).append("\n"); 
		query.append("    PSD.BKG_STS_CD," ).append("\n"); 
		query.append("    PSD.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("    PSD.BL_CVRD_TP_CD," ).append("\n"); 
		query.append("    PSD.CHN_BKG_AGN_CD," ).append("\n"); 
		query.append("    PSD.BKG_OFC_CD," ).append("\n"); 
		query.append("    PSD.CLT_OFC_CD," ).append("\n"); 
		query.append("    PSD.BKG_CRE_DT," ).append("\n"); 
		query.append("    PSD.BDR_FLG," ).append("\n"); 
		query.append("    PSD.BDR_DT," ).append("\n"); 
		query.append("    PSD.POR_CD," ).append("\n"); 
		query.append("    PSD.POR_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    PSD.POR_AR_OFC_CD," ).append("\n"); 
		query.append("    PSD.POL_CD," ).append("\n"); 
		query.append("    PSD.POL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    PSD.POL_AR_OFC_CD," ).append("\n"); 
		query.append("    PSD.POD_CD," ).append("\n"); 
		query.append("    PSD.POD_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    PSD.POD_AR_OFC_CD," ).append("\n"); 
		query.append("    PSD.DEL_CD," ).append("\n"); 
		query.append("    PSD.DEL_FINC_CTRL_OFC_CD," ).append("\n"); 
		query.append("    PSD.DEL_AR_OFC_CD," ).append("\n"); 
		query.append("    PSD.BKG_RCV_TERM_CD," ).append("\n"); 
		query.append("    PSD.BKG_DE_TERM_CD," ).append("\n"); 
		query.append("    PSD.TRD_CD," ).append("\n"); 
		query.append("    PSD.SLAN_CD," ).append("\n"); 
		query.append("    PSD.RLANE_CD," ).append("\n"); 
		query.append("    CASE WHEN PSD.WDR_CHK = 1 AND PSD.TRNK_VSL_CD IN ('SMXX', 'SMYY', 'SMZZ') THEN 'CNTC' || TO_CHAR(SYSDATE, 'YYMM') || 'MM'" ).append("\n"); 
		query.append("         ELSE PSD.REV_VVD_CD" ).append("\n"); 
		query.append("    END," ).append("\n"); 
		query.append("    PSD.TRNK_SLAN_CD," ).append("\n"); 
		query.append("    PSD.TRNK_RLANE_CD," ).append("\n"); 
		query.append("    PSD.TRNK_VSL_CD," ).append("\n"); 
		query.append("    PSD.TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("    PSD.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("    PSD.TRNK_REV_DIR_CD," ).append("\n"); 
		query.append("    PSD.SVC_SCP_CD," ).append("\n"); 
		query.append("    PSD.PRE_PORT_CD," ).append("\n"); 
		query.append("    PSD.PST_PORT_CD," ).append("\n"); 
		query.append("    PSD.COMM_PROC_RSLT_RSN," ).append("\n"); 
		query.append("    PSD.CRE_USR_ID," ).append("\n"); 
		query.append("    PSD.CRE_DT," ).append("\n"); 
		query.append("    PSD.UPD_USR_ID," ).append("\n"); 
		query.append("    PSD.UPD_DT" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}