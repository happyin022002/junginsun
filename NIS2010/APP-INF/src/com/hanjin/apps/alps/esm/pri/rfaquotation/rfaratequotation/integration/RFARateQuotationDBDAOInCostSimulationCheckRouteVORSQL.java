/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFARateQuotationDBDAOInCostSimulationCheckRouteVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.23 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAOInCostSimulationCheckRouteVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public RFARateQuotationDBDAOInCostSimulationCheckRouteVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAOInCostSimulationCheckRouteVORSQL").append("\n"); 
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
		query.append("	'' AS QTTN_NO" ).append("\n"); 
		query.append("	,'' AS QTTN_VER_NO" ).append("\n"); 
		query.append("	,'' AS GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append("	,'' AS CMDT_HDR_SEQ" ).append("\n"); 
		query.append("	,'' AS ROUT_SEQ" ).append("\n"); 
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