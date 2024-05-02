/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChargeCalculationDBDAOmergeDmtExceptionChargeCalculationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOmergeDmtExceptionChargeCalculationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mergeDmtExceptionChargeCalculation
	  * </pre>
	  */
	public ChargeCalculationDBDAOmergeDmtExceptionChargeCalculationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_expt_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_bzc_ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_ft_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_cntr_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_trf_rt_adj_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incur_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incur_cntr_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("incur_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOmergeDmtExceptionChargeCalculationUSQL").append("\n"); 
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
		query.append("#if (${dmdt_chg_sts_cd} == 'D')" ).append("\n"); 
		query.append("    UPDATE  DMT_EXPT_CHG_CALC" ).append("\n"); 
		query.append("    SET     BKG_QTY               = 0" ).append("\n"); 
		query.append("            , INCUR_QTY             = 0" ).append("\n"); 
		query.append("            , INCUR_CNTR_TEU_KNT    = 0" ).append("\n"); 
		query.append("            , EXPT_QTY              = 0" ).append("\n"); 
		query.append("            , EXPT_CNTR_TEU_KNT     = 0" ).append("\n"); 
		query.append("            , INCUR_AMT             = 0" ).append("\n"); 
		query.append("            , EXPT_FT_AMT           = 0" ).append("\n"); 
		query.append("            , EXPT_TRF_RT_ADJ_AMT   = 0" ).append("\n"); 
		query.append("            , EXPT_DYS              = 0" ).append("\n"); 
		query.append("            , EXPT_COST_AMT         = 0" ).append("\n"); 
		query.append("            , UPD_DT                = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SYSDATE), SYSDATE)" ).append("\n"); 
		query.append("            , UPD_USR_ID            = @[upd_usr_id]" ).append("\n"); 
		query.append("            , UPD_OFC_CD            = @[upd_ofc_cd]" ).append("\n"); 
		query.append("    WHERE   BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("    AND     CNTR_NO             = @[cntr_no]" ).append("\n"); 
		query.append("    AND     CNTR_CYC_NO         = @[cntr_cyc_no]" ).append("\n"); 
		query.append("    AND     DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("    AND     DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("    AND     CHG_SEQ             = @[chg_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    MERGE INTO DMT_EXPT_CHG_CALC" ).append("\n"); 
		query.append("      USING DUAL" ).append("\n"); 
		query.append("      ON (      BKG_NO              = @[bkg_no]" ).append("\n"); 
		query.append("         AND    CNTR_NO             = @[cntr_no]" ).append("\n"); 
		query.append("         AND    CNTR_CYC_NO         = @[cntr_cyc_no]" ).append("\n"); 
		query.append("         AND    DMDT_TRF_CD         = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("         AND    DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("         AND    CHG_SEQ             = @[chg_seq]" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("      WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE" ).append("\n"); 
		query.append("          SET BKG_QTY               = @[bkg_qty]" ).append("\n"); 
		query.append("            , INCUR_QTY             = @[incur_qty]" ).append("\n"); 
		query.append("            , INCUR_CNTR_TEU_KNT    = @[incur_cntr_teu_knt]" ).append("\n"); 
		query.append("            , EXPT_QTY              = @[expt_qty]" ).append("\n"); 
		query.append("            , EXPT_CNTR_TEU_KNT     = @[expt_cntr_teu_knt]" ).append("\n"); 
		query.append("            , INCUR_AMT             = @[incur_amt]" ).append("\n"); 
		query.append("            , EXPT_FT_AMT           = @[expt_ft_amt]" ).append("\n"); 
		query.append("            , EXPT_TRF_RT_ADJ_AMT   = @[expt_trf_rt_adj_amt]" ).append("\n"); 
		query.append("            , EXPT_DYS              = CASE WHEN TO_NUMBER(@[expt_dys]) < 0 THEN 0 ELSE TO_NUMBER(@[expt_dys]) END" ).append("\n"); 
		query.append("            , EXPT_COST_AMT         = @[expt_cost_amt]" ).append("\n"); 
		query.append("            , DMDT_BZC_FT_END_DT    = TO_DATE(@[dmdt_bzc_ft_end_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("            , YD_CD                 = @[yd_cd]" ).append("\n"); 
		query.append("            , YD_EXPT_COST_SEQ      = @[yd_expt_cost_seq]" ).append("\n"); 
		query.append("            , EXPT_FT_END_DT        = TO_DATE(@[expt_ft_end_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("            , UPD_DT                = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SYSDATE), SYSDATE)" ).append("\n"); 
		query.append("            , UPD_USR_ID            = @[upd_usr_id]" ).append("\n"); 
		query.append("            , UPD_OFC_CD            = @[upd_ofc_cd]" ).append("\n"); 
		query.append("            , CNTR_TPSZ_CD          = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT (" ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("          , CNTR_NO" ).append("\n"); 
		query.append("          , CNTR_CYC_NO" ).append("\n"); 
		query.append("          , DMDT_TRF_CD" ).append("\n"); 
		query.append("          , DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("          , CHG_SEQ" ).append("\n"); 
		query.append("          , BKG_QTY" ).append("\n"); 
		query.append("          , INCUR_QTY" ).append("\n"); 
		query.append("          , INCUR_CNTR_TEU_KNT" ).append("\n"); 
		query.append("          , EXPT_QTY" ).append("\n"); 
		query.append("          , EXPT_CNTR_TEU_KNT" ).append("\n"); 
		query.append("          , INCUR_AMT" ).append("\n"); 
		query.append("          , EXPT_FT_AMT" ).append("\n"); 
		query.append("          , EXPT_TRF_RT_ADJ_AMT" ).append("\n"); 
		query.append("          , EXPT_DYS" ).append("\n"); 
		query.append("          , EXPT_COST_AMT" ).append("\n"); 
		query.append("          , DMDT_BZC_FT_END_DT" ).append("\n"); 
		query.append("          , YD_CD" ).append("\n"); 
		query.append("          , YD_EXPT_COST_SEQ" ).append("\n"); 
		query.append("          , EXPT_FT_END_DT" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , CRE_OFC_CD" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT" ).append("\n"); 
		query.append("          , UPD_OFC_CD" ).append("\n"); 
		query.append("          , CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("        VALUES (" ).append("\n"); 
		query.append("            @[bkg_no]" ).append("\n"); 
		query.append("          , @[cntr_no]" ).append("\n"); 
		query.append("          , @[cntr_cyc_no]" ).append("\n"); 
		query.append("          , @[dmdt_trf_cd]" ).append("\n"); 
		query.append("          , @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("          , @[chg_seq]" ).append("\n"); 
		query.append("          , @[bkg_qty]" ).append("\n"); 
		query.append("          , @[incur_qty]" ).append("\n"); 
		query.append("          , @[incur_cntr_teu_knt]" ).append("\n"); 
		query.append("          , @[expt_qty]" ).append("\n"); 
		query.append("          , @[expt_cntr_teu_knt]" ).append("\n"); 
		query.append("          , @[incur_amt]" ).append("\n"); 
		query.append("          , @[expt_ft_amt]" ).append("\n"); 
		query.append("          , @[expt_trf_rt_adj_amt]" ).append("\n"); 
		query.append("          , CASE WHEN TO_NUMBER(@[expt_dys]) < 0 THEN 0 ELSE TO_NUMBER(@[expt_dys]) END" ).append("\n"); 
		query.append("          , @[expt_cost_amt]" ).append("\n"); 
		query.append("          , TO_DATE (@[dmdt_bzc_ft_end_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          , @[yd_cd]" ).append("\n"); 
		query.append("          , @[yd_expt_cost_seq]" ).append("\n"); 
		query.append("          , TO_DATE (@[expt_ft_end_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SYSDATE), SYSDATE)" ).append("\n"); 
		query.append("          , @[upd_ofc_cd]" ).append("\n"); 
		query.append("          , @[upd_usr_id]" ).append("\n"); 
		query.append("          , NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(SYSDATE), SYSDATE)" ).append("\n"); 
		query.append("          , @[upd_ofc_cd]" ).append("\n"); 
		query.append("          , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}