/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOPndlmSvcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOPndlmSvcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkCostDBDAOPndlmSvcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOPndlmSvcRSQL").append("\n"); 
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
		query.append("SELECT   DISTINCT" ).append("\n"); 
		query.append("         VVD_CD" ).append("\n"); 
		query.append("        ,EFF_FM_DT" ).append("\n"); 
		query.append("        ,EFF_TO_DT" ).append("\n"); 
		query.append("        ,SLAN_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("    FROM COA_PNDLM_SVC " ).append("\n"); 
		query.append("   WHERE 1 = 1 " ).append("\n"); 
		query.append("     AND SLAN_CD = NVL(@[f_slan_cd], SLAN_CD)" ).append("\n"); 
		query.append("     AND DIR_CD = NVL(@[f_dir_cd], DIR_CD)" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("     AND VVD_CD LIKE @[f_vsl_cd]||NVL(@[f_skd_voy_no],'')||NVL(@[f_dir],'')||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--20151126.MOD" ).append("\n"); 
		query.append("#if (${f_from_dt} != '')" ).append("\n"); 
		query.append("     AND @[f_from_dt] BETWEEN EFF_FM_DT AND NVL(EFF_TO_DT,'99991231')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   ORDER BY SLAN_CD, DIR_CD, EFF_FM_DT" ).append("\n"); 

	}
}