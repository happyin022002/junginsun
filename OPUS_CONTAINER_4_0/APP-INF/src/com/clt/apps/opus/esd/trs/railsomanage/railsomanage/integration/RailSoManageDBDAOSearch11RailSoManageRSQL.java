/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailSoManageDBDAOSearch11RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.03.22 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch11RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail Empty Verify SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch11RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch11RailSoManageRSQL").append("\n"); 
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
		query.append("#set(${eqNoVerify}=${eqNoVerify})" ).append("\n"); 
		query.append("#set(${frmNodeVerify}=${frmNodeVerify})" ).append("\n"); 
		query.append("#set(${toNodVerify}=${toNodVerify})" ).append("\n"); 
		query.append("#set(${eqToNodVerify}=${eqToNodVerify})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrNo})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("MAX(VERIFY_RESULT) VERIFY_RESULT," ).append("\n"); 
		query.append("MAX(VERIFY_YN) VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("C.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("NVL(MAX(DECODE(C.CNTR_USE_CO_CD, 'D' , 'Senator CARGO! ') ||" ).append("\n"); 
		query.append("DECODE(C.SYS_AREA_GRP_ID, 'USA', '', 'CNTR is not in the states! ') ||" ).append("\n"); 
		query.append("DECODE(C.ACIAC_DIV_CD, 'I', 'CNTR status is inactive! ')) ||" ).append("\n"); 
		query.append("DECODE(SUBSTR(MAX(CM.CNMV_YR || TO_CHAR(CM.CNMV_ID_NO, '00000') || CM.CNMV_RMK), 11, 3)," ).append("\n"); 
		query.append("'SBO', 'SBO CARGO!', 'LSO', 'LSO CARGO!', 'MUO', 'MUO CARGO!', 'SKD', 'SKD CARGO!'," ).append("\n"); 
		query.append("'SLD', 'SLD CARGO!', 'TLL', 'TLL CARGO!'), 'LSTM CD = OF')  VERIFY_RESULT," ).append("\n"); 
		query.append("'Y' VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MST_CONTAINER C," ).append("\n"); 
		query.append("CTM_MOVEMENT CM" ).append("\n"); 
		query.append("WHERE C.CNTR_NO = ${eqNoVerify.get($key)}" ).append("\n"); 
		query.append("AND   C.CNTR_NO = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   CM.CNMV_YR||TO_CHAR(CM.CNMV_ID_NO , '00000') = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(M.CNMV_YR||TO_CHAR(M.CNMV_ID_NO, '00000') )" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO  = C.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(C.CNTR_USE_CO_CD = 'D' OR C.SYS_AREA_GRP_ID <> 'USA' OR C.ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("OR SUBSTR(CM.CNMV_RMK, 1, 3) IN ('SBO', 'LSO', 'MUO', 'SKD', 'SLD', 'TLL'))" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("C.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'OF'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("LSE_AGMT_RT DF" ).append("\n"); 
		query.append("WHERE C.AGMT_CTY_CD = DF.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND   C.AGMT_SEQ = DF.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND   LOC_CD = ${frmNodeVerify.get($key)}" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("C.CNTR_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("SUBSTR( TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') || 'COMPANY - CNTR_NO: ' || EQ_NO ||" ).append("\n"); 
		query.append("' S/O created( '|| TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') || DECODE(TRSP_BND_CD, Null , ' : Mty )', ' : Full )') ||" ).append("\n"); 
		query.append("' ROUTE : ' || FM_NOD_CD || '-->' || TO_NOD_CD ,9,100) VERIFY_RESULT," ).append("\n"); 
		query.append("CASE WHEN SO.TRSP_BND_CD = 'O' OR SO.CGO_TP_CD ='M' THEN 'Y'" ).append("\n"); 
		query.append("WHEN SO.TRSP_BND_CD = 'I' THEN 'N'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND   EQ_NO = ${eqNoVerify.get($key)}" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("( SO.TRSP_BND_CD = 'O' AND  LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd])  )" ).append("\n"); 
		query.append("OR  (SO.TRSP_BND_CD = 'I' AND  LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) - 5) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) )" ).append("\n"); 
		query.append("OR  (SO.CGO_TP_CD = 'M'   AND  LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LTRIM(BB.EQ_NO, ' ') EQ_NO," ).append("\n"); 
		query.append("CASE WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USLGB' THEN ''" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USSEA' THEN ''" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USORF' THEN ''" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USLGB' THEN 'This container/Genset can not be moved to USLGB due to CARP regulation.'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USSEA' THEN 'The rail dest should be ''USLGB'' due to genset management.'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USORF' THEN 'The rail dest should be ''USLGB'' due to genset management.'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VERIFY_RESULT," ).append("\n"); 
		query.append("CASE WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USLGB' THEN 'N'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USSEA' THEN 'N'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USORF' THEN 'N'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USLGB' THEN 'Y'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USSEA' THEN 'Y'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USORF' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SO.EQ_NO," ).append("\n"); 
		query.append("MAX(SO.TRSP_SO_SEQ) TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO," ).append("\n"); 
		query.append("BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE SO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND (DECODE(SO.POD_CD, 'USORF', 'USSEA', SO.POD_CD), SO.EQ_NO) IN (" ).append("\n"); 
		query.append("(SUBSTR(${eqToNodVerify.get($key)}, 1, 5), SUBSTR(${eqToNodVerify.get($key)}, 6))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SO.EQ_TPSZ_CD = 'R5'" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND SO.LOCL_CRE_DT >= SYSDATE - 35" ).append("\n"); 
		query.append("AND BKG.RC_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SO.EQ_NO" ).append("\n"); 
		query.append(") AA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SO.EQ_NO," ).append("\n"); 
		query.append("MAX(SO.POD_CD) POD_CD," ).append("\n"); 
		query.append("MAX(SO.TRSP_SO_SEQ) TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO," ).append("\n"); 
		query.append("BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE SO.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND SO.EQ_NO = ${eqNoVerify.get($key)}" ).append("\n"); 
		query.append("AND SO.EQ_TPSZ_CD = 'R5'" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND SO.LOCL_CRE_DT >= SYSDATE - 35" ).append("\n"); 
		query.append("AND BKG.RC_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SO.EQ_NO" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE AA.TRSP_SO_SEQ(+) = BB.TRSP_SO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("EQ_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("MAX(VERIFY_RESULT) VERIFY_RESULT," ).append("\n"); 
		query.append("MAX(VERIFY_YN) VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("C.CNTR_NO EQ_NO," ).append("\n"); 
		query.append("NVL(MAX(DECODE(C.CNTR_USE_CO_CD, 'D' , 'Senator CARGO! ') ||" ).append("\n"); 
		query.append("DECODE(C.SYS_AREA_GRP_ID, 'USA', '', 'CNTR is not in the states! ') ||" ).append("\n"); 
		query.append("DECODE(C.ACIAC_DIV_CD, 'I', 'CNTR status is inactive! ')) ||" ).append("\n"); 
		query.append("DECODE(SUBSTR(MAX(CM.CNMV_YR || TO_CHAR(CM.CNMV_ID_NO, '00000') || CM.CNMV_RMK), 11, 3)," ).append("\n"); 
		query.append("'SBO', 'SBO CARGO!', 'LSO', 'LSO CARGO!', 'MUO', 'MUO CARGO!', 'SKD', 'SKD CARGO!'," ).append("\n"); 
		query.append("'SLD', 'SLD CARGO!', 'TLL', 'TLL CARGO!'), 'LSTM CD = OF')  VERIFY_RESULT," ).append("\n"); 
		query.append("'Y' VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MST_CONTAINER C," ).append("\n"); 
		query.append("CTM_MOVEMENT CM" ).append("\n"); 
		query.append("WHERE C.CNTR_NO = ${eqNoVerify.get($key)}" ).append("\n"); 
		query.append("AND   C.CNTR_NO = CM.CNTR_NO(+)" ).append("\n"); 
		query.append("AND   CM.CNMV_YR||TO_CHAR(CM.CNMV_ID_NO , '00000') = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MAX(M.CNMV_YR||TO_CHAR(M.CNMV_ID_NO, '00000') )" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO  = C.CNTR_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(C.CNTR_USE_CO_CD = 'D' OR C.SYS_AREA_GRP_ID <> 'USA' OR C.ACIAC_DIV_CD = 'I'" ).append("\n"); 
		query.append("OR SUBSTR(CM.CNMV_RMK, 1, 3) IN ('SBO', 'LSO', 'MUO', 'SKD', 'SLD', 'TLL'))" ).append("\n"); 
		query.append("OR (" ).append("\n"); 
		query.append("C.LSTM_CD = 'OF'" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'OF'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("LSE_AGMT_RT DF" ).append("\n"); 
		query.append("WHERE C.AGMT_CTY_CD = DF.AGMT_CTY_CD(+)" ).append("\n"); 
		query.append("AND   C.AGMT_SEQ = DF.AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND   LOC_CD = ${frmNodeVerify.get($key)}" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("C.CNTR_NO" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("SUBSTR( TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') || 'COMPANY - CNTR_NO: ' || EQ_NO ||" ).append("\n"); 
		query.append("' S/O created( '|| TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD') || DECODE(TRSP_BND_CD, Null , ' : Mty )', ' : Full )') ||" ).append("\n"); 
		query.append("' ROUTE : ' || FM_NOD_CD || '-->' || TO_NOD_CD ,9,100) VERIFY_RESULT," ).append("\n"); 
		query.append("CASE WHEN SO.TRSP_BND_CD = 'O' OR SO.CGO_TP_CD ='M' THEN 'Y'" ).append("\n"); 
		query.append("WHEN SO.TRSP_BND_CD = 'I' THEN 'N'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND   EQ_NO = ${eqNoVerify.get($key)}" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("( SO.TRSP_BND_CD = 'O' AND  LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd])  )" ).append("\n"); 
		query.append("OR  (SO.TRSP_BND_CD = 'I' AND  LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) - 5) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) )" ).append("\n"); 
		query.append("OR  (SO.CGO_TP_CD = 'M'   AND  LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sctrlOfcCd]) )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("LTRIM(BB.EQ_NO, ' ') EQ_NO," ).append("\n"); 
		query.append("CASE WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USLGB' THEN ''" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USSEA' THEN ''" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USORF' THEN ''" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USLGB' THEN 'This container/Genset can not be moved to USLGB due to CARP regulation.'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USSEA' THEN 'The rail dest should be ''USLGB'' due to genset management.'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USORF' THEN 'The rail dest should be ''USLGB'' due to genset management.'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VERIFY_RESULT," ).append("\n"); 
		query.append("CASE WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USLGB' THEN 'N'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USSEA' THEN 'N'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) != 0 AND BB.POD_CD = 'USORF' THEN 'N'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USLGB' THEN 'Y'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USSEA' THEN 'Y'" ).append("\n"); 
		query.append("WHEN NVL(AA.TRSP_SO_SEQ, 0) = 0 AND BB.POD_CD = 'USORF' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SO.EQ_NO," ).append("\n"); 
		query.append("MAX(SO.TRSP_SO_SEQ) TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("WHERE (DECODE(SO.POD_CD, 'USORF', 'USSEA', SO.POD_CD), SO.EQ_NO) IN (" ).append("\n"); 
		query.append("(SUBSTR(${eqToNodVerify.get($key)}, 1, 5), SUBSTR(${eqToNodVerify.get($key)}, 6))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND SO.EQ_TPSZ_CD = 'R5'" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND SO.LOCL_CRE_DT >= SYSDATE - 35" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SO.EQ_NO" ).append("\n"); 
		query.append(") AA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SO.EQ_NO," ).append("\n"); 
		query.append("MAX(SO.POD_CD) POD_CD," ).append("\n"); 
		query.append("MAX(SO.TRSP_SO_SEQ) TRSP_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("WHERE SO.EQ_NO = ${eqNoVerify.get($key)}" ).append("\n"); 
		query.append("AND SO.EQ_TPSZ_CD = 'R5'" ).append("\n"); 
		query.append("AND SO.TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("AND SO.LOCL_CRE_DT >= SYSDATE - 35" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("SO.EQ_NO" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE AA.TRSP_SO_SEQ(+) = BB.TRSP_SO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("EQ_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}