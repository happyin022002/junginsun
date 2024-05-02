/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchCleaningContainerBKGListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchCleaningContainerBKGListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특수 컨테이너 클리닝 실시한 컨테이너 조회 및 BKG data 연동
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchCleaningContainerBKGListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_row",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_row",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchCleaningContainerBKGListRSQL").append("\n"); 
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
		query.append("SELECT   A.WO_NO" ).append("\n"); 
		query.append("       , A.WO_USER" ).append("\n"); 
		query.append("       , A.RHQ_COST_OFC_CD RHQ_OFC_CD" ).append("\n"); 
		query.append("       , A.COST_OFC_CD OFC_CD" ).append("\n"); 
		query.append("       , A.MNR_INP_DT" ).append("\n"); 
		query.append("       , A.COST_DTL_CD" ).append("\n"); 
		query.append("       , A.EQ_NO" ).append("\n"); 
		query.append("       , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("       , A.COST_DTL_NM" ).append("\n"); 
		query.append("       , A.CURR_CD" ).append("\n"); 
		query.append("       , A.COST_AMT" ).append("\n"); 
		query.append("       , A.LOC_CD" ).append("\n"); 
		query.append("       , A.YD_CD" ).append("\n"); 
		query.append("       , A.LSTM_CD" ).append("\n"); 
		query.append("       , A.OWNR_CO_CD" ).append("\n"); 
		query.append("       , A.TOTAL" ).append("\n"); 
		query.append("       , A.PRE_BKG_NO" ).append("\n"); 
		query.append("       , B1.POD_NOD_CD POD_YARD" ).append("\n"); 
		query.append("       , B1.CMDT_CD PRE_CMDT_CD" ).append("\n"); 
		query.append("       , C1.CMDT_NM PRE_CMDT_NM" ).append("\n"); 
		query.append("       , D1.CSTMS_DESC PRE_CSTMS_DESC" ).append("\n"); 
		query.append("       , E1.DCGO_FLG AS PRE_DG" ).append("\n"); 
		query.append("       , E1.AWK_CGO_FLG AS PRE_AK" ).append("\n"); 
		query.append("       , E1.RC_FLG AS PRE_RF" ).append("\n"); 
		query.append("       , E1.RD_CGO_FLG AS PRE_RD" ).append("\n"); 
		query.append("       , DECODE(E1.RC_FLG, 'Y', (SELECT G.CDO_TEMP FROM BKG_RF_CGO G WHERE G.BKG_NO = A.PRE_BKG_NO AND ROWNUM = 1), '') PRE_CDO_TEMP" ).append("\n"); 
		query.append("       , SUBSTR(DECODE(E1.DCGO_FLG, 'Y', ', DG', '') || DECODE(E1.AWK_CGO_FLG, 'Y', ', AK', '') || DECODE(E1.RC_FLG, 'Y', ', RF', '') || DECODE(E1.RD_CGO_FLG, 'Y', ', RD', ''), 2) PRE_SPECIAL" ).append("\n"); 
		query.append("       , DECODE(E1.DCGO_FLG, 'Y', (SELECT G.IMDG_UN_NO FROM BKG_DG_CGO G WHERE G.BKG_NO = A.PRE_BKG_NO AND G.CNTR_CGO_SEQ = 1 AND ROWNUM = 1), '') PRE_UN_NO" ).append("\n"); 
		query.append("       , A.POST_BKG_NO" ).append("\n"); 
		query.append("       , B2.POL_NOD_CD POL_YARD" ).append("\n"); 
		query.append("       , B2.CMDT_CD POST_CMDT_CD" ).append("\n"); 
		query.append("       , C2.CMDT_NM POST_CMDT_NM" ).append("\n"); 
		query.append("       , D2.CSTMS_DESC POST_CSTMS_DESC" ).append("\n"); 
		query.append("       , E2.DCGO_FLG AS POST_DG" ).append("\n"); 
		query.append("       , E2.AWK_CGO_FLG AS POST_AK" ).append("\n"); 
		query.append("       , E2.RC_FLG AS POST_RF" ).append("\n"); 
		query.append("       , E2.RD_CGO_FLG AS POST_RD" ).append("\n"); 
		query.append("       , DECODE(E2.DCGO_FLG, 'Y', (SELECT G.IMDG_UN_NO FROM BKG_DG_CGO G WHERE G.BKG_NO = A.POST_BKG_NO AND G.CNTR_CGO_SEQ = 1 AND ROWNUM = 1), '') POST_UN_NO" ).append("\n"); 
		query.append("       , DECODE(E2.RC_FLG, 'Y', (SELECT G.CDO_TEMP FROM BKG_RF_CGO G WHERE G.BKG_NO = A.POST_BKG_NO AND ROWNUM = 1), '') POST_CDO_TEMP" ).append("\n"); 
		query.append("       , SUBSTR(DECODE(E2.DCGO_FLG, 'Y', ', DG', '') || DECODE(E2.AWK_CGO_FLG, 'Y', ', AK', '') || DECODE(E2.RC_FLG, 'Y', ', RF', '') || DECODE(E2.RD_CGO_FLG, 'Y', ', RD', ''), 2) POST_SPECIAL" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   WO_NO" ).append("\n"); 
		query.append("			      , WO_USER" ).append("\n"); 
		query.append("                  , RHQ_COST_OFC_CD" ).append("\n"); 
		query.append("                  , COST_OFC_CD" ).append("\n"); 
		query.append("                  , TO_CHAR(MNR_INP_DT, 'YYYY-MM-DD') MNR_INP_DT" ).append("\n"); 
		query.append("                  , COST_DTL_CD" ).append("\n"); 
		query.append("                  , EQ_NO" ).append("\n"); 
		query.append("                  , EQ_TPSZ_CD" ).append("\n"); 
		query.append("                  , COST_DTL_NM" ).append("\n"); 
		query.append("                  , CURR_CD" ).append("\n"); 
		query.append("                  , COST_AMT" ).append("\n"); 
		query.append("                  , LOC_CD" ).append("\n"); 
		query.append("                  , YD_CD" ).append("\n"); 
		query.append("                  , LSTM_CD" ).append("\n"); 
		query.append("                  , OWNR_CO_CD" ).append("\n"); 
		query.append("                  , TOTAL" ).append("\n"); 
		query.append("                  , PRE_BKG_NO" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      WITH POST AS" ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                        SELECT   M.BKG_NO" ).append("\n"); 
		query.append("                               , CNTR_NO" ).append("\n"); 
		query.append("                               , CNMV_EVNT_DT" ).append("\n"); 
		query.append("                        FROM     CTM_MOVEMENT M" ).append("\n"); 
		query.append("                               , BKG_BOOKING K" ).append("\n"); 
		query.append("                        WHERE    1 = 1" ).append("\n"); 
		query.append("                        AND      M.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("                        AND      K.POL_NOD_CD LIKE @[s_cnt_cd] || '%'" ).append("\n"); 
		query.append("                        AND      M.MVMT_STS_CD = 'OP'" ).append("\n"); 
		query.append("                        AND      M.CNMV_EVNT_DT BETWEEN TO_DATE(@[s_start_dt]||'000000', 'YYYY-MM-DDHH24MISS') - 120 AND TO_DATE(@[s_end_dt]||'000000', 'YYYY-MM-DDHH24MISS') + 120" ).append("\n"); 
		query.append("                        ORDER BY CNMV_EVNT_DT ASC" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                      SELECT   BKG_NO" ).append("\n"); 
		query.append("                      FROM     POST" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      POST.CNTR_NO = A.EQ_NO" ).append("\n"); 
		query.append("                      AND      POST.CNMV_EVNT_DT > NVL(A.PRE_EVNT_DT, A.MNR_INP_DT)" ).append("\n"); 
		query.append("                      AND      ROWNUM = 1" ).append("\n"); 
		query.append("                    ) AS POST_BKG_NO" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   A.MNR_ORD_OFC_CTY_CD || A.MNR_ORD_SEQ AS WO_NO" ).append("\n"); 
		query.append("				             , ( SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID AND ROWNUM = 1 ) AS WO_USER" ).append("\n"); 
		query.append("                             , MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.COST_OFC_CD) AS RHQ_COST_OFC_CD" ).append("\n"); 
		query.append("                             , A.COST_OFC_CD" ).append("\n"); 
		query.append("                             , A.MNR_INP_DT" ).append("\n"); 
		query.append("                             , B.COST_DTL_CD" ).append("\n"); 
		query.append("                             , B.EQ_NO" ).append("\n"); 
		query.append("                             , B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                             , ( SELECT MNR_CD_DP_DESC FROM MNR_GEN_CD G WHERE G.MNR_CD_ID = B.COST_DTL_CD AND G.PRNT_CD_ID = 'MRDRCL' ) AS COST_DTL_NM" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , B.COST_AMT " ).append("\n"); 
		query.append("                             , SUBSTR(B.YD_CD, 1, 5) AS LOC_CD" ).append("\n"); 
		query.append("                             , B.YD_CD" ).append("\n"); 
		query.append("                             , C.LSTM_CD" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   DECODE(INTG_CD_VAL_CTNT,'H','SM Line',INTG_CD_VAL_DP_DESC)" ).append("\n"); 
		query.append("                                 FROM     COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      INTG_CD_ID ='CD01047'" ).append("\n"); 
		query.append("                                 AND      CD.INTG_CD_VAL_CTNT = C.OWNR_CO_CD" ).append("\n"); 
		query.append("                               ) AS OWNR_CO_CD" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 WITH PRE AS" ).append("\n"); 
		query.append("                                 (" ).append("\n"); 
		query.append("                                   SELECT   M.BKG_NO" ).append("\n"); 
		query.append("                                          , CNTR_NO" ).append("\n"); 
		query.append("                                   FROM     CTM_MOVEMENT M" ).append("\n"); 
		query.append("                                          , BKG_BOOKING K" ).append("\n"); 
		query.append("                                   WHERE    1 = 1" ).append("\n"); 
		query.append("                                   AND      M.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("                                   AND      K.POD_NOD_CD LIKE @[s_cnt_cd] || '%'" ).append("\n"); 
		query.append("                                   AND      M.MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("                                   AND      M.CNMV_EVNT_DT BETWEEN TO_DATE(@[s_start_dt]||'000000', 'YYYY-MM-DDHH24MISS') - 120 AND TO_DATE(@[s_end_dt]||'000000', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("                                   ORDER BY CNMV_EVNT_DT DESC" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                                 SELECT   BKG_NO" ).append("\n"); 
		query.append("                                 FROM     PRE" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      PRE.CNTR_NO = B.EQ_NO" ).append("\n"); 
		query.append("                                 AND      ROWNUM = 1" ).append("\n"); 
		query.append("                               ) AS PRE_BKG_NO" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 WITH PRE AS" ).append("\n"); 
		query.append("                                 (" ).append("\n"); 
		query.append("                                   SELECT   CNMV_EVNT_DT" ).append("\n"); 
		query.append("                                          , CNTR_NO" ).append("\n"); 
		query.append("                                   FROM     CTM_MOVEMENT M" ).append("\n"); 
		query.append("                                          , BKG_BOOKING K" ).append("\n"); 
		query.append("                                   WHERE    1 = 1" ).append("\n"); 
		query.append("                                   AND      M.BKG_NO = K.BKG_NO" ).append("\n"); 
		query.append("                                   AND      K.POD_NOD_CD LIKE @[s_cnt_cd] || '%'" ).append("\n"); 
		query.append("                                   AND      M.MVMT_STS_CD = 'IC'" ).append("\n"); 
		query.append("                                   AND      M.CNMV_EVNT_DT BETWEEN TO_DATE(@[s_start_dt]||'000000', 'YYYY-MM-DDHH24MISS') - 120 AND TO_DATE(@[s_end_dt]||'000000', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("                                   ORDER BY CNMV_EVNT_DT DESC" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                                 SELECT   CNMV_EVNT_DT" ).append("\n"); 
		query.append("                                 FROM     PRE" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      PRE.CNTR_NO = B.EQ_NO" ).append("\n"); 
		query.append("                                 AND      ROWNUM = 1" ).append("\n"); 
		query.append("                               ) AS PRE_EVNT_DT" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER(ORDER BY A.MNR_INP_DT ASC) AS RNUM" ).append("\n"); 
		query.append("                             , COUNT(MNR_INP_DT) OVER() AS TOTAL" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_HDR A" ).append("\n"); 
		query.append("                             , MNR_ORD_DTL B" ).append("\n"); 
		query.append("                             , MST_CONTAINER C" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                      AND      B.EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                      AND      B.COST_CD = 'MRDRCL'" ).append("\n"); 
		query.append("                      AND      A.MNR_INP_DT BETWEEN TO_DATE(@[s_start_dt]||'000000', 'YYYY-MM-DDHH24MISS') AND TO_DATE(@[s_end_dt]||'235959', 'YYYY-MM-DDHH24MISS')" ).append("\n"); 
		query.append("                      AND      A.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                      AND      B.EQ_NO IS NOT NULL" ).append("\n"); 
		query.append("                      AND      B.YD_CD LIKE @[s_cnt_cd] || '%'" ).append("\n"); 
		query.append("#if(${s_loc_cd} != '')" ).append("\n"); 
		query.append("                      AND      B.YD_CD LIKE @[s_loc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_yd_cd} != '')" ).append("\n"); 
		query.append("                      AND      B.YD_CD = @[s_loc_cd] || @[s_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eq_tpsz_cd} != '')" ).append("\n"); 
		query.append("                      AND      B.EQ_TPSZ_CD IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("    #foreach ($tpszCd IN ${eqTpSzCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $eqTpSzCds.size())" ).append("\n"); 
		query.append("                                  '$tpszCd'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                                  '$tpszCd'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end              " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_eq_no} != '')" ).append("\n"); 
		query.append("                      AND      B.EQ_NO IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("    #foreach ($eqNo IN ${eqNos})" ).append("\n"); 
		query.append("        #if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("                                  '$eqNo'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                                  '$eqNo'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end              " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_cost_dtl_cd} != '')" ).append("\n"); 
		query.append("                      AND      B.COST_DTL_CD IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("    #foreach ($costDtlCd IN ${costDtlCds})" ).append("\n"); 
		query.append("        #if($velocityCount < $costDtlCds.size())" ).append("\n"); 
		query.append("                                  '$costDtlCd'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("                                  '$costDtlCd'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("    #end              " ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    ) A " ).append("\n"); 
		query.append("          WHERE     1 = 1" ).append("\n"); 
		query.append("          AND       A.RNUM BETWEEN @[start_row] AND @[end_row]" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append("       , BKG_BOOKING B1" ).append("\n"); 
		query.append("       , BKG_BOOKING B2" ).append("\n"); 
		query.append("       , MDM_COMMODITY C1" ).append("\n"); 
		query.append("       , MDM_COMMODITY C2" ).append("\n"); 
		query.append("       , BKG_BL_DOC D1" ).append("\n"); 
		query.append("       , BKG_BL_DOC D2" ).append("\n"); 
		query.append("       , BKG_CONTAINER E1" ).append("\n"); 
		query.append("       , BKG_CONTAINER E2" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.PRE_BKG_NO = B1.BKG_NO(+)" ).append("\n"); 
		query.append("AND      A.POST_BKG_NO = B2.BKG_NO(+)" ).append("\n"); 
		query.append("AND      B1.CMDT_CD = C1.CMDT_CD(+)" ).append("\n"); 
		query.append("AND      B2.CMDT_CD = C2.CMDT_CD(+)" ).append("\n"); 
		query.append("AND      B1.BKG_NO = D1.BKG_NO(+)" ).append("\n"); 
		query.append("AND      B2.BKG_NO = D2.BKG_NO(+)" ).append("\n"); 
		query.append("AND      A.EQ_NO = E1.CNTR_NO(+)" ).append("\n"); 
		query.append("AND      A.PRE_BKG_NO = E1.BKG_NO(+)" ).append("\n"); 
		query.append("AND      A.EQ_NO = E2.CNTR_NO(+)" ).append("\n"); 
		query.append("AND      A.POST_BKG_NO = E2.BKG_NO(+)" ).append("\n"); 
		query.append("#if(${s_cargo_type} != '')" ).append("\n"); 
		query.append("    #if(${s_cargo_type} == 'AK')" ).append("\n"); 
		query.append("AND      ( E1.AWK_CGO_FLG = 'Y' OR E2.AWK_CGO_FLG = 'Y' )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${s_cargo_type} == 'DG')" ).append("\n"); 
		query.append("AND      ( E1.DCGO_FLG = 'Y' OR E2.DCGO_FLG = 'Y' )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${s_cargo_type} == 'DR')" ).append("\n"); 
		query.append("AND      ( E1.RD_CGO_FLG = 'Y' OR E2.RD_CGO_FLG = 'Y')" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if(${s_cargo_type} == 'RF')" ).append("\n"); 
		query.append("AND      ( E1.RC_FLG = 'Y' OR E2.RC_FLG = 'Y' )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}