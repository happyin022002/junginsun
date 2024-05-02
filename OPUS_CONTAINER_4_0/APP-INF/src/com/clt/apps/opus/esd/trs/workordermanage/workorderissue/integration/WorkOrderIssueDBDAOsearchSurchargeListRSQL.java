/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderIssueDBDAOsearchSurchargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.10.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
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
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderissue.integration").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		/*+ LEADING(C) USE_NL(A) */" ).append("\n"); 
		query.append("	   A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ AS UNIQUE_CD" ).append("\n"); 
		query.append("      ,A.LGS_COST_CD" ).append("\n"); 
		query.append("      ,B.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("      ,A.SCG_AMT" ).append("\n"); 
		query.append("      ,A.DRY_RUN_RLBL_PTY_TP_CD" ).append("\n"); 
		query.append("      ,A.FNE_CUZ_DESC" ).append("\n"); 
		query.append("      ,A.FUMG_COST_TP_CD" ).append("\n"); 
		query.append("      ,A.MGST_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.INSP_RF_PTI_CSTMS_TP_CD" ).append("\n"); 
		query.append("      ,A.LFTG_KNT" ).append("\n"); 
		query.append("      ,A.LFTG_CUZ_DESC" ).append("\n"); 
		query.append("      ,A.STOP_LOC_NOD_CD" ).append("\n"); 
		query.append("      ,A.GRS_WGT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.INCRT_DT, 'YYYYMMDD') INCRT_DT" ).append("\n"); 
		query.append("      ,A.SCL_STOP_PLC_NOD_CD" ).append("\n"); 
		query.append("      ,A.STO_DYS" ).append("\n"); 
		query.append("      ,A.OB_BKG_NO" ).append("\n"); 
		query.append("      ,A.WT_HRS" ).append("\n"); 
		query.append("      ,A.OTR_RMK" ).append("\n"); 
		query.append("      ,A.INV_SCG_AMT" ).append("\n"); 
		query.append("      ,A.INV_DRY_RUN_RLBL_PTY_TP_CD" ).append("\n"); 
		query.append("      ,A.INV_FNE_CUZ_DESC" ).append("\n"); 
		query.append("      ,A.INV_FUMG_COST_TP_CD" ).append("\n"); 
		query.append("      ,A.INV_MGST_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.INV_INSP_RF_PTI_CSTMS_TP_CD" ).append("\n"); 
		query.append("      ,A.INV_LFTG_KNT" ).append("\n"); 
		query.append("      ,A.INV_LFTG_CUZ_DESC" ).append("\n"); 
		query.append("      ,A.INV_STOP_LOC_NOD_CD" ).append("\n"); 
		query.append("      ,A.INV_GRS_WGT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.INV_INCRT_DT, 'YYYYMMDD') INV_INCRT_DT" ).append("\n"); 
		query.append("      ,A.INV_SCL_STOP_PLC_NOD_CD" ).append("\n"); 
		query.append("      ,A.INV_STO_DYS" ).append("\n"); 
		query.append("      ,A.INV_OB_BKG_NO" ).append("\n"); 
		query.append("      ,A.INV_WT_HRS" ).append("\n"); 
		query.append("      ,A.INV_OTR_RMK" ).append("\n"); 
		query.append("      ,A.N3PTY_BIL_FLG" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,A.CUST_SEQ" ).append("\n"); 
		query.append("      ,A.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.N3PTY_OFC_CD" ).append("\n"); 
		query.append("      ,A.N3PTY_AMT" ).append("\n"); 
		query.append("      ,A.N3PTY_DESC" ).append("\n"); 
		query.append("      ,C.N3PTY_CURR_CD" ).append("\n"); 
		query.append("      ,A.CRE_OFC_CD" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(A.LOCL_CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(A.INCUR_DT, 'YYYYMMDD') INCUR_DT" ).append("\n"); 
		query.append("      ,A.CHSS_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(A.INV_INCUR_DT, 'YYYYMMDD') INV_INCUR_DT" ).append("\n"); 
		query.append("      ,A.INV_CHSS_NO" ).append("\n"); 
		query.append("      ,C.REF_INV_NO" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("      ,A.FUEL_RTO" ).append("\n"); 
		query.append("      ,A.COM_SCG_KND_CD" ).append("\n"); 
		query.append("      ,A.COM_SCG_SEQ" ).append("\n"); 
		query.append("      ,A.SCG_DTL_SEQ" ).append("\n"); 
		query.append("      ,NVL(A.CURR_CD, C.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("      ,(SELECT ROUND((X1.USD_LOCL_XCH_RT / X2.USD_LOCL_XCH_RT),6) AS RATE" ).append("\n"); 
		query.append("          FROM GL_MON_XCH_RT X1" ).append("\n"); 
		query.append("             , GL_MON_XCH_RT X2" ).append("\n"); 
		query.append("         WHERE X1.ACCT_XCH_RT_YRMON = TO_CHAR(C.LOCL_CRE_DT, 'YYYYMM') -- S/O Creation Date" ).append("\n"); 
		query.append("           AND X1.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND X1.CURR_CD = C.CURR_CD -- W/O Currency" ).append("\n"); 
		query.append("           AND X2.ACCT_XCH_RT_YRMON = TO_CHAR(C.LOCL_CRE_DT, 'YYYYMM') -- S/O Creation Date" ).append("\n"); 
		query.append("           AND X2.ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("           AND X2.CURR_CD = NVL(A.CURR_CD, C.CURR_CD) -- SCG Currency" ).append("\n"); 
		query.append("           AND X1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND X2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       ) AS WO_SCG_XCH_RT" ).append("\n"); 
		query.append("      ,NVL(A.ORG_SCG_AMT, A.SCG_AMT) AS ORG_SCG_AMT" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SCG_DTL A" ).append("\n"); 
		query.append("      ,TES_LGS_COST     B" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD C" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("#if($SoNo.size() > 0 ) " ).append("\n"); 
		query.append("   AND  (C.TRSP_SO_OFC_CTY_CD, C.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("	#foreach($code IN ${SoNo})  " ).append("\n"); 
		query.append("		#if($velocityCount == 1)  " ).append("\n"); 
		query.append("						(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 8))" ).append("\n"); 
		query.append("		#else  " ).append("\n"); 
		query.append("					   ,(SUBSTR('$code', 1, 3),SUBSTR('$code', 4, 8))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end  " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  AND  A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD 	" ).append("\n"); 
		query.append("  AND  A.TRSP_SO_SEQ = C.TRSP_SO_SEQ				 	" ).append("\n"); 
		query.append("  AND  A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 

	}
}