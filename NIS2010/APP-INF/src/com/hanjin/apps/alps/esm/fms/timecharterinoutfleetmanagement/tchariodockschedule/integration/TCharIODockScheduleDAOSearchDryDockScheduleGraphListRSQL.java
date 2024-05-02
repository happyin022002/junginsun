/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleDAOSearchDryDockScheduleGraphListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.25 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharIODockScheduleDAOSearchDryDockScheduleGraphListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * D/dock Schedule Review / Graph
	  * </pre>
	  */
	public TCharIODockScheduleDAOSearchDryDockScheduleGraphListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fst_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snd_year",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("b.vsl_dznd_capa" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${reflection_cd} == \"I\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0131' and phs_in_dt >= @[fst_year]||'0101' then a.flet_dck_svey_tp_cd else '' end) ym1_01" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0231' and phs_in_dt >= @[fst_year]||'0201' then a.flet_dck_svey_tp_cd else '' end) ym1_02" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0331' and phs_in_dt >= @[fst_year]||'0301' then a.flet_dck_svey_tp_cd else '' end) ym1_03" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0431' and phs_in_dt >= @[fst_year]||'0401' then a.flet_dck_svey_tp_cd else '' end) ym1_04" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0531' and phs_in_dt >= @[fst_year]||'0501' then a.flet_dck_svey_tp_cd else '' end) ym1_05" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0631' and phs_in_dt >= @[fst_year]||'0601' then a.flet_dck_svey_tp_cd else '' end) ym1_06" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0731' and phs_in_dt >= @[fst_year]||'0701' then a.flet_dck_svey_tp_cd else '' end) ym1_07" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0831' and phs_in_dt >= @[fst_year]||'0801' then a.flet_dck_svey_tp_cd else '' end) ym1_08" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'0931' and phs_in_dt >= @[fst_year]||'0901' then a.flet_dck_svey_tp_cd else '' end) ym1_09" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'1031' and phs_in_dt >= @[fst_year]||'1001' then a.flet_dck_svey_tp_cd else '' end) ym1_10" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'1131' and phs_in_dt >= @[fst_year]||'1101' then a.flet_dck_svey_tp_cd else '' end) ym1_11" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[fst_year]||'1231' and phs_in_dt >= @[fst_year]||'1201' then a.flet_dck_svey_tp_cd else '' end) ym1_12" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${snd_year} != \"\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0131' and phs_in_dt >= @[snd_year]||'0101' then a.flet_dck_svey_tp_cd else '' end) ym2_01" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0231' and phs_in_dt >= @[snd_year]||'0201' then a.flet_dck_svey_tp_cd else '' end) ym2_02" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0331' and phs_in_dt >= @[snd_year]||'0301' then a.flet_dck_svey_tp_cd else '' end) ym2_03" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0431' and phs_in_dt >= @[snd_year]||'0401' then a.flet_dck_svey_tp_cd else '' end) ym2_04" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0531' and phs_in_dt >= @[snd_year]||'0501' then a.flet_dck_svey_tp_cd else '' end) ym2_05" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0631' and phs_in_dt >= @[snd_year]||'0601' then a.flet_dck_svey_tp_cd else '' end) ym2_06" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0731' and phs_in_dt >= @[snd_year]||'0701' then a.flet_dck_svey_tp_cd else '' end) ym2_07" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0831' and phs_in_dt >= @[snd_year]||'0801' then a.flet_dck_svey_tp_cd else '' end) ym2_08" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'0931' and phs_in_dt >= @[snd_year]||'0901' then a.flet_dck_svey_tp_cd else '' end) ym2_09" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'1031' and phs_in_dt >= @[snd_year]||'1001' then a.flet_dck_svey_tp_cd else '' end) ym2_10" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'1131' and phs_in_dt >= @[snd_year]||'1101' then a.flet_dck_svey_tp_cd else '' end) ym2_11" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[snd_year]||'1231' and phs_in_dt >= @[snd_year]||'1201' then a.flet_dck_svey_tp_cd else '' end) ym2_12" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_year} != \"\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0131' and phs_in_dt >= @[trd_year]||'0101' then a.flet_dck_svey_tp_cd else '' end) ym3_01" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0231' and phs_in_dt >= @[trd_year]||'0201' then a.flet_dck_svey_tp_cd else '' end) ym3_02" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0331' and phs_in_dt >= @[trd_year]||'0301' then a.flet_dck_svey_tp_cd else '' end) ym3_03" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0431' and phs_in_dt >= @[trd_year]||'0401' then a.flet_dck_svey_tp_cd else '' end) ym3_04" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0531' and phs_in_dt >= @[trd_year]||'0501' then a.flet_dck_svey_tp_cd else '' end) ym3_05" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0631' and phs_in_dt >= @[trd_year]||'0601' then a.flet_dck_svey_tp_cd else '' end) ym3_06" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0731' and phs_in_dt >= @[trd_year]||'0701' then a.flet_dck_svey_tp_cd else '' end) ym3_07" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0831' and phs_in_dt >= @[trd_year]||'0801' then a.flet_dck_svey_tp_cd else '' end) ym3_08" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'0931' and phs_in_dt >= @[trd_year]||'0901' then a.flet_dck_svey_tp_cd else '' end) ym3_09" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'1031' and phs_in_dt >= @[trd_year]||'1001' then a.flet_dck_svey_tp_cd else '' end) ym3_10" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'1131' and phs_in_dt >= @[trd_year]||'1101' then a.flet_dck_svey_tp_cd else '' end) ym3_11" ).append("\n"); 
		query.append(",max(case when phs_out_dt <= @[trd_year]||'1231' and phs_in_dt >= @[trd_year]||'1201' then a.flet_dck_svey_tp_cd else '' end) ym3_12" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'01','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_01" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'02','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_02" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'03','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_03" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'04','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_04" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'05','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_05" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'06','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_06" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'07','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_07" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'08','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_08" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'09','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_09" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'10','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_10" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'11','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_11" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[fst_year]||'12','yyyymm')) and dck_to_dt >= to_date(@[fst_year]||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_12" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${snd_year} != \"\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'01','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_01" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'02','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_02" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'03','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_03" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'04','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_04" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'05','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_05" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'06','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_06" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'07','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_07" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'08','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_08" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'09','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_09" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'10','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_10" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'11','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_11" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[snd_year]||'12','yyyymm')) and dck_to_dt >= to_date(@[snd_year]||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_12" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trd_year} != \"\")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'01','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_01" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'02','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_02" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'03','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_03" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'04','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_04" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'05','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_05" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'06','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_06" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'07','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_07" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'08','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_08" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'09','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_09" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'10','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_10" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'11','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_11" ).append("\n"); 
		query.append(",max(case when dck_fm_dt <= last_day(to_date(@[trd_year]||'12','yyyymm')) and dck_to_dt >= to_date(@[trd_year]||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_12" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
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
		query.append("group by a.vsl_cd," ).append("\n"); 
		query.append("d.slan_cd," ).append("\n"); 
		query.append("b.vsl_dznd_capa" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration").append("\n"); 
		query.append("FileName : TCharIODockScheduleDAOSearchDryDockScheduleGraphListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}