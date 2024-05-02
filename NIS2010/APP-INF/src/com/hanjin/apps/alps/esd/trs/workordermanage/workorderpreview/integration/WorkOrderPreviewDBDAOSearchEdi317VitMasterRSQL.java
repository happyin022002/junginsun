/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi317VitMasterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.07 
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

public class WorkOrderPreviewDBDAOSearchEdi317VitMasterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi317VitMaster
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi317VitMasterRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi317VitMasterRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(WO.WO_ISS_STS_CD, 'I', 'N', WO.WO_ISS_STS_CD) TYPE," ).append("\n"); 
		query.append("SO.BKG_NO BKGNO," ).append("\n"); 
		query.append("SO.BL_NO BLNO," ).append("\n"); 
		query.append("SO.EQ_NO EQNO," ).append("\n"); 
		query.append("SO.POD_CD POD," ).append("\n"); 
		query.append("LOC1.LOC_NM POD_NAME," ).append("\n"); 
		query.append("SO.DEL_CD DEL," ).append("\n"); 
		query.append("LOC2.LOC_NM DEL_NAME," ).append("\n"); 
		query.append("REPLACE(NVL(SO.FCTRY_NM, ''), CHR(13)||CHR(10), ' ') DO_NAME," ).append("\n"); 
		query.append("REPLACE(NVL(SO.DOR_DE_ADDR, ''), CHR(13)||CHR(10), ' ') DO_ADDR," ).append("\n"); 
		query.append("VN.USA_EDI_CD TRUCK_SCAC," ).append("\n"); 
		query.append("VN.VNDR_LGL_ENG_NM TRUCK_NAME," ).append("\n"); 
		query.append("''RAIL_CARRIER," ).append("\n"); 
		query.append("'' RAIL_ORIG," ).append("\n"); 
		query.append("'' RAIL_DEST," ).append("\n"); 
		query.append("'' DEL_RQ_DATETIME" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WO," ).append("\n"); 
		query.append("MDM_VENDOR VN," ).append("\n"); 
		query.append("MDM_LOCATION LOC1," ).append("\n"); 
		query.append("MDM_LOCATION LOC2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("AND SO.VNDR_SEQ = VN.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND SO.FM_NOD_CD in ('USORFM1', 'USORFM2')" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND SO.TRSP_CRR_MOD_CD = 'TD'" ).append("\n"); 
		query.append("AND SO.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("AND SO.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND WO.WO_ISS_STS_CD = 'I'" ).append("\n"); 
		query.append("AND SO.POD_CD = LOC1.LOC_CD(+)" ).append("\n"); 
		query.append("AND SO.DEL_CD = LOC2.LOC_CD(+)" ).append("\n"); 
		query.append("AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("AND SO.HJL_NO IS NULL" ).append("\n"); 
		query.append("AND WO.HJL_NO IS NULL" ).append("\n"); 

	}
}