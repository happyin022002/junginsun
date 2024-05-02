/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SurchargeAutoRatingDBDAOThirdPartyOfcByLbpVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.01.26 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeAutoRatingDBDAOThirdPartyOfcByLbpVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ThirdPartyOfcByLbpVO 생성 쿼리
	  * </pre>
	  */
	public SurchargeAutoRatingDBDAOThirdPartyOfcByLbpVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : SurchargeAutoRatingDBDAOThirdPartyOfcByLbpVORSQL").append("\n"); 
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
		query.append("'' bkg_no," ).append("\n"); 
		query.append("'' login_office," ).append("\n"); 
		query.append("'' third_party_ofc," ).append("\n"); 
		query.append("'' rep_cust_cnt_cd," ).append("\n"); 
		query.append("'' rep_cust_seq," ).append("\n"); 
		query.append("'' frt_term_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}