/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTerminalDepartureReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.28 
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

public class TerminalDepartureReportDBDAOTerminalDepartureReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTerminalDepartureReportVORSQL(){
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
		params.put("tml_prod_rpt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_lanes",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_ports",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTerminalDepartureReportVORSQL").append("\n"); 
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
		query.append("SELECT PORT," ).append("\n"); 
		query.append("       DECODE(C2,3,'S.Total',YARD) YARD," ).append("\n"); 
		query.append("       DECODE(C2,3,'',LANE) LANE," ).append("\n"); 
		query.append("       DECODE(C2,3,'',VVD) VVD," ).append("\n"); 
		query.append("       DECODE(C2,3,'',ATA) ATA," ).append("\n"); 
		query.append("       DECODE(C2,3,'',ATD) ATD," ).append("\n"); 
		query.append("       DECODE(C2,3,'',MONTH) MONTH," ).append("\n"); 
		query.append("       DECODE(C2,3,'',TDR_QTY) TDR_QTY," ).append("\n"); 
		query.append("       TOT_MVS," ).append("\n"); 
		query.append("       WORK_GROSS," ).append("\n"); 
		query.append("       GANG_GROSS," ).append("\n"); 
		query.append("       TMNL_PROD," ).append("\n"); 
		query.append("       GANG_PROD," ).append("\n"); 
		query.append("       AVG_CLAN," ).append("\n"); 
		query.append("       DECODE(C2,3,'',TML_PROD_RPT_RSN_CD) TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("         SELECT DECODE(C2,1,'Total',2,'Average per TDR',PORT) PORT," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'Average per TDR',YARD) YARD," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'',LANE) LANE," ).append("\n"); 
		query.append("                C2," ).append("\n"); 
		query.append("                DECODE(VVD,'N',DECODE(C2,1,'',2,'',NULL), NVL(VVD, ''))   VVD," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'', TO_CHAR(ATA,'yyyy-mm-dd'))                ATA," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'', TO_CHAR(ATD,'yyyy-mm-dd'))                ATD," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'','') MONTH," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'','') TDR_QTY," ).append("\n"); 
		query.append("                TOT_MVS," ).append("\n"); 
		query.append("                WORK_GROSS," ).append("\n"); 
		query.append("                GANG_GROSS," ).append("\n"); 
		query.append("                TMNL_PROD," ).append("\n"); 
		query.append("                GANG_PROD," ).append("\n"); 
		query.append("                AVG_CLAN," ).append("\n"); 
		query.append("                DECODE(C2,1,'',2,'', TML_PROD_RPT_RSN_CD)                TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("         FROM   ( " ).append("\n"); 
		query.append("                  /* Q1 */" ).append("\n"); 
		query.append("                  SELECT PORT," ).append("\n"); 
		query.append("                         YARD," ).append("\n"); 
		query.append("                         LANE," ).append("\n"); 
		query.append("                         VVD," ).append("\n"); 
		query.append("                         ATA," ).append("\n"); 
		query.append("                         ATD," ).append("\n"); 
		query.append("                         DECODE(C3,1,3,C2) AS C2," ).append("\n"); 
		query.append("                         TOT_MVS," ).append("\n"); 
		query.append("                         WORK_GROSS," ).append("\n"); 
		query.append("                         GANG_GROSS," ).append("\n"); 
		query.append("                         DECODE(WORK_GROSS,0,0,ROUND(TOT_MVS/WORK_GROSS,2))     TMNL_PROD," ).append("\n"); 
		query.append("                         DECODE(GANG_GROSS,0,0,ROUND(TOT_MVS/GANG_GROSS,2))     GANG_PROD," ).append("\n"); 
		query.append("                         DECODE(WORK_GROSS,0,0,ROUND(GANG_GROSS/WORK_GROSS,2))  AVG_CLAN," ).append("\n"); 
		query.append("                         --ROUND(TOT_MVS/DECODE(WORK_GROSS,0,1,WORK_GROSS),2)    TMNL_PROD," ).append("\n"); 
		query.append("                         --ROUND(TOT_MVS/DECODE(GANG_GROSS,0,1,GANG_GROSS),2)    GANG_PROD," ).append("\n"); 
		query.append("                         --ROUND(GANG_GROSS/DECODE(WORK_GROSS,0,1,WORK_GROSS),2) AVG_CLAN," ).append("\n"); 
		query.append("                         TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("                  FROM   ( SELECT /*+ ORDERED */ PORT," ).append("\n"); 
		query.append("                        YARD," ).append("\n"); 
		query.append("                        LANE," ).append("\n"); 
		query.append("                        VVD," ).append("\n"); 
		query.append("                        MAX(ATA) ATA," ).append("\n"); 
		query.append("                        MAX(ATD) ATD," ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN GROUPING(PORT)=0 AND GROUPING(YARD)=0 AND GROUPING(LANE)=0 AND GROUPING(VVD)=0 THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                        END C1," ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                          WHEN GROUPING(PORT)=0 AND GROUPING(YARD)=0 AND GROUPING(LANE)=1 AND GROUPING(VVD)=1 THEN 1" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                        END C3," ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                          WHEN GROUPING(PORT)=1 AND GROUPING(YARD)=1 AND GROUPING(LANE)=1 AND GROUPING(VVD)=1 THEN 1" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                        END C2," ).append("\n"); 
		query.append("                        NVL(COUNT(VVD),0) TDR_QTY," ).append("\n"); 
		query.append("                        NVL(SUM(MVS),0) TOT_MVS," ).append("\n"); 
		query.append("                        ROUND(SUM(NVL(TO_NUMBER(SUBSTR(GROSS_WORK,1,INSTR(GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(GROSS_WORK,INSTR(GROSS_WORK,':')+1)/60),0)),2) WORK_GROSS," ).append("\n"); 
		query.append("                        ROUND(SUM(NVL(TO_NUMBER(SUBSTR(GROSS_GANG,1,INSTR(GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(GROSS_GANG,INSTR(GROSS_GANG,':')+1)/60),0)),2) GANG_GROSS," ).append("\n"); 
		query.append("                        MAX(TML_PROD_RPT_RSN_CD) TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("                      FROM" ).append("\n"); 
		query.append("                        (SELECT MAX(V.VPS_PORT_CD) PORT," ).append("\n"); 
		query.append("                          MAX(V.YD_CD) YARD," ).append("\n"); 
		query.append("                          MAX(V.SLAN_CD) LANE," ).append("\n"); 
		query.append("                          MAX(T.VSL_CD" ).append("\n"); 
		query.append("                          ||T.VOY_NO" ).append("\n"); 
		query.append("                          ||T.DIR_CD) VVD," ).append("\n"); 
		query.append("                          MAX(A.ACT_ARR_DT) ATA," ).append("\n"); 
		query.append("                          MAX(A.ACT_DEP_DT) ATD," ).append("\n"); 
		query.append("                          MAX(T.MVS) MVS," ).append("\n"); 
		query.append("                          MAX(T.GROSS_WORK) GROSS_WORK," ).append("\n"); 
		query.append("                          MAX(T.GROSS_GANG) GROSS_GANG," ).append("\n"); 
		query.append("                          MAX(D.TML_PROD_RPT_RSN_CD) TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("                           FROM   TDR_HEADER       T, VSK_VSL_PORT_SKD V, VSK_ACT_PORT_SKD    A," ).append("\n"); 
		query.append("                                  MDM_VSL_SVC_LANE L, OPF_TML_DEP_RPT_DTL D," ).append("\n"); 
		query.append("--::20150428::CodeValidate Process Delete(FMS_CONTRACT, FMS_ID_VSL)" ).append("\n"); 
		query.append("                                      ( " ).append("\n"); 
		query.append("                                        SELECT  LOC_CD, POR_RHQ, TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("                                        FROM    " ).append("\n"); 
		query.append("                                        ( " ).append("\n"); 
		query.append("                          SELECT ML.LOC_CD,  NVL(ML.VSKD_PORT_RHQ_CD,MO.AR_HD_QTR_OFC_CD) AS POR_RHQ" ).append("\n"); 
		query.append("                                ,DECODE(NVL(ML.VSKD_PORT_RHQ_CD,MO.AR_HD_QTR_OFC_CD),NULL,'A','B') TP" ).append("\n"); 
		query.append("                                ,VOP_PORT_FLG" ).append("\n"); 
		query.append("                          FROM   MDM_LOCATION       ML" ).append("\n"); 
		query.append("                                ,MDM_ORGANIZATION   MO" ).append("\n"); 
		query.append("                          WHERE  1=1" ).append("\n"); 
		query.append("                          AND    ML.LOC_CD          = MO.LOC_CD" ).append("\n"); 
		query.append("                          AND    ML.CALL_PORT_FLG   = 'Y'" ).append("\n"); 
		query.append("                          AND    ML.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                          --::20150406::--AND    VSKD_PORT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                        WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq])" ).append("\n"); 
		query.append("                           ) R" ).append("\n"); 
		query.append("                           WHERE  T.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("                           AND    T.VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND    T.DIR_CD       = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND    T.PORT_CD      = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND    T.CALL_IND     = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND    V.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("                           AND    V.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND    V.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND    V.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND    V.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND    V.SLAN_CD      = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("                           --AND    V.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND    V.VPS_PORT_CD  = R.LOC_CD " ).append("\n"); 
		query.append("                           AND    T.VSL_CD       = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND    T.VOY_NO       = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND    T.DIR_CD       = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                           AND    T.PORT_CD      = D.CLPT_CD(+)" ).append("\n"); 
		query.append("                           AND    T.CALL_IND     = D.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                           AND    T.COMMENCE     IS NOT NULL" ).append("\n"); 
		query.append("                           AND    T.MVS          > 0" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR ( TO_CHAR(A.ACT_DEP_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(A.ACT_DEP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("                           AND    V.VPS_PORT_CD  LIKE @[loc_cd]||'%'                                                            --:port_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} != '')" ).append("\n"); 
		query.append("                           AND    V.YD_CD        LIKE @[yd_cd]||'%'                                                             --:yd_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           AND    R.POR_RHQ      = DECODE(@[rhq], 'ALL', R.POR_RHQ, @[rhq])                                      --:rhq_cd" ).append("\n"); 
		query.append("#if (${slan_cd} != 'ALL')" ).append("\n"); 
		query.append("                           AND    V.SLAN_CD      = @[slan_cd]                                                                    --:Lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${target_lanes} != 'ALL')" ).append("\n"); 
		query.append("                           AND    L.TML_PROD_RPT_FLG LIKE @[target_lanes]||'%'                                                --Target Lanes Only 일경우 'Y', ALL일 경우 NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${target_ports} != 'ALL')" ).append("\n"); 
		query.append("                           AND    R.TP           LIKE @[target_ports]||'%'                                                    --Target Ports Only 일경우 'B', ALL일 경우 NULL" ).append("\n"); 
		query.append("                           AND    R.VOP_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_prod_rpt_rsn_cd} != '')" ).append("\n"); 
		query.append("                           AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE(@[tml_prod_rpt_rsn_cd],'N','Y','N')       --Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE('N','N','Y','N')       --Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#end                           " ).append("\n"); 
		query.append("                            --:car_cd                    " ).append("\n"); 
		query.append("                        GROUP BY ( V.VPS_PORT_CD, V.YD_CD, V.SLAN_CD, T.VSL_CD||T.VOY_NO||T.DIR_CD )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                       GROUP BY ROLLUP( PORT, YARD, LANE, VVD) " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                  WHERE C1 = 1 OR C2 = 1 OR C3 = 1" ).append("\n"); 
		query.append("                  /* Q1 */" ).append("\n"); 
		query.append("                  UNION ALL" ).append("\n"); 
		query.append("                  /* Q2 */" ).append("\n"); 
		query.append("                  SELECT 'N'     PORT," ).append("\n"); 
		query.append("                         'N'     YARD," ).append("\n"); 
		query.append("                         'N'     LANE," ).append("\n"); 
		query.append("                         'N'     VVD," ).append("\n"); 
		query.append("                         SYSDATE ATA," ).append("\n"); 
		query.append("                         SYSDATE ATD," ).append("\n"); 
		query.append("                         2       C2," ).append("\n"); 
		query.append("                         ROUND(TOT_MVS/TDR_QTY,2) TOT_MVS," ).append("\n"); 
		query.append("                         ROUND(WORK_GROSS/TDR_QTY,2) WORK_GROSS," ).append("\n"); 
		query.append("                         ROUND(GANG_GROSS/TDR_QTY,2) GANG_GROSS," ).append("\n"); 
		query.append("                         DECODE(WORK_GROSS,0,0,ROUND(TOT_MVS/WORK_GROSS,2))     TMNL_PROD," ).append("\n"); 
		query.append("                         DECODE(GANG_GROSS,0,0,ROUND(TOT_MVS/GANG_GROSS,2))     GANG_PROD," ).append("\n"); 
		query.append("                         DECODE(WORK_GROSS,0,0,ROUND(GANG_GROSS/WORK_GROSS,2))  AVG_CLAN," ).append("\n"); 
		query.append("                         'N'     TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("                  FROM   ( SELECT /*+ ORDERED */ PORT," ).append("\n"); 
		query.append("                        YARD," ).append("\n"); 
		query.append("                        LANE," ).append("\n"); 
		query.append("                        VVD," ).append("\n"); 
		query.append("                        MAX(ATA) ATA," ).append("\n"); 
		query.append("                        MAX(ATD) ATD," ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                        WHEN GROUPING(PORT)=0 AND GROUPING(YARD)=0 AND GROUPING(LANE)=0 AND GROUPING(VVD)=0 THEN 1" ).append("\n"); 
		query.append("                        ELSE 0" ).append("\n"); 
		query.append("                        END C1," ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                          WHEN GROUPING(PORT)=0 AND GROUPING(YARD)=0 AND GROUPING(LANE)=1 AND GROUPING(VVD)=1 THEN 1" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                        END C3," ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                          WHEN GROUPING(PORT)=1 AND GROUPING(YARD)=1 AND GROUPING(LANE)=1 AND GROUPING(VVD)=1 THEN 1" ).append("\n"); 
		query.append("                          ELSE 0" ).append("\n"); 
		query.append("                        END C2," ).append("\n"); 
		query.append("                        NVL(COUNT(VVD),0) TDR_QTY," ).append("\n"); 
		query.append("                        NVL(SUM(MVS),0) TOT_MVS," ).append("\n"); 
		query.append("                        ROUND(SUM(NVL(TO_NUMBER(SUBSTR(GROSS_WORK,1,INSTR(GROSS_WORK,':')-1))+TO_NUMBER(SUBSTR(GROSS_WORK,INSTR(GROSS_WORK,':')+1)/60),0)),2) WORK_GROSS," ).append("\n"); 
		query.append("                        ROUND(SUM(NVL(TO_NUMBER(SUBSTR(GROSS_GANG,1,INSTR(GROSS_GANG,':')-1))+TO_NUMBER(SUBSTR(GROSS_GANG,INSTR(GROSS_GANG,':')+1)/60),0)),2) GANG_GROSS," ).append("\n"); 
		query.append("                        MAX(TML_PROD_RPT_RSN_CD) TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("                      FROM" ).append("\n"); 
		query.append("                        (SELECT MAX(V.VPS_PORT_CD) PORT," ).append("\n"); 
		query.append("                          MAX(V.YD_CD) YARD," ).append("\n"); 
		query.append("                          MAX(V.SLAN_CD) LANE," ).append("\n"); 
		query.append("                          MAX(T.VSL_CD" ).append("\n"); 
		query.append("                          ||T.VOY_NO" ).append("\n"); 
		query.append("                          ||T.DIR_CD) VVD," ).append("\n"); 
		query.append("                          MAX(A.ACT_ARR_DT) ATA," ).append("\n"); 
		query.append("                          MAX(A.ACT_DEP_DT) ATD," ).append("\n"); 
		query.append("                          MAX(T.MVS) MVS," ).append("\n"); 
		query.append("                          MAX(T.GROSS_WORK) GROSS_WORK," ).append("\n"); 
		query.append("                          MAX(T.GROSS_GANG) GROSS_GANG," ).append("\n"); 
		query.append("                          MAX(D.TML_PROD_RPT_RSN_CD) TML_PROD_RPT_RSN_CD" ).append("\n"); 
		query.append("                           FROM   TDR_HEADER       T, VSK_VSL_PORT_SKD V, VSK_ACT_PORT_SKD    A," ).append("\n"); 
		query.append("                                  MDM_VSL_SVC_LANE L, OPF_TML_DEP_RPT_DTL D," ).append("\n"); 
		query.append("--::20150428::CodeValidate Process Delete(FMS_CONTRACT, FMS_ID_VSL)" ).append("\n"); 
		query.append("                                  ( " ).append("\n"); 
		query.append("                                    SELECT  LOC_CD, POR_RHQ, TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("                                    FROM    (" ).append("\n"); 
		query.append("                                            SELECT LOC_CD, VOP_PORT_RHQ_CD AS POR_RHQ, DECODE(VOP_PORT_RHQ_CD,NULL,'A','B') TP, VOP_PORT_FLG" ).append("\n"); 
		query.append("                                            FROM   MDM_LOCATION" ).append("\n"); 
		query.append("                                            WHERE  1=1" ).append("\n"); 
		query.append("                                            AND    CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                                            AND    VSKD_PORT_RHQ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                    WHERE   POR_RHQ = DECODE(SUBSTR(@[rhq], 1, 3), 'ALL', POR_RHQ, @[rhq])" ).append("\n"); 
		query.append("                           ) R" ).append("\n"); 
		query.append("                           WHERE  T.VSL_CD       = V.VSL_CD" ).append("\n"); 
		query.append("                           AND    T.VOY_NO       = V.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND    T.DIR_CD       = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND    T.PORT_CD      = V.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND    T.CALL_IND     = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND    V.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("                           AND    V.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND    V.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND    V.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND    V.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                           AND    V.SLAN_CD      = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("                           --AND    V.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND    V.VPS_PORT_CD  = R.LOC_CD " ).append("\n"); 
		query.append("                           AND    T.VSL_CD       = D.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND    T.VOY_NO       = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND    T.DIR_CD       = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                           AND    T.PORT_CD      = D.CLPT_CD(+)" ).append("\n"); 
		query.append("                           AND    T.CALL_IND     = D.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                           AND    T.COMMENCE     IS NOT NULL" ).append("\n"); 
		query.append("                           AND    T.MVS          > 0" ).append("\n"); 
		query.append("                           AND    ( REPLACE(@[from_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:fm_dt" ).append("\n"); 
		query.append("                                    OR REPLACE(@[to_date],'-','') BETWEEN TO_CHAR(A.ACT_DEP_DT, 'yyyymm') AND TO_CHAR(A.ACT_DEP_DT, 'yyyymm')  --:to_dt" ).append("\n"); 
		query.append("                                    OR ( TO_CHAR(A.ACT_DEP_DT,'YYYYMM') >= REPLACE(@[from_date],'-','') AND    TO_CHAR(A.ACT_DEP_DT,'YYYYMM') <= REPLACE(@[to_date],'-','') ) ) --:fm_dt, :to_dt" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("                           AND    V.VPS_PORT_CD  LIKE @[loc_cd]||'%'                                                            --:port_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_cd} != '')" ).append("\n"); 
		query.append("                           AND    V.YD_CD        LIKE @[yd_cd]||'%'                                                             --:yd_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           AND    R.POR_RHQ      = DECODE(@[rhq], 'ALL', R.POR_RHQ, @[rhq])   " ).append("\n"); 
		query.append("                                   --:rhq_cd" ).append("\n"); 
		query.append("#if (${slan_cd} != 'ALL')" ).append("\n"); 
		query.append("                           AND    V.SLAN_CD      = @[slan_cd]                                                                    --:Lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${target_lanes} != 'ALL')" ).append("\n"); 
		query.append("                           AND    L.TML_PROD_RPT_FLG LIKE @[target_lanes]||'%'                                                --Target Lanes Only 일경우 'Y', ALL일 경우 NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${target_ports} != 'ALL')" ).append("\n"); 
		query.append("                           AND    R.TP           LIKE @[target_ports]||'%'                                                     --Target Ports Only 일경우 'B', ALL일 경우 NULL" ).append("\n"); 
		query.append("                           AND    R.VOP_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${tml_prod_rpt_rsn_cd} != '')" ).append("\n"); 
		query.append("                           AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE(@[tml_prod_rpt_rsn_cd],'N','Y','N')       --Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND    DECODE(D.TML_PROD_RPT_RSN_CD,NULL,'Y','N') = DECODE('N','N','Y','N')       --Exclude fm TPR이 Check되었을 경우 'Y', Check되지 않았을 경우 'N'" ).append("\n"); 
		query.append("#end                                " ).append("\n"); 
		query.append("                           GROUP BY ( V.VPS_PORT_CD, V.YD_CD, V.SLAN_CD, T.VSL_CD||T.VOY_NO||T.DIR_CD )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                       GROUP BY ROLLUP( PORT, YARD, LANE, VVD) " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                  where C2 = 1" ).append("\n"); 
		query.append("                  /* Q2 */" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("         ORDER BY DECODE(C2,1,'YYYYY',2,'ZZZZZ',PORT), DECODE(C2,3,YARD||'Z',YARD), DECODE(C2,1,'YYY','2','ZZZ',LANE), ATA" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}