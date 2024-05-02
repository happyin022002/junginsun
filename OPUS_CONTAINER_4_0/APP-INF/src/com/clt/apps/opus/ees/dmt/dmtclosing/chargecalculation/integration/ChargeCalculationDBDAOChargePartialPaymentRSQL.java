/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationDBDAOChargePartialPaymentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOChargePartialPaymentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOChargePartialPaymentRSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAOChargePartialPaymentRSQL(){
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
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOChargePartialPaymentRSQL").append("\n"); 
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
		query.append("SELECT   B.BKG_NO" ).append("\n"); 
		query.append("		,B.BL_NO" ).append("\n"); 
		query.append("        ,B.VSL_CD" ).append("\n"); 
		query.append("        ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,B.SKD_DIR_CD          " ).append("\n"); 
		query.append("        ,C.CUST_CNT_CD" ).append("\n"); 
		query.append("        ,C.CUST_SEQ" ).append("\n"); 
		query.append("        ,C.ACT_CNT_CD    " ).append("\n"); 
		query.append("        ,C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("        ,SUBSTR(@[dmdt_trf_cd], 3, 1) AS IO_BND_CD" ).append("\n"); 
		query.append("        ,NVL(( SELECT TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDDHH24MI') FROM CTM_MOVEMENT " ).append("\n"); 
		query.append("             WHERE C.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("               AND C.FM_MVMT_YR = CNMV_YR" ).append("\n"); 
		query.append("               AND C.FM_MVMT_SEQ = CNMV_SEQ" ).append("\n"); 
		query.append("               AND NVL(C.FM_MVMT_SPLIT_NO,' ')= CNMV_SPLIT_NO" ).append("\n"); 
		query.append("               AND 'DR' NOT IN ( C.FM_MVMT_STS_CD, C.TO_MVMT_STS_CD )" ).append("\n"); 
		query.append("               AND ROWNUM = 1 )" ).append("\n"); 
		query.append("              ,@[fm_mvmt_dt] || TO_CHAR(C.FM_MVMT_DT, 'HH24MI')) AS FM_MVMT_DT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if (${bydr} == 'DR')" ).append("\n"); 
		query.append("			,@[to_mvmt_dt] || TO_CHAR(C.FM_MVMT_DT, 'HH24MI') AS TO_MVMT_DT" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("        ,NVL(( SELECT TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDDHH24MI') FROM CTM_MOVEMENT " ).append("\n"); 
		query.append("             WHERE C.CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("               AND C.TO_MVMT_YR = CNMV_YR" ).append("\n"); 
		query.append("               AND C.TO_MVMT_SEQ = CNMV_SEQ" ).append("\n"); 
		query.append("               AND NVL(C.TO_MVMT_SPLIT_NO,' ')= CNMV_SPLIT_NO" ).append("\n"); 
		query.append("               AND 'DR' NOT IN ( C.FM_MVMT_STS_CD, C.TO_MVMT_STS_CD )" ).append("\n"); 
		query.append("               AND ROWNUM = 1 )" ).append("\n"); 
		query.append("			  ,@[to_mvmt_dt] || '0001') AS TO_MVMT_DT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,NVL(C.OFC_TRNS_FLG, 'N') OFC_TRNS_FLG" ).append("\n"); 
		query.append("        ,C.WEB_IND_FLG" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR    B" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC        C" ).append("\n"); 
		query.append("WHERE 	C.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND		C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		C.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		C.DMDT_TRF_CD		= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_LOC_DIV_CD = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		C.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND		B.SYS_AREA_GRP_ID	= C.SYS_AREA_GRP_ID  " ).append("\n"); 
		query.append("AND		B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("AND		B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 

	}
}