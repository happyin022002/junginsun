/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TRIProposalDBDAOInCostSimulationCheckRouteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.23 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAOInCostSimulationCheckRouteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public TRIProposalDBDAOInCostSimulationCheckRouteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAOInCostSimulationCheckRouteVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'' AS TRI_PROP_NO " ).append("\n"); 
		query.append("	,'' AS AMDT_SEQ" ).append("\n"); 
		query.append("	,'' AS ORG_DEST_TP_CD" ).append("\n"); 
		query.append("	,'' AS POR_CD" ).append("\n"); 
		query.append("	,'' AS POL_CD" ).append("\n"); 
		query.append("	,'' AS POD_CD" ).append("\n"); 
		query.append("	,'' AS DEL_CD" ).append("\n"); 
		query.append("	,'' AS BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	,'' AS BKG_DE_TERM_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}