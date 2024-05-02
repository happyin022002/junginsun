/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchSoByPrvTmpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchSoByPrvTmpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSoByPrvTmp
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchSoByPrvTmpRSQL(){
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
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchSoByPrvTmpRSQL").append("\n"); 
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
		query.append("    SO.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("    SO.TRSP_SO_SEQ," ).append("\n"); 
		query.append("    (   " ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN SO.TRSP_WO_OFC_CTY_CD IS NULL OR SO.TRSP_WO_OFC_CTY_CD = '' THEN TMP.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("        ELSE SO.TRSP_WO_OFC_CTY_CD " ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("    ) TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        CASE WHEN SO.TRSP_WO_SEQ IS NULL OR SO.TRSP_WO_SEQ = '' THEN TMP.TRSP_WO_SEQ " ).append("\n"); 
		query.append("        ELSE SO.TRSP_WO_SEQ " ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("    ) TRSP_WO_SEQ," ).append("\n"); 
		query.append("    TMP.VNDR_SEQ," ).append("\n"); 
		query.append("    TMP.WO_ISS_STS_CD," ).append("\n"); 
		query.append("    TMP.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("    TMP.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("    VNDR.WO_EDI_USE_FLG," ).append("\n"); 
		query.append("    LOC.CONTI_CD," ).append("\n"); 
		query.append("    SO.EQ_NO," ).append("\n"); 
		query.append("    EDI.EDI_RCVR_NM_USE_FLG," ).append("\n"); 
		query.append("    RPAD(EDI.EDI_RCVR_NM, 20) AS EDI_RCVR_NM," ).append("\n"); 
		query.append("	SO.CRE_OFC_CD AS SO_CRE_OFC_CD," ).append("\n"); 
		query.append("	SO.TRSP_BND_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("    TRS_TRSP_WRK_ORD_PRV_TMP TMP," ).append("\n"); 
		query.append("    MDM_VENDOR VNDR," ).append("\n"); 
		query.append("    MDM_LOCATION LOC," ).append("\n"); 
		query.append("    TRS_EDI_USA_RCVR_DTL EDI" ).append("\n"); 
		query.append("WHERE TMP.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND TMP.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    AND LOC.LOC_CD = SUBSTR(SO.FM_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("    AND TMP.VNDR_SEQ = VNDR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND TMP.VNDR_SEQ = EDI.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND TMP.WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("    AND TMP.WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("    AND TMP.WO_CXL_FLG = (" ).append("\n"); 
		query.append("                            CASE " ).append("\n"); 
		query.append("                                WHEN TMP.WO_ISS_STS_CD IN ('I', 'R') THEN 'N' " ).append("\n"); 
		query.append("                                WHEN TMP.WO_ISS_STS_CD IN ('C', 'N') THEN 'Y' " ).append("\n"); 
		query.append("                            ELSE 'N' " ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                         ) " ).append("\n"); 
		query.append("    -- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("    AND SO.HJL_NO IS NULL" ).append("\n"); 

	}
}