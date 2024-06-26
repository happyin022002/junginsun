/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AGNCommAgreementDBDAOSearchAgentRateDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommAgreementDBDAOSearchAgentRateDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommAgreementDBDAOSearchAgentRateDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration").append("\n"); 
		query.append("FileName : AGNCommAgreementDBDAOSearchAgentRateDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.AGN_CD," ).append("\n"); 
		query.append("       A.AGN_AGMT_NO," ).append("\n"); 
		query.append("       A.IO_BND_CD," ).append("\n"); 
		query.append("       A.AC_TP_CD, " ).append("\n"); 
		query.append("       A.AGN_AGMT_SEQ," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_CNTR" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_CNTR_SEQ))) AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DECODE(A.COMM_FX_AMT,'','',NVL(A.OFT_PAY_TERM_CD, 'T')) AS OFT_PAY_TERM_CD," ).append("\n"); 
		query.append("       DECODE(A.COMM_FX_AMT,'','',A.FULL_MTY_CD) AS FULL_MTY_CD," ).append("\n"); 
		query.append("       DECODE(A.COMM_FX_AMT,'','',A.CURR_CD) AS CURR_CD," ).append("\n"); 
		query.append("       A.COMM_FX_AMT," ).append("\n"); 
		query.append("       DECODE(A.COMM_RT,'','',NVL(A.COMM_PAY_TERM_CD, 'T')) AS COMM_PAY_TERM_CD," ).append("\n"); 
		query.append("       DECODE(A.COMM_RT,'','',A.REV_DIV_CD) AS REV_DIV_CD," ).append("\n"); 
		query.append("       A.COMM_RT," ).append("\n"); 
		query.append("       A.OFC_SET_TP_CD," ).append("\n"); 
		query.append("       A.OFC_CVRG_CD," ).append("\n"); 
		query.append("       A.OFC_CD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PORV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '1'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POR_1," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PORV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '2'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POR_2," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PORV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '3'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POR_3," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PORV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '4'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POR_4," ).append("\n"); 
		query.append("       (SELECT ROUT_LVL_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("         WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("           AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("           AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("           AND ROUT_REF_DIV_CD = 'POR'" ).append("\n"); 
		query.append("           AND ROWNUM < 600" ).append("\n"); 
		query.append("         GROUP BY ROUT_LVL_CD) AS POR_LVL_CD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POR'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POR," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POLV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '1'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POL_1," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POLV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '2'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POL_2," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POLV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '3'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POL_3," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POLV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '4'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POL_4," ).append("\n"); 
		query.append("       (SELECT ROUT_LVL_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("         WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("           AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("           AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("           AND ROUT_REF_DIV_CD = 'POL'" ).append("\n"); 
		query.append("           AND ROWNUM < 600" ).append("\n"); 
		query.append("         GROUP BY ROUT_LVL_CD) AS POL_LVL_CD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POL'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POL," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PODV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '1'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POD_1," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PODV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '2'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POD_2," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PODV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '3'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POD_3," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'PODV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '4'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POD_4," ).append("\n"); 
		query.append("       (SELECT ROUT_LVL_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("         WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("           AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("           AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("           AND ROUT_REF_DIV_CD = 'POD'" ).append("\n"); 
		query.append("           AND ROWNUM < 600" ).append("\n"); 
		query.append("         GROUP BY ROUT_LVL_CD) AS POD_LVL_CD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'POD'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS POD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'DELV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '1'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS DEL_1," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'DELV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '2'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS DEL_2," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'DELV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '3'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS DEL_3," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'DELV'" ).append("\n"); 
		query.append("                               AND ROUT_LVL_CD = '4'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS DEL_4," ).append("\n"); 
		query.append("       (SELECT ROUT_LVL_CD" ).append("\n"); 
		query.append("          FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("         WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("           AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("           AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("           AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("           AND ROUT_REF_DIV_CD = 'DEL'" ).append("\n"); 
		query.append("           AND ROWNUM < 600" ).append("\n"); 
		query.append("         GROUP BY ROUT_LVL_CD) AS DEL_LVL_CD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT ROUT_INFO_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_ROUT" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROUT_REF_DIV_CD = 'DEL'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                             ORDER BY AGN_AGMT_ROUT_SEQ))) AS DEL," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_CHG" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND ROWNUM < 600" ).append("\n"); 
		query.append("                               AND CHG_DIV_CD = 'R'))) AS REP_CHG_CD," ).append("\n"); 
		query.append("       (ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n"); 
		query.append("                              FROM ACM_AGN_AGMT_DTL_CHG" ).append("\n"); 
		query.append("                             WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                               AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                               AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                               AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                               AND CHG_DIV_CD = 'C'" ).append("\n"); 
		query.append("                               AND ROWNUM < 600))) AS CHG_CD," ).append("\n"); 
		query.append("       HLG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("       HLG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("       FDRG_DDCT_ORG_FLG," ).append("\n"); 
		query.append("       FDRG_DDCT_DEST_FLG," ).append("\n"); 
		query.append("       (CASE WHEN A.REV_DIV_CD IS NOT NULL" ).append("\n"); 
		query.append("                THEN 'R'" ).append("\n"); 
		query.append("             WHEN A.FULL_MTY_CD IS NOT NULL" ).append("\n"); 
		query.append("                THEN 'F'" ).append("\n"); 
		query.append("             ELSE 'F'" ).append("\n"); 
		query.append("        END) AS RATE_DIV," ).append("\n"); 
		query.append("       A.AGN_CD||A.AGN_AGMT_NO||A.IO_BND_CD||A.AC_TP_CD||A.AGN_AGMT_SEQ AS AGMT_DTL_PK," ).append("\n"); 
		query.append("	   --2017.08.18 Charge Commission 추가" ).append("\n"); 
		query.append("	   (ACM_JOIN_FNC(CURSOR(SELECT CHG_CD" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_CHG_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_CHG_SEQ))) AS COMM_CHG_CD," ).append("\n"); 
		query.append("	   CHG_COMM_DIV_CD," ).append("\n"); 
		query.append("	   CHG_COMM_RT," ).append("\n"); 
		query.append("	   CHG_COMM_OTR_AMT," ).append("\n"); 
		query.append("	   CHG_COMM_CURR_CD," ).append("\n"); 
		query.append("	   CHG_COMM_PAY_TERM_CD," ).append("\n"); 
		query.append("	   (CASE WHEN CHG_COMM_RT IS NOT NULL THEN 'R'" ).append("\n"); 
		query.append("			 WHEN CHG_COMM_OTR_AMT IS NOT NULL THEN 'O'" ).append("\n"); 
		query.append("             ELSE 'R'" ).append("\n"); 
		query.append("        END) AS CHG_COMM_RATE_DIV," ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT MIN_COMM_DIV_CD" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS MIN_COMM_DIV_CD," ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT MIN_COMM_RT" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS MIN_COMM_RT," ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT MIN_COMM_CURR_CD" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS MIN_COMM_CURR_CD,                             " ).append("\n"); 
		query.append("         (ACM_JOIN_FNC(CURSOR(SELECT MIN_COMM_PER_CD" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS MIN_COMM_PER_CD,    " ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT MIN_COMM_NET_REV_AMT" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS MIN_COMM_NET_REV_AMT, " ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT MIN_COMM_NET_REV_CURR_CD" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS MIN_COMM_NET_REV_CURR_CD, " ).append("\n"); 
		query.append("        (ACM_JOIN_FNC(CURSOR(SELECT AGN_AGMT_MIN_COMM_SEQ" ).append("\n"); 
		query.append("                      		  FROM ACM_AGN_AGMT_MIN_COMM" ).append("\n"); 
		query.append("                     		 WHERE AGN_CD = A.AGN_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_NO = A.AGN_AGMT_NO" ).append("\n"); 
		query.append("                       		   AND IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("                       		   AND AC_TP_CD = A.AC_TP_CD" ).append("\n"); 
		query.append("                       		   AND AGN_AGMT_SEQ = A.AGN_AGMT_SEQ" ).append("\n"); 
		query.append("                     	  	 ORDER BY AGN_AGMT_MIN_COMM_SEQ))) AS AGN_AGMT_MIN_COMM_SEQ" ).append("\n"); 
		query.append("  FROM ACM_AGN_AGMT_DTL A" ).append("\n"); 
		query.append(" WHERE A.AGN_AGMT_NO = @[agn_agmt_no]" ).append("\n"); 
		query.append(" ORDER BY A.AGN_CD,A.AGN_AGMT_NO,A.IO_BND_CD DESC,A.AGN_AGMT_SEQ" ).append("\n"); 

	}
}