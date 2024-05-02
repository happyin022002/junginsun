/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchBkgAgentEmlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.11.06 이일민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchBkgAgentEmlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgAgentEml
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchBkgAgentEmlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchBkgAgentEmlRSQL").append("\n"); 
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
		query.append("SELECT A2.BKG_NO" ).append("\n"); 
		query.append(",A1.AGN_EML" ).append("\n"); 
		query.append("FROM BKG_CHN_AGN A1" ).append("\n"); 
		query.append(",BKG_BOOKING A2" ).append("\n"); 
		query.append("WHERE A2.CHN_AGN_CD = A1.CHN_AGN_CD(+)" ).append("\n"); 
		query.append("AND 'Y' = A1.AUTO_DP_CHK_FLG(+)" ).append("\n"); 
		query.append("AND A2.BKG_NO IN (" ).append("\n"); 
		query.append("#foreach($bkg_no IN ${bkg_nos})" ).append("\n"); 
		query.append("'$bkg_no'" ).append("\n"); 
		query.append("#if ($velocityCount < $bkg_nos.size()) , #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}