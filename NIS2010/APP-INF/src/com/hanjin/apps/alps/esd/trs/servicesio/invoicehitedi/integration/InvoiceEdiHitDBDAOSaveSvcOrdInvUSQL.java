/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceEdiHitDBDAOSaveSvcOrdInvUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.08.29 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG-IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceEdiHitDBDAOSaveSvcOrdInvUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Order에 Invoice 맵핑
	  * </pre>
	  */
	public InvoiceEdiHitDBDAOSaveSvcOrdInvUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_calc_lgc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_inv_act_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.integration").append("\n"); 
		query.append("FileName : InvoiceEdiHitDBDAOSaveSvcOrdInvUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("   SET A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("      ,A.INV_VNDR_SEQ = @[inv_vndr_seq]" ).append("\n"); 
		query.append("      ,A.INV_CURR_CD = @[inv_curr_cd]" ).append("\n"); 
		query.append("      ,A.TRSP_INV_CALC_LGC_TP_CD = @[trsp_inv_calc_lgc_tp_cd]" ).append("\n"); 
		query.append("      ,A.INV_XCH_RT = TO_NUMBER(@[inv_xch_rt])" ).append("\n"); 
		query.append("      ,A.TRSP_INV_ACT_STS_CD = @[trsp_inv_act_sts_cd]" ).append("\n"); 
		query.append("      ,A.INV_BZC_AMT = CASE WHEN @[inv_curr_cd] IN ('KRW','JPY','TWD') THEN ROUND(((NVL(A.BZC_AMT,0) + NVL(A.NEGO_AMT,0) + NVL(A.FUEL_SCG_AMT,0)+ NVL(A.SCG_VAT_AMT,0) + NVL(A.OVR_WGT_SCG_AMT,0) + NVL(A.ETC_ADD_AMT,0) + NVL(A.TOLL_FEE_AMT,0)) * TO_NUMBER(@[inv_xch_rt])),0)" ).append("\n"); 
		query.append("                            ELSE ROUND(((NVL(A.BZC_AMT,0) + NVL(A.NEGO_AMT,0) + NVL(A.FUEL_SCG_AMT,0) + NVL(A.SCG_VAT_AMT,0) + NVL(A.OVR_WGT_SCG_AMT,0) + NVL(A.ETC_ADD_AMT,0) + NVL(A.TOLL_FEE_AMT,0)) * TO_NUMBER(@[inv_xch_rt])),2)" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("      ,A.INV_ETC_ADD_AMT = 0" ).append("\n"); 
		query.append("      ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID = 'HIT_INV_EDI'" ).append("\n"); 
		query.append(" 	  ,A.LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[inv_vndr_seq]))  " ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND A.INV_NO IS NULL" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}