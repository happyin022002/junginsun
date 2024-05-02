/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnOffHireAuditDBDAOsearchAuditResultOnOffHireVersionlistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.12.28 진준성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jin Jun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnOffHireAuditDBDAOsearchAuditResultOnOffHireVersionlistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Audit 버전 리스트 조회
	  * </pre>
	  */
	public OnOffHireAuditDBDAOsearchAuditResultOnOffHireVersionlistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.integration").append("\n"); 
		query.append("FileName : OnOffHireAuditDBDAOsearchAuditResultOnOffHireVersionlistRSQL").append("\n"); 
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
		query.append("DISTINCT AUD_VER_SEQ AUDIT_VERSION" ).append("\n"); 
		query.append("FROM  LSE_ONF_HIR_AUD A" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("ORDER BY A.AUD_VER_SEQ" ).append("\n"); 

	}
}