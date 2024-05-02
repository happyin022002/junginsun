/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod044CSQL.java
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

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod044CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiSpcAlocPolPod044
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod044CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_aval_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_53ft_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_aval_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_aval_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_aval_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod044CSQL").append("\n"); 
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
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[rlane_cd]  ," ).append("\n"); 
		query.append("    @[dir_cd]    ," ).append("\n"); 
		query.append("    @[vsl_cd]    ," ).append("\n"); 
		query.append("    @[skd_voy_no]," ).append("\n"); 
		query.append("    @[skd_dir_cd]," ).append("\n"); 
		query.append("    @[sls_ofc_cd]," ).append("\n"); 
		query.append("    @[pol_cd]    ," ).append("\n"); 
		query.append("    @[pod_cd]    ," ).append("\n"); 
		query.append("    @[ts_flg]    ," ).append("\n"); 
		query.append("    @[mnl_flg]   ," ).append("\n"); 
		query.append("    saq_get_rep_trd_fnc(@[rlane_cd])    ," ).append("\n"); 
		query.append("    saq_get_rep_sub_trd_fnc(@[rlane_cd])," ).append("\n"); 
		query.append("    @[trd_cd]    ," ).append("\n"); 
		query.append("    @[sub_trd_cd]," ).append("\n"); 
		query.append("    DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')," ).append("\n"); 
		query.append("    ( SELECT O.N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("        FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("             COA_MON_VVD C" ).append("\n"); 
		query.append("       WHERE O.OFC_CD     = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("         AND C.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("         AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("         AND C.IOC_CD     = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 
		query.append("         AND C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("         AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND C.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("    )," ).append("\n"); 
		query.append("    ( SELECT O.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("        FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("             COA_MON_VVD C" ).append("\n"); 
		query.append("       WHERE O.OFC_CD     = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("         AND C.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("         AND C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("         AND C.IOC_CD     = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 
		query.append("         AND C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("         AND C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("         AND C.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("         AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("    )," ).append("\n"); 
		query.append("    @[sls_rgn_ofc_cd]  ," ).append("\n"); 
		query.append("    @[bkg_aval_ttl_qty]," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    0," ).append("\n"); 
		query.append("    @[bkg_aval_40ft_hc_qty]," ).append("\n"); 
		query.append("    @[bkg_aval_45ft_hc_qty]," ).append("\n"); 
		query.append("    @[bkg_aval_53ft_qty]   ," ).append("\n"); 
		query.append("    @[bkg_aval_rf_qty]     ," ).append("\n"); 
		query.append("    @[bkg_aval_ttl_wgt]    ," ).append("\n"); 
		query.append("    @[fcast_ttl_qty]       ," ).append("\n"); 
		query.append("    @[fcast_40ft_hc_qty]   ," ).append("\n"); 
		query.append("    @[fcast_45ft_hc_qty]   ," ).append("\n"); 
		query.append("    @[fcast_53ft_qty]      ," ).append("\n"); 
		query.append("    @[fcast_rf_qty]        ," ).append("\n"); 
		query.append("    @[fcast_ttl_wgt]       ," ).append("\n"); 
		query.append("    @[usd_bkg_ttl_qty]     ," ).append("\n"); 
		query.append("    @[usd_bkg_20ft_qty]    ," ).append("\n"); 
		query.append("    @[usd_bkg_40ft_qty]    ," ).append("\n"); 
		query.append("    @[usd_bkg_40ft_hc_qty] ," ).append("\n"); 
		query.append("    @[usd_bkg_45ft_hc_qty] ," ).append("\n"); 
		query.append("    @[usd_bkg_53ft_qty]    ," ).append("\n"); 
		query.append("    @[usd_bkg_rf_qty]      ," ).append("\n"); 
		query.append("    @[usd_bkg_ttl_wgt]     ," ).append("\n"); 
		query.append("    '1'," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE)," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE      ," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")	" ).append("\n"); 

	}
}