/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAONetworkCostExceptionListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.08 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAONetworkCostExceptionListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Network Cost Exception List 를 저장한다.(Insert)
	  * </pre>
	  */
	public NetworkCostDBDAONetworkCostExceptionListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAONetworkCostExceptionListCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_NTWK_EXPT_LIST A" ).append("\n"); 
		query.append("     USING" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("	      SELECT @[stnd_cost_cd]   AS STND_COST_CD," ).append("\n"); 
		query.append("	             @[vsl_cd]         AS VSL_CD," ).append("\n"); 
		query.append("	             @[eff_fm_yrwk]    AS EFF_FM_YRWK," ).append("\n"); 
		query.append("	             @[eff_to_yrwk]    AS EFF_TO_YRWK,	             " ).append("\n"); 
		query.append("           	     @[upd_usr_id]     AS CRE_USR_ID" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("	        FROM DUAL" ).append("\n"); 
		query.append("          ) T" ).append("\n"); 
		query.append("        ON (" ).append("\n"); 
		query.append("            T.STND_COST_CD  = A.STND_COST_CD   AND             " ).append("\n"); 
		query.append("            T.VSL_CD        = A.VSL_CD         AND " ).append("\n"); 
		query.append("            T.EFF_FM_YRWK   = A.EFF_FM_YRWK    AND " ).append("\n"); 
		query.append("            T.EFF_TO_YRWK   = A.EFF_TO_YRWK" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("      WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("           		INSERT (" ).append("\n"); 
		query.append("                         A.STND_COST_CD" ).append("\n"); 
		query.append("                       , A.VSL_CD" ).append("\n"); 
		query.append("                       , A.EFF_FM_YRWK" ).append("\n"); 
		query.append("                       , A.EFF_TO_YRWK" ).append("\n"); 
		query.append("                       , A.DELT_FLG" ).append("\n"); 
		query.append("                       , A.CRE_USR_ID" ).append("\n"); 
		query.append("                       , A.CRE_DT" ).append("\n"); 
		query.append("                       , A.UPD_USR_ID" ).append("\n"); 
		query.append("                       , A.UPD_DT " ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("                VALUES (" ).append("\n"); 
		query.append("                         T.STND_COST_CD" ).append("\n"); 
		query.append("                       , T.VSL_CD" ).append("\n"); 
		query.append("                       , T.EFF_FM_YRWK" ).append("\n"); 
		query.append("                       , T.EFF_TO_YRWK" ).append("\n"); 
		query.append("                       , 'N'" ).append("\n"); 
		query.append("                       , T.CRE_USR_ID" ).append("\n"); 
		query.append("                       , SYSDATE" ).append("\n"); 
		query.append("                       , T.CRE_USR_ID" ).append("\n"); 
		query.append("                       , SYSDATE" ).append("\n"); 
		query.append("                   	   )" ).append("\n"); 

	}
}