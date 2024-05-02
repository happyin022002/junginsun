/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureDBDAOCoaTrnsTermCalcVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.10.13 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOCoaTrnsTermCalcVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Feeder Term Ratio 추가, 수정   
	  * </pre>
	  */
	public CostStructureDBDAOCoaTrnsTermCalcVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_tml_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_mod_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_thrp_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_nod_thrp_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_nod_tml_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nod_stvg_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nxt_nod_stvg_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOCoaTrnsTermCalcVOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_TRNS_TERM_CALC B1" ).append("\n"); 
		query.append("USING ( SELECT '1'" ).append("\n"); 
		query.append("FROM DUAL ) B2" ).append("\n"); 
		query.append("ON (    B1.COST_ACT_GRP_CD  = @[cost_act_grp_cd]" ).append("\n"); 
		query.append("AND B1.CALC_TERM_CD     = @[calc_term_cd]" ).append("\n"); 
		query.append("AND B1.WTR_TERM_CD      = @[wtr_term_cd]" ).append("\n"); 
		query.append("AND B1.WTR_MOD_FLG      = @[wtr_mod_flg] )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET   B1.NOD_STVG_RTO         = @[nod_stvg_rto]" ).append("\n"); 
		query.append(",B1.NOD_THRP_RTO         = @[nod_thrp_rto]" ).append("\n"); 
		query.append(",B1.NOD_TML_RTO          = @[nod_tml_rto]" ).append("\n"); 
		query.append(",B1.NXT_NOD_STVG_RTO     = @[nxt_nod_stvg_rto]" ).append("\n"); 
		query.append(",B1.NXT_NOD_THRP_RTO     = @[nxt_nod_thrp_rto]" ).append("\n"); 
		query.append(",B1.NXT_NOD_TML_RTO      = @[nxt_nod_tml_rto]" ).append("\n"); 
		query.append(",B1.UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append(",B1.UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",CALC_TERM_CD" ).append("\n"); 
		query.append(",WTR_TERM_CD" ).append("\n"); 
		query.append(",WTR_MOD_FLG" ).append("\n"); 
		query.append(",NOD_STVG_RTO" ).append("\n"); 
		query.append(",NOD_THRP_RTO" ).append("\n"); 
		query.append(",NOD_TML_RTO" ).append("\n"); 
		query.append(",NXT_NOD_STVG_RTO" ).append("\n"); 
		query.append(",NXT_NOD_THRP_RTO" ).append("\n"); 
		query.append(",NXT_NOD_TML_RTO" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(@[cost_act_grp_cd]" ).append("\n"); 
		query.append(",@[calc_term_cd]" ).append("\n"); 
		query.append(",@[wtr_term_cd]" ).append("\n"); 
		query.append(",@[wtr_mod_flg]" ).append("\n"); 
		query.append(",@[nod_stvg_rto]" ).append("\n"); 
		query.append(",@[nod_thrp_rto]" ).append("\n"); 
		query.append(",@[nod_tml_rto]" ).append("\n"); 
		query.append(",@[nxt_nod_stvg_rto]" ).append("\n"); 
		query.append(",@[nxt_nod_thrp_rto]" ).append("\n"); 
		query.append(",@[nxt_nod_tml_rto]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE)" ).append("\n"); 

	}
}