/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOSearchSubBFRExceptionByGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.10 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOSearchSubBFRExceptionByGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSubBFRExceptionByGeneration
	  * </pre>
	  */
	public DMTCalculationDBDAOSearchSubBFRExceptionByGenerationRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cntt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtt_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("efft_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pts_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_conti",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_rgn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_rgn",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT RFA_EXPT_APRO_NO TMP_APPR_NO" ).append("\n"); 
		query.append(",RFA_EXPT_DAR_NO TMP_REQ_NO" ).append("\n"); 
		query.append(",RFA_RQST_DTL_SEQ TMP_SEQ" ).append("\n"); 
		query.append(",FT_USE_FLG TMP_FTIME_MK" ).append("\n"); 
		query.append(",ADD_DYS TMP_ADD_DAY" ).append("\n"); 
		query.append(",TTL_DYS TMP_TTL_DAY" ).append("\n"); 
		query.append(",XCLD_SAT_FLG TMP_EXCL_SAT" ).append("\n"); 
		query.append(",XCLD_SUN_FLG TMP_EXCL_SUN" ).append("\n"); 
		query.append(",XCLD_HOL_FLG TMP_EXCL_HOLI" ).append("\n"); 
		query.append(",RT_USE_FLG TMP_RATE_MK" ).append("\n"); 
		query.append(",CURR_CD TMP_CUR_CD" ).append("\n"); 
		query.append("FROM (SELECT   M.RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",D.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",D.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",D.FT_USE_FLG" ).append("\n"); 
		query.append(",D.ADD_DYS" ).append("\n"); 
		query.append(",D.TTL_DYS" ).append("\n"); 
		query.append(",D.XCLD_SAT_FLG" ).append("\n"); 
		query.append(",D.XCLD_SUN_FLG" ).append("\n"); 
		query.append(",D.XCLD_HOL_FLG" ).append("\n"); 
		query.append(",D.RT_USE_FLG" ).append("\n"); 
		query.append(",D.CURR_CD" ).append("\n"); 
		query.append("FROM DMT_RFA_EXPT_TRF_DTL D" ).append("\n"); 
		query.append(",DMT_RFA_EXPT_TRF M" ).append("\n"); 
		query.append(",DMT_RFA_EXPT_CVRG_CMB C" ).append("\n"); 
		query.append("WHERE M.RFA_EXPT_DAR_NO = D.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND M.RFA_EXPT_VER_SEQ = D.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND D.RFA_EXPT_DAR_NO = C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND D.RFA_EXPT_VER_SEQ = C.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND D.RFA_RQST_DTL_SEQ = C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("AND D.EFF_DT <= TO_DATE (@[efft_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("AND D.EXP_DT >= TO_DATE (@[efft_dt], 'rrrrmmdd')" ).append("\n"); 
		query.append("AND M.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("AND M.RFA_EXPT_APRO_NO IS NOT NULL" ).append("\n"); 
		query.append("AND D.DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND D.DMDT_CNTR_TP_CD = @[cntr_tp]" ).append("\n"); 
		query.append("AND D.DMDT_CGO_TP_CD = @[cgo_tp]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I')" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_CONTI_CD = @[pol_conti_cd]" ).append("\n"); 
		query.append("OR C.ORG_DEST_CONTI_CD = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_CNT_CD = @[pol_cnt_cd]" ).append("\n"); 
		query.append("OR C.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_RGN_CD = @[pol_rgn_cd]" ).append("\n"); 
		query.append("OR NVL (C.ORG_DEST_RGN_CD, ' ') = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_LOC_CD = @[pol_loc_cd]" ).append("\n"); 
		query.append("OR C.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (   C.CVRG_CONTI_CD = @[del_conti_cd]" ).append("\n"); 
		query.append("OR C.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   C.CVRG_CNT_CD = @[del_cnt_cd]" ).append("\n"); 
		query.append("OR C.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   C.CVRG_RGN_CD = @[del_rgn_cd]" ).append("\n"); 
		query.append("OR NVL (C.CVRG_RGN_CD, ' ') = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (   C.CVRG_LOC_CD = @[del_loc_cd]" ).append("\n"); 
		query.append("OR C.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("#elseif (${io_bnd_cd} == 'O')" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_CONTI_CD = @[del_conti_cd]" ).append("\n"); 
		query.append("OR C.ORG_DEST_CONTI_CD = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_CNT_CD = @[del_cnt_cd]" ).append("\n"); 
		query.append("OR C.ORG_DEST_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_RGN_CD = @[del_rgn_cd]" ).append("\n"); 
		query.append("OR NVL (C.ORG_DEST_RGN_CD, ' ') = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (   C.ORG_DEST_LOC_CD = @[del_loc_cd]" ).append("\n"); 
		query.append("OR C.ORG_DEST_LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (   C.CVRG_CONTI_CD = @[pol_conti_cd]" ).append("\n"); 
		query.append("OR C.CVRG_CONTI_CD = ' ')" ).append("\n"); 
		query.append("AND (   C.CVRG_CNT_CD = @[pol_cnt_cd]" ).append("\n"); 
		query.append("OR C.CVRG_CNT_CD = ' ')" ).append("\n"); 
		query.append("AND (   C.CVRG_RGN_CD = @[pol_rgn_cd]" ).append("\n"); 
		query.append("OR NVL (C.CVRG_RGN_CD, ' ') = ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (   C.CVRG_LOC_CD = @[pol_loc_cd]" ).append("\n"); 
		query.append("OR C.CVRG_LOC_CD = ' ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND D.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("AND D.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("ORDER BY C.CVRG_CONTI_CD DESC" ).append("\n"); 
		query.append(",C.CVRG_CNT_CD DESC" ).append("\n"); 
		query.append(",C.CVRG_RGN_CD DESC" ).append("\n"); 
		query.append(",C.CVRG_LOC_CD DESC" ).append("\n"); 
		query.append(",C.ORG_DEST_CONTI_CD DESC" ).append("\n"); 
		query.append(",C.ORG_DEST_CONTI_CD DESC" ).append("\n"); 
		query.append("--   ,C.ORG_DEST_RGN_CD DESC" ).append("\n"); 
		query.append("--   ,C.ORG_DEST_LOC_CD DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOSearchSubBFRExceptionByGenerationRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}