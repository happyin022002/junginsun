/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MakeVoDAOIntloadSumReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2012.07.09 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOIntloadSumReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MakeVoDAOIntloadSumReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOIntloadSumReportVORSQL").append("\n"); 
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
		query.append("SELECT '' AS JO_VOID_TEU_QTY" ).append("\n"); 
		query.append("    , '' AS VSL_CD" ).append("\n"); 
		query.append("    , '' AS ADDITIONAL_CD" ).append("\n"); 
		query.append("    , '' AS REMARK" ).append("\n"); 
		query.append("    , '' AS AK_JO_VOID_TEU_QTY" ).append("\n"); 
		query.append("    , '' AS ACTU_WT" ).append("\n"); 
		query.append("    , '' AS RLANE_CD" ).append("\n"); 
		query.append("    , '' AS MT_40" ).append("\n"); 
		query.append("    , '' AS ADD_40HC_TEU" ).append("\n"); 
		query.append("    , '' AS FULL_40" ).append("\n"); 
		query.append("    , '' AS PRE_FR" ).append("\n"); 
		query.append("    , '' AS VPS_PORT_CD" ).append("\n"); 
		query.append("    , '' AS JO_ALOC_ADJ_RMK_YN" ).append("\n"); 
		query.append("    , '' AS IUD_FLAG" ).append("\n"); 
		query.append("    , '' AS FULL_45" ).append("\n"); 
		query.append("    , '' AS ACT_SLOT" ).append("\n"); 
		query.append("    , '' AS ACTU_TEU" ).append("\n"); 
		query.append("    , '' AS HC_LD_40" ).append("\n"); 
		query.append("    , '' AS JO_RF_IPT_QTY" ).append("\n"); 
		query.append("    , '' AS JO_RGN_CD" ).append("\n"); 
		query.append("    , '' AS VPS_ETD_DT" ).append("\n"); 
		query.append("    , '' AS JO_SHRT_LEG_RMK_SCTR_NM" ).append("\n"); 
		query.append("    , '' AS SUPER_CD1" ).append("\n"); 
		query.append("    , '' AS ADD_45_TEU" ).append("\n"); 
		query.append("    , '' AS SKD_VOY_NO" ).append("\n"); 
		query.append("    , '' AS GRAND_TTL_SLOT" ).append("\n"); 
		query.append("    , '' AS AK_UNIT" ).append("\n"); 
		query.append("    , '' AS EMPTY_WT" ).append("\n"); 
		query.append("    , '' AS VVD" ).append("\n"); 
		query.append("    , '' AS CRE_USR_ID" ).append("\n"); 
		query.append("    , '' AS PRE_TO" ).append("\n"); 
		query.append("    , '' AS REMARK_YN" ).append("\n"); 
		query.append("    , '' AS EMPTY_TEU" ).append("\n"); 
		query.append("    , '' AS REGION" ).append("\n"); 
		query.append("    , '' AS TOTAL_TEU" ).append("\n"); 
		query.append("    , '' AS JO_SHRT_LEG_RMK_WGT" ).append("\n"); 
		query.append("    , '' AS FULL_40HC" ).append("\n"); 
		query.append("    , '' AS HC_LD_20" ).append("\n"); 
		query.append("    , '' AS FULL_20" ).append("\n"); 
		query.append("    , '' AS ALL_WGT" ).append("\n"); 
		query.append("    , '' AS MT_TEU" ).append("\n"); 
		query.append("    , '' AS OVER_SLOT" ).append("\n"); 
		query.append("    , '' AS USR_ID" ).append("\n"); 
		query.append("    , '' AS JO_ALOC_ADJ_WGT" ).append("\n"); 
		query.append("    , '' AS JO_ALOC_ADJ_TEU_QTY" ).append("\n"); 
		query.append("    , '' AS PORT_CD" ).append("\n"); 
		query.append("    , '' AS MT_WT" ).append("\n"); 
		query.append("    , '' AS ALLOC_WT" ).append("\n"); 
		query.append("    , '' AS JO_ALOC_ADJ_RMK" ).append("\n"); 
		query.append("    , '' AS JO_SHRT_LEG_RMK_TEU_QTY" ).append("\n"); 
		query.append("    , '' AS JO_CRR_CD" ).append("\n"); 
		query.append("    , '' AS OVER_WGT" ).append("\n"); 
		query.append("    , '' AS ALL_TEU" ).append("\n"); 
		query.append("    , '' AS OVER_LONG_WT" ).append("\n"); 
		query.append("    , '' AS JO_RF_OCN_QTY" ).append("\n"); 
		query.append("    , '' AS OVER_LONG_TEU" ).append("\n"); 
		query.append("    , '' AS SKD_DIR_CD" ).append("\n"); 
		query.append("    , '' AS SLAN_CD" ).append("\n"); 
		query.append("    , '' AS SOURCE" ).append("\n"); 
		query.append("    , '' AS GRAND_TTL_WGT" ).append("\n"); 
		query.append("    , '' AS OPR_CD" ).append("\n"); 
		query.append("    , '' AS RE_DIVR_CD" ).append("\n"); 
		query.append("    , '' AS RF_I" ).append("\n"); 
		query.append("    , '' AS ALLOC_TEU" ).append("\n"); 
		query.append("    , '' AS RF_O" ).append("\n"); 
		query.append("	, '' AS ADD_20HC_TEU" ).append("\n"); 
		query.append("	, '' AS FULL_20HC" ).append("\n"); 
		query.append("	, '' AS	HID_JO_SHRT_LEG_RMK_TEU_QTY" ).append("\n"); 
		query.append("	, '' AS HID_JO_SHRT_LEG_RMK_WGT" ).append("\n"); 
		query.append("	, '' AS HID_JO_SHRT_LEG_RMK_SCTR_NM" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}