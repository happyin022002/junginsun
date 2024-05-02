/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOAverageUCVesselRegisterRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOAverageUCVesselRegisterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AverageUCVesselRegister
	  * 2015.03.26 컬럼 속성명 변경으로 수정()
	  * </pre>
	  */
	public NetworkCostDBDAOAverageUCVesselRegisterRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOAverageUCVesselRegisterRSQL").append("\n"); 
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
		query.append("SELECT A.COST_YRMON" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = A.VSL_CD) AS VSL_NM" ).append("\n"); 
		query.append("     , A.VSL_OSHP_CD" ).append("\n"); 
		query.append("     , A.CHTR_OUT_FLG" ).append("\n"); 
		query.append("     , A.VSL_DZND_CAPA" ).append("\n"); 
		query.append("     , A.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("     , A.VSL_CLSS_GRP_CD AS VSL_CLSS_GRP" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM MAS_POOL_VSL_RGST A" ).append("\n"); 
		query.append(" WHERE A.COST_YRMON = REPLACE(@[f_yearweek],'-','')" ).append("\n"); 
		query.append(" ORDER BY A.VSL_CLSS_GRP_CD, A.VSL_CD" ).append("\n"); 

	}
}