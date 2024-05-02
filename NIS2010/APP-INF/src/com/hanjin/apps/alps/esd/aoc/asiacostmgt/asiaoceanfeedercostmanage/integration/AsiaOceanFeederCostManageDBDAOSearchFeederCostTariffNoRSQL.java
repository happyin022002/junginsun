/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AsiaOceanFeederCostManageDBDAOSearchFeederCostTariffNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AsiaOceanFeederCostManageDBDAOSearchFeederCostTariffNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFeederCostTariffNo
	  * </pre>
	  */
	public AsiaOceanFeederCostManageDBDAOSearchFeederCostTariffNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiaoceanfeedercostmanage.integration").append("\n"); 
		query.append("FileName : AsiaOceanFeederCostManageDBDAOSearchFeederCostTariffNoRSQL").append("\n"); 
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
		query.append("SELECT COST_TRF_NO" ).append("\n"); 
		query.append("  FROM AOC_CHN_FDR_TRF_HDR" ).append("\n"); 
		query.append(" WHERE RHQ_CD = @[in_ofc_cd]" ).append("\n"); 
		query.append("   AND COST_TRF_STS_CD IN ('B', 'U', 'C')" ).append("\n"); 
		query.append("ORDER BY CRE_DT DESC " ).append("\n"); 

	}
}