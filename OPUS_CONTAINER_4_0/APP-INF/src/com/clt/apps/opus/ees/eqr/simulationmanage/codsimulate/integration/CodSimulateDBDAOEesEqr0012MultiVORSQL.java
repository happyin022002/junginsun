/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodSimulateDBDAOEesEqr0012MultiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.01 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodSimulateDBDAOEesEqr0012MultiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CodSimulateDBDAO
	  * </pre>
	  */
	public CodSimulateDBDAOEesEqr0012MultiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.integration ").append("\n"); 
		query.append("FileName : CodSimulateDBDAOEesEqr0012MultiVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' ibflag," ).append("\n"); 
		query.append("''	pln_yrwk," ).append("\n"); 
		query.append("''	fm_ecc_cd," ).append("\n"); 
		query.append("''	fm_ecc_cd_tmp," ).append("\n"); 
		query.append("'' fm_etd_dt," ).append("\n"); 
		query.append("'' to_ecc_cd," ).append("\n"); 
		query.append("''		to_ecc_cd_tmp," ).append("\n"); 
		query.append("''	to_etb_dt," ).append("\n"); 
		query.append("''	co_cd," ).append("\n"); 
		query.append("''  lane_cd," ).append("\n"); 
		query.append("''  vsl_cd," ).append("\n"); 
		query.append("''	skd_voy_no," ).append("\n"); 
		query.append("''	skd_dir_cd," ).append("\n"); 
		query.append("''	vvd," ).append("\n"); 
		query.append("''  fm_ecc_cd_tmp1," ).append("\n"); 
		query.append("''  fm_etd_dt1," ).append("\n"); 
		query.append("''	to_ecc_cd_tmp1," ).append("\n"); 
		query.append("''	to_etb_dt1," ).append("\n"); 
		query.append("''	fm_ecc_cd_flg," ).append("\n"); 
		query.append("''  to_ecc_cd_flg," ).append("\n"); 
		query.append("''  past_repo_pln_flg," ).append("\n"); 
		query.append("''	fix_to_ecc," ).append("\n"); 
		query.append("''  ldis_ts_flg" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}