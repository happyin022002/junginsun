/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOAddAfterBookingContainerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOAddAfterBookingContainerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Billable Amount per CNTR 정보를 입력하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOAddAfterBookingContainerCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_sat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_sun_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_bil_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_bil_aft_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_ttl_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_chg_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_adj_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_chg_dc_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apro_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_bil_aft_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_add_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_aft_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xcld_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOAddAfterBookingContainerCSQL").append("\n"); 
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
		query.append("MERGE INTO DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("  USING DUAL" ).append("\n"); 
		query.append("  ON (      AFT_EXPT_DAR_NO          =   @[aft_expt_dar_no]" ).append("\n"); 
		query.append("     AND    AFT_EXPT_ADJ_SEQ =   @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("     AND    AFT_EXPT_CNTR_SEQ = @[aft_expt_cntr_seq]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET " ).append("\n"); 
		query.append("     	SYS_AREA_GRP_ID = @[sys_area_grp_id]" ).append("\n"); 
		query.append("    ,	CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("    ,	CNTR_CYC_NO = @[cntr_cyc_no]" ).append("\n"); 
		query.append("    ,	DMDT_TRF_CD = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("    ,	DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("    ,	CHG_SEQ = @[chg_seq]" ).append("\n"); 
		query.append("	,	CNTR_CHG_DC_AMT = @[cntr_chg_dc_amt]" ).append("\n"); 
		query.append("	,	CNTR_CHG_DC_RTO = @[cntr_chg_dc_rto]" ).append("\n"); 
		query.append("	,	FT_ADJ_FLG = DECODE(@[ft_adj_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	FT_ADD_DYS = @[ft_add_dys]" ).append("\n"); 
		query.append("	,	FT_TTL_DYS = @[ft_ttl_dys]" ).append("\n"); 
		query.append("	,	XCLD_SAT_FLG = DECODE(@[xcld_sat_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	XCLD_SUN_FLG = DECODE(@[xcld_sun_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	XCLD_HOL_FLG = DECODE(@[xcld_hol_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	,	UPD_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("    ,   BIL_AFT_DC_AMT = @[bil_aft_dc_amt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   AFT_BKG_CURR_CD = NVL(@[rqst_curr_cd],'')" ).append("\n"); 
		query.append("	,   RQST_BIL_AMT = NVL(@[rqst_bil_amt],0)" ).append("\n"); 
		query.append("	,   RQST_DC_AMT = NVL(@[rqst_dc_amt],0)" ).append("\n"); 
		query.append("	,   RQST_BIL_AFT_DC_AMT = NVL(@[rqst_bil_aft_dc_amt],0)" ).append("\n"); 
		query.append("	,   APRO_BIL_AMT = NVL(@[apro_bil_amt],0)" ).append("\n"); 
		query.append("	,   APRO_DC_AMT = NVL(@[apro_dc_amt],0)" ).append("\n"); 
		query.append("	,   APRO_BIL_AFT_DC_AMT = NVL(@[apro_bil_aft_dc_amt],0)" ).append("\n"); 
		query.append("  WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("    	AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("    ,	AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("    ,	AFT_EXPT_CNTR_SEQ" ).append("\n"); 
		query.append("    ,	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("    ,	CNTR_NO" ).append("\n"); 
		query.append("    ,	CNTR_CYC_NO" ).append("\n"); 
		query.append("    ,	DMDT_TRF_CD" ).append("\n"); 
		query.append("    ,	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("    ,	CHG_SEQ" ).append("\n"); 
		query.append("    ,	CNTR_CHG_DC_AMT" ).append("\n"); 
		query.append("    ,	CNTR_CHG_DC_RTO" ).append("\n"); 
		query.append("    ,	FT_ADJ_FLG" ).append("\n"); 
		query.append("    ,	FT_ADD_DYS" ).append("\n"); 
		query.append("    ,	FT_TTL_DYS" ).append("\n"); 
		query.append("    ,	XCLD_SAT_FLG" ).append("\n"); 
		query.append("    ,	XCLD_SUN_FLG" ).append("\n"); 
		query.append("    ,	XCLD_HOL_FLG" ).append("\n"); 
		query.append("    ,	CRE_USR_ID" ).append("\n"); 
		query.append("    ,	CRE_DT" ).append("\n"); 
		query.append("    ,	CRE_OFC_CD" ).append("\n"); 
		query.append("    ,	UPD_USR_ID" ).append("\n"); 
		query.append("    ,	UPD_DT" ).append("\n"); 
		query.append("    ,	UPD_OFC_CD" ).append("\n"); 
		query.append("    ,   BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("    ,   AFT_BKG_CURR_CD" ).append("\n"); 
		query.append("    ,   RQST_BIL_AMT" ).append("\n"); 
		query.append("    ,   RQST_DC_AMT" ).append("\n"); 
		query.append("    ,   RQST_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("    ,   APRO_BIL_AMT" ).append("\n"); 
		query.append("    ,   APRO_DC_AMT" ).append("\n"); 
		query.append("    ,   APRO_BIL_AFT_DC_AMT" ).append("\n"); 
		query.append("    ) VALUES (" ).append("\n"); 
		query.append("    	@[aft_expt_dar_no]" ).append("\n"); 
		query.append("    ,	@[aft_expt_adj_seq]" ).append("\n"); 
		query.append("    ,	@[aft_expt_cntr_seq]" ).append("\n"); 
		query.append("    ,	@[sys_area_grp_id]" ).append("\n"); 
		query.append("    ,	@[cntr_no]" ).append("\n"); 
		query.append("    ,	@[cntr_cyc_no]" ).append("\n"); 
		query.append("    ,	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("    ,	@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("    ,	@[chg_seq]" ).append("\n"); 
		query.append("    ,	@[cntr_chg_dc_amt]" ).append("\n"); 
		query.append("    ,	@[cntr_chg_dc_rto]" ).append("\n"); 
		query.append("    ,	DECODE(@[ft_adj_flg],'1','Y','N')" ).append("\n"); 
		query.append("    ,	@[ft_add_dys]" ).append("\n"); 
		query.append("    ,	@[ft_ttl_dys]" ).append("\n"); 
		query.append("    ,	DECODE(@[xcld_sat_flg],'1','Y','N')" ).append("\n"); 
		query.append("    ,	DECODE(@[xcld_sun_flg],'1','Y','N')" ).append("\n"); 
		query.append("    ,	DECODE(@[xcld_hol_flg],'1','Y','N')" ).append("\n"); 
		query.append("    ,	@[cre_usr_id]" ).append("\n"); 
		query.append("    ,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("    ,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("    ,	@[cre_usr_id]" ).append("\n"); 
		query.append("    ,	NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("    ,	@[cre_ofc_cd]" ).append("\n"); 
		query.append("    ,	@[bil_aft_dc_amt]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,	NVL(@[rqst_curr_cd],'')" ).append("\n"); 
		query.append("    ,	NVL(@[rqst_bil_amt],0)" ).append("\n"); 
		query.append("    ,	NVL(@[rqst_dc_amt],0)" ).append("\n"); 
		query.append("    ,	NVL(@[rqst_bil_aft_dc_amt],0)" ).append("\n"); 
		query.append("    ,	NVL(@[apro_bil_amt],0)" ).append("\n"); 
		query.append("    ,	NVL(@[apro_dc_amt],0)" ).append("\n"); 
		query.append("    ,	NVL(@[apro_bil_aft_dc_amt],0)" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}