/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCodeDBDAOSearchBillingCaseByExpenseTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.11.12 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchBillingCaseByExpenseTypeRSQL implements ISQLTemplate{
	
	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBillingCaseByExpenseType
	  * </pre>
	  */
	public CommonCodeDBDAOSearchBillingCaseByExpenseTypeRSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_src_sub_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration ").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchBillingCaseByExpenseTypeRSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("SELECT n3pty_bil_tp_cd," ).append("\n");
		query.append("       n3pty_bil_tp_nm" ).append("\n");
		query.append("  FROM TPB_N3RD_PTY_BIL_TP" ).append("\n");
		query.append(" WHERE act_flg = 'Y'" ).append("\n");
		query.append("#if (${s_n3pty_expn_tp_cd} == '')" ).append("\n");
		query.append("   AND n3pty_expn_tp_cd = @[s_n3pty_src_sub_sys_cd]" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("   AND n3pty_expn_tp_cd = @[s_n3pty_expn_tp_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("   AND n3pty_if_tp_cd = 'S'" ).append("\n");
		query.append(" ORDER BY n3pty_bil_tp_cd" ).append("\n");
	}
}