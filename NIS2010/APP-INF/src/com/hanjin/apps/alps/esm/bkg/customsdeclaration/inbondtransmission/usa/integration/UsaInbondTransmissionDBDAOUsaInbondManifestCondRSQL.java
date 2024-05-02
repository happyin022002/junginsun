/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOUsaInbondManifestCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.21 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOUsaInbondManifestCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim 조회조건
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOUsaInbondManifestCondRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOUsaInbondManifestCondRSQL").append("\n"); 
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
		query.append("SELECT '' VVD, '' POD, '' HUB, '' FROMD, '' FROMT, '' TOD, '' TOT, '' IBD_TP_CD, '' ARR_DT, '' XPT_DT, '' EDI_ERROR," ).append("\n"); 
		query.append("'' ARR_GUBUN, '' EQ_OFC, '' BL_CNTR_GUBUN, '' PAGE_NO, '' H_VVD, '' H_POD, '' h_hub, '' h_del" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}