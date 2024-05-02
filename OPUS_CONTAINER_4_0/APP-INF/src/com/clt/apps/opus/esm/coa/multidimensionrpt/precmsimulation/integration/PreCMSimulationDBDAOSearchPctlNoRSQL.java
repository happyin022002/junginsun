/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PreCMSimulationDBDAOSearchPctlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreCMSimulationDBDAOSearchPctlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPctlNo
	  * </pre>
	  */
	public PreCMSimulationDBDAOSearchPctlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.precmsimulation.integration").append("\n"); 
		query.append("FileName : PreCMSimulationDBDAOSearchPctlNoRSQL").append("\n"); 
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
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT M.PCTL_NO, M.TTL_TZTM_HRS" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("     PRD_PROD_CTL_ROUT_DTL D," ).append("\n"); 
		query.append("     MDM_DTL_REV_LANE RL" ).append("\n"); 
		query.append("WHERE M.PCTL_NO LIKE  @[pctl_no]||'%'" ).append("\n"); 
		query.append("  AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("  AND M.TRNK_VSL_CD = D.VSL_CD" ).append("\n"); 
		query.append("  AND M.TRNK_SKD_VOY_NO = D.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND M.TRNK_SKD_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND RL.VSL_SLAN_DIR_CD = D.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND RL.FM_CONTI_CD = (SELECT CONTI_CD" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                         WHERE LOC_CD = SUBSTR(D.ORG_NOD_CD,1,5))" ).append("\n"); 
		query.append("  AND RL.TO_CONTI_CD = (SELECT CONTI_CD" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION" ).append("\n"); 
		query.append("                         WHERE LOC_CD = SUBSTR(D.DEST_NOD_CD,1,5))" ).append("\n"); 
		query.append("  AND RL.RLANE_CD LIKE D.VSL_SLAN_CD ||'%'" ).append("\n"); 
		query.append("  AND RL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("  ORDER BY M.TTL_TZTM_HRS, M.PCTL_NO" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  WHERE ROWNUM<11" ).append("\n"); 

	}
}