/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeGuidelineDBDAOPriSgGohChgVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.12 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kong Back Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGOHChargeGuidelineDBDAOPriSgGohChgVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCGOHChargeGuidelineDBDAOPriSgGohChgVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_pnt_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("goh_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_pnt_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE PRI_SG_GOH_CHG SET" ).append("\n"); 
		query.append("ROUT_PNT_LOC_TP_CD 	= @[rout_pnt_loc_tp_cd]" ).append("\n"); 
		query.append(",ROUT_PNT_LOC_DEF_CD 	= @[rout_pnt_loc_def_cd]" ).append("\n"); 
		query.append(",RAT_UT_CD 				= @[rat_ut_cd]" ).append("\n"); 
		query.append(",PRC_HNGR_BAR_TP_CD 	= @[prc_hngr_bar_tp_cd]" ).append("\n"); 
		query.append(",CURR_CD 				= @[curr_cd]" ).append("\n"); 
		query.append(",FRT_RT_AMT 			= @[frt_rt_amt]" ).append("\n"); 
		query.append(",UPD_USR_ID	 			= @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT 				= sysdate" ).append("\n"); 
		query.append("WHERE	SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	GLINE_SEQ 	 = @[gline_seq]" ).append("\n"); 
		query.append("AND	GOH_CHG_SEQ  = @[goh_chg_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scguideline.scgohchargeguideline.integration").append("\n"); 
		query.append("FileName : SCGOHChargeGuidelineDBDAOPriSgGohChgVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}