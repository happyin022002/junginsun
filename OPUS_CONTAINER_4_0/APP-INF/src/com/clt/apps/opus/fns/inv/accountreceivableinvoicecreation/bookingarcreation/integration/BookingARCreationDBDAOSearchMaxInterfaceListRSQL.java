/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchMaxInterfaceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
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

public class BookingARCreationDBDAOSearchMaxInterfaceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOSearchMaxInterfaceListRSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchMaxInterfaceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchMaxInterfaceListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	   MN.AR_OFC_CD," ).append("\n"); 
		query.append("       MN.AR_IF_NO," ).append("\n"); 
		query.append("       MN.VSL_CD||MN.SKD_VOY_NO||MN.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       MN.SVC_SCP_CD," ).append("\n"); 
		query.append("       MN.SLAN_CD," ).append("\n"); 
		query.append("       MN.POL_CD," ).append("\n"); 
		query.append("       MN.POD_CD," ).append("\n"); 
		query.append("       MN.REV_VSL_CD||MN.REV_SKD_VOY_NO||MN.REV_SKD_DIR_CD||MN.REV_DIR_CD REV_VVD_CD," ).append("\n"); 
		query.append("       MN.RLANE_CD," ).append("\n"); 
		query.append("       MN.INV_DELT_DIV_CD," ).append("\n"); 
		query.append("       MN.BL_INV_CFM_DT," ).append("\n"); 
		query.append("       MN.BKG_NO," ).append("\n"); 
		query.append("       SUBSTR(ORG.LOC_CD, 1, 2) LOC_CD," ).append("\n"); 
		query.append("	   MN.IO_BND_CD," ).append("\n"); 
		query.append("       '' CREATE_FLAG," ).append("\n"); 
		query.append("       MN.BKG_TEU_QTY," ).append("\n"); 
		query.append("       MN.BKG_FEU_QTY," ).append("\n"); 
		query.append("       MN.BL_INV_IF_DT," ).append("\n"); 
		query.append("	   MN.OLD_AR_IF_NO," ).append("\n"); 
		query.append("	   MN.CRE_USR_ID," ).append("\n"); 
		query.append("	   MN.LOCL_CURR_CD" ).append("\n"); 
		query.append("  FROM INV_AR_MN MN," ).append("\n"); 
		query.append("       MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append(" WHERE MN.AR_IF_NO  IN (SELECT MAX(AR_IF_NO) " ).append("\n"); 
		query.append("                      FROM INV_AR_MN" ).append("\n"); 
		query.append("                     WHERE BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                       AND NVL(INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("                       AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("                       AND NVL(INV_SPLIT_CD,'N') NOT IN ('S','X','C','E') --2009.12.21 이상희과장 ,2009.12.24 C 다시뺌, 2010.03.05 C다시 넣음, 2010.04.07 C 다시뺌 PUSE52299004" ).append("\n"); 
		query.append("                     GROUP BY AR_OFC_CD,BL_SRC_NO)" ).append("\n"); 
		query.append("   AND MN.AR_OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("   AND NVL(MN.INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("   AND MN.REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("   AND NVL(MN.INV_SPLIT_CD,'N') NOT IN ('S','X','C','E')" ).append("\n"); 

	}
}