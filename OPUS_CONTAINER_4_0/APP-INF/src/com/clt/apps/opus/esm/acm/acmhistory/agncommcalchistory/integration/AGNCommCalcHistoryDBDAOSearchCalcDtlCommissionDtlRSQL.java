/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlCommissionDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommCalcHistoryDBDAOSearchCalcDtlCommissionDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Calculation Detail 의 Commission Detail 정보를 조회한다.
	  * </pre>
	  */
	public AGNCommCalcHistoryDBDAOSearchCalcDtlCommissionDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration").append("\n"); 
		query.append("FileName : AGNCommCalcHistoryDBDAOSearchCalcDtlCommissionDtlRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND CD.INTG_CD_ID = 'CD03021'" ).append("\n"); 
		query.append("           AND CD.INTG_CD_VAL_CTNT = A.AC_TP_CD) AS ACCT_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_SEQ  " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND CD.INTG_CD_ID = 'CD03021'" ).append("\n"); 
		query.append("           AND CD.INTG_CD_VAL_CTNT = A.AC_TP_CD) AS DP_SEQ             " ).append("\n"); 
		query.append("       , DECODE(A.REV_DIV_CD, '', 'Box','Rate') AS RT_FX_FLG" ).append("\n"); 
		query.append("       , DECODE(A.REV_DIV_CD, 'N', 'Net', 'G', 'Gross', '') AS REV_DIV_CD" ).append("\n"); 
		query.append("       , (A.CRNT_REV_AMT-A.DDCT_CHG_AMT -A.DDCT_TRSP_AMT -A.DDCT_SPCL_CMPN_AMT) AS COMM_REV_AMT" ).append("\n"); 
		query.append("       , A.COMM_RT||'%' AS COMM_RT_AMT" ).append("\n"); 
		query.append("       , '-' AS COMM_TPSZ_CD" ).append("\n"); 
		query.append("       , NULL AS BKG_VOL_QTY" ).append("\n"); 
		query.append("       , A.CRNT_AMT" ).append("\n"); 
		query.append("       , A.PPD_AMT" ).append("\n"); 
		query.append("       , A.IF_AMT" ).append("\n"); 
		query.append("       , A.PAY_IF_AMT" ).append("\n"); 
		query.append("       , '' AS RMK " ).append("\n"); 
		query.append("  FROM  ACM_AGN_COMM_HIS A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("   AND A.CALC_NO = @[calc_no]" ).append("\n"); 
		query.append("   AND A.REV_DIV_CD IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND CD.INTG_CD_ID = 'CD03021'" ).append("\n"); 
		query.append("           AND CD.INTG_CD_VAL_CTNT = A.AC_TP_CD) AS ACCT_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_SEQ  " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND CD.INTG_CD_ID = 'CD03021'" ).append("\n"); 
		query.append("           AND CD.INTG_CD_VAL_CTNT = A.AC_TP_CD) AS DP_SEQ            " ).append("\n"); 
		query.append("       , DECODE(A.REV_DIV_CD, '', 'Box','Rate') AS RT_FX_FLG" ).append("\n"); 
		query.append("       , DECODE(A.REV_DIV_CD, 'N', 'Net', 'G', 'Gross', '') AS REV_DIV_CD" ).append("\n"); 
		query.append("       , NULL AS COMM_REV_AMT" ).append("\n"); 
		query.append("       , TO_CHAR(D.IF_DTRB_AMT /D.BKG_VOL_QTY) AS COMM_RT_AMT" ).append("\n"); 
		query.append("       , D.CNTR_TPSZ_CD AS COMM_TPSZ_CD" ).append("\n"); 
		query.append("       , D.BKG_VOL_QTY AS BKG_VOL_QTY" ).append("\n"); 
		query.append("       , A.CRNT_AMT" ).append("\n"); 
		query.append("       , A.PPD_AMT" ).append("\n"); 
		query.append("       , A.IF_AMT" ).append("\n"); 
		query.append("       , A.PAY_IF_AMT" ).append("\n"); 
		query.append("       , DECODE(A.REV_DIV_CD, '', DECODE(D.AC_SEQ, A.AC_SEQ, '', 'Merchant Haulage'), '') AS RMK " ).append("\n"); 
		query.append("  FROM  ACM_AGN_COMM_HIS A" ).append("\n"); 
		query.append("        ,  " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT BKG_NO" ).append("\n"); 
		query.append("           , AGN_CD" ).append("\n"); 
		query.append("           , IO_BND_CD" ).append("\n"); 
		query.append("           , AC_TP_CD" ).append("\n"); 
		query.append("           , AC_SEQ" ).append("\n"); 
		query.append("           , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , BKG_VOL_QTY" ).append("\n"); 
		query.append("           , CALC_NO" ).append("\n"); 
		query.append("           , (SELECT SUM(IF_DTRB_AMT) " ).append("\n"); 
		query.append("                FROM ACM_AGN_COMM_DTL_HIS DL " ).append("\n"); 
		query.append("               WHERE DL.BKG_NO = DTL.BKG_NO " ).append("\n"); 
		query.append("                 AND DL.AGN_CD = DTL.AGN_CD" ).append("\n"); 
		query.append("                 AND DL.IO_BND_CD = DTL.IO_BND_CD " ).append("\n"); 
		query.append("                 AND DL.AC_TP_CD = DTL.AC_TP_CD" ).append("\n"); 
		query.append("                 AND DL.CALC_NO = DTL.CALC_NO" ).append("\n"); 
		query.append("                 AND DL.CNTR_TPSZ_CD = DTL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                 AND DL.BKG_VOL_QTY = DTL.BKG_VOL_QTY" ).append("\n"); 
		query.append("                 ) AS IF_DTRB_AMT" ).append("\n"); 
		query.append("        FROM ACM_AGN_COMM_DTL_HIS DTL" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("         AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("         AND CALC_NO = @[calc_no]" ).append("\n"); 
		query.append("      )D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("   AND A.CALC_NO = @[calc_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND A.AGN_CD = D.AGN_CD" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("   AND A.CALC_NO = D.CALC_NO" ).append("\n"); 
		query.append("   AND D.AC_SEQ IN (A.AC_SEQ, A.AC_SEQ + 1000)" ).append("\n"); 
		query.append("   AND A.AC_TP_CD = D.AC_TP_CD " ).append("\n"); 
		query.append("   AND A.REV_DIV_CD IS NULL" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}