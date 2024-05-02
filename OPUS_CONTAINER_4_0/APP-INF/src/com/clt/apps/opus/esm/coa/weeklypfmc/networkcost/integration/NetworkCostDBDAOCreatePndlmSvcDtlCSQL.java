/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NetworkCostDBDAOCreatePndlmSvcDtlCSQL.java
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

public class NetworkCostDBDAOCreatePndlmSvcDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkCostDBDAOCreatePndlmSvcDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("last_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rs_cnt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : NetworkCostDBDAOCreatePndlmSvcDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_PNDLM_SVC_DTL (" ).append("\n"); 
		query.append("         SLAN_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,YD_CD" ).append("\n"); 
		query.append("        ,EFF_FM_DT" ).append("\n"); 
		query.append("        ,EFF_TO_DT" ).append("\n"); 
		query.append("        ,PNDLM_RTO								--20151210.ADD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT)" ).append("\n"); 
		query.append("SELECT DISTINCT  " ).append("\n"); 
		query.append("         @[slan_cd]" ).append("\n"); 
		query.append("        ,@[dir_cd] " ).append("\n"); 
		query.append("        ,@[rlane_cd]" ).append("\n"); 
		query.append("        ,TRIM(YD_CD)			AS YD_CD" ).append("\n"); 
		query.append("        ,@[eff_fm_dt]" ).append("\n"); 
		query.append("        ,@[eff_to_dt]" ).append("\n"); 
		query.append("        ,TO_NUMBER(TRIM('0'))	AS PNDLM_RTO			--20151210.ADD" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]       " ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("   FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("  WHERE SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("    AND SKD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("    AND TO_CHAR(PF_ETD_DT,'YYYYMMDD')  > @[eff_fm_dt]	--20151215.MOD" ).append("\n"); 
		query.append(" UNION ALL												--20151210.ADD" ).append("\n"); 
		query.append("  SELECT  " ).append("\n"); 
		query.append("         @[slan_cd]" ).append("\n"); 
		query.append("        ,@[dir_cd] " ).append("\n"); 
		query.append("        ,@[rlane_cd]" ).append("\n"); 
		query.append("        ,TRIM('XXXXXXX')		AS YD_CD" ).append("\n"); 
		query.append("        ,@[eff_fm_dt]" ).append("\n"); 
		query.append("        ,@[eff_to_dt]" ).append("\n"); 
		query.append("        ,DECODE(@[last_yn],'Y',1-(ROUND(1/TO_NUMBER(@[rs_cnt]),2)*(TO_NUMBER(@[rs_cnt])-1)),ROUND(1/TO_NUMBER(@[rs_cnt]),2))	AS PNDLM_RTO" ).append("\n"); 
		query.append("        ,@[cre_usr_id]" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,@[upd_usr_id]       " ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}