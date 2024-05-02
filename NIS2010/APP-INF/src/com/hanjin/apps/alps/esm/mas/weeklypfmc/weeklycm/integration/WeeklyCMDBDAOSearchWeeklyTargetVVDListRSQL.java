/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchWeeklyTargetVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchWeeklyTargetVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History---------------------------------------------------
	  * 2011.04.18 이행지 [CHM-201110235-01] OPR 컬럼 추가(MAS_VSL_RGST.VOP_CD)
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchWeeklyTargetVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_selslane",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_seldir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchWeeklyTargetVVDListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("     DECODE(NVL(A.bsa_zr_flg,'N'),'N', '0', '1')                BSA_ZR_FLG" ).append("\n"); 
		query.append("    ,A.COST_YRMON                                               COST_YRMON" ).append("\n"); 
		query.append("    ,A.SLS_YRMON                                                SLS_YRMON" ).append("\n"); 
		query.append("    ,A.COST_WK                                                  COST_WK" ).append("\n"); 
		query.append("    ,A.TRD_CD                                                   TRD_CD" ).append("\n"); 
		query.append("    ,A.SUB_TRD_CD                                               SUB_TRD_CD" ).append("\n"); 
		query.append("    ,B.SLAN_CD                                                  SLAN_CD" ).append("\n"); 
		query.append("    ,A.RLANE_CD                                                 RLANE_CD" ).append("\n"); 
		query.append("    ,B.VSL_LANE_TP_CD                                           VSL_LANE_TP_CD" ).append("\n"); 
		query.append("    ,A.VSL_CD                                                   VSL_CD" ).append("\n"); 
		query.append("    ,A.SKD_VOY_NO                                               SKD_VOY_NO" ).append("\n"); 
		query.append("    ,A.DIR_CD                                                   DIR_CD" ).append("\n"); 
		query.append("	, (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = B.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("    ,A.IOC_CD                                                   IOC_CD" ).append("\n"); 
		query.append("    ,A.LST_LODG_PORT_CD                                         LST_LODG_PORT_CD" ).append("\n"); 
		query.append("    ,TO_CHAR( A.LST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')  LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("    ,TO_CHAR(A.N1ST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI:SS')  N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("    ,CASE WHEN A.WKY_TGT_FLG = 'Y' THEN 'YES' ELSE 'NO' END     WKY_TGT_FLG" ).append("\n"); 
		query.append("     --DECODE(A.wky_tgt_flg, 'N', 'NO', 'YES') wky_tgt_flg" ).append("\n"); 
		query.append("    ,A.WKY_MNL_FLG                                              WKY_MNL_FLG" ).append("\n"); 
		query.append("    ,DECODE(A.MON_TGT_FLG, 'N', 'NO', 'YES')                    MON_TGT_FLG" ).append("\n"); 
		query.append("    ,A.DELT_FLG                                                 DELT_FLG" ).append("\n"); 
		query.append("	,C.VOP_CD													VOP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,A.COST_WK                                                  OLD_COST_WK" ).append("\n"); 
		query.append("    ,DECODE(NVL(A.bsa_zr_flg,'N'),'N', '0', '1')                OLD_BSA_ZR_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("      , MAS_LANE_RGST B" ).append("\n"); 
		query.append("      , MAS_VSL_RGST C" ).append("\n"); 
		query.append("  WHERE A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("    AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("    AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("    AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("    AND A.VSL_CD     = C.VSL_CD(+)" ).append("\n"); 
		query.append("    AND A.N1ST_LODG_PORT_ETD_DT BETWEEN VSL_APLY_FM_DT(+) AND VSL_APLY_TO_DT(+)" ).append("\n"); 
		query.append("    #if (${f_chkdel} == '')" ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND NVL(A.DELT_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("    #if (${f_seltrade} != '')" ).append("\n"); 
		query.append("    AND A.TRD_CD = @[f_seltrade]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_selrlane} != '')" ).append("\n"); 
		query.append("    AND A.RLANE_CD = @[f_selrlane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_seldir} != '')" ).append("\n"); 
		query.append("    AND A.DIR_CD = @[f_seldir]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_selioc} != '')" ).append("\n"); 
		query.append("    AND A.IOC_CD = @[f_selioc]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_selslane} != '')" ).append("\n"); 
		query.append("    AND A.SLAN_CD = @[f_selslane]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("    AND A.VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("    AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("    AND A.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]    " ).append("\n"); 
		query.append("    #elseif(${f_chkprd} == 'W')" ).append("\n"); 
		query.append("    AND A.SLS_YRMON LIKE @[f_year] || '%'" ).append("\n"); 
		query.append("    AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} != '')" ).append("\n"); 
		query.append("    AND B.HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A.COST_YRMON" ).append("\n"); 
		query.append("        , A.COST_WK" ).append("\n"); 
		query.append("        , A.TRD_CD" ).append("\n"); 
		query.append("        , B.SUB_TRD_CD" ).append("\n"); 
		query.append("        , B.SLAN_CD" ).append("\n"); 

	}
}