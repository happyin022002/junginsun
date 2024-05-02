/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivityManageDBDAOCreateRecoveryActivityListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009-09-28 Jong-Geon Byeon	1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RecoveryActivityManageDBDAOCreateRecoveryActivityListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Recovery Activity Insert
	  * </pre>
	  */
	public RecoveryActivityManageDBDAOCreateRecoveryActivityListCSQL(){
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
		params.put("n3pty_clt_rmk_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitimanage.integration").append("\n"); 
		query.append("FileName : RecoveryActivityManageDBDAOCreateRecoveryActivityListCSQL").append("\n"); 
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
		query.append("INSERT INTO TPB_OTS_GRP_RCVR_ACT" ).append("\n"); 
		query.append("(n3pty_no" ).append("\n"); 
		query.append(",ots_grp_rcvr_act_seq" ).append("\n"); 
		query.append(",cntc_pson_nm" ).append("\n"); 
		query.append(",act_rmk" ).append("\n"); 
		query.append(",n3pty_clt_rmk_tp_cd" ).append("\n"); 
		query.append(",clt_act_cre_ofc_cd" ).append("\n"); 
		query.append(",clt_act_upd_ofc_cd" ).append("\n"); 
		query.append(",file_no" ).append("\n"); 
		query.append(",locl_cre_dt" ).append("\n"); 
		query.append(",cre_usr_id" ).append("\n"); 
		query.append(",cre_dt" ).append("\n"); 
		query.append(",upd_usr_id" ).append("\n"); 
		query.append(",upd_dt)" ).append("\n"); 
		query.append("VALUES (@[n3pty_no]" ).append("\n"); 
		query.append(",@[ots_grp_rcvr_act_seq]" ).append("\n"); 
		query.append(",@[cntc_pson_nm]" ).append("\n"); 
		query.append(",@[act_rmk]" ).append("\n"); 
		query.append(",DECODE(@[n3pty_clt_rmk_tp_cd],'1','M')" ).append("\n"); 
		query.append(",@[clt_act_upd_ofc_cd]" ).append("\n"); 
		query.append(",@[clt_act_upd_ofc_cd]" ).append("\n"); 
		query.append(",@[file_no]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE)" ).append("\n"); 

	}
}