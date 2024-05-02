/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOaddVskCnlTzBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.18
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.12.18 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOaddVskCnlTzBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AgentCanalTransitFeeBCDBDAOaddVskCnlTzBkg
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOaddVskCnlTzBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_bkg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bkg_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_ot_svc_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bkg_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_bkg_prd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_bkg_tz_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_ot_svc_apro_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOaddVskCnlTzBkgCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_CNL_TZ_BKG(" ).append("\n"); 
		query.append("	CNL_TZ_BKG_YRMON" ).append("\n"); 
		query.append("	,VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,SKD_DIR_CD" ).append("\n"); 
		query.append("	,CNL_PORT_CD" ).append("\n"); 
		query.append("	,SVC_SCP_BND_CD" ).append("\n"); 
		query.append("	,CNL_TZ_BKG_PRD_CD" ).append("\n"); 
		query.append("	,CNL_TZ_BKG_PROC_STS_CD" ).append("\n"); 
		query.append("	,CNL_BKG_TZ_DT" ).append("\n"); 
		query.append("	,CNL_OT_SVC_APRO_FLG" ).append("\n"); 
		query.append("	,CNL_OT_SVC_ARR_DT" ).append("\n"); 
		query.append("	,CNL_BKG_AMT" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("	TO_CHAR(TO_DATE(@[cnl_tz_bkg_yrmon],'YYYY-MM-DD HH24:MI'),'YYYYMM')" ).append("\n"); 
		query.append("	,@[vsl_cd]" ).append("\n"); 
		query.append("	,@[skd_voy_no]" ).append("\n"); 
		query.append("	,@[skd_dir_cd]" ).append("\n"); 
		query.append("	,'PAPAC'" ).append("\n"); 
		query.append("	,DECODE(@[svc_scp_bnd_cd],'South','S','North','N','West','W','East','E','')" ).append("\n"); 
		query.append("	,@[cnl_tz_bkg_prd_cd]" ).append("\n"); 
		query.append("	,@[cnl_tz_bkg_proc_sts_cd]" ).append("\n"); 
		query.append("	,TO_DATE(@[cnl_bkg_tz_dt],'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("	,@[cnl_ot_svc_apro_flg]" ).append("\n"); 
		query.append("	,TO_DATE(@[cnl_ot_svc_arr_dt],'YYYY/MM/DD HH24:MI')" ).append("\n"); 
		query.append("	,@[cnl_bkg_amt]" ).append("\n"); 
		query.append("	,@[cre_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append("	,@[upd_usr_id]" ).append("\n"); 
		query.append("	,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}