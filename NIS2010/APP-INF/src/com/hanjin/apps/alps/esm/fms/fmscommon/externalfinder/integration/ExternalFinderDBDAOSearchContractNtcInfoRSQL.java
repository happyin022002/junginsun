/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchContractNtcInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchContractNtcInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계약번호가 정상적인지 확인 (noitce에서 사용)
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchContractNtcInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration ").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchContractNtcInfoRSQL").append("\n"); 
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
		query.append("SELECT T.FLET_CTRT_NO  AGMT_NO" ).append("\n"); 
		query.append("  FROM FMS_CONTRACT T" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("   AND T.FLET_CTRT_NO = @[agmt_no]" ).append("\n"); 

	}
}