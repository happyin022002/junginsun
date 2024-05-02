/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivalbeAgentDBDAOAgentCollectionListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.07 
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

public class AccountReceivalbeAgentDBDAOAgentCollectionListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agent Collection Entry
	  * </pre>
	  */
	public AccountReceivalbeAgentDBDAOAgentCollectionListVORSQL(){
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
		params.put("option1",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AccountReceivalbeAgentDBDAOAgentCollectionListVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("@[asa_no1]||@[asa_no2]||@[asa_no3]          ASA_NO           " ).append("\n"); 
		query.append(",SOH.BL_NO                                  BL_NO                        " ).append("\n"); 
		query.append(",SOD.CHG_TP_CD                              CHG_TP_CD " ).append("\n"); 
		query.append(",5                                          ASA_CLT_SEQ" ).append("\n"); 
		query.append(",SOH.OTS_OFC_CD                             AR_OFC_CD      " ).append("\n"); 
		query.append(",SOH.VSL_CD||SOH.SKD_VOY_NO ||SOH.DIR_CD    VVD_CD     " ).append("\n"); 
		query.append(",DECODE(SOH.BKG_IO_BND_CD, 'O', SOH.POL_CD " ).append("\n"); 
		query.append("                         , 'I', SOH.POD_CD) PORT_CD          " ).append("\n"); 
		query.append(",'C'                                        ASA_TP_CD" ).append("\n"); 
		query.append(",''                                         USD_AMT         " ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(SOH.DUE_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                           ,'YYYY-MM-DD')   DUE_DT" ).append("\n"); 
		query.append(",1                                          ASA_XCH_RT1     " ).append("\n"); 
		query.append(",''                                         EQV_LOCL_AMT  	" ).append("\n"); 
		query.append(",''                                         LOCL_AMT        " ).append("\n"); 
		query.append(",''                                         ASA_XCH_RT2     " ).append("\n"); 
		query.append(",''                                         CHG_USD_AMT          " ).append("\n"); 
		query.append(",SOD.BAL_LOCL_AMT                           TTL_AMT" ).append("\n"); 
		query.append(",'TEST'                                     ASA_RMK " ).append("\n"); 
		query.append(",SOH.OTS_OFC_CD                             AGN_CD" ).append("\n"); 
		query.append(",SOH.SVC_SCP_CD                             SVC_SCP_CD " ).append("\n"); 
		query.append(",''                                         EFF_DT" ).append("\n"); 
		query.append(",SOH.BKG_IO_BND_CD                          IB_OB_CD " ).append("\n"); 
		query.append(",@[asa_curr_cd]                             ASA_CURR_CD " ).append("\n"); 
		query.append(",SOS.GL_DT                                  GL_YRMON " ).append("\n"); 
		query.append(",SOD.BL_CURR_CD                             LOCL_CURR_CD" ).append("\n"); 
		query.append(",SOH.SAIL_ARR_DT                            SAIL_ARR_DT" ).append("\n"); 
		query.append(",SOH.CRE_USR_ID	                            CRE_USR_ID " ).append("\n"); 
		query.append(",SOH.CRE_DT                                 CRE_DT" ).append("\n"); 
		query.append(",SOH.UPD_USR_ID                             UPD_USR_ID" ).append("\n"); 
		query.append(",SOH.UPD_DT                                 UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' N3RD_CURR_CD1   ,'' N3RD_AMT1     	,'' N3RD_CURR_CD2   ,'' N3RD_AMT2       ,'' N3RD_CURR_CD3             " ).append("\n"); 
		query.append(",'' N3RD_AMT3       ,'' N3RD_CURR_CD4 	,'' N3RD_AMT4       ,'' N3RD_XCH_RT1    ,'' N3RD_XCH_RT2             " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' N3RD_XCH_RT3    ,'' N3RD_XCH_RT4  	,'' EQV_LOCL_AMT2   ,'' N3RD_LOCL_AMT1  ,'' N3RD_LOCL_AMT2           " ).append("\n"); 
		query.append(",'' N3RD_LOCL_AMT3  ,'' N3RD_LOCL_AMT4	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(",'' OPTION1      ,'' OPTION2        ,'' ASA_NO1      ,'' ASA_NO2      ,'' ASA_NO3" ).append("\n"); 
		query.append(",'' BND          ,'' GL_YRMON_FM	,'' GL_YRMON_TO	 ,'' DUE_DT_FM	  ,'' DUE_DT_TO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SAR_OTS_HDR SOH, " ).append("\n"); 
		query.append("     SAR_OTS_DTL SOD," ).append("\n"); 
		query.append("     SAR_OTS_HIS SOS," ).append("\n"); 
		query.append("     MDM_CUSTOMER MC, " ).append("\n"); 
		query.append("     MDM_CR_CUST MCC" ).append("\n"); 
		query.append("WHERE SOH.RHQ_CD            = SOD.RHQ_CD" ).append("\n"); 
		query.append("AND SOH.RHQ_CD              = SOS.RHQ_CD" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = SOD.OTS_OFC_CD" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = SOS.OTS_OFC_CD" ).append("\n"); 
		query.append("AND SOH.BL_NO               = SOD.BL_NO " ).append("\n"); 
		query.append("AND SOH.BL_NO               = SOS.BL_NO " ).append("\n"); 
		query.append("AND SOH.INV_NO              = SOD.INV_NO" ).append("\n"); 
		query.append("AND SOH.INV_NO              = SOS.INV_NO" ).append("\n"); 
		query.append("AND SOD.BL_CURR_CD          = SOS.CURR_CD" ).append("\n"); 
		query.append("AND SOH.BIL_TO_CUST_CNT_CD  = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND SOH.BIL_TO_CUST_SEQ     = MC.CUST_SEQ  " ).append("\n"); 
		query.append("AND MC.CUST_CNT_CD          = MCC.CUST_CNT_CD  (+)" ).append("\n"); 
		query.append("AND MC.CUST_SEQ             = MCC.CUST_SEQ  (+)" ).append("\n"); 
		query.append("AND SOH.OTS_OFC_CD          = NVL(@[ar_ofc_cd],SOH.OTS_OFC_CD)" ).append("\n"); 
		query.append("AND SOS.GL_DT              <= NVL(SUBSTR(REPLACE(@[gl_yrmon_to],'-',''),1,6),SOS.GL_DT)" ).append("\n"); 
		query.append("AND 'C'                     = NVL(@[option1],'C')" ).append("\n"); 
		query.append("AND SOH.BL_NO               = NVL(@[bl_no],SOH.BL_NO)" ).append("\n"); 
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

	}
}