/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOPriScgAplyDtRuleVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOPriScgAplyDtRuleVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.07.07 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing) 신규개발
	  *                                                 - Application Date Rule 정보를 저장한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOPriScgAplyDtRuleVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_dt_rule_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_dt_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOPriScgAplyDtRuleVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCG_APLY_DT_RULE" ).append("\n"); 
		query.append("    (SCG_APLY_DT_RULE_SEQ" ).append("\n"); 
		query.append("    ,SVC_SCP_CD" ).append("\n"); 
		query.append("    ,POR_TP_CD" ).append("\n"); 
		query.append("    ,POR_DEF_CD" ).append("\n"); 
		query.append("    ,POL_TP_CD" ).append("\n"); 
		query.append("    ,POL_DEF_CD" ).append("\n"); 
		query.append("    ,POD_TP_CD" ).append("\n"); 
		query.append("    ,POD_DEF_CD" ).append("\n"); 
		query.append("    ,DEL_TP_CD" ).append("\n"); 
		query.append("    ,DEL_DEF_CD" ).append("\n"); 
		query.append("    ,APLY_DT_RULE_TP_CD" ).append("\n"); 
		query.append("    ,EFF_DT" ).append("\n"); 
		query.append("    ,EXP_DT" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,APLY_DT_RMK)" ).append("\n"); 
		query.append("SELECT  NVL(MAX(SCG_APLY_DT_RULE_SEQ), 0) +1" ).append("\n"); 
		query.append("       ,@[svc_scp_cd]" ).append("\n"); 
		query.append("       ,@[por_tp_cd]" ).append("\n"); 
		query.append("       ,@[por_def_cd]" ).append("\n"); 
		query.append("       ,@[pol_tp_cd]" ).append("\n"); 
		query.append("       ,@[pol_def_cd]" ).append("\n"); 
		query.append("       ,@[pod_tp_cd]" ).append("\n"); 
		query.append("       ,@[pod_def_cd]" ).append("\n"); 
		query.append("       ,@[del_tp_cd]" ).append("\n"); 
		query.append("       ,@[del_def_cd]" ).append("\n"); 
		query.append("       ,@[aply_dt_rule_tp_cd]" ).append("\n"); 
		query.append("       ,TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("       ,TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[upd_usr_id]" ).append("\n"); 
		query.append("       ,@[aply_dt_rmk]" ).append("\n"); 
		query.append("  FROM  PRI_SCG_APLY_DT_RULE" ).append("\n"); 

	}
}