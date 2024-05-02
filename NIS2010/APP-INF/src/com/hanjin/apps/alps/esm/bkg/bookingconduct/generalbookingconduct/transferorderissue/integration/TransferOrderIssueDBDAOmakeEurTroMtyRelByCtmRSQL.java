/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOmakeEurTroMtyRelByCtmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.28 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOmakeEurTroMtyRelByCtmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vo 생성
	  * </pre>
	  */
	public TransferOrderIssueDBDAOmakeEurTroMtyRelByCtmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOmakeEurTroMtyRelByCtmRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' BKG_NO" ).append("\n"); 
		query.append(",'' BOUND_CD" ).append("\n"); 
		query.append(",'' HAULAGE_CD" ).append("\n"); 
		query.append(",'' CFM_FLAG" ).append("\n"); 
		query.append(",'' JOB_DIV_CD" ).append("\n"); 
		query.append(",'' JOB_DT" ).append("\n"); 
		query.append(",'' SO_CITY_CD" ).append("\n"); 
		query.append(",'' SO_SEQ" ).append("\n"); 
		query.append(",'' TRO_SEQ" ).append("\n"); 
		query.append(",'' YD_CD" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}