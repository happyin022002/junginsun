/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MultiDimensionRPTDBDAOAddPnlRptItemCSQL.java
*@FileTitle : P/L Report Item Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.19 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-Sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MultiDimensionRPTDBDAOAddPnlRptItemCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Query for ESM_COA_2003
	  * </pre>
	  */
	public MultiDimensionRPTDBDAOAddPnlRptItemCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_itm_colr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_itm_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgrp_locl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgrp_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgrp_cost_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_rpt_itm_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_dp_sgrp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.multidimensionrpt.multidimensionrpt.integration ").append("\n"); 
		query.append("FileName : MultiDimensionRPTDBDAOAddPnlRptItemCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_PFIT_LSS_RPT_ITM 	" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("		 STND_COST_CD" ).append("\n"); 
		query.append("		,RPT_VW_CD" ).append("\n"); 
		query.append("		,SGRP_COST_CD" ).append("\n"); 
		query.append("		,STND_COST_TP_CD" ).append("\n"); 
		query.append("		,RPT_ITM_DESC" ).append("\n"); 
		query.append("		,LOCL_RPT_ITM_DESC" ).append("\n"); 
		query.append("		,SGRP_COST_CD_DESC" ).append("\n"); 
		query.append("		,SGRP_LOCL_DESC" ).append("\n"); 
		query.append("		,RPT_DP_SEQ" ).append("\n"); 
		query.append("		,RPT_DP_SGRP_SEQ" ).append("\n"); 
		query.append("		,RPT_ITM_COLR_FLG" ).append("\n"); 
		query.append("		,CRE_USR_ID" ).append("\n"); 
		query.append("		,CRE_DT" ).append("\n"); 
		query.append("		,UPD_USR_ID" ).append("\n"); 
		query.append("		,UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("		 @[stnd_cost_cd]" ).append("\n"); 
		query.append("		,@[rpt_vw_cd]" ).append("\n"); 
		query.append("		,@[sgrp_cost_cd]" ).append("\n"); 
		query.append("		,@[stnd_cost_tp_cd]" ).append("\n"); 
		query.append("		,@[rpt_itm_desc]" ).append("\n"); 
		query.append("		,@[locl_rpt_itm_desc]" ).append("\n"); 
		query.append("		,@[sgrp_cost_cd_desc]" ).append("\n"); 
		query.append("		,@[sgrp_locl_desc]" ).append("\n"); 
		query.append("		,@[rpt_dp_seq]" ).append("\n"); 
		query.append("		,@[rpt_dp_sgrp_seq]" ).append("\n"); 
		query.append("		,@[rpt_itm_colr_flg]" ).append("\n"); 
		query.append("		,@[cre_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append("		,@[upd_usr_id]" ).append("\n"); 
		query.append("		,SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}