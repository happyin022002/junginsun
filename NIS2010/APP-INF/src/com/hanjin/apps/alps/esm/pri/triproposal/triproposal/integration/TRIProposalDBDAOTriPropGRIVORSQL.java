/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRIProposalDBDAOTriPropGRIVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.23 박성수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOTriPropGRIVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GRI용 VO생성용 쿼리
	  * </pre>
	  */
	public TRIProposalDBDAOTriPropGRIVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration ").append("\n"); 
		query.append("FileName : TRIProposalDBDAOTriPropGRIVORSQL").append("\n"); 
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
		query.append("SELECT '' AS TRF_PFX_CD" ).append("\n"); 
		query.append(",'' AS TRF_NO" ).append("\n"); 
		query.append(",'' AS GRI_EFF_DT" ).append("\n"); 
		query.append(",'' AS TRI_RQST_OFC_CD" ).append("\n"); 
		query.append(",'' AS TRI_RQST_USR_ID" ).append("\n"); 
		query.append(",'' AS TRI_APRO_OFC_CD" ).append("\n"); 
		query.append(",'' AS TRI_APRO_USR_ID" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}