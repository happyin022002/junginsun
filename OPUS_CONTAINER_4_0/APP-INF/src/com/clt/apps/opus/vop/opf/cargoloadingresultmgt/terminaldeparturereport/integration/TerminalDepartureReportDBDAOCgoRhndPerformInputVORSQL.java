/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOCgoRhndPerformInputVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(C3, 1, 'G.Total', DECODE(C5, 1, 'G.Total', PORT)) AS PORT," ).append("\n"); 
		query.append("       LANE AS LANE," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       DECODE(C1, 1, 'S.Total', DECODE(C3, 1, 'Total', OPR)) AS OPR," ).append("\n"); 
		query.append("#foreach($key IN ${restow_reason_list}) " ).append("\n"); 
		query.append("    #if($velocityCount < $restow_reason_list.size()) " ).append("\n"); 
		query.append("       RSN_$velocityCount ||'|'||" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("       RSN_$velocityCount AS RESTOW_REASON_LIST," ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       FL," ).append("\n"); 
		query.append("       MT," ).append("\n"); 
		query.append("       TL," ).append("\n"); 
		query.append("       OWN_RH_UNIT," ).append("\n"); 
		query.append("       OTH_RH_UNIT," ).append("\n"); 
		query.append("       OWN_RH_MOVE," ).append("\n"); 
		query.append("       OTH_RH_MOVE," ).append("\n"); 
		query.append("       CC_MOVE," ).append("\n"); 
		query.append("       CDC_MOVE," ).append("\n"); 
		query.append("       --RH_UNIT_RATIO," ).append("\n"); 
		query.append("       --RH_MOVE_RATIO " ).append("\n"); 
		query.append("       DECODE(TL,0,0, NVL(ROUND((OWN_RH_UNIT+OTH_RH_UNIT)/TL, 4), 0) * 100) RH_UNIT_RATIO," ).append("\n"); 
		query.append("       DECODE(TL,0,0, NVL(ROUND((OWN_RH_MOVE+OTH_RH_MOVE)/TL, 4), 0) *100) RH_MOVE_RATIO" ).append("\n"); 
		query.append("/*" ).append("\n"); 
		query.append("       RSN_CC," ).append("\n"); 
		query.append("       RSN_CR," ).append("\n"); 
		query.append("       RSN_IC," ).append("\n"); 
		query.append("       RSN_ID," ).append("\n"); 
		query.append("       RSN_IF," ).append("\n"); 
		query.append("       RSN_IG," ).append("\n"); 
		query.append("       RSN_IH," ).append("\n"); 
		query.append("       RSN_IL," ).append("\n"); 
		query.append("       RSN_IO," ).append("\n"); 
		query.append("       RSN_IP," ).append("\n"); 
		query.append("       RSN_IR," ).append("\n"); 
		query.append("       RSN_IS," ).append("\n"); 
		query.append("       RSN_IT," ).append("\n"); 
		query.append("       RSN_IW," ).append("\n"); 
		query.append("       RSN_IX," ).append("\n"); 
		query.append("       RSN_XX" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("  FROM (SELECT A.PORT PORT," ).append("\n"); 
		query.append("               A.LANE LANE," ).append("\n"); 
		query.append("               A.VVD VVD," ).append("\n"); 
		query.append("               A.OPR OPR," ).append("\n"); 
		query.append("               GROUPING(A.PORT) P," ).append("\n"); 
		query.append("               GROUPING(A.LANE) L," ).append("\n"); 
		query.append("               GROUPING(A.VVD) V," ).append("\n"); 
		query.append("               GROUPING(A.OPR) O," ).append("\n"); 
		query.append("               CASE WHEN GROUPING(A.PORT)=0 AND GROUPING(A.LANE)=0 AND GROUPING(A.VVD)=0 AND GROUPING(A.OPR)=1 THEN 1" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END C1," ).append("\n"); 
		query.append("               CASE WHEN GROUPING(A.PORT)=1 AND GROUPING(A.LANE)=1 AND GROUPING(A.VVD)=1 AND GROUPING(A.OPR)=1 THEN 1" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END C3," ).append("\n"); 
		query.append("               CASE WHEN GROUPING(A.PORT)=0 AND GROUPING(A.LANE)=0 AND GROUPING(A.VVD)=0 AND GROUPING(A.OPR)=0 THEN 1" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END C4," ).append("\n"); 
		query.append("               CASE WHEN GROUPING(A.PORT)=1 AND GROUPING(A.LANE)=1 AND GROUPING(A.VVD)=1 AND GROUPING(A.OPR)=0 THEN 1" ).append("\n"); 
		query.append("                    ELSE 0" ).append("\n"); 
		query.append("               END C5," ).append("\n"); 
		query.append("#foreach($key IN ${restow_reason_list}) " ).append("\n"); 
		query.append("               SUM(NVL(RSN_$velocityCount,0)) RSN_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               SUM(NVL(A.FL, 0)) FL," ).append("\n"); 
		query.append("               SUM(NVL(A.MT, 0)) MT," ).append("\n"); 
		query.append("               SUM(NVL(A.TL, 0)) TL," ).append("\n"); 
		query.append("               SUM(NVL(A.HBMVS+A.HQMVS, 0)) OWN_RH_UNIT," ).append("\n"); 
		query.append("               SUM(NVL(A.OBMVS+A.OQMVS, 0)) OTH_RH_UNIT," ).append("\n"); 
		query.append("               SUM(NVL(A.HBMVS+(A.HQMVS*2), 0)) OWN_RH_MOVE," ).append("\n"); 
		query.append("               SUM(NVL(A.OBMVS+(A.OQMVS*2), 0)) OTH_RH_MOVE," ).append("\n"); 
		query.append("               SUM(NVL(A.HBMVS+A.OBMVS, 0)) CC_MOVE," ).append("\n"); 
		query.append("               SUM(NVL((A.HQMVS+A.OQMVS*2), 0)) CDC_MOVE--," ).append("\n"); 
		query.append("               --SUM(NVL(ROUND((A.HBMVS+A.HQMVS+A.OBMVS+A.OQMVS)/DECODE(A.TL, 0, 1), 4), 0)) * 100 RH_UNIT_RATIO," ).append("\n"); 
		query.append("               --SUM(NVL(ROUND(((A.HBMVS+(A.HQMVS*2))+(A.OBMVS+(A.OQMVS*2)))/DECODE(A.TL, 0, 1), 4), 0)) *100 RH_MOVE_RATIO" ).append("\n"); 
		query.append("          FROM (SELECT S.PORT_CD PORT," ).append("\n"); 
		query.append("                       V.LANE LANE," ).append("\n"); 
		query.append("                       S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("                       S.OPR_CD OPR," ).append("\n"); 
		query.append("#foreach($key IN ${restow_reason_list}) " ).append("\n"); 
		query.append("               		   0 RSN_$velocityCount," ).append("\n"); 
		query.append("#end                  " ).append("\n"); 
		query.append("                       SUM(DECODE(S.CNTR_TYPE, 'E', 0, QTY)) FL," ).append("\n"); 
		query.append("                       SUM(DECODE(S.CNTR_TYPE, 'E', QTY, 0)) MT," ).append("\n"); 
		query.append("                       SUM(DECODE(S.CNTR_TYPE, 'E', 0, QTY)) + SUM(DECODE(S.CNTR_TYPE, 'E', QTY, 0)) TL," ).append("\n"); 
		query.append("                       0 HBMVS," ).append("\n"); 
		query.append("                       0 OBMVS," ).append("\n"); 
		query.append("                       0 HQMVS," ).append("\n"); 
		query.append("                       0 OQMVS" ).append("\n"); 
		query.append("                  FROM TDR_SUMMARY S," ).append("\n"); 
		query.append("                       (SELECT A.VSL_CD VSL," ).append("\n"); 
		query.append("                               A.SKD_VOY_NO VOY," ).append("\n"); 
		query.append("                               A.SKD_DIR_CD DIR," ).append("\n"); 
		query.append("                               A.VPS_PORT_CD LOC," ).append("\n"); 
		query.append("                               A.CLPT_IND_SEQ CAL," ).append("\n"); 
		query.append("                               A.SLAN_CD LANE" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("                               VSK_ACT_PORT_SKD B" ).append("\n"); 
		query.append("                         WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                           AND A.SLAN_CD LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end                           " ).append("\n"); 
		query.append("                           AND B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                           AND B.ACT_DEP_DT BETWEEN TO_DATE(REPLACE(@[from_date], '-', ''), 'YYYYMMDD') --:fm_dt" ).append("\n"); 
		query.append("                                                AND TO_DATE(REPLACE(@[to_date], '-', ''), 'YYYYMMDD') + 0.99999 --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                           AND A.YD_CD LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND A.YD_CD LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                          ) V" ).append("\n"); 
		query.append("                 WHERE S.VSL_CD = V.VSL" ).append("\n"); 
		query.append("                   AND S.VOY_NO = V.VOY" ).append("\n"); 
		query.append("                   AND S.DIR_CD = V.DIR" ).append("\n"); 
		query.append("                   AND S.PORT_CD = V.LOC" ).append("\n"); 
		query.append("                   AND S.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                 GROUP BY S.PORT_CD," ).append("\n"); 
		query.append("                       V.LANE," ).append("\n"); 
		query.append("                       S.VSL_CD||S.VOY_NO||S.DIR_CD," ).append("\n"); 
		query.append("                       S.OPR_CD" ).append("\n"); 
		query.append("                 UNION" ).append("\n"); 
		query.append("                SELECT C.PORT_CD PORT," ).append("\n"); 
		query.append("                       V.LANE LANE," ).append("\n"); 
		query.append("                       C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                       C.OPR_CD OPR," ).append("\n"); 
		query.append("#foreach($key IN ${restow_reason_list}) " ).append("\n"); 
		query.append("                       0 RSN_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       0 FL," ).append("\n"); 
		query.append("                       0 MT," ).append("\n"); 
		query.append("                       0 TL," ).append("\n"); 
		query.append("                       SUM(DECODE(C.ACCOUNT, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), DECODE(C.SHIFT_TYPE, 'S', 1, 0), 0)) HBMVS," ).append("\n"); 
		query.append("                       SUM(DECODE(C.ACCOUNT, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 0 , DECODE(C.SHIFT_TYPE, 'S', 1, 0))) OBMVS," ).append("\n"); 
		query.append("                       SUM(DECODE(C.ACCOUNT, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), DECODE(C.SHIFT_TYPE, 'D', 1, 0), 0)) HQMVS," ).append("\n"); 
		query.append("                       SUM(DECODE(C.ACCOUNT, COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(), 0 , DECODE(C.SHIFT_TYPE, 'D', 1, 0))) OQMVS" ).append("\n"); 
		query.append("                  FROM TDR_CNTR_DETAIL C," ).append("\n"); 
		query.append("                       (SELECT A.VSL_CD VSL," ).append("\n"); 
		query.append("                               A.SKD_VOY_NO VOY," ).append("\n"); 
		query.append("                               A.SKD_DIR_CD DIR," ).append("\n"); 
		query.append("                               A.VPS_PORT_CD LOC," ).append("\n"); 
		query.append("                               A.CLPT_IND_SEQ CAL," ).append("\n"); 
		query.append("                               A.SLAN_CD LANE" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("                               VSK_ACT_PORT_SKD B" ).append("\n"); 
		query.append("                         WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                           AND A.SLAN_CD LIKE @[slan_cd]||'%'                                          --:lane_cd" ).append("\n"); 
		query.append("#end                             " ).append("\n"); 
		query.append("                           AND B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                           AND B.ACT_DEP_DT BETWEEN TO_DATE(REPLACE(@[from_date], '-', ''), 'YYYYMMDD') --:fm_dt" ).append("\n"); 
		query.append("                                                AND TO_DATE(REPLACE(@[to_date], '-', ''), 'YYYYMMDD') + 0.99999 --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                           AND A.YD_CD LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND A.YD_CD LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           ) V" ).append("\n"); 
		query.append("                 WHERE C.VSL_CD = V.VSL" ).append("\n"); 
		query.append("                   AND C.VOY_NO = V.VOY" ).append("\n"); 
		query.append("                   AND C.DIR_CD = V.DIR" ).append("\n"); 
		query.append("                   AND C.PORT_CD = V.LOC" ).append("\n"); 
		query.append("                   AND C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                   AND TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                 GROUP BY C.PORT_CD," ).append("\n"); 
		query.append("                       V.LANE," ).append("\n"); 
		query.append("                       C.VSL_CD||C.VOY_NO||C.DIR_CD," ).append("\n"); 
		query.append("                       C.OPR_CD" ).append("\n"); 
		query.append("                 UNION" ).append("\n"); 
		query.append("                SELECT C.PORT_CD PORT," ).append("\n"); 
		query.append("                       V.LANE LANE," ).append("\n"); 
		query.append("                       C.VSL_CD||C.VOY_NO||C.DIR_CD VVD," ).append("\n"); 
		query.append("                       C.OPR_CD OPR," ).append("\n"); 
		query.append("#foreach($key IN ${restow_reason_list}) " ).append("\n"); 
		query.append("					   SUM(DECODE(C.SHIFT_TYPE||C.SHIFT_RSN||C.PARTY ,'$key',1,0)) RSN_$velocityCount," ).append("\n"); 
		query.append("#end                       " ).append("\n"); 
		query.append("                       0 FL," ).append("\n"); 
		query.append("                       0 MT," ).append("\n"); 
		query.append("                       0 TL," ).append("\n"); 
		query.append("                       0 HBMVS," ).append("\n"); 
		query.append("                       0 OBMVS," ).append("\n"); 
		query.append("                       0 HQMVS," ).append("\n"); 
		query.append("                       0 OQMVS" ).append("\n"); 
		query.append("                  FROM TDR_CNTR_DETAIL C," ).append("\n"); 
		query.append("                       (SELECT A.VSL_CD VSL," ).append("\n"); 
		query.append("                               A.SKD_VOY_NO VOY," ).append("\n"); 
		query.append("                               A.SKD_DIR_CD DIR," ).append("\n"); 
		query.append("                               A.VPS_PORT_CD LOC," ).append("\n"); 
		query.append("                               A.CLPT_IND_SEQ CAL," ).append("\n"); 
		query.append("                               A.SLAN_CD LANE" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("                               VSK_ACT_PORT_SKD B" ).append("\n"); 
		query.append("                         WHERE A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                           AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND B.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("                           AND B.ACT_DEP_DT BETWEEN TO_DATE(REPLACE(@[from_date], '-', ''), 'YYYYMMDD') --:fm_dt" ).append("\n"); 
		query.append("                                                AND TO_DATE(REPLACE(@[to_date], '-', ''), 'YYYYMMDD') + 0.99999 --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                           AND A.YD_CD LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND A.YD_CD LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("                           ) V" ).append("\n"); 
		query.append("                 WHERE C.VSL_CD = V.VSL" ).append("\n"); 
		query.append("                   AND C.VOY_NO = V.VOY" ).append("\n"); 
		query.append("                   AND C.DIR_CD = V.DIR" ).append("\n"); 
		query.append("                   AND C.PORT_CD = V.LOC" ).append("\n"); 
		query.append("                   AND C.CALL_IND = V.CAL" ).append("\n"); 
		query.append("                   AND TRIM(C.PRECELL) IS NOT NULL" ).append("\n"); 
		query.append("                 GROUP BY C.PORT_CD," ).append("\n"); 
		query.append("                       V.LANE," ).append("\n"); 
		query.append("                       C.VSL_CD||C.VOY_NO||C.DIR_CD," ).append("\n"); 
		query.append("                       C.OPR_CD ) A ," ).append("\n"); 
		query.append("               (SELECT DISTINCT LOC_CD" ).append("\n"); 
		query.append("                  FROM (SELECT ML.LOC_CD," ).append("\n"); 
		query.append("                               NVL(ML.VSKD_PORT_RHQ_CD, MO.AR_HD_QTR_OFC_CD) AS POR_RHQ" ).append("\n"); 
		query.append("                          FROM MDM_LOCATION ML ," ).append("\n"); 
		query.append("                               MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND ML.LOC_CD = MO.LOC_CD" ).append("\n"); 
		query.append("                           AND MO.AR_HD_QTR_OFC_CD <> 'SINHO'" ).append("\n"); 
		query.append("                           AND ML.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                           AND ML.DELT_FLG = 'N' )" ).append("\n"); 
		query.append("                 WHERE POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq] ) ) R, --:rhq_cd" ).append("\n"); 
		query.append("               MDM_VSL_SVC_LANE T" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.PORT = R.LOC_CD" ).append("\n"); 
		query.append("           AND A.LANE = T.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("           AND T.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         GROUP BY CUBE( A.PORT, A.LANE, A.VVD, A.OPR) )" ).append("\n"); 
		query.append(" WHERE (C1 = 1 OR C3 = 1 OR C4 = 1 OR C5 = 1)" ).append("\n"); 
		query.append(" ORDER BY DECODE(C3, 1, 'ZZZZZ', DECODE(C5, 1, 'YYYYY', PORT))," ).append("\n"); 
		query.append("       LANE," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       DECODE(C1, 1, 'ZZZZ', DECODE(C3, 1, 'YYYY', OPR))" ).append("\n"); 

	}
}