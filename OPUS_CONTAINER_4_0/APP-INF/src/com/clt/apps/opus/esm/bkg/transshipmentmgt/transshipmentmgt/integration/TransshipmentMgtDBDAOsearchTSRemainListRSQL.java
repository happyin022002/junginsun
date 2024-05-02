/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTSRemainListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchTSRemainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * t/s port에서 next vessel이 재지정 되지 않고 port에 머물러 있는 booking들을 조회한다.   
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTSRemainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTSRemainListRSQL").append("\n"); 
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
		query.append("select pod_yd_cd" ).append("\n"); 
		query.append("        , cntr_no" ).append("\n"); 
		query.append("        , cntr_tpsz_cd" ).append("\n"); 
		query.append("        , decode(bkg_cgo_tp_cd, 'P', 'M', 'F') fm" ).append("\n"); 
		query.append("        , cnmv_sts_cd" ).append("\n"); 
		query.append("        , bl_no        " ).append("\n"); 
		query.append("        , pol_cd" ).append("\n"); 
		query.append("        , pod_cd" ).append("\n"); 
		query.append("        , next_port" ).append("\n"); 
		query.append("        , frmr_vvd" ).append("\n"); 
		query.append("        , frmr_lane" ).append("\n"); 
		query.append("        , to_char(act,'yyyy-MM-dd HH24:mi') act" ).append("\n"); 
		query.append("        , next_vvd" ).append("\n"); 
		query.append("        , next_lane" ).append("\n"); 
		query.append("        , to_char(etd,'yyyy-MM-dd HH24:mi') etd" ).append("\n"); 
		query.append("        , special" ).append("\n"); 
		query.append("        , stay_day" ).append("\n"); 
		query.append("        , sh_nm" ).append("\n"); 
		query.append("        , cn_nm" ).append("\n"); 
		query.append("  from " ).append("\n"); 
		query.append("        (select  mst.CRNT_YD_CD pod_yd_cd" ).append("\n"); 
		query.append("                , cntr.cntr_no" ).append("\n"); 
		query.append("                , cntr.cntr_tpsz_cd" ).append("\n"); 
		query.append("                , bk.bkg_cgo_tp_cd" ).append("\n"); 
		query.append("                , mst.cnmv_sts_cd" ).append("\n"); 
		query.append("                , bk.bl_no  " ).append("\n"); 
		query.append("                , bk.pol_cd" ).append("\n"); 
		query.append("                , bk.pod_cd" ).append("\n"); 
		query.append("                , next_vvd.pod_cd next_port" ).append("\n"); 
		query.append("                , frmr_vvd.vsl_cd||frmr_vvd.skd_voy_no||frmr_vvd.skd_dir_cd frmr_vvd" ).append("\n"); 
		query.append("                , frmr_vvd.slan_cd frmr_lane" ).append("\n"); 
		query.append("                , frmr_vvd.pod_cd frmr_pod" ).append("\n"); 
		query.append("                , frmr_vvd.pod_yd_cd frmr_yd" ).append("\n"); 
		query.append("                , etb.vps_etb_dt etb" ).append("\n"); 
		query.append("                , cntr.CNMV_EVNT_DT act" ).append("\n"); 
		query.append("                , next_vvd.vsl_cd||next_vvd.skd_voy_no||next_vvd.skd_dir_cd next_vvd" ).append("\n"); 
		query.append("                , next_vvd.vsl_cd next_vsl" ).append("\n"); 
		query.append("                , next_vvd.slan_cd next_lane                " ).append("\n"); 
		query.append("                , etd.vps_etd_dt etd" ).append("\n"); 
		query.append("                , decode(bk.dcgo_flg, 'Y', 'DG', decode(bk.rc_flg, 'Y', 'RF', decode(bk.awk_cgo_flg, 'Y', 'AK', decode(bk.bb_cgo_flg, 'Y', 'BB', '  ')))) special" ).append("\n"); 
		query.append("                , trunc(sysdate - cntr.CNMV_EVNT_DT) stay_day" ).append("\n"); 
		query.append("                , replace(sh.cust_nm,chr(10),'') sh_nm" ).append("\n"); 
		query.append("                , replace(cn.cust_nm,chr(10),'') cn_nm" ).append("\n"); 
		query.append("          from bkg_booking bk" ).append("\n"); 
		query.append("                , bkg_vvd frmr_vvd" ).append("\n"); 
		query.append("                , bkg_vvd next_vvd" ).append("\n"); 
		query.append("                , bkg_container cntr" ).append("\n"); 
		query.append("                , vsk_vsl_port_skd etb" ).append("\n"); 
		query.append("                , vsk_vsl_port_skd etd" ).append("\n"); 
		query.append("                , bkg_customer sh" ).append("\n"); 
		query.append("                , bkg_customer cn" ).append("\n"); 
		query.append("                , mst_container mst" ).append("\n"); 
		query.append("         where bk.bkg_no       = sh.bkg_no(+)" ).append("\n"); 
		query.append("           and 'S'			   = sh.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("           and bk.bkg_no       = cn.bkg_no(+)" ).append("\n"); 
		query.append("           and 'C'			   = cn.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("           and bk.bkg_sts_cd   <> 'X'" ).append("\n"); 
		query.append("           and nvl(bk.split_rsn_cd, 'X') <> 'M'" ).append("\n"); 
		query.append("           and bk.bkg_no       = cntr.bkg_no " ).append("\n"); 
		query.append("           and cntr.bkg_no     = mst.bkg_no " ).append("\n"); 
		query.append("           and cntr.cntr_no    = mst.cntr_no" ).append("\n"); 
		query.append("#if (${loc_cd} !='') " ).append("\n"); 
		query.append("		   and mst.CRNT_YD_CD  LIKE @[loc_cd]||@[loc_yd_cd]||'%'	           " ).append("\n"); 
		query.append("           and mst.loc_CD      = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           and bk.bkg_no       = frmr_vvd.bkg_no " ).append("\n"); 
		query.append("           and bk.bkg_no       = next_vvd.bkg_no " ).append("\n"); 
		query.append("           and frmr_vvd.pod_cd = next_vvd.pol_cd" ).append("\n"); 
		query.append("           and frmr_vvd.vsl_cd       = etb.vsl_cd" ).append("\n"); 
		query.append("           and frmr_vvd.skd_voy_no   = etb.skd_voy_no" ).append("\n"); 
		query.append("           and frmr_vvd.skd_dir_cd   = etb.skd_dir_cd" ).append("\n"); 
		query.append("           and frmr_vvd.pod_cd       = etb.vps_port_cd" ).append("\n"); 
		query.append("           and frmr_vvd.pod_clpt_ind_seq = etb.clpt_ind_seq" ).append("\n"); 
		query.append("           and next_vvd.vsl_cd       = etd.vsl_cd(+)" ).append("\n"); 
		query.append("           and next_vvd.skd_voy_no   = etd.skd_voy_no(+)" ).append("\n"); 
		query.append("           and next_vvd.skd_dir_cd   = etd.skd_dir_cd(+)" ).append("\n"); 
		query.append("           and next_vvd.pol_cd       = etd.vps_port_cd(+)" ).append("\n"); 
		query.append("           and next_vvd.pol_clpt_ind_seq = etd.clpt_ind_seq(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("where 1 = 1           " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${vps_etb_dt} != '')" ).append("\n"); 
		query.append("	 and etb > to_date(@[vps_etb_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_etd_dt} != '')" ).append("\n"); 
		query.append("	 and etb < to_date(@[vps_etd_dt], 'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_eta_dt} !='')" ).append("\n"); 
		query.append("	and stay_day > @[vps_eta_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd_list} != '')" ).append("\n"); 
		query.append("   and cnmv_sts_cd  in (" ).append("\n"); 
		query.append("     #foreach($cnmvStsCd IN ${cnmv_sts_cd_list})        " ).append("\n"); 
		query.append("        #if($velocityCount < $cnmv_sts_cd_list.size()) '$cnmvStsCd', #else '$cnmvStsCd' #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_list} != '')" ).append("\n"); 
		query.append("   and cntr_tpsz_cd  in (" ).append("\n"); 
		query.append("     #foreach($cntrTpszCd IN ${cntr_tpsz_cd_list})        " ).append("\n"); 
		query.append("        #if($velocityCount < $cntr_tpsz_cd_list.size()) '$cntrTpszCd', #else '$cntrTpszCd' #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${next_vvd} == 'Y')" ).append("\n"); 
		query.append("    and (next_vsl is not null or next_vsl not in ('COXX', 'COYY', 'COZZ'))" ).append("\n"); 
		query.append("#elseif(${next_vvd} == 'N')" ).append("\n"); 
		query.append("    and (next_vsl is null or next_vsl in ('COXX', 'COYY', 'COZZ'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by pod_yd_cd,bl_no" ).append("\n"); 

	}
}