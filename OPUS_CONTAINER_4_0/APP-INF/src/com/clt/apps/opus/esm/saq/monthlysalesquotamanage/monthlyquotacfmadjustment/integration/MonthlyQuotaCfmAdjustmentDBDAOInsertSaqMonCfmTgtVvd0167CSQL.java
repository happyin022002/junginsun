/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmTgtVvd0167CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
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

public class MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmTgtVvd0167CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Quota Editing - Office Add Popup 관련 Data 처리
	  * </pre>
	  */
	public MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmTgtVvd0167CSQL(){
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
		params.put("new_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_lodg_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaCfmAdjustmentDBDAOInsertSaqMonCfmTgtVvd0167CSQL").append("\n"); 
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
		query.append("MERGE INTO SAQ_MON_CFM_TGT_VVD A" ).append("\n"); 
		query.append(" USING (" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("			@[mqta_rlse_ver_no] AS MQTA_RLSE_VER_NO, " ).append("\n"); 
		query.append("			@[bse_yr] AS BSE_YR       , " ).append("\n"); 
		query.append("			@[bse_qtr_cd] AS BSE_QTR_CD , " ).append("\n"); 
		query.append("			@[bse_mon] AS BSE_MON             ," ).append("\n"); 
		query.append("			@[bse_wk] AS BSE_WK          , " ).append("\n"); 
		query.append("			@[trd_cd] AS TRD_CD       , " ).append("\n"); 
		query.append("			@[new_rlane_cd] AS RLANE_CD   , " ).append("\n"); 
		query.append("			@[dir_cd] AS DIR_CD              ," ).append("\n"); 
		query.append("			@[sub_trd_cd] AS SUB_TRD_CD      , " ).append("\n"); 
		query.append("			@[vsl_cd] AS VSL_CD       , " ).append("\n"); 
		query.append("			@[skd_voy_no] AS SKD_VOY_NO , " ).append("\n"); 
		query.append("			@[skd_dir_cd] AS SKD_DIR_CD          ," ).append("\n"); 
		query.append("			'X' AS SPRT_GRP_CD   ," ).append("\n"); 
		query.append("			'00' AS BSA_GRP_CD, " ).append("\n"); 
		query.append("			@[ioc_cd] AS IOC_CD     ," ).append("\n"); 
		query.append("			NVL(@[bsa_capa], 0) AS FNL_BSA_CAPA," ).append("\n"); 
		query.append("			TO_DATE(@[lst_lodg_port_etd_dt], 'RRRR-MM-DD HH24:MI:SS') AS LST_LODG_PORT_ETD_DT, " ).append("\n"); 
		query.append("			@[vvd_seq] AS VVD_SEQ             ," ).append("\n"); 
		query.append("			DECODE(MIN(CONV_DIR_CD),'',	@[dir_cd], 	MIN(conv_dir_cd)) AS CONV_DIR_CD," ).append("\n"); 
		query.append("			@[cre_usr_id] AS CRE_USR_ID      ,  " ).append("\n"); 
		query.append("			@[upd_usr_id] AS upd_usr_id" ).append("\n"); 
		query.append("           FROM SAQ_MON_DIR_CONV" ).append("\n"); 
		query.append("          WHERE BSE_YR     = @[bse_yr]" ).append("\n"); 
		query.append("            AND BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append("            AND TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("            AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("            AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("            AND RLANE_CD   = @[new_rlane_cd]  ) B" ).append("\n"); 
		query.append("    ON (" ).append("\n"); 
		query.append("             A.MQTA_RLSE_VER_NO = B.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("            AND A.BSE_YR           = B.BSE_YR" ).append("\n"); 
		query.append("            AND A.BSE_QTR_CD       = B.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND A.TRD_CD           = B.TRD_CD" ).append("\n"); 
		query.append("            AND A.RLANE_CD         = B.RLANE_CD" ).append("\n"); 
		query.append("            AND A.DIR_CD           = B.DIR_CD" ).append("\n"); 
		query.append("            AND A.VSL_CD           = B.VSL_CD" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO       = B.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD       = B.SKD_DIR_CD  " ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("        WHEN MATCHED THEN" ).append("\n"); 
		query.append("            UPDATE SET A.BSE_MON              = B.BSE_MON             ," ).append("\n"); 
		query.append("                       A.BSE_WK               = B.BSE_WK              ," ).append("\n"); 
		query.append("                       A.LST_LODG_PORT_ETD_DT = B.LST_LODG_PORT_ETD_DT," ).append("\n"); 
		query.append("                       A.UPD_USR_ID           = B.UPD_USR_ID          ," ).append("\n"); 
		query.append("                       A.UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("        WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("            INSERT (" ).append("\n"); 
		query.append("                     A.MQTA_RLSE_VER_NO    , A.BSE_YR    , A.BSE_QTR_CD , A.BSE_MON     ," ).append("\n"); 
		query.append("                     A.BSE_WK              , A.TRD_CD    , A.RLANE_CD   , A.DIR_CD      ," ).append("\n"); 
		query.append("                     A.SUB_TRD_CD          , A.VSL_CD    , A.SKD_VOY_NO , A.SKD_DIR_CD  ," ).append("\n"); 
		query.append("                     A.SPRT_GRP_CD         , A.BSA_GRP_CD, A.IOC_CD     , A.FNL_BSA_CAPA," ).append("\n"); 
		query.append("                     A.LST_LODG_PORT_ETD_DT, A.VVD_SEQ   , A.CONV_DIR_CD," ).append("\n"); 
		query.append("                     A.CRE_USR_ID          , A.CRE_DT    , A.UPD_USR_ID , A.UPD_DT  )" ).append("\n"); 
		query.append("            VALUES (" ).append("\n"); 
		query.append("                     B.MQTA_RLSE_VER_NO    , B.BSE_YR    , B.BSE_QTR_CD , B.BSE_MON     ," ).append("\n"); 
		query.append("                     B.BSE_WK              , B.TRD_CD    , B.RLANE_CD   , B.DIR_CD      ," ).append("\n"); 
		query.append("                     B.SUB_TRD_CD          , B.VSL_CD    , B.SKD_VOY_NO , B.SKD_DIR_CD  ," ).append("\n"); 
		query.append("                     B.SPRT_GRP_CD         , B.BSA_GRP_CD, B.IOC_CD     , B.FNL_BSA_CAPA," ).append("\n"); 
		query.append("                     B.LST_LODG_PORT_ETD_DT, B.VVD_SEQ   , B.CONV_DIR_CD," ).append("\n"); 
		query.append("                     B.CRE_USR_ID          , SYSDATE     , B.UPD_USR_ID , SYSDATE  )" ).append("\n"); 

	}
}