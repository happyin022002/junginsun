/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueArAgnStmtAgmtDBDAOModifyArAgnStmtAgmtListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.10.27 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArAgnStmtAgmtDBDAOModifyArAgnStmtAgmtListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ar_agn_stmt_agmt 테이블 수정
	  * </pre>
	  */
	public ReceiveQueueArAgnStmtAgmtDBDAOModifyArAgnStmtAgmtListUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueArAgnStmtAgmtDBDAOModifyArAgnStmtAgmtListUSQL").append("\n"); 
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
		query.append("UPDATE ar_agn_stmt_agmt	SET" ).append("\n"); 
		query.append("asa_ofc_cd		= @[asa_ofc_cd]," ).append("\n"); 
		query.append("asa_curr_cd		= @[asa_curr_cd]," ).append("\n"); 
		query.append("asa_prd_fm_dt	= substr(@[asa_prd_fm_dt],1,8)," ).append("\n"); 
		query.append("asa_prd_to_dt	= substr(@[asa_prd_to_dt],1,8)," ).append("\n"); 
		query.append("asa_clz_dt		= substr(@[asa_clz_dt],1,8)," ).append("\n"); 
		query.append("asa_prpr_usr_id	= @[asa_prpr_usr_id]," ).append("\n"); 
		query.append("asa_apro_usr_id	= @[asa_apro_usr_id]," ).append("\n"); 
		query.append("asa_apro_dt		= substr(@[asa_apro_dt],1,8)," ).append("\n"); 
		query.append("delt_flg		= @[delt_flg]," ).append("\n"); 
		query.append("eai_evnt_dt		= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')," ).append("\n"); 
		query.append("upd_dt			= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append("WHERE asa_rhq_cd = @[asa_rhq_cd]" ).append("\n"); 
		query.append("AND	asa_no = @[asa_no]" ).append("\n"); 
		query.append("AND	eai_evnt_dt	<= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}