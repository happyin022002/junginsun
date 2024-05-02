/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchCLMListPopRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.09.11 이중환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchCLMListPopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select list
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchCLMListPopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchCLMListPopRSQL").append("\n"); 
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
		query.append("SELECT  t2.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT  t1.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT  sc.cntr_no, sc.cnmv_yr, sc.cnmv_id_no, sc.clm_seq," ).append("\n"); 
		query.append("MAX(ttr.eq_tpsz_cd) cntr_tpsz_cd," ).append("\n"); 
		query.append("MAX(sc.full_mty_cd) full_mty_cd," ).append("\n"); 
		query.append("MAX(scs.clm_sght_abbr_nm) clm_sght_abbr_nm," ).append("\n"); 
		query.append("MAX(CASE" ).append("\n"); 
		query.append("WHEN srs.loc_cd is null" ).append("\n"); 
		query.append("THEN sc.arr_loc_nm" ).append("\n"); 
		query.append("ELSE sc.arr_loc_nm||' ('||srs.loc_cd||')'" ).append("\n"); 
		query.append("END ) loc_cd," ).append("\n"); 
		query.append("MAX(sc.arr_ste_cd) arr_ste_cd," ).append("\n"); 
		query.append("MAX(TO_CHAR(sc.arr_dt, 'yyyy-MM-dd')) arr_date," ).append("\n"); 
		query.append("MAX(TO_CHAR(sc.arr_dt, 'hh24:mi')) arr_time," ).append("\n"); 
		query.append("MAX(sc.clm_crr_nm) clm_crr_nm," ).append("\n"); 
		query.append("MAX(sc.trsp_mod_tp_cd) trsp_mod_tp_cd," ).append("\n"); 
		query.append("MAX(ttr.fm_nod_cd) fm_nod_cd," ).append("\n"); 
		query.append("MAX(sc.arr_ste_cd) fm_ste_cd," ).append("\n"); 
		query.append("MAX(ttr.to_nod_cd) to_nod_cd," ).append("\n"); 
		query.append("MAX(sc.dep_ste_cd) to_ste_cd," ).append("\n"); 
		query.append("MAX(sc.dep_loc_nm) dep_loc_nm," ).append("\n"); 
		query.append("MAX(sc.trn_no) trn_no," ).append("\n"); 
		query.append("MAX(sc.fcar_no) fcar_no" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(select trsp_so_ofc_cty_cd, trsp_so_seq" ).append("\n"); 
		query.append(",cntr_no,cnmv_yr,cnmv_id_no,clm_seq" ).append("\n"); 
		query.append(",full_mty_cd,arr_dt,arr_loc_nm,arr_ste_cd" ).append("\n"); 
		query.append(",clm_crr_nm,trsp_mod_tp_cd,dep_ste_cd,trn_no,fcar_no" ).append("\n"); 
		query.append(",clm_sght_cd,ARR_SPLC_CD" ).append("\n"); 
		query.append(",DEP_LOC_NM" ).append("\n"); 
		query.append("from  sce_clm" ).append("\n"); 
		query.append("where cntr_no = @[r_cntr_no]" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(TO_CHAR(str.cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("||str.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("||TO_CHAR(str.trsp_so_seq,'000000000')), 9, 3) trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",TO_NUMBER(SUBSTR(MAX(TO_CHAR(str.cre_dt, 'YYYYMMDD')" ).append("\n"); 
		query.append("||str.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("||TO_CHAR(str.trsp_so_seq,'000000000')),12, 21)) trsp_so_seq" ).append("\n"); 
		query.append(",cntr_no,cnmv_yr,cnmv_id_no,clm_seq" ).append("\n"); 
		query.append(",MAX(cmc.full_mty_cd),MAX(cmc.arr_dt),MAX(cmc.arr_loc_nm),MAX(cmc.arr_ste_cd)" ).append("\n"); 
		query.append(",MAX(cmc.clm_crr_nm),MAX(cmc.trsp_mod_tp_cd),MAX(cmc.dep_ste_cd)" ).append("\n"); 
		query.append(",MAX(cmc.trn_no),MAX(cmc.fcar_no),MAX(cmc.clm_sght_cd),MAX(cmc.ARR_SPLC_CD)" ).append("\n"); 
		query.append(",MAX(cmc.dep_loc_nm)" ).append("\n"); 
		query.append("FROM   trs_trsp_rail_bil_ord   str" ).append("\n"); 
		query.append(",sce_rail_splc rss" ).append("\n"); 
		query.append(",sce_clm_if    cmc" ).append("\n"); 
		query.append("where cmc.cntr_no        = @[r_cntr_no]" ).append("\n"); 
		query.append("AND   cmc.so_mapg_sts_cd != '52'" ).append("\n"); 
		query.append("AND   cmc.cntr_no        = str.eq_no" ).append("\n"); 
		query.append("AND   SUBSTR(str.to_nod_cd, 1, 5) = rss.loc_cd" ).append("\n"); 
		query.append("AND   str.delt_flg       = 'N'" ).append("\n"); 
		query.append("AND   rss.splc_cd        > 500" ).append("\n"); 
		query.append("GROUP BY cmc.cntr_no,cmc.cnmv_yr,cmc.cnmv_id_no,cmc.clm_seq ) sc," ).append("\n"); 
		query.append("sce_clm_sght scs," ).append("\n"); 
		query.append("trs_trsp_rail_bil_ord ttr," ).append("\n"); 
		query.append("sce_rail_splc srs" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   sc.clm_sght_cd = scs.clm_sght_cd" ).append("\n"); 
		query.append("AND     sc.ARR_SPLC_CD = srs.SPLC_CD(+)" ).append("\n"); 
		query.append("AND     sc.TRSP_SO_OFC_CTY_CD = ttr.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND     sc.TRSP_SO_SEQ = ttr.TRSP_SO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by sc.cntr_no, sc.cnmv_yr, sc.cnmv_id_no, sc.clm_seq" ).append("\n"); 
		query.append("ORDER BY MAX(TO_CHAR(sc.arr_dt, 'yyyy-MM-dd')) , MAX(TO_CHAR(sc.arr_dt, 'hh24:mi')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") t1" ).append("\n"); 
		query.append(") t2" ).append("\n"); 

	}
}