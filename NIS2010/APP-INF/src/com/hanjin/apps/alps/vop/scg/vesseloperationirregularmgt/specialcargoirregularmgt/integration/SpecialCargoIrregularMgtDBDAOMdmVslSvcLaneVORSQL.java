/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOMdmVslSvcLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.14 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOMdmVslSvcLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular List의 Lane Combo 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOMdmVslSvcLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration ").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOMdmVslSvcLaneVORSQL").append("\n"); 
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
		query.append("LAN.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE LAN" ).append("\n"); 
		query.append("WHERE EXISTS(" ).append("\n"); 
		query.append("SELECT 'A'" ).append("\n"); 
		query.append("FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append(", VSK_VSL_SKD   VVS" ).append("\n"); 
		query.append("WHERE SIR.VSL_CD      = VVS.VSL_CD" ).append("\n"); 
		query.append("AND SIR.SKD_VOY_NO  = VVS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SIR.SKD_DIR_CD  = VVS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVS.VSL_SLAN_CD = LAN.VSL_SLAN_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY LAN.VSL_SLAN_CD" ).append("\n"); 

	}
}