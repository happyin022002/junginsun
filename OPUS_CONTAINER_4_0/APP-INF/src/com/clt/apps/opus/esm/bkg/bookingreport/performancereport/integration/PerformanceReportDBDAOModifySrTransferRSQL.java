/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOModifySrTransferRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.11 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOModifySrTransferRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 111
	  * </pre>
	  */
	public PerformanceReportDBDAOModifySrTransferRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOModifySrTransferRSQL").append("\n"); 
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
		query.append("select '' BKG_NO" ).append("\n"); 
		query.append(",'' SR_NO" ).append("\n"); 
		query.append(",'' SR_KND_CD" ).append("\n"); 
		query.append(",'' usr_id" ).append("\n"); 
		query.append(",'' sr_mtch_sts_cd" ).append("\n"); 
		query.append(",'' ofc_cd" ).append("\n"); 
		query.append(",'' SR_HIS_SEQ" ).append("\n"); 
		query.append(",'' rcv_dt" ).append("\n"); 
		query.append(",'' SR_STS_CD" ).append("\n"); 
		query.append("from 	dual" ).append("\n"); 

	}
}