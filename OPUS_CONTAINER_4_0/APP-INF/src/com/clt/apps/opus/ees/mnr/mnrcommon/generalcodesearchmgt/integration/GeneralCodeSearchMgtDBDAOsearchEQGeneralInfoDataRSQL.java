/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchEQGeneralInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_loss_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
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
		query.append("SELECT A.EQ_TYPE" ).append("\n"); 
		query.append("     , A.EQ_NO" ).append("\n"); 
		query.append("     , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , A.DMG_FLAG" ).append("\n"); 
		query.append("     , A.MANU_DT" ).append("\n"); 
		query.append("     , A.LESSOR_NM" ).append("\n"); 
		query.append("     , A.LSTM_CD" ).append("\n"); 
		query.append("     , A.DSP_FLAG" ).append("\n"); 
		query.append("     , A.OFF_HIRE" ).append("\n"); 
		query.append("     , A.IMM_EXT" ).append("\n"); 
		query.append("     , A.MVMT_CD" ).append("\n"); 
		query.append("#if(${eq_type} == 'G')" ).append("\n"); 
		query.append("     , '' MVMT_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , DECODE(A.MVMT_CD," ).append("\n"); 
		query.append("        'MT',A.MVMT_DT," ).append("\n"); 
		query.append("        'IC',A.MVMT_DT," ).append("\n"); 
		query.append("        'OC',A.MVMT_DT," ).append("\n"); 
		query.append("        (#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(CTM_MOVEMENT XPKCTM_MOVEMENT) */ TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("          AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("		 #elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(CTM_MOVEMENT XAK17CTM_MOVEMENT) */ TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("          AND CHSS_NO = @[cntr_no]" ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC(CTM_MOVEMENT XPKCTM_MOVEMENT) */ TO_CHAR(CNMV_EVNT_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("          AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("		 #end" ).append("\n"); 
		query.append("           AND CNMV_YR IN (TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YYYY') - 1)" ).append("\n"); 
		query.append("           AND CNMV_ID_NO > 0 " ).append("\n"); 
		query.append("           AND MVMT_STS_CD IN ('MT', 'IC', 'OC')" ).append("\n"); 
		query.append("           AND ROWNUM = 1)" ).append("\n"); 
		query.append("  	   )  MVMT_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     , A.RPR_TYPE" ).append("\n"); 
		query.append("     , A.STATUS" ).append("\n"); 
		query.append("     , A.RPR_YD" ).append("\n"); 
		query.append("     , A.RPR_DT" ).append("\n"); 
		query.append("     , A.SP_NAME" ).append("\n"); 
		query.append("     , A.COST" ).append("\n"); 
		query.append("     , A.DV_CUR" ).append("\n"); 
		query.append("     , DECODE(A.LSTM_CD," ).append("\n"); 
		query.append("       'OW',MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO, replace(@[total_loss_date],'-',''))," ).append("\n"); 
		query.append("       'LP',MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO, replace(@[total_loss_date],'-',''))," ).append("\n"); 
		query.append("       'OL',MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO, replace(@[total_loss_date],'-',''))," ).append("\n"); 
		query.append("       ''" ).append("\n"); 
		query.append("       ) DV_VALUE" ).append("\n"); 
		query.append("     , A.CRNT_YD_CD" ).append("\n"); 
		query.append("     , A.HNGR_FLG_YD" ).append("\n"); 
		query.append("     , A.HNGR_RCK_CD" ).append("\n"); 
		query.append("     , NVL(A.BAR_ATCH_KNT,0) BAR_ATCH_KNT" ).append("\n"); 
		query.append("     , A.BAR_TP_CD" ).append("\n"); 
		query.append("     , A.HNGR_FLG_DT" ).append("\n"); 
		query.append("     , A.FLG_RMK" ).append("\n"); 
		query.append("	 , A.MTRL_CD " ).append("\n"); 
		query.append("	 , A.MTRL_NM " ).append("\n"); 
		query.append("	 , A.MKR_NM " ).append("\n"); 
		query.append("	 , A.MDL_NM" ).append("\n"); 
		query.append("     , @[total_loss_date] TOTAL_LOSS_DATE" ).append("\n"); 
		query.append("     , A.RPR_COST_AMT" ).append("\n"); 
		query.append("	 , A.DPP_AMT" ).append("\n"); 
		query.append("	 , A.MNR_HNGR_TRF_CD" ).append("\n"); 
		query.append("  	 , A.MNR_HNGR_TRF_OTR_DESC" ).append("\n"); 
		query.append("  	 , NVL(A.ACT_INVT_QTY,0) ACT_INVT_QTY" ).append("\n"); 
		query.append("  	 , NVL(A.MNR_HNGR_DMG_QTY,0) MNR_HNGR_DMG_QTY" ).append("\n"); 
		query.append("  	 , NVL(A.MNR_LOST_HNGR_QTY,0) MNR_LOST_HNGR_QTY" ).append("\n"); 
		query.append("  	 , NVL(A.MNR_DISP_HNGR_QTY,0) MNR_DISP_HNGR_QTY" ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("	 , MST_COMMON_PKG.MST_RU_LBL_GET_FNC(C.CNTR_NO) AS RSTR_USG_LBL_NM" ).append("\n"); 
		query.append("     , MST_COMMON_PKG.MST_RU_TP_GET_FNC(C.CNTR_NO) AS RSTR_USG_LBL_TP" ).append("\n"); 
		query.append("     , MST_COMMON_PKG.MST_RU_VAL_GET_FNC(C.CNTR_NO) AS RSTR_USG_LBL_VAL" ).append("\n"); 
		query.append("     , C.CNTR_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 , A.LESSOR_CD" ).append("\n"); 
		query.append("     , A.ACT_IND" ).append("\n"); 
		query.append("  FROM MNR_EQ_STS_V A " ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append(", MST_CONTAINER C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE A.EQ_TYPE = @[eq_type]   " ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append(" AND     A.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   #if (${eq_no} != '')" ).append("\n"); 
		query.append("   AND A.EQ_NO IN ( #foreach ($user_eq_no IN ${eq_no})" ).append("\n"); 
		query.append("  			             #if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("  				         '$user_eq_no'," ).append("\n"); 
		query.append("  			             #else" ).append("\n"); 
		query.append("  				         '$user_eq_no'" ).append("\n"); 
		query.append("  			             #end " ).append("\n"); 
		query.append("  		             #end			  " ).append("\n"); 
		query.append("  	               )" ).append("\n"); 
		query.append("   #end" ).append("\n"); 

	}
}