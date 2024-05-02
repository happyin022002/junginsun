/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0033VVDLanePortRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocation0033VVDLanePortRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSpaceAllocation0033VVDLanePortRgstList
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocation0033VVDLanePortRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocation0033VVDLanePortRgstListRSQL").append("\n"); 
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
		query.append("SELECT ILPR.REP_TRD_CD" ).append("\n"); 
		query.append("     , ILPR.SUB_TRD_CD" ).append("\n"); 
		query.append("     , ILPR.RLANE_CD" ).append("\n"); 
		query.append("     , ILPR.DIR_CD" ).append("\n"); 
		query.append("     , ILPR.VVD" ).append("\n"); 
		query.append("     , ILPR.EFF_FM_DT" ).append("\n"); 
		query.append("     , ILPR.EFF_TO_DT" ).append("\n"); 
		query.append("     , ILPR.BSA_CAPA" ).append("\n"); 
		query.append("     , ILPR.POL_CD" ).append("\n"); 
		query.append("     , ILPR.ALOC_HC_CALC_QTY" ).append("\n"); 
		query.append("     , ILPR.ALOC_HC_BZC_BX_QTY" ).append("\n"); 
		query.append("     , ILPR.ALOC_HC_APLY_FLG" ).append("\n"); 
		query.append("     , ILPR.ALOC_HC_OVR_CALC_QTY" ).append("\n"); 
		query.append("     , ILPR.ALOC_45FT_CALC_QTY" ).append("\n"); 
		query.append("     , ILPR.ALOC_45FT_BZC_BX_QTY" ).append("\n"); 
		query.append("     , ILPR.ALOC_45FT_APLY_FLG" ).append("\n"); 
		query.append("     , ILPR.ALOC_45FT_OVR_CALC_QTY" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("        SELECT ILPR.REP_TRD_CD" ).append("\n"); 
		query.append("             , ILPR.SUB_TRD_CD" ).append("\n"); 
		query.append("             , ILPR.RLANE_CD" ).append("\n"); 
		query.append("             , ILPR.DIR_CD" ).append("\n"); 
		query.append("             , ILPR.VSL_CD||ILPR.SKD_VOY_NO||ILPR.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("             , ILPR.EFF_FM_DT" ).append("\n"); 
		query.append("             , ILPR.EFF_TO_DT" ).append("\n"); 
		query.append("             , NVL(VPS.CLPT_SEQ,99) AS CLPT_SEQ" ).append("\n"); 
		query.append("             , ILPR.BSA_CAPA" ).append("\n"); 
		query.append("             , ILPR.POL_CD" ).append("\n"); 
		query.append("             , ILPR.ALOC_HC_CALC_QTY" ).append("\n"); 
		query.append("             , ILPR.ALOC_HC_BZC_BX_QTY" ).append("\n"); 
		query.append("             , ILPR.ALOC_HC_APLY_FLG" ).append("\n"); 
		query.append("             , ILPR.ALOC_HC_OVR_CALC_QTY" ).append("\n"); 
		query.append("             , ILPR.ALOC_45FT_CALC_QTY" ).append("\n"); 
		query.append("             , ILPR.ALOC_45FT_BZC_BX_QTY" ).append("\n"); 
		query.append("             , ILPR.ALOC_45FT_APLY_FLG" ).append("\n"); 
		query.append("             , ILPR.ALOC_45FT_OVR_CALC_QTY" ).append("\n"); 
		query.append("        FROM SPC_IRR_LANE_PORT_RGST ILPR," ).append("\n"); 
		query.append("             VSK_VSL_PORT_SKD       VPS" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        #if (${f_trade} != '') " ).append("\n"); 
		query.append("        AND REP_TRD_CD = @[f_trade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_sub_trade} != '') " ).append("\n"); 
		query.append("        AND SUB_TRD_CD = @[f_sub_trade]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_lane} != '') " ).append("\n"); 
		query.append("        AND RLANE_CD = @[f_lane]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${f_bound} != '') " ).append("\n"); 
		query.append("        AND DIR_CD = @[f_bound]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND ILPR.VSL_CD      = VPS.VSL_CD(+)" ).append("\n"); 
		query.append("        AND ILPR.SKD_VOY_NO  = VPS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND ILPR.SKD_DIR_CD  = VPS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        AND ILPR.POL_CD      = VPS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("        AND SUBSTR(ILPR.RLANE_CD,1,3) = VPS.SLAN_CD(+)" ).append("\n"); 
		query.append("        AND VPS.CLPT_IND_SEQ(+)    = 1" ).append("\n"); 
		query.append("        ORDER BY ILPR.REP_TRD_CD" ).append("\n"); 
		query.append("             , ILPR.SUB_TRD_CD" ).append("\n"); 
		query.append("             , ILPR.RLANE_CD" ).append("\n"); 
		query.append("             , ILPR.DIR_CD" ).append("\n"); 
		query.append("             , ILPR.VSL_CD||ILPR.SKD_VOY_NO||ILPR.SKD_DIR_CD" ).append("\n"); 
		query.append("			 , NVL(VPS.CLPT_SEQ,99)" ).append("\n"); 
		query.append("             , ILPR.POL_CD" ).append("\n"); 
		query.append("             , ILPR.EFF_FM_DT" ).append("\n"); 
		query.append("             , ILPR.EFF_TO_DT" ).append("\n"); 
		query.append("             , ILPR.BSA_CAPA" ).append("\n"); 
		query.append("      ) ILPR" ).append("\n"); 

	}
}