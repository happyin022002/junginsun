/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다.(추가)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aloc_gdt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod042CSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_ALOC_POL_POD (" ).append("\n"); 
		query.append("    RLANE_CD            ," ).append("\n"); 
		query.append("    DIR_CD              ," ).append("\n"); 
		query.append("    VSL_CD              ," ).append("\n"); 
		query.append("    SKD_VOY_NO          ," ).append("\n"); 
		query.append("    SKD_DIR_CD          ," ).append("\n"); 
		query.append("    SLS_OFC_CD          ," ).append("\n"); 
		query.append("    POL_YD_CD           ," ).append("\n"); 
		query.append("    POD_YD_CD           ," ).append("\n"); 
		query.append("    TS_FLG              ," ).append("\n"); 
		query.append("    MNL_FLG             ," ).append("\n"); 
		query.append("    REP_TRD_CD          ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD      ," ).append("\n"); 
		query.append("    TRD_CD              ," ).append("\n"); 
		query.append("    SUB_TRD_CD          ," ).append("\n"); 
		query.append("    IOC_CD              ," ).append("\n"); 
		query.append("    SLS_RHQ_CD          ," ).append("\n"); 
		query.append("    SLS_AQ_CD           ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD      ," ).append("\n"); 
		query.append("    ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("    ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("    ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("    ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("    ASGN_RF_QTY         ," ).append("\n"); 
		query.append("    ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("    BKG_AVAL_20FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("    BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("    BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("    BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("    FCAST_TTL_QTY       ," ).append("\n"); 
		query.append("    FCAST_40FT_HC_QTY   ," ).append("\n"); 
		query.append("    FCAST_45FT_HC_QTY   ," ).append("\n"); 
		query.append("    FCAST_53FT_QTY      ," ).append("\n"); 
		query.append("    FCAST_RF_QTY        ," ).append("\n"); 
		query.append("    FCAST_TTL_WGT       ," ).append("\n"); 
		query.append("    USD_BKG_TTL_QTY     ," ).append("\n"); 
		query.append("    USD_BKG_20FT_QTY    ," ).append("\n"); 
		query.append("    USD_BKG_40FT_QTY    ," ).append("\n"); 
		query.append("    USD_BKG_40FT_HC_QTY ," ).append("\n"); 
		query.append("    USD_BKG_45FT_HC_QTY ," ).append("\n"); 
		query.append("    USD_BKG_53FT_QTY    ," ).append("\n"); 
		query.append("    USD_BKG_RF_QTY      ," ).append("\n"); 
		query.append("    USD_BKG_TTL_WGT     ," ).append("\n"); 
		query.append("    MNL_ALOC_RMK        ," ).append("\n"); 
		query.append("    ALOC_USR_ID         ," ).append("\n"); 
		query.append("    ALOC_GDT            ," ).append("\n"); 
		query.append("    CRE_USR_ID          ," ).append("\n"); 
		query.append("    CRE_DT              ," ).append("\n"); 
		query.append("    UPD_USR_ID          ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
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
		query.append("            SYSDATE AS DT" ).append("\n"); 
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
		query.append("         Z.DT UPD_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
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
		query.append("                             COA_MON_VVD C" ).append("\n"); 
		query.append("                       WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND C.TRD_CD     = DRL.TRD_CD" ).append("\n"); 
		query.append("                         AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                         AND C.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("                         AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                         AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
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
		query.append("                   P.DT" ).append("\n"); 
		query.append("              FROM PARAMS           P   ," ).append("\n"); 
		query.append("                   MDM_REV_LANE     RL  ," ).append("\n"); 
		query.append("                   MDM_DTL_REV_LANE DRL ," ).append("\n"); 
		query.append("                   MDM_LOCATION     LLOC," ).append("\n"); 
		query.append("                   MDM_LOCATION     DLOC" ).append("\n"); 
		query.append("             WHERE P.RLANE_CD                = RL.RLANE_CD" ).append("\n"); 
		query.append("               AND P.RLANE_CD                = DRL.RLANE_CD" ).append("\n"); 
		query.append("               AND P.SKD_DIR_CD              = DRL.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("               AND SUBSTR(P.POL_YD_CD, 1, 5) = LLOC.LOC_CD" ).append("\n"); 
		query.append("               AND SUBSTR(P.POD_YD_CD, 1, 5) = DLOC.LOC_CD" ).append("\n"); 
		query.append("               AND DRL.FM_CONTI_CD           = LLOC.CONTI_CD" ).append("\n"); 
		query.append("               AND DRL.TO_CONTI_CD           = DLOC.CONTI_CD" ).append("\n"); 
		query.append("               AND P.POD_YD_CD              <> DECODE(LENGTH(P.POD_YD_CD), 5, '00000', '0000000')" ).append("\n"); 
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
		query.append("                             COA_MON_VVD C" ).append("\n"); 
		query.append("                       WHERE O.OFC_CD     = P.SLS_OFC_CD" ).append("\n"); 
		query.append("                         AND C.TRD_CD     = P.TRD_CD" ).append("\n"); 
		query.append("                         AND C.RLANE_CD   = P.RLANE_CD" ).append("\n"); 
		query.append("                         AND C.IOC_CD     = P.IOC_CD" ).append("\n"); 
		query.append("                         AND C.VSL_CD     = P.VSL_CD" ).append("\n"); 
		query.append("                         AND C.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("                         AND C.DIR_CD     = P.SKD_DIR_CD" ).append("\n"); 
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
		query.append("                   P.DT" ).append("\n"); 
		query.append("              FROM PARAMS       P ," ).append("\n"); 
		query.append("                   MDM_REV_LANE RL" ).append("\n"); 
		query.append("             WHERE P.RLANE_CD  = RL.RLANE_CD" ).append("\n"); 
		query.append("               AND P.POD_YD_CD = DECODE(LENGTH(P.POD_YD_CD), 5, '00000', '0000000')" ).append("\n"); 
		query.append("         ) Z		" ).append("\n"); 

	}
}