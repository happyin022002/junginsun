/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAgreementDBDAOFFAgreementRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier :
*@LastVersion : 1.0
* 2012.05.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAgreementDBDAOFFAgreementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * FFAgreement
	  * </pre>
	  */
	public FFCmpnAgreementDBDAOFFAgreementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_brog_cnt_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmagreement.ffcmpnagreement.integration").append("\n");
		query.append("FileName : FFCmpnAgreementDBDAOFFAgreementRSQL").append("\n");
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
		query.append("      A.FF_CNT_CD," ).append("\n");
		query.append("      A.FF_SEQ," ).append("\n");
		query.append("      CONCAT(A.FF_CNT_CD, TO_CHAR(A.FF_SEQ, 'FM000000'))                  AS FF_CNT_SEQ," ).append("\n");
		query.append("      CASE TO_CHAR(A.FF_SEQ, 'FM000000')" ).append("\n");
		query.append("      WHEN '999999'" ).append("\n");
		query.append("      THEN 'All customer for General Rate Case'" ).append("\n");
		query.append("      WHEN '888888'" ).append("\n");
		query.append("      THEN 'All customer for Special Rate Case'" ).append("\n");
		query.append("      WHEN '777777'" ).append("\n");
		query.append("      THEN 'All customer for Canadian Special Rate Case'" ).append("\n");
		query.append("      ELSE NVL(REPLACE(REPLACE(B.CUST_LGL_ENG_NM,CHR(13)||CHR(10),' '),CHR(9),' '),' ')" ).append("\n");
		query.append("       END                                                                              AS FF_CNT_CUST_NM," ).append("\n");
		query.append("      CASE CONCAT(A.SHPR_CNT_CD, TO_CHAR(A.SHPR_SEQ, 'FM000000'))" ).append("\n");
		query.append("      WHEN '*000000'" ).append("\n");
		query.append("      THEN '*'" ).append("\n");
		query.append("      ELSE NVL(CONCAT(A.SHPR_CNT_CD, TO_CHAR(A.SHPR_SEQ, 'FM000000')), '*')" ).append("\n");
		query.append("       END                                                                              AS SHPR_CNT_SEQ," ).append("\n");
		query.append("           NVL(REPLACE(REPLACE(C.CUST_LGL_ENG_NM,CHR(13)||CHR(10),' '),CHR(9),' '),' ') AS SHPR_CNT_NM," ).append("\n");
		query.append("           NVL(A.POR_GRP_TP_CD, '*')                                                    AS POR_GRP_TP_CD," ).append("\n");
		query.append("           NVL(A.POR_ROUT_CD,   '*')                                                    AS POR_ROUT_CD," ).append("\n");
		query.append("           NVL(A.POL_GRP_TP_CD, '*')                                                    AS POL_GRP_TP_CD," ).append("\n");
		query.append("           NVL(A.POL_ROUT_CD,   '*')                                                    AS POL_ROUT_CD," ).append("\n");
		query.append("           NVL(A.POD_GRP_TP_CD, '*')                                                    AS POD_GRP_TP_CD," ).append("\n");
		query.append("           NVL(A.POD_ROUT_CD,   '*')                                                    AS POD_ROUT_CD," ).append("\n");
		query.append("           NVL(A.FM_EFF_DT, '20000101')                                                 AS FM_EFF_DT," ).append("\n");
		query.append("           NVL(A.TO_EFF_DT, '29991231')                                                 AS TO_EFF_DT," ).append("\n");
		query.append("           NVL(A.SC_NO,         '*')                                                    AS SC_NO," ).append("\n");
		query.append("           NVL(A.RFA_NO,        '*')                                                    AS RFA_NO," ).append("\n");
		query.append("           NVL(A.CMDT_TP_CD,    '*')                                                    AS CMDT_TP_CD," ).append("\n");
		query.append("           NVL(A.CMDT_CD,       '*')                                                    AS CMDT_CD," ).append("\n");
		query.append("      CASE A.CMDT_TP_CD" ).append("\n");
		query.append("      WHEN '2'" ).append("\n");
		query.append("      THEN E.REP_CMDT_NM" ).append("\n");
		query.append("      WHEN '3'" ).append("\n");
		query.append("      THEN F.CMDT_NM" ).append("\n");
		query.append("       END                                                                              AS CMDT_NM," ).append("\n");
		query.append("           NVL(A.FF_DIV_CD,   ' ')                                                      AS FF_DIV_CD," ).append("\n");
		query.append("           NVL(A.FF_BKG_RT,     0)                                                      AS FF_BKG_RT," ).append("\n");
		query.append("           NVL(A.FF_BX_AMT,      0)                                                     AS FF_BX_AMT," ).append("\n");
		query.append("           NVL(A.FF_TEU_AMT,     0)                                                     AS FF_TEU_AMT," ).append("\n");
		query.append("           NVL(A.FF_FEU_AMT,     0)                                                     AS FF_FEU_AMT," ).append("\n");
		query.append("           NVL(A.FF_RF_AMT,      0)                                                     AS FF_RF_AMT," ).append("\n");
		query.append("           NVL(A.FF_CHG_CTNT, ' ')                                                      AS FF_CHG_CTNT," ).append("\n");
		query.append("           A.FF_AGMT_SEQ" ).append("\n");
		query.append("      FROM ACM_FF_AGMT A," ).append("\n");
		query.append("           MDM_CUSTOMER     B," ).append("\n");
		query.append("           MDM_CUSTOMER     C," ).append("\n");
		query.append("           MDM_REP_CMDT     E," ).append("\n");
		query.append("           MDM_COMMODITY    F" ).append("\n");
		query.append("     WHERE A.FF_CNT_CD    = B.CUST_CNT_CD(+)" ).append("\n");
		query.append("       AND A.FF_SEQ  = B.CUST_SEQ(+)" ).append("\n");
		query.append("       AND A.SHPR_CNT_CD    = C.CUST_CNT_CD(+)" ).append("\n");
		query.append("       AND A.SHPR_SEQ       = C.CUST_SEQ(+)" ).append("\n");
		query.append("       AND A.CMDT_CD        = E.REP_CMDT_CD(+)" ).append("\n");
		query.append("       AND A.CMDT_CD        = F.CMDT_CD(+)" ).append("\n");
		query.append("       AND NVL(A.DELT_FLG,'N') <> 'Y' " ).append("\n");
		query.append("#if(${search_brog_cnt_cust_seq} != '')" ).append("\n");
		query.append("       AND CONCAT(A.FF_CNT_CD, TO_CHAR(A.FF_SEQ, 'FM000000')) LIKE @[search_brog_cnt_cust_seq]||'%'" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("  ORDER BY FF_CNT_SEQ, FF_CNT_CUST_NM, SHPR_CNT_NM, POR_GRP_TP_CD, POR_ROUT_CD, POL_GRP_TP_CD, POL_ROUT_CD, POD_GRP_TP_CD" ).append("\n");
		query.append("  , POD_ROUT_CD, FM_EFF_DT, TO_EFF_DT, SC_NO, CMDT_TP_CD" ).append("\n");

	}
}