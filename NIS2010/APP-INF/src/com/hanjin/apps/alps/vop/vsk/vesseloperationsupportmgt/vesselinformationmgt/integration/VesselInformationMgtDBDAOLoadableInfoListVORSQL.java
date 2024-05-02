/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOLoadableInfoListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.16 
* 1.0 Creation
* 
* 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOLoadableInfoListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Loadable Info list 를 조회한다.
	  * 
	  * //History
	  * 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
	  * </pre>
	  */
	public VesselInformationMgtDBDAOLoadableInfoListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOLoadableInfoListVORSQL").append("\n"); 
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
		query.append("	    VSL_SLAN_CTNT" ).append("\n"); 
		query.append("	  , CAPA_SEQ" ).append("\n"); 
		query.append("	  , TRD_CD" ).append("\n"); 
		query.append("	  , CNTR_DZN_CAPA" ).append("\n"); 
		query.append("	  , MAX_CGO_SMR_MT_WGT" ).append("\n"); 
		query.append("	  , HC_INCL_BSA_QTY" ).append("\n"); 
		query.append("	  , HC_XCLD_BSA_QTY" ).append("\n"); 
		query.append("	  , CTRT_BSA_UT_WGT" ).append("\n"); 
		query.append("	  , ACT_BSA_UT_WGT" ).append("\n"); 
		query.append("	  , TTL_BSA_WGT" ).append("\n"); 
		query.append("	  , HD_HUL_HC_HLD_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_HC_DECK_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_HC_INCL_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_HC_XCLD_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_ACT_UT_WGT" ).append("\n"); 
		query.append("	  , HD_HUL_TTL_WGT" ).append("\n"); 
		query.append("	  , HD_HUL_CRNT_SLT_RT" ).append("\n"); 
		query.append("	  , HD_HUL_NEW_SLT_RT" ).append("\n"); 
		query.append("	  , HD_HUL_NEW_WGT_RT" ).append("\n"); 
		query.append("	  , HD_HUL_INCL_ICRZ_QTY" ).append("\n"); 
		query.append("	  , HD_HUL_XCLD_ICRZ_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_HLD_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_DECK_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_INCL_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_HC_XCLD_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_ACT_UT_WGT" ).append("\n"); 
		query.append("	  , BAK_HUL_TTL_WGT" ).append("\n"); 
		query.append("	  , BAK_HUL_CRNT_SLT_RT" ).append("\n"); 
		query.append("	  , BAK_HUL_NEW_SLT_RT" ).append("\n"); 
		query.append("	  , BAK_HUL_NEW_WGT_RT" ).append("\n"); 
		query.append("	  , BAK_HUL_INCL_ICRZ_QTY" ).append("\n"); 
		query.append("	  , BAK_HUL_XCLD_ICRZ_QTY" ).append("\n"); 
		query.append("	  , LDB_CAPA_RMK" ).append("\n"); 
		query.append("  FROM VSK_VSL_LANE_LDB_CAPA" ).append("\n"); 

	}
}