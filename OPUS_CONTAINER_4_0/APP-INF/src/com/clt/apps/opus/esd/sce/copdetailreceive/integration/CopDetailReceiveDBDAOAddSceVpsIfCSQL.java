/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CopDetailReceiveDBDAOAddSceVpsIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOAddSceVpsIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddSceVpsIf
	  * </pre>
	  */
	public CopDetailReceiveDBDAOAddSceVpsIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rcv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dlay_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOAddSceVpsIfCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_VPS_IF(" ).append("\n"); 
		query.append("vps_rcv_dt" ).append("\n"); 
		query.append(",vps_rcv_no" ).append("\n"); 
		query.append(",vsl_cd" ).append("\n"); 
		query.append(",skd_voy_no" ).append("\n"); 
		query.append(",skd_dir_cd" ).append("\n"); 
		query.append(",vps_port_cd" ).append("\n"); 
		query.append(",clpt_ind_seq" ).append("\n"); 
		query.append(",vps_evnt_tp_cd" ).append("\n"); 
		query.append(",vps_evnt_dt" ).append("\n"); 
		query.append(",vps_if_sts_cd" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt" ).append("\n"); 
		query.append(",vsl_dlay_rsn_cd" ).append("\n"); 
		query.append(",vsl_dlay_rsn_desc" ).append("\n"); 
		query.append(",vps_loc_cd" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("TO_CHAR(sysdate,'YYYYMMDD')" ).append("\n"); 
		query.append(",sce_vps_if_seq1.nextval" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[vps_port_cd]" ).append("\n"); 
		query.append(",@[clpt_ind_seq]" ).append("\n"); 
		query.append(",DECODE(@[act_rcv_tp_cd],'24','ETA','25','ETB','26','ETD')" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt],'YYYY/MM/DD HH24:MI:SS')" ).append("\n"); 
		query.append(",'00'" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[vsl_dlay_rsn_cd]" ).append("\n"); 
		query.append(",@[vsl_dlay_rsn_desc]" ).append("\n"); 
		query.append(",@[vps_loc_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}