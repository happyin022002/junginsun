/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOApplyToPLOP61CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.09.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOApplyToPLOP61CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ApplyTo PL OP6_1
	  * </pre>
	  */
	public NetworkDistributionDBDAOApplyToPLOP61CSQL(){
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
		params.put("cost_yrmon_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_s",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_wk_e",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOApplyToPLOP61CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PFIT_LSS_SMRY C1 USING " ).append("\n"); 
		query.append("	( SELECT B1.VSL_CD " ).append("\n"); 
		query.append("	      , B1.SKD_VOY_NO " ).append("\n"); 
		query.append("	      , B1.SKD_DIR_CD " ).append("\n"); 
		query.append("	      , B1.IOC_CD " ).append("\n"); 
		query.append("	      , B1.RLANE_CD " ).append("\n"); 
		query.append("	      , B1.TRD_CD " ).append("\n"); 
		query.append("	      , B1.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	      , B1.STND_COST_CD " ).append("\n"); 
		query.append("	      , B1.SLS_OFC_CD " ).append("\n"); 
		query.append("	      , B1.AGMT_SGN_OFC_CD " ).append("\n"); 
		query.append("	      , B1.N5TH_ESTM_PL_AMT" ).append("\n"); 
		query.append("	      , B1.N5TH_HJS_SLS_AMT" ).append("\n"); 
		query.append("	      , B1.N5TH_CO_AMT" ).append("\n"); 
		query.append("	      , B2.OP_LANE_TP_CD " ).append("\n"); 
		query.append("	      , @[upd_usr_id] UPD_USR_ID " ).append("\n"); 
		query.append("	      , SYSDATE UPD_DT " ).append("\n"); 
		query.append("	FROM    COA_PFIT_LSS_SMRY B1 " ).append("\n"); 
		query.append("	      , (SELECT A1.TRD_CD " ).append("\n"); 
		query.append("	              , A1.RLANE_CD " ).append("\n"); 
		query.append("	              , A1.IOC_CD " ).append("\n"); 
		query.append("	              , A1.VSL_CD " ).append("\n"); 
		query.append("	              , A1.SKD_VOY_NO " ).append("\n"); 
		query.append("	              , A1.DIR_CD " ).append("\n"); 
		query.append("	              , A1.SLAN_CD " ).append("\n"); 
		query.append("	              , NVL(A2.OP_LANE_TP_CD, 'OT') OP_LANE_TP_CD " ).append("\n"); 
		query.append("	        FROM    COA_MON_VVD A1 " ).append("\n"); 
		query.append("	              , COA_LANE_RGST A2 " ).append("\n"); 
		query.append("	        WHERE   A1.TRD_CD     = A2.TRD_CD " ).append("\n"); 
		query.append("	            AND A1.RLANE_CD   = A2.RLANE_CD " ).append("\n"); 
		query.append("	            AND A1.DIR_CD     = A2.DIR_CD " ).append("\n"); 
		query.append("	            AND A1.IOC_CD     = A2.IOC_CD " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("            	#if (${trd_cd} != '')" ).append("\n"); 
		query.append("            	         AND A1.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("            	#end         " ).append("\n"); 
		query.append("            	#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("            	         AND A1.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("            	#end               " ).append("\n"); 
		query.append("            	#if (${ioc_cd} != '')" ).append("\n"); 
		query.append("            	         AND A1.IOC_CD   = @[ioc_cd]" ).append("\n"); 
		query.append("            	#end            " ).append("\n"); 
		query.append("            	#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("            	         AND A1.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("            	#end          " ).append("\n"); 
		query.append("            	#if (${skd_voy_no} != '')           " ).append("\n"); 
		query.append("            	         AND A1.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("            	#end           " ).append("\n"); 
		query.append("            	#if (${dir_cd} != '')               " ).append("\n"); 
		query.append("            	        AND A1.DIR_CD     = @[dir_cd]" ).append("\n"); 
		query.append("            	#end        " ).append("\n"); 
		query.append("                #if (${priod} == 'M')" ).append("\n"); 
		query.append("                      #if (${fmMonth} != '')" ).append("\n"); 
		query.append("            			            AND A1.COST_YRMON BETWEEN @[cost_yrmon_s] AND @[cost_yrmon_e]" ).append("\n"); 
		query.append("            		  #else" ).append("\n"); 
		query.append("            			            AND A1.COST_YRMON LIKE @[cost_yrmon] || '%'" ).append("\n"); 
		query.append("            		  #end" ).append("\n"); 
		query.append("            	#elseif (${priod} == 'W')" ).append("\n"); 
		query.append("            		            AND A1.SLS_YRMON LIKE @[sls_yrmon]" ).append("\n"); 
		query.append("            		#if (${fmWeek} != '')" ).append("\n"); 
		query.append("            			          AND A1.COST_WK BETWEEN @[cost_wk_s] AND @[cost_wk_e]" ).append("\n"); 
		query.append("            		#end" ).append("\n"); 
		query.append("            	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	            AND NVL(A1.DELT_FLG, 'N')   = 'N' 		" ).append("\n"); 
		query.append("	        ) B2 " ).append("\n"); 
		query.append("	WHERE   1             =1 " ).append("\n"); 
		query.append("  	    AND B1.VSL_CD     = B2.VSL_CD " ).append("\n"); 
		query.append("  	    AND B1.SKD_VOY_NO = B2.SKD_VOY_NO " ).append("\n"); 
		query.append("  	    AND B1.SKD_DIR_CD = B2.DIR_CD " ).append("\n"); 
		query.append("  	    AND B1.RLANE_CD   = B2.RLANE_CD " ).append("\n"); 
		query.append("  	    AND B1.IOC_CD     = B2.IOC_CD " ).append("\n"); 
		query.append("  	    AND B1.TRD_CD     = B2.TRD_CD " ).append("\n"); 
		query.append("  	    AND B1.SLS_OFC_CD     	   ='SELHO'  " ).append("\n"); 
		query.append("  	    AND B1.AGMT_SGN_OFC_CD     = 'SELHO'  " ).append("\n"); 
		query.append("	) C2 " ).append("\n"); 
		query.append("	ON (  C1.VSL_CD = C2.VSL_CD " ).append("\n"); 
		query.append("	  AND C1.SKD_VOY_NO = C2.SKD_VOY_NO " ).append("\n"); 
		query.append("	  AND C1.SKD_DIR_CD = C2.SKD_DIR_CD " ).append("\n"); 
		query.append("	  AND C1.IOC_CD = C2.IOC_CD " ).append("\n"); 
		query.append("	  AND C1.RLANE_CD = C2.RLANE_CD " ).append("\n"); 
		query.append("	  AND C1.TRD_CD = C2.TRD_CD " ).append("\n"); 
		query.append("	  AND C1.CNTR_TPSZ_CD = C2.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	  AND C1.STND_COST_CD = C2.STND_COST_CD " ).append("\n"); 
		query.append("	  AND C1.SLS_OFC_CD = C2.SLS_OFC_CD  " ).append("\n"); 
		query.append("	  AND C1.AGMT_SGN_OFC_CD = C2.AGMT_SGN_OFC_CD " ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("	WHEN MATCHED THEN " ).append("\n"); 
		query.append("	   UPDATE " ).append("\n"); 
		query.append("	   SET C1.N6TH_ESTM_PL_AMT = C2.N5TH_ESTM_PL_AMT" ).append("\n"); 
		query.append("	      ,C1.N6TH_HJS_SLS_AMT = C2.N5TH_HJS_SLS_AMT" ).append("\n"); 
		query.append("	      ,C1.N6TH_CO_AMT      = C2.N5TH_CO_AMT" ).append("\n"); 
		query.append("	      ,C1.OP_LANE_TP_CD    = C2.OP_LANE_TP_CD " ).append("\n"); 
		query.append("	      ,C1.UPD_USR_ID       = C2.UPD_USR_ID " ).append("\n"); 
		query.append("	      ,C1.UPD_DT           = C2.UPD_DT" ).append("\n"); 

	}
}