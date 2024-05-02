/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvEquipmentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvEquipmentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hawk_FFile(USV_N)-JOEDIUPDT_IAS_OUTBOUND
	  * - EQUIPMENT
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvEquipmentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvEquipmentRSQL").append("\n"); 
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
		query.append("SELECT T1.* " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNTR_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ" ).append("\n"); 
		query.append("      ,PKG_QTY" ).append("\n"); 
		query.append("      ,CASE WHEN TRSP_SO_TP_CD = 'M' THEN '' " ).append("\n"); 
		query.append("            ELSE TRIM(REGEXP_SUBSTR(WGT_STR, '[^|]+', 1, 1)) " ).append("\n"); 
		query.append("       END N_EGT" ).append("\n"); 
		query.append("      ,TRIM(REGEXP_SUBSTR(WGT_STR, '[^|]+', 1, 2)) AS T_WGT" ).append("\n"); 
		query.append("      ,TRIM(REGEXP_SUBSTR(WGT_STR, '[^|]+', 1, 3)) AS G_WGT" ).append("\n"); 
		query.append("      ,WGTUNIT" ).append("\n"); 
		query.append("      ,VOL" ).append("\n"); 
		query.append("      ,VOLUNIT" ).append("\n"); 
		query.append("      ,FREIGHT_DESC" ).append("\n"); 
		query.append("      ,MTREL_NO" ).append("\n"); 
		query.append("      ,HAZMAT" ).append("\n"); 
		query.append("      ,OVWGT" ).append("\n"); 
		query.append("      ,SHIP_NO" ).append("\n"); 
		query.append("      ,'' AS HEIGHT" ).append("\n"); 
		query.append("      ,'' AS WIDTH" ).append("\n"); 
		query.append("      ,'' AS DEPTH" ).append("\n"); 
		query.append("      ,NVL2(EQ_COMM, 'REEFER DETAILS:'||CHR(9)||EQ_COMM, '')  AS EQ_COMMENT" ).append("\n"); 
		query.append("  FROM (SELECT SO.EQ_NO AS CNTR_NO" ).append("\n"); 
		query.append("              ,SO.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("              ,SO.EQ_TPSZ_CD AS CNTR_TPSZ" ).append("\n"); 
		query.append("              ,CNTR.PCK_QTY AS PKG_QTY" ).append("\n"); 
		query.append("              ,TRS_GET_COM_SO_RAIL_WGT_FNC('S', SO.TRSP_SO_OFC_CTY_CD, SO.TRSP_SO_SEQ, NULL, SO.BKG_NO, SO.EQ_NO, SO.EQ_TPSZ_CD,NVL(NVL(CNTR.WGT_UT_CD, SO.WGT_MEAS_UT_CD), 'KGS'), SO.COP_NO, 'Y') WGT_STR" ).append("\n"); 
		query.append("              ,DECODE(NVL(NVL(CNTR.WGT_UT_CD, SO.WGT_MEAS_UT_CD), 'KGS'), 'KGS', 'KG', 'LBS', 'LB', '') AS WGTUNIT" ).append("\n"); 
		query.append("              ,'' AS VOL" ).append("\n"); 
		query.append("              ,'' AS VOLUNIT" ).append("\n"); 
		query.append("              ,SUBSTR(REPLACE(REPLACE(NVL2(SO.EQ_NO, NVL(CNTR.DIFF_RMK, MC.CMDT_NM), MC.CMDT_NM), CHR(10), ''), CHR(13), ''), 1, 50) AS FREIGHT_DESC" ).append("\n"); 
		query.append("			  ,NVL((CASE WHEN SO.TRSP_COST_DTL_MOD_CD = 'CY'  OR (SO.TRSP_COST_DTL_MOD_CD = 'DR' AND TRS_GET_FOC_INFO_FNC(SO.BL_NO, SO.TRSP_SO_OFC_CTY_CD, SO.TRSP_SO_SEQ, NULL) = DECODE(SUBSTR(DOR_NOD_CD, 1, 2), 'US', 'YYY', 'YY')) THEN SO.CNTR_PKUP_NO END) , SO.BKG_NO) AS MTREL_NO" ).append("\n"); 
		query.append("              ,DECODE(BKG.DCGO_FLG, 'Y', 'true', 'false') AS HAZMAT" ).append("\n"); 
		query.append("              ,'false' AS OVWGT" ).append("\n"); 
		query.append("              ,CASE WHEN SO.TRSP_SO_TP_CD = 'M'  THEN SO.REF_ID" ).append("\n"); 
		query.append("                    WHEN SO.TRSP_SO_TP_CD = 'Y' THEN SO.COP_NO" ).append("\n"); 
		query.append("               END SHIP_NO" ).append("\n"); 
		query.append("              ,C.EQ_COMM" ).append("\n"); 
		query.append("              ,SO.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("              ,BKG_BOOKING BKG" ).append("\n"); 
		query.append("              ,BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("              ,MST_CONTAINER M" ).append("\n"); 
		query.append("              ,MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("              ,MST_CNTR_SPEC X" ).append("\n"); 
		query.append("              ,MDM_COMMODITY MC" ).append("\n"); 
		query.append("              ,(SELECT TRS_JOIN_FNC(CURSOR (SELECT 'TEMPERATURE: ' || TEMP || 'C' || ' VENT SETTING: ' || VENT || ' HUMIDITY: ' || HUMIDITY || ' GENSET: ' || GENSET || ' DRAIN: ' || DRAIN_HOLE" ).append("\n"); 
		query.append("                                       FROM (SELECT B.CDO_TEMP AS TEMP" ).append("\n"); 
		query.append("                                                   ,CASE WHEN (NVL(B.VENT_RTO, 0) > 0 OR NVL(B.CBM_PER_HR_QTY, 0) > 0) THEN 'Open'" ).append("\n"); 
		query.append("                                                         ELSE'Closed'" ).append("\n"); 
		query.append("                                                    END VENT" ).append("\n"); 
		query.append("                                                   ,B.HUMID_NO AS HUMIDITY" ).append("\n"); 
		query.append("                                                   ,B.PWR_SPL_CBL_FLG AS GENSET" ).append("\n"); 
		query.append("                                                   ,DECODE(B.CNTR_DRN_CD, 'O', 'Open', 'Closed') AS DRAIN_HOLE" ).append("\n"); 
		query.append("                                               FROM BKG_RF_CGO       B" ).append("\n"); 
		query.append("                                                   ,TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("                                              WHERE S.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                AND S.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("                                                AND S.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("                                                AND NVL(S.EQ_NO, 'XX') = NVL2(S.EQ_NO, NVL(B.CNTR_NO, NVL(S.EQ_NO, 'XX')), 'XX')" ).append("\n"); 
		query.append("                                                AND NVL(S.EQ_TPSZ_CD, 'XX') = NVL2(S.EQ_TPSZ_CD, NVL(B.CNTR_TPSZ_CD, NVL(S.EQ_TPSZ_CD, 'XX')), 'XX')))," ).append("\n"); 
		query.append("                                    CHR(9)) EQ_COMM" ).append("\n"); 
		query.append("                  FROM DUAL) C" ).append("\n"); 
		query.append("         WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND SO.BKG_NO = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("           AND SO.BKG_NO = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("           AND SO.EQ_NO = CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND SO.EQ_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND M.CNTR_SPEC_NO = X.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("           AND SO.EQ_TPSZ_CD = A.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("           AND NVL(A.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("           AND BKG.CMDT_CD = MC.CMDT_CD(+)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append(") T1 RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("ON 1= 1" ).append("\n"); 

	}
}