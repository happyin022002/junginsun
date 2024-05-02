/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAddNew0167ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.10 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAddNew0167ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Office Add Popup 새로 추가할 Office List 조회
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAddNew0167ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaRlseVerNo",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qtaTgtCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgnOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAddNew0167ListRSQL").append("\n"); 
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
		query.append("                BSE_MON, " ).append("\n"); 
		query.append("                BSE_WK    , " ).append("\n"); 
		query.append("                TRD_CD    ," ).append("\n"); 
		query.append("                VSL_CD , " ).append("\n"); 
		query.append("                SKD_VOY_NO, " ).append("\n"); 
		query.append("                SKD_DIR_CD," ).append("\n"); 
		query.append("                DIR_CD , " ).append("\n"); 
		query.append("                SUB_TRD_CD, " ).append("\n"); 
		query.append("                RLANE_CD  ," ).append("\n"); 
		query.append("                @[rhq_cd]   AS RHQ_CD              ," ).append("\n"); 
		query.append("                @[aq_cd]   AS AQ_CD               ," ).append("\n"); 
		query.append("                @[rgnOfcCd]   AS RGN_OFC_CD          ," ).append("\n"); 
		query.append("                @[add_tp_cd]   AS ADD_TP_CD           ," ).append("\n"); 
		query.append("                'N' AS DELT_FLG            ," ).append("\n"); 
		query.append("                ''  AS NEW_RLANE_CD        ," ).append("\n"); 
		query.append("                ''  AS IOC_CD              ," ).append("\n"); 
		query.append("                ''  AS VVD_SEQ             ," ).append("\n"); 
		query.append("                ''  AS LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                ''  AS BSA_CAPA" ).append("\n"); 
		query.append("     FROM SAQ_MON_CFM_TGT_VVD" ).append("\n"); 
		query.append("   WHERE MQTA_RLSE_VER_NO = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("        AND BSE_YR        = @[bse_yr]" ).append("\n"); 
		query.append("        AND BSE_QTR_CD    = @[bse_qtr_cd]" ).append("\n"); 
		query.append("        AND TRD_CD        = @[trd_cd]" ).append("\n"); 
		query.append("        AND DIR_CD        = @[dir_cd]" ).append("\n"); 
		query.append("        AND RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("        AND (BSE_MON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, @[rgnOfcCd]) NOT IN ( " ).append("\n"); 
		query.append("                                                               SELECT DISTINCT bse_mon, vsl_cd, skd_voy_no, skd_dir_cd, rgn_ofc_cd" ).append("\n"); 
		query.append("                                                                FROM SAQ_MON_CFM_QTA" ).append("\n"); 
		query.append("                                                               WHERE MQTA_RLSE_VER_NO = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("                                                                 AND BSE_YR           = @[bse_yr]" ).append("\n"); 
		query.append("                                                                 AND BSE_QTR_CD       = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                                                                 AND TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("                                                                 AND DIR_CD           = @[dir_cd]" ).append("\n"); 
		query.append("                                                                 AND RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("                                                                 AND RHQ_CD           = @[rhq_cd]" ).append("\n"); 
		query.append("#if (${aq_cd} != '') " ).append("\n"); 
		query.append("                                                                 AND AQ_CD= @[aq_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                                                                 AND AQ_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                                 AND QTA_TGT_CD       = @[qtaTgtCd]  )" ).append("\n"); 
		query.append(" ORDER BY BSE_MON, BSE_WK, TRD_CD,VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}