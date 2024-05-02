/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052List01RSQL.java
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

public class MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052List01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Confirmation and Distribution
	  * </pre>
	  */
	public MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052List01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052List01RSQL").append("\n"); 
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
		query.append("		        A.MQTA_RLSE_VER_NO " ).append("\n"); 
		query.append("			    ,B.INTG_CD_VAL_DP_DESC AS STATUS " ).append("\n"); 
		query.append("		        ,A.BSE_YR " ).append("\n"); 
		query.append("		        ,A.BSE_QTR_CD " ).append("\n"); 
		query.append("		        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT',A.RLSE_GDT, @[ofcCd]),'YYYY-MM-DD HH24:MI')  AS RLSE_GDT " ).append("\n"); 
		query.append("		        ,A.QTA_RLSE_STS_CD " ).append("\n"); 
		query.append("		  FROM  SAQ_MON_QTA_RLSE A " ).append("\n"); 
		query.append("	  	    JOIN " ).append("\n"); 
		query.append("			       COM_INTG_CD_DTL B " ).append("\n"); 
		query.append("			 ON    A.QTA_RLSE_STS_CD = B.INTG_CD_VAL_CTNT " ).append("\n"); 
		query.append("		   WHERE   A.BSE_Yr = @[year] " ).append("\n"); 
		query.append("		     AND   A.BSE_QTR_CD = @[quarter] " ).append("\n"); 
		query.append("		     AND   B.INTG_CD_ID = 'CD00969' " ).append("\n"); 
		query.append("	   ORDER BY    A.MQTA_RLSE_VER_NO, A.RLSE_GDT" ).append("\n"); 

	}
}