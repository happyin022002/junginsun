/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAONetworkCostExceptionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.08.20 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAONetworkCostExceptionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Network Cost Exception List 를 조회한다.
	  * </pre>
	  */
	public NetworkCostDBDAONetworkCostExceptionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("select1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAONetworkCostExceptionListRSQL").append("\n"); 
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
		query.append("SELECT A.STND_COST_CD" ).append("\n"); 
		query.append("      ,B.STND_COST_NM" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.EFF_FM_YRWK" ).append("\n"); 
		query.append("      ,A.EFF_TO_YRWK" ).append("\n"); 
		query.append("      ,A.DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,A.CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT" ).append("\n"); 
		query.append("      ,A.STND_COST_CD AS STND_COST_CD_ORG" ).append("\n"); 
		query.append("	  ,EFF_FM_YRWK  AS EFF_FM_YRWK_ORG" ).append("\n"); 
		query.append("      ,EFF_TO_YRWK  AS EFF_TO_YRWK_ORG" ).append("\n"); 
		query.append("      ,A.VSL_CD       AS VSL_CD_ORG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID   AS CRE_USR_ID_ORG" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID   AS UPD_USR_ID_ORG" ).append("\n"); 
		query.append("  FROM MAS_NTWK_EXPT_LIST A" ).append("\n"); 
		query.append("      ,MAS_STND_ACCT      B" ).append("\n"); 
		query.append(" WHERE A.STND_COST_CD = B.STND_COST_CD" ).append("\n"); 
		query.append("   AND (@[f_yearweek] BETWEEN A.EFF_FM_YRWK AND A.EFF_TO_YRWK" ).append("\n"); 
		query.append("OR @[f_yearweek] <= A.EFF_TO_YRWK)" ).append("\n"); 
		query.append(" #if (${f_selcost} != '')  " ).append("\n"); 
		query.append("   AND A.STND_COST_CD = @[f_selcost]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${select1} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD       = @[select1]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" ORDER BY A.STND_COST_CD, A.VSL_CD, A.EFF_FM_YRWK, A.EFF_TO_YRWK" ).append("\n"); 

	}
}