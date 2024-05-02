/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivityManageDBDAOModifyRecoveryActivityListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009-09-28 Jong-Geon Byeon	1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RecoveryActivityManageDBDAOModifyRecoveryActivityListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Recovoery Activity List Modify
	  * </pre>
	  */
	public RecoveryActivityManageDBDAOModifyRecoveryActivityListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_act_upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ots_grp_rcvr_act_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitimanage.integration").append("\n"); 
		query.append("FileName : RecoveryActivityManageDBDAOModifyRecoveryActivityListUSQL").append("\n"); 
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
		query.append("UPDATE TPB_OTS_GRP_RCVR_ACT" ).append("\n"); 
		query.append("SET locl_cre_dt = SYSDATE" ).append("\n"); 
		query.append(",clt_act_upd_ofc_cd = @[clt_act_upd_ofc_cd]" ).append("\n"); 
		query.append(",cntc_pson_nm = @[cntc_pson_nm]" ).append("\n"); 
		query.append(",act_rmk = @[act_rmk]" ).append("\n"); 
		query.append(",file_no = @[file_no]" ).append("\n"); 
		query.append(",upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append(",upd_dt = SYSDATE" ).append("\n"); 
		query.append("WHERE n3pty_no = @[n3pty_no]" ).append("\n"); 
		query.append("AND ots_grp_rcvr_act_seq = @[ots_grp_rcvr_act_seq]" ).append("\n"); 

	}
}