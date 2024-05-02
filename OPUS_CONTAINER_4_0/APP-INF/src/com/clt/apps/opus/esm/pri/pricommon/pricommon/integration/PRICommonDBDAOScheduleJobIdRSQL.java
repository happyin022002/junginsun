/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAOScheduleJobIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.01 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOScheduleJobIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * batch job 실행후 program 명과 파라메터를 이용해 job id를 조회한다.
	  * </pre>
	  */
	public PRICommonDBDAOScheduleJobIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOScheduleJobIdRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("max(skd_id) as cd, '' as nm" ).append("\n"); 
		query.append("from  com_skd_mgmt" ).append("\n"); 
		query.append("where pgm_no = @[etc1]" ).append("\n"); 
		query.append("and skd_para_ctnt = @[etc2]" ).append("\n"); 

	}
}