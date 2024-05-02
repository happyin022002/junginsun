/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OPCostDBDAOStndUtCostDtlPopRSQL.java
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

public class OPCostDBDAOStndUtCostDtlPopRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_MAS_0317(ESM_MAS_0315의 Popup) Creation 직후 Popup을 조회해 온다.
	  * 2015.02.23-김시몬- TGT_LOD_QTY 가 0 인경우도 보여지도록 수정
	  * 2015.02.24-김시몬- 대상항차 테이블 걸어서  BSA ZERO FLAG = 'Y'는 제외하는 로직 추가
	  * </pre>
	  */
	public OPCostDBDAOStndUtCostDtlPopRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_yearweek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.opcost.integration").append("\n"); 
		query.append("FileName : OPCostDBDAOStndUtCostDtlPopRSQL").append("\n"); 
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
		query.append("        , A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD AS VVD" ).append("\n"); 
		query.append("        , NVL(A1.TGT_LOD_QTY,0) AS TGT_LOD_QTY" ).append("\n"); 
		query.append("        , NVL(A1.TEU_UC_AMT,0)  AS TEU_UC_AMT" ).append("\n"); 
		query.append("        , A1.STND_COST_CD" ).append("\n"); 
		query.append("        , C1.STND_COST_NM" ).append("\n"); 
		query.append("  FROM MAS_STND_UT_COST_DTL    A1," ).append("\n"); 
		query.append("       MAS_STND_ACCT           C1," ).append("\n"); 
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
		query.append("                   AND DECODE(@[f_cobcost],'65000000',A1.VOP_CD,'54400000','OTH','SML') = A1.VOP_CD" ).append("\n"); 
		query.append("                   AND NVL(A1.VSL_OSHP_CD,'OTH') IN (DECODE(@[f_cobcost],'54350009','CHT','54250009','CHT','54150009','CHT','54200009','CHT','54350000','CHT'" ).append("\n"); 
		query.append("                                                                      ,'54400000',NVL(A1.VSL_OSHP_CD,'OTH'),' ')," ).append("\n"); 
		query.append("                                                     DECODE(@[f_cobcost],'54100000','OWN','54150000','OWN','54180000','OWN','54250000','OWN'" ).append("\n"); 
		query.append("                                                                      ,'54300000','OWN','54550000','OWN','54200000','OWN','54300000','OWN','54450000','OWN'" ).append("\n"); 
		query.append("                                                                      ,'72100000','OWN',' '),                                     " ).append("\n"); 
		query.append("                                                     DECODE(@[f_cobcost],'53200000',NVL(A1.VSL_OSHP_CD,'OTH'),'53101000',NVL(A1.VSL_OSHP_CD,'OTH')" ).append("\n"); 
		query.append("                                                                      ,'53102000',NVL(A1.VSL_OSHP_CD,'OTH'),'53200000',NVL(A1.VSL_OSHP_CD,'OTH')" ).append("\n"); 
		query.append("                                                                      ,'65000000',NVL(A1.VSL_OSHP_CD,'OTH'),' ')" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("               ) B2" ).append("\n"); 
		query.append("         WHERE B1.VSL_CD              = B2.VSL_CD" ).append("\n"); 
		query.append("           AND B1.COST_YRMON          = @[f_yearweek]" ).append("\n"); 
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
		query.append("           AND NVL(B1.BSA_ZR_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("       ) A2," ).append("\n"); 
		query.append("       MAS_MON_VVD MV" ).append("\n"); 
		query.append(" WHERE A1.COST_YRMON   = @[f_yearweek]" ).append("\n"); 
		query.append("   AND A1.STND_COST_CD = @[f_cobcost] " ).append("\n"); 
		query.append("   AND A1.VSL_CD       = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.STND_COST_CD = C1.STND_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.COST_YRMON   = MV.COST_YRMON" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = MV.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = MV.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.VSL_CD       = MV.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO   = MV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = MV.DIR_CD" ).append("\n"); 
		query.append("   AND NVL(MV.DELT_FLG,  'N')  = 'N'" ).append("\n"); 
		query.append("   AND NVL(MV.BSA_ZR_FLG,'N') != 'Y'" ).append("\n"); 
		query.append("   AND MV.SUB_TRD_CD          != 'IP'" ).append("\n"); 
		query.append("   AND MV.RLANE_CD            != 'RBCCO'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND (NVL(A1.TEU_UC_AMT,0) = 0 OR NVL(A1.TGT_LOD_QTY,0) = 0)" ).append("\n"); 
		query.append(" ORDER BY A1.COST_YRMON" ).append("\n"); 
		query.append("        , A1.COST_WK" ).append("\n"); 
		query.append("        , A1.TRD_CD" ).append("\n"); 
		query.append("        , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("        , A1.RLANE_CD" ).append("\n"); 
		query.append("        , A1.DIR_CD" ).append("\n"); 
		query.append("        , A1.VSL_CD||A1.SKD_VOY_NO||A1.DIR_CD" ).append("\n"); 

	}
}