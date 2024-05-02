/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchThoroughputCCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.10 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchThoroughputCCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Thoroughput Cost Code 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchThoroughputCCRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration ").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchThoroughputCCRSQL").append("\n"); 
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
		query.append("SELECT	a.lgs_cost_cd" ).append("\n"); 
		query.append(", a.lgs_cost_full_nm" ).append("\n"); 
		query.append("FROM	TES_LGS_COST a, TES_TML_AGMT_VRFY_MZD b" ).append("\n"); 
		query.append("WHERE	a.lgs_cost_cd = b.lgs_cost_cd" ).append("\n"); 
		query.append("AND		b.tml_thrp_cost_cd_flg	= 'Y'" ).append("\n"); 

	}
}