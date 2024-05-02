/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgCopyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgCopyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFA Copy 데이터의 Arbitrary 값을 변경.
	  * 2015.08.27 전지예 [CHM-201537719] Arbitrary RFA copy 시 발생하는 currency error 수정요청
	  * 2015.11.10 SELCMU/김현경 [CHM-201538112] Tariff 변경시 현 RFA 상 Arbitiary 탭 미반영 로직수정
	  * </pre>
	  */
	public RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgCopyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration").append("\n"); 
		query.append("FileName : RFATransportationAdditionalChargeProposalDBDAOPriRpScpTrspAddChgCopyUSQL").append("\n"); 
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
		query.append("UPDATE /*+ bypass_ujvc*/ " ).append("\n"); 
		query.append("(SELECT        G.PROP_NO," ).append("\n"); 
		query.append("               G.AMDT_SEQ," ).append("\n"); 
		query.append("               G.SVC_SCP_CD," ).append("\n"); 
		query.append("               G.ADD_CHG_TP_CD," ).append("\n"); 
		query.append("               G.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("               G.ADD_CHG_SEQ," ).append("\n"); 
		query.append("               G.PROP_FRT_RT_AMT," ).append("\n"); 
		query.append("               G.CURR_CD," ).append("\n"); 
		query.append("               G.OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("               G.FIC_ROUT_CMB_TP_CD," ).append("\n"); 
		query.append("               G.FIC_RT_USE_STS_CD," ).append("\n"); 
		query.append("               G.FIC_GLINE_RT_AMT," ).append("\n"); 
		query.append("               G.FIC_GLINE_UPD_DT," ).append("\n"); 
		query.append("               X.FIC_RT_USE_STS_CD AS RT_USE_STS_CD," ).append("\n"); 
		query.append("               X.FIC_ROUT_CMB_TP_CD AS ROUT_CMB_TP_CD," ).append("\n"); 
		query.append("               X.OPTM_TRSP_MOD_FLG AS TRSP_MOD_FLG," ).append("\n"); 
		query.append("               X.FIC_GLINE_RT_AMT AS GLINE_RT_AMT," ).append("\n"); 
		query.append("               X.FIC_LOCL_CURR_CD," ).append("\n"); 
		query.append("               X.FIC_GLINE_LOCL_RT_AMT," ).append("\n"); 
		query.append("               (SELECT USD_LOCL_XCH_RT * NVL(X.FIC_GLINE_RT_AMT, 0) RATE" ).append("\n"); 
		query.append("                  FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("                       AND ACCT_XCH_RT_YRMON = (SELECT MAX(ACCT_XCH_RT_YRMON)" ).append("\n"); 
		query.append("                                                  FROM GL_MON_XCH_RT" ).append("\n"); 
		query.append("                                                 WHERE 1 = 1" ).append("\n"); 
		query.append("                                                       AND ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                                                       AND CURR_CD = G.CURR_CD" ).append("\n"); 
		query.append("                                                       AND ACCT_XCH_RT_YRMON <= TO_CHAR(X.EFF_DT, 'YYYYMM')" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("                       AND ACCT_XCH_RT_LVL = '1'" ).append("\n"); 
		query.append("                       AND CURR_CD = G.CURR_CD              " ).append("\n"); 
		query.append("               ) CUR_RT_AMT" ).append("\n"); 
		query.append("          FROM PRI_RP_SCP_TRSP_ADD_CHG G," ).append("\n"); 
		query.append("               (SELECT PROP_NO," ).append("\n"); 
		query.append("                       AMDT_SEQ," ).append("\n"); 
		query.append("                       SVC_SCP_CD," ).append("\n"); 
		query.append("                       ADD_CHG_TP_CD," ).append("\n"); 
		query.append("                       ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                       ADD_CHG_SEQ," ).append("\n"); 
		query.append("                       REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 1) FIC_RT_USE_STS_CD," ).append("\n"); 
		query.append("                       REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 2) FIC_ROUT_CMB_TP_CD," ).append("\n"); 
		query.append("                       REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 3) OPTM_TRSP_MOD_FLG," ).append("\n"); 
		query.append("                       TRIM(REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 4)) FIC_GLINE_RT_AMT," ).append("\n"); 
		query.append("                       TRIM(REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 5)) FIC_LOCL_CURR_CD," ).append("\n"); 
		query.append("                       TRIM(REGEXP_SUBSTR(FIC_RT_USE_STS_CD, '[^|]+', 1, 6)) FIC_GLINE_LOCL_RT_AMT," ).append("\n"); 
		query.append("                       TO_CHAR(SYSDATE, 'YYYYMMDD') FIC_GLINE_UPD_DT," ).append("\n"); 
		query.append("                       EFF_DT" ).append("\n"); 
		query.append("                  FROM (SELECT B.EFF_DT," ).append("\n"); 
		query.append("                               A.PROP_NO," ).append("\n"); 
		query.append("                               A.AMDT_SEQ," ).append("\n"); 
		query.append("                               A.SVC_SCP_CD," ).append("\n"); 
		query.append("                               A.ADD_CHG_TP_CD," ).append("\n"); 
		query.append("                               A.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                               A.ADD_CHG_SEQ," ).append("\n"); 
		query.append("#if(${add_on_flag} == 'Y')                   " ).append("\n"); 
		query.append("                               PRI_ADDON_RATE_CALCULATE_PKG.PRI_getFICArbRateByRoute_FNC(TO_CHAR(B.EFF_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("                                                                                         A.SVC_SCP_CD," ).append("\n"); 
		query.append("                                                                                         A.ORG_DEST_TP_CD," ).append("\n"); 
		query.append("                                                                                         A.ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                                                                                         A.BSE_PORT_DEF_CD," ).append("\n"); 
		query.append("                                                                                         A.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                                                                                         A.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("                                                                                         NVL(A.RAT_UT_CD,'D2')," ).append("\n"); 
		query.append("                                                                                         NVL(A.PRC_CGO_TP_CD,'RF')) FIC_RT_USE_STS_CD," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                               PRI_FIC_RATE_CALCULATE_PKG.PRI_getFICArbRateByRoute_FNC(TO_CHAR(B.EFF_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("                                                                                         A.SVC_SCP_CD," ).append("\n"); 
		query.append("                                                                                         A.ROUT_PNT_LOC_DEF_CD," ).append("\n"); 
		query.append("                                                                                         A.BSE_PORT_DEF_CD," ).append("\n"); 
		query.append("                                                                                         A.RCV_DE_TERM_CD," ).append("\n"); 
		query.append("                                                                                         A.PRC_TRSP_MOD_CD," ).append("\n"); 
		query.append("                                                                                         NVL(A.RAT_UT_CD,'D2')," ).append("\n"); 
		query.append("                                                                                         NVL(A.PRC_CGO_TP_CD,'RF')) FIC_RT_USE_STS_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                               'A' AS CD" ).append("\n"); 
		query.append("                          FROM PRI_RP_SCP_TRSP_ADD_CHG A, PRI_RP_MN B" ).append("\n"); 
		query.append("                         WHERE A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("                           AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("                           AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("                           AND A.SVC_SCP_CD NOT IN (" ).append("\n"); 
		query.append("                               #foreach( ${v} in ${v_param}) " ).append("\n"); 
		query.append("                                     #if($velocityCount != 1) " ).append("\n"); 
		query.append("                                     ," ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                     '$v'" ).append("\n"); 
		query.append("                               #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT SYSDATE,'', 0, '', '', '', 0, '', 'B' FROM DUAL)" ).append("\n"); 
		query.append("                 WHERE CD = 'A') X" ).append("\n"); 
		query.append("         WHERE G.PROP_NO = X.PROP_NO" ).append("\n"); 
		query.append("           AND G.AMDT_SEQ = X.AMDT_SEQ" ).append("\n"); 
		query.append("           AND G.SVC_SCP_CD = X.SVC_SCP_CD" ).append("\n"); 
		query.append("           AND G.ADD_CHG_TP_CD = X.ADD_CHG_TP_CD" ).append("\n"); 
		query.append("           AND G.ORG_DEST_TP_CD = X.ORG_DEST_TP_CD" ).append("\n"); 
		query.append("           AND G.ADD_CHG_SEQ = X.ADD_CHG_SEQ)" ).append("\n"); 
		query.append("   SET FIC_GLINE_RT_AMT = (CASE WHEN CURR_CD = 'USD' THEN GLINE_RT_AMT " ).append("\n"); 
		query.append("                                WHEN CURR_CD = FIC_LOCL_CURR_CD THEN FIC_GLINE_LOCL_RT_AMT ELSE ''||CUR_RT_AMT END)" ).append("\n"); 
		query.append("   , FIC_GLINE_UPD_DT = DECODE(NVL(GLINE_RT_AMT, 1), 1, NULL, SYSDATE) " ).append("\n"); 
		query.append("   , OPTM_TRSP_MOD_FLG = TRSP_MOD_FLG" ).append("\n"); 
		query.append("   , FIC_ROUT_CMB_TP_CD = ROUT_CMB_TP_CD" ).append("\n"); 
		query.append("   , FIC_RT_USE_STS_CD = RT_USE_STS_CD" ).append("\n"); 

	}
}