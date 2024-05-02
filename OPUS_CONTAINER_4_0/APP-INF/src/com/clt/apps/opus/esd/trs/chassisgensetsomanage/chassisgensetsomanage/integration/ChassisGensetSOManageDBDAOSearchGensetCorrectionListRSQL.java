/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOSearchGensetCorrectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.03.22 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOSearchGensetCorrectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * f_cmd : SEARCH09
	  * Genset List Retrieve
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOSearchGensetCorrectionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kind_chassis",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_to_node",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trs_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_fm_node",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOSearchGensetCorrectionListRSQL").append("\n"); 
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
		query.append("SELECT a.trsp_so_cmb_seq" ).append("\n"); 
		query.append(",a.trsp_so_cmb_seq trsp_so_cmb_seq2" ).append("\n"); 
		query.append(",DECODE(a.trsp_so_cmb_tp_cd,'BS','Stack','BF','Flatbed','') trsp_so_cmb_tp_nm" ).append("\n"); 
		query.append(",a.eq_no" ).append("\n"); 
		query.append(",a.eq_tpsz_cd" ).append("\n"); 
		query.append(",a.fm_nod_cd" ).append("\n"); 
		query.append(",SUBSTR (a.fm_nod_cd,1,5) fm_loc_value" ).append("\n"); 
		query.append(",SUBSTR (a.fm_nod_cd,6,2) fm_yard_value" ).append("\n"); 
		query.append(",a.to_nod_cd" ).append("\n"); 
		query.append(",SUBSTR (a.to_nod_cd,1,5) to_loc_value" ).append("\n"); 
		query.append(",SUBSTR (a.to_nod_cd,6,2) to_yard_value" ).append("\n"); 
		query.append(",a.trsp_crr_mod_cd" ).append("\n"); 
		query.append(",b.vndr_seq" ).append("\n"); 
		query.append(",c.vndr_abbr_nm" ).append("\n"); 
		query.append(",b.agmt_lstm_cd lstm_cd" ).append("\n"); 
		query.append(",a.inter_rmk" ).append("\n"); 
		query.append(",a.cntr_no" ).append("\n"); 
		query.append(",a.cntr_tpsz_cd" ).append("\n"); 
		query.append(",a.ref_bkg_no" ).append("\n"); 
		query.append(",'' ref_bkg_no_split" ).append("\n"); 
		query.append(",a.ref_bl_no" ).append("\n"); 
		query.append(",TO_CHAR (a.org_gate_out_dt, 'YYYY-MM-DD') org_gate_out_date" ).append("\n"); 
		query.append(",TO_CHAR (a.org_gate_out_dt, 'HH24:MI:SS') org_gate_out_time" ).append("\n"); 
		query.append(",TO_CHAR (a.dest_gate_in_dt, 'YYYY-MM-DD') dest_gate_in_date" ).append("\n"); 
		query.append(",TO_CHAR (a.dest_gate_in_dt, 'HH24:MI:SS') dest_gate_in_time" ).append("\n"); 
		query.append(",a.spcl_instr_rmk" ).append("\n"); 
		query.append(",a.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append(",a.trsp_so_seq" ).append("\n"); 
		query.append(",a.trsp_so_tp_cd" ).append("\n"); 
		query.append(",a.trsp_so_sts_cd" ).append("\n"); 
		query.append(",a.eq_knd_cd" ).append("\n"); 
		query.append(",a.chss_mgst_trsp_tp_cd" ).append("\n"); 
		query.append(",a.cre_ofc_cd" ).append("\n"); 
		query.append(",TO_CHAR (a.locl_cre_dt, 'YYYYMMDD') cre_dt" ).append("\n"); 
		query.append(",a.cre_usr_id" ).append("\n"); 
		query.append(",TO_CHAR (a.locl_upd_dt, 'YYYYMMDD') upd_dt" ).append("\n"); 
		query.append(",a.upd_usr_id" ).append("\n"); 
		query.append(", (CASE" ).append("\n"); 
		query.append("WHEN a.eq_no IS NULL" ).append("\n"); 
		query.append("THEN 'T'" ).append("\n"); 
		query.append("END) isimport" ).append("\n"); 
		query.append(",DECODE (a.trsp_wo_seq, NULL, 'N','Y' ) wo_issue" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord a" ).append("\n"); 
		query.append(",cgm_equipment b" ).append("\n"); 
		query.append(",mdm_vendor c" ).append("\n"); 
		query.append("WHERE a.eq_no = b.eq_no(+)" ).append("\n"); 
		query.append("AND b.vndr_seq = c.vndr_seq(+)" ).append("\n"); 
		query.append("AND a.trsp_so_sts_cd IN ('C', 'R')" ).append("\n"); 
		query.append("AND b.eq_knd_cd ='G'" ).append("\n"); 
		query.append("AND a.eq_knd_cd = @[kind_chassis]" ).append("\n"); 
		query.append("#if (${fmdate} != '' && ${todate} != '')" ).append("\n"); 
		query.append("AND a.locl_cre_dt BETWEEN TO_DATE(@[fmdate]||'000001','YYYYMMDDHH24MISS') AND TO_DATE(@[todate]||'235959','YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trs_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("AND a.chss_mgst_trsp_tp_cd =@[trs_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trs_md_cd} != 'ALL')" ).append("\n"); 
		query.append("AND a.trsp_crr_mod_cd = @[trs_md_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trsp_so_fm_node} != '')" ).append("\n"); 
		query.append("AND a.fm_nod_cd = @[trsp_so_fm_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trsp_so_to_node} != '')" ).append("\n"); 
		query.append("AND a.to_nod_cd = @[trsp_so_to_node]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if($eq_no.size() > 0)" ).append("\n"); 
		query.append("AND a.eq_no IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${eq_no})" ).append("\n"); 
		query.append("#if($velocityCount < $eq_no.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND a.delt_flg <> 'Y'" ).append("\n"); 
		query.append("ORDER BY a.trsp_so_cmb_seq" ).append("\n"); 
		query.append(",a.eq_no" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}