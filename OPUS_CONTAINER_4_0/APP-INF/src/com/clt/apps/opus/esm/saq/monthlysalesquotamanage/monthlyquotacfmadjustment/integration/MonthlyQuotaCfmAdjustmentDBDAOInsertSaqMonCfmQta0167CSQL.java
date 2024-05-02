/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQta0167CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
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

public class MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQta0167CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Office Add Popup 관련 Data 처리
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQta0167CSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("add_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mqta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("temp_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmQta0167CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_CFM_QTA (" ).append("\n"); 
		query.append("             MQTA_RLSE_VER_NO, " ).append("\n"); 
		query.append("             BSE_YR            , " ).append("\n"); 
		query.append("             BSE_QTR_CD     , " ).append("\n"); 
		query.append("             QTA_TGT_CD      ," ).append("\n"); 
		query.append("             BSE_MON         , " ).append("\n"); 
		query.append("             VSL_CD            , " ).append("\n"); 
		query.append("             SKD_VOY_NO     , " ).append("\n"); 
		query.append("             SKD_DIR_CD      ," ).append("\n"); 
		query.append("             TRD_CD          , " ).append("\n"); 
		query.append("             DIR_CD            , " ).append("\n"); 
		query.append("             RLANE_CD       , " ).append("\n"); 
		query.append("             RHQ_CD          ," ).append("\n"); 
		query.append("             AQ_CD           , " ).append("\n"); 
		query.append("             RGN_OFC_CD        , " ).append("\n"); 
		query.append("             CUST_CNT_CD    ," ).append("\n"); 
		query.append("             CUST_SEQ        ," ).append("\n"); 
		query.append("             POL_CD          ," ).append("\n"); 
		query.append("             POD_CD            , " ).append("\n"); 
		query.append("             LOD_QTY        , " ).append("\n"); 
		query.append("             GRS_RPB_REV     ," ).append("\n"); 
		query.append("             CM_UC_AMT       , " ).append("\n"); 
		query.append("             OPFIT_UC_AMT      , " ).append("\n"); 
		query.append("             RA_CM_UC_AMT   , " ).append("\n"); 
		query.append("             RA_OPFIT_UC_AMT ," ).append("\n"); 
		query.append("             FULL_STVG_UC_AMT, " ).append("\n"); 
		query.append("             FULL_TRSP_UC_AMT  , " ).append("\n"); 
		query.append("             MTY_STVG_UC_AMT, " ).append("\n"); 
		query.append("             MTY_TRSP_UC_AMT ," ).append("\n"); 
		query.append("             CNTR_FX_UC_AMT  , " ).append("\n"); 
		query.append("             CHSS_FX_UC_AMT    , " ).append("\n"); 
		query.append("             AGN_COMM_UT_AMT, " ).append("\n"); 
		query.append("             BIZ_ACT_UC_AMT  ," ).append("\n"); 
		query.append("             SLT_MGMT_UC_AMT , " ).append("\n"); 
		query.append("             OWN_VOL_ACT_UC_AMT, " ).append("\n"); 
		query.append("             STP_UC_AMT     , " ).append("\n"); 
		query.append("             EQ_HLD_UC_AMT   ," ).append("\n"); 
		query.append("             EQ_REPO_UC_AMT  ," ).append("\n"); 
		query.append("             EQ_SIM_UC_AMT     , " ).append("\n"); 
		query.append("             CONV_DIR_CD    , " ).append("\n"); 
		query.append("             SAQ_MISC_REV_AMT," ).append("\n"); 
		query.append("             ADD_TP_CD       ," ).append("\n"); 
		query.append("             CRE_USR_ID      , " ).append("\n"); 
		query.append("             CRE_DT            , " ).append("\n"); 
		query.append("             UPD_USR_ID     , " ).append("\n"); 
		query.append("             UPD_DT             " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" WITH INPUT_PARAMS AS (" ).append("\n"); 
		query.append("                   SELECT " ).append("\n"); 
		query.append("                                @[mqta_rlse_ver_no] AS MQTA_RLSE_VER_NO," ).append("\n"); 
		query.append("                                @[bse_yr] AS BSE_YR          ," ).append("\n"); 
		query.append("                                @[bse_qtr_cd] AS BSE_QTR_CD      ," ).append("\n"); 
		query.append("                                @[qta_tgt_cd] AS QTA_TGT_CD      ," ).append("\n"); 
		query.append("                                @[bse_mon] AS BSE_MON         ," ).append("\n"); 
		query.append("                                @[trd_cd] AS TRD_CD          ," ).append("\n"); 
		query.append("                                @[dir_cd] AS DIR_CD          ," ).append("\n"); 
		query.append("                                @[vsl_cd] AS VSL_CD          ," ).append("\n"); 
		query.append("                                @[skd_voy_no] AS SKD_VOY_NO      ," ).append("\n"); 
		query.append("                                @[skd_dir_cd] AS SKD_DIR_CD      ," ).append("\n"); 
		query.append("                                @[sub_trd_cd] AS SUB_TRD_CD      ," ).append("\n"); 
		query.append("                                @[rlane_cd] AS RLANE_CD        ," ).append("\n"); 
		query.append("                                @[new_rlane_cd] AS NEW_RLANE_CD    ," ).append("\n"); 
		query.append("                                @[rhq_cd] AS RHQ_CD          ," ).append("\n"); 
		query.append("                                @[aq_cd] AS AQ_CD           ," ).append("\n"); 
		query.append("                                @[rgn_ofc_cd] AS RGN_OFC_CD      ," ).append("\n"); 
		query.append("                                @[add_tp_cd] AS ADD_TP_CD       ," ).append("\n"); 
		query.append("                                MIN(CONV_DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("                      FROM SAQ_MON_DIR_CONV" ).append("\n"); 
		query.append("                   WHERE BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("                        AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("                        AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("                        AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("                        AND RLANE_CD   = @[temp_rlane_cd]" ).append("\n"); 
		query.append("                        AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    #if(${add_tp_cd} == 'L')    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        INP.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       ,INP.BSE_YR" ).append("\n"); 
		query.append("       ,INP.BSE_QTR_CD" ).append("\n"); 
		query.append("       ,INP.QTA_TGT_CD" ).append("\n"); 
		query.append("       ,INP.BSE_MON" ).append("\n"); 
		query.append("       ,INP.VSL_CD" ).append("\n"); 
		query.append("       ,INP.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,INP.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,INP.TRD_CD" ).append("\n"); 
		query.append("       ,INP.DIR_CD" ).append("\n"); 
		query.append("       ,DECODE(INP.ADD_TP_CD, 'O', INP.RLANE_CD, INP.NEW_RLANE_CD)" ).append("\n"); 
		query.append("       ,INP.RHQ_CD" ).append("\n"); 
		query.append("       ,INP.AQ_CD" ).append("\n"); 
		query.append("       ,INP.RGN_OFC_CD" ).append("\n"); 
		query.append("       ,'00'" ).append("\n"); 
		query.append("       ,'0'" ).append("\n"); 
		query.append("       ,'00000'" ).append("\n"); 
		query.append("       ,'00000'" ).append("\n"); 
		query.append("       , SMCQ.LOD_QTY, SMCQ.GRS_RPB_REV, SMCQ.CM_UC_AMT, 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append("       , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append("       ,NVL(INP.CONV_DIR_CD, INP.DIR_CD)" ).append("\n"); 
		query.append("       ,0" ).append("\n"); 
		query.append("       ,INP.ADD_TP_CD" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    FROM INPUT_PARAMS INP, SAQ_MON_CFM_QTA SMCQ " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND INP.MQTA_RLSE_VER_NO = SMCQ.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("    AND INP.BSE_YR  = SMCQ.BSE_YR" ).append("\n"); 
		query.append("    AND INP.BSE_QTR_CD = SMCQ.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND INP.QTA_TGT_CD = SMCQ.QTA_TGT_CD" ).append("\n"); 
		query.append("    AND INP.BSE_MON = SMCQ.BSE_MON" ).append("\n"); 
		query.append("    AND SMCQ.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("    AND INP.RHQ_CD  = SMCQ.RHQ_CD" ).append("\n"); 
		query.append("    AND INP.RGN_OFC_CD = SMCQ.RGN_OFC_CD" ).append("\n"); 
		query.append("    AND ROWNUM = 1" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("SELECT  MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       ,BSE_YR" ).append("\n"); 
		query.append("       ,BSE_QTR_CD" ).append("\n"); 
		query.append("       ,QTA_TGT_CD" ).append("\n"); 
		query.append("       ,BSE_MON" ).append("\n"); 
		query.append("       ,VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,TRD_CD" ).append("\n"); 
		query.append("       ,DIR_CD" ).append("\n"); 
		query.append("       ,DECODE(ADD_TP_CD, 'O', RLANE_CD, NEW_RLANE_CD)" ).append("\n"); 
		query.append("       ,RHQ_CD" ).append("\n"); 
		query.append("       ,AQ_CD" ).append("\n"); 
		query.append("       ,RGN_OFC_CD" ).append("\n"); 
		query.append("       ,'00'" ).append("\n"); 
		query.append("       ,'0'" ).append("\n"); 
		query.append("       ,'00000'" ).append("\n"); 
		query.append("       ,'00000'" ).append("\n"); 
		query.append("       , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append("       , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0" ).append("\n"); 
		query.append("       ,NVL(CONV_DIR_CD, DIR_CD)" ).append("\n"); 
		query.append("       ,0" ).append("\n"); 
		query.append("       ,ADD_TP_CD" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("  FROM  INPUT_PARAMS" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}