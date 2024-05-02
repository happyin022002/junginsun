/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOAddVskPfSkdHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.11.12 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOAddVskPfSkdHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddVskPfSkdHis
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOAddVskPfSkdHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOAddVskPfSkdHisCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_PF_SKD_HIS(" ).append("\n"); 
		query.append("VSL_SLAN_CD" ).append("\n"); 
		query.append(",PF_SVC_TP_CD" ).append("\n"); 
		query.append(",SIM_DT" ).append("\n"); 
		query.append(",SIM_NO" ).append("\n"); 
		query.append(",PF_HIS_SEQ" ).append("\n"); 
		query.append(",PF_SKD_STS_CD" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[vsl_slan_cd]" ).append("\n"); 
		query.append(",@[pf_svc_tp_cd]" ).append("\n"); 
		query.append(",@[sim_dt]" ).append("\n"); 
		query.append(",@[sim_no]" ).append("\n"); 
		query.append(",(SELECT /*+index_desc(VSK_PF_SKD_HIS XPKVSK_PF_SKD_HIS)*/" ).append("\n"); 
		query.append("NVL(MAX(PF_HIS_SEQ),0) +1" ).append("\n"); 
		query.append("FROM  VSK_PF_SKD_HIS" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND   PF_SVC_TP_CD = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND   ROWNUM <= 1)" ).append("\n"); 
		query.append(",@[pf_skd_sts_cd]" ).append("\n"); 
		query.append(",@[diff_rmk]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}