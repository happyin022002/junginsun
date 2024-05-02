/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOModifyAvgHireOwnVslListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.02 
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

public class NetworkCostDBDAOModifyAvgHireOwnVslListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AVG-hire by Own-VSL (PA) 의 정보를 수정한다.
	  * 20150402 김시몬 WEEK = '00'으로 고정되도록 수정(WEEK의미 없음)
	  * </pre>
	  */
	public NetworkCostDBDAOModifyAvgHireOwnVslListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hb_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addhb_cost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_dtrb_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fin_cost",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("own_vsl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tab_item",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOModifyAvgHireOwnVslListUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_OWN_VSL_DLY_HIR A" ).append("\n"); 
		query.append("     USING" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("	      SELECT @[cost_yrmon]    AS COST_YRMON," ).append("\n"); 
		query.append("	             @[cost_wk]       AS COST_WK," ).append("\n"); 
		query.append("	             @[vsl_cd]        AS VSL_CD," ).append("\n"); 
		query.append("	             @[vsl_clss_capa] AS VSL_CLSS_CAPA," ).append("\n"); 
		query.append("	             @[tab_item]      AS STND_COST_CD,         " ).append("\n"); 
		query.append("                 @[eff_fm_yrmon]  AS EFF_FM_YRMON," ).append("\n"); 
		query.append("                 @[eff_to_yrmon]  AS EFF_TO_YRMON," ).append("\n"); 
		query.append("           	     @[vsl_amt]       AS VSL_AMT," ).append("\n"); 
		query.append("           	     @[com_dtrb_amt]  AS COM_DTRB_AMT," ).append("\n"); 
		query.append("           	     @[hb_cost]       AS DHIR_BFR_AMT," ).append("\n"); 
		query.append("           	     @[addhb_cost]    AS DHIR_ADD_AMT," ).append("\n"); 
		query.append("                 @[fin_cost]      AS DHIR_AMT," ).append("\n"); 
		query.append("                 @[own_vsl_rmk]   AS OWN_VSL_RMK," ).append("\n"); 
		query.append("           	     @[cre_usr_id]    AS CRE_USR_ID" ).append("\n"); 
		query.append("	        FROM DUAL" ).append("\n"); 
		query.append("          ) T" ).append("\n"); 
		query.append("        ON (" ).append("\n"); 
		query.append("            T.COST_YRMON    = A.COST_YRMON    AND " ).append("\n"); 
		query.append("            --T.COST_WK       = A.COST_WK       AND " ).append("\n"); 
		query.append("            T.VSL_CD        = A.VSL_CD        AND " ).append("\n"); 
		query.append("            T.VSL_CLSS_CAPA = A.VSL_CLSS_CAPA AND " ).append("\n"); 
		query.append("            T.STND_COST_CD  = A.STND_COST_CD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("      WHEN MATCHED THEN" ).append("\n"); 
		query.append("           		UPDATE SET" ).append("\n"); 
		query.append("                       A.VSL_AMT      = @[vsl_amt]" ).append("\n"); 
		query.append("                     , A.COM_DTRB_AMT = @[com_dtrb_amt]" ).append("\n"); 
		query.append("                     , A.DHIR_BFR_AMT = @[hb_cost]" ).append("\n"); 
		query.append("                     , A.DHIR_ADD_AMT = @[addhb_cost]" ).append("\n"); 
		query.append("                     , A.DHIR_AMT     = @[fin_cost]" ).append("\n"); 
		query.append("                     , A.OWN_VSL_RMK  = @[own_vsl_rmk]" ).append("\n"); 
		query.append("                     , A.UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append("                     , A.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("      WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("           		INSERT (" ).append("\n"); 
		query.append("                         A.COST_YRMON   " ).append("\n"); 
		query.append("                       , A.COST_WK      " ).append("\n"); 
		query.append("                       , A.VSL_CD       " ).append("\n"); 
		query.append("                       , A.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("                       , A.STND_COST_CD" ).append("\n"); 
		query.append("                       , A.DHIR_AMT" ).append("\n"); 
		query.append("                       , A.EFF_FM_YRMON" ).append("\n"); 
		query.append("                       , A.EFF_TO_YRMON" ).append("\n"); 
		query.append("                       , A.VSL_AMT" ).append("\n"); 
		query.append("                       , A.COM_DTRB_AMT" ).append("\n"); 
		query.append("                       , A.DHIR_ADD_AMT" ).append("\n"); 
		query.append("                       , A.DHIR_BFR_AMT" ).append("\n"); 
		query.append("                       , A.OWN_VSL_RMK" ).append("\n"); 
		query.append("                       , A.CRE_USR_ID" ).append("\n"); 
		query.append("                       , A.CRE_DT" ).append("\n"); 
		query.append("                       , A.UPD_USR_ID" ).append("\n"); 
		query.append("                       , A.UPD_DT" ).append("\n"); 
		query.append("                       ) " ).append("\n"); 
		query.append("                VALUES (" ).append("\n"); 
		query.append("                        T.COST_YRMON," ).append("\n"); 
		query.append("        	            '00', --T.COST_WK," ).append("\n"); 
		query.append("        	            T.VSL_CD," ).append("\n"); 
		query.append("        	            T.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("        	            T.STND_COST_CD, " ).append("\n"); 
		query.append("        	            T.DHIR_AMT,        " ).append("\n"); 
		query.append("                        T.EFF_FM_YRMON," ).append("\n"); 
		query.append("                        T.EFF_TO_YRMON," ).append("\n"); 
		query.append("                   	    T.VSL_AMT," ).append("\n"); 
		query.append("                   	    T.COM_DTRB_AMT," ).append("\n"); 
		query.append("                   	    T.DHIR_ADD_AMT," ).append("\n"); 
		query.append("                   	    T.DHIR_BFR_AMT," ).append("\n"); 
		query.append("                   	    T.OWN_VSL_RMK," ).append("\n"); 
		query.append("                   	    T.CRE_USR_ID," ).append("\n"); 
		query.append("                   	    SYSDATE," ).append("\n"); 
		query.append("                   	    T.CRE_USR_ID," ).append("\n"); 
		query.append("                   	    SYSDATE" ).append("\n"); 
		query.append("                   	   )" ).append("\n"); 

	}
}