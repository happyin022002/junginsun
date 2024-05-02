/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IHCGuideLineDBDAOCreatePriTrfIHCRtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOCreatePriTrfIHCRtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PriTrfIHCRtVO를 만들기 위한 SQL
	  * </pre>
	  */
	public IHCGuideLineDBDAOCreatePriTrfIHCRtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration ").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOCreatePriTrfIHCRtVORSQL").append("\n"); 
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
		query.append("SELECT '' IHC_COST_LOC_GRP_NO" ).append("\n"); 
		query.append("    , '' AMDT_SEQ" ).append("\n"); 
		query.append("    , '' SVC_SCP_CD" ).append("\n"); 
		query.append("    , '' PNT_LOC_CD" ).append("\n"); 
		query.append("    , '' LOCL_CURR_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_20FT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_DG_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' LOCL_CURR_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' RCV_DE_TERM_CD" ).append("\n"); 
		query.append("    , '' UPD_USR_ID" ).append("\n"); 
		query.append("    , '' BSE_PORT_LOC_CD" ).append("\n"); 
		query.append("    , '' MTY_TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_DG_40FT_AMT" ).append("\n"); 
		query.append("    , '' IHC_TRF_NO" ).append("\n"); 
		query.append("    , '' LOCL_CURR_CD" ).append("\n"); 
		query.append("    , '' COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' PNT_NOD_CD" ).append("\n"); 
		query.append("    , '' ORG_DEST_TP_CD" ).append("\n"); 
		query.append("    , '' TRSP_40FT_COST_AMT" ).append("\n"); 
		query.append("    , '' BSE_PORT_NOD_CD" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_40FT_AMT" ).append("\n"); 
		query.append("    , '' RT_SEQ" ).append("\n"); 
		query.append("    , '' ORG_COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' CRE_USR_ID" ).append("\n"); 
		query.append("    , '' N1ST_CMNC_AMDT_SEQ" ).append("\n"); 
		query.append("    , '' TML_40FT_COST_AMT" ).append("\n"); 
		query.append("    , '' PRC_TRSP_MOD_CD" ).append("\n"); 
		query.append("    , '' IHC_RT_RMK" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_OVR_40FT_AMT" ).append("\n"); 
		query.append("    , '' MB_20FT_RTO" ).append("\n"); 
		query.append("    , '' ORG_COST_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' CRE_DT" ).append("\n"); 
		query.append("    , '' MTY_TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_OVR_20FT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_OVR_WGT_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' MB_40FT_RTO" ).append("\n"); 
		query.append("    , '' GLINE_OVR_WGT_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' PRC_TRF_CRE_TP_CD" ).append("\n"); 
		query.append("    , '' UPD_DT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_DG_20FT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' OPTM_TRSP_MOD_FLG" ).append("\n"); 
		query.append("    , '' TRSP_20FT_COST_AMT" ).append("\n"); 
		query.append("    , '' SRC_INFO_CD" ).append("\n"); 
		query.append("    , '' HUB_NOD_CD" ).append("\n"); 
		query.append("    , '' COST_20FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' TML_20FT_COST_AMT" ).append("\n"); 
		query.append("    , '' GLINE_DG_40FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' DCGO_SVC_FLG" ).append("\n"); 
		query.append("    , '' IHC_CGO_TP_CD" ).append("\n"); 
		query.append("    , '' HUB_LOC_CD" ).append("\n"); 
		query.append("    , '' LOCL_CURR_COST_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' MTY_TRSP_45FT_COST_AMT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_DG_45FT_AMT" ).append("\n"); 
		query.append("    , '' COST_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' TRSP_45FT_COST_AMT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_45FT_AMT" ).append("\n"); 
		query.append("    , '' TML_45FT_COST_AMT" ).append("\n"); 
		query.append("    , '' GLINE_LOCL_CURR_OVR_45FT_AMT" ).append("\n"); 
		query.append("    , '' ORG_COST_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' MB_45FT_RTO" ).append("\n"); 
		query.append("    , '' GLINE_OVR_WGT_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append("    , '' GLINE_DG_45FT_FRT_RT_AMT" ).append("\n"); 
		query.append(" FROM PRI_TRF_IHC_RT" ).append("\n"); 

	}
}