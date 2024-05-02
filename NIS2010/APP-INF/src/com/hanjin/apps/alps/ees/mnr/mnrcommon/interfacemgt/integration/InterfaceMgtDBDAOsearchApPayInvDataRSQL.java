/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchApPayInvDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.04.27 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchApPayInvDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InterfaceMgtDBDAOsearchApPayInvDataRSQL
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchApPayInvDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchApPayInvDataRSQL").append("\n"); 
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
		query.append("SELECT '' INV_RGST_NO," ).append("\n"); 
		query.append("DECODE(IW.MNR_GRP_TP_CD, 'TLL', 'TLL', 'MNR') INV_SUB_SYS_CD," ).append("\n"); 
		query.append("IW.ISS_OFC_CD  INV_OFC_CD," ).append("\n"); 
		query.append("DECODE(IW.MNR_GRP_TP_CD, 'TLL', IW.ISS_OFC_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MOH.COST_OFC_CD" ).append("\n"); 
		query.append("FROM   MNR_ORD_DTL MOD, MNR_ORD_HDR MOH" ).append("\n"); 
		query.append("WHERE IW.PAY_INV_SEQ = MOD.PAY_INV_SEQ" ).append("\n"); 
		query.append("AND   MOD.MNR_ORD_OFC_CTY_CD = MOH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   MOD.MNR_ORD_SEQ = MOH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("AND   ROWNUM = 1 )) COST_OFC_CD," ).append("\n"); 
		query.append("IW.MNR_PRNR_SEQ VNDR_SEQ," ).append("\n"); 
		query.append("IW.INV_NO INV_NO," ).append("\n"); 
		query.append("TO_CHAR(IW.ISS_DT, 'yyyymmdd') INV_ISS_DT," ).append("\n"); 
		query.append("TO_CHAR(IW.RCV_DT, 'yyyymmdd') INV_RCV_DT," ).append("\n"); 
		query.append("TO_CHAR(IW.EFF_DT, 'yyyymmdd') INV_EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(NVL(IW.CFM_DT, SYSDATE), 'yyyymmdd') INV_CFM_DT," ).append("\n"); 
		query.append("(SELECT MV.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE IW.MNR_PRNR_SEQ = MV.VNDR_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1) VNDR_TERM_NM," ).append("\n"); 
		query.append("'' GL_DT," ).append("\n"); 
		query.append("IW.TTL_LSS_DIV_CD TTL_LSS_DIV_CD," ).append("\n"); 
		query.append("IW.CURR_CD INV_CURR_CD," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_DECIMAL_FNC(IW.CURR_CD,IW.BZC_AMT) INV_NET_AMT," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_DECIMAL_FNC(IW.CURR_CD,IW.VAT_AMT) INV_VAT_AMT," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_DECIMAL_FNC(IW.CURR_CD,IW.WHLD_TAX_AMT) WHLD_TAX_AMT," ).append("\n"); 
		query.append("MNR_COMMON_PKG.MNR_CONV_DECIMAL_FNC(IW.CURR_CD,IW.TTL_AMT) INV_TTL_AMT," ).append("\n"); 
		query.append("'' EQ_TP_CD," ).append("\n"); 
		query.append("IW.MNR_INV_RMK INV_RMK," ).append("\n"); 
		query.append("'C' INV_STS_CD," ).append("\n"); 
		query.append("'' CSR_NO," ).append("\n"); 
		query.append("'' AP_IF_DT," ).append("\n"); 
		query.append("'' AP_CXL_DT," ).append("\n"); 
		query.append("'' AP_PAY_FLG," ).append("\n"); 
		query.append("'' AP_PAY_DT," ).append("\n"); 
		query.append("'' AP_PAY_AMT," ).append("\n"); 
		query.append("'' ERR_CSR_NO," ).append("\n"); 
		query.append("'N' DELT_FLG" ).append("\n"); 
		query.append("FROM MNR_PAY_INV_WRK IW" ).append("\n"); 
		query.append("WHERE IW.PAY_INV_SEQ = @[pay_inv_seq]" ).append("\n"); 

	}
}