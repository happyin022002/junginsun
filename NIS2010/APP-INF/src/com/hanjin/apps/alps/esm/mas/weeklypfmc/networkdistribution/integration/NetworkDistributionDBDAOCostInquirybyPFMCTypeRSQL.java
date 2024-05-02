/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkDistributionDBDAOCostInquirybyPFMCTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.27 유제량
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Je Ryang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOCostInquirybyPFMCTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cost Inquiry by PFMC Type 의 정보를 조회한다.
	  * </pre>
	  */
	public NetworkDistributionDBDAOCostInquirybyPFMCTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd_combo",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOCostInquirybyPFMCTypeRSQL").append("\n"); 
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
		query.append("SELECT				" ).append("\n"); 
		query.append("        A.COST_YRMON                              AS COST_YRMON				" ).append("\n"); 
		query.append("       ,A.SLS_YRMON                               AS SLS_YRMON				" ).append("\n"); 
		query.append("       ,A.COST_WK                                 AS COST_WK				" ).append("\n"); 
		query.append("       ,A.TRD_CD                                  AS TRD_CD				" ).append("\n"); 
		query.append("       ,A.SUB_TRD_CD                              AS SUB_TRD_CD				" ).append("\n"); 
		query.append("       ,A.RLANE_CD                                AS RLANE_CD				" ).append("\n"); 
		query.append("       ,A.IOC_CD                                  AS IOC_CD				" ).append("\n"); 
		query.append("       ,A.VSL_CD ||A.SKD_VOY_NO||A.DIR_CD         AS REV_VVD" ).append("\n"); 
		query.append("       ,A.DIR_CD                                  AS DIR_CD				" ).append("\n"); 
		query.append("       ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = D.HUL_BND_CD) HUL_BND_CD				" ).append("\n"); 
		query.append("       ,C.COST_TP                                 AS COST_TP				" ).append("\n"); 
		query.append("       ,B.FNL_HJS_BSA_CAPA                        AS FNL_HJS_BSA_CAPA				" ).append("\n"); 
		query.append("       ,A.BKG_TTL_QTY                             AS LOAD				" ).append("\n"); 
		query.append("       ,ROUND(A.TTL_DYS,2)                        AS TTL_DYS				" ).append("\n"); 
		query.append("       ,ROUND(DECODE(B.FNL_HJS_BSA_CAPA,0,0,A.BKG_TTL_QTY/B.FNL_HJS_BSA_CAPA) * 100,2) AS LOAD_FT				" ).append("\n"); 
		query.append("       ,C.AMT_1_01                                AS AMT_1_01  --Port Expense				" ).append("\n"); 
		query.append("       ,C.AMT_1_02                                AS AMT_1_02  --Canal Transit Fee 				" ).append("\n"); 
		query.append("       ,C.AMT_1_03                                AS AMT_1_03  --Bunker				" ).append("\n"); 
		query.append("       ,C.AMT_1_04                                AS AMT_1_04  --Crew Expense				" ).append("\n"); 
		query.append("       ,C.AMT_1_05                                AS AMT_1_05  --Insurance				" ).append("\n"); 
		query.append("       ,C.AMT_1_06                                AS AMT_1_06  --Lubricant Expense				" ).append("\n"); 
		query.append("       ,C.AMT_1_07                                AS AMT_1_07  --Store Supply Expense				" ).append("\n"); 
		query.append("       ,C.AMT_1_08                                AS AMT_1_08  --Vessel M&R				" ).append("\n"); 
		query.append("       ,C.AMT_1_09                                AS AMT_1_09  --Depreciations				" ).append("\n"); 
		query.append("       ,C.AMT_1_10                                AS AMT_1_10  --Telecom Expense				" ).append("\n"); 
		query.append("       ,C.AMT_1_11                                AS AMT_1_11  --Other Operation Fixed Exp				" ).append("\n"); 
		query.append("       ,C.AMT_1_12                                AS AMT_1_12  --Time Charterage				" ).append("\n"); 
		query.append("       ,C.AMT_1_13                                AS AMT_1_13  --Space Charterage				" ).append("\n"); 
		query.append("       ,C.AMT_1_14                                AS AMT_1_14  --Vessel Interest				" ).append("\n"); 
		query.append("       ,C.AMT_1_01 + C.AMT_1_02 + C.AMT_1_03 + C.AMT_1_04 +				" ).append("\n"); 
		query.append("        C.AMT_1_05 + C.AMT_1_06 + C.AMT_1_07 + C.AMT_1_08 +				" ).append("\n"); 
		query.append("        C.AMT_1_09 + C.AMT_1_10 + C.AMT_1_11 + C.AMT_1_12 +				" ).append("\n"); 
		query.append("        C.AMT_1_13 + C.AMT_1_14                   AS OP_TOTAL				" ).append("\n"); 
		query.append("  FROM (SELECT A.TRD_CD,				" ).append("\n"); 
		query.append("               A.SUB_TRD_CD,				" ).append("\n"); 
		query.append("               A.RLANE_CD,				" ).append("\n"); 
		query.append("               A.IOC_CD,				" ).append("\n"); 
		query.append("               A.VSL_CD,				" ).append("\n"); 
		query.append("               A.SKD_VOY_NO,				" ).append("\n"); 
		query.append("               A.DIR_CD,				" ).append("\n"); 
		query.append("               A.COST_YRMON,				" ).append("\n"); 
		query.append("               A.SLS_YRMON,				" ).append("\n"); 
		query.append("               A.COST_WK,				" ).append("\n"); 
		query.append("               --A.BSA_ZR_FLG,				" ).append("\n"); 
		query.append("               NVL(MAX(A.BKG_TTL_QTY),0) AS BKG_TTL_QTY,				" ).append("\n"); 
		query.append("               NVL(SUM(A3.SEA_DYS),0) + NVL(SUM(A3.PORT_DYS),0) AS TTL_DYS				" ).append("\n"); 
		query.append("          FROM MAS_MON_VVD A,				" ).append("\n"); 
		query.append("               MAS_MON_VVD_PORT_OP_DYS A3				" ).append("\n"); 
		query.append("         WHERE 1=1				" ).append("\n"); 
		query.append("    #if (${f_seltrade} != '')				" ).append("\n"); 
		query.append("           AND A.TRD_CD = @[f_seltrade]				" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("    #if (${f_sub_trd_cd} != '')				" ).append("\n"); 
		query.append("           AND A.SUB_TRD_CD = @[f_sub_trd_cd]				" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("    #if (${f_selrlane} != '')				" ).append("\n"); 
		query.append("           AND A.RLANE_CD = @[f_selrlane]				" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("    #if (${f_dir_cd_combo} != '')				" ).append("\n"); 
		query.append("           AND A.DIR_CD = @[f_dir_cd_combo]				" ).append("\n"); 
		query.append("    #end       				" ).append("\n"); 
		query.append("    				" ).append("\n"); 
		query.append("    #if (${f_vsl_cd} != '')				" ).append("\n"); 
		query.append("           AND A.VSL_CD = @[f_vsl_cd]				" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("    #if (${f_skd_voy_no} != '')				" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[f_skd_voy_no]				" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("    #if (${f_dir_cd} != '')				" ).append("\n"); 
		query.append("           AND A.DIR_CD = @[f_dir_cd]				" ).append("\n"); 
		query.append("    #end				" ).append("\n"); 
		query.append("    #if (${f_chkprd} == 'M')				" ).append("\n"); 
		query.append("       #if (${f_year} != '')				" ).append("\n"); 
		query.append("           AND A.COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]				" ).append("\n"); 
		query.append("       #else				" ).append("\n"); 
		query.append("           AND A.COST_YRMON LIKE @[f_cost_yr] || '%'				" ).append("\n"); 
		query.append("       #end				" ).append("\n"); 
		query.append("    #elseif (${f_chkprd} == 'W')				" ).append("\n"); 
		query.append("           AND A.SLS_YRMON LIKE @[f_year]||'%'				" ).append("\n"); 
		query.append("       #if (${f_fm_wk} != '')				" ).append("\n"); 
		query.append("           AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]				" ).append("\n"); 
		query.append("       #end				" ).append("\n"); 
		query.append("    #end  				" ).append("\n"); 
		query.append("         				" ).append("\n"); 
		query.append("           --AND A.SLS_YRMON  LIKE '2015'||'%'				" ).append("\n"); 
		query.append("           --AND A.COST_WK BETWEEN '11' AND '11' 				" ).append("\n"); 
		query.append("                				" ).append("\n"); 
		query.append("           AND A.TRD_CD      = A3.TRD_CD(+)				" ).append("\n"); 
		query.append("           AND A.RLANE_CD    = A3.RLANE_CD(+)				" ).append("\n"); 
		query.append("           AND A.IOC_CD      = A3.IOC_CD(+)				" ).append("\n"); 
		query.append("           AND A.VSL_CD      = A3.VSL_CD(+)				" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO  = A3.SKD_VOY_NO(+)				" ).append("\n"); 
		query.append("           AND A.DIR_CD      = A3.DIR_CD(+)				" ).append("\n"); 
		query.append("           AND A3.NEW_OP_DYS_FLG(+) = 'Y'  				" ).append("\n"); 
		query.append("           AND A.DELT_FLG    = 'N' 				" ).append("\n"); 
		query.append("         GROUP BY A.TRD_CD,				" ).append("\n"); 
		query.append("               A.SUB_TRD_CD,				" ).append("\n"); 
		query.append("               A.RLANE_CD,				" ).append("\n"); 
		query.append("               A.IOC_CD,				" ).append("\n"); 
		query.append("               A.VSL_CD,				" ).append("\n"); 
		query.append("               A.SKD_VOY_NO,				" ).append("\n"); 
		query.append("               A.DIR_CD,				" ).append("\n"); 
		query.append("               A.COST_YRMON,				" ).append("\n"); 
		query.append("               A.SLS_YRMON,				" ).append("\n"); 
		query.append("               A.COST_WK				" ).append("\n"); 
		query.append("               --A.BSA_ZR_FLG 				" ).append("\n"); 
		query.append("        ) A				" ).append("\n"); 
		query.append("       ,BSA_VVD_MST B				" ).append("\n"); 
		query.append("       ,(SELECT  DECODE(B2.RNUM,1,'Actual','Pooling')                         AS COST_TP				" ).append("\n"); 
		query.append("                ,A1.TRD_CD                                                    AS TRD_CD				" ).append("\n"); 
		query.append("                ,A1.RLANE_CD                                                  AS RLANE_CD				" ).append("\n"); 
		query.append("                ,A1.IOC_CD                                                    AS IOC_CD				" ).append("\n"); 
		query.append("                ,A1.VSL_CD                                                    AS VSL_CD				" ).append("\n"); 
		query.append("                ,A1.SKD_VOY_NO                                                AS SKD_VOY_NO				" ).append("\n"); 
		query.append("                ,A1.DIR_CD                                                    AS DIR_CD				" ).append("\n"); 
		query.append("                ,MAX(A1.HJS_SLS_UC_QTY)                                       AS LOAD				" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'53101000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_01	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'53102000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_02	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'53200000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_03	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54100000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_04	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54250000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_05	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54300000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_06	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54200000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_07	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54150000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_08	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54450000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_09	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54180000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_10	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54550000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_11	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54350000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_12	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'54400000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_13	" ).append("\n"); 
		query.append("    			,SUM(DECODE(A1.STND_COST_CD,'72100000',DECODE(B2.RNUM,1,A1.NTWK_HIR_COST_AMT,2,A1.N4TH_NTWK_COST_AMT),0)) AS AMT_1_14	" ).append("\n"); 
		query.append("		   FROM MAS_VVD_HIR A1		" ).append("\n"); 
		query.append("				,(SELECT CPY_NO AS RNUM " ).append("\n"); 
		query.append("                    FROM COM_CPY_NO 				" ).append("\n"); 
		query.append("                   WHERE CPY_NO BETWEEN 1 AND 2				" ).append("\n"); 
		query.append("                 ) B2  				" ).append("\n"); 
		query.append("           GROUP BY DECODE(B2.RNUM,1,'Actual','Pooling')				" ).append("\n"); 
		query.append("                 ,A1.TRD_CD				" ).append("\n"); 
		query.append("                 ,A1.RLANE_CD				" ).append("\n"); 
		query.append("                 ,A1.IOC_CD				" ).append("\n"); 
		query.append("                 ,A1.VSL_CD				" ).append("\n"); 
		query.append("                 ,A1.SKD_VOY_NO				" ).append("\n"); 
		query.append("                 ,A1.DIR_CD				" ).append("\n"); 
		query.append("        ) C				" ).append("\n"); 
		query.append("        ,MAS_VSL_RGST V				" ).append("\n"); 
		query.append("		,(SELECT TRD_CD, RLANE_CD, IOC_CD, DIR_CD, HUL_BND_CD FROM MAS_LANE_RGST) D		" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append(" WHERE A.TRD_CD            = B.TRD_CD				" ).append("\n"); 
		query.append("   AND A.RLANE_CD          = B.RLANE_CD				" ).append("\n"); 
		query.append("   AND A.IOC_CD            = B.IOC_CD				" ).append("\n"); 
		query.append("   AND A.VSL_CD            = B.VSL_CD				" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO        = B.SKD_VOY_NO				" ).append("\n"); 
		query.append("   AND A.DIR_CD            = B.SKD_DIR_CD				" ).append("\n"); 
		query.append("   AND A.TRD_CD            = C.TRD_CD				" ).append("\n"); 
		query.append("   AND A.RLANE_CD          = C.RLANE_CD				" ).append("\n"); 
		query.append("   AND A.IOC_CD            = C.IOC_CD				" ).append("\n"); 
		query.append("   AND A.VSL_CD            = C.VSL_CD				" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO        = C.SKD_VOY_NO				" ).append("\n"); 
		query.append("   AND A.DIR_CD            = C.DIR_CD				" ).append("\n"); 
		query.append("   AND A.VSL_CD            = V.VSL_CD(+)				" ).append("\n"); 
		query.append("   AND V.LST_FLG(+)        = 'Y'				" ).append("\n"); 
		query.append("   AND V.DELT_FLG(+)       = 'N'				" ).append("\n"); 
		query.append("   AND A.TRD_CD            = D.TRD_CD				" ).append("\n"); 
		query.append("   AND A.RLANE_CD          = D.RLANE_CD				" ).append("\n"); 
		query.append("   AND A.IOC_CD            = D.IOC_CD				" ).append("\n"); 
		query.append("   AND A.DIR_CD            = D.DIR_CD				" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("#if (${f_hul_bnd_cd} != '')				" ).append("\n"); 
		query.append("   AND D.HUL_BND_CD = @[f_hul_bnd_cd]				" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("    				" ).append("\n"); 
		query.append(" ORDER BY A.COST_YRMON				" ).append("\n"); 
		query.append("       ,A.SLS_YRMON				" ).append("\n"); 
		query.append("       ,A.COST_WK				" ).append("\n"); 
		query.append("       ,A.TRD_CD				" ).append("\n"); 
		query.append("       ,A.SUB_TRD_CD				" ).append("\n"); 
		query.append("       ,A.RLANE_CD				" ).append("\n"); 
		query.append("       ,A.IOC_CD 				" ).append("\n"); 
		query.append("       ,A.VSL_CD 				" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO				" ).append("\n"); 
		query.append("       ,A.DIR_CD				" ).append("\n"); 
		query.append("       ,C.COST_TP" ).append("\n"); 

	}
}