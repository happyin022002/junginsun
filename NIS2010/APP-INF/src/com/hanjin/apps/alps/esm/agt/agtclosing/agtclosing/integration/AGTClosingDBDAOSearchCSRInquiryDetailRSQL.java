/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTClosingDBDAOSearchCSRInquiryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.14
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.12.14 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTClosingDBDAOSearchCSRInquiryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AGTClosingDBDAOSearchCSRInquiryDetailRSQL
	  * </pre>
	  */
	public AGTClosingDBDAOSearchCSRInquiryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration").append("\n"); 
		query.append("FileName : AGTClosingDBDAOSearchCSRInquiryDetailRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("MAX (AGN.BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SUM (QTY.OP_CNTR_QTY)" ).append("\n"); 
		query.append("FROM BKG_BL_DOC    DOC," ).append("\n"); 
		query.append("BKG_BOOKING   BKG," ).append("\n"); 
		query.append("BKG_BOOKING   BK2," ).append("\n"); 
		query.append("BKG_QUANTITY  QTY" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG.BKG_NO    = DOC.BKG_NO" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG.BL_NO     = DOC.MST_CVRD_BL_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND BK2.BKG_NO    = DOC.BKG_NO" ).append("\n"); 
		query.append("AND BK2.BKG_NO    = QTY.BKG_NO" ).append("\n"); 
		query.append("AND BK2.BL_NO_TP  = '0'" ).append("\n"); 
		query.append("AND BKG.BKG_NO    = AGN.BKG_NO" ).append("\n"); 
		query.append(") AS QTY," ).append("\n"); 
		query.append("(SELECT TO_CHAR(NVL(BKG_PPD_FRT_AMT,0)" ).append("\n"); 
		query.append("+ NVL(BKG_PPD_OTR_AMT,0)" ).append("\n"); 
		query.append("+ NVL(BKG_CLT_FRT_AMT,0)" ).append("\n"); 
		query.append("+ NVL(BKG_CLT_OTR_AMT,0),'999,999,990.00')" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO" ).append("\n"); 
		query.append("where BKG_NO =	AGN.BKG_NO" ).append("\n"); 
		query.append(") AS G_REV," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512621'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS OUT_BOUND," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512611'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS IN_BOUND," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512631'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS TRANS," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512661'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS CHF," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512641'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS BROG," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512691'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS DOC_OTH," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512692'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS DMDT," ).append("\n"); 
		query.append("SUM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN AGN.COMM_STND_COST_CD = '512693'" ).append("\n"); 
		query.append("THEN AGN.ACT_IF_COMM_AMT" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") AS VSL_OPR" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM      AGN," ).append("\n"); 
		query.append("AGT_COMM_BKG_INFO INF," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("---------- SEARCH To Agent Code -----------------" ).append("\n"); 
		query.append("-- VARCHAR(5) : AAABB" ).append("\n"); 
		query.append("@[agn_cd]" ).append("\n"); 
		query.append("AS AGN_CD," ).append("\n"); 
		query.append("-------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------- SEARCH To CSR No. --------------------" ).append("\n"); 
		query.append("-- VARCHAR(20) : 08SAAAAAYYMMDD1NNNN" ).append("\n"); 
		query.append("@[s_csr_no]" ).append("\n"); 
		query.append("AS CSR_NO," ).append("\n"); 
		query.append("-------------------------------------------------" ).append("\n"); 
		query.append("---------- SEARCH To STND_COST_CD ---------------" ).append("\n"); 
		query.append("-- VARCHAR(6) : 512611 ~ 512693" ).append("\n"); 
		query.append("@[comm_stnd_cost_cd]" ).append("\n"); 
		query.append("AS COMM_STND_COST_CD," ).append("\n"); 
		query.append("-------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("---------- SEARCH To Rev. VVD -------------------" ).append("\n"); 
		query.append("-- VARCHAR(10) : VVVVYYYYSR" ).append("\n"); 
		query.append("@[rev_vvd_cd]" ).append("\n"); 
		query.append("AS REV_VVD_CD" ).append("\n"); 
		query.append("-------------------------------------------------" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") INP" ).append("\n"); 
		query.append("WHERE AGN.BKG_NO = INF.BKG_NO" ).append("\n"); 
		query.append("AND AGN.AGN_CD = INP.AGN_CD" ).append("\n"); 
		query.append("AND AGN.CSR_NO = INP.CSR_NO" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INF.REV_VVD_CD = INP.REV_VVD_CD" ).append("\n"); 
		query.append("AND INP.REV_VVD_CD IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.REV_VVD_CD IS NULL" ).append("\n"); 
		query.append("AND INF.REV_VVD_CD = INF.REV_VVD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AGN.COMM_STND_COST_CD = INP.COMM_STND_COST_CD" ).append("\n"); 
		query.append("AND INP.COMM_STND_COST_CD IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("INP.COMM_STND_COST_CD IS NULL" ).append("\n"); 
		query.append("AND AGN.COMM_STND_COST_CD = AGN.COMM_STND_COST_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY AGN.BKG_NO," ).append("\n"); 
		query.append("AGN.CSR_NO," ).append("\n"); 
		query.append("AGN.COMM_STND_COST_CD," ).append("\n"); 
		query.append("INF.REV_VVD_CD" ).append("\n"); 

	}
}