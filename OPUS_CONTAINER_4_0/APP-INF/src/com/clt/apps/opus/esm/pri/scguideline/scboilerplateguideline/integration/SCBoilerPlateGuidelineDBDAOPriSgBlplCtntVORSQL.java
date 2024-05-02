/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVORSQL.java
*@FileTitle : CMPB Guideline Creation - Location Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.07.17 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * content search
	  * </pre>
	  */
	public SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blpl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blpl_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scboilerplateguideline.integration").append("\n"); 
		query.append("FileName : SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("blpl_hdr_seq," ).append("\n"); 
		query.append("blpl_seq," ).append("\n"); 
		query.append("blpl_ctnt_seq," ).append("\n"); 
		query.append("blpl_ctnt," ).append("\n"); 
		query.append("dp_seq," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from pri_sg_blpl_ctnt" ).append("\n"); 
		query.append("where	blpl_hdr_seq = @[blpl_hdr_seq]" ).append("\n"); 
		query.append("and	blpl_seq = @[blpl_seq]" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}