/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SurchargeInputInquiryDBDAOaddTempSurchargeListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.01.05 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeInputInquiryDBDAOaddTempSurchargeListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addTempSurchargeList
	  * </pre>
	  */
	public SurchargeInputInquiryDBDAOaddTempSurchargeListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CUST_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("RF_MGST_USG_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INCRT_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_INCUR_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("UPD_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SCL_STOP_PLC_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_OVR_WGT_OTR_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_CHSS_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("GRS_WGT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_RF_HNDL_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INCUR_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_LFTG_KNT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_GRS_WGT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("N3PTY_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_STO_DYS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_WT_HRS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WO_PRV_GRP_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("STO_DYS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_OVR_WGT_PRMT_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FNE_CUZ_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CRE_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("STOP_LOC_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OVR_WGT_OTR_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LGS_COST_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_FNE_CUZ_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_DRY_RUN_RLBL_PTY_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WT_HRS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_RF_MGST_USG_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LFTG_CUZ_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_TRI_AXL_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_SCG_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OTR_RMK",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FOR_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CHSS_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_INSP_RF_PTI_CSTMS_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_INCRT_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_FUMG_COST_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("RF_HNDL_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DRY_RUN_RLBL_PTY_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_LFTG_CUZ_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_OTR_RMK",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("N3PTY_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CUST_CNT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_AGMT_BFR_EXTD_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_STOP_LOC_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("MGST_TPSZ_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SCG_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("N3PTY_VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("N3PTY_BIL_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRI_AXL_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_OVR_WGT_RMK",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OB_BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("N3PTY_DESC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_OB_BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LFTG_KNT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OVR_WGT_PRMT_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INSP_RF_PTI_CSTMS_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_MGST_TPSZ_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("OVR_WGT_RMK",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("INV_SCL_STOP_PLC_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FUMG_COST_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.integration").append("\n"); 
		query.append("FileName : SurchargeInputInquiryDBDAOaddTempSurchargeListCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SCG_DTL_TMP (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TRSP_SO_SEQ," ).append("\n"); 
		query.append("LGS_COST_CD," ).append("\n"); 
		query.append("WO_PRV_GRP_SEQ," ).append("\n"); 
		query.append("SCG_AMT," ).append("\n"); 
		query.append("DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("FNE_CUZ_DESC," ).append("\n"); 
		query.append("FUMG_COST_TP_CD," ).append("\n"); 
		query.append("MGST_TPSZ_CD," ).append("\n"); 
		query.append("INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("LFTG_KNT," ).append("\n"); 
		query.append("LFTG_CUZ_DESC," ).append("\n"); 
		query.append("STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("GRS_WGT," ).append("\n"); 
		query.append("INCRT_DT," ).append("\n"); 
		query.append("SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("STO_DYS," ).append("\n"); 
		query.append("OB_BKG_NO," ).append("\n"); 
		query.append("WT_HRS," ).append("\n"); 
		query.append("OTR_RMK," ).append("\n"); 
		query.append("INV_SCG_AMT," ).append("\n"); 
		query.append("INV_DRY_RUN_RLBL_PTY_TP_CD," ).append("\n"); 
		query.append("INV_FNE_CUZ_DESC," ).append("\n"); 
		query.append("INV_FUMG_COST_TP_CD," ).append("\n"); 
		query.append("INV_MGST_TPSZ_CD," ).append("\n"); 
		query.append("INV_INSP_RF_PTI_CSTMS_TP_CD," ).append("\n"); 
		query.append("INV_LFTG_KNT," ).append("\n"); 
		query.append("INV_LFTG_CUZ_DESC," ).append("\n"); 
		query.append("INV_STOP_LOC_NOD_CD," ).append("\n"); 
		query.append("INV_GRS_WGT," ).append("\n"); 
		query.append("INV_INCRT_DT," ).append("\n"); 
		query.append("INV_SCL_STOP_PLC_NOD_CD," ).append("\n"); 
		query.append("INV_STO_DYS," ).append("\n"); 
		query.append("INV_OB_BKG_NO," ).append("\n"); 
		query.append("INV_WT_HRS," ).append("\n"); 
		query.append("INV_OTR_RMK," ).append("\n"); 
		query.append("N3PTY_BIL_FLG," ).append("\n"); 
		query.append("CUST_CNT_CD," ).append("\n"); 
		query.append("CUST_SEQ," ).append("\n"); 
		query.append("N3PTY_VNDR_SEQ," ).append("\n"); 
		query.append("N3PTY_OFC_CD," ).append("\n"); 
		query.append("N3PTY_AMT," ).append("\n"); 
		query.append("N3PTY_DESC," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LOCL_CRE_DT," ).append("\n"); 
		query.append("LOCL_UPD_DT," ).append("\n"); 
		query.append("INCUR_DT," ).append("\n"); 
		query.append("CHSS_NO," ).append("\n"); 
		query.append("INV_INCUR_DT," ).append("\n"); 
		query.append("INV_CHSS_NO," ).append("\n"); 
		query.append("RF_HNDL_FLG," ).append("\n"); 
		query.append("RF_MGST_USG_FLG," ).append("\n"); 
		query.append("TRI_AXL_FLG," ).append("\n"); 
		query.append("OVR_WGT_PRMT_FLG," ).append("\n"); 
		query.append("OVR_WGT_OTR_FLG," ).append("\n"); 
		query.append("OVR_WGT_RMK," ).append("\n"); 
		query.append("INV_RF_HNDL_FLG," ).append("\n"); 
		query.append("INV_RF_MGST_USG_FLG," ).append("\n"); 
		query.append("INV_TRI_AXL_FLG," ).append("\n"); 
		query.append("INV_OVR_WGT_PRMT_FLG," ).append("\n"); 
		query.append("INV_OVR_WGT_OTR_FLG," ).append("\n"); 
		query.append("INV_OVR_WGT_RMK," ).append("\n"); 
		query.append("TRSP_AGMT_BFR_EXTD_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("@[TRSP_SO_OFC_CTY_CD]," ).append("\n"); 
		query.append("@[TRSP_SO_SEQ]," ).append("\n"); 
		query.append("@[LGS_COST_CD]," ).append("\n"); 
		query.append("@[WO_PRV_GRP_SEQ]," ).append("\n"); 
		query.append("@[SCG_AMT]," ).append("\n"); 
		query.append("@[DRY_RUN_RLBL_PTY_TP_CD]," ).append("\n"); 
		query.append("@[FNE_CUZ_DESC]," ).append("\n"); 
		query.append("@[FUMG_COST_TP_CD]," ).append("\n"); 
		query.append("@[MGST_TPSZ_CD]," ).append("\n"); 
		query.append("@[INSP_RF_PTI_CSTMS_TP_CD]," ).append("\n"); 
		query.append("@[LFTG_KNT]," ).append("\n"); 
		query.append("@[LFTG_CUZ_DESC]," ).append("\n"); 
		query.append("@[STOP_LOC_NOD_CD]," ).append("\n"); 
		query.append("@[GRS_WGT]," ).append("\n"); 
		query.append("TO_DATE(SUBSTR(@[INCRT_DT],1,8), 'YYYYMMDD')," ).append("\n"); 
		query.append("@[SCL_STOP_PLC_NOD_CD]," ).append("\n"); 
		query.append("@[STO_DYS]," ).append("\n"); 
		query.append("@[OB_BKG_NO]," ).append("\n"); 
		query.append("@[WT_HRS]," ).append("\n"); 
		query.append("@[OTR_RMK]," ).append("\n"); 
		query.append("@[INV_SCG_AMT]," ).append("\n"); 
		query.append("@[INV_DRY_RUN_RLBL_PTY_TP_CD]," ).append("\n"); 
		query.append("@[INV_FNE_CUZ_DESC]," ).append("\n"); 
		query.append("@[INV_FUMG_COST_TP_CD]," ).append("\n"); 
		query.append("@[INV_MGST_TPSZ_CD]," ).append("\n"); 
		query.append("@[INV_INSP_RF_PTI_CSTMS_TP_CD]," ).append("\n"); 
		query.append("@[INV_LFTG_KNT]," ).append("\n"); 
		query.append("@[INV_LFTG_CUZ_DESC]," ).append("\n"); 
		query.append("@[INV_STOP_LOC_NOD_CD]," ).append("\n"); 
		query.append("@[INV_GRS_WGT]," ).append("\n"); 
		query.append("@[INV_INCRT_DT]," ).append("\n"); 
		query.append("@[INV_SCL_STOP_PLC_NOD_CD]," ).append("\n"); 
		query.append("@[INV_STO_DYS]," ).append("\n"); 
		query.append("@[INV_OB_BKG_NO]," ).append("\n"); 
		query.append("@[INV_WT_HRS]," ).append("\n"); 
		query.append("@[INV_OTR_RMK]," ).append("\n"); 
		query.append("@[N3PTY_BIL_FLG]," ).append("\n"); 
		query.append("@[CUST_CNT_CD]," ).append("\n"); 
		query.append("@[CUST_SEQ]," ).append("\n"); 
		query.append("@[N3PTY_VNDR_SEQ]," ).append("\n"); 
		query.append("@[N3PTY_OFC_CD]," ).append("\n"); 
		query.append("@[N3PTY_AMT]," ).append("\n"); 
		query.append("@[N3PTY_DESC]," ).append("\n"); 
		query.append("@[CRE_OFC_CD]," ).append("\n"); 
		query.append("@[CRE_USR_ID]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[UPD_USR_ID]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FOR_USR_OFC_CD])," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[FOR_USR_OFC_CD])," ).append("\n"); 
		query.append("TO_DATE(SUBSTR(@[INCUR_DT],1,8), 'YYYYMMDD') 	," ).append("\n"); 
		query.append("@[CHSS_NO]," ).append("\n"); 
		query.append(" TO_DATE(SUBSTR(@[INV_INCUR_DT],1,8), 'YYYYMMDD')," ).append("\n"); 
		query.append("@[INV_CHSS_NO]," ).append("\n"); 
		query.append("@[RF_HNDL_FLG]," ).append("\n"); 
		query.append("@[RF_MGST_USG_FLG]," ).append("\n"); 
		query.append("@[TRI_AXL_FLG]," ).append("\n"); 
		query.append("@[OVR_WGT_PRMT_FLG]," ).append("\n"); 
		query.append("@[OVR_WGT_OTR_FLG]," ).append("\n"); 
		query.append("@[OVR_WGT_RMK]," ).append("\n"); 
		query.append("@[INV_RF_HNDL_FLG]," ).append("\n"); 
		query.append("@[INV_RF_MGST_USG_FLG]," ).append("\n"); 
		query.append("@[INV_TRI_AXL_FLG]," ).append("\n"); 
		query.append("@[INV_OVR_WGT_PRMT_FLG]," ).append("\n"); 
		query.append("@[INV_OVR_WGT_OTR_FLG]," ).append("\n"); 
		query.append("@[INV_OVR_WGT_RMK]," ).append("\n"); 
		query.append("NVL(@[TRSP_AGMT_BFR_EXTD_FLG],'N')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}