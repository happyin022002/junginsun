/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CHAuditTroArmanageDBDAOSearchChAuditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.09.13 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CHAuditTroArmanageDBDAOSearchChAuditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchChAuditList SELECT
	  * </pre>
	  */
	public CHAuditTroArmanageDBDAOSearchChAuditListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_fromsodate",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_tosodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("str_vvdno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : CHAuditTroArmanageDBDAOSearchChAuditListRSQL").append("\n"); 
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
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.BL_NO," ).append("\n"); 
		query.append("A.por_cd," ).append("\n"); 
		query.append("A.pol_cd," ).append("\n"); 
		query.append("A.pod_cd," ).append("\n"); 
		query.append("A.del_cd," ).append("\n"); 
		query.append("A.SC_NO," ).append("\n"); 
		query.append("A.RFA_NO," ).append("\n"); 
		query.append("A.CNTR_QTY," ).append("\n"); 
		query.append("A.BND," ).append("\n"); 
		query.append("A.term," ).append("\n"); 
		query.append("A.TRO_OFC," ).append("\n"); 
		query.append("A.TRO_LOC," ).append("\n"); 
		query.append("A.tro_qty," ).append("\n"); 
		query.append("A.tro_amt," ).append("\n"); 
		query.append("A.inv_amt," ).append("\n"); 
		query.append("A.ar_rev," ).append("\n"); 
		query.append("A.rev_exp," ).append("\n"); 
		query.append("A.cct_ofc," ).append("\n"); 
		query.append("A.ex_rate," ).append("\n"); 
		query.append("A.TRO_ID," ).append("\n"); 
		query.append("A.SO_OFC," ).append("\n"); 
		query.append("A.SO_ID," ).append("\n"); 
		query.append("A.rating_ofc," ).append("\n"); 
		query.append("A.rating_id," ).append("\n"); 
		query.append("A.sts," ).append("\n"); 
		query.append("A.EUR_TRNS_TP_CD," ).append("\n"); 
		query.append("A.rmk_ctnt" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TRO.BKG_NO," ).append("\n"); 
		query.append("TRO.BL_NO," ).append("\n"); 
		query.append("TRO.por_cd," ).append("\n"); 
		query.append("TRO.pol_cd," ).append("\n"); 
		query.append("TRO.pod_cd," ).append("\n"); 
		query.append("TRO.del_cd," ).append("\n"); 
		query.append("NVL(AR_INV.sc_no,'-') SC_NO," ).append("\n"); 
		query.append("NVL(AR_INV.rfa_no,'-') RFA_NO," ).append("\n"); 
		query.append("TRO.CNTR_QTY," ).append("\n"); 
		query.append("TRSO.IO_BND_CD BND," ).append("\n"); 
		query.append("TRSO.BKG_RCVDE_TERM_CD term," ).append("\n"); 
		query.append("TRO.TRO_OFC," ).append("\n"); 
		query.append("TRO.LOC_CD TRO_LOC," ).append("\n"); 
		query.append("TRSO.QTY tro_qty," ).append("\n"); 
		query.append("--TRO.tro_rev tro_amt," ).append("\n"); 
		query.append("TRSO.TRSO_REV tro_amt," ).append("\n"); 
		query.append("TRSO.inv_amt inv_amt," ).append("\n"); 
		query.append("case when AR_INV.ar_rev < 0 then 0 else AR_INV.ar_rev end ar_rev," ).append("\n"); 
		query.append("case when AR_INV.ar_rev < 0 then 0 - TRSO.inv_amt else AR_INV.ar_rev - TRSO.inv_amt end rev_exp," ).append("\n"); 
		query.append("AR_INV.CLT_OFC_CD cct_ofc," ).append("\n"); 
		query.append("TRSO.ex_rate," ).append("\n"); 
		query.append("TRO.TRO_ID," ).append("\n"); 
		query.append("TRSO.SO_OFC," ).append("\n"); 
		query.append("TRSO.SO_ID," ).append("\n"); 
		query.append("AR_INV.AR_OFC_CD rating_ofc," ).append("\n"); 
		query.append("AR_INV.rating_id," ).append("\n"); 
		query.append("TRO.bkg_sts_cd sts," ).append("\n"); 
		query.append("TRO.EUR_TRNS_TP_CD, -- trm_type" ).append("\n"); 
		query.append("DECODE((SELECT 'Y' FROM TRS_EXPN_AUD_RMK RMK WHERE RMK.BKG_NO = TRSO.BKG_NO AND RMK.EAS_EXPN_TP_CD = 'CA' AND RMK.RMK_CTNT_SEQ = 1),'Y','Yes','No') rmk_ctnt" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("/********* SO 부분 ************/" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TRO.BKG_NO, TRO.IO_BND_CD," ).append("\n"); 
		query.append("SUM(DECODE(SO.TRSP_SO_TP_CD,'Y',1,0)) QTY," ).append("\n"); 
		query.append("MAX(SO.CRE_OFC_CD) SO_OFC," ).append("\n"); 
		query.append("MAX(SO.CRE_USR_ID) SO_ID," ).append("\n"); 
		query.append("MAX(a.usd_locl_xch_rt) ex_rate," ).append("\n"); 
		query.append("MAX(SO.BKG_RCVDE_TERM_CD) BKG_RCVDE_TERM_CD," ).append("\n"); 
		query.append("round(SUM(trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD', round( (SO.inv_bzc_amt + SO.inv_etc_add_amt)/ a.usd_locl_xch_rt , 2), to_char(SO.cre_dt, 'YYYYMM' ) )), 2) INV_AMT," ).append("\n"); 
		query.append("SUM(TRO.tro_rev) TRSO_REV" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO,gl_mon_xch_rt a," ).append("\n"); 
		query.append("------------ 조회옵션으로 BKG 한정 ----------" ).append("\n"); 
		query.append("(SELECT BKG_NO,IO_BND_CD,TRO_SEQ," ).append("\n"); 
		query.append("round(SUM(trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD', round( (NVL(TRO.TRNS_REV_AMT,0)+NVL(TRO.NMF_TRNS_REV_AMT,0))/ B.usd_locl_xch_rt , 2) , to_char(NVL(tro.cre_dt,TRO.UPD_DT), 'YYYYMM' ))), 2)  tro_rev" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO TRO, gl_mon_xch_rt B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${data_type} != '' && ${data_type} == 'TRO')" ).append("\n"); 
		query.append("#if( ( ${str_fromsodate} != '' && ${str_fromsodate} != 'YYYYMMDD' ) && ( ${str_tosodate} != '' && ${str_tosodate} != 'YYYYMMDD' ) )" ).append("\n"); 
		query.append("AND TRO.CRE_DT >= TO_DATE(@[str_fromsodate],'YYYYMMDD')" ).append("\n"); 
		query.append("AND TRO.CRE_DT <= TO_DATE(@[str_tosodate],'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRO.cre_ofc_cd in (" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrCreOfcCd})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_bkgno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no       = @[str_bkgno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_blno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no  IN ( select bkg_no from bkg_booking where BL_NO = @[str_blno])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_vvdno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no  IN ( SELECT SO.BKG_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE SO.VSL_CD = SUBSTR(@[str_vvdno],0,4)" ).append("\n"); 
		query.append("AND SO.SKD_VOY_NO = SUBSTR(@[str_vvdno],5,4)" ).append("\n"); 
		query.append("AND SO.SKD_DIR_CD = SUBSTR(@[str_vvdno],9,1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRO.HLG_TP_CD = 'C'" ).append("\n"); 
		query.append("AND NVL(TRO.CXL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND B.acct_xch_rt_lvl = 1  --- TRO 환율 적용" ).append("\n"); 
		query.append("AND B.curr_cd = nvl(DECODE(tro.curr_cd,'   ','',tro.curr_cd), 'EUR')" ).append("\n"); 
		query.append("AND B.acct_xch_rt_yrmon = to_char(tro.cre_dt, 'YYYYMM' )" ).append("\n"); 
		query.append("GROUP BY BKG_NO,IO_BND_CD,TRO_SEQ) TRO" ).append("\n"); 
		query.append("---------------------------------------------" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SO.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD = TRO.IO_BND_CD" ).append("\n"); 
		query.append("AND SO.TRO_SEQ = TRO.TRO_SEQ" ).append("\n"); 
		query.append("and SO.trsp_cost_dtl_mod_cd IN('DR','CY')" ).append("\n"); 
		query.append("AND NVL(SO.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("and a.acct_xch_rt_lvl = 1  --- SO 환율 적용" ).append("\n"); 
		query.append("and a.curr_cd = SO.inv_curr_cd" ).append("\n"); 
		query.append("and a.acct_xch_rt_yrmon = to_char(SO.cre_dt, 'YYYYMM' )" ).append("\n"); 
		query.append("GROUP BY  TRO.BKG_NO, TRO.IO_BND_CD) TRSO," ).append("\n"); 
		query.append("/********* TRO 부분 ************/" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TRO.BKG_NO, TRO.IO_BND_CD," ).append("\n"); 
		query.append("--COUNT(TRO.TRO_SEQ) CNTR_QTY," ).append("\n"); 
		query.append("(SELECT COUNT(*) FROM BKG_CONTAINER CN WHERE CN.BKG_NO = TRO.BKG_NO) CNTR_QTY," ).append("\n"); 
		query.append("MAX(BKG.bl_no) BL_NO," ).append("\n"); 
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
		query.append("------------ 조회옵션으로 BKG 한정 ----------" ).append("\n"); 
		query.append("#if( ${data_type} != '' && ${data_type} == 'TRO')" ).append("\n"); 
		query.append("#if( ( ${str_fromsodate} != '' && ${str_fromsodate} != 'YYYYMMDD' ) && ( ${str_tosodate} != '' && ${str_tosodate} != 'YYYYMMDD' ) )" ).append("\n"); 
		query.append("AND TRO.CRE_DT >= TO_DATE(@[str_fromsodate],'YYYYMMDD')" ).append("\n"); 
		query.append("AND TRO.CRE_DT <= TO_DATE(@[str_tosodate],'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRO.cre_ofc_cd in (" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrCreOfcCd})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_bkgno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no       = @[str_bkgno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_blno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no  IN ( select bkg_no from bkg_booking where BL_NO = @[str_blno])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_vvdno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no  IN ( SELECT SO.BKG_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE SO.VSL_CD = SUBSTR(@[str_vvdno],0,4)" ).append("\n"); 
		query.append("AND SO.SKD_VOY_NO = SUBSTR(@[str_vvdno],5,4)" ).append("\n"); 
		query.append("AND SO.SKD_DIR_CD = SUBSTR(@[str_vvdno],9,1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRO.HLG_TP_CD = 'C'" ).append("\n"); 
		query.append("AND NVL(TRO.CXL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("---------------------------------------------" ).append("\n"); 
		query.append("AND TRO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND TROA.bkg_no = TRO.bkg_no" ).append("\n"); 
		query.append("and TROA.io_bnd_cd = TRO.io_bnd_cd" ).append("\n"); 
		query.append("and TROA.tro_seq = TRO.tro_seq" ).append("\n"); 
		query.append("and TROA.tro_sub_seq = 1" ).append("\n"); 
		query.append("AND B.acct_xch_rt_lvl = 1  --- TRO 환율 적용" ).append("\n"); 
		query.append("AND B.curr_cd = nvl(DECODE(tro.curr_cd,'   ','',tro.curr_cd), 'EUR')" ).append("\n"); 
		query.append("AND B.acct_xch_rt_yrmon = to_char(tro.cre_dt, 'YYYYMM' )" ).append("\n"); 
		query.append("GROUP BY  TRO.BKG_NO, TRO.IO_BND_CD ) TRO," ).append("\n"); 
		query.append("/********* AR INV 부분 ************/" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("TRO.BKG_NO, TRO.IO_BND_CD," ).append("\n"); 
		query.append("MAX(BR.CLT_OFC_CD) CLT_OFC_CD," ).append("\n"); 
		query.append("MAX(AR_MN.sc_no) sc_no," ).append("\n"); 
		query.append("MAX(AR_MN.rfa_no) rfa_no," ).append("\n"); 
		query.append("case when TRO.IO_BND_CD = 'O'" ).append("\n"); 
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
		query.append("FROM INV_AR_MN AR_MN, INV_AR_CHG AR_CHG, BKG_RATE BR,gl_mon_xch_rt C," ).append("\n"); 
		query.append("------------ 조회옵션으로 BKG 한정 ----------" ).append("\n"); 
		query.append("(SELECT BKG_NO,IO_BND_CD" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if( ${data_type} != '' && ${data_type} == 'TRO')" ).append("\n"); 
		query.append("#if( ( ${str_fromsodate} != '' && ${str_fromsodate} != 'YYYYMMDD' ) && ( ${str_tosodate} != '' && ${str_tosodate} != 'YYYYMMDD' ) )" ).append("\n"); 
		query.append("AND TRO.CRE_DT >= TO_DATE(@[str_fromsodate],'YYYYMMDD')" ).append("\n"); 
		query.append("AND TRO.CRE_DT <= TO_DATE(@[str_tosodate],'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRO.cre_ofc_cd in (" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrCreOfcCd})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_bkgno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no       = @[str_bkgno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_blno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no  IN ( select bkg_no from bkg_booking where BL_NO = @[str_blno])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and TRO.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and TRO.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_vvdno} != '' )" ).append("\n"); 
		query.append("AND   TRO.bkg_no  IN ( SELECT SO.BKG_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE SO.VSL_CD = SUBSTR(@[str_vvdno],0,4)" ).append("\n"); 
		query.append("AND SO.SKD_VOY_NO = SUBSTR(@[str_vvdno],5,4)" ).append("\n"); 
		query.append("AND SO.SKD_DIR_CD = SUBSTR(@[str_vvdno],9,1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TRO.HLG_TP_CD = 'C'" ).append("\n"); 
		query.append("AND NVL(TRO.CXL_FLG,'N') = 'N'" ).append("\n"); 
		query.append("GROUP BY BKG_NO,IO_BND_CD) TRO" ).append("\n"); 
		query.append("---------------------------------------------" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND AR_MN.AR_IF_NO = AR_CHG.AR_IF_NO" ).append("\n"); 
		query.append("AND AR_MN.IO_BND_CD = TRO.IO_BND_CD" ).append("\n"); 
		query.append("AND AR_MN.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("AND TRO.BKG_NO = BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND TRO.BKG_NO = AR_MN.BKG_NO" ).append("\n"); 
		query.append("and c.acct_xch_rt_lvl = 1" ).append("\n"); 
		query.append("and c.curr_cd = AR_CHG.CURR_CD --환율." ).append("\n"); 
		query.append("and c.acct_xch_rt_yrmon = to_char(AR_MN.CRE_DT, 'YYYYMM') -- 환율 적용 월" ).append("\n"); 
		query.append("GROUP BY  TRO.BKG_NO, TRO.IO_BND_CD ) AR_INV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND TRO.BKG_NO = TRSO.BKG_NO" ).append("\n"); 
		query.append("AND TRO.BKG_NO = AR_INV.BKG_NO" ).append("\n"); 
		query.append("AND TRO.IO_BND_CD = TRSO.IO_BND_CD" ).append("\n"); 
		query.append("AND TRO.IO_BND_CD = AR_INV.IO_BND_CD" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if( ${str_s_type} == 'M' )" ).append("\n"); 
		query.append("and (a.tro_rev - ar_rev > -10 and a.tro_rev - ar_rev < 10 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_type} == 'U' )" ).append("\n"); 
		query.append("and (a.tro_rev - ar_rev < -10 or a.tro_rev - ar_rev > 10  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and a.bnd = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and a.bnd = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_dtltype} == 'OI-1' )" ).append("\n"); 
		query.append("and a.sts in( 'X', 'A')  --O.1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_dtltype} == 'OI-6' )" ).append("\n"); 
		query.append("and a.EUR_TRNS_TP_CD ='FR'  and a.sts not in( 'X', 'A')  --O.6" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_dtltype} == 'OI-2' )" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and a.pod_cd = a.del_cd" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and a.por_cd = a.pol_cd" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'A' )" ).append("\n"); 
		query.append("and ((a.pod_cd = a.del_cd and a.bnd = 'I' ) or (a.por_cd = a.pol_cd and a.bnd = 'O'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and a.term='Y' and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A')  --O.2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_dtltype} == 'OI-3' )" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and  a.pod_cd = a.del_cd and a.pod_cd <> a.tro_loc" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and a.por_cd = a.pol_cd and a.pol_cd <> a.tro_loc" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'A' )" ).append("\n"); 
		query.append("and ((a.pod_cd = a.del_cd and a.pod_cd <> a.tro_loc and a.bnd = 'I')" ).append("\n"); 
		query.append("or (a.por_cd = a.pol_cd and a.pol_cd <> a.tro_loc and a.bnd = 'O'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and a.term='D'and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A')   --O.3" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_dtltype} == 'OI-4' )" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and  a.pod_cd <> a.del_cd and a.pod_cd <> a.tro_loc and a.del_cd <> a.tro_loc" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and a.por_cd <> a.pol_cd and a.por_cd <> a.tro_loc and a.pol_cd <> a.tro_loc" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'A' )" ).append("\n"); 
		query.append("and ((a.pod_cd <> a.del_cd and a.pod_cd <> a.tro_loc and a.del_cd <> a.tro_loc  and a.bnd = 'I')" ).append("\n"); 
		query.append("or (a.por_cd <> a.pol_cd and a.por_cd <> a.tro_loc and a.pol_cd <> a.tro_loc  and a.bnd = 'O'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A')  --I.4" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${str_dtltype} == 'OI-5' )" ).append("\n"); 
		query.append("#if( ${str_s_bnd} == 'I' )" ).append("\n"); 
		query.append("and ( a.sts in( 'X', 'A')   --I.1" ).append("\n"); 
		query.append("or ( a.pod_cd = a.del_cd and a.term='Y' and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') ) --I.2" ).append("\n"); 
		query.append("or ( a.pod_cd = a.del_cd and a.term='D' and a.pod_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') ) --I.3" ).append("\n"); 
		query.append("or ( a.pod_cd <> a.del_cd and a.pod_cd <> a.tro_loc and a.del_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') ) --I.4" ).append("\n"); 
		query.append("or ( a.EUR_TRNS_TP_CD ='FR' and a.sts not in( 'X', 'A')   )) --I.6" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'O' )" ).append("\n"); 
		query.append("and (a.sts in( 'X', 'A')    --O.1" ).append("\n"); 
		query.append("or ( a.por_cd = a.pol_cd and a.term='Y' and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') ) --O.2" ).append("\n"); 
		query.append("or ( a.por_cd = a.pol_cd and a.term='D' and a.pol_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A')  ) --O.3" ).append("\n"); 
		query.append("or ( a.por_cd <> a.pol_cd and a.por_cd <> a.tro_loc and a.pol_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') ) --O.4" ).append("\n"); 
		query.append("or ( a.EUR_TRNS_TP_CD ='FR'  and a.sts not in( 'X', 'A')  )) --O.6" ).append("\n"); 
		query.append("#elseif( ${str_s_bnd} == 'A' )" ).append("\n"); 
		query.append("and ( a.sts in( 'X', 'A')   --I.1" ).append("\n"); 
		query.append("or ( a.pod_cd = a.del_cd and a.term='Y' and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') and a.bnd = 'I') --I.2" ).append("\n"); 
		query.append("or ( a.por_cd = a.pol_cd and a.term='Y' and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') and a.bnd = 'O') --O.2" ).append("\n"); 
		query.append("or ( a.pod_cd = a.del_cd and a.term='D' and a.pod_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') and a.bnd = 'I') --I.3" ).append("\n"); 
		query.append("or ( a.por_cd = a.pol_cd and a.term='D' and a.pol_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') and a.bnd = 'O') --O.3" ).append("\n"); 
		query.append("or ( a.pod_cd <> a.del_cd and a.pod_cd <> a.tro_loc and a.del_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') and a.bnd = 'I') --I.4" ).append("\n"); 
		query.append("or ( a.por_cd <> a.pol_cd and a.por_cd <> a.tro_loc and a.pol_cd <> a.tro_loc and a.ar_rev - a.inv_amt < 0  and a.sts not in( 'X', 'A') and a.bnd = 'O') --O.4" ).append("\n"); 
		query.append("or ( a.EUR_TRNS_TP_CD ='FR' and a.sts not in( 'X', 'A')   )) --I.6" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}