/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.04
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.05.04 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repo Container별 합계
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOSearchEmptyCntrSumRSQL").append("\n"); 
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
		query.append("max(decode(cntr_tpsz_cd,'D2',vol,0)) sum_d2" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'D4',vol,0)) sum_d4" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'D5',vol,0)) sum_d5" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'D7',vol,0)) sum_d7" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'R2',vol,0)) sum_r2" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'R4',vol,0)) sum_r4" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'R5',vol,0)) sum_r5" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'F2',vol,0)) sum_f2" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'F4',vol,0)) sum_f4" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'F5',vol,0)) sum_f5" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'O2',vol,0)) sum_o2" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'O4',vol,0)) sum_o4" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'A2',vol,0)) sum_a2" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'A4',vol,0)) sum_a4" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'S2',vol,0)) sum_s2" ).append("\n"); 
		query.append(",max(decode(cntr_tpsz_cd,'S4',vol,0)) sum_s4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("select qty.cntr_tpsz_cd, sum(op_cntr_qty) vol" ).append("\n"); 
		query.append("from bkg_quantity qty," ).append("\n"); 
		query.append("(SELECT DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("FROM bkg_booking bk," ).append("\n"); 
		query.append("(select bk.bkg_no, bk.fm_bkg_no" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append(", bkg_vvd vvd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no1} != '')" ).append("\n"); 
		query.append(", bkg_container cntr" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_date_tp} == 'E')" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("select skd.vps_eta_dt, bk.bkg_no, vvd.pod_cd" ).append("\n"); 
		query.append("from bkg_booking bk, bkg_vvd vvd, vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("where bk.bkg_no            = vvd.bkg_no" ).append("\n"); 
		query.append("and bk.pod_cd            = vvd.pod_cd" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd   in ('T','U')" ).append("\n"); 
		query.append("and vvd.vsl_cd           = skd.vsl_cd" ).append("\n"); 
		query.append("and vvd.skd_voy_no       = skd.skd_voy_no" ).append("\n"); 
		query.append("and vvd.skd_dir_cd       = skd.skd_dir_cd" ).append("\n"); 
		query.append("and vvd.pod_cd           = skd.VPS_PORT_CD" ).append("\n"); 
		query.append("and vvd.pod_clpt_ind_seq = skd.clpt_ind_seq" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("and vvd.vsl_cd     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("and vvd.skd_voy_no = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("and vvd.skd_dir_cd = substr(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_from_dt} != '')" ).append("\n"); 
		query.append("and skd.vps_eta_dt >= to_date(@[cre_from_dt]|| '00:00:00','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_to_dt} != '')" ).append("\n"); 
		query.append("and skd.vps_eta_dt <= to_date(@[cre_to_dt]|| '23:59:59','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") eta" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("where bk.bkg_cgo_tp_cd = 'P'" ).append("\n"); 
		query.append("and 'Y' = case when bk.split_flg = 'Y' and bk.bkg_sts_cd = 'X' then 'Y'--split인데 cancel된 건 -> master bkg -> 조회됨" ).append("\n"); 
		query.append("when bk.split_flg = 'N' and bk.bkg_sts_Cd = 'X' then 'N'--split이 아닌데 cancel된 건 -> 일반 cancel -> 조회안됨" ).append("\n"); 
		query.append("else 'Y' end --그외 조회됨" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("and bk.bkg_no LIKE @[bkg_no]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and bk.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if  (${bl_no} != '')" ).append("\n"); 
		query.append("and bk.bl_no LIKE @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("and bk.bkg_no     = vvd.bkg_no" ).append("\n"); 
		query.append("and vvd.vsl_cd     = substr(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("and vvd.skd_voy_no = substr(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("and vvd.skd_dir_cd = substr(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no1} != '')" ).append("\n"); 
		query.append("and bk.bkg_no = cntr.bkg_no" ).append("\n"); 
		query.append("and cntr.cntr_no = @[cntr_no1]||@[cntr_no2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("and bk.pol_cd LIKE @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("and bk.pod_cd LIKE @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pre_rly_port_cd} != '')" ).append("\n"); 
		query.append("and bk.pre_rly_port_cd LIKE @[pre_rly_port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pst_rly_port_cd} != '')" ).append("\n"); 
		query.append("and bk.pst_rly_port_cd LIKE @[pst_rly_port_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} == '')" ).append("\n"); 
		query.append("#if (${bkg_date_tp} != 'E')" ).append("\n"); 
		query.append("#if (${cre_from_dt} != '')" ).append("\n"); 
		query.append("and bk.bkg_cre_dt >= to_date(@[cre_from_dt]|| '00:00:00','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_to_dt} != '')" ).append("\n"); 
		query.append("and bk.bkg_cre_dt <= to_date(@[cre_to_dt]|| '23:59:59','yyyy-mm-dd HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and bk.bkg_no = eta.bkg_no" ).append("\n"); 
		query.append("and bk.pod_cd = eta.pod_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("and bk.bkg_ofc_cd = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd_flg} == 'E')" ).append("\n"); 
		query.append("and vvd.vsl_pre_pst_cd = 'T'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_attach} == 'Y')" ).append("\n"); 
		query.append("and (select count(1) from bkg_container bcntr where bk.bkg_no = bcntr.bkg_no and rownum = 1) > 0" ).append("\n"); 
		query.append("#elseif  (${cntr_attach} == 'N')" ).append("\n"); 
		query.append("and (select count(1) from bkg_container bcntr where bk.bkg_no = bcntr.bkg_no and rownum = 1) = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") mst_bkg" ).append("\n"); 
		query.append("-------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("#if (${bkg_no} == '' && ${bl_no} == '')" ).append("\n"); 
		query.append("where bk.bkg_no = mst_bkg.bkg_no" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("where (bk.bkg_no = mst_bkg.bkg_no or bk.fm_bkg_no = mst_bkg.bkg_no or mst_bkg.fm_bkg_no = bk.bkg_no)" ).append("\n"); 
		query.append("--	or (length(mst_bkg.bkg_no) = 13 and bk.bkg_no = substr(mst_bkg.bkg_no, 1, 11))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") BK" ).append("\n"); 
		query.append("WHERE bk.bkg_no = qty.bkg_no" ).append("\n"); 
		query.append("group by qty.cntr_tpsz_cd" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}