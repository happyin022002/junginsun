/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTSListBy1st2ndVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.02.12 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchTSListBy1st2ndVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * t/s port를 기준으로 booking들의 입항 vessel과 출항 vessel을 조회한다.
	  * 2011.04.28 이일민 [CHM-201110111] Transshipment 와 discharging list data match 요청
	  * 2011.04.28 이일민 [CHM-201110191] * T/S List by 1st VSL & 2nd VSL 화면의 1st VSL 조회 값 변경
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTSListBy1st2ndVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dur_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disc_load_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dur_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTSListBy1st2ndVVDListRSQL").append("\n"); 
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
		query.append("select  rmk" ).append("\n"); 
		query.append("      , ts_rmk" ).append("\n"); 
		query.append("      , disc" ).append("\n"); 
		query.append("      , firstlane" ).append("\n"); 
		query.append("      , firstvvd " ).append("\n"); 
		query.append("      , firstetb" ).append("\n"); 
		query.append("      , nextlane" ).append("\n"); 
		query.append("      , nextvvd" ).append("\n"); 
		query.append("      , nextetd" ).append("\n"); 
		query.append("      , bl_no" ).append("\n"); 
		query.append("      , cntr_no" ).append("\n"); 
		query.append("      , cntr_vol" ).append("\n"); 
		query.append("      , cntr_tpsz_cd" ).append("\n"); 
		query.append("      , cntr_seal_no" ).append("\n"); 
		query.append("      , org_yd_cd" ).append("\n"); 
		query.append("      , pol_cd" ).append("\n"); 
		query.append("      , POL_NM" ).append("\n"); 
		query.append("      , pod_cd" ).append("\n"); 
		query.append("      , pod_nod_cd" ).append("\n"); 
		query.append("      , POD_NM" ).append("\n"); 
		query.append("      , del_cd" ).append("\n"); 
		query.append("      , DEL_NM" ).append("\n"); 
		query.append("      , wgt" ).append("\n"); 
		query.append("      , BS_CD" ).append("\n"); 
		query.append("      , special" ).append("\n"); 
		query.append("      , auth" ).append("\n"); 
		query.append("      , stwg_cd" ).append("\n"); 
		query.append("      , cmdt_nm" ).append("\n"); 
		query.append("      , bkg_no" ).append("\n"); 
		query.append("      , TEU" ).append("\n"); 
		query.append("      , FEU" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D' || ${disc_load_cd}=='L')" ).append("\n"); 
		query.append("      , op_cd " ).append("\n"); 
		query.append("      , terminal" ).append("\n"); 
		query.append("      , vsl_nm " ).append("\n"); 
		query.append("      , vvd1" ).append("\n"); 
		query.append("      , etb" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  from(" ).append("\n"); 
		query.append("select #if (${disc_load_cd}=='L') " ).append("\n"); 
		query.append("        	RANK() OVER (PARTITION BY BK.BL_NO, CNTR.CNTR_NO ORDER BY VVD1.VSL_PRE_PST_CD DESC, VVD1.VSL_SEQ DESC) AS RNK" ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='D')" ).append("\n"); 
		query.append("        	RANK() OVER (PARTITION BY BK.BL_NO, CNTR.CNTR_NO ORDER BY VVD2.VSL_PRE_PST_CD DESC, VVD2.VSL_SEQ DESC) AS RNK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        , decode(nvl(rmk.ts_rmk, 'null'), 'null', '0', '1') rmk" ).append("\n"); 
		query.append("        , rmk.ts_rmk" ).append("\n"); 
		query.append("        , @[disc_load_cd] disc" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D') " ).append("\n"); 
		query.append("        , vvd1.op_cd " ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("        , vvd2.op_cd " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		, vvd1.slan_cd firstlane" ).append("\n"); 
		query.append("		, nvl(vvd1.vsl_cd||vvd1.skd_voy_no||vvd1.skd_dir_cd,' ') firstvvd " ).append("\n"); 
		query.append("		, to_char(skd1.vps_etb_dt,'yyyy-mm-dd') firstetb" ).append("\n"); 
		query.append("		, vvd2.slan_cd nextlane" ).append("\n"); 
		query.append("        , nvl(vvd2.vsl_cd||vvd2.skd_voy_no||vvd2.skd_dir_cd,' ') nextvvd   " ).append("\n"); 
		query.append("		, to_char(skd2.vps_etd_dt,'yyyy-mm-dd') nextetd" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D') " ).append("\n"); 
		query.append("		, vvd2.pol_yd_cd terminal " ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("		, vvd2.pol_yd_cd terminal " ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("		, bk.bl_no" ).append("\n"); 
		query.append("        , cntr.cntr_no" ).append("\n"); 
		query.append("        , cntr.cntr_vol_qty as cntr_vol" ).append("\n"); 
		query.append("        , cntr.cntr_tpsz_cd" ).append("\n"); 
		query.append("        , seal.cntr_seal_no" ).append("\n"); 
		query.append("        , vvd1.pod_yd_cd org_yd_cd" ).append("\n"); 
		query.append("        , vvd2.pod_yd_cd org_yd_cd2" ).append("\n"); 
		query.append("        , bk.pol_cd" ).append("\n"); 
		query.append("        , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.POL_CD) POL_NM" ).append("\n"); 
		query.append("        , vvd2.pod_cd" ).append("\n"); 
		query.append("		, SUBSTR(VVD2.POD_YD_CD,6,2) pod_nod_cd" ).append("\n"); 
		query.append("        , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = VVD2.POD_CD) POD_NM" ).append("\n"); 
		query.append("        , bk.del_cd" ).append("\n"); 
		query.append("        , (SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = BK.DEL_CD) DEL_NM" ).append("\n"); 
		query.append("		, ROUND((CASE WHEN NVL(CNTR.CNTR_WGT, 0) = 0 THEN " ).append("\n"); 
		query.append("				            decode(BL.wgt_ut_cd, 'LBS', BL.ACT_WGT * 0.45359, BL.ACT_WGT)" ).append("\n"); 
		query.append("		        		     / (SELECT COUNT(1) FROM BKG_CONTAINER CNT WHERE CNT.BKG_NO = CNTR.BKG_NO) " ).append("\n"); 
		query.append("				      ELSE decode(cntr.wgt_ut_cd, 'LBS', cntr.cntr_wgt * 0.45359, cntr.cntr_wgt) END" ).append("\n"); 
		query.append("				+ (SELECT DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("				            , DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("					            , DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0) " ).append("\n"); 
		query.append("						            , MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("							            , S.TARE_WGT  ) TARE_WGT" ).append("\n"); 
		query.append("					FROM MST_CONTAINER M, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("					WHERE M.CNTR_NO           =   CNTR.CNTR_NO" ).append("\n"); 
		query.append("					AND   M.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("					AND   M.CNTR_TPSZ_CD      =   MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				)), 0) wgt" ).append("\n"); 
		query.append("			,BK.blck_stwg_cd AS BS_CD" ).append("\n"); 
		query.append("        ,  ltrim(   decode(dg.bkg_no, null,'', 'Cls:'||dg.imdg_clss_cd||' UN:'||dg.imdg_un_no||' ')" ).append("\n"); 
		query.append("			     || decode(rf.bkg_no, null, '', rf.cdo_temp||'''C/')" ).append("\n"); 
		query.append("			     || decode(rf.cntr_vent_tp_cd, 'C', 'CMH:', 'P', 'Venti:', '')||' '" ).append("\n"); 
		query.append("			     || decode(rf.cntr_vent_tp_cd, 'C', decode(rf.CBM_PER_HR_QTY, 0, 'Closed', rf.CBM_PER_HR_QTY||'%') , 'P', decode(rf.VENT_RTO, 0, 'Closed', rf.VENT_RTO ||'%'), '')" ).append("\n"); 
		query.append("			     || decode(awk.bkg_no, null, '', decode(awk.ovr_hgt,    0, '' , 'OH:'||awk.ovr_hgt)" ).append("\n"); 
		query.append("                    		                  || decode(awk.ovr_lf_len, 0, '' , decode(awk.ovr_hgt               ,0,'','/')||'OWL:'||awk.ovr_lf_len)" ).append("\n"); 
		query.append("            		                          || decode(awk.ovr_rt_len, 0, '' , decode(awk.ovr_hgt+awk.ovr_lf_len,0,'','/')||'OWR:'||awk.ovr_rt_len) )||' '" ).append("\n"); 
		query.append("			     || decode(bk.stwg_cd, null, '', bk.stwg_cd)||' '|| decode(cntr.rd_cgo_flg, 'Y', 'RD', '')" ).append("\n"); 
		query.append("             ) AS special" ).append("\n"); 
		query.append("        , decode(TRIM(dg.spcl_cgo_apro_cd||rf.spcl_cgo_apro_cd||awk.spcl_cgo_apro_cd), '', '', 'Y', 'Y', 'YY', 'Y', 'YYY', 'Y', 'N') auth" ).append("\n"); 
		query.append("        , bk.stwg_cd" ).append("\n"); 
		query.append("        , cmdt.cmdt_nm" ).append("\n"); 
		query.append("        , bk.bkg_no" ).append("\n"); 
		query.append("        , skd1.vps_eta_dt" ).append("\n"); 
		query.append("        , skd2.vps_eta_dt vps_eta_dt2" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D') " ).append("\n"); 
		query.append("        , vsl2.vsl_eng_nm||' '||vvd2.skd_voy_no||' '||vvd2.skd_dir_cd vsl_nm " ).append("\n"); 
		query.append("        , vvd2.vsl_cd||vvd2.skd_voy_no||vvd2.skd_dir_cd vvd1" ).append("\n"); 
		query.append("        , to_char(skd2.vps_etb_dt, 'yyyy-mm-dd') etb" ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("        , vsl1.vsl_eng_nm||' '||vvd1.skd_voy_no||' '||vvd1.skd_dir_cd vsl_nm " ).append("\n"); 
		query.append("        , vvd1.vsl_cd||vvd1.skd_voy_no||vvd1.skd_dir_cd vvd1" ).append("\n"); 
		query.append("        , to_char(skd1.vps_etb_dt, 'yyyy-mm-dd') etb" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("        , (SELECT DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',NVL(cntr_vol_qty,0),0)" ).append("\n"); 
		query.append("           FROM  BKG_CONTAINER C" ).append("\n"); 
		query.append("           WHERE C.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND   C.CNTR_NO = CNTR.CNTR_NO) AS TEU" ).append("\n"); 
		query.append("        , (SELECT DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',0,NVL(cntr_vol_qty,0))" ).append("\n"); 
		query.append("           FROM BKG_CONTAINER C" ).append("\n"); 
		query.append("           WHERE C.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("           AND   C.CNTR_NO = CNTR.CNTR_NO) AS FEU" ).append("\n"); 
		query.append("  from bkg_booking bk, bkg_bl_doc bl" ).append("\n"); 
		query.append("        , bkg_container cntr, bkg_cntr_seal_no seal" ).append("\n"); 
		query.append("        , bkg_dg_cgo dg, bkg_rf_cgo rf, bkg_awk_cgo awk" ).append("\n"); 
		query.append("        , bkg_ts_rmk rmk, mdm_commodity cmdt" ).append("\n"); 
		query.append("        , bkg_vvd vvd1, mdm_vsl_cntr vsl1, vsk_vsl_port_skd skd1" ).append("\n"); 
		query.append("        , bkg_vvd vvd2, mdm_vsl_cntr vsl2, vsk_vsl_port_skd skd2" ).append("\n"); 
		query.append(" where bk.bkg_no         = VVD1.bkg_no " ).append("\n"); 
		query.append("   and bk.bkg_no         = VVD2.bkg_no " ).append("\n"); 
		query.append("   and vvd1.pod_cd       = vvd2.pol_cd" ).append("\n"); 
		query.append("   and bk.bkg_no         = bl.bkg_no " ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD     not in ('X','S')" ).append("\n"); 
		query.append("   and bk.bkg_no         = cntr.bkg_no " ).append("\n"); 
		query.append("   and cntr.bkg_no        = seal.bkg_no(+) " ).append("\n"); 
		query.append("   and cntr.cntr_no       = seal.cntr_no(+)" ).append("\n"); 
		query.append("   and 1                  = seal.cntr_seal_Seq(+)" ).append("\n"); 
		query.append("   and cntr.bkg_no        = dg.bkg_no(+) " ).append("\n"); 
		query.append("   and cntr.cntr_no       = dg.cntr_no(+)" ).append("\n"); 
		query.append("   and 1	          = dg.CNTR_CGO_SEQ(+)" ).append("\n"); 
		query.append("   and cntr.bkg_no        = rf.bkg_no(+) " ).append("\n"); 
		query.append("   and cntr.cntr_no       = rf.cntr_no(+)" ).append("\n"); 
		query.append("   and cntr.bkg_no        = awk.bkg_no(+) " ).append("\n"); 
		query.append("   and cntr.cntr_no       = awk.cntr_no(+)" ).append("\n"); 
		query.append("   and vvd1.bkg_no        = rmk.bkg_no(+) " ).append("\n"); 
		query.append("   and 'N'                = rmk.ts_rmk_delt_flg(+)" ).append("\n"); 
		query.append("   and bk.cmdt_cd         = cmdt.cmdt_cd" ).append("\n"); 
		query.append("   and vvd1.vsl_cd        = vsl1.vsl_cd(+)" ).append("\n"); 
		query.append("   and vvd1.vsl_cd        = skd1.vsl_cd(+)" ).append("\n"); 
		query.append("   and vvd1.skd_voy_no    = skd1.skd_voy_no(+)" ).append("\n"); 
		query.append("   and vvd1.skd_dir_cd    = skd1.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and vvd1.pod_cd        = skd1.vps_port_cd(+)" ).append("\n"); 
		query.append("   and vvd1.pod_clpt_ind_seq  = skd1.clpt_ind_seq(+)" ).append("\n"); 
		query.append("   and vvd2.vsl_cd        = vsl2.vsl_cd(+)" ).append("\n"); 
		query.append("   and vvd2.vsl_cd        = skd2.vsl_cd(+)" ).append("\n"); 
		query.append("   and vvd2.skd_voy_no    = skd2.skd_voy_no(+)" ).append("\n"); 
		query.append("   and vvd2.skd_dir_cd    = skd2.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and vvd2.pol_cd        = skd2.vps_port_cd(+)" ).append("\n"); 
		query.append("   and vvd2.pol_clpt_ind_seq  = skd2.clpt_ind_seq(+)" ).append("\n"); 
		query.append("#if (${loc_cd}!='')" ).append("\n"); 
		query.append("   and vvd1.pod_cd  = @[loc_cd]             " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd}!='' && ${loc_yd_cd} !='')" ).append("\n"); 
		query.append("   and vvd1.pod_yd_cd =@[loc_cd]||@[loc_yd_cd]           " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("	#if (${disc_load_cd}=='D') " ).append("\n"); 
		query.append("	   	and vvd1.vsl_Cd       = substr(UPPER(@[vvd]), 1, 4)" ).append("\n"); 
		query.append("	   	and vvd1.skd_voy_no   = substr(UPPER(@[vvd]), 5, 4)" ).append("\n"); 
		query.append("	   	and vvd1.skd_dir_cd   = substr(UPPER(@[vvd]), 9, 1)" ).append("\n"); 
		query.append("	#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("	   	and vvd2.vsl_Cd       = substr(UPPER(@[vvd]), 1, 4)" ).append("\n"); 
		query.append("	   	and vvd2.skd_voy_no   = substr(UPPER(@[vvd]), 5, 4)" ).append("\n"); 
		query.append("	   	and vvd2.skd_dir_cd   = substr(UPPER(@[vvd]), 9, 1)	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_kind_cd} =='D')" ).append("\n"); 
		query.append("     #if (${disc_load_cd}=='D'&& ${dur_from}!=''&& ${dur_to}!='')" ).append("\n"); 
		query.append("	 	and skd1.vps_eta_dt > to_date(@[dur_from], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("	 	and skd1.vps_eta_dt < to_date(@[dur_to],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #elseif (${disc_load_cd}=='L' && ${dur_from}!=''&& ${dur_to}!='')" ).append("\n"); 
		query.append("	 	and skd2.vps_etd_dt > to_date(@[dur_from], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("	 	and skd2.vps_etd_dt < to_date(@[dur_to],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${search_kind_cd} =='E' && ${vvd}=='' && 0==1)" ).append("\n"); 
		query.append("--적용 중지" ).append("\n"); 
		query.append("     #if (${disc_load_cd}=='D'&& ${vps_etd_dt}!='')" ).append("\n"); 
		query.append("	 	and skd1.vps_eta_dt > to_date(@[vps_etd_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("	 	and skd1.vps_eta_dt < to_date(@[vps_etd_dt],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("	 #elseif (${disc_load_cd}=='L' && ${vps_etd_dt}!='')" ).append("\n"); 
		query.append("		and skd2.vps_etd_dt > to_date(@[vps_etd_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("	 	and skd2.vps_etd_dt < to_date(@[vps_etd_dt],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("         and vvd1.pol_cd like @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} !='')" ).append("\n"); 
		query.append("         and vvd2.pod_cd like @[pod_cd] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D' && ${op_cd} !='' )" ).append("\n"); 
		query.append("             and vvd1.op_cd = @[op_cd]" ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L' && ${op_cd} !='')" ).append("\n"); 
		query.append("             and vvd2.op_cd = @[op_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${special} != 'SD')" ).append("\n"); 
		query.append("			 #if (${special} == 'All')" ).append("\n"); 
		query.append("                 and (CNTR.dcgo_flg = 'Y'" ).append("\n"); 
		query.append("                 or CNTR.rc_flg = 'Y'" ).append("\n"); 
		query.append("                 or CNTR.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("				 or CNTR.bb_cgo_flg ='Y'" ).append("\n"); 
		query.append("                 or bk.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("                 or bk.stwg_cd  is not null" ).append("\n"); 
		query.append("                 or cntr.soc_flg ='Y')" ).append("\n"); 
		query.append("             #elseif (${special} == 'DG')" ).append("\n"); 
		query.append("                 and cntr.dcgo_flg = 'Y'" ).append("\n"); 
		query.append("             #elseif (${special} == 'RF')" ).append("\n"); 
		query.append("                 and cntr.rc_flg = 'Y'" ).append("\n"); 
		query.append("             #elseif (${special} == 'AK') " ).append("\n"); 
		query.append("                 and cntr.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("             #elseif (${special} == 'ST')" ).append("\n"); 
		query.append("                 and bk.stwg_cd  is not null" ).append("\n"); 
		query.append("             #elseif (${special} == 'RD')" ).append("\n"); 
		query.append("                 and bk.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("			 #elseif (${special} == 'SO')" ).append("\n"); 
		query.append("				 and cntr.soc_flg ='Y'" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where 1 = rnk" ).append("\n"); 
		query.append("order by vsl_nm" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D')" ).append("\n"); 
		query.append("       , org_yd_cd2" ).append("\n"); 
		query.append("       , to_char(vps_eta_dt2, 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("       , org_yd_cd" ).append("\n"); 
		query.append("       , to_char(vps_eta_dt, 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , bl_no" ).append("\n"); 

	}
}