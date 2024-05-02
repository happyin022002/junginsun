/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOremovePsoPortExpenseDivisionDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.26 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOremovePsoPortExpenseDivisionDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_PORT_EXPN_DIV 테이블 삭제
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOremovePsoPortExpenseDivisionDSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration").append("\n"); 
		query.append("FileName : LaneExpenseRatioMgtDAOremovePsoPortExpenseDivisionDSQL").append("\n"); 
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
		query.append("DELETE FROM pso_port_expn_div" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND slan_cd      = @[slan_cd]" ).append("\n"); 
		query.append("AND	skd_dir_cd   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	loc_cd       = @[loc_cd]" ).append("\n"); 
		query.append("AND	rlane_cd     = @[rlane_cd]" ).append("\n"); 
		query.append("AND	rev_dir_cd   = @[rlane_dir_cd]" ).append("\n"); 

	}
}