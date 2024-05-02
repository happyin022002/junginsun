/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleDBDAOSearchDryDockScheduleListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharIODockScheduleDBDAOSearchDryDockScheduleListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharIODockScheduleDBDAOSearchDryDockScheduleListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dznd_capa_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ydSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_dck_svey_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dznd_capa_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration").append("\n"); 
		query.append("FileName : TCharIODockScheduleDBDAOSearchDryDockScheduleListVORSQL").append("\n"); 
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
		query.append("select a.vsl_cd," ).append("\n"); 
		query.append("d.slan_cd," ).append("\n"); 
		query.append("b.vsl_dznd_capa," ).append("\n"); 
		query.append("to_char(a.dck_fm_dt,'yyyymmdd') last_dck_fm_dt," ).append("\n"); 
		query.append("to_char(a.dck_to_dt,'yyyymmdd') last_dck_to_dt," ).append("\n"); 
		query.append("a.dck_loc_cd last_dck_loc_cd," ).append("\n"); 
		query.append("(select shp_yd_nm from fms_shp_yd fs where fs.yd_seq = a.yd_seq) last_ship_yard," ).append("\n"); 
		query.append("a.flet_dck_svey_tp_cd last_flet_dck_svey_tp_cd," ).append("\n"); 
		query.append("to_char(na.next_dck_fm_dt,'yyyymmdd') next_dck_fm_dt," ).append("\n"); 
		query.append("to_char(na.next_dck_to_dt,'yyyymmdd') next_dck_to_dt," ).append("\n"); 
		query.append("na.next_dck_loc_cd," ).append("\n"); 
		query.append("(select shp_yd_nm from fms_shp_yd fs where fs.yd_seq = na.yd_seq) next_ship_yard," ).append("\n"); 
		query.append("na.next_flet_dck_svey_tp_cd," ).append("\n"); 
		query.append("to_char(nc.dck_fm_dt,'yyyymmdd') rec_dck_fm_dt," ).append("\n"); 
		query.append("to_char(nc.dck_to_dt,'yyyymmdd') rec_dck_to_dt" ).append("\n"); 
		query.append("from fms_dck_skd a, fms_contract b," ).append("\n"); 
		query.append("(select vsl_cd, flet_ctrt_no" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num" ).append("\n"); 
		query.append("from fms_contract" ).append("\n"); 
		query.append("where flet_ctrt_tp_cd <> 'TO'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where row_num = 1" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select vsl_cd, flet_ctrt_no" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num" ).append("\n"); 
		query.append("from fms_id_vsl a" ).append("\n"); 
		query.append("where not exists (select null from fms_contract where flet_ctrt_tp_cd <> 'TO' and vsl_cd = a.vsl_cd)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where row_num = 1" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("(select vsl_cd, slan_cd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num" ).append("\n"); 
		query.append("from vsk_vsl_port_skd" ).append("\n"); 
		query.append("where vps_eta_dt between to_date(@[fr_duration]||'0101','yyyymmdd') and to_date(@[to_duration]||'1231','yyyymmdd')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where lane_num = 1) d," ).append("\n"); 
		query.append("(select a.vsl_cd, a.dck_fm_dt," ).append("\n"); 
		query.append("b.dck_fm_dt next_dck_fm_dt, b.dck_to_dt next_dck_to_dt, b.dck_loc_cd next_dck_loc_cd, b.yd_seq, b.flet_dck_svey_tp_cd next_flet_dck_svey_tp_cd" ).append("\n"); 
		query.append("from   (" ).append("\n"); 
		query.append("select vsl_cd, dck_fm_dt, row_number() over(partition by vsl_cd order by dck_fm_dt asc) row_num" ).append("\n"); 
		query.append("From fms_dck_skd" ).append("\n"); 
		query.append("where dck_sel_cd = 'E') a," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select vsl_cd, dck_fm_dt, dck_to_dt, dck_loc_cd, flet_dck_svey_tp_cd, yd_seq," ).append("\n"); 
		query.append("row_number() over(partition by vsl_cd order by dck_fm_dt asc) row_num" ).append("\n"); 
		query.append("From fms_dck_skd" ).append("\n"); 
		query.append("where dck_sel_cd = 'E') b" ).append("\n"); 
		query.append("where a.vsl_cd = b.vsl_cd" ).append("\n"); 
		query.append("and   a.row_num = b.row_num-1) na," ).append("\n"); 
		query.append("(select vsl_cd, dck_fm_dt, dck_to_dt" ).append("\n"); 
		query.append("from   fms_dck_skd" ).append("\n"); 
		query.append("where dck_sel_cd = 'C') nc" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ownr_seq} != \"\")" ).append("\n"); 
		query.append(",(select vndr_seq from mdm_vendor" ).append("\n"); 
		query.append("where flet_mgmt_ownr_vndr_seq = @[ownr_seq]) e" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where a.vsl_cd = c.vsl_cd(+)" ).append("\n"); 
		query.append("and   a.vsl_cd = d.vsl_cd(+)" ).append("\n"); 
		query.append("and   b.flet_ctrt_no(+) = c.flet_ctrt_no" ).append("\n"); 
		query.append("and   a.vsl_cd = na.vsl_cd(+)" ).append("\n"); 
		query.append("and   a.dck_fm_dt = na.dck_fm_dt(+)" ).append("\n"); 
		query.append("and   a.vsl_cd = nc.vsl_cd(+)" ).append("\n"); 
		query.append("#if (${flet_ctrt_tp_cd} != \"\")" ).append("\n"); 
		query.append("and   b.flet_ctrt_tp_cd like @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_dznd_capa_fr} != \"\")" ).append("\n"); 
		query.append("and   b.vsl_dznd_capa >= @[vsl_dznd_capa_fr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_dznd_capa_to} != \"\")" ).append("\n"); 
		query.append("and   b.vsl_dznd_capa <= @[vsl_dznd_capa_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane_cd} != \"\")" ).append("\n"); 
		query.append("and   d.slan_cd like @[lane_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ownr_seq} != \"\")" ).append("\n"); 
		query.append("and   b.vndr_seq = e.vndr_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ydSeq} != \"\")" ).append("\n"); 
		query.append("and   (a.yd_seq = @[ydSeq] or na.yd_seq = @[ydSeq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and	  a.vsl_cd like @[vsl_cd]||'%'" ).append("\n"); 
		query.append("and   a.dck_sel_cd = 'E'" ).append("\n"); 
		query.append("and   a.flet_dck_svey_tp_cd like @[flet_dck_svey_tp_cd]||'%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${reflection_cd} == \"I\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and a.phs_out_dt <= @[to_duration]||'1231' and a.phs_in_dt >= @[fr_duration]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("and a.dck_fm_dt <= to_date(@[to_duration]||'1231','yyyymmdd') and a.dck_to_dt >= to_date(@[fr_duration]||'0101','yyyymmdd')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select a.vsl_cd," ).append("\n"); 
		query.append("d.slan_cd," ).append("\n"); 
		query.append("b.vsl_dznd_capa," ).append("\n"); 
		query.append("null last_dck_fm_dt," ).append("\n"); 
		query.append("null last_dck_to_dt," ).append("\n"); 
		query.append("null last_dck_loc_cd," ).append("\n"); 
		query.append("null last_ship_yard," ).append("\n"); 
		query.append("null last_flet_dck_svey_tp_cd," ).append("\n"); 
		query.append("null next_dck_fm_dt," ).append("\n"); 
		query.append("null next_dck_to_dt," ).append("\n"); 
		query.append("null next_dck_loc_cd," ).append("\n"); 
		query.append("null next_ship_yard," ).append("\n"); 
		query.append("null next_flet_dck_svey_tp_cd," ).append("\n"); 
		query.append("to_char(a.dck_fm_dt,'yyyymmdd') rec_dck_fm_dt," ).append("\n"); 
		query.append("to_char(a.dck_to_dt,'yyyymmdd') rec_dck_to_dt" ).append("\n"); 
		query.append("from fms_dck_skd a, fms_contract b," ).append("\n"); 
		query.append("(select vsl_cd, flet_ctrt_no" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num" ).append("\n"); 
		query.append("from fms_contract" ).append("\n"); 
		query.append("where flet_ctrt_tp_cd <> 'TO'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where row_num = 1" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("select vsl_cd, flet_ctrt_no" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num" ).append("\n"); 
		query.append("from fms_id_vsl a" ).append("\n"); 
		query.append("where not exists (select null from fms_contract where flet_ctrt_tp_cd <> 'TO' and vsl_cd = a.vsl_cd)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where row_num = 1" ).append("\n"); 
		query.append(") c," ).append("\n"); 
		query.append("(select vsl_cd, slan_cd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num" ).append("\n"); 
		query.append("from vsk_vsl_port_skd" ).append("\n"); 
		query.append("where vps_eta_dt between to_date(@[fr_duration]||'0101','yyyymmdd') and to_date(@[to_duration]||'1231','yyyymmdd')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where lane_num = 1) d" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ownr_seq} != \"\")" ).append("\n"); 
		query.append(",(select vndr_seq from mdm_vendor" ).append("\n"); 
		query.append("where flet_mgmt_ownr_vndr_seq = @[ownr_seq]) e" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where a.vsl_cd = c.vsl_cd(+)" ).append("\n"); 
		query.append("and   a.vsl_cd = d.vsl_cd(+)" ).append("\n"); 
		query.append("and   b.flet_ctrt_no(+) = c.flet_ctrt_no" ).append("\n"); 
		query.append("#if (${flet_ctrt_tp_cd} != \"\")" ).append("\n"); 
		query.append("and   b.flet_ctrt_tp_cd like @[flet_ctrt_tp_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_dznd_capa_fr} != \"\")" ).append("\n"); 
		query.append("and   b.vsl_dznd_capa >= @[vsl_dznd_capa_fr]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_dznd_capa_to} != \"\")" ).append("\n"); 
		query.append("and   b.vsl_dznd_capa <= @[vsl_dznd_capa_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane_cd} != \"\")" ).append("\n"); 
		query.append("and   d.slan_cd like @[lane_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ownr_seq} != \"\")" ).append("\n"); 
		query.append("and   b.vndr_seq = e.vndr_seq" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and	  a.vsl_cd like @[vsl_cd]||'%'" ).append("\n"); 
		query.append("and   a.dck_sel_cd = 'C'" ).append("\n"); 
		query.append("and   a.flet_dck_svey_tp_cd like @[flet_dck_svey_tp_cd]||'%'" ).append("\n"); 
		query.append("and   not exists (select null from fms_dck_skd where vsl_cd = a.vsl_cd and dck_sel_cd = 'E')" ).append("\n"); 
		query.append("and a.dck_fm_dt <= to_date(@[to_duration]||'1231','yyyymmdd') and a.dck_to_dt >= to_date(@[fr_duration]||'0101','yyyymmdd')" ).append("\n"); 

	}
}