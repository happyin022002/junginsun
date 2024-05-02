/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationBackEndDBDAOSearchMaxInterfaceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.17 
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

public class BookingARCreationBackEndDBDAOSearchMaxInterfaceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Max Interface No
	  * </pre>
	  */
	public BookingARCreationBackEndDBDAOSearchMaxInterfaceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationBackEndDBDAOSearchMaxInterfaceNoRSQL").append("\n"); 
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
		query.append("SELECT MN.AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_MN MN" ).append("\n"); 
		query.append("WHERE MN.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("AND MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("AND MN.BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(MN.INV_DELT_DIV_CD, 'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(MN.INV_SPLIT_CD, 'N') NOT IN ('S','X')" ).append("\n"); 
		query.append("AND MN.AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("                   FROM INV_AR_MN" ).append("\n"); 
		query.append("                   WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("                   AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("                   -- AND BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("                   AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                   AND NVL(INV_SPLIT_CD, 'N') NOT IN ('S','X')) " ).append("\n"); 
		query.append("#if (${xch_rt_usd_tp_cd} == 'V')" ).append("\n"); 
		query.append("    AND MN.XCH_RT_USD_TP_CD ='V'" ).append("\n"); 
		query.append("    AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_VVD_XCH_RT VVD, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("                   WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("                   AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("                   AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND   VVD.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("                   AND   VVD.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("                   AND   VVD.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(CHG2.INV_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   VVD.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("        OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_VVD_XCH_RT VVD, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("                   WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("                   AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("                   AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND   VVD.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                   AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("                   AND   VVD.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("                   AND   VVD.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(CHG2.USD_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   VVD.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("        OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_VVD_XCH_RT VVD" ).append("\n"); 
		query.append("                   WHERE VVD.VSL_CD     = MN.VSL_CD" ).append("\n"); 
		query.append("                   AND   VVD.SKD_VOY_NO = MN.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND   VVD.SKD_DIR_CD = MN.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND   VVD.IO_BND_CD  = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND   VVD.PORT_CD    = DECODE(MN.IO_BND_CD,'O',MN.POL_CD,MN.POD_CD)" ).append("\n"); 
		query.append("                   AND   VVD.SVC_SCP_CD   = MN.INV_SVC_SCP_CD" ).append("\n"); 
		query.append("                   AND   VVD.AR_OFC_CD  = MN.AR_OFC_CD" ).append("\n"); 
		query.append("                   AND   VVD.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   AND   VVD.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("                   AND   VVD.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(MN.USD_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   VVD.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append("#elseif (${xch_rt_usd_tp_cd} == 'I')                                                " ).append("\n"); 
		query.append("    AND MN.XCH_RT_USD_TP_CD ='I'" ).append("\n"); 
		query.append("    AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("                   WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("                   AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("                   AND   MN.XCH_RT_DT between FM_DT and TO_DT" ).append("\n"); 
		query.append("                   AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("                   AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(CHG2.INV_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("        OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("                   WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("                   AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("                   AND   MN.XCH_RT_DT between FM_DT and TO_DT" ).append("\n"); 
		query.append("                   AND   CUST.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                   AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("                   AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(CHG2.USD_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("        OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT CUST" ).append("\n"); 
		query.append("                   WHERE CUST.CUST_CNT_CD = MN.INV_CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND   CUST.CUST_SEQ     = MN.INV_CUST_SEQ" ).append("\n"); 
		query.append("                   AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND	 XCH_RT_TP_CD = 'I'" ).append("\n"); 
		query.append("                   AND   MN.XCH_RT_DT between FM_DT and TO_DT" ).append("\n"); 
		query.append("                   AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   AND   CUST.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(MN.USD_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append("#elseif (${xch_rt_usd_tp_cd} == 'D')" ).append("\n"); 
		query.append("    AND MN.XCH_RT_USD_TP_CD = 'D'" ).append("\n"); 
		query.append("    AND (EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("                   WHERE CUST.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("                   AND   CUST.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("                   AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND	 XCH_RT_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("                   AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("                   AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> NVL(CHG2.INV_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(CHG2.INV_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("        OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT CUST, INV_AR_CHG CHG2" ).append("\n"); 
		query.append("                   WHERE CUST.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("                   AND   CUST.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("                   AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND	 XCH_RT_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("                   AND   CUST.LOCL_CURR_CD = 'USD'" ).append("\n"); 
		query.append("                   AND   MN.AR_IF_NO = CHG2.AR_IF_NO" ).append("\n"); 
		query.append("                   AND   CUST.CHG_CURR_CD  = CHG2.CURR_CD" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> NVL(CHG2.USD_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(CHG2.USD_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> 0 )" ).append("\n"); 
		query.append("        OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                   FROM INV_CUST_AND_DLY_XCH_RT CUST" ).append("\n"); 
		query.append("                   WHERE CUST.CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("                   AND   CUST.CUST_SEQ  = '0'" ).append("\n"); 
		query.append("                   AND   CUST.IO_BND_CD   = MN.IO_BND_CD" ).append("\n"); 
		query.append("                   AND	 XCH_RT_TP_CD = 'D'" ).append("\n"); 
		query.append("                   AND   MN.XCH_RT_DT BETWEEN FM_DT AND TO_DT" ).append("\n"); 
		query.append("                   AND   CUST.LOCL_CURR_CD = MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("                   AND   CUST.CHG_CURR_CD  = 'USD'" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> NVL(MN.USD_XCH_RT,0)" ).append("\n"); 
		query.append("                   AND   NVL(MN.USD_XCH_RT,0) <> 0" ).append("\n"); 
		query.append("                   AND   CUST.INV_XCH_RT <> 0 ))" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}