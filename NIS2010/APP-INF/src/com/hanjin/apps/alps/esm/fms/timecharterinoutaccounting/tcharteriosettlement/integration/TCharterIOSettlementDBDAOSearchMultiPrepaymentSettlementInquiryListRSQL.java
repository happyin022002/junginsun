/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOSettlementDBDAOSearchMultiPrepaymentSettlementInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.23 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOSettlementDBDAOSearchMultiPrepaymentSettlementInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slip Inquiry
	  * </pre>
	  */
	public TCharterIOSettlementDBDAOSearchMultiPrepaymentSettlementInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_date_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration").append("\n"); 
		query.append("FileName : TCharterIOSettlementDBDAOSearchMultiPrepaymentSettlementInquiryListRSQL").append("\n"); 
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
		query.append("SELECT 	" ).append("\n"); 
		query.append("        @[usr_id] USR_ID," ).append("\n"); 
		query.append("        'AP' CSR_TYPE," ).append("\n"); 
		query.append("        'MultiPrepaymentSettlement' SCREEN_GUBUN," ).append("\n"); 
		query.append("        @[eff_date_from] FROM_EFF_DT," ).append("\n"); 
		query.append("        @[eff_date_to] TO_EFF_DT," ).append("\n"); 
		query.append("		B.ORG_SLP_TP_CD||B.ORG_SLP_FUNC_CD||B.ORG_SLP_OFC_CD||B.ORG_ISS_DT||B.ORG_SLP_SER_NO ORG_SLIP_NO," ).append("\n"); 
		query.append("        B.SLP_TP_CD||B.SLP_FUNC_CD||B.SLP_OFC_CD||B.SLP_ISS_DT||B.SLP_SER_NO NEW_CSR_NO," ).append("\n"); 
		query.append("        B.SLP_OFC_CD REQUEST_TEAM," ).append("\n"); 
		query.append("        TO_CHAR(A.CRE_DT,'YYYYMMDD') CSR_DT," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT USR_NM" ).append("\n"); 
		query.append("              FROM COM_USER" ).append("\n"); 
		query.append("             WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("        ) PRODUCED_BY," ).append("\n"); 
		query.append("        B.CSR_DESC," ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN B.CUST_CNT_CD IS NOT NULL AND B.CUST_SEQ IS NOT NULL " ).append("\n"); 
		query.append("            THEN B.CUST_CNT_CD || ' ' || B.CUST_SEQ" ).append("\n"); 
		query.append("            ELSE TO_CHAR(B.VNDR_SEQ)" ).append("\n"); 
		query.append("        END OWNR_CD," ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN C.OWNR_SEQ IS NULL " ).append("\n"); 
		query.append("            THEN (  " ).append("\n"); 
		query.append("                    CASE " ).append("\n"); 
		query.append("                        WHEN B.CUST_CNT_CD IS NOT NULL AND B.CUST_SEQ IS NOT NULL " ).append("\n"); 
		query.append("                        THEN (" ).append("\n"); 
		query.append("                                SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                                  FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("                                 WHERE MV.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                   AND MV.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("                                   AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                                   AND ROWNUM =1" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                        ELSE (" ).append("\n"); 
		query.append("                                SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                                  FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("                                 WHERE MV.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("                                   AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                                   AND ROWNUM =1" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                        END " ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            ELSE (" ).append("\n"); 
		query.append("                    SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                      FROM FMS_OWNER FO" ).append("\n"); 
		query.append("                     WHERE C.OWNR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM =1" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("        END OWNR_NM," ).append("\n"); 
		query.append("        B.CSR_CURR_CD," ).append("\n"); 
		query.append("        B.CSR_AMT," ).append("\n"); 
		query.append("        DECODE(A.EVID_TP_CD,'1','TAX','4','CI','ETC') EVID_TP," ).append("\n"); 
		query.append("        CASE " ).append("\n"); 
		query.append("            WHEN A.DIFF_AMT > 0 " ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("        END DEDUCTION," ).append("\n"); 
		query.append("        A.RQST_AMT," ).append("\n"); 
		query.append("        A.DIFF_DESC," ).append("\n"); 
		query.append("        A.CXL_FLG," ).append("\n"); 
		query.append("        A.CXL_DESC," ).append("\n"); 
		query.append("        NVL(" ).append("\n"); 
		query.append("            B.VSL_CD," ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT VSL_CD" ).append("\n"); 
		query.append("                  FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                 WHERE FLET_CTRT_NO = A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        ) VSL_CD," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT VSL_ENG_NM" ).append("\n"); 
		query.append("              FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("             WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("              AND VSL_CD = NVL(B.VSL_CD," ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                            SELECT VSL_CD" ).append("\n"); 
		query.append("                                              FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                                             WHERE FLET_CTRT_NO = A.FLET_CTRT_NO" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("        ) VSL_ENG_NAME" ).append("\n"); 
		query.append("FROM 	FMS_CONSULTATION A, FMS_CSUL_SLP B, FMS_CONTRACT C" ).append("\n"); 
		query.append("WHERE 	A.SLP_TP_CD 	= B.SLP_TP_CD" ).append("\n"); 
		query.append("AND   	A.SLP_FUNC_CD 	= B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_OFC_CD 	= B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND   	A.SLP_ISS_DT 	= B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND   	A.SLP_SER_NO 	= B.SLP_SER_NO" ).append("\n"); 
		query.append("AND		A.SLP_FUNC_CD   = 'S'" ).append("\n"); 
		query.append("AND	  	B.ACCT_CD	 	= '111431'" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = C.FLET_CTRT_NO " ).append("\n"); 
		query.append("#if ( ${eff_date_from} != '' )" ).append("\n"); 
		query.append("AND A.EFF_DT BETWEEN @[eff_date_from] AND @[eff_date_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${vsl_cd} != '' )" ).append("\n"); 
		query.append("AND C.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY B.INV_SEQ" ).append("\n"); 

	}
}