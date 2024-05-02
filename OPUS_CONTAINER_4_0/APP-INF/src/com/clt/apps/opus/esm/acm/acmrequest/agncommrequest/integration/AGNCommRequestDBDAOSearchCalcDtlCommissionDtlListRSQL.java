/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOSearchCalcDtlCommissionDtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOSearchCalcDtlCommissionDtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Commission Detail 목록을 조회한다.
	  * </pre>
	  */
	public AGNCommRequestDBDAOSearchCalcDtlCommissionDtlListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOSearchCalcDtlCommissionDtlListRSQL").append("\n"); 
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
		query.append("  FROM  ACM_AGN_COMM A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_SEQ = @[ac_seq]" ).append("\n"); 
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
		query.append("       , TO_CHAR(ROUND(D.IF_DTRB_AMT /D.BKG_VOL_QTY,2)) AS COMM_RT_AMT" ).append("\n"); 
		query.append("       , D.CNTR_TPSZ_CD AS COMM_TPSZ_CD" ).append("\n"); 
		query.append("       , D.BKG_VOL_QTY AS BKG_VOL_QTY" ).append("\n"); 
		query.append("       , A.CRNT_AMT" ).append("\n"); 
		query.append("       , A.PPD_AMT" ).append("\n"); 
		query.append("       , A.IF_AMT" ).append("\n"); 
		query.append("       , A.PAY_IF_AMT" ).append("\n"); 
		query.append("       , DECODE(A.REV_DIV_CD, '', DECODE(D.AC_SEQ, A.AC_SEQ, '', 'Merchant Haulage'), '') AS RMK " ).append("\n"); 
		query.append("  FROM  ACM_AGN_COMM A" ).append("\n"); 
		query.append("        ,  " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT DTL.BKG_NO" ).append("\n"); 
		query.append("           , DTL.AGN_CD" ).append("\n"); 
		query.append("           , DTL.IO_BND_CD" ).append("\n"); 
		query.append("           , DTL.AC_TP_CD" ).append("\n"); 
		query.append("           , DTL.AC_SEQ" ).append("\n"); 
		query.append("           , DTL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("           , DTL.BKG_VOL_QTY" ).append("\n"); 
		query.append("           , AMT.IF_DTRB_AMT" ).append("\n"); 
		query.append("        FROM ACM_AGN_COMM_DTL DTL" ).append("\n"); 
		query.append("            ,(SELECT DL.BKG_NO " ).append("\n"); 
		query.append("                   , DL.AGN_CD" ).append("\n"); 
		query.append("                   , DL.IO_BND_CD" ).append("\n"); 
		query.append("                   , DL.AC_TP_CD" ).append("\n"); 
		query.append("                   , DL.AC_SEQ" ).append("\n"); 
		query.append("                   , DL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                   , DL.BKG_VOL_QTY" ).append("\n"); 
		query.append("                   , SUM(IF_DTRB_AMT) AS IF_DTRB_AMT" ).append("\n"); 
		query.append("                FROM ACM_AGN_COMM_DTL DL " ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("                 AND DL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                 AND DL.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("                 AND DL.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                 AND DL.AC_SEQ IN (@[ac_seq], 1000+@[ac_seq])              " ).append("\n"); 
		query.append("               GROUP BY DL.BKG_NO, DL.AGN_CD, DL.IO_BND_CD, DL.AC_TP_CD, DL.AC_SEQ, DL.CNTR_TPSZ_CD, DL.BKG_VOL_QTY   " ).append("\n"); 
		query.append("              ) AMT                " ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND DTL.BKG_NO = AMT.BKG_NO" ).append("\n"); 
		query.append("         AND DTL.AGN_CD = AMT.AGN_CD" ).append("\n"); 
		query.append("         AND DTL.IO_BND_CD = AMT.IO_BND_CD" ).append("\n"); 
		query.append("         AND DTL.AC_TP_CD = AMT.AC_TP_CD" ).append("\n"); 
		query.append("         AND DTL.AC_SEQ = AMT.AC_SEQ" ).append("\n"); 
		query.append("         AND DTL.CNTR_TPSZ_CD = AMT.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         AND DTL.BKG_VOL_QTY = AMT.BKG_VOL_QTY" ).append("\n"); 
		query.append("      )D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_SEQ = @[ac_seq]" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND A.AGN_CD = D.AGN_CD" ).append("\n"); 
		query.append("   AND A.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("   AND D.AC_SEQ IN (A.AC_SEQ, A.AC_SEQ + 1000)" ).append("\n"); 
		query.append("   AND A.AC_TP_CD = D.AC_TP_CD " ).append("\n"); 
		query.append("   AND A.REV_DIV_CD IS NULL" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}