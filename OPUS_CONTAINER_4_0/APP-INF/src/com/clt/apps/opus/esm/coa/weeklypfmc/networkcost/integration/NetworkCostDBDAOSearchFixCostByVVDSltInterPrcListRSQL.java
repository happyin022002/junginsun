/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOSearchFixCostByVVDSltInterPrcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOSearchFixCostByVVDSltInterPrcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------
	  * 2014.10.28 SJH Re-Assignment by Bound(Internal Pricing) 신규화면 Retrieve 버튼적용 쿼리
	  * 2015.06.09 Supplier와 Borrow의 위치를 바꿈에서 다시 원복 테이블의 컬럼을 바꾸기로 결정
	  * </pre>
	  */
	public NetworkCostDBDAOSearchFixCostByVVDSltInterPrcListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOSearchFixCostByVVDSltInterPrcListRSQL").append("\n"); 
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
		query.append("SELECT	A.TRD_CD										AS FM_TRD_CD" ).append("\n"); 
		query.append("	,	A.RLANE_CD										AS FM_RLANE_CD" ).append("\n"); 
		query.append("	,	A.IOC_CD										AS FM_IOC_CD" ).append("\n"); 
		query.append("	,	A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD 				AS FM_VVD_CD" ).append("\n"); 
		query.append("    ,   A.TO_TRD_CD	" ).append("\n"); 
		query.append("	,	A.TO_RLANE_CD" ).append("\n"); 
		query.append("	,	A.TO_IOC_CD" ).append("\n"); 
		query.append("	,	A.TO_VSL_CD||A.TO_SKD_VOY_NO||A.TO_SKD_DIR_CD 	AS TO_VVD_CD" ).append("\n"); 
		query.append("	,	A.STND_COST_CD" ).append("\n"); 
		query.append("	,	A.CNTR_LOD_QTY" ).append("\n"); 
		query.append("	,	A.INTER_PRC_UC_AMT" ).append("\n"); 
		query.append("	,	A.INTER_PRC_TTL_EXPN_AMT" ).append("\n"); 
		query.append("	,	A.COST_CALC_RMK" ).append("\n"); 
		query.append("  FROM	COA_INTER_PRC_VVD_EXPN A" ).append("\n"); 
		query.append("  	,	COA_MON_VVD B" ).append("\n"); 
		query.append(" WHERE	A.TRD_CD	= B.TRD_CD" ).append("\n"); 
		query.append(" 	AND	A.RLANE_CD	= B.RLANE_CD" ).append("\n"); 
		query.append(" 	AND	A.IOC_CD	= B.IOC_CD" ).append("\n"); 
		query.append(" 	AND	A.VSL_CD	= B.VSL_CD" ).append("\n"); 
		query.append(" 	AND	A.SKD_VOY_NO= B.SKD_VOY_NO" ).append("\n"); 
		query.append(" 	AND	A.DIR_CD	= B.DIR_CD" ).append("\n"); 
		query.append("    AND B.DELT_FLG	= 'N'" ).append("\n"); 
		query.append("    AND A.STND_COST_CD = '54600002'		--SJH.20141104.MOD : 54600001->54600002" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("	AND B.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("	AND B.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("	AND B.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_seltrade} != '')" ).append("\n"); 
		query.append(" 	AND	A.TRD_CD	= @[f_seltrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append(" 	AND	A.RLANE_CD	= @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("	AND A.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("	AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("	AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.TRD_CD" ).append("\n"); 
		query.append("	,	A.RLANE_CD" ).append("\n"); 
		query.append("	,	A.IOC_CD" ).append("\n"); 
		query.append("	,	A.VSL_CD" ).append("\n"); 
		query.append("	,	A.SKD_VOY_NO" ).append("\n"); 
		query.append("	,	A.DIR_CD" ).append("\n"); 

	}
}