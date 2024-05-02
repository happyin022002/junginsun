/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchDualChargeTariffRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.03.24 황효근
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

public class ChargeCalculationDBDAOSearchDualChargeTariffRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchDualChargeTariffRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchDualChargeTariffRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchDualChargeTariffRSQL").append("\n"); 
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
		query.append("SELECT   C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_CYC_NO" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",C.CHG_SEQ" ).append("\n"); 
		query.append(",C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') AS FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') AS TO_MVMT_DT" ).append("\n"); 
		query.append(",C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.CORR_RMK" ).append("\n"); 
		query.append(",C.WEB_IND_FLG" ).append("\n"); 
		query.append(",C.OFC_CD" ).append("\n"); 
		query.append(",C.OFC_RHQ_CD" ).append("\n"); 
		query.append(",C.CUST_CNT_CD" ).append("\n"); 
		query.append(",C.CUST_SEQ" ).append("\n"); 
		query.append(",C.ACT_CNT_CD" ).append("\n"); 
		query.append(",C.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",SUBSTR(C.DMDT_TRF_CD, 3, 1) AS IO_BND_CD" ).append("\n"); 
		query.append(",NVL(C.OFC_TRNS_FLG, 'N') OFC_TRNS_FLG" ).append("\n"); 
		query.append(",TO_CHAR(C.WEB_MTY_DT, 'YYYYMMDD') AS WEB_MTY_DT" ).append("\n"); 
		query.append(",C.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",C.CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append(",B.BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",B.VSL_CD" ).append("\n"); 
		query.append(",B.SKD_VOY_NO" ).append("\n"); 
		query.append(",B.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR    B," ).append("\n"); 
		query.append("DMT_CHG_CALC        C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	C.SYS_AREA_GRP_ID	= @[svr_id]" ).append("\n"); 
		query.append("AND		C.CNTR_NO			= @[cntr_no]" ).append("\n"); 
		query.append("AND		C.CNTR_CYC_NO		= @[cntr_cyc_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'CTOC')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(		C.DMDT_TRF_CD           = 'DTOC'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD   = 'POR'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(		C.DMDT_TRF_CD           = 'DMOF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD   = 'POL'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(		C.DMDT_TRF_CD           = 'DMOF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD   = 'POR'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${dmdt_trf_cd} == 'CTIC')" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(		C.DMDT_TRF_CD           = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD   = 'POD'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(		C.DMDT_TRF_CD           = 'DTIC'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD   = 'DEL'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(		C.DMDT_TRF_CD           = 'DMIF'" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD   = 'DEL'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		C.CHG_SEQ			= @[chg_seq]" ).append("\n"); 
		query.append("AND		B.SYS_AREA_GRP_ID	= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND		B.CNTR_NO			= C.CNTR_NO" ).append("\n"); 
		query.append("AND		B.CNTR_CYC_NO		= C.CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dmdt_trf_cd} == 'CTOC')" ).append("\n"); 
		query.append("ORDER BY C.DMDT_TRF_CD ASC, C.DMDT_CHG_LOC_DIV_CD ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${dmdt_trf_cd} == 'CTIC')" ).append("\n"); 
		query.append("ORDER BY C.DMDT_TRF_CD DESC, C.DMDT_CHG_LOC_DIV_CD ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}