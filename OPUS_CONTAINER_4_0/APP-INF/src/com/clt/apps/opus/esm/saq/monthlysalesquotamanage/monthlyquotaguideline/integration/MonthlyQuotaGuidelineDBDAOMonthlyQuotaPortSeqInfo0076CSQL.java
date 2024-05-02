/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOMonthlyQuotaPortSeqInfo0076CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaGuidelineDBDAOMonthlyQuotaPortSeqInfo0076CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_PORT_SEQ Insert
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOMonthlyQuotaPortSeqInfo0076CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaGuidelineDBDAOMonthlyQuotaPortSeqInfo0076CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_PORT_SEQ (               " ).append("\n"); 
		query.append("            BSE_YR      ," ).append("\n"); 
		query.append("            BSE_QTR_CD  ," ).append("\n"); 
		query.append("            GLINE_VER_NO," ).append("\n"); 
		query.append("            TRD_CD      ," ).append("\n"); 
		query.append("            RLANE_CD    ," ).append("\n"); 
		query.append("            DIR_CD      ," ).append("\n"); 
		query.append("            SPRT_GRP_CD ," ).append("\n"); 
		query.append("            BSA_GRP_CD  ," ).append("\n"); 
		query.append("            PORT_CD     ," ).append("\n"); 
		query.append("            PORT_SEQ    ," ).append("\n"); 
		query.append("            CRE_USR_ID  ," ).append("\n"); 
		query.append("            CRE_DT      ," ).append("\n"); 
		query.append("            UPD_USR_ID  ," ).append("\n"); 
		query.append("            UPD_DT      )" ).append("\n"); 
		query.append("SELECT	    DISTINCT BSE_YR      	    ," ).append("\n"); 
		query.append("            BSE_QTR_CD        			  ," ).append("\n"); 
		query.append("            GLINE_VER_NO         		  ," ).append("\n"); 
		query.append("            TRD_CD               		  ," ).append("\n"); 
		query.append("            RLANE_CD            		  ," ).append("\n"); 
		query.append("            DIR_CD               		  ," ).append("\n"); 
		query.append("            SPRT_GRP_CD          		  ," ).append("\n"); 
		query.append("            BSA_GRP_CD           		  ," ).append("\n"); 
		query.append("            '00000'    AS PORT_CD  	  ," ).append("\n"); 
		query.append("            '1'        AS PORT_SEQ  	," ).append("\n"); 
		query.append("            @[user_id] AS CRE_USR_ID	," ).append("\n"); 
		query.append("            SYSDATE    AS CRE_DT    	," ).append("\n"); 
		query.append("            @[user_id] AS UPD_USR_ID	," ).append("\n"); 
		query.append("            SYSDATE    AS UPD_DT       " ).append("\n"); 
		query.append("FROM 	SAQ_MON_TGT_VVD_ADJ" ).append("\n"); 
		query.append("WHERE   BSE_YR       = @[year]" ).append("\n"); 
		query.append("AND 	BSE_QTR_CD   = @[bse_qtr_cd]" ).append("\n"); 
		query.append("AND 	GLINE_VER_NO = @[version]" ).append("\n"); 

	}
}