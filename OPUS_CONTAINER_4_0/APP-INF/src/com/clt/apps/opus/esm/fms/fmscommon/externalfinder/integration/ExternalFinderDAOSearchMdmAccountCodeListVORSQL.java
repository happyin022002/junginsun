/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDAOSearchMdmAccountCodeListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDAOSearchMdmAccountCodeListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ExternalFinderDAOSearchMdmAccountCodeListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDAOSearchMdmAccountCodeListVORSQL").append("\n"); 
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
		query.append("SELECT ACCT_CD" ).append("\n"); 
		query.append("     , ACCT_ENG_NM" ).append("\n"); 
		query.append("     , JNL_CRE_FLG " ).append("\n"); 
		query.append("  FROM MDM_ACCOUNT" ).append("\n"); 
		query.append(" WHERE 1=1 " ).append("\n"); 
		query.append("#if (${acct_gb} == '1')" ).append("\n"); 
		query.append("   AND ACCT_ENG_NM LIKE '%'||UPPER (@[acct_cd])||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND ACCT_CD LIKE @[acct_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY ACCT_CD" ).append("\n"); 

	}
}