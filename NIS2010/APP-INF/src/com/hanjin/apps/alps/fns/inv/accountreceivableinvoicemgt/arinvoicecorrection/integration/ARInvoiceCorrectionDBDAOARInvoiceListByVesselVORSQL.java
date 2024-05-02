/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOARInvoiceListByVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOARInvoiceListByVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOARInvoiceListByVesselVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOARInvoiceListByVesselVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	A.BL_SRC_NO" ).append("\n"); 
		query.append("	,A.BKG_NO" ).append("\n"); 
		query.append("	,A.BKG_OFC_CD" ).append("\n"); 
		query.append("	,A.REV_TP_CD" ).append("\n"); 
		query.append("	,A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("	,A.POL_CD" ).append("\n"); 
		query.append("	,A.POD_CD" ).append("\n"); 
		query.append("	,A.AR_IF_NO" ).append("\n"); 
		query.append("	,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("	,A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("	,A.SAIL_ARR_DT" ).append("\n"); 
		query.append("	,A.UPD_USR_ID" ).append("\n"); 
		query.append("	,ROUND(SUM(A.CHG_AMT),A.DP_PRCS_KNT) CHG_AMT" ).append("\n"); 
		query.append("	,A.DP_PRCS_KNT" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT    A.BL_SRC_NO" ).append("\n"); 
		query.append("		,A.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("		,A.SLS_OFC_CD AS BKG_OFC_CD" ).append("\n"); 
		query.append("		,A.REV_TP_CD||A.REV_SRC_CD AS REV_TP_CD" ).append("\n"); 
		query.append("		,A.ACT_CUST_CNT_CD||'-'||LPAD(A.ACT_CUST_SEQ,6,'0') AS ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		,A.POL_CD" ).append("\n"); 
		query.append("		,A.POD_CD" ).append("\n"); 
		query.append("		,A.AR_IF_NO" ).append("\n"); 
		query.append("		,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("		,A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("		,A.SAIL_ARR_DT" ).append("\n"); 
		query.append("		,A.UPD_USR_ID" ).append("\n"); 
		query.append("		,C.CHG_AMT*INV_XCH_RT CHG_AMT" ).append("\n"); 
		query.append("        ,F.DP_PRCS_KNT" ).append("\n"); 
		query.append("		FROM    INV_AR_MN A," ).append("\n"); 
		query.append("				INV_AR_CHG C," ).append("\n"); 
		query.append("				MDM_CURRENCY F" ).append("\n"); 
		query.append("		WHERE   A.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("		AND     C.CURR_CD = F.CURR_CD" ).append("\n"); 
		query.append("		AND		A.INV_ISS_FLG ='N'" ).append("\n"); 
		query.append("		AND		A.INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("		AND		A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("		AND     A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("		AND     A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("		#if (${pol_cd} != '')" ).append("\n"); 
		query.append("		AND		A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pod_cd} != '')" ).append("\n"); 
		query.append("		AND		A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${ofc2} != '' && ${ofc2} != 'ALL')" ).append("\n"); 
		query.append("		AND		A.AR_OFC_CD = @[ofc2]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${svc_scp_cd} != '' && ${svc_scp_cd} != 'ALL')" ).append("\n"); 
		query.append("		AND		A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${io_bnd_cd} != '' && ${io_bnd_cd} != 'A')" ).append("\n"); 
		query.append("		AND		A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND		A.SLS_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${rev_tp_cd} != '')" ).append("\n"); 
		query.append("		AND		A.REV_TP_CD = @[rev_tp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${slan_cd} != '')" ).append("\n"); 
		query.append("		AND		A.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.BL_SRC_NO" ).append("\n"); 
		query.append("		,A.BKG_NO" ).append("\n"); 
		query.append("		,A.BKG_OFC_CD" ).append("\n"); 
		query.append("		,A.REV_TP_CD" ).append("\n"); 
		query.append("		,A.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("		,A.POL_CD" ).append("\n"); 
		query.append("		,A.POD_CD" ).append("\n"); 
		query.append("		,A.AR_IF_NO" ).append("\n"); 
		query.append("		,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("		,A.INV_TTL_LOCL_AMT" ).append("\n"); 
		query.append("		,A.SAIL_ARR_DT" ).append("\n"); 
		query.append("		,A.UPD_USR_ID" ).append("\n"); 
		query.append("		,A.DP_PRCS_KNT" ).append("\n"); 

	}
}