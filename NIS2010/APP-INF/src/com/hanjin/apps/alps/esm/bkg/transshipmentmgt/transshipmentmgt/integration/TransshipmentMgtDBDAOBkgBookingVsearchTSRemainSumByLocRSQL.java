/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransshipmentMgtDBDAOBkgBookingVsearchTSRemainSumByLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOBkgBookingVsearchTSRemainSumByLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  * 2011.06.20,23 김진승 [CHM-201111528] R9 CNTR의 BKG UPDATE 요청 - R4, R5부분 변경   
	  * </pre>
	  */
	public TransshipmentMgtDBDAOBkgBookingVsearchTSRemainSumByLocRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOBkgBookingVsearchTSRemainSumByLocRSQL").append("\n"); 
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
		query.append("select dummy.yd_cd" ).append("\n"); 
		query.append("    , decode(dummy.days, 0, '1-30', 1, '31-60', 2, '61-90', '91-') s_day" ).append("\n"); 
		query.append("    , ft40" ).append("\n"); 
		query.append("    , ft20" ).append("\n"); 
		query.append("    , ak40" ).append("\n"); 
		query.append("    , ak20" ).append("\n"); 
		query.append("    , dg40" ).append("\n"); 
		query.append("    , dg20" ).append("\n"); 
		query.append("    , rf40" ).append("\n"); 
		query.append("    , rf20     " ).append("\n"); 
		query.append("from    (select mst.CRNT_YD_CD  YD" ).append("\n"); 
		query.append("                , sum(decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 0, 1)) ft40" ).append("\n"); 
		query.append("                , sum(decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 1, 0)) ft20            " ).append("\n"); 
		query.append("                , sum(decode(bk.awk_cgo_flg, 'Y', decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 0, 1), 0)) ak40" ).append("\n"); 
		query.append("                , sum(decode(bk.awk_cgo_flg, 'Y', decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 1, 0), 0)) ak20            " ).append("\n"); 
		query.append("                , sum(decode(bk.dcgo_flg, 'Y', decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 0, 1), 0)) dg40" ).append("\n"); 
		query.append("                , sum(decode(bk.dcgo_flg, 'Y', decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 1, 0), 0)) dg20            " ).append("\n"); 
		query.append("                , sum(case when cntr.cntr_tpsz_cd <> 'R2' and cntr.cntr_tpsz_cd like 'R%' then 1 else 0 end) rf40 " ).append("\n"); 
		query.append("                , sum(decode(cntr.cntr_tpsz_cd, 'R2', 1, 0)) rf20            " ).append("\n"); 
		query.append("                , DECODE(TRUNC(Trunc(sysdate - cntr.CNMV_EVNT_DT) / 30, 0), 0, 0, 1, 1, 2, 2, 3) stay_day" ).append("\n"); 
		query.append("          from bkg_booking bk" ).append("\n"); 
		query.append("                , bkg_vvd frmr_vvd" ).append("\n"); 
		query.append("                , bkg_vvd next_vvd" ).append("\n"); 
		query.append("                , bkg_container cntr" ).append("\n"); 
		query.append("                , mst_container mst" ).append("\n"); 
		query.append("                , vsk_vsl_port_skd etb" ).append("\n"); 
		query.append("				, vsk_vsl_port_skd etd" ).append("\n"); 
		query.append("         where bk.bkg_no       = frmr_vvd.bkg_no " ).append("\n"); 
		query.append("           and bk.bkg_no       = next_vvd.bkg_no " ).append("\n"); 
		query.append("           and frmr_vvd.pod_cd = next_vvd.pol_cd" ).append("\n"); 
		query.append("           and bk.bkg_sts_cd   <> 'X'      " ).append("\n"); 
		query.append("and nvl(bk.split_rsn_cd, 'X') <> 'C'" ).append("\n"); 
		query.append("           and bk.bkg_no       = cntr.bkg_no " ).append("\n"); 
		query.append("           and cntr.bkg_no       = mst.bkg_no " ).append("\n"); 
		query.append("           and cntr.cntr_no      = mst.cntr_no" ).append("\n"); 
		query.append("           and frmr_vvd.vsl_cd       = etb.vsl_cd" ).append("\n"); 
		query.append("           and frmr_vvd.skd_voy_no   = etb.skd_voy_no" ).append("\n"); 
		query.append("           and frmr_vvd.skd_dir_cd   = etb.skd_dir_cd" ).append("\n"); 
		query.append("           and frmr_vvd.pod_cd       = etb.vps_port_cd" ).append("\n"); 
		query.append("           and frmr_vvd.pod_clpt_ind_seq = etb.clpt_ind_seq" ).append("\n"); 
		query.append("		   and next_vvd.vsl_cd       = etd.vsl_cd" ).append("\n"); 
		query.append("           and next_vvd.skd_voy_no   = etd.skd_voy_no" ).append("\n"); 
		query.append("           and next_vvd.skd_dir_cd   = etd.skd_dir_cd" ).append("\n"); 
		query.append("           and next_vvd.pol_cd       = etd.vps_port_cd" ).append("\n"); 
		query.append("           and next_vvd.pol_clpt_ind_seq = etd.clpt_ind_seq" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#if (${loc_cd} !='')" ).append("\n"); 
		query.append("           and mst.loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("           and mst.CRNT_YD_CD like @[loc_cd]||@[loc_yd_cd] ||'%'  " ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_etb_dt} != '')" ).append("\n"); 
		query.append("		   and etb.VPS_ETB_DT > to_date(@[vps_etb_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_etd_dt} != '')" ).append("\n"); 
		query.append("           and etb.VPS_ETB_DT < to_date(@[vps_etd_dt], 'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vps_eta_dt} !='')" ).append("\n"); 
		query.append("		   aND trunc(sysdate - cntr.CNMV_EVNT_DT) >= @[vps_eta_dt]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnmv_sts_cd_list} != '')" ).append("\n"); 
		query.append("   and mst.cnmv_sts_cd  in (" ).append("\n"); 
		query.append("     #foreach($cnmvStsCd IN ${cnmv_sts_cd_list})        " ).append("\n"); 
		query.append("        #if($velocityCount < $cnmv_sts_cd_list.size()) '$cnmvStsCd', #else '$cnmvStsCd' #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_list} != '')" ).append("\n"); 
		query.append("   and cntr.cntr_tpsz_cd in (" ).append("\n"); 
		query.append("     #foreach($cntrTpszCd IN ${cntr_tpsz_cd_list})        " ).append("\n"); 
		query.append("        #if($velocityCount < $cntr_tpsz_cd_list.size()) '$cntrTpszCd', #else '$cntrTpszCd' #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${next_vvd} == 'Y')" ).append("\n"); 
		query.append("    and (next_vvd.VSL_CD is not null or next_vvd.VSL_CD not in ('SMXX', 'SMYY', 'SMZZ'))" ).append("\n"); 
		query.append("#elseif(${next_vvd} == 'N')" ).append("\n"); 
		query.append("    and (next_vvd.VSL_CD is null or next_vvd.VSL_CD in ('SMXX', 'SMYY', 'SMZZ'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	 group by mst.CRNT_YD_CD, DECODE(TRUNC(Trunc(sysdate - cntr.CNMV_EVNT_DT) / 30, 0), 0, 0, 1, 1, 2, 2, 3)" ).append("\n"); 
		query.append("        ) remain" ).append("\n"); 
		query.append("        , (select yd_cd, 0 days from mdm_yard " ).append("\n"); 
		query.append("#if (${loc_cd} !='' && ${loc_yd_cd} !='')   " ).append("\n"); 
		query.append("           where yd_cd like  @[loc_cd]||@[loc_yd_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${loc_cd} !='')" ).append("\n"); 
		query.append("		   where yd_cd like  @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           and delt_flg = 'N' AND YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("        union     " ).append("\n"); 
		query.append("        select yd_cd, 1 days from mdm_yard " ).append("\n"); 
		query.append("#if (${loc_cd} !='' && ${loc_yd_cd} !='')  " ).append("\n"); 
		query.append("        where yd_cd like @[loc_cd]||@[loc_yd_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${loc_cd} !='')" ).append("\n"); 
		query.append("		 where yd_cd like  @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        and delt_flg = 'N' AND YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("        union     " ).append("\n"); 
		query.append("        select yd_cd, 2 days from mdm_yard " ).append("\n"); 
		query.append("#if (${loc_cd} !='' && ${loc_yd_cd} !='')  " ).append("\n"); 
		query.append("        where yd_cd like @[loc_cd]||@[loc_yd_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${loc_cd} !='')" ).append("\n"); 
		query.append("		 where yd_cd like  @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        and delt_flg = 'N' AND YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("        union     " ).append("\n"); 
		query.append("        select yd_cd, 3 days from mdm_yard " ).append("\n"); 
		query.append("#if (${loc_cd} !='' && ${loc_yd_cd} !='')  " ).append("\n"); 
		query.append("        where yd_cd like @[loc_cd]||@[loc_yd_cd]||'%' " ).append("\n"); 
		query.append("#elseif (${loc_cd} !='')" ).append("\n"); 
		query.append("		 where yd_cd like  @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        and delt_flg = 'N' AND YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("        ) dummy   " ).append("\n"); 
		query.append(" where dummy.days  = remain.stay_day(+)" ).append("\n"); 
		query.append("   and dummy.yd_cd = remain.yd(+)   " ).append("\n"); 
		query.append(" order by yd_cd, s_day" ).append("\n"); 

	}
}