/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CgmCodeMgtDBDAOCheckCPSCHSSPoolCodeDupDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.02 이영헌
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

public class CgmCodeMgtDBDAOCheckCPSCHSSPoolCodeDupDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Pool Code의 중복을 체크한다.
	  * </pre>
	  */
	public CgmCodeMgtDBDAOCheckCPSCHSSPoolCodeDupDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration ").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOCheckCPSCHSSPoolCodeDupDataRSQL").append("\n"); 
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
		query.append("SELECT CHSS_POOL_CD," ).append("\n"); 
		query.append("       CHSS_POOL_NM" ).append("\n"); 
		query.append("FROM CGM_CPS_POOL_LIST" ).append("\n"); 
		query.append("WHERE CHSS_POOL_CD = @[chss_pool_cd]" ).append("\n"); 

	}
}