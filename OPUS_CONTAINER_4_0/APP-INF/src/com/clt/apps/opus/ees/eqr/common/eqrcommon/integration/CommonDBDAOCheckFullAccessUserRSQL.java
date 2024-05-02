/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CommonDBDAOCheckFullAccessUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2010.05.03 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN YONGCHAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOCheckFullAccessUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_EXE_PLN_USR 테이블에서 특정 user id 존재하는 여부 확인
	  *  - 059, 080, 081, 083 에서 전주차 access 권한에 사용함
	  * </pre>
	  */
	public CommonDBDAOCheckFullAccessUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userid",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.common.eqrcommon.integration").append("\n"); 
		query.append("FileName : CommonDBDAOCheckFullAccessUserRSQL").append("\n"); 
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
		query.append("SELECT COUNT(1) CHECKCOUNT" ).append("\n"); 
		query.append("FROM EQR_EXE_PLN_USR" ).append("\n"); 
		query.append("WHERE EXE_PLN_USR_ID = @[userid]" ).append("\n"); 

	}
}