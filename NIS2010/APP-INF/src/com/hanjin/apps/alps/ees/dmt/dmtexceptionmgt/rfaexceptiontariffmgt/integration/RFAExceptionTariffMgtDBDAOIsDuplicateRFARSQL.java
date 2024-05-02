/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOIsDuplicateRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.09
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.01.09 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOIsDuplicateRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에 입력된 Before Booking Request 와 기등록된 Before Booking Request 중에 중복된 데이터가 있는지 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOIsDuplicateRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_dest_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cvrg_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOIsDuplicateRFARSQL").append("\n"); 
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
		query.append("SELECT MIN(DECODE(TRF.RFA_EXPT_DAR_NO||RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ||TRF.RFA_EXPT_VER_SEQ,@[rfa_expt_dar_no]||@[rfa_expt_mapg_seq]||@[rfa_expt_ver_seq]," ).append("\n"); 
		query.append("                 'in this version.', " ).append("\n"); 
		query.append("                 'with '||TRF.APRO_OFC_CD||'-approved version '||TRF.RFA_EXPT_VER_SEQ )) MSG" ).append("\n"); 
		query.append("FROM   DMT_RFA_EXPT_TRF_DTL 	RFA_TRF_DTL," ).append("\n"); 
		query.append("	   DMT_RFA_EXPT_CVRG_CMB	RFA_CVRG," ).append("\n"); 
		query.append("	   DMT_RFA_EXPT_TRF TRF" ).append("\n"); 
		query.append("WHERE  TRF.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("  AND  TRF.RFA_EXPT_DAR_NO   = RFA_TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("  AND  TRF.RFA_EXPT_MAPG_SEQ = RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("  AND  TRF.RFA_EXPT_VER_SEQ  = RFA_TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("  AND  RFA_TRF_DTL.RFA_EXPT_DAR_NO   = RFA_CVRG.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("  AND  RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ = RFA_CVRG.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("  AND  RFA_TRF_DTL.RFA_EXPT_VER_SEQ	 = RFA_CVRG.RFA_EXPT_VER_SEQ   " ).append("\n"); 
		query.append("  AND  RFA_TRF_DTL.RFA_RQST_DTL_SEQ	 = RFA_CVRG.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("  AND  TRF.DMDT_EXPT_RQST_STS_CD IN ('R','A','T')" ).append("\n"); 
		query.append("  AND  RFA_TRF_DTL.DMDT_TRF_CD       = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("  AND (" ).append("\n"); 
		query.append("            (RFA_TRF_DTL.EFF_DT >= TO_DATE(@[eff_dt], 'YYYYMMDD') AND RFA_TRF_DTL.EFF_DT <= TO_DATE(@[exp_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("		OR" ).append("\n"); 
		query.append("			(RFA_TRF_DTL.EFF_DT <= TO_DATE(@[eff_dt], 'YYYYMMDD') AND RFA_TRF_DTL.EXP_DT >= TO_DATE(@[eff_dt], 'YYYYMMDD'))" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.DMDT_CNTR_TP_CD 	 = @[dmdt_cntr_tp_cd]" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.DMDT_CGO_TP_CD	 = @[dmdt_cgo_tp_cd]" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.FNL_DEST_CONTI_CD = NVL(@[fnl_dest_conti_cd], ' ')" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.FNL_DEST_CNT_CD   = NVL(@[fnl_dest_cnt_cd], 	 ' ')" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.FNL_DEST_RGN_CD	 = NVL(@[fnl_dest_rgn_cd], 	 ' ')" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.FNL_DEST_STE_CD	 = NVL(@[fnl_dest_ste_cd], 	 ' ')" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.FNL_DEST_LOC_CD	 = NVL(@[fnl_dest_loc_cd], 	 ' ')" ).append("\n"); 
		query.append("   AND RFA_TRF_DTL.FT_USE_FLG        = DECODE(NVL(@[ft_use_flg],'1'),'1','Y','N')" ).append("\n"); 
		query.append("#if(${act_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("	AND RFA_TRF_DTL.ACT_CUST_CNT_CD  = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("	AND RFA_TRF_DTL.ACT_CUST_SEQ	 = @[act_cust_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND RFA_TRF_DTL.ACT_CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("	AND RFA_TRF_DTL.ACT_CUST_SEQ	IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND RFA_CVRG.CVRG_CNT_CD		= NVL(@[cvrg_cnt_cd], 	' ')" ).append("\n"); 
		query.append("	AND RFA_CVRG.CVRG_RGN_CD		= NVL(@[cvrg_rgn_cd], 	' ')" ).append("\n"); 
		query.append("	AND RFA_CVRG.CVRG_STE_CD		= NVL(@[cvrg_ste_cd], 	' ')" ).append("\n"); 
		query.append("	AND RFA_CVRG.CVRG_LOC_CD		= NVL(@[cvrg_loc_cd], 	' ')" ).append("\n"); 
		query.append("    AND RFA_TRF_DTL.RFA_EXPT_DAR_NO||RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ||RFA_TRF_DTL.RFA_EXPT_VER_SEQ||RFA_TRF_DTL.RFA_RQST_DTL_SEQ <> @[rfa_expt_dar_no]||@[rfa_expt_mapg_seq]||@[rfa_expt_ver_seq]||NVL(@[rfa_rqst_dtl_seq],' ')" ).append("\n"); 
		query.append("    AND ((RFA_TRF_DTL.RFA_EXPT_DAR_NO = @[rfa_expt_dar_no] AND RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ = @[rfa_expt_mapg_seq] AND RFA_TRF_DTL.RFA_EXPT_VER_SEQ >= @[rfa_expt_ver_seq]) " ).append("\n"); 
		query.append("         OR (RFA_TRF_DTL.RFA_EXPT_DAR_NO <> @[rfa_expt_dar_no] AND RFA_TRF_DTL.RFA_EXPT_MAPG_SEQ <> @[rfa_expt_mapg_seq]))" ).append("\n"); 
		query.append("#if(${coverage_list} != '')" ).append("\n"); 
		query.append("	AND (" ).append("\n"); 
		query.append("			(RFA_CVRG.ORG_DEST_CONTI_CD, RFA_CVRG.ORG_DEST_CNT_CD, RFA_CVRG.ORG_DEST_RGN_CD, RFA_CVRG.ORG_DEST_STE_CD, RFA_CVRG.ORG_DEST_LOC_CD) " ).append("\n"); 
		query.append("			IN" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("				#foreach( $coverage in ${list_coverage} )" ).append("\n"); 
		query.append("					#if($velocityCount < $list_coverage.size()) ($coverage), #else ($coverage) #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}