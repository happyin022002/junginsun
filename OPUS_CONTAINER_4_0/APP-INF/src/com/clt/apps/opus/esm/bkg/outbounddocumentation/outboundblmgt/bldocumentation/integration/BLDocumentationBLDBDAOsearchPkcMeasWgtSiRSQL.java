/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLDocumentationBLDBDAOsearchPkcMeasWgtSiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.01 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun Yong Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOsearchPkcMeasWgtSiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPkcMeasWgtSi
	  * </pre>
	  */
	public BLDocumentationBLDBDAOsearchPkcMeasWgtSiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOsearchPkcMeasWgtSiRSQL").append("\n"); 
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
		query.append("SELECT SUM(PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append(", SUM(MEAS_QTY) MEAS_QTY" ).append("\n"); 
		query.append(", SUM(ACT_WGT) ACT_WGT" ).append("\n"); 
		query.append("FROM BKG_BL_DOC" ).append("\n"); 
		query.append("WHERE BKG_NO IN (" ).append("\n"); 
		query.append("#foreach( ${bkg_no} in ${bkg_no_list})" ).append("\n"); 
		query.append("#if($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}