/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeSumRptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.12 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Ihl
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeSumRptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzFeeSumRpt
	  * </pre>
	  */
	public CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeSumRptRSQL(){
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
		query.append("select pay_to,lane,vvd,trns_dt,py_due_dt,adv_py_sts,adv_py_rev_mon,inv_sts,inv_rev_mon,msa,rslt" ).append("\n"); 
		query.append(",'' revyrmon" ).append("\n"); 
		query.append(",'' port_cd" ).append("\n"); 
		query.append(", vndr_seq" ).append("\n"); 
		query.append(",'' vsl_slan_cd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT   GRP," ).append("\n"); 
		query.append("(select nvl(x.vndr_abbr_nm, x.vndr_seq) from mdm_vendor x where x.vndr_seq = z.VNDR_SEQ) pay_to," ).append("\n"); 
		query.append("lane," ).append("\n"); 
		query.append("vvd," ).append("\n"); 
		query.append("TRANSITDATE trns_dt," ).append("\n"); 
		query.append("(select x.due_dt from pso_charge x where x.ISS_CTY_CD = z.ISS_CTY_CD and x.SO_SEQ = x.SO_SEQ) py_due_dt," ).append("\n"); 
		query.append("decode( msa, null,decode(ADVANCEPAYMENTSTATUS, 'C', 1, 'R', 5, null, decode(vvd, null, null, 5)), null) adv_py_sts," ).append("\n"); 
		query.append("ADVANCEPAYMENTREVMONTH adv_py_rev_mon," ).append("\n"); 
		query.append("decode( msa, null,decode(INVOICESTATUS, 'C', 1, 'R', 5, null, decode(vvd, null, null, 5)), null) inv_sts," ).append("\n"); 
		query.append("INVOICEREVMONTH inv_rev_mon," ).append("\n"); 
		query.append("decode(MSA, 'C', 1, 'R', 5, null, decode( msa, null, decode(vvd, null, 5, null))) msa," ).append("\n"); 
		query.append("DIFF_RMK rslt," ).append("\n"); 
		query.append("CNT" ).append("\n"); 
		query.append(",'' revyrmon" ).append("\n"); 
		query.append(",'' port_cd" ).append("\n"); 
		query.append(",vndr_seq vndr_seq" ).append("\n"); 
		query.append(",'' vsl_slan_cd" ).append("\n"); 
		query.append("FROM   (  SELECT   GROUPING (vndr_seq) grp," ).append("\n"); 
		query.append("vndr_seq," ).append("\n"); 
		query.append("vvd," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (PSO_BZTP_CD)) PSO_BZTP_CD," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (lane)) lane," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (TRANSITDATE)) TRANSITDATE," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (ADVANCEPAYMENTSTATUS))" ).append("\n"); 
		query.append("ADVANCEPAYMENTSTATUS," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (ADVANCEPAYMENTREVMONTH))" ).append("\n"); 
		query.append("ADVANCEPAYMENTREVMONTH," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (INVOICESTATUS))" ).append("\n"); 
		query.append("INVOICESTATUS," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (INVOICEREVMONTH))" ).append("\n"); 
		query.append("INVOICEREVMONTH," ).append("\n"); 
		query.append("DECODE (" ).append("\n"); 
		query.append("GROUPING (vvd)," ).append("\n"); 
		query.append("1," ).append("\n"); 
		query.append("(SELECT   x.PSO_MSA_STS_CD" ).append("\n"); 
		query.append("FROM   pso_msa x" ).append("\n"); 
		query.append("WHERE   x.REV_YRMON = @[revyrmon]" ).append("\n"); 
		query.append("AND x.vndr_seq = y.vndr_seq)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("msa," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (DIFF_RMK)) DIFF_RMK," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (ISS_CTY_CD)) ISS_CTY_CD," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (SO_SEQ)) SO_SEQ," ).append("\n"); 
		query.append("DECODE (GROUPING (vvd), 0, MAX (CNT)) CNT" ).append("\n"); 
		query.append("FROM   (SELECT   1 flg," ).append("\n"); 
		query.append("a.PSO_BZTP_CD," ).append("\n"); 
		query.append("NVL (" ).append("\n"); 
		query.append("b.vndr_seq," ).append("\n"); 
		query.append("(SELECT   CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("FROM   mdm_vsl_svc_lane" ).append("\n"); 
		query.append("WHERE   VSL_SLAN_CD =" ).append("\n"); 
		query.append("(SELECT   VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM   vsk_vsl_skd z" ).append("\n"); 
		query.append("WHERE   z.VSL_CD = a.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO =" ).append("\n"); 
		query.append("a.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD =" ).append("\n"); 
		query.append("a.SKD_DIR_CD))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("(SELECT   z.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM   vsk_vsl_skd z" ).append("\n"); 
		query.append("WHERE       z.VSL_CD = a.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO = a.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD = a.SKD_DIR_CD)" ).append("\n"); 
		query.append("lane," ).append("\n"); 
		query.append("a.VSL_CD || a.SKD_VOY_NO || a.SKD_DIR_CD vvd," ).append("\n"); 
		query.append("(SELECT   VPS_ETB_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD z" ).append("\n"); 
		query.append("WHERE       z.VSL_CD = a.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO = a.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD = a.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD = b.YD_CD" ).append("\n"); 
		query.append("AND CALL_YD_IND_SEQ = '1')" ).append("\n"); 
		query.append("transitDate," ).append("\n"); 
		query.append("DECODE (b.CNL_TZ_BZTP_CD," ).append("\n"); 
		query.append("'E', b.CNL_TZ_PROC_STS_CD," ).append("\n"); 
		query.append("'')" ).append("\n"); 
		query.append("advancePaymentStatus," ).append("\n"); 
		query.append("DECODE (b.CNL_TZ_BZTP_CD, 'E', b.REV_YRMON, '')" ).append("\n"); 
		query.append("advancePaymentRevMonth," ).append("\n"); 
		query.append("DECODE (b.CNL_TZ_BZTP_CD," ).append("\n"); 
		query.append("'I', b.CNL_TZ_PROC_STS_CD," ).append("\n"); 
		query.append("'')" ).append("\n"); 
		query.append("InvoiceStatus," ).append("\n"); 
		query.append("DECODE (b.CNL_TZ_BZTP_CD, 'I', b.REV_YRMON, '')" ).append("\n"); 
		query.append("InvoiceRevMonth," ).append("\n"); 
		query.append("'' MSA," ).append("\n"); 
		query.append("b.DIFF_RMK," ).append("\n"); 
		query.append("b.ISS_CTY_CD," ).append("\n"); 
		query.append("b.SO_SEQ," ).append("\n"); 
		query.append("-1 cnt" ).append("\n"); 
		query.append("FROM   pso_tgt_vvd a, pso_cnl_tz_fee b" ).append("\n"); 
		query.append("WHERE       a.EXPN_YRMON = @[revyrmon]" ).append("\n"); 
		query.append("AND a.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND a.PSO_BZTP_CD = b.PSO_BZTP_CD(+)" ).append("\n"); 
		query.append("AND a.VSL_CD = b.VSL_CD(+)" ).append("\n"); 
		query.append("AND a.SKD_VOY_NO = b.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND a.SKD_DIR_CD = b.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT   2," ).append("\n"); 
		query.append("a.PSO_BZTP_CD," ).append("\n"); 
		query.append("b.VNDR_SEQ," ).append("\n"); 
		query.append("(SELECT   z.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM   vsk_vsl_skd z" ).append("\n"); 
		query.append("WHERE       z.VSL_CD = a.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO = a.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD = a.SKD_DIR_CD)" ).append("\n"); 
		query.append("lane," ).append("\n"); 
		query.append("a.VSL_CD || a.SKD_VOY_NO || a.SKD_DIR_CD vvd," ).append("\n"); 
		query.append("(SELECT   VPS_ETB_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD z" ).append("\n"); 
		query.append("WHERE       z.VSL_CD = a.VSL_CD" ).append("\n"); 
		query.append("AND z.SKD_VOY_NO = a.SKD_VOY_NO" ).append("\n"); 
		query.append("AND z.SKD_DIR_CD = a.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD = b.YD_CD" ).append("\n"); 
		query.append("AND CALL_YD_IND_SEQ = '1')" ).append("\n"); 
		query.append("transitDate," ).append("\n"); 
		query.append("MIN(DECODE (b.CNL_TZ_BZTP_CD," ).append("\n"); 
		query.append("'E', b.CNL_TZ_PROC_STS_CD," ).append("\n"); 
		query.append("''))" ).append("\n"); 
		query.append("advancePaymentStatus," ).append("\n"); 
		query.append("MIN(DECODE (b.CNL_TZ_BZTP_CD," ).append("\n"); 
		query.append("'E', b.REV_YRMON," ).append("\n"); 
		query.append("''))" ).append("\n"); 
		query.append("advancePaymentRevMonth," ).append("\n"); 
		query.append("MAX(DECODE (b.CNL_TZ_BZTP_CD," ).append("\n"); 
		query.append("'I', b.CNL_TZ_PROC_STS_CD," ).append("\n"); 
		query.append("''))" ).append("\n"); 
		query.append("InvoiceStatus," ).append("\n"); 
		query.append("MAX(DECODE (b.CNL_TZ_BZTP_CD," ).append("\n"); 
		query.append("'I', b.REV_YRMON," ).append("\n"); 
		query.append("''))" ).append("\n"); 
		query.append("InvoiceRevMonth," ).append("\n"); 
		query.append("'' MSA," ).append("\n"); 
		query.append("'Mismatch' DIFF_RMK," ).append("\n"); 
		query.append("max(b.ISS_CTY_CD) ISS_CTY_CD," ).append("\n"); 
		query.append("max(b.SO_SEQ) SO_SEQ," ).append("\n"); 
		query.append("COUNT ( * ) CNT" ).append("\n"); 
		query.append("FROM   pso_tgt_vvd a, pso_cnl_tz_fee b" ).append("\n"); 
		query.append("WHERE   b.NTC_YRMON BETWEEN TO_CHAR (" ).append("\n"); 
		query.append("ADD_MONTHS (" ).append("\n"); 
		query.append("TO_DATE (@[revyrmon]," ).append("\n"); 
		query.append("'yyyymm')," ).append("\n"); 
		query.append("-6" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  TO_CHAR (" ).append("\n"); 
		query.append("ADD_MONTHS (" ).append("\n"); 
		query.append("TO_DATE (@[revyrmon]," ).append("\n"); 
		query.append("'yyyymm')," ).append("\n"); 
		query.append("-1" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("'yyyymm'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND b.CNL_TZ_PROC_STS_CD = 'C'" ).append("\n"); 
		query.append("AND a.PSO_BZTP_CD = b.PSO_BZTP_CD" ).append("\n"); 
		query.append("AND a.VSL_CD = b.VSL_CD" ).append("\n"); 
		query.append("AND a.SKD_VOY_NO = b.SKD_VOY_NO" ).append("\n"); 
		query.append("AND a.SKD_DIR_CD = b.SKD_DIR_CD" ).append("\n"); 
		query.append("GROUP BY   a.PSO_BZTP_CD," ).append("\n"); 
		query.append("a.VSL_CD," ).append("\n"); 
		query.append("a.SKD_VOY_NO," ).append("\n"); 
		query.append("a.SKD_DIR_CD," ).append("\n"); 
		query.append("b.VNDR_SEQ," ).append("\n"); 
		query.append("b.YD_CD) y" ).append("\n"); 
		query.append("GROUP BY   ROLLUP (vndr_seq, vvd)) z" ).append("\n"); 
		query.append("WHERE   z.grp = 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where 1 = 1" ).append("\n"); 
		query.append("#if( ${revyrmon}!='')" ).append("\n"); 
		query.append("AND @[revyrmon] = @[revyrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${port_cd}!='')" ).append("\n"); 
		query.append("AND @[port_cd] = @[port_cd]" ).append("\n"); 
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
		query.append("AND @[vsl_slan_cd] = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by pay_to, lane, vvd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeBalanceBCDBDAOsearchCanalTzFeeSumRptRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}