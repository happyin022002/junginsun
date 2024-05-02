/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
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

public class WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search WorkOrder Preview Issue Status
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewIssueStatusRSQL").append("\n"); 
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
		query.append("SELECT A.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("      ,A.WO_ISS_NO" ).append("\n"); 
		query.append("      ,A.WO_FMT_TP_CD" ).append("\n"); 
		query.append("      ,A.WO_ISS_STS_CD" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_WO_SEQ" ).append("\n"); 
		query.append("      ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("      ,COUNT(WO_ISS_NO) CNT" ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      ,DECODE(B.WO_EDI_USE_FLG, 'Y', CASE WHEN D.TRSP_SO_TP_CD IN ('Y', 'M', 'S') THEN 'Y' ELSE 'N' END, 'N') WO_EDI_USE_FLG" ).append("\n"); 
		query.append("      ,C.CONTI_CD" ).append("\n"); 
		query.append("      ,D.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("      ,D.TRSP_BND_CD" ).append("\n"); 
		query.append("      ,A.FM_NOD_CD" ).append("\n"); 
		query.append("      ,A.TO_NOD_CD" ).append("\n"); 
		query.append("      ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("      ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("      ,E.INTER_USE_FLG" ).append("\n"); 
		query.append("      ,NVL(E.WO_RMK, F.WO_INSTR_RMK) WO_INSTR_RMK" ).append("\n"); 
		query.append("      ,MAX(DECODE(FX.WO_CC_SEQ, 1, FX.WO_FAX_NO)) FAX1" ).append("\n"); 
		query.append("      ,MAX(DECODE(FX.WO_CC_SEQ, 2, FX.WO_FAX_NO)) FAX2" ).append("\n"); 
		query.append("      ,MAX(DECODE(FX.WO_CC_SEQ, 3, FX.WO_FAX_NO)) FAX3" ).append("\n"); 
		query.append("      ,MAX(DECODE(EL.WO_CC_SEQ, 1, EL.WO_EML)) EML1" ).append("\n"); 
		query.append("      ,MAX(DECODE(EL.WO_CC_SEQ, 2, EL.WO_EML)) EML2" ).append("\n"); 
		query.append("      ,MAX(DECODE(EL.WO_CC_SEQ, 3, EL.WO_EML)) EML3" ).append("\n"); 
		query.append("      ,EDI.EDI_RCVR_NM_USE_FLG" ).append("\n"); 
		query.append("  FROM TRS_TRSP_WRK_ORD_PRV_TMP A" ).append("\n"); 
		query.append("      ,MDM_VENDOR               B" ).append("\n"); 
		query.append("      ,MDM_LOCATION             C" ).append("\n"); 
		query.append("      ,TRS_TRSP_SVC_ORD         D" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD         E" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD_INSTR   F" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD_CC_FAX  FX" ).append("\n"); 
		query.append("      ,TRS_TRSP_WRK_ORD_CC_EML  EL" ).append("\n"); 
		query.append("      ,TRS_EDI_USA_RCVR_DTL     EDI" ).append("\n"); 
		query.append(" WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND SUBSTR(A.FM_NOD_CD, 1, 5) = C.LOC_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_OFC_CTY_CD = D.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = D.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND A.TRSP_WO_OFC_CTY_CD = E.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND A.TRSP_WO_SEQ = E.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("   AND D.TRSP_COST_DTL_MOD_CD = F.TRSP_COST_MOD_CD(+)" ).append("\n"); 
		query.append("   AND D.TRSP_CRR_MOD_CD = F.TRSP_CRR_MOD_CD(+)" ).append("\n"); 
		query.append("   AND D.TRSP_BND_CD = F.TRSP_BND_CD(+)" ).append("\n"); 
		query.append("   AND D.CRE_OFC_CD = F.WO_INSTR_OFC_CD(+)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = FX.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = EL.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = EDI.VNDR_SEQ(+)" ).append("\n"); 
		query.append(" GROUP BY A.WO_PRV_GRP_SEQ" ).append("\n"); 
		query.append("         ,A.WO_ISS_NO" ).append("\n"); 
		query.append("         ,A.WO_FMT_TP_CD" ).append("\n"); 
		query.append("         ,A.WO_ISS_STS_CD" ).append("\n"); 
		query.append("         ,A.VNDR_SEQ" ).append("\n"); 
		query.append("         ,A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("         ,A.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("         ,A.TRSP_WO_SEQ" ).append("\n"); 
		query.append("         ,B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("         ,DECODE(B.WO_EDI_USE_FLG, 'Y', CASE WHEN D.TRSP_SO_TP_CD IN ('Y', 'M', 'S') THEN 'Y' ELSE 'N' END, 'N')" ).append("\n"); 
		query.append("         ,C.CONTI_CD" ).append("\n"); 
		query.append("         ,D.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("         ,D.TRSP_BND_CD" ).append("\n"); 
		query.append("         ,A.FM_NOD_CD" ).append("\n"); 
		query.append("         ,A.TO_NOD_CD" ).append("\n"); 
		query.append("         ,A.VIA_NOD_CD" ).append("\n"); 
		query.append("         ,A.DOR_NOD_CD" ).append("\n"); 
		query.append("         ,F.WO_INSTR_RMK" ).append("\n"); 
		query.append("         ,E.WO_RMK" ).append("\n"); 
		query.append("         ,E.INTER_USE_FLG" ).append("\n"); 
		query.append("         ,EDI.EDI_RCVR_NM_USE_FLG" ).append("\n"); 
		query.append(" ORDER BY WO_ISS_NO" ).append("\n"); 

	}
}