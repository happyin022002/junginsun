/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOLoadableListVORSQL.java
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

public class VesselInformationMgtDBDAOLoadableListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance 의 Loadable 정보를 확인한다.
	  * 
	  * //History
	  * 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
	  * </pre>
	  */
	public VesselInformationMgtDBDAOLoadableListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOLoadableListVORSQL").append("\n"); 
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
		query.append("SELECT  X.VSL_SLAN_CTNT" ).append("\n"); 
		query.append("      , X.HC_INCL_BSA_QTY" ).append("\n"); 
		query.append("      , X.HC_XCLD_BSA_QTY" ).append("\n"); 
		query.append("      , X.CTRT_BSA_UT_WGT" ).append("\n"); 
		query.append("      , X.ACT_BSA_UT_WGT" ).append("\n"); 
		query.append("      , X.TTL_BSA_WGT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , X.HD_HUL_HC_HLD_QTY" ).append("\n"); 
		query.append("      , X.HD_HUL_HC_DECK_QTY" ).append("\n"); 
		query.append("      , X.HD_HUL_HC_INCL_QTY" ).append("\n"); 
		query.append("      , X.HD_HUL_HC_XCLD_QTY" ).append("\n"); 
		query.append("      , X.HD_HUL_ACT_UT_WGT" ).append("\n"); 
		query.append("      , X.HD_HUL_TTL_WGT" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      , X.BAK_HUL_HC_HLD_QTY" ).append("\n"); 
		query.append("      , X.BAK_HUL_HC_DECK_QTY" ).append("\n"); 
		query.append("      , X.BAK_HUL_HC_INCL_QTY" ).append("\n"); 
		query.append("      , X.BAK_HUL_HC_XCLD_QTY" ).append("\n"); 
		query.append("      , X.BAK_HUL_ACT_UT_WGT" ).append("\n"); 
		query.append("      , X.BAK_HUL_TTL_WGT" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append(" FROM   VSK_VSL_LANE_LDB_CAPA     X" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("  AND   X.VSL_SLAN_CD             = @[h_vsl_slan_cd]" ).append("\n"); 
		query.append("  AND   X.CNTR_DZN_CAPA           IN" ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                  ----------------------------------------------" ).append("\n"); 
		query.append("                                  SELECT     VC.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("                                  FROM       MDM_VSL_CNTR   VC" ).append("\n"); 
		query.append("                                  WHERE      VC.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("                                  ----------------------------------------------" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 

	}
}