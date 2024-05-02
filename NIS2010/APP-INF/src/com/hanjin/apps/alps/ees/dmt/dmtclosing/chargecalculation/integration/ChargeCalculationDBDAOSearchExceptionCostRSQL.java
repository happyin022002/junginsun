/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchExceptionCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.12.11 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchExceptionCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container 별 Yard Exception Cost를 조회함.
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchExceptionCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchExceptionCostRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(EC.DMDT_BZC_FT_END_DT, 'YYYYMMDD') DMDT_BZC_FT_END_DT , " ).append("\n"); 
		query.append("       TO_CHAR(EC.EXPT_FT_END_DT, 'YYYYMMDD') EXPT_FT_END_DT, " ).append("\n"); 
		query.append("       TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT, " ).append("\n"); 
		query.append("       EC.EXPT_DYS, EC.EXPT_COST_AMT," ).append("\n"); 
		query.append("       'USD' AS BZC_TRF_CURR_CD,   " ).append("\n"); 
		query.append("       EY.CURR_CD, " ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'DTIC' || ${dmdt_trf_cd} == 'CTIC' ) " ).append("\n"); 
		query.append("     DECODE( SUBSTR(B.CNTR_TPSZ_CD, 2, 1), " ).append("\n"); 
		query.append("              '2', ( NVL(EY.CNTR_COST_20FT_RT_AMT,0) + NVL(EY.OTR_COST_20FT_RT_AMT,0)" ).append("\n"); 
		query.append("                   + DECODE(B.BKG_DE_TERM_CD,'D',NVL(EY.CHG_COST_DOR_RT_AMT,0),NVL(EY.CHG_COST_CY_RT_AMT,0)))," ).append("\n"); 
		query.append("				   ( NVL(EY.CNTR_COST_40FT_RT_AMT,0) + NVL(EY.OTR_COST_40FT_RT_AMT,0)" ).append("\n"); 
		query.append("				   + DECODE(B.BKG_DE_TERM_CD,'D',NVL(EY.CHG_COST_DOR_RT_AMT,0),NVL(EY.CHG_COST_CY_RT_AMT,0)))" ).append("\n"); 
		query.append("				   )  AS EXP_RT_AMT," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      DECODE( SUBSTR(B.CNTR_TPSZ_CD, 2, 1), " ).append("\n"); 
		query.append("              '2', ( DECODE(DECODE(SUBSTR(@[dmdt_trf_cd],3,1),'O',B.BKG_RCV_TERM_CD, B.BKG_DE_TERM_CD),'O', 0, NVL(EY.TML_COST_20FT_RT_AMT,0)) + " ).append("\n"); 
		query.append("                     NVL(EY.CNTR_COST_20FT_RT_AMT,0) + NVL(EY.OTR_COST_20FT_RT_AMT,0) " ).append("\n"); 
		query.append("                    + DECODE(DECODE(SUBSTR(@[dmdt_trf_cd],3,1),'O',B.BKG_RCV_TERM_CD, B.BKG_DE_TERM_CD),'D',NVL(EY.CHG_COST_DOR_RT_AMT,0),NVL(EY.CHG_COST_CY_RT_AMT,0)))," ).append("\n"); 
		query.append("				   ( DECODE(DECODE(SUBSTR(@[dmdt_trf_cd],3,1),'O',B.BKG_RCV_TERM_CD, B.BKG_DE_TERM_CD),'O', 0, NVL(EY.TML_COST_40FT_RT_AMT,0)) + " ).append("\n"); 
		query.append("				     NVL(EY.CNTR_COST_40FT_RT_AMT,0) + NVL(EY.OTR_COST_40FT_RT_AMT,0)" ).append("\n"); 
		query.append("				    + DECODE(DECODE(SUBSTR(@[dmdt_trf_cd],3,1),'O',B.BKG_RCV_TERM_CD, B.BKG_DE_TERM_CD),'D',NVL(EY.CHG_COST_DOR_RT_AMT,0),NVL(EY.CHG_COST_CY_RT_AMT,0)))" ).append("\n"); 
		query.append("				    )  AS EXP_RT_AMT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     EY.CNTR_COST_STK_AMT " ).append("\n"); 
		query.append("FROM DMT_CHG_CALC      C," ).append("\n"); 
		query.append("     DMT_CHG_BKG_CNTR  B," ).append("\n"); 
		query.append("     DMT_YD_EXPT_COST EY," ).append("\n"); 
		query.append("     DMT_EXPT_CHG_CALC EC" ).append("\n"); 
		query.append("WHERE C.SYS_AREA_GRP_ID	=	@[svr_id]" ).append("\n"); 
		query.append("AND	  C.CNTR_NO			=	@[cntr_no]" ).append("\n"); 
		query.append("AND	  C.CNTR_CYC_NO		=	@[cntr_cyc_no]" ).append("\n"); 
		query.append("AND	  C.DMDT_TRF_CD		=	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND	  C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND	  C.CHG_SEQ			=	@[chg_seq]" ).append("\n"); 
		query.append("AND   C.CNTR_NO = EC.CNTR_NO" ).append("\n"); 
		query.append("AND   C.CNTR_CYC_NO = EC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND   C.DMDT_TRF_CD = EC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND   C.DMDT_CHG_LOC_DIV_CD = EC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND   C.CHG_SEQ = EC.CHG_SEQ" ).append("\n"); 
		query.append("AND   EC.YD_CD = EY.YD_CD" ).append("\n"); 
		query.append("AND   EC.YD_EXPT_COST_SEQ = EY.YD_EXPT_COST_SEQ" ).append("\n"); 
		query.append("AND   C.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND   C.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND   C.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 

	}
}