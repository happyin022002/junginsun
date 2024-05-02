/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneSimulationDBDAOCreateSimBunkerListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneSimulationDBDAOCreateSimBunkerListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BunkerList 수정
	  * </pre>
	  */
	public LaneSimulationDBDAOCreateSimBunkerListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_vsl_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sect_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.lanesimulation.integration").append("\n"); 
		query.append("FileName : LaneSimulationDBDAOCreateSimBunkerListUSQL").append("\n"); 
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
		query.append("UPDATE MAS_SIM_BNK_COST" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("FOIL_SAIL_CSM = (SELECT FOIL_SAIL_CSM" ).append("\n"); 
		query.append("FROM MAS_BNK_CSM" ).append("\n"); 
		query.append("WHERE VSL_CLSS_CAPA = @[vsl_clss_capa]" ).append("\n"); 
		query.append("AND BZC_VSL_SPD   = @[bzc_vsl_spd])" ).append("\n"); 
		query.append(",FOIL_PORT_CSM = (SELECT FOIL_SAIL_CSM*0.05" ).append("\n"); 
		query.append("FROM MAS_BNK_CSM" ).append("\n"); 
		query.append("WHERE VSL_CLSS_CAPA = @[vsl_clss_capa]" ).append("\n"); 
		query.append("AND BZC_VSL_SPD   = @[bzc_vsl_spd])" ).append("\n"); 
		query.append(",FOIL_UC_AMT   = @[foil_uc_amt]" ).append("\n"); 
		query.append(",DOIL_CSM      = @[doil_csm]" ).append("\n"); 
		query.append(",DOIL_UC_AMT   = @[doil_uc_amt]" ).append("\n"); 
		query.append(",BZC_VSL_SPD   = @[bzc_vsl_spd]" ).append("\n"); 
		query.append(",UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT        = SYSDATE" ).append("\n"); 
		query.append("WHERE SIM_DT        = @[sim_dt]" ).append("\n"); 
		query.append("AND SIM_NO        = @[sim_no]" ).append("\n"); 
		query.append("AND SECT_NO       = @[sect_no]" ).append("\n"); 
		query.append("AND VSL_CLSS_CAPA = @[vsl_clss_capa]" ).append("\n"); 

	}
}