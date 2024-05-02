/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVoDAOSlotXchPartnerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.20 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVoDAOSlotXchPartnerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVoDAOSlotXchPartnerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : MakeVoDAOSlotXchPartnerRSQL").append("\n"); 
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
		query.append("SELECT  ''cost_yrmon," ).append("\n"); 
		query.append("''cost_yr," ).append("\n"); 
		query.append("''cost_mon," ).append("\n"); 
		query.append("''skd_dir_cd," ).append("\n"); 
		query.append("''rlane_cd," ).append("\n"); 
		query.append("''trd_cd," ).append("\n"); 
		query.append("''ACCT_YRMON," ).append("\n"); 
		query.append("''RE_DIVR_CD," ).append("\n"); 
		query.append("'' JO_CRR_CD        ," ).append("\n"); 
		query.append("'' CUR_STL_BSA_QTY  ," ).append("\n"); 
		query.append("'' STL_LOCL_AMT     ," ).append("\n"); 
		query.append("'' BSA_SLT_PRC      ," ).append("\n"); 
		query.append("'' TERM_STL_BSA_QTY ," ).append("\n"); 
		query.append("'' TERM_STL_PRC     ," ).append("\n"); 
		query.append("'' TERM_STL_LOCL_AMT" ).append("\n"); 
		query.append(",''COST_YR" ).append("\n"); 
		query.append(",''COST_WK_FR" ).append("\n"); 
		query.append(",''COST_WK_TO" ).append("\n"); 
		query.append(",''COST_WK,''OFC_CD" ).append("\n"); 
		query.append("FROM  DUAL" ).append("\n"); 

	}
}