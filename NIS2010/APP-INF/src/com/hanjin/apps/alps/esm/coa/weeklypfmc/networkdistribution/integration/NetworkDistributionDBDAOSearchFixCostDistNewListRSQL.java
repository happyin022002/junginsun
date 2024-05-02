/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkDistributionDBDAOSearchFixCostDistNewListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkDistributionDBDAOSearchFixCostDistNewListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TS Allocation 2 에서만 사용
	  * </pre>
	  */
	public NetworkDistributionDBDAOSearchFixCostDistNewListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.integration").append("\n"); 
		query.append("FileName : NetworkDistributionDBDAOSearchFixCostDistNewListRSQL").append("\n"); 
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
		query.append("-- T/S Allocation 2" ).append("\n"); 
		query.append(" SELECT M_COST_YRMON" ).append("\n"); 
		query.append("      , M_COST_WK" ).append("\n"); 
		query.append("      , M_TRD_CD" ).append("\n"); 
		query.append("      , M_RLANE_CD" ).append("\n"); 
		query.append("      , M_IOC_CD" ).append("\n"); 
		query.append("      , M_HUL_BND_CD" ).append("\n"); 
		query.append("      , M_VVD_CD" ).append("\n"); 
		query.append("      , RNUM" ).append("\n"); 
		query.append("      , DECODE(RNUM, 1, FNL_HJS_BSA_CAPA) AS FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("      , DECODE(RNUM, 1, SUM(M_TS_UC_AMT) OVER (PARTITION BY  M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD)) AS M_TS_UC_AMT" ).append("\n"); 
		query.append("      , DECODE(RNUM, 1, M_HJS_SLS_AMT) AS M_HJS_SLS_AMT" ).append("\n"); 
		query.append("      , D_COST_YRMON" ).append("\n"); 
		query.append("      , D_COST_WK" ).append("\n"); 
		query.append("      , D_TRD_CD" ).append("\n"); 
		query.append("      , DD_TRD_CD" ).append("\n"); 
		query.append("      , NVL(" ).append("\n"); 
		query.append("        (SELECT DISTINCT (BSA_CMMT_RTO) / 100" ).append("\n"); 
		query.append("           FROM COA_LANE_TS_BSA_CMMT" ).append("\n"); 
		query.append("          WHERE COST_YRMON    = M_COST_YRMON" ).append("\n"); 
		query.append("            AND FM_TRD_CD     = M_TRD_CD" ).append("\n"); 
		query.append("            AND FM_RLANE_CD   = M_RLANE_CD" ).append("\n"); 
		query.append("            AND FM_IOC_CD     = M_IOC_CD" ).append("\n"); 
		query.append("            AND FM_HUL_BND_CD = M_HUL_BND_CD" ).append("\n"); 
		query.append("            AND TO_TRD_CD     = D_TRD_CD" ).append("\n"); 
		query.append("            AND TO_HUL_BND_CD = DECODE(D_TRD_CD,'IAS','HH',D_HUL_BND_CD)" ).append("\n"); 
		query.append("        ), 0) AS D_BSA_CMMT_RTO" ).append("\n"); 
		query.append("      , D_RLANE_CD" ).append("\n"); 
		query.append("      , D_IOC_CD" ).append("\n"); 
		query.append("      , D_HUL_BND_CD" ).append("\n"); 
		query.append("      , D_VVD_CD" ).append("\n"); 
		query.append("      , D_LOCL_TS_STS_CD" ).append("\n"); 
		query.append("      , D_TS_QTY" ).append("\n"); 
		query.append("      , SUM(D_TS_QTY) OVER (PARTITION BY M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_HUL_BND_CD, M_VVD_CD) AS VVD_TTL_QTY" ).append("\n"); 
		query.append("      , D_TS_RTO" ).append("\n"); 
		query.append("      , D_FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("      , D_CMMT_QTY" ).append("\n"); 
		query.append("      , D_CMMT_BSE_COST_RTO" ).append("\n"); 
		query.append("      , D_CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("      , D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("      , SUM(M_TS_UC_AMT) OVER (PARTITION BY  M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD) * D_TS_QTY AS TO_LANE_INIT_AMT" ).append("\n"); 
		query.append("      , D_CMMT_BSE_COST_AMT - (SUM(M_TS_UC_AMT) OVER (PARTITION BY  M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD) * D_TS_QTY) AS TO_TRD_OTR_INIT_AMT" ).append("\n"); 
		query.append("      , D_CMMT_BSE_COST_AMT AS TO_INIT_TTL_AMT" ).append("\n"); 
		query.append("      , SUM(ADJ_LANE_FNL_AMT) OVER (PARTITION BY  M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD, D_TRD_CD, D_RLANE_CD, D_IOC_CD, D_VVD_CD) ADJ_LANE_FNL_AMT" ).append("\n"); 
		query.append("      , SUM(ADJ_TRD_OTR_FNL_AMT) OVER (PARTITION BY  M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD, D_TRD_CD, D_RLANE_CD, D_IOC_CD, D_VVD_CD) ADJ_TRD_OTR_FNL_AMT" ).append("\n"); 
		query.append("      , SUM(ADJ_FNL_AMT) OVER (PARTITION BY  M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD, D_TRD_CD, D_RLANE_CD, D_IOC_CD, D_VVD_CD) ADJ_FNL_AMT" ).append("\n"); 
		query.append("      , CASE WHEN SUM(D_TS_QTY) OVER (PARTITION BY M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_HUL_BND_CD, M_VVD_CD) >= FNL_HJS_BSA_CAPA " ).append("\n"); 
		query.append("                  AND FNL_HJS_BSA_CAPA > 0" ).append("\n"); 
		query.append("             THEN 'L/F > 100%' ELSE '' END AS ADJ_REMARK" ).append("\n"); 
		query.append("   FROM" ).append("\n"); 
		query.append("        (SELECT M_COST_YRMON" ).append("\n"); 
		query.append("              , M_COST_WK" ).append("\n"); 
		query.append("              , M_TRD_CD" ).append("\n"); 
		query.append("              , M_RLANE_CD" ).append("\n"); 
		query.append("              , M_IOC_CD" ).append("\n"); 
		query.append("              , M_HUL_BND_CD" ).append("\n"); 
		query.append("              , M_VVD_CD" ).append("\n"); 
		query.append("              , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("              , SUM(M_TS_UC_AMT) M_TS_UC_AMT" ).append("\n"); 
		query.append("              , ROW_NUMBER() OVER(PARTITION BY M_TRD_CD, M_RLANE_CD, M_IOC_CD, M_VVD_CD  " ).append("\n"); 
		query.append("                                  ORDER BY DECODE(SUM(M_TS_UC_AMT),0,NULL, SUM(M_TS_UC_AMT)) NULLS LAST, D_TRD_CD, D_RLANE_CD, D_VVD_CD) AS RNUM" ).append("\n"); 
		query.append("              , D_COST_YRMON" ).append("\n"); 
		query.append("              , D_COST_WK" ).append("\n"); 
		query.append("              , D_TRD_CD" ).append("\n"); 
		query.append("              , DD_TRD_CD" ).append("\n"); 
		query.append("              , D_RLANE_CD" ).append("\n"); 
		query.append("              , D_IOC_CD" ).append("\n"); 
		query.append("              , D_HUL_BND_CD" ).append("\n"); 
		query.append("              , D_VVD_CD" ).append("\n"); 
		query.append("              , D_LOCL_TS_STS_CD" ).append("\n"); 
		query.append("              , MAX(D_TS_QTY) AS D_TS_QTY" ).append("\n"); 
		query.append("              , MAX(D_TS_RTO) AS D_TS_RTO" ).append("\n"); 
		query.append("              , SUM(D_FX_COST_DTRB_AMT) AS D_FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("              , MAX(D_CMMT_QTY) AS D_CMMT_QTY" ).append("\n"); 
		query.append("              , MAX(D_CMMT_BSE_COST_RTO) AS D_CMMT_BSE_COST_RTO" ).append("\n"); 
		query.append("              , SUM(D_CMMT_BSE_COST_AMT) AS D_CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("              , SUM(D_CMMT_ADD_COST_AMT) AS D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("              , SUM(ADJ_LANE_FNL_AMT) AS ADJ_LANE_FNL_AMT" ).append("\n"); 
		query.append("              , SUM(ADJ_TRD_OTR_FNL_AMT) AS ADJ_TRD_OTR_FNL_AMT" ).append("\n"); 
		query.append("              , SUM(ADJ_FNL_AMT) AS ADJ_FNL_AMT" ).append("\n"); 
		query.append("              , MAX(M_HJS_SLS_AMT) M_HJS_SLS_AMT                      " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                 SELECT A.COST_YRMON AS M_COST_YRMON" ).append("\n"); 
		query.append("                      , A.COST_WK AS M_COST_WK" ).append("\n"); 
		query.append("                      , A.TRD_CD AS M_TRD_CD" ).append("\n"); 
		query.append("                      , A.RLANE_CD AS M_RLANE_CD" ).append("\n"); 
		query.append("                      , A.IOC_CD AS M_IOC_CD" ).append("\n"); 
		query.append("                      , E.HUL_BND_CD AS M_HUL_BND_CD" ).append("\n"); 
		query.append("                      , (A.VSL_CD || A.SKD_VOY_NO || A.DIR_CD) AS M_VVD_CD" ).append("\n"); 
		query.append("                      , NVL(B.FNL_HJS_BSA_CAPA, 0) FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if (${f_op_view} == 'OP4')" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_TS_UC_AMT, 0) AS M_TS_UC_AMT" ).append("\n"); 
		query.append("                      , D.COST_YRMON AS D_COST_YRMON" ).append("\n"); 
		query.append("                      , D.COST_WK AS D_COST_WK" ).append("\n"); 
		query.append("                      , B.TO_TRD_CD AS D_TRD_CD" ).append("\n"); 
		query.append("                      , B.TO_TRD_CD AS DD_TRD_CD" ).append("\n"); 
		query.append("                      , B.TO_RLANE_CD AS D_RLANE_CD" ).append("\n"); 
		query.append("                      , B.TO_IOC_CD AS D_IOC_CD" ).append("\n"); 
		query.append("                      , F.HUL_BND_CD AS D_HUL_BND_CD" ).append("\n"); 
		query.append("                      , B.TO_VSL_CD||B.TO_SKD_VOY_NO||B.TO_SKD_DIR_CD AS D_VVD_CD" ).append("\n"); 
		query.append("                      , B.LOCL_TS_STS_CD AS D_LOCL_TS_STS_CD                    " ).append("\n"); 
		query.append("                      , NVL(C.TS_QTY, 0) AS D_TS_QTY" ).append("\n"); 
		query.append("                      , NVL(C.TS_RTO, 0) AS D_TS_RTO" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_FX_COST_DTRB_AMT, 0) AS D_FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("                      , NVL(B.CMMT_QTY, 0) AS D_CMMT_QTY" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_CMMT_BSE_COST_RTO, 0) AS D_CMMT_BSE_COST_RTO" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_CMMT_BSE_COST_AMT, 0) AS D_CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("                      , NVL(B.N4TH_CMMT_ADD_COST_AMT, 0) AS D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("                      , NVL(B.N6TH_ADJ_LANE_FNL_AMT, 0) AS ADJ_LANE_FNL_AMT" ).append("\n"); 
		query.append("                      , NVL(B.N6TH_ADJ_OTR_FNL_AMT, 0) AS ADJ_TRD_OTR_FNL_AMT" ).append("\n"); 
		query.append("                      , NVL(B.N6TH_ADJ_FNL_AMT, 0) AS ADJ_FNL_AMT     " ).append("\n"); 
		query.append("                      , SUM(DECODE('', B.STND_COST_CD, B.N4TH_FX_COST_DTRB_AMT, '', B.N4TH_FX_COST_DTRB_AMT,0)) " ).append("\n"); 
		query.append("                                OVER (PARTITION BY A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) M_HJS_SLS_AMT" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("                      , NVL(B.TS_UC_AMT, 0) AS M_TS_UC_AMT" ).append("\n"); 
		query.append("                      , D.COST_YRMON AS D_COST_YRMON" ).append("\n"); 
		query.append("                      , D.COST_WK AS D_COST_WK" ).append("\n"); 
		query.append("                      , B.TO_TRD_CD AS D_TRD_CD" ).append("\n"); 
		query.append("                      , B.TO_TRD_CD AS DD_TRD_CD" ).append("\n"); 
		query.append("                      , B.TO_RLANE_CD AS D_RLANE_CD" ).append("\n"); 
		query.append("                      , B.TO_IOC_CD AS D_IOC_CD" ).append("\n"); 
		query.append("                      , F.HUL_BND_CD AS D_HUL_BND_CD" ).append("\n"); 
		query.append("                      , B.TO_VSL_CD||B.TO_SKD_VOY_NO||B.TO_SKD_DIR_CD AS D_VVD_CD" ).append("\n"); 
		query.append("                      , B.LOCL_TS_STS_CD AS D_LOCL_TS_STS_CD                    " ).append("\n"); 
		query.append("                      , NVL(C.TS_QTY, 0) AS D_TS_QTY" ).append("\n"); 
		query.append("                      , NVL(C.TS_RTO, 0) AS D_TS_RTO" ).append("\n"); 
		query.append("                      , NVL(B.FX_COST_DTRB_AMT, 0) AS D_FX_COST_DTRB_AMT" ).append("\n"); 
		query.append("                      , NVL(B.CMMT_QTY, 0) AS D_CMMT_QTY" ).append("\n"); 
		query.append("                      , NVL(B.CMMT_BSE_COST_RTO, 0) AS D_CMMT_BSE_COST_RTO" ).append("\n"); 
		query.append("                      , NVL(B.CMMT_BSE_COST_AMT, 0) AS D_CMMT_BSE_COST_AMT" ).append("\n"); 
		query.append("                      , NVL(B.CMMT_ADD_COST_AMT, 0) AS D_CMMT_ADD_COST_AMT" ).append("\n"); 
		query.append("                      , NVL(B.ADJ_LANE_FNL_AMT, 0) AS ADJ_LANE_FNL_AMT" ).append("\n"); 
		query.append("                      , NVL(B.ADJ_TRD_OTR_FNL_AMT, 0) AS ADJ_TRD_OTR_FNL_AMT" ).append("\n"); 
		query.append("                      , NVL(B.ADJ_FNL_AMT, 0) AS ADJ_FNL_AMT     " ).append("\n"); 
		query.append("                      , SUM(DECODE(NVL(@[f_selcost],''), B.STND_COST_CD, B.FX_COST_DTRB_AMT, '', B.FX_COST_DTRB_AMT,0)) " ).append("\n"); 
		query.append("                                OVER (PARTITION BY A.TRD_CD, A.RLANE_CD, A.IOC_CD, A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD) M_HJS_SLS_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   FROM COA_MON_VVD A" ).append("\n"); 
		query.append("                      , COA_FX_AMT_DTRB B" ).append("\n"); 
		query.append("                      , COA_LANE_TS_QTY C" ).append("\n"); 
		query.append("                      , COA_MON_VVD D" ).append("\n"); 
		query.append("                      , COA_LANE_RGST E" ).append("\n"); 
		query.append("                      , COA_LANE_RGST F" ).append("\n"); 
		query.append("                  WHERE A.TRD_CD             = B.FM_TRD_CD" ).append("\n"); 
		query.append("                    AND A.RLANE_CD           = B.FM_RLANE_CD" ).append("\n"); 
		query.append("                    AND A.IOC_CD             = B.FM_IOC_CD" ).append("\n"); 
		query.append("                    AND A.VSL_CD             = B.FM_VSL_CD" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO         = B.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND A.DIR_CD             = B.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND B.FM_TRD_CD          = C.FM_TRD_CD" ).append("\n"); 
		query.append("                    AND B.FM_RLANE_CD        = C.FM_RLANE_CD" ).append("\n"); 
		query.append("                    AND B.FM_IOC_CD          = C.FM_IOC_CD" ).append("\n"); 
		query.append("                    AND B.FM_VSL_CD          = C.FM_VSL_CD" ).append("\n"); 
		query.append("                    AND B.FM_SKD_VOY_NO      = C.FM_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND B.FM_SKD_DIR_CD      = C.FM_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND B.TO_TRD_CD          = C.TO_TRD_CD" ).append("\n"); 
		query.append("                    AND B.TO_RLANE_CD        = C.TO_RLANE_CD" ).append("\n"); 
		query.append("                    AND B.TO_IOC_CD          = C.TO_IOC_CD" ).append("\n"); 
		query.append("                    AND B.TO_VSL_CD          = C.TO_VSL_CD" ).append("\n"); 
		query.append("                    AND B.TO_SKD_VOY_NO      = C.TO_SKD_VOY_NO" ).append("\n"); 
		query.append("                    AND B.TO_SKD_DIR_CD      = C.TO_SKD_DIR_CD" ).append("\n"); 
		query.append("                    AND B.TO_TRD_CD          = D.TRD_CD(+)" ).append("\n"); 
		query.append("                    AND B.TO_RLANE_CD        = D.RLANE_CD(+)" ).append("\n"); 
		query.append("                    AND B.TO_IOC_CD          = D.IOC_CD(+)" ).append("\n"); 
		query.append("                    AND B.TO_VSL_CD          = D.VSL_CD(+)" ).append("\n"); 
		query.append("                    AND B.TO_SKD_VOY_NO      = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    AND B.TO_SKD_DIR_CD      = D.DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A.RLANE_CD           = E.RLANE_CD" ).append("\n"); 
		query.append("                    AND A.DIR_CD             = E.DIR_CD" ).append("\n"); 
		query.append("                    AND A.TRD_CD             = E.TRD_CD" ).append("\n"); 
		query.append("                    AND A.IOC_CD             = E.IOC_CD" ).append("\n"); 
		query.append("                    AND D.RLANE_CD           = F.RLANE_CD(+)" ).append("\n"); 
		query.append("                    AND D.DIR_CD             = F.DIR_CD(+)" ).append("\n"); 
		query.append("                    AND D.TRD_CD             = F.TRD_CD(+)" ).append("\n"); 
		query.append("                    AND D.IOC_CD             = F.IOC_CD(+)" ).append("\n"); 
		query.append("                    AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${f_seltrade} != '')" ).append("\n"); 
		query.append("                    AND A.TRD_CD 	= @[f_seltrade]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${f_selrlane} != '')" ).append("\n"); 
		query.append("                    AND A.RLANE_CD 	= @[f_selrlane]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${f_selioc} != '')" ).append("\n"); 
		query.append("                    AND A.IOC_CD 	= @[f_selioc]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("                    AND A.VSL_CD 	= @[f_vsl_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("                    AND A.SKD_VOY_NO = @[f_skd_voy_no]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${f_dir_cd} != '')" ).append("\n"); 
		query.append("                    AND A.DIR_CD 	= @[f_dir_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${f_selcost} != '')" ).append("\n"); 
		query.append("                    AND B.STND_COST_CD = @[f_selcost]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("				#if (${f_chkprd} == 'M')" ).append("\n"); 
		query.append("		    		#if (${f_fm_mon} != '')" ).append("\n"); 
		query.append("                    AND A.COST_YRMON BETWEEN @[f_year] || @[f_fm_mon] AND @[f_year] || @[f_to_mon]" ).append("\n"); 
		query.append("		    		#else" ).append("\n"); 
		query.append("                    AND A.COST_YRMON like @[f_year] || '%'" ).append("\n"); 
		query.append("		    		#end" ).append("\n"); 
		query.append("				#elseif (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("                    AND A.SLS_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("		    		#if (${f_fm_wk} != '')" ).append("\n"); 
		query.append("                    AND A.COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("		    		#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    AND NVL(DTRB_STEP_CD, 'BZC') = 'CMT'" ).append("\n"); 
		query.append("                    AND STND_COST_CD NOT IN ('43102011', '54600000' )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("       GROUP BY M_COST_YRMON" ).append("\n"); 
		query.append("              , M_COST_WK" ).append("\n"); 
		query.append("              , M_TRD_CD" ).append("\n"); 
		query.append("              , M_RLANE_CD" ).append("\n"); 
		query.append("              , M_IOC_CD" ).append("\n"); 
		query.append("              , M_HUL_BND_CD" ).append("\n"); 
		query.append("              , M_VVD_CD" ).append("\n"); 
		query.append("              , FNL_HJS_BSA_CAPA" ).append("\n"); 
		query.append("              , D_COST_YRMON" ).append("\n"); 
		query.append("              , D_COST_WK" ).append("\n"); 
		query.append("              , D_TRD_CD" ).append("\n"); 
		query.append("              , DD_TRD_CD" ).append("\n"); 
		query.append("              , D_RLANE_CD" ).append("\n"); 
		query.append("              , D_IOC_CD" ).append("\n"); 
		query.append("              , D_HUL_BND_CD" ).append("\n"); 
		query.append("              , D_VVD_CD" ).append("\n"); 
		query.append("              , D_LOCL_TS_STS_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY M_TRD_CD" ).append("\n"); 
		query.append("      , M_RLANE_CD" ).append("\n"); 
		query.append("      , M_IOC_CD" ).append("\n"); 
		query.append("      , M_HUL_BND_CD" ).append("\n"); 
		query.append("      , M_VVD_CD" ).append("\n"); 
		query.append("      , RNUM" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}