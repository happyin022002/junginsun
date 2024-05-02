/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselInformationMgtDBDAOMdmVslCntrExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOMdmVslCntrExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public VesselInformationMgtDBDAOMdmVslCntrExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOMdmVslCntrExcelVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       case rownum " ).append("\n"); 
		query.append("         when 1  then a.vsl_eng_nm" ).append("\n"); 
		query.append("         when 2  then 'VESSEL CODE : '||a.vsl_cd" ).append("\n"); 
		query.append("         when 3  then 'BUILDER                   '" ).append("\n"); 
		query.append("         when 4  then 'KEEL LAID                 '" ).append("\n"); 
		query.append("         when 5  then 'LAUNCHED DATE             '" ).append("\n"); 
		query.append("         when 6  then 'DELIVERED DATE            '" ).append("\n"); 
		query.append("         when 7  then 'REGISTERED DATE           '" ).append("\n"); 
		query.append("         when 8  then 'CALL SIGN                 '" ).append("\n"); 
		query.append("         when 9  then 'OFFICIAL NO               '" ).append("\n"); 
		query.append("         when 10 then 'IMO NO                   '" ).append("\n"); 
		query.append("         when 11 then 'CLASS                    '" ).append("\n"); 
		query.append("         when 12 then 'CLASS NO                  '" ).append("\n"); 
		query.append("         when 13 then 'PORT OF REGISTRY          '" ).append("\n"); 
		query.append("         when 14 then 'FLAG (NATIONALITY)        '" ).append("\n"); 
		query.append("         when 15 then 'OWNER                     '" ).append("\n"); 
		query.append("         when 16 then 'HULL NO                   '" ).append("\n"); 
		query.append("         when 17 then 'P & I CLUB                '" ).append("\n"); 
		query.append("         when 18 then 'CREW                      '" ).append("\n"); 
		query.append("         when 19 then 'TELEPHONE NO              '" ).append("\n"); 
		query.append("         when 20 then 'FAX NO                    '" ).append("\n"); 
		query.append("         when 21 then 'TELEX NO                  '" ).append("\n"); 
		query.append("         when 22 then 'E-MAIL ADDRESS            '" ).append("\n"); 
		query.append("         when 23 then 'DESIGN CAPACITY (TEU)     '" ).append("\n"); 
		query.append("         when 24 then 'OPERATION CAPACITY (TEU)  '" ).append("\n"); 
		query.append("         when 25 then 'PANAMA CAPACITY (TEU)     '" ).append("\n"); 
		query.append("         when 26 then 'VESSEL CLASS              '" ).append("\n"); 
		query.append("         when 27 then 'R/F RECEPTACLE - MAX      '" ).append("\n"); 
		query.append("         when 28 then 'R/F RECEPTACLE - OPERATION'" ).append("\n"); 
		query.append("         when 29 then 'MIN SPEED (KNOTS)    '" ).append("\n"); 
		query.append("         when 30 then 'SERVICE SPEED (KNOTS)     '" ).append("\n"); 
		query.append("         when 31 then 'MAX SPEED (KNOTS)         '" ).append("\n"); 
		query.append("         when 32 then 'L.O.A (M)                 '" ).append("\n"); 
		query.append("         when 33 then 'L.B.P (M)                 '" ).append("\n"); 
		query.append("         when 34 then 'BREADTH (M)               '" ).append("\n"); 
		query.append("         when 35 then 'DEPTH (M)                 '" ).append("\n"); 
		query.append("         when 36 then 'HEIGHT (M)                '" ).append("\n"); 
		query.append("         when 37 then 'SUMMER DRAFT (M)          '" ).append("\n"); 
		query.append("         when 38 then 'FREEBOARD (M)             '" ).append("\n"); 
		query.append("         else '' " ).append("\n"); 
		query.append("       end as name1" ).append("\n"); 
		query.append(",      case rownum " ).append("\n"); 
		query.append("         when 1  then a.vsl_eng_nm" ).append("\n"); 
		query.append("         when 2  then 'VESSEL CODE : '||a.vsl_cd         " ).append("\n"); 
		query.append("         when 3  then a.vsl_bldr_nm       " ).append("\n"); 
		query.append("         when 4  then a.vsl_kel_ly_dt      " ).append("\n"); 
		query.append("         when 5  then a.vsl_lnch_dt   " ).append("\n"); 
		query.append("         when 6  then a.vsl_de_dt  " ).append("\n"); 
		query.append("         when 7  then a.rgst_dt     " ).append("\n"); 
		query.append("         when 8  then a.call_sgn_no" ).append("\n"); 
		query.append("         when 9  then a.rgst_no " ).append("\n"); 
		query.append("         when 10 then a.lloyd_no      " ).append("\n"); 
		query.append("         when 11 then a.clss_no_rgst_area_nm         " ).append("\n"); 
		query.append("         when 12 then a.vsl_clss_no      " ).append("\n"); 
		query.append("         when 13 then a.rgst_port_cd" ).append("\n"); 
		query.append("         when 14 then a.cnt_nm       " ).append("\n"); 
		query.append("         when 15 then case a.vsl_own_ind_cd when 'O' then COM_CONSTANTMGR_PKG.COM_getCompanyName_FNC()" ).append("\n"); 
		query.append("                                            when 'C' then 'CHARTER'" ).append("\n"); 
		query.append("                      end    -- OWNER 재작업 필요    " ).append("\n"); 
		query.append("         when 16 then a.vsl_hl_no       " ).append("\n"); 
		query.append("         when 17 then a.piclb_desc             " ).append("\n"); 
		query.append("         when 18 then DECODE(a.crw_knt, 0, '', to_char(a.crw_knt))" ).append("\n"); 
		query.append("         when 19 then a.phn_no     " ).append("\n"); 
		query.append("         when 20 then a.fax_no" ).append("\n"); 
		query.append("         when 21 then a.tlx_no" ).append("\n"); 
		query.append("         when 22 then a.vsl_eml   " ).append("\n"); 
		query.append("         --when 5  then trim(to_char(a.lgt_shp_tong_wgt,'999,999,999.99'))          " ).append("\n"); 
		query.append("         when 23 then DECODE(a.cntr_dzn_capa,0,'',trim(to_char(a.cntr_dzn_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 24 then DECODE(a.cntr_op_capa,0,'',trim(to_char(a.cntr_op_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 25 then DECODE(a.cntr_pnm_capa,0,'',trim(to_char(a.cntr_pnm_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 26 then DECODE(a.cntr_vsl_clss_capa,0,'',trim(to_char(a.cntr_vsl_clss_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 27 then DECODE(a.rf_rcpt_knt,0,'',trim(to_char(a.rf_rcpt_knt,'99,999')))" ).append("\n"); 
		query.append("         when 28 then DECODE(a.rf_rcpt_max_knt,0,'',trim(to_char(a.rf_rcpt_max_knt,'99,999')))" ).append("\n"); 
		query.append("         when 29 then DECODE(a.ecn_spd,0,'',trim(to_char(a.ecn_spd,'99,999.99')))       " ).append("\n"); 
		query.append("         when 30 then DECODE(a.vsl_svc_spd,0,'',trim(to_char(a.vsl_svc_spd,'99,999.99')))" ).append("\n"); 
		query.append("         when 31 then DECODE(a.max_spd,0,'',trim(to_char(a.max_spd,'99,999.99')))" ).append("\n"); 
		query.append("         when 32 then DECODE(a.loa_len,0,'',trim(to_char(a.loa_len,'9,999,999.99')))" ).append("\n"); 
		query.append("         when 33 then DECODE(a.lbp_len,0,'',trim(to_char(a.lbp_len,'9,999,999.99')))" ).append("\n"); 
		query.append("         when 34 then DECODE(a.vsl_wdt,0,'',trim(to_char(a.vsl_wdt,'9,999,999.99')))" ).append("\n"); 
		query.append("         when 35 then DECODE(a.vsl_dpth,0,'',trim(to_char(a.vsl_dpth,'999,999.99')))         " ).append("\n"); 
		query.append("         when 36 then DECODE(a.vsl_hgt,0,'',trim(to_char(a.vsl_hgt,'99,999,999.99')))        " ).append("\n"); 
		query.append("         when 37 then DECODE(a.smr_drft_hgt,0,'',trim(to_char(a.smr_drft_hgt,'99,999,999.99')))         " ).append("\n"); 
		query.append("         when 38 then DECODE(a.fbd_capa,0,'',trim(to_char(a.fbd_capa,'999,999,999,999.99')))  " ).append("\n"); 
		query.append("         else '' " ).append("\n"); 
		query.append("       end as val1" ).append("\n"); 
		query.append(",      case rownum " ).append("\n"); 
		query.append("         when 1  then a.vsl_eng_nm" ).append("\n"); 
		query.append("         when 2  then 'ISSUE DATE : '||to_char(sysdate,'yyyy.mm.dd')" ).append("\n"); 
		query.append("         when 3  then 'DISPLACEMENT (MT)            '" ).append("\n"); 
		query.append("         when 4  then 'DEAD WEIGHT (MT)             '" ).append("\n"); 
		query.append("         when 5  then 'LIGHT SHIP (MT)              '" ).append("\n"); 
		query.append("         when 6  then 'INTERNATIONAL GROSS TON (MT) '" ).append("\n"); 
		query.append("         when 7  then 'INTERNATIONAL NET TON (MT)   '" ).append("\n"); 
		query.append("         when 8  then 'PANAMA GROSS TON (MT)        '" ).append("\n"); 
		query.append("         when 9  then 'PANAMA NET TON (MT)          '" ).append("\n"); 
		query.append("         when 10  then 'SUEZ GROSS TON (MT)          '" ).append("\n"); 
		query.append("         when 11  then 'SUEZ NET TON (MT)            '" ).append("\n"); 
		query.append("         when 12 then 'ITC (Y/N)                    '" ).append("\n"); 
		query.append("         when 13 then 'F.O TANK CAPACITY - 85% (MT) '" ).append("\n"); 
		query.append("         when 14 then 'D.O TANK CAPACITY - 85% (MT) '" ).append("\n"); 
		query.append("         when 15 then 'F.W TANK CAPACITY - 100% (MT)'" ).append("\n"); 
		query.append("         when 16 then 'B.W TANK CAPACITY - 100% (MT)'" ).append("\n"); 
		query.append("         when 17 then 'F.O CONSUMPTION (DAY)        '" ).append("\n"); 
		query.append("         when 18 then 'D.O CONSUMPTION (DAY)        '" ).append("\n"); 
		query.append("         when 19 then 'F.W CONSUMPTION (DAY)        '" ).append("\n"); 
		query.append("         when 20 then 'M/E MAKER                    '" ).append("\n"); 
		query.append("         when 21 then 'M/E TYPE                     '" ).append("\n"); 
		query.append("         when 22 then 'M/E BHP                      '" ).append("\n"); 
		query.append("         when 23 then 'M/E RPM                      '" ).append("\n"); 
		query.append("         when 24 then 'G/E MAKER                    '" ).append("\n"); 
		query.append("         when 25 then 'G/E TYPE                     '" ).append("\n"); 
		query.append("         when 26 then 'G/E BHP                      '" ).append("\n"); 
		query.append("         when 27 then 'G/E RPM                      '" ).append("\n"); 
		query.append("         when 28 then 'BOW THRUST MAKER             '" ).append("\n"); 
		query.append("         when 29 then 'BOW THRUST TYPE              '" ).append("\n"); 
		query.append("         when 30 then 'BOW THRUST BHP               '" ).append("\n"); 
		query.append("         when 31 then 'BOW THRUST RPM               '" ).append("\n"); 
		query.append("         when 32 then ''" ).append("\n"); 
		query.append("         when 33 then ''" ).append("\n"); 
		query.append("         when 34 then ''" ).append("\n"); 
		query.append("         when 35 then ''" ).append("\n"); 
		query.append("         when 36 then ''" ).append("\n"); 
		query.append("         when 37 then ''" ).append("\n"); 
		query.append("         when 38 then ''" ).append("\n"); 
		query.append("         else '' " ).append("\n"); 
		query.append("       end as name2" ).append("\n"); 
		query.append(",      case rownum " ).append("\n"); 
		query.append("         when 1  then a.vsl_eng_nm" ).append("\n"); 
		query.append("         when 2  then 'ISSUE DATE : '||to_char(sysdate,'yyyy.mm.dd')" ).append("\n"); 
		query.append("         when 3  then DECODE(a.dpl_capa,0,'',trim(to_char(a.dpl_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 4  then DECODE(a.dwt_wgt,0,'',trim(to_char(a.dwt_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 5  then DECODE(a.lgt_shp_tong_wgt,0,'',trim(to_char(a.lgt_shp_tong_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 6  then DECODE(a.grs_rgst_tong_wgt,0,'',trim(to_char(a.grs_rgst_tong_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 7  then DECODE(a.net_rgst_tong_wgt,0,'',trim(to_char(a.net_rgst_tong_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 8  then DECODE(a.pnm_gt_wgt,0,'',trim(to_char(a.pnm_gt_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 9  then DECODE(a.pnm_net_tong_wgt,0,'',trim(to_char(a.pnm_net_tong_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 10 then DECODE(a.suz_gt_wgt,0,'',trim(to_char(a.suz_gt_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 11 then DECODE(a.suz_net_tong_wgt,0,'',trim(to_char(a.suz_net_tong_wgt,'999,999,999.99')))" ).append("\n"); 
		query.append("         when 12 then a.intl_tong_certi_flg" ).append("\n"); 
		query.append("         when 13 then DECODE(a.foil_capa,0,'',trim(to_char(a.foil_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 14 then DECODE(a.doil_capa,0,'',trim(to_char(a.doil_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 15 then DECODE(a.frsh_wtr_capa,0,'',trim(to_char(a.frsh_wtr_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 16 then DECODE(a.blst_tnk_capa,0,'',trim(to_char(a.blst_tnk_capa,'999,999,999,999.99')))" ).append("\n"); 
		query.append("         when 17 then DECODE(a.foil_csm,0,'',trim(to_char(a.foil_csm,'99,999,999.99')))" ).append("\n"); 
		query.append("         when 18 then DECODE(a.doil_csm,0,'',trim(to_char(a.doil_csm,'99,999,999.99')))" ).append("\n"); 
		query.append("         when 19 then DECODE(a.frsh_wtr_csm,0,'',trim(to_char(a.frsh_wtr_csm,'99,999,999.99')))" ).append("\n"); 
		query.append("         when 20 then a.mn_eng_mkr_nm" ).append("\n"); 
		query.append("         when 21 then a.mn_eng_tp_desc" ).append("\n"); 
		query.append("         when 22 then DECODE(a.mn_eng_bhp_pwr,0,'',trim(to_char(a.mn_eng_bhp_pwr,'99,999,999')))" ).append("\n"); 
		query.append("         when 23 then DECODE(a.mn_eng_rpm_pwr,0,'',trim(to_char(a.mn_eng_rpm_pwr,'99,999,999')))" ).append("\n"); 
		query.append("         when 24 then a.gnr_mkr_nm" ).append("\n"); 
		query.append("         when 25 then a.gnr_tp_desc" ).append("\n"); 
		query.append("         when 26 then DECODE(a.gnr_bhp_pwr,0,'',trim(to_char(a.gnr_bhp_pwr,'99,999,999')))" ).append("\n"); 
		query.append("         when 27 then DECODE(a.gnr_rpm_pwr,0,'',trim(to_char(a.gnr_rpm_pwr,'99,999,999')))" ).append("\n"); 
		query.append("         when 28 then a.bwthst_mkr_nm" ).append("\n"); 
		query.append("         when 29 then a.bwthst_tp_desc" ).append("\n"); 
		query.append("         when 30 then DECODE(a.bwthst_bhp_pwr,0,'',trim(to_char(a.bwthst_bhp_pwr,'99,999,999')))" ).append("\n"); 
		query.append("         when 31 then DECODE(a.bwthst_rpm_pwr,0,'',trim(to_char(a.bwthst_rpm_pwr,'99,999,999')))" ).append("\n"); 
		query.append("         when 32 then ''" ).append("\n"); 
		query.append("         when 33 then ''" ).append("\n"); 
		query.append("         when 34 then ''" ).append("\n"); 
		query.append("         when 35 then ''" ).append("\n"); 
		query.append("         when 36 then ''" ).append("\n"); 
		query.append("         when 37 then ''" ).append("\n"); 
		query.append("         when 38 then ''" ).append("\n"); 
		query.append("         else '' " ).append("\n"); 
		query.append("       end as val2              " ).append("\n"); 
		query.append(" FROM ( " ).append("\n"); 
		query.append("        SELECT mvc.cntr_vsl_clss_capa                                             " ).append("\n"); 
		query.append("             , to_char(mvc.vsl_kel_ly_dt,'ddmonyy', 'nls_date_language=american') vsl_kel_ly_dt" ).append("\n"); 
		query.append("             , to_char(mvc.vsl_lnch_dt,'ddmonyy', 'nls_date_language=american') vsl_lnch_dt    " ).append("\n"); 
		query.append("             , to_char(mvc.vsl_de_dt,'ddmonyy', 'nls_date_language=american') vsl_de_dt         " ).append("\n"); 
		query.append("             , to_char(mvc.rgst_dt,'ddmonyy', 'nls_date_language=american') rgst_dt                          " ).append("\n"); 
		query.append("             , mvc.rf_rcpt_knt                                                    " ).append("\n"); 
		query.append("             , mvc.rf_rcpt_max_knt                                                             " ).append("\n"); 
		query.append("             , mvc.fbd_capa                                                                    " ).append("\n"); 
		query.append("             , mvc.dpl_capa                                                                    " ).append("\n"); 
		query.append("             , mvc.blst_tnk_capa                                                               " ).append("\n"); 
		query.append("             , mvc.foil_csm                                                                    " ).append("\n"); 
		query.append("             , mvc.doil_csm                                                                    " ).append("\n"); 
		query.append("             , mvc.frsh_wtr_csm                                                                " ).append("\n"); 
		query.append("             , mvc.mn_eng_rpm_pwr                                                              " ).append("\n"); 
		query.append("             , mvc.gnr_rpm_pwr                                                                 " ).append("\n"); 
		query.append("             , mvc.vsl_hgt                                                                     " ).append("\n"); 
		query.append("             , mvc.vsl_edi_nm                                                                  " ).append("\n"); 
		query.append("             , mvc.co_cd                                                                       " ).append("\n"); 
		query.append("             , mvc.vsl_clz_dt                                                                  " ).append("\n"); 
		query.append("             , mvc.vsl_cre_ofc_cd                                                              " ).append("\n"); 
		query.append("             , mvc.vsl_delt_ofc_cd                                                             " ).append("\n"); 
		query.append("             , mvc.vsl_bld_area_nm                                                             " ).append("\n"); 
		query.append("             , mvc.gnr_mkr_nm                                                                  " ).append("\n"); 
		query.append("             , mvc.gnr_tp_desc                                                                 " ).append("\n"); 
		query.append("             , mvc.gnr_bhp_pwr                                                                 " ).append("\n"); 
		query.append("             , mvc.bwthst_mkr_nm                                                               " ).append("\n"); 
		query.append("             , mvc.bwthst_tp_desc                                                              " ).append("\n"); 
		query.append("             , mvc.bwthst_bhp_pwr                                                              " ).append("\n"); 
		query.append("             , mvc.bwthst_rpm_pwr                                                              " ).append("\n"); 
		query.append("             , mvc.lloyd_no                                                                    " ).append("\n"); 
		query.append("             , mvc.vsl_hl_no                                                                   " ).append("\n"); 
		query.append("             , mvc.ttl_teu_knt                                                                 " ).append("\n"); 
		query.append("             , mvc.vsl_htch_knt                                                                " ).append("\n"); 
		query.append("             , mvc.vsl_hld_knt                                                                 " ).append("\n"); 
		query.append("             , mvc.vsl_rmk                                                                     " ).append("\n"); 
		query.append("             , mvc.intl_tong_certi_flg                                                         " ).append("\n"); 
		query.append("             , mvc.vsl_sft_cstru_certi_exp_dt                                                  " ).append("\n"); 
		query.append("             , mvc.vsl_sft_rdo_certi_exp_dt                                                    " ).append("\n"); 
		query.append("             , mvc.vsl_sft_eq_certi_exp_dt                                                     " ).append("\n"); 
		query.append("             , mvc.vsl_lod_line_certi_exp_dt                                                   " ).append("\n"); 
		query.append("             , mvc.vsl_derat_certi_exp_dt                                                      " ).append("\n"); 
		query.append("             , mvc.cre_usr_id                                                                  " ).append("\n"); 
		query.append("             , mvc.cre_dt                                                                      " ).append("\n"); 
		query.append("             , mvc.upd_usr_id                                                                  " ).append("\n"); 
		query.append("             , to_char(mvc.upd_dt,'yyyy-mm-dd hh24:mi') upd_dt                                 " ).append("\n"); 
		query.append("             , mvc.delt_flg                                                                    " ).append("\n"); 
		query.append("             , mvc.eai_evnt_dt                                                                 " ).append("\n"); 
		query.append("             , mvc.vsl_cd                                                                      " ).append("\n"); 
		query.append("             , '' vsl_clss_cd                                                                 " ).append("\n"); 
		query.append("             , mvc.vsl_eng_nm                                                                  " ).append("\n"); 
		query.append("             , mvc.foil_capa                                                                   " ).append("\n"); 
		query.append("             , mvc.doil_capa                                                                   " ).append("\n"); 
		query.append("             , mvc.frsh_wtr_capa                                                               " ).append("\n"); 
		query.append("             , mvc.call_sgn_no                                                                 " ).append("\n"); 
		query.append("             , mvc.rgst_no                                                                     " ).append("\n"); 
		query.append("             , mvc.phn_no                                                                      " ).append("\n"); 
		query.append("             , mvc.fax_no                                                                      " ).append("\n"); 
		query.append("             , mvc.tlx_no                                                                      " ).append("\n"); 
		query.append("             , mvc.vsl_eml                                                                     " ).append("\n"); 
		query.append("             , mvc.piclb_desc                                                                  " ).append("\n"); 
		query.append("             --, mvc.rgst_port_cd " ).append("\n"); 
		query.append("             , ml.loc_nm||', '||mc2.cnt_nm rgst_port_cd                                                               " ).append("\n"); 
		query.append("             , mvc.clss_no_rgst_area_nm                                                        " ).append("\n"); 
		query.append("             , mvc.vsl_clss_no                                                                 " ).append("\n"); 
		query.append("             , mvc.vsl_bldr_nm                                                                 " ).append("\n"); 
		query.append("             , mvc.loa_len                                                                     " ).append("\n"); 
		query.append("             , mvc.lbp_len                                                                     " ).append("\n"); 
		query.append("             , mvc.vsl_wdt                                                                     " ).append("\n"); 
		query.append("             , mvc.vsl_dpth                                                                    " ).append("\n"); 
		query.append("             , mvc.smr_drft_hgt                                                                " ).append("\n"); 
		query.append("             , mvc.dwt_wgt                                                                     " ).append("\n"); 
		query.append("             , mvc.lgt_shp_tong_wgt                                                            " ).append("\n"); 
		query.append("             , mvc.grs_rgst_tong_wgt                                                           " ).append("\n"); 
		query.append("             , mvc.net_rgst_tong_wgt                                                           " ).append("\n"); 
		query.append("             , mvc.pnm_gt_wgt                                                                  " ).append("\n"); 
		query.append("             , mvc.pnm_net_tong_wgt                                                            " ).append("\n"); 
		query.append("             , mvc.suz_gt_wgt                                                                  " ).append("\n"); 
		query.append("             , mvc.suz_net_tong_wgt                                                            " ).append("\n"); 
		query.append("             , mvc.mn_eng_mkr_nm                                                               " ).append("\n"); 
		query.append("             , mvc.mn_eng_tp_desc                                                              " ).append("\n"); 
		query.append("             , mvc.mn_eng_bhp_pwr                                                              " ).append("\n"); 
		query.append("             , mvc.vsl_own_ind_cd                                                              " ).append("\n"); 
		query.append("             , mvc.vsl_rgst_cnt_cd                                                             " ).append("\n"); 
		query.append("             , mvc.vsl_bld_cd                                                                  " ).append("\n"); 
		query.append("             , mvc.crr_cd                                                                      " ).append("\n"); 
		query.append("             , mvc.fdr_div_cd                                                                  " ).append("\n"); 
		query.append("             , mvc.vsl_svc_spd                                                                 " ).append("\n"); 
		query.append("             , mvc.max_spd                                                                     " ).append("\n"); 
		query.append("             , mvc.ecn_spd                                                                     " ).append("\n"); 
		query.append("             , mvc.crw_knt                                                                     " ).append("\n"); 
		query.append("             , mvc.cntr_dzn_capa                                                               " ).append("\n"); 
		query.append("             , mvc.cntr_op_capa                                                                " ).append("\n"); 
		query.append("             , mvc.cntr_pnm_capa                                                               " ).append("\n"); 
		query.append("             , vc.crr_nm                                                                  " ).append("\n"); 
		query.append("             , mc1.cnt_cd||'-'||mc1.cnt_nm as cnt_nm                                                            " ).append("\n"); 
		query.append("         FROM  mdm_vsl_cntr mvc                                                           " ).append("\n"); 
		query.append("             , mdm_carrier  vc                                                            " ).append("\n"); 
		query.append("             , mdm_country  mc1" ).append("\n"); 
		query.append("             , mdm_country  mc2" ).append("\n"); 
		query.append("             , mdm_location ml                                                            " ).append("\n"); 
		query.append("        WHERE mvc.crr_cd = vc.crr_cd(+)" ).append("\n"); 
		query.append("          AND mvc.vsl_rgst_cnt_cd = mc1.cnt_cd(+)" ).append("\n"); 
		query.append("          AND substr(mvc.rgst_port_cd,1,2) = mc2.cnt_cd(+)" ).append("\n"); 
		query.append("          AND mvc.rgst_port_cd = ml.loc_cd(+)" ).append("\n"); 
		query.append("          AND mvc.vsl_cd = @[vsl_cd]                                                         " ).append("\n"); 
		query.append("      ) a" ).append("\n"); 
		query.append("    , (SELECT rownum" ).append("\n"); 
		query.append("         FROM dual" ).append("\n"); 
		query.append("       CONNECT BY 1=1" ).append("\n"); 
		query.append("          AND rownum < 39" ).append("\n"); 
		query.append("       ) b" ).append("\n"); 

	}
}