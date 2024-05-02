/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOsearchPortListByTriVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.29 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOsearchPortListByTriVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] ARInvoiceExRateMgtDBDAO::searchPortListByVVD ( searchByVVDVo )
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOsearchPortListByTriVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etda_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOsearchPortListByTriVORSQL").append("\n"); 
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
		query.append("#if (${svr_id} != 'EUR') " ).append("\n"); 
		query.append("SELECT 	DISTINCT(T1.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("		DECODE(T1.IO_BND_CD,'O',T1.POL_CD,T1.POD_CD) VPS_PORT_CD," ).append("\n"); 
		query.append("    	T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD VVD_CD ," ).append("\n"); 
		query.append("    	T1.SVC_SCP_CD SVC_SCP_CD," ).append("\n"); 
		query.append("		DECODE(T1.IO_BND_CD,'O','ETD','ETA') ETDA_CD," ).append("\n"); 
		query.append("    	T1.SAIL_ARR_DT ETDA_DT," ).append("\n"); 
		query.append("    	T3.INV_XCH_RT INV_XCH_RT --2010-01-09 ivs_xch_rt 뺌" ).append("\n"); 
		query.append("FROM INV_AR_MN T1, INV_VVD_XCH_RT T3" ).append("\n"); 
		query.append("WHERE --EXISTS(SELECT AR_IF_NO FROM INV_AR_CHG WHERE AR_IF_NO = T1.AR_IF_NO AND INV_XCH_RT=0)" ).append("\n"); 
		query.append("T1.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND T3.VSL_CD(+) = T1.VSL_CD" ).append("\n"); 
		query.append("AND T3.SKD_VOY_NO(+) = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T3.SKD_DIR_CD(+) = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND DECODE(T1.IO_BND_CD,'O',T1.POL_CD,'I',T1.POD_CD) = T3.PORT_CD(+)" ).append("\n"); 
		query.append("AND T3.LOCL_CURR_CD(+) = @[locl_curr_cd]" ).append("\n"); 
		query.append("AND T3.CHG_CURR_CD(+) = 'USD'" ).append("\n"); 
		query.append("AND T1.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("#if (${vps_port_cd} != 'ALL') " ).append("\n"); 
		query.append("AND DECODE(T1.IO_BND_CD,'O',T1.POL_CD,T1.POD_CD) = @[vps_port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != 'ALL') " ).append("\n"); 
		query.append("AND T1.INV_SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND T1.SAIL_ARR_DT = @[etda_dt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${opt_type} == 'V') " ).append("\n"); 
		query.append("    AND T1.VSL_CD = substr(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO  = substr(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = substr(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND SUBSTR(DECODE(T1.IO_BND_CD,'O',T1.POL_CD,'I',T1.POD_CD),1,2)  <> (SELECT SUBSTR(LOC_CD,1,2) FROM MDM_ORGANIZATION WHERE OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("ORDER BY VVD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${svr_id} == 'EUR') " ).append("\n"); 
		query.append("SELECT DISTINCT(T1.IO_BND_CD) IO_BND_CD,DECODE(T1.IO_BND_CD,'O',T1.POL_CD,T1.POD_CD) VPS_PORT_CD," ).append("\n"); 
		query.append("	   T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD VVD_CD ," ).append("\n"); 
		query.append("	   T1.SVC_SCP_CD,DECODE(T1.IO_BND_CD,'O','ETD','ETA') ETDA_CD," ).append("\n"); 
		query.append("	   T1.SAIL_ARR_DT ETDA_DT," ).append("\n"); 
		query.append("	   T3.INV_XCH_RT INV_XCH_RT, --2010-01-09 ivs_xch_rt 뺌" ).append("\n"); 
		query.append("	   T1.LOCL_CURR_CD" ).append("\n"); 
		query.append("  FROM INV_AR_MN T1, INV_VVD_XCH_RT T3" ).append("\n"); 
		query.append("    WHERE --EXISTS(SELECT AR_IF_NO FROM INV_AR_CHG WHERE AR_IF_NO = T1.AR_IF_NO AND INV_XCH_RT=0)" ).append("\n"); 
		query.append("    T1.AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(" 	AND T1.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("	AND T3.VSL_CD(+) = T1.VSL_CD" ).append("\n"); 
		query.append("	AND T3.SKD_VOY_NO(+) = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("	AND T3.SKD_DIR_CD(+) = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("	AND DECODE(T1.IO_BND_CD,'O',T1.POL_CD,'I',T1.POD_CD) = T3.PORT_CD(+)" ).append("\n"); 
		query.append("	AND T3.LOCL_CURR_CD(+) =  @[locl_curr_cd]" ).append("\n"); 
		query.append("	AND T3.CHG_CURR_CD(+) = 'USD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${vps_port_cd} != 'ALL')  " ).append("\n"); 
		query.append("	AND DECODE(T1.IO_BND_CD,'O',T1.POL_CD,T1.POD_CD) = @[vps_port_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${svc_scp_cd} != 'ALL') " ).append("\n"); 
		query.append("	AND T1.INV_SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	AND T1.SAIL_ARR_DT = @[etda_dt]" ).append("\n"); 
		query.append("	AND DECODE(T1.IO_BND_CD,'O',T1.POL_CD,'I',T1.POD_CD) NOT IN (SELECT LOC_CD FROM MDM_LOCATION  WHERE CONTI_CD = 'E')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${opt_type} == 'V') " ).append("\n"); 
		query.append("    AND T1.VSL_CD = substr(@[vvd_cd],0,4)" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO  = substr(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = substr(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("    AND (T1.VSL_CD,T1.SKD_VOY_NO,T1.SKD_DIR_CD) in (" ).append("\n"); 
		query.append("    SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD FROM INV_AR_MN" ).append("\n"); 
		query.append("    WHERE DECODE(IO_BND_CD,'O',POL_CD,'I',POD_CD) NOT IN (SELECT LOC_CD FROM MDM_LOCATION  WHERE CONTI_CD = 'E')" ).append("\n"); 
		query.append("    GROUP BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD)	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}