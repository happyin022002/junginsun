/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOFcmBnkCsmPfSimVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.02 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOFcmBnkCsmPfSimVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sim_no 번호를 FCM_BNK_CSM_PF_SIM 테이블에 저장
	  * </pre>
	  */
	public SimulationDBDAOFcmBnkCsmPfSimVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bnk_csm_sim_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOFcmBnkCsmPfSimVOCSQL").append("\n"); 
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
		query.append("INSERT INTO FCM_BNK_CSM_PF_SIM (" ).append("\n"); 
		query.append("                vsl_slan_cd," ).append("\n"); 
		query.append("                pf_svc_tp_cd," ).append("\n"); 
		query.append("                bnk_csm_sim_no," ).append("\n"); 
		query.append("                cre_usr_id," ).append("\n"); 
		query.append("                cre_dt," ).append("\n"); 
		query.append("                upd_usr_id," ).append("\n"); 
		query.append("                upd_dt" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       VALUES  ( @[vsl_slan_cd]," ).append("\n"); 
		query.append("                @[pf_svc_tp_cd]," ).append("\n"); 
		query.append("                @[bnk_csm_sim_no]," ).append("\n"); 
		query.append("                @[cre_usr_id]," ).append("\n"); 
		query.append("                sysdate," ).append("\n"); 
		query.append("                @[upd_usr_id]," ).append("\n"); 
		query.append("                sysdate" ).append("\n"); 
		query.append("               )" ).append("\n"); 

	}
}