/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSearchRevDetailARDataInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.30 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSearchRevDetailARDataInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSearchRevDetailARDataInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cb_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSearchRevDetailARDataInquiryRSQL").append("\n"); 
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
		query.append("/*+ INDEX(S XPKJOO_SETTLEMENT) */" ).append("\n"); 
		query.append("S.ACCT_YRMON" ).append("\n"); 
		query.append(",       S.JO_CRR_CD" ).append("\n"); 
		query.append(",       S.RLANE_CD" ).append("\n"); 
		query.append(",       S.VSL_CD" ).append("\n"); 
		query.append(",       S.SKD_VOY_NO" ).append("\n"); 
		query.append(",       S.SKD_DIR_CD" ).append("\n"); 
		query.append(",       S.REV_DIR_CD" ).append("\n"); 
		query.append(",       S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD||S.REV_DIR_CD VVD" ).append("\n"); 
		query.append(",       AR.REV_YRMON" ).append("\n"); 
		query.append(",       SL.CSR_LOCL_AMT CSR_LOCL_AMT" ).append("\n"); 
		query.append(",       S.LOCL_CURR_CD" ).append("\n"); 
		query.append(",       S.JO_STL_ITM_CD" ).append("\n"); 
		query.append(",       SL.JO_BIL_NO" ).append("\n"); 
		query.append(",       SL.SLP_TP_CD||SL.SLP_FUNC_CD||SL.SLP_OFC_CD||SUBSTR(SL.SLP_ISS_DT,3)||SL.SLP_SER_NO||SL.SLP_SEQ_NO  TRAN_NO" ).append("\n"); 
		query.append("FROM    JOO_SLIP        SL" ).append("\n"); 
		query.append(",       JOO_SETTLEMENT  S" ).append("\n"); 
		query.append(",       JOO_STL_CMB     CB" ).append("\n"); 
		query.append(",       AR_MST_REV_VVD  AR" ).append("\n"); 
		query.append(",       JOO_CSR         R" ).append("\n"); 
		query.append(",       (SELECT   TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[yrmon_fr],'-','')||'01', 'YYYYMMDD'), -12),'YYYY')||'01' PRE_YEAR01" ).append("\n"); 
		query.append(",@[cb_ofc_cd] OFC_CD" ).append("\n"); 
		query.append(", REPLACE( @[yrmon_fr],'-','') CUR_YRMON" ).append("\n"); 
		query.append("FROM DUAL ) P" ).append("\n"); 
		query.append(",      (SELECT   DISTINCT" ).append("\n"); 
		query.append("NVL( ORG1.OFC_CD, ORG2.OFC_CD ) OFC_CD, AP_P.LST_UPD_DT CLS_DT" ).append("\n"); 
		query.append(",NVL( ORG1.AP_OFC_CD, ORG2.AR_HD_QTR_OFC_CD ) HD_OFC_CD" ).append("\n"); 
		query.append(",ORG1.AP_OFC_CD" ).append("\n"); 
		query.append(",ORG2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM   AP_PERIOD AP_P" ).append("\n"); 
		query.append(",      MDM_ORGANIZATION ORG1" ).append("\n"); 
		query.append(",      (SELECT    HD_ORG1.OFC_CD, HD_ORG1.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION HD_ORG1" ).append("\n"); 
		query.append(",      MDM_ORGANIZATION HD_ORG2" ).append("\n"); 
		query.append("WHERE  HD_ORG1.OFC_CD =  HD_ORG2.AP_OFC_CD" ).append("\n"); 
		query.append("GROUP BY HD_ORG1.OFC_CD, HD_ORG1.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(") ORG2" ).append("\n"); 
		query.append(",     (SELECT   TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[yrmon_fr],'-','')||'01', 'YYYYMMDD'), -12),'YYYY')||'01' PRE_YEAR01" ).append("\n"); 
		query.append(", REPLACE( @[yrmon_fr],'-','') CUR_YRMON" ).append("\n"); 
		query.append("FROM DUAL ) SUB_P" ).append("\n"); 
		query.append("WHERE   AP_P.SYS_DIV_CD = '25'" ).append("\n"); 
		query.append("AND   AP_P.EFF_YRMON  =  SUB_P.CUR_YRMON" ).append("\n"); 
		query.append("AND   AP_P.RHQ_CD     =  ORG1.AP_OFC_CD(+)" ).append("\n"); 
		query.append("AND   AP_P.RHQ_CD     =  ORG2.AR_HD_QTR_OFC_CD(+)" ).append("\n"); 
		query.append("AND   (ORG1.AP_OFC_CD IS NOT NULL OR ORG2.AR_HD_QTR_OFC_CD IS NOT NULL)" ).append("\n"); 
		query.append(")CURR_YRMON_AP_P" ).append("\n"); 
		query.append(",      (SELECT   DISTINCT" ).append("\n"); 
		query.append("NVL( ORG1.OFC_CD, ORG2.OFC_CD ) OFC_CD,  AP_P.LST_UPD_DT CLS_DT" ).append("\n"); 
		query.append(",NVL( ORG1.AP_OFC_CD, ORG2.AR_HD_QTR_OFC_CD ) HD_OFC_CD" ).append("\n"); 
		query.append(",ORG1.AP_OFC_CD" ).append("\n"); 
		query.append(",ORG2.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM   AP_PERIOD AP_P" ).append("\n"); 
		query.append(",      MDM_ORGANIZATION ORG1" ).append("\n"); 
		query.append(",      (SELECT    HD_ORG1.OFC_CD, HD_ORG1.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM   MDM_ORGANIZATION HD_ORG1" ).append("\n"); 
		query.append(",      MDM_ORGANIZATION HD_ORG2" ).append("\n"); 
		query.append("WHERE  HD_ORG1.OFC_CD =  HD_ORG2.AP_OFC_CD" ).append("\n"); 
		query.append("GROUP BY HD_ORG1.OFC_CD, HD_ORG1.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(") ORG2" ).append("\n"); 
		query.append(",     (SELECT   TO_CHAR(TO_DATE(REPLACE(@[yrmon_fr],'-','')||'01','YYYYMMDD')-1, 'YYYYMM') PREV_YRMON" ).append("\n"); 
		query.append("FROM DUAL ) P" ).append("\n"); 
		query.append("WHERE   AP_P.SYS_DIV_CD = '25'" ).append("\n"); 
		query.append("AND   AP_P.EFF_YRMON  =  P.PREV_YRMON" ).append("\n"); 
		query.append("AND   AP_P.RHQ_CD     =  ORG1.AP_OFC_CD(+)" ).append("\n"); 
		query.append("AND   AP_P.RHQ_CD     =  ORG2.AR_HD_QTR_OFC_CD(+)" ).append("\n"); 
		query.append("AND   (ORG1.AP_OFC_CD IS NOT NULL OR ORG2.AR_HD_QTR_OFC_CD IS NOT NULL)" ).append("\n"); 
		query.append(")PREV_YRMON_AP_P" ).append("\n"); 
		query.append("WHERE   S.ACCT_YRMON     = SL.ACCT_YRMON" ).append("\n"); 
		query.append("AND     S.STL_VVD_SEQ    = SL.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND     S.STL_SEQ        = SL.STL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     CB.SLP_TP_CD    = SL.SLP_TP_CD" ).append("\n"); 
		query.append("AND     CB.SLP_FUNC_CD  = SL.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND     CB.SLP_OFC_CD   = SL.SLP_OFC_CD" ).append("\n"); 
		query.append("AND     CB.SLP_ISS_DT   = SL.SLP_ISS_DT" ).append("\n"); 
		query.append("AND     CB.SLP_SER_NO   = SL.SLP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     S.VSL_CD          = AR.VSL_CD" ).append("\n"); 
		query.append("AND     S.SKD_VOY_NO      = AR.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     S.SKD_DIR_CD      = AR.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     S.REV_DIR_CD      = AR.RLANE_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     SL.SLP_TP_CD   = R.SLP_TP_CD" ).append("\n"); 
		query.append("AND     SL.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND     SL.SLP_OFC_CD  = R.SLP_OFC_CD" ).append("\n"); 
		query.append("AND     SL.SLP_ISS_DT  = R.SLP_ISS_DT" ).append("\n"); 
		query.append("AND     SL.SLP_SER_NO  = R.SLP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     SL.SLP_OFC_CD  =  CURR_YRMON_AP_P.OFC_CD" ).append("\n"); 
		query.append("AND     SL.SLP_OFC_CD  =  PREV_YRMON_AP_P.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     SL.SLP_OFC_CD  =  DECODE(P.OFC_CD,'All',SL.SLP_OFC_CD,P.OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     NVL( AR.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("S.ACCT_YRMON  = P.CUR_YRMON" ).append("\n"); 
		query.append("AND    AR.REV_YRMON <= P.CUR_YRMON" ).append("\n"); 
		query.append("AND    R.APRO_DT   BETWEEN   PREV_YRMON_AP_P.CLS_DT" ).append("\n"); 
		query.append("AND    CURR_YRMON_AP_P.CLS_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(      S.ACCT_YRMON BETWEEN  P.PRE_YEAR01 AND P.CUR_YRMON" ).append("\n"); 
		query.append("AND   AR.REV_YRMON =  P.CUR_YRMON" ).append("\n"); 
		query.append("AND   R.APRO_DT  <=   CURR_YRMON_AP_P.CLS_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("S.ACCT_YRMON >    P.CUR_YRMON" ).append("\n"); 
		query.append("AND   AR.REV_YRMON <=   P.CUR_YRMON" ).append("\n"); 
		query.append("AND   R.APRO_DT    <=   CURR_YRMON_AP_P.CLS_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != 'All')" ).append("\n"); 
		query.append("AND     S.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     SL.SLP_TP_CD   = '18'" ).append("\n"); 
		query.append("AND     SL.DR_CR_CD    = 'DR'" ).append("\n"); 
		query.append("AND     CB.RE_DIVR_CD  = 'R'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY S.ACCT_YRMON, S.RLANE_CD, AR.REV_YRMON,S.JO_CRR_CD" ).append("\n"); 

	}
}