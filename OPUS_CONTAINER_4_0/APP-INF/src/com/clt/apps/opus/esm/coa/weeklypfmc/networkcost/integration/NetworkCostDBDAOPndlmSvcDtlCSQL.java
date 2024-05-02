/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOPndlmSvcDtlCSQL.java
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

public class NetworkCostDBDAOPndlmSvcDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkCostDBDAOPndlmSvcDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pndlm_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOPndlmSvcDtlCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PNDLM_SVC_DTL B1 " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("	 AND B1.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("     AND B1.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("     AND B1.YD_CD      = @[yd_cd]" ).append("\n"); 
		query.append("     AND B1.EFF_FM_DT  = @[eff_fm_dt])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET PNDLM_RTO   = @[pndlm_rto]" ).append("\n"); 
		query.append("            ,UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT ( SLAN_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,YD_CD" ).append("\n"); 
		query.append("              ,EFF_FM_DT" ).append("\n"); 
		query.append("              ,EFF_TO_DT" ).append("\n"); 
		query.append("              ,PNDLM_RTO" ).append("\n"); 
		query.append("              ,CRE_USR_ID" ).append("\n"); 
		query.append("              ,CRE_DT" ).append("\n"); 
		query.append("              ,UPD_USR_ID" ).append("\n"); 
		query.append("              ,UPD_DT" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("      VALUES (@[slan_cd]" ).append("\n"); 
		query.append("             ,@[dir_cd]" ).append("\n"); 
		query.append("             ,@[rlane_cd]" ).append("\n"); 
		query.append("             ,@[yd_cd]" ).append("\n"); 
		query.append("             ,@[eff_fm_dt]" ).append("\n"); 
		query.append("			 ,@[eff_to_dt]" ).append("\n"); 
		query.append("             ,@[pndlm_rto]" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE)" ).append("\n"); 

	}
}