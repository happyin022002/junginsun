/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteDBDAOGetEngRunMonitorStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanOptiExecuteDBDAOGetEngRunMonitorStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_eng_inp_opmz_run 상태 확인
	  * </pre>
	  */
	public CntrRepoPlanOptiExecuteDBDAOGetEngRunMonitorStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("run_id_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration ").append("\n"); 
		query.append("FileName : CntrRepoPlanOptiExecuteDBDAOGetEngRunMonitorStatusRSQL").append("\n"); 
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
		query.append("SELECT RUN_ID_NO" ).append("\n"); 
		query.append(",RUN_STS_CD" ).append("\n"); 
		query.append(",RUN_PROG_KNT" ).append("\n"); 
		query.append(",RUN_STS_DESC" ).append("\n"); 
		query.append("FROM EQR_ENG_INP_OPMZ_RUN" ).append("\n"); 
		query.append("WHERE RUN_ID_NO = @[run_id_no]" ).append("\n"); 

	}
}