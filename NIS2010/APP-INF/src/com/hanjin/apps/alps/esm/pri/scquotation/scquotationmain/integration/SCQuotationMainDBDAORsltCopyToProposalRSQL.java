/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCQuotationMainDBDAORsltCopyToProposalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.14 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCQuotationMainDBDAORsltCopyToProposalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltCopyToProposal vo 생성 용
	  * </pre>
	  */
	public SCQuotationMainDBDAORsltCopyToProposalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.integration").append("\n"); 
		query.append("FileName : SCQuotationMainDBDAORsltCopyToProposalRSQL").append("\n"); 
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
		query.append("SELECT '' AS NEW_PROP_NO" ).append("\n"); 
		query.append(", '' AS CRE_USR_ID" ).append("\n"); 
		query.append(", '' AS QTTN_OFC_CD" ).append("\n"); 
		query.append(", '' AS UPD_USR_ID" ).append("\n"); 
		query.append(", '' AS QTTN_NO" ).append("\n"); 
		query.append(", '' AS QTTN_VER_NO" ).append("\n"); 
		query.append(",	'' AS 	FRM_GRP_LOC_CNT" ).append("\n"); 
		query.append(",	'' AS 	FRM_GRP_CMDT_CNT" ).append("\n"); 
		query.append(",	'' AS 	FRM_RATE_G_CNT" ).append("\n"); 
		query.append(",	'' AS 	FRM_RATE_S_CNT" ).append("\n"); 
		query.append(",	'' AS	GEN_SPCL_RT_TP_CD_FROM" ).append("\n"); 
		query.append(",  '' AS   APP_OFC_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}