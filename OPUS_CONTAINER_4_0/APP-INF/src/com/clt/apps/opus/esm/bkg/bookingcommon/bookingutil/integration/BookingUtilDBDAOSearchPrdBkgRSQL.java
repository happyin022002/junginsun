/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchPrdBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchPrdBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * prd로 보낼 parameter를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchPrdBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flex_hgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pm_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trns_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hg_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("m_pu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cmd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_sal_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ak_f",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cngn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod2_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol2_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod4_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol4_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_n",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_un",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_com",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pc_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchPrdBkgRSQL").append("\n"); 
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
		query.append("#if (${bkg_no}!= '')" ).append("\n"); 
		query.append("select @[f_cmd]			 f_cmd" ).append("\n"); 
		query.append("	, @[pc_mode]		 pc_mode" ).append("\n"); 
		query.append("	, @[bkg_no] 		 bkg_no     " ).append("\n"); 
		query.append("    , nvl(@[t_vvd]       , bk.vsl_cd||bk.skd_voy_no||bk.skd_dir_cd ) t_vvd			" ).append("\n"); 
		query.append("    , nvl(@[rcv_t]       , bk.rcv_term_Cd  )  		rcv_t      			" ).append("\n"); 
		query.append("    , nvl(@[del_t]       , bk.de_term_cd   )	del_t      		" ).append("\n"); 
		query.append("    , nvl(@[por]         , bk.por_cd       )	por        		" ).append("\n"); 
		query.append("    , nvl(@[por_n]       , bk.por_nod_cd   )	por_n      		" ).append("\n"); 
		query.append("    , nvl(@[pol]         , bk.pol_cd       )	pol        		" ).append("\n"); 
		query.append("    , nvl(@[pol_n]       , bk.pol_nod_cd   )	pol_n      		" ).append("\n"); 
		query.append("    , nvl(@[pod]         , bk.pod_cd       )	pod        		" ).append("\n"); 
		query.append("    , nvl(@[pod_n]       , bk.pod_nod_cd   )	pod_n      		" ).append("\n"); 
		query.append("    , nvl(@[del]         , bk.del_cd       )	del        		" ).append("\n"); 
		query.append("    , nvl(@[del_n]       , bk.del_nod_cd   )	del_n      		" ).append("\n"); 
		query.append("    , nvl(@[pod1]        , n1vvd.pod_cd    )	pod1       		" ).append("\n"); 
		query.append("    , nvl(@[pod1_n]      , n1vvd.pod_yd_cd )	pod1_n     		" ).append("\n"); 
		query.append("    , nvl(@[pod1_c]      , n1vvd.pod_clpt_ind_seq)  pod1_c  " ).append("\n"); 
		query.append("    , nvl(@[pol1]        , n1vvd.pol_cd    )	pol1       		" ).append("\n"); 
		query.append("    , nvl(@[pol1_n]      , n1vvd.pol_yd_cd )	pol1_n   " ).append("\n"); 
		query.append("	, nvl(@[pol1_c]      , n1vvd.pol_clpt_ind_seq)	pol1_c  " ).append("\n"); 
		query.append("#if (${ui_no} == 'ESM_BKG_0077') " ).append("\n"); 
		query.append("	#if (${vvd1} != '') " ).append("\n"); 
		query.append("	, @[vvd1] vvd1  " ).append("\n"); 
		query.append("	, (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd1], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd1], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd1], 9, 1)) lane1   " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else		" ).append("\n"); 
		query.append("    , nvl(@[vvd1]        , n1vvd.vvd       )	vvd1       		" ).append("\n"); 
		query.append("    , nvl((select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd1], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd1], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd1], 9, 1)), n1vvd.slan_cd   ) lane1   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , nvl(@[pod2]        , n2vvd.pod_cd    )	pod2       		" ).append("\n"); 
		query.append("    , nvl(@[pod2_n]      , n2vvd.pod_yd_cd )	pod2_n   " ).append("\n"); 
		query.append("	, nvl(@[pod2_c]      , n2vvd.pod_clpt_ind_seq)	pod2_c     		" ).append("\n"); 
		query.append("    , nvl(@[pol2]        , n2vvd.pol_cd    )	pol2       		" ).append("\n"); 
		query.append("    , nvl(@[pol2_n]      , n2vvd.pol_yd_cd )	pol2_n   " ).append("\n"); 
		query.append("	, nvl(@[pol2_c]      , n2vvd.pol_clpt_ind_seq)	pol2_c  " ).append("\n"); 
		query.append("#if (${ui_no} == 'ESM_BKG_0077') " ).append("\n"); 
		query.append("	#if (${vvd2} != '') " ).append("\n"); 
		query.append("    , @[vvd2] vvd2  " ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd2], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd2], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd2], 9, 1)) lane2  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    , nvl(@[vvd2]        , n2vvd.vvd       )	vvd2  " ).append("\n"); 
		query.append("    , nvl((select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd2], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd2], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd2], 9, 1)), n2vvd.slan_cd   ) lane2   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    , nvl(@[pod3]        , n3vvd.pod_cd    )	pod3       		" ).append("\n"); 
		query.append("    , nvl(@[pod3_n]      , n3vvd.pod_yd_cd )	pod3_n  " ).append("\n"); 
		query.append("	, nvl(@[pod3_c]      , n3vvd.pod_clpt_ind_seq)	pod3_c    		" ).append("\n"); 
		query.append("    , nvl(@[pol3]        , n3vvd.pol_cd    )	pol3       		" ).append("\n"); 
		query.append("    , nvl(@[pol3_n]      , n3vvd.pol_yd_cd )	pol3_n   " ).append("\n"); 
		query.append("	, nvl(@[pol3_c]      , n3vvd.pol_clpt_ind_seq)	pol3_c  " ).append("\n"); 
		query.append("#if (${ui_no} == 'ESM_BKG_0077') " ).append("\n"); 
		query.append("	#if (${vvd3} != '') " ).append("\n"); 
		query.append("	, @[vvd3] vvd3       " ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd3], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd3], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd3], 9, 1)) lane3  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else	" ).append("\n"); 
		query.append("    , nvl(@[vvd3]        , n3vvd.vvd       )	vvd3       " ).append("\n"); 
		query.append("    , nvl((select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd3], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd3], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd3], 9, 1)), n3vvd.slan_cd   ) lane3  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    , nvl(@[pod4]        , n4vvd.pod_cd    )	pod4       		" ).append("\n"); 
		query.append("    , nvl(@[pod4_n]      , n4vvd.pod_yd_cd )	pod4_n " ).append("\n"); 
		query.append("	, nvl(@[pod4_c]      , n4vvd.pod_clpt_ind_seq)	pod4_c     		" ).append("\n"); 
		query.append("    , nvl(@[pol4]        , n4vvd.pol_cd    )	pol4       		" ).append("\n"); 
		query.append("    , nvl(@[pol4_n]      , n4vvd.pol_yd_cd )	pol4_n " ).append("\n"); 
		query.append("	, nvl(@[pol4_c]      , n4vvd.pol_clpt_ind_seq)	pol4_c " ).append("\n"); 
		query.append("#if (${ui_no} == 'ESM_BKG_0077') " ).append("\n"); 
		query.append("	#if (${vvd4} != '') " ).append("\n"); 
		query.append("    , @[vvd4] vvd4       " ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd4], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd4], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd4], 9, 1)) lane4  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    , nvl(@[vvd4]        , n4vvd.vvd       )	vvd4       " ).append("\n"); 
		query.append("    , nvl((select skd.vsl_slan_cd " ).append("\n"); 
		query.append("             from vsk_vsl_skd skd" ).append("\n"); 
		query.append("            where vsl_cd     = substr(@[vvd4], 1, 4) " ).append("\n"); 
		query.append("              and skd_voy_no = substr(@[vvd4], 5, 4) " ).append("\n"); 
		query.append("              and skd_dir_cd = substr(@[vvd4], 9, 1)), n4vvd.slan_cd   ) lane4  " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    , to_char(nvl(to_date(@[ld_dt],      'yy/mm/dd'), bk.lodg_due_dt  ), 'yyyymmdd') ld_dt      		" ).append("\n"); 
		query.append("    , to_char(nvl(to_date(@[dr_dt],      'yy/mm/dd'), bk.de_due_dt    ), 'yyyymmdd') dr_dt      		" ).append("\n"); 
		query.append("--최초 생성 이후에 m_pu, f_rt, mt_pkup_dt 적용 없음(20091217 신은영차장님 요청)" ).append("\n"); 
		query.append("	, @[mt_pkup_dt]							  mt_pkup_dt			" ).append("\n"); 
		query.append("    , @[m_pu]      							  m_pu    " ).append("\n"); 
		query.append("    , @[f_rt] 								  f_rt     " ).append("\n"); 
		query.append("	, decode(@[org_trns_mode], 'X', 'AL', (select ATTR_CTNT2 from bkg_hrd_cdg_ctnt where HRD_CDG_ID = 'PRI_PRD_TRNS_MODE_CD' and ATTR_CTNT1 = nvl(@[org_trns_mode],  bk.ORG_TRNS_MOD_CD)))  org_trns_mode" ).append("\n"); 
		query.append("	, decode(@[dest_trns_mode],'X', 'AL', (select ATTR_CTNT2 from bkg_hrd_cdg_ctnt where HRD_CDG_ID = 'PRI_PRD_TRNS_MODE_CD' and ATTR_CTNT1 = nvl(@[dest_trns_mode], bk.DEST_TRNS_MOD_CD))) dest_trns_mode			" ).append("\n"); 
		query.append("    , nvl(@[cgo_tp]      , bk.bkg_cgo_tp_cd ) cgo_tp     			" ).append("\n"); 
		query.append("    , nvl(@[pm_f]        , bk.hot_de_flg    ) pm_f       			" ).append("\n"); 
		query.append("    , nvl(@[dg_f]        , bk.dcgo_flg      ) dg_f       			" ).append("\n"); 
		query.append("    , nvl(@[rf_f]        , bk.rc_flg        ) rf_f       			" ).append("\n"); 
		query.append("    , nvl(@[ak_f]        , bk.awk_cgo_flg   ) ak_f       			" ).append("\n"); 
		query.append("    , nvl(@[bb_f]        , bk.bb_cgo_flg    ) bb_f       			" ).append("\n"); 
		query.append("    , nvl(@[rd_f]        , bk.rd_cgo_flg    ) rd_f       			" ).append("\n"); 
		query.append("    , nvl(@[soc_f]       , bk.soc_flg       ) soc_f           			" ).append("\n"); 
		query.append("    , nvl(@[flex_hgt_flg], bk.flex_hgt_flg  ) flex_hgt_flg" ).append("\n"); 
		query.append("    , nvl(@[com]         , bk.cmdt_cd       ) com        			" ).append("\n"); 
		query.append("    , nvl(@[rep_com]     , bk.rep_cmdt_cd   ) rep_com    			" ).append("\n"); 
		query.append("    , nvl(@[bkg_ofc]     , bk.bkg_ofc_cd    ) bkg_ofc    			" ).append("\n"); 
		query.append("    , nvl(@[org_sal_ofc] , bk.ob_sls_ofc_cd ) org_sal_ofc			" ).append("\n"); 
		query.append("    , nvl(@[wgt]         , bl.act_wgt       ) wgt        			" ).append("\n"); 
		query.append("    , nvl(@[wgt_un]      , bl.wgt_ut_cd     ) wgt_un     			" ).append("\n"); 
		query.append("    , nvl(@[hg_f]        , bk.hngr_flg      ) hg_f       			" ).append("\n"); 
		query.append("    , nvl(@[sub_f]       , bk.eq_subst_flg  ) sub_f      			" ).append("\n"); 
		query.append("    , nvl(@[rfa]         , bk.rfa_no        ) rfa" ).append("\n"); 
		query.append("    , nvl(@[sc]          , bk.sc_no         ) sc" ).append("\n"); 
		query.append("	, '' 									  rfa_ofc" ).append("\n"); 
		query.append("	, '' 									  sc_ofc" ).append("\n"); 
		query.append("    , nvl(@[shpr], (select cust_cnt_cd||trim(to_char(cust_seq, '000009'))" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    				FROM BKG_CUST_HIS CUST " ).append("\n"); 
		query.append("    				WHERE CUST.BKG_NO = BK.BKG_NO AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("					AND CORR_NO = 'TMP0000001')) shpr" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    				FROM BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("    				WHERE CUST.BKG_NO = BK.BKG_NO AND CUST.BKG_CUST_TP_CD = 'S')) shpr" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("    , nvl(@[cngn], (select cust_cnt_cd||trim(to_char(cust_seq, '000009'))" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    				FROM BKG_CUST_HIS CUST " ).append("\n"); 
		query.append("					WHERE CUST.BKG_NO = BK.BKG_NO AND CUST.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("					AND CORR_NO = 'TMP0000001')) cngn" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    				FROM BKG_CUSTOMER CUST " ).append("\n"); 
		query.append("					WHERE CUST.BKG_NO = BK.BKG_NO AND CUST.BKG_CUST_TP_CD = 'C')) cngn" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("    				" ).append("\n"); 
		query.append("    , (SELECT imdg_clss_cd " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("    	from bkg_dg_cgo_his dg " ).append("\n"); 
		query.append("    	where dg.bkg_no = bk.bkg_no " ).append("\n"); 
		query.append("		and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    	from bkg_dg_cgo dg " ).append("\n"); 
		query.append("    	where dg.bkg_no = bk.bkg_no " ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("        and imdg_clss_cd is not null and rownum = 1) imdg" ).append("\n"); 
		query.append("	, '' com_bkg_no" ).append("\n"); 
		query.append("	, '' hitchment   			" ).append("\n"); 
		query.append("	, '' parent_bkg_no" ).append("\n"); 
		query.append("	, '' copy_cnt" ).append("\n"); 
		query.append("	, '' ocn_seq" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("  from  bkg_bkg_his bk" ).append("\n"); 
		query.append("       ,bkg_bl_doc_his bl  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  from  bkg_booking bk" ).append("\n"); 
		query.append("       ,bkg_bl_doc bl  " ).append("\n"); 
		query.append("#end        	" ).append("\n"); 
		query.append("       , (select rownum num, bkg_no, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd, pol_clpt_ind_seq, pod_clpt_ind_seq, vsl_cd||skd_voy_no||skd_dir_cd vvd, vvd.slan_Cd" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("            from bkg_vvd_his vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(" 		     and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            from bkg_vvd vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("		   ORDER BY vvd.bkg_no, vvd.vsl_pre_pst_cd, vvd.vsl_seq) n1vvd" ).append("\n"); 
		query.append("       , (select rownum num, bkg_no, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd, pol_clpt_ind_seq, pod_clpt_ind_seq, vsl_cd||skd_voy_no||skd_dir_cd vvd, vvd.slan_Cd" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("            from bkg_vvd_his vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(" 			 and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            from bkg_vvd vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("		   ORDER BY vvd.bkg_no, vvd.vsl_pre_pst_cd, vvd.vsl_seq) n2vvd" ).append("\n"); 
		query.append("       , (select rownum num, bkg_no, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd, pol_clpt_ind_seq, pod_clpt_ind_seq, vsl_cd||skd_voy_no||skd_dir_cd vvd, vvd.slan_Cd" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("            from bkg_vvd_his vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(" 			 and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            from bkg_vvd vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("		   ORDER BY vvd.bkg_no, vvd.vsl_pre_pst_cd, vvd.vsl_seq) n3vvd" ).append("\n"); 
		query.append("       , (select rownum num, bkg_no, pol_cd, pol_yd_cd, pod_cd, pod_yd_cd, pol_clpt_ind_seq, pod_clpt_ind_seq, vsl_cd||skd_voy_no||skd_dir_cd vvd, vvd.slan_Cd" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("            from bkg_vvd_his vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append(" 			 and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            from bkg_vvd vvd" ).append("\n"); 
		query.append("           where vvd.bkg_no = @[bkg_no] " ).append("\n"); 
		query.append("#end              			" ).append("\n"); 
		query.append("		   ORDER BY vvd.bkg_no, vvd.vsl_pre_pst_cd, vvd.vsl_seq) n4vvd" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("   and bk.bkg_no = n1vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and 1         = n1vvd.num   (+)" ).append("\n"); 
		query.append("   and bk.bkg_no = n2vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and 2         = n2vvd.num   (+)" ).append("\n"); 
		query.append("   and bk.bkg_no = n3vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and 3         = n3vvd.num   (+)" ).append("\n"); 
		query.append("   and bk.bkg_no = n4vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and 4         = n4vvd.num   (+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("   and bk.corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("   and bl.corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("select @[f_cmd]			f_cmd" ).append("\n"); 
		query.append("	, @[pc_mode]		pc_mode" ).append("\n"); 
		query.append("	, @[bkg_no] 		bkg_no     " ).append("\n"); 
		query.append("    , @[t_vvd]			t_vvd			" ).append("\n"); 
		query.append("    , @[rcv_t]   		rcv_t      			" ).append("\n"); 
		query.append("    , @[del_t]       	del_t      		" ).append("\n"); 
		query.append("    , @[por]         	por        		" ).append("\n"); 
		query.append("    , @[por_n]       	por_n      		" ).append("\n"); 
		query.append("    , @[pol]         	pol        		" ).append("\n"); 
		query.append("    , @[pol_n]       	pol_n      		" ).append("\n"); 
		query.append("    , @[pod]         	pod        		" ).append("\n"); 
		query.append("    , @[pod_n]       	pod_n      		" ).append("\n"); 
		query.append("    , @[del]         	del        		" ).append("\n"); 
		query.append("    , @[del_n]       	del_n      		" ).append("\n"); 
		query.append("    , @[pod1]        	pod1       		" ).append("\n"); 
		query.append("    , @[pod1_n]     	pod1_n     		" ).append("\n"); 
		query.append("    , @[pod1_c]     	pod1_c  " ).append("\n"); 
		query.append("    , @[pol1]        	pol1       		" ).append("\n"); 
		query.append("    , @[pol1_n]      	pol1_n     		" ).append("\n"); 
		query.append("    , @[pol1_c]      	pol1_c" ).append("\n"); 
		query.append("    , @[vvd1]        	vvd1       		" ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("         from vsk_vsl_skd skd" ).append("\n"); 
		query.append("        where vsl_cd     = substr(@[vvd4], 1, 4) " ).append("\n"); 
		query.append("          and skd_voy_no = substr(@[vvd4], 5, 4) " ).append("\n"); 
		query.append("          and skd_dir_cd = substr(@[vvd4], 9, 1)) lane1      		" ).append("\n"); 
		query.append("    , @[pod2]        	pod2       		" ).append("\n"); 
		query.append("    , @[pod2_n]      	pod2_n      		" ).append("\n"); 
		query.append("    , @[pod2_c]      	pod2_c  " ).append("\n"); 
		query.append("    , @[pol2]        	pol2       		" ).append("\n"); 
		query.append("    , @[pol2_n]      	pol2_n      		" ).append("\n"); 
		query.append("    , @[pol2_c]      	pol2_c" ).append("\n"); 
		query.append("    , @[vvd2]        	vvd2       		" ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("         from vsk_vsl_skd skd" ).append("\n"); 
		query.append("        where vsl_cd     = substr(@[vvd2], 1, 4) " ).append("\n"); 
		query.append("          and skd_voy_no = substr(@[vvd2], 5, 4) " ).append("\n"); 
		query.append("          and skd_dir_cd = substr(@[vvd2], 9, 1)) lane2      		" ).append("\n"); 
		query.append("    , @[pod3]        	pod3       		" ).append("\n"); 
		query.append("    , @[pod3_n]      	pod3_n      		" ).append("\n"); 
		query.append("    , @[pod3_c]      	pod3_c " ).append("\n"); 
		query.append("    , @[pol3]        	pol3       		" ).append("\n"); 
		query.append("    , @[pol3_n]      	pol3_n     		" ).append("\n"); 
		query.append("    , @[pol3_c]      	pol3_c " ).append("\n"); 
		query.append("    , @[vvd3]        	vvd3       		" ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("         from vsk_vsl_skd skd" ).append("\n"); 
		query.append("        where vsl_cd     = substr(@[vvd3], 1, 4) " ).append("\n"); 
		query.append("          and skd_voy_no = substr(@[vvd3], 5, 4) " ).append("\n"); 
		query.append("          and skd_dir_cd = substr(@[vvd3], 9, 1)) lane3      		" ).append("\n"); 
		query.append("    , @[pod4]       	pod4       		" ).append("\n"); 
		query.append("    , @[pod4_n]      	pod4_n      		" ).append("\n"); 
		query.append("    , @[pod4_c]      	pod4_c" ).append("\n"); 
		query.append("    , @[pol4]        	pol4       		" ).append("\n"); 
		query.append("    , @[pol4_n]      	pol4_n     		" ).append("\n"); 
		query.append("    , @[pol4_c]      	pol4_c " ).append("\n"); 
		query.append("    , @[vvd4]        	vvd4       		" ).append("\n"); 
		query.append("    , (select skd.vsl_slan_cd " ).append("\n"); 
		query.append("         from vsk_vsl_skd skd" ).append("\n"); 
		query.append("        where vsl_cd     = substr(@[vvd4], 1, 4) " ).append("\n"); 
		query.append("          and skd_voy_no = substr(@[vvd4], 5, 4) " ).append("\n"); 
		query.append("          and skd_dir_cd = substr(@[vvd4], 9, 1)) lane4      		" ).append("\n"); 
		query.append("    , @[ld_dt]       	ld_dt      		" ).append("\n"); 
		query.append("    , @[dr_dt]       	dr_dt      	" ).append("\n"); 
		query.append("	, @[mt_pkup_dt]     mt_pkup_dt	   	" ).append("\n"); 
		query.append("    , @[m_pu]           m_pu     			" ).append("\n"); 
		query.append("    , @[f_rt]         	f_rt      " ).append("\n"); 
		query.append("	, decode(@[org_trns_mode], 'X', 'AL', (select ATTR_CTNT2 from bkg_hrd_cdg_ctnt where HRD_CDG_ID = 'PRI_PRD_TRNS_MODE_CD' and ATTR_CTNT1 = @[org_trns_mode]))  org_trns_mode" ).append("\n"); 
		query.append("	, decode(@[dest_trns_mode],'X', 'AL', (select ATTR_CTNT2 from bkg_hrd_cdg_ctnt where HRD_CDG_ID = 'PRI_PRD_TRNS_MODE_CD' and ATTR_CTNT1 = @[dest_trns_mode])) dest_trns_mode			" ).append("\n"); 
		query.append("    , @[cgo_tp]         cgo_tp     			" ).append("\n"); 
		query.append("    , nvl(@[pm_f],'N')  pm_f       			" ).append("\n"); 
		query.append("    , nvl(@[dg_f],'N')  dg_f       			" ).append("\n"); 
		query.append("    , nvl(@[rf_f],'N')  rf_f       			" ).append("\n"); 
		query.append("    , nvl(@[ak_f],'N')  ak_f       			" ).append("\n"); 
		query.append("    , nvl(@[bb_f],'N')  bb_f       			" ).append("\n"); 
		query.append("    , nvl(@[rd_f],'N')  rd_f       			" ).append("\n"); 
		query.append("    , nvl(@[soc_f],'N') soc_f      			           			" ).append("\n"); 
		query.append("    , nvl(@[flex_hgt_flg],'N') flex_hgt_flg" ).append("\n"); 
		query.append("    , @[com]          	com        			" ).append("\n"); 
		query.append("    , @[rep_com]    	rep_com    			" ).append("\n"); 
		query.append("    , @[bkg_ofc]        bkg_ofc    			" ).append("\n"); 
		query.append("    , @[org_sal_ofc]    org_sal_ofc			" ).append("\n"); 
		query.append("    , @[wgt]          	wgt        			" ).append("\n"); 
		query.append("    , @[wgt_un]      	wgt_un     			" ).append("\n"); 
		query.append("    , nvl(@[hg_f],'N')  hg_f       			" ).append("\n"); 
		query.append("    , nvl(@[sub_f],'N') sub_f      			" ).append("\n"); 
		query.append("    , @[rfa]          	rfa" ).append("\n"); 
		query.append("    , @[sc]           	sc  	" ).append("\n"); 
		query.append("	, '' 				rfa_ofc" ).append("\n"); 
		query.append("	, '' 				sc_ofc" ).append("\n"); 
		query.append("    , @[shpr]  		    shpr" ).append("\n"); 
		query.append("    , @[cngn] 		    cngn" ).append("\n"); 
		query.append("    , '' 				imdg" ).append("\n"); 
		query.append("	, '' 				com_bkg_no" ).append("\n"); 
		query.append("	, '' 				hitchment   			" ).append("\n"); 
		query.append("	, '' 				parent_bkg_no      " ).append("\n"); 
		query.append("	, '' 				copy_cnt	" ).append("\n"); 
		query.append("	, '' ocn_seq	 		" ).append("\n"); 
		query.append("  from dual" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}