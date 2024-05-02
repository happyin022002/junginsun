/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerMgtDBDAOsearchDisposalPartnerDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.08 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOsearchDisposalPartnerDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalPartnerData
	  * </pre>
	  */
	public PartnerMgtDBDAOsearchDisposalPartnerDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOsearchDisposalPartnerDataRSQL").append("\n"); 
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
		query.append("MNR_PRNR_CRE_SEQ.NEXTVAL as MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}