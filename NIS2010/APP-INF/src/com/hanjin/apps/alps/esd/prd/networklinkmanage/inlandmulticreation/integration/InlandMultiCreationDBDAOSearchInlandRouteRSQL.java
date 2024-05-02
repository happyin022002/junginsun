/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandMultiCreationDBDAOSearchInlandRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.11.10 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandMultiCreationDBDAOSearchInlandRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInlandRoute
	  * </pre>
	  */
	public InlandMultiCreationDBDAOSearchInlandRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("node_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.integration").append("\n"); 
		query.append("FileName : InlandMultiCreationDBDAOSearchInlandRouteRSQL").append("\n"); 
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
		query.append("SELECT delt_flg, rout_org_nod_cd, rout_dest_nod_cd, prio_seq, inlnd_rout_bkg_flg ," ).append("\n"); 
		query.append("			wrs_full_cmdt, inlnd_rout_tmp_flg, inlnd_rout_incl_sttl_flg, inlnd_rout_inv_bil_patt_cd, rout_pln_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- 시작 저장할 때 쓰이는 값" ).append("\n"); 
		query.append("            wrs_mty_cmdt_cd," ).append("\n"); 
		query.append("            pctl_io_bnd_cd," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, hub_loc_cd, DECODE(rout_dtl_seq,1, hub_loc_cd))) hub_loc_cd," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, cre_usr_id, DECODE(rout_dtl_seq,1, cre_usr_id))) cre_usr_id," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, cre_usr_id, DECODE(rout_dtl_seq,1, cre_usr_id))) cre_usr_id," ).append("\n"); 
		query.append("            rout_seq," ).append("\n"); 
		query.append("            sum_tt_time," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, cre_usr_id, DECODE(rout_dtl_seq,1, cre_usr_id))) cre_usr_id," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, cre_ofc_cd, DECODE(rout_dtl_seq,1, cre_ofc_cd))) cre_ofc_cd," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, cre_dt, DECODE(rout_dtl_seq,1, cre_dt))) cre_dt," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, upd_usr_id, DECODE(rout_dtl_seq,1, upd_usr_id))) upd_usr_id," ).append("\n"); 
		query.append("            MAX(DECODE(cnt,1, upd_dt, DECODE(rout_dtl_seq,1, upd_dt))) upd_dt," ).append("\n"); 
		query.append("			-- 끝 저장할 때 쓰이는 값" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- first" ).append("\n"); 
		query.append("            rout_org_nod_cd n1st_node ," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, trsp_mod               , DECODE(rout_dtl_seq ,1, trsp_mod           ))) tm1 ," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, vndr_seq               , DECODE(rout_dtl_seq, 1, vndr_seq           ))) vndr1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, sp_name                , DECODE(rout_dtl_seq, 1, sp_name            ))) sp_name1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, fmt_tztm_hrs           , DECODE(rout_dtl_seq, 1, fmt_tztm_hrs       ))) fmt_tztm_hrs1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, agmt_no                , DECODE(rout_dtl_seq, 1, agmt_no            ))) agmt_no1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, agmt_ref_no            , DECODE(rout_dtl_seq, 1, agmt_ref_no        ))) agmt_ref_no1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, inlnd_rout_cmb_flg     , DECODE(rout_dtl_seq, 1, inlnd_rout_cmb_flg ))) com_flg1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, inlnd_rout_junc_nm     , DECODE(rout_dtl_seq, 1, inlnd_rout_junc_nm ))) junc_nm1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, inlnd_rout_rmk         , DECODE(rout_dtl_seq, 1, inlnd_rout_rmk     ))) inlnd_rout_rmk1," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, rail_crr_tp_cd         , DECODE(rout_dtl_seq, 1, rail_crr_tp_cd     ))) rd_crr_tp1," ).append("\n"); 
		query.append("            '' n1st_trsp_agmt_ofc_cty_cd, '' n1st_trsp_agmt_seq, '' n1st_agmt_ref_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- second" ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, DECODE(rout_dtl_seq, 1, lnk_dest_nod_cd    ), DECODE(rout_dtl_seq, 1, lnk_dest_nod_cd    ))) n2nd_node," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, trsp_mod           ))) tm2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, vndr_seq           ))) vndr2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, sp_name            ))) sp_name2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, fmt_tztm_hrs       ))) fmt_tztm_hrs2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, agmt_no            ))) agmt_no2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, agmt_ref_no        ))) agmt_ref_no2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, inlnd_rout_cmb_flg ))) com_flg2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, inlnd_rout_junc_nm ))) junc_nm2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, inlnd_rout_rmk     ))) inlnd_rout_rmk2," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 2, rail_crr_tp_cd     ))) rd_crr_tp2," ).append("\n"); 
		query.append("            '' n2nd_trsp_agmt_ofc_cty_cd,''	n2nd_trsp_agmt_seq,''	n2nd_agmt_ref_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- third" ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 2, DECODE(rout_dtl_seq, 2, lnk_dest_nod_cd    ), DECODE(rout_dtl_seq, 2, lnk_dest_nod_cd    ))) n3rd_node," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, trsp_mod           ))) tm3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, vndr_seq           ))) vndr3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, sp_name            ))) sp_name3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, fmt_tztm_hrs       ))) fmt_tztm_hrs3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, agmt_no            ))) agmt_no3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, agmt_ref_no        ))) agmt_ref_no3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, inlnd_rout_cmb_flg ))) com_flg3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, inlnd_rout_junc_nm ))) junc_nm3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, inlnd_rout_rmk     ))) inlnd_rout_rmk3," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 3, rail_crr_tp_cd     ))) rd_crr_tp3," ).append("\n"); 
		query.append("            '' n3rd_trsp_agmt_ofc_cty_cd,''	n3rd_trsp_agmt_seq,''	n3rd_agmt_ref_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- fourth" ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 3, DECODE(rout_dtl_seq, 3, lnk_dest_nod_cd    ), DECODE(rout_dtl_seq, 3, lnk_dest_nod_cd    ))) n4th_node,--   ||" ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, trsp_mod           ))) tm4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, vndr_seq           ))) vndr4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, sp_name            ))) sp_name4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, fmt_tztm_hrs       ))) fmt_tztm_hrs4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, agmt_no            ))) agmt_no4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, agmt_ref_no        ))) agmt_ref_no4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, inlnd_rout_cmb_flg ))) com_flg4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, inlnd_rout_junc_nm ))) junc_nm4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, inlnd_rout_rmk     ))) inlnd_rout_rmk4," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 4, rail_crr_tp_cd     ))) rd_crr_tp4," ).append("\n"); 
		query.append("            '' n4th_trsp_agmt_ofc_cty_cd,''	n4th_trsp_agmt_seq,''	n4th_agmt_ref_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- fifth" ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 4, DECODE(rout_dtl_seq, 4, lnk_dest_nod_cd    ), DECODE(rout_dtl_seq, 4, lnk_dest_nod_cd    ))) n5th_node," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, trsp_mod           ))) tm5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, vndr_seq           ))) vndr5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, sp_name            ))) sp_name5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, fmt_tztm_hrs       ))) fmt_tztm_hrs5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, agmt_no            ))) agmt_no5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, agmt_ref_no        ))) agmt_ref_no5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, inlnd_rout_cmb_flg ))) com_flg5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, inlnd_rout_junc_nm ))) junc_nm5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, inlnd_rout_rmk     ))) inlnd_rout_rmk5," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 5, rail_crr_tp_cd     ))) rd_crr_tp5," ).append("\n"); 
		query.append("            '' n5th_trsp_agmt_ofc_cty_cd,''	n5th_trsp_agmt_seq,''	n5th_agmt_ref_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			-- sixth" ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 5, DECODE(rout_dtl_seq, 5, lnk_dest_nod_cd    ), DECODE(rout_dtl_seq, 5, lnk_dest_nod_cd    ))) n6th_node," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, trsp_mod           ))) tm6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, vndr_seq           ))) vndr6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, sp_name            ))) sp_name6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, agmt_no            ))) agmt_no6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, agmt_ref_no        ))) agmt_ref_no6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, inlnd_rout_cmb_flg ))) com_flg6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, inlnd_rout_junc_nm ))) junc_nm6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, inlnd_rout_rmk     ))) inlnd_rout_rmk6," ).append("\n"); 
		query.append("            MAX(DECODE(cnt, 1, ''                     , DECODE(rout_dtl_seq, 6, rail_crr_tp_cd     ))) rd_crr_tp6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("          /* ------------------------------------------------------------------------ */" ).append("\n"); 
		query.append("                   SELECT m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, DECODE(m.prio_seq,0,null,m.prio_seq) prio_seq," ).append("\n"); 
		query.append("                        DECODE(m.inlnd_rout_bkg_flg, 'Y', 1, 0) inlnd_rout_bkg_flg," ).append("\n"); 
		query.append("						DECODE(inlnd_rout_incl_sttl_flg , 'Y', 1, 0) inlnd_rout_incl_sttl_flg," ).append("\n"); 
		query.append("                        d.lnk_org_nod_cd, d.lnk_dest_nod_cd, d.rout_dtl_seq, d.trsp_mod_cd, l.tztm_hrs," ).append("\n"); 
		query.append("                        COUNT (*) OVER (partition by m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("                           ORDER BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq) as cnt," ).append("\n"); 
		query.append("                        SUM(l.tztm_hrs) OVER(partition by m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq" ).append("\n"); 
		query.append("                           ORDER BY m.rout_org_nod_cd,m.rout_dest_nod_cd, m.rout_seq) as sum_tt_time," ).append("\n"); 
		query.append("                        (SELECT NVL(decode(@[io_type], 'O', ob_dry_avg_dwll_hrs, ib_dry_avg_dwll_hrs),0)  FROM mdm_yard WHERE yd_cd = d.lnk_dest_nod_cd ) dest_dw_time," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						ltrim(to_char(trunc(l.tztm_hrs/24,0),'00')) || ltrim(to_char(mod(l.tztm_hrs,24  ),'00'))  fmt_tztm_hrs," ).append("\n"); 
		query.append("						v.vndr_lgl_eng_nm sp_name," ).append("\n"); 
		query.append("						a.trsp_agmt_ofc_cty_cd || LPAD(a.trsp_agmt_seq, 6, '0') agmt_no, a.agmt_ref_no," ).append("\n"); 
		query.append("						DECODE(d.inlnd_rout_cmb_flg, 'Y', 1, 0) inlnd_rout_cmb_flg," ).append("\n"); 
		query.append("                        DECODE(inlnd_rout_tmp_flg, 'Y', 1, 0) inlnd_rout_tmp_flg," ).append("\n"); 
		query.append("                        DECODE(trim(wrs_full_cmdt_cd), '', 0, 1) wrs_full_cmdt," ).append("\n"); 
		query.append("						m.cre_usr_id, m.cre_ofc_cd,m.cre_dt, m.inlnd_rout_rmk," ).append("\n"); 
		query.append("                        d.trsp_mod_cd trsp_mod, m.hub_loc_cd," ).append("\n"); 
		query.append("                        m.rout_pln_cd," ).append("\n"); 
		query.append("                        m.upd_usr_id, m.upd_dt," ).append("\n"); 
		query.append("                        m.inlnd_rout_inv_bil_patt_cd," ).append("\n"); 
		query.append("                        wrs_mty_cmdt_cd, pctl_io_bnd_cd, NVL(m.delt_flg,'N') delt_flg," ).append("\n"); 
		query.append("                        d.vndr_seq, inlnd_rout_junc_nm, d.rail_crr_tp_cd" ).append("\n"); 
		query.append("                   FROM prd_inlnd_rout_mst m, prd_inlnd_rout_dtl d, prd_inlnd_each_lnk l, prd_node n, prd_node n1, mdm_vendor v,TRS_AGMT_HDR a" ).append("\n"); 
		query.append("                   WHERE m.rout_org_nod_cd LIKE @[org_node]||'%'" ).append("\n"); 
		query.append("                     AND m.rout_dest_nod_cd LIKE @[dest_node]||'%'" ).append("\n"); 
		query.append("                     AND m.rout_org_nod_cd = n.nod_cd" ).append("\n"); 
		query.append("                     AND m.rout_dest_nod_cd = n1.nod_cd" ).append("\n"); 
		query.append("                     AND NVL(m.delt_flg,'N') = NVL('','N')" ).append("\n"); 
		query.append("                     AND m.rout_org_nod_cd = d.rout_org_nod_cd" ).append("\n"); 
		query.append("                     AND m.rout_dest_nod_cd = d.rout_dest_nod_cd" ).append("\n"); 
		query.append("                     AND m.rout_seq = d.rout_seq" ).append("\n"); 
		query.append("                     AND d.lnk_org_nod_cd = l.lnk_org_nod_cd" ).append("\n"); 
		query.append("                     AND d.lnk_dest_nod_cd = l.lnk_dest_nod_cd" ).append("\n"); 
		query.append("                     AND d.trsp_mod_cd = l.trsp_mod_cd" ).append("\n"); 
		query.append("                     AND m.pctl_io_bnd_cd = @[io_type]" ).append("\n"); 
		query.append("					 AND d.vndr_seq = v.vndr_seq(+)" ).append("\n"); 
		query.append("					 AND d.trsp_agmt_ofc_cty_cd = a.trsp_agmt_ofc_cty_cd(+)" ).append("\n"); 
		query.append("					 AND d.trsp_agmt_seq = a.trsp_agmt_seq(+)" ).append("\n"); 
		query.append("					 --AND   NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("					 AND (CASE  WHEN @[io_type] = 'B'  THEN 'OK'" ).append("\n"); 
		query.append("							WHEN @[io_type] = 'I'  AND n.nod_tp_cd in  ('M','B') AND @[node_type] = 'Z' AND n1.nod_tp_cd ='Z'   THEN 'OK'" ).append("\n"); 
		query.append("							WHEN @[io_type] = 'I'  AND n.nod_tp_cd in  ('M','B') AND @[node_type] = 'Y' AND n1.nod_tp_cd <> 'Z' THEN 'OK'" ).append("\n"); 
		query.append("							WHEN @[io_type] = 'O'  AND n1.nod_tp_cd in ('M','B') AND @[node_type] = 'Z' AND n.nod_tp_cd ='Z'    THEN 'OK'" ).append("\n"); 
		query.append("							WHEN @[io_type] = 'O'  AND n1.nod_tp_cd in ('M','B') AND @[node_type] = 'Y' AND n.nod_tp_cd <>'Z'   THEN 'OK' else 'XX'" ).append("\n"); 
		query.append("						END) = 'OK'" ).append("\n"); 
		query.append("                   ORDER BY m.rout_seq, d.rout_dtl_seq" ).append("\n"); 
		query.append("          /* ------------------------------------------------------------------------ */" ).append("\n"); 
		query.append("              ) m" ).append("\n"); 
		query.append("     GROUP BY m.rout_org_nod_cd, m.rout_dest_nod_cd, m.rout_seq, m.prio_seq,sum_tt_time,inlnd_rout_bkg_flg,inlnd_rout_tmp_flg," ).append("\n"); 
		query.append("              m.inlnd_rout_incl_sttl_flg,wrs_full_cmdt, inlnd_rout_inv_bil_patt_cd,rout_pln_cd,wrs_mty_cmdt_cd, pctl_io_bnd_cd" ).append("\n"); 
		query.append("              ,delt_flg" ).append("\n"); 
		query.append("     ORDER BY pctl_io_bnd_cd,rout_org_nod_cd, rout_dest_nod_cd, prio_seq" ).append("\n"); 

	}
}