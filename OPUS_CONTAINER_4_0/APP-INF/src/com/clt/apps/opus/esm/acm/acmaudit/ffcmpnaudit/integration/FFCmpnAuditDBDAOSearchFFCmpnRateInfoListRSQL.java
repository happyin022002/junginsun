/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditDBDAOSearchFFCmpnRateInfoListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.17 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOSearchFFCmpnRateInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchFFCmpnRateInfoList
	  * </pre>
	  */
	public FFCmpnAuditDBDAOSearchFFCmpnRateInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration").append("\n");
		query.append("FileName : FFCmpnAuditDBDAOSearchFFCmpnRateInfoListRSQL").append("\n");
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
		query.append("SELECT A.FF_CNT_CD||TO_CHAR(A.FF_SEQ, 'FM000000') AS FF_CNT_SEQ," ).append("\n");
		query.append("       DECODE(TO_CHAR(A.FF_SEQ, 'FM000000')," ).append("\n");
		query.append("              '999999', 'All customer for General Rate Case'," ).append("\n");
		query.append("              '888888', 'All customer for Special Rate Case'," ).append("\n");
		query.append("              '777777', 'All customer for Canadian Special Rate Case'," ).append("\n");
		query.append("              NVL(REPLACE(REPLACE(REPLACE(B.CUST_LGL_ENG_NM, '&', '&amp;'), CHR(13)||CHR(10), ''), CHR(9),''), '')) AS FF_CNT_CUST_NM," ).append("\n");
		query.append("       NVL(DECODE(A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000'), '*000000', '*', A.SHPR_CNT_CD||TO_CHAR(A.SHPR_SEQ, 'FM000000')), '*') AS SHPR_CNT_SEQ," ).append("\n");
		query.append("       NVL(REPLACE(REPLACE(REPLACE(C.CUST_LGL_ENG_NM, '&', '&amp;'), CHR(13)||CHR(10), ''), CHR(9),''), '') AS SHPR_CNT_NM," ).append("\n");
		query.append("       NVL(A.POR_GRP_TP_CD, '*') AS POR_GRP_TP_CD," ).append("\n");
		query.append("       NVL(A.POR_ROUT_CD, '*') AS POR_ROUT_CD," ).append("\n");
		query.append("       NVL(A.POL_GRP_TP_CD, '*') AS POL_GRP_TP_CD," ).append("\n");
		query.append("       NVL(A.POL_ROUT_CD, '*') AS POL_ROUT_CD," ).append("\n");
		query.append("       NVL(A.POD_GRP_TP_CD, '*') AS POD_GRP_TP_CD," ).append("\n");
		query.append("       NVL(A.POD_ROUT_CD, '*') AS POD_ROUT_CD," ).append("\n");
		query.append("       TO_CHAR(TO_DATE(NVL(A.FM_EFF_DT, '2000-01-01'), 'YYYYMMDD'), 'YYYY-MM-DD') AS FM_EFF_DT," ).append("\n");
		query.append("       TO_CHAR(TO_DATE(NVL(A.TO_EFF_DT, '2999-12-31'), 'YYYYMMDD'), 'YYYY-MM-DD') AS TO_EFF_DT," ).append("\n");
		query.append("       NVL(A.SC_NO, '*') AS SC_NO," ).append("\n");
		query.append("       NVL(A.RFA_NO, '*') AS RFA_NO," ).append("\n");
		query.append("       NVL(A.CMDT_TP_CD, '*') AS CMDT_TP_CD," ).append("\n");
		query.append("       NVL(A.CMDT_CD, '*') AS CMDT_CD," ).append("\n");
		query.append("       DECODE (A.CMDT_TP_CD, '2', D.REP_CMDT_NM, '3', E.CMDT_NM) AS CMDT_NM," ).append("\n");
		query.append("       NVL(A.FF_DIV_CD, '') AS FF_DIV_CD," ).append("\n");
		query.append("       NVL(A.FF_BKG_RT, 0) FF_BKG_RT, NVL (A.FF_BX_AMT, 0) AS FF_BX_AMT," ).append("\n");
		query.append("       NVL(A.FF_TEU_AMT, 0) FF_TEU_AMT, NVL (A.FF_FEU_AMT, 0) AS FF_FEU_AMT," ).append("\n");
		query.append("       NVL(A.FF_RF_AMT, 0) AS FF_RF_AMT," ).append("\n");
		query.append("       NVL(A.FF_CHG_CTNT, '') AS FF_CHG_CTNT" ).append("\n");
		query.append("       --NVL (A.BROG_KND_CD, 'F') AS BROG_KND_CD" ).append("\n");
		query.append("  FROM ACM_FF_AGMT A," ).append("\n");
		query.append("       MDM_CUSTOMER B," ).append("\n");
		query.append("       MDM_CUSTOMER C," ).append("\n");
		query.append("       MDM_REP_CMDT D," ).append("\n");
		query.append("       MDM_COMMODITY E" ).append("\n");
		query.append(" WHERE A.FF_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n");
		query.append("   AND A.FF_SEQ = B.CUST_SEQ(+)" ).append("\n");
		query.append("   AND A.SHPR_CNT_CD = C.CUST_CNT_CD(+)" ).append("\n");
		query.append("   AND A.SHPR_SEQ = C.CUST_SEQ(+)" ).append("\n");
		query.append("   AND A.CMDT_CD = D.REP_CMDT_CD(+)" ).append("\n");
		query.append("   AND A.CMDT_CD = E.CMDT_CD(+)" ).append("\n");
		query.append("   AND A.FF_CNT_CD = @[ff_cnt_cd]" ).append("\n");
		query.append("   AND A.FF_SEQ = @[ff_seq]" ).append("\n");
		query.append("   AND A.FF_AGMT_SEQ = @[ff_agmt_seq]" ).append("\n");

	}
}