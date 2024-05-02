/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpShuttleCostCSQL.java
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

public class ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpShuttleCostCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCQ_AWK_ROUT_DTL_TMP 의 Shuttle Cost 계산 및 결과 생성
	  * </pre>
	  */
	public ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpShuttleCostCSQL(){
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
		query.append("FileName : ScqAwkwardDBDAOcalcPriScqAwkRoutDtlTmpShuttleCostCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCQ_AWK_ROUT_DTL_TMP" ).append("\n"); 
		query.append("(       SCQ_RQST_NO" ).append("\n"); 
		query.append("    ,   SCQ_VER_NO" ).append("\n"); 
		query.append("    ,   ROUT_SEQ" ).append("\n"); 
		query.append("    ,   ROUT_COST_SEQ" ).append("\n"); 
		query.append("    ,   ROUT_COST_DTL_SEQ" ).append("\n"); 
		query.append("    ,   COST_TP_CD" ).append("\n"); 
		query.append("    ,   FM_YD_CD" ).append("\n"); 
		query.append("    ,   TO_YD_CD" ).append("\n"); 
		query.append("    ,   CGO_SEQ" ).append("\n"); 
		query.append("    ,   CNTR_QTY" ).append("\n"); 
		query.append("    ,   USD_AMT" ).append("\n"); 
		query.append("    ,   SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    ,   CRE_USR_ID" ).append("\n"); 
		query.append("    ,   CRE_DT" ).append("\n"); 
		query.append("    ,   UPD_USR_ID" ).append("\n"); 
		query.append("    ,   UPD_DT" ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WITH" ).append("\n"); 
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
		query.append(", ROUT_CS AS (" ).append("\n"); 
		query.append("    SELECT  ROUT_SEQ, ROUT_TP_CD, ROUT_TP_SEQ, IB_YD_CD, OB_YD_CD, CGO_IO_GA_CD" ).append("\n"); 
		query.append("    FROM    PRI_SCQ_AWK_ROUT_TMP A" ).append("\n"); 
		query.append("        ,   (" ).append("\n"); 
		query.append("                SELECT  DISTINCT CGO_IO_GA_CD" ).append("\n"); 
		query.append("                FROM    CGO_CS " ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("    WHERE   A.SCQ_RQST_NO = @[scq_rqst_no]  " ).append("\n"); 
		query.append("    AND     A.SCQ_VER_NO  = @[scq_ver_no_tmp]  " ).append("\n"); 
		query.append("    AND     A.ROUT_TP_CD  = 'N'       " ).append("\n"); 
		query.append(")           " ).append("\n"); 
		query.append(", MAX_COND_LIST AS (" ).append("\n"); 
		query.append("    SELECT  B.ROUT_SEQ, B.ROUT_TP_CD" ).append("\n"); 
		query.append("        ,   B.IB_YD_CD, B.OB_YD_CD" ).append("\n"); 
		query.append("        ,   B.CGO_IO_GA_CD" ).append("\n"); 
		query.append("        ,   A.IO_GA_CD" ).append("\n"); 
		query.append("        ,   A.TRSP_CRR_MOD_CD " ).append("\n"); 
		query.append("        ,   A.COND_NO" ).append("\n"); 
		query.append("        ,   MAX ( A.TRSP_AWK_TRF_VER_NO ) AS MAX_VER_NO" ).append("\n"); 
		query.append("        ,   CASE WHEN A.IO_GA_CD <> 'A' AND A.TRSP_CRR_MOD_CD = 'TD' THEN 4" ).append("\n"); 
		query.append("                 WHEN A.IO_GA_CD <> 'A' AND A.TRSP_CRR_MOD_CD = 'WD' THEN 3" ).append("\n"); 
		query.append("                 WHEN A.IO_GA_CD =  'A' AND A.TRSP_CRR_MOD_CD = 'TD' THEN 2" ).append("\n"); 
		query.append("                 WHEN A.IO_GA_CD =  'A' AND A.TRSP_CRR_MOD_CD = 'WD' THEN 1 END AS PRIORITY" ).append("\n"); 
		query.append("        ,   MAX ( CASE WHEN A.IO_GA_CD <> 'A' AND A.TRSP_CRR_MOD_CD = 'TD' THEN 4" ).append("\n"); 
		query.append("                       WHEN A.IO_GA_CD <> 'A' AND A.TRSP_CRR_MOD_CD = 'WD' THEN 3" ).append("\n"); 
		query.append("                       WHEN A.IO_GA_CD =  'A' AND A.TRSP_CRR_MOD_CD = 'TD' THEN 2" ).append("\n"); 
		query.append("                       WHEN A.IO_GA_CD =  'A' AND A.TRSP_CRR_MOD_CD = 'WD' THEN 1 END ) " ).append("\n"); 
		query.append("            OVER ( PARTITION BY B.ROUT_SEQ, B.ROUT_TP_CD, B.IB_YD_CD, B.OB_YD_CD, B.CGO_IO_GA_CD ) AS MAX_PRIORITY" ).append("\n"); 
		query.append("    FROM    TRS_AWK_CGO_TRF_HDR A, ROUT_CS B" ).append("\n"); 
		query.append("    WHERE   A.FM_YD_CD = B.IB_YD_CD" ).append("\n"); 
		query.append("    AND     A.TO_YD_CD = B.OB_YD_CD" ).append("\n"); 
		query.append("    AND     A.TRSP_AWK_CGO_TRF_TP_CD = 'S'" ).append("\n"); 
		query.append("    AND  (  A.IO_GA_CD = B.CGO_IO_GA_CD OR A.IO_GA_CD = 'A' )" ).append("\n"); 
		query.append("    GROUP   BY B.ROUT_SEQ, B.ROUT_TP_CD, B.IB_YD_CD, B.OB_YD_CD, B.CGO_IO_GA_CD, A.IO_GA_CD, A.TRSP_CRR_MOD_CD, A.COND_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", DIST_COND_LIST AS (" ).append("\n"); 
		query.append("    SELECT  DISTINCT CGO_IO_GA_CD, COND_NO " ).append("\n"); 
		query.append("    FROM    MAX_COND_LIST     " ).append("\n"); 
		query.append("    WHERE   PRIORITY = MAX_PRIORITY" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append(", CGO_COND_CHK_LIST AS ( " ).append("\n"); 
		query.append("    SELECT  A.CGO_SEQ, A.CNTR_TPSZ_CD, A.CNTR_QTY, A.CGO_IO_GA_CD, B.COND_NO" ).append("\n"); 
		query.append("        ,   PRI_SCQ_CGO_COND_CHK_FNC ( B.COND_NO, @[scq_rqst_no] , @[scq_ver_no_tmp] , A.CGO_SEQ ) COND_CHK_RSLT" ).append("\n"); 
		query.append("    FROM    CGO_CS A, DIST_COND_LIST B" ).append("\n"); 
		query.append("    WHERE   A.CGO_IO_GA_CD = B.CGO_IO_GA_CD    " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MAX_AMT_LIST AS (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("            A.ROUT_SEQ, A.ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD" ).append("\n"); 
		query.append("        ,   B.CGO_SEQ, B.CGO_IO_GA_CD, B.CNTR_QTY" ).append("\n"); 
		query.append("        ,   C.USD_AMT " ).append("\n"); 
		query.append("        ,   MAX ( C.USD_AMT ) OVER ( PARTITION BY A.ROUT_SEQ, A.ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD, A.TRSP_CRR_MOD_CD, B.CGO_SEQ, B.CGO_IO_GA_CD ) AS MAX_USD_AMT" ).append("\n"); 
		query.append("        ,   A.COND_NO" ).append("\n"); 
		query.append("        ,   C.SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    FROM    MAX_COND_LIST A" ).append("\n"); 
		query.append("        ,   CGO_COND_CHK_LIST B" ).append("\n"); 
		query.append("        ,   TRS_AWK_CGO_TRF_TP_SZ C" ).append("\n"); 
		query.append("    WHERE   A.CGO_IO_GA_CD = B.CGO_IO_GA_CD" ).append("\n"); 
		query.append("    AND     A.COND_NO = B.COND_NO " ).append("\n"); 
		query.append("    AND     B.COND_CHK_RSLT = 1  " ).append("\n"); 
		query.append("    AND     A.IB_YD_CD = C.FM_YD_CD" ).append("\n"); 
		query.append("    AND     A.OB_YD_CD = C.TO_YD_CD" ).append("\n"); 
		query.append("    AND     A.IO_GA_CD = C.IO_GA_CD" ).append("\n"); 
		query.append("    AND     A.TRSP_CRR_MOD_CD = C.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("    AND     A.COND_NO = C.COND_NO" ).append("\n"); 
		query.append("    AND     A.MAX_VER_NO = C.TRSP_AWK_TRF_VER_NO" ).append("\n"); 
		query.append("    AND     A.PRIORITY = A.MAX_PRIORITY  " ).append("\n"); 
		query.append("    AND     C.TRSP_AWK_CGO_TRF_TP_CD = 'S'" ).append("\n"); 
		query.append("    AND     C.TRSP_AWK_UC_CALC_TP_CD = 'S'   " ).append("\n"); 
		query.append("    AND     C.CNTR_SZ_CD = DECODE ( SIGN ( INSTR ( B.CNTR_TPSZ_CD, '2' ) ), 1, '2', '4' )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[scq_rqst_no] , @[scq_ver_no_tmp] , A.ROUT_SEQ" ).append("\n"); 
		query.append("    ,   PRI_SCQ_AWK_COST_SEQ_FNC ( A.ROUT_TP_CD, 'S', '' ) AS ROUT_COST_SEQ" ).append("\n"); 
		query.append("    ,   ROW_NUMBER ( ) OVER ( PARTITION BY A.ROUT_SEQ  ORDER BY A.CGO_SEQ ) AS ROUT_COST_DTL_SEQ" ).append("\n"); 
		query.append("    ,   'S' AS COST_TP_CD, A.IB_YD_CD AS FM_YD_CD, A.OB_YD_CD AS TO_YD_CD, A.CGO_SEQ, A.CNTR_QTY, A.USD_AMT" ).append("\n"); 
		query.append("    ,   MAX ( A.SPCL_CGO_REF_SEQ ) AS MAX_SPCL_CGO_REF_SEQ" ).append("\n"); 
		query.append("    ,   @[cre_usr_id] , SYSDATE, @[cre_usr_id] , SYSDATE" ).append("\n"); 
		query.append("FROM    MAX_AMT_LIST A" ).append("\n"); 
		query.append("WHERE   A.USD_AMT = A.MAX_USD_AMT" ).append("\n"); 
		query.append("GROUP   BY A.ROUT_SEQ, A.ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD, A.CGO_SEQ, A.CNTR_QTY, A.USD_AMT" ).append("\n"); 
		query.append("ORDER   BY A.ROUT_SEQ, A.ROUT_TP_CD, A.IB_YD_CD, A.OB_YD_CD, A.CGO_SEQ" ).append("\n"); 

	}
}