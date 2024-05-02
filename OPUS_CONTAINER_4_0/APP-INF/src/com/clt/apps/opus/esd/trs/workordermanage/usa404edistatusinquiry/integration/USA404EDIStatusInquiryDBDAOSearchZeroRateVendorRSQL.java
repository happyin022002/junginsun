/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOSearchZeroRateVendorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOSearchZeroRateVendorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA404EDIStatusInquiryDBDAOSearchZeroRateVendor
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOSearchZeroRateVendorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOSearchZeroRateVendorRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT X.EQ_NO" ).append("\n"); 
		query.append("               ,Y.VNDR_SEQ" ).append("\n"); 
		query.append("               ,M.VNDR_ABBR_NM" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_BIL_ORD      X" ).append("\n"); 
		query.append("      ,TRS_TRSP_RAIL_BIL_VNDR_SET Y" ).append("\n"); 
		query.append("      ,MDM_VENDOR                 M" ).append("\n"); 
		query.append(" WHERE X.TRSP_SO_OFC_CTY_CD = Y.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND X.TRSP_SO_SEQ = Y.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   and X.RAIL_CMB_THRU_TP_CD NOT IN ('C2T', 'C3T')" ).append("\n"); 
		query.append("   AND X.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND X.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND NVL(BZC_AMT, 0) + NVL(FUEL_SCG_AMT, 0) + NVL(OVR_WGT_SCG_AMT, 0) + NVL(NEGO_AMT, 0) + NVL(HZD_MTRL_SCG_AMT, 0) + NVL(ETC_ADD_AMT, 0) = 0" ).append("\n"); 
		query.append("   AND NVL(X.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND Y.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT X.EQ_NO" ).append("\n"); 
		query.append("               ,Y.VNDR_SEQ" ).append("\n"); 
		query.append("               ,M.VNDR_ABBR_NM" ).append("\n"); 
		query.append("  FROM TRS_TRSP_RAIL_BIL_ORD      X" ).append("\n"); 
		query.append("      ,TRS_TRSP_RAIL_BIL_VNDR_SET Y" ).append("\n"); 
		query.append("      ,MDM_VENDOR                 M" ).append("\n"); 
		query.append(" WHERE X.TRSP_SO_OFC_CTY_CD = Y.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND X.TRSP_SO_SEQ = Y.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND X.RAIL_CMB_THRU_TP_CD IN ('C2T', 'C3T')" ).append("\n"); 
		query.append("   AND Y.SUB_RAIL_SEQ = 1" ).append("\n"); 
		query.append("   AND X.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND X.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND NVL(BZC_AMT, 0) + NVL(FUEL_SCG_AMT, 0) + NVL(OVR_WGT_SCG_AMT, 0) + NVL(NEGO_AMT, 0) + NVL(HZD_MTRL_SCG_AMT, 0) + NVL(ETC_ADD_AMT, 0) = 0" ).append("\n"); 
		query.append("   AND NVL(X.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND Y.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 

	}
}