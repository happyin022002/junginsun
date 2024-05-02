/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCReportDBDAOcreatePriMotFileRtDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.24
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2015.05.24 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
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
		query.append("Path : com.clt.apps.opus.esm.pri.screport.screport.integration").append("\n"); 
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
		query.append("INSERT ALL " ).append("\n"); 
		query.append("WHEN    SCG_SEQ <= 1 THEN" ).append("\n"); 
		query.append("INTO PRI_MOT_FILE_RT " ).append("\n"); 
		query.append("(BAT_EXE_DT, MOT_FILE_RT_SEQ, CTRT_NO, CTRT_HLD_NM, ACT_CUST_NM, MOT_FILE_LANE_CD, MOT_FILE_ORG_CD, MOT_FILE_DEST_CD, MOT_FILE_CNTR_TP_CD, " ).append("\n"); 
		query.append(" MOT_FILE_CMDT_TP_CD, MOT_FILE_CNTR_SZ_CD, MOT_FILE_RT_AMT, CTRT_EFF_DT, CTRT_EXP_DT, MOT_FILE_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, SHPR_CNT_CD, SHPR_SEQ, " ).append("\n"); 
		query.append(" CNEE_NM, OP_AGN_NM, COMM_AMT, FWRD_CNT_CD, FWRD_CUST_SEQ)" ).append("\n"); 
		query.append("VALUES " ).append("\n"); 
		query.append("( BAT_EXE_DT, MOT_FILE_RT_LOG_SEQ, CTRT_NO, CTRT_HLD_NM, ACT_CUST_NM, MOT_FILE_LANE_CD, MOT_FILE_ORG_CD, MOT_FILE_DEST_CD, MOT_FILE_CNTR_TP_CD, " ).append("\n"); 
		query.append("  MOT_FILE_CMDT_TP_CD, MOT_FILE_CNTR_SZ_CD, MOT_FILE_RT_AMT, CTRT_EFF_DT, CTRT_EXP_DT, MOT_FILE_RMK, 'SYSTEM', SYSDATE, 'SYSTEM', SYSDATE, SHPR_CNT_CD, SHPR_SEQ," ).append("\n"); 
		query.append("  CNEE_NM, OP_AGN_NM, COMM_AMT, FWRD_CNT_CD, FWRD_CUST_SEQ )" ).append("\n"); 
		query.append("WHEN    SCG_SEQ >= 1 THEN" ).append("\n"); 
		query.append("INTO PRI_MOT_FILE_RT_SCG_DTL (BAT_EXE_DT, MOT_FILE_RT_SEQ, SCG_SEQ, CHG_CD, RAT_UT_CD, MOT_FILE_CHG_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, CURR_CD)" ).append("\n"); 
		query.append("VALUES ( BAT_EXE_DT, MOT_FILE_RT_LOG_SEQ, SCG_SEQ, CHG_CD, RAT_UT_CD, MOT_FILE_CHG_AMT, 'SYSTEM', SYSDATE, 'SYSTEM', SYSDATE, CURR_CD )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("       A.BAT_EXE_DT" ).append("\n"); 
		query.append("     , A.MOT_FILE_RT_LOG_SEQ" ).append("\n"); 
		query.append("     , NVL ( B.SCG_SEQ, 0 ) AS SCG_SEQ" ).append("\n"); 
		query.append("     , A.SHPR_CNT_CD" ).append("\n"); 
		query.append("     , A.SHPR_SEQ" ).append("\n"); 
		query.append("     , A.CTRT_NO" ).append("\n"); 
		query.append("     , A.CTRT_HLD_NM" ).append("\n"); 
		query.append("     , A.ACT_CUST_NM" ).append("\n"); 
		query.append("     , A.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("     , A.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("     , A.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("     , A.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("     , A.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("     , A.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("     , A.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("     , A.CTRT_EFF_DT" ).append("\n"); 
		query.append("     , A.CTRT_EXP_DT" ).append("\n"); 
		query.append("     , A.MOT_FILE_RMK" ).append("\n"); 
		query.append("     , A.CNEE_NM" ).append("\n"); 
		query.append("     , A.OP_AGN_NM" ).append("\n"); 
		query.append("     , B.CHG_CD" ).append("\n"); 
		query.append("     , B.RAT_UT_CD" ).append("\n"); 
		query.append("     , B.MOT_FILE_CHG_AMT" ).append("\n"); 
		query.append("     , B.CURR_CD" ).append("\n"); 
		query.append("     , A.COMM_AMT" ).append("\n"); 
		query.append("     , A.FWRD_CNT_CD" ).append("\n"); 
		query.append("     , A.FWRD_CUST_SEQ" ).append("\n"); 
		query.append("  FROM PRI_MOT_FILE_RT_LOG A" ).append("\n"); 
		query.append("     , PRI_MOT_FILE_RT_LOG_DTL B" ).append("\n"); 
		query.append(" WHERE   A.BAT_EXE_DT = TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )" ).append("\n"); 
		query.append("   AND EXISTS" ).append("\n"); 
		query.append("                (SELECT 1" ).append("\n"); 
		query.append("                   FROM PRI_MOT_FILE_RT_LOG_DTL D" ).append("\n"); 
		query.append("                  WHERE D.BAT_EXE_DT          = A.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND D.MOT_FILE_RT_LOG_SEQ = A.MOT_FILE_RT_LOG_SEQ " ).append("\n"); 
		query.append("                    AND ROWNUM <= 1 )" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("                 SELECT M.CTRT_NO" ).append("\n"); 
		query.append("                      , M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                      , M.ACT_CUST_NM" ).append("\n"); 
		query.append("                      , M.CNEE_NM" ).append("\n"); 
		query.append("                      , M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("                      , D.CHG_CD" ).append("\n"); 
		query.append("                      , D.RAT_UT_CD" ).append("\n"); 
		query.append("                   FROM PRI_MOT_FILE_RT_LOG M" ).append("\n"); 
		query.append("                      , PRI_MOT_FILE_RT_LOG_DTL D" ).append("\n"); 
		query.append("                  WHERE M.BAT_EXE_DT  = TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )           " ).append("\n"); 
		query.append("                    AND A.CTRT_NO             = M.CTRT_NO" ).append("\n"); 
		query.append("                    AND A.CTRT_HLD_NM         = M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                    AND A.ACT_CUST_NM         = M.ACT_CUST_NM" ).append("\n"); 
		query.append("                    AND NVL(A.CNEE_NM,'1')    = NVL(M.CNEE_NM,'1')" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_LANE_CD    = M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_ORG_CD     = M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_DEST_CD    = M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                    AND NVL(A.MOT_FILE_CNTR_TP_CD,'1') = NVL(M.MOT_FILE_CNTR_TP_CD,'1')" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_CMDT_TP_CD = M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_CNTR_SZ_CD = M.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_RT_AMT     = M.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("                    AND M.BAT_EXE_DT          = D.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND M.MOT_FILE_RT_LOG_SEQ = D.MOT_FILE_RT_LOG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  MINUS " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 SELECT M.CTRT_NO" ).append("\n"); 
		query.append("                      , M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                      , M.ACT_CUST_NM" ).append("\n"); 
		query.append("                      , M.CNEE_NM" ).append("\n"); 
		query.append("                      , M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_CNTR_TP_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_CNTR_SZ_CD" ).append("\n"); 
		query.append("                      , M.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("                      , D.CHG_CD" ).append("\n"); 
		query.append("                      , D.RAT_UT_CD" ).append("\n"); 
		query.append("                   FROM PRI_MOT_FILE_RT M" ).append("\n"); 
		query.append("                      , PRI_MOT_FILE_RT_SCG_DTL D" ).append("\n"); 
		query.append("                  WHERE M.BAT_EXE_DT          < TO_DATE ( @[exec_dt], 'YYYY-MM-DD' )           " ).append("\n"); 
		query.append("                    AND A.CTRT_NO             = M.CTRT_NO" ).append("\n"); 
		query.append("                    AND A.CTRT_HLD_NM         = M.CTRT_HLD_NM" ).append("\n"); 
		query.append("                    AND A.ACT_CUST_NM         = M.ACT_CUST_NM" ).append("\n"); 
		query.append("                    AND NVL(A.CNEE_NM,'1')    = NVL(M.CNEE_NM,'1')" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_LANE_CD    = M.MOT_FILE_LANE_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_ORG_CD     = M.MOT_FILE_ORG_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_DEST_CD    = M.MOT_FILE_DEST_CD" ).append("\n"); 
		query.append("                    AND NVL(A.MOT_FILE_CNTR_TP_CD,'1') = NVL(M.MOT_FILE_CNTR_TP_CD,'1')" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_CMDT_TP_CD = M.MOT_FILE_CMDT_TP_CD" ).append("\n"); 
		query.append("                    AND A.MOT_FILE_CNTR_SZ_CD = M.MOT_FILE_CNTR_SZ_CD  " ).append("\n"); 
		query.append("                    AND A.MOT_FILE_RT_AMT     = M.MOT_FILE_RT_AMT" ).append("\n"); 
		query.append("                    AND M.BAT_EXE_DT          = D.BAT_EXE_DT" ).append("\n"); 
		query.append("                    AND M.MOT_FILE_RT_SEQ     = D.MOT_FILE_RT_SEQ" ).append("\n"); 
		query.append("                )    " ).append("\n"); 
		query.append("   AND A.BAT_EXE_DT = B.BAT_EXE_DT(+)" ).append("\n"); 
		query.append("   AND A.MOT_FILE_RT_LOG_SEQ = B.MOT_FILE_RT_LOG_SEQ(+)" ).append("\n"); 
		query.append(" ORDER BY 1,2,3" ).append("\n"); 

	}
}