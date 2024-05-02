/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TesTorAudDBDAOSearchRehandlingExpenseTorVsTpbRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.testoraud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesTorAudDBDAOSearchRehandlingExpenseTorVsTpbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rehandling Expense - TOR vs. TPB 데이타 조회
	  * </pre>
	  */
	public TesTorAudDBDAOSearchRehandlingExpenseTorVsTpbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_trmnl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.testoraud.integration").append("\n"); 
		query.append("FileName : TesTorAudDBDAOSearchRehandlingExpenseTorVsTpbRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD " ).append("\n"); 
		query.append("     , PORT_CD" ).append("\n"); 
		query.append("     , CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , RHND_EXPN_SEQ" ).append("\n"); 
		query.append("     , VVD" ).append("\n"); 
		query.append("     , LANE_CD" ).append("\n"); 
		query.append("     , ACT_DEP_DT" ).append("\n"); 
		query.append("     , CNTR_NO" ).append("\n"); 
		query.append("     , RESPB_CNTR_NO" ).append("\n"); 
		query.append("     , SZTP" ).append("\n"); 
		query.append("     , POL" ).append("\n"); 
		query.append("     , OPR_CD" ).append("\n"); 
		query.append("     , PRECELL" ).append("\n"); 
		query.append("     , POSITION" ).append("\n"); 
		query.append("     , SHIFT_RSN" ).append("\n"); 
		query.append("     , PARTY" ).append("\n"); 
		query.append("     , FILE_ATCH" ).append("\n"); 
		query.append("     , TPB_NO" ).append("\n"); 
		query.append("     , TPB_AMT_USD" ).append("\n"); 
		query.append("     , TPB_OFC" ).append("\n"); 
		query.append("     , TPB_PTY_3RD" ).append("\n"); 
		query.append("     , TPB_STS_NM" ).append("\n"); 
		query.append("     , DECODE(OPR_CD,'SML',BKG_NO,'') BKG_NO" ).append("\n"); 
		query.append("     , ( SELECT 'Y'" ).append("\n"); 
		query.append("          FROM   EAS_RHND_CHG_CHK X" ).append("\n"); 
		query.append("          WHERE  X.VSL_CD			  = SUBSTR(RT.VVD,1,4)" ).append("\n"); 
		query.append("				 AND X.SKD_VOY_NO	  = SUBSTR(RT.VVD,5,4)" ).append("\n"); 
		query.append("				 AND X.SKD_DIR_CD  	  = SUBSTR(RT.VVD,9,1)" ).append("\n"); 
		query.append("                 AND X.PORT_CD        = RT.PORT_CD" ).append("\n"); 
		query.append("                 AND X.CLPT_IND_SEQ   = RT.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 AND X.CNTR_NO        = RT.CNTR_NO" ).append("\n"); 
		query.append("                 AND X.RHND_EXPN_SEQ  = RT.RHND_EXPN_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) EAC_IF_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ OPT_PARAM('_optimizer_push_pred_cost_based','TRUE') PUSH_PRED(BKG) */" ).append("\n"); 
		query.append("               TOR.OFC_CD" ).append("\n"); 
		query.append("             , TOR.PORT_CD" ).append("\n"); 
		query.append("             , TOR.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , RANK() OVER (PARTITION BY TOR.PORT_CD, TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD, TOR.CNTR_NO ORDER BY TOR.PORT_CD, TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD, TOR.CNTR_NO, BKG.BKG_NO) RHND_EXPN_SEQ -- Rehandling Expense Sequence" ).append("\n"); 
		query.append("             , TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("             , TOR.LANE_CD" ).append("\n"); 
		query.append("             , TO_CHAR(TOR.ACT_DEP_DT,'YYYY-MM-DD') ACT_DEP_DT" ).append("\n"); 
		query.append("             , TOR.CNTR_NO" ).append("\n"); 
		query.append("             , TOR.RESPB_CNTR_NO" ).append("\n"); 
		query.append("             , TOR.SZTP" ).append("\n"); 
		query.append("             , TOR.POL" ).append("\n"); 
		query.append("             , TOR.OPR_CD" ).append("\n"); 
		query.append("             , TOR.PRECELL" ).append("\n"); 
		query.append("             , TOR.POSITION" ).append("\n"); 
		query.append("             , TOR.SHIFT_RSN" ).append("\n"); 
		query.append("             , TOR.PARTY" ).append("\n"); 
		query.append("             , TOR.FILE_ATCH" ).append("\n"); 
		query.append("             , TPB.TPB_NO" ).append("\n"); 
		query.append("             , TPB.TPB_AMT_USD" ).append("\n"); 
		query.append("             , TPB.TPB_OFC" ).append("\n"); 
		query.append("             , TPB.TPB_PTY_3RD" ).append("\n"); 
		query.append("             , TPB.TPB_STS_NM" ).append("\n"); 
		query.append("             , BKG.BKG_NO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT /*+ LEADING(A) INDEX(A XAK1VSK_ACT_PORT_SKD) */" ).append("\n"); 
		query.append("                 CASE WHEN R.CNTR_NO IS NOT NULL AND LENGTH(R.CNTR_NO) >= 10 THEN C.RESPB_CNTR_NO" ).append("\n"); 
		query.append("                         WHEN M.CNTR_NO IS NOT NULL AND LENGTH(M.CNTR_NO) >= 10 THEN C.CNTR_NO" ).append("\n"); 
		query.append("                    END AS TOR_CNTR_NO" ).append("\n"); 
		query.append("                     , M.CNTR_NO MST_M_CNTR_NO" ).append("\n"); 
		query.append("                     , R.CNTR_NO MST_R_CNTR_NO" ).append("\n"); 
		query.append("                     , L.EQ_CTRL_OFC_CD OFC_CD" ).append("\n"); 
		query.append("                     , H.PORT_CD" ).append("\n"); 
		query.append("                     , V.VSL_CD" ).append("\n"); 
		query.append("                     , V.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , V.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , S.VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("                     , A.ACT_DEP_DT" ).append("\n"); 
		query.append("                     , C.CNTR_NO          " ).append("\n"); 
		query.append("                     , C.RESPB_CNTR_NO" ).append("\n"); 
		query.append("                     , C.SZTP" ).append("\n"); 
		query.append("                     , C.POL" ).append("\n"); 
		query.append("                     , C.OPR_CD" ).append("\n"); 
		query.append("                     , C.PRECELL" ).append("\n"); 
		query.append("                     , C.POSITION" ).append("\n"); 
		query.append("                     , C.STATUS CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("                     , NVL(C.SHIFT_TYPE,'')||NVL(C.SHIFT_RSN,'') AS SHIFT_RSN" ).append("\n"); 
		query.append("                     , C.PARTY" ).append("\n"); 
		query.append("                     , (SELECT DECODE(SIGN(COUNT(1)),1,'File Attached',NULL)" ).append("\n"); 
		query.append("                          FROM OPF_TDR_ATCH_FILE F" ).append("\n"); 
		query.append("                         WHERE C.VSL_CD   = F.VSL_CD" ).append("\n"); 
		query.append("                           AND C.VOY_NO   = F.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND C.DIR_CD   = F.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND C.PORT_CD  = F.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND C.CALL_IND = F.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND C.STATUS   = F.CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("                           AND C.CNTR_NO  = F.CNTR_NO" ).append("\n"); 
		query.append("                       ) AS FILE_ATCH " ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD S" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                     , VSK_ACT_PORT_SKD A" ).append("\n"); 
		query.append("                     , TDR_HEADER H" ).append("\n"); 
		query.append("                     , TDR_CNTR_DETAIL C" ).append("\n"); 
		query.append("                     , MDM_LOCATION L" ).append("\n"); 
		query.append("                     , MST_CONTAINER M" ).append("\n"); 
		query.append("                     , MST_CONTAINER R" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND S.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("                   AND S.SKD_VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND S.SKD_DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND V.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND V.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND V.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND A.ACT_DEP_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_dt],'-',''),'YYYYMMDD') + 0.99998 " ).append("\n"); 
		query.append("                   #if($s_vvd.size() > 0) " ).append("\n"); 
		query.append("                       AND (V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                           #foreach( ${key} in ${s_vvd}) " ).append("\n"); 
		query.append("                             #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                ( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9, 1))" ).append("\n"); 
		query.append("                             #else " ).append("\n"); 
		query.append("                              , ( SUBSTR('$key', 1, 4), SUBSTR('$key', 5, 4), SUBSTR('$key', 9, 1))" ).append("\n"); 
		query.append("                             #end " ).append("\n"); 
		query.append("                           #end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   AND V.VSL_CD        = H.VSL_CD" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO    = H.VOY_NO" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD    = H.DIR_CD" ).append("\n"); 
		query.append("                   AND V.VPS_PORT_CD   = H.PORT_CD" ).append("\n"); 
		query.append("                   AND V.CLPT_IND_SEQ  = H.CALL_IND" ).append("\n"); 
		query.append("                   AND H.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("                   AND H.VOY_NO        = C.VOY_NO" ).append("\n"); 
		query.append("                   AND H.DIR_CD        = C.DIR_CD" ).append("\n"); 
		query.append("                   AND H.PORT_CD       = C.PORT_CD" ).append("\n"); 
		query.append("                   AND H.CALL_IND      = C.CALL_IND" ).append("\n"); 
		query.append("                   AND C.STATUS        = 'ST'" ).append("\n"); 
		query.append("                   AND TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                   #if (${s_shift_rsn} == '1')" ).append("\n"); 
		query.append("                        AND NVL(C.SHIFT_TYPE,'')||NVL(C.SHIFT_RSN,'') IN ('BIC','QIC')" ).append("\n"); 
		query.append("                   #elseif ( ${s_shift_rsn} == '2')" ).append("\n"); 
		query.append("                        AND NVL(C.SHIFT_TYPE,'')||NVL(C.SHIFT_RSN,'') IN ('BIT','QIT')" ).append("\n"); 
		query.append("                   #elseif ( ${s_shift_rsn} == '3')" ).append("\n"); 
		query.append("                        AND NVL(C.SHIFT_TYPE,'')||NVL(C.SHIFT_RSN,'') NOT IN ('QIC','BIC','BIT','QIT')" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   AND L.LOC_CD         = H.PORT_CD" ).append("\n"); 
		query.append("                   AND NVL(L.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD(L.EQ_CTRL_OFC_CD) = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = M.CNTR_NO(+)" ).append("\n"); 
		query.append("                   #if (${s_cntr_no} != '')" ).append("\n"); 
		query.append("                        AND INSTR(@[s_cntr_no], C.CNTR_NO) > 0" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   AND C.RESPB_CNTR_NO = R.CNTR_NO(+)" ).append("\n"); 
		query.append("                   #if (${s_port_cd} != '' && ${s_trmnl_cd} == '')		--// PORT/YARD 조건" ).append("\n"); 
		query.append("                        AND V.VPS_PORT_CD = @[s_port_cd]" ).append("\n"); 
		query.append("                   #elseif (${s_port_cd} != '' && ${s_trmnl_cd} != '')" ).append("\n"); 
		query.append("				   		--AND V.YD_CD IN ( ${s_trmnl_cd} )" ).append("\n"); 
		query.append("						AND ( V.VPS_PORT_CD = @[s_port_cd] AND INSTR(@[s_trmnl_cd], SUBSTR(V.YD_CD,6)) > 0 )" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("               ) TOR" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT /*+ INDEX(BC XAK1BKG_CONTAINER) INDEX(BV XAK1BKG_VVD) */" ).append("\n"); 
		query.append("                       BB.BKG_NO" ).append("\n"); 
		query.append("                     , BV.VSL_CD VSL_CD" ).append("\n"); 
		query.append("                     , BV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("                     , BV.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("                     , BV.POL_CD " ).append("\n"); 
		query.append("                     , BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , BV.POD_CD" ).append("\n"); 
		query.append("                     , BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , BV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                     , BV.SLAN_CD" ).append("\n"); 
		query.append("                     , BC.CNTR_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                     , BKG_VVD BV" ).append("\n"); 
		query.append("                     , BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND BB.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("                   AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                   AND BB.BKG_NO = BV.BKG_NO " ).append("\n"); 
		query.append("                   AND BC.BKG_NO = BV.BKG_NO " ).append("\n"); 
		query.append("                   AND BV.VSL_PRE_PST_CD IN ('S','T','U')" ).append("\n"); 
		query.append("               ) BKG" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT W.BKG_NO AS TPB_BKG_NO" ).append("\n"); 
		query.append("                     , W.EQ_NO  AS TPB_CNTR_NO" ).append("\n"); 
		query.append("                     , MAX(NVL(W.FM_CLT_CNG_OFC_N3PTY_NO, W.N3PTY_NO)) TPB_NO  --TPB_TPB NBR TPB Billing Case : RH / CNTR nbr + BKG nbr 가 일치하는 TPB nbr" ).append("\n"); 
		query.append("                     , SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(W.CFM_CURR_CD, W.CFM_AMT, TO_CHAR(W.CFM_DT,'YYYYMM')),2)) TPB_AMT_USD" ).append("\n"); 
		query.append("                     , MAX(W.OFC_CD) TPB_OFC                                            -- TPB_TPB OFC 현재 Responsible OFC" ).append("\n"); 
		query.append("                     , MAX(DECODE(W.VNDR_CUST_DIV_CD,'V',W.VNDR_CNT_CD||W.VNDR_SEQ,'C',W.CUST_CNT_CD||W.CUST_SEQ,W.N3PTY_OFC_CD)) TPB_PTY_3RD          --TPB_3rd Party 해당 TPB의 3rd         Party Name     " ).append("\n"); 
		query.append("                     , MAX(CASE WHEN Z.OTS_STS_CD IN ('R','T','J') THEN COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD02799',X.OTS_STS_DTL_CD)" ).append("\n"); 
		query.append("                                ELSE COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00588', Z.OTS_STS_CD)" ).append("\n"); 
		query.append("                           END) AS TPB_STS_NM -- TPB status" ).append("\n"); 
		query.append("                  FROM TPB_OTS_GRP X" ).append("\n"); 
		query.append("                     , TPB_ADJ_STS Y" ).append("\n"); 
		query.append("                     , TPB_OTS_GRP_STS Z" ).append("\n"); 
		query.append("                     , TPB_OTS_DTL W" ).append("\n"); 
		query.append("                 WHERE X.N3PTY_NO           = Y.N3PTY_NO(+)" ).append("\n"); 
		query.append("                   AND Y.STL_STS_LST_FLG(+) = 'Y' " ).append("\n"); 
		query.append("                   AND Y.N3PTY_STL_TP_CD(+) = 'O'" ).append("\n"); 
		query.append("                   AND X.N3PTY_NO           = Z.N3PTY_NO" ).append("\n"); 
		query.append("                   AND Z.OTS_STS_LST_FLG    = 'Y' " ).append("\n"); 
		query.append("                   AND X.N3PTY_NO           = W.N3PTY_NO " ).append("\n"); 
		query.append("                   AND W.N3PTY_BIL_TP_CD    = 'RH'" ).append("\n"); 
		query.append("                   AND W.N3PTY_EXPN_TP_CD   = 'TES'" ).append("\n"); 
		query.append("                   AND W.N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("                   AND W.BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND W.EQ_NO  IS NOT NULL" ).append("\n"); 
		query.append("                 GROUP BY W.BKG_NO, W.EQ_NO" ).append("\n"); 
		query.append("               ) TPB" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND TOR_CNTR_NO    = BKG.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND TOR.VSL_CD     = BKG.VSL_CD(+)" ).append("\n"); 
		query.append("           AND TOR.SKD_VOY_NO = BKG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           --AND TOR.SKD_DIR_CD = BKG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND TOR.LANE_CD    = BKG.SLAN_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO     = TPB.TPB_BKG_NO(+)" ).append("\n"); 
		query.append("           AND BKG.CNTR_NO    = TPB.TPB_CNTR_NO(+)" ).append("\n"); 
		query.append("           #if (${s_bkg_no} != '')" ).append("\n"); 
		query.append("                AND INSTR(@[s_bkg_no], BKG.BKG_NO) > 0" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (${s_tpb_flg} == 'Y')" ).append("\n"); 
		query.append("                AND TPB.TPB_NO IS NOT NULL" ).append("\n"); 
		query.append("           #elseif (${s_tpb_flg} == 'N')" ).append("\n"); 
		query.append("                AND TPB.TPB_NO IS NULL " ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("         GROUP BY " ).append("\n"); 
		query.append("               TOR.OFC_CD " ).append("\n"); 
		query.append("             , TOR.PORT_CD" ).append("\n"); 
		query.append("             , TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD" ).append("\n"); 
		query.append("             , TOR.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , TOR.LANE_CD" ).append("\n"); 
		query.append("             , TOR.ACT_DEP_DT" ).append("\n"); 
		query.append("             , TOR.CNTR_NO" ).append("\n"); 
		query.append("             , TOR.RESPB_CNTR_NO" ).append("\n"); 
		query.append("             , TOR.SZTP" ).append("\n"); 
		query.append("             , TOR.POL" ).append("\n"); 
		query.append("             , TOR.OPR_CD" ).append("\n"); 
		query.append("             , TOR.PRECELL" ).append("\n"); 
		query.append("             , TOR.POSITION" ).append("\n"); 
		query.append("             , TOR.SHIFT_RSN" ).append("\n"); 
		query.append("             , TOR.PARTY" ).append("\n"); 
		query.append("             , TOR.FILE_ATCH" ).append("\n"); 
		query.append("             , TPB.TPB_NO" ).append("\n"); 
		query.append("             , TPB.TPB_AMT_USD" ).append("\n"); 
		query.append("             , TPB.TPB_OFC" ).append("\n"); 
		query.append("             , TPB.TPB_PTY_3RD" ).append("\n"); 
		query.append("             , TPB.TPB_STS_NM" ).append("\n"); 
		query.append("             , BKG.BKG_NO" ).append("\n"); 
		query.append("             , TOR.CNTR_HNDL_KND_CD" ).append("\n"); 
		query.append("         ORDER BY " ).append("\n"); 
		query.append("               TOR.OFC_CD" ).append("\n"); 
		query.append("             , TOR.PORT_CD" ).append("\n"); 
		query.append("             , TOR.VSL_CD||TOR.SKD_VOY_NO||TOR.SKD_DIR_CD" ).append("\n"); 
		query.append("             , TOR.CNTR_NO" ).append("\n"); 
		query.append("             , TO_CHAR(TOR.ACT_DEP_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("             , BKG.BKG_NO" ).append("\n"); 
		query.append("        )RT" ).append("\n"); 
		query.append("WHERE 	1 = 1" ).append("\n"); 
		query.append("       	#if (${s_eac_if} != '')" ).append("\n"); 
		query.append("        	#if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("             	AND EXISTS (SELECT 	'1'" ).append("\n"); 
		query.append("							FROM   	EAS_RHND_CHG_CHK X" ).append("\n"); 
		query.append("         					WHERE  	X.VSL_CD			  = SUBSTR(RT.VVD,1,4)" ).append("\n"); 
		query.append("				 					AND X.SKD_VOY_NO	  = SUBSTR(RT.VVD,5,4)" ).append("\n"); 
		query.append("				 					AND X.SKD_DIR_CD  	  = SUBSTR(RT.VVD,9,1)" ).append("\n"); 
		query.append("                 					AND X.PORT_CD        = RT.PORT_CD" ).append("\n"); 
		query.append("                 					AND X.CLPT_IND_SEQ   = RT.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 					AND X.CNTR_NO        = RT.CNTR_NO" ).append("\n"); 
		query.append("                 					AND X.RHND_EXPN_SEQ  = RT.RHND_EXPN_SEQ" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("          	#else" ).append("\n"); 
		query.append("             	AND NOT EXISTS (SELECT 	'1'" ).append("\n"); 
		query.append("                	            FROM   	EAS_RHND_CHG_CHK X" ).append("\n"); 
		query.append("         						WHERE  	X.VSL_CD			  = SUBSTR(RT.VVD,1,4)" ).append("\n"); 
		query.append("				 						AND X.SKD_VOY_NO	  = SUBSTR(RT.VVD,5,4)" ).append("\n"); 
		query.append("				 						AND X.SKD_DIR_CD  	  = SUBSTR(RT.VVD,9,1)" ).append("\n"); 
		query.append("                 						AND X.PORT_CD        = RT.PORT_CD" ).append("\n"); 
		query.append("                 						AND X.CLPT_IND_SEQ   = RT.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                 						AND X.CNTR_NO        = RT.CNTR_NO" ).append("\n"); 
		query.append("                 						AND X.RHND_EXPN_SEQ  = RT.RHND_EXPN_SEQ" ).append("\n"); 
		query.append("                         		)" ).append("\n"); 
		query.append("          	#end" ).append("\n"); 
		query.append("       	#end" ).append("\n"); 

	}
}