/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod042USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.02.24 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod042USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_ALOC_POL_POD의 지정된 ibflag 값에 따라 DB에 반영한다.(수정)
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod042USQL(){
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
		params.put("fcast_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_40ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usd_bkg_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod042USQL").append("\n"); 
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
		query.append("UPDATE SPC_ALOC_POL_POD A" ).append("\n"); 
		query.append("   SET (" ).append("\n"); 
		query.append("          ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("          ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("          ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("          ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("          ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("          ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("          ASGN_RF_QTY         ," ).append("\n"); 
		query.append("          ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("          BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("          BKG_AVAL_20FT_QTY   ," ).append("\n"); 
		query.append("          BKG_AVAL_40FT_QTY   ," ).append("\n"); 
		query.append("          BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("          BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("          BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("          BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("          BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("          FCAST_TTL_QTY       ," ).append("\n"); 
		query.append("          FCAST_40FT_HC_QTY   ," ).append("\n"); 
		query.append("          FCAST_45FT_HC_QTY   ," ).append("\n"); 
		query.append("          FCAST_53FT_QTY      ," ).append("\n"); 
		query.append("          FCAST_RF_QTY        ," ).append("\n"); 
		query.append("          FCAST_TTL_WGT       ," ).append("\n"); 
		query.append("          USD_BKG_TTL_QTY     ," ).append("\n"); 
		query.append("          USD_BKG_20FT_QTY    ," ).append("\n"); 
		query.append("          USD_BKG_40FT_QTY    ," ).append("\n"); 
		query.append("          USD_BKG_40FT_HC_QTY ," ).append("\n"); 
		query.append("          USD_BKG_45FT_HC_QTY ," ).append("\n"); 
		query.append("          USD_BKG_53FT_QTY    ," ).append("\n"); 
		query.append("          USD_BKG_RF_QTY      ," ).append("\n"); 
		query.append("          USD_BKG_TTL_WGT" ).append("\n"); 
		query.append("       ) = (" ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("                     ASGN_TTL," ).append("\n"); 
		query.append("                     0       ," ).append("\n"); 
		query.append("                     0       ," ).append("\n"); 
		query.append("                     ASGN_HC ," ).append("\n"); 
		query.append("                     ASGN_45 ," ).append("\n"); 
		query.append("                     ASGN_53 ," ).append("\n"); 
		query.append("                     ASGN_RF ," ).append("\n"); 
		query.append("                     ASGN_WGT," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_TTL, A.BKG_AVAL_TTL_QTY)," ).append("\n"); 
		query.append("                     0," ).append("\n"); 
		query.append("                     0," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_HC , A.BKG_AVAL_40FT_HC_QTY)," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_45 , A.BKG_AVAL_45FT_HC_QTY)," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_53 , A.BKG_AVAL_53FT_QTY   )," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_RF , A.BKG_AVAL_RF_QTY     )," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_WGT, A.BKG_AVAL_TTL_WGT    )," ).append("\n"); 
		query.append("                     @[fcast_ttl_qty]       AS FCAST_TTL_QTY      ," ).append("\n"); 
		query.append("                     @[fcast_40ft_hc_qty]   AS FCAST_40FT_HC_QTY  ," ).append("\n"); 
		query.append("                     @[fcast_45ft_hc_qty]   AS FCAST_45FT_HC_QTY  ," ).append("\n"); 
		query.append("                     @[fcast_53ft_qty]      AS FCAST_53FT_QTY     ," ).append("\n"); 
		query.append("                     @[fcast_rf_qty]        AS FCAST_RF_QTY       ," ).append("\n"); 
		query.append("                     @[fcast_ttl_wgt]       AS FCAST_TTL_WGT      ," ).append("\n"); 
		query.append("                     @[usd_bkg_ttl_qty]     AS USD_BKG_TTL_QTY    ," ).append("\n"); 
		query.append("                     @[usd_bkg_20ft_qty]    AS USD_BKG_20FT_QTY   ," ).append("\n"); 
		query.append("                     @[usd_bkg_40ft_qty]    AS USD_BKG_40FT_QTY   ," ).append("\n"); 
		query.append("                     @[usd_bkg_40ft_hc_qty] AS USD_BKG_40FT_HC_QTY," ).append("\n"); 
		query.append("                     @[usd_bkg_45ft_hc_qty] AS USD_BKG_45FT_HC_QTY," ).append("\n"); 
		query.append("                     @[usd_bkg_53ft_qty]    AS USD_BKG_53FT_QTY   ," ).append("\n"); 
		query.append("                     @[usd_bkg_rf_qty]      AS USD_BKG_RF_QTY     ," ).append("\n"); 
		query.append("                     @[usd_bkg_ttl_wgt]     AS USD_BKG_TTL_WGT" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                               COUNT(1)            AS SUB_OFC_CNT," ).append("\n"); 
		query.append("                               @[asgn_ttl_qty]     AS ASGN_TTL   ," ).append("\n"); 
		query.append("                               @[asgn_20ft_qty]    AS ASGN_20    ," ).append("\n"); 
		query.append("                               @[asgn_40ft_qty]    AS ASGN_40    ," ).append("\n"); 
		query.append("                               @[asgn_40ft_hc_qty] AS ASGN_HC    ," ).append("\n"); 
		query.append("                               @[asgn_45ft_hc_qty] AS ASGN_45    ," ).append("\n"); 
		query.append("                               @[asgn_53ft_qty]    AS ASGN_53    ," ).append("\n"); 
		query.append("                               @[asgn_rf_qty]      AS ASGN_RF    ," ).append("\n"); 
		query.append("                               @[asgn_ttl_wgt]     AS ASGN_WGT" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                         WHERE O.PRNT_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("                           AND O.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       ALOC_USR_ID  = @[upd_usr_id]," ).append("\n"); 
		query.append("       MNL_ALOC_RMK = '3', " ).append("\n"); 
		query.append("       ALOC_GDT     = CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[aloc_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE)," ).append("\n"); 
		query.append("       UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT       = SYSDATE" ).append("\n"); 
		query.append(" WHERE RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("   AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(POL_YD_CD, 6, 2), '00', SUBSTR(POL_YD_CD, 1, 5), SUBSTR(POL_YD_CD, 1, LENGTH(@[pol_cd]))) = DECODE(SUBSTR(POL_YD_CD, 6, 2), '00', SUBSTR(@[pol_cd], 1, 5), @[pol_cd])" ).append("\n"); 
		query.append("   AND DECODE(SUBSTR(POD_YD_CD, 6, 2), '00', SUBSTR(POD_YD_CD, 1, 5), SUBSTR(POD_YD_CD, 1, LENGTH(@[pod_cd]))) = DECODE(SUBSTR(POD_YD_CD, 6, 2), '00', SUBSTR(@[pod_cd], 1, 5), @[pod_cd])" ).append("\n"); 
		query.append("   AND TS_FLG     = @[ts_flg]" ).append("\n"); 
		query.append("   AND MNL_FLG    = @[mnl_flg]" ).append("\n"); 

	}
}