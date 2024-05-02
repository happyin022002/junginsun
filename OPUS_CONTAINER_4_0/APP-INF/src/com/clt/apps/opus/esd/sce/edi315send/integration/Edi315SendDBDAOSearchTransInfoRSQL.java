/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Edi315SendDBDAOSearchTransInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2017.01.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchTransInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi 315 trans info
	  * </pre>
	  */
	public Edi315SendDBDAOSearchTransInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchTransInfoRSQL").append("\n"); 
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
		query.append("#if (${trans_tp_cd} == 'TRNKPC' || ${trans_tp_cd} == 'TRNKMC' || ${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("/*TRNKPC, TRNKMC, TRNKOC*/" ).append("\n"); 
		query.append("SELECT @[trans_tp_cd]" ).append("\n"); 
		query.append("     , MAX(ACTIVITY_IND)  AS ACTIVITY_IND" ).append("\n"); 
		query.append("     , MAX(TRANS_MODE) AS TRANS_MODE" ).append("\n"); 
		query.append("     , MAX(DECODE(VSL_CD,'','',VSL_TP)) AS VSL_TP" ).append("\n"); 
		query.append("     , MIN(OB_CSSM_VOY_NO) AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , MAX(VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("     , MAX(VSL_VOY_NO) AS VSL_VOY_NO" ).append("\n"); 
		query.append("     , MAX(VSL_DIR_CD) AS VSL_DIR_CD" ).append("\n"); 
		query.append("     , MAX(VSL_LLOYD_CD) AS VSL_LLOYD_CD" ).append("\n"); 
		query.append("     , MAX(VSL_NM) AS VSL_NM" ).append("\n"); 
		query.append("     , MAX(VSL_CNT_CD) AS VSL_CNT_CD" ).append("\n"); 
		query.append("     , MAX(VSL_SEQ) AS VSL_SEQ" ).append("\n"); 
		query.append("     , MAX(POL_YD_CD) AS POL_YD_CD" ).append("\n"); 
		query.append("     , MAX(POD_YD_CD) AS POD_YD_CD" ).append("\n"); 
		query.append("  FROM(SELECT @[trans_tp_cd]" ).append("\n"); 
		query.append("             ,SCD.COP_DTL_SEQ SEQ" ).append("\n"); 
		query.append("             , CASE WHEN (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                         , SCE_COP_HDR B" ).append("\n"); 
		query.append("                         , BKG_VVD BV" ).append("\n"); 
		query.append("                     WHERE A.COP_NO =  @[cop_no]" ).append("\n"); 
		query.append("                       AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                       AND B.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                       AND DECODE(@[edi_sts_cd], 'VE',SUBSTR(A.STND_EDI_STS_CD, 1, 1), A.STND_EDI_STS_CD)  " ).append("\n"); 
		query.append("                         = DECODE(@[edi_sts_cd], 'VE',SUBSTR(@[edi_sts_cd],1,1), @[edi_sts_cd])  -- 'VE' EVENT 처리" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                    #if (${trans_tp_cd} == 'TRNKPC')" ).append("\n"); 
		query.append("               			AND BV.VSL_PRE_PST_CD = 'S'/*TRNKPC 'S' TRNKMC 'T' TRNKPC 'U' 가변 조건*/" ).append("\n"); 
		query.append("	           		#elseif(${trans_tp_cd} == 'TRNKMC')" ).append("\n"); 
		query.append("               			AND BV.VSL_PRE_PST_CD = 'T'/*TRNKPC 'S' TRNKMC 'T' TRNKPC 'U' 가변 조건*/" ).append("\n"); 
		query.append("           			#elseif(${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("               			AND BV.VSL_PRE_PST_CD = 'U'/*TRNKPC 'S' TRNKMC 'T' TRNKPC 'U' 가변 조건*/" ).append("\n"); 
		query.append("           			#end" ).append("\n"); 
		query.append("                       AND A.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("                       AND A.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND A.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND -- 0715 로직 변경" ).append("\n"); 
		query.append("             , DECODE(SUBSTR(SCD.ACT_CD, 3,1),'W','F',SUBSTR(SCD.ACT_CD, 3,1)) AS TRANS_MODE" ).append("\n"); 
		query.append("             , DECODE(VSL_SVC_TP_CD, NULL, 'F', 'O', 'F', 'M') AS VSL_TP" ).append("\n"); 
		query.append("             , NVL(OB_CSSM_VOY_NO, IB_CSSM_VOY_NO) AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , BV.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("             , BV.SKD_VOY_NO AS VSL_VOY_NO" ).append("\n"); 
		query.append("             , BV.SKD_DIR_CD AS VSL_DIR_CD" ).append("\n"); 
		query.append("             , MVC.LLOYD_NO AS VSL_LLOYD_CD" ).append("\n"); 
		query.append("             , MVC.VSL_ENG_NM AS VSL_NM" ).append("\n"); 
		query.append("             , MVC.VSL_RGST_CNT_CD AS VSL_CNT_CD" ).append("\n"); 
		query.append("             , VSL_SEQ" ).append("\n"); 
		query.append("             , BV.POL_YD_CD" ).append("\n"); 
		query.append("             , BV.POD_YD_CD" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("             , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("             , BKG_VVD BV" ).append("\n"); 
		query.append("             , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("             , MDM_VSL_SVC_LANE MV" ).append("\n"); 
		query.append("         WHERE SCH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND SCH.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("           AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("           AND SCD.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("           AND SCD.VSL_CD = MVC.VSL_CD(+)" ).append("\n"); 
		query.append("           AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND SCD.VSL_CD IS NOT NULL" ).append("\n"); 
		query.append("           AND SKD.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND SKD.VPS_PORT_CD = SCD.VPS_PORT_CD" ).append("\n"); 
		query.append("           --AND OB_CSSM_VOY_NO IS NOT NULL" ).append("\n"); 
		query.append("           AND SKD.CLPT_IND_SEQ = SCD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND SCH.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("           AND BV.SLAN_CD = MV.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("		#if (${trans_tp_cd} == 'TRNKPC')" ).append("\n"); 
		query.append("           AND SCD.VSL_CD(+) = BV.VSL_CD" ).append("\n"); 
		query.append("           AND SCD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SCD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("           AND SCD.VSL_CD || SCD.SKD_VOY_NO || SCD.SKD_DIR_CD = @[vvd]    /*Edi315SendDBDAOSearchDynamicTransInfoRSQL 에서 VVD*/" ).append("\n"); 
		query.append("           AND SCD.VPS_PORT_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        #elseif(${trans_tp_cd} == 'TRNKMC')" ).append("\n"); 
		query.append("           AND SCD.VSL_CD(+) = BV.VSL_CD" ).append("\n"); 
		query.append("           AND SCD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SCD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("        #elseif(${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("           AND SCD.VSL_CD(+) = BV.VSL_CD" ).append("\n"); 
		query.append("           AND SCD.SKD_VOY_NO(+) = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND SCD.SKD_DIR_CD(+) = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BV.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("           AND SCD.VSL_CD || SCD.SKD_VOY_NO || SCD.SKD_DIR_CD = @[vvd]    /*Edi315SendDBDAOSearchDynamicTransInfoRSQL 에서 VVD*/" ).append("\n"); 
		query.append("           AND SCD.VPS_PORT_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("           AND (SUBSTR(SCD.NOD_CD, 1,5 ) = SUBSTR( BV.POL_YD_CD ,1, 5) OR SUBSTR(SCD.NOD_CD, 1,5 ) = SUBSTR( BV.POD_YD_CD ,1, 5) ) " ).append("\n"); 
		query.append("           --AND SUBSTR(SCD.NOD_CD, 1,5 ) = SUBSTR( [nod_cd] ,1, 5)   /* Edi315SendDBDAOSearchDynamicTransInfoRSQL 에서 NOD_CD */" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" GROUP BY VSL_SEQ          -- 추가          " ).append("\n"); 
		query.append(" ORDER BY VSL_SEQ " ).append("\n"); 
		query.append("#elseif(${trans_tp_cd} == 'TRNKTT')" ).append("\n"); 
		query.append("/*TRNKTT*/" ).append("\n"); 
		query.append("SELECT DISTINCT @[trans_tp_cd]" ).append("\n"); 
		query.append("     , CASE WHEN ACTIVITY_IND1 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("            WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'Y' THEN 'Y' ELSE 'N' END AS ACTIVITY_IND" ).append("\n"); 
		query.append("     , TRANS_MODE AS TRANS_MODE" ).append("\n"); 
		query.append("     , DECODE(VSL_CD,'','',VSL_TP) AS VSL_TP" ).append("\n"); 
		query.append("     , OB_CSSM_VOY_NO AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("     , VSL_VOY_NO AS VSL_VOY_NO" ).append("\n"); 
		query.append("     , VSL_DIR_CD AS VSL_DIR_CD" ).append("\n"); 
		query.append("     , VSL_LLOYD_CD AS VSL_LLOYD_CD" ).append("\n"); 
		query.append("     , VSL_NM AS VSL_NM" ).append("\n"); 
		query.append("     , VSL_CNT_CD AS VSL_CNT_CD" ).append("\n"); 
		query.append("     , '' AS VSL_SEQ" ).append("\n"); 
		query.append("     , '' AS POL_YD_CD" ).append("\n"); 
		query.append("     , '' AS POD_YD_CD" ).append("\n"); 
		query.append("  FROM (SELECT @[trans_tp_cd]" ).append("\n"); 
		query.append("             , SCD.COP_DTL_SEQ SEQ" ).append("\n"); 
		query.append("             , CASE WHEN (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.STND_EDI_STS_CD = @[edi_sts_cd]  /*PARAMEMTER MSGID ediStatus(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND1-- 0715 로직 변경-- 0715 로직 변경" ).append("\n"); 
		query.append("             , CASE WHEN (" ).append("\n"); 
		query.append("                        SELECT DECODE(ACT_STS_CD,'F','Y','N')" ).append("\n"); 
		query.append("                          FROM SCE_COP_DTL" ).append("\n"); 
		query.append("                         WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                           AND COP_DTL_SEQ = (  SELECT COP_DTL_SEQ" ).append("\n"); 
		query.append("                                                  FROM(SELECT ROW_NUMBER() OVER(PARTITION BY B.CNTR_NO ORDER BY C.COP_DTL_SEQ DESC) RN" ).append("\n"); 
		query.append("                                                            , COP_DTL_SEQ" ).append("\n"); 
		query.append("                                                         FROM SCE_COP_HDR B" ).append("\n"); 
		query.append("                                                            , SCE_COP_DTL C" ).append("\n"); 
		query.append("                                                        WHERE B.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                                                          AND B.COP_STS_CD IN ('C','T','F')" ).append("\n"); 
		query.append("                                                          AND B.COP_NO = C.COP_NO" ).append("\n"); 
		query.append("                                                          AND C.ACT_STS_CD = 'F' " ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("                                                 WHERE RN = 1" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                           AND COP_DTL_SEQ = SCD.COP_DTL_SEQ ) IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND2" ).append("\n"); 
		query.append("             , DECODE(SUBSTR(SCD.ACT_CD, 3, 1), 'W', 'F', SUBSTR(SCD.ACT_CD, 3, 1)) AS TRANS_MODE" ).append("\n"); 
		query.append("             , (SELECT DECODE(L.VSL_SVC_TP_CD, NULL, 'F', 'O', 'F', 'M')" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("                 WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND B.SLAN_CD = L.VSL_SLAN_CD(+)) AS VSL_TP" ).append("\n"); 
		query.append("             , (SELECT NVL(OB_CSSM_VOY_NO, IB_CSSM_VOY_NO)" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE VSL_CD = SCD.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = SCD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = SCD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VPS_PORT_CD = SCD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND CLPT_IND_SEQ = SCD.CLPT_IND_SEQ) AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , SCD.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("             , SCD.SKD_VOY_NO AS VSL_VOY_NO" ).append("\n"); 
		query.append("             , SCD.SKD_DIR_CD AS VSL_DIR_CD" ).append("\n"); 
		query.append("             , MVC.LLOYD_NO AS VSL_LLOYD_CD" ).append("\n"); 
		query.append("             , MVC.VSL_ENG_NM AS VSL_NM" ).append("\n"); 
		query.append("             , MVC.VSL_RGST_CNT_CD AS VSL_CNT_CD" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("             , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("         WHERE SCH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND SCH.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("           AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("           AND SCD.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("           AND SCD.VSL_CD = MVC.VSL_CD(+)" ).append("\n"); 
		query.append("           AND SCD.ACT_CD IN ('FTTMDO', 'FTTMAD') " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(" ORDER BY ACTIVITY_IND DESC" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("/*OBSTRT, OBIMD, IBIMD, IBEND*/" ).append("\n"); 
		query.append("SELECT @[trans_tp_cd]" ).append("\n"); 
		query.append("       ,MAX(CASE WHEN ACTIVITY_IND1 = 'Y' THEN 'Y'" ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("             WHEN ACTIVITY_IND1 = 'N' AND ACTIVITY_IND2 = 'N' AND ACTIVITY_IND3 = 'Y' THEN 'Y' " ).append("\n"); 
		query.append("             ELSE 'N' END) ACTIVITY_IND" ).append("\n"); 
		query.append("     , MAX(TRANS_MODE) AS TRANS_MODE" ).append("\n"); 
		query.append("     , MAX(DECODE(VSL_CD,'','',VSL_TP)) AS VSL_TP" ).append("\n"); 
		query.append("     , MIN(OB_CSSM_VOY_NO) AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("     , MAX(VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("     , MAX(VSL_VOY_NO) AS VSL_VOY_NO" ).append("\n"); 
		query.append("     , MAX(VSL_DIR_CD) AS VSL_DIR_CD" ).append("\n"); 
		query.append("     , MAX(VSL_LLOYD_CD) AS VSL_LLOYD_CD" ).append("\n"); 
		query.append("     , MAX(VSL_NM) AS VSL_NM" ).append("\n"); 
		query.append("     , MAX(VSL_CNT_CD) AS VSL_CNT_CD" ).append("\n"); 
		query.append("     , '' AS VSL_SEQ" ).append("\n"); 
		query.append("     , '' AS POL_YD_CD" ).append("\n"); 
		query.append("     , '' AS POD_YD_CD" ).append("\n"); 
		query.append("  FROM(SELECT @[trans_tp_cd]" ).append("\n"); 
		query.append("            , SCD.COP_DTL_SEQ SEQ" ).append("\n"); 
		query.append("            , CASE WHEN @[edi_sts_cd] = 'D' OR @[edi_sts_cd] = 'AG'   -- COP에 없는 I/B Delivery Case 처리" ).append("\n"); 
		query.append("                   THEN " ).append("\n"); 
		query.append("                   NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.ACT_CD = 'FITZAD'  -- 상수" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ), 'N')  ELSE 'N' END ACTIVITY_IND1-- 0715 로직 변경-- 0715 로직 변경" ).append("\n"); 
		query.append("             , CASE WHEN (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.STND_EDI_STS_CD = @[edi_sts_cd]  /*PARAMEMTER MSGID ediStatus(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND2-- 0715 로직 변경-- 0715 로직 변경" ).append("\n"); 
		query.append("             , CASE WHEN (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM SCE_COP_DTL A" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                       AND A.ACT_CD = @[edi_sts_cd]  /*PARAMEMTER MSGID ediStatus(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND SUBSTR(A.NOD_CD, 1, 5) LIKE SUBSTR(@[event_yard_cd], 1, 5) /*PARAMETER    eventYard(Edi315SendVO)*/" ).append("\n"); 
		query.append("                       AND A.COP_DTL_SEQ = SCD.COP_DTL_SEQ) IS NULL THEN 'N' ELSE 'Y' END ACTIVITY_IND3-- 0715 로직 변경" ).append("\n"); 
		query.append("             , DECODE(SUBSTR(SCD.ACT_CD, 3,1),'W','F',SUBSTR(SCD.ACT_CD, 3,1)) AS TRANS_MODE" ).append("\n"); 
		query.append("             , (SELECT DECODE(L.VSL_SVC_TP_CD, NULL, 'F', 'O', 'F', 'M')" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("                 WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   AND B.SLAN_CD = L.VSL_SLAN_CD(+)) AS VSL_TP" ).append("\n"); 
		query.append("             , (SELECT OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                 WHERE VSL_CD = SCD.VSL_CD" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = SCD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = SCD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VPS_PORT_CD = SCD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND CLPT_IND_SEQ = SCD.CLPT_IND_SEQ) AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("             , SCD.VSL_CD AS VSL_CD" ).append("\n"); 
		query.append("             , SCD.SKD_VOY_NO AS VSL_VOY_NO" ).append("\n"); 
		query.append("             , SCD.SKD_DIR_CD AS VSL_DIR_CD" ).append("\n"); 
		query.append("             , MVC.LLOYD_NO AS VSL_LLOYD_CD" ).append("\n"); 
		query.append("             , MVC.VSL_ENG_NM AS VSL_NM" ).append("\n"); 
		query.append("             , MVC.VSL_RGST_CNT_CD AS VSL_CNT_CD" ).append("\n"); 
		query.append("          FROM SCE_COP_HDR SCH" ).append("\n"); 
		query.append("             , SCE_COP_DTL SCD" ).append("\n"); 
		query.append("             , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("         WHERE SCH.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND SCH.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("           AND SCH.COP_NO = SCD.COP_NO" ).append("\n"); 
		query.append("           AND SCD.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("           AND SCD.VSL_CD = MVC.VSL_CD(+)" ).append("\n"); 
		query.append("		   #if (${trans_tp_cd} == 'OBSTRT')" ).append("\n"); 
		query.append("               AND SUBSTR(SCD.ACT_CD,2,1) = 'O'" ).append("\n"); 
		query.append("               AND SUBSTR(SCD.ACT_CD,3,1) NOT IN ('R','W')" ).append("\n"); 
		query.append("               AND SCD.COP_DTL_SEQ <= (SELECT MIN(COP_DTL_SEQ) FROM SCE_COP_DTL WHERE COP_NO = @[cop_no] AND SUBSTR(ACT_CD, 5, 2)  = 'AD' AND SUBSTR(ACT_CD, 1, 1)  =  'F')" ).append("\n"); 
		query.append("           #elseif (${trans_tp_cd} == 'OBIMD')" ).append("\n"); 
		query.append("               AND (SCD.COP_DTL_SEQ = @[cop_dtl_seq]  -- 출발지   위에서 조회한 SEQ" ).append("\n"); 
		query.append("                 OR SCD.COP_DTL_SEQ = (SELECT MIN(B.COP_DTL_SEQ) " ).append("\n"); 
		query.append("                                         FROM SCE_COP_DTL A, SCE_COP_DTL B" ).append("\n"); 
		query.append("                                        WHERE A.COP_NO = @[cop_no] " ).append("\n"); 
		query.append("                                          AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                                          AND A.COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 5,2) = 'AD'  -- 직후 도착지 FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 2,1) = 'O'" ).append("\n"); 
		query.append("                                          AND SUBSTR(A.ACT_CD, 1,3) = SUBSTR(B.ACT_CD, 1,3)" ).append("\n"); 
		query.append("                                          AND B.COP_DTL_SEQ >  @[cop_dtl_seq]) " ).append("\n"); 
		query.append("                 OR SCD.COP_DTL_SEQ = (SELECT MAX(B.COP_DTL_SEQ) " ).append("\n"); 
		query.append("                                         FROM SCE_COP_DTL A, SCE_COP_DTL B" ).append("\n"); 
		query.append("                                        WHERE A.COP_NO = @[cop_no] " ).append("\n"); 
		query.append("                                          AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                                          AND A.COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 5,2) = 'LO'  -- 직전 Loading FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 2,1) = 'O'" ).append("\n"); 
		query.append("                                          AND SUBSTR(A.ACT_CD, 1,3) = SUBSTR(B.ACT_CD, 1,3)" ).append("\n"); 
		query.append("                                          AND B.COP_DTL_SEQ < @[cop_dtl_seq]) " ).append("\n"); 
		query.append("                 OR SCD.COP_DTL_SEQ = (SELECT MIN(B.COP_DTL_SEQ) " ).append("\n"); 
		query.append("                                         FROM SCE_COP_DTL A, SCE_COP_DTL B" ).append("\n"); 
		query.append("                                        WHERE A.COP_NO = @[cop_no] " ).append("\n"); 
		query.append("                                          AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                                          AND A.COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 4,3) = 'RUD'  -- 직전 Loading FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 2,1) = 'O'" ).append("\n"); 
		query.append("                                          AND SUBSTR(A.ACT_CD, 1,3) = SUBSTR(B.ACT_CD, 1,3)" ).append("\n"); 
		query.append("                                          AND B.COP_DTL_SEQ > @[cop_dtl_seq])" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("           #elseif (${trans_tp_cd} == 'IBIMD')" ).append("\n"); 
		query.append("           	   AND (SCD.COP_DTL_SEQ = @[cop_dtl_seq]  -- 도착지   위에서 조회한 SEQ " ).append("\n"); 
		query.append("                 OR SCD.COP_DTL_SEQ = (SELECT MAX(B.COP_DTL_SEQ) " ).append("\n"); 
		query.append("                                         FROM SCE_COP_DTL A, SCE_COP_DTL B" ).append("\n"); 
		query.append("                                        WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                                          AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                                          AND A.COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 5,2) = 'DO'  -- 직전 출발지 FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 2,1) = 'I'" ).append("\n"); 
		query.append("                                          AND SUBSTR(A.ACT_CD, 1,3) = SUBSTR(B.ACT_CD, 1,3)" ).append("\n"); 
		query.append("                                          AND B.COP_DTL_SEQ < @[cop_dtl_seq])" ).append("\n"); 
		query.append("                 OR SCD.COP_DTL_SEQ = (SELECT MAX(B.COP_DTL_SEQ) " ).append("\n"); 
		query.append("                                         FROM SCE_COP_DTL  A, SCE_COP_DTL B" ).append("\n"); 
		query.append("                                        WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                                          AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                                          AND A.COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 5,2) = 'LO'  -- 직전 Loading FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 2,1) = 'I'" ).append("\n"); 
		query.append("                                          AND SUBSTR(A.ACT_CD, 1,3) = SUBSTR(B.ACT_CD, 1,3)" ).append("\n"); 
		query.append("                                          AND B.COP_DTL_SEQ < @[cop_dtl_seq] )" ).append("\n"); 
		query.append("                 OR SCD.COP_DTL_SEQ = (SELECT MIN(B.COP_DTL_SEQ) " ).append("\n"); 
		query.append("                                         FROM SCE_COP_DTL A, SCE_COP_DTL B" ).append("\n"); 
		query.append("                                        WHERE A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                                          AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                                          AND A.COP_DTL_SEQ = @[cop_dtl_seq]" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 4,3) = 'RUD'  -- 직전 Loading FM - TO 를 다 가져오기 위해" ).append("\n"); 
		query.append("                                          AND SUBSTR(B.ACT_CD, 2,1) = 'I'" ).append("\n"); 
		query.append("                                          AND SUBSTR(A.ACT_CD, 1,3) = SUBSTR(B.ACT_CD, 1,3)" ).append("\n"); 
		query.append("                                          AND B.COP_DTL_SEQ > @[cop_dtl_seq] )" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("           #elseif (${trans_tp_cd} == 'IBEND')" ).append("\n"); 
		query.append("	           AND SUBSTR(SCD.ACT_CD,2,1) = 'I'" ).append("\n"); 
		query.append("               AND SUBSTR(SCD.ACT_CD,3,1) NOT IN ('R','W')" ).append("\n"); 
		query.append("               AND SCD.COP_DTL_SEQ >= (SELECT MAX(COP_DTL_SEQ) FROM SCE_COP_DTL WHERE COP_NO = @[cop_no] AND SUBSTR(ACT_CD, 5, 2)  = 'DO' )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}