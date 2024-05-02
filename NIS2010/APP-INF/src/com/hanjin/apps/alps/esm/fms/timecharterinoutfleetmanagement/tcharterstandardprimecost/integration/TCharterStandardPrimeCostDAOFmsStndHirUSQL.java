/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterStandardPrimeCostDAOFmsStndHirUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.23 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterStandardPrimeCostDAOFmsStndHirUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hire Creation Update
	  * </pre>
	  */
	public TCharterStandardPrimeCostDAOFmsStndHirUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_stnd_max_hir_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_14ton_vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mkt_rt_aply_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_rt_n2nd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_rt_n1st_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_teu_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_max_hir_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dznd_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_stnd_14ton_hir_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hb_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("teu_14ton_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_14ton_hir_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.integration").append("\n"); 
		query.append("FileName : TCharterStandardPrimeCostDAOFmsStndHirUSQL").append("\n"); 
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
		query.append("MERGE INTO FMS_STND_HIR A" ).append("\n"); 
		query.append("USING (SELECT @[flet_ctrt_no] FLET_CTRT_NO," ).append("\n"); 
		query.append("@[hb_yrmon] HB_YRMON," ).append("\n"); 
		query.append("@[vsl_cd] VSL_CD," ).append("\n"); 
		query.append("@[flet_ctrt_tp_cd] FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("@[mkt_rt_aply_flg] MKT_RT_APLY_FLG," ).append("\n"); 
		query.append("@[vsl_dznd_capa] VSL_DZND_CAPA," ).append("\n"); 
		query.append("@[bse_14ton_vsl_capa] BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("@[hir_rt_n1st_amt] HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("@[hir_rt_n2nd_amt] HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("@[max_teu_rt_amt] MAX_TEU_RT_AMT," ).append("\n"); 
		query.append("@[stnd_max_hir_amt] STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("@[diff_stnd_max_hir_amt] DIFF_STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("@[teu_14ton_rt_amt] TEU_14TON_RT_AMT," ).append("\n"); 
		query.append("@[stnd_14ton_hir_amt] STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("@[diff_stnd_14ton_hir_amt] DIFF_STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("@[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL) B" ).append("\n"); 
		query.append("ON (A.FLET_CTRT_NO = B.FLET_CTRT_NO AND A.HB_YRMON = B.HB_YRMON AND A.VSL_CD = B.VSL_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("A.MKT_RT_APLY_FLG = B.MKT_RT_APLY_FLG," ).append("\n"); 
		query.append("A.STND_MAX_HIR_AMT = B.STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("A.STND_14TON_HIR_AMT = B.STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("A.DIFF_STND_MAX_HIR_AMT = B.DIFF_STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("A.DIFF_STND_14TON_HIR_AMT = B.DIFF_STND_14TON_HIR_AMT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT( FLET_CTRT_NO," ).append("\n"); 
		query.append("HB_YRMON," ).append("\n"); 
		query.append("VSL_CD," ).append("\n"); 
		query.append("FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("MKT_RT_APLY_FLG," ).append("\n"); 
		query.append("VSL_DZND_CAPA," ).append("\n"); 
		query.append("BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("MAX_TEU_RT_AMT," ).append("\n"); 
		query.append("STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("DIFF_STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("TEU_14TON_RT_AMT," ).append("\n"); 
		query.append("STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("DIFF_STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES( B.FLET_CTRT_NO," ).append("\n"); 
		query.append("B.HB_YRMON," ).append("\n"); 
		query.append("B.VSL_CD," ).append("\n"); 
		query.append("B.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("B.MKT_RT_APLY_FLG," ).append("\n"); 
		query.append("B.VSL_DZND_CAPA," ).append("\n"); 
		query.append("B.BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("B.HIR_RT_N1ST_AMT," ).append("\n"); 
		query.append("B.HIR_RT_N2ND_AMT," ).append("\n"); 
		query.append("B.MAX_TEU_RT_AMT," ).append("\n"); 
		query.append("B.STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("B.DIFF_STND_MAX_HIR_AMT," ).append("\n"); 
		query.append("B.TEU_14TON_RT_AMT," ).append("\n"); 
		query.append("B.STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("B.DIFF_STND_14TON_HIR_AMT," ).append("\n"); 
		query.append("B.CRE_USR_ID," ).append("\n"); 
		query.append("B.UPD_USR_ID)" ).append("\n"); 

	}
}