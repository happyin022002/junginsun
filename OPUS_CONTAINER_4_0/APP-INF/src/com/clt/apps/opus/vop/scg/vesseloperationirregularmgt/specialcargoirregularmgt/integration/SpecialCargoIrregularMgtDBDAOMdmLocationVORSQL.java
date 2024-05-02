/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOMdmLocationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.22 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOMdmLocationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular List의 Location Combo 조회
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOMdmLocationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOMdmLocationVORSQL").append("\n"); 
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
		query.append("MLT.LOC_CD" ).append("\n"); 
		query.append("FROM MDM_LOCATION MLT" ).append("\n"); 
		query.append(", SCG_IRR_CNTR SIC" ).append("\n"); 
		query.append(", BKG_BOOKING   BBK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'POR')" ).append("\n"); 
		query.append("AND MLT.LOC_CD = BBK.POR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'POL')" ).append("\n"); 
		query.append("AND MLT.LOC_CD = BBK.POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'POD')" ).append("\n"); 
		query.append("AND MLT.LOC_CD = BBK.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_tp_cd} == 'DEL')" ).append("\n"); 
		query.append("AND MLT.LOC_CD = BBK.DEL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BBK.BKG_NO = SIC.BKG_NO" ).append("\n"); 
		query.append("GROUP BY MLT.LOC_CD" ).append("\n"); 
		query.append("ORDER BY MLT.LOC_CD" ).append("\n"); 

	}
}