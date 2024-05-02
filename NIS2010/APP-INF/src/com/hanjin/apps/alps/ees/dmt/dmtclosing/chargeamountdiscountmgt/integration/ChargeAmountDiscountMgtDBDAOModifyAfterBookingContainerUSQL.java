/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingContainerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.11 
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

public class ChargeAmountDiscountMgtDBDAOModifyAfterBookingContainerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 수정하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOModifyAfterBookingContainerUSQL(){
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
		params.put("apro_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_bil_aft_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_bil_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_bil_aft_dc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ft_ttl_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aft_expt_adj_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xcld_hol_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_chg_dc_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOModifyAfterBookingContainerUSQL").append("\n"); 
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
		query.append("UPDATE DMT_AFT_BKG_CNTR SET" ).append("\n"); 
		query.append("		CNTR_CHG_DC_AMT = @[cntr_chg_dc_amt]" ).append("\n"); 
		query.append("	,	CNTR_CHG_DC_RTO = @[cntr_chg_dc_rto]" ).append("\n"); 
		query.append("	,	FT_ADJ_FLG = DECODE(@[ft_adj_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	FT_ADD_DYS = @[ft_add_dys]" ).append("\n"); 
		query.append("	,	FT_TTL_DYS = @[ft_ttl_dys]" ).append("\n"); 
		query.append("	,	XCLD_SAT_FLG = DECODE(@[xcld_sat_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	XCLD_SUN_FLG = DECODE(@[xcld_sun_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	XCLD_HOL_FLG = DECODE(@[xcld_hol_flg], 1, 'Y', 'N')" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	UPD_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("	,	UPD_OFC_CD = @[upd_ofc_cd]" ).append("\n"); 
		query.append("    ,   BIL_AFT_DC_AMT = @[bil_aft_dc_amt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   AFT_BKG_CURR_CD = NVL(@[rqst_curr_cd],'')" ).append("\n"); 
		query.append("	,   RQST_BIL_AMT = NVL(@[rqst_bil_amt],0)" ).append("\n"); 
		query.append("	,   RQST_DC_AMT = NVL(@[rqst_dc_amt],0)" ).append("\n"); 
		query.append("	,   RQST_BIL_AFT_DC_AMT = NVL(@[rqst_bil_aft_dc_amt],0)" ).append("\n"); 
		query.append("	,   APRO_BIL_AMT = NVL(@[apro_bil_amt],0)" ).append("\n"); 
		query.append("	,   APRO_DC_AMT = NVL(@[apro_dc_amt],0)" ).append("\n"); 
		query.append("	,   APRO_BIL_AFT_DC_AMT = NVL(@[apro_bil_aft_dc_amt],0)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("	AND	AFT_EXPT_ADJ_SEQ = @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("	AND AFT_EXPT_CNTR_SEQ = @[aft_expt_cntr_seq]" ).append("\n"); 

	}
}