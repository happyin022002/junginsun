/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Recovery Activity List Search
	  * </pre>
	  */
	public RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.integration").append("\n"); 
		query.append("FileName : RecoveryActivityManageDBDAOSearchRecoveryActivityListRSQL").append("\n"); 
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
		query.append("SELECT 2 sortNo" ).append("\n"); 
		query.append(",b.n3pty_no" ).append("\n"); 
		query.append(",b.ots_grp_rcvr_act_seq" ).append("\n"); 
		query.append(",b.act_rmk" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(b.locl_cre_dt,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') locl_cre_dt" ).append("\n"); 
		query.append(",b.clt_act_upd_ofc_cd" ).append("\n"); 
		query.append(",b.upd_usr_id" ).append("\n"); 
		query.append(",b.cntc_pson_nm" ).append("\n"); 
		query.append(",DECODE(b.n3pty_clt_rmk_tp_cd,'A',1,0) n3pty_no_y" ).append("\n"); 
		query.append(",DECODE(b.n3pty_clt_rmk_tp_cd,'M',1,0) n3pty_no_n" ).append("\n"); 
		query.append(",NVL2(b.file_no,'File Attach',DECODE(b.n3pty_clt_rmk_tp_cd,'M','File Attach')) img_file_no" ).append("\n"); 
		query.append(",b.file_no" ).append("\n"); 
		query.append(",a.n3pty_inv_no" ).append("\n"); 
		query.append(",b.n3pty_clt_rmk_tp_cd" ).append("\n"); 
		query.append(",NVL2(b.file_no, ( SELECT COUNT(0) cnt FROM TPB_TTL_FILE_MGMT f WHERE f.file_no=b.file_no AND f.delt_flg='N' ), 0) As file_count" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP a" ).append("\n"); 
		query.append(",TPB_OTS_GRP_RCVR_ACT b" ).append("\n"); 
		query.append("WHERE a.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("AND a.n3pty_no = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("SELECT 2 sortNo" ).append("\n"); 
		query.append(",b.n3pty_no" ).append("\n"); 
		query.append(",b.ots_grp_rcvr_act_seq" ).append("\n"); 
		query.append(",TPB_GET_IF_RMK_FNC(b.n3pty_no) act_rmk" ).append("\n"); 
		query.append(",TO_CHAR(TPB_GET_LCL_DATE_FNC(b.locl_cre_dt,@[user_ofc_cd]),'YYYY-MM-DD HH24:MI') locl_cre_dt" ).append("\n"); 
		query.append(",b.clt_act_upd_ofc_cd" ).append("\n"); 
		query.append(",b.upd_usr_id" ).append("\n"); 
		query.append(",b.cntc_pson_nm" ).append("\n"); 
		query.append(",DECODE(b.n3pty_clt_rmk_tp_cd,'A',1,0) n3pty_no_y" ).append("\n"); 
		query.append(",DECODE(b.n3pty_clt_rmk_tp_cd,'M',1,0) n3pty_no_n" ).append("\n"); 
		query.append(",NVL2(b.file_no,'File Attach',DECODE(b.n3pty_clt_rmk_tp_cd,'M','File Attach')) img_file_no" ).append("\n"); 
		query.append(",b.file_no" ).append("\n"); 
		query.append(",a.n3pty_inv_no" ).append("\n"); 
		query.append(",b.n3pty_clt_rmk_tp_cd" ).append("\n"); 
		query.append(",NVL2(b.file_no, ( SELECT COUNT(0) cnt FROM TPB_TTL_FILE_MGMT f WHERE f.file_no=b.file_no AND f.delt_flg='N' ), 0) As file_count" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP a" ).append("\n"); 
		query.append(",TPB_OTS_GRP_RCVR_ACT b" ).append("\n"); 
		query.append("WHERE a.n3pty_no = b.n3pty_no" ).append("\n"); 
		query.append("#if (${s_n3pty_no} != '')" ).append("\n"); 
		query.append("AND a.n3pty_no = @[s_n3pty_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 1 = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and b.ots_grp_rcvr_act_seq = 1" ).append("\n"); 
		query.append("and TPB_GET_IF_RMK_FNC(b.n3pty_no) is not null" ).append("\n"); 
		query.append("ORDER BY sortNo, n3pty_no, ots_grp_rcvr_act_seq" ).append("\n"); 

	}
}