/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchChargeCalculationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchChargeCalculationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking 승인처리시 After Booking 계산 대상 조회를 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchChargeCalculationListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchChargeCalculationListRSQL").append("\n"); 
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
		query.append("SELECT	ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	CHG_CALC.SYS_AREA_GRP_ID SVR_ID" ).append("\n"); 
		query.append(",	CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append(", 	CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append(", 	CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.CHG_SEQ" ).append("\n"); 
		query.append(", 	CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append(", 	CHG_CNTR.BL_NO" ).append("\n"); 
		query.append(", 	CHG_CNTR.VSL_CD" ).append("\n"); 
		query.append(", 	CHG_CNTR.SKD_VOY_NO" ).append("\n"); 
		query.append(", 	CHG_CNTR.SKD_DIR_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.CUST_CNT_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.CUST_SEQ" ).append("\n"); 
		query.append(", 	CHG_CALC.ACT_CNT_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.ACT_CUST_SEQ" ).append("\n"); 
		query.append(", 	SUBSTR(CHG_CALC.DMDT_TRF_CD, 3, 1) IO_BND_CD" ).append("\n"); 
		query.append(", 	CHG_CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", 	TO_CHAR(CHG_CALC.FM_MVMT_DT, 'YYYYMMDDHH24MI') FM_MVMT_DT" ).append("\n"); 
		query.append(", 	CHG_CALC.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(", 	TO_CHAR(CHG_CALC.TO_MVMT_DT, 'YYYYMMDDHH24MI') AS TO_MVMT_DT" ).append("\n"); 
		query.append(", 	CHG_CALC.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(", 	NVL(CHG_CALC.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append(", 	CHG_CALC.OFC_CD" ).append("\n"); 
		query.append(", 	CHG_CALC.OFC_RHQ_CD" ).append("\n"); 
		query.append(", 	NVL(CHG_CALC.DUL_TP_EXPT_FLG, 'N') AS DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(", 	CHG_CALC.CORR_RMK" ).append("\n"); 
		query.append(", 	CHG_CALC.DMDT_INV_NO" ).append("\n"); 
		query.append(", 	TO_CHAR(CHG_CALC.WEB_MTY_DT, 'YYYYMMDD') WEB_MTY_DT" ).append("\n"); 
		query.append(",	DECODE(CHG_CALC.DMDT_TRF_CD, 'DMIF', FT_END_DT, '') AS DEM_FT_END_DT" ).append("\n"); 
		query.append(",	DECODE(CHG_CALC.DMDT_TRF_CD, 'DTIC', FT_END_DT, '') AS DET_FT_END_DT" ).append("\n"); 
		query.append(",	DECODE(CHG_CALC.DMDT_TRF_CD, 'DTIC', FX_FT_OVR_DYS, '') AS DET_FT_OVR_DYS" ).append("\n"); 
		query.append(",	CHG_CALC.CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 	DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append(", 	DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(", 	DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append(", 	DMT_INV_MN INV_MN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 	ADJ_RQST_DTL.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.BKG_NO 		 = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID 	 = CHG_CALC.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_NO 			 = CHG_CALC.CNTR_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.CNTR_CYC_NO 		 = CHG_CALC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.DMDT_TRF_CD 	 = CHG_CALC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND	(" ).append("\n"); 
		query.append("(ADJ_RQST_DTL.EACH_CNTR_FLG = 'N')" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("ADJ_RQST_DTL.EACH_CNTR_FLG = 'Y'" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(CHG_CALC.SYS_AREA_GRP_ID, CHG_CALC.CNTR_NO, CHG_CALC.CNTR_CYC_NO, CHG_CALC.DMDT_TRF_CD, CHG_CALC.DMDT_CHG_LOC_DIV_CD, CHG_CALC.CHG_SEQ)" ).append("\n"); 
		query.append("IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_CNTR" ).append("\n"); 
		query.append("WHERE	AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("CNTR_CHG_DC_AMT > 0" ).append("\n"); 
		query.append("OR CNTR_CHG_DC_RTO > 0" ).append("\n"); 
		query.append("OR FT_ADD_DYS      > 0" ).append("\n"); 
		query.append("OR FT_TTL_DYS      > 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_CHG_STS_CD NOT IN ('P', 'T')" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_INV_NO = INV_MN.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_TRF_CD = INV_MN.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_CHG_LOC_DIV_CD NOT IN ('TSP', 'SZP')" ).append("\n"); 
		query.append("AND CHG_CALC.CHG_SEQ = 1" ).append("\n"); 

	}
}