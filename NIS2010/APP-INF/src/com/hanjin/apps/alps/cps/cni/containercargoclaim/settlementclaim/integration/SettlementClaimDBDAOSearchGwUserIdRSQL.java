/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementClaimDBDAOSearchGwUserIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.05.11 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementClaimDBDAOSearchGwUserIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자 그룹웨어 사용자 아이디 취득
	  * </pre>
	  */
	public SettlementClaimDBDAOSearchGwUserIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.integration ").append("\n"); 
		query.append("FileName : SettlementClaimDBDAOSearchGwUserIdRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    EP_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    COM_USER" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    USR_ID = @[usr_id]" ).append("\n"); 

	}
}