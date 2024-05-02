/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchLaneInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.11.25 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOSearchLaneInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchLaneInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchLaneInfoListRSQL").append("\n"); 
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
		query.append("-- stpe1:Service Lane Sheet 데이터 조회" ).append("\n"); 
		query.append("SELECT LPAD(ROW_NUMBER() oVER (ORDER BY c1.seq),3,'0') sect_no" ).append("\n"); 
		query.append(",c1.slan_cd" ).append("\n"); 
		query.append(",c1.trd_cd" ).append("\n"); 
		query.append(",c1.sub_trd_cd" ).append("\n"); 
		query.append(",c1.rlane_cd" ).append("\n"); 
		query.append(",c1.skd_dir_cd" ).append("\n"); 
		query.append(",c1.ioc_cd" ).append("\n"); 
		query.append(",c1.freq_no" ).append("\n"); 
		query.append(",0 as vsl_cnt" ).append("\n"); 
		query.append(",'' as extd_lane_flg" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT distinct" ).append("\n"); 
		query.append("b1.trd_cd" ).append("\n"); 
		query.append(",b1.rlane_cd" ).append("\n"); 
		query.append(",b1.vsl_slan_dir_cd as skd_dir_cd" ).append("\n"); 
		query.append(",b1.sub_trd_cd" ).append("\n"); 
		query.append(",b2.vsl_slan_cd as slan_cd" ).append("\n"); 
		query.append(",b1.ioc_cd" ).append("\n"); 
		query.append(",b2.brth_itval_dys as freq_no" ).append("\n"); 
		query.append(",MAX(b2.seq) seq" ).append("\n"); 
		query.append("FROM mdm_dtl_rev_lane b1" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("a2.vsl_slan_cd" ).append("\n"); 
		query.append(",a2.skd_dir_cd" ).append("\n"); 
		query.append(",ROUND(a1.svc_dur_dys/a1.brth_itval_dys,0) as brth_itval_dys" ).append("\n"); 
		query.append(",DECODE(a2.vsl_slan_cd,'INX',DECODE(conti_cd,'F','A',conti_cd)" ).append("\n"); 
		query.append(",'RES',DECODE(conti_cd,'F','A',conti_cd)" ).append("\n"); 
		query.append(",DECODE(conti_cd,'F','E',conti_cd)) conti_cd" ).append("\n"); 
		query.append(",MIN(a2.port_rotn_seq) OVER(PARTITION BY a2.vsl_slan_cd" ).append("\n"); 
		query.append(",a2.skd_dir_cd" ).append("\n"); 
		query.append(",DECODE(a2.vsl_slan_cd,'INX',DECODE(conti_cd,'F','A',conti_cd)" ).append("\n"); 
		query.append(",'RES',DECODE(conti_cd,'F','A',conti_cd)" ).append("\n"); 
		query.append(",DECODE(conti_cd,'F','E',conti_cd)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") seq" ).append("\n"); 
		query.append("FROM vsk_pf_skd a1" ).append("\n"); 
		query.append(",vsk_pf_skd_dtl a2" ).append("\n"); 
		query.append(",mdm_location a3" ).append("\n"); 
		query.append("WHERE a1.vsl_slan_cd   = a2.vsl_slan_cd" ).append("\n"); 
		query.append("AND a1.pf_svc_tp_cd  = a2.pf_svc_tp_cd" ).append("\n"); 
		query.append("AND a2.port_cd       = a3.loc_cd" ).append("\n"); 
		query.append("AND a1.slan_stnd_flg = 'Y'" ).append("\n"); 
		query.append("--AND a1.pf_src_tp_cd  = 'P'" ).append("\n"); 
		query.append("AND a1.vsl_slan_cd   = @[f_slan_cd]" ).append("\n"); 
		query.append("ORDER BY seq" ).append("\n"); 
		query.append(") b2" ).append("\n"); 
		query.append("WHERE b1.rlane_cd        LIKE b2.vsl_slan_cd ||'%'" ).append("\n"); 
		query.append("AND b1.vsl_slan_dir_cd = b2.skd_dir_cd" ).append("\n"); 
		query.append("AND b1.fm_conti_cd     = b2.conti_cd" ).append("\n"); 
		query.append("AND b1.sub_trd_cd      <> 'IP'" ).append("\n"); 
		query.append("AND b1.delt_flg        = 'N'" ).append("\n"); 
		query.append("GROUP BY b1.trd_cd" ).append("\n"); 
		query.append(",b1.rlane_cd" ).append("\n"); 
		query.append(",b1.vsl_slan_dir_cd" ).append("\n"); 
		query.append(",b1.sub_trd_cd" ).append("\n"); 
		query.append(",b2.vsl_slan_cd" ).append("\n"); 
		query.append(",b1.ioc_cd" ).append("\n"); 
		query.append(",b2.brth_itval_dys" ).append("\n"); 
		query.append(") c1" ).append("\n"); 
		query.append("ORDER BY c1.seq" ).append("\n"); 

	}
}