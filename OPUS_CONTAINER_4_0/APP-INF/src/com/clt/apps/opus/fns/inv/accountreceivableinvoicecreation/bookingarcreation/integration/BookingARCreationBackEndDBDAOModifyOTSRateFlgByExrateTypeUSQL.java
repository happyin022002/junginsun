/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOModifyOTSRateFlgByExrateTypeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
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

public class BookingARCreationBackEndDBDAOModifyOTSRateFlgByExrateTypeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify OTS Rate Flg By Exrate Type
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOModifyOTSRateFlgByExrateTypeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOModifyOTSRateFlgByExrateTypeUSQL").append("\n"); 
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
		query.append("#if (${locl_curr_cd} == 'USD')       " ).append("\n"); 
		query.append("    UPDATE SAR_OTS_HDR A" ).append("\n"); 
		query.append("	    SET OTS_RT_FLG = NVL((SELECT 'N' " ).append("\n"); 
		query.append("       	   				      FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                              WHERE RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("                              AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("                              AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                              AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                              AND (NVL(LOCL_XCH_RT, 0) = 0 OR NVL(USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("                              AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("	#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("		AND BKG_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${xch_rt_tp_cd} == 'V')" ).append("\n"); 
		query.append("		AND DECODE(@[chg_curr_cd], OFC_CURR_CD, XCH_RT_TP_CD, XCH_RT_N3RD_TP_CD) = 'V'                     " ).append("\n"); 
		query.append("    	AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    	AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("    	AND DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    	AND DECODE(@[io_bnd_cd], 'O', POL_CD, 'I', POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("    	AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("	#elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("   		AND DECODE(@[chg_curr_cd], OFC_CURR_CD, XCH_RT_TP_CD, XCH_RT_N3RD_TP_CD) = 'I'" ).append("\n"); 
		query.append("   		AND SHP_TO_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   		AND SHP_TO_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   		AND XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("   	#elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("   		AND DECODE(@[chg_curr_cd], OFC_CURR_CD, XCH_RT_TP_CD, XCH_RT_N3RD_TP_CD) = 'D'" ).append("\n"); 
		query.append("   		AND XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("#elseif (${chg_curr_cd} == 'USD')" ).append("\n"); 
		query.append("    UPDATE SAR_OTS_HDR A" ).append("\n"); 
		query.append("	    SET OTS_RT_FLG = NVL((SELECT 'N' " ).append("\n"); 
		query.append("       	   				      FROM SAR_OTS_DTL" ).append("\n"); 
		query.append("                              WHERE RHQ_CD = A.RHQ_CD" ).append("\n"); 
		query.append("                              AND OTS_OFC_CD = A.OTS_OFC_CD" ).append("\n"); 
		query.append("                              AND BL_NO = A.BL_NO" ).append("\n"); 
		query.append("                              AND INV_NO = A.INV_NO" ).append("\n"); 
		query.append("                              AND (NVL(LOCL_XCH_RT, 0) = 0 OR NVL(USD_XCH_RT, 0) = 0)" ).append("\n"); 
		query.append("                              AND ROWNUM = 1), 'Y')" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("	#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("		AND BKG_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${xch_rt_tp_cd} == 'V')	" ).append("\n"); 
		query.append("		AND DECODE(@[locl_curr_cd], OFC_CURR_CD, XCH_RT_TP_CD, XCH_RT_N3RD_TP_CD) = 'V'                     " ).append("\n"); 
		query.append("    	AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("    	AND SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("    	AND DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    	AND DECODE(@[io_bnd_cd], 'O', POL_CD, 'I', POD_CD) = @[port_cd]" ).append("\n"); 
		query.append("    	AND SVC_SCP_CD =  @[svc_scp_cd]" ).append("\n"); 
		query.append("	#elseif (${xch_rt_tp_cd} == 'I')" ).append("\n"); 
		query.append("   		AND DECODE(@[locl_curr_cd], OFC_CURR_CD, XCH_RT_TP_CD, XCH_RT_N3RD_TP_CD) = 'I'" ).append("\n"); 
		query.append("   		AND SHP_TO_CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   		AND SHP_TO_CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("   		AND XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("   	#elseif (${xch_rt_tp_cd} == 'D')" ).append("\n"); 
		query.append("   		AND DECODE(@[locl_curr_cd], OFC_CURR_CD, XCH_RT_TP_CD, XCH_RT_N3RD_TP_CD) = 'D'" ).append("\n"); 
		query.append("   		AND XCH_RT_DT between replace(@[fm_dt],'-','') and replace(@[to_dt],'-','')" ).append("\n"); 
		query.append("   	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}