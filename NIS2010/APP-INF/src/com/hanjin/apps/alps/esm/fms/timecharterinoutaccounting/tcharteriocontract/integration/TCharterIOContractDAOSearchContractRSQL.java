/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TCharterIOContractDAOSearchContractRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOSearchContractRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOContractDAOSearchContractRSQL
	  * </pre>
	  */
	public TCharterIOContractDAOSearchContractRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOSearchContractRSQL").append("\n"); 
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
		query.append("SELECT FLET_CTRT_NO," ).append("\n"); 
		query.append("	   VSL_CD," ).append("\n"); 
		query.append("	   VSL_ENG_NM," ).append("\n"); 
		query.append("	   FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("	   VNDR_SEQ," ).append("\n"); 
		query.append("	   CUST_CNT_CD," ).append("\n"); 
		query.append("	   CUST_SEQ," ).append("\n"); 
		query.append("	   VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("	   OWNR_NM," ).append("\n"); 
		query.append("	   VSL_CNT_CD," ).append("\n"); 
		query.append("	   CNT_NM," ).append("\n"); 
		query.append("	   FLET_CTRT_FACT_CD," ).append("\n"); 
		query.append("	   CP_DT," ).append("\n"); 
		query.append("	   EFF_DT," ).append("\n"); 
		query.append("	   FROM_TIME," ).append("\n"); 
		query.append("	   EXP_DT," ).append("\n"); 
		query.append("	   TO_TIME," ).append("\n"); 
		query.append("	   DECL_FLG," ).append("\n"); 
		query.append("	   ACMM_RT_AMT," ).append("\n"); 
		query.append("	   FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("	   FLET_OLAY_COMM_RT_AMT," ).append("\n"); 
		query.append("	   OA_RSV_AMT," ).append("\n"); 
		query.append("	   OA_RSV_CURR_CD," ).append("\n"); 
		query.append("	   ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("	   ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("	   ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("	   ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("	   FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("	   DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("	   FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("	   DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("	   VSL_BLD_DT," ).append("\n"); 
		query.append("	   VSL_DZND_CAPA," ).append("\n"); 
		query.append("	   BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("	   DDWT_CGO_CAPA_QTY," ).append("\n"); 
		query.append("	   GRS_WGT," ).append("\n"); 
		query.append("	   NRT_WGT," ).append("\n"); 
		query.append("	   CHTR_PRD_OPT_CTNT," ).append("\n"); 
		query.append("	   RDE_RNG_CTNT," ).append("\n"); 
		query.append("	   RDE_NTC_CTNT," ).append("\n"); 
		query.append("	   RF_CNTR_PLG_QTY," ).append("\n"); 
		query.append("	   GR_FLG," ).append("\n"); 
		query.append("	   SHP_SPD_QTY," ).append("\n"); 
		query.append("	   FLET_GMT_LMT_CD," ).append("\n"); 
		query.append("	   BOD_PORT_CD," ).append("\n"); 
		query.append("	   BOR_PORT_CD," ).append("\n"); 
		query.append("  	   AGMT_DOC_NO,		-- GW 문서 번호 " ).append("\n"); 
		query.append(" 	   AGMT_DOC_DESC,	-- GW 문서 명" ).append("\n"); 
		query.append("	   ACT_LOW_SULP_FOIL_BOD_QTY," ).append("\n"); 
		query.append("       ACT_LOW_SULP_GAS_OIL_BOD_QTY," ).append("\n"); 
		query.append("       ACT_LOW_SULP_FOIL_BOR_QTY," ).append("\n"); 
		query.append("       ACT_LOW_SULP_GAS_OIL_BOR_QTY," ).append("\n"); 
		query.append("       LOW_SULP_FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("       LOW_SULP_GAS_OIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("       LOW_SULP_FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("       LOW_SULP_GAS_OIL_BOR_OUT_PRC" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("		SELECT " ).append("\n"); 
		query.append("				FLET_CTRT_NO," ).append("\n"); 
		query.append("				VSL_CD," ).append("\n"); 
		query.append("				(SELECT VSL_ENG_NM " ).append("\n"); 
		query.append("				   FROM MDM_VSL_CNTR " ).append("\n"); 
		query.append("                  WHERE VSL_CD = FC.VSL_CD " ).append("\n"); 
		query.append("                    AND ROWNUM =1) VSL_ENG_NM," ).append("\n"); 
		query.append("				FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("				VNDR_SEQ," ).append("\n"); 
		query.append("				CUST_CNT_CD," ).append("\n"); 
		query.append("				CUST_SEQ," ).append("\n"); 
		query.append("				CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("						  (SELECT MV.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("							 FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("							WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("							  AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("							  AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("							  AND ROWNUM =1)" ).append("\n"); 
		query.append("				 ELSE " ).append("\n"); 
		query.append("					(SELECT MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("					  FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("					 WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("					   AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("				  	   AND ROWNUM =1)" ).append("\n"); 
		query.append("			    END VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                CASE WHEN FC.OWNR_SEQ IS NULL THEN" ).append("\n"); 
		query.append("                   (        " ).append("\n"); 
		query.append("                      CASE WHEN FC.FLET_CTRT_TP_CD = 'TO' THEN" ).append("\n"); 
		query.append("                        (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                         FROM MDM_CUSTOMER MV, FMS_OWNER FO" ).append("\n"); 
		query.append("                         WHERE CUST_CNT_CD = FC.CUST_CNT_CD" ).append("\n"); 
		query.append("                         AND CUST_SEQ = FC.CUST_SEQ" ).append("\n"); 
		query.append("                         AND MV.FLET_MGMT_OWNR_CUST_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                         AND ROWNUM =1)" ).append("\n"); 
		query.append("                     ELSE" ).append("\n"); 
		query.append("                        (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                         FROM MDM_VENDOR MV, FMS_OWNER FO" ).append("\n"); 
		query.append("                         WHERE VNDR_SEQ = FC.VNDR_SEQ" ).append("\n"); 
		query.append("                         AND MV.FLET_MGMT_OWNR_VNDR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                         AND ROWNUM =1)" ).append("\n"); 
		query.append("                    END )        " ).append("\n"); 
		query.append("                ELSE  " ).append("\n"); 
		query.append("                  (SELECT FO.OWNR_NM" ).append("\n"); 
		query.append("                   FROM FMS_OWNER FO" ).append("\n"); 
		query.append("                   WHERE FC.OWNR_SEQ = FO.OWNR_SEQ" ).append("\n"); 
		query.append("                   AND ROWNUM =1)" ).append("\n"); 
		query.append("                END OWNR_NM," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				VSL_CNT_CD," ).append("\n"); 
		query.append("				(SELECT CNT_NM FROM MDM_COUNTRY WHERE CNT_CD = FC.VSL_CNT_CD) CNT_NM," ).append("\n"); 
		query.append("				FLET_CTRT_FACT_CD," ).append("\n"); 
		query.append("				DECODE(CP_DT,NULL,CP_DT,SUBSTR(CP_DT,1,4) || '-' || SUBSTR(CP_DT,5,2) || '-' || SUBSTR(CP_DT,7,2)) CP_DT," ).append("\n"); 
		query.append("				TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("				TO_CHAR(EFF_DT,'HH24:MI') FROM_TIME," ).append("\n"); 
		query.append("				TO_CHAR(EXP_DT,'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("				TO_CHAR(EXP_DT,'HH24:MI') TO_TIME," ).append("\n"); 
		query.append("				DECL_FLG," ).append("\n"); 
		query.append("				TO_CHAR(ACMM_RT_AMT,'FM999,999,999,999.00') ACMM_RT_AMT," ).append("\n"); 
		query.append("				TO_CHAR(FLET_BROG_RT_AMT,'FM999,999,999,999.00') FLET_BROG_RT_AMT," ).append("\n"); 
		query.append("				TO_CHAR(FLET_OLAY_COMM_RT_AMT,'FM999,999,999,999.00') FLET_OLAY_COMM_RT_AMT," ).append("\n"); 
		query.append("				TO_CHAR(OA_RSV_AMT,'FM999,999,999,999.00') OA_RSV_AMT," ).append("\n"); 
		query.append("				OA_RSV_CURR_CD," ).append("\n"); 
		query.append("				TO_CHAR(ACT_FOIL_BOD_QTY,'FM999,999,990.000') ACT_FOIL_BOD_QTY," ).append("\n"); 
		query.append("				TO_CHAR(ACT_DOIL_BOD_QTY,'FM999,999,990.000') ACT_DOIL_BOD_QTY," ).append("\n"); 
		query.append("				TO_CHAR(ACT_FOIL_BOR_QTY,'FM999,999,990.000') ACT_FOIL_BOR_QTY," ).append("\n"); 
		query.append("				TO_CHAR(ACT_DOIL_BOR_QTY,'FM999,999,990.000') ACT_DOIL_BOR_QTY," ).append("\n"); 
		query.append("				TO_CHAR(FOIL_BOD_OUT_PRC,'FM999,999,999,990.00') FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				TO_CHAR(DOIL_BOD_OUT_PRC,'FM999,999,999,990.00') DOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("				TO_CHAR(FOIL_BOR_OUT_PRC,'FM999,999,999,990.00') FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				TO_CHAR(DOIL_BOR_OUT_PRC,'FM999,999,999,990.00') DOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("				DECODE(VSL_BLD_DT,NULL,VSL_BLD_DT,SUBSTR(VSL_BLD_DT,1,4) || '-' || SUBSTR(VSL_BLD_DT,5,2) || '-' || SUBSTR(VSL_BLD_DT,7,2)) VSL_BLD_DT," ).append("\n"); 
		query.append("				VSL_DZND_CAPA," ).append("\n"); 
		query.append("				BSE_14TON_VSL_CAPA," ).append("\n"); 
		query.append("				TO_CHAR(DDWT_CGO_CAPA_QTY,'FM999,990.00') DDWT_CGO_CAPA_QTY," ).append("\n"); 
		query.append("				GRS_WGT," ).append("\n"); 
		query.append("				NRT_WGT," ).append("\n"); 
		query.append("				CHTR_PRD_OPT_CTNT," ).append("\n"); 
		query.append("				RDE_RNG_CTNT," ).append("\n"); 
		query.append("				RDE_NTC_CTNT," ).append("\n"); 
		query.append("				RF_CNTR_PLG_QTY," ).append("\n"); 
		query.append("				GR_FLG," ).append("\n"); 
		query.append("				TO_CHAR(SHP_SPD_QTY,'FM999,990.00') SHP_SPD_QTY," ).append("\n"); 
		query.append("				FLET_GMT_LMT_CD," ).append("\n"); 
		query.append("				BOD_PORT_CD," ).append("\n"); 
		query.append("				BOR_PORT_CD," ).append("\n"); 
		query.append("				AGMT_DOC_NO,		-- GW 문서 번호 " ).append("\n"); 
		query.append("				AGMT_DOC_DESC,		-- GW 문서 명" ).append("\n"); 
		query.append("      			TO_CHAR(ACT_LOW_SULP_FOIL_BOD_QTY,'FM999,999,990.000') ACT_LOW_SULP_FOIL_BOD_QTY," ).append("\n"); 
		query.append("    			TO_CHAR(ACT_LOW_SULP_GAS_OIL_BOD_QTY,'FM999,999,990.000') ACT_LOW_SULP_GAS_OIL_BOD_QTY," ).append("\n"); 
		query.append("      			TO_CHAR(ACT_LOW_SULP_FOIL_BOR_QTY,'FM999,999,990.000') ACT_LOW_SULP_FOIL_BOR_QTY," ).append("\n"); 
		query.append("     		    TO_CHAR(ACT_LOW_SULP_GAS_OIL_BOR_QTY,'FM999,999,990.000') ACT_LOW_SULP_GAS_OIL_BOR_QTY," ).append("\n"); 
		query.append("     			TO_CHAR(LOW_SULP_FOIL_BOD_OUT_PRC,'FM999,999,999,990.00') LOW_SULP_FOIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("       			TO_CHAR(LOW_SULP_GAS_OIL_BOD_OUT_PRC,'FM999,999,999,990.00') LOW_SULP_GAS_OIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("       			TO_CHAR(LOW_SULP_FOIL_BOR_OUT_PRC,'FM999,999,999,990.00') LOW_SULP_FOIL_BOR_OUT_PRC," ).append("\n"); 
		query.append("       			TO_CHAR(LOW_SULP_GAS_OIL_BOR_OUT_PRC,'FM999,999,999,990.00') LOW_SULP_GAS_OIL_BOR_OUT_PRC" ).append("\n"); 
		query.append("		  FROM  FMS_CONTRACT FC" ).append("\n"); 
		query.append("		 WHERE  FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("	   )" ).append("\n"); 

	}
}