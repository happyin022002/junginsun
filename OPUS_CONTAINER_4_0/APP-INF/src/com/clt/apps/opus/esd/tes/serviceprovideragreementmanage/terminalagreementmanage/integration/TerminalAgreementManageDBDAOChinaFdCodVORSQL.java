/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOChinaFdCodVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.18 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOChinaFdCodVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * China Splecial Feeder화면의 VO를 생성한다.
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOChinaFdCodVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOChinaFdCodVORSQL").append("\n"); 
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
		query.append("SELECT ''fdr_pol_cd" ).append("\n"); 
		query.append("     , ''fdr_pod_cd" ).append("\n"); 
		query.append("     , ''pol_cd" ).append("\n"); 
		query.append("     , ''pod_cd" ).append("\n"); 
		query.append("     , ''chk_pol_cd" ).append("\n"); 
		query.append("     , ''chk_pod_cd" ).append("\n"); 
		query.append("     , ''cre_usr_id" ).append("\n"); 
		query.append("     , ''cre_dt" ).append("\n"); 
		query.append("     , ''upd_usr_id" ).append("\n"); 
		query.append("     , ''upd_dt" ).append("\n"); 
		query.append("     , ''pol_loc_nm" ).append("\n"); 
		query.append("     , ''pod_loc_nm" ).append("\n"); 
		query.append("     , ''search_cd" ).append("\n"); 
		query.append("From dual" ).append("\n"); 

	}
}