/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveQueueArFincDirConvDBDAOCreateArFincDirConvCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.30 
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

public class ReceiveQueueArFincDirConvDBDAOCreateArFincDirConvCSQL implements ISQLTemplate{
 
	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass()); 
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateArFincDirConv
	  * </pre>
	  */
	public ReceiveQueueArFincDirConvDBDAOCreateArFincDirConvCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_rev_lane_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cng_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_conti",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_rev_lane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.tableSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueArFincDirConvDBDAOCreateArFincDirConvCSQL").append("\n"); 
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
		query.append("INSERT INTO AR_FINC_DIR_CONV (" ).append("\n"); 
		query.append("    slan_cd,                sconti_cd,              slan_dir_cd," ).append("\n"); 
		query.append("    rlane_dir_cd,           dir_cng_cd,             delt_flg," ).append("\n"); 
		query.append("    upd_usr_id,             cre_dt,                 upd_dt," ).append("\n"); 
		query.append("    eai_evnt_dt,            rlane_cd,				pod_conti_cd," ).append("\n"); 
		query.append("	pod_rlane_dir_cd,		pod_rlane_cd,			pod_slane_dir_cd" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("VALUES  (" ).append("\n"); 
		query.append("    @[slan_cd],           @[sconti_cd],         @[slan_dir_cd]," ).append("\n"); 
		query.append("    @[rlane_dir_cd],      @[dir_cng_cd],        @[delt_flg]," ).append("\n"); 
		query.append("    @[upd_usr_id],        SYSDATE,              SYSDATE," ).append("\n"); 
		query.append("    TO_DATE(@[eai_evnt_dt],'YYYYMMDDHH24MISS'), @[rlane_cd],				@[pod_conti]," ).append("\n"); 
		query.append("	SUBSTR(@[pod_rev_lane_dir], 2, 1),			@[pod_rev_lane],			SUBSTR(@[pod_rev_lane_dir], 1, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}