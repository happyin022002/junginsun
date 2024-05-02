/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchPortExpenceByVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.02.04 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchPortExpenceByVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchPortExpenceByVesselRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchPortExpenceByVesselRSQL").append("\n"); 
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
		query.append("SELECT  NVL(SUM(TTL_CHG_AMT), 0) * (-1) AS TTL_CHG_AMT" ).append("\n"); 
		query.append("		, MAX(BSE_YR) AS BSE_YR" ).append("\n"); 
		query.append("		, MAX(BSE_QTR_CD) AS BSE_QTR_CD" ).append("\n"); 
		query.append("FROM	PSO_VSL_CLSS_TRF" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND	YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("AND	CNTR_VSL_CLSS_CAPA = (" ).append("\n"); 
		query.append("            				SELECT	CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("            				FROM 	MDM_VSL_CNTR" ).append("\n"); 
		query.append("            				WHERE	VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("            				AND		DELT_FLG    = 'N'" ).append("\n"); 
		query.append("				   		  )" ).append("\n"); 

	}
}