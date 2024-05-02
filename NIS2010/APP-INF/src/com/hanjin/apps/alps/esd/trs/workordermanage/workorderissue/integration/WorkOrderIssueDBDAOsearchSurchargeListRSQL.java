/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchSurchargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.24
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.03.24 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderIssueDBDAOsearchSurchargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSurchargeList
	  * </pre>
	  */
	public WorkOrderIssueDBDAOsearchSurchargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
		query.append("FileName : WorkOrderIssueDBDAOsearchSurchargeListRSQL").append("\n"); 
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
		query.append("SELECT											" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD							,	" ).append("\n"); 
		query.append("A.TRSP_SO_SEQ									,	" ).append("\n"); 
		query.append("A.TRSP_SO_SEQ	AS UNIQUE_CD					,	" ).append("\n"); 
		query.append("A.LGS_COST_CD									,	" ).append("\n"); 
		query.append("B.LGS_COST_FULL_NM							,	" ).append("\n"); 
		query.append("A.SCG_AMT										,	" ).append("\n"); 
		query.append("A.DRY_RUN_RLBL_PTY_TP_CD						,	" ).append("\n"); 
		query.append("A.FNE_CUZ_DESC								,	" ).append("\n"); 
		query.append("A.FUMG_COST_TP_CD								,	" ).append("\n"); 
		query.append("A.MGST_TPSZ_CD								,	" ).append("\n"); 
		query.append("A.INSP_RF_PTI_CSTMS_TP_CD						,	" ).append("\n"); 
		query.append("A.LFTG_KNT									,	" ).append("\n"); 
		query.append("A.LFTG_CUZ_DESC								,	" ).append("\n"); 
		query.append("A.STOP_LOC_NOD_CD								,	" ).append("\n"); 
		query.append("A.GRS_WGT										,	" ).append("\n"); 
		query.append("TO_CHAR(A.INCRT_DT, 'YYYYMMDD') INCRT_DT		,	" ).append("\n"); 
		query.append("A.SCL_STOP_PLC_NOD_CD							,	" ).append("\n"); 
		query.append("A.STO_DYS										,	" ).append("\n"); 
		query.append("A.OB_BKG_NO									,	" ).append("\n"); 
		query.append("--A.OB_BKG_NO_SPLIT								,	" ).append("\n"); 
		query.append("A.WT_HRS										,	" ).append("\n"); 
		query.append("A.OTR_RMK										,	" ).append("\n"); 
		query.append("A.INV_SCG_AMT									,	" ).append("\n"); 
		query.append("A.INV_DRY_RUN_RLBL_PTY_TP_CD					,	" ).append("\n"); 
		query.append("A.INV_FNE_CUZ_DESC							,	" ).append("\n"); 
		query.append("A.INV_FUMG_COST_TP_CD							,	" ).append("\n"); 
		query.append("A.INV_MGST_TPSZ_CD							,	" ).append("\n"); 
		query.append("A.INV_INSP_RF_PTI_CSTMS_TP_CD					,	" ).append("\n"); 
		query.append("A.INV_LFTG_KNT								,	" ).append("\n"); 
		query.append("A.INV_LFTG_CUZ_DESC							,	" ).append("\n"); 
		query.append("A.INV_STOP_LOC_NOD_CD							,	" ).append("\n"); 
		query.append("A.INV_GRS_WGT									,	" ).append("\n"); 
		query.append("TO_CHAR(A.INV_INCRT_DT, 'YYYYMMDD') INV_INCRT_DT,	" ).append("\n"); 
		query.append("A.INV_SCL_STOP_PLC_NOD_CD						,	" ).append("\n"); 
		query.append("A.INV_STO_DYS									,	" ).append("\n"); 
		query.append("A.INV_OB_BKG_NO								,	" ).append("\n"); 
		query.append("--A.INV_OB_BKG_NO_SPLIT							,	" ).append("\n"); 
		query.append("A.INV_WT_HRS									,	" ).append("\n"); 
		query.append("A.INV_OTR_RMK									,	" ).append("\n"); 
		query.append("A.N3PTY_BIL_FLG								,	" ).append("\n"); 
		query.append("A.CUST_CNT_CD									,	" ).append("\n"); 
		query.append("A.CUST_SEQ									,	" ).append("\n"); 
		query.append("A.N3PTY_VNDR_SEQ								,	" ).append("\n"); 
		query.append("A.N3PTY_OFC_CD								,	" ).append("\n"); 
		query.append("A.N3PTY_AMT									,	" ).append("\n"); 
		query.append("A.N3PTY_DESC									,	" ).append("\n"); 
		query.append("C.N3PTY_CURR_CD								,	" ).append("\n"); 
		query.append("A.CRE_OFC_CD									,	" ).append("\n"); 
		query.append("A.CRE_USR_ID									,	" ).append("\n"); 
		query.append("TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') CRE_DT	    ," ).append("\n"); 
		query.append("TO_CHAR(A.INCUR_DT, 'YYYYMMDD') INCUR_DT		,	" ).append("\n"); 
		query.append("A.CHSS_NO										," ).append("\n"); 
		query.append("TO_CHAR(A.INV_INCUR_DT, 'YYYYMMDD') INV_INCUR_DT,	" ).append("\n"); 
		query.append("A.INV_CHSS_NO									," ).append("\n"); 
		query.append("DECODE(A.GRS_WGT, NULL, NULL, NVL(A.WO_GRS_WGT_MEAS_UT_CD,'LBS')) WO_GRS_WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("DECODE(A.INV_GRS_WGT, NULL, NULL, NVL(A.INV_GRS_WGT_MEAS_UT_CD,'LBS')) INV_GRS_WGT_MEAS_UT_CD," ).append("\n"); 
		query.append("A.RF_HNDL_FLG," ).append("\n"); 
		query.append("A.RF_MGST_USG_FLG," ).append("\n"); 
		query.append("A.TRI_AXL_FLG," ).append("\n"); 
		query.append("A.OVR_WGT_PRMT_FLG," ).append("\n"); 
		query.append("A.OVR_WGT_OTR_FLG," ).append("\n"); 
		query.append("A.OVR_WGT_RMK," ).append("\n"); 
		query.append("A.INV_RF_HNDL_FLG," ).append("\n"); 
		query.append("A.INV_RF_MGST_USG_FLG," ).append("\n"); 
		query.append("A.INV_TRI_AXL_FLG," ).append("\n"); 
		query.append("A.INV_OVR_WGT_PRMT_FLG," ).append("\n"); 
		query.append("A.INV_OVR_WGT_OTR_FLG," ).append("\n"); 
		query.append("A.INV_OVR_WGT_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM TRS_TRSP_SCG_DTL	A						,	" ).append("\n"); 
		query.append("TES_LGS_COST	B								,	" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD	C								" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if($SoNo.size() > 0 ) " ).append("\n"); 
		query.append("AND (A.TRSP_SO_OFC_CTY_CD,A.TRSP_SO_SEQ) IN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#foreach($code IN ${SoNo})  " ).append("\n"); 
		query.append("#if($velocityCount == 1)  " ).append("\n"); 
		query.append("(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 8))" ).append("\n"); 
		query.append("#else  " ).append("\n"); 
		query.append(",(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 8))" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("--//AND B.LGS_COST_SUBJ_CD IN ('SC', 'SM')			" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD 	" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ				 	" ).append("\n"); 
		query.append("AND A.LGS_COST_CD = B.LGS_COST_CD			 	" ).append("\n"); 
		query.append("AND (SUBSTR(A.LGS_COST_CD,3,2) <> 'FU' AND SUBSTR(A.LGS_COST_CD, 3, 4) <> 'OTAX'AND NVL(A.TRSP_AGMT_BFR_EXTD_FLG,'N') <> 'Y')		 		" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 

	}
}