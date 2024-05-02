/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplInqVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.10.01 공백진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateGuidelineDBDAOPriSgBlplInqVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Boiler Plate Inquiry
	  * </pre>
	  */
	public SCBoilerPlateGuidelineDBDAOPriSgBlplInqVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blpl_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.integration ").append("\n"); 
		query.append("FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplInqVORSQL").append("\n"); 
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
		query.append("BLPL_HDR_SEQ," ).append("\n"); 
		query.append("BLPL_SEQ," ).append("\n"); 
		query.append("BLPL_TIT_NM," ).append("\n"); 
		query.append("DP_SEQ," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM PRI_SG_BLPL" ).append("\n"); 
		query.append("WHERE	BLPL_HDR_SEQ = @[blpl_hdr_seq]" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}