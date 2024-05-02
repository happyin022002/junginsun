/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTOfficeAgreementInfoDBDAOSearchOtherInfoListRepTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.18 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTOfficeAgreementInfoDBDAOSearchOtherInfoListRepTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOtherInfoListRepType
	  * </pre>
	  */
	public AGTOfficeAgreementInfoDBDAOSearchOtherInfoListRepTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration").append("\n"); 
		query.append("FileName : AGTOfficeAgreementInfoDBDAOSearchOtherInfoListRepTypeRSQL").append("\n"); 
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
		query.append("CNTR_TP_CD," ).append("\n"); 
		query.append("CNTR_TP_DESC" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP" ).append("\n"); 
		query.append("WHERE NVL (DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("ORDER BY CNTR_TP_CD" ).append("\n"); 

	}
}