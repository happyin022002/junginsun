/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTargerBkgForAssignRSQL.java
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

public class TransshipmentMgtDBDAOsearchTargerBkgForAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vvd assign에서 next vvd를 지정할 대상을 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTargerBkgForAssignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("relay_port",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("relay_port_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("former_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTargerBkgForAssignRSQL").append("\n"); 
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
		query.append("select bk.bl_no" ).append("\n"); 
		query.append("        , bk.bkg_no     " ).append("\n"); 
		query.append("        , cntr.cntr_no" ).append("\n"); 
		query.append("        , cntr.cntr_tpsz_cd" ).append("\n"); 
		query.append("        , cntr.cntr_wgt" ).append("\n"); 
		query.append("        , cntr.wgt_ut_cd" ).append("\n"); 
		query.append("        , bk.pol_cd" ).append("\n"); 
		query.append("        , bk.del_cd   " ).append("\n"); 
		query.append("        , next_vvd.pod_cd next_port" ).append("\n"); 
		query.append("        , substr(next_vvd.pod_yd_cd, 6, 2) next_port_yard" ).append("\n"); 
		query.append("		, nvl(next_vvd.pod_yd_cd,next_vvd.pod_cd) next_tmnl" ).append("\n"); 
		query.append("        , former_vvd.vsl_cd||former_vvd.skd_voy_no||former_vvd.skd_dir_cd former_vvd" ).append("\n"); 
		query.append("        , to_char(former_skd.vps_etb_dt, 'yyyy-mm-dd hh24') etb" ).append("\n"); 
		query.append("        , former_vvd.pod_yd_cd tmnl" ).append("\n"); 
		query.append("        , next_vvd.vsl_cd||next_vvd.skd_voy_no||next_vvd.skd_dir_cd next_vvd" ).append("\n"); 
		query.append("        , next_vvd.op_cd" ).append("\n"); 
		query.append("        , to_char(next_skd.vps_etd_dt, 'yyyy-mm-dd hh24') etd" ).append("\n"); 
		query.append("        , cntr.dcgo_flg" ).append("\n"); 
		query.append("        , cntr.rc_flg" ).append("\n"); 
		query.append("        , cntr.awk_cgo_flg" ).append("\n"); 
		query.append("        , (select decode(nvl(st.stwg_cd, 'N'), 'N', 'N', 'Y') from bkg_booking st where st.bkg_no = bk.bkg_no) st" ).append("\n"); 
		query.append("        , decodE(nvl(rmk.bkg_no, 'X'), 'X', 'X', 'Y') rmk  " ).append("\n"); 
		query.append("        , next_vvd.vsl_pre_pst_cd  " ).append("\n"); 
		query.append("        , next_vvd.vsl_seq         " ).append("\n"); 
		query.append("  from bkg_booking bk" ).append("\n"); 
		query.append("        , bkg_vvd former_vvd" ).append("\n"); 
		query.append("        , bkg_vvd next_vvd" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd former_skd" ).append("\n"); 
		query.append("        , vsk_vsl_port_skd next_skd" ).append("\n"); 
		query.append("        , bkg_container cntr" ).append("\n"); 
		query.append("        , BKG_TS_RMK rmk" ).append("\n"); 
		query.append(" where bk.bkg_no = former_vvd.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_no = next_vvd.bkg_no" ).append("\n"); 
		query.append("   and bk.bkg_no = cntr.bkg_no(+)" ).append("\n"); 
		query.append("   and bk.bkg_no = rmk.bkg_no(+)" ).append("\n"); 
		query.append("   and 'N'       = rmk.TS_RMK_DELT_FLG (+)" ).append("\n"); 
		query.append("   and bk.bkg_sts_Cd NOT IN ('X','S')" ).append("\n"); 
		query.append("   and former_vvd.vsl_cd            = former_skd.vsl_cd" ).append("\n"); 
		query.append("   and former_vvd.skd_voy_no        = former_skd.skd_voy_no" ).append("\n"); 
		query.append("   and former_vvd.skd_dir_cd        = former_skd.skd_dir_cd" ).append("\n"); 
		query.append("   and former_vvd.pod_cd            = former_skd.vps_port_cd" ).append("\n"); 
		query.append("   and former_vvd.pod_CLPT_IND_SEQ  = former_skd.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   and former_vvd.pod_cd            = next_vvd.pol_cd" ).append("\n"); 
		query.append("   and next_vvd.vsl_cd              = next_skd.vsl_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.skd_voy_no          = next_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and next_vvd.skd_dir_cd          = next_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.pol_cd              = next_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and next_vvd.pol_CLPT_IND_SEQ    = next_skd.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   and next_vvd.vsl_pre_pst_cd = 'U'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${former_vvd}!='')" ).append("\n"); 
		query.append("   	and former_vvd.vsl_cd        = substr(@[former_vvd], 1, 4)" ).append("\n"); 
		query.append("   	and former_vvd.skd_voy_no    = substr(@[former_vvd], 5, 4)" ).append("\n"); 
		query.append("   	and former_vvd.skd_dir_cd    = substr(@[former_vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if(${relay_port} !='')" ).append("\n"); 
		query.append("   	and former_vvd.pod_cd        = substr(@[relay_port], 1, 5)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${relay_port_yard_cd} !='')" ).append("\n"); 
		query.append("   	and former_vvd.pod_yd_cd     like @[relay_port_yard_cd]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${pol_cd} !='') " ).append("\n"); 
		query.append("   	and bk.pol_cd                = @[pol_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${next_port} !='')" ).append("\n"); 
		query.append("   	and next_vvd.pod_cd          = @[next_port]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${pod_cd}!='')   " ).append("\n"); 
		query.append("   	and bk.pod_cd                = @[pod_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${next_vvd} !='')" ).append("\n"); 
		query.append("   	and next_vvd.vsl_cd          = substr(@[next_vvd], 1, 4)" ).append("\n"); 
		query.append("   	and next_vvd.skd_voy_no      = substr(@[next_vvd], 5, 4)" ).append("\n"); 
		query.append("   	and next_vvd.skd_dir_cd      = substr(@[next_vvd], 9, 1)" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${next_vvd_select} !=''&&${next_vvd_select} != 'All')" ).append("\n"); 
		query.append("		#if(${next_vvd_select} == 'Assigned')" ).append("\n"); 
		query.append("				AND (NEXT_VVD.VSL_CD IS NOT NULL OR NEXT_VVD.VSL_CD <> 'SMXX' OR NEXT_VVD.VSL_CD <> 'SMYY' OR NEXT_VVD.VSL_CD <> 'SMZZ')" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if(${next_vvd_select} == 'Not Assigned')" ).append("\n"); 
		query.append("				AND (NEXT_VVD.VSL_CD IS NULL OR NEXT_VVD.VSL_CD = 'SMXX' OR NEXT_VVD.VSL_CD = 'SMYY' OR NEXT_VVD.VSL_CD = 'SMZZ')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${invalid_vvd} == 'Y')" ).append("\n"); 
		query.append("AND (SELECT COUNT(1) VVD_COUNT" ).append("\n"); 
		query.append("       FROM BKG_VVD vvd" ).append("\n"); 
		query.append("      WHERE VVD.BKG_NO         = NEXT_VVD.BKG_NO" ).append("\n"); 
		query.append("        AND VVD.VSL_PRE_PST_CD = NEXT_VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("        AND VVD.VSL_SEQ        = NEXT_VVD.VSL_SEQ" ).append("\n"); 
		query.append("        AND vvd.VSL_CD IS NOT NULL) <> (SELECT COUNT(1) SKD_COUNT" ).append("\n"); 
		query.append("                                          FROM VSK_VSL_PORT_SKD POL," ).append("\n"); 
		query.append("                                               VSK_VSL_PORT_SKD POD," ).append("\n"); 
		query.append("                                               BKG_VVD VVD" ).append("\n"); 
		query.append("                                         WHERE VVD.BKG_NO         = NEXT_VVD.BKG_NO" ).append("\n"); 
		query.append("                                           AND VVD.VSL_PRE_PST_CD = NEXT_VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                           AND VVD.VSL_SEQ        = NEXT_VVD.VSL_SEQ" ).append("\n"); 
		query.append("                                           AND VVD.VSL_CD       = POL.VSL_CD" ).append("\n"); 
		query.append("                                           AND VVD.SKD_VOY_NO   = POL.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND VVD.SKD_DIR_CD   = POL.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND VVD.POL_CD       = POL.VPS_PORT_CD" ).append("\n"); 
		query.append("                                           AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = POL.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                           AND NVL(POL.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                                           AND VVD.VSL_CD       = POD.VSL_CD" ).append("\n"); 
		query.append("                                           AND VVD.SKD_VOY_NO   = POD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND VVD.SKD_DIR_CD   = POD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND VVD.POD_CD       = POD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                           AND NVL(VVD.POD_CLPT_IND_SEQ, 1) = POD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                           AND NVL(POD.SKD_CNG_STS_CD, 'X') <> 'S') " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${rc_flg} !='')" ).append("\n"); 
		query.append("       and bk.rc_flg      = 'Y'  " ).append("\n"); 
		query.append("   #end	" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${dcgo_flg} !='')" ).append("\n"); 
		query.append("       and bk.dcgo_flg    = 'Y'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${awk_cgo_flg} !='')" ).append("\n"); 
		query.append("       and bk.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (${rd_cgo_flg} !='')" ).append("\n"); 
		query.append("       and bk.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(" order by next_vvd.vsl_cd" ).append("\n"); 
		query.append("		, next_vvd.skd_voy_no" ).append("\n"); 
		query.append("		, next_vvd.skd_dir_cd" ).append("\n"); 
		query.append("		, next_vvd.pod_cd" ).append("\n"); 

	}
}