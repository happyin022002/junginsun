/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchMonthlyQuotaRHQRemarkListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchMonthlyQuotaRHQRemarkListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchMonthlyQuotaRHQRemarkListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sprt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("login_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchMonthlyQuotaRHQRemarkListRSQL").append("\n"); 
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
		query.append("SELECT                                                              " ).append("\n"); 
		query.append("    MQTA_STEP_CD ,                                                  " ).append("\n"); 
		query.append("    BSE_YR       ,                                                  " ).append("\n"); 
		query.append("    BSE_QTR_CD      ,                                                  " ).append("\n"); 
		query.append("    TRD_CD       ,                                                  " ).append("\n"); 
		query.append("    DIR_CD       ,                                                  " ).append("\n"); 
		query.append("    MQTA_VER_NO  ,                                                  " ).append("\n"); 
		query.append("    RLANE_CD     ,                                                  " ).append("\n"); 
		query.append("    SPRT_GRP_CD  ,                                                  " ).append("\n"); 
		query.append("    BSA_GRP_CD   ,                                                  " ).append("\n"); 
		query.append("    CTRT_RGN_OFC_CD,                                                " ).append("\n"); 
		query.append("    BSE_MON      ,                                                  " ).append("\n"); 
		query.append("    CRE_SEQ      ,                                                  " ).append("\n"); 
		query.append("    SUBJ_CTNT    ,                                                  " ).append("\n"); 
		query.append("    CRE_OFC_CD   ,                                                  " ).append("\n"); 
		query.append("    CMT_CTNT     ,                                                  " ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', RMK_CRE_GDT, @[login_ofc_cd]), 'yyyy.mm.dd hh24:mi:ss') AS RMK_CRE_GDT, " ).append("\n"); 
		query.append("    SAQ_STS_CD                                                      " ).append("\n"); 
		query.append("FROM   SAQ_MON_QTA_RHQ_RMK                                          " ).append("\n"); 
		query.append("WHERE MQTA_STEP_CD  = @[mqta_step_cd]                                             " ).append("\n"); 
		query.append("AND   BSE_YR        = @[bse_yr]                                             " ).append("\n"); 
		query.append("AND   BSE_QTR_CD       = @[bse_qtr_cd]                                             " ).append("\n"); 
		query.append("AND   TRD_CD        = @[trd_cd]                                             " ).append("\n"); 
		query.append("AND   DIR_CD        = @[dir_cd]                                             " ).append("\n"); 
		query.append("AND   MQTA_VER_NO   = @[mqta_ver_no]                                             " ).append("\n"); 
		query.append("AND   RLANE_CD      = @[rlane_cd]                                             " ).append("\n"); 
		query.append("AND   SPRT_GRP_CD   = @[sprt_grp_cd]                                             " ).append("\n"); 
		query.append("AND   BSA_GRP_CD    = @[bsa_grp_cd]                                             " ).append("\n"); 
		query.append("AND   CTRT_RGN_OFC_CD = @[ctrt_rgn_ofc_cd]                                           " ).append("\n"); 
		query.append("AND   BSE_MON       = @[bse_mon]                                             " ).append("\n"); 
		query.append("UNION ALL                                                           " ).append("\n"); 
		query.append("SELECT                                                              " ).append("\n"); 
		query.append("    RMK.MQTA_STEP_CD ,                                              " ).append("\n"); 
		query.append("    RMK.BSE_YR       ,                                              " ).append("\n"); 
		query.append("    RMK.BSE_QTR_CD      ,                                              " ).append("\n"); 
		query.append("    RMK.TRD_CD       ,                                              " ).append("\n"); 
		query.append("    RMK.DIR_CD       ,                                              " ).append("\n"); 
		query.append("    RMK.MQTA_VER_NO  ,                                              " ).append("\n"); 
		query.append("    RMK.RLANE_CD     ,                                              " ).append("\n"); 
		query.append("    RMK.SPRT_GRP_CD  ,                                              " ).append("\n"); 
		query.append("    RMK.BSA_GRP_CD   ,                                              " ).append("\n"); 
		query.append("    RMK.CTRT_RGN_OFC_CD,                                            " ).append("\n"); 
		query.append("    RMK.BSE_MON      ,                                              " ).append("\n"); 
		query.append("    RMK.CRE_SEQ      ,                                              " ).append("\n"); 
		query.append("    RMK.SUBJ_CTNT    ,                                              " ).append("\n"); 
		query.append("    RMK.CRE_OFC_CD   ,                                              " ).append("\n"); 
		query.append("    RMK.CMT_CTNT     ,                                              " ).append("\n"); 
		query.append("    TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', RMK_CRE_GDT, @[login_ofc_cd]), 'yyyy.mm.dd hh24:mi:ss') AS RMK_CRE_GDT, " ).append("\n"); 
		query.append("    RMK.SAQ_STS_CD                                                  " ).append("\n"); 
		query.append("FROM  SAQ_MON_QTA_STEP_VER VER,                                     " ).append("\n"); 
		query.append("      SAQ_MON_QTA_RHQ_RMK RMK                                       " ).append("\n"); 
		query.append("WHERE VER.MQTA_STEP_CD  <> @[mqta_step_cd]                                        " ).append("\n"); 
		query.append("AND   VER.BSE_YR        = @[bse_yr]                                         " ).append("\n"); 
		query.append("AND   VER.BSE_QTR_CD       = @[bse_qtr_cd]                                         " ).append("\n"); 
		query.append("AND   VER.TRD_CD        = @[trd_cd]                                         " ).append("\n"); 
		query.append("AND   VER.DIR_CD        = @[dir_cd]                                         " ).append("\n"); 
		query.append("AND   VER.GLINE_VER_NO  = @[gline_ver_no]                                         " ).append("\n"); 
		query.append("AND   VER.SAQ_STS_CD IN                                             " ).append("\n"); 
		query.append("                (SELECT A.INTG_CD_VAL_CTNT                          " ).append("\n"); 
		query.append("                 FROM   COM_INTG_CD_DTL A,                          " ).append("\n"); 
		query.append("                        COM_INTG_CD_DTL B                           " ).append("\n"); 
		query.append("                 WHERE A.INTG_CD_ID = 'CD00926'                     " ).append("\n"); 
		query.append("                 AND   B.INTG_CD_ID = A.INTG_CD_ID                  " ).append("\n"); 
		query.append("                 AND   B.INTG_CD_VAL_CTNT = 'DN'                    " ).append("\n"); 
		query.append("                 AND   A.INTG_CD_VAL_DP_SEQ >= B.INTG_CD_VAL_DP_SEQ)" ).append("\n"); 
		query.append("AND   RMK.MQTA_STEP_CD  = VER.MQTA_STEP_CD                          " ).append("\n"); 
		query.append("AND   RMK.BSE_YR        = VER.BSE_YR                                " ).append("\n"); 
		query.append("AND   RMK.BSE_QTR_CD       = VER.BSE_QTR_CD                               " ).append("\n"); 
		query.append("AND   RMK.TRD_CD        = VER.TRD_CD                                " ).append("\n"); 
		query.append("AND   RMK.DIR_CD        = VER.DIR_CD                                " ).append("\n"); 
		query.append("AND   RMK.MQTA_VER_NO   = VER.MQTA_VER_NO                           " ).append("\n"); 
		query.append("AND   RMK.RLANE_CD      = @[rlane_cd]                                         " ).append("\n"); 
		query.append("AND   RMK.SPRT_GRP_CD   = @[sprt_grp_cd]                                         " ).append("\n"); 
		query.append("AND   RMK.BSA_GRP_CD    = @[bsa_grp_cd]                                         " ).append("\n"); 
		query.append("AND   RMK.CTRT_RGN_OFC_CD = @[ctrt_rgn_ofc_cd]                                       " ).append("\n"); 
		query.append("AND   RMK.BSE_MON       = @[bse_mon]                                         " ).append("\n"); 
		query.append("ORDER BY RMK_CRE_GDT DESC       " ).append("\n"); 

	}
}