/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OPCostDBDAOStndUseQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.12.16 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ock, KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPCostDBDAOStndUseQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StndUseQty
	  * </pre>
	  */
	public OPCostDBDAOStndUseQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration").append("\n"); 
		query.append("FileName : OPCostDBDAOStndUseQtyRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       HUL_BND_CD," ).append("\n"); 
		query.append("       VSL_CD||SKD_VOY_NO||DIR_CD AS VVD," ).append("\n"); 
		query.append("       VVD_BSA_CAPA," ).append("\n"); 
		query.append("       LOD_QTY," ).append("\n"); 
		query.append("       LDF_RTO," ).append("\n"); 
		query.append("       COST_WK," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       UPD_USR_ID" ).append("\n"); 
		query.append("  FROM MAS_STND_USE_QTY" ).append("\n"); 
		query.append(" WHERE COST_YRMON  = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND VSL_CD     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("   AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != '')" ).append("\n"); 
		query.append("   AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY COST_YRMON," ).append("\n"); 
		query.append("       TRD_CD," ).append("\n"); 
		query.append("       SUB_TRD_CD," ).append("\n"); 
		query.append("       RLANE_CD," ).append("\n"); 
		query.append("       DIR_CD," ).append("\n"); 
		query.append("       VSL_CD||SKD_VOY_NO||DIR_CD" ).append("\n"); 

	}
}