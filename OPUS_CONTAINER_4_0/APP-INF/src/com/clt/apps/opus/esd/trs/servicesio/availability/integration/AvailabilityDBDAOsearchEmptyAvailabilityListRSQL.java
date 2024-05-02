/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AvailabilityDBDAOsearchEmptyAvailabilityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이상훈
*@LastVersion : 1.0
* 2010.02.24 이상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.availability.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Hoon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailabilityDBDAOsearchEmptyAvailabilityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Empty Availability List
	  * </pre>
	  */
	public AvailabilityDBDAOsearchEmptyAvailabilityListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dvsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.availability.integration").append("\n"); 
		query.append("FileName : AvailabilityDBDAOsearchEmptyAvailabilityListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("x.eq_no" ).append("\n"); 
		query.append(",x.eq_tpsz_cd" ).append("\n"); 
		query.append(",x.cntr_tpsz_iso_cd" ).append("\n"); 
		query.append(",x.iso_nm" ).append("\n"); 
		query.append(",x.dor_nod_cd" ).append("\n"); 
		query.append(",x.dor_nod_name" ).append("\n"); 
		query.append(",x.dor_loc_nm" ).append("\n"); 
		query.append(",x.dor_yd_addr" ).append("\n"); 
		query.append(",x.dor_zip_cd" ).append("\n"); 
		query.append(",x.dor_fctry_nm" ).append("\n"); 
		query.append(",x.dor_ofc_eng_nm" ).append("\n"); 
		query.append(",x.dor_phn_no" ).append("\n"); 
		query.append(",x.to_nod_cd" ).append("\n"); 
		query.append(",x.to_loc_nm" ).append("\n"); 
		query.append(",x.to_nod_name" ).append("\n"); 
		query.append(",x.to_yd_addr" ).append("\n"); 
		query.append(",x.to_zip_cd" ).append("\n"); 
		query.append(",x.to_ofc_eng_nm" ).append("\n"); 
		query.append(",x.to_phn_no" ).append("\n"); 
		query.append(",x.avb_sts" ).append("\n"); 
		query.append(",x.avb_dt" ).append("\n"); 
		query.append(",x.firt_free_dt" ).append("\n"); 
		query.append(",x.last_free_dt" ).append("\n"); 
		query.append(",x.wo_vndr_seq" ).append("\n"); 
		query.append(",x.cop_fsh_dt" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select /*+ ordered(a b d e f g) use_nl(e b a d f g) */" ).append("\n"); 
		query.append("b.eq_no" ).append("\n"); 
		query.append(",b.eq_tpsz_cd" ).append("\n"); 
		query.append(",(SELECT cntr_tpsz_iso_cd FROM mdm_cntr_tp_sz WHERE cntr_tpsz_cd = b.eq_tpsz_cd) cntr_tpsz_iso_cd" ).append("\n"); 
		query.append(",(SELECT iso_cntr_tpsz_nm" ).append("\n"); 
		query.append("FROM mst_iso_cntr_tp_sz" ).append("\n"); 
		query.append("WHERE iso_cntr_tpsz_cd = (SELECT cntr_tpsz_iso_cd" ).append("\n"); 
		query.append("FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("WHERE cntr_tpsz_cd = b.eq_tpsz_cd)) iso_nm" ).append("\n"); 
		query.append(",b.dor_nod_cd" ).append("\n"); 
		query.append(",f.zn_nm dor_nod_name" ).append("\n"); 
		query.append(",(select loc_nm from mdm_location where loc_cd = f.loc_cd) dor_loc_nm" ).append("\n"); 
		query.append(",b.dor_de_addr dor_yd_addr" ).append("\n"); 
		query.append(",b.dor_pst_cd dor_zip_cd" ).append("\n"); 
		query.append(",b.fctry_nm dor_fctry_nm" ).append("\n"); 
		query.append(",b.cntc_pson_nm dor_ofc_eng_nm" ).append("\n"); 
		query.append(",b.cntc_pson_phn_no dor_phn_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",b.to_nod_cd" ).append("\n"); 
		query.append(",(select loc_nm from mdm_location where loc_cd = g.loc_cd) to_loc_nm" ).append("\n"); 
		query.append(",g.yd_nm to_nod_name" ).append("\n"); 
		query.append(",g.yd_addr to_yd_addr" ).append("\n"); 
		query.append(",g.zip_cd to_zip_cd" ).append("\n"); 
		query.append(",g.yd_pic_nm to_ofc_eng_nm" ).append("\n"); 
		query.append(",g.phn_no to_phn_no" ).append("\n"); 
		query.append(",case when e.web_mty_dt is null and e.web_cre_dt is null then 'Unavailable'" ).append("\n"); 
		query.append("else 'Available'" ).append("\n"); 
		query.append("end avb_sts" ).append("\n"); 
		query.append(",case when e.web_mty_dt is not null then to_char(e.web_mty_dt,'yyyy-mm-dd')" ).append("\n"); 
		query.append("when e.web_cre_dt is not null then to_char(e.web_cre_dt,'yyyy-mm-dd')" ).append("\n"); 
		query.append("else ''" ).append("\n"); 
		query.append("end avb_dt" ).append("\n"); 
		query.append(",to_char(e.ft_end_dt,'yyyy-mm-dd') firt_free_dt" ).append("\n"); 
		query.append(",to_char(e.ft_end_dt,'yyyy-mm-dd') last_free_dt" ).append("\n"); 
		query.append(",a.wo_vndr_seq" ).append("\n"); 
		query.append(",(select to_char(cop_fsh_dt,'yyyy-mm-dd') cop_fsh_dt from sce_cop_hdr where cop_no = b.cop_no) cop_fsh_dt" ).append("\n"); 
		query.append(",a.cre_dt" ).append("\n"); 
		query.append("from DMT_CHG_CALC e" ).append("\n"); 
		query.append(",trs_trsp_svc_ord b" ).append("\n"); 
		query.append(",trs_trsp_wrk_ord a" ).append("\n"); 
		query.append(",BKG_CONTAINER d" ).append("\n"); 
		query.append(",mdm_zone f" ).append("\n"); 
		query.append(",mdm_yard g" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("#if (${period_type} != 'N' || (${period_type} != 'Y' && $wo_no.size() > 0))" ).append("\n"); 
		query.append("and a.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period_type} == 'N' && $wo_no.size() > 0)" ).append("\n"); 
		query.append("AND (a.trsp_wo_ofc_cty_cd,a.trsp_wo_seq) in (" ).append("\n"); 
		query.append("#foreach($wonoKey in ${wo_no})" ).append("\n"); 
		query.append("#if($velocityCount < $wo_no.size())" ).append("\n"); 
		query.append("(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${period_type} == 'N' && $eq_no.size() > 0)" ).append("\n"); 
		query.append("and  (1,b.eq_no) in (" ).append("\n"); 
		query.append("#foreach($EqNokey IN ${eq_no})" ).append("\n"); 
		query.append("#if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("(1,'$EqNokey')," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("(1,'$EqNokey')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("and b.trsp_wo_ofc_cty_cd = a.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("and b.trsp_wo_seq = a.trsp_wo_seq" ).append("\n"); 
		query.append("and b.trsp_cost_dtl_mod_cd = 'DR'" ).append("\n"); 
		query.append("AND (@[to_nod_cd] is null OR substr(b.to_nod_cd,0,5 )  = @[to_nod_cd])" ).append("\n"); 
		query.append("AND (@[dor_nod_cd] is null OR substr(b.dor_nod_cd,0,5 )  = @[dor_nod_cd])" ).append("\n"); 
		query.append("and d.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("and d.cntr_no = b.eq_no" ).append("\n"); 
		query.append("and e.cntr_no(+) = d.cntr_no" ).append("\n"); 
		query.append("and e.CNTR_CYC_NO(+) = d.CNMV_CYC_NO" ).append("\n"); 
		query.append("and e.DMDT_TRF_CD(+) = 'DTIC'" ).append("\n"); 
		query.append("and e.DMDT_CHG_LOC_DIV_CD(+) = 'DEL'" ).append("\n"); 
		query.append("and e.chg_seq(+) = 1" ).append("\n"); 
		query.append("#if (${period_type} == 'E')" ).append("\n"); 
		query.append("and ((e.web_mty_dt is not null and e.web_mty_dt  >= to_date(@[dt_fr] || '000000','yyyymmddhh24miss')" ).append("\n"); 
		query.append("and e.web_mty_dt  <= to_date(@[dt_to] || '235959','yyyymmddhh24miss'))" ).append("\n"); 
		query.append("OR (e.web_mty_dt is null and e.web_cre_dt  >= to_date(@[dt_fr] || '000000','yyyymmddhh24miss')" ).append("\n"); 
		query.append("and e.web_cre_dt  <= to_date(@[dt_to] || '235959','yyyymmddhh24miss')))" ).append("\n"); 
		query.append("#elseif (${period_type} == 'L')" ).append("\n"); 
		query.append("and e.ft_end_dt  >= to_date(@[dt_fr] || '000000','yyyymmddhh24miss')" ).append("\n"); 
		query.append("and e.ft_end_dt  <= to_date(@[dt_to] || '235959','yyyymmddhh24miss')" ).append("\n"); 
		query.append("#elseif (${period_type} == 'W')" ).append("\n"); 
		query.append("and a.cre_dt  >= to_date(@[dt_fr] || '000000','yyyymmddhh24miss')" ).append("\n"); 
		query.append("and a.cre_dt  <= to_date(@[dt_to] || '235959','yyyymmddhh24miss')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${period_type} != 'N')" ).append("\n"); 
		query.append("and (@[dvsn] = 'A'" ).append("\n"); 
		query.append("OR (@[dvsn] = 'Y' and (e.web_mty_dt is not null OR e.web_cre_dt is not null))" ).append("\n"); 
		query.append("OR (@[dvsn] = 'N' and e.web_mty_dt is null and e.web_cre_dt is null))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and f.zn_cd = b.dor_nod_cd" ).append("\n"); 
		query.append("and g.yd_cd = b.to_nod_cd" ).append("\n"); 
		query.append("and substr(g.loc_cd,0,2) = 'US'" ).append("\n"); 
		query.append(") x" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${period_type} != 'N')" ).append("\n"); 
		query.append("AND x.cop_fsh_dt is null" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by x.cre_dt desc" ).append("\n"); 

	}
}