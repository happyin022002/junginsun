/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CnlBKGCntrmanageDBDAOSearchCnlBKGCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.06.01 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CnlBKGCntrmanageDBDAOSearchCnlBKGCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCnlBKGCntrList SELECT
	  * </pre>
	  */
	public CnlBKGCntrmanageDBDAOSearchCnlBKGCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_bkgno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_blno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : CnlBKGCntrmanageDBDAOSearchCnlBKGCntrListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("TRSO.BKG_NO," ).append("\n"); 
		query.append("NVL(TRSO.BL_NO,'-') BL_NO," ).append("\n"); 
		query.append("NVL(TRO.por_cd,TRSO.por_cd) por_cd," ).append("\n"); 
		query.append("NVL(TRO.pol_cd,TRSO.pol_cd) pol_cd," ).append("\n"); 
		query.append("NVL(TRO.pod_cd,TRSO.pod_cd) pod_cd," ).append("\n"); 
		query.append("NVL(TRO.del_cd,TRSO.del_cd) del_cd," ).append("\n"); 
		query.append("NVL(AR_INV.sc_no,'-') SC_NO," ).append("\n"); 
		query.append("NVL(AR_INV.rfa_no,'-') RFA_NO," ).append("\n"); 
		query.append("NVL(TRO.CNTR_NO,'-') CNTR_NO," ).append("\n"); 
		query.append("TRO.CNTR_QTY CNTR_QTY," ).append("\n"); 
		query.append("NVL(TRO.IO_BND_CD,TRSO.TRSP_BND_CD) BND," ).append("\n"); 
		query.append("NVL(TRO.DE_TERM_CD,'-') term," ).append("\n"); 
		query.append("NVL(TRO.TRO_OFC,'-') TRO_OFC," ).append("\n"); 
		query.append("NVL(TRO.LOC_CD,'-') TRO_LOC," ).append("\n"); 
		query.append("TRSO.QTY tro_qty," ).append("\n"); 
		query.append("TRO.tro_rev tro_amt," ).append("\n"); 
		query.append("TRSO.inv_amt exp_inv," ).append("\n"); 
		query.append("case when AR_INV.ar_rev < 0 then 0 else AR_INV.ar_rev end ar_rev," ).append("\n"); 
		query.append("case when AR_INV.ar_rev < 0 then 0 - TRSO.inv_amt else AR_INV.ar_rev - TRSO.inv_amt end rev_exp," ).append("\n"); 
		query.append("AR_INV.CLT_OFC_CD cct_ofc," ).append("\n"); 
		query.append("TRSO.ex_rate," ).append("\n"); 
		query.append("TRO.TRO_ID," ).append("\n"); 
		query.append("TRSO.SO_OFC," ).append("\n"); 
		query.append("TRSO.SO_ID," ).append("\n"); 
		query.append("AR_INV.AR_OFC_CD rating_ofc," ).append("\n"); 
		query.append("AR_INV.rating_id," ).append("\n"); 
		query.append("NVL(TRO.bkg_sts_cd,TRSO.bkg_sts_cd) sts," ).append("\n"); 
		query.append("TRO.EUR_TRNS_TP_CD trm_type," ).append("\n"); 
		query.append("DECODE((SELECT 'Y' FROM TRS_EXPN_AUD_RMK RMK WHERE RMK.BKG_NO = TRSO.BKG_NO AND RMK.EAS_EXPN_TP_CD = 'CA' AND RMK.RMK_CTNT_SEQ = 1),'Y','Yes','No') rmk_ctnt" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("/********* SO 부분 ************/" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("BK.TO_BKG_NO BKG_NO, SO.BL_NO, NVL(SO.TRSP_BND_CD,'X') TRSP_BND_CD," ).append("\n"); 
		query.append("SUM(DECODE(SO.TRSP_SO_TP_CD,'Y',1,0)) QTY," ).append("\n"); 
		query.append("MAX(SO.CRE_OFC_CD) SO_OFC," ).append("\n"); 
		query.append("MAX(SO.CRE_USR_ID) SO_ID," ).append("\n"); 
		query.append("MAX(a.usd_locl_xch_rt) ex_rate," ).append("\n"); 
		query.append("MAX(BK.bkg_sts_cd) bkg_sts_cd," ).append("\n"); 
		query.append("MAX(BK.por_cd) por_cd," ).append("\n"); 
		query.append("MAX(BK.pol_cd) pol_cd," ).append("\n"); 
		query.append("MAX(BK.pod_cd) pod_cd," ).append("\n"); 
		query.append("MAX(BK.del_cd) del_cd," ).append("\n"); 
		query.append("MAX(BK.DE_TERM_CD) DE_TERM_CD," ).append("\n"); 
		query.append("round(SUM(trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD', round( (SO.inv_bzc_amt + SO.inv_etc_add_amt)/ a.usd_locl_xch_rt , 2), to_char(SO.cre_dt, 'YYYYMM' ) )), 2) INV_AMT" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO,gl_mon_xch_rt a, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${str_bkgno} != '' )" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[str_bkgno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_blno} != '' )" ).append("\n"); 
		query.append("AND BK.BL_NO  = @[str_blno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BK.TO_BKG_NO = SO.BKG_NO(+)" ).append("\n"); 
		query.append("AND NVL(SO.trsp_cost_dtl_mod_cd,'DR') IN('DR','CY')" ).append("\n"); 
		query.append("AND NVL(SO.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("and a.acct_xch_rt_lvl = 1  --- SO 환율 적용" ).append("\n"); 
		query.append("and a.curr_cd = NVL(SO.inv_curr_cd,'EUR')" ).append("\n"); 
		query.append("and a.acct_xch_rt_yrmon = to_char(NVL(SO.cre_dt,SYSDATE), 'YYYYMM' )" ).append("\n"); 
		query.append("GROUP BY BK.TO_BKG_NO, SO.BL_NO, SO.TRSP_BND_CD" ).append("\n"); 
		query.append(") TRSO," ).append("\n"); 
		query.append("/********* TRO 부분 ************/" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("BKG.TO_BKG_NO BKG_NO, NVL(TRO.IO_BND_CD,'X') IO_BND_CD," ).append("\n"); 
		query.append("1 CNTR_QTY," ).append("\n"); 
		query.append("-- case when tro.cntr_no is null then 'N/A' else tro.cntr_no end cntr_no," ).append("\n"); 
		query.append("(SELECT EQ_NO FROM TRS_TRSP_SVC_ORD SO WHERE SO.BKG_NO = BKG.TO_BKG_NO AND SO.TRO_SEQ = NVL(TRO.TRO_SEQ,'1')) cntr_no," ).append("\n"); 
		query.append("MAX(BKG.bkg_sts_cd) bkg_sts_cd," ).append("\n"); 
		query.append("MAX(BKG.por_cd) por_cd," ).append("\n"); 
		query.append("MAX(BKG.pol_cd) pol_cd," ).append("\n"); 
		query.append("MAX(BKG.pod_cd) pod_cd," ).append("\n"); 
		query.append("MAX(BKG.del_cd) del_cd," ).append("\n"); 
		query.append("MAX(BKG.DE_TERM_CD) DE_TERM_CD," ).append("\n"); 
		query.append("MAX(tro.cre_ofc_cd) tro_ofc," ).append("\n"); 
		query.append("MAX(tro.upd_usr_id) tro_id," ).append("\n"); 
		query.append("MAX(tro.EUR_TRNS_TP_CD) EUR_TRNS_TP_CD," ).append("\n"); 
		query.append("MAX(troa.LOC_CD) LOC_CD," ).append("\n"); 
		query.append("round(SUM(trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD', round( (NVL(TRO.TRNS_REV_AMT,0)+NVL(TRO.NMF_TRNS_REV_AMT,0))/ B.usd_locl_xch_rt , 2) , to_char(NVL(tro.cre_dt,TRO.UPD_DT), 'YYYYMM' ))), 2)  tro_rev" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO TRO, BKG_EUR_TRO_DTL TROA, bkg_booking BKG, gl_mon_xch_rt B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${str_bkgno} != '' )" ).append("\n"); 
		query.append("AND BKG.bkg_no       = @[str_bkgno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_blno} != '' )" ).append("\n"); 
		query.append("AND BKG.bl_no        = @[str_blno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BKG.TO_BKG_NO = TRO.BKG_NO(+)" ).append("\n"); 
		query.append("AND BKG.TO_BKG_NO = TROA.BKG_NO(+)" ).append("\n"); 
		query.append("AND NVL(TROA.io_bnd_cd,'I') = NVL(TRO.io_bnd_cd,'I')" ).append("\n"); 
		query.append("AND NVL(TROA.tro_seq,'1') = NVL(TRO.tro_seq,'1')" ).append("\n"); 
		query.append("AND NVL(TROA.tro_sub_seq,'1') = 1" ).append("\n"); 
		query.append("AND B.acct_xch_rt_lvl = 1  --- TRO 환율 적용" ).append("\n"); 
		query.append("AND B.curr_cd = nvl(DECODE(tro.curr_cd,'   ','',tro.curr_cd), 'EUR')" ).append("\n"); 
		query.append("AND B.acct_xch_rt_yrmon = to_char(NVL(tro.cre_dt,SYSDATE), 'YYYYMM' )" ).append("\n"); 
		query.append("GROUP BY  BKG.TO_BKG_NO, TRO.IO_BND_CD,TRO.CNTR_NO,TRO.TRO_SEQ" ).append("\n"); 
		query.append(") TRO," ).append("\n"); 
		query.append("/********* AR INV 부분 ************/" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("BK.TO_BKG_NO BKG_NO, NVL(AR_MN.IO_BND_CD,'X') IO_BND_CD," ).append("\n"); 
		query.append("MAX(BR.CLT_OFC_CD) CLT_OFC_CD," ).append("\n"); 
		query.append("MAX(AR_MN.sc_no) sc_no," ).append("\n"); 
		query.append("MAX(AR_MN.rfa_no) rfa_no," ).append("\n"); 
		query.append("case when AR_MN.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("then round( sum( trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD', round( decode( AR_CHG.CHG_CD, 'OIH', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'MSC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'WHC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'OAR', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'LWS', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'HWS', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'PCS', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'WJC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt , 0 ) , 2), to_char(AR_MN.CRE_DT, 'YYYYMM' ) ) ), 2)" ).append("\n"); 
		query.append("else round( sum( trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD', round( decode( AR_CHG.CHG_CD, 'DIH', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'MSC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'WHC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'DDC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'DIC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'DAR', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'LWS', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'HWS', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'PCS', AR_CHG.CHG_AMT/c.usd_locl_xch_rt ," ).append("\n"); 
		query.append("'WJC', AR_CHG.CHG_AMT/c.usd_locl_xch_rt , 0 ) , 2), to_char(AR_MN.CRE_DT, 'YYYYMM' ) ) ), 2)" ).append("\n"); 
		query.append("end ar_rev," ).append("\n"); 
		query.append("MIN(AR_MN.AR_OFC_CD) AR_OFC_CD," ).append("\n"); 
		query.append("MAX(AR_MN.ACT_CUST_CNT_CD||AR_MN.ACT_CUST_SEQ) rating_id" ).append("\n"); 
		query.append("FROM INV_AR_MN AR_MN, INV_AR_CHG AR_CHG, BKG_RATE BR,gl_mon_xch_rt C, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${str_bkgno} != '' )" ).append("\n"); 
		query.append("AND BK.BKG_NO        = @[str_bkgno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_blno} != '' )" ).append("\n"); 
		query.append("AND BK.BL_NO         = @[str_blno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND AR_MN.AR_IF_NO = AR_CHG.AR_IF_NO" ).append("\n"); 
		query.append("AND BK.TO_BKG_NO = BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND BK.TO_BKG_NO = AR_MN.BKG_NO(+)" ).append("\n"); 
		query.append("and c.acct_xch_rt_lvl = 1" ).append("\n"); 
		query.append("and c.curr_cd = AR_CHG.CURR_CD --환율." ).append("\n"); 
		query.append("and c.acct_xch_rt_yrmon = to_char(NVL(AR_MN.CRE_DT,SYSDATE), 'YYYYMM') -- 환율 적용 월" ).append("\n"); 
		query.append("GROUP BY  BK.TO_BKG_NO, AR_MN.IO_BND_CD ) AR_INV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRSO.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("AND TRSO.BKG_NO = AR_INV.BKG_NO" ).append("\n"); 
		query.append("AND TRSO.TRSP_BND_CD = DECODE(TRSO.TRSP_BND_CD,'X','X',TRO.IO_BND_CD)" ).append("\n"); 
		query.append("AND TRSO.TRSP_BND_CD = DECODE(TRSO.TRSP_BND_CD,'X','X',AR_INV.IO_BND_CD)" ).append("\n"); 

	}
}