/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi17536801BkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.03 
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

public class WorkOrderPreviewDBDAOSearchEdi17536801BkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI BKGVVD GROUP
	  * VENDOR [114745] UNIFEEDER A/S 가 사용
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi17536801BkgVvdRSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi17536801BkgVvdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(VVD.VSL_PRE_PST_CD,'S','PRE','T','TRUNK','U','POST','') VVDTYPE" ).append("\n"); 
		query.append(",VVD.SLAN_CD        LANE_CD" ).append("\n"); 
		query.append(",VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",VSL.CALL_SGN_NO    VSL_CALLSIGN" ).append("\n"); 
		query.append(",VSL.LLOYD_NO       VSL_LLOYDCODE" ).append("\n"); 
		query.append(",VSL.VSL_ENG_NM     VSL_NAME" ).append("\n"); 
		query.append(",VSL.VSL_CLSS_FLG   VSL_FLAG" ).append("\n"); 
		query.append(",VVD.POL_CD         POL" ).append("\n"); 
		query.append(",POL_LOC.LOC_NM     POL_NAME" ).append("\n"); 
		query.append(",VVD.POL_YD_CD      POL_YD" ).append("\n"); 
		query.append(",POL_YD.YD_NM       POL_YDNAME" ).append("\n"); 
		query.append(",VVD.POD_CD         POD" ).append("\n"); 
		query.append(",POD_LOC.LOC_NM     POD_NAME" ).append("\n"); 
		query.append(",VVD.POD_YD_CD 	  POD_YD" ).append("\n"); 
		query.append(",POD_YD.YD_NM 	  POD_YDNAME" ).append("\n"); 
		query.append(",(SELECT TO_CHAR(POL_VSK.VPS_ETA_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD POL_VSK" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = POL_VSK.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = POL_VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = POL_VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD =POL_VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = POL_VSK.CLPT_IND_SEQ) POLETA" ).append("\n"); 
		query.append(",(SELECT TO_CHAR(POL_VSK.VPS_ETD_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD POL_VSK" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = POL_VSK.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = POL_VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = POL_VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD =POL_VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = POL_VSK.CLPT_IND_SEQ) POLETD" ).append("\n"); 
		query.append(",(SELECT TO_CHAR(POD_VSK.VPS_ETA_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD POD_VSK" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = POD_VSK.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = POD_VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = POD_VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD =POD_VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POD_CLPT_IND_SEQ = POD_VSK.CLPT_IND_SEQ ) PODETA" ).append("\n"); 
		query.append(",(SELECT TO_CHAR(POD_VSK.VPS_ETD_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD POD_VSK" ).append("\n"); 
		query.append("WHERE VVD.VSL_CD = POD_VSK.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = POD_VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = POD_VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD =POD_VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POD_CLPT_IND_SEQ = POD_VSK.CLPT_IND_SEQ  ) PODETD" ).append("\n"); 
		query.append(",VSL.CRR_CD         OP_CODE" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(",BKG_VVD VVD" ).append("\n"); 
		query.append(",MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append(",TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(",MDM_LOCATION POL_LOC" ).append("\n"); 
		query.append(",MDM_LOCATION POD_LOC" ).append("\n"); 
		query.append(",MDM_YARD POL_YD" ).append("\n"); 
		query.append(",MDM_YARD POD_YD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_CD = VSL.VSL_CD(+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("AND VVD.POL_CD = POL_LOC.LOC_CD" ).append("\n"); 
		query.append("AND VVD.POD_CD = POD_LOC.LOC_CD" ).append("\n"); 
		query.append("AND VVD.POL_YD_CD = POL_YD.YD_CD" ).append("\n"); 
		query.append("AND VVD.POD_YD_CD = POD_YD.YD_CD" ).append("\n"); 
		query.append("AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND SO.TRSP_SO_SEQ  = @[trsp_so_seq]" ).append("\n"); 
		query.append("ORDER BY VVD.VSL_PRE_PST_CD,VVD.VSL_SEQ" ).append("\n"); 

	}
}