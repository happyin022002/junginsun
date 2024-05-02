/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052ListSub01RSQL.java
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

public class MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052ListSub01RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Confirmation and Distribution Sub
	  * </pre>
	  */
	public MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052ListSub01RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MonthlyQuotaReleaseDBDAOSearchMonthlyQuotaRelease0052ListSub01RSQL").append("\n"); 
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
		query.append("#if (${is_new_version}=='false') " ).append("\n"); 
		query.append("			SELECT " ).append("\n"); 
		query.append("			        MQTA_RLSE_VER_NO " ).append("\n"); 
		query.append("			        ,TRD_CD " ).append("\n"); 
		query.append("			        ,DIR_CD " ).append("\n"); 
		query.append("			        ,SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("			        ,MQTA_VER_NO " ).append("\n"); 
		query.append("			        ,GLINE_VER_NO " ).append("\n"); 
		query.append("			FROM    SAQ_MON_QTA_RLSE_TRD " ).append("\n"); 
		query.append("			WHERE   MQTA_RLSE_VER_NO = @[mqta_rlse_ver_no] " ).append("\n"); 
		query.append("	#else " ).append("\n"); 
		query.append("			SELECT  @[mqta_rlse_ver_no]  AS MQTA_RLSE_VER_NO " ).append("\n"); 
		query.append("	 		        ,A.SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("			        ,A.TRD_CD " ).append("\n"); 
		query.append("			        ,A.DIR_CD " ).append("\n"); 
		query.append("			        ,B.MQTA_VER_NO " ).append("\n"); 
		query.append("			        ,B.GLINE_VER_NO " ).append("\n"); 
		query.append("			FROM     (" ).append("\n"); 
		query.append("                         SELECT " ).append("\n"); 
		query.append("                            DISTINCT SAQ_TGT_GRP_CD " ).append("\n"); 
		query.append("			                         ,TRD_CD " ).append("\n"); 
		query.append("			                         ,DIR_CD " ).append("\n"); 
		query.append("			             FROM   SAQ_TGT_GRP_TRD" ).append("\n"); 
		query.append("                      ) A  " ).append("\n"); 
		query.append("		        LEFT JOIN SAQ_MON_QTA_STEP_VER B  " ).append("\n"); 
		query.append("			           ON B.TRD_CD = A.TRD_CD " ).append("\n"); 
		query.append("					  AND B.DIR_CD = A.DIR_CD " ).append("\n"); 
		query.append("					  AND B.MQTA_STEP_CD = '01' " ).append("\n"); 
		query.append("					  AND B.BSE_YR = @[year]  " ).append("\n"); 
		query.append("					  AND B.BSE_QTR_CD = @[quarter] " ).append("\n"); 
		query.append("					  AND B.SAQ_STS_CD = 'QF' " ).append("\n"); 
		query.append("			WHERE    1 = 1 " ).append("\n"); 
		query.append("			ORDER BY A.SAQ_TGT_GRP_CD, " ).append("\n"); 
		query.append("                     A.TRD_CD, " ).append("\n"); 
		query.append("                     A.DIR_CD " ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}