/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivalbeAgentDBDAOsearchUnreportedOtsReportListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivalbeAgentDBDAOsearchUnreportedOtsReportListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unreported OTS Report  Inquiry
	  * </pre>
	  */
	public AccountReceivalbeAgentDBDAOsearchUnreportedOtsReportListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivalbeAgentDBDAOsearchUnreportedOtsReportListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("ACT.AR_OFC_CD       OFC_CD," ).append("\n"); 
		query.append("ACT.VVD_CD          VVD_CD,       " ).append("\n"); 
		query.append("ACT.BL_NO           BL_NO," ).append("\n"); 
		query.append("ACT.SAIL_ARR_DT     SAIL_ARR_DT," ).append("\n"); 
		query.append("ACT.DUE_DT          DUE_DT," ).append("\n"); 
		query.append("ACT.ACT_USD         ACT_USD," ).append("\n"); 
		query.append("ASA.ASA_USD         ASA_USD," ).append("\n"); 
		query.append("NVL(ACT.ACT_USD, 0) " ).append("\n"); 
		query.append("  - NVL(ASA_USD, 0) TOBE_USD" ).append("\n"); 
		query.append(",'' AR_OFC_CD" ).append("\n"); 
		query.append(",'' ASA_NO1" ).append("\n"); 
		query.append(",'' ASA_NO2" ).append("\n"); 
		query.append(",'' ASA_NO3" ).append("\n"); 
		query.append(",'' DUE_DT_FM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT   ACF.BL_NO " ).append("\n"); 
		query.append("               , ROUND(SUM(NVL(ACF.USD_AMT, 0) + NVL( (ACF.LOCL_AMT + NVL(ACF.EQV_LOCL_AMT2, 0) ) * DECODE(MMO.AR_CURR_CD, 'USD', 1, SAR_GET_GL_XCH_RT_FNC('1',TO_CHAR(SYSDATE,'YYYYMMDD'),MMO.AR_CURR_CD,'USD')) , 0)), 2)  ASA_USD" ).append("\n"); 
		query.append("        FROM SAR_AGN_CLT_RFND_MST ACF" ).append("\n"); 
		query.append("            ,MDM_ORGANIZATION MMO" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND ACF.AR_OFC_CD   = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        AND ACF.ASA_NO      = @[asa_no1]||@[asa_no2]||@[asa_no3]" ).append("\n"); 
		query.append("        AND ACF.AR_OFC_CD   = MMO.OFC_CD" ).append("\n"); 
		query.append("        GROUP BY ACF.BL_NO" ).append("\n"); 
		query.append("        ) ASA, " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("         SOH.BL_NO                                                      BL_NO                        " ).append("\n"); 
		query.append("        ,SOH.OTS_OFC_CD                                                 AR_OFC_CD  " ).append("\n"); 
		query.append("        ,SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD                        VVD_CD" ).append("\n"); 
		query.append("        ,SOH.SAIL_ARR_DT                                                SAIL_ARR_DT" ).append("\n"); 
		query.append("        ,SOH.DUE_DT                                                     DUE_DT" ).append("\n"); 
		query.append("        ,ROUND( SHD.USD_AMT +  ( SHD.LOCL_AMT +  SHD.N3RD_AMT ) * DECODE(SOH.OFC_CURR_CD ,'USD',1, SAR_GET_GL_XCH_RT_FNC('1',TO_CHAR(SYSDATE,'YYYYMMDD'),OFC_CURR_CD,'USD')),2) ACT_USD" ).append("\n"); 
		query.append("        FROM SAR_OTS_HDR   SOH," ).append("\n"); 
		query.append("                 (   SELECT  " ).append("\n"); 
		query.append("                     SOH.BL_NO                                                      BL_NO                        " ).append("\n"); 
		query.append("                    ,SOH.OTS_OFC_CD                                                 AR_OFC_CD      " ).append("\n"); 
		query.append("                    ,SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_AMT,0),0))                                     USD_AMT         " ).append("\n"); 
		query.append("                    ,SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,SOD.BAL_AMT),0))                     LOCL_AMT        " ).append("\n"); 
		query.append("                    ,SUM(NVL(ROUND(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,0, SOD.BAL_AMT)" ).append("\n"); 
		query.append("                           * ROUND(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,0, SOD.LOCL_XCH_RT),6),2),0))                  N3RD_AMT " ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                    FROM SAR_OTS_HDR   SOH, " ).append("\n"); 
		query.append("                         SAR_OTS_DTL   SOD" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND SOH.RHQ_CD              = SOD.RHQ_CD" ).append("\n"); 
		query.append("                    AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("                    AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("                    AND SOH.INV_NO              = SOD.INV_NO" ).append("\n"); 
		query.append("                    GROUP BY SOH.OTS_OFC_CD, SOH.BL_NO" ).append("\n"); 
		query.append("                    HAVING   SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_AMT,0),0)) <> 0" ).append("\n"); 
		query.append("                          OR SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,SOD.BAL_AMT),0)) <> 0" ).append("\n"); 
		query.append("                          OR SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,0, SOD.BAL_AMT),0)) <> 0" ).append("\n"); 
		query.append("                ) SHD" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND SOH.OTS_OFC_CD          = SHD.AR_OFC_CD" ).append("\n"); 
		query.append("            AND SOH.BL_NO               = SHD.BL_NO " ).append("\n"); 
		query.append("            AND SOH.REV_TP_SRC_CD != 'ASA'" ).append("\n"); 
		query.append("            AND SOH.OTS_OFC_CD          = @[ar_ofc_cd]" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            #if ( ${due_dt_fm} != '' )" ).append("\n"); 
		query.append("                 AND SOH.DUE_DT <=  REPLACE(@[due_dt_fm],'-','')       " ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            ) ACT" ).append("\n"); 
		query.append("WHERE ACT.BL_NO = ASA.BL_NO(+)" ).append("\n"); 
		query.append("  AND NVL(ACT.ACT_USD,0) > NVL(ASA.ASA_USD,0)" ).append("\n"); 

	}
}