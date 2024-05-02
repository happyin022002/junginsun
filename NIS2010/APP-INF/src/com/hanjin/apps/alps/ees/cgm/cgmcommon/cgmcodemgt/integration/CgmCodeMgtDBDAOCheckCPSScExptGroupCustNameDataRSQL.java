/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOCheckCPSScExptGroupCustNameDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.02
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.05.02 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOCheckCPSScExptGroupCustNameDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Group Customer Code로부터 Group Customer Name을 체크한다.
	  * </pre>
	  */
	public CgmCodeMgtDBDAOCheckCPSScExptGroupCustNameDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOCheckCPSScExptGroupCustNameDataRSQL").append("\n"); 
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
		query.append("SELECT  CUST_GRP_ID," ).append("\n"); 
		query.append("        CUST_GRP_NM" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("WHERE CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 

	}
}