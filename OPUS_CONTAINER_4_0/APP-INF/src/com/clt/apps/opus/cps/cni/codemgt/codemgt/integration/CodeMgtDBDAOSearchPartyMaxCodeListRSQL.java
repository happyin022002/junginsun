/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeMgtDBDAOSearchPartyMaxCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.26 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeMgtDBDAOSearchPartyMaxCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Code Name의 자리수별 max 값 취득
	  * </pre>
	  */
	public CodeMgtDBDAOSearchPartyMaxCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_pty_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : CodeMgtDBDAOSearchPartyMaxCodeListRSQL").append("\n"); 
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
		query.append("MAX (CLM_PTY_ABBR_NM) CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CNI_PARTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CLM_PTY_ABBR_NM LIKE  @[clm_pty_abbr_nm] || '%'" ).append("\n"); 
		query.append("AND REGEXP_LIKE (CLM_PTY_ABBR_NM,  @[cond])" ).append("\n"); 

	}
}