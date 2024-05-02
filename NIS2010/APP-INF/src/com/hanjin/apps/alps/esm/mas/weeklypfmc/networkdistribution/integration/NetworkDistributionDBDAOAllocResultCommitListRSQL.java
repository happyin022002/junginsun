/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkDistributionDBDAOAllocResultCommitListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOAllocResultCommitListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation Results(Commitment base) 조회
	  * </pre>
	  */
	public NetworkDistributionDBDAOAllocResultCommitListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_seltrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selrlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_selioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOAllocResultCommitListRSQL").append("\n"); 
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
		query.append("SELECT cost_yrmon" ).append("\n"); 
		query.append("      , cost_wk" ).append("\n"); 
		query.append("      , trd_cd" ).append("\n"); 
		query.append("      , sub_trd_cd" ).append("\n"); 
		query.append("      , rlane_cd" ).append("\n"); 
		query.append("      , ioc_cd" ).append("\n"); 
		query.append("      , vsl_cd" ).append("\n"); 
		query.append("      , skd_voy_no" ).append("\n"); 
		query.append("      , dir_cd" ).append("\n"); 
		query.append("      , vvd_cd" ).append("\n"); 
		query.append("	  , hul_bnd_cd" ).append("\n"); 
		query.append("      , co_amt" ).append("\n"); 
		query.append("      , hjs_sls_amt" ).append("\n"); 
		query.append("      , n1st_asgn_amt" ).append("\n"); 
		query.append("      , ipt_asgn_amt" ).append("\n"); 
		query.append("      , (hjs_sls_amt + n1st_asgn_amt + ipt_asgn_amt) AS hjs_sales_final" ).append("\n"); 
		query.append("      , (co_amt + hjs_sls_amt + n1st_asgn_amt + ipt_asgn_amt)  total_network_cost" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("	SELECT a.cost_yrmon" ).append("\n"); 
		query.append("	      , a.cost_wk" ).append("\n"); 
		query.append("	      , b.trd_cd" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, a.sub_trd_cd, 'OT') AS sub_trd_cd" ).append("\n"); 
		query.append("	      , b.rlane_cd" ).append("\n"); 
		query.append("	      , b.ioc_cd" ).append("\n"); 
		query.append("	      , b.vsl_cd" ).append("\n"); 
		query.append("	      , b.skd_voy_no" ).append("\n"); 
		query.append("	      , b.dir_cd" ).append("\n"); 
		query.append("	      , b.vsl_cd||b.skd_voy_no||b.dir_cd AS vvd_cd" ).append("\n"); 
		query.append("		  , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("	#if (${f_op_view} == 'OP5')" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, NVL(SUM(b.co_amt), 0),0)   AS co_amt" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, NVL(SUM(b.hjs_sls_amt), 0),0)   AS hjs_sls_amt" ).append("\n"); 
		query.append("	      , CASE WHEN b.trd_cd IN ('IAS','IES','IMS') THEN DECODE(c.no, 1, (NVL(SUM(b.n5th_asgn_amt), 0) - NVL(SUM(b.hjs_sls_amt), 0)), NVL(SUM(B.adj_trd_otr_fnl_amt), 0) ) " ).append("\n"); 
		query.append("				 ELSE DECODE(c.no, 1, NVL(SUM(b.n5th_asgn_amt), 0), NVL(SUM(B.adj_trd_otr_fnl_amt), 0)) END AS n1st_asgn_amt" ).append("\n"); 
		query.append("	      , 0  AS n2st_asgn_amt" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, NVL(SUM(b.ipt_asgn_amt), 0),0)  AS ipt_asgn_amt" ).append("\n"); 
		query.append("	      " ).append("\n"); 
		query.append("	#elseif (${f_op_view} == 'OP6')" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, NVL(SUM(b.n4th_co_amt), 0),0)   AS co_amt" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, NVL(SUM(b.n4th_hjs_sls_amt), 0),0)   AS hjs_sls_amt" ).append("\n"); 
		query.append("	      , CASE WHEN b.trd_cd IN ('IAS','IES','IMS') THEN DECODE(c.no, 1, NVL(SUM(b.n6th_asgn_amt), 0) - NVL(SUM(b.n4th_hjs_sls_amt), 0), NVL(SUM(B.n6th_adj_otr_fnl_amt), 0) ) " ).append("\n"); 
		query.append("				 ELSE DECODE(c.no, 1, NVL(SUM(b.n6th_asgn_amt), 0), NVL(SUM(B.n6th_adj_otr_fnl_amt), 0)) END AS n1st_asgn_amt" ).append("\n"); 
		query.append("	      , 0  AS n2st_asgn_amt" ).append("\n"); 
		query.append("	      , DECODE(c.no, 1, NVL(SUM(b.ipt_asgn_amt), 0),0)  AS ipt_asgn_amt" ).append("\n"); 
		query.append("	      " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   FROM mas_mon_vvd a" ).append("\n"); 
		query.append("	      , mas_vvd_hir b" ).append("\n"); 
		query.append("	      , (SELECT LEVEL AS NO FROM dual  CONNECT BY LEVEL < 3 ) c " ).append("\n"); 
		query.append("		  , (SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM MAS_LANE_RGST) D" ).append("\n"); 
		query.append("	  WHERE a.trd_cd             = b.trd_cd" ).append("\n"); 
		query.append("	    AND a.rlane_cd           = b.rlane_cd" ).append("\n"); 
		query.append("	    AND a.ioc_cd             = b.ioc_cd" ).append("\n"); 
		query.append("	    AND a.vsl_cd             = b.vsl_cd" ).append("\n"); 
		query.append("	    AND a.skd_voy_no         = b.skd_voy_no" ).append("\n"); 
		query.append("	    AND a.dir_cd             = b.dir_cd" ).append("\n"); 
		query.append("		AND A.TRD_CD          = D.TRD_CD" ).append("\n"); 
		query.append("        AND A.RLANE_CD        = D.RLANE_CD" ).append("\n"); 
		query.append("        AND A.IOC_CD          = D.IOC_CD" ).append("\n"); 
		query.append("        AND A.DIR_CD          = D.DIR_CD    " ).append("\n"); 
		query.append("	    AND b.stnd_cost_cd NOT  IN('43102011', '54600000')" ).append("\n"); 
		query.append("	    AND NVL(a.delt_flg, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("	    AND a.trd_cd = @[f_seltrade]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("	    AND a.rlane_cd = @[f_selrlane]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_selioc} != '')" ).append("\n"); 
		query.append("	    AND a.ioc_cd = @[f_selioc]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("	    AND a.vsl_cd = @[f_vsl_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("	    AND a.skd_voy_no = @[f_skd_voy_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("	    AND a.dir_cd = @[f_dir_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_selcost} != '')" ).append("\n"); 
		query.append("	    AND b.stnd_cost_cd = @[f_selcost]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("	    #if (${f_fm_mon} != '')" ).append("\n"); 
		query.append("	    AND a.cost_yrmon BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("	    AND a.cost_yrmon like @[f_year] || '%'" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("	    AND a.sls_yrmon LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("	    #if (${f_fm_wk} != '')" ).append("\n"); 
		query.append("	    AND a.cost_wk BETWEEN @[f_fm_wk] AND @[f_to_wk] " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY a.cost_yrmon" ).append("\n"); 
		query.append("	      , a.cost_wk" ).append("\n"); 
		query.append("	      , b.trd_cd" ).append("\n"); 
		query.append("	      , a.sub_trd_cd" ).append("\n"); 
		query.append("	      , b.rlane_cd" ).append("\n"); 
		query.append("	      , b.ioc_cd" ).append("\n"); 
		query.append("	      , b.vsl_cd" ).append("\n"); 
		query.append("	      , b.skd_voy_no" ).append("\n"); 
		query.append("	      , b.dir_cd" ).append("\n"); 
		query.append("		  , d.HUL_BND_CD" ).append("\n"); 
		query.append("	      , c.no" ).append("\n"); 
		query.append("	ORDER BY  a.cost_yrmon" ).append("\n"); 
		query.append("	      , a.cost_wk" ).append("\n"); 
		query.append("	      , b.trd_cd" ).append("\n"); 
		query.append("	      , b.rlane_cd" ).append("\n"); 
		query.append("	      , b.ioc_cd" ).append("\n"); 
		query.append("	      , b.vsl_cd" ).append("\n"); 
		query.append("	      , b.skd_voy_no" ).append("\n"); 
		query.append("	      , b.dir_cd" ).append("\n"); 
		query.append("	      , DECODE(DECODE(c.no, 1, a.sub_trd_cd, 'OT'), 'OT', '2', '1') " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   WHERE TRD_CD||SUB_TRD_CD NOT IN ('IMSOT', 'IESOT')" ).append("\n"); 

	}
}