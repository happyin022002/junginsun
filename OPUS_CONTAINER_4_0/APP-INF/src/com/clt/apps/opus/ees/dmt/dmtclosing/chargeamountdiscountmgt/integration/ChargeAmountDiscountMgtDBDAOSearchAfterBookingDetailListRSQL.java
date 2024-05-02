/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.14 
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

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * After Booking Request Container 조회를 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDetailListRSQL").append("\n"); 
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
		query.append("SELECT	D.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",	E.CNTR_NO" ).append("\n"); 
		query.append(",	E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	E.SLS_OFC_CD" ).append("\n"); 
		query.append(",	D.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",	D.FT_DYS" ).append("\n"); 
		query.append(",	D.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",	D.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",	D.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",	D.BIL_AMT" ).append("\n"); 
		query.append(",	F.DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",	C.FT_ADD_DYS" ).append("\n"); 
		query.append(",	C.FT_TTL_DYS" ).append("\n"); 
		query.append(",	DECODE(C.XCLD_SAT_FLG, 'Y', 1, 0) XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	DECODE(C.XCLD_SUN_FLG, 'Y', 1, 0) XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	DECODE(C.XCLD_HOL_FLG, 'Y', 1, 0) XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	C.CNTR_CHG_DC_AMT" ).append("\n"); 
		query.append(",	C.CNTR_CHG_DC_RTO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_RQST A" ).append("\n"); 
		query.append(",	DMT_AFT_BKG_ADJ_RQST_DTL B" ).append("\n"); 
		query.append(",	DMT_AFT_BKG_CNTR C" ).append("\n"); 
		query.append(",	DMT_CHG_CALC D" ).append("\n"); 
		query.append(",	DMT_CHG_BKG_CNTR E" ).append("\n"); 
		query.append(",	DMT_INV_MN F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.AFT_EXPT_DAR_NO = B.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("#if(${apvl_ofc_cd} != '')" ).append("\n"); 
		query.append("AND	A.APRO_OFC_CD = @[apvl_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${dar_no} != '')" ).append("\n"); 
		query.append("AND	A.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${apvl_no} != '')" ).append("\n"); 
		query.append("AND	A.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND	B.AFT_EXPT_DAR_NO = C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND B.AFT_EXPT_ADJ_SEQ = C.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("AND C.SVR_ID = D.SVR_ID" ).append("\n"); 
		query.append("AND C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO = D.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND D.CHG_SEQ = 1" ).append("\n"); 
		query.append("AND D.SYS_AREA_GRP_ID = E.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND D.CNTR_NO = E.CNTR_NO" ).append("\n"); 
		query.append("AND D.CNTR_CYC_NO = E.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND E.BKG_NO = F.BKG_NO" ).append("\n"); 

	}
}