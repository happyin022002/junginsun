/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OPCostDBDAOStndUtCostDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPCostDBDAOStndUtCostDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StndUtCostDtl
	  * VVD별 운항일수 보여줄수 있도록 항목 추가-20141226
	  * VSL OPREATION 보여주도록 항목 추가 - 20150105
	  * 대상항차 테이블 걸어서  BSA ZERO FLAG = 'Y'는 제외하는 로직 추가 - 20150224
	  * 2015.04.01 김시몬 일반관리비 관련 쿼리 분기
	  * </pre>
	  */
	public OPCostDBDAOStndUtCostDtlRSQL(){
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
		params.put("f_cobcost",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration").append("\n"); 
		query.append("FileName : OPCostDBDAOStndUtCostDtlRSQL").append("\n"); 
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
		query.append("          A1.COST_YRMON" ).append("\n"); 
		query.append("        , A1.COST_WK" ).append("\n"); 
		query.append("        , A1.TRD_CD" ).append("\n"); 
		query.append("        , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        , A1.RLANE_CD" ).append("\n"); 
		query.append("        , A1.DIR_CD" ).append("\n"); 
		query.append("        , A1.RLANE_CD||A1.DIR_CD AS RLANE_DIR" ).append("\n"); 
		query.append("        , A1.HUL_BND_CD" ).append("\n"); 
		query.append("        , A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD AS VVD" ).append("\n"); 
		query.append("        , TO_CHAR(TO_DATE(A1.EFF_FM_YRMON,'YYYYMM'),'YYYY-MM')||'~'||TO_CHAR(TO_DATE(A1.EFF_TO_YRMON,'YYYYMM'),'YYYY-MM') AS EFF_YRMON" ).append("\n"); 
		query.append("        , A1.TTL_AMT      --TTL cost" ).append("\n"); 
		query.append("        , TRUNC(A1.OWN_SLS_RTO,2)*100 AS OWN_SLS_RTO  --SML Sales ratio" ).append("\n"); 
		query.append("        , A1.FNL_TTL_AMT  --Final cost" ).append("\n"); 
		query.append("        , A1.TGT_LOD_QTY  --Target Load" ).append("\n"); 
		query.append("        , A1.TEU_UC_AMT   --Cost / TEU" ).append("\n"); 
		query.append("        , A1.VVD_BSA_CAPA --l/f" ).append("\n"); 
		query.append("        , A1.DHIR_AMT     --Cost/day" ).append("\n"); 
		query.append("        , A1.VSL_CD" ).append("\n"); 
		query.append("        , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("        , A1.STND_COST_CD" ).append("\n"); 
		query.append("        , A1.UPD_USR_ID" ).append("\n"); 
		query.append("        , NVL(SUM(A3.SEA_DYS),0) + NVL(SUM(A3.PORT_DYS),0) AS TTL_TZ_DYS" ).append("\n"); 
		query.append("    #if(${f_cobcost} == '65000000')  " ).append("\n"); 
		query.append("          , 'OTH' AS VSL_TP" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          , NVL(A2.VSL_TP,'OTH') AS VSL_TP" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("  FROM MAS_STND_UT_COST_DTL    A1," ).append("\n"); 
		query.append("       MAS_MON_VVD_PORT_OP_DYS A3," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               B2.VSL_CD," ).append("\n"); 
		query.append("               B2.VSL_OSHP_CD AS VSL_TP" ).append("\n"); 
		query.append("          FROM MAS_MON_VVD   B1," ).append("\n"); 
		query.append("               MAS_LANE_RGST B3," ).append("\n"); 
		query.append("               (SELECT A1.VSL_SEQ," ).append("\n"); 
		query.append("                       A1.VSL_CD," ).append("\n"); 
		query.append("                       A1.VSL_TP_CD," ).append("\n"); 
		query.append("                       A1.VSL_OSHP_CD," ).append("\n"); 
		query.append("                       A1.VOP_CD," ).append("\n"); 
		query.append("                       A1.PORT_CLSS_CAPA," ).append("\n"); 
		query.append("                       A1.VSL_CLSS_CAPA," ).append("\n"); 
		query.append("					   NVL(A1.VSL_APLY_FM_DT, A1.VSL_RETN_FM_DT)  AS FM_DT,			" ).append("\n"); 
		query.append("              		   NVL(A1.VSL_APLY_TO_DT , A1.VSL_RETN_TO_DT) AS TO_DT " ).append("\n"); 
		query.append("                  FROM MAS_VSL_RGST A1" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                   AND NVL(A1.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("               ) B2" ).append("\n"); 
		query.append("         WHERE B1.VSL_CD              = B2.VSL_CD" ).append("\n"); 
		query.append("           AND B1.COST_YRMON          = @[f_cost_yrmon]" ).append("\n"); 
		query.append("           AND B1.DELT_FLG            <> 'Y'" ).append("\n"); 
		query.append("           AND B2.VSL_TP_CD           = 'C'" ).append("\n"); 
		query.append("           AND TO_CHAR(B1.N1ST_LODG_PORT_ETD_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                       BETWEEN NVL(TO_CHAR(B2.FM_DT, 'YYYYMMDD'), '19000101')" ).append("\n"); 
		query.append("                       AND     NVL(TO_CHAR(B2.TO_DT, 'YYYYMMDD'), '99991231')" ).append("\n"); 
		query.append("		   AND B1.SUB_TRD_CD <> 'IP'" ).append("\n"); 
		query.append("		   AND B1.RLANE_CD  != 'RBCCO'" ).append("\n"); 
		query.append("		   AND B1.TRD_CD     = B3.TRD_CD" ).append("\n"); 
		query.append("           AND B1.RLANE_CD   = B3.RLANE_CD" ).append("\n"); 
		query.append("           AND B1.DIR_CD     = B3.DIR_CD" ).append("\n"); 
		query.append("           AND B1.SUB_TRD_CD = B3.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND B1.IOC_CD     = B3.IOC_CD" ).append("\n"); 
		query.append("       ) A2," ).append("\n"); 
		query.append("       MAS_MON_VVD MV " ).append("\n"); 
		query.append(" WHERE A1.COST_YRMON  = @[f_cost_yrmon]" ).append("\n"); 
		query.append("   AND A1.STND_COST_CD = @[f_cobcost] " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if(${f_cobcost} == '65000000')   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND MV.TRD_CD       = A3.TRD_CD(+)" ).append("\n"); 
		query.append("   AND MV.RLANE_CD     = A3.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND MV.VSL_CD       = A3.VSL_CD(+)" ).append("\n"); 
		query.append("   AND MV.SKD_VOY_NO   = A3.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND MV.DIR_CD       = A3.DIR_CD(+)" ).append("\n"); 
		query.append("   AND A3.NEW_OP_DYS_FLG(+) = 'Y' " ).append("\n"); 
		query.append("   AND MV.VSL_CD       = A2.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.COST_YRMON   = MV.COST_YRMON" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = MV.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = MV.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = MV.DIR_CD" ).append("\n"); 
		query.append("   AND NVL(MV.DELT_FLG,  'N')  = 'N'" ).append("\n"); 
		query.append("   AND NVL(MV.BSA_ZR_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("   AND MV.SUB_TRD_CD          != 'IP'" ).append("\n"); 
		query.append("   AND MV.RLANE_CD            != 'RBCCO'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if(${f_vsl_cd} != '')" ).append("\n"); 
		query.append("   AND A1.VSL_CD     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != '')" ).append("\n"); 
		query.append("   AND A1.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != '')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_dir_cd} != '')" ).append("\n"); 
		query.append("   AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_hul_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND A1.HUL_BND_CD = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A3.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A3.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A3.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = A3.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A3.DIR_CD(+)" ).append("\n"); 
		query.append("   AND A3.NEW_OP_DYS_FLG(+) = 'Y' " ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A2.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.COST_YRMON   = MV.COST_YRMON" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = MV.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = MV.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = MV.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = MV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = MV.DIR_CD" ).append("\n"); 
		query.append("   AND NVL(MV.DELT_FLG,  'N')  = 'N'" ).append("\n"); 
		query.append("   AND NVL(MV.BSA_ZR_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("   AND MV.SUB_TRD_CD          != 'IP'" ).append("\n"); 
		query.append("   AND MV.RLANE_CD            != 'RBCCO'   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(" GROUP BY A1.COST_YRMON" ).append("\n"); 
		query.append("        , A1.COST_WK" ).append("\n"); 
		query.append("        , A1.TRD_CD" ).append("\n"); 
		query.append("        , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        , A1.RLANE_CD" ).append("\n"); 
		query.append("        , A1.DIR_CD" ).append("\n"); 
		query.append("        , A1.HUL_BND_CD" ).append("\n"); 
		query.append("        , A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD" ).append("\n"); 
		query.append("        , TO_CHAR(TO_DATE(A1.EFF_FM_YRMON,'YYYYMM'),'YYYY-MM')||'~'||TO_CHAR(TO_DATE(A1.EFF_TO_YRMON,'YYYYMM'),'YYYY-MM')" ).append("\n"); 
		query.append("        , A1.TTL_AMT      --TTL cost" ).append("\n"); 
		query.append("        , A1.OWN_SLS_RTO  --SML Sales ratio" ).append("\n"); 
		query.append("        , A1.FNL_TTL_AMT  --Final cost" ).append("\n"); 
		query.append("        , A1.TGT_LOD_QTY  --Target Load" ).append("\n"); 
		query.append("        , A1.TEU_UC_AMT   --Cost / TEU" ).append("\n"); 
		query.append("        , A1.VVD_BSA_CAPA --l/f" ).append("\n"); 
		query.append("        , A1.DHIR_AMT     --Cost/day" ).append("\n"); 
		query.append("        , A1.VSL_CD" ).append("\n"); 
		query.append("        , A1.SKD_VOY_NO" ).append("\n"); 
		query.append("        , A1.STND_COST_CD" ).append("\n"); 
		query.append("        , A1.UPD_USR_ID" ).append("\n"); 
		query.append("    #if(${f_cobcost} == '65000000')  " ).append("\n"); 
		query.append("          , 'OTH'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("          , NVL(A2.VSL_TP,'OTH')" ).append("\n"); 
		query.append("    #end        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(" ORDER BY A1.COST_YRMON," ).append("\n"); 
		query.append("       A1.TRD_CD," ).append("\n"); 
		query.append("       A1.SUB_TRD_CD," ).append("\n"); 
		query.append("       A1.RLANE_CD," ).append("\n"); 
		query.append("       A1.DIR_CD," ).append("\n"); 
		query.append("       A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD" ).append("\n"); 

	}
}