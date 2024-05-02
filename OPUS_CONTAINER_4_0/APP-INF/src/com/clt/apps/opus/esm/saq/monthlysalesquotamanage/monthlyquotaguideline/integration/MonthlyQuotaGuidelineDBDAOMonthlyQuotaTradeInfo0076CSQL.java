/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOMonthlyQuotaTradeInfo0076CSQL.java
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

public class MonthlyQuotaGuidelineDBDAOMonthlyQuotaTradeInfo0076CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_QTA_TRD Insert
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOMonthlyQuotaTradeInfo0076CSQL(){
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
		params.put("mqta_mdl_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : MonthlyQuotaGuidelineDBDAOMonthlyQuotaTradeInfo0076CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_QTA_TRD (" ).append("\n"); 
		query.append("            MQTA_STEP_CD    ," ).append("\n"); 
		query.append("            BSE_YR          ," ).append("\n"); 
		query.append("            BSE_QTR_CD      ," ).append("\n"); 
		query.append("            TRD_CD          ," ).append("\n"); 
		query.append("            DIR_CD          ," ).append("\n"); 
		query.append("            MQTA_VER_NO     ," ).append("\n"); 
		query.append("            RLANE_CD        ," ).append("\n"); 
		query.append("            SPRT_GRP_CD     ," ).append("\n"); 
		query.append("            BSA_GRP_CD      ," ).append("\n"); 
		query.append("            CTRT_RHQ_CD     ," ).append("\n"); 
		query.append("            BSE_MON         ," ).append("\n"); 
		query.append("            SUB_TRD_CD      ," ).append("\n"); 
		query.append("            LOD_QTY         ," ).append("\n"); 
		query.append("            GRS_RPB_REV     ," ).append("\n"); 
		query.append("            CM_UC_AMT       ," ).append("\n"); 
		query.append("            OPFIT_UC_AMT    ," ).append("\n"); 
		query.append("            RA_CM_UC_AMT    ," ).append("\n"); 
		query.append("            RA_OPFIT_UC_AMT ," ).append("\n"); 
		query.append("            CRE_USR_ID      ," ).append("\n"); 
		query.append("            CRE_DT          ," ).append("\n"); 
		query.append("            UPD_USR_ID      ," ).append("\n"); 
		query.append("            UPD_DT )         " ).append("\n"); 
		query.append("SELECT      /*+ ORDERED USE_HASH(VER, ADJ, MRS) INDEX(MRS XPKSAQ_MON_MDL_RSLT_OFC_SMRY)*/      " ).append("\n"); 
		query.append("            '01'                                                            AS MQTA_STEP_CD,   " ).append("\n"); 
		query.append("            VER.BSE_YR                                                                      ,  " ).append("\n"); 
		query.append("            VER.BSE_QTR_CD                                                                  ,  " ).append("\n"); 
		query.append("            MRS.TRD_CD                                                                      ,  " ).append("\n"); 
		query.append("            MRS.DIR_CD                                                                      ,  " ).append("\n"); 
		query.append("            VER.MQTA_VER_NO                                                 AS MQTA_VER_NO  ,  " ).append("\n"); 
		query.append("            MRS.RLANE_CD                                                                    ,  " ).append("\n"); 
		query.append("            ADJ.SPRT_GRP_CD                                                                 ,  " ).append("\n"); 
		query.append("            ADJ.BSA_GRP_CD                                                                  ,  " ).append("\n"); 
		query.append("            MRS.CTRT_RHQ_CD                                                                 ,  " ).append("\n"); 
		query.append("            MRS.BSE_MON                                                                     ,  " ).append("\n"); 
		query.append("            MRS.SUB_TRD_CD                                                                  ,  " ).append("\n"); 
		query.append("            SUM(MRS.LOD_QTY)                                " ).append("\n"); 
		query.append("                /COUNT(DISTINCT ADJ.VSL_CD||ADJ.SKD_VOY_NO||ADJ.SKD_DIR_CD) AS LOD_QTY      ,  " ).append("\n"); 
		query.append("            SUM(MRS.GRS_RPB_REV*MRS.LOD_QTY)	  /SUM(MRS.LOD_QTY)           AS GRS_RPB_REV  ,  " ).append("\n"); 
		query.append("            SUM(MRS.CM_UC_AMT*MRS.LOD_QTY)		  /SUM(MRS.LOD_QTY)           AS CM_UC_AMT    ,  " ).append("\n"); 
		query.append("            SUM(MRS.OPFIT_UC_AMT*MRS.LOD_QTY)	  /SUM(MRS.LOD_QTY)           AS OPFIT_UC_AMT ,  " ).append("\n"); 
		query.append("            SUM(MRS.RA_CM_UC_AMT*MRS.LOD_QTY)	  /SUM(MRS.LOD_QTY)           AS RA_CM_UC_AMT ,  " ).append("\n"); 
		query.append("            SUM(MRS.RA_OPFIT_UC_AMT*MRS.LOD_QTY)  /SUM(MRS.LOD_QTY)           AS RA_OPFIT_UC_AMT," ).append("\n"); 
		query.append("            @[user_id]                                                      AS CRE_USR_ID   ,  " ).append("\n"); 
		query.append("            SYSDATE                                                         AS CRE_DT       ,  " ).append("\n"); 
		query.append("            @[user_id]                                                      AS UPD_USR_ID   ,  " ).append("\n"); 
		query.append("            SYSDATE                                                         AS UPD_DT          " ).append("\n"); 
		query.append("FROM        (                                                         " ).append("\n"); 
		query.append("            SELECT  -- YQTA_VER_NO                                    " ).append("\n"); 
		query.append("                    BSE_YR      ," ).append("\n"); 
		query.append("                    BSE_QTR_CD  ," ).append("\n"); 
		query.append("                    TRD_CD      ," ).append("\n"); 
		query.append("                    DIR_CD      ," ).append("\n"); 
		query.append("                    GLINE_VER_NO,                                     " ).append("\n"); 
		query.append("                    MAX(MQTA_VER_NO) AS MQTA_VER_NO                   " ).append("\n"); 
		query.append("            FROM    SAQ_MON_QTA_STEP_VER                              " ).append("\n"); 
		query.append("            WHERE   MQTA_STEP_CD    = '01'                            " ).append("\n"); 
		query.append("            AND     BSE_YR          = @[year]                         " ).append("\n"); 
		query.append("            AND     BSE_QTR_CD      = @[bse_qtr_cd]                   " ).append("\n"); 
		query.append("            AND     GLINE_VER_NO    = @[version]                      " ).append("\n"); 
		query.append("            GROUP BY" ).append("\n"); 
		query.append("                    BSE_YR      , " ).append("\n"); 
		query.append("                    BSE_QTR_CD  , " ).append("\n"); 
		query.append("                    TRD_CD      , " ).append("\n"); 
		query.append("                    DIR_CD      , " ).append("\n"); 
		query.append("                    GLINE_VER_NO " ).append("\n"); 
		query.append("            ) VER,                                  " ).append("\n"); 
		query.append("            SAQ_MON_TGT_VVD_ADJ     ADJ,            " ).append("\n"); 
		query.append("            SAQ_MON_MDL_CTRT_SMRY   MRS             " ).append("\n"); 
		query.append("WHERE  ADJ.BSE_YR           = VER.BSE_YR            " ).append("\n"); 
		query.append("AND    ADJ.BSE_QTR_CD       = VER.BSE_QTR_CD        " ).append("\n"); 
		query.append("AND    ADJ.TRD_CD           = VER.TRD_CD            " ).append("\n"); 
		query.append("AND    ADJ.DIR_CD           = VER.DIR_CD            " ).append("\n"); 
		query.append("AND    ADJ.GLINE_VER_NO     = VER.GLINE_VER_NO      " ).append("\n"); 
		query.append("AND    MRS.MQTA_MDL_VER_NO  = @[mqta_mdl_ver_no]    " ).append("\n"); 
		query.append("AND    MRS.BSE_MON          = ADJ.BSE_MON           " ).append("\n"); 
		query.append("AND    MRS.TRD_CD           = ADJ.TRD_CD            " ).append("\n"); 
		query.append("AND    MRS.RLANE_CD         = ADJ.RLANE_CD          " ).append("\n"); 
		query.append("AND    MRS.DIR_CD           = ADJ.DIR_CD            " ).append("\n"); 
		query.append("AND    MRS.VSL_CD           = ADJ.VSL_CD            " ).append("\n"); 
		query.append("AND    MRS.SKD_VOY_NO       = ADJ.SKD_VOY_NO        " ).append("\n"); 
		query.append("AND    MRS.SKD_DIR_CD       = ADJ.SKD_DIR_CD        " ).append("\n"); 
		query.append("GROUP BY                                            " ).append("\n"); 
		query.append("        VER.BSE_YR,                                 " ).append("\n"); 
		query.append("        VER.BSE_QTR_CD,                             " ).append("\n"); 
		query.append("        MRS.TRD_CD,                                 " ).append("\n"); 
		query.append("        MRS.DIR_CD,                                 " ).append("\n"); 
		query.append("        VER.MQTA_VER_NO,                            " ).append("\n"); 
		query.append("        MRS.RLANE_CD,                               " ).append("\n"); 
		query.append("        ADJ.SPRT_GRP_CD,                            " ).append("\n"); 
		query.append("        ADJ.BSA_GRP_CD,                             " ).append("\n"); 
		query.append("        MRS.CTRT_RHQ_CD,                            " ).append("\n"); 
		query.append("        MRS.BSE_MON,                                " ).append("\n"); 
		query.append("        MRS.BSE_YR,                                 " ).append("\n"); 
		query.append("        MRS.SUB_TRD_CD" ).append("\n"); 

	}
}