/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltSpScpMqcServiceScopeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.27 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSpScpMqcServiceScopeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public PRICommonDBDAORsltSpScpMqcServiceScopeListVORSQL(){
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
		query.append("SELECT ' ' CD , ' ' NM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.SVC_SCP_CD CD" ).append("\n"); 
		query.append(",B.SVC_SCP_NM NM" ).append("\n"); 
		query.append("FROM PRI_SP_SCP_MQC A" ).append("\n"); 
		query.append(",MDM_SVC_SCP B" ).append("\n"); 
		query.append("WHERE A.PROP_NO = @[etc1]" ).append("\n"); 
		query.append("AND   A.AMDT_SEQ = @[etc2]" ).append("\n"); 
		query.append("AND   A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSpScpMqcServiceScopeListVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}