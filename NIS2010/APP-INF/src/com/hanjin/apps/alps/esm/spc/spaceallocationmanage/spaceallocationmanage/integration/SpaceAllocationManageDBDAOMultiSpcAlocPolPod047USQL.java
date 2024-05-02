/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod047USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2014.12.08 신자영
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

public class SpaceAllocationManageDBDAOMultiSpcAlocPolPod047USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiSpcAlocPolPod047
	  * CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOMultiSpcAlocPolPod047USQL(){
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
		params.put("fcast_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_45ft_hc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_rd_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_d4_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_40ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_rf_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asgn_d2_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcast_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOMultiSpcAlocPolPod047USQL").append("\n"); 
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
		query.append("   SET ( " ).append("\n"); 
		query.append("         ASGN_TTL_QTY        ," ).append("\n"); 
		query.append("         ASGN_20FT_QTY       ," ).append("\n"); 
		query.append("         ASGN_40FT_QTY       ," ).append("\n"); 
		query.append("         ASGN_40FT_HC_QTY    ," ).append("\n"); 
		query.append("         ASGN_45FT_HC_QTY    ," ).append("\n"); 
		query.append("         ASGN_53FT_QTY       ," ).append("\n"); 
		query.append("         ASGN_RF_QTY         ," ).append("\n"); 
		query.append("         ASGN_TTL_WGT        ," ).append("\n"); 
		query.append("         BKG_AVAL_TTL_QTY    ," ).append("\n"); 
		query.append("         BKG_AVAL_20FT_QTY   ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_QTY   ," ).append("\n"); 
		query.append("         BKG_AVAL_40FT_HC_QTY," ).append("\n"); 
		query.append("         BKG_AVAL_45FT_HC_QTY," ).append("\n"); 
		query.append("         BKG_AVAL_53FT_QTY   ," ).append("\n"); 
		query.append("         BKG_AVAL_RF_QTY     ," ).append("\n"); 
		query.append("         BKG_AVAL_TTL_WGT    ," ).append("\n"); 
		query.append("         FCAST_TTL_QTY       ," ).append("\n"); 
		query.append("         FCAST_40FT_HC_QTY   ," ).append("\n"); 
		query.append("         FCAST_45FT_HC_QTY   ," ).append("\n"); 
		query.append("         FCAST_53FT_QTY      ," ).append("\n"); 
		query.append("         FCAST_RF_QTY        ," ).append("\n"); 
		query.append("         FCAST_TTL_WGT       ," ).append("\n"); 
		query.append("         USD_BKG_TTL_QTY     ," ).append("\n"); 
		query.append("         USD_BKG_20FT_QTY    ," ).append("\n"); 
		query.append("         USD_BKG_40FT_QTY    ," ).append("\n"); 
		query.append("         USD_BKG_40FT_HC_QTY ," ).append("\n"); 
		query.append("         USD_BKG_45FT_HC_QTY ," ).append("\n"); 
		query.append("         USD_BKG_53FT_QTY    ," ).append("\n"); 
		query.append("         USD_BKG_RF_QTY      ," ).append("\n"); 
		query.append("         USD_BKG_TTL_WGT     ," ).append("\n"); 
		query.append("         -- 2014.08.01 컬럼 추가" ).append("\n"); 
		query.append("    	 CUST_CNT_CD," ).append("\n"); 
		query.append("    	 CUST_SEQ," ).append("\n"); 
		query.append("    	 CTRT_NO," ).append("\n"); 
		query.append("    	 USA_BKG_MOD_CD," ).append("\n"); 
		query.append("    	 DEST_LOC_CD," ).append("\n"); 
		query.append("    	 ASGN_20FT_DRY_QTY," ).append("\n"); 
		query.append("    	 ASGN_40FT_DRY_QTY," ).append("\n"); 
		query.append("    	 ASGN_RD_QTY," ).append("\n"); 
		query.append("    	 BKG_AVAL_20FT_DRY_QTY," ).append("\n"); 
		query.append("    	 BKG_AVAL_40FT_DRY_QTY," ).append("\n"); 
		query.append("    	 BKG_AVAL_RD_QTY," ).append("\n"); 
		query.append("    	 FCAST_20FT_DRY_QTY," ).append("\n"); 
		query.append("    	 FCAST_40FT_DRY_QTY," ).append("\n"); 
		query.append("    	 FCAST_RD_QTY," ).append("\n"); 
		query.append("    	 USD_BKG_20FT_DRY_QTY," ).append("\n"); 
		query.append("    	 USD_BKG_40FT_DRY_QTY," ).append("\n"); 
		query.append("    	 USD_BKG_RD_QTY " ).append("\n"); 
		query.append("       ) = (" ).append("\n"); 
		query.append("              SELECT ASGN_TTL," ).append("\n"); 
		query.append("                     0       ," ).append("\n"); 
		query.append("                     0       ," ).append("\n"); 
		query.append("                     ASGN_HC ," ).append("\n"); 
		query.append("                     ASGN_45 ," ).append("\n"); 
		query.append("                     ASGN_53 ," ).append("\n"); 
		query.append("                     ASGN_RF ," ).append("\n"); 
		query.append("                     ASGN_WGT," ).append("\n"); 
		query.append("                     DECODE(SUB_OFC_CNT, 0, ASGN_TTL, A.BKG_AVAL_TTL_QTY)," ).append("\n"); 
		query.append("                     0       ," ).append("\n"); 
		query.append("                     0       ," ).append("\n"); 
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
		query.append("                     @[usd_bkg_ttl_wgt]     AS USD_BKG_TTL_WGT    ," ).append("\n"); 
		query.append("                     -- 2014.08.01 컬럼 추가" ).append("\n"); 
		query.append("                     DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2))," ).append("\n"); 
		query.append("      		     DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6))," ).append("\n"); 
		query.append("      		     @[ctrt_no] 	    AS CTRT_NO," ).append("\n"); 
		query.append("    		     DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod])," ).append("\n"); 
		query.append("             	     DECODE(@[del_cd], 'OTHERS', 'XXXXX', @[del_cd])," ).append("\n"); 
		query.append("                     ASGN_D2 ," ).append("\n"); 
		query.append("		     ASGN_D4 ," ).append("\n"); 
		query.append("		     ASGN_RD ," ).append("\n"); 
		query.append("		     DECODE(SUB_OFC_CNT, 0, ASGN_D2 , A.BKG_AVAL_20FT_DRY_QTY)," ).append("\n"); 
		query.append("		     DECODE(SUB_OFC_CNT, 0, ASGN_D4 , A.BKG_AVAL_40FT_DRY_QTY)," ).append("\n"); 
		query.append("		     DECODE(SUB_OFC_CNT, 0, ASGN_RD , A.BKG_AVAL_RD_QTY   )," ).append("\n"); 
		query.append("		     @[fcast_d2_qty]        AS FCAST_20FT_DRY_QTY ,   " ).append("\n"); 
		query.append("    		     @[fcast_d4_qty]        AS FCAST_40FT_DRY_QTY ,  " ).append("\n"); 
		query.append("    		     @[fcast_rd_qty]        AS FCAST_RD_QTY	  ,        " ).append("\n"); 
		query.append("    		     @[usd_bkg_d2_qty]      AS USD_BKG_20FT_DRY_QTY,  " ).append("\n"); 
		query.append("    		     @[usd_bkg_d4_qty]      AS USD_BKG_40FT_DRY_QTY,  " ).append("\n"); 
		query.append("    		     @[usd_bkg_rd_qty]      AS USD_BKG_RD_QTY         " ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT COUNT(1)            AS SUB_OFC_CNT," ).append("\n"); 
		query.append("                               @[asgn_ttl_qty]     AS ASGN_TTL   ," ).append("\n"); 
		query.append("                               @[asgn_20ft_qty]    AS ASGN_20    ," ).append("\n"); 
		query.append("                               @[asgn_40ft_qty]    AS ASGN_40    ," ).append("\n"); 
		query.append("                               @[asgn_40ft_hc_qty] AS ASGN_HC    ," ).append("\n"); 
		query.append("                               @[asgn_45ft_hc_qty] AS ASGN_45    ," ).append("\n"); 
		query.append("                               @[asgn_53ft_qty]    AS ASGN_53    ," ).append("\n"); 
		query.append("                               @[asgn_rf_qty]      AS ASGN_RF    ," ).append("\n"); 
		query.append("                               @[asgn_ttl_wgt]     AS ASGN_WGT   ," ).append("\n"); 
		query.append("                               -- 2014.08.01 컬럼추가" ).append("\n"); 
		query.append("                               @[asgn_d2_qty]      AS ASGN_D2    ," ).append("\n"); 
		query.append("    			       @[asgn_d4_qty]      AS ASGN_D4    ," ).append("\n"); 
		query.append("    			       @[asgn_rd_qty]      AS ASGN_RD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION O" ).append("\n"); 
		query.append("                         WHERE O.PRNT_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           )," ).append("\n"); 
		query.append("       ALOC_USR_ID  = @[upd_usr_id]," ).append("\n"); 
		query.append("       MNL_ALOC_RMK = '3'," ).append("\n"); 
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
		query.append("   -- Allocation 세분화 관련 추가" ).append("\n"); 
		query.append("   AND DEST_LOC_CD = DECODE(@[del_cd], 'OTHERS', 'XXXXX', @[del_cd]) " ).append("\n"); 
		query.append("   AND CUST_CNT_CD = DECODE(@[account_cd], 'OTHERS', 'XX', SUBSTR(@[account_cd], 1, 2))" ).append("\n"); 
		query.append("   AND CUST_SEQ = DECODE(@[account_cd], 'OTHERS', '999999', SUBSTR(@[account_cd], 3, 6))" ).append("\n"); 
		query.append("   AND CTRT_NO  = @[ctrt_no]" ).append("\n"); 
		query.append("   AND USA_BKG_MOD_CD = DECODE(@[us_mod], 'OTHERS', 'OTH',  @[us_mod]) " ).append("\n"); 
		query.append("   AND TS_FLG     = @[ts_flg]" ).append("\n"); 
		query.append("   AND MNL_FLG    = @[mnl_flg]" ).append("\n"); 
		query.append("   AND IOC_CD     = DECODE(@[ioc_cd], 'OCN', 'O', 'T-OCN', 'O', 'I')" ).append("\n"); 

	}
}