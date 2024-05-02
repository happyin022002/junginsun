/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.25
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.25 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hask_FFile(ESV_N) - JOEDI
	  * {EU
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMasterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileEsvMasterRSQL").append("\n"); 
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
		query.append("SELECT @[wo_iss_sts_cd] WO_ISS_STS_CD" ).append("\n"); 
		query.append("      ,DECODE(@[wo_iss_sts_cd], 'I', 'Create', 'N', 'Cancel', 'C', 'Update', 'R', 'Update', 'X', 'Draft') AS JO_ITEM_MSG_TYPE" ).append("\n"); 
		query.append("      ,'NYKS-' || SUBSTR(M.OFC_CD, 1, 3) AS SND_CD" ).append("\n"); 
		query.append("      ,V.USA_EDI_CD || '-' || SUBSTR(L.SCC_CD, 3, 3) AS RCV_CD" ).append("\n"); 
		query.append("      ,SO.TRSP_WO_OFC_CTY_CD || SO.TRSP_WO_SEQ || '-' || SO.TRSP_SO_OFC_CTY_CD || SO.TRSP_SO_SEQ AS JO_ITEM_REF" ).append("\n"); 
		query.append("      ,'NYKS' CARRIER_CD" ).append("\n"); 
		query.append("      ,CASE WHEN SO.TRSP_SO_TP_CD = 'M' THEN 'Empty'" ).append("\n"); 
		query.append("            WHEN SO.TRSP_BND_CD = 'I' THEN 'Import'" ).append("\n"); 
		query.append("            WHEN SO.TRSP_BND_CD = 'O' THEN 'Export'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS MOVE_TYPE" ).append("\n"); 
		query.append("      ,DECODE(SO.TRSP_COST_DTL_MOD_CD, 'DR', 'Round-Trip', 'One-Way') AS TRIP_TYPE" ).append("\n"); 
		query.append("      ,CASE WHEN SO.EQ_KND_CD = 'Z' THEN  'Chassis Reposition'" ).append("\n"); 
		query.append("            WHEN SO.TRSP_SO_TP_CD = 'M' THEN 'Container Reposition'" ).append("\n"); 
		query.append("            WHEN SO.TRSP_BND_CD = 'I' THEN 'Import/Inbound Dray'" ).append("\n"); 
		query.append("            WHEN SO.TRSP_BND_CD = 'O' THEN 'Export/Outbound Dray'" ).append("\n"); 
		query.append("            ELSE ''" ).append("\n"); 
		query.append("       END AS CATEGORY" ).append("\n"); 
		query.append("      ,U.USR_NM AS CREATEBY" ).append("\n"); 
		query.append("      ,NVL((SELECT MAX(WO_ISS_KNT) - 1 FROM TRS_TRSP_WRK_ORD_HIS S WHERE S.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD AND S.TRSP_WO_SEQ = WO.TRSP_WO_SEQ), 0) AS AMEND_NO" ).append("\n"); 
		query.append("      ,NVL((SELECT MAX(WO_ISS_KNT) - 1 FROM TRS_TRSP_WRK_ORD_HIS S WHERE S.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD AND S.TRSP_WO_SEQ = WO.TRSP_WO_SEQ), 0) AS VERSION_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(WO.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') AS JO_ISSUE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(WO.LOCL_CRE_DT + 2 / 24, 'YYYYMMDDHH24MISS') AS RESPOND_DT" ).append("\n"); 
		query.append("      ,DECODE(SO.TRSP_CRR_MOD_CD, 'TD', 'Truck', 'TR', 'Truck Rail', 'TW', 'Truck Feeder', 'RD', 'Rail', 'RT', 'Rail Truck', 'RW', 'Rail Feeder', 'WD', 'Feeder', 'WR', 'Feeder Rail', 'WT', 'Feeder Truck') AS TRANS_MD" ).append("\n"); 
		query.append("      ,DECODE(SO.TRSP_BND_CD, 'O', REPLACE(REPLACE(WO.WO_RMK, CHR(10), '!@#'), CHR(13), ''), REPLACE(REPLACE(WO.WO_RMK, CHR(10), ''), CHR(13), '')) AS M_COMMENT" ).append("\n"); 
		query.append("      ,'' AS REASON_CD" ).append("\n"); 
		query.append("      ,'' AS CNTR_SEQ" ).append("\n"); 
		query.append("      ,'' AS TOTAL_CNTR" ).append("\n"); 
		query.append("      ,'' AS WAYBILL_NO" ).append("\n"); 
		query.append("      ,SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,SO.EQ_NO" ).append("\n"); 
		query.append("      ,SO.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,SO.BKG_NO" ).append("\n"); 
		query.append("      ,SO.VNDR_SEQ" ).append("\n"); 
		query.append("	  ,SO.TRSP_SO_TP_CD" ).append("\n"); 
		query.append("      ,SO.CGO_TP_CD" ).append("\n"); 
		query.append("      ,@[wo_prv_grp_seq] WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("      ,@[wo_iss_no] WO_ISS_NO" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("      ,MDM_YARD         M" ).append("\n"); 
		query.append("      ,MDM_VENDOR       V" ).append("\n"); 
		query.append("      ,COM_USER         U" ).append("\n"); 
		query.append("      ,MDM_LOCATION     L" ).append("\n"); 
		query.append(" WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("   AND WO.WO_ISS_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND SO.FM_NOD_CD = M.YD_CD(+)" ).append("\n"); 
		query.append("   AND SO.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND SO.UPD_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append("   AND U.USE_FLG(+) = 'Y'" ).append("\n"); 
		query.append("   AND SUBSTR(SO.FM_NOD_CD, 1, 5) = L.LOC_CD(+)" ).append("\n"); 

	}
}