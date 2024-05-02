/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOSlotHireTgtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.11.25 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOSlotHireTgtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slot Hire Target 수정
	  * </pre>
	  */
	public SettlementProcessDBDAOSlotHireTgtUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_fsh_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("estm_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSlotHireTgtUSQL").append("\n"); 
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
		query.append("UPDATE JOO_SLT_TGT J" ).append("\n"); 
		query.append("SET   			" ).append("\n"); 
		query.append(" J.JO_FSH_FLG 					 = @[jo_fsh_flg]" ).append("\n"); 
		query.append(",J.FNL_BSA_QTY 					 = @[fnl_bsa_qty] 			" ).append("\n"); 
		query.append(",J.FNL_BSA_SLT_PRC 				 = @[fnl_bsa_slt_prc] 		" ).append("\n"); 
		query.append(",J.ESTM_STL_AMT 				 = @[estm_stl_amt] 			" ).append("\n"); 
		query.append(",J.ACT_STL_AMT 					 = @[act_stl_amt] 			" ).append("\n"); 
		query.append(",J.FNL_STL_AMT 					 = @[fnl_stl_amt] 			" ).append("\n"); 
		query.append(",J.ADJ_RSLT_CD 					 = @[adj_rslt_cd] 			" ).append("\n"); 
		query.append(",J.ADJ_RMK 						 = @[adj_rmk] 				" ).append("\n"); 
		query.append(",J.JO_STL_STS_CD 				 = @[jo_stl_sts_cd]			" ).append("\n"); 
		query.append(",J.UPD_DT              = SYSDATE 	" ).append("\n"); 
		query.append(",J.UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND J.REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND J.REV_YRMON_SEQ = @[rev_yrmon_seq]" ).append("\n"); 

	}
}