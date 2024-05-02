/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPodSmp042CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.04
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.04 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN JA YOUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPodSmp042CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_CUST_POL_POD 의 지정된 ibflag 값에 따라 SPC_ALOC_POL_POD DB에 반영한다.(입력)
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * [CHM-201324211-01] SLS_OFC_CD 관련 로직 수정
	  * 2013.08.13 진마리아 [trouble shooting] 성수기 Alloc 저장시 비수기로 말아올리는 과정에 mnl_aloc_rmk 가 3으로 하드코딩된 것 수정
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPodSmp042CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("account_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_aloc_pod_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnl_aloc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spc_ctrl_aloc_pol_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPodSmp042CSQL").append("\n"); 
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
		query.append("MERGE INTO SPC_ALOC_POL_POD T" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("         SELECT RLANE_CD      ," ).append("\n"); 
		query.append("                DIR_CD        ," ).append("\n"); 
		query.append("                VSL_CD        ," ).append("\n"); 
		query.append("                SKD_VOY_NO    ," ).append("\n"); 
		query.append("                SKD_DIR_CD    ," ).append("\n"); 
		query.append("                SLS_OFC_CD    ," ).append("\n"); 
		query.append("                POL_YD_CD     ," ).append("\n"); 
		query.append("                POD_YD_CD     ," ).append("\n"); 
		query.append("                TS_FLG        ," ).append("\n"); 
		query.append("                MNL_FLG       ," ).append("\n"); 
		query.append("                -- 2014.08.06 컬럼 추가" ).append("\n"); 
		query.append("                CUST_CNT_CD   ," ).append("\n"); 
		query.append("                CUST_SEQ      ," ).append("\n"); 
		query.append("                CTRT_NO       ," ).append("\n"); 
		query.append("                USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                DEST_LOC_CD   ," ).append("\n"); 
		query.append("                --" ).append("\n"); 
		query.append("                REP_TRD_CD    ," ).append("\n"); 
		query.append("                REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                TRD_CD        ," ).append("\n"); 
		query.append("                SUB_TRD_CD    ," ).append("\n"); 
		query.append("                IOC_CD        ," ).append("\n"); 
		query.append("                SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                SLS_AQ_CD     ," ).append("\n"); 
		query.append("                SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                @[mnl_aloc_rmk] AS MNL_ALOC_RMK," ).append("\n"); 
		query.append("                @[upd_usr_id]  AS ALOC_USR_ID ," ).append("\n"); 
		query.append("                CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS ALOC_GDT," ).append("\n"); 
		query.append("                SUM(ASGN_TTL_QTY)         AS ASGN_TTL_QTY         ," ).append("\n"); 
		query.append("                SUM(ASGN_20FT_QTY)        AS ASGN_20FT_QTY        ," ).append("\n"); 
		query.append("                SUM(ASGN_40FT_QTY)        AS ASGN_40FT_QTY        ," ).append("\n"); 
		query.append("                SUM(ASGN_40FT_HC_QTY)     AS ASGN_40FT_HC_QTY     ," ).append("\n"); 
		query.append("                SUM(ASGN_45FT_HC_QTY)     AS ASGN_45FT_HC_QTY     ," ).append("\n"); 
		query.append("                SUM(ASGN_53FT_QTY)        AS ASGN_53FT_QTY        ," ).append("\n"); 
		query.append("                SUM(ASGN_RF_QTY)          AS ASGN_RF_QTY          ," ).append("\n"); 
		query.append("                SUM(ASGN_TTL_WGT)         AS ASGN_TTL_WGT         ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_TTL_QTY)     AS BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_20FT_QTY)    AS BKG_AVAL_20FT_QTY    ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_40FT_QTY)    AS BKG_AVAL_40FT_QTY    ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_40FT_HC_QTY) AS BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_45FT_HC_QTY) AS BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_53FT_QTY)    AS BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_RF_QTY)      AS BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_TTL_WGT)     AS BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("                SUM(FCAST_TTL_QTY)        AS FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("                SUM(FCAST_40FT_HC_QTY)    AS FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("                SUM(FCAST_45FT_HC_QTY)    AS FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("                SUM(FCAST_53FT_QTY)       AS FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("                SUM(FCAST_RF_QTY)         AS FCAST_RF_QTY         ," ).append("\n"); 
		query.append("                SUM(FCAST_TTL_WGT)        AS FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("                SUM(USD_BKG_TTL_QTY)      AS USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("                SUM(USD_BKG_20FT_QTY)     AS USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("                SUM(USD_BKG_40FT_QTY)     AS USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("                SUM(USD_BKG_40FT_HC_QTY)  AS USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                SUM(USD_BKG_45FT_HC_QTY)  AS USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                SUM(USD_BKG_53FT_QTY)     AS USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("                SUM(USD_BKG_RF_QTY)       AS USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("                SUM(USD_BKG_TTL_WGT)      AS USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("                @[spc_ctrl_aloc_rmk]      AS SPC_CTRL_ALOC_RMK    ," ).append("\n"); 
		query.append("                @[spc_ctrl_aloc_pol_rmk]  AS SPC_CTRL_ALOC_POL_RMK," ).append("\n"); 
		query.append("                @[spc_ctrl_aloc_pod_rmk]  AS SPC_CTRL_ALOC_POD_RMK," ).append("\n"); 
		query.append("                @[upd_usr_id]             AS CRE_USR_ID           ," ).append("\n"); 
		query.append("                SYSDATE                   AS CRE_DT               ," ).append("\n"); 
		query.append("                @[upd_usr_id]             AS UPD_USR_ID           ," ).append("\n"); 
		query.append("                SYSDATE                   AS UPD_DT               ," ).append("\n"); 
		query.append("                --2014.08.06 컬럼추가" ).append("\n"); 
		query.append("                SUM(ASGN_20FT_DRY_QTY)    AS ASGN_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("                SUM(ASGN_40FT_DRY_QTY)    AS ASGN_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("                SUM(ASGN_RD_QTY)          AS ASGN_RD_QTY          ," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_20FT_DRY_QTY) AS BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_40FT_DRY_QTY) AS BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("                SUM(BKG_AVAL_RD_QTY)       AS BKG_AVAL_RD_QTY      ," ).append("\n"); 
		query.append("                SUM(FCAST_20FT_DRY_QTY)   AS FCAST_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("                SUM(FCAST_40FT_DRY_QTY)   AS FCAST_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("                SUM(FCAST_RD_QTY)         AS FCAST_RD_QTY          ," ).append("\n"); 
		query.append("                SUM(USD_BKG_20FT_DRY_QTY) AS USD_BKG_20FT_DRY_QTY  ," ).append("\n"); 
		query.append("                SUM(USD_BKG_40FT_DRY_QTY) AS USD_BKG_40FT_DRY_QTY  ," ).append("\n"); 
		query.append("                SUM(USD_BKG_RD_QTY)       AS USD_BKG_RD_QTY        " ).append("\n"); 
		query.append("           FROM SPC_ALOC_CUST_POL_POD" ).append("\n"); 
		query.append("          WHERE RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("            AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("            AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("            AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("            AND SLS_OFC_CD = DECODE(TS_FLG, 'Y', NVL(@[sls_ofc_cd], @[sls_rhq_cd]), @[sls_ofc_cd])" ).append("\n"); 
		query.append("            AND POL_YD_CD  = NVL(@[pol_cd], '0000000')" ).append("\n"); 
		query.append("            AND POD_YD_CD  = NVL(@[pod_cd], '0000000')" ).append("\n"); 
		query.append("            AND TS_FLG     = @[ts_flg]" ).append("\n"); 
		query.append("            AND MNL_FLG    = @[mnl_flg]" ).append("\n"); 
		query.append("            AND IOC_CD     = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 
		query.append("            --2014.08.06 조건추가" ).append("\n"); 
		query.append("            AND DEST_LOC_CD  = DECODE(NVL(@[del_cd], '00000'), 'OTHERS', 'XXXXX', NVL(@[del_cd], '00000')) " ).append("\n"); 
		query.append("            AND USA_BKG_MOD_CD = DECODE(NVL(@[us_mod], '00000'), 'OTHERS', 'OTH', NVL(@[us_mod], '00000'))" ).append("\n"); 
		query.append("            AND CUST_CNT_CD||LPAD(CUST_SEQ, 6, '0') = DECODE(NVL(@[account_cd], '00000000'), 'OTHERS', 'XX999999', NVL(@[account_cd], '00000000'))" ).append("\n"); 
		query.append("            AND CTRT_NO  = NVL(@[ctrt_no], '0')" ).append("\n"); 
		query.append("       GROUP BY RLANE_CD      ," ).append("\n"); 
		query.append("                DIR_CD        ," ).append("\n"); 
		query.append("                VSL_CD        ," ).append("\n"); 
		query.append("                SKD_VOY_NO    ," ).append("\n"); 
		query.append("                SKD_DIR_CD    ," ).append("\n"); 
		query.append("                SLS_OFC_CD    ," ).append("\n"); 
		query.append("                POL_YD_CD     ," ).append("\n"); 
		query.append("                POD_YD_CD     ," ).append("\n"); 
		query.append("                TS_FLG        ," ).append("\n"); 
		query.append("                MNL_FLG       ," ).append("\n"); 
		query.append("                -- 2014.08.06 컬럼 추가" ).append("\n"); 
		query.append("                CUST_CNT_CD   ," ).append("\n"); 
		query.append("                CUST_SEQ      ," ).append("\n"); 
		query.append("                CTRT_NO	      ," ).append("\n"); 
		query.append("                USA_BKG_MOD_CD," ).append("\n"); 
		query.append("                DEST_LOC_CD   ," ).append("\n"); 
		query.append("                REP_TRD_CD    ," ).append("\n"); 
		query.append("                REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                TRD_CD        ," ).append("\n"); 
		query.append("                SUB_TRD_CD    ," ).append("\n"); 
		query.append("                IOC_CD        ," ).append("\n"); 
		query.append("                SLS_RHQ_CD    ," ).append("\n"); 
		query.append("                SLS_AQ_CD     ," ).append("\n"); 
		query.append("                SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("      ) C" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("             T.RLANE_CD     = C.RLANE_CD" ).append("\n"); 
		query.append("         AND T.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("         AND T.VSL_CD       = C.VSL_CD" ).append("\n"); 
		query.append("         AND T.SKD_VOY_NO   = C.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND T.SKD_DIR_CD   = C.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND T.SLS_OFC_CD   = C.SLS_OFC_CD" ).append("\n"); 
		query.append("         AND T.POL_YD_CD    = C.POL_YD_CD" ).append("\n"); 
		query.append("         AND T.POD_YD_CD    = C.POD_YD_CD" ).append("\n"); 
		query.append("         AND T.TS_FLG       = C.TS_FLG" ).append("\n"); 
		query.append("         AND T.MNL_FLG      = C.MNL_FLG" ).append("\n"); 
		query.append("         AND T.IOC_CD       = C.IOC_CD" ).append("\n"); 
		query.append("         -- 2014.08.06 컬럼 추가" ).append("\n"); 
		query.append("         AND T.DEST_LOC_CD  = C.DEST_LOC_CD" ).append("\n"); 
		query.append("         AND T.USA_BKG_MOD_CD  = C.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("         AND T.CUST_CNT_CD  = C.CUST_CNT_CD" ).append("\n"); 
		query.append("         AND T.CUST_SEQ     = C.CUST_SEQ" ).append("\n"); 
		query.append("         AND T.CTRT_NO      = C.CTRT_NO" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("       SET T.ASGN_TTL_QTY          = C.ASGN_TTL_QTY         ," ).append("\n"); 
		query.append("           T.ASGN_20FT_QTY         = C.ASGN_20FT_QTY        ," ).append("\n"); 
		query.append("           T.ASGN_40FT_QTY         = C.ASGN_40FT_QTY        ," ).append("\n"); 
		query.append("           T.ASGN_40FT_HC_QTY      = C.ASGN_40FT_HC_QTY     ," ).append("\n"); 
		query.append("           T.ASGN_45FT_HC_QTY      = C.ASGN_45FT_HC_QTY     ," ).append("\n"); 
		query.append("           T.ASGN_53FT_QTY         = C.ASGN_53FT_QTY        ," ).append("\n"); 
		query.append("           T.ASGN_RF_QTY           = C.ASGN_RF_QTY          ," ).append("\n"); 
		query.append("           T.ASGN_TTL_WGT          = C.ASGN_TTL_WGT         ," ).append("\n"); 
		query.append("           T.BKG_AVAL_TTL_QTY      = C.BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("           T.BKG_AVAL_20FT_QTY     = C.BKG_AVAL_20FT_QTY    ," ).append("\n"); 
		query.append("           T.BKG_AVAL_40FT_QTY     = C.BKG_AVAL_40FT_QTY    ," ).append("\n"); 
		query.append("           T.BKG_AVAL_40FT_HC_QTY  = C.BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("           T.BKG_AVAL_45FT_HC_QTY  = C.BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("           T.BKG_AVAL_53FT_QTY     = C.BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("           T.BKG_AVAL_RF_QTY       = C.BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("           T.BKG_AVAL_TTL_WGT      = C.BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("           T.FCAST_TTL_QTY         = C.FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("           T.FCAST_40FT_HC_QTY     = C.FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("           T.FCAST_45FT_HC_QTY     = C.FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("           T.FCAST_53FT_QTY        = C.FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("           T.FCAST_RF_QTY          = C.FCAST_RF_QTY         ," ).append("\n"); 
		query.append("           T.FCAST_TTL_WGT         = C.FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("           T.USD_BKG_TTL_QTY       = C.USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("           T.USD_BKG_20FT_QTY      = C.USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("           T.USD_BKG_40FT_QTY      = C.USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("           T.USD_BKG_40FT_HC_QTY   = C.USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("           T.USD_BKG_45FT_HC_QTY   = C.USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("           T.USD_BKG_53FT_QTY      = C.USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("           T.USD_BKG_RF_QTY        = C.USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("           T.USD_BKG_TTL_WGT       = C.USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("           T.SPC_CTRL_ALOC_RMK     = C.SPC_CTRL_ALOC_RMK    ," ).append("\n"); 
		query.append("           T.SPC_CTRL_ALOC_POL_RMK = C.SPC_CTRL_ALOC_POL_RMK," ).append("\n"); 
		query.append("           T.SPC_CTRL_ALOC_POD_RMK = C.SPC_CTRL_ALOC_POD_RMK," ).append("\n"); 
		query.append("           T.ALOC_USR_ID           = C.ALOC_USR_ID          ," ).append("\n"); 
		query.append("           T.MNL_ALOC_RMK          = C.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("           T.ALOC_GDT              = C.ALOC_GDT             ," ).append("\n"); 
		query.append("           T.UPD_USR_ID            = C.UPD_USR_ID           ," ).append("\n"); 
		query.append("           T.UPD_DT                = C.UPD_DT		    ," ).append("\n"); 
		query.append("           --2014.08.06 컬럼추가" ).append("\n"); 
		query.append("           T.ASGN_20FT_DRY_QTY     = C.ASGN_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("           T.ASGN_40FT_DRY_QTY     = C.ASGN_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("           T.ASGN_RD_QTY     	   = C.ASGN_RD_QTY          ," ).append("\n"); 
		query.append("           T.BKG_AVAL_20FT_DRY_QTY = C.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("           T.BKG_AVAL_40FT_DRY_QTY = C.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("           T.BKG_AVAL_RD_QTY       = C.BKG_AVAL_RD_QTY      ," ).append("\n"); 
		query.append("           T.FCAST_20FT_DRY_QTY    = C.FCAST_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("           T.FCAST_40FT_DRY_QTY    = C.FCAST_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("           T.FCAST_RD_QTY          = C.FCAST_RD_QTY         ," ).append("\n"); 
		query.append("           T.USD_BKG_20FT_DRY_QTY  = C.USD_BKG_20FT_DRY_QTY ," ).append("\n"); 
		query.append("           T.USD_BKG_40FT_DRY_QTY  = C.USD_BKG_40FT_DRY_QTY ," ).append("\n"); 
		query.append("           T.USD_BKG_RD_QTY        = C.USD_BKG_RD_QTY           " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("              RLANE_CD             ," ).append("\n"); 
		query.append("              DIR_CD               ," ).append("\n"); 
		query.append("              VSL_CD               ," ).append("\n"); 
		query.append("              SKD_VOY_NO           ," ).append("\n"); 
		query.append("              SKD_DIR_CD           ," ).append("\n"); 
		query.append("              SLS_OFC_CD           ," ).append("\n"); 
		query.append("              POL_YD_CD            ," ).append("\n"); 
		query.append("              POD_YD_CD            ," ).append("\n"); 
		query.append("              TS_FLG               ," ).append("\n"); 
		query.append("              MNL_FLG              ," ).append("\n"); 
		query.append("              -- 2014.08.06 컬럼 추가" ).append("\n"); 
		query.append("              CUST_CNT_CD          ," ).append("\n"); 
		query.append("              CUST_SEQ             ," ).append("\n"); 
		query.append("              CTRT_NO              ," ).append("\n"); 
		query.append("              USA_BKG_MOD_CD       ," ).append("\n"); 
		query.append("              DEST_LOC_CD   	   ," ).append("\n"); 
		query.append("              --" ).append("\n"); 
		query.append("              REP_TRD_CD           ," ).append("\n"); 
		query.append("              REP_SUB_TRD_CD       ," ).append("\n"); 
		query.append("              TRD_CD               ," ).append("\n"); 
		query.append("              SUB_TRD_CD           ," ).append("\n"); 
		query.append("              IOC_CD               ," ).append("\n"); 
		query.append("              SLS_RHQ_CD           ," ).append("\n"); 
		query.append("              SLS_AQ_CD            ," ).append("\n"); 
		query.append("              SLS_RGN_OFC_CD       ," ).append("\n"); 
		query.append("              ASGN_TTL_QTY         ," ).append("\n"); 
		query.append("              ASGN_20FT_QTY        ," ).append("\n"); 
		query.append("              ASGN_40FT_QTY        ," ).append("\n"); 
		query.append("              ASGN_40FT_HC_QTY     ," ).append("\n"); 
		query.append("              ASGN_45FT_HC_QTY     ," ).append("\n"); 
		query.append("              ASGN_53FT_QTY        ," ).append("\n"); 
		query.append("              ASGN_RF_QTY          ," ).append("\n"); 
		query.append("              ASGN_TTL_WGT         ," ).append("\n"); 
		query.append("              BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("              BKG_AVAL_20FT_QTY    ," ).append("\n"); 
		query.append("              BKG_AVAL_40FT_QTY    ," ).append("\n"); 
		query.append("              BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("              BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("              BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("              BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("              BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("              FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("              FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("              FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("              FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("              FCAST_RF_QTY         ," ).append("\n"); 
		query.append("              FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("              USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("              USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("              USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("              USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("              USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("              USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("              USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("              USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("              SPC_CTRL_ALOC_RMK    ," ).append("\n"); 
		query.append("              SPC_CTRL_ALOC_POL_RMK," ).append("\n"); 
		query.append("              SPC_CTRL_ALOC_POD_RMK," ).append("\n"); 
		query.append("              MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("              ALOC_USR_ID          ," ).append("\n"); 
		query.append("              ALOC_GDT             ," ).append("\n"); 
		query.append("              CRE_USR_ID           ," ).append("\n"); 
		query.append("              CRE_DT               ," ).append("\n"); 
		query.append("              UPD_USR_ID           ," ).append("\n"); 
		query.append("              UPD_DT               ," ).append("\n"); 
		query.append("              --2014.08.06 컬럼추가" ).append("\n"); 
		query.append("              ASGN_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("              ASGN_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("              ASGN_RD_QTY          ," ).append("\n"); 
		query.append("              BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("              BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("              BKG_AVAL_RD_QTY      ," ).append("\n"); 
		query.append("              FCAST_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("              FCAST_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("              FCAST_RD_QTY         ," ).append("\n"); 
		query.append("              USD_BKG_20FT_DRY_QTY ," ).append("\n"); 
		query.append("              USD_BKG_40FT_DRY_QTY ," ).append("\n"); 
		query.append("              USD_BKG_RD_QTY        " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("              C.RLANE_CD             ," ).append("\n"); 
		query.append("              C.DIR_CD               ," ).append("\n"); 
		query.append("              C.VSL_CD               ," ).append("\n"); 
		query.append("              C.SKD_VOY_NO           ," ).append("\n"); 
		query.append("              C.SKD_DIR_CD           ," ).append("\n"); 
		query.append("              C.SLS_OFC_CD           ," ).append("\n"); 
		query.append("              C.POL_YD_CD            ," ).append("\n"); 
		query.append("              C.POD_YD_CD            ," ).append("\n"); 
		query.append("              C.TS_FLG               ," ).append("\n"); 
		query.append("              C.MNL_FLG              ," ).append("\n"); 
		query.append("              -- 2014.08.06 컬럼 추가" ).append("\n"); 
		query.append("              C.CUST_CNT_CD          ," ).append("\n"); 
		query.append("              C.CUST_SEQ             ," ).append("\n"); 
		query.append("              C.CTRT_NO              ," ).append("\n"); 
		query.append("              C.USA_BKG_MOD_CD       ," ).append("\n"); 
		query.append("              C.DEST_LOC_CD   	     ," ).append("\n"); 
		query.append("              --" ).append("\n"); 
		query.append("              C.REP_TRD_CD           ," ).append("\n"); 
		query.append("              C.REP_SUB_TRD_CD       ," ).append("\n"); 
		query.append("              C.TRD_CD               ," ).append("\n"); 
		query.append("              C.SUB_TRD_CD           ," ).append("\n"); 
		query.append("              C.IOC_CD               ," ).append("\n"); 
		query.append("              C.SLS_RHQ_CD           ," ).append("\n"); 
		query.append("              C.SLS_AQ_CD            ," ).append("\n"); 
		query.append("              C.SLS_RGN_OFC_CD       ," ).append("\n"); 
		query.append("              C.ASGN_TTL_QTY         ," ).append("\n"); 
		query.append("              C.ASGN_20FT_QTY        ," ).append("\n"); 
		query.append("              C.ASGN_40FT_QTY        ," ).append("\n"); 
		query.append("              C.ASGN_40FT_HC_QTY     ," ).append("\n"); 
		query.append("              C.ASGN_45FT_HC_QTY     ," ).append("\n"); 
		query.append("              C.ASGN_53FT_QTY        ," ).append("\n"); 
		query.append("              C.ASGN_RF_QTY          ," ).append("\n"); 
		query.append("              C.ASGN_TTL_WGT         ," ).append("\n"); 
		query.append("              C.BKG_AVAL_TTL_QTY     ," ).append("\n"); 
		query.append("              C.BKG_AVAL_20FT_QTY    ," ).append("\n"); 
		query.append("              C.BKG_AVAL_40FT_QTY    ," ).append("\n"); 
		query.append("              C.BKG_AVAL_40FT_HC_QTY ," ).append("\n"); 
		query.append("              C.BKG_AVAL_45FT_HC_QTY ," ).append("\n"); 
		query.append("              C.BKG_AVAL_53FT_QTY    ," ).append("\n"); 
		query.append("              C.BKG_AVAL_RF_QTY      ," ).append("\n"); 
		query.append("              C.BKG_AVAL_TTL_WGT     ," ).append("\n"); 
		query.append("              C.FCAST_TTL_QTY        ," ).append("\n"); 
		query.append("              C.FCAST_40FT_HC_QTY    ," ).append("\n"); 
		query.append("              C.FCAST_45FT_HC_QTY    ," ).append("\n"); 
		query.append("              C.FCAST_53FT_QTY       ," ).append("\n"); 
		query.append("              C.FCAST_RF_QTY         ," ).append("\n"); 
		query.append("              C.FCAST_TTL_WGT        ," ).append("\n"); 
		query.append("              C.USD_BKG_TTL_QTY      ," ).append("\n"); 
		query.append("              C.USD_BKG_20FT_QTY     ," ).append("\n"); 
		query.append("              C.USD_BKG_40FT_QTY     ," ).append("\n"); 
		query.append("              C.USD_BKG_40FT_HC_QTY  ," ).append("\n"); 
		query.append("              C.USD_BKG_45FT_HC_QTY  ," ).append("\n"); 
		query.append("              C.USD_BKG_53FT_QTY     ," ).append("\n"); 
		query.append("              C.USD_BKG_RF_QTY       ," ).append("\n"); 
		query.append("              C.USD_BKG_TTL_WGT      ," ).append("\n"); 
		query.append("              C.SPC_CTRL_ALOC_RMK    ," ).append("\n"); 
		query.append("              C.SPC_CTRL_ALOC_POL_RMK," ).append("\n"); 
		query.append("              C.SPC_CTRL_ALOC_POD_RMK," ).append("\n"); 
		query.append("              C.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("              C.ALOC_USR_ID          ," ).append("\n"); 
		query.append("              C.ALOC_GDT             ," ).append("\n"); 
		query.append("              C.CRE_USR_ID           ," ).append("\n"); 
		query.append("              C.CRE_DT               ," ).append("\n"); 
		query.append("              C.UPD_USR_ID           ," ).append("\n"); 
		query.append("              C.UPD_DT               ," ).append("\n"); 
		query.append("              --2014.08.06 컬럼추가" ).append("\n"); 
		query.append("              C.ASGN_20FT_DRY_QTY    ," ).append("\n"); 
		query.append("              C.ASGN_40FT_DRY_QTY    ," ).append("\n"); 
		query.append("              C.ASGN_RD_QTY          ," ).append("\n"); 
		query.append("              C.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("              C.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("              C.BKG_AVAL_RD_QTY      ," ).append("\n"); 
		query.append("              C.FCAST_20FT_DRY_QTY   ," ).append("\n"); 
		query.append("              C.FCAST_40FT_DRY_QTY   ," ).append("\n"); 
		query.append("              C.FCAST_RD_QTY         ," ).append("\n"); 
		query.append("              C.USD_BKG_20FT_DRY_QTY ," ).append("\n"); 
		query.append("              C.USD_BKG_40FT_DRY_QTY ," ).append("\n"); 
		query.append("              C.USD_BKG_RD_QTY      " ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}