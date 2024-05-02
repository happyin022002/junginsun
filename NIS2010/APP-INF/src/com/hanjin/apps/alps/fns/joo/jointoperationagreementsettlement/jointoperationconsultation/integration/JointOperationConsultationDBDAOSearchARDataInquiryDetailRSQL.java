/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JointOperationConsultationDBDAOSearchARDataInquiryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.10.27 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM YOUNG-OH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOSearchARDataInquiryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationConsultationDBDAOSearchARDataInquiryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOSearchARDataInquiryDetailRSQL").append("\n"); 
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
		query.append("SELECT  S.ACCT_YRMON" ).append("\n"); 
		query.append(",       S.JO_CRR_CD AS JO_CRR_CD2" ).append("\n"); 
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
		query.append(",   	DECODE(S.RE_DIVR_CD, 'R', S.STL_LOCL_AMT / DECODE (S.LOCL_CURR_CD, 'USD', 1, (" ).append("\n"); 
		query.append("SELECT NVL(EX1.USD_LOCL_XCH_RT, 1)" ).append("\n"); 
		query.append("FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("WHERE EX1.CURR_CD = S.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND EX1.ACCT_XCH_RT_YRMON = TO_CHAR(R.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("AND EX1.ACCT_XCH_RT_LVL = '1' ) ) )  AS STL_USD_AMT" ).append("\n"); 
		query.append("FROM    JOO_SETTLEMENT  S" ).append("\n"); 
		query.append(",       JOO_STL_CMB     CB" ).append("\n"); 
		query.append(",       JOO_SLIP SL" ).append("\n"); 
		query.append(",  		JOO_CSR R" ).append("\n"); 
		query.append(",       AR_MST_REV_VVD AR" ).append("\n"); 
		query.append(",       (SELECT  @[cb_ofc_cd] OFC_CD" ).append("\n"); 
		query.append("FROM DUAL ) P" ).append("\n"); 
		query.append("WHERE   S.ACCT_YRMON    = SL.ACCT_YRMON" ).append("\n"); 
		query.append("AND     S.STL_VVD_SEQ   = SL.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND     S.STL_SEQ       = SL.STL_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     CB.SLP_TP_CD    = SL.SLP_TP_CD" ).append("\n"); 
		query.append("AND     CB.SLP_FUNC_CD  = SL.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND     CB.SLP_OFC_CD   = SL.SLP_OFC_CD" ).append("\n"); 
		query.append("AND     CB.SLP_ISS_DT   = SL.SLP_ISS_DT" ).append("\n"); 
		query.append("AND     CB.SLP_SER_NO   = SL.SLP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 	CB.SLP_FUNC_CD = R.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND 	CB.SLP_OFC_CD = R.SLP_OFC_CD" ).append("\n"); 
		query.append("AND 	CB.SLP_ISS_DT = R.SLP_ISS_DT" ).append("\n"); 
		query.append("AND 	CB.SLP_SER_NO = R.SLP_SER_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     S.VSL_CD          = AR.VSL_CD(+)" ).append("\n"); 
		query.append("AND     S.SKD_VOY_NO      = AR.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     S.SKD_DIR_CD      = AR.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     S.REV_DIR_CD      = AR.RLANE_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     SL.SLP_OFC_CD  =  DECODE(P.OFC_CD,'All',SL.SLP_OFC_CD,P.OFC_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     NVL( AR.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append("AND     S.ACCT_YRMON    BETWEEN REPLACE(@[yrmon_fr],'-','')  AND REPLACE(@[yrmon_to],'-','')" ).append("\n"); 
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