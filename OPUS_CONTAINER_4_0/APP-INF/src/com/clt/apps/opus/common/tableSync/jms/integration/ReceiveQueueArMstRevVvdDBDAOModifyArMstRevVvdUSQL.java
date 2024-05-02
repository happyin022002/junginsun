/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueArMstRevVvdDBDAOModifyArMstRevVvdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.29
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2010.06.29 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.common.tableSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueArMstRevVvdDBDAOModifyArMstRevVvdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ar_mst_rev_vvd update
	  * </pre>
	  */
	public ReceiveQueueArMstRevVvdDBDAOModifyArMstRevVvdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_vvd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_com_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_ie_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_im_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_ia_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_oo_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueArMstRevVvdDBDAOModifyArMstRevVvdUSQL").append("\n"); 
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
		query.append("UPDATE ar_mst_rev_vvd" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("voy_tp_cd		= @[voy_tp_cd]" ).append("\n"); 
		query.append(", slan_cd		= @[slan_cd]" ).append("\n"); 
		query.append(", rlane_cd		= @[rlane_cd]" ).append("\n"); 
		query.append(", port_chk_flg	= @[port_chk_flg]" ).append("\n"); 
		query.append(", lod_qty		= @[lod_qty]" ).append("\n"); 
		query.append(", com_vvd_flg	= @[com_vvd_flg]" ).append("\n"); 
		query.append(", vvd_com_lvl	= @[vvd_com_lvl]" ).append("\n"); 
		query.append(", rev_port_cd	= @[rev_port_cd]" ).append("\n"); 
		query.append(", delt_flg		= NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append(", rev_yrmon     =" ).append("\n"); 
		query.append("DECODE(delt_flg,'Y',NULL,( SELECT SUBSTR(DECODE(NVL(@[rev_oo_dt],'')," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("LEAST(NVL(@[rev_im_dt], '99991231235959')," ).append("\n"); 
		query.append("LEAST(NVL(@[rev_ie_dt],'99991231235959')," ).append("\n"); 
		query.append("NVL(@[rev_ia_dt],'99991231235959')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("@[rev_oo_dt])" ).append("\n"); 
		query.append(", 1, 6)" ).append("\n"); 
		query.append("FROM DUAL )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", eai_evnt_dt  = to_date(@[eai_evnt_dt], 'yyyymmddhh24miss')" ).append("\n"); 
		query.append("WHERE 	vsl_cd	= @[vsl_cd]" ).append("\n"); 
		query.append("AND	skd_voy_no = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	rlane_dir_cd = @[rlane_dir_cd]" ).append("\n"); 
		query.append("AND eai_evnt_dt <= to_date(@[eai_evnt_dt], 'yyyymmddhh24miss')" ).append("\n"); 

	}
}