/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOSearchARInvExRtForBkgTaxRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationBackEndDBDAOSearchARInvExRtForBkgTaxRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 환율 변경시 Booking에 Tax Exchange Rate 재계산을 위한 대상 List 검색
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOSearchARInvExRtForBkgTaxRtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOSearchARInvExRtForBkgTaxRtRSQL").append("\n"); 
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
		query.append("#if (${chg_curr_cd} == 'USD')" ).append("\n"); 
		query.append("SELECT DISTINCT MN.BKG_NO," ).append("\n"); 
		query.append("       #if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("           'VVD : '||MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD||' BND : '||MN.IO_BND_CD||' OFFICE : '||MN.AR_OFC_CD AS IF_RMK" ).append("\n"); 
		query.append("       #elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("           'CUSTOMER : '||MN.INV_CUST_CNT_CD||MN.INV_CUST_SEQ AS IF_RMK" ).append("\n"); 
		query.append("       #elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("           'OFFICE : '||MN.AR_OFC_CD AS IF_RMK" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       ,@[usr_id] AS UPD_USR_ID " ).append("\n"); 
		query.append("  FROM INV_AR_CHG CHG," ).append("\n"); 
		query.append("       INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE CHG.AR_IF_NO = MN.AR_IF_NO" ).append("\n"); 
		query.append("   AND MN.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT >= TO_CHAR(ADD_MONTHS(SYSDATE,-3),'YYYYMMDD')    " ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL " ).append("\n"); 
		query.append("	#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   		AND MN.IO_BND_CD = @[io_bnd_cd]  " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   #if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("   	AND MN.XCH_RT_USD_TP_CD = 'V'                     " ).append("\n"); 
		query.append("   	AND MN.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   	AND MN.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("   	AND MN.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   	AND DECODE(@[io_bnd_cd],'O',MN.POL_CD,'I',MN.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("   	AND MN.INV_SVC_SCP_CD =  @[svc_scp_cd]		" ).append("\n"); 
		query.append("	AND MN.AR_OFC_CD = @[ar_ofc_cd]			   " ).append("\n"); 
		query.append("   #elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("   	AND MN.XCH_RT_USD_TP_CD = 'I'" ).append("\n"); 
		query.append("   	AND MN.INV_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   	AND MN.INV_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   	AND MN.XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("   #elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("   	AND MN.XCH_RT_USD_TP_CD = 'D'" ).append("\n"); 
		query.append("   	AND MN.XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("	AND MN.AR_OFC_CD = @[ar_ofc_cd]	" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   	AND CHG.CURR_CD = @[chg_curr_cd]" ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("			(OFC.OTS_SMRY_CD<>'BL' AND " ).append("\n"); 
		query.append("				(CHG.INV_ISS_FLG = 'N' OR " ).append("\n"); 
		query.append("				 	CHG.INV_CLR_FLG = 'Y' OR" ).append("\n"); 
		query.append("					NVL(CHG.INV_XCH_RT, 0) = 0" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("			OR OFC.OTS_SMRY_CD='BL'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X' FROM BKG_CHG_RT T WHERE T.BKG_NO = MN.BKG_NO AND NVL(T.TAX_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DISTINCT MN.BKG_NO," ).append("\n"); 
		query.append("       #if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("           'VVD : '||MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD||' BND : '||MN.IO_BND_CD||' OFFICE : '||MN.AR_OFC_CD AS IF_RMK" ).append("\n"); 
		query.append("       #elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("           'CUSTOMER : '||MN.INV_CUST_CNT_CD||MN.INV_CUST_SEQ AS IF_RMK" ).append("\n"); 
		query.append("       #elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("           'OFFICE : '||MN.AR_OFC_CD AS IF_RMK" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("       ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("  FROM INV_AR_CHG CHG," ).append("\n"); 
		query.append("       INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_STUP_OFC OFC" ).append("\n"); 
		query.append(" WHERE CHG.AR_IF_NO = MN.AR_IF_NO" ).append("\n"); 
		query.append("   AND MN.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("   AND MN.BL_INV_CFM_DT >= TO_CHAR(ADD_MONTHS(SYSDATE,-3),'YYYYMMDD')  " ).append("\n"); 
		query.append("   AND MN.OTS_PAY_CD IS NULL AND MN.ORG_INV_NO IS NULL  " ).append("\n"); 
		query.append("	#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   		AND MN.IO_BND_CD = @[io_bnd_cd] " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = OFC.AR_OFC_CD" ).append("\n"); 
		query.append("   #if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("	AND MN.XCH_RT_N3RD_TP_CD = 'V'                     " ).append("\n"); 
		query.append("	AND MN.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    AND MN.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND MN.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND DECODE(@[io_bnd_cd],'O',MN.POL_CD,'I',MN.POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("    AND MN.INV_SVC_SCP_CD =  @[svc_scp_cd]	" ).append("\n"); 
		query.append("	AND MN.AR_OFC_CD = @[ar_ofc_cd]				   " ).append("\n"); 
		query.append("   #elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("	AND MN.XCH_RT_N3RD_TP_CD = 'I'" ).append("\n"); 
		query.append("	AND MN.INV_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("	AND MN.INV_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("    AND MN.XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("   #elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("	AND MN.XCH_RT_N3RD_TP_CD = 'D'" ).append("\n"); 
		query.append("    AND MN.SAIL_ARR_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("	AND MN.AR_OFC_CD = @[ar_ofc_cd]	" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND CHG.CURR_CD = @[chg_curr_cd]" ).append("\n"); 
		query.append("   AND (" ).append("\n"); 
		query.append("			(OFC.OTS_SMRY_CD<>'BL' AND " ).append("\n"); 
		query.append("				(CHG.INV_ISS_FLG = 'N' OR " ).append("\n"); 
		query.append("					CHG.INV_CLR_FLG = 'Y' OR" ).append("\n"); 
		query.append("					NVL(CHG.INV_XCH_RT, 0) = 0" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			) " ).append("\n"); 
		query.append("			OR OFC.OTS_SMRY_CD='BL'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 'X' FROM BKG_CHG_RT T WHERE T.BKG_NO = MN.BKG_NO AND NVL(T.TAX_FLG, 'N') = 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}