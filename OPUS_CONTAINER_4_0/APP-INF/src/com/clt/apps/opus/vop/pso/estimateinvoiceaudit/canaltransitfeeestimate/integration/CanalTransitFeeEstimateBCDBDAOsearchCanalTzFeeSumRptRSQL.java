/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeSumRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.28
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2010.05.28 김진주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim JinJoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeSumRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzFeeSumRpt
	  * </pre>
	  */
	public CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeSumRptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("revyrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeEstimateBCDBDAOsearchCanalTzFeeSumRptRSQL").append("\n"); 
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
		query.append("pay_to" ).append("\n"); 
		query.append(",lane" ).append("\n"); 
		query.append(",vvd" ).append("\n"); 
		query.append(",transit_date trns_dt" ).append("\n"); 
		query.append(",DECODE (flg,0, py_due_dt) py_due_dt" ).append("\n"); 
		query.append(",decode(flg, 0, decode(advance_payment_sts, 'Q',1, 'A',10, 'P',12, 0), -1) adv_py_sts" ).append("\n"); 
		query.append(",advance_payment_revmonth adv_py_rev_mon" ).append("\n"); 
		query.append(",invoice_sts" ).append("\n"); 
		query.append(",decode(flg, 0, decode(invoice_sts, 'Q',1, 'Q1',1, 'Q2',2,'Q3',3,'Q4',4,'Q5',5,'Q6',6,'Q7',7,'Q8',8,'Q9',9,'A',10,'P',12, 0), -1) inv_sts" ).append("\n"); 
		query.append(",invoice_revmonth inv_rev_mon" ).append("\n"); 
		query.append(",decode(flg, 1, decode(msa,'Q',1, 'A',10, 0), -1) msa" ).append("\n"); 
		query.append(",result rslt" ).append("\n"); 
		query.append(", ESEQ" ).append("\n"); 
		query.append(", ISEQ" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", CALL_SEQ" ).append("\n"); 
		query.append(",'' revyrmon" ).append("\n"); 
		query.append(",'' port_cd" ).append("\n"); 
		query.append(",vndr_seq vndr_seq" ).append("\n"); 
		query.append(",'' vsl_slan_cd" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  (" ).append("\n"); 
		query.append("SELECT  VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM    MDM_VENDOR" ).append("\n"); 
		query.append("WHERE   PAY_TO      = VNDR_SEQ" ).append("\n"); 
		query.append("AND     DELT_FLG    = 'N'" ).append("\n"); 
		query.append(") PAY_TO," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 1, NULL, LANE) LANE, VVD," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 1, NULL, TRANSIT_DATE) TRANSIT_DATE," ).append("\n"); 
		query.append("(select TO_CHAR(NVL(p.ap_pay_dt,x.due_dt), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("from pso_charge x, ap_pay_inv p" ).append("\n"); 
		query.append("where x.ISS_CTY_CD = T11.ISS_CTY_CD" ).append("\n"); 
		query.append("and x.SO_SEQ = T11.SO_SEQ" ).append("\n"); 
		query.append("and x.inv_no = p.inv_no(+)" ).append("\n"); 
		query.append("and p.delt_flg(+) = 'N'" ).append("\n"); 
		query.append(") py_due_dt," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 1, NULL, ADVANCE_PAYMENT_STS) ADVANCE_PAYMENT_STS," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 1, NULL, ADVANCE_PAYMENT_REVMONTH) ADVANCE_PAYMENT_REVMONTH, DECODE(VVDSUBTTLFLG, 1, NULL, INVOICE_STS) INVOICE_STS," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 1, NULL, INVOICE_REVMONTH) INVOICE_REVMONTH," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 0, NULL, (" ).append("\n"); 
		query.append("SELECT  PSO_MSA_STS_CD" ).append("\n"); 
		query.append("FROM    PSO_MSA" ).append("\n"); 
		query.append("WHERE   REV_YRMON   = replace(@[revyrmon],'-', '')/*'200906'*/" ).append("\n"); 
		query.append("AND     VNDR_SEQ    = PAY_TO" ).append("\n"); 
		query.append(")) MSA," ).append("\n"); 
		query.append("DECODE(VVDSUBTTLFLG, 1, NULL, RESULT) RESULT" ).append("\n"); 
		query.append(", ISS_CTY_CD" ).append("\n"); 
		query.append(", SO_SEQ" ).append("\n"); 
		query.append(", ESEQ" ).append("\n"); 
		query.append(", ISEQ" ).append("\n"); 
		query.append(", PAY_TO VNDR_SEQ" ).append("\n"); 
		query.append(", VVDSUBTTLFLG FLG" ).append("\n"); 
		query.append(", YD_CD" ).append("\n"); 
		query.append(", CALL_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  GROUPING(VSL_CD||SKD_VOY_NO||SKD_DIR_CD) VVDSUBTTLFLG," ).append("\n"); 
		query.append("PAY_TO, MAX(LANE) LANE, VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD,--VSL_CD, SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("MAX(TRANSIT_DATE) TRANSIT_DATE, MAX(ADVANCE_PAYMENT_STS) ADVANCE_PAYMENT_STS," ).append("\n"); 
		query.append("MAX(ADVANCE_PAYMENT_REVMONTH) ADVANCE_PAYMENT_REVMONTH, MAX(INVOICE_STS) INVOICE_STS," ).append("\n"); 
		query.append("MAX(INVOICE_REVMONTH) INVOICE_REVMONTH, MAX(RESULT) RESULT" ).append("\n"); 
		query.append(",MAX(ISS_CTY_CD) ISS_CTY_CD" ).append("\n"); 
		query.append(",MAX(SO_SEQ) SO_SEQ" ).append("\n"); 
		query.append(",MAX(ESEQ) ESEQ" ).append("\n"); 
		query.append(",MAX(ISEQ) ISEQ" ).append("\n"); 
		query.append(",MAX(YD_CD) YD_CD" ).append("\n"); 
		query.append(",MAX(CALL_SEQ) CALL_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("FROM    MDM_VSL_SVC_LANE T1" ).append("\n"); 
		query.append("WHERE   T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append(") PAY_TO," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM    MDM_VSL_SVC_LANE T1" ).append("\n"); 
		query.append("WHERE   VSL_SLAN_CD  = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append(") LANE" ).append("\n"); 
		query.append(",T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD,YD_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     VPS_PORT_CD  = SUBSTR(T3.YD_CD, 1, 5)" ).append("\n"); 
		query.append("--AND     YD_CD        = T3.YD_CD /* AFTER MOIDFY */" ).append("\n"); 
		query.append(") AS TRANSIT_DATE" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("NVL((	SELECT" ).append("\n"); 
		query.append("DECODE(INV_STS_CD,'D','P',CNL_TZ_PROC_STS_CD)" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE A, PSO_CHARGE B, AP_PAY_INV D" ).append("\n"); 
		query.append("WHERE A.ISS_CTY_CD   = B.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("AND   A.SO_SEQ       = B.SO_SEQ(+)" ).append("\n"); 
		query.append("AND   B.INV_RGST_NO  = D.INV_RGST_NO(+)" ).append("\n"); 
		query.append("AND   A.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   A.YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND   A.CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append("), 'X')" ).append("\n"); 
		query.append(") AS ADVANCE_PAYMENT_STS" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("NVL((SELECT  REV_YRMON" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'E'          = CNL_TZ_BZTP_CD), '')" ).append("\n"); 
		query.append(") AS ADVANCE_PAYMENT_REVMONTH" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DECODE(D.INV_STS_CD,'D','P', CNL_TZ_PROC_STS_CD ||" ).append("\n"); 
		query.append("decode(CNL_TZ_PROC_STS_CD, 'Q',(" ).append("\n"); 
		query.append("SELECT  NVL(SUM(DECODE(CNL_TZ_BZTP_CD||CNL_TZ_PROC_STS_CD, 'IQ', 1, 0)), 0)" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE A" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'I'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append("))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE A, PSO_CHARGE B, AP_PAY_INV D" ).append("\n"); 
		query.append("WHERE   A.ISS_CTY_CD   = B.ISS_CTY_CD(+)" ).append("\n"); 
		query.append("AND   A.SO_SEQ       = B.SO_SEQ(+)" ).append("\n"); 
		query.append("AND   B.INV_RGST_NO  = D.INV_RGST_NO(+)" ).append("\n"); 
		query.append("AND   A.VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND   A.YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'I'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append("AND     NTC_YRMON    = replace(@[revyrmon],'-', '')/*'200906'*/)" ).append("\n"); 
		query.append(", '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AS INVOICE_STS" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("NVL((SELECT  REV_YRMON" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     'I'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append("AND     NTC_YRMON    = replace(@[revyrmon],'-', '')/*'200906'*/), '')" ).append("\n"); 
		query.append(") AS INVOICE_REVMONTH" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("NVL((SELECT  MAX(DIFF_RMK)" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("--                AND     ('E', 'I'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append("AND     NTC_YRMON    = replace(@[revyrmon],'-', '')/*'200906'*/), '')" ).append("\n"); 
		query.append(") AS RESULT" ).append("\n"); 
		query.append(",(SELECT ISS_CTY_CD FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'E'          = CNL_TZ_BZTP_CD) ISS_CTY_CD" ).append("\n"); 
		query.append(",(SELECT SO_SEQ FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'E'          = CNL_TZ_BZTP_CD) SO_SEQ" ).append("\n"); 
		query.append(",(SELECT MAX(CALL_SEQ) FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'E'          = CNL_TZ_BZTP_CD) ESEQ" ).append("\n"); 
		query.append(",(SELECT MAX(CALL_SEQ) FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   VSL_CD       = T3.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     YD_CD        = T3.YD_CD" ).append("\n"); 
		query.append("AND     'I'          = CNL_TZ_BZTP_CD) ISEQ" ).append("\n"); 
		query.append(",NVL (" ).append("\n"); 
		query.append("(SELECT   MAX(x.CALL_SEQ)" ).append("\n"); 
		query.append("FROM   PSO_CNL_TZ_FEE x" ).append("\n"); 
		query.append("WHERE   x.PSO_BZTP_CD =" ).append("\n"); 
		query.append("T1.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = x.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO =" ).append("\n"); 
		query.append("x.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD =" ).append("\n"); 
		query.append("x.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = x.VSL_CD" ).append("\n"); 
		query.append("AND x.YD_CD = T3.YD_CD)," ).append("\n"); 
		query.append("1" ).append("\n"); 
		query.append(")     /*TODO : FOR TEST GARA DATA*/" ).append("\n"); 
		query.append("CALL_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  PSO_BZTP_CD, VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  5 PSO_BZTP_CD, VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("FROM    PSO_TGT_VVD" ).append("\n"); 
		query.append("WHERE   PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("AND     EXPN_YRMON = replace(@[revyrmon],'-', '')--'200906'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5 PSO_BZTP_CD, VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append("FROM    PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE   PSO_BZTP_CD = '5'" ).append("\n"); 
		query.append("AND     NTC_YRMON = replace(@[revyrmon],'-', '')--'200906'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PSO_BZTP_CD, VSL_CD,SKD_VOY_NO,SKD_DIR_CD" ).append("\n"); 
		query.append(") T1, VSK_VSL_SKD T2, PSO_TGT_YD_SKD T3" ).append("\n"); 
		query.append("WHERE   T1.VSL_CD       = T2.VSL_CD     (+)" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND     T1.VSL_CD       = T3.VSL_CD     (+)" ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO   = T3.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD   = T3.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND     T1.PSO_BZTP_CD  = T3.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY PAY_TO, ROLLUP (VSL_CD||SKD_VOY_NO||SKD_DIR_CD)" ).append("\n"); 
		query.append(") T11" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where 1 = 1" ).append("\n"); 
		query.append("#if( ${revyrmon}!='')" ).append("\n"); 
		query.append("AND replace(@[revyrmon],'-', '') = replace(@[revyrmon],'-', '')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${port_cd}!='' && ${port_cd}!='All' )" ).append("\n"); 
		query.append("AND YD_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vndr_seq}!='')" ).append("\n"); 
		query.append("AND vndr_seq in (SELECT   REGEXP_SUBSTR (inlist," ).append("\n"); 
		query.append("'[^|]+'," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("b.rn)" ).append("\n"); 
		query.append("FROM   (SELECT    @[vndr_seq] inlist FROM DUAL) a," ).append("\n"); 
		query.append("(SELECT   ROWNUM rn" ).append("\n"); 
		query.append("FROM   dict" ).append("\n"); 
		query.append("WHERE   ROWNUM <= 571) b" ).append("\n"); 
		query.append("WHERE   b.rn <=" ).append("\n"); 
		query.append("LENGTH ( @[vndr_seq] )" ).append("\n"); 
		query.append("- LENGTH (REPLACE ( @[vndr_seq], '|', ''))" ).append("\n"); 
		query.append("+ 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${vsl_slan_cd}!='')" ).append("\n"); 
		query.append("AND LANE = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by pay_to, transit_date, lane, vvd" ).append("\n"); 

	}
}