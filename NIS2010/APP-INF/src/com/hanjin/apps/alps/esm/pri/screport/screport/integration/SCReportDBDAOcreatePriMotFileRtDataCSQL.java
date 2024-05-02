/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SCReportDBDAOcreatePriMotFileRtDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.11.20 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHojin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAOcreatePriMotFileRtDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 일별 데이터중에서 이전 Filing 되었던 것과 같은 건을 제거한 
	  * 금일 Filing 대상 데이터 생성
	  * PRI_MOT_FILE_RT
	  * PRI_MOT_FILE_RT_SCG_DTL
	  * </pre>
	  */
	public SCReportDBDAOcreatePriMotFileRtDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exec_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAOcreatePriMotFileRtDataCSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("INSERT ALL " ).append("\n"); 
		query.append("WHEN    SCG_SEQ <= 1 THEN" ).append("\n"); 
		query.append("INTO PRI_MOT_FILE_RT" ).append("\n"); 
		query.append("( BAT_EXE_DT, MOT_FILE_RT_SEQ, CTRT_NO, CTRT_HLD_NM, ACT_CUST_NM, MOT_FILE_LANE_CD, MOT_FILE_ORG_CD, MOT_FILE_DEST_CD, MOT_FILE_CNTR_TP_CD, MOT_FILE_CMDT_TP_CD, " ).append("\n"); 
		query.append("MOT_FILE_CNTR_SZ_CD, MQC_QTY, MOT_FILE_RT_AMT, CTRT_EFF_DT, CTRT_EXP_DT, MOT_FILE_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, SHPR_CNT_CD, SHPR_SEQ, " ).append("\n"); 
		query.append("BKG_DIR_CALL_FLG, MOT_FILE_TS_PORT_CD, MOT_FILE_PRE_RLY_PORT_CD, MOT_FILE_PST_RLY_PORT_CD, MOT_FILE_IB_PORT_CD, MOT_FILE_DE_TERM_CD )" ).append("\n"); 
		query.append("VALUES ( BAT_EXE_DT, MOT_FILE_RT_LOG_SEQ, CTRT_NO, CTRT_HLD_NM, ACT_CUST_NM, MOT_FILE_LANE_CD, MOT_FILE_ORG_CD, MOT_FILE_DEST_CD, MOT_FILE_CNTR_TP_CD, " ).append("\n"); 
		query.append("MOT_FILE_CMDT_TP_CD, MOT_FILE_CNTR_SZ_CD, MQC_QTY, MOT_FILE_RT_AMT, CTRT_EFF_DT, CTRT_EXP_DT, MOT_FILE_RMK, 'SYSTEM', SYSDATE, 'SYSTEM', SYSDATE, SHPR_CNT_CD, SHPR_SEQ, " ).append("\n"); 
		query.append("BKG_DIR_CALL_FLG, MOT_FILE_TS_PORT_CD, MOT_FILE_PRE_RLY_PORT_CD, MOT_FILE_PST_RLY_PORT_CD, MOT_FILE_IB_PORT_CD, MOT_FILE_DE_TERM_CD )" ).append("\n"); 
		query.append("WHEN    SCG_SEQ >= 1 THEN" ).append("\n"); 
		query.append("INTO PRI_MOT_FILE_RT_SCG_DTL" ).append("\n"); 
		query.append("( BAT_EXE_DT, MOT_FILE_RT_SEQ, SCG_SEQ, CHG_CD, RAT_UT_CD, MOT_FILE_CHG_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("VALUES ( BAT_EXE_DT, MOT_FILE_RT_LOG_SEQ, SCG_SEQ, CHG_CD, RAT_UT_CD, MOT_FILE_CHG_AMT, 'SYSTEM', SYSDATE, 'SYSTEM', SYSDATE )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  A.BAT_EXE_DT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,   A.MOT_FILE_RT_LOG_SEQ" ).append("\n"); 
		query.append("    ,   NVL ( B.SCG_SEQ, 0 ) AS SCG_SEQ" ).append("\n"); 
		query.append("    ,   A.SHPR_CNT_CD" ).append("\n"); 
		query.append("    ,   A.SHPR_SEQ" ).append("\n"); 
		query.append("    ,   A.CTRT_NO" ).append("\n"); 
		query.append("    ,   A.CTRT_HLD_NM" ).append("\n"); 
		query.append("    ,   A.ACT_CUST_NM" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("    ,   A.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("    ,   '' AS MOT_FILE_TS_PORT_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_PRE_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_PST_RLY_PORT_CD" ).append("\n"); 
		query.append("    ,   A.MQC_QTY" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("    ,   A.CTRT_EFF_DT" ).append("\n"); 
		query.append("    ,   A.CTRT_EXP_DT" ).append("\n"); 
		query.append("    ,   A.MOT_FILE_RMK" ).append("\n"); 
		query.append("    ,   B.CHG_CD" ).append("\n"); 
		query.append("    ,   B.RAT_UT_CD" ).append("\n"); 
		query.append("    ,   B.MOT_FILE_CHG_AMT" ).append("\n"); 
		query.append("FROM    PRI_MOT_FILE_RT_LOG A" ).append("\n"); 
		query.append("    ,   PRI_MOT_FILE_RT_LOG_DTL B" ).append("\n"); 
		query.append("WHERE   A.BAT_EXE_DT = TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                EXISTS" ).append("\n"); 
		query.append("                (   SELECT 1" ).append("\n"); 
		query.append("                    FROM    PRI_MOT_FILE_RT_LOG_DTL D" ).append("\n"); 
		query.append("                    WHERE   D.BAT_EXE_DT = A.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND     D.MOT_FILE_RT_LOG_SEQ = A.MOT_FILE_RT_LOG_SEQ " ).append("\n"); 
		query.append("                    AND     ROWNUM <= 1 )" ).append("\n"); 
		query.append("                AND  EXISTS" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  D.CHG_CD" ).append("\n"); 
		query.append("                        ,   D.RAT_UT_CD" ).append("\n"); 
		query.append("                        ,   D.MOT_FILE_CHG_AMT" ).append("\n"); 
		query.append("                        ,   COUNT(1) OVER ( PARTITION BY M.BAT_EXE_DT, M.MOT_FILE_RT_LOG_SEQ ) AS KNT" ).append("\n"); 
		query.append("                    FROM    PRI_MOT_FILE_RT_LOG M" ).append("\n"); 
		query.append("                        ,   PRI_MOT_FILE_RT_LOG_DTL D" ).append("\n"); 
		query.append("                    WHERE   M.BAT_EXE_DT = TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )           " ).append("\n"); 
		query.append("                    AND     A.CTRT_NO = M.CTRT_NO" ).append("\n"); 
		query.append("                    AND     A.CTRT_HLD_NM = M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.ACT_CUST_NM IS NOT NULL AND A.ACT_CUST_NM = M.ACT_CUST_NM )" ).append("\n"); 
		query.append("                            OR A.ACT_CUST_NM IS NULL )" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_LANE_CD = M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_ORG_CD = M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_DEST_CD = M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_IB_PORT_CD = M.MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_DE_TERM_CD = M.MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CNTR_TP_CD = M.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CMDT_TP_CD = M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CNTR_SZ_CD = M.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("                    AND     A.BKG_DIR_CALL_FLG    = M.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_PRE_RLY_PORT_CD IS NOT NULL AND A.MOT_FILE_PRE_RLY_PORT_CD = M.MOT_FILE_PRE_RLY_PORT_CD )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_PRE_RLY_PORT_CD IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_PST_RLY_PORT_CD IS NOT NULL AND A.MOT_FILE_PST_RLY_PORT_CD = M.MOT_FILE_PST_RLY_PORT_CD )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_PST_RLY_PORT_CD IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MQC_QTY IS NOT NULL AND A.MQC_QTY = M.MQC_QTY )" ).append("\n"); 
		query.append("                            OR A.MQC_QTY IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_RT_AMT IS NOT NULL AND A.MOT_FILE_RT_AMT = M.MOT_FILE_RT_AMT )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_RT_AMT IS NULL )" ).append("\n"); 
		query.append("                    AND     A.CTRT_EFF_DT = M.CTRT_EFF_DT" ).append("\n"); 
		query.append("                    AND     A.CTRT_EXP_DT = M.CTRT_EXP_DT " ).append("\n"); 
		query.append("                    AND     M.BAT_EXE_DT = D.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND     M.MOT_FILE_RT_LOG_SEQ = D.MOT_FILE_RT_LOG_SEQ" ).append("\n"); 
		query.append("                    MINUS " ).append("\n"); 
		query.append("                    SELECT  D.CHG_CD" ).append("\n"); 
		query.append("                        ,   D.RAT_UT_CD" ).append("\n"); 
		query.append("                        ,   D.MOT_FILE_CHG_AMT" ).append("\n"); 
		query.append("                        ,   COUNT(1) OVER ( PARTITION BY M.BAT_EXE_DT, M.MOT_FILE_RT_SEQ ) AS KNT" ).append("\n"); 
		query.append("                    FROM    PRI_MOT_FILE_RT M" ).append("\n"); 
		query.append("                        ,   PRI_MOT_FILE_RT_SCG_DTL D" ).append("\n"); 
		query.append("                    WHERE   M.BAT_EXE_DT < TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )           " ).append("\n"); 
		query.append("                    AND     A.CTRT_NO = M.CTRT_NO" ).append("\n"); 
		query.append("                    AND     A.CTRT_HLD_NM = M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.ACT_CUST_NM IS NOT NULL AND A.ACT_CUST_NM = M.ACT_CUST_NM )" ).append("\n"); 
		query.append("                            OR A.ACT_CUST_NM IS NULL )" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_LANE_CD = M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_ORG_CD = M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_DEST_CD = M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_IB_PORT_CD = M.MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_DE_TERM_CD = M.MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CNTR_TP_CD = M.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CMDT_TP_CD = M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CNTR_SZ_CD = M.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("                    AND     A.BKG_DIR_CALL_FLG    = M.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_PRE_RLY_PORT_CD IS NOT NULL AND A.MOT_FILE_PRE_RLY_PORT_CD = M.MOT_FILE_PRE_RLY_PORT_CD )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_PRE_RLY_PORT_CD IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_PST_RLY_PORT_CD IS NOT NULL AND A.MOT_FILE_PST_RLY_PORT_CD = M.MOT_FILE_PST_RLY_PORT_CD )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_PST_RLY_PORT_CD IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MQC_QTY IS NOT NULL AND A.MQC_QTY = M.MQC_QTY )" ).append("\n"); 
		query.append("                            OR A.MQC_QTY IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_RT_AMT IS NOT NULL AND A.MOT_FILE_RT_AMT = M.MOT_FILE_RT_AMT )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_RT_AMT IS NULL )" ).append("\n"); 
		query.append("                    AND     A.CTRT_EFF_DT = M.CTRT_EFF_DT" ).append("\n"); 
		query.append("                    AND     A.CTRT_EXP_DT = M.CTRT_EXP_DT " ).append("\n"); 
		query.append("                    AND     M.BAT_EXE_DT = D.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND     M.MOT_FILE_RT_SEQ = D.MOT_FILE_RT_SEQ" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        OR " ).append("\n"); 
		query.append("        (  " ).append("\n"); 
		query.append("            (   NOT EXISTS" ).append("\n"); 
		query.append("                (   SELECT  1" ).append("\n"); 
		query.append("                    FROM    PRI_MOT_FILE_RT_LOG_DTL D" ).append("\n"); 
		query.append("                    WHERE   D.BAT_EXE_DT = A.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND     D.MOT_FILE_RT_LOG_SEQ = A.MOT_FILE_RT_LOG_SEQ " ).append("\n"); 
		query.append("                    AND     ROWNUM <= 1 ) " ).append("\n"); 
		query.append("                AND NOT EXISTS " ).append("\n"); 
		query.append("                (   SELECT  1" ).append("\n"); 
		query.append("                    FROM    PRI_MOT_FILE_RT M" ).append("\n"); 
		query.append("                    WHERE   M.BAT_EXE_DT < TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )           " ).append("\n"); 
		query.append("                    AND     A.CTRT_NO = M.CTRT_NO" ).append("\n"); 
		query.append("                    AND     A.CTRT_HLD_NM = M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.ACT_CUST_NM IS NOT NULL AND A.ACT_CUST_NM = M.ACT_CUST_NM )" ).append("\n"); 
		query.append("                            OR A.ACT_CUST_NM IS NULL )" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_LANE_CD = M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_ORG_CD = M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_DEST_CD = M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_IB_PORT_CD = M.MOT_FILE_IB_PORT_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_DE_TERM_CD = M.MOT_FILE_DE_TERM_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CNTR_TP_CD = M.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CMDT_TP_CD = M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                    AND     A.MOT_FILE_CNTR_SZ_CD = M.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("                    AND     A.BKG_DIR_CALL_FLG    = M.BKG_DIR_CALL_FLG" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_PRE_RLY_PORT_CD IS NOT NULL AND A.MOT_FILE_PRE_RLY_PORT_CD = M.MOT_FILE_PRE_RLY_PORT_CD )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_PRE_RLY_PORT_CD IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_PST_RLY_PORT_CD IS NOT NULL AND A.MOT_FILE_PST_RLY_PORT_CD = M.MOT_FILE_PST_RLY_PORT_CD )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_PST_RLY_PORT_CD IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MQC_QTY IS NOT NULL AND A.MQC_QTY = M.MQC_QTY )" ).append("\n"); 
		query.append("                            OR A.MQC_QTY IS NULL )" ).append("\n"); 
		query.append("                    AND  (" ).append("\n"); 
		query.append("                            (  A.MOT_FILE_RT_AMT IS NOT NULL AND A.MOT_FILE_RT_AMT = M.MOT_FILE_RT_AMT )" ).append("\n"); 
		query.append("                            OR A.MOT_FILE_RT_AMT IS NULL )" ).append("\n"); 
		query.append("                    AND     A.CTRT_EFF_DT = M.CTRT_EFF_DT" ).append("\n"); 
		query.append("                    AND     A.CTRT_EXP_DT = M.CTRT_EXP_DT " ).append("\n"); 
		query.append("                    AND     NOT EXISTS" ).append("\n"); 
		query.append("                        (   SELECT  1" ).append("\n"); 
		query.append("                            FROM    PRI_MOT_FILE_RT_SCG_DTL D" ).append("\n"); 
		query.append("                            WHERE   D.BAT_EXE_DT = M.BAT_EXE_DT    " ).append("\n"); 
		query.append("                            AND     D.MOT_FILE_RT_SEQ = M.MOT_FILE_RT_SEQ" ).append("\n"); 
		query.append("                        )   " ).append("\n"); 
		query.append("                )  " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("AND     A.BAT_EXE_DT = B.BAT_EXE_DT(+)" ).append("\n"); 
		query.append("AND     A.MOT_FILE_RT_LOG_SEQ = B.MOT_FILE_RT_LOG_SEQ(+)" ).append("\n"); 
		query.append("ORDER   BY 1,2,3" ).append("\n"); 

	}
}