/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueArAgnStmtAgmtDBDAOAddArAgnStmtAgmtListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.30 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArAgnStmtAgmtDBDAOAddArAgnStmtAgmtListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ar_agn_stmt_agmt 테이블에 저장
	  * </pre>
	  */
	public ReceiveQueueArAgnStmtAgmtDBDAOAddArAgnStmtAgmtListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_apro_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_apro_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prpr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_prd_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueArAgnStmtAgmtDBDAOAddArAgnStmtAgmtListCSQL").append("\n"); 
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
		query.append("INSERT INTO	ar_agn_stmt_agmt (" ).append("\n"); 
		query.append("asa_rhq_cd," ).append("\n"); 
		query.append("asa_no," ).append("\n"); 
		query.append("asa_ofc_cd," ).append("\n"); 
		query.append("asa_curr_cd," ).append("\n"); 
		query.append("asa_prd_fm_dt," ).append("\n"); 
		query.append("asa_prd_to_dt," ).append("\n"); 
		query.append("asa_clz_dt," ).append("\n"); 
		query.append("asa_prpr_usr_id," ).append("\n"); 
		query.append("asa_apro_usr_id," ).append("\n"); 
		query.append("asa_apro_dt," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("eai_evnt_dt," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES  (" ).append("\n"); 
		query.append("@[asa_rhq_cd]," ).append("\n"); 
		query.append("@[asa_no]," ).append("\n"); 
		query.append("@[asa_ofc_cd]," ).append("\n"); 
		query.append("@[asa_curr_cd]," ).append("\n"); 
		query.append("substr(@[asa_prd_fm_dt],1,8)," ).append("\n"); 
		query.append("substr(@[asa_prd_to_dt],1,8)," ).append("\n"); 
		query.append("substr(@[asa_clz_dt],1,8)," ).append("\n"); 
		query.append("@[asa_prpr_usr_id]," ).append("\n"); 
		query.append("@[asa_apro_usr_id]," ).append("\n"); 
		query.append("substr(@[asa_apro_dt],1,8)," ).append("\n"); 
		query.append("@[delt_flg]," ).append("\n"); 
		query.append("to_date(@[eai_evnt_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("to_date(@[eai_evnt_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("'MIG_USER'," ).append("\n"); 
		query.append("'MIG_USER'," ).append("\n"); 
		query.append("to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}