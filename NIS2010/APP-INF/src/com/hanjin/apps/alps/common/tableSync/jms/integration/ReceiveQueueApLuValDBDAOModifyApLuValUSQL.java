/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueApLuValDBDAOModifyApLuValUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueApLuValDBDAOModifyApLuValUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update ap_lu_val
	  * </pre>
	  */
	public ReceiveQueueApLuValDBDAOModifyApLuValUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_st_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aval_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_tp_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lu_end_act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueApLuValDBDAOModifyApLuValUSQL").append("\n"); 
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
		query.append("UPDATE ap_lu_val" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("lu_delt_flg   	= @[lu_delt_flg]" ).append("\n"); 
		query.append(", lu_ctnt     	= HJSEAI_PKG.h_decode(@[lu_ctnt], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append(", lu_desc       = HJSEAI_PKG.h_decode(@[lu_desc], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append(", lu_st_act_dt  = to_date(@[lu_st_act_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", lu_end_act_dt = to_date(@[lu_end_act_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", cre_dt        = to_date(@[cre_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", cre_usr_id    = @[cre_usr_id]" ).append("\n"); 
		query.append(", upd_dt        = to_date(@[upd_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", upd_usr_id    = @[upd_usr_id]" ).append("\n"); 
		query.append(", eai_evnt_dt   = to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 
		query.append(", aval_flg	    = @[aval_flg]" ).append("\n"); 
		query.append("WHERE 	lu_tp_ind_cd = HJSEAI_PKG.h_decode(@[lu_tp_ind_cd], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append("AND	lu_cd        = HJSEAI_PKG.h_decode(@[lu_cd], 'UTF8' ,'UTF8')" ).append("\n"); 
		query.append("AND 	eai_evnt_dt <= to_date(@[eai_evnt_dt],'yyyymmddhh24miss')" ).append("\n"); 

	}
}