/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : WriteOffMgtDBDAOsearchWriteOffNoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WriteOffMgtDBDAOsearchWriteOffNoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public WriteOffMgtDBDAOsearchWriteOffNoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_wrtf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : WriteOffMgtDBDAOsearchWriteOffNoListDataRSQL").append("\n"); 
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
		query.append("SELECT C.PRE_WRTF_NO||" ).append("\n"); 
		query.append("DECODE(LENGTH(C.POST_WRTF_NO),1,'00'||C.POST_WRTF_NO" ).append("\n"); 
		query.append(",2,'0'||C.POST_WRTF_NO" ).append("\n"); 
		query.append(",C.POST_WRTF_NO)" ).append("\n"); 
		query.append("AS WRTF_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT B.PRE_WRTF_NO" ).append("\n"); 
		query.append(", TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(MWRH.WRTF_NO,LENGTH(MWRH.WRTF_NO)-2))),0)+1) AS POST_WRTF_NO" ).append("\n"); 
		query.append("FROM MNR_WRTF_RQST_HDR MWRH" ).append("\n"); 
		query.append(", (SELECT @[pre_wrtf_no]||'-'||'W'||'-'||TO_CHAR(SYSDATE,'YYYYMM')||'-' AS PRE_WRTF_NO" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("WHERE MWRH.WRTF_NO LIKE B.PRE_WRTF_NO||'%'" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}