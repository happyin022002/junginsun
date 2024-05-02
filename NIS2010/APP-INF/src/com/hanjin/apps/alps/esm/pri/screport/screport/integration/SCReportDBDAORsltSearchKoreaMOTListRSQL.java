/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SCReportDBDAORsltSearchKoreaMOTListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchKoreaMOTListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Korea MOT
	  * </pre>
	  */
	public SCReportDBDAORsltSearchKoreaMOTListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchKoreaMOTListRSQL").append("\n"); 
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
		query.append("SELECT CTRT_TYPE 			AS CTRT_TYPE" ).append("\n"); 
		query.append("     , CTRT_NO 				AS CTRT_NO" ).append("\n"); 
		query.append("     , PROP_NO 				AS PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ				AS AMDT_SEQ" ).append("\n"); 
		query.append("     , CUST_NM 				AS CUST_NM" ).append("\n"); 
		query.append("     , PROP_OFC_CD 			AS PROP_OFC_CD" ).append("\n"); 
		query.append("     , PROP_APRO_OFC_CD 	AS PROP_APRO_OFC_cD" ).append("\n"); 
		query.append("     , CTRT_EFF_DT 			AS CTRT_EFF_DT" ).append("\n"); 
		query.append("     , CTRT_EXP_DT 			AS CTRT_EXP_DT" ).append("\n"); 
		query.append("	 , AMDT_EFF_DT 			AS AMDT_EFF_DT" ).append("\n"); 
		query.append("     , PROP_STS_CD 			AS PROP_STS_CD" ).append("\n"); 
		query.append("     , FILE_APRO_DT 		AS FILE_APRO_DT" ).append("\n"); 
		query.append("     , '' AS DATE_BY" ).append("\n"); 
		query.append("     , '' AS F_EFF_DT" ).append("\n"); 
		query.append("     , '' AS F_EXP_DT" ).append("\n"); 
		query.append("     , '' AS APVL_OFC" ).append("\n"); 
		query.append("     , '' AS F_CTRT_TP" ).append("\n"); 
		query.append("     , '' AS F_CTRT_TP_R" ).append("\n"); 
		query.append("     , '' AS F_CTRT_TP_S" ).append("\n"); 
		query.append("	 , '' AS IBFLAG" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("(SELECT 'RFA'                					    AS CTRT_TYPE" ).append("\n"); 
		query.append("     , RFA_NO                   					AS CTRT_NO" ).append("\n"); 
		query.append("     , MN.PROP_NO               					AS PROP_NO" ).append("\n"); 
		query.append("     , MN.AMDT_SEQ              					AS AMDT_SEQ" ).append("\n"); 
		query.append("     , CUST.CUST_LGL_ENG_NM				 			AS CUST_NM" ).append("\n"); 
		query.append("     , PROP_OFC_CD									AS PROP_OFC_CD" ).append("\n"); 
		query.append("     , PROP_APRO_OFC_CD								AS PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(DUR.CTRT_EFF_DT, 'YYYY-MM-DD') 		AS CTRT_EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(DUR.CTRT_EXP_DT, 'YYYY-MM-DD') 		AS CTRT_EXP_DT" ).append("\n"); 
		query.append("     , TO_CHAR(MN.EFF_DT, 'YYYY-MM-DD')				AS AMDT_EFF_DT" ).append("\n"); 
		query.append("     , DECODE(MN.PROP_STS_CD,'A','Approved')		AS PROP_STS_CD" ).append("\n"); 
		query.append("     , TO_CHAR(PROP_APRO_DT,'YYYY-MM-DD')			AS FILE_APRO_DT" ).append("\n"); 
		query.append("  FROM PRI_RP_HDR HDR" ).append("\n"); 
		query.append("      ,PRI_RP_MN MN" ).append("\n"); 
		query.append("      ,PRI_RP_DUR DUR" ).append("\n"); 
		query.append("      ,MDM_CUSTOMER CUST" ).append("\n"); 
		query.append("      ,COM_INTG_CD_DTL STS_CD" ).append("\n"); 
		query.append(" WHERE MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("   AND MN.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("   AND MN.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("   AND CUST.CUST_CNT_CD        = MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("   AND CUST.CUST_SEQ           = MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("   AND CUST.CNTR_DIV_FLG 	   = 'Y' " ).append("\n"); 
		query.append("   AND STS_CD.INTG_CD_ID = 'CD01722'" ).append("\n"); 
		query.append("   AND STS_CD.INTG_CD_VAL_CTNT = MN.PROP_STS_CD" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- 기본 조건" ).append("\n"); 
		query.append("   AND CTRT_EXP_DT - CTRT_EFF_DT >= 90 -- 계약기간 90일 이상인 것만" ).append("\n"); 
		query.append("   AND MN.PROP_STS_CD = 'A' -- Approved" ).append("\n"); 
		query.append("   AND DUR.PRC_PROG_STS_CD = 'A' --Approved" ).append("\n"); 
		query.append("   AND RFA_CTRT_TP_CD IN ('C', 'S', 'B') -- RFA Type 조건" ).append("\n"); 
		query.append("   AND PROP_OFC_CD IN ('SELSC', 'PUSSC', 'PUSBS') -- R.OFC 조건" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- Date by" ).append("\n"); 
		query.append("#if( ${date_by} != '2')" ).append("\n"); 
		query.append("  AND PROP_APRO_DT BETWEEN TO_DATE(@[f_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[f_exp_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND MN.EFF_DT              <= TO_DATE(@[f_exp_dt], 'YYYY-MM-DD') -- Effective Date(To)" ).append("\n"); 
		query.append("  AND MN.EXP_DT              >= TO_DATE(@[f_eff_dt], 'YYYY-MM-DD') -- Effective Date(From)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- Apvl Ofc" ).append("\n"); 
		query.append("#if( ${apvl_ofc} != '' )" ).append("\n"); 
		query.append("  AND PROP_APRO_OFC_CD = @[apvl_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${f_ctrt_tp_r} != 'RFA')" ).append("\n"); 
		query.append("  AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'SC'													AS CTRT_TYPE" ).append("\n"); 
		query.append("     , SH.SC_NO                   							AS CTRT_NO" ).append("\n"); 
		query.append("     , SM.PROP_NO               							AS PROP_NO" ).append("\n"); 
		query.append("     , SM.AMDT_SEQ              							AS AMDT_SEQ" ).append("\n"); 
		query.append("     , SP.CTRT_PTY_NM	 									AS CUST_NM" ).append("\n"); 
		query.append("     , SM.PROP_OFC_CD 										AS PROP_OFC_CD" ).append("\n"); 
		query.append("     , SM.PROP_APRO_OFC_CD 									AS PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("     , TO_CHAR(DUR.CTRT_EFF_DT, 'YYYY-MM-DD') 				AS CTRT_EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(DUR.CTRT_EXP_DT, 'YYYY-MM-DD') 				AS CTRT_EXP_DT" ).append("\n"); 
		query.append("     , TO_CHAR(SM.EFF_DT, 'YYYY-MM-DD')						AS AMDT_EFF_DT" ).append("\n"); 
		query.append("     , DECODE(SM.PROP_STS_CD,'F','Filed')					AS PROP_STS_CD" ).append("\n"); 
		query.append("     , TO_CHAR(SM.FILE_DT, 'YYYY-MM-DD')					AS FILE_APRO_DT" ).append("\n"); 
		query.append("  FROM PRI_SP_MN SM," ).append("\n"); 
		query.append("       PRI_SP_HDR SH," ).append("\n"); 
		query.append("       PRI_SP_CTRT_PTY SP," ).append("\n"); 
		query.append("       PRI_SP_DUR DUR" ).append("\n"); 
		query.append(" WHERE SM.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("   AND SM.PROP_NO = SP.PROP_NO" ).append("\n"); 
		query.append("   AND SM.AMDT_SEQ = SP.AMDT_SEQ" ).append("\n"); 
		query.append("   AND SM.PROP_NO = DUR.PROP_NO" ).append("\n"); 
		query.append("   AND SM.AMDT_SEQ = DUR.AMDT_SEQ" ).append("\n"); 
		query.append("   AND SP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- 기본 조건" ).append("\n"); 
		query.append("   AND CTRT_EXP_DT - CTRT_EFF_DT >= 90 -- 계약기간 90일 이상인 것만" ).append("\n"); 
		query.append("   AND SM.PROP_STS_CD = 'F' -- Filed" ).append("\n"); 
		query.append("   AND PROP_OFC_CD IN ('SELSC', 'PUSSC', 'PUSBS')  -- R.OFC 조건" ).append("\n"); 
		query.append("-----------------------------------------------------------------------------" ).append("\n"); 
		query.append("-- Date by" ).append("\n"); 
		query.append("#if( ${date_by} != '2')" ).append("\n"); 
		query.append("  AND SM.FILE_DT BETWEEN TO_DATE(@[f_eff_dt],'YYYY-MM-DD') AND TO_DATE(@[f_exp_dt],'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND SM.EFF_DT              <= TO_DATE(@[f_exp_dt], 'YYYY-MM-DD') -- Effective Date(To)" ).append("\n"); 
		query.append("  AND SM.EXP_DT              >= TO_DATE(@[f_eff_dt], 'YYYY-MM-DD') -- Effective Date(From)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- Apvl Ofc" ).append("\n"); 
		query.append("#if( ${apvl_ofc} != '' )" ).append("\n"); 
		query.append("  AND SM.PROP_APRO_OFC_CD = @[apvl_ofc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if( ${f_ctrt_tp_s} != 'SC')" ).append("\n"); 
		query.append("  AND 1=2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}