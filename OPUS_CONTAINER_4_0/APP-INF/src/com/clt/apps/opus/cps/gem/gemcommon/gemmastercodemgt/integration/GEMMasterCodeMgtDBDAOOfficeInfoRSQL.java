/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.06.24 최정미
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author choijungmi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 오피스 VS 비용 매트릭스 문의 VO
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOOfficeInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("SELECT '' ofc_cd" ).append("\n"); 
		query.append(", '' locl_curr_cd" ).append("\n"); 
		query.append(", '' rqst_ut_val" ).append("\n"); 
		query.append(", '' usd_locl_xch_rt" ).append("\n"); 
		query.append(", '' rqst_auth_flg" ).append("\n"); 
		query.append(", '' rhq_auth_flg" ).append("\n"); 
		query.append(", '' tic_auth_flg" ).append("\n"); 
		query.append(", '' cmit_auth_flg" ).append("\n"); 
		query.append(", '' sls_ofc_flg" ).append("\n"); 
		query.append(", '' gen_expn_cd" ).append("\n"); 
		query.append(", '' expn_nm" ).append("\n"); 
		query.append(", '' tic_cd" ).append("\n"); 
		query.append(", '' delt_flg" ).append("\n"); 
		query.append(", '' cre_usr_id" ).append("\n"); 
		query.append(", '' cre_dt" ).append("\n"); 
		query.append(", '' upd_usr_id" ).append("\n"); 
		query.append(", '' upd_dt" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOOfficeInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}