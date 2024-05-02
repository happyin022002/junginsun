/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAO021FcastPortViewListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAO021FcastPortViewListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSpaceControlInquiry021FcastPortViewList
	  * 
	  * 2016.05.12 SPC_GET_HC_RT_BSA_FNC : SKD_VOY_NO parm 추가
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAO021FcastPortViewListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAO021FcastPortViewListRSQL").append("\n"); 
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
		query.append("WITH VVDS AS (" ).append("\n"); 
		query.append("    SELECT M.TRD_CD    ," ).append("\n"); 
		query.append("           M.SUB_TRD_CD," ).append("\n"); 
		query.append("           M.RLANE_CD  ," ).append("\n"); 
		query.append("           M.DIR_CD    ," ).append("\n"); 
		query.append("           M.IOC_CD    ," ).append("\n"); 
		query.append("           W.COST_YR   ," ).append("\n"); 
		query.append("           SUBSTR(M.SLS_YRMON, 5) AS COST_MON," ).append("\n"); 
		query.append("           M.COST_WK   ," ).append("\n"); 
		query.append("           W.NUM       ," ).append("\n"); 
		query.append("           M.VSL_CD    ," ).append("\n"); 
		query.append("           M.SKD_VOY_NO," ).append("\n"); 
		query.append("           M.DIR_CD AS SKD_DIR_CD," ).append("\n"); 
		query.append("           RHQ_CD    AS RHQ_CD," ).append("\n"); 
		query.append("           AQ_CD  ," ).append("\n"); 
		query.append("           OFC_CD ," ).append("\n"); 
		query.append("           PORT_CD," ).append("\n"); 
		query.append("           SPC_GET_WK_VVD_BSA_FNC('VOL', M.TRD_CD, M.RLANE_CD, M.DIR_CD, SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK, M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD) AS BSA" ).append("\n"); 
		query.append("      FROM COA_MON_VVD M," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("              SELECT /*+ INDEX(P XPKCOA_WK_PRD) */" ).append("\n"); 
		query.append("                     P.COST_YR ," ).append("\n"); 
		query.append("                     P.COST_WK ," ).append("\n"); 
		query.append("                     ROWNUM AS NUM," ).append("\n"); 
		query.append("                     YR        ," ).append("\n"); 
		query.append("                     WK        ," ).append("\n"); 
		query.append("                     DUR       ," ).append("\n"); 
		query.append("                     TRD_CD    ," ).append("\n"); 
		query.append("                     SUB_TRD_CD," ).append("\n"); 
		query.append("                     DIR_CD    ," ).append("\n"); 
		query.append("                     RHQ_CD    ," ).append("\n"); 
		query.append("                     AQ_CD     ," ).append("\n"); 
		query.append("                     OFC_CD    ," ).append("\n"); 
		query.append("                     PORT_CD" ).append("\n"); 
		query.append("                FROM COA_WK_PRD P," ).append("\n"); 
		query.append("                     (" ).append("\n"); 
		query.append("                        SELECT @[year]     AS YR    ," ).append("\n"); 
		query.append("                               @[week]     AS WK    ," ).append("\n"); 
		query.append("                               @[duration] AS DUR   ," ).append("\n"); 
		query.append("                               @[trade]    AS TRD_CD," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("#if (${subtrade1} != '')" ).append("\n"); 
		query.append("                               @[subtrade1] AS SUB_TRD_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                               @[subtrade2] AS SUB_TRD_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("                               @[bound]        AS DIR_CD ," ).append("\n"); 
		query.append("                               @[rhq]          AS RHQ_CD ," ).append("\n"); 
		query.append("                               @[area]         AS AQ_CD  ," ).append("\n"); 
		query.append("                               @[sales_office] AS OFC_CD ," ).append("\n"); 
		query.append("                               @[pol_cd]       AS PORT_CD" ).append("\n"); 
		query.append("                          FROM DUAL" ).append("\n"); 
		query.append("                     ) PARAMS" ).append("\n"); 
		query.append("               WHERE P.COST_YR||P.COST_WK >= YR||WK" ).append("\n"); 
		query.append("                 AND ROWNUM               <= DUR" ).append("\n"); 
		query.append("           )       W," ).append("\n"); 
		query.append("           COM_CPY_NO  P" ).append("\n"); 
		query.append("     WHERE (SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK) = W.COST_YR||W.COST_WK" ).append("\n"); 
		query.append("       AND M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("       AND M.TRD_CD   = W.TRD_CD" ).append("\n"); 
		query.append("       AND M.SUB_TRD_CD LIKE W.SUB_TRD_CD || '%'" ).append("\n"); 
		query.append("       AND M.DIR_CD     LIKE W.DIR_CD || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       AND P.CPY_NO < 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTA AS (" ).append("\n"); 
		query.append("    SELECT T2.SAQ_RGN_OFC_CD      AS OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK   AS WK    ," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           ROUND(SUM(T1.LOD_QTY)) AS LOAD  ," ).append("\n"); 
		query.append("           0 AS GREV  ," ).append("\n"); 
		query.append("           0 AS CMCOST" ).append("\n"); 
		query.append("      FROM VVDS               A ," ).append("\n"); 
		query.append("           SAQ_MON_CFM_QTA    T1," ).append("\n"); 
		query.append("           SAQ_MON_QTA_RLSE   B ," ).append("\n"); 
		query.append("           SPC_OFC_LVL        T2" ).append("\n"); 
		query.append("     WHERE B.BSE_YR            = A.COST_YR" ).append("\n"); 
		query.append("       AND B.BSE_QTR_CD        = CEIL(TO_NUMBER(A.COST_MON) / 3)||'Q'" ).append("\n"); 
		query.append("       AND B.QTA_RLSE_STS_CD   = 'R'" ).append("\n"); 
		query.append("       AND T1.MQTA_RLSE_VER_NO = B.MQTA_RLSE_VER_NO" ).append("\n"); 
		query.append("       AND T1.BSE_YR           = B.BSE_YR" ).append("\n"); 
		query.append("       AND T1.BSE_QTR_CD       = B.BSE_QTR_CD" ).append("\n"); 
		query.append("       AND T1.QTA_TGT_CD       = 'T'" ).append("\n"); 
		query.append("       AND T1.BSE_MON          = A.COST_MON" ).append("\n"); 
		query.append("       AND T1.TRD_CD           = A.TRD_CD" ).append("\n"); 
		query.append("       AND T1.RLANE_CD         = A.RLANE_CD" ).append("\n"); 
		query.append("       AND T1.DIR_CD           = A.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND T1.VSL_CD           = A.VSL_CD" ).append("\n"); 
		query.append("       AND T1.SKD_VOY_NO       = A.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND T1.SKD_DIR_CD       = A.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND (A.PORT_CD IS NULL OR T1.POL_CD         = A.PORT_CD)" ).append("\n"); 
		query.append("       AND (A.RHQ_CD  IS NULL OR T1.RHQ_CD         = A.RHQ_CD )" ).append("\n"); 
		query.append("       AND (A.AQ_CD   IS NULL OR T1.AQ_CD          = A.AQ_CD  )" ).append("\n"); 
		query.append("       AND (A.OFC_CD  IS NULL OR T2.SAQ_RGN_OFC_CD = A.OFC_CD )" ).append("\n"); 
		query.append("       AND T1.RGN_OFC_CD = T2.OFC_CD" ).append("\n"); 
		query.append("       AND A.COST_YR || A.COST_WK BETWEEN T2.OFC_APLY_FM_YRWK AND T2.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("  GROUP BY T2.SAQ_RGN_OFC_CD   ," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK," ).append("\n"); 
		query.append("           A.NUM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", FCST AS (" ).append("\n"); 
		query.append("    SELECT B.SLS_RGN_OFC_CD     AS OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK AS WK    ," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           SUM(NVL(B.CFM_TTL_QTY, 0) + NVL(B.CFM_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD, B.RLANE_CD, B.DIR_CD, B.VSL_CD, B.SKD_VOY_NO, 'D5') + NVL(B.CFM_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD, B.RLANE_CD, B.DIR_CD, B.VSL_CD, B.SKD_VOY_NO, 'D7') + NVL(B.CFM_53FT_QTY, 0) * 2) AS LOAD," ).append("\n"); 
		query.append("           0 AS GREV  ," ).append("\n"); 
		query.append("           0 AS CMCOST" ).append("\n"); 
		query.append("      FROM VVDS               A," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_CUST B" ).append("\n"); 
		query.append("     WHERE B.TRD_CD     = A.TRD_CD" ).append("\n"); 
		query.append("       AND B.SUB_TRD_CD = A.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND B.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("       AND B.IOC_TS_CD  = A.IOC_CD" ).append("\n"); 
		query.append("       AND B.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("       AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND B.SKD_DIR_CD = A.DIR_CD " ).append("\n"); 
		query.append("       AND B.DIR_CD     = A.DIR_CD " ).append("\n"); 
		query.append("       AND B.SLS_RHQ_CD          LIKE A.RHQ_CD  || '%'" ).append("\n"); 
		query.append("       AND NVL(B.SLS_AQ_CD, ' ') LIKE A.AQ_CD   || '%'" ).append("\n"); 
		query.append("       AND B.SLS_RGN_OFC_CD      LIKE A.OFC_CD  || '%'" ).append("\n"); 
		query.append("       AND B.POL_YD_CD           LIKE A.PORT_CD || '%'" ).append("\n"); 
		query.append("  GROUP BY B.SLS_RGN_OFC_CD    ," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK," ).append("\n"); 
		query.append("           A.NUM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", PFCST AS (" ).append("\n"); 
		query.append("    SELECT B.SLS_RGN_OFC_CD     AS OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK AS WK    ," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           SUM(NVL(B.FCAST_LOD_QTY, 0) + NVL(B.FCAST_40FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD, B.RLANE_CD, B.DIR_CD, B.VSL_CD, B.SKD_VOY_NO, 'D5') + NVL(B.FCAST_45FT_HC_QTY, 0) * SPC_GET_HC_RT_BSA_FNC(B.TRD_CD, B.RLANE_CD, B.DIR_CD, B.VSL_CD, B.SKD_VOY_NO, 'D7') + NVL(B.FCAST_53FT_QTY, 0) * 2) AS LOAD," ).append("\n"); 
		query.append("           0 AS GREV  ," ).append("\n"); 
		query.append("           0 AS CMCOST" ).append("\n"); 
		query.append("      FROM VVDS              A," ).append("\n"); 
		query.append("           SPC_DLY_FCAST_HIS B" ).append("\n"); 
		query.append("     WHERE B.FCAST_TP_CD = 'D'" ).append("\n"); 
		query.append("       AND B.TRD_CD      = A.TRD_CD" ).append("\n"); 
		query.append("       AND B.SUB_TRD_CD  = A.SUB_TRD_CD" ).append("\n"); 
		query.append("       AND B.RLANE_CD    = A.RLANE_CD" ).append("\n"); 
		query.append("       AND B.IOC_TS_CD   = A.IOC_CD" ).append("\n"); 
		query.append("       AND B.VSL_CD      = A.VSL_CD" ).append("\n"); 
		query.append("       AND B.SKD_VOY_NO  = A.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND B.SKD_DIR_CD  = A.DIR_CD" ).append("\n"); 
		query.append("       AND B.DIR_CD      = A.DIR_CD" ).append("\n"); 
		query.append("       AND B.OFC_KND_CD  = '3'" ).append("\n"); 
		query.append("       AND B.SLS_RHQ_CD          LIKE A.RHQ_CD  || '%'" ).append("\n"); 
		query.append("       AND NVL(B.SLS_AQ_CD, ' ') LIKE A.AQ_CD   || '%'" ).append("\n"); 
		query.append("       AND B.SLS_RGN_OFC_CD      LIKE A.OFC_CD  || '%'" ).append("\n"); 
		query.append("       AND B.POL_YD_CD           LIKE A.PORT_CD || '%'" ).append("\n"); 
		query.append("       AND B.BSE_DT = ( SELECT /*+ INDEX_DESC(C XPKSPC_DLY_FCAST_HIS) */" ).append("\n"); 
		query.append("                               MIN(C.BSE_DT)" ).append("\n"); 
		query.append("                          FROM SPC_DLY_FCAST_HIS C" ).append("\n"); 
		query.append("                         WHERE B.FCAST_TP_CD = 'D'" ).append("\n"); 
		query.append("                           AND C.FCAST_TP_CD = B.FCAST_TP_CD" ).append("\n"); 
		query.append("                           AND C.OFC_KND_CD  = B.OFC_KND_CD" ).append("\n"); 
		query.append("                           AND C.RLANE_CD    = B.RLANE_CD" ).append("\n"); 
		query.append("                           AND C.DIR_CD      = B.DIR_CD" ).append("\n"); 
		query.append("                           AND C.VSL_CD      = B.VSL_CD" ).append("\n"); 
		query.append("                           AND C.SKD_VOY_NO  = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND C.SKD_DIR_CD  = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND C.SLS_OFC_CD  = B.SLS_OFC_CD" ).append("\n"); 
		query.append("                           AND C.POL_YD_CD   = B.POL_YD_CD" ).append("\n"); 
		query.append("                           AND C.POD_YD_CD   = B.POD_YD_CD" ).append("\n"); 
		query.append("                           AND B.OFC_KND_CD  = '3'" ).append("\n"); 
		query.append("                           AND ROWNUM < 3 )" ).append("\n"); 
		query.append("  GROUP BY B.SLS_RGN_OFC_CD    ," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK," ).append("\n"); 
		query.append("           A.NUM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BKG AS (" ).append("\n"); 
		query.append("    SELECT /*+ OPT_PARAM('_COMPLEX_VIEW_MERGING', 'FALSE')" ).append("\n"); 
		query.append("               FULL(B.O.Z.M) INDEX(B.Z2.BV XAK6BKG_BKG_VVD) INDEX(B.Z2.B XAK4BKG_BOOKING) */" ).append("\n"); 
		query.append("           B.SLS_RGN_OFC_CD     AS OFC_CD," ).append("\n"); 
		query.append("           A.COST_YR||A.COST_WK AS WK    ," ).append("\n"); 
		query.append("           A.NUM," ).append("\n"); 
		query.append("           BKG_TTL_QTY AS LOAD," ).append("\n"); 
		query.append("           0 AS GREV  ," ).append("\n"); 
		query.append("           0 AS CMCOST" ).append("\n"); 
		query.append("      FROM VVDS      A," ).append("\n"); 
		query.append("           SPC_BKG_V B" ).append("\n"); 
		query.append("     WHERE B.TRD_CD         = A.TRD_CD" ).append("\n"); 
		query.append("       AND B.RLANE_CD       = A.RLANE_CD" ).append("\n"); 
		query.append("       AND B.VSL_CD         = A.VSL_CD" ).append("\n"); 
		query.append("       AND B.SKD_VOY_NO     = A.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND B.SKD_DIR_CD     = A.DIR_CD" ).append("\n"); 
		query.append("       AND B.IOC_CD         = A.IOC_CD" ).append("\n"); 
		query.append("       AND B.BKG_CGO_TP_CD IN ('F', 'B', 'R')" ).append("\n"); 
		query.append("       AND B.BKG_STS_CD    IN ('F')" ).append("\n"); 
		query.append("       AND B.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("       AND B.POL_CD              LIKE A.PORT_CD || '%'" ).append("\n"); 
		query.append("       AND B.SLS_RHQ_CD          LIKE A.RHQ_CD  || '%'" ).append("\n"); 
		query.append("       AND NVL(B.SLS_AQ_CD, ' ') LIKE A.AQ_CD   || '%'" ).append("\n"); 
		query.append("       AND B.SLS_RGN_OFC_CD      LIKE A.OFC_CD  || '%'" ).append("\n"); 
		query.append("       AND B.RLANE_CD <> 'RBCCO'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TMP_DATA AS (" ).append("\n"); 
		query.append("    SELECT 1 AS FLG," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           LOAD   AS QTA_LOAD," ).append("\n"); 
		query.append("           GREV   AS QTA_GREV," ).append("\n"); 
		query.append("           CMCOST AS QTA_COST," ).append("\n"); 
		query.append("           0      AS FCT_LOAD," ).append("\n"); 
		query.append("           0      AS FCT_GREV," ).append("\n"); 
		query.append("           0      AS FCT_COST," ).append("\n"); 
		query.append("           0      AS PFC_LOAD," ).append("\n"); 
		query.append("           0      AS PFC_GREV," ).append("\n"); 
		query.append("           0      AS PFC_COST," ).append("\n"); 
		query.append("           0      AS BKG_LOAD," ).append("\n"); 
		query.append("           0      AS BKG_GREV," ).append("\n"); 
		query.append("           0      AS BKG_COST" ).append("\n"); 
		query.append("      FROM QTA" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 2 AS FLG," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           0      AS QTA_LOAD," ).append("\n"); 
		query.append("           0      AS QTA_GREV," ).append("\n"); 
		query.append("           0      AS QTA_COST," ).append("\n"); 
		query.append("           LOAD   AS FCT_LOAD," ).append("\n"); 
		query.append("           GREV   AS FCT_GREV," ).append("\n"); 
		query.append("           CMCOST AS FCT_COST," ).append("\n"); 
		query.append("           0      AS PFC_LOAD," ).append("\n"); 
		query.append("           0      AS PFC_GREV," ).append("\n"); 
		query.append("           0      AS PFC_COST," ).append("\n"); 
		query.append("           0      AS BKG_LOAD," ).append("\n"); 
		query.append("           0      AS BKG_GREV," ).append("\n"); 
		query.append("           0      AS BKG_COST" ).append("\n"); 
		query.append("      FROM FCST" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 3 AS FLG," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           0      AS QTA_LOAD," ).append("\n"); 
		query.append("           0      AS QTA_GREV," ).append("\n"); 
		query.append("           0      AS QTA_COST," ).append("\n"); 
		query.append("           0      AS FCT_LOAD," ).append("\n"); 
		query.append("           0      AS FCT_GREV," ).append("\n"); 
		query.append("           0      AS FCT_COST," ).append("\n"); 
		query.append("           LOAD   AS PFC_LOAD," ).append("\n"); 
		query.append("           GREV   AS PFC_GREV," ).append("\n"); 
		query.append("           CMCOST AS PFC_COST," ).append("\n"); 
		query.append("           0      AS BKG_LOAD," ).append("\n"); 
		query.append("           0      AS BKG_GREV," ).append("\n"); 
		query.append("           0      AS BKG_COST" ).append("\n"); 
		query.append("      FROM PFCST" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ALL_DATA AS (" ).append("\n"); 
		query.append("    SELECT 3 AS FLG," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           QTA_LOAD," ).append("\n"); 
		query.append("           QTA_GREV," ).append("\n"); 
		query.append("           QTA_COST," ).append("\n"); 
		query.append("           FCT_LOAD," ).append("\n"); 
		query.append("           FCT_GREV," ).append("\n"); 
		query.append("           FCT_COST," ).append("\n"); 
		query.append("           PFC_LOAD," ).append("\n"); 
		query.append("           PFC_GREV," ).append("\n"); 
		query.append("           PFC_COST," ).append("\n"); 
		query.append("           BKG_LOAD," ).append("\n"); 
		query.append("           BKG_GREV," ).append("\n"); 
		query.append("           BKG_COST" ).append("\n"); 
		query.append("      FROM TMP_DATA" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT 4 AS FLG," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           0         AS QTA_LOAD," ).append("\n"); 
		query.append("           0         AS QTA_GREV," ).append("\n"); 
		query.append("           0         AS QTA_COST," ).append("\n"); 
		query.append("           0         AS FCT_LOAD," ).append("\n"); 
		query.append("           0         AS FCT_GREV," ).append("\n"); 
		query.append("           0         AS FCT_COST," ).append("\n"); 
		query.append("           0         AS PFC_LOAD," ).append("\n"); 
		query.append("           0         AS PFC_GREV," ).append("\n"); 
		query.append("           0         AS PFC_COST," ).append("\n"); 
		query.append("           SUM(LOAD) AS BKG_LOAD," ).append("\n"); 
		query.append("           GREV      AS BKG_GREV," ).append("\n"); 
		query.append("           CMCOST    AS BKG_COST" ).append("\n"); 
		query.append("      FROM BKG" ).append("\n"); 
		query.append("  GROUP BY OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           GREV  ," ).append("\n"); 
		query.append("           CMCOST" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TGT AS (" ).append("\n"); 
		query.append("    SELECT OFC_CD," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           SUM(QTA_LOAD) AS QTA_LOAD," ).append("\n"); 
		query.append("           SUM(QTA_GREV) AS QTA_GREV," ).append("\n"); 
		query.append("           SUM(QTA_COST) AS QTA_COST," ).append("\n"); 
		query.append("           SUM(FCT_LOAD) AS FCT_LOAD," ).append("\n"); 
		query.append("           SUM(FCT_GREV) AS FCT_GREV," ).append("\n"); 
		query.append("           SUM(FCT_COST) AS FCT_COST," ).append("\n"); 
		query.append("           SUM(PFC_LOAD) AS PFC_LOAD," ).append("\n"); 
		query.append("           SUM(PFC_GREV) AS PFC_GREV," ).append("\n"); 
		query.append("           SUM(PFC_COST) AS PFC_COST," ).append("\n"); 
		query.append("           SUM(BKG_LOAD) AS BKG_LOAD," ).append("\n"); 
		query.append("           SUM(BKG_GREV) AS BKG_GREV," ).append("\n"); 
		query.append("           SUM(BKG_COST) AS BKG_COST" ).append("\n"); 
		query.append("      FROM ALL_DATA" ).append("\n"); 
		query.append("  GROUP BY OFC_CD," ).append("\n"); 
		query.append("           WK    ," ).append("\n"); 
		query.append("           NUM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BASE AS (" ).append("\n"); 
		query.append("    SELECT OFC_CD," ).append("\n"); 
		query.append("           NUM" ).append("\n"); 
		query.append("      FROM ( SELECT DISTINCT" ).append("\n"); 
		query.append("                    OFC_CD" ).append("\n"); 
		query.append("               FROM TMP_DATA )," ).append("\n"); 
		query.append("           (     SELECT LEVEL AS NUM" ).append("\n"); 
		query.append("                   FROM DUAL" ).append("\n"); 
		query.append("             CONNECT BY LEVEL <= ( SELECT DUR" ).append("\n"); 
		query.append("                                     FROM (" ).append("\n"); 
		query.append("                                            SELECT @[year]     AS YR    ," ).append("\n"); 
		query.append("                                                   @[week]     AS WK    ," ).append("\n"); 
		query.append("                                                   @[duration] AS DUR   ," ).append("\n"); 
		query.append("                                                   @[trade]    AS TRD_CD," ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("#if (${subtrade1} != '')" ).append("\n"); 
		query.append("                                                   @[subtrade1] AS SUB_TRD_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                   @[subtrade2] AS SUB_TRD_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                              " ).append("\n"); 
		query.append("                                                   @[bound]        AS DIR_CD ," ).append("\n"); 
		query.append("                                                   @[rhq]          AS RHQ_CD ," ).append("\n"); 
		query.append("                                                   @[area]         AS AQ_CD  ," ).append("\n"); 
		query.append("                                                   @[sales_office] AS OFC_CD ," ).append("\n"); 
		query.append("                                                   @[pol_cd]       AS PORT_CD" ).append("\n"); 
		query.append("                                              FROM DUAL" ).append("\n"); 
		query.append("                                           )))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", OFC_DATA AS (" ).append("\n"); 
		query.append("    SELECT B.OFC_CD ," ).append("\n"); 
		query.append("           B.NUM    ," ).append("\n"); 
		query.append("           '' AS TMP," ).append("\n"); 
		query.append("           QTA_LOAD ," ).append("\n"); 
		query.append("           QTA_GREV ," ).append("\n"); 
		query.append("           QTA_COST ," ).append("\n"); 
		query.append("           FCT_LOAD ," ).append("\n"); 
		query.append("           FCT_GREV ," ).append("\n"); 
		query.append("           FCT_COST ," ).append("\n"); 
		query.append("           PFC_LOAD ," ).append("\n"); 
		query.append("           PFC_GREV ," ).append("\n"); 
		query.append("           PFC_COST ," ).append("\n"); 
		query.append("           BKG_LOAD ," ).append("\n"); 
		query.append("           BKG_GREV ," ).append("\n"); 
		query.append("           BKG_COST" ).append("\n"); 
		query.append("      FROM TGT  A," ).append("\n"); 
		query.append("           BASE B" ).append("\n"); 
		query.append("     WHERE B.OFC_CD = A.OFC_CD (+)" ).append("\n"); 
		query.append("       AND B.NUM    = A.NUM    (+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", BSA AS (" ).append("\n"); 
		query.append("    SELECT NUM," ).append("\n"); 
		query.append("           NVL(RHQ_CD, 'TOTAL') AS RHQ_CD," ).append("\n"); 
		query.append("           SUM(BSA)             AS BSA" ).append("\n"); 
		query.append("      FROM VVDS" ).append("\n"); 
		query.append("  GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                           (NUM, RHQ_CD)," ).append("\n"); 
		query.append("                           (NUM)" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", AQ_DATA AS (" ).append("\n"); 
		query.append("    SELECT AQ_CD ," ).append("\n"); 
		query.append("           OFC_CD," ).append("\n"); 
		query.append("           NUM   ," ).append("\n"); 
		query.append("           ROUND(QTA_LOAD)                     AS QTA_LOAD ," ).append("\n"); 
		query.append("           ROUND(QTA_GREV / 1000)              AS QTA_GREV ," ).append("\n"); 
		query.append("           ROUND(QTA_GRPB)                     AS QTA_GRPB ," ).append("\n"); 
		query.append("           ROUND(QTA_CM / 1000)                AS QTA_CM   ," ).append("\n"); 
		query.append("           ROUND(QTA_CMB)                      AS QTA_CMB  ," ).append("\n"); 
		query.append("           ROUND(FCT_LOAD)                     AS FCT_LOAD ," ).append("\n"); 
		query.append("           ROUND(FCT_GREV / 1000)              AS FCT_GREV ," ).append("\n"); 
		query.append("           ROUND(FCT_GRPB)                     AS FCT_GRPB ," ).append("\n"); 
		query.append("           ROUND(FCT_CM / 1000)                AS FCT_CM   ," ).append("\n"); 
		query.append("           ROUND(FCT_CMB)                      AS FCT_CMB  ," ).append("\n"); 
		query.append("           ROUND(PFC_LOAD)                     AS PFC_LOAD ," ).append("\n"); 
		query.append("           ROUND(PFC_GREV / 1000)              AS PFC_GREV ," ).append("\n"); 
		query.append("           ROUND(PFC_GRPB)                     AS PFC_GRPB ," ).append("\n"); 
		query.append("           ROUND(PFC_CM / 1000)                AS PFC_CM   ," ).append("\n"); 
		query.append("           ROUND(PFC_CMB)                      AS PFC_CMB  ," ).append("\n"); 
		query.append("           ROUND(FCT_LOAD  - PFC_LOAD)         AS DIFF_LOAD," ).append("\n"); 
		query.append("           ROUND((FCT_GREV - PFC_GREV) / 1000) AS DIFF_GREV," ).append("\n"); 
		query.append("           ROUND(FCT_GRPB - PFC_GRPB)          AS DIFF_GRPB," ).append("\n"); 
		query.append("           ROUND((FCT_CM - PFC_CM) / 1000)     AS DIFF_CM  ," ).append("\n"); 
		query.append("           ROUND(FCT_CMB - PFC_CMB)            AS DIFF_CMB ," ).append("\n"); 
		query.append("           ROUND(BKG_LOAD)                     AS BKG_LOAD ," ).append("\n"); 
		query.append("           ROUND(BKG_GREV / 1000)              AS BKG_GREV ," ).append("\n"); 
		query.append("           ROUND(BKG_GRPB)                     AS BKG_GRPB ," ).append("\n"); 
		query.append("           ROUND(BKG_CM / 1000)                AS BKG_CM   ," ).append("\n"); 
		query.append("           ROUND(BKG_CMB)                      AS BKG_CMB  ," ).append("\n"); 
		query.append("           ROUND(DECODE(QTA_LOAD, 0, 0, FCT_LOAD * 100 / QTA_LOAD))||'%' AS PREF_LOAD," ).append("\n"); 
		query.append("           ROUND(DECODE(QTA_GREV, 0, 0, FCT_GREV * 100 / QTA_GREV))||'%' AS PREF_GREV," ).append("\n"); 
		query.append("           ROUND(DECODE(QTA_GRPB, 0, 0, FCT_GRPB * 100 / QTA_GRPB))||'%' AS PREF_GRPB," ).append("\n"); 
		query.append("           ROUND(DECODE(QTA_CM  , 0, 0, FCT_CM   * 100 / QTA_CM  ))||'%' AS PREF_CM  ," ).append("\n"); 
		query.append("           ROUND(DECODE(QTA_CMB , 0, 0, FCT_CMB  * 100 / QTA_CMB ))||'%' AS PREF_CMB," ).append("\n"); 
		query.append("           BSA," ).append("\n"); 
		query.append("           LVL" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("              SELECT AQ_CD   ," ).append("\n"); 
		query.append("                     OFC_CD  ," ).append("\n"); 
		query.append("                     Z.NUM   ," ).append("\n"); 
		query.append("                     QTA_LOAD," ).append("\n"); 
		query.append("                     QTA_GREV," ).append("\n"); 
		query.append("                     DECODE(QTA_LOAD, 0, 0, QTA_GREV / QTA_LOAD) AS QTA_GRPB," ).append("\n"); 
		query.append("                     QTA_GREV - QTA_COST AS QTA_CM," ).append("\n"); 
		query.append("                     DECODE(QTA_LOAD, 0, 0, (QTA_GREV - QTA_COST) / QTA_LOAD) AS QTA_CMB," ).append("\n"); 
		query.append("                     FCT_LOAD," ).append("\n"); 
		query.append("                     FCT_GREV," ).append("\n"); 
		query.append("                     DECODE(FCT_LOAD, 0, 0, FCT_GREV / FCT_LOAD) AS FCT_GRPB," ).append("\n"); 
		query.append("                     FCT_GREV - FCT_COST AS FCT_CM," ).append("\n"); 
		query.append("                     DECODE(FCT_LOAD, 0, 0, (FCT_GREV - FCT_COST) / FCT_LOAD) AS FCT_CMB," ).append("\n"); 
		query.append("                     PFC_LOAD," ).append("\n"); 
		query.append("                     PFC_GREV," ).append("\n"); 
		query.append("                     DECODE(PFC_LOAD, 0, 0, PFC_GREV / PFC_LOAD) AS PFC_GRPB," ).append("\n"); 
		query.append("                     PFC_GREV - PFC_COST AS PFC_CM," ).append("\n"); 
		query.append("                     DECODE(PFC_LOAD, 0, 0, (PFC_GREV - PFC_COST) / PFC_LOAD) AS PFC_CMB," ).append("\n"); 
		query.append("                     BKG_LOAD," ).append("\n"); 
		query.append("                     BKG_GREV," ).append("\n"); 
		query.append("                     DECODE(BKG_LOAD, 0, 0, BKG_GREV / BKG_LOAD) AS BKG_GRPB," ).append("\n"); 
		query.append("                     BKG_GREV - BKG_COST AS BKG_CM," ).append("\n"); 
		query.append("                     DECODE(BKG_LOAD, 0, 0, (BKG_GREV - BKG_COST) / BKG_LOAD) AS BKG_CMB," ).append("\n"); 
		query.append("                     B.BSA," ).append("\n"); 
		query.append("                     LVL" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                        SELECT NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD) AS AQ_CD," ).append("\n"); 
		query.append("                               D.OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("                               D.NUM," ).append("\n"); 
		query.append("                               SUM(QTA_LOAD) AS QTA_LOAD," ).append("\n"); 
		query.append("                               SUM(QTA_GREV) AS QTA_GREV," ).append("\n"); 
		query.append("                               SUM(QTA_COST) AS QTA_COST," ).append("\n"); 
		query.append("                               SUM(FCT_LOAD) AS FCT_LOAD," ).append("\n"); 
		query.append("                               SUM(FCT_GREV) AS FCT_GREV," ).append("\n"); 
		query.append("                               SUM(FCT_COST) AS FCT_COST," ).append("\n"); 
		query.append("                               SUM(PFC_LOAD) AS PFC_LOAD," ).append("\n"); 
		query.append("                               SUM(PFC_GREV) AS PFC_GREV," ).append("\n"); 
		query.append("                               SUM(PFC_COST) AS PFC_COST," ).append("\n"); 
		query.append("                               SUM(BKG_LOAD) AS BKG_LOAD," ).append("\n"); 
		query.append("                               SUM(BKG_GREV) AS BKG_GREV," ).append("\n"); 
		query.append("                               SUM(BKG_COST) AS BKG_COST," ).append("\n"); 
		query.append("                               2 - (GROUPING_ID(NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD)) + GROUPING_ID(D.OFC_CD)) AS LVL" ).append("\n"); 
		query.append("                          FROM SPC_OFC_LVL O," ).append("\n"); 
		query.append("                               OFC_DATA    D" ).append("\n"); 
		query.append("                         WHERE O.OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                           AND (  -- Duraion 때문에 연도가 바뀌는 Data 를 위한 로직" ).append("\n"); 
		query.append("                                  SELECT W.COST_YR || W.COST_WK" ).append("\n"); 
		query.append("                                    FROM COA_WK_PRD W" ).append("\n"); 
		query.append("                                   WHERE ( SELECT TO_CHAR(( SELECT TO_DATE(SLS_FM_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                              FROM COA_WK_PRD W" ).append("\n"); 
		query.append("                                                             WHERE W.COST_YR = @[year]" ).append("\n"); 
		query.append("                                                               AND W.COST_WK = @[week]" ).append("\n"); 
		query.append("                                                          ) + ( D.NUM * 7 ) - 7 ,'YYYYMMDD')" ).append("\n"); 
		query.append("                                             FROM DUAL" ).append("\n"); 
		query.append("                                         )  BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT" ).append("\n"); 
		query.append("                               ) BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 
		query.append("                      GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                                               (D.NUM, NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD), D.OFC_CD)," ).append("\n"); 
		query.append("                                               (D.NUM, NVL(O.N3RD_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD))," ).append("\n"); 
		query.append("                                               (D.NUM)" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                     ) Z," ).append("\n"); 
		query.append("                     BSA B" ).append("\n"); 
		query.append("               WHERE Z.NUM = B.NUM(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                 AND NVL(Z.AQ_CD, 'TOTAL') = B.RHQ_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("  ORDER BY NVL(AQ_CD , 'ZZZZZZ')," ).append("\n"); 
		query.append("           NVL(OFC_CD, '00000') ," ).append("\n"); 
		query.append("           NUM" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("  SELECT NVL(AQ_CD, 'TOTAL') AS AQ_CD," ).append("\n"); 
		query.append("         DECODE(AQ_CD, NULL, '', NVL(OFC_CD, '-')) AS OFC_CD," ).append("\n"); 
		query.append("         NUM      ," ).append("\n"); 
		query.append("         NVL(QTA_LOAD, 0) QTA_LOAD," ).append("\n"); 
		query.append("         NVL(QTA_GREV, 0) QTA_GREV," ).append("\n"); 
		query.append("         NVL(QTA_GRPB, 0) QTA_GRPB," ).append("\n"); 
		query.append("         NVL(QTA_CM , 0)  QTA_CM," ).append("\n"); 
		query.append("         NVL(QTA_CMB , 0) QTA_CMB," ).append("\n"); 
		query.append("         NVL(FCT_LOAD , 0) FCT_LOAD," ).append("\n"); 
		query.append("         NVL(FCT_GREV, 0) FCT_GREV," ).append("\n"); 
		query.append("         NVL(FCT_GRPB, 0) FCT_GRPB," ).append("\n"); 
		query.append("         NVL(FCT_CM , 0)  FCT_CM," ).append("\n"); 
		query.append("         NVL(FCT_CMB, 0)  FCT_CMB," ).append("\n"); 
		query.append("         NVL(PFC_LOAD, 0) PFC_LOAD," ).append("\n"); 
		query.append("         NVL(PFC_GREV, 0) PFC_GREV," ).append("\n"); 
		query.append("         NVL(PFC_GRPB, 0) PFC_GREV," ).append("\n"); 
		query.append("         NVL(PFC_CM, 0)   PFC_CM," ).append("\n"); 
		query.append("         NVL(PFC_CMB, 0)  PFC_CMB," ).append("\n"); 
		query.append("         NVL(DIFF_LOAD, 0) DIFF_LOAD," ).append("\n"); 
		query.append("         NVL(DIFF_GREV, 0) DIFF_GREV," ).append("\n"); 
		query.append("         NVL(DIFF_GRPB, 0) DIFF_GRPB," ).append("\n"); 
		query.append("         NVL(DIFF_CM, 0)  DIFF_CM," ).append("\n"); 
		query.append("         NVL(DIFF_CMB, 0) DIFF_CMB," ).append("\n"); 
		query.append("         NVL(BKG_LOAD, 0) BKG_LOAD," ).append("\n"); 
		query.append("         NVL(BKG_GREV, 0) BKG_GREV," ).append("\n"); 
		query.append("         NVL(BKG_GRPB, 0) BKG_GRPB," ).append("\n"); 
		query.append("         NVL(BKG_CM , 0)  BKG_CM," ).append("\n"); 
		query.append("         NVL(BKG_CMB, 0)  BKG_CMB," ).append("\n"); 
		query.append("         NVL(PREF_LOAD, 0) PREF_LOAD," ).append("\n"); 
		query.append("         NVL(PREF_GREV, 0) PREF_GREV," ).append("\n"); 
		query.append("         NVL(PREF_GRPB, 0) PREF_GRPB," ).append("\n"); 
		query.append("         NVL(PREF_CM, 0)  PREF_CM," ).append("\n"); 
		query.append("         NVL(PREF_CMB, 0) PREF_CMB," ).append("\n"); 
		query.append("         NVL(BSA, 0)  BSA," ).append("\n"); 
		query.append("         DECODE(BSA, 0, 0, ROUND(FCT_LOAD / BSA * 100))||'%' AS LF," ).append("\n"); 
		query.append("         LVL" ).append("\n"); 
		query.append("    FROM AQ_DATA" ).append("\n"); 

	}
}