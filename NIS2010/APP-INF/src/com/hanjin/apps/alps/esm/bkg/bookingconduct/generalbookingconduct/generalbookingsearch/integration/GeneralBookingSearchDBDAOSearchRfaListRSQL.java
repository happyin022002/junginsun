/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchRfaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchRfaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주의 계약서상의 RFA를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchRfaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("include_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchRfaListRSQL").append("\n"); 
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
		query.append("with cust as (select 'S' cust_tp_cd, cust_cnt_cd, cust_seq, cust_lgl_eng_nm" ).append("\n"); 
		query.append("         from mdm_customer" ).append("\n"); 
		query.append("        where cust_cnt_cd     = nvl(@[s_cust_cnt_cd], 'xx')" ).append("\n"); 
		query.append("#if (${s_cust_seq} == '' && ${s_cust_nm} == '') " ).append("\n"); 
		query.append("		  and cust_seq = 0 --seq, name이 둘다 없는 경우 조회에서 제외" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${s_cust_seq} != '')" ).append("\n"); 
		query.append("		  and cust_seq 		  = @[s_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_nm} != '') " ).append("\n"); 
		query.append("          and cust_lgl_eng_nm like decode(@[include_flag], 'Y', '%', '')||@[s_cust_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          and delt_flg        = 'N'" ).append("\n"); 
		query.append("       union" ).append("\n"); 
		query.append("       select 'C' cust_tp_cd, cust_cnt_cd, cust_seq, cust_lgl_eng_nm" ).append("\n"); 
		query.append("         from mdm_customer" ).append("\n"); 
		query.append("        where cust_cnt_cd     = nvl(@[c_cust_cnt_cd], 'xx')" ).append("\n"); 
		query.append("#if (${c_cust_seq} == '' && ${c_cust_nm} == '') " ).append("\n"); 
		query.append("		  and cust_seq = 0 --seq, name이 둘다 없는 경우 조회에서 제외" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${c_cust_seq} != '')" ).append("\n"); 
		query.append("		  and cust_seq 		  = @[c_cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${c_cust_nm} != '') " ).append("\n"); 
		query.append("          and cust_lgl_eng_nm like decode(@[include_flag], 'Y', '%', '')||@[c_cust_nm]||'%'" ).append("\n"); 
		query.append("#end        " ).append("\n"); 
		query.append("          and delt_flg        = 'N'" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	   union " ).append("\n"); 
		query.append("       select cust.bkg_cust_tp_cd, cust.cust_cnt_cd, cust.cust_seq, cust.cust_nm" ).append("\n"); 
		query.append("         from bkg_customer cust, bkg_booking bk" ).append("\n"); 
		query.append("        where bk.bkg_no          = @[bkg_no]   " ).append("\n"); 
		query.append("          and bk.bkg_no          = cust.bkg_no" ).append("\n"); 
		query.append("          and bk.CUST_TO_ORD_FLG = 'Y'" ).append("\n"); 
		query.append("          and cust.bkg_cust_tp_Cd    = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("select distinct cust.cust_tp_cd" ).append("\n"); 
		query.append("        , cust.cust_cnt_cd" ).append("\n"); 
		query.append("        , cust.cust_seq" ).append("\n"); 
		query.append("        , cust.cust_lgl_eng_nm" ).append("\n"); 
		query.append("        , (select rfa_no from pri_rp_hdr where prop_no = ctrt_prop_no) rfa_no" ).append("\n"); 
		query.append("        , respb_sls_ofc_cd sales_ofc" ).append("\n"); 
		query.append("        , respb_srep_cd    sales_rep        " ).append("\n"); 
		query.append("        , rp_scp.svc_scp_cd" ).append("\n"); 
		query.append("        , (select svc_scp_nm from mdm_svc_scp where svc_scp_cd = rp_scp.svc_scp_cd) svc_scp_nm" ).append("\n"); 
		query.append("  from " ).append("\n"); 
		query.append("    (select appl_dt" ).append("\n"); 
		query.append("         from " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("            select 1 rank, RT_APLY_DT appl_dt " ).append("\n"); 
		query.append("              from bkg_rt_his r" ).append("\n"); 
		query.append("             where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("			   and corr_no = 'TMP0000001'" ).append("\n"); 
		query.append("               and rt_aply_dt is not null" ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("			select 2 rank, RT_APLY_DT appl_dt --rate applicable" ).append("\n"); 
		query.append("              from bkg_rate r" ).append("\n"); 
		query.append("             where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("               and rt_aply_dt is not null" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            select 3 rank, skd.vps_etd_dt appl_dt --onboard date" ).append("\n"); 
		query.append("              from bkg_vvd_his vvd, vsk_vsl_port_skd skd, bkg_bkg_his bk" ).append("\n"); 
		query.append("             where bk.bkg_no          = @[bkg_no] " ).append("\n"); 
		query.append("			   and bk.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("			   and vvd.corr_no 		  = 'TMP0000001'" ).append("\n"); 
		query.append("               and bk.bkg_no          = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("               and vvd.pol_cd         = bk.pol_cd" ).append("\n"); 
		query.append("               and vvd.vsl_cd         = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no     = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd     = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pol_cd         = skd.vps_port_cd" ).append("\n"); 
		query.append("               and vvd.pol_CLPT_IND_SEQ = skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            union all" ).append("\n"); 
		query.append("            select 4 rank, skd.vps_etd_dt appl_dt --onboard date" ).append("\n"); 
		query.append("              from bkg_vvd vvd, vsk_vsl_port_skd skd, bkg_booking bk" ).append("\n"); 
		query.append("             where bk.bkg_no          = @[bkg_no] " ).append("\n"); 
		query.append("               and bk.bkg_no          = vvd.bkg_no" ).append("\n"); 
		query.append("               and vvd.vsl_pre_pst_cd in ('S', 'T')" ).append("\n"); 
		query.append("               and vvd.pol_cd         = bk.pol_cd" ).append("\n"); 
		query.append("               and vvd.vsl_cd         = skd.vsl_cd" ).append("\n"); 
		query.append("               and vvd.skd_voy_no     = skd.skd_voy_no" ).append("\n"); 
		query.append("               and vvd.skd_dir_cd     = skd.skd_dir_cd" ).append("\n"); 
		query.append("               and vvd.pol_cd         = skd.vps_port_cd" ).append("\n"); 
		query.append("               and vvd.pol_CLPT_IND_SEQ = skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            union all " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            select 5 rank, sysdate appl_dt" ).append("\n"); 
		query.append("              from dual)   " ).append("\n"); 
		query.append("        where rownum = 1) appl" ).append("\n"); 
		query.append("    , cust" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '') " ).append("\n"); 
		query.append("    , (SELECT DISTINCT LOC_SCOPE.SVC_SCP_CD" ).append("\n"); 
		query.append("		 FROM (SELECT ORG.SVC_SCP_CD SVC_SCP_CD, COUNT(1) CNT" ).append("\n"); 
		query.append("        		 FROM MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("		            , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("			    WHERE ORG.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por_cd])" ).append("\n"); 
		query.append("			      AND ORG.ORG_DEST_CD 		= 'O'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND ORG.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("			      AND DEST.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append("			      AND DEST.ORG_DEST_CD 		= 'D'" ).append("\n"); 
		query.append("			      AND DEST.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND DEST.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("        		  AND ORG.SVC_SCP_CD = DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("		        GROUP BY ORG.SVC_SCP_CD) LOC_SCOPE," ).append("\n"); 
		query.append("			  (SELECT ORG.SVC_SCP_CD SVC_SCP_CD, 1 CNT" ).append("\n"); 
		query.append("			     FROM MDM_SVC_SCP_LANE LANE " ).append("\n"); 
		query.append("			        , MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("			        , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("			        , VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("			    WHERE ORG.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[por_cd])" ).append("\n"); 
		query.append("			      AND ORG.ORG_DEST_CD 		= 'O'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND ORG.DELT_FLG			= 'N'" ).append("\n"); 
		query.append("			      AND DEST.RGN_CD 			= (SELECT RGN_CD FROM MDM_LOCATION WHERE LOC_CD = @[del_cd])" ).append("\n"); 
		query.append("			      AND DEST.ORG_DEST_CD 		= 'D'" ).append("\n"); 
		query.append("			      AND DEST.SVC_SCP_IND_FLG 	= 'Y'" ).append("\n"); 
		query.append("			      AND DEST.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("			      AND ORG.SVC_SCP_CD   		= DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("			      AND LANE.VSL_SLAN_CD 		= SKD.VSL_SLAN_CD" ).append("\n"); 
		query.append("			      AND SKD.VSL_CD    		= SUBSTR(@[bkg_vvd], 1, 4)" ).append("\n"); 
		query.append("			      AND SKD.SKD_VOY_NO 		= SUBSTR(@[bkg_vvd], 5, 4)" ).append("\n"); 
		query.append("			      AND SKD.SKD_DIR_CD 		= SUBSTR(@[bkg_vvd], 9, 1)" ).append("\n"); 
		query.append("			    GROUP BY ORG.SVC_SCP_CD" ).append("\n"); 
		query.append("			    UNION " ).append("\n"); 
		query.append("			    SELECT '   ' SVC_SCP_CD , 1 CNT FROM DUAL) VSL_SCOPE" ).append("\n"); 
		query.append("		WHERE ((LOC_SCOPE.CNT = 1 AND LOC_SCOPE.CNT = VSL_SCOPE.CNT)" ).append("\n"); 
		query.append("		       OR " ).append("\n"); 
		query.append("		       (LOC_SCOPE.CNT > 1 AND LOC_SCOPE.SVC_SCP_CD = VSL_SCOPE.SVC_SCP_CD)" ).append("\n"); 
		query.append("		      )" ).append("\n"); 
		query.append("         ) scope" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("    , (select ctrt.ctrt_cust_cnt_cd ctrt_cust_cnt" ).append("\n"); 
		query.append("            , ctrt.ctrt_cust_seq    ctrt_cust_seq" ).append("\n"); 
		query.append("            , ctrt.prop_no          ctrt_prop_no" ).append("\n"); 
		query.append("            , ctrt.amdt_seq         ctrt_amdt_seq" ).append("\n"); 
		query.append("         from pri_rp_mn ctrt" ).append("\n"); 
		query.append("		where (ctrt_cust_cnt_cd, ctrt_cust_seq) in (select cust_cnt_cd, cust_seq from cust)" ).append("\n"); 
		query.append("       union" ).append("\n"); 
		query.append("       select afil.cust_cnt_cd  ctrt_cust_cnt" ).append("\n"); 
		query.append("            , afil.cust_seq     ctrt_cust_seq" ).append("\n"); 
		query.append("            , afil.prop_no      ctrt_prop_no" ).append("\n"); 
		query.append("            , afil.amdt_seq     ctrt_amdt_seq" ).append("\n"); 
		query.append("         from pri_rp_afil afil" ).append("\n"); 
		query.append("		where (cust_cnt_cd, cust_seq) in (select cust_cnt_cd, cust_seq from cust)" ).append("\n"); 
		query.append("	   ) ctrt" ).append("\n"); 
		query.append("    , pri_rp_mn main, pri_rp_scp_mn rp_scp" ).append("\n"); 
		query.append("  where cust.cust_cnt_cd    = ctrt.ctrt_cust_cnt " ).append("\n"); 
		query.append("    and cust.cust_seq       = ctrt.ctrt_cust_Seq" ).append("\n"); 
		query.append("    and main.prop_no        = ctrt.ctrt_prop_no" ).append("\n"); 
		query.append("    and main.amdt_seq       = ctrt.ctrt_amdt_Seq" ).append("\n"); 
		query.append("    and main.prop_no        = rp_scp.prop_no(+)" ).append("\n"); 
		query.append("    and main.amdt_seq       = rp_scp.amdt_seq(+)" ).append("\n"); 
		query.append("#if (${por_cd} != '' && ${del_cd} != '') " ).append("\n"); 
		query.append("    and rp_scp.svc_scp_cd   =  scope.SVC_SCP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '' && ${svc_scp_cd} != '*') " ).append("\n"); 
		query.append("	and rp_scp.svc_scp_cd   = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    and MAIN.eff_dt - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("    AND MAIN.exp_dt + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("    AND main.prop_sts_cd    = 'A'" ).append("\n"); 

	}
}