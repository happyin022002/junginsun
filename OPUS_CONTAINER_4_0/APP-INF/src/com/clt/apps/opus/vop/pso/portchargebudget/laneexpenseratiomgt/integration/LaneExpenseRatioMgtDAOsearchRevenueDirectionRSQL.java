/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneExpenseRatioMgtDAOsearchRevenueDirectionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneExpenseRatioMgtDAOsearchRevenueDirectionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue direction Search
	  * </pre>
	  */
	public LaneExpenseRatioMgtDAOsearchRevenueDirectionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("FileName : LaneExpenseRatioMgtDAOsearchRevenueDirectionRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD||'|'||RLANE_CD||'|'||SLAN_DIR_CD||'|'||RLANE_DIR_CD AS DATA" ).append("\n"); 
		query.append("  FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append(" WHERE SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("   AND SLAN_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND RLANE_DIR_CD = @[rlane_dir_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}