/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOsearchEdiResenListRSQL.java
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

public class WorkOrderPreviewDBDAOsearchEdiResenListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiResenList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOsearchEdiResenListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_WO_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_WO_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOsearchEdiResenListRSQL").append("\n"); 
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
		query.append("    (CASE WHEN SO.TRSP_WO_OFC_CTY_CD IS NULL OR SO.TRSP_WO_OFC_CTY_CD = '' " ).append("\n"); 
		query.append("        THEN WO.TRSP_WO_OFC_CTY_CD ELSE SO.TRSP_WO_OFC_CTY_CD END) TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("    (CASE WHEN SO.TRSP_WO_SEQ IS NULL OR SO.TRSP_WO_SEQ = '' " ).append("\n"); 
		query.append("        THEN WO.TRSP_WO_SEQ ELSE SO.TRSP_WO_SEQ END) TRSP_WO_SEQ," ).append("\n"); 
		query.append("--	WO.WO_ISS_KNT, " ).append("\n"); 
		query.append("    SO.VNDR_SEQ," ).append("\n"); 
		query.append("    WO.WO_ISS_STS_CD," ).append("\n"); 
		query.append("	DECODE(WO.WO_EDI_USE_FLG,'Y','EDI','N') WO_EDI_USE_FLG," ).append("\n"); 
		query.append("    SO.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("    SO.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("    VNDR.WO_EDI_USE_FLG," ).append("\n"); 
		query.append("    LOC.CONTI_CD," ).append("\n"); 
		query.append("    SO.EQ_NO," ).append("\n"); 
		query.append("    EDI.EDI_RCVR_NM_USE_FLG," ).append("\n"); 
		query.append("    RPAD(EDI.EDI_RCVR_NM, 20) AS EDI_RCVR_NM," ).append("\n"); 
		query.append("	SO.CRE_OFC_CD AS SO_CRE_OFC_CD," ).append("\n"); 
		query.append("	SO.TRSP_BND_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("    TRS_TRSP_WRK_ORD WO," ).append("\n"); 
		query.append("    MDM_VENDOR VNDR," ).append("\n"); 
		query.append("    MDM_LOCATION LOC," ).append("\n"); 
		query.append("    TRS_EDI_USA_RCVR_DTL EDI" ).append("\n"); 
		query.append("WHERE WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("    AND LOC.LOC_CD = SUBSTR(SO.FM_NOD_CD, 1, 5)" ).append("\n"); 
		query.append("    AND SO.VNDR_SEQ = VNDR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND SO.VNDR_SEQ = EDI.VNDR_SEQ(+)" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_OFC_CTY_CD = @[TRSP_WO_OFC_CTY_CD]" ).append("\n"); 
		query.append("    AND WO.TRSP_WO_SEQ = @[TRSP_WO_SEQ]" ).append("\n"); 
		query.append("    /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("    AND SO.HJL_NO IS NULL" ).append("\n"); 

	}
}