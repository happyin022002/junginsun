/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSOCodeFinderDBDAOsearchAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.08.11 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSOCodeFinderDBDAOsearchAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * account 조회
	  * </pre>
	  */
	public PSOCodeFinderDBDAOsearchAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.psocommon.psocodefinder.integration").append("\n"); 
		query.append("FileName : PSOCodeFinderDBDAOsearchAccountListRSQL").append("\n"); 
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
		query.append("select distinct t1.acct_cd, t2.acct_eng_nm" ).append("\n"); 
		query.append("from tes_lgs_cost t1, mdm_account t2" ).append("\n"); 
		query.append("where lgs_cost_subj_cd in ('PT', 'CN')" ).append("\n"); 
		query.append("and   lgs_cost_cd_clss_lvl != 'D'" ).append("\n"); 
		query.append("and   t2.delt_flg = 'N'" ).append("\n"); 
		query.append("and   t1.acct_cd = t2.acct_cd" ).append("\n"); 
		query.append("order by t1.acct_cd" ).append("\n"); 

	}
}