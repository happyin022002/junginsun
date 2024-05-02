/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchLaneEtdEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchLaneEtdEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOSearchLaneEtdEta
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchLaneEtdEtaRSQL(){
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
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchLaneEtdEtaRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("select 	  pol.slan_cd" ).append("\n"); 
		query.append("		, substr(pol.yd_cd, 6, 2) pol_yd_cd" ).append("\n"); 
		query.append("		, substr(pod.yd_cd, 6, 2) pod_yd_cd" ).append("\n"); 
		query.append(", ' |'||REPLACE(BKG_JOIN_FNC(CURSOR(SELECT clpt_ind_seq" ).append("\n"); 
		query.append("                        FROM vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("                       where pol.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                         and pol.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                         and pol.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                         and pol.vps_port_cd = @[pol_cd])),',','|') pol_clpt_ind_seq_list" ).append("\n"); 
		query.append(", ' |'||REPLACE(BKG_JOIN_FNC(CURSOR(SELECT clpt_ind_seq" ).append("\n"); 
		query.append("                        FROM vsk_vsl_port_skd pod" ).append("\n"); 
		query.append("                       where pod.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                         and pod.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                         and pod.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                         and pod.vps_port_cd = @[pod_cd])),',','|') pod_clpt_ind_seq_list" ).append("\n"); 
		query.append("        , to_char(pol.vps_etd_dt,'yyyy-mm-dd hh24:mi') etd" ).append("\n"); 
		query.append("        , to_char(pod.vps_eta_dt,'yyyy-mm-dd hh24:mi') eta" ).append("\n"); 
		query.append("        , to_char(pol.vps_etd_dt,'yyyy-mm-dd') etd_day" ).append("\n"); 
		query.append("        , to_char(pol.vps_etd_dt,'hh24:mi') etd_time" ).append("\n"); 
		query.append("        , to_char(pod.vps_eta_dt,'yyyy-mm-dd') eta_day" ).append("\n"); 
		query.append("        , to_char(pod.vps_eta_dt,'hh24:mi') eta_time   " ).append("\n"); 
		query.append("        , pol.clpt_ind_seq pol_clpt_ind_seq" ).append("\n"); 
		query.append("        , pod.clpt_ind_seq pod_clpt_ind_seq" ).append("\n"); 
		query.append("  from vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd pod" ).append("\n"); 
		query.append(" where pol.vsl_cd = pod.vsl_cd" ).append("\n"); 
		query.append("   and pol.skd_voy_no   = pod.skd_voy_no" ).append("\n"); 
		query.append("   and pol.skd_dir_cd   = pod.skd_dir_cd" ).append("\n"); 
		query.append("   and pol.vps_port_cd  = @[pol_cd]" ).append("\n"); 
		query.append("   AND POL.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("#if(${pol_yd_cd}!='')" ).append("\n"); 
		query.append("   and pol.yd_cd = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("	#if(${bkg_no}!='')" ).append("\n"); 
		query.append("	and exists (select 'x' from bkg_vvd bv where bv.bkg_no = @[bkg_no] and bv.POL_YD_CD = @[pol_cd]||@[pol_yd_cd] and bv.pol_clpt_ind_seq = pol.clpt_ind_seq)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_clpt_ind_seq}!='' && ${pol_clpt_ind_seq}!=' ')" ).append("\n"); 
		query.append("   and pol.clpt_ind_seq = trim(@[pol_clpt_ind_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and pol.clpt_ind_seq in (select clpt_ind_seq" ).append("\n"); 
		query.append("							 from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("							where skd.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("							  and skd.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("							  and skd.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("						      and skd.vps_port_cd  = @[pol_cd]" ).append("\n"); 
		query.append("						      and nvl(skd.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("							#if(${pol_yd_cd}!='')" ).append("\n"); 
		query.append("							  and skd.yd_cd = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   and pod.vps_port_cd  = @[pod_cd]" ).append("\n"); 
		query.append("#if(${pod_yd_cd}!='')" ).append("\n"); 
		query.append("   and pod.yd_cd = @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("	#if(${bkg_no}!='')" ).append("\n"); 
		query.append("	and exists (select 'x' from bkg_vvd bv where bv.bkg_no = @[bkg_no] and bv.POL_YD_CD = @[pod_cd]||@[pod_yd_cd] and bv.pod_clpt_ind_seq = pod.clpt_ind_seq)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pod_clpt_ind_seq}!='' && ${pod_clpt_ind_seq}!=' ')" ).append("\n"); 
		query.append("   and pod.clpt_ind_seq = trim(@[pod_clpt_ind_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and pod.clpt_ind_seq in (select clpt_ind_seq" ).append("\n"); 
		query.append("							 from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("							where skd.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("							  and skd.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("							  and skd.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("						      and skd.vps_port_cd  = @[pod_cd]" ).append("\n"); 
		query.append("						      and nvl(skd.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("							#if(${pod_yd_cd}!='')" ).append("\n"); 
		query.append("							  and skd.yd_cd = @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and pol.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   and pol.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   and pol.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   and pol.clpt_seq < pod.clpt_seq" ).append("\n"); 
		query.append("   and nvl(pod.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   and nvl(pol.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select 	  pol.slan_cd" ).append("\n"); 
		query.append("		, substr(pol.yd_cd, 6, 2) pol_yd_cd" ).append("\n"); 
		query.append("		, substr(pod.yd_cd, 6, 2) pod_yd_cd" ).append("\n"); 
		query.append(", ' |'||REPLACE(BKG_JOIN_FNC(CURSOR(SELECT clpt_ind_seq" ).append("\n"); 
		query.append("                        FROM vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("                       where pol.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                         and pol.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                         and pol.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                         and pol.vps_port_cd = @[pol_cd])),',','|') pol_clpt_ind_seq_list" ).append("\n"); 
		query.append(", ' |'||REPLACE(BKG_JOIN_FNC(CURSOR(SELECT clpt_ind_seq" ).append("\n"); 
		query.append("                        FROM vsk_vsl_port_skd pod" ).append("\n"); 
		query.append("                       where pod.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                         and pod.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                         and pod.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                         and pod.vps_port_cd = @[pod_cd])),',','|') pod_clpt_ind_seq_list" ).append("\n"); 
		query.append("        , to_char(pol.vps_etd_dt,'yyyy-mm-dd hh24:mi') etd" ).append("\n"); 
		query.append("        , to_char(pod.vps_eta_dt,'yyyy-mm-dd hh24:mi') eta" ).append("\n"); 
		query.append("        , to_char(pol.vps_etd_dt,'yyyy-mm-dd') etd_day" ).append("\n"); 
		query.append("        , to_char(pol.vps_etd_dt,'hh24:mi') etd_time" ).append("\n"); 
		query.append("        , to_char(pod.vps_eta_dt,'yyyy-mm-dd') eta_day" ).append("\n"); 
		query.append("        , to_char(pod.vps_eta_dt,'hh24:mi') eta_time   " ).append("\n"); 
		query.append("        , pol.clpt_ind_seq pol_clpt_ind_seq" ).append("\n"); 
		query.append("        , pod.clpt_ind_seq pod_clpt_ind_seq" ).append("\n"); 
		query.append("  from vsk_vsl_port_skd pol" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd pod" ).append("\n"); 
		query.append(" where pol.vsl_cd = pod.vsl_cd" ).append("\n"); 
		query.append("   and pol.skd_voy_no   = pod.skd_voy_no" ).append("\n"); 
		query.append("   and pol.skd_dir_cd   = pod.skd_dir_cd" ).append("\n"); 
		query.append("   and pol.vps_port_cd  = @[pol_cd]" ).append("\n"); 
		query.append("   AND POL.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("#if(${pol_yd_cd}!='')" ).append("\n"); 
		query.append("   and pol.yd_cd = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("	#if(${bkg_no}!='')" ).append("\n"); 
		query.append("	and exists (select 'x' from bkg_vvd bv where bv.bkg_no = @[bkg_no] and bv.POL_YD_CD = @[pol_cd]||@[pol_yd_cd] and bv.pol_clpt_ind_seq = pol.clpt_ind_seq)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${pol_clpt_ind_seq}!='' && ${pol_clpt_ind_seq}!=' ')" ).append("\n"); 
		query.append("   and pol.clpt_ind_seq = trim(@[pol_clpt_ind_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and pol.clpt_ind_seq in (select clpt_ind_seq" ).append("\n"); 
		query.append("							 from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("							where skd.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("							  and skd.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("							  and skd.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("						      and skd.vps_port_cd  = @[pol_cd]" ).append("\n"); 
		query.append("						      and nvl(skd.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("							#if(${pol_yd_cd}!='')" ).append("\n"); 
		query.append("							  and skd.yd_cd = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   and pod.vps_port_cd  = @[pod_cd]" ).append("\n"); 
		query.append("#if(${pod_clpt_ind_seq}!='' && ${pod_clpt_ind_seq}!=' ')" ).append("\n"); 
		query.append("   --and pod.clpt_ind_seq = trim([pod_clpt_ind_seq])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and pod.clpt_ind_seq in (select clpt_ind_seq" ).append("\n"); 
		query.append("							 from vsk_vsl_port_skd skd" ).append("\n"); 
		query.append("							where skd.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("							  and skd.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("							  and skd.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("						      and skd.vps_port_cd  = @[pod_cd]" ).append("\n"); 
		query.append("						      and nvl(skd.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and pol.vsl_cd       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   and pol.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   and pol.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   and pol.clpt_seq < pod.clpt_seq" ).append("\n"); 
		query.append("   and nvl(pod.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   and nvl(pol.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("order by decode(pod_clpt_ind_seq,@[pod_clpt_ind_seq],1,2)" ).append("\n"); 
		query.append("#if(${bkg_no}!='')" ).append("\n"); 
		query.append(" ,decode(pod_clpt_ind_seq, (select pod_clpt_ind_seq from bkg_vvd v where v.bkg_no = @[bkg_no] and V.vsl_cd = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   and v.skd_voy_no   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   and v.skd_dir_cd   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   and rownum = 1),1,pod_clpt_ind_seq+5) asc" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(" , decode(pod_clpt_ind_seq,@[pod_clpt_ind_seq],1,2) asc" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}