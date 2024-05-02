/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LaneSimulationDBDAOSearchVesselInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.05.03 윤진영
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

public class LaneSimulationDBDAOSearchVesselListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vessel 정보를 조회한다.
	  * </pre>
	  */
	public LaneSimulationDBDAOSearchVesselListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srow",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOSearchVesselInfoRSQL").append("\n"); 
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
		query.append("SELECT x.vsl_cd" ).append("\n"); 
		query.append(",x.vsl_clss_capa" ).append("\n"); 
		query.append(",DECODE(NVL(y.sub_trd_capa,0),0, x.stnd_ldb_capa,y.sub_trd_capa) stnd_ldb_capa" ).append("\n"); 
		query.append(",x.vsl_oshp_cd" ).append("\n"); 
		query.append(",x.vop_cd" ).append("\n"); 
		query.append(",'Y' AS mdm_vsl_yn" ).append("\n"); 
		query.append(",'' as trade_cd" ).append("\n"); 
		query.append(",@[srow] as srow" ).append("\n"); 
		query.append(",'' as procgb" ).append("\n"); 
		query.append("FROM coa_vsl_rgst x," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT b.vsl_cd, MAX(b.sub_trd_capa) sub_trd_capa, b.vsl_seq" ).append("\n"); 
		query.append("FROM mdm_sub_trd a, coa_vsl_sub_trd_capa b" ).append("\n"); 
		query.append("WHERE a.sub_trd_cd      = b.sub_trd_cd" ).append("\n"); 
		query.append("AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("GROUP BY b.vsl_cd, b.vsl_seq" ).append("\n"); 
		query.append(") y" ).append("\n"); 
		query.append("WHERE x.vsl_cd    = y.vsl_cd(+)" ).append("\n"); 
		query.append("AND x.vsl_seq   = y.vsl_seq(+)" ).append("\n"); 
		query.append("AND x.vsl_tp_cd = 'C'" ).append("\n"); 
		query.append("AND x.vsl_cd    = @[vsl_cd]" ).append("\n"); 
		query.append("AND x.lst_flg   = 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT vsl_cd, vsl_clss_capa, stnd_ldb_capa, vsl_oshp_cd, vop_cd, 'N' AS mdm_vsl_yn" ).append("\n"); 
		query.append(",'' as trade_cd,@[srow] as srow,'' as procgb" ).append("\n"); 
		query.append("FROM coa_sim_vsl_rgst" ).append("\n"); 
		query.append("WHERE vsl_cd = @[vsl_cd]" ).append("\n"); 

	}
}