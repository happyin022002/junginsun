/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrRepoPlanOptiExecuteDBDAODeleteEqrEngRunDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.09.03 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanOptiExecuteDBDAODeleteEqrEngRunDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eqr_eng_inp_opmz_run 테이블에 해당 엔진 run정보 삭제
	  * </pre>
	  */
	public CntrRepoPlanOptiExecuteDBDAODeleteEqrEngRunDSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanOptiExecuteDBDAODeleteEqrEngRunDSQL").append("\n"); 
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
		query.append("DELETE EQR_ENG_INP_OPMZ_RUN" ).append("\n"); 
		query.append("WHERE RUN_ID_NO = @[run_id_no]" ).append("\n"); 
		query.append("AND RUN_STS_CD IN ('CREATED','ABORTED')" ).append("\n"); 

	}
}