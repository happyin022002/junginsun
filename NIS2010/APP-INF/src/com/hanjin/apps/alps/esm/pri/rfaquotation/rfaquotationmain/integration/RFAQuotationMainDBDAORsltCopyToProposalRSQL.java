/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAQuotationMainDBDAORsltCopyToProposalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.05 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAQuotationMainDBDAORsltCopyToProposalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltCopyToProposal vo 생성 용
	  * </pre>
	  */
	public RFAQuotationMainDBDAORsltCopyToProposalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.integration").append("\n"); 
		query.append("FileName : RFAQuotationMainDBDAORsltCopyToProposalRSQL").append("\n"); 
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
		query.append(",  '' AS   OFC_CD" ).append("\n"); 
		query.append(",  '' AS   CUST_CNT_CD" ).append("\n"); 
		query.append(",  '' AS   CUST_SEQ" ).append("\n"); 
		query.append(",  '' AS   DMDT_FT_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}