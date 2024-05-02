/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOSearchFixCostByVVDInterPrcListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.06 
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

public class NetworkCostDBDAOSearchFixCostByVVDInterPrcListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------
	  * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
	  *                                                        - Re-Assignment by Bound(Internal Pricing) 화면 Retrieve 버튼적용 쿼리
	  * </pre>
	  */
	public NetworkCostDBDAOSearchFixCostByVVDInterPrcListRSQL(){
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
		query.append("FileName : NetworkCostDBDAOSearchFixCostByVVDInterPrcListRSQL").append("\n"); 
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
		query.append("SELECT	A.TRD_CD" ).append("\n"); 
		query.append("	,	A.RLANE_CD" ).append("\n"); 
		query.append("	,	A.IOC_CD" ).append("\n"); 
		query.append("	,	A.VSL_CD" ).append("\n"); 
		query.append("	,	A.SKD_VOY_NO" ).append("\n"); 
		query.append("	,	A.DIR_CD" ).append("\n"); 
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
		query.append("    AND A.STND_COST_CD = '54600000' 		--SJH.20141106.ADD" ).append("\n"); 
		query.append("    AND B.DELT_FLG	= 'N'" ).append("\n"); 
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