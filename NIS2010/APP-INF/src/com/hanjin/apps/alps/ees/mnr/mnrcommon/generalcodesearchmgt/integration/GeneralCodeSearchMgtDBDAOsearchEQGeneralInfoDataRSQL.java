/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchEQGeneralInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchEQGeneralInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchEQGeneralInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_loss_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchEQGeneralInfoDataRSQL").append("\n"); 
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
		query.append("SELECT   A.EQ_TYPE" ).append("\n"); 
		query.append("       , A.EQ_NO" ).append("\n"); 
		query.append("       , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , A.DMG_FLAG" ).append("\n"); 
		query.append("       , A.MANU_DT" ).append("\n"); 
		query.append("       , A.LESSOR_NM" ).append("\n"); 
		query.append("       , A.LSTM_CD" ).append("\n"); 
		query.append("       , A.DSP_FLAG" ).append("\n"); 
		query.append("       , A.OFF_HIRE" ).append("\n"); 
		query.append("       , A.IMM_EXT" ).append("\n"); 
		query.append("       , A.MVMT_CD" ).append("\n"); 
		query.append("       , A.MVMT_DT" ).append("\n"); 
		query.append("       , A.RPR_TYPE" ).append("\n"); 
		query.append("       , A.STATUS" ).append("\n"); 
		query.append("       , A.RPR_YD" ).append("\n"); 
		query.append("       , A.RPR_DT" ).append("\n"); 
		query.append("       , A.SP_NAME" ).append("\n"); 
		query.append("       , A.COST" ).append("\n"); 
		query.append("       , A.DV_CUR" ).append("\n"); 
		query.append("       , CASE WHEN A.LSTM_CD = 'OW' THEN MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO, replace(@[total_loss_date],'-',''))" ).append("\n"); 
		query.append("              WHEN A.LSTM_CD = 'LP' THEN MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO, replace(@[total_loss_date],'-',''))" ).append("\n"); 
		query.append("              WHEN A.LSTM_CD = 'OL' THEN MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO, replace(@[total_loss_date],'-',''))" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("         END AS DV_VALUE" ).append("\n"); 
		query.append("       , A.CRNT_YD_CD" ).append("\n"); 
		query.append("       , A.HNGR_FLG_YD" ).append("\n"); 
		query.append("       , A.HNGR_RCK_CD" ).append("\n"); 
		query.append("       , NVL(A.BAR_ATCH_KNT,0) AS BAR_ATCH_KNT" ).append("\n"); 
		query.append("       , A.BAR_TP_CD" ).append("\n"); 
		query.append("       , A.HNGR_FLG_DT" ).append("\n"); 
		query.append("       , A.FLG_RMK" ).append("\n"); 
		query.append("	   , A.MTRL_CD " ).append("\n"); 
		query.append("	   , A.MTRL_NM " ).append("\n"); 
		query.append("	   , A.MKR_NM " ).append("\n"); 
		query.append("	   , A.MDL_NM" ).append("\n"); 
		query.append("       , @[total_loss_date] AS TOTAL_LOSS_DATE" ).append("\n"); 
		query.append("       , A.RPR_COST_AMT" ).append("\n"); 
		query.append("	   , A.DPP_AMT" ).append("\n"); 
		query.append("	   , A.MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append("  	   , A.MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append("  	   , NVL(A.ACT_INVT_QTY,0) AS ACT_INVT_QTY" ).append("\n"); 
		query.append("  	   , NVL(A.MNR_HNGR_DMG_QTY,0) AS MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append("  	   , NVL(A.MNR_LOST_HNGR_QTY,0) AS MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append("  	   , NVL(A.MNR_DISP_HNGR_QTY,0) AS MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append("FROM     MNR_EQ_STS_V A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.EQ_TYPE = @[eq_type]   " ).append("\n"); 
		query.append("#if (${eq_no} != '')" ).append("\n"); 
		query.append("AND      A.EQ_NO IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("    #foreach ($user_eq_no IN ${eq_no})" ).append("\n"); 
		query.append("        #if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("  			'$user_eq_no'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("  			'$user_eq_no'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end			  " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}