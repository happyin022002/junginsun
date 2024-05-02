/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaReleaseDBDAOUpdateSaqMonQtaRlse0052USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaReleaseDBDAOUpdateSaqMonQtaRlse0052USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Update SAQ_MON_QTA_RLSE
	  * </pre>
	  */
	public MonthlyQuotaReleaseDBDAOUpdateSaqMonQtaRlse0052USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("quarter",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaReleaseDBDAOUpdateSaqMonQtaRlse0052USQL").append("\n"); 
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
		query.append("UPDATE SAQ_MON_QTA_RLSE " ).append("\n"); 
		query.append("		     SET  QTA_RLSE_STS_CD = 'P' " ).append("\n"); 
		query.append("		WHERE  BSE_YR = @[year] " ).append("\n"); 
		query.append("		    AND   BSE_QTR_CD = @[quarter] " ).append("\n"); 
		query.append("		    AND   QTA_RLSE_STS_CD = 'R'" ).append("\n"); 

	}
}