/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivityManageDBDAORemoveRecoveryActivityListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009-09-28 Jong-Geon Byeon	1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RecoveryActivityManageDBDAORemoveRecoveryActivityListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Recovery Activity List Remove
	  * </pre>
	  */
	public RecoveryActivityManageDBDAORemoveRecoveryActivityListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitimanage.integration ").append("\n"); 
		query.append("FileName : RecoveryActivityManageDBDAORemoveRecoveryActivityListDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP_RCVR_ACT" ).append("\n"); 
		query.append("WHERE n3pty_no = @[n3pty_no]" ).append("\n"); 
		query.append("AND ots_grp_rcvr_act_seq = @[ots_grp_rcvr_act_seq]" ).append("\n"); 

	}
}