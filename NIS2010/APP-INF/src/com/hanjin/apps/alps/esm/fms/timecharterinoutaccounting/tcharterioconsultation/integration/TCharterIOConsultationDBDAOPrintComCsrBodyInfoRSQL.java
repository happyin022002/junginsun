/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOPrintComCsrBodyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOPrintComCsrBodyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * groupware 전송 xmlData Body info
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOPrintComCsrBodyInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOPrintComCsrBodyInfoRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM L_SEQ, R.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT Chart_of_Account L_COA" ).append("\n"); 
		query.append("     , Account_Name L_ACCOUNT_NAME" ).append("\n"); 
		query.append("     , GL_Date L_GL_DATE" ).append("\n"); 
		query.append("     , City L_CITY" ).append("\n"); 
		query.append("     , Invoice_NO L_VENDOR_INV_NO" ).append("\n"); 
		query.append("     , Description L_DESCRIPTION" ).append("\n"); 
		query.append("     ,TO_CHAR(Debit, '999,999,999,990.00') L_DEBIT_AMT" ).append("\n"); 
		query.append("     ,TO_CHAR(Credit, '999,999,999,990.00') L_CREDIT_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("       ( SELECT  Chart_of_Account" ).append("\n"); 
		query.append("              , Account_Name" ).append("\n"); 
		query.append("              , GL_Date" ).append("\n"); 
		query.append("              , City" ).append("\n"); 
		query.append("              , Invoice_NO" ).append("\n"); 
		query.append("              , Description" ).append("\n"); 
		query.append("              , Debit" ).append("\n"); 
		query.append("              , Credit" ).append("\n"); 
		query.append("       FROM" ).append("\n"); 
		query.append("                ( SELECT  D.DTRB_COA_CO_CD" ).append("\n"); 
		query.append("                                  ||'.'" ).append("\n"); 
		query.append("                                  ||D.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("                                  ||'.'" ).append("\n"); 
		query.append("                                  ||D.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("                                  ||'.'" ).append("\n"); 
		query.append("                                  ||D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("                                  ||'.'" ).append("\n"); 
		query.append("                                  || D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("                                  ||'.'" ).append("\n"); 
		query.append("                                  ||D.DTRB_COA_VVD_CD Chart_of_Account" ).append("\n"); 
		query.append("                       , (SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("                         FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("                         WHERE   ACCT_CD = D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("                         ) Account_Name" ).append("\n"); 
		query.append("                       , SUBSTR(H.GL_DT,1,4)" ).append("\n"); 
		query.append("                                  ||'/'" ).append("\n"); 
		query.append("                                  ||SUBSTR(H.GL_DT,5,2)" ).append("\n"); 
		query.append("                                  ||'/'" ).append("\n"); 
		query.append("                                  ||SUBSTR(H.GL_DT,7,2) GL_Date" ).append("\n"); 
		query.append("                       , D.ATTR_CTNT3 City" ).append("\n"); 
		query.append("                       , D.ATTR_CTNT1 Invoice_NO" ).append("\n"); 
		query.append("                       , CASE WHEN D.DTRB_COA_ACCT_CD = '111431' THEN" ).append("\n"); 
		query.append("                                 (" ).append("\n"); 
		query.append("                                 SELECT A.CSR_DESC FROM FMS_CSUL_SLP A" ).append("\n"); 
		query.append("                                  WHERE 1=1" ).append("\n"); 
		query.append("                                    AND		A.SLP_TP_CD 	= SUBSTR(@[csr_no],1,2)" ).append("\n"); 
		query.append("                                    AND		A.SLP_FUNC_CD 	= SUBSTR(@[csr_no],3,1)" ).append("\n"); 
		query.append("                                    AND		A.SLP_OFC_CD 	= SUBSTR(@[csr_no],4,6)" ).append("\n"); 
		query.append("                                    AND		A.SLP_ISS_DT 	= SUBSTR(@[csr_no],10,6)" ).append("\n"); 
		query.append("                                    AND		A.SLP_SER_NO 	= SUBSTR(@[csr_no],16,5)" ).append("\n"); 
		query.append("                                    AND     A.ACCT_CD = '111431'" ).append("\n"); 
		query.append("                                 )   " ).append("\n"); 
		query.append("                              ELSE" ).append("\n"); 
		query.append("                                  D.INV_DESC                        " ).append("\n"); 
		query.append("                              END Description" ).append("\n"); 
		query.append("                       , CASE WHEN D.DTRB_COA_ACCT_CD = '111431' THEN" ).append("\n"); 
		query.append("                            CASE WHEN SUBSTR(@[csr_no],0,3) = '07S' AND MAX(H.PPD_DTRB_NO) = '1' THEN" ).append("\n"); 
		query.append("                                      TO_CHAR(ROUND(SUM(D.INV_AMT),2)*-1)" ).append("\n"); 
		query.append("                                 ELSE TO_CHAR(ROUND(SUM(D.INV_AMT),2))" ).append("\n"); 
		query.append("                                 END  " ).append("\n"); 
		query.append("                             ELSE" ).append("\n"); 
		query.append("                                TO_CHAR(ROUND(SUM(D.INV_AMT),2))" ).append("\n"); 
		query.append("                             END Debit   " ).append("\n"); 
		query.append("                       , '' Credit" ).append("\n"); 
		query.append("                       , D.LINE_NO NO" ).append("\n"); 
		query.append("					   , D.LINE_SEQ                        " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[csr_no] ORG_CSR_NO, H.* FROM AP_INV_HDR H WHERE H.CSR_NO = @[csr_no]                                        " ).append("\n"); 
		query.append(") H                   " ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[csr_no] ORG_CSR_NO, H.* FROM AP_INV_DTRB H WHERE H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT @[csr_no] ORG_CSR_NO, D.* FROM AP_INV_DTRB D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND D.CSR_NO = (" ).append("\n"); 
		query.append("                SELECT PPD_NO FROM AP_INV_HDR" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                )  " ).append("\n"); 
		query.append("AND D.DTRB_COA_ACCT_CD = '111431'                " ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("                WHERE    H.ORG_CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("                     AND H.ORG_CSR_NO = D.ORG_CSR_NO                     " ).append("\n"); 
		query.append("                GROUP BY D.DTRB_COA_CO_CD" ).append("\n"); 
		query.append("                       , D.DTRB_COA_RGN_CD" ).append("\n"); 
		query.append("                       , D.DTRB_COA_CTR_CD" ).append("\n"); 
		query.append("                       , D.DTRB_COA_ACCT_CD" ).append("\n"); 
		query.append("                       , D.DTRB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("                       , D.DTRB_COA_VVD_CD" ).append("\n"); 
		query.append("                       , D.INV_DESC" ).append("\n"); 
		query.append("                       , H.GL_DT" ).append("\n"); 
		query.append("                       , D.ATTR_CTNT3" ).append("\n"); 
		query.append("                       , D.ATTR_CTNT1" ).append("\n"); 
		query.append("                       , D.LINE_NO" ).append("\n"); 
		query.append("                       , DECODE(H.SRC_CTNT, 'SO_M&R', 1, D.LINE_SEQ)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("       ORDER BY NO ASC" ).append("\n"); 
		query.append("       )          " ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT COA_CO_CD" ).append("\n"); 
		query.append("              ||'.'" ).append("\n"); 
		query.append("              ||COA_RGN_CD" ).append("\n"); 
		query.append("              ||'.'" ).append("\n"); 
		query.append("              ||COA_CTR_CD" ).append("\n"); 
		query.append("              ||'.'" ).append("\n"); 
		query.append("              ||COA_ACCT_CD" ).append("\n"); 
		query.append("              ||'.'" ).append("\n"); 
		query.append("              || COA_INTER_CO_CD" ).append("\n"); 
		query.append("              ||'.'" ).append("\n"); 
		query.append("              ||COA_VVD_CD Chart_of_Account" ).append("\n"); 
		query.append("     , ( SELECT ACCT_ENG_NM" ).append("\n"); 
		query.append("       FROM    MDM_ACCOUNT" ).append("\n"); 
		query.append("       WHERE   ACCT_CD = COA_ACCT_CD" ).append("\n"); 
		query.append("       ) Account_Name" ).append("\n"); 
		query.append("     , SUBSTR(GL_DT,1,4)" ).append("\n"); 
		query.append("              ||'/'" ).append("\n"); 
		query.append("              ||SUBSTR(GL_DT,5,2)" ).append("\n"); 
		query.append("              ||'/'" ).append("\n"); 
		query.append("              ||SUBSTR(GL_DT,7,2) GL_Date" ).append("\n"); 
		query.append("     , '' City" ).append("\n"); 
		query.append("     , '' Invoice_NO" ).append("\n"); 
		query.append("     , INV_DESC Description" ).append("\n"); 
		query.append("     , '' Debit" ).append("\n"); 
		query.append("     ,CASE WHEN SUBSTR(@[csr_no],0,3) = '07S' AND H.PPD_DTRB_NO = '1' THEN" ).append("\n"); 
		query.append("            '0.00'" ).append("\n"); 
		query.append("         ELSE" ).append("\n"); 
		query.append("            TO_CHAR(ROUND(H.CSR_AMT, 2), '999,999,999,990.00')" ).append("\n"); 
		query.append("         END  Credit   " ).append("\n"); 
		query.append("FROM   AP_INV_HDR H" ).append("\n"); 
		query.append("WHERE  H.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append(") R" ).append("\n"); 
		query.append("WHERE ROWNUM <= 6" ).append("\n"); 

	}
}