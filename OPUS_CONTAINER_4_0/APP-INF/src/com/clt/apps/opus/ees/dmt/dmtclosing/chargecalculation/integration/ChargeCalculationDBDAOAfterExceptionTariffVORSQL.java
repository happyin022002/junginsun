/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOAfterExceptionTariffVORSQL.java
*@FileTitle : Monthly Invoiced &amp; Collection by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.25 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOAfterExceptionTariffVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Discount의 Free Time일수 및 주말, 공휴일 포함 여부, Currency, Discount Ratio 또는 Discount Amount를 조회한다
	  * </pre>
	  */
	public ChargeCalculationDBDAOAfterExceptionTariffVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOAfterExceptionTariffVORSQL").append("\n"); 
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
		query.append("SELECT	RQST_OFC_CD," ).append("\n"); 
		query.append("(	SELECT USR_NM" ).append("\n"); 
		query.append("FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = RQST_USR_ID" ).append("\n"); 
		query.append(") RQST_USR_NM," ).append("\n"); 
		query.append("(	SELECT	PROG_OFC_CD" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_PROG	VP" ).append("\n"); 
		query.append("WHERE	D.AFT_EXPT_DAR_NO =	VP.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND		VP.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("AND		ROWNUM =  1" ).append("\n"); 
		query.append(") APRO_OFC_CD," ).append("\n"); 
		query.append("(	SELECT USR_NM" ).append("\n"); 
		query.append("FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = (" ).append("\n"); 
		query.append("SELECT	PROG_USR_ID" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_PROG	VP" ).append("\n"); 
		query.append("WHERE	D.AFT_EXPT_DAR_NO	=	VP.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND		VP.DMDT_EXPT_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("AND		ROWNUM =  1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") APRO_USR_NM," ).append("\n"); 
		query.append("M.AFT_EXPT_DAR_NO," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.FT_ADD_DYS	, C.FT_ADD_DYS)		ADD_DYS," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.FT_TTL_DYS	, C.FT_TTL_DYS)		TTL_DYS," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.XCLD_SAT_FLG	, C.XCLD_SAT_FLG)	XCLD_SAT_FLG," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.XCLD_SUN_FLG	, C.XCLD_SUN_FLG)	XCLD_SUN_FLG," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.XCLD_HOL_FLG	, C.XCLD_HOL_FLG)	XCLD_HOL_FLG," ).append("\n"); 
		query.append("D.CURR_CD," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.DC_AMT, C.CNTR_CHG_DC_AMT) DC_AMT," ).append("\n"); 
		query.append("DECODE(D.EACH_CNTR_FLG, 'N', D.DC_RTO, C.CNTR_CHG_DC_RTO) DC_RTO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",'' AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_RQST_DTL	D," ).append("\n"); 
		query.append("DMT_AFT_BKG_ADJ_RQST		M," ).append("\n"); 
		query.append("DMT_AFT_BKG_CNTR			C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	D.AFT_EXPT_DAR_NO	= @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND		D.AFT_EXPT_ADJ_SEQ	= @[aft_expt_adj_seq]" ).append("\n"); 
		query.append("AND		D.AFT_EXPT_DAR_NO	= M.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND		D.AFT_EXPT_DAR_NO	= C.AFT_EXPT_DAR_NO(+)" ).append("\n"); 
		query.append("AND		D.AFT_EXPT_ADJ_SEQ	= C.AFT_EXPT_ADJ_SEQ(+)" ).append("\n"); 
		query.append("AND		C.SYS_AREA_GRP_ID(+) = @[svr_id]" ).append("\n"); 
		query.append("AND		C.CNTR_NO(+)		= @[cntr_no]" ).append("\n"); 
		query.append("AND		C.CNTR_CYC_NO(+)	= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		C.DMDT_TRF_CD(+)	= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_LOC_DIV_CD(+) = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND 	C.CHG_SEQ(+) = 1" ).append("\n"); 

	}
}