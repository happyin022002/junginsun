/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpBasicCostCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.30
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.30 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpBasicCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Cost 중 Basic ( POL, POD 에 적용 ) 금액 계산
	  * </pre>
	  */
	public ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpBasicCostCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration").append("\n"); 
		query.append("FileName : ScqAwkwardDBDAOcalcPriScqAwkYdDtlTmpBasicCostCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_AWK_YD_DTL_TMP" ).append("\n"); 
		query.append("(       SCQ_RQST_NO" ).append("\n"); 
		query.append("    ,   SCQ_VER_NO" ).append("\n"); 
		query.append("    ,   ROUT_SEQ" ).append("\n"); 
		query.append("    ,   YD_COST_SEQ" ).append("\n"); 
		query.append("    ,   YD_COST_DTL_SEQ" ).append("\n"); 
		query.append("    ,   IO_BND_CD" ).append("\n"); 
		query.append("    ,   YD_CD" ).append("\n"); 
		query.append("    ,   COST_TP_CD" ).append("\n"); 
		query.append("    ,   CGO_SEQ" ).append("\n"); 
		query.append("    ,   CNTR_QTY" ).append("\n"); 
		query.append("    ,   USD_AMT" ).append("\n"); 
		query.append("    ,   SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    ,   CRE_USR_ID" ).append("\n"); 
		query.append("    ,   CRE_DT" ).append("\n"); 
		query.append("    ,   UPD_USR_ID" ).append("\n"); 
		query.append("    ,   UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH " ).append("\n"); 
		query.append("CGO_CS AS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  CGO_SEQ" ).append("\n"); 
		query.append("         ,  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         ,  CNTR_QTY" ).append("\n"); 
		query.append("         ,  CASE WHEN NVL( OVR_FWRD_LEN, 0 ) <= 0 AND NVL( OVR_BKWD_LEN, 0 ) <= 0 AND NVL( OVR_LF_LEN, 0 ) <= 0 AND NVL( OVR_RT_LEN, 0 ) <= 0 AND NVL( OVR_HGT, 0 ) <= 0 THEN 'I' ELSE 'O' END AS CGO_IO_GA_CD  " ).append("\n"); 
		query.append("    FROM    PRI_SCQ_AWK_CGO_TMP" ).append("\n"); 
		query.append("    WHERE   SCQ_RQST_NO = @[scq_rqst_no]  " ).append("\n"); 
		query.append("    AND     SCQ_VER_NO  = @[scq_ver_no_tmp]  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ROUT_CS AS ( " ).append("\n"); 
		query.append("    SELECT  ROUT_SEQ, ROUT_TP_CD, IO_BND_CD, YD_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (   SELECT  ROUT_SEQ, ROUT_TP_CD, 'I' AS IO_BND_CD, IB_YD_CD AS YD_CD" ).append("\n"); 
		query.append("        FROM    PRI_SCQ_AWK_ROUT_TMP A" ).append("\n"); 
		query.append("        WHERE   A.SCQ_RQST_NO = @[scq_rqst_no]  " ).append("\n"); 
		query.append("        AND     A.SCQ_VER_NO = @[scq_ver_no_tmp]" ).append("\n"); 
		query.append("        AND     A.ROUT_TP_CD = 'P' " ).append("\n"); 
		query.append("        AND     A.IB_YD_CD IS NOT NULL" ).append("\n"); 
		query.append("        UNION   ALL" ).append("\n"); 
		query.append("        SELECT  ROUT_SEQ, ROUT_TP_CD, 'O', OB_YD_CD" ).append("\n"); 
		query.append("        FROM    PRI_SCQ_AWK_ROUT_TMP A" ).append("\n"); 
		query.append("        WHERE   A.SCQ_RQST_NO = @[scq_rqst_no] " ).append("\n"); 
		query.append("        AND     A.SCQ_VER_NO = @[scq_ver_no_tmp]  " ).append("\n"); 
		query.append("        AND     A.ROUT_TP_CD = 'L' " ).append("\n"); 
		query.append("        AND     A.OB_YD_CD IS NOT NULL" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("    ORDER   BY  ROUT_SEQ, ROUT_TP_CD, IO_BND_CD  " ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", MAX_COND_LIST AS (" ).append("\n"); 
		query.append("    SELECT  B.ROUT_SEQ, B.ROUT_TP_CD, A.IO_BND_CD, A.YD_CD" ).append("\n"); 
		query.append("        ,   'N' AS COST_TP_CD " ).append("\n"); 
		query.append("        ,   MAX ( A.TML_AWK_TRF_VER_NO ) AS MAX_VER_NO" ).append("\n"); 
		query.append("        ,   A.COND_NO" ).append("\n"); 
		query.append("        ,   DECODE ( A.COND_NO, 0, 1, 2 ) AS PRIORITY" ).append("\n"); 
		query.append("        ,   MAX ( DECODE ( A.COND_NO, 0, 1, 2 ) ) OVER ( PARTITION BY B.ROUT_SEQ, B.ROUT_TP_CD, A.IO_BND_CD, A.YD_CD ) AS MAX_PRIORITY         " ).append("\n"); 
		query.append("    FROM    TES_AWK_CGO_TRF_DTL A, ROUT_CS B" ).append("\n"); 
		query.append("    WHERE   A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("    AND     A.YD_CD = B.YD_CD" ).append("\n"); 
		query.append("    AND     A.TML_AWK_CGO_TRF_TP_CD = 'B'" ).append("\n"); 
		query.append("    AND     A.TML_AWK_TS_CD = 'S'" ).append("\n"); 
		query.append("    AND     A.IO_GA_CD = 'I'" ).append("\n"); 
		query.append("    AND     A.COND_NO NOT IN ( 9, 10 ) " ).append("\n"); 
		query.append("    GROUP   BY  " ).append("\n"); 
		query.append("            B.ROUT_SEQ, B.ROUT_TP_CD, A.IO_BND_CD, A.YD_CD, A.COND_NO" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", DIST_COND_LIST AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT  COND_NO " ).append("\n"); 
		query.append("    FROM    MAX_COND_LIST " ).append("\n"); 
		query.append("    WHERE   PRIORITY = MAX_PRIORITY" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", CGO_COND_CHK_LIST AS ( " ).append("\n"); 
		query.append("    SELECT  A.CGO_SEQ, A.CNTR_TPSZ_CD, A.CNTR_QTY, B.COND_NO" ).append("\n"); 
		query.append("        ,   PRI_SCQ_CGO_COND_CHK_FNC ( B.COND_NO, @[scq_rqst_no], @[scq_ver_no_tmp], A.CGO_SEQ ) COND_CHK_RSLT" ).append("\n"); 
		query.append("    FROM    CGO_CS A, DIST_COND_LIST B   " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MAX_AMT_LIST AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("            A.ROUT_SEQ, A.IO_BND_CD, A.YD_CD" ).append("\n"); 
		query.append("        ,   A.COST_TP_CD" ).append("\n"); 
		query.append("        ,   B.CGO_SEQ, B.CNTR_QTY, C.USD_AMT" ).append("\n"); 
		query.append("        ,   C.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("        ,   MAX ( C.USD_AMT ) OVER ( PARTITION BY A.ROUT_SEQ, A.IO_BND_CD, A.YD_CD, A.COST_TP_CD, B.CGO_SEQ ) AS MAX_USD_AMT" ).append("\n"); 
		query.append("        ,   A.ROUT_TP_CD" ).append("\n"); 
		query.append("        ,   C.TML_AWK_TS_CD, A.COND_NO, A.MAX_VER_NO" ).append("\n"); 
		query.append("        ,   C.TML_AWK_CGO_TRF_TP_CD" ).append("\n"); 
		query.append("    FROM    MAX_COND_LIST A" ).append("\n"); 
		query.append("        ,   CGO_COND_CHK_LIST B" ).append("\n"); 
		query.append("        ,   TES_AWK_CGO_TRF_TP_SZ C" ).append("\n"); 
		query.append("    WHERE   A.COND_NO = B.COND_NO " ).append("\n"); 
		query.append("    AND     B.COND_CHK_RSLT = 1   " ).append("\n"); 
		query.append("    AND     A.YD_CD = C.YD_CD" ).append("\n"); 
		query.append("    AND     A.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("    AND     A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("    AND     A.MAX_VER_NO = C.TML_AWK_TRF_VER_NO  " ).append("\n"); 
		query.append("    AND     A.PRIORITY = A.MAX_PRIORITY  " ).append("\n"); 
		query.append("    AND     C.TML_AWK_CGO_TRF_TP_CD = 'B'" ).append("\n"); 
		query.append("    AND     C.IO_GA_CD = 'I'" ).append("\n"); 
		query.append("    AND     C.TML_AWK_TS_CD = 'S'" ).append("\n"); 
		query.append("    AND     C.TML_AWK_UC_CALC_TP_CD = 'S'   " ).append("\n"); 
		query.append("    AND     C.CNTR_SZ_CD = DECODE ( SIGN ( INSTR ( B.CNTR_TPSZ_CD, '2' ) ), 1, '2', '4' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[scq_rqst_no] , @[scq_ver_no_tmp] , A.ROUT_SEQ" ).append("\n"); 
		query.append("    ,   PRI_SCQ_AWK_COST_SEQ_FNC ( A.ROUT_TP_CD, A.COST_TP_CD, A.IO_BND_CD ) AS YD_COST_SEQ" ).append("\n"); 
		query.append("    ,   ROW_NUMBER ( ) OVER ( PARTITION BY A.ROUT_SEQ, A.IO_BND_CD, A.YD_CD, A.COST_TP_CD  ORDER BY A.CGO_SEQ ) AS YD_COST_DTL_SEQ" ).append("\n"); 
		query.append("    ,   A.IO_BND_CD, A.YD_CD, A.COST_TP_CD, A.CGO_SEQ, A.CNTR_QTY, A.USD_AMT" ).append("\n"); 
		query.append("    ,   MAX ( SPCL_CGO_REF_SEQ )  AS MAX_SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    ,   @[cre_usr_id] , SYSDATE, @[cre_usr_id] , SYSDATE" ).append("\n"); 
		query.append("FROM    MAX_AMT_LIST A" ).append("\n"); 
		query.append("WHERE   A.USD_AMT = A.MAX_USD_AMT" ).append("\n"); 
		query.append("GROUP   BY A.ROUT_SEQ, A.ROUT_TP_CD, A.IO_BND_CD, A.YD_CD, A.COST_TP_CD, A.CGO_SEQ, A.CNTR_QTY, A.USD_AMT" ).append("\n"); 
		query.append("ORDER   BY A.ROUT_SEQ, A.ROUT_TP_CD, A.IO_BND_CD, A.YD_CD, A.COST_TP_CD, A.CGO_SEQ" ).append("\n"); 

	}
}