/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchLaneTSUnitCostListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.15 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Dae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchLaneTSUnitCostListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchLaneTSUnitCostList SELECT
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchLaneTSUnitCostListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchLaneTSUnitCostListRSQL").append("\n"); 
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
		query.append("A.COST_YR          AS COST_YR" ).append("\n"); 
		query.append(",A.FM_TRD_CD        AS FM_TRD_CD" ).append("\n"); 
		query.append(",A.FM_RLANE_CD      AS FM_RLANE_CD" ).append("\n"); 
		query.append(",A.FM_IOC_CD        AS FM_IOC_CD" ).append("\n"); 
		query.append(",A.FM_SKD_DIR_CD    AS FM_SKD_DIR_CD" ).append("\n"); 
		query.append(",A.TS_UC_AMT        AS TS_UC_AMT" ).append("\n"); 
		query.append("FROM COA_LANE_TS_UT_COST A" ).append("\n"); 
		query.append("WHERE A.COST_YR = @[cost_yr]" ).append("\n"); 
		query.append("#if (${fm_trd_cd} != '')" ).append("\n"); 
		query.append("AND A.FM_TRD_CD = @[fm_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_rlane_cd} != '')" ).append("\n"); 
		query.append("AND A.FM_RLANE_CD = @[fm_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_ioc_cd} != '')" ).append("\n"); 
		query.append("AND A.FM_IOC_CD = @[fm_ioc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND A.FM_SKD_DIR_CD = @[fm_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("A.COST_YR" ).append("\n"); 
		query.append(",A.FM_TRD_CD" ).append("\n"); 
		query.append(",A.FM_RLANE_CD" ).append("\n"); 
		query.append(",A.FM_IOC_CD" ).append("\n"); 
		query.append(",A.FM_SKD_DIR_CD" ).append("\n"); 

	}
}