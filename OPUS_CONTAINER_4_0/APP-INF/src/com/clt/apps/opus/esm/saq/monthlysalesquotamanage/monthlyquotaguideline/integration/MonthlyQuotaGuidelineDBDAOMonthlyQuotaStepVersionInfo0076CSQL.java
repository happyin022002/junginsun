/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOMonthlyQuotaStepVersionInfo0076CSQL.java
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

public class MonthlyQuotaGuidelineDBDAOMonthlyQuotaStepVersionInfo0076CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_STEP_VER Insert
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOMonthlyQuotaStepVersionInfo0076CSQL(){
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
		params.put("target_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaGuidelineDBDAOMonthlyQuotaStepVersionInfo0076CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_STEP_VER (							" ).append("\n"); 
		query.append("            MQTA_STEP_CD                                        ," ).append("\n"); 
		query.append("            BSE_YR                                              ," ).append("\n"); 
		query.append("            BSE_QTR_CD                                          ," ).append("\n"); 
		query.append("            TRD_CD                                              ," ).append("\n"); 
		query.append("            DIR_CD                                              ," ).append("\n"); 
		query.append("            MQTA_VER_NO                                         ," ).append("\n"); 
		query.append("            SAQ_STS_CD                                          ," ).append("\n"); 
		query.append("            GLINE_VER_NO                                        ," ).append("\n"); 
		query.append("            QTA_MST_VER_NO                                      ," ).append("\n"); 
		query.append("            CRE_OFC_CD                                          ," ).append("\n"); 
		query.append("            CRE_USR_ID                                          ," ).append("\n"); 
		query.append("            CRE_DT                                              ," ).append("\n"); 
		query.append("            UPD_USR_ID                                          ," ).append("\n"); 
		query.append("            UPD_DT )                                             " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("            '01'                                        AS MQTA_STEP_CD ," ).append("\n"); 
		query.append("            GVR.BSE_YR                                                  ," ).append("\n"); 
		query.append("            GVR.BSE_QTR_CD                                              ," ).append("\n"); 
		query.append("            GTR.TRD_CD                                                  ," ).append("\n"); 
		query.append("            GTR.DIR_CD                                                  ," ).append("\n"); 
		query.append("            ( SELECT  GVR.GLINE_VER_NO                               " ).append("\n"); 
		query.append("                        ||TO_CHAR(NVL(MAX(SUBSTR(STV.MQTA_VER_NO,    " ).append("\n"); 
		query.append("                          LENGTH(GVR.GLINE_VER_NO)+1)), 0)+1,'FM09') " ).append("\n"); 
		query.append("              FROM   SAQ_MON_QTA_STEP_VER STV                        " ).append("\n"); 
		query.append("              WHERE  STV.MQTA_STEP_CD   = '01'                         " ).append("\n"); 
		query.append("              AND    STV.GLINE_VER_NO   = GVR.GLINE_VER_NO             " ).append("\n"); 
		query.append("              AND    STV.BSE_YR         = GVR.BSE_YR                     " ).append("\n"); 
		query.append("              AND    STV.BSE_QTR_CD     = GVR.BSE_QTR_CD                 " ).append("\n"); 
		query.append("              AND    STV.TRD_CD         = GTR.TRD_CD                     " ).append("\n"); 
		query.append("              AND    STV.DIR_CD         = GTR.DIR_CD )  AS YQTA_VER_NO  ," ).append("\n"); 
		query.append("            '00'                                        AS SAQ_STS_CD   ," ).append("\n"); 
		query.append("            GVR.GLINE_VER_NO                                            ," ).append("\n"); 
		query.append("            GVR.QTA_MST_VER_NO                                          ," ).append("\n"); 
		query.append("            GVR.CRE_OFC_CD                                              ," ).append("\n"); 
		query.append("            @[user_id]                                  AS CRE_USR_ID   ," ).append("\n"); 
		query.append("            SYSDATE                                     AS CRE_DT       ," ).append("\n"); 
		query.append("            @[user_id]                                  AS UPD_USR_ID   ," ).append("\n"); 
		query.append("            SYSDATE                                     AS UPD_DT        " ).append("\n"); 
		query.append("FROM        SAQ_MON_QTA_GLINE_VER GVR,                              " ).append("\n"); 
		query.append("            SAQ_MON_QTA_GLINE_TRD GTR                               " ).append("\n"); 
		query.append("WHERE       GVR.BSE_YR          = @[year]                                " ).append("\n"); 
		query.append("AND         GVR.BSE_QTR_CD      = @[bse_qtr_cd]                          " ).append("\n"); 
		query.append("AND         GVR.SAQ_TGT_GRP_CD  = @[target_grp]                          " ).append("\n"); 
		query.append("AND         GVR.GLINE_VER_NO    = @[version]                             " ).append("\n"); 
		query.append("AND         GTR.BSE_YR          = GVR.BSE_YR                             " ).append("\n"); 
		query.append("AND         GTR.SAQ_TGT_GRP_CD  = GVR.SAQ_TGT_GRP_CD                " ).append("\n"); 
		query.append("AND         GTR.GLINE_VER_NO    = GVR.GLINE_VER_NO                    " ).append("\n"); 
		query.append("GROUP BY    GVR.BSE_YR, GVR.BSE_QTR_CD, GVR.GLINE_VER_NO,          " ).append("\n"); 
		query.append("            GVR.CRE_OFC_CD, GTR.TRD_CD, GTR.DIR_CD, GVR.QTA_MST_VER_NO" ).append("\n"); 

	}
}