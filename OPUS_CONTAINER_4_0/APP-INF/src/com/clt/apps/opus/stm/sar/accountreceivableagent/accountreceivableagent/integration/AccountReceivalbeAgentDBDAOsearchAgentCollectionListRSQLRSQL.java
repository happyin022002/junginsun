/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivalbeAgentDBDAOsearchAgentCollectionListRSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16 
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

public class AccountReceivalbeAgentDBDAOsearchAgentCollectionListRSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent Collection List Inquiry
	  * </pre>
	  */
	public AccountReceivalbeAgentDBDAOsearchAgentCollectionListRSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("asa_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("due_dt_to",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AccountReceivalbeAgentDBDAOsearchAgentCollectionListRSQLRSQL").append("\n"); 
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
		query.append(" ASA_NO         ,BL_NO      ,INV_NO  ,CHG_TP_CD      ,ASA_CLT_SEQ     , AR_OFC_CD" ).append("\n"); 
		query.append(",VVD_CD         ,PORT_CD                    ,DECODE(SUM(USD_AMT),0,0,MAX(ASA_XCH_RT1)) ASA_XCH_RT1     ,@[asa_curr_cd] ASA_CURR_CD" ).append("\n"); 
		query.append(",ASA_XCH_RT2    ,ASA_RMK    ,AGN_CD         ,SVC_SCP_CD      ,EFF_DT" ).append("\n"); 
		query.append(",IB_OB_CD       ,MAX(GL_YRMON) GL_YRMON   ,@[asa_curr_cd] LOCL_CURR_CD   ,SAIL_ARR_DT     ,DUE_DT" ).append("\n"); 
		query.append(",CASE WHEN SUM(TTL_AMT) >= 0 THEN 'C' ELSE 'R'  END  ASA_TP_CD" ).append("\n"); 
		query.append(",SUM(TTL_AMT) TTL_AMT" ).append("\n"); 
		query.append(",SUM(USD_AMT) USD_AMT" ).append("\n"); 
		query.append(",SUM(CHG_USD_AMT) CHG_USD_AMT" ).append("\n"); 
		query.append(",SUM(EQV_LOCL_AMT) EQV_LOCL_AMT" ).append("\n"); 
		query.append(",SUM(LOCL_AMT) LOCL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",MIN (DECODE (RN, 1, N3RD_CURR_CD)) N3RD_CURR_CD1  ,MIN (DECODE (RN, 1, N3RD_AMT)) N3RD_AMT1 ,MIN (DECODE (RN, 1, N3RD_XCH_RT)) N3RD_XCH_RT1 ,MIN (DECODE (RN, 1, N3RD_LOCL_AMT)) N3RD_LOCL_AMT1" ).append("\n"); 
		query.append(",MIN (DECODE (RN, 2, N3RD_CURR_CD)) N3RD_CURR_CD2  ,MIN (DECODE (RN, 2, N3RD_AMT)) N3RD_AMT2 ,MIN (DECODE (RN, 2, N3RD_XCH_RT)) N3RD_XCH_RT2 ,MIN (DECODE (RN, 2, N3RD_LOCL_AMT)) N3RD_LOCL_AMT2" ).append("\n"); 
		query.append(",MIN (DECODE (RN, 3, N3RD_CURR_CD)) N3RD_CURR_CD3  ,MIN (DECODE (RN, 3, N3RD_AMT)) N3RD_AMT3 ,MIN (DECODE (RN, 3, N3RD_XCH_RT)) N3RD_XCH_RT3 ,MIN (DECODE (RN, 3, N3RD_LOCL_AMT)) N3RD_LOCL_AMT3" ).append("\n"); 
		query.append(",MIN (DECODE (RN, 4, N3RD_CURR_CD)) N3RD_CURR_CD4  ,MIN (DECODE (RN, 4, N3RD_AMT)) N3RD_AMT4 ,MIN (DECODE (RN, 4, N3RD_XCH_RT)) N3RD_XCH_RT4 ,MIN (DECODE (RN, 4, N3RD_LOCL_AMT)) N3RD_LOCL_AMT4" ).append("\n"); 
		query.append(",SUM(N3RD_LOCL_AMT) EQV_LOCL_AMT2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' OPTION1      ,'' OPTION2        ,'' ASA_NO1      ,'' ASA_NO2      ,'' ASA_NO3" ).append("\n"); 
		query.append(",'' BND          ,'' GL_YRMON_FM	,'' GL_YRMON_TO	 ,'' DUE_DT_FM	  ,'' DUE_DT_TO" ).append("\n"); 
		query.append(",@[usr_id] AS USR_ID" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("@[asa_no1]||@[asa_no2]||@[asa_no3]                              ASA_NO           " ).append("\n"); 
		query.append(",SOH.BL_NO                                                      BL_NO                        " ).append("\n"); 
		query.append(",SOH.INV_NO                                                     INV_NO                        " ).append("\n"); 
		query.append(",SOD.CHG_TP_CD                                                  CHG_TP_CD " ).append("\n"); 
		query.append(",''                                                             ASA_CLT_SEQ" ).append("\n"); 
		query.append(",SOH.OTS_OFC_CD                                                 AR_OFC_CD      " ).append("\n"); 
		query.append(",SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD                        VVD_CD     " ).append("\n"); 
		query.append(",DECODE(SOH.BKG_IO_BND_CD, 'O', SOH.POL_CD, 'I', SOH.POD_CD)    PORT_CD  " ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(SOH.DUE_DT,'YYYYMMDD'),'YYYY-MM-DD')           DUE_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" --ar_currency_code      SOH.OFC_CURR_CD" ).append("\n"); 
		query.append(" --invoice_currency_code SOD.BL_CURR_CD " ).append("\n"); 
		query.append(",CASE WHEN TP.TTL_AMT >= 0 THEN 'C' ELSE 'R' END                ASA_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NVL(DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_LOCL_AMT,0),0) " ).append("\n"); 
		query.append("+ " ).append("\n"); 
		query.append("NVL(DECODE(SOD.BL_CURR_CD, 'USD',0,SOH.OFC_CURR_CD,SOD.BAL_LOCL_AMT),0)                                                    " ).append("\n"); 
		query.append("+ " ).append("\n"); 
		query.append("NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,0, SOD.BAL_LOCL_AMT),0)    " ).append("\n"); 
		query.append("                                                                       TTL_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_AMT,0)                            USD_AMT         " ).append("\n"); 
		query.append(",DECODE(SOD.BL_CURR_CD,'USD',LOCL_XCH_RT,0)  ASA_XCH_RT1" ).append("\n"); 
		query.append(",NVL(DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_LOCL_AMT,0),0)  " ).append("\n"); 
		query.append("                                                                       EQV_LOCL_AMT" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(",SOH.OFC_CURR_CD                                                       ASA_CURR_CD " ).append("\n"); 
		query.append(",NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,SOD.BAL_AMT),0)     LOCL_AMT        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",1    " ).append("\n"); 
		query.append("                                                                       ASA_XCH_RT2" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append(", NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,SOD.BAL_AMT),0)      " ).append("\n"); 
		query.append("                                                                      CHG_USD_AMT          " ).append("\n"); 
		query.append(",''                                         ASA_RMK " ).append("\n"); 
		query.append(",SOH.OTS_OFC_CD                             AGN_CD" ).append("\n"); 
		query.append(",SOH.SVC_SCP_CD                             SVC_SCP_CD " ).append("\n"); 
		query.append(",SOH.SAIL_ARR_DT                            EFF_DT" ).append("\n"); 
		query.append(",SOH.BKG_IO_BND_CD                          IB_OB_CD " ).append("\n"); 
		query.append(",SUBSTR(REPLACE(@[gl_yrmon_to],'-',''),1,6) GL_YRMON " ).append("\n"); 
		query.append(",SOH.OFC_CURR_CD                            LOCL_CURR_CD" ).append("\n"); 
		query.append(",SOH.SAIL_ARR_DT                            SAIL_ARR_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(SOD.BL_CURR_CD,'USD','',SOH.OFC_CURR_CD,'', SOD.BL_CURR_CD)     N3RD_CURR_CD   " ).append("\n"); 
		query.append(",DECODE(SOD.BL_CURR_CD,'USD','',SOH.OFC_CURR_CD,'', SOD.BAL_AMT)        N3RD_AMT" ).append("\n"); 
		query.append(",DECODE(SOD.BL_CURR_CD,'USD','',SOH.OFC_CURR_CD,'', SOD.LOCL_XCH_RT)    N3RD_XCH_RT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",DECODE(SOD.BL_CURR_CD,'USD','',SOH.OFC_CURR_CD,'', SOD.BAL_LOCL_AMT)" ).append("\n"); 
		query.append("       																     N3RD_LOCL_AMT" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append(",ROW_NUMBER () OVER (PARTITION BY SOH.BL_NO, SOH.INV_NO, SOD.CHG_TP_CD ORDER BY SOH.BL_NO, SOH.INV_NO,DECODE(SOD.BL_CURR_CD,'USD','ZZZ',SOH.OFC_CURR_CD,'ZZZ', SOD.BL_CURR_CD))             RN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR SOH, " ).append("\n"); 
		query.append("     SAR_OTS_DTL SOD," ).append("\n"); 
		query.append("     MDM_CUSTOMER MC, " ).append("\n"); 
		query.append("     MDM_CR_CUST MCC," ).append("\n"); 
		query.append("     MDM_ORGANIZATION MO ," ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("     ( SELECT SOH.RHQ_CD, SOH.OTS_OFC_CD, SOH.BL_NO  , SOH.INV_NO, SOD.CHG_TP_CD" ).append("\n"); 
		query.append("           ,SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,SOD.BAL_AMT),0))   LOCL_AMT" ).append("\n"); 
		query.append("           ,SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_LOCL_AMT,0) ,0)  )   EQV_LOCL_AMT " ).append("\n"); 
		query.append("           ,SUM(NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,0, SOD.BAL_LOCL_AMT),0))  EQV_LOCL_AMT2" ).append("\n"); 
		query.append("           ,SUM(" ).append("\n"); 
		query.append("                 NVL(DECODE(SOD.BL_CURR_CD,'USD',SOD.BAL_LOCL_AMT,0),0) " ).append("\n"); 
		query.append("                   + " ).append("\n"); 
		query.append("                 NVL(DECODE(SOD.BL_CURR_CD, 'USD',0,SOH.OFC_CURR_CD,SOD.BAL_LOCL_AMT),0)     " ).append("\n"); 
		query.append("                   + " ).append("\n"); 
		query.append("                 NVL(DECODE(SOD.BL_CURR_CD,'USD',0,SOH.OFC_CURR_CD,0, SOD.BAL_LOCL_AMT),0)" ).append("\n"); 
		query.append("              )                     TTL_AMT" ).append("\n"); 
		query.append("        FROM SAR_OTS_HDR SOH, " ).append("\n"); 
		query.append("             SAR_OTS_DTL SOD," ).append("\n"); 
		query.append("             MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("            AND SOH.RHQ_CD              = SOD.RHQ_CD" ).append("\n"); 
		query.append("            AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("            AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("            AND SOH.INV_NO              = SOD.INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND SOH.OTS_OFC_CD          = @[ar_ofc_cd]" ).append("\n"); 
		query.append("            AND SOH.BL_NO               = NVL(@[bl_no],SOH.BL_NO)" ).append("\n"); 
		query.append("            AND SOH.OTS_OFC_CD          = MO.OFC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND EXISTS ( SELECT 'A' FROM SAR_OTS_HIS SOS WHERE 1=1 " ).append("\n"); 
		query.append("                                     AND SOH.RHQ_CD              = SOS.RHQ_CD" ).append("\n"); 
		query.append("                                     AND SOH.OTS_OFC_CD          = SOS.OTS_OFC_CD" ).append("\n"); 
		query.append("                                     AND SOH.BL_NO               = SOS.BL_NO " ).append("\n"); 
		query.append("                                     AND SOH.INV_NO              = SOS.INV_NO" ).append("\n"); 
		query.append("                                     AND SOS.OTS_HIS_TP_CD       = 'OTS'" ).append("\n"); 
		query.append("                                     AND SUBSTR(SOS.GL_DT,1,6)  <= SUBSTR(REPLACE(@[gl_yrmon_to],'-',''),1,6) )" ).append("\n"); 
		query.append("      GROUP BY SOH.RHQ_CD, SOH.OTS_OFC_CD, SOH.BL_NO,SOH.INV_NO, SOD.CHG_TP_CD" ).append("\n"); 
		query.append("       ) TP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SOH.RHQ_CD              = SOD.RHQ_CD            " ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("AND SOH.INV_NO              = SOD.INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SOH.BIL_TO_CUST_CNT_CD  = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND SOH.BIL_TO_CUST_SEQ     = MC.CUST_SEQ  " ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD          = MCC.CUST_CNT_CD  (+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ             = MCC.CUST_SEQ  (+)" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = @[ar_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SOH.BL_NO               = NVL(@[bl_no],SOH.BL_NO)" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = MO.OFC_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SOH.RHQ_CD              = TP.RHQ_CD" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = TP.OTS_OFC_CD" ).append("\n"); 
		query.append("AND SOH.BL_NO               = TP.BL_NO " ).append("\n"); 
		query.append("AND SOH.INV_NO               = TP.INV_NO" ).append("\n"); 
		query.append("AND SOD.CHG_TP_CD           = TP.CHG_TP_CD " ).append("\n"); 
		query.append("AND ( ( NVL(TP.LOCL_AMT, 0) <> 0)    OR   ( NVL(TP.EQV_LOCL_AMT, 0) <> 0)  OR     ( NVL(TP.EQV_LOCL_AMT2, 0) <> 0) )" ).append("\n"); 
		query.append("AND SOH.REV_TP_SRC_CD != 'ASA'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${option2} == 'V' )       " ).append("\n"); 
		query.append("    #if ( ${bnd} != 'ALL'  ) " ).append("\n"); 
		query.append("       AND SOH.BKG_IO_BND_CD  =  @[bnd] " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if ( ${vvd_cd} != '' )" ).append("\n"); 
		query.append("       AND SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if ( ${svc_scp_cd} != '' )" ).append("\n"); 
		query.append("      AND SOH.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if ( ${port_cd} != '' )" ).append("\n"); 
		query.append("      AND DECODE(SOH.BKG_IO_BND_CD, 'O', SOH.POL_CD, 'I', SOH.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("    #end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#elseif ( ${option2} == 'D' )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if ( ${due_dt_fm} != '' )" ).append("\n"); 
		query.append("         AND SOH.DUE_DT >=  REPLACE(@[due_dt_fm],'-','')       " ).append("\n"); 
		query.append("    #end                   " ).append("\n"); 
		query.append("    #if ( ${due_dt_to} != '' )" ).append("\n"); 
		query.append("         AND SOH.DUE_DT <=  REPLACE(@[due_dt_to],'-','')       " ).append("\n"); 
		query.append("    #end                           " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY  " ).append("\n"); 
		query.append(" ASA_NO         ,BL_NO      ,INV_NO   ,CHG_TP_CD      ,ASA_CLT_SEQ     ,AR_OFC_CD" ).append("\n"); 
		query.append(",VVD_CD         ,PORT_CD    ,ASA_CURR_CD" ).append("\n"); 
		query.append(",ASA_XCH_RT2    ,ASA_RMK    ,AGN_CD         ,SVC_SCP_CD      ,EFF_DT" ).append("\n"); 
		query.append(",IB_OB_CD          ,LOCL_CURR_CD   ,SAIL_ARR_DT     ,DUE_DT" ).append("\n"); 
		query.append("#if (${option1} == 'C' )" ).append("\n"); 
		query.append("	HAVING SUM(TTL_AMT) >= 0 " ).append("\n"); 
		query.append("#elseif (${option1} == 'R' )" ).append("\n"); 
		query.append("    HAVING SUM(TTL_AMT) < 0 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ASA_NO         ,BL_NO      ,INV_NO   ,CHG_TP_CD" ).append("\n"); 

	}
}