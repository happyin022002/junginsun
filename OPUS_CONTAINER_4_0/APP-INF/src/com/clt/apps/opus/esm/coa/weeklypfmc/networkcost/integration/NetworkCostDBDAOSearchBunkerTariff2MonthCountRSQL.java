/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NetworkCostDBDAOSearchBunkerTariff2MonthCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Dae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchBunkerTariff2MonthCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBunkerTariff2MonthCount SELECT
	  * </pre>
	  */
	public NetworkCostDBDAOSearchBunkerTariff2MonthCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchBunkerTariff2MonthCountRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT A1.COST_YRMON) CNT" ).append("\n"); 
		query.append("FROM COA_MON_VVD A1" ).append("\n"); 
		query.append(", COA_BNK_TRF A2" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND A1.SLS_YRMON     = A2.COST_YRMON" ).append("\n"); 
		query.append("AND A1.SLAN_CD       = A2.SLAN_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD        = A2.SLAN_DIR_CD" ).append("\n"); 
		query.append("AND A1.SLS_YRMON     LIKE @[sls_yrmon] ||'%'" ).append("\n"); 
		query.append("AND A1.COST_WK       = @[cost_wk]" ).append("\n"); 
		query.append("AND A1.DELT_FLG      <> 'Y'" ).append("\n"); 
		query.append("AND A2.SLAN_CD       = NVL(@[slan_cd], A2.SLAN_CD)" ).append("\n"); 
		query.append("AND A2.RLANE_CD      = NVL(@[rlane_cd], A2.RLANE_CD)" ).append("\n"); 
		query.append("AND A2.VSL_CLSS_CAPA = NVL(@[vsl_clss_capa], A2.VSL_CLSS_CAPA)" ).append("\n"); 

	}
}