/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi17536801SkdVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.05.20 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi17536801SkdVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MT VVD 조회
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi17536801SkdVvdRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi17536801SkdVvdRSQL").append("\n"); 
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
		query.append("SELECT NVL(POL_VSL.SLAN_CD,POD_VSL.SLAN_CD) AS SKD_LANE_CD" ).append("\n"); 
		query.append("      ,SO.VSL_CD||SO.SKD_VOY_NO||SO.SKD_DIR_CD AS SKD_VVD" ).append("\n"); 
		query.append("      ,VSL.CALL_SGN_NO          AS SKD_VSL_CALLSIGN" ).append("\n"); 
		query.append("      ,VSL.LLOYD_NO             AS SKD_VSL_LLOYDCODE" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM           AS SKD_VSL_NAME" ).append("\n"); 
		query.append("      ,VSL.NET_RGST_TONG_WGT    AS SKD_VSL_NAT" ).append("\n"); 
		query.append("      ,SUBSTR(SO.FM_NOD_CD,1,5) AS SKD_POL" ).append("\n"); 
		query.append("      ,POL_LOC.LOC_NM           AS SKD_POL_NAME" ).append("\n"); 
		query.append("      ,SO.FM_NOD_CD             AS SKD_POL_YD" ).append("\n"); 
		query.append("      ,POL_YD.YD_NM             AS SKD_POL_YDNAME" ).append("\n"); 
		query.append("      ,SUBSTR(SO.TO_NOD_CD,1,5) AS SKD_POD" ).append("\n"); 
		query.append("      ,POD_LOC.LOC_NM           AS SKD_POD_NAME" ).append("\n"); 
		query.append("      ,SO.TO_NOD_CD             AS SKD_POD_YD" ).append("\n"); 
		query.append("      ,POD_YD.YD_NM             AS SKD_POD_YDNAME" ).append("\n"); 
		query.append("      ,TO_CHAR(POL_VSL.VPS_ETA_DT,'YYYYMMDDHH24MI')       AS SKD_POLETA" ).append("\n"); 
		query.append("      ,TO_CHAR(POL_VSL.VPS_ETD_DT,'YYYYMMDDHH24MI')       AS SKD_POLETD" ).append("\n"); 
		query.append("      ,TO_CHAR(POD_VSL.VPS_ETA_DT,'YYYYMMDDHH24MI')       AS SKD_PODETA" ).append("\n"); 
		query.append("      ,TO_CHAR(POD_VSL.VPS_ETD_DT,'YYYYMMDDHH24MI')       AS SKD_PODETD" ).append("\n"); 
		query.append("      ,VSL.CRR_CD               AS SKD_OP_CODE" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD POL_VSL" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD POD_VSL" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("      ,MDM_LOCATION POL_LOC" ).append("\n"); 
		query.append("      ,MDM_LOCATION POD_LOC" ).append("\n"); 
		query.append("      ,MDM_YARD POL_YD" ).append("\n"); 
		query.append("      ,MDM_YARD POD_YD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SO.VSL_CD = POL_VSL.VSL_CD" ).append("\n"); 
		query.append("   AND SO.SKD_VOY_NO = POL_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SO.SKD_DIR_CD = POL_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SO.VSL_CD = POD_VSL.VSL_CD" ).append("\n"); 
		query.append("   AND SO.SKD_VOY_NO = POD_VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND SO.SKD_DIR_CD = POD_VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND SO.VSL_CD =VSL.VSL_CD" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_OFC_CTY_CD =@[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND SUBSTR(SO.FM_NOD_CD,1,5) = POL_VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND SUBSTR(SO.TO_NOD_CD,1,5) = POD_VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND SO.FM_NOD_CD = POL_VSL.YD_CD" ).append("\n"); 
		query.append("   AND SO.TO_NOD_CD = POD_VSL.YD_CD" ).append("\n"); 
		query.append("   AND SUBSTR(SO.FM_NOD_CD,1,5) = POL_LOC.LOC_CD" ).append("\n"); 
		query.append("   AND SUBSTR(SO.TO_NOD_CD,1,5) = POD_LOC.LOC_CD" ).append("\n"); 
		query.append("   AND SO.FM_NOD_CD = POL_YD.YD_CD" ).append("\n"); 
		query.append("   AND SO.TO_NOD_CD = POD_YD.YD_CD" ).append("\n"); 

	}
}