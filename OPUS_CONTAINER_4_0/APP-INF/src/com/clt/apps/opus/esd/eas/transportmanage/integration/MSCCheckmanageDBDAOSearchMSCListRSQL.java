/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MSCCheckmanageDBDAOSearchMSCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.12.21 박성진
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

public class MSCCheckmanageDBDAOSearchMSCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MSC Search List
	  * </pre>
	  */
	public MSCCheckmanageDBDAOSearchMSCListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromtrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("totrodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tromonth",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : MSCCheckmanageDBDAOSearchMSCListRSQL").append("\n"); 
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
		query.append("tros.cre_ofc_cd," ).append("\n"); 
		query.append("max(tros.bkg_no)  bkg_no," ).append("\n"); 
		query.append("MAX(AR_IF.ar_bl_all_no) bl_no," ).append("\n"); 
		query.append("max(decode(AR_IF.ar_inv_chg_tp_cd, 'MSC', AR_IF.bkg_io_bnd_cd, tros.IO_BND_CD)) bnd," ).append("\n"); 
		query.append("max(decode(AR_IF.ar_inv_chg_tp_cd, 'MSC', decode(AR_IF.bkg_io_bnd_cd, 'O', tros.rcv_term_cd, tros.de_term_cd),  decode(TROS.IO_BND_CD, 'O', tros.rcv_term_cd, tros.de_term_cd))) term," ).append("\n"); 
		query.append("'EUR' chg_curr_cd," ).append("\n"); 
		query.append("round( sum( trs_common_pkg.GET_CONVERSION_EUR_AMT_FNC( 'USD'," ).append("\n"); 
		query.append("round( decode( AR_IF.ar_inv_chg_tp_cd, 'MSC',  AR_IF.ar_chg_amt/c.usd_locl_xch_rt, 0 )  ,2),tros.cre_dt ) )" ).append("\n"); 
		query.append(", 2) ar_rev" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("IO_BND_CD bkg_io_bnd_cd," ).append("\n"); 
		query.append("BL_SRC_NO bl_no," ).append("\n"); 
		query.append("BKG_NO bkg_no," ).append("\n"); 
		query.append("CHG_CD ar_inv_chg_tp_cd," ).append("\n"); 
		query.append("CHG_AMT ar_chg_amt," ).append("\n"); 
		query.append("CURR_CD chg_curr_cd," ).append("\n"); 
		query.append("BL_SRC_NO ar_bl_all_no," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD trnk_vvd_cd," ).append("\n"); 
		query.append("AR_OFC_CD ar_ofc_cd," ).append("\n"); 
		query.append("ACT_CUST_CNT_CD||ACT_CUST_SEQ act_cust_cd" ).append("\n"); 
		query.append("FROM INV_AR_MN MN, INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE MN.AR_IF_NO = CHG.AR_IF_NO) AR_IF," ).append("\n"); 
		query.append("(select" ).append("\n"); 
		query.append("tro.cre_ofc_cd," ).append("\n"); 
		query.append("tro.bkg_no," ).append("\n"); 
		query.append("tro.bkg_no bkg_all_no," ).append("\n"); 
		query.append("bb.bl_no bl_no," ).append("\n"); 
		query.append("bb.rcv_term_cd," ).append("\n"); 
		query.append("bb.de_term_cd," ).append("\n"); 
		query.append("troa.IO_BND_CD," ).append("\n"); 
		query.append("to_char(tro.cre_dt, 'YYYYMM') cre_dt" ).append("\n"); 
		query.append("--from   trs_trsp_rqst_ord_hd tro, trs_trsp_rqst_ord_addr troa, bkg_booking bb" ).append("\n"); 
		query.append("from BKG_EUR_TRO tro, BKG_EUR_TRO_DTL troa, bkg_booking bb" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where  tro.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("and    bb.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("AND NVL (TRO.CXL_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("and    tro.cre_ofc_cd in (" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrCreOfcCd})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'${key}'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '${key}'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if( ( ${fromtrodate} != '' && ${fromtrodate} != 'YYYYMMDD' ) && ( ${totrodate} != '' && ${totrodate} != 'YYYYMMDD' ) )" ).append("\n"); 
		query.append("AND   TO_CHAR(tro.cre_dt,'YYYYMMDD') >= @[fromtrodate]" ).append("\n"); 
		query.append("AND   TO_CHAR(tro.cre_dt,'YYYYMMDD') <= @[totrodate] + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${tromonth} != '' && ${tromonth} != 'YYYYMM' )" ).append("\n"); 
		query.append("and   to_char(tro.cre_dt, 'YYYYMM') = @[tromonth]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and   tro.bkg_no = troa.bkg_no" ).append("\n"); 
		query.append("and   tro.io_bnd_cd = troa.io_bnd_cd" ).append("\n"); 
		query.append("and   tro.tro_seq = troa.tro_seq" ).append("\n"); 
		query.append("and   troa.tro_sub_seq > 1" ).append("\n"); 
		query.append("group by" ).append("\n"); 
		query.append("tro.cre_ofc_cd," ).append("\n"); 
		query.append("tro.bkg_no, bb.bl_no, bb.rcv_term_cd, bb.de_term_cd, troa.IO_BND_CD, to_char(tro.cre_dt, 'YYYYMM')" ).append("\n"); 
		query.append(") tros," ).append("\n"); 
		query.append("gl_mon_xch_rt c" ).append("\n"); 
		query.append("where  1=1" ).append("\n"); 
		query.append("AND tros.bl_no = AR_IF.ar_bl_all_no(+)" ).append("\n"); 
		query.append("#if( ${s_bnd} == 'I' )" ).append("\n"); 
		query.append("and   AR_IF.bkg_io_bnd_cd = 'I'" ).append("\n"); 
		query.append("#elseif( ${s_bnd} == 'O' )" ).append("\n"); 
		query.append("and   AR_IF.bkg_io_bnd_cd = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and   c.acct_xch_rt_lvl   = 1" ).append("\n"); 
		query.append("and   c.curr_cd           = NVL(AR_IF.chg_curr_cd,'EUR')                 -- 환율" ).append("\n"); 
		query.append("and   c.acct_xch_rt_yrmon = tros.cre_dt  -- 환율 적용 월" ).append("\n"); 
		query.append("group by" ).append("\n"); 
		query.append("tros.cre_ofc_cd,tros.bkg_no" ).append("\n"); 

	}
}