/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchPartialPaymentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
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

public class ChargeCalculationDBDAOSearchPartialPaymentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partial할 대상 Charge 조회
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchPartialPaymentRSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchPartialPaymentRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT" ).append("\n"); 
		query.append("	 C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("	,C.CNTR_NO" ).append("\n"); 
		query.append("	,C.CNTR_CYC_NO" ).append("\n"); 
		query.append("	,C.DMDT_TRF_CD" ).append("\n"); 
		query.append("	,C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	,C.OFC_CD" ).append("\n"); 
		query.append("	,C.CHG_SEQ" ).append("\n"); 
		query.append("	,DECODE(C.CHG_SEQ, 1, 'G', 'B') CHG_TYPE" ).append("\n"); 
		query.append("	,C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("	,TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append("	,C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("	,C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("	,TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append("	,C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("	,C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("	,C.DMDT_INV_NO" ).append("\n"); 
		query.append("	,D.CRE_OFC_CD" ).append("\n"); 
		query.append("	,D.INV_DTL_SEQ" ).append("\n"); 
		query.append("    ,(SELECT CNTR_TPSZ_CD FROM MST_CONTAINER" ).append("\n"); 
		query.append("        WHERE CNTR_NO = C.CNTR_NO)  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,DECODE(C.DMDT_INV_NO, NULL, '', NVL(D.INV_PRT_FLG, 'N')) PARTIAL_MARK	/* INVOICE NO가 존재하는 경우, PARTIAL MARK 표시 */" ).append("\n"); 
		query.append("	,I.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("	,C.CORR_RMK" ).append("\n"); 
		query.append("	,C.MVMT_UMCH_SEQ" ).append("\n"); 
		query.append("	,C.FM_MVMT_YR" ).append("\n"); 
		query.append("	,C.FM_MVMT_SEQ" ).append("\n"); 
		query.append("	,C.FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("	,C.TO_MVMT_YR" ).append("\n"); 
		query.append("	,C.TO_MVMT_SEQ" ).append("\n"); 
		query.append("	,C.TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("	,C.BZC_TRF_SEQ" ).append("\n"); 
		query.append("	,C.BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("	,C.RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,C.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,C.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("	,C.AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append("	,C.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("	,C.AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append("	,C.SC_NO" ).append("\n"); 
		query.append("	,C.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	,C.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("	,C.CUST_CNT_CD" ).append("\n"); 
		query.append("	,C.CUST_SEQ" ).append("\n"); 
		query.append("	,C.ACT_CNT_CD" ).append("\n"); 
		query.append("	,C.ACT_CUST_SEQ" ).append("\n"); 
		query.append("	,TO_CHAR(C.CFM_DT, 'YYYYMMDD') CFM_DT" ).append("\n"); 
		query.append("	,C.CFM_USR_ID" ).append("\n"); 
		query.append("	,C.CFM_OFC_CD" ).append("\n"); 
		query.append("	,TO_CHAR(C.CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("	,C.CRE_USR_ID" ).append("\n"); 
		query.append("	--,C.CRE_OFC_CD" ).append("\n"); 
		query.append("	,C.OFC_TRNS_FLG" ).append("\n"); 
		query.append("	,C.CALC_DT" ).append("\n"); 
		query.append("	,C.WEB_IND_FLG" ).append("\n"); 
		query.append("	,C.WEB_CRE_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(C.WEB_CRE_DT, 'YYYYMMDD') WEB_CRE_DT" ).append("\n"); 
		query.append("	,C.WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append("	,C.WEB_NTFY_PIC_TELCM_NO" ).append("\n"); 
		query.append("	,DECODE(C.WEB_IND_FLG, 'Y',	TO_CHAR(NVL(C.WEB_MTY_DT, C.TO_MVMT_DT), 'YYYYMMDD')," ).append("\n"); 
		query.append("								TO_CHAR(C.WEB_MTY_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("	) WEB_MTY_DT" ).append("\n"); 
		query.append("	,TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT	" ).append("\n"); 
		query.append("	,C.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append("	,C.CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append("	,C.OFC_RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	DMT_CHG_CALC	C," ).append("\n"); 
		query.append("		DMT_INV_MN		I," ).append("\n"); 
		query.append("		DMT_INV_DTL		D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	C.DMDT_INV_NO			=	I.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND		C.DMDT_INV_NO			=	D.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND		C.CNTR_NO				=	D.CNTR_NO(+)" ).append("\n"); 
		query.append("AND		C.CHG_SEQ				=	D.CHG_SEQ(+)" ).append("\n"); 
		query.append("AND		C.SYS_AREA_GRP_ID		=	@[svr_id]" ).append("\n"); 
		query.append("AND		C.CNTR_NO				=	@[cntr_no]" ).append("\n"); 
		query.append("AND		C.CNTR_CYC_NO			=	@[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		C.DMDT_TRF_CD			=	@[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_LOC_DIV_CD	=	@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		C.DMDT_CHG_STS_CD		<>	'D'" ).append("\n"); 
		query.append("ORDER BY C.CHG_SEQ" ).append("\n"); 

	}
}