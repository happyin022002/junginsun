/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvoiceCreationDBDAOsearchInvoiceCreationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.07
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2015.10.07 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun Kwon-Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDBDAOsearchInvoiceCreationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Invoice Creation List
	  * </pre>
	  */
	public InvoiceCreationDBDAOsearchInvoiceCreationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_dvsn",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDBDAOsearchInvoiceCreationListRSQL").append("\n"); 
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
		query.append("SELECT 	ROWNUM" ).append("\n"); 
		query.append("		,so.trsp_wo_ofc_cty_cd||so.trsp_wo_seq wo_no" ).append("\n"); 
		query.append("		,so.trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("		,(SELECT intg_cd_val_dp_desc" ).append("\n"); 
		query.append("			FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("		   WHERE intg_cd_id = 'CD00594'" ).append("\n"); 
		query.append("			 AND intg_cd_val_ctnt = so.trsp_cost_dtl_mod_cd) trsp_cost_dtl_mod_nm" ).append("\n"); 
		query.append("		,so.trsp_so_ofc_cty_cd||so.trsp_so_seq so_no" ).append("\n"); 
		query.append("		,so.eq_knd_cd" ).append("\n"); 
		query.append("		,(SELECT intg_cd_val_dp_desc" ).append("\n"); 
		query.append("			FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("		   WHERE intg_cd_id = 'CD01132'" ).append("\n"); 
		query.append("			 AND intg_cd_val_ctnt = so.eq_knd_cd) eq_tp_nm" ).append("\n"); 
		query.append("		,so.eq_no" ).append("\n"); 
		query.append("		,so.eq_tpsz_cd" ).append("\n"); 
		query.append("		,(SELECT cntr_tpsz_rmk" ).append("\n"); 
		query.append("			FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("		   WHERE cntr_tpsz_cd = so.eq_tpsz_cd) eq_tpsz_nm" ).append("\n"); 
		query.append("		,(SELECT cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("			FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("		   WHERE cntr_tpsz_cd = so.eq_tpsz_cd) cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("		,so.bkg_no" ).append("\n"); 
		query.append("		,so.bl_no" ).append("\n"); 
		query.append("		,so.fm_nod_cd" ).append("\n"); 
		query.append("		,yd1.yd_nm fm_yard_nm" ).append("\n"); 
		query.append("		,so.via_nod_cd" ).append("\n"); 
		query.append("		,yd2.yd_nm via_yard_nm" ).append("\n"); 
		query.append("		,so.to_nod_cd" ).append("\n"); 
		query.append("		,yd3.yd_nm to_yard_nm" ).append("\n"); 
		query.append("		,so.dor_nod_cd" ).append("\n"); 
		query.append("		,(SELECT zn_nm FROM mdm_zone WHERE zn_cd = so.dor_nod_cd) dor_yard_nm" ).append("\n"); 
		query.append("		,so.vndr_seq" ).append("\n"); 
		query.append("		,(SELECT prnt_vndr_seq FROM mdm_vendor WHERE vndr_seq = so.vndr_seq) prnt_vndr_seq" ).append("\n"); 
		query.append("		,to_char(so.apnt_dt, 'YYYY-MM-DD HH24:MI') apnt_dt" ).append("\n"); 
		query.append("		,to_char(so.de_dt, 'YYYY-MM-DD HH24:MI') de_dt" ).append("\n"); 
		query.append("		,so.cre_ofc_cd" ).append("\n"); 
		query.append("		,so.trsp_so_sts_cd" ).append("\n"); 
		query.append("		,(SELECT intg_cd_val_dp_desc" ).append("\n"); 
		query.append("			FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("		   WHERE intg_cd_id = 'CD00286'" ).append("\n"); 
		query.append("			 AND intg_cd_val_ctnt = so.trsp_so_sts_cd) so_status" ).append("\n"); 
		query.append("		,so.trsp_so_tp_cd" ).append("\n"); 
		query.append("		,(SELECT intg_cd_val_dp_desc" ).append("\n"); 
		query.append("		    FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("		   WHERE intg_cd_id = 'CD00279'" ).append("\n"); 
		query.append("			 AND intg_cd_val_ctnt = so.trsp_so_tp_cd) so_type" ).append("\n"); 
		query.append("		,so.inv_no" ).append("\n"); 
		query.append("		,so.trsp_inv_act_sts_cd" ).append("\n"); 
		query.append("		,(SELECT intg_cd_val_dp_desc" ).append("\n"); 
		query.append("			FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("		   WHERE intg_cd_id = 'CD00824'" ).append("\n"); 
		query.append("			 AND intg_cd_val_ctnt = so.trsp_inv_act_sts_cd) inv_status" ).append("\n"); 
		query.append("		,so.curr_cd" ).append("\n"); 
		query.append("		,so.trsp_bnd_cd" ).append("\n"); 
		query.append("		,NVL(so.cgo_tp_cd,'M') cgo_tp_cd" ).append("\n"); 
		query.append("		,to_char(x.cre_dt, 'YYYY-MM-DD HH24:MI') wo_cre_dt" ).append("\n"); 
		query.append("		,to_char((SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', " ).append("\n"); 
		query.append("													   TO_DATE((SELECT to_char(cre_dt, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("            													  FROM sce_cop_hdr" ).append("\n"); 
		query.append("            													 WHERE cop_no = so.cop_no ), 'YYYYMMDDHH24MISS'), " ).append("\n"); 
		query.append("													   SUBSTR(so.dor_nod_cd, 1, 5))" ).append("\n"); 
		query.append("            		FROM DUAL), 'YYYY-MM-DD HH24:MI') locl_cop_cre_dt" ).append("\n"); 
		query.append("		,(SELECT max(to_char(CTM.CNMV_EVNT_DT, 'YYYYMMDDHH24MI')) CNMV_EVNT_DT" ).append("\n"); 
		query.append("            FROM BKG_CONTAINER BCN ," ).append("\n"); 
		query.append("              CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND BCN.BKG_NO = CTM.BKG_NO" ).append("\n"); 
		query.append("              AND BCN.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("              AND CTM.CNMV_CYC_NO = BCN.CNMV_CYC_NO" ).append("\n"); 
		query.append("              AND CTM.BKG_NO = so.bkg_no" ).append("\n"); 
		query.append("              AND CTM.CNTR_NO = so.eq_no" ).append("\n"); 
		query.append("              AND CTM.MVMT_STS_CD = 'VD') cnmv_vdsts_dt" ).append("\n"); 
		query.append("		,so.spot_bid_no" ).append("\n"); 
		query.append("		FROM TRS_TRSP_SVC_ORD so" ).append("\n"); 
		query.append("		,MDM_YARD yd1" ).append("\n"); 
		query.append("		,MDM_YARD yd2" ).append("\n"); 
		query.append("		,MDM_YARD yd3" ).append("\n"); 
		query.append("		,(SELECT x1.*" ).append("\n"); 
		query.append("			FROM (SELECT /* index(wo XAK1TRS_TRSP_WRK_ORD, wo XAK2TRS_TRSP_WRK_ORD) */" ).append("\n"); 
		query.append("						 wo.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("						 ,wo.trsp_wo_seq" ).append("\n"); 
		query.append("						 ,wo.cre_dt" ).append("\n"); 
		query.append("				    FROM trs_trsp_wrk_ord wo" ).append("\n"); 
		query.append("				   WHERE 1 = 1" ).append("\n"); 
		query.append("					 AND ((@[vndr_dvsn] = 'S' and" ).append("\n"); 
		query.append("#if ($sp_cd.size() == 1) " ).append("\n"); 
		query.append("	wo.wo_vndr_seq = @[vndr_seq] " ).append("\n"); 
		query.append("#elseif ($sp_cd.size() > 1)" ).append("\n"); 
		query.append("	(1,wo.wo_vndr_seq) IN (" ).append("\n"); 
		query.append("	#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR @[vndr_dvsn] != 'S')" ).append("\n"); 
		query.append("#if ($trsp_wo_ofc_cty_cd.size() > 0)" ).append("\n"); 
		query.append("					 AND (wo.trsp_wo_ofc_cty_cd,wo.trsp_wo_seq) in (" ).append("\n"); 
		query.append("	#foreach($wonoKey in ${trsp_wo_ofc_cty_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_wo_ofc_cty_cd.size())" ).append("\n"); 
		query.append("							(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("							(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("					 AND NVL(wo.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("					 AND NVL(wo.inter_use_flg, 'N') != 'Y'" ).append("\n"); 
		query.append("		) x1) x" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND so.trsp_wo_ofc_cty_cd IS NOT NULL" ).append("\n"); 
		query.append("  AND LENGTH(so.trsp_wo_ofc_cty_cd) = 3" ).append("\n"); 
		query.append("  AND so.trsp_wo_seq IS NOT NULL" ).append("\n"); 
		query.append("  AND so.inv_no IS NULL" ).append("\n"); 
		query.append("  AND so.inv_vndr_seq IS NULL" ).append("\n"); 
		query.append("  AND so.trsp_wo_ofc_cty_cd = x.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("  AND so.trsp_wo_seq = x.trsp_wo_seq" ).append("\n"); 
		query.append("#if ($eq_no.size() > 0)" ).append("\n"); 
		query.append("  and (1,so.eq_no) in (" ).append("\n"); 
		query.append("	#foreach($EqNokey IN ${eq_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("			(1,'$EqNokey')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$EqNokey')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($bkg_no.size() > 0)" ).append("\n"); 
		query.append("  and  (1,so.bkg_no) in (" ).append("\n"); 
		query.append("	#foreach($bkg_no_key IN ${bkg_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bkg_no.size())" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bkg_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($bl_no.size() > 0)" ).append("\n"); 
		query.append("	and (1,so.bl_no) in (" ).append("\n"); 
		query.append("	#foreach($bl_no_key IN ${bl_no})" ).append("\n"); 
		query.append("		#if($velocityCount < $bl_no.size())" ).append("\n"); 
		query.append("			(1,'$bl_no_key')," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(1,'$bl_no_key')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($trsp_so_ofc_cty_cd.size() > 0)" ).append("\n"); 
		query.append("	AND (so.trsp_so_ofc_cty_cd,so.trsp_so_seq) in (" ).append("\n"); 
		query.append("	#foreach($sonoKey in ${trsp_so_ofc_cty_cd})" ).append("\n"); 
		query.append("		#if($velocityCount < $trsp_so_ofc_cty_cd.size())" ).append("\n"); 
		query.append("			(substr('$sonoKey',0,3),to_number(substr('$sonoKey',4,length('$sonoKey'))))," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			(substr('$sonoKey',0,3),to_number(substr('$sonoKey',4,length('$sonoKey'))))" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND yd1.yd_cd(+) = so.fm_nod_cd" ).append("\n"); 
		query.append("  AND yd2.yd_cd(+) = so.via_nod_cd" ).append("\n"); 
		query.append("  AND yd3.yd_cd(+) = so.to_nod_cd" ).append("\n"); 
		query.append("  AND NVL(so.delt_flg, 'E') <> 'Y'" ).append("\n"); 
		query.append("  AND so.vndr_seq IS NOT NULL" ).append("\n"); 
		query.append("  AND ((@[vndr_dvsn] = 'S' and so.vndr_seq IN ( SELECT vndr_seq" ).append("\n"); 
		query.append("												  FROM mdm_vendor" ).append("\n"); 
		query.append("												 WHERE prnt_vndr_seq IN (SELECT prnt_vndr_seq" ).append("\n"); 
		query.append("																		  FROM mdm_vendor" ).append("\n"); 
		query.append("																		 WHERE 1=1" ).append("\n"); 
		query.append("#if ($sp_cd.size() == 1) " ).append("\n"); 
		query.append("	AND vndr_seq = @[vndr_seq]" ).append("\n"); 
		query.append("#elseif ($sp_cd.size() > 1)" ).append("\n"); 
		query.append("	AND (1,vndr_seq) IN (" ).append("\n"); 
		query.append("	#foreach($sp_cd_key in ${sp_cd}) " ).append("\n"); 
		query.append("		#if($velocityCount < $sp_cd.size()) " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')," ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			(1,'$sp_cd_key')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("																		)" ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("		) OR @[vndr_dvsn] != 'S')" ).append("\n"); 
		query.append("ORDER BY so.trsp_wo_ofc_cty_cd,so.trsp_wo_seq,eq_no" ).append("\n"); 

	}
}