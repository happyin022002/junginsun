/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomerInfoManageDBDAOSearchCustCoverListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.08.05 박찬민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK CHAN MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerInfoManageDBDAOSearchCustCoverListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustCoverListVO
	  * </pre>
	  */
	public CustomerInfoManageDBDAOSearchCustCoverListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration").append("\n"); 
		query.append("FileName : CustomerInfoManageDBDAOSearchCustCoverListVORSQL").append("\n"); 
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
		query.append("SELECT '' SREP_PRMRY_FLG" ).append("\n"); 
		query.append("     , '' SREP_FT_NM" ).append("\n"); 
		query.append("     , '' SREP_LT_NM" ).append("\n"); 
		query.append("     , '' SREP_ABBR_NM" ).append("\n"); 
		query.append("     , '' SREP_CD" ).append("\n"); 
		query.append("     , '' SREP_FLG" ).append("\n"); 
		query.append("     , '' OFC_CD" ).append("\n"); 
		query.append("     , '' PRNT_OFC_CD" ).append("\n"); 
		query.append("     , '' MPHN_NO" ).append("\n"); 
		query.append("	 , '' USER_ID" ).append("\n"); 
		query.append("     , '' CUST_CD" ).append("\n"); 
		query.append("	 , '' CUST_CNT_CD" ).append("\n"); 
		query.append("	 , '' CUST_SEQ" ).append("\n"); 
		query.append("	 , '' PRE_SREP_CD" ).append("\n"); 
		query.append("	 , '' CHK_SREP_CD" ).append("\n"); 
		query.append("	 , '' DELT_FLG" ).append("\n"); 
		query.append("	 , '' OP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}