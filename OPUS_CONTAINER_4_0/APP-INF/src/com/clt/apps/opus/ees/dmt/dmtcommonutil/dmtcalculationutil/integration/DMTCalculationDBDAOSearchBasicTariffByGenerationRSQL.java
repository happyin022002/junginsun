/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchBasicTariffByGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchBasicTariffByGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBasicTariffByGeneration
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchBasicTariffByGenerationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchBasicTariffByGenerationRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED USE_NL( N G B ) NO_EXPAND" ).append("\n"); 
		query.append("INDEX_DESC   ( N XAK1DMT_TRF_RGN )" ).append("\n"); 
		query.append("INDEX        ( G XPKDMT_TRF_GRP )" ).append("\n"); 
		query.append("INDEX        ( B XPKDMT_TRF_CMB ) */" ).append("\n"); 
		query.append("G.TRF_SEQ" ).append("\n"); 
		query.append(",G.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",G.DMDT_TRF_CD" ).append("\n"); 
		query.append(",G.TRF_GRP_SEQ" ).append("\n"); 
		query.append(",G.DMDT_CHG_CMNC_TP_CD" ).append("\n"); 
		query.append(",G.CMNC_HR" ).append("\n"); 
		query.append(",G.XCLD_SAT_FLG" ).append("\n"); 
		query.append(",G.XCLD_SUN_FLG" ).append("\n"); 
		query.append(",G.XCLD_HOL_FLG" ).append("\n"); 
		query.append(",G.CURR_CD" ).append("\n"); 
		query.append(",G.DMDT_TRF_GRP_TP_CD" ).append("\n"); 
		query.append("FROM DMT_TRF_RGN N" ).append("\n"); 
		query.append(",DMT_TRF_GRP G" ).append("\n"); 
		query.append(",DMT_TRF_CMB B" ).append("\n"); 
		query.append("WHERE N.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'O' && ${dmdt_trf_cd} == 'DMIF')" ).append("\n"); 
		query.append("AND (   N.CVRG_CONTI_CD  = NVL(@[yrd_conti_cd], ' ')    	  OR N.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_CNT_CD 	= NVL(@[yrd_cnt_cd]  , ' ')       OR N.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_RGN_CD 	= NVL(@[yrd_rgn_cd]  , ' ')       OR N.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_STE_CD 	= NVL(@[yrd_ste_cd]  , ' ')       OR N.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_LOC_CD 	= NVL(@[yrd_loc_cd]  , ' ')       OR N.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_YD_CD  	= NVL(@[cvrg_yd_cd]  , ' ')       OR N.CVRG_YD_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CONTI_CD 	= NVL(@[pol_conti_cd], ' ')   OR N.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CNT_CD 	= NVL(@[pol_cnt_cd]  , ' ')   OR N.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_RGN_CD 	= NVL(@[pol_rgn_cd]  , ' ')   OR N.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_STE_CD 	= NVL(@[pol_ste_cd]  , ' ')   OR N.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_LOC_CD 	= NVL(@[pol_loc_cd]  , ' ')   OR N.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMIF')" ).append("\n"); 
		query.append("AND (   N.CVRG_CONTI_CD  = NVL(@[yrd_conti_cd], ' ')       OR N.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_CNT_CD 	= NVL(@[yrd_cnt_cd]  , ' ')       OR N.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_RGN_CD 	= NVL(@[yrd_rgn_cd]  , ' ')       OR N.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_STE_CD 	= NVL(@[yrd_ste_cd]  , ' ')       OR N.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_LOC_CD 	= NVL(@[yrd_loc_cd]  , ' ')       OR N.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_YD_CD  	= NVL(@[cvrg_yd_cd]  , ' ')       OR N.CVRG_YD_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CONTI_CD 	= NVL(@[por_conti_cd], ' ')   OR N.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CNT_CD 	= NVL(@[por_cnt_cd]  , ' ')   OR N.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_RGN_CD 	= NVL(@[por_rgn_cd]  , ' ')   OR N.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_STE_CD 	= NVL(@[por_ste_cd]  , ' ')   OR N.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_LOC_CD 	= NVL(@[por_loc_cd]  , ' ')   OR N.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("#elseif (${dmdt_trf_cd} == 'DTIC' || ${dmdt_trf_cd} == 'CTIC')" ).append("\n"); 
		query.append("AND (   N.CVRG_CONTI_CD 	= NVL(@[del_conti_cd], ' ')      OR N.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_CNT_CD 	= NVL(@[del_cnt_cd]  , ' ')      OR N.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_RGN_CD 	= NVL(@[del_rgn_cd]  , ' ')      OR N.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_STE_CD 	= NVL(@[del_ste_cd]  , ' ')      OR N.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_LOC_CD 	= NVL(@[del_loc_cd]  , ' ')      OR N.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CONTI_CD 	= NVL(@[por_conti_cd], ' ')  OR N.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CNT_CD 	= NVL(@[por_cnt_cd]  , ' ')  OR N.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_RGN_CD 	= NVL(@[por_rgn_cd]  , ' ')  OR N.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_STE_CD 	= NVL(@[por_ste_cd]  , ' ')  OR N.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_LOC_CD 	= NVL(@[por_loc_cd]  , ' ')  OR N.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DMOF')" ).append("\n"); 
		query.append("AND (   N.CVRG_CONTI_CD = NVL(@[yrd_conti_cd], ' ')       OR N.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_CNT_CD 	= NVL(@[yrd_cnt_cd]  , ' ')       OR N.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_RGN_CD 	= NVL(@[yrd_rgn_cd]  , ' ')       OR N.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_STE_CD 	= NVL(@[yrd_ste_cd]  , ' ')       OR N.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_LOC_CD 	= NVL(@[yrd_loc_cd]  , ' ')       OR N.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_YD_CD 	= NVL(@[cvrg_yd_cd]  , ' ')       OR N.CVRG_YD_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CONTI_CD = NVL(@[del_conti_cd], ' ')   OR N.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CNT_CD 	= NVL(@[del_cnt_cd]  , ' ')   OR N.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_RGN_CD 	= NVL(@[del_rgn_cd]  , ' ')   OR N.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_STE_CD 	= NVL(@[del_ste_cd]  , ' ')   OR N.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_LOC_CD 	= NVL(@[del_loc_cd]  , ' ')   OR N.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("#elseif (${dmdt_trf_cd} == 'DTOC' || ${dmdt_trf_cd} == 'CTOC')" ).append("\n"); 
		query.append("AND (   N.CVRG_CONTI_CD = NVL(@[por_conti_cd], ' ')       OR N.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_CNT_CD 	= NVL(@[por_cnt_cd]  , ' ')       OR N.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_RGN_CD 	= NVL(@[por_rgn_cd]  , ' ')       OR N.CVRG_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_STE_CD 	= NVL(@[por_ste_cd]  , ' ')       OR N.CVRG_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.CVRG_LOC_CD 	= NVL(@[por_loc_cd]  , ' ')       OR N.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CONTI_CD = NVL(@[del_conti_cd], ' ')   OR N.ORG_DEST_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_CNT_CD 	= NVL(@[del_cnt_cd]  , ' ')   OR N.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_RGN_CD 	= NVL(@[del_rgn_cd]  , ' ')   OR N.ORG_DEST_RGN_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_STE_CD 	= NVL(@[del_ste_cd]  , ' ')   OR N.ORG_DEST_STE_CD = ' ')" ).append("\n"); 
		query.append("AND (   N.ORG_DEST_LOC_CD 	= NVL(@[del_loc_cd]  , ' ')   OR N.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND N.SYS_AREA_GRP_ID 	= G.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND N.DMDT_TRF_CD 		= G.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND N.TRF_SEQ 			= G.TRF_SEQ" ).append("\n"); 
		query.append("--   AND N.CFM_FLG 			= 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${suth_chn_use_flg} == 'Y')" ).append("\n"); 
		query.append("AND N.SUTH_CHN_USE_FLG 	= 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND N.SUTH_CHN_USE_FLG 	= 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (   (" ).append("\n"); 
		query.append("G.EFF_DT <= TO_DATE (@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("G.EXP_DT  IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("G.EFF_DT  <= TO_DATE (@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("G.EXP_DT  >= TO_DATE (@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND G.SYS_AREA_GRP_ID 	= B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND G.DMDT_TRF_CD 		= B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND G.TRF_SEQ 			= B.TRF_SEQ" ).append("\n"); 
		query.append("AND G.TRF_GRP_SEQ  		= B.TRF_GRP_SEQ" ).append("\n"); 
		query.append("AND G.CFM_FLG 			= 'Y'" ).append("\n"); 
		query.append("AND B.DMDT_CNTR_TP_CD 	= @[dmdt_cntr_tp_cd]" ).append("\n"); 
		query.append("AND B.DMDT_CGO_TP_CD 	= @[dmdt_cgo_tp_cd]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}