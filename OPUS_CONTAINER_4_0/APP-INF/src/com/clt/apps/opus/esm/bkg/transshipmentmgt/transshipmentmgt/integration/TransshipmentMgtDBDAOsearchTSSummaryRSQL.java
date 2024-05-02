/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTSSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2015.07.16 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchTSSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * T/S port에 입항한 1st VVD를 기준으로 연결되는 선명 별로 물량을 조회한다.   
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTSSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("dur_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("op_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTSSummaryRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D')" ).append("\n"); 
		query.append("       vvd2.vsl_cd||vvd2.skd_voy_no||vvd2.skd_dir_cd vvd  " ).append("\n"); 
		query.append("       , vvd2.pol_yd_cd" ).append("\n"); 
		query.append("       , to_char(skd2.vps_eta_dt, 'yyyy-mm-dd') eta," ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("       vvd1.vsl_cd||vvd1.skd_voy_no||vvd1.skd_dir_cd vvd " ).append("\n"); 
		query.append("       , vvd1.pod_yd_cd" ).append("\n"); 
		query.append("       , to_char(skd1.vps_eta_dt, 'yyyy-mm-dd') eta," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" sum(decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', CNTR_VOL_QTY, 0)) ft20" ).append("\n"); 
		query.append(", sum(decode(substr(cntr.cntr_tpsz_cd, 2, 1), '2', 0, CNTR_VOL_QTY)) ft40" ).append("\n"); 
		query.append(", sum(decode(cntr.RD_CGO_FLG,'Y',0,decode(cntr.cntr_tpsz_cd, 'R2', CNTR_VOL_QTY,  0))) rf20" ).append("\n"); 
		query.append(", sum(decode(cntr.RD_CGO_FLG,'Y',0,decode(cntr.cntr_tpsz_cd, 'R4', CNTR_VOL_QTY, 'R5', CNTR_VOL_QTY, 0))) rf40" ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_container cntr" ).append("\n"); 
		query.append("        , bkg_vvd vvd1, vsk_vsl_port_skd skd1" ).append("\n"); 
		query.append("        , bkg_vvd vvd2, vsk_vsl_port_skd skd2" ).append("\n"); 
		query.append(" where bk.bkg_no         = VVD1.bkg_no " ).append("\n"); 
		query.append("   and bk.bkg_no         = VVD2.bkg_no " ).append("\n"); 
		query.append("   and vvd1.pod_cd       = vvd2.pol_cd" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD     <> 'X'" ).append("\n"); 
		query.append("   and bk.bkg_no         = cntr.bkg_no " ).append("\n"); 
		query.append("   and vvd1.vsl_cd        = skd1.vsl_cd" ).append("\n"); 
		query.append("   and vvd1.skd_voy_no    = skd1.skd_voy_no" ).append("\n"); 
		query.append("   and vvd1.skd_dir_cd    = skd1.skd_dir_cd" ).append("\n"); 
		query.append("   and vvd1.pod_cd        = skd1.vps_port_cd " ).append("\n"); 
		query.append("   and vvd1.pod_clpt_ind_seq  = skd1.clpt_ind_seq" ).append("\n"); 
		query.append("   and vvd2.vsl_cd        = skd2.vsl_cd" ).append("\n"); 
		query.append("   and vvd2.skd_voy_no    = skd2.skd_voy_no" ).append("\n"); 
		query.append("   and vvd2.skd_dir_cd    = skd2.skd_dir_cd" ).append("\n"); 
		query.append("   and vvd2.pol_cd        = skd2.vps_port_cd" ).append("\n"); 
		query.append("   and vvd2.pol_clpt_ind_seq  = skd2.clpt_ind_seq  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd}!='')" ).append("\n"); 
		query.append("   and vvd1.pod_cd  = @[loc_cd]             " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd}!='' && ${loc_yd_cd} !='')" ).append("\n"); 
		query.append("   and vvd1.pod_yd_cd =@[loc_cd]||@[loc_yd_cd]           " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("	#if (${disc_load_cd}=='D')" ).append("\n"); 
		query.append("		and vvd1.vsl_Cd       = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   		and vvd1.skd_voy_no   = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   		and vvd1.skd_dir_cd   = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("		and vvd2.vsl_Cd       = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   		and vvd2.skd_voy_no   = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   		and vvd2.skd_dir_cd   = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${search_kind_cd} =='D')" ).append("\n"); 
		query.append("     #if (${disc_load_cd}=='D'&& ${dur_from}!=''&& ${dur_to}!='')" ).append("\n"); 
		query.append("		and skd1.vps_eta_dt > to_date(@[dur_from], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("		and skd1.vps_eta_dt < to_date(@[dur_to],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #elseif (${disc_load_cd}=='L' && ${dur_from}!=''&& ${dur_to}!='')" ).append("\n"); 
		query.append("	 	and skd2.vps_etd_dt > to_date(@[dur_from], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("	 	and skd2.vps_etd_dt < to_date(@[dur_to],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${search_kind_cd} =='E' && ${vvd}=='' && 0==1)" ).append("\n"); 
		query.append("--적용 중지" ).append("\n"); 
		query.append("	 #if (${disc_load_cd}=='D'&& ${vps_etd_dt}!='')" ).append("\n"); 
		query.append("        and skd1.vps_eta_dt > to_date(@[vps_etd_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        and skd1.vps_eta_dt < to_date(@[vps_etd_dt],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #elseif (${disc_load_cd}=='L' && ${vps_etd_dt}!='')" ).append("\n"); 
		query.append("        and skd2.vps_etd_dt > to_date(@[vps_etd_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        and skd2.vps_etd_dt < to_date(@[vps_etd_dt],   'yyyy-mm-dd')+1" ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("     and bk.pol_cd = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} !='')" ).append("\n"); 
		query.append("     and bk.pod_cd = @[pod_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D' && ${op_cd} !='' )" ).append("\n"); 
		query.append("             and vvd2.op_cd = @[op_cd]" ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L' && ${op_cd} !='')" ).append("\n"); 
		query.append("             and vvd1.op_cd = @[op_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${special} != 'SD')" ).append("\n"); 
		query.append("			 #if (${special} == 'All')" ).append("\n"); 
		query.append("                 and (CNTR.dcgo_flg = 'Y'" ).append("\n"); 
		query.append("                 or CNTR.rc_flg = 'Y'" ).append("\n"); 
		query.append("                 or CNTR.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("                 or CNTR.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("                 or bk.stwg_cd  is not null)" ).append("\n"); 
		query.append("             #elseif (${special} == 'DG')" ).append("\n"); 
		query.append("                 and CNTR.dcgo_flg = 'Y'" ).append("\n"); 
		query.append("             #elseif (${special} == 'RF')" ).append("\n"); 
		query.append("                 and CNTR.rc_flg = 'Y'" ).append("\n"); 
		query.append("             #elseif (${special} == 'AK') " ).append("\n"); 
		query.append("                 and CNTR.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("             #elseif (${special} == 'ST')" ).append("\n"); 
		query.append("                 and bk.stwg_cd  is not null" ).append("\n"); 
		query.append("             #elseif (${special} == 'RD')" ).append("\n"); 
		query.append("                 and CNTR.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D')" ).append("\n"); 
		query.append("group by " ).append("\n"); 
		query.append("       vvd2.vsl_cd||vvd2.skd_voy_no||vvd2.skd_dir_cd " ).append("\n"); 
		query.append("       , vvd2.pol_yd_cd" ).append("\n"); 
		query.append("       , to_char(skd2.vps_eta_dt, 'yyyy-mm-dd') " ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("group by " ).append("\n"); 
		query.append("       vvd1.vsl_cd||vvd1.skd_voy_no||vvd1.skd_dir_cd " ).append("\n"); 
		query.append("       , vvd1.pod_yd_cd" ).append("\n"); 
		query.append("       , to_char(skd1.vps_eta_dt, 'yyyy-mm-dd')    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${disc_load_cd}=='D')" ).append("\n"); 
		query.append("order by  " ).append("\n"); 
		query.append("       vvd2.vsl_cd||vvd2.skd_voy_no||vvd2.skd_dir_cd " ).append("\n"); 
		query.append("       , vvd2.pol_yd_cd" ).append("\n"); 
		query.append("       , to_char(skd2.vps_eta_dt, 'yyyy-mm-dd') " ).append("\n"); 
		query.append("#elseif (${disc_load_cd}=='L')" ).append("\n"); 
		query.append("order by  " ).append("\n"); 
		query.append("       vvd1.vsl_cd||vvd1.skd_voy_no||vvd1.skd_dir_cd " ).append("\n"); 
		query.append("       , vvd1.pod_yd_cd" ).append("\n"); 
		query.append("       , to_char(skd1.vps_eta_dt, 'yyyy-mm-dd') " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}