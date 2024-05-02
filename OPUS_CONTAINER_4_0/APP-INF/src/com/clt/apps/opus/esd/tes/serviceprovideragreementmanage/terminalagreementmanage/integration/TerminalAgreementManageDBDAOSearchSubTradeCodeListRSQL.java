/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchSubTradeCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchSubTradeCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSubTradeCodeList
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchSubTradeCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchSubTradeCodeListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        SUB_TRD_CD, SUB_TRD_NM" ).append("\n"); 
		query.append("FROM MDM_SUB_TRD " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 

	}
}