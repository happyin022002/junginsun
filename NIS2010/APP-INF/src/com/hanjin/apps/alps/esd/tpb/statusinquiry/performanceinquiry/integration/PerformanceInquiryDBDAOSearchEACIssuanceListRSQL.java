/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceInquiryDBDAOSearchEACIssuanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2010.01.14 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceInquiryDBDAOSearchEACIssuanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEACIssuanceList
	  * </pre>
	  */
	public PerformanceInquiryDBDAOSearchEACIssuanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_edate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sdate",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.integration").append("\n"); 
		query.append("FileName : PerformanceInquiryDBDAOSearchEACIssuanceListRSQL").append("\n"); 
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
		query.append("SELECT o.rhq if_rhq_cd, o.n3pty_expn_tp_cd expn_tp_cd" ).append("\n"); 
		query.append(",NVL(a.cnt,0) cnt_a, NVL(a.amt,0) amt_a" ).append("\n"); 
		query.append(",NVL(b.cnt,0) cnt_b, NVL(b.amt,0) amt_b" ).append("\n"); 
		query.append(",NVL(c.cnt,0) cnt_c, NVL(c.amt,0) amt_c" ).append("\n"); 
		query.append(",NVL(a.cnt,0)+NVL(b.cnt,0)+NVL(c.cnt,0) cnt_tot" ).append("\n"); 
		query.append(",NVL(a.amt,0)+NVL(b.amt,0)+NVL(c.amt,0) amt_tot" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 0 seq, rhq, n3pty_expn_tp_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ofc_cd AS rhq" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE n3pty_ofc_tp_cd='R'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND ofc_cd = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") a," ).append("\n"); 
		query.append("(  SELECT intg_cd_val_dp_seq seq, intg_cd_val_ctnt n3pty_expn_tp_cd" ).append("\n"); 
		query.append("FROM com_intg_cd_dtl" ).append("\n"); 
		query.append("WHERE intg_cd_id='CD00578'" ).append("\n"); 
		query.append(") b" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 999 seq, '(TOTAL)' rhq, '(TOTAL)' n3pty_expn_tp_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append(") o," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- Misbilling" ).append("\n"); 
		query.append("SELECT NVL(m.rhq,'(TOTAL)') rhq, NVL(a.n3pty_expn_tp_cd,'(TOTAL)') n3pty_expn_tp_cd" ).append("\n"); 
		query.append(",COUNT(0) cnt" ).append("\n"); 
		query.append(",SUM(TPB_GET_USD_AMT_FNC(a.ots_amt,a.curr_cd,TPB_GET_LCL_DATE_FNC(DECODE(c.ots_sts_cd,'E',c.ots_sts_cre_dt,SYSDATE),a.ofc_cd))) amt" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP a, TPB_OTS_GRP_STS c," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT rhq_cd AS rhq, ofc_cd ofc" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE n3pty_ofc_tp_cd='T'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND rhq_cd = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") m" ).append("\n"); 
		query.append("WHERE a.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND a.ofc_cd = m.ofc" ).append("\n"); 
		query.append("AND a.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND a.cfm_dt >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd])" ).append("\n"); 
		query.append("AND a.cfm_dt < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]) + 1" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 0 FROM TPB_OTS_DTL s WHERE s.n3pty_no=a.n3pty_no AND s.eac_tp_cd IN ('M') )" ).append("\n"); 
		query.append("GROUP BY ROLLUP(m.rhq, a.n3pty_expn_tp_cd)" ).append("\n"); 
		query.append("HAVING GROUPING(m.rhq) = 1 OR GROUPING(a.n3pty_expn_tp_cd) = 0" ).append("\n"); 
		query.append(") a," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- Missing 3rd Party Billing" ).append("\n"); 
		query.append("SELECT NVL(m.rhq,'(TOTAL)') rhq, NVL(a.n3pty_expn_tp_cd,'(TOTAL)') n3pty_expn_tp_cd" ).append("\n"); 
		query.append(",COUNT(0) cnt" ).append("\n"); 
		query.append(",SUM(TPB_GET_USD_AMT_FNC(a.ots_amt,a.curr_cd,TPB_GET_LCL_DATE_FNC(DECODE(c.ots_sts_cd,'E',c.ots_sts_cre_dt,SYSDATE),a.ofc_cd))) amt" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP a, TPB_OTS_GRP_STS c," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT rhq_cd AS rhq, ofc_cd ofc" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE n3pty_ofc_tp_cd='T'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND rhq_cd = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") m" ).append("\n"); 
		query.append("WHERE a.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND a.ofc_cd = m.ofc" ).append("\n"); 
		query.append("AND a.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND a.cfm_dt >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd])" ).append("\n"); 
		query.append("AND a.cfm_dt < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]) + 1" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 0 FROM TPB_OTS_DTL s WHERE s.n3pty_no=a.n3pty_no AND s.eac_tp_cd IN ('T') )" ).append("\n"); 
		query.append("GROUP BY ROLLUP(m.rhq, a.n3pty_expn_tp_cd)" ).append("\n"); 
		query.append("HAVING GROUPING(m.rhq) = 1 OR GROUPING(a.n3pty_expn_tp_cd) = 0" ).append("\n"); 
		query.append(") b," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- Internal Error" ).append("\n"); 
		query.append("SELECT NVL(m.rhq,'(TOTAL)') rhq, NVL(a.n3pty_expn_tp_cd,'(TOTAL)') n3pty_expn_tp_cd" ).append("\n"); 
		query.append(",COUNT(0) cnt" ).append("\n"); 
		query.append(",SUM(TPB_GET_USD_AMT_FNC(a.ots_amt,a.curr_cd,TPB_GET_LCL_DATE_FNC(DECODE(c.ots_sts_cd,'E',c.ots_sts_cre_dt,SYSDATE),a.ofc_cd))) amt" ).append("\n"); 
		query.append("FROM TPB_OTS_GRP a, TPB_OTS_GRP_STS c," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT rhq_cd AS rhq, ofc_cd ofc" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE n3pty_ofc_tp_cd='T'" ).append("\n"); 
		query.append("#if (${s_if_rhq_cd} != '')" ).append("\n"); 
		query.append("AND rhq_cd = @[s_if_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") m" ).append("\n"); 
		query.append("WHERE a.n3pty_no = c.n3pty_no" ).append("\n"); 
		query.append("AND a.ofc_cd = m.ofc" ).append("\n"); 
		query.append("AND a.n3pty_delt_tp_cd IN ('N')" ).append("\n"); 
		query.append("AND c.ots_sts_lst_flg = 'Y'" ).append("\n"); 
		query.append("AND a.cfm_dt >= TPB_GET_SRCH_DATE_FNC(@[s_sdate],'YYYY-MM-DD',@[user_ofc_cd])" ).append("\n"); 
		query.append("AND a.cfm_dt < TPB_GET_SRCH_DATE_FNC(@[s_edate],'YYYY-MM-DD',@[user_ofc_cd]) + 1" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 0 FROM TPB_OTS_DTL s WHERE s.n3pty_no=a.n3pty_no AND s.eac_tp_cd IN ('I') )" ).append("\n"); 
		query.append("GROUP BY ROLLUP(m.rhq, a.n3pty_expn_tp_cd)" ).append("\n"); 
		query.append("HAVING GROUPING(m.rhq) = 1 OR GROUPING(a.n3pty_expn_tp_cd) = 0" ).append("\n"); 
		query.append(") c" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND o.rhq = a.rhq(+) AND o.n3pty_expn_tp_cd = a.n3pty_expn_tp_cd(+)" ).append("\n"); 
		query.append("AND o.rhq = b.rhq(+) AND o.n3pty_expn_tp_cd = b.n3pty_expn_tp_cd(+)" ).append("\n"); 
		query.append("AND o.rhq = c.rhq(+) AND o.n3pty_expn_tp_cd = c.n3pty_expn_tp_cd(+)" ).append("\n"); 
		query.append("ORDER BY o.seq, o.rhq, o.n3pty_expn_tp_cd" ).append("\n"); 

	}
}