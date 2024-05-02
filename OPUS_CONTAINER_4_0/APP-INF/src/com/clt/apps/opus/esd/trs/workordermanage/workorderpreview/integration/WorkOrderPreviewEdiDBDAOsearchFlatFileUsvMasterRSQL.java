/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NYK-Hask_FFile(USV_N) - JOEDI
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvMasterRSQL(){
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
		params.put("wo_iss_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_item_ref",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvMasterRSQL").append("\n"); 
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
		query.append("SELECT  @[wo_iss_sts_cd] WO_ISS_STS_CD" ).append("\n"); 
		query.append("        ,DECODE(@[wo_iss_sts_cd], 'I', 'Create', 'N', 'Cancel', 'C', 'Update', 'R', 'Update', 'A', 'Accept',  'J', 'Reject') AS JO_ITEM_MSG_TYPE" ).append("\n"); 
		query.append("        ,'NYKS' || '-' || SUBSTR(Y.OFC_CD, 1, 3) AS SND_CD" ).append("\n"); 
		query.append("        ,N.USA_EDI_CD || '-' || SUBSTR(L.SCC_CD, 3, 3) AS RCV_CD" ).append("\n"); 
		query.append("        ,NVL(@[jo_item_ref], SO.TRSP_WO_OFC_CTY_CD || SO.TRSP_WO_SEQ || '-' || SO.TRSP_SO_OFC_CTY_CD || SO.TRSP_SO_SEQ) AS JO_ITEM_REF" ).append("\n"); 
		query.append("        ,'NYKS' CARRIER_CD" ).append("\n"); 
		query.append("        ,CASE WHEN SO.TRSP_SO_TP_CD = 'M' THEN 'Empty'" ).append("\n"); 
		query.append("              WHEN SO.TRSP_BND_CD = 'I'   THEN 'Import'" ).append("\n"); 
		query.append("              WHEN SO.TRSP_BND_CD = 'O'   THEN  'Export'" ).append("\n"); 
		query.append("              ELSE '' END MOVE_TYPE" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_COST_DTL_MOD_CD, 'DR', 'Round-Trip', 'One-Way') AS TRIP_TYPE" ).append("\n"); 
		query.append("        ,CASE WHEN SO.EQ_KND_CD = 'Z'      THEN ' Chassis Reposition'" ).append("\n"); 
		query.append("              WHEN SO.TRSP_SO_TP_CD = 'M'  THEN 'Container Reposition'" ).append("\n"); 
		query.append("              WHEN SO.TRSP_BND_CD = 'I'    THEN 'Import/Inbound Dray'" ).append("\n"); 
		query.append("              WHEN SO.TRSP_BND_CD = 'O'    THEN  'Export/Outbound Dray'" ).append("\n"); 
		query.append("              ELSE ''" ).append("\n"); 
		query.append("         END CATEGORY " ).append("\n"); 
		query.append("        ,U.USR_NM as CREATEBY" ).append("\n"); 
		query.append("        ,TO_CHAR(WO.LOCL_CRE_DT, 'YYYYMMDDHH24MISS') AS WO_DT" ).append("\n"); 
		query.append("		,CASE WHEN SO.TRSP_SO_TP_CD = 'M'  THEN SO.REF_ID" ).append("\n"); 
		query.append("			  WHEN SO.TRSP_BND_CD = 'O' THEN SO.BKG_NO" ).append("\n"); 
		query.append("		 END BKG_NO" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_BND_CD, 'I', SO.BL_NO, '') AS BL_NO" ).append("\n"); 
		query.append("        ,DECODE(SO.CGO_TP_CD, 'F', R.WBL_NO, '') RAIL_BILL_NO" ).append("\n"); 
		query.append("        ,'' AS VND_NO" ).append("\n"); 
		query.append("        ,'' AS SND_REF" ).append("\n"); 
		query.append("        ,TO_CHAR(WO.LOCL_CRE_DT + 2/24, 'YYYYMMDDHH24MISS') AS RESPOND_DT" ).append("\n"); 
		query.append("        ,TO_CHAR(SO.LST_FREE_DT, 'YYYYMMDDHH24MISS') AS LAST_FREE_DT" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_BND_CD, 'O', TO_CHAR(NVL(RCL.MNL_SET_DT, RCL.SYS_SET_DT), 'YYYYMMDDHH24MISS'))  AS CUTOFF_DT" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '', VSL.VSL_ENG_NM) as VESSEL" ).append("\n"); 
		query.append("        --,DECODE(SO.TRSP_SO_TP_CD, 'M', '', SO.SKD_VOY_NO) as VOYAGE" ).append("\n"); 
		query.append("		,DECODE(SO.TRSP_SO_TP_CD, 'M', '', NVL2(SO.IB_VVD_CD||SO.OB_VVD_CD, DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 5, 4), SUBSTR(SO.OB_VVD_CD, 5, 4)), SO.SKD_VOY_NO)) AS VOYAGE" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '', SUBSTR(MPOL.LOC_NM, 0, DECODE(SIGN(INSTR(MPOL.LOC_NM, ',')), 1, INSTR(MPOL.LOC_NM, ',')-1, LENGTH(MPOL.LOC_NM)))) POL_NAME" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '', SUBSTR(MPOD.LOC_NM, 0, DECODE(SIGN(INSTR(MPOD.LOC_NM, ',')), 1, INSTR(MPOD.LOC_NM, ',')-1, LENGTH(MPOD.LOC_NM)))) POD_NAME" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '', ( SELECT TO_CHAR(MAX(VSK.VPS_ETA_DT), 'YYYYMMDDHH24MISS') FROM VSK_VSL_PORT_SKD VSK WHERE VSK.VSL_CD = BKG.VSL_CD AND VSK.SKD_VOY_NO = BKG.SKD_VOY_NO AND VSK.SKD_DIR_CD = BKG.SKD_DIR_CD AND VSK.YD_CD = BKG.POD_NOD_CD) ) AS ARR_ETA" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_SO_TP_CD, 'M', '',  DECODE(SO.TRSP_BND_CD, 'I', CONS_MC.CUST_LGL_ENG_NM, 'O', SHIP_MC.CUST_LGL_ENG_NM)) AS SHPR" ).append("\n"); 
		query.append("        ,'' AS BRKR" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(MO.OFC_ADDR, CHR(10),''), CHR(13),'') AS BILLTO" ).append("\n"); 
		query.append("        ,DECODE(SO.TRSP_BND_CD, 'O', REPLACE(REPLACE(WO.WO_RMK,  CHR(10), '!@#'), CHR(13),''), REPLACE(REPLACE(WO.WO_RMK, CHR(10), ''), CHR(13),'')) WO_RMK" ).append("\n"); 
		query.append("        ,SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,SO.VNDR_SEQ" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD      SO" ).append("\n"); 
		query.append("        ,TRS_TRSP_WRK_ORD      WO" ).append("\n"); 
		query.append("        ,BKG_BOOKING           BKG" ).append("\n"); 
		query.append("        ,MDM_VENDOR            N" ).append("\n"); 
		query.append("        ,COM_USER              U" ).append("\n"); 
		query.append("        ,TRS_TRSP_EDI_RAIL_ORD R" ).append("\n"); 
		query.append("        ,BKG_CLZ_TM            RCL" ).append("\n"); 
		query.append("        ,MDM_VSL_CNTR          VSL" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER          SHIP" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER          CONS" ).append("\n"); 
		query.append("        ,MDM_YARD              Y" ).append("\n"); 
		query.append("        ,MDM_LOCATION          L" ).append("\n"); 
		query.append("        ,MDM_CUSTOMER          CONS_MC" ).append("\n"); 
		query.append("        ,MDM_CUSTOMER          SHIP_MC" ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION      MO" ).append("\n"); 
		query.append("        ,MDM_LOCATION          MPOL" ).append("\n"); 
		query.append("        ,MDM_LOCATION          MPOD" ).append("\n"); 
		query.append("   WHERE SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("     AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("     AND NVL(SO.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("     AND SO.BKG_NO = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("     AND WO.UPD_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append("     AND SO.VNDR_SEQ = N.VNDR_SEQ(+)" ).append("\n"); 
		query.append("     AND SO.BKG_NO = R.BKG_NO(+)" ).append("\n"); 
		query.append("     AND SO.EQ_NO = R.EQ_NO(+)" ).append("\n"); 
		query.append("	 AND SO.VNDR_SEQ = R.VNDR_SEQ(+)" ).append("\n"); 
		query.append("     AND SO.TO_NOD_CD = R.FM_NOD_CD(+)" ).append("\n"); 
		query.append("     AND NVL(R.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("     AND SO.BKG_NO = RCL.BKG_NO(+)" ).append("\n"); 
		query.append("     AND RCL.CLZ_TP_CD(+) = 'R'" ).append("\n"); 
		query.append("     --AND SO.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("	 AND NVL2(SO.IB_VVD_CD||SO.OB_VVD_CD, DECODE(SO.TRSP_BND_CD, 'I', SUBSTR(SO.IB_VVD_CD, 1, 4), SUBSTR(SO.OB_VVD_CD, 1, 4)), SO.VSL_CD) = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("     AND SO.BKG_NO = SHIP.BKG_NO(+)" ).append("\n"); 
		query.append("     AND SHIP.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("     AND SO.BKG_NO = CONS.BKG_NO(+)" ).append("\n"); 
		query.append("     AND CONS.BKG_CUST_TP_CD(+) = 'C' " ).append("\n"); 
		query.append("     AND SO.FM_NOD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("     AND SUBSTR(SO.FM_NOD_CD, 1, 5) = L.LOC_CD(+)" ).append("\n"); 
		query.append("     AND CONS.CUST_CNT_CD = CONS_MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("     AND CONS.CUST_SEQ = CONS_MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("     AND SHIP.CUST_CNT_CD = SHIP_MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("     AND SHIP.CUST_SEQ = SHIP_MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("     AND Y.OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("     AND BKG.POL_CD = MPOL.LOC_CD(+)" ).append("\n"); 
		query.append("     AND MPOL.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("     AND BKG.POD_CD = MPOD.LOC_CD(+)" ).append("\n"); 
		query.append("     AND MPOD.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}