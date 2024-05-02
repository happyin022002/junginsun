/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselStatusDBDAOSearchInsuranceVesselDataVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.03.14 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselStatusDBDAOSearchInsuranceVesselDataVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Status의 선박 관련 항목 조회한다
	  * </pre>
	  */
	public VesselStatusDBDAOSearchInsuranceVesselDataVORSQL(){
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
		query.append("Path : com.clt.apps.opus.cps.cni.insurance.vesselstatus.integration").append("\n"); 
		query.append("FileName : VesselStatusDBDAOSearchInsuranceVesselDataVORSQL").append("\n"); 
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
		query.append("SELECT 	TO_CHAR(V.VSL_LNCH_DT,' YYYY') VSL_LNCH_DT,  V.VSL_RGST_CNT_CD, V.CLSS_NO_RGST_AREA_NM, " ).append("\n"); 
		query.append("		V.GRS_RGST_TONG_WGT, V.DWT_WGT, TO_CHAR(V.VSL_DE_DT,'YYYYMMDD') VSL_DE_DT, " ).append("\n"); 
		query.append("		MC.CNT_CD, MC.CNT_NM" ).append("\n"); 
		query.append("FROM 	MDM_COUNTRY MC, MDM_VSL_CNTR V " ).append("\n"); 
		query.append("WHERE 	MC.CNT_CD(+)	= V.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("AND     V.VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 

	}
}