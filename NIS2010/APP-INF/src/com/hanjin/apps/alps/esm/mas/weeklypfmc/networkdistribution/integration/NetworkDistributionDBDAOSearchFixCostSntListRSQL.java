/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchFixCostSntListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.01.10 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchFixCostSntListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TS Allocation(SNT) 조회
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchFixCostSntListRSQL(){
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
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : NetworkDistributionDBDAOSearchFixCostSntListRSQL").append("\n"); 
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
		query.append("SELECT	 A.TRD_CD		AS M_TRD_CD" ).append("\n"); 
		query.append("   		,A.RLANE_CD		AS M_RLANE_CD" ).append("\n"); 
		query.append("   		,A.VSL_CD || A.SKD_VOY_NO || A.DIR_CD AS M_VVD_CD" ).append("\n"); 
		query.append("   		,A.IOC_CD		AS M_IOC_CD" ).append("\n"); 
		query.append("   		,B.TO_TRD_CD	AS D_TRD_CD" ).append("\n"); 
		query.append("   		,B.TO_RLANE_CD	AS D_RLANE_CD" ).append("\n"); 
		query.append("   		,B.TO_VSL_CD || B.TO_SKD_VOY_NO ||	B.TO_SKD_DIR_CD AS D_VVD_CD" ).append("\n"); 
		query.append("   		,B.TO_IOC_CD		AS D_IOC_CD" ).append("\n"); 
		query.append("   		,B.LOCL_TS_STS_CD	" ).append("\n"); 
		query.append("   		,B.SNT_TS_QTY		AS D_TS_QTY" ).append("\n"); 
		query.append("   		,B.SNT_FM_VVD_BSA_AMT	AS D_FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("	#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("   		,SUM(B.N4TH_FX_COST_DTRB_AMT)	AS D_ASSIGN_AMT	" ).append("\n"); 
		query.append("   		,SUM(B.N4TH_TS_UC_AMT)			AS D_SLOT_PRICE" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("    	,SUM(B.FX_COST_DTRB_AMT)		AS D_ASSIGN_AMT	" ).append("\n"); 
		query.append("    	,SUM(B.TS_UC_AMT)				AS D_SLOT_PRICE" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("	#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("		,(SELECT	SUM(H.N4TH_HJS_SLS_AMT)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		,(SELECT	SUM(H.HJS_SLS_AMT)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			FROM	MAS_VVD_HIR H" ).append("\n"); 
		query.append("	       WHERE	A.TRD_CD	= H.TRD_CD" ).append("\n"); 
		query.append("			 AND	A.RLANE_CD	= H.RLANE_CD" ).append("\n"); 
		query.append("    		 AND	A.IOC_CD	= H.IOC_CD" ).append("\n"); 
		query.append("    		 AND	A.VSL_CD	= H.VSL_CD" ).append("\n"); 
		query.append("    		 AND	A.SKD_VOY_NO= H.SKD_VOY_NO" ).append("\n"); 
		query.append("    		 AND	A.DIR_CD	= H.DIR_CD" ).append("\n"); 
		query.append("    		 AND	H.STND_COST_CD NOT IN ('43102011')" ).append("\n"); 
		query.append("		#if (${f_selcost} != '')" ).append("\n"); 
		query.append("			 AND	H.STND_COST_CD = @[f_selcost]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		   GROUP BY H.TRD_CD" ).append("\n"); 
		query.append("    		 		, H.RLANE_CD" ).append("\n"); 
		query.append("    		 		, H.IOC_CD" ).append("\n"); 
		query.append("    		 		, H.VSL_CD" ).append("\n"); 
		query.append("    		 		, H.SKD_VOY_NO" ).append("\n"); 
		query.append("    		 		, H.DIR_CD" ).append("\n"); 
		query.append("      	) D_VVD_EXPENSE" ).append("\n"); 
		query.append("FROM	MAS_MON_VVD A" ).append("\n"); 
		query.append("   		,MAS_FX_AMT_DTRB B" ).append("\n"); 
		query.append("   		,MAS_LANE_RGST C" ).append("\n"); 
		query.append("WHERE	A.TRD_CD	= B.FM_TRD_CD" ).append("\n"); 
		query.append("  AND	A.RLANE_CD	= B.FM_RLANE_CD" ).append("\n"); 
		query.append("  AND	A.IOC_CD	= B.FM_IOC_CD" ).append("\n"); 
		query.append("  AND	A.VSL_CD	= B.FM_VSL_CD" ).append("\n"); 
		query.append("  AND	A.SKD_VOY_NO= B.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("  AND	A.DIR_CD	= B.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("#if(${f_chkprd} == 'M')" ).append("\n"); 
		query.append(" #if(${f_fm_mon} != '')" ).append("\n"); 
		query.append("  AND	A.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("  AND	A.COST_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_chkprd} == 'W')" ).append("\n"); 
		query.append("  AND	SUBSTR(SLS_YRMON,1,4)||A.COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND	B.TO_RLANE_CD	= C.RLANE_CD" ).append("\n"); 
		query.append("  AND	B.TO_SKD_DIR_CD	= C.DIR_CD" ).append("\n"); 
		query.append("  AND	B.TO_TRD_CD		= C.TRD_CD" ).append("\n"); 
		query.append("  AND	B.TO_IOC_CD		= C.IOC_CD" ).append("\n"); 
		query.append("  AND	B.STND_COST_CD NOT IN ('43102011')" ).append("\n"); 
		query.append("  AND  NVL(B.DTRB_STEP_CD,'BZC') = 'BZC' 	" ).append("\n"); 
		query.append("#if (${f_selcost} != '')" ).append("\n"); 
		query.append("  AND	B.STND_COST_CD	= @[f_selcost]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("  AND	A.TRD_CD		= @[f_seltrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("  AND	A.RLANE_CD		= @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selioc} != '')" ).append("\n"); 
		query.append("  AND	A.IOC_CD		= @[f_selioc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("  AND	A.VSL_CD		= @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("  AND	A.SKD_VOY_NO		= @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("  AND	A.DIR_CD		= @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND	NVL(C.PCTL_LANE_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("  AND	NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("  AND	NVL(C.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("GROUP BY A.TRD_CD" ).append("\n"); 
		query.append("  		,A.RLANE_CD" ).append("\n"); 
		query.append("  		,A.VSL_CD" ).append("\n"); 
		query.append("   		,A.SKD_VOY_NO" ).append("\n"); 
		query.append("   		,A.DIR_CD" ).append("\n"); 
		query.append("   		,A.IOC_CD" ).append("\n"); 
		query.append("   		,B.TO_TRD_CD" ).append("\n"); 
		query.append("   		,B.TO_RLANE_CD" ).append("\n"); 
		query.append("   		,B.TO_VSL_CD" ).append("\n"); 
		query.append("   		,B.TO_SKD_VOY_NO" ).append("\n"); 
		query.append("   		,B.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("   		,B.TO_IOC_CD" ).append("\n"); 
		query.append("   		,B.LOCL_TS_STS_CD" ).append("\n"); 
		query.append("   		,B.SNT_TS_QTY" ).append("\n"); 
		query.append("   		,B.SNT_FM_VVD_BSA_AMT" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD" ).append("\n"); 
		query.append("    	,A.RLANE_CD" ).append("\n"); 
		query.append("    	,A.VSL_CD" ).append("\n"); 
		query.append("    	,A.SKD_VOY_NO" ).append("\n"); 
		query.append("    	,A.DIR_CD" ).append("\n"); 
		query.append("    	,A.IOC_CD" ).append("\n"); 

	}
}