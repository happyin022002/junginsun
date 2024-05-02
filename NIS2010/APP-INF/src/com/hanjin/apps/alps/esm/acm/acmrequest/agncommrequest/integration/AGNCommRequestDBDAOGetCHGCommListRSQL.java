/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetCHGCommListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetCHGCommListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Get CHG Comm List
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetCHGCommListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sa_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("max_ac_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOGetCHGCommListRSQL").append("\n"); 
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
		query.append("WITH ACM_PARAM AS (" ).append("\n"); 
		query.append("    SELECT AGN_CD" ).append("\n"); 
		query.append("         , AGN_AGMT_NO" ).append("\n"); 
		query.append("         , IO_BND_CD" ).append("\n"); 
		query.append("         , AC_TP_CD" ).append("\n"); 
		query.append("         , OFC_SET_TP_CD" ).append("\n"); 
		query.append("         , OFC_CVRG_CD" ).append("\n"); 
		query.append("         , OFC_CD" ).append("\n"); 
		query.append("         , POR_CD" ).append("\n"); 
		query.append("         , POL_CD" ).append("\n"); 
		query.append("         , POD_CD" ).append("\n"); 
		query.append("         , DEL_CD" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        (SELECT AGN_CD" ).append("\n"); 
		query.append("              , AGN_AGMT_NO" ).append("\n"); 
		query.append("              , IO_BND_CD" ).append("\n"); 
		query.append("              , AC_TP_CD" ).append("\n"); 
		query.append("              , NVL(OFC_SET_TP_CD, 'XXX') OFC_SET_TP_CD" ).append("\n"); 
		query.append("              , NVL(OFC_CVRG_CD, 'XXX') OFC_CVRG_CD" ).append("\n"); 
		query.append("              , NVL(OFC_CD, 'XXX') OFC_CD" ).append("\n"); 
		query.append("         FROM ACM_AGN_AGMT_DTL" ).append("\n"); 
		query.append("         WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("         AND AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("         AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("         AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("         AND AGN_AGMT_SEQ = @[agn_agmt_seq]) A," ).append("\n"); 
		query.append("        (SELECT NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'POR', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS POR_CD" ).append("\n"); 
		query.append("			  , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'POL', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS POL_CD" ).append("\n"); 
		query.append("			  , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'POD', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS POD_CD" ).append("\n"); 
		query.append("			  , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'DEL', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS DEL_CD" ).append("\n"); 
		query.append("         FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("         WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("         AND AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("         AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("         AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("         AND AGN_AGMT_SEQ = @[agn_agmt_seq]) B  " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("     , @[agn_cd] AS AGN_CD" ).append("\n"); 
		query.append("     , @[io_bnd_cd] AS IO_BND_CD" ).append("\n"); 
		query.append("     , @[ac_tp_cd] AS AC_TP_CD" ).append("\n"); 
		query.append("     , @[max_ac_seq] AS MAX_AC_SEQ" ).append("\n"); 
		query.append("     , @[ofc_curr_cd] AS OFC_CURR_CD" ).append("\n"); 
		query.append("     , @[pay_xch_rt] AS PAY_XCH_RT" ).append("\n"); 
		query.append("     , @[sa_dt] AS SA_DT" ).append("\n"); 
		query.append("     , @[usr_id] AS USR_ID" ).append("\n"); 
		query.append("     , A.CHG_COMM_DIV_CD" ).append("\n"); 
		query.append("     , A.CHG_COMM_RT" ).append("\n"); 
		query.append("     , A.CHG_COMM_OTR_AMT" ).append("\n"); 
		query.append("     , A.CHG_COMM_CURR_CD" ).append("\n"); 
		query.append("     , A.CHG_COMM_PAY_TERM_CD" ).append("\n"); 
		query.append("     , C.CHG_CD AS COMM_CHG_CD" ).append("\n"); 
		query.append("	 , NVL(E.USD_LOCL_XCH_RT, 0) AS USD_XCH_RT" ).append("\n"); 
		query.append("FROM ACM_AGN_AGMT_DTL A," ).append("\n"); 
		query.append("     (SELECT AGN_AGMT_SEQ" ).append("\n"); 
		query.append("           , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'POR', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS POR_CD" ).append("\n"); 
		query.append("		   , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'POL', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS POL_CD" ).append("\n"); 
		query.append("		   , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'POD', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS POD_CD" ).append("\n"); 
		query.append("		   , NVL(SUBSTR(XMLAGG(XMLELEMENT(X,'',DECODE(ROUT_REF_DIV_CD, 'DEL', ROUT_INFO_CD, '')) ORDER BY AGN_AGMT_SEQ, AGN_AGMT_ROUT_SEQ).EXTRACT('//text()'), 1), 'XXX') AS DEL_CD" ).append("\n"); 
		query.append("      FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("      WHERE AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("      AND AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append("      AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("      AND AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("      GROUP BY AGN_AGMT_SEQ) B," ).append("\n"); 
		query.append("     ACM_AGN_AGMT_CHG_COMM C," ).append("\n"); 
		query.append("     ACM_PARAM D," ).append("\n"); 
		query.append("     GL_MON_XCH_RT E" ).append("\n"); 
		query.append("WHERE A.AGN_CD = D.AGN_CD" ).append("\n"); 
		query.append("AND A.AGN_AGMT_NO = D.AGN_AGMT_NO" ).append("\n"); 
		query.append("AND A.IO_BND_CD = D.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD = D.AC_TP_CD" ).append("\n"); 
		query.append("AND NVL(A.OFC_SET_TP_CD, 'XXX') = D.OFC_SET_TP_CD" ).append("\n"); 
		query.append("AND NVL(A.OFC_CVRG_CD, 'XXX') = D.OFC_CVRG_CD" ).append("\n"); 
		query.append("AND NVL(A.OFC_CD, 'XXX') = D.OFC_CD" ).append("\n"); 
		query.append("AND A.AGN_AGMT_SEQ = B.AGN_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND NVL(B.POR_CD, 'XXX') = D.POR_CD" ).append("\n"); 
		query.append("AND NVL(B.POL_CD, 'XXX') = D.POL_CD" ).append("\n"); 
		query.append("AND NVL(B.POD_CD, 'XXX') = D.POD_CD" ).append("\n"); 
		query.append("AND NVL(B.DEL_CD, 'XXX') = D.DEL_CD" ).append("\n"); 
		query.append("AND A.AGN_CD = C.AGN_CD" ).append("\n"); 
		query.append("AND A.AGN_AGMT_NO = C.AGN_AGMT_NO" ).append("\n"); 
		query.append("AND A.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("AND A.AC_TP_CD = C.AC_TP_CD" ).append("\n"); 
		query.append("AND A.AGN_AGMT_SEQ = C.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("AND ((A.CHG_COMM_DIV_CD = 'M' AND C.CHG_CD IN (SELECT CHG_CD FROM BKG_CHG_RT WHERE BKG_NO = @[bkg_no] AND FRT_INCL_XCLD_DIV_CD = 'N' AND FRT_TERM_CD = DECODE(A.CHG_COMM_PAY_TERM_CD, 'T', FRT_TERM_CD, '', FRT_TERM_CD, A.CHG_COMM_PAY_TERM_CD)))" ).append("\n"); 
		query.append("  OR (A.CHG_COMM_DIV_CD = 'T' AND C.CHG_CD IN (SELECT CHG_CD FROM BKG_TRF_SCG_RT WHERE BKG_NO = @[bkg_no] AND FRT_INCL_XCLD_DIV_CD = 'N' AND FRT_TERM_CD = DECODE(A.CHG_COMM_PAY_TERM_CD, 'T', FRT_TERM_CD, '', FRT_TERM_CD, A.CHG_COMM_PAY_TERM_CD)))" ).append("\n"); 
		query.append("  OR (A.CHG_COMM_DIV_CD = 'R' AND C.CHG_CD IN (SELECT CHG_CD FROM INV_AR_MN P, INV_AR_CHG Q WHERE P.AR_IF_NO = Q.AR_IF_NO AND P.BKG_NO = @[bkg_no] AND P.REV_TP_CD = 'M' AND P.IO_BND_CD = DECODE(A.CHG_COMM_PAY_TERM_CD, 'T', P.IO_BND_CD, '', P.IO_BND_CD, DECODE(A.CHG_COMM_PAY_TERM_CD, 'P', 'O', 'I')))))" ).append("\n"); 
		query.append("AND A.CHG_COMM_CURR_CD = E.CURR_CD(+)" ).append("\n"); 
		query.append("AND E.ACCT_XCH_RT_YRMON(+) = DECODE(SIGN(TO_NUMBER(TO_CHAR(SYSDATE, 'YYYYMM')) - TO_NUMBER(SUBSTR (@[sa_dt], 1, 6))), 1, SUBSTR (@[sa_dt], 1, 6),TO_CHAR(SYSDATE, 'YYYYMM')) " ).append("\n"); 
		query.append("AND E.ACCT_XCH_RT_LVL(+) = '1'" ).append("\n"); 

	}
}