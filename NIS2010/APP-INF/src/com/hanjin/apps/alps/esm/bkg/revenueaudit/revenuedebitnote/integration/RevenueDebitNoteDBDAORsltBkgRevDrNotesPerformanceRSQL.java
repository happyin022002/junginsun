/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteDBDAORsltBkgRevDrNotesPerformanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.11.24 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seung-Jun,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RevenueDebitNoteDBDAORsltBkgRevDrNotesPerformanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RsltBkgRevDrNotesPerformance VO 생성용 쿼리
	  * </pre>
	  */
	public RevenueDebitNoteDBDAORsltBkgRevDrNotesPerformanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.integration ").append("\n"); 
		query.append("FileName : RevenueDebitNoteDBDAORsltBkgRevDrNotesPerformanceRSQL").append("\n"); 
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
		query.append("SELECT  ''  AS RCT_RHQ_CD" ).append("\n"); 
		query.append(",       ''  AS RCT_OFC_CD" ).append("\n"); 
		query.append(",       ''  AS RESPB_RHQ_CD" ).append("\n"); 
		query.append(",       ''  AS RESPB_OFC_CD" ).append("\n"); 
		query.append(",       ''  AS CNT1" ).append("\n"); 
		query.append(",       ''  AS AMT1" ).append("\n"); 
		query.append(",       ''  AS CNT2" ).append("\n"); 
		query.append(",       ''  AS AMT2" ).append("\n"); 
		query.append(",       ''  AS CNT3" ).append("\n"); 
		query.append(",       ''  AS AMT3" ).append("\n"); 
		query.append(",       ''  AS CNT4" ).append("\n"); 
		query.append(",       ''  AS AMT4" ).append("\n"); 
		query.append(",       ''  AS CNT5" ).append("\n"); 
		query.append(",       ''  AS AMT5" ).append("\n"); 
		query.append(",       ''  AS CNT6" ).append("\n"); 
		query.append(",       ''  AS AMT6" ).append("\n"); 
		query.append(",       ''  AS CNT7" ).append("\n"); 
		query.append(",       ''  AS AMT7" ).append("\n"); 
		query.append(",       ''  AS CNT8" ).append("\n"); 
		query.append(",       ''  AS AMT8" ).append("\n"); 
		query.append(",       ''  AS CNT9" ).append("\n"); 
		query.append(",       ''  AS AMT9" ).append("\n"); 
		query.append(",       ''  AS CNT10" ).append("\n"); 
		query.append(",       ''  AS AMT10" ).append("\n"); 
		query.append(",       ''  AS CNT11" ).append("\n"); 
		query.append(",       ''  AS AMT11" ).append("\n"); 
		query.append(",	''  AS RDN_STS_CD" ).append("\n"); 
		query.append(",	''  AS RDN_ISS_DT_FROM" ).append("\n"); 
		query.append(",	''  AS RDN_ISS_DT_TO" ).append("\n"); 
		query.append(",	''  AS RCT_RHQ_CD" ).append("\n"); 
		query.append(",	''  AS RCT_OFC_CD" ).append("\n"); 
		query.append(",	''  AS RESPB_RHQ_CD" ).append("\n"); 
		query.append(",	''  AS RESPB_OFC_CD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}