/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOConditionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOConditionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSQ 공통으로 사용 하는 조건 VO.
	  * </pre>
	  */
	public CommonDBDAOConditionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOConditionRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    ''F_HO_TEAM_CD            " ).append("\n"); 
		query.append("    ,''F_FM_MON                " ).append("\n"); 
		query.append("    ,''F_BSE_MON               " ).append("\n"); 
		query.append("    ,''F_DIR_CD                " ).append("\n"); 
		query.append("    ,''F_RHQ_CD                " ).append("\n"); 
		query.append("    ,''F_ORG_CD                " ).append("\n"); 
		query.append("    ,''F_GUBUN                 " ).append("\n"); 
		query.append("    ,''F_VSL_CD                " ).append("\n"); 
		query.append("    ,''F_BSE_QTR_CD            " ).append("\n"); 
		query.append("    ,''F_PORTION_LINK          " ).append("\n"); 
		query.append("    ,''F_CLICK                 " ).append("\n"); 
		query.append("    ,''F_OFC_LVL               " ).append("\n"); 
		query.append("    ,''F_NEW_RLANE_CD          " ).append("\n"); 
		query.append("    ,''F_FM_WK                 " ).append("\n"); 
		query.append("    ,''F_OB_DIV_CD             " ).append("\n"); 
		query.append("    ,''F_CSQ_CNG_TP_CD                   " ).append("\n"); 
		query.append("    ,''F_DECIMAL_FLG           " ).append("\n"); 
		query.append("    ,''F_TO_MON                " ).append("\n"); 
		query.append("    ,''F_SRC_TRD_CD            " ).append("\n"); 
		query.append("    ,''F_SKD_VOY_NO            " ).append("\n"); 
		query.append("    ,''F_BSE_TP_CD             " ).append("\n"); 
		query.append("    ,''F_USR_ID                " ).append("\n"); 
		query.append("    ,''F_CHK_ALOC_QTA          " ).append("\n"); 
		query.append("    ,''F_TRD_CD                " ).append("\n"); 
		query.append("    ,''F_TO_WK                 " ).append("\n"); 
		query.append("    ,''F_RLANE_CD              " ).append("\n"); 
		query.append("    ,''F_IO_BOUND              " ).append("\n"); 
		query.append("    ,''F_CHK_DECIMAL           " ).append("\n"); 
		query.append("    ,''F_APLY_FLG              " ).append("\n"); 
		query.append("    ,''F_ACCT_TGT_CD           " ).append("\n"); 
		query.append("    ,''F_QTA_STEP_CD                    " ).append("\n"); 
		query.append("    ,''F_QTA_TGT_CD            " ).append("\n"); 
		query.append("    ,''F_BSE_YR                " ).append("\n"); 
		query.append("    ,''F_SRC_RLANE_CD          " ).append("\n"); 
		query.append("    ,''F_YEAR_TP_CD            " ).append("\n"); 
		query.append("    ,''F_SRC_RHQ_CD            " ).append("\n"); 
		query.append("    ,''F_CHK_VVD               " ).append("\n"); 
		query.append("    ,''F_RGN_OFC_CD            " ).append("\n"); 
		query.append("    ,''F_SRC_RGN_OFC_CD        " ).append("\n"); 
		query.append("    ,''F_OFC_VW_CD             " ).append("\n"); 
		query.append("    ,''F_SKD_DIR_CD            " ).append("\n"); 
		query.append("    ,''F_CHK_WEEK              " ).append("\n"); 
		query.append("    ,''F_LANE_DIR_CD           " ).append("\n"); 
		query.append("    ,''F_CRNT_BSE_YR           " ).append("\n"); 
		query.append("    ,''F_DURATION              " ).append("\n"); 
		query.append("    ,''F_SUB_TRD_CD            " ).append("\n"); 
		query.append("    ,''F_CUST_GRP_ID           " ).append("\n"); 
		query.append("    ,''F_CONV_DIR_CD           " ).append("\n"); 
		query.append("    ,''F_CRNT_QTA_CD" ).append("\n"); 
		query.append("    ,''F_BSE_WK" ).append("\n"); 
		query.append("    ,''F_PF_GRP_CD" ).append("\n"); 
		query.append("    ,''F_IAS_SCTR_FLG" ).append("\n"); 
		query.append("    ,''F_POL_CD" ).append("\n"); 
		query.append("    ,''F_POD_CD" ).append("\n"); 
		query.append("    ,''F_ACT_FLAG" ).append("\n"); 
		query.append("    ,''F_C_CNT" ).append("\n"); 
		query.append("    ,''F_ADD_FLG" ).append("\n"); 
		query.append("    ,''F_CHK_PAIR" ).append("\n"); 
		query.append("    ,''CHK_WEEK" ).append("\n"); 
		query.append("    ,''F_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,''F_DG_FLG" ).append("\n"); 
		query.append("    ,''F_RD_FLG" ).append("\n"); 
		query.append("    ,''F_CSQ_MN_SCTR_FLG" ).append("\n"); 
		query.append("	,''F_FNL_BSA_CAPA" ).append("\n"); 
		query.append("	,''f_deleted_flg" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}