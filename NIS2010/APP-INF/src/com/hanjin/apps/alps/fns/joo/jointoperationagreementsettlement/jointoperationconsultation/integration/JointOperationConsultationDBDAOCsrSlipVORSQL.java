/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCsrSlipVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCsrSlipVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHM-201641292 CSR List Inquiry 상 Payment date 표시 건 : AP CSR건에 대한 PAY_DT 표시항목 추가
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCsrSlipVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCsrSlipVORSQL").append("\n"); 
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
		query.append("       A.APRO_FLG," ).append("\n"); 
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||SUBSTR(A.SLP_ISS_DT,3)||A.SLP_SER_NO AS CSR_NO," ).append("\n"); 
		query.append("       A.CSR_OFFST_NO," ).append("\n"); 
		query.append("       A.SLP_ISS_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.EFF_DT,'YYYYMMDD') AS EFF_DT," ).append("\n"); 
		query.append("       A.CSR_LOCL_CURR_CD," ).append("\n"); 
		query.append("       A.CSR_LOCL_AMT," ).append("\n"); 
		query.append("       B.USR_NM AS ISSUER," ).append("\n"); 
		query.append("       A.CSR_DESC," ).append("\n"); 
		query.append("	   A.CSR_LOCL_AMT / DECODE (A.CSR_LOCL_CURR_CD, 'USD', 1, (" ).append("\n"); 
		query.append("           SELECT NVL(EX1.USD_LOCL_XCH_RT, 1)" ).append("\n"); 
		query.append("                FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("           WHERE EX1.CURR_CD = A.CSR_LOCL_CURR_CD" ).append("\n"); 
		query.append("           AND EX1.ACCT_XCH_RT_YRMON = TO_CHAR(A.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("           AND EX1.ACCT_XCH_RT_LVL = '1' ) ) AS USD_LOCL_AMT," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("          SELECT CASE WHEN INV.RCV_ERR_FLG = 'E' THEN 'Cancelled'" ).append("\n"); 
		query.append("                      WHEN INV.PAY_DT IS NULL AND INV.PAY_AMT = 0 THEN 'Paid Amount : 0'" ).append("\n"); 
		query.append("                      WHEN INV.PAY_DT IS NOT NULL THEN TO_CHAR(TO_DATE(PAY_DT, 'YYYYMMDD'), 'YYYY-MM-DD')" ).append("\n"); 
		query.append("                 ELSE ''" ).append("\n"); 
		query.append("                 END PAY_DT" ).append("\n"); 
		query.append("            FROM AP_INV_HDR INV" ).append("\n"); 
		query.append("           WHERE INV.CSR_NO = A.SLP_TP_CD || A.SLP_FUNC_CD || A.SLP_OFC_CD || SUBSTR(A.SLP_ISS_DT, 3) || A.SLP_SER_NO" ).append("\n"); 
		query.append("       ) PAY_DT" ).append("\n"); 
		query.append("FROM   JOO_CSR  A," ).append("\n"); 
		query.append("       COM_USER B" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID  = B.USR_ID(+)" ).append("\n"); 
		query.append("AND    A.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("	#if (${re_divr_cd} == 'R')" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD = '18'" ).append("\n"); 
		query.append("	#elseif(${re_divr_cd} == 'E')" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD IN ('06', '02')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND   A.CSR_OFFST_NO LIKE @[crr_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${csr_no} != '')" ).append("\n"); 
		query.append("AND    A.SLP_TP_CD   = SUBSTR(@[csr_no], 1,2)" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD = SUBSTR(@[csr_no], 3,1)" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],4,6),SUBSTR(@[csr_no],4,5))" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  = TO_CHAR(TO_DATE(DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],10,6),SUBSTR(@[csr_no],9,6)),'RRMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO  = DECODE(LENGTH(@[csr_no]),20,SUBSTR(@[csr_no],16),SUBSTR(@[csr_no],15))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${gubun} == '0')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("#elseif(${gubun} == '1')" ).append("\n"); 
		query.append("AND    A.EFF_DT  >= TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.EFF_DT  <= TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slp_ofc_cd} != '')" ).append("\n"); 
		query.append("/* 20091208 SLP_OFC_CD -> SLP_ISS_OFC_CD 수정  => 20100201 다시 SLP_OFC_CD로 변경 => 20100219 SLP_OFC_CD, SLP_ISS_OFC_CD 중 하나 (박효숙차장)*/" ).append("\n"); 
		query.append("AND   (A.SLP_OFC_CD = @[slp_ofc_cd] OR A.SLP_ISS_OFC_CD  = @[slp_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 

	}
}