/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTargetVvdForAssignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.26 
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

public class TransshipmentMgtDBDAOsearchTargetVvdForAssignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건에 맞는 Booking들을 vvd, next port별로 group하여 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTargetVvdForAssignRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTargetVvdForAssignRSQL").append("\n"); 
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
		query.append("select mst.next_port" ).append("\n"); 
		query.append(", sum(decode(substr(mst.cntr_tpsz_cd, 2, 1), '2', mst.cntr_vol_qty, 0)) fit20" ).append("\n"); 
		query.append(", sum(decode(substr(mst.cntr_tpsz_cd, 2, 1), '2', 0, mst.cntr_vol_qty)) fit40" ).append("\n"); 
		query.append(", mst.vsl_cd||mst.skd_voy_no||mst.skd_dir_cd next_vvd" ).append("\n"); 
		query.append(", mst.op_cd" ).append("\n"); 
		query.append(", mst.etb" ).append("\n"); 
		query.append(", mst.etd" ).append("\n"); 
		query.append(", decode(sum(mst.spcl), 0, 'N', 'Y') spcl" ).append("\n"); 
		query.append("from (select next_vvd.pod_cd||substr(next_vvd.pod_yd_cd, 6, 2) next_port" ).append("\n"); 
		query.append(", next_vvd.pod_cd" ).append("\n"); 
		query.append(", cntr.cntr_tpsz_cd" ).append("\n"); 
		query.append(", cntr.cntr_vol_qty" ).append("\n"); 
		query.append(", NVL(" ).append("\n"); 
		query.append("(select 1" ).append("\n"); 
		query.append("from bkg_dg_cgo dg" ).append("\n"); 
		query.append("where dg.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 1" ).append("\n"); 
		query.append("from bkg_rf_cgo rf" ).append("\n"); 
		query.append("where rf.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 1" ).append("\n"); 
		query.append("from bkg_awk_cgo ak" ).append("\n"); 
		query.append("where ak.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select 1" ).append("\n"); 
		query.append("from bkg_bb_cgo bb" ).append("\n"); 
		query.append("where bb.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("and rownum = 1), 0) spcl" ).append("\n"); 
		query.append(", next_vvd.vsl_cd" ).append("\n"); 
		query.append(", next_vvd.skd_voy_no" ).append("\n"); 
		query.append(", next_vvd.skd_dir_cd" ).append("\n"); 
		query.append(", next_vvd.op_cd" ).append("\n"); 
		query.append(", to_char(next_skd.vps_etb_dt, 'yyyy-mm-dd hh24') etb" ).append("\n"); 
		query.append(", to_char(next_skd.vps_etd_dt, 'yyyy-mm-dd hh24') etd" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append(", bkg_vvd former_vvd" ).append("\n"); 
		query.append(", bkg_vvd next_vvd" ).append("\n"); 
		query.append(", vsk_vsl_port_skd next_skd" ).append("\n"); 
		query.append(", bkg_container cntr" ).append("\n"); 
		query.append("where bk.bkg_no = former_vvd.bkg_no" ).append("\n"); 
		query.append("and bk.bkg_no = next_vvd.bkg_no" ).append("\n"); 
		query.append("and bk.bkg_no = cntr.bkg_no(+)" ).append("\n"); 
		query.append("and bk.bkg_sts_Cd <> 'X'" ).append("\n"); 
		query.append("and former_vvd.pod_cd            = next_vvd.pol_cd" ).append("\n"); 
		query.append("and next_vvd.vsl_cd              = next_skd.vsl_cd(+)" ).append("\n"); 
		query.append("and next_vvd.skd_voy_no          = next_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("and next_vvd.skd_dir_cd          = next_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("and next_vvd.pol_cd              = next_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("and next_vvd.pol_CLPT_IND_SEQ    = next_skd.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("and next_vvd.vsl_pre_pst_cd = 'U'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${former_vvd}!='')" ).append("\n"); 
		query.append("and former_vvd.vsl_cd        = substr(@[former_vvd], 1, 4)" ).append("\n"); 
		query.append("and former_vvd.skd_voy_no    = substr(@[former_vvd], 5, 4)" ).append("\n"); 
		query.append("and former_vvd.skd_dir_cd    = substr(@[former_vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${relay_port} !='')" ).append("\n"); 
		query.append("and former_vvd.pod_cd        = substr(@[relay_port], 1, 5)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${relay_port_yard_cd} !='')" ).append("\n"); 
		query.append("and former_vvd.pod_yd_cd     like @[relay_port_yard_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("and bk.pol_cd                like @[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${next_port} !='')" ).append("\n"); 
		query.append("and next_vvd.pod_cd          like @[next_port]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!='')" ).append("\n"); 
		query.append("and bk.pod_cd                like @[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${next_vvd} !='')" ).append("\n"); 
		query.append("and next_vvd.vsl_cd          = substr(@[next_vvd], 1, 4)" ).append("\n"); 
		query.append("and next_vvd.skd_voy_no      = substr(@[next_vvd], 5, 4)" ).append("\n"); 
		query.append("and next_vvd.skd_dir_cd      = substr(@[next_vvd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${next_vvd_select} !=''&&${next_vvd_select} != 'All')" ).append("\n"); 
		query.append("#if(${next_vvd_select} == 'Assigned')" ).append("\n"); 
		query.append("AND (NEXT_VVD.VSL_CD IS NOT NULL OR NEXT_VVD.VSL_CD <> 'HJXX' OR NEXT_VVD.VSL_CD <> 'HJYY' OR NEXT_VVD.VSL_CD <> 'HJZZ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${next_vvd_select} == 'Not Assigned')" ).append("\n"); 
		query.append("AND (NEXT_VVD.VSL_CD IS NULL OR NEXT_VVD.VSL_CD = 'HJXX' OR NEXT_VVD.VSL_CD = 'HJYY' OR NEXT_VVD.VSL_CD = 'HJZZ')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rc_flg} !='')" ).append("\n"); 
		query.append("and bk.rc_flg      = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dcgo_flg} !='')" ).append("\n"); 
		query.append("and bk.dcgo_flg    = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${awk_cgo_flg} !='')" ).append("\n"); 
		query.append("and bk.awk_cgo_flg = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rd_cgo_flg} !='')" ).append("\n"); 
		query.append("and bk.rd_cgo_flg  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") mst" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("group by mst.next_port" ).append("\n"); 
		query.append(", mst.vsl_cd" ).append("\n"); 
		query.append(", mst.skd_voy_no" ).append("\n"); 
		query.append(", mst.skd_dir_cd" ).append("\n"); 
		query.append(", mst.op_cd" ).append("\n"); 
		query.append(", mst.etb" ).append("\n"); 
		query.append(", mst.etd" ).append("\n"); 

	}
}