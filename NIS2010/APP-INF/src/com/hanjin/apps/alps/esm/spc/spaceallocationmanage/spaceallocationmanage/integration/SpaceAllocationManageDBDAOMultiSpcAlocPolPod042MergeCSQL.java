/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod042MergeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.23
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.01.23 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod042MergeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * 2011.01.05 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * 2013.03.22 김시몬 [CHM-201322502] 성수기 선복운영 개선을 위한 T/F추진 MDM_DTL_REV_LANE 삭제체크 추가
	  * ESM_SPC_0042에서 save시 중복 에러가 발생해서 SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL를 copy하여 Merge문으로 수정함.
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod042MergeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("us_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asgn_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod042MergeCSQL").append("\n"); 
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
		query.append("merge into SPC_ALOC_POL_POD a" ).append("\n"); 
		query.append("using (" ).append("\n"); 
		query.append("WITH PARAMS AS (" ).append("\n"); 
		query.append("    SELECT  @[trd_cd]     AS TRD_CD    ," ).append("\n"); 
		query.append("            @[sub_trd_cd] AS SUB_TRD_CD," ).append("\n"); 
		query.append("            @[rlane_cd]   AS RLANE_CD  ," ).append("\n"); 
		query.append("            @[dir_cd]     AS DIR_CD    ," ).append("\n"); 
		query.append("            @[vsl_cd]     AS VSL_CD    ," ).append("\n"); 
		query.append("            @[skd_voy_no] AS SKD_VOY_NO," ).append("\n"); 
		query.append("            @[skd_dir_cd] AS SKD_DIR_CD," ).append("\n"); 
		query.append("            @[sls_ofc_cd] AS SLS_OFC_CD," ).append("\n"); 
		query.append("            @[pol_cd]     AS POL_YD_CD ," ).append("\n"); 
		query.append("            @[pod_cd]     AS POD_YD_CD ," ).append("\n"); 
		query.append("            @[ts_flg]     AS TS_FLG    ," ).append("\n"); 
		query.append("            @[mnl_flg]    AS MNL_FLG   ," ).append("\n"); 
		query.append("            DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I') AS IOC_CD," ).append("\n"); 
		query.append("            @[sls_rhq_cd]          AS SLS_RHQ_CD         ," ).append("\n"); 
		query.append("            @[asgn_ttl_qty]        AS ASGN_TTL           ," ).append("\n"); 
		query.append("            @[asgn_20ft_qty]       AS ASGN_20            ," ).append("\n"); 
		query.append("            @[asgn_40ft_qty]       AS ASGN_40            ," ).append("\n"); 
		query.append("            @[asgn_40ft_hc_qty]    AS ASGN_HC            ," ).append("\n"); 
		query.append("            @[asgn_45ft_hc_qty]    AS ASGN_45            ," ).append("\n"); 
		query.append("            @[asgn_53ft_qty]       AS ASGN_53            ," ).append("\n"); 
		query.append("            @[asgn_rf_qty]         AS ASGN_RF            ," ).append("\n"); 
		query.append("            @[asgn_ttl_wgt]        AS ASGN_WGT           ," ).append("\n"); 
		query.append("            @[fcast_ttl_qty]       AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("            @[fcast_40ft_hc_qty]   AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("            @[fcast_45ft_hc_qty]   AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("            @[fcast_53ft_qty]      AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("            @[fcast_rf_qty]        AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("            @[fcast_ttl_wgt]       AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("            @[usd_bkg_ttl_qty]     AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("            @[usd_bkg_20ft_qty]    AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("            @[usd_bkg_40ft_qty]    AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("            @[usd_bkg_40ft_hc_qty] AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("            @[usd_bkg_45ft_hc_qty] AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("            @[usd_bkg_53ft_qty]    AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("            @[usd_bkg_rf_qty]      AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("            @[usd_bkg_ttl_wgt]     AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("            '3'                    AS MNL_ALOC_RMK       ," ).append("\n"); 
		query.append("            @[upd_usr_id]          AS USR_ID             ," ).append("\n"); 
		query.append("            CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS ALOC_GDT," ).append("\n"); 
		query.append("            SYSDATE AS DT," ).append("\n"); 
		query.append("            DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2)) AS CUST_CNT_CD," ).append("\n"); 
		query.append("            DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6)) AS CUST_SEQ," ).append("\n"); 
		query.append("            DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod]) USA_BKG_MOD_CD," ).append("\n"); 
		query.append("            DECODE(NVL(@[del_cd], '00000') , '1', '00000', '00000', '00000', 'OTHERS', 'XXXXX', @[del_cd]) AS DEST_LOC_CD," ).append("\n"); 
		query.append("            @[asgn_d2_qty]  AS ASGN_D2," ).append("\n"); 
		query.append("            @[asgn_d4_qty]  AS ASGN_D4," ).append("\n"); 
		query.append("            @[asgn_rd_qty]  AS ASGN_RD," ).append("\n"); 
		query.append("            @[fcast_d2_qty] AS FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("            @[fcast_d4_qty] AS FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("            @[fcast_rd_qty] AS FCAST_RD_QTY," ).append("\n"); 
		query.append("            @[usd_bkg_d2_qty]      AS USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("            @[usd_bkg_d4_qty]      AS USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("            @[usd_bkg_rd_qty]      AS USD_BKG_RD_QTY," ).append("\n"); 
		query.append("            @[ctrt_no]      	   AS CTRT_NO" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT Z.RLANE_CD      ," ).append("\n"); 
		query.append("         Z.DIR_CD        ," ).append("\n"); 
		query.append("         Z.VSL_CD        ," ).append("\n"); 
		query.append("         Z.SKD_VOY_NO    ," ).append("\n"); 
		query.append("         Z.SKD_DIR_CD    ," ).append("\n"); 
		query.append("         Z.SLS_OFC_CD    ," ).append("\n"); 
		query.append("         Z.POL_YD_CD     ," ).append("\n"); 
		query.append("         Z.POD_YD_CD     ," ).append("\n"); 
		query.append("         Z.TS_FLG        ," ).append("\n"); 
		query.append("         Z.MNL_FLG       ," ).append("\n"); 
		query.append("         Z.REP_TRD_CD    ," ).append("\n"); 
		query.append("         Z.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         Z.TRD_CD        ," ).append("\n"); 
		query.append("         Z.SUB_TRD_CD    ," ).append("\n"); 
		query.append("         Z.IOC_CD        ," ).append("\n"); 
		query.append("         Z.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("         Z.SLS_AQ_CD     ," ).append("\n"); 
		query.append("         Z.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         Z.ASGN_TTL AS ASGN_TTL_QTY    ," ).append("\n"); 
		query.append("         0          AS ASGN_20FT_QTY   ," ).append("\n"); 
		query.append("         0          AS ASGN_40FT_QTY   ," ).append("\n"); 
		query.append("         Z.ASGN_HC  AS ASGN_40FT_HC_QTY," ).append("\n"); 
		query.append("         Z.ASGN_45  AS ASGN_45FT_HC_QTY," ).append("\n"); 
		query.append("         Z.ASGN_53  AS ASGN_53FT_QTY   ," ).append("\n"); 
		query.append("         Z.ASGN_RF  AS ASGN_RF_QTY     ," ).append("\n"); 
		query.append("         Z.ASGN_WGT AS ASGN_TTL_WGT    ," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_TTL, NULL) AS BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("         NULL AS BKG_AVAL_20FT_QTY," ).append("\n"); 
		query.append("         NULL AS BKG_AVAL_40FT_QTY," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_HC , NULL) AS BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_45 , NULL) AS BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_53 , NULL) AS BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_RF , NULL) AS BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_WGT, NULL) AS BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("         FCAST_TTL_QTY          ," ).append("\n"); 
		query.append("         FCAST_40FT_HC_QTY      ," ).append("\n"); 
		query.append("         FCAST_45FT_HC_QTY      ," ).append("\n"); 
		query.append("         FCAST_53FT_QTY         ," ).append("\n"); 
		query.append("         FCAST_RF_QTY           ," ).append("\n"); 
		query.append("         FCAST_TTL_WGT          ," ).append("\n"); 
		query.append("         USD_BKG_TTL_QTY        ," ).append("\n"); 
		query.append("         USD_BKG_20FT_QTY       ," ).append("\n"); 
		query.append("         USD_BKG_40FT_QTY       ," ).append("\n"); 
		query.append("         USD_BKG_40FT_HC_QTY    ," ).append("\n"); 
		query.append("         USD_BKG_45FT_HC_QTY    ," ).append("\n"); 
		query.append("         USD_BKG_53FT_QTY       ," ).append("\n"); 
		query.append("         USD_BKG_RF_QTY         ," ).append("\n"); 
		query.append("         USD_BKG_TTL_WGT        ," ).append("\n"); 
		query.append("         Z.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("         Z.USR_ID AS ALOC_USR_ID," ).append("\n"); 
		query.append("         Z.ALOC_GDT             ," ).append("\n"); 
		query.append("         Z.USR_ID AS CRE_USR_ID ," ).append("\n"); 
		query.append("         Z.DT CRE_DT            ," ).append("\n"); 
		query.append("         Z.USR_ID AS UPD_USR_ID ," ).append("\n"); 
		query.append("         Z.DT UPD_DT ," ).append("\n"); 
		query.append("         Z.CUST_CNT_CD," ).append("\n"); 
		query.append("         Z.CUST_SEQ," ).append("\n"); 
		query.append("         DECODE(Z.USA_BKG_MOD_CD, 'OTHERS', 'X', Z.USA_BKG_MOD_CD) as USA_BKG_MOD_CD," ).append("\n"); 
		query.append("         DECODE(Z.DEST_LOC_CD, '1','XXXXX', Z.DEST_LOC_CD) as DEST_LOC_CD," ).append("\n"); 
		query.append("         Z.ASGN_D2 AS ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("         Z.ASGN_D4 AS ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("         Z.ASGN_RD AS ASGN_RD_QTY," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_D2 , NULL) AS BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_D4 , NULL) AS BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("         DECODE(Z.SUB_OFC_CNT, 0, Z.ASGN_RD , NULL) AS BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("         Z.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("         Z.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("         Z.FCAST_RD_QTY," ).append("\n"); 
		query.append("         Z.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("         Z.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("         Z.USD_BKG_RD_QTY," ).append("\n"); 
		query.append("         Z.CTRT_NO" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("            SELECT P.RLANE_CD   ," ).append("\n"); 
		query.append("                   P.DIR_CD     ," ).append("\n"); 
		query.append("                   P.VSL_CD     ," ).append("\n"); 
		query.append("                   P.SKD_VOY_NO ," ).append("\n"); 
		query.append("                   P.SKD_DIR_CD ," ).append("\n"); 
		query.append("                   DECODE(P.TS_FLG, 'Y', NVL(P.SLS_OFC_CD, P.SLS_RHQ_CD), P.SLS_OFC_CD) AS SLS_OFC_CD," ).append("\n"); 
		query.append("                   P.POL_YD_CD  ," ).append("\n"); 
		query.append("                   P.POD_YD_CD  ," ).append("\n"); 
		query.append("                   P.TS_FLG     ," ).append("\n"); 
		query.append("                   P.MNL_FLG    ," ).append("\n"); 
		query.append("                   RL.REP_TRD_CD," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT RDRL.SUB_TRD_CD" ).append("\n"); 
		query.append("                        FROM MDM_DTL_REV_LANE RDRL" ).append("\n"); 
		query.append("                       WHERE RL.RLANE_CD          = RDRL.RLANE_CD" ).append("\n"); 
		query.append("                         AND RL.REP_TRD_CD        = RDRL.TRD_CD" ).append("\n"); 
		query.append("                         AND RDRL.VSL_SLAN_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                   DRL.TRD_CD    ," ).append("\n"); 
		query.append("                   DRL.SUB_TRD_CD," ).append("\n"); 
		query.append("                   P.IOC_CD      ," ).append("\n"); 
		query.append("                   P.SLS_RHQ_CD  ," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT O.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                        FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                             MAS_MON_VVD C" ).append("\n"); 
		query.append("                       WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND C.TRD_CD     = DRL.TRD_CD" ).append("\n"); 
		query.append("                         AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                         AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                         AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND C.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                         AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                   ) AS SLS_AQ_CD," ).append("\n"); 
		query.append("                   P.SLS_OFC_CD AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT COUNT(1)" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                       WHERE O.PRNT_OFC_CD = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND O.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                   ) AS SUB_OFC_CNT," ).append("\n"); 
		query.append("                   P.ASGN_TTL           ," ).append("\n"); 
		query.append("                   P.ASGN_20            ," ).append("\n"); 
		query.append("                   P.ASGN_40            ," ).append("\n"); 
		query.append("                   P.ASGN_HC            ," ).append("\n"); 
		query.append("                   P.ASGN_45            ," ).append("\n"); 
		query.append("                   P.ASGN_53            ," ).append("\n"); 
		query.append("                   P.ASGN_RF            ," ).append("\n"); 
		query.append("                   P.ASGN_WGT           ," ).append("\n"); 
		query.append("                   P.FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("                   P.FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                   P.FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                   P.FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("                   P.FCAST_RF_QTY       ," ).append("\n"); 
		query.append("                   P.FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("                   P.USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                   P.USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                   P.USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                   P.USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                   P.USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("                   P.USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("                   P.MNL_ALOC_RMK       ," ).append("\n"); 
		query.append("                   P.USR_ID             ," ).append("\n"); 
		query.append("                   P.ALOC_GDT           ," ).append("\n"); 
		query.append("                   P.DT                 ," ).append("\n"); 
		query.append("                   P.CUST_CNT_CD        ," ).append("\n"); 
		query.append("                   P.CUST_SEQ           ," ).append("\n"); 
		query.append("                   P.USA_BKG_MOD_CD     ,    " ).append("\n"); 
		query.append("                   P.DEST_LOC_CD        ," ).append("\n"); 
		query.append("                   P.ASGN_D2            ," ).append("\n"); 
		query.append("                   P.ASGN_D4            ," ).append("\n"); 
		query.append("                   P.ASGN_RD            ," ).append("\n"); 
		query.append("--                   P.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("--                   P.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("--                   P.BKG_AVAL_RD_QTY    ," ).append("\n"); 
		query.append("                   P.FCAST_20FT_DRY_QTY ," ).append("\n"); 
		query.append("                   P.FCAST_40FT_DRY_QTY ," ).append("\n"); 
		query.append("                   P.FCAST_RD_QTY       ," ).append("\n"); 
		query.append("                   P.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_RD_QTY," ).append("\n"); 
		query.append("                   P.CTRT_NO" ).append("\n"); 
		query.append("                FROM PARAMS           P   ," ).append("\n"); 
		query.append("                   MDM_REV_LANE     RL  ," ).append("\n"); 
		query.append("                   MDM_DTL_REV_LANE DRL ," ).append("\n"); 
		query.append("                   MDM_LOCATION     LLOC," ).append("\n"); 
		query.append("                   MDM_LOCATION     DLOC" ).append("\n"); 
		query.append("             WHERE P.RLANE_CD                = RL.RLANE_CD" ).append("\n"); 
		query.append("               AND P.RLANE_CD                = DRL.RLANE_CD" ).append("\n"); 
		query.append("               AND P.SKD_DIR_CD              = DRL.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("               AND SUBSTR(P.POL_YD_CD, 1, 5) = LLOC.LOC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(P.POD_YD_CD, 1, 5) = DLOC.LOC_CD" ).append("\n"); 
		query.append("               AND DRL.FM_CONTI_CD           = SPC_CONTI_CONV_FNC(LLOC.CONTI_CD, P.RLANE_CD,P.SKD_DIR_CD)" ).append("\n"); 
		query.append("               AND DRL.TO_CONTI_CD           = SPC_CONTI_CONV_FNC(DLOC.CONTI_CD, P.RLANE_CD,P.SKD_DIR_CD)" ).append("\n"); 
		query.append("               AND P.POD_YD_CD              <> DECODE(LENGTH(P.POD_YD_CD), 5, '00000', '0000000')" ).append("\n"); 
		query.append("               AND NVL(DRL.DELT_FLG,'N')     = 'N'" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                   P.RLANE_CD   ," ).append("\n"); 
		query.append("                   P.DIR_CD     ," ).append("\n"); 
		query.append("                   P.VSL_CD     ," ).append("\n"); 
		query.append("                   P.SKD_VOY_NO ," ).append("\n"); 
		query.append("                   P.SKD_DIR_CD ," ).append("\n"); 
		query.append("                   DECODE(P.TS_FLG, 'Y', NVL(P.SLS_OFC_CD, P.SLS_RHQ_CD), P.SLS_OFC_CD) SLS_OFC_CD," ).append("\n"); 
		query.append("                   P.POL_YD_CD  ," ).append("\n"); 
		query.append("                   P.POD_YD_CD  ," ).append("\n"); 
		query.append("                   P.TS_FLG     ," ).append("\n"); 
		query.append("                   P.MNL_FLG    ," ).append("\n"); 
		query.append("                   RL.REP_TRD_CD," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT RDRL.SUB_TRD_CD" ).append("\n"); 
		query.append("                        FROM MDM_DTL_REV_LANE RDRL" ).append("\n"); 
		query.append("                       WHERE RL.RLANE_CD          = RDRL.RLANE_CD" ).append("\n"); 
		query.append("                         AND RL.REP_TRD_CD        = RDRL.TRD_CD" ).append("\n"); 
		query.append("                         AND RDRL.VSL_SLAN_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) AS REP_SUB_TRD_CD," ).append("\n"); 
		query.append("                   P.TRD_CD    ," ).append("\n"); 
		query.append("                   P.SUB_TRD_CD," ).append("\n"); 
		query.append("                   P.IOC_CD    ," ).append("\n"); 
		query.append("                   P.SLS_RHQ_CD," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                        FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                             MAS_MON_VVD C" ).append("\n"); 
		query.append("                       WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("                         AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                         AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                         AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
		query.append("                         AND C.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                         AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                   ) AS SLS_AQ_CD," ).append("\n"); 
		query.append("                   P.SLS_OFC_CD AS SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("                      SELECT COUNT(1)" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                       WHERE O.PRNT_OFC_CD = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                   ) AS SUB_OFC_CNT," ).append("\n"); 
		query.append("                   P.ASGN_TTL           ," ).append("\n"); 
		query.append("                   P.ASGN_20            ," ).append("\n"); 
		query.append("                   P.ASGN_40            ," ).append("\n"); 
		query.append("                   P.ASGN_HC            ," ).append("\n"); 
		query.append("                   P.ASGN_45            ," ).append("\n"); 
		query.append("                   P.ASGN_53            ," ).append("\n"); 
		query.append("                   P.ASGN_RF            ," ).append("\n"); 
		query.append("                   P.ASGN_WGT           ," ).append("\n"); 
		query.append("                   P.FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("                   P.FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                   P.FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                   P.FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("                   P.FCAST_RF_QTY       ," ).append("\n"); 
		query.append("                   P.FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("                   P.USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                   P.USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                   P.USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                   P.USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                   P.USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("                   P.USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("                   P.MNL_ALOC_RMK       ," ).append("\n"); 
		query.append("                   P.USR_ID             ," ).append("\n"); 
		query.append("                   P.ALOC_GDT           ," ).append("\n"); 
		query.append("                   P.DT                 ," ).append("\n"); 
		query.append("                   P.CUST_CNT_CD        ," ).append("\n"); 
		query.append("                   P.CUST_SEQ           ," ).append("\n"); 
		query.append("                   P.USA_BKG_MOD_CD     ," ).append("\n"); 
		query.append("                   P.DEST_LOC_CD        ," ).append("\n"); 
		query.append("                   P.ASGN_D2            ," ).append("\n"); 
		query.append("                   P.ASGN_D4            ," ).append("\n"); 
		query.append("                   P.ASGN_RD            ," ).append("\n"); 
		query.append("--                   P.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("--                   P.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("--                   P.BKG_AVAL_RD_QTY    ," ).append("\n"); 
		query.append("                   P.FCAST_20FT_DRY_QTY ," ).append("\n"); 
		query.append("                   P.FCAST_40FT_DRY_QTY ," ).append("\n"); 
		query.append("                   P.FCAST_RD_QTY       ," ).append("\n"); 
		query.append("                   P.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("                   P.USD_BKG_RD_QTY," ).append("\n"); 
		query.append("                   P.CTRT_NO " ).append("\n"); 
		query.append("              FROM PARAMS       P ," ).append("\n"); 
		query.append("                   MDM_REV_LANE RL" ).append("\n"); 
		query.append("             WHERE P.RLANE_CD  = RL.RLANE_CD" ).append("\n"); 
		query.append("               AND P.POD_YD_CD = DECODE(LENGTH(P.POD_YD_CD), 5, '00000', '0000000')" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("         ) Z" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	) b" ).append("\n"); 
		query.append("on (" ).append("\n"); 
		query.append("    a.RLANE_CD           = b.RLANE_CD      " ).append("\n"); 
		query.append("and a.DIR_CD		 = b.DIR_CD        " ).append("\n"); 
		query.append("and a.VSL_CD		 = b.VSL_CD        " ).append("\n"); 
		query.append("and a.SKD_VOY_NO	 = b.SKD_VOY_NO    " ).append("\n"); 
		query.append("and a.SKD_DIR_CD	 = b.SKD_DIR_CD    " ).append("\n"); 
		query.append("and a.SLS_OFC_CD	 = b.SLS_OFC_CD    " ).append("\n"); 
		query.append("and a.POL_YD_CD		 = b.POL_YD_CD     " ).append("\n"); 
		query.append("and a.POD_YD_CD		 = b.POD_YD_CD     " ).append("\n"); 
		query.append("and a.TS_FLG		 = b.TS_FLG        " ).append("\n"); 
		query.append("and a.MNL_FLG		 = b.MNL_FLG       " ).append("\n"); 
		query.append("and a.IOC_CD		 = b.IOC_CD        " ).append("\n"); 
		query.append("and a.CUST_CNT_CD	 = b.CUST_CNT_CD   " ).append("\n"); 
		query.append("and a.CUST_SEQ		 = b.CUST_SEQ      " ).append("\n"); 
		query.append("and a.USA_BKG_MOD_CD	 = b.USA_BKG_MOD_CD" ).append("\n"); 
		query.append("and a.DEST_LOC_CD	 = b.DEST_LOC_CD   " ).append("\n"); 
		query.append("and a.CTRT_NO  		 = b.CTRT_NO       " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("    WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("INSERT   (" ).append("\n"); 
		query.append("    a.RLANE_CD            ," ).append("\n"); 
		query.append("    a.DIR_CD              ," ).append("\n"); 
		query.append("    a.VSL_CD              ," ).append("\n"); 
		query.append("    a.SKD_VOY_NO          ," ).append("\n"); 
		query.append("    a.SKD_DIR_CD          ," ).append("\n"); 
		query.append("    a.SLS_OFC_CD          ," ).append("\n"); 
		query.append("    a.POL_YD_CD           ," ).append("\n"); 
		query.append("    a.POD_YD_CD           ," ).append("\n"); 
		query.append("    a.TS_FLG              ," ).append("\n"); 
		query.append("    a.MNL_FLG             ," ).append("\n"); 
		query.append("    a.REP_TRD_CD          ," ).append("\n"); 
		query.append("    a.REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("    a.TRD_CD              ," ).append("\n"); 
		query.append("    a.SUB_TRD_CD          ," ).append("\n"); 
		query.append("    a.IOC_CD              ," ).append("\n"); 
		query.append("    a.SLS_RHQ_CD          ," ).append("\n"); 
		query.append("    a.SLS_AQ_CD           ," ).append("\n"); 
		query.append("    a.SLS_RGN_OFC_CD      ," ).append("\n"); 
		query.append("    a.ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("    a.ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("    a.ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("    a.ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("    a.ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("    a.ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("    a.ASGN_RF_QTY         ," ).append("\n"); 
		query.append("    a.ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    a.BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("    a.BKG_AVAL_20FT_QTY   ," ).append("\n"); 
		query.append("    a.BKG_AVAL_40FT_QTY   ," ).append("\n"); 
		query.append("    a.BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("    a.BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("    a.BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("    a.BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("    a.BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("    a.FCAST_TTL_QTY       ," ).append("\n"); 
		query.append("    a.FCAST_40FT_HC_QTY   ," ).append("\n"); 
		query.append("    a.FCAST_45FT_HC_QTY   ," ).append("\n"); 
		query.append("    a.FCAST_53FT_QTY      ," ).append("\n"); 
		query.append("    a.FCAST_RF_QTY        ," ).append("\n"); 
		query.append("    a.FCAST_TTL_WGT       ," ).append("\n"); 
		query.append("    a.USD_BKG_TTL_QTY     ," ).append("\n"); 
		query.append("    a.USD_BKG_20FT_QTY    ," ).append("\n"); 
		query.append("    a.USD_BKG_40FT_QTY    ," ).append("\n"); 
		query.append("    a.USD_BKG_40FT_HC_QTY ," ).append("\n"); 
		query.append("    a.USD_BKG_45FT_HC_QTY ," ).append("\n"); 
		query.append("    a.USD_BKG_53FT_QTY    ," ).append("\n"); 
		query.append("    a.USD_BKG_RF_QTY      ," ).append("\n"); 
		query.append("    a.USD_BKG_TTL_WGT     ," ).append("\n"); 
		query.append("    a.MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    a.ALOC_USR_ID         ," ).append("\n"); 
		query.append("    a.ALOC_GDT            ," ).append("\n"); 
		query.append("    a.CRE_USR_ID          ," ).append("\n"); 
		query.append("    a.CRE_DT              ," ).append("\n"); 
		query.append("    a.UPD_USR_ID          ," ).append("\n"); 
		query.append("    a.UPD_DT              ," ).append("\n"); 
		query.append("    -- 2014.07.28 컬럼 추가" ).append("\n"); 
		query.append("    a.CUST_CNT_CD," ).append("\n"); 
		query.append("    a.CUST_SEQ," ).append("\n"); 
		query.append("    a.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("    a.DEST_LOC_CD," ).append("\n"); 
		query.append("    a.ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("    a.ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("    a.ASGN_RD_QTY," ).append("\n"); 
		query.append("    a.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("    a.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("    a.BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("    a.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("    a.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("    a.FCAST_RD_QTY," ).append("\n"); 
		query.append("    a.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("    a.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("    a.USD_BKG_RD_QTY," ).append("\n"); 
		query.append("    a.CTRT_NO " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         b.RLANE_CD      ," ).append("\n"); 
		query.append("         b.DIR_CD        ," ).append("\n"); 
		query.append("         b.VSL_CD        ," ).append("\n"); 
		query.append("         b.SKD_VOY_NO    ," ).append("\n"); 
		query.append("         b.SKD_DIR_CD    ," ).append("\n"); 
		query.append("         b.SLS_OFC_CD    ," ).append("\n"); 
		query.append("         b.POL_YD_CD     ," ).append("\n"); 
		query.append("         b.POD_YD_CD     ," ).append("\n"); 
		query.append("         b.TS_FLG        ," ).append("\n"); 
		query.append("         b.MNL_FLG       ," ).append("\n"); 
		query.append("         b.REP_TRD_CD    ," ).append("\n"); 
		query.append("         b.REP_SUB_TRD_CD," ).append("\n"); 
		query.append("         b.TRD_CD        ," ).append("\n"); 
		query.append("         b.SUB_TRD_CD    ," ).append("\n"); 
		query.append("         b.IOC_CD        ," ).append("\n"); 
		query.append("         b.SLS_RHQ_CD    ," ).append("\n"); 
		query.append("         b.SLS_AQ_CD     ," ).append("\n"); 
		query.append("         b.SLS_RGN_OFC_CD," ).append("\n"); 
		query.append("         b.ASGN_TTL_QTY    ," ).append("\n"); 
		query.append("         b.ASGN_20FT_QTY   ," ).append("\n"); 
		query.append("         b.ASGN_40FT_QTY   ," ).append("\n"); 
		query.append("         b.ASGN_40FT_HC_QTY," ).append("\n"); 
		query.append("         b.ASGN_45FT_HC_QTY," ).append("\n"); 
		query.append("         b.ASGN_53FT_QTY   ," ).append("\n"); 
		query.append("         b.ASGN_RF_QTY     ," ).append("\n"); 
		query.append("         b.ASGN_TTL_WGT    ," ).append("\n"); 
		query.append("         b.BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("         b.BKG_AVAL_20FT_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_40FT_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("         b.BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("         b.BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         b.FCAST_TTL_QTY          ," ).append("\n"); 
		query.append("         b.FCAST_40FT_HC_QTY      ," ).append("\n"); 
		query.append("         b.FCAST_45FT_HC_QTY      ," ).append("\n"); 
		query.append("         b.FCAST_53FT_QTY         ," ).append("\n"); 
		query.append("         b.FCAST_RF_QTY           ," ).append("\n"); 
		query.append("         b.FCAST_TTL_WGT          ," ).append("\n"); 
		query.append("         b.USD_BKG_TTL_QTY        ," ).append("\n"); 
		query.append("         b.USD_BKG_20FT_QTY       ," ).append("\n"); 
		query.append("         b.USD_BKG_40FT_QTY       ," ).append("\n"); 
		query.append("         b.USD_BKG_40FT_HC_QTY    ," ).append("\n"); 
		query.append("         b.USD_BKG_45FT_HC_QTY    ," ).append("\n"); 
		query.append("         b.USD_BKG_53FT_QTY       ," ).append("\n"); 
		query.append("         b.USD_BKG_RF_QTY         ," ).append("\n"); 
		query.append("         b.USD_BKG_TTL_WGT        ," ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("         b.MNL_ALOC_RMK         ," ).append("\n"); 
		query.append("         b.ALOC_USR_ID," ).append("\n"); 
		query.append("         b.ALOC_GDT             ," ).append("\n"); 
		query.append("         b.CRE_USR_ID ," ).append("\n"); 
		query.append("         b.CRE_DT            ," ).append("\n"); 
		query.append("         b.UPD_USR_ID ," ).append("\n"); 
		query.append("         b.UPD_DT ," ).append("\n"); 
		query.append("         b.CUST_CNT_CD," ).append("\n"); 
		query.append("         b.CUST_SEQ," ).append("\n"); 
		query.append("         b.USA_BKG_MOD_CD," ).append("\n"); 
		query.append("         b.DEST_LOC_CD," ).append("\n"); 
		query.append("         b.ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("         b.ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("         b.ASGN_RD_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("         b.BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("         b.FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("         b.FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("         b.FCAST_RD_QTY," ).append("\n"); 
		query.append("         b.USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("         b.USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("         b.USD_BKG_RD_QTY," ).append("\n"); 
		query.append("         b.CTRT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("when matched then " ).append("\n"); 
		query.append(" UPDATE SET " ).append("\n"); 
		query.append("	  a.REP_TRD_CD              = b.REP_TRD_CD                   " ).append("\n"); 
		query.append("	, a.REP_SUB_TRD_CD	    = b.REP_SUB_TRD_CD               " ).append("\n"); 
		query.append("	, a.TRD_CD		    = b.TRD_CD                       " ).append("\n"); 
		query.append("	, a.SUB_TRD_CD		    = b.SUB_TRD_CD                   " ).append("\n"); 
		query.append("	, a.SLS_RHQ_CD		    = b.SLS_RHQ_CD                   " ).append("\n"); 
		query.append("	, a.SLS_RGN_OFC_CD	    = b.SLS_RGN_OFC_CD               " ).append("\n"); 
		query.append("	, a.ASGN_TTL_QTY	    = b.ASGN_TTL_QTY                 " ).append("\n"); 
		query.append("	, a.ASGN_20FT_QTY	    = b.ASGN_20FT_QTY                " ).append("\n"); 
		query.append("	, a.ASGN_40FT_QTY	    = b.ASGN_40FT_QTY                " ).append("\n"); 
		query.append("	, a.ASGN_40FT_HC_QTY	    = b.ASGN_40FT_HC_QTY             " ).append("\n"); 
		query.append("	, a.ASGN_45FT_HC_QTY	    = b.ASGN_45FT_HC_QTY             " ).append("\n"); 
		query.append("	, a.ASGN_RF_QTY		    = b.ASGN_RF_QTY                  " ).append("\n"); 
		query.append("	, a.ASGN_TTL_WGT	    = b.ASGN_TTL_WGT                 " ).append("\n"); 
		query.append("	, a.BKG_AVAL_TTL_QTY	    = b.BKG_AVAL_TTL_QTY             " ).append("\n"); 
		query.append("	, a.BKG_AVAL_20FT_QTY	    = b.BKG_AVAL_20FT_QTY            " ).append("\n"); 
		query.append("	, a.BKG_AVAL_40FT_QTY	    = b.BKG_AVAL_40FT_QTY            " ).append("\n"); 
		query.append("	, a.BKG_AVAL_40FT_HC_QTY    = b.BKG_AVAL_40FT_HC_QTY         " ).append("\n"); 
		query.append("	, a.BKG_AVAL_45FT_HC_QTY    = b.BKG_AVAL_45FT_HC_QTY         " ).append("\n"); 
		query.append("	, a.BKG_AVAL_RF_QTY	    = b.BKG_AVAL_RF_QTY              " ).append("\n"); 
		query.append("	, a.BKG_AVAL_TTL_WGT	    = b.BKG_AVAL_TTL_WGT             " ).append("\n"); 
		query.append("	, a.MNL_ALOC_RMK	    = b.MNL_ALOC_RMK                 " ).append("\n"); 
		query.append("	, a.ALOC_USR_ID		    = b.ALOC_USR_ID                  " ).append("\n"); 
		query.append("	, a.ALOC_GDT		    = b.ALOC_GDT                     " ).append("\n"); 
		query.append("	, a.SLS_AQ_CD		    = b.SLS_AQ_CD                    " ).append("\n"); 
		query.append("	, a.FCAST_TTL_QTY	    = b.FCAST_TTL_QTY                " ).append("\n"); 
		query.append("	, a.FCAST_40FT_HC_QTY	    = b.FCAST_40FT_HC_QTY            " ).append("\n"); 
		query.append("	, a.FCAST_45FT_HC_QTY	    = b.FCAST_45FT_HC_QTY            " ).append("\n"); 
		query.append("	, a.FCAST_RF_QTY	    = b.FCAST_RF_QTY                 " ).append("\n"); 
		query.append("	, a.FCAST_TTL_WGT	    = b.FCAST_TTL_WGT                " ).append("\n"); 
		query.append("	, a.USD_BKG_TTL_QTY	    = b.USD_BKG_TTL_QTY              " ).append("\n"); 
		query.append("	, a.USD_BKG_20FT_QTY	    = b.USD_BKG_20FT_QTY             " ).append("\n"); 
		query.append("	, a.USD_BKG_40FT_QTY	    = b.USD_BKG_40FT_QTY             " ).append("\n"); 
		query.append("	, a.USD_BKG_40FT_HC_QTY	    = b.USD_BKG_40FT_HC_QTY          " ).append("\n"); 
		query.append("	, a.USD_BKG_45FT_HC_QTY	    = b.USD_BKG_45FT_HC_QTY          " ).append("\n"); 
		query.append("	, a.USD_BKG_RF_QTY	    = b.USD_BKG_RF_QTY               " ).append("\n"); 
		query.append("	, a.USD_BKG_TTL_WGT	    = b.USD_BKG_TTL_WGT              " ).append("\n"); 
		query.append("	, a.UPD_USR_ID		    = b.UPD_USR_ID                   " ).append("\n"); 
		query.append("	, a.UPD_DT		    = b.UPD_DT                       " ).append("\n"); 
		query.append("	, a.ASGN_53FT_QTY	    = b.ASGN_53FT_QTY                " ).append("\n"); 
		query.append("	, a.BKG_AVAL_53FT_QTY	    = b.BKG_AVAL_53FT_QTY            " ).append("\n"); 
		query.append("	, a.FCAST_53FT_QTY	    = b.FCAST_53FT_QTY               " ).append("\n"); 
		query.append("	, a.USD_BKG_53FT_QTY	    = b.USD_BKG_53FT_QTY             " ).append("\n"); 
		query.append("	, a.ASGN_20FT_DRY_QTY	    = b.ASGN_20FT_DRY_QTY            " ).append("\n"); 
		query.append("	, a.ASGN_40FT_DRY_QTY	    = b.ASGN_40FT_DRY_QTY            " ).append("\n"); 
		query.append("	, a.ASGN_RD_QTY		    = b.ASGN_RD_QTY                  " ).append("\n"); 
		query.append("	, a.BKG_AVAL_20FT_DRY_QTY   = b.BKG_AVAL_20FT_DRY_QTY        " ).append("\n"); 
		query.append("	, a.BKG_AVAL_40FT_DRY_QTY   = b.BKG_AVAL_40FT_DRY_QTY        " ).append("\n"); 
		query.append("	, a.BKG_AVAL_RD_QTY	    = b.BKG_AVAL_RD_QTY              " ).append("\n"); 
		query.append("	, a.FCAST_20FT_DRY_QTY	    = b.FCAST_20FT_DRY_QTY           " ).append("\n"); 
		query.append("	, a.FCAST_40FT_DRY_QTY	    = b.FCAST_40FT_DRY_QTY           " ).append("\n"); 
		query.append("	, a.FCAST_RD_QTY	    = b.FCAST_RD_QTY                 " ).append("\n"); 
		query.append("	, a.USD_BKG_20FT_DRY_QTY    = b.USD_BKG_20FT_DRY_QTY         " ).append("\n"); 
		query.append("	, a.USD_BKG_40FT_DRY_QTY    = b.USD_BKG_40FT_DRY_QTY         " ).append("\n"); 
		query.append("	, a.USD_BKG_RD_QTY 	    = b.USD_BKG_RD_QTY" ).append("\n"); 

	}
}