/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOManageTrsTrspWrkOrdHisByVendorCMCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOManageTrsTrspWrkOrdHisByVendorCMCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreviewDBDAOManageTrsTrspWrkOrdHisByVendorCM
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOManageTrsTrspWrkOrdHisByVendorCMCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration ").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOManageTrsTrspWrkOrdHisByVendorCMCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_WRK_ORD_HIS (" ).append("\n"); 
		query.append("   TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("   TRSP_WO_SEQ," ).append("\n"); 
		query.append("   WO_ISS_KNT," ).append("\n"); 
		query.append("   WO_ISS_STS_CD," ).append("\n"); 
		query.append("   WO_PRN_USE_FLG," ).append("\n"); 
		query.append("   WO_FAX_USE_FLG," ).append("\n"); 
		query.append("   WO_EML_USE_FLG," ).append("\n"); 
		query.append("   WO_EDI_USE_FLG," ).append("\n"); 
		query.append("   WO_N1ST_FAX_NO," ).append("\n"); 
		query.append("   WO_N2ND_FAX_NO," ).append("\n"); 
		query.append("   WO_N3RD_FAX_NO," ).append("\n"); 
		query.append("   WO_N1ST_FAX_SND_NO," ).append("\n"); 
		query.append("   WO_N2ND_FAX_SND_NO," ).append("\n"); 
		query.append("   WO_N3RD_FAX_SND_NO," ).append("\n"); 
		query.append("   WO_N1ST_FAX_RSLT_FLG," ).append("\n"); 
		query.append("   WO_N2ND_FAX_RSLT_FLG," ).append("\n"); 
		query.append("   WO_N3RD_FAX_RSLT_FLG," ).append("\n"); 
		query.append("   WO_N1ST_EML," ).append("\n"); 
		query.append("   WO_N2ND_EML," ).append("\n"); 
		query.append("   WO_N3RD_EML," ).append("\n"); 
		query.append("   WO_N1ST_EML_SND_NO," ).append("\n"); 
		query.append("   WO_N2ND_EML_SND_NO," ).append("\n"); 
		query.append("   WO_N3RD_EML_SND_NO," ).append("\n"); 
		query.append("   WO_N1ST_EML_RSLT_FLG," ).append("\n"); 
		query.append("   WO_N2ND_EML_RSLT_FLG," ).append("\n"); 
		query.append("   WO_N3RD_EML_RSLT_FLG," ).append("\n"); 
		query.append("   WO_RMK," ).append("\n"); 
		query.append("   WO_BL_NO_ISS_FLG," ).append("\n"); 
		query.append("   RT_DP_USE_FLG," ).append("\n"); 
		query.append("   CMDT_DP_USE_FLG," ).append("\n"); 
		query.append("   PRE_DIS_USE_FLG," ).append("\n"); 
		query.append("   DTN_USE_FLG," ).append("\n"); 
		query.append("   WO_EDI_RCV_RSLT_MSG," ).append("\n"); 
		query.append("   WO_EDI_RCV_RSLT_CD," ).append("\n"); 
		query.append("   WO_EDI_RCV_RSLT_DT," ).append("\n"); 
		query.append("   WO_EDI_RCV_PURP_CD," ).append("\n"); 
		query.append("   INTER_USE_FLG," ).append("\n"); 
		query.append("   CRE_OFC_CD," ).append("\n"); 
		query.append("   LOCL_CRE_DT," ).append("\n"); 
		query.append("   LOCL_UPD_DT," ).append("\n"); 
		query.append("   CRE_USR_ID," ).append("\n"); 
		query.append("   CRE_DT," ).append("\n"); 
		query.append("   UPD_USR_ID," ).append("\n"); 
		query.append("   UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("  SELECT TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("         TRSP_WO_SEQ," ).append("\n"); 
		query.append("         NVL((SELECT MAX(WO_ISS_KNT) FROM TRS_TRSP_WRK_ORD_HIS H WHERE H.TRSP_WO_OFC_CTY_CD = O.TRSP_WO_OFC_CTY_CD AND H.TRSP_WO_SEQ = O.TRSP_WO_SEQ), 0) + 1 WO_ISS_KNT," ).append("\n"); 
		query.append("         WO_ISS_STS_CD," ).append("\n"); 
		query.append("         WO_PRN_USE_FLG," ).append("\n"); 
		query.append("         WO_FAX_USE_FLG," ).append("\n"); 
		query.append("         WO_EML_USE_FLG," ).append("\n"); 
		query.append("         WO_EDI_USE_FLG," ).append("\n"); 
		query.append("         WO_N1ST_FAX_NO," ).append("\n"); 
		query.append("         WO_N2ND_FAX_NO," ).append("\n"); 
		query.append("         WO_N3RD_FAX_NO," ).append("\n"); 
		query.append("         WO_N1ST_FAX_SND_NO," ).append("\n"); 
		query.append("         WO_N2ND_FAX_SND_NO," ).append("\n"); 
		query.append("         WO_N3RD_FAX_SND_NO," ).append("\n"); 
		query.append("         WO_N1ST_FAX_RSLT_FLG," ).append("\n"); 
		query.append("         WO_N2ND_FAX_RSLT_FLG," ).append("\n"); 
		query.append("         WO_N3RD_FAX_RSLT_FLG," ).append("\n"); 
		query.append("         WO_N1ST_EML," ).append("\n"); 
		query.append("         WO_N2ND_EML," ).append("\n"); 
		query.append("         WO_N3RD_EML," ).append("\n"); 
		query.append("         WO_N1ST_EML_SND_NO," ).append("\n"); 
		query.append("         WO_N2ND_EML_SND_NO," ).append("\n"); 
		query.append("         WO_N3RD_EML_SND_NO," ).append("\n"); 
		query.append("         WO_N1ST_EML_RSLT_FLG," ).append("\n"); 
		query.append("         WO_N2ND_EML_RSLT_FLG," ).append("\n"); 
		query.append("         WO_N3RD_EML_RSLT_FLG," ).append("\n"); 
		query.append("         WO_RMK," ).append("\n"); 
		query.append("         WO_BL_NO_ISS_FLG," ).append("\n"); 
		query.append("         RT_DP_USE_FLG," ).append("\n"); 
		query.append("         CMDT_DP_USE_FLG," ).append("\n"); 
		query.append("         PRE_DIS_USE_FLG," ).append("\n"); 
		query.append("         DTN_USE_FLG," ).append("\n"); 
		query.append("         '' WO_EDI_RCV_RSLT_MSG," ).append("\n"); 
		query.append("         '' WO_EDI_RCV_RSLT_CD," ).append("\n"); 
		query.append("         '' WO_EDI_RCV_RSLT_DT," ).append("\n"); 
		query.append("         WO_EDI_RCV_PURP_CD," ).append("\n"); 
		query.append("         INTER_USE_FLG," ).append("\n"); 
		query.append("         CRE_OFC_CD," ).append("\n"); 
		query.append("         GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD) LOCL_CRE_DT," ).append("\n"); 
		query.append("         GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(CRE_OFC_CD) LOCL_UPD_DT," ).append("\n"); 
		query.append("         CRE_USR_ID," ).append("\n"); 
		query.append("         SYSDATE CRE_DT," ).append("\n"); 
		query.append("         UPD_USR_ID," ).append("\n"); 
		query.append("         SYSDATE UPD_DT" ).append("\n"); 
		query.append("    FROM TRS_TRSP_WRK_ORD O" ).append("\n"); 
		query.append("   WHERE O.TRSP_WO_OFC_CTY_CD = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND O.TRSP_WO_SEQ = @[trsp_wo_seq]" ).append("\n"); 

	}
}