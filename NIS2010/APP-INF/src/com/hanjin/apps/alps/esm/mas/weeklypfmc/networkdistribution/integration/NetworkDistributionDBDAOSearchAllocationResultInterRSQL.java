/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchAllocationResultInterRSQL.java
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

public class NetworkDistributionDBDAOSearchAllocationResultInterRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------
	  * 2010.10.22 이행지 [CHM-201006375-01][MAS] Trunk IPC와 Ocean간 내부거래 신규 추가 
	  *                                                        - Allocation Result( Internal Pricing) 화면 Retrieve버튼적용 쿼리
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchAllocationResultInterRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchAllocationResultInterRSQL").append("\n"); 
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
		query.append("SELECT	FX.FM_TRD_CD" ).append("\n"); 
		query.append("	,   FX.FM_IOC_CD" ).append("\n"); 
		query.append("	,   FX.FM_RLANE_CD" ).append("\n"); 
		query.append("	,   FX.FM_VSL_CD" ).append("\n"); 
		query.append("	,	FX.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("	,   FX.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("	,   FX.FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("	,   FX.TO_TRD_CD" ).append("\n"); 
		query.append("	,   FX.TO_IOC_CD" ).append("\n"); 
		query.append("	,   FX.TO_RLANE_CD" ).append("\n"); 
		query.append("	,   FX.TO_VSL_CD" ).append("\n"); 
		query.append("	,   FX.TO_SKD_VOY_NO" ).append("\n"); 
		query.append("	,   FX.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("	,   FX.FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("  FROM	MAS_MON_VVD        HD" ).append("\n"); 
		query.append("    ,   MAS_FX_AMT_DTRB    FX" ).append("\n"); 
		query.append(" WHERE  HD.TRD_CD          = FX.FM_TRD_CD" ).append("\n"); 
		query.append("   AND  HD.RLANE_CD        = FX.FM_RLANE_CD" ).append("\n"); 
		query.append("   AND  HD.IOC_CD          = FX.FM_IOC_CD" ).append("\n"); 
		query.append("   AND  HD.VSL_CD          = FX.FM_VSL_CD" ).append("\n"); 
		query.append("   AND  HD.SKD_VOY_NO      = FX.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("   AND  HD.DIR_CD          = FX.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("   AND  FX.STND_COST_CD    = '54600000'" ).append("\n"); 
		query.append("   AND  NVL(FX.DTRB_STEP_CD,'BZC') = 'BZC'" ).append("\n"); 
		query.append("   AND  HD.DELT_FLG		   = 'N'" ).append("\n"); 
		query.append("#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("   AND HD.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]" ).append("\n"); 
		query.append("#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("   AND HD.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("   AND HD.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("   AND	HD.TRD_CD	= @[f_seltrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("   AND	HD.RLANE_CD	= @[f_selrlane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND HD.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("   AND HD.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND HD.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}