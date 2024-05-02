/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatementCommonDBDAOChkRevenuePortEachLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOChkRevenuePortEachLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * check RevenuePortEachLane
	  * </pre>
	  */
	public StatementCommonDBDAOChkRevenuePortEachLaneRSQL(){
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
		params.put("finc_rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_ipt_ocn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAOChkRevenuePortEachLaneRSQL").append("\n"); 
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
		query.append("SELECT SLAN_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , FINC_REV_DIR_CD" ).append("\n"); 
		query.append("    , REV_IPT_OCN_CD" ).append("\n"); 
		query.append("    , REV_PORT_CD" ).append("\n"); 
		query.append("    , RLANE_NM" ).append("\n"); 
		query.append("    , DIR_CNG_CD" ).append("\n"); 
		query.append("    , DELT_FLG" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("FROM SCO_REV_LANE_PORT_INFO" ).append("\n"); 
		query.append("WHERE SLAN_CD 			= @[slan_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD 		= @[rlane_cd]" ).append("\n"); 
		query.append("    AND FINC_REV_DIR_CD = @[finc_rev_dir_cd]" ).append("\n"); 
		query.append("    AND REV_IPT_OCN_CD 	= @[rev_ipt_ocn_cd]" ).append("\n"); 
		query.append("	AND DELT_FLG 		= 'N'" ).append("\n"); 

	}
}