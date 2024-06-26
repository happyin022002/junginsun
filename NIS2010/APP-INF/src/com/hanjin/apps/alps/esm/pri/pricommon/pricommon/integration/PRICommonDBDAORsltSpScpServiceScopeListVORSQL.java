/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonDBDAORsltSpScpServiceScopeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.07.30 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltSpScpServiceScopeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * service scope
	  * </pre>
	  */
	public PRICommonDBDAORsltSpScpServiceScopeListVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltSpScpServiceScopeListVORSQL").append("\n"); 
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
		query.append("SELECT ' ' CD" ).append("\n"); 
		query.append(",' ' NM" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CD" ).append("\n"); 
		query.append(",NM" ).append("\n"); 
		query.append("FROM   (SELECT   A.SVC_SCP_CD CD" ).append("\n"); 
		query.append(",B.SVC_SCP_NM NM" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append("FROM     PRI_SP_SCP_MN A" ).append("\n"); 
		query.append(",MDM_SVC_SCP B" ).append("\n"); 
		query.append("WHERE    A.PROP_NO = @[etc1]" ).append("\n"); 
		query.append("AND      A.AMDT_SEQ = @[etc2]" ).append("\n"); 
		query.append("AND      A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("ORDER BY A.CRE_DT)" ).append("\n"); 

	}
}