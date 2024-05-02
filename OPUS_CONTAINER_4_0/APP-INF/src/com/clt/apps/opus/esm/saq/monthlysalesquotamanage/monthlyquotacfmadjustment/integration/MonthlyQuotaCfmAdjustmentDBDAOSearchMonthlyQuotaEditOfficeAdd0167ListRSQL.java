/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAdd0167ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAdd0167ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Office Add Popup List 조회
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAdd0167ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOSearchMonthlyQuotaEditOfficeAdd0167ListRSQL").append("\n"); 
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
		query.append("          A.MQTA_RLSE_VER_NO    , " ).append("\n"); 
		query.append("          A.BSE_YR    , " ).append("\n"); 
		query.append("          A.BSE_QTR_CD," ).append("\n"); 
		query.append("          A.QTA_TGT_CD          ," ).append("\n"); 
		query.append("          B.BSE_MON   , " ).append("\n"); 
		query.append("          B.BSE_WK    ," ).append("\n"); 
		query.append("          A.VSL_CD              , " ).append("\n"); 
		query.append("          A.SKD_VOY_NO," ).append("\n"); 
		query.append("          A.SKD_DIR_CD," ).append("\n"); 
		query.append("          A.TRD_CD              ," ).append("\n"); 
		query.append("          A.DIR_CD    , " ).append("\n"); 
		query.append("          A.SUB_TRD_CD," ).append("\n"); 
		query.append("          A.RLANE_CD            , " ).append("\n"); 
		query.append("          A.RHQ_CD    , " ).append("\n"); 
		query.append("          A.AQ_CD     ," ).append("\n"); 
		query.append("          A.RGN_OFC_CD          , " ).append("\n"); 
		query.append("          A.ADD_TP_CD , " ).append("\n"); 
		query.append("          A.DELT_FLG  ," ).append("\n"); 
		query.append("          A.RLANE_CD     AS NEW_RLANE_CD," ).append("\n"); 
		query.append("          B.FNL_BSA_CAPA AS BSA_CAPA    ," ).append("\n"); 
		query.append("          TO_CHAR(B.LST_LODG_PORT_ETD_DT,'YYYY-MM-DD HH24:MI:SS') AS LST_LODG_PORT_ETD_DT, B.IOC_CD    , B.VVD_SEQ" ).append("\n"); 
		query.append("     FROM SAQ_MON_CFM_QTA_OFC_ADD A," ).append("\n"); 
		query.append("          SAQ_MON_CFM_TGT_VVD     B" ).append("\n"); 
		query.append("    WHERE A.MQTA_RLSE_VER_NO  = @[mqtaRlseVerNo]" ).append("\n"); 
		query.append("      AND A.BSE_YR            = @[bse_yr]" ).append("\n"); 
		query.append("      AND A.BSE_QTR_CD        = @[bse_qtr_cd]" ).append("\n"); 
		query.append("      AND A.QTA_TGT_CD        = @[qtaTgtCd]" ).append("\n"); 
		query.append("      AND A.TRD_CD            = @[trd_cd]" ).append("\n"); 
		query.append("      AND A.DIR_CD            = @[dir_cd]" ).append("\n"); 
		query.append("#if (${add_tp_cd} == 'O')" ).append("\n"); 
		query.append("	#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("      AND A.RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND A.ADD_TP_CD        = @[add_tp_cd]" ).append("\n"); 
		query.append("      AND A.MQTA_RLSE_VER_NO = B.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      AND A.BSE_YR           = B.BSE_YR" ).append("\n"); 
		query.append("      AND A.BSE_QTR_CD       = B.BSE_QTR_CD" ).append("\n"); 
		query.append("      AND A.TRD_CD           = B.TRD_CD" ).append("\n"); 
		query.append("      AND A.DIR_CD           = B.DIR_CD" ).append("\n"); 
		query.append("      AND A.VSL_CD           = B.VSL_CD" ).append("\n"); 
		query.append("      AND A.SKD_VOY_NO       = B.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND A.SKD_DIR_CD       = B.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD       = B.SUB_TRD_CD" ).append("\n"); 
		query.append("      AND A.RLANE_CD         = B.RLANE_CD" ).append("\n"); 
		query.append(" ORDER BY RLANE_CD, RGN_OFC_CD, BSE_MON, BSE_WK, VSL_CD||SKD_VOY_NO||SKD_DIR_CD" ).append("\n"); 

	}
}