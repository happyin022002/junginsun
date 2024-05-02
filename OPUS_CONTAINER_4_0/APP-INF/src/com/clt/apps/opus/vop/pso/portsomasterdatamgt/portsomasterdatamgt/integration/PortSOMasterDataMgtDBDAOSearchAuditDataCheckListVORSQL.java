/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박 vessel 조회
	  * </pre>
	  */
	public PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",200";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDBDAOSearchAuditDataCheckListVORSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append(" Object 목록" ).append("\n"); 
		query.append(" GRS_RGST_TONG_WGT          - GRT                   : GRT(28), GRT1(73), GRT2(74)" ).append("\n"); 
		query.append(" NET_RGST_TONG_WGT          - NRT                   : NRT(29), NRT1(87), NRT2(151)" ).append("\n"); 
		query.append(" CNTR_DZN_CAPA              - Design Capacity       : Design Capacity(63)" ).append("\n"); 
		query.append(" LOA_LEN                    - LOA                   : LOA(F)(30), LOA(M)(31), LOA 1(M)(81), LOA 2(M)(82), LOA 3(M)(83), Ship Unit 1(99), Block Size 1(118), " ).append("\n"); 
		query.append("                                                      Vessel Volume(FR)(131), Vessel Volume(CI)(134), LOA*BM(135), IB(TON)/VV(FR)(161), OB(TON)/VV(FR)(162), Vessel Volume(FR)1(164), Vessel Volume(FR)2(165)" ).append("\n"); 
		query.append(" DWT_WGT                    - DWT                   : DWT(64)" ).append("\n"); 
		query.append(" MADN_VOY_SUZ_NET_TONG_WGT  - Suez Net Tonnage(SCNT): SCNT(38), SCNT2(98)" ).append("\n"); 
		query.append(" SUZ_GT_WGT                 - Suez Gross Ton(SCGT)  : SCGT(163)" ).append("\n"); 
		query.append(" CNTR_PNM_CAPA              - Panama Allowance TEU  : Allowance TEU(1)" ).append("\n"); 
		query.append(" VSL_WDT                    - BM                    : Ship Unit(39), Ship Unit 1(99), Block Size 1(118), Vessel Volume(FR)(131), Vessel Volume(CI)(134), LOA*BM(135), IB(TON)/VV(FR)(161), OB(TON)/VV(FR)(162), Vessel Volume(FR)1(164), Vessel Volume(FR)2(165)" ).append("\n"); 
		query.append(" SMR_DRFT_HGT               - Summer Draft          : Summer Draft(F)(100), Summer Draft(M)(101), Block Size 1(118), Vessel Volume(CI)(134)" ).append("\n"); 
		query.append(" VSL_RGST_CNT_CD            - Flag                  : Nationality of VSL Origin(35)" ).append("\n"); 
		query.append(" VSL_OWN_IND_CD             - Ownership             : Ownership(122)" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH V_CHK_OBJ AS (" ).append("\n"); 
		query.append("    /*Default Check Object : REGEXP_LIKE or 검색 인자로 만듬.*/" ).append("\n"); 
		query.append("    SELECT 28   CHK_OBJ, 'CHK_GRT'  CHK_TP_CD FROM DUAL UNION ALL /*GRS_RGST_TONG_WGT : GRT(28)*/" ).append("\n"); 
		query.append("    SELECT 73   CHK_OBJ, 'CHK_GRT'  CHK_TP_CD FROM DUAL UNION ALL /*GRS_RGST_TONG_WGT : GRT1(73)*/" ).append("\n"); 
		query.append("    SELECT 74   CHK_OBJ, 'CHK_GRT'  CHK_TP_CD FROM DUAL UNION ALL /*GRS_RGST_TONG_WGT : GRT2(74)*/" ).append("\n"); 
		query.append("    SELECT 29   CHK_OBJ, 'CHK_NRT'  CHK_TP_CD FROM DUAL UNION ALL /*NET_RGST_TONG_WGT : NRT(29)*/" ).append("\n"); 
		query.append("    SELECT 87   CHK_OBJ, 'CHK_NRT'  CHK_TP_CD FROM DUAL UNION ALL /*NET_RGST_TONG_WGT : NRT1(87)*/" ).append("\n"); 
		query.append("    SELECT 151  CHK_OBJ, 'CHK_NRT'  CHK_TP_CD FROM DUAL UNION ALL /*NET_RGST_TONG_WGT : NRT2(151)*/" ).append("\n"); 
		query.append("    SELECT 63   CHK_OBJ, 'CHK_DCP'  CHK_TP_CD FROM DUAL UNION ALL /*CNTR_DZN_CAPA : Design Capacity(63)*/    " ).append("\n"); 
		query.append("    SELECT 30   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : LOA(F)(30)*/" ).append("\n"); 
		query.append("    SELECT 31   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : LOA(M)(31)*/" ).append("\n"); 
		query.append("    SELECT 81   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : LOA 1(M)(81)*/" ).append("\n"); 
		query.append("    SELECT 82   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : LOA 2(M)(82)*/" ).append("\n"); 
		query.append("    SELECT 83   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : LOA 3(M)(83)*/" ).append("\n"); 
		query.append("    SELECT 39   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Ship Unit(39)*/" ).append("\n"); 
		query.append("    SELECT 99   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Ship Unit 1(99)*/" ).append("\n"); 
		query.append("    SELECT 16   CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Block Size(16)*/" ).append("\n"); 
		query.append("    SELECT 118  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Block Size 1(118)*/" ).append("\n"); 
		query.append("    SELECT 131  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Vessel Volume(FR)(131)*/" ).append("\n"); 
		query.append("    SELECT 134  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Vessel Volume(CI)(134)*/" ).append("\n"); 
		query.append("    SELECT 135  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : LOA*BM(135)*/" ).append("\n"); 
		query.append("    SELECT 161  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : IB(TON)/VV(FR)(161)*/" ).append("\n"); 
		query.append("    SELECT 162  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : OB(TON)/VV(FR)(162)*/" ).append("\n"); 
		query.append("    SELECT 164  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Vessel Volume(FR)1(164)*/" ).append("\n"); 
		query.append("    SELECT 165  CHK_OBJ, 'CHK_LOA'  CHK_TP_CD FROM DUAL UNION ALL /*LOA_LEN : Vessel Volume(FR)2(165)*/" ).append("\n"); 
		query.append("    SELECT 64   CHK_OBJ, 'CHK_DWT'  CHK_TP_CD FROM DUAL UNION ALL /*DWT_WGT : DWT(64)*/" ).append("\n"); 
		query.append("    SELECT 38   CHK_OBJ, 'CHK_SCNT' CHK_TP_CD FROM DUAL UNION ALL /*MADN_VOY_SUZ_NET_TONG_WGT : SCNT(38)*/" ).append("\n"); 
		query.append("    SELECT 98   CHK_OBJ, 'CHK_SCNT' CHK_TP_CD FROM DUAL UNION ALL /*MADN_VOY_SUZ_NET_TONG_WGT : SCNT2(98)*/" ).append("\n"); 
		query.append("    SELECT 163  CHK_OBJ, 'CHK_SCGT' CHK_TP_CD FROM DUAL UNION ALL /*SUZ_GT_WGT : SCGT(163)*/" ).append("\n"); 
		query.append("    SELECT 1    CHK_OBJ, 'CHK_ALLT' CHK_TP_CD FROM DUAL UNION ALL /*CNTR_PNM_CAPA : Allowance TEU(1)*/" ).append("\n"); 
		query.append("    SELECT 39   CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Ship Unit(39)*/" ).append("\n"); 
		query.append("    SELECT 99   CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Ship Unit 1(99)*/" ).append("\n"); 
		query.append("    SELECT 16   CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Block Size(16)*/" ).append("\n"); 
		query.append("    SELECT 118  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Block Size 1(118)*/" ).append("\n"); 
		query.append("    SELECT 131  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Vessel Volume(FR)(131)*/" ).append("\n"); 
		query.append("    SELECT 134  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Vessel Volume(CI)(134)*/" ).append("\n"); 
		query.append("    SELECT 135  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : LOA*BM(135)*/" ).append("\n"); 
		query.append("    SELECT 161  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : IB(TON)/VV(FR)(161)*/" ).append("\n"); 
		query.append("    SELECT 162  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : OB(TON)/VV(FR)(162)*/" ).append("\n"); 
		query.append("    SELECT 164  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Vessel Volume(FR)1(164)*/" ).append("\n"); 
		query.append("    SELECT 165  CHK_OBJ, 'CHK_BM'   CHK_TP_CD FROM DUAL UNION ALL /*VSL_WDT : Vessel Volume(FR)2(165)*/" ).append("\n"); 
		query.append("    SELECT 100  CHK_OBJ, 'CHK_SDRT' CHK_TP_CD FROM DUAL UNION ALL /*SMR_DRFT_HGT : Summer Draft(F)(100)*/" ).append("\n"); 
		query.append("    SELECT 101  CHK_OBJ, 'CHK_SDRT' CHK_TP_CD FROM DUAL UNION ALL /*SMR_DRFT_HGT : Summer Draft(M)(101)*/" ).append("\n"); 
		query.append("    SELECT 16   CHK_OBJ, 'CHK_SDRT' CHK_TP_CD FROM DUAL UNION ALL /*SMR_DRFT_HGT : Block Size(16)*/" ).append("\n"); 
		query.append("    SELECT 118  CHK_OBJ, 'CHK_SDRT' CHK_TP_CD FROM DUAL UNION ALL /*SMR_DRFT_HGT : Block Size 1(118)*/" ).append("\n"); 
		query.append("    SELECT 134  CHK_OBJ, 'CHK_SDRT' CHK_TP_CD FROM DUAL UNION ALL /*SMR_DRFT_HGT : Vessel Volume(CI)(134)*/" ).append("\n"); 
		query.append("    SELECT 35   CHK_OBJ, 'CHK_FLAG' CHK_TP_CD FROM DUAL UNION ALL /*VSL_RGST_CNT_CD : Nationality of VSL Origin(35)*/" ).append("\n"); 
		query.append("    SELECT 122  CHK_OBJ, 'CHK_OWNE' CHK_TP_CD FROM DUAL           /*VSL_OWN_IND_CD : Ownership(122)*/" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("--    SELECT '28|73|74'                                               AS CHK_GRT" ).append("\n"); 
		query.append("--         , '29|87|151'                                              AS CHK_NRT" ).append("\n"); 
		query.append("--         , '63'                                                     AS CHK_DESING_CAPACITY" ).append("\n"); 
		query.append("--         , '30|31|81|82|83|99|118|131|134|135|161|162|164|165'      AS CHK_LOA" ).append("\n"); 
		query.append("--         , '64'                                                     AS CHK_DWT" ).append("\n"); 
		query.append("--         , '38|98'                                                  AS CHK_SCNT" ).append("\n"); 
		query.append("--         , '163'                                                    AS CHK_SCGT" ).append("\n"); 
		query.append("--         , '1'                                                      AS CHK_ALLOWANCE_TEU" ).append("\n"); 
		query.append("--         , '39|99|118|131|134|135|161|162|164|165'                  AS CHK_BM" ).append("\n"); 
		query.append("--         , '100|101|118|134'                                        AS CHK_SUMMER_DRAFT" ).append("\n"); 
		query.append("--         , '35'                                                     AS CHK_FLAG" ).append("\n"); 
		query.append("--         , '122'                                                    AS CHK_OWNERSHIP" ).append("\n"); 
		query.append("--      FROM DUAL" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" , V_VSL_PORT_SKD AS (" ).append("\n"); 
		query.append("    /*VSK_VSL_PORT_SKD의 VSL_CD, YD_CD*/" ).append("\n"); 
		query.append("    SELECT DISTINCT VSL_CD" ).append("\n"); 
		query.append("         , YD_CD " ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("         , MDM_VSL_SVC_LANE T2" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       AND T1.VPS_ETD_DT  BETWEEN TO_DATE(REPLACE(@[from_date],'-'), 'YYYYMM') AND LAST_DAY(TO_DATE(REPLACE(@[to_date],'-'), 'YYYYMM'))  + 0.99999" ).append("\n"); 
		query.append("       AND T1.SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("       AND T2.DELT_FLG = 'N'   " ).append("\n"); 
		query.append("       AND NVL(T1.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("       AND NVL(T1.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append(" , V_YD_CHG AS (" ).append("\n"); 
		query.append("    /*PSO_YD_CHG의 최종 사용 되는 데이타*/" ).append("\n"); 
		query.append("    SELECT DISTINCT V.VSL_CD" ).append("\n"); 
		query.append("         , A.YD_CD" ).append("\n"); 
		query.append("         , D.FOML_NO" ).append("\n"); 
		query.append("      FROM (SELECT A.YD_CD" ).append("\n"); 
		query.append("                 , A.YD_CHG_NO" ).append("\n"); 
		query.append("                 , MAX(A.YD_CHG_VER_SEQ) AS YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("              FROM PSO_YD_CHG A" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND A.EFF_DT     <= TO_DATE(REPLACE(@[from_date],'-'), 'YYYYMM')" ).append("\n"); 
		query.append("               AND A.EXP_DT     >= LAST_DAY(TO_DATE(REPLACE(@[to_date],'-'), 'YYYYMM'))  + 0.99999" ).append("\n"); 
		query.append("             GROUP BY A.YD_CD, A.YD_CHG_NO  ) A" ).append("\n"); 
		query.append("         , PSO_YD_CHG_XPR B" ).append("\n"); 
		query.append("         , PSO_CHG_XPR C" ).append("\n"); 
		query.append("         , PSO_CHG_XPR_DTL D" ).append("\n"); 
		query.append("         , V_VSL_PORT_SKD V /*SKD 에 걸린 YD 정보 조회.*/" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND A.YD_CHG_NO      = B.YD_CHG_NO" ).append("\n"); 
		query.append("       AND A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("       AND C.CHG_XPR_NO     = B.CHG_XPR_NO" ).append("\n"); 
		query.append("       AND C.CHG_XPR_NO     = D.CHG_XPR_NO " ).append("\n"); 
		query.append("       AND A.YD_CD          = V.YD_CD         " ).append("\n"); 
		query.append("   ORDER BY  V.VSL_CD, A.YD_CD      " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_YD_CHG; -- 327" ).append("\n"); 
		query.append(" , V_VSL_CHK_OBJ AS (" ).append("\n"); 
		query.append("    SELECT O.VSL_CD" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_GRT)            ,0,'N','Y') AS CHK_GRT_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_NRT)            ,0,'N','Y') AS CHK_NRT_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_DESING_CAPACITY),0,'N','Y') AS CHK_DESING_CAPACITY_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_LOA)            ,0,'N','Y') AS CHK_LOA_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_DWT)            ,0,'N','Y') AS CHK_DWT_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_SCNT)           ,0,'N','Y') AS CHK_SCNT_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_SCGT)           ,0,'N','Y') AS CHK_SCGT_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_ALLOWANCE_TEU)  ,0,'N','Y') AS CHK_ALLOWANCE_TEU_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_BM)             ,0,'N','Y') AS CHK_BM_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_SUMMER_DRAFT)   ,0,'N','Y') AS CHK_SUMMER_DRAFT_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_FLAG)           ,0,'N','Y') AS CHK_FLAG_YN" ).append("\n"); 
		query.append("         , DECODE(SUM(O.CHK_OWNERSHIP)      ,0,'N','Y') AS CHK_OWNERSHIP_YN" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT O.VSL_CD" ).append("\n"); 
		query.append("                 , O.OBJ_LIST_NO" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_GRT'  AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_GRT" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_NRT'  AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_NRT" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_DCP'  AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_DESING_CAPACITY" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_LOA'  AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_LOA" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_DWT'  AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_DWT" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_SCNT' AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_SCNT" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_SCGT' AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_SCGT" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_ALLT' AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_ALLOWANCE_TEU" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_BM'   AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_BM" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_SDRT' AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_SUMMER_DRAFT" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_FLAG' AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_FLAG" ).append("\n"); 
		query.append("                 , (SELECT COUNT(*) FROM V_CHK_OBJ V WHERE V.CHK_TP_CD = 'CHK_OWNE' AND V.CHK_OBJ = O.OBJ_LIST_NO ) AS CHK_OWNERSHIP" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT DISTINCT P.VSL_CD" ).append("\n"); 
		query.append("                         , DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) OBJ_LIST_NO" ).append("\n"); 
		query.append("                      FROM (SELECT A.VSL_CD" ).append("\n"); 
		query.append("                                 , BB.OBJ_LIST_NO" ).append("\n"); 
		query.append("                                 , BB.RT_OBJ_LIST_NO" ).append("\n"); 
		query.append("                              FROM V_YD_CHG A" ).append("\n"); 
		query.append("                                 , PSO_FORMULA B" ).append("\n"); 
		query.append("                                 , PSO_FOML_DTL BB" ).append("\n"); 
		query.append("                             WHERE 1 = 1" ).append("\n"); 
		query.append("                               AND A.FOML_NO = B.FOML_NO" ).append("\n"); 
		query.append("                               AND B.FOML_NO = BB.FOML_NO" ).append("\n"); 
		query.append("                               AND (BB.OBJ_LIST_NO IS NOT NULL OR BB.RT_OBJ_LIST_NO IS NOT NULL) ) P" ).append("\n"); 
		query.append("                         ,(SELECT LEVEL RNUM FROM DUAL CONNECT BY LEVEL <= 2 ) Q" ).append("\n"); 
		query.append("                     WHERE DECODE(Q.RNUM, 1, P.OBJ_LIST_NO, P.RT_OBJ_LIST_NO) IS NOT NULL" ).append("\n"); 
		query.append("                   ) O   " ).append("\n"); 
		query.append("           ) O" ).append("\n"); 
		query.append("     GROUP BY O.VSL_CD  " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_VSL_CHK_OBJ;    " ).append("\n"); 
		query.append(" , V_MDM_VSL_CNTR AS (" ).append("\n"); 
		query.append("    SELECT /*+PUSH_SUBQ */       " ).append("\n"); 
		query.append("           M.VSL_CD     -- Vessel Code" ).append("\n"); 
		query.append("         , M.VSL_ENG_NM           -- Vessel Name" ).append("\n"); 
		query.append("         , DECODE ( M.GRS_RGST_TONG_WGT         , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.GRS_RGST_TONG_WGT         , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS GRS_RGST_TONG_WGT  -- GRT" ).append("\n"); 
		query.append("         , DECODE ( M.NET_RGST_TONG_WGT         , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.NET_RGST_TONG_WGT         , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS NET_RGST_TONG_WGT  -- NRT" ).append("\n"); 
		query.append("         , DECODE ( M.CNTR_DZN_CAPA             , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.CNTR_DZN_CAPA             , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS CNTR_DZN_CAPA   -- Design Capacity" ).append("\n"); 
		query.append("         , DECODE ( M.LOA_LEN                   , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.LOA_LEN                   , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS LOA_LEN    -- LOA" ).append("\n"); 
		query.append("         , DECODE ( M.DWT_WGT                   , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.DWT_WGT                   , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS DWT_WGT    -- DWT" ).append("\n"); 
		query.append("         , DECODE ( M.MADN_VOY_SUZ_NET_TONG_WGT , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.MADN_VOY_SUZ_NET_TONG_WGT , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS SCNT    -- SCNT COUNT" ).append("\n"); 
		query.append("         , DECODE ( M.VSL_RGST_CNT_CD           , NULL , NULL , 0, NULL , M.VSL_RGST_CNT_CD )                                                                             AS VSL_RGST_CNT_CD   -- NATIONALLITY ( Nationality of VSL Origin ) : FLAG" ).append("\n"); 
		query.append("         , DECODE ( M.VSL_DPTH                  , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.VSL_DPTH                  , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS VSL_DPTH    -- DEPTH" ).append("\n"); 
		query.append("         , DECODE ( M.CNTR_PNM_CAPA             , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.CNTR_PNM_CAPA             , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS CNTR_PNM_CAPA   -- ALLOWANCE TEU " ).append("\n"); 
		query.append("         , DECODE ( M.VSL_WDT                   , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.VSL_WDT                   , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS VSL_WDT    -- BEAM" ).append("\n"); 
		query.append("         , DECODE ( M.SMR_DRFT_HGT              , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.SMR_DRFT_HGT              , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS SMR_DRFT_HGT   -- Summer Draft" ).append("\n"); 
		query.append("         , DECODE ( M.VSL_OWN_IND_CD            , NULL , NULL , 0, NULL , (SELECT B.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL B WHERE INTG_CD_ID = 'CD00649' AND INTG_CD_VAL_CTNT = M.VSL_OWN_IND_CD)  ) AS VSL_OWN_IND_CD   -- Nationality of VSL Origin" ).append("\n"); 
		query.append("         , DECODE ( M.SUZ_GT_WGT                , NULL , NULL , 0, NULL , RTRIM(RTRIM(TO_CHAR(M.SUZ_GT_WGT                , 'FM9,999,9,999,9,999,990.0000'), '0'), '.') ) AS SCGT    -- SCGT" ).append("\n"); 
		query.append("         , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("              FROM V_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND T1.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("               AND SUBSTR(T1.YD_CD,1,5) = 'EGSCA'" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ),'N') AS EXIST_SUZ_YN" ).append("\n"); 
		query.append("         , NVL((SELECT 'Y'" ).append("\n"); 
		query.append("              FROM V_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND T1.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("               AND SUBSTR(T1.YD_CD,1,5) = 'PAPCA'" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ),'N') AS EXIST_PNM_YN" ).append("\n"); 
		query.append("         , NVL(V.CHK_GRT_YN             , 'N') AS CHK_GRT_YN                /*GRT Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_NRT_YN             , 'N') AS CHK_NRT_YN                /*NRT Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_DESING_CAPACITY_YN , 'N') AS CHK_DESING_CAPACITY_YN    /*Design Capacity Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_LOA_YN             , 'N') AS CHK_LOA_YN                /*LOA Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_DWT_YN             , 'N') AS CHK_DWT_YN                /*DWT Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_SCNT_YN            , 'N') AS CHK_SCNT_YN               /*Suez Net Tonnage Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_SCGT_YN            , 'N') AS CHK_SCGT_YN               /*Suez Gross Ton Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_ALLOWANCE_TEU_YN   , 'N') AS CHK_ALLOWANCE_TEU_YN      /*Panama Allowance TEU Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_BM_YN              , 'N') AS CHK_BM_YN                 /*BM Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_SUMMER_DRAFT_YN    , 'N') AS CHK_SUMMER_DRAFT_YN       /*Summer Draft Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_FLAG_YN            , 'N') AS CHK_FLAG_YN               /*Flag Used YN*/" ).append("\n"); 
		query.append("         , NVL(V.CHK_OWNERSHIP_YN       , 'N') AS CHK_OWNERSHIP_YN          /*Ownership Used YN*/" ).append("\n"); 
		query.append("      FROM MDM_VSL_CNTR M" ).append("\n"); 
		query.append("         , V_VSL_CHK_OBJ V" ).append("\n"); 
		query.append("     WHERE 1 = 1" ).append("\n"); 
		query.append("       AND EXISTS   ( SELECT 'Y' " ).append("\n"); 
		query.append("                        FROM V_VSL_PORT_SKD S" ).append("\n"); 
		query.append("                       WHERE S.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("       AND M.CRR_CD = COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("       AND NVL(M.VSL_CLSS_FLG,' ') <> 'T'" ).append("\n"); 
		query.append("       AND M.VSL_CD = V.VSL_CD(+)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("--SELECT * FROM V_MDM_VSL_CNTR; " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Object Condition All */" ).append("\n"); 
		query.append("SELECT M.VSL_CD" ).append("\n"); 
		query.append("     , M.VSL_ENG_NM" ).append("\n"); 
		query.append("     , M.GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("     , M.NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("     , M.CNTR_DZN_CAPA" ).append("\n"); 
		query.append("     , M.LOA_LEN" ).append("\n"); 
		query.append("     , M.DWT_WGT" ).append("\n"); 
		query.append("     , DECODE ( M.EXIST_SUZ_YN, 'Y' , M.SCNT , 'Not Required' ) AS SCNT" ).append("\n"); 
		query.append("     , DECODE ( M.EXIST_SUZ_YN, 'Y' , M.SCGT , 'Not Required' ) AS SCGT" ).append("\n"); 
		query.append("     , M.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("     , M.VSL_DPTH" ).append("\n"); 
		query.append("     , DECODE ( M.EXIST_PNM_YN, 'Y' , M.CNTR_PNM_CAPA , 'Not Required' ) AS  CNTR_PNM_CAPA" ).append("\n"); 
		query.append("     , M.VSL_WDT" ).append("\n"); 
		query.append("     , M.SMR_DRFT_HGT" ).append("\n"); 
		query.append("     , M.EXIST_SUZ_YN" ).append("\n"); 
		query.append("     , M.EXIST_PNM_YN" ).append("\n"); 
		query.append("     , M.VSL_OWN_IND_CD" ).append("\n"); 
		query.append("     , M.CHK_GRT_YN                /*GRT Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_NRT_YN                /*NRT Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_DESING_CAPACITY_YN    /*Design Capacity Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_LOA_YN                /*LOA Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_DWT_YN                /*DWT Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_SCNT_YN               /*Suez Net Tonnage Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_SCGT_YN               /*Suez Gross Ton Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_ALLOWANCE_TEU_YN      /*Panama Allowance TEU Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_BM_YN                 /*BM Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_SUMMER_DRAFT_YN       /*Summer Draft Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_FLAG_YN               /*Flag Used YN*/" ).append("\n"); 
		query.append("     , M.CHK_OWNERSHIP_YN          /*Ownership Used YN*/" ).append("\n"); 
		query.append("  FROM V_MDM_VSL_CNTR M" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${srh_cnd} != '' && ${srh_cnd} == '2') " ).append("\n"); 
		query.append("/* Object Condition Match */" ).append("\n"); 
		query.append("   AND DECODE ( M.CHK_GRT_YN            , 'Y', DECODE ( M.GRS_RGST_TONG_WGT , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_NRT_YN            , 'Y', DECODE ( M.NET_RGST_TONG_WGT , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_DESING_CAPACITY_YN, 'Y', DECODE ( M.CNTR_DZN_CAPA     , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_LOA_YN            , 'Y', DECODE ( M.LOA_LEN           , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_DWT_YN            , 'Y', DECODE ( M.DWT_WGT           , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_SCNT_YN           , 'Y', DECODE ( M.EXIST_SUZ_YN      , 'Y' , DECODE ( M.SCNT         ,  NULL , 0 , 0, 0, 1 ) , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_SCGT_YN           , 'Y', DECODE ( M.EXIST_SUZ_YN      , 'Y' , DECODE ( M.SCGT         ,  NULL , 0 , 0, 0, 1 ) , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_ALLOWANCE_TEU_YN  , 'Y', DECODE ( M.EXIST_PNM_YN      , 'Y' , DECODE ( M.CNTR_PNM_CAPA,  NULL , 0, 0 , 0, 1 ) , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_BM_YN             , 'Y', DECODE ( M.VSL_WDT           , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_SUMMER_DRAFT_YN   , 'Y', DECODE ( M.SMR_DRFT_HGT      , NULL , 0 , 0 , 0 , 1 ) , 1) = 1" ).append("\n"); 
		query.append("#elseif (${srh_cnd} != '' && ${srh_cnd} == '3') " ).append("\n"); 
		query.append("/* Object Condition MisMatch */" ).append("\n"); 
		query.append("   AND DECODE ( M.CHK_GRT_YN            , 'Y', DECODE ( M.GRS_RGST_TONG_WGT , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_NRT_YN            , 'Y', DECODE ( M.NET_RGST_TONG_WGT , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_DESING_CAPACITY_YN, 'Y', DECODE ( M.CNTR_DZN_CAPA     , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_LOA_YN            , 'Y', DECODE ( M.LOA_LEN           , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_DWT_YN            , 'Y', DECODE ( M.DWT_WGT           , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_SCNT_YN           , 'Y', DECODE ( M.EXIST_SUZ_YN      , 'Y' , DECODE ( M.SCNT         ,  NULL , 0 , 0, 0, 1 ) , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_SCGT_YN           , 'Y', DECODE ( M.EXIST_SUZ_YN      , 'Y' , DECODE ( M.SCGT         ,  NULL , 0 , 0, 0, 1 ) , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_ALLOWANCE_TEU_YN  , 'Y', DECODE ( M.EXIST_PNM_YN      , 'Y' , DECODE ( M.CNTR_PNM_CAPA,  NULL , 0, 0 , 0, 1 ) , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_BM_YN             , 'Y', DECODE ( M.VSL_WDT           , NULL , 0 , 0 , 0 , 1 ) , 1)" ).append("\n"); 
		query.append("      *DECODE ( M.CHK_SUMMER_DRAFT_YN   , 'Y', DECODE ( M.SMR_DRFT_HGT      , NULL , 0 , 0 , 0 , 1 ) , 1) = 0" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}