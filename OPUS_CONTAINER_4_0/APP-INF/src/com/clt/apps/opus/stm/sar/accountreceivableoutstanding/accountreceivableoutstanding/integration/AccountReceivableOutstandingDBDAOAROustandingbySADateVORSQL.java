/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOAROustandingbySADateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOAROustandingbySADateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Outstanding inquiry search
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOAROustandingbySADateVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kind3_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("overdue_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kind2_radio",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("overdue_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sail_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rate_yn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("credit_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_arr_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOAROustandingbySADateVORSQL").append("\n"); 
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
		query.append("#if ( ${summary_yn} == 'S')" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("       SOH.RHQ_CD       		RHQ_CD,  " ).append("\n"); 
		query.append("       SOH.OTS_OFC_CD   		OTS_OFC_CD, " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${kind_3} == 'CUSTOMER')" ).append("\n"); 
		query.append("       SOH.BIL_TO_CUST_CNT_CD||LPAD(SOH.BIL_TO_CUST_SEQ,6, '0') CUST_CD," ).append("\n"); 
		query.append("       MC.CUST_LGL_ENG_NM   	CUST_NM," ).append("\n"); 
		query.append("       MCC.CR_CURR_CD       	CREDIT_CURR_CD,           " ).append("\n"); 
		query.append("       MCC.CR_AMT   	        CREDIT_LIMIT," ).append("\n"); 
		query.append("       MCC.OB_CR_TERM_DYS   	OB_TERM,  " ).append("\n"); 
		query.append("       MCC.IB_CR_TERM_DYS   	IB_TERM," ).append("\n"); 
		query.append("       MCC.CR_FLG   	        CREDIT_FLG, " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'VVD')" ).append("\n"); 
		query.append("		SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD 		VVD ,	" ).append("\n"); 
		query.append("    #elseif ( ${kind_3} == 'SALESREP')" ).append("\n"); 
		query.append("		SOH.CUST_SREP_CD								SALE_REP_CD," ).append("\n"); 
		query.append("    #elseif ( ${kind_3} == 'SA_DATE')" ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(SOH.SAIL_ARR_DT,'YYYY-MM-DD'),'YYYY-MM-DD')      SAIL_ARR_DT," ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'HJSREF')" ).append("\n"); 
		query.append("		SOH.BKG_REF_NO       							REF_NO," ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'APAR_OFFSET')" ).append("\n"); 
		query.append("		SOH.AP_AR_OFFST_NO   							AP_AR_OFFST_NO, " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SUM(DECODE (SOD.BL_CURR_CD, 'USD', 1, 0*NULL) * NVL (SOD.BAL_AMT, 0) USD," ).append("\n"); 
		query.append("       --''                       EX_RATE, " ).append("\n"); 
		query.append("       SUM(DECODE (SOD.BL_CURR_CD, 'USD', 1, 0*NULL) * NVL (SOD.BAL_LOCL_AMT, 0) USD_EQV_LCL,         " ).append("\n"); 
		query.append("       SUM(SOD.BAL_LOCL_AMT ) 	TOT_LCL," ).append("\n"); 
		query.append("       SUM(SOD.BAL_USD_AMT  )	TOT_USD," ).append("\n"); 
		query.append("       SUM(SOD.BAL_AMT) BAL_AMT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SOH.RHQ_CD       										RHQ_CD,  " ).append("\n"); 
		query.append("       SOH.OTS_OFC_CD   										OTS_OFC_CD, " ).append("\n"); 
		query.append("       SOH.BL_NO        										BL_NO," ).append("\n"); 
		query.append("       SOH.BKG_NO      	 										BKG_NO," ).append("\n"); 
		query.append("       SOH.INV_NO       										INV_NO,  " ).append("\n"); 
		query.append("       SOD.CHG_TP_CD       										CHG_TP_CD,  " ).append("\n"); 
		query.append("       SOH.BIL_TO_CUST_CNT_CD||LPAD(SOH.BIL_TO_CUST_SEQ,6, '0') CUST_CD," ).append("\n"); 
		query.append("       MC.CUST_LGL_ENG_NM   									CUST_NM," ).append("\n"); 
		query.append("       MCC.CR_CURR_CD       									CREDIT_CURR_CD,           " ).append("\n"); 
		query.append("       MCC.CR_AMT           									CREDIT_LIMIT," ).append("\n"); 
		query.append("       MCC.OB_CR_TERM_DYS   									OB_TERM,  " ).append("\n"); 
		query.append("       MCC.IB_CR_TERM_DYS   									IB_TERM," ).append("\n"); 
		query.append("       MCC.CR_FLG           									CREDIT_FLG, " ).append("\n"); 
		query.append("       SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD 					VVD , " ).append("\n"); 
		query.append("       SOH.LANE_CD          									LANE_CD, " ).append("\n"); 
		query.append("       SOH.BKG_IO_BND_CD    									BND, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(SOH.SAIL_ARR_DT,'YYYY-MM-DD'),'YYYY-MM-DD')      SAIL_ARR_DT, " ).append("\n"); 
		query.append("       SOH.POR_CD           									POR_CD, " ).append("\n"); 
		query.append("       SOH.POL_CD           									POL_CD, " ).append("\n"); 
		query.append("       SOH.POD_CD           									POD_CD, " ).append("\n"); 
		query.append("       SOH.DEL_CD           									DEL_CD, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(SOH.INV_DT,'YYYY-MM-DD'),'YYYY-MM-DD')   INV_DT, " ).append("\n"); 
		query.append("       SOH.SVC_SCP_CD       									SVC_SCP_CD, " ).append("\n"); 
		query.append("       SOH.CUST_SREP_CD     									SALE_REP_CD," ).append("\n"); 
		query.append("       SOH.BKG_REF_NO       									REF_NO, " ).append("\n"); 
		query.append("       TO_CHAR(TO_DATE(SOH.DUE_DT,'YYYY-MM-DD'),'YYYY-MM-DD')   DUE_DT, " ).append("\n"); 
		query.append("       TO_DATE(replace(@[sail_arr_dt],'-',''), 'YYYYMMDD') - TO_DATE(SOH.DUE_DT,'YYYYMMDD') AS OVER_DUE," ).append("\n"); 
		query.append("       SOH.OTS_GRP_TP_CD    									OTS_GRP_TP_CD, " ).append("\n"); 
		query.append("       SOH.OTS_TP_CD        									OTS_TP_CD, " ).append("\n"); 
		query.append("       SOH.SC_NO            									SC_NO, " ).append("\n"); 
		query.append("       SOH.OTS_RMK          									RMK, " ).append("\n"); 
		query.append("       SOH.OTS_SRC_CD       									KIND2," ).append("\n"); 
		query.append("       SOH.AP_AR_OFFST_NO   									AP_AR_OFFST_NO, " ).append("\n"); 
		query.append("       DECODE (SOD.BL_CURR_CD, 'USD', 1, 0*NULL) * NVL (SOD.BAL_AMT, 0) USD," ).append("\n"); 
		query.append("       DECODE (SOD.BL_CURR_CD, 'USD', 1, 0*NULL) * SOD.LOCL_XCH_RT      EX_RATE, " ).append("\n"); 
		query.append("       DECODE (SOD.BL_CURR_CD, 'USD', 1, 0*NULL) * NVL (SOD.BAL_LOCL_AMT, 0) USD_EQV_LCL,         " ).append("\n"); 
		query.append("       SOD.BAL_LOCL_AMT  			TOT_LCL," ).append("\n"); 
		query.append("       SOD.BAL_USD_AMT   				TOT_USD ," ).append("\n"); 
		query.append("       SOD.BAL_AMT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("FROM SAR_OTS_HDR SOH, " ).append("\n"); 
		query.append("     SAR_OTS_DTL SOD, " ).append("\n"); 
		query.append("     MDM_CUSTOMER MC, " ).append("\n"); 
		query.append("     MDM_CR_CUST MCC" ).append("\n"); 
		query.append("WHERE SOH.RHQ_CD            = SOD.RHQ_CD  " ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("AND SOH.INV_NO              = SOD.INV_NO  " ).append("\n"); 
		query.append("AND SOH.BIL_TO_CUST_CNT_CD  = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND SOH.BIL_TO_CUST_SEQ     = MC.CUST_SEQ  " ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD          = MCC.CUST_CNT_CD  (+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ             = MCC.CUST_SEQ  (+)" ).append("\n"); 
		query.append("AND SOH.RHQ_CD              = @[rhq]" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD           = @[ofc_cd]" ).append("\n"); 
		query.append("AND SOH.SAIL_ARR_DT        <= replace(@[sail_arr_dt],'-','')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${kind2_radio} == 'ALL')" ).append("\n"); 
		query.append("  AND NVL(SOH.OTS_SRC_CD, 'NISAR') IN ('NISAR', 'OTHER', 'STM AR', '3RD',  'BMS', 'STM AP', 'JO', 'CDAM')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${kind2_radio} != 'ALL')" ).append("\n"); 
		query.append("  AND SOH.OTS_SRC_CD LIKE @[kind2_radio]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${bnd} != 'ALL')" ).append("\n"); 
		query.append("   AND SOH.BKG_IO_BND_CD = @[bnd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SOH.BKG_IO_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${overdue_from} != '')" ).append("\n"); 
		query.append("	AND    TO_DATE(replace(@[sail_arr_dt],'-',''), 'YYYYMMDD') - TO_DATE(SOH.DUE_DT,'YYYYMMDD')  >= @[overdue_from]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${overdue_to} != '')" ).append("\n"); 
		query.append("	AND    TO_DATE(replace(@[sail_arr_dt],'-',''), 'YYYYMMDD') - TO_DATE(SOH.DUE_DT,'YYYYMMDD')  <= @[overdue_to]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   AND SOH.SVC_SCP_CD LIKE @[svc_scp_cd]||'%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${port} != '')" ).append("\n"); 
		query.append("    #if ( ${bnd} == 'I')" ).append("\n"); 
		query.append("        AND SOH.POD_CD LIKE @[port]||'%'" ).append("\n"); 
		query.append("    #elseif ( ${bnd} == 'O')" ).append("\n"); 
		query.append("        AND SOH.POL_CD LIKE @[port]||'%'" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND ( SOH.POD_CD LIKE @[port]||'%' OR SOH.POL_CD LIKE @[port]||'%' )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${credit_flg} != 'ALL')" ).append("\n"); 
		query.append("   AND NVL(MCC.CR_FLG,'N') = @[credit_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${rate_yn} != 'ALL')" ).append("\n"); 
		query.append("   AND NVL(SOH.OTS_RT_FLG,'Y') = @[rate_yn]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${bl_inv} == 'B')" ).append("\n"); 
		query.append("   AND SOH.INV_NO	= '**********'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${bl_inv} == 'I')" ).append("\n"); 
		query.append("   AND SOH.INV_NO	<> '**********'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (  ${ots_grp_tp_cd} != '' and ${ots_grp_tp_cd} != 'ALL' )" ).append("\n"); 
		query.append("   AND SOH.OTS_GRP_TP_CD = @[ots_grp_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (  ${ots_tp_cd} != '' and ${ots_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("   AND SOH.OTS_TP_CD = @[ots_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'CUSTOMER')" ).append("\n"); 
		query.append("   #if ( ${kind3_code} != '')" ).append("\n"); 
		query.append("   		AND SOH.BIL_TO_CUST_CNT_CD||LPAD(SOH.BIL_TO_CUST_SEQ,6, '0') = @[kind3_code]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'VVD')" ).append("\n"); 
		query.append("   #if ( ${kind3_code} != '')" ).append("\n"); 
		query.append("   		AND SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD = @[kind3_code]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'SALESREP')" ).append("\n"); 
		query.append("   #if ( ${kind3_code} != '')" ).append("\n"); 
		query.append("   		AND SOH.CUST_SREP_CD = @[kind3_code]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'HJSREF')" ).append("\n"); 
		query.append("   #if ( ${kind3_code} != '')" ).append("\n"); 
		query.append("   		AND SOH.BKG_REF_NO = @[kind3_code]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'APAR_OFFSET')" ).append("\n"); 
		query.append("   #if ( ${kind3_code} != '')" ).append("\n"); 
		query.append("   		AND SOH.AP_AR_OFFST_NO = @[kind3_code]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'SA_DATE')" ).append("\n"); 
		query.append("   #if ( ${sail_arr_dt_fm} != '')" ).append("\n"); 
		query.append("   		AND SOH.SAIL_ARR_DT        >= REPLACE(@[sail_arr_dt_fm],'-','')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if ( ${sail_arr_dt_to} != '')" ).append("\n"); 
		query.append("   		AND SOH.SAIL_ARR_DT        <= REPLACE(@[sail_arr_dt_to],'-','')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${kind_3} == 'SCNO')" ).append("\n"); 
		query.append("   #if ( ${kind3_code} != '')" ).append("\n"); 
		query.append("   		AND SOH.SC_NO LIKE  @[kind3_code]||'%'" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("		AND SOH.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${ots_opy} == 'OTS')" ).append("\n"); 
		query.append("   	AND SOD.BAL_USD_AMT > 0" ).append("\n"); 
		query.append("#elseif ( ${ots_opy} == 'OPY')" ).append("\n"); 
		query.append("   	AND SOD.BAL_USD_AMT < 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${summary_yn} == 'S')" ).append("\n"); 
		query.append("	GROUP BY SOH.RHQ_CD , SOH.OTS_OFC_CD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${kind_3} == 'CUSTOMER')" ).append("\n"); 
		query.append("		SOH.BIL_TO_CUST_CNT_CD||LPAD(SOH.BIL_TO_CUST_SEQ,6, '0') , MC.CUST_LGL_ENG_NM , MCC.CR_CURR_CD , MCC.CR_AMT ,  MCC.OB_CR_TERM_DYS , MCC.IB_CR_TERM_DYS , MCC.CR_FLG    " ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'VVD')" ).append("\n"); 
		query.append("        SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD " ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'SALESREP')" ).append("\n"); 
		query.append("		SOH.CUST_SREP_CD" ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'SA_DATE')" ).append("\n"); 
		query.append("    	TO_CHAR(TO_DATE(SOH.SAIL_ARR_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #elseif ( ${kind_3} == 'HJSREF')" ).append("\n"); 
		query.append("		SOH.BKG_REF_NO" ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'APAR_OFFSET')" ).append("\n"); 
		query.append("		SOH.AP_AR_OFFST_NO" ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'SCNO')" ).append("\n"); 
		query.append("        'x'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	 " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${summary_yn} == 'S')" ).append("\n"); 
		query.append("	ORDER BY SOH.RHQ_CD , SOH.OTS_OFC_CD ," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${kind_3} == 'CUSTOMER')" ).append("\n"); 
		query.append("		SOH.BIL_TO_CUST_CNT_CD||LPAD(SOH.BIL_TO_CUST_SEQ,6, '0') , MC.CUST_LGL_ENG_NM , MCC.CR_CURR_CD , MCC.CR_AMT ,  MCC.OB_CR_TERM_DYS , MCC.IB_CR_TERM_DYS , MCC.CR_FLG    " ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'VVD')" ).append("\n"); 
		query.append("        SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD " ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'SALESREP')" ).append("\n"); 
		query.append("		SOH.CUST_SREP_CD" ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'SA_DATE')" ).append("\n"); 
		query.append("    	TO_CHAR(TO_DATE(SOH.SAIL_ARR_DT,'YYYY-MM-DD'),'YYYY-MM-DD')" ).append("\n"); 
		query.append("    #elseif ( ${kind_3} == 'HJSREF')" ).append("\n"); 
		query.append("		SOH.BKG_REF_NO" ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'APAR_OFFSET')" ).append("\n"); 
		query.append("		SOH.AP_AR_OFFST_NO" ).append("\n"); 
		query.append("	#elseif ( ${kind_3} == 'SCNO')" ).append("\n"); 
		query.append("        'x'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	ORDER BY SOH.RHQ_CD , SOH.OTS_OFC_CD, SOH.BL_NO, SOH.INV_NO " ).append("\n"); 
		query.append("#end		" ).append("\n"); 

	}
}