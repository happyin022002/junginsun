/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InlandRatesDBDAOPriTrfInlndRtVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.14 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRatesDBDAOPriTrfInlndRtVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inland rates 변경
	  * </pre>
	  */
	public InlandRatesDBDAOPriTrfInlndRtVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_one_wy_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_bse_loc_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_via_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_45ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_20ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_one_wy_40ft_hc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_lmt_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_one_wy_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inlnd_bx_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_one_wy_45ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_one_wy_bx_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_cmnc_amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_info_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_40ft_hc_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_40ft_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_bse_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_min_lmt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_inlnd_rt_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_rt_lmt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_inlnd_rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.inlandrates.integration").append("\n"); 
		query.append("FileName : InlandRatesDBDAOPriTrfInlndRtVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_INLND_RT" ).append("\n"); 
		query.append("   SET INLND_RT_BSE_LOC_CD         = @[inlnd_rt_bse_loc_cd]" ).append("\n"); 
		query.append("     , INLND_RT_BSE_LOC_ZIP_CD     = @[inlnd_rt_bse_loc_zip_cd]" ).append("\n"); 
		query.append("     , INLND_RT_TERM_CD            = @[inlnd_rt_term_cd]" ).append("\n"); 
		query.append("     , INLND_RT_VIA_LOC_CD         = @[inlnd_rt_via_loc_cd]" ).append("\n"); 
		query.append("     , PRC_INLND_RT_TRSP_MOD_CD    = @[prc_inlnd_rt_trsp_mod_cd]" ).append("\n"); 
		query.append("     , INLND_RT_LMT_WGT            = @[inlnd_rt_lmt_wgt]" ).append("\n"); 
		query.append("     , INLND_RT_MIN_LMT_WGT        = @[inlnd_rt_min_lmt_wgt]" ).append("\n"); 
		query.append("     , INLND_RT_LMT_WGT_UT_CD      = @[inlnd_rt_lmt_wgt_ut_cd]" ).append("\n"); 
		query.append("     , PRC_CGO_TP_CD               = @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append("     , CURR_CD                     = @[curr_cd]" ).append("\n"); 
		query.append("     , INLND_BX_RT_AMT             = @[inlnd_bx_rt_amt]" ).append("\n"); 
		query.append("     , INLND_20FT_RT_AMT           = @[inlnd_20ft_rt_amt]" ).append("\n"); 
		query.append("     , INLND_40FT_RT_AMT           = @[inlnd_40ft_rt_amt]" ).append("\n"); 
		query.append("     , INLND_40FT_HC_RT_AMT        = @[inlnd_40ft_hc_rt_amt]" ).append("\n"); 
		query.append("     , INLND_45FT_RT_AMT           = @[inlnd_45ft_rt_amt]" ).append("\n"); 
		query.append("     , INLND_ONE_WY_BX_RT_AMT      = @[inlnd_one_wy_bx_rt_amt]" ).append("\n"); 
		query.append("     , INLND_ONE_WY_20FT_RT_AMT    = @[inlnd_one_wy_20ft_rt_amt]" ).append("\n"); 
		query.append("     , INLND_ONE_WY_40FT_RT_AMT    = @[inlnd_one_wy_40ft_rt_amt]" ).append("\n"); 
		query.append("     , INLND_ONE_WY_40FT_HC_RT_AMT = @[inlnd_one_wy_40ft_hc_rt_amt]" ).append("\n"); 
		query.append("     , INLND_ONE_WY_45FT_RT_AMT    = @[inlnd_one_wy_45ft_rt_amt]" ).append("\n"); 
		query.append("     , INLND_RT_RMK                = @[inlnd_rt_rmk]" ).append("\n"); 
		query.append("     , UPD_USR_ID                  = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT                      = SYSDATE" ).append("\n"); 
		query.append("	 , N1ST_CMNC_AMDT_SEQ		   = NVL(@[n1st_cmnc_amdt_seq], N1ST_CMNC_AMDT_SEQ)" ).append("\n"); 
		query.append("	 , SRC_INFO_CD     			   = NVL(@[src_info_cd], SRC_INFO_CD)" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD		   		   = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO                      = @[trf_no]" ).append("\n"); 
		query.append("   AND TRF_INLND_SEQ               = @[trf_inlnd_seq]" ).append("\n"); 
		query.append("   AND AMDT_SEQ                    = @[amdt_seq]" ).append("\n"); 
		query.append("   AND TRF_INLND_RT_SEQ            = @[trf_inlnd_rt_seq]" ).append("\n"); 

	}
}