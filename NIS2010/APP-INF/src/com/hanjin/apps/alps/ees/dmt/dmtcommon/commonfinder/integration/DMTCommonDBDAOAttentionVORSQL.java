/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonDBDAOAttentionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.11.25 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOAttentionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AttentionVO 생성
	  * </pre>
	  */
	public DMTCommonDBDAOAttentionVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommon.dmtcommonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAOAttentionVORSQL").append("\n"); 
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
		query.append("'' DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",'' PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",'' PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",'' PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}