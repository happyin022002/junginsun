/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselInformationMgtDBDAOVSLPerformanceDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
* 1.0 Creation
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

public class VesselInformationMgtDBDAOVSLPerformanceDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RPM & Slow Steaming, Design Max Load Hold/Deck, OPT Trim, ESI Score 를 조회한다.
	  * 
	  * //History
	  * 2014.04.16 박다은 [CHM-201429675-01] Voyage Performance내 Lane Code 구분
	  * </pre>
	  */
	public VesselInformationMgtDBDAOVSLPerformanceDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOVSLPerformanceDetailVORSQL").append("\n"); 
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
		query.append("        VSL_CD              " ).append("\n"); 
		query.append("      ,	CTCL_RPM_NO" ).append("\n"); 
		query.append("      ,	CTCL_TO_RPM_NO        " ).append("\n"); 
		query.append("      ,	OP_MIN_RPM_NO      " ).append("\n"); 
		query.append("      ,	OP_MIN_SPD         " ).append("\n"); 
		query.append("      ,	SLW_STMNG_FLG      " ).append("\n"); 
		query.append("      ,	SPR_SLW_STMNG_FLG  " ).append("\n"); 
		query.append("      ,	FUEL_SAV_EQ_FLG    " ).append("\n"); 
		query.append("      ,	IN_HLD_PER_TR_KNT  " ).append("\n"); 
		query.append("      ,	IN_HLD_PER_ROW_KNT " ).append("\n"); 
		query.append("      ,	HTCH_CVR_IN_HLD_KNT" ).append("\n"); 
		query.append("      ,	ON_DECK_PER_TR_KNT " ).append("\n"); 
		query.append("      ,	ON_DECK_PER_ROW_KNT" ).append("\n"); 
		query.append("      ,	BOW_HGT            " ).append("\n"); 
		query.append("      ,	TRSM_HGT        " ).append("\n"); 
		query.append("      ,	SHP_IDX_SCRE" ).append("\n"); 
		query.append("	  , VSL_LOD_RTO" ).append("\n"); 
		query.append("	  , AMP_TP_CD" ).append("\n"); 
		query.append("  FROM VSK_VSL_ADD_SPEC" ).append("\n"); 
		query.append(" WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 

	}
}